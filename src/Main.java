import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //makeCsvToList();
        RealtimeSubwayInfo realtimeSubwayInfo = new RealtimeSubwayInfo("신이문");
        realtimeSubwayInfo.get();
    }

    private static void makeCsvToList() {
        String csvFilePath = "stationInfo.csv";
        CSVReader csvReader = new CSVReader();
        List<String[]> stationData = csvReader.readCsv(csvFilePath);
        ArrayList<StationInfo> stationInfos = new ArrayList<>();
        for (String[] row : stationData) {
            StationInfo stationInfo = new StationInfo(Integer.parseInt(row[0]), Integer.parseInt(row[1]), row[2], row[3]);
            stationInfos.add(stationInfo);
        }
        for(StationInfo s: stationInfos){
            System.out.println(s);
        }
    }


}
