import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class RealtimeSubwayInfo {
    private String station_Name;
    private int subwayId;
    private int updownLine;

    public RealtimeSubwayInfo(String station_Name) {
        this.station_Name = station_Name;
    }

    public void get() {
        try {
            String station = URLEncoder.encode(this.station_Name, StandardCharsets.UTF_8);
            // URL 설정
            String urlString = "http://swopenAPI.seoul.go.kr/api/subway/5167474e4d646f6d35327376574c58/xml/realtimeStationArrival/0/1/"+station;
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

                // XML 파싱
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(new InputSource(new java.io.StringReader(response.toString())));

                // XML 예쁘게 출력
                javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
                javax.xml.transform.Transformer transformer = tf.newTransformer();
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "no");
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
                transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");

                transformer.transform(new javax.xml.transform.dom.DOMSource(doc),
                        new javax.xml.transform.stream.StreamResult(new java.io.OutputStreamWriter(System.out, StandardCharsets.UTF_8)));
            } else {
                System.out.println("HTTP GET request failed: " + responseCode);
            }
        } catch (IOException | ParserConfigurationException | SAXException | javax.xml.transform.TransformerException e) {
            e.printStackTrace();
        }
    }
}
