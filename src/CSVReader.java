import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<String[]> readCsv(String csvFile){
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            if (br.ready()) { //BOM 제거 과정
                br.mark(1);
                if (br.read() != 0xFEFF) {
                    br.reset(); // BOM 없음
                }
            }
            String line;
            while((line = br.readLine())!=null){
                String[] row = line.split(",");
                if(row.length==4){
                    data.add(row);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
