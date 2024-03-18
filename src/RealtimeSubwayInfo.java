import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RealtimeSubwayInfo {
    private String station_Name;
    private ArrayList<Subway> subwayArrayList; //도착정보 받은 json 데이터를 Subway 객체로 저장

    public RealtimeSubwayInfo(String station_Name) {
        this.station_Name = station_Name;
    }

    private void get() {
        try {
            String station = URLEncoder.encode(this.station_Name, StandardCharsets.UTF_8);
            // URL 설정
            String urlString = "http://swopenAPI.seoul.go.kr/api/subway/5167474e4d646f6d35327376574c58/json/realtimeStationArrival/0/20/"+station;
            URL url = new URL(urlString);

            // HTTP 연결 설정
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 응답 코드 확인
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 응답 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                subwayArrayList = makeSubwayList(new JSONObject(response.toString()));

            } else {
                System.out.println("HTTP GET request failed: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<Subway> makeSubwayList(JSONObject jsonObject){ //어레이리스트에 Subway 저장 및 리턴
        JSONArray realtimeArrivalList = jsonObject.getJSONArray("realtimeArrivalList");
        ArrayList<Subway> subwayArrayList = new ArrayList<>();
        for (int i = 0; i < realtimeArrivalList.length(); i++) {
            JSONObject arrivalInfo = realtimeArrivalList.getJSONObject(i);
            int subwayId = Integer.parseInt(arrivalInfo.getString("subwayId"));
            String updownline = arrivalInfo.getString("updnLine");
            String trainLineNm = arrivalInfo.getString("trainLineNm");
            int stationFromId = arrivalInfo.getInt("statnFid");
            int stationToId = arrivalInfo.getInt("statnTid");
            int stationNum = arrivalInfo.getInt("statnId");
            String orderKey = arrivalInfo.getString("ordkey");
            String  subwayType = arrivalInfo.getString("btrainSttus");
            int subwayETA = arrivalInfo.getInt("barvlDt");
            String trainNum = arrivalInfo.getString("btrainNo");
            String arrivalMsg = arrivalInfo.getString("arvlMsg2");
            int arrivalCode = arrivalInfo.getInt("arvlCd");
            Subway subway = new Subway(subwayId,updownline,trainLineNm,stationFromId,stationToId,stationNum,orderKey,subwayType,subwayETA,trainNum,arrivalMsg,arrivalCode);
            subwayArrayList.add(subway);
        }

        return subwayArrayList;
    }

    public ArrayList<Subway> getSubwayArrayList() {
        get();
        return subwayArrayList; //subwayArrayList getter
    }
}
