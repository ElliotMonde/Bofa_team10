import java.util.ArrayList;
import java.util.HashMap; 

public class Client {
    private String clientId;
    private ArrayList<String> currencies;
    private boolean checkFlag;
    private int rating;
    private ArrayList<Order> orders;
    private HashMap<String, Double> positionsHashMap;

    Client(String clientId, ArrayList<String> currencies, boolean checkFlag, int rating) {
        setClientId(clientId);
        setCurrencies(currencies);
        setCheckFlag(checkFlag);
        setRating(rating);
        positionsHashMap = new HashMap<>();
    }

    void setClientId(String clientId) {
        this.clientId = clientId;
    }

    void setCurrencies(ArrayList<String> currencies) {
        this.currencies = currencies;
    }

    void setCheckFlag(boolean checkFlag) {
        this.checkFlag = checkFlag;
    }

    void setRating(int rating) {
        this.rating = rating;
    }

    void addOrder(Order order) {
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<String> getCurrencies() {
        return currencies;
    }

    public String getClientId() {
        return clientId;
    }

    public boolean getCheckFlag() {
        return checkFlag;
    }

    public int getRating() {
        return rating;
    }

    private void setPositions(Order order) {
        String instrumentId = order.getInstrumentId();
        Double quantity = order.getQuantity();
        if (order.getSide().equals("Buy")){
            positionsHashMap.put(instrumentId, positionsHashMap.getOrDefault(instrumentId, 0.0) + quantity);
        } else {
            if (positionsHashMap.get(instrumentId) != null && getCheckFlag()) {
                double positionAmt = positionsHashMap.get(instrumentId);
                if (positionAmt < quantity) {
                    //todo: reject order
                    String rejectionReason = "REJECTION - POSITION CHECK FAILED";
                    order.setRejection(rejectionReason);
                }else{
                    positionsHashMap.put(instrumentId, positionAmt - quantity);
                }

            } else if (!getCheckFlag()) {
                positionsHashMap.put(instrumentId, positionsHashMap.getOrDefault(instrumentId, 0.0) - quantity);
            }
        }
    }
    
}