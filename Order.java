import java.time.LocalTime;

public class Order {
    private String orderId;
    private LocalTime orderTime;
    private String clientId;
    private String instrumentId;
    private String side;
    private Double orderPrice;
    private Double quantity;
    private String rejectionReason;

    Order(String orderId, LocalTime time, String clientId, String instrumentId, String side, String price,
            double quantity) {
        setOrderId(orderId);
        setOrderTime(time);
        setClientId(clientId);
        setInstrumentId(instrumentId);
        setSide(side);
        setPrice(price);
        setQuantity(quantity);
        rejectionReason = "";

    }

    private void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    private void setOrderTime(LocalTime time) {
        this.orderTime = time;
    }

    private void setClientId(String clientId) {
        this.clientId = clientId;
    }

    private void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    private void setSide(String side) {
        this.side = side;
    }

    private void setPrice(String priceString) {
        if (priceString.equals("Market")){
            //TODO: get market price of instrument using instrument id and getCurrentPrice method
        }else{
            this.orderPrice = Double.parseDouble(priceString);
        }
    }

    private void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public String getClientId() {
        return clientId;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public String getSide() {
        return side;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public double getQuantity() {
        return quantity;
    }
    public void setRejection(String rejectionReason){
        this.rejectionReason = rejectionReason;
    }
}