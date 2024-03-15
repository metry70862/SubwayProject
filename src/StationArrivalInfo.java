import java.util.ArrayList;

public class StationArrivalInfo {
    private ArrayList<Subway> subwayArrayList;
    private String inputStationName;

    public StationArrivalInfo(String inputStationName) {
        this.inputStationName = inputStationName;
    }

    public void getArrivalInfo(){
        RealtimeSubwayInfo realtimeSubwayInfo = new RealtimeSubwayInfo(this.inputStationName);
        this.subwayArrayList = realtimeSubwayInfo.getSubwayArrayList();
        printArrivalInfo();
    }

    private void printArrivalInfo(){
        for (Subway subway : subwayArrayList) {
            System.out.println(subway.toString());
        }
    }
}
