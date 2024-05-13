import java.util.ArrayList;

public class Main
{
    public static void main(String[] arg)
    {
        String dir = "test-set";
        ArrayList<Client> clientList = (new ClientAdapter()).createList(dir + "/input_clients.csv");
        ArrayList<Order> orderList = (new OrderAdapter()).createList(dir + "/input_orders.csv");
        ArrayList<Instrument> instrumentList = (new InstrumentAdapter()).createList(dir + "/input_instruments.csv");
    }
}