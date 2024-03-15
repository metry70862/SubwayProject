/*
StationInfo 는 역 정보를 저장하기 위해 만든 객체임
subwayID = 몇호선 역인지
stationID = api에서 받아오는 역 코드
String stationName = 역 이름
String LineName = 몇호선인지
 */

public class StationInfo {
    private int Subway_Id;
    private int Station_Id;
    private String Station_Name;
    private String Line_Name;

    public StationInfo(int subway_Id, int station_Id, String station_Name, String line_Name) {
        this.Subway_Id = subway_Id;
        this.Station_Id = station_Id;
        this.Station_Name = station_Name;
        this.Line_Name = line_Name;
    }

    @Override
    public String toString() {
        return "StationInfo{" +
                "Subway_Id=" + Subway_Id +
                ", Station_Id=" + Station_Id +
                ", Station_Name='" + Station_Name + '\'' +
                ", Line_Name='" + Line_Name + '\'' +
                '}';
    }
}
