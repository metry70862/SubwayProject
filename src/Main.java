import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static ArrayList<StationInfo> stationInfos;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        makeCsvToList();
        StationArrivalInfo arrivalInfo = new StationArrivalInfo(scanner.next());
        arrivalInfo.getArrivalInfo();
    }

    private static void makeCsvToList() {
        String csvFilePath = "stationInfo.csv";
        CSVReader csvReader = new CSVReader();
        List<String[]> stationData = csvReader.readCsv(csvFilePath);
        stationInfos = new ArrayList<>();
        for (String[] row : stationData) {
            StationInfo stationInfo = new StationInfo(Integer.parseInt(row[0]), Integer.parseInt(row[1]), row[2], row[3]);
            stationInfos.add(stationInfo);
        }
    }

}
