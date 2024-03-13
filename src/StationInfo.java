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
