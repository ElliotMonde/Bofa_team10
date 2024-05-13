import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;  

public class ClientAdapter extends CSVReader implements AdapterInterface<Client> {

    public boolean convertFlag(String flag) {
        if (flag == "Y") {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> parseString(String line) {
        ArrayList<String> arr = new ArrayList<>();
        String clientId, flag, ratingString, currencies;
        if (line.contains("\"")) {
            String[] nextItem = line.split("\"");
            clientId = (nextItem[0].split(","))[0];
            String[] hold = nextItem[2].split(",");
            flag = hold[1];
            ratingString = hold[2];
            currencies = nextItem[1];
        } else {
            String[] nextItem = line.split(",");
            clientId = nextItem[0];
            currencies = nextItem[1];
            flag = nextItem[2];
            ratingString = nextItem[3];
        }
        arr.add(clientId);
        arr.add(currencies);
        arr.add(flag);
        arr.add(ratingString);
        return arr;
    }

    @Override
    public ArrayList<Client> createList(String filename) {
        ArrayList<Client> clientList = new ArrayList<>();
        Scanner sc = parseCSV(filename);
        sc.nextLine();
        while (sc.hasNext()) {
            String lineString = sc.nextLine();
            ArrayList<String> arr = parseString(lineString);

            ArrayList<String> currenciesArrayList = new ArrayList<>(Arrays.asList(arr.get(1).split(",")));
            Client newClient = new Client(arr.get(0), currenciesArrayList, convertFlag(arr.get(2)), Integer.parseInt(arr.get(3)));
            clientList.add(newClient);
        }
        return clientList;
    }

}