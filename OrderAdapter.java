import java.time.LocalTime;
import java.util.ArrayList;

public class OrderAdapter extends CSVReader implements AdapterInterface<Order> {

  @Override
  public ArrayList<Order> createList(String filename) {
    ArrayList<Order> instrumentList = new ArrayList<>();
    sc = parseCSV(filename);
    while (sc.hasNext()) {
      String[] nextItem = (sc.next()).split(", ");
      // in csv: time, orderId, instrumentId, quantity, client, price, side
      // in order: Order(String orderId, LocalTime time, String clientId, String instrumentId, String side, String price, double quantity)
      Order newOrder = new Order(nextItem[1], LocalTime.parse(nextItem[0]), nextItem[4], nextItem[2], nextItem[6], nextItem[5], Double.parseDouble(nextItem[3]))  ;
      instrumentList.add(newOrder);
    }
    return instrumentList;
  }
}
