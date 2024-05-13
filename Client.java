import java.util.ArrayList; 

public class Client {
    private String clientId;
    private ArrayList<String> currencies;
    private boolean checkFlag;
    private int rating;
    private ArrayList<Order> orders;

    Client(String clientId, ArrayList<String> currencies, boolean checkFlag, int rating) {
        setClientId(clientId);
        setCurrencies(currencies);
        setCheckFlag(checkFlag);
        setRating(rating);
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
    
}