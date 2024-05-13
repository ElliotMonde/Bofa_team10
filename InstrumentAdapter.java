import java.util.ArrayList;

public class InstrumentAdapter
  extends CSVReader
  implements AdapterInterface<Instrument> {

  @Override
  public ArrayList<Instrument> createList(String filename) {
    ArrayList<Instrument> instrumentList = new ArrayList<>();
        sc = parseCSV(filename);
        while (sc.hasNext()) {
            String[] nextItem = (sc.next()).split(", ");
            Instrument newInstrument = new Instrument(nextItem[0], nextItem[1], Integer.parseInt(nextItem[1])) ;
            instrumentList.add(newInstrument);
        }
        return instrumentList;
  }
}
