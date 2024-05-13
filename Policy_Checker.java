import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Policy_Checker {
    public static void main(String[] args) {
        
        HashMap<String, Instrument> instruments_hashmap =new HashMap<>();
        instruments_hashmap.put("SIA", new Instrument("SIA", "SGD", 100));

        HashMap<String, Client> clients_hashmap =new HashMap<>();
        clients_hashmap.put("A", new Client("A", new ArrayList<>(Arrays.asList(new String[]{"USD", "SGD"})), true, 1));
        clients_hashmap.put("B", new Client("B", new ArrayList<>(Arrays.asList(new String[]{"USD", "SGD", "JPY"})), false, 2));
        clients_hashmap.put("C", new Client("C", new ArrayList<>(Arrays.asList(new String[]{"SGD"})), true, 3));
        clients_hashmap.put("D", new Client("D", new ArrayList<>(Arrays.asList(new String[]{"USD"})), true, 4));
        clients_hashmap.put("E", new Client("E", new ArrayList<>(Arrays.asList(new String[]{"SGD"})), false, 5));

    }

    public static String checker(HashMap<String, Instrument> instruments_hashmap, HashMap<String, Client> clients_hashmap, Order order) {
        //1. Instrument Policy Check
        if (!instruments_hashmap.containsKey(order.getInstrumentId())) {
           return "REJECTED - INSTRUMENT NOT FOUND";
        }
        
        //2. Currency Check
        //Get order currency
        String currency = instruments_hashmap.get(order.getInstrumentId()).getInstrumentCurrency();
        Client client = clients_hashmap.get(order.getClientId());
        ArrayList<String> available_currency = client.getCurrencies();
        boolean match_currency = false;
        for (String c: available_currency) {
            if(c.equals(currency)) {
                match_currency = true;
                break;
            }
        }
        if (!match_currency) {
            return "REJECTED - MISMATCHED CURRENCY";
        }

        //3. Lot Size Check
        if ( ((order.getQuantity()) % (instruments_hashmap.get(order.getInstrumentId()).getLotSize())) != 0 ) {
            return "REJECTED - INVALID LOT SIZE";
        }

        //4. Position Check
        //if (client.getCheckFlag()) {
            //if (order.getQuantity() > clients_hashmap.get(order.getClientId()). {
                //return "REJECTED - POSITION CHECK FAILED"
            //}
        //}

        return "Accept";
    }
}