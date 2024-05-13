public class Instrument {
    public String instrumentId;
    public String instrumentCurrency;
    public int lotSize;

    Instrument(String instrumentId, String currency, int lotSize) {
        setInstrumentId(instrumentId);
        setCurrency(currency);
        setLotSize(lotSize);
    }

    private void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    private void setCurrency(String currency) {
        this.instrumentCurrency = currency;
    }

    private void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
}