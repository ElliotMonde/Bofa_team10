public class Instrument {
    private String instrumentId;
    private String instrumentCurrency;
    private int lotSize;
    private double currentPrice;

    public Instrument(String instrumentId, String currency, int lotSize) {
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

    public void setInstrumentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public int getLotSize() {
        return lotSize;
    }

    public String getInstrumentCurrency() {
        return instrumentCurrency;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

}