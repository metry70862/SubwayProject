public class Subway {
    private int subwayID;
    private int updownLine;
    private int stationFromId;
    private int stationToId;
    private int stationNum;
    private String orderKey;
    private String subwayType;
    private int subwayETA;
    private int trainNum;
    private String arrivalMsg;
    private int arrivalCode;

    public Subway(int subwayID, int updownLine, int stationFromId, int stationToId, int stationNum, String orderKey, String subwayType, int subwayETA, int trainNum, String arrivalMsg, int arrivalCode) {
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
}
