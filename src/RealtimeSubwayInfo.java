import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RealtimeSubwayInfo {
    private String station_Name;

    public RealtimeSubwayInfo(String station_Name) {
        this.station_Name = station_Name;
    }

    public void get() {
        try {
            String station = URLEncoder.encode(this.station_Name, StandardCharsets.UTF_8);
            // URL 설정
            String urlString = "http://swopenAPI.seoul.go.kr/api/subway/5167474e4d646f6d35327376574c58/json/realtimeStationArrival/0/1/"+station;
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
                parseJsonData(new JSONObject(response.toString()));

            } else {
                System.out.println("HTTP GET request failed: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void parseJsonData(JSONObject jsonObject){
        JSONArray realtimeArrivalList = jsonObject.getJSONArray("realtimeArrivalList");
        for (int i = 0; i < realtimeArrivalList.length(); i++) {
            JSONObject arrivalInfo = realtimeArrivalList.getJSONObject(i);
            String subwayId = arrivalInfo.getString("subwayId");
            String updownline = arrivalInfo.getString("updnLine");
            System.out.println("SubwayId:"+subwayId);
            System.out.println("Updownline:"+updownline);
        }
    }
}
