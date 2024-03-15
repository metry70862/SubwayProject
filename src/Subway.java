/*
Subway 는 각 지하철 정보를 저장하기 위해 만든 객체임
subwayID = 몇호선 전철인지
updownLine = 상하행
stationFromId = 어떤 역에서 오는지
stationToId = 어떤 역으로 향하는지
stationNum = 어떤 역에 있는지
orderKey = 도착예정열차순번
(상하행코드(1자리), 순번(첫번째, 두번째 열차 , 1자리), 첫번째 도착예정 정류장 - 현재 정류장(3자리), 목적지 정류장, 급행여부(1자리))
subwayType = 열차종류 (급행,ITX,일반,특급)
subwayETA = 열차 도착 잔여 시간(초단위)
trainNum = 열차번호
arrivalMsg = 첫번째도착메세지 (도착, 출발 , 진입 등)
arrivalCode = 도착코드 (0:진입, 1:도착, 2:출발, 3:전역출발, 4:전역진입, 5:전역도착, 99:운행중)
 */
public class Subway {
    private int subwayID;
    private String updownLine;
    private int stationFromId;
    private int stationToId;
    private int stationNum;
    private String orderKey;
    private String subwayType;
    private int subwayETA;
    private int trainNum;
    private String arrivalMsg;
    private int arrivalCode;

    public Subway(int subwayID, String updownLine, int stationFromId, int stationToId, int stationNum, String orderKey, String subwayType, int subwayETA, int trainNum, String arrivalMsg, int arrivalCode) {
        this.subwayID = subwayID;
        this.updownLine = updownLine;
        this.stationFromId = stationFromId;
        this.stationToId = stationToId;
        this.stationNum = stationNum;
        this.orderKey = orderKey;
        this.subwayType = subwayType;
        this.subwayETA = subwayETA;
        this.trainNum = trainNum;
        this.arrivalMsg = arrivalMsg;
        this.arrivalCode = arrivalCode;
    }

    @Override
    public String toString() {
        return "Subway{" +
                "subwayID=" + subwayID +
                ", updownLine='" + updownLine + '\'' +
                ", stationFromId=" + stationFromId +
                ", stationToId=" + stationToId +
                ", stationNum=" + stationNum +
                ", orderKey='" + orderKey + '\'' +
                ", subwayType='" + subwayType + '\'' +
                ", subwayETA=" + subwayETA +
                ", trainNum=" + trainNum +
                ", arrivalMsg='" + arrivalMsg + '\'' +
                ", arrivalCode=" + arrivalCode +
                '}';
    }
}
