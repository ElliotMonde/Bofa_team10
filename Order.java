import java.time.LocalTime;

public class Order {
    private String orderId;
    private LocalTime orderTime;
    private String clientId;
    private String instrumentId;
    private String side;
    private Double orderPrice;
    private Double quantity;

    Order(String orderId, LocalTime time, String clientId, String instrumentId, String side, double price,
            double quantity) {
        setOrderId(orderId);
        setOrderTime(time);
        setClientId(clientId);
        setInstrumentId(instrumentId);
        setSide(side);
        setPrice(price);
        setQuantity(quantity);

    }
    
    private void setOrderId(String orderId){
        this.orderId = orderId;
    }

    private void setOrderTime(LocalTime time){
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

    private void setPrice(double price) {
        this.orderPrice = price;
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
}