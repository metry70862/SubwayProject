/*
StationInfo 는 역 정보를 저장하기 위해 만든 객체임
subwayID = 몇호선 역인지
stationID = api에서 받아오는 역 코드
String stationName = 역 이름
String LineName = 몇호선인지
station 정보를 담는 ArrayList를 멤버 변수로 가지고 있음
findStation 메소드를 이용하여 역 아이디를 받으면 Station 객체로 반환
역 아이디가 없을 경우 null반환
부역명 있는 경우 역명만 검색해도 부역명 포함으로 변환
 */

import java.util.ArrayList;

public class StationInfo {
    private int Subway_Id;
    private int Station_Id;
    private String Station_Name;
    private String Line_Name;
    public static ArrayList<StationInfo> stationInfos;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        StationInfo stationInfo = (StationInfo) obj;
        return stationInfo.Station_Id == this.Station_Id;
    }

    public static StationInfo findStation(int input_stationid){
        for (StationInfo stationInfo : stationInfos) {
            if (stationInfo.Station_Id == input_stationid) {
                return stationInfo;
            }
        }
        return null;
    }

    public String getStation_Name() {
        return Station_Name;
    }
    public static String getStationFullName(String stationName) {
        for (StationInfo stationInfo : stationInfos) {
            if (stationInfo.Station_Name.contains(stationName)) {
                return stationInfo.Station_Name;
            }
        }
        return stationName;
    }
}
