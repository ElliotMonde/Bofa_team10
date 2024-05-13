import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSV_Manager_Function {
    String directory = "output/";

    public static void main(String[] args) {
        // CSV_Manager_Function csv = new CSV_Manager_Function();
        // csv.generate_report("test10.csv", "Bank,of,America");
        report_creator("First", "Second", "Third"); // Input output data here
    }

    public static void report_creator(String exchange, String client, String instrument) {
        CSV_Manager_Function csv = new CSV_Manager_Function();
        csv.generate_report("output_client_report.csv", "OrderID, RejectionReason\n" + client);
        csv.generate_report("output_exchange_report.csv", "ClientID, InstrumentID, NetPosition\n" + exchange);
        csv.generate_report("output_instrument_report.csv",
                "InstrumentID, OpenPrice, ClosePrice, TotalVolume, VWAP, DayHigh, DayLow\n" + instrument);
    }

    void generate_report(String fileName, String fileData) {
        // create report
        FileWriter fw = get_fw(fileName);
        System.out.println(fw);
        try {
            if (fw != null) {
                fw.write(fileData);
                System.out.println("CSV file created successfully: " + fileName);
            } else {
                System.out.println("Failed to create CSV file.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Error while closing FileWriter.");
                    e.printStackTrace();
                }
            }
        }
    }

    FileWriter get_fw(String fname) {
        try {
            File file = new File(directory + fname);
            file.createNewFile();
            return new FileWriter(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}