import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  

public class ClientAdapter extends CSVReader implements AdapterInterface<Client>{

    public boolean convertFlag(String flag) {
        if (flag == "Y"){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Client> createList(String filename) {
        ArrayList<Client> clientList = new ArrayList<>();
        Scanner sc = parseCSV(filename);
        while (sc.hasNext()) {
            String[] nextItem = (sc.next()).split(", ");
            ArrayList<String> currenciesArrayList = new ArrayList<>(Arrays.asList(nextItem[1].split(",")));
            Client newClient = new Client(nextItem[0], currenciesArrayList, convertFlag(nextItem[2]),
                    Integer.parseInt(nextItem[3]));
            clientList.add(newClient);
        }
        return clientList;
    }

}