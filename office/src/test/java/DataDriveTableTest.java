import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.capslv.generate.DataDriveTableExpand;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataDriveTableTest {

    String data = "{\n" +
            "    \"project\": [\n" +
            "        {\n" +
            "            \"item\": \"item1\",\n" +
            "            \"name\": \"name1\",\n" +
            "            \"date\": \"2022-01-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item2\",\n" +
            "            \"name\": \"name2\",\n" +
            "            \"date\": \"2022-02-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item3\",\n" +
            "            \"name\": \"name3\",\n" +
            "            \"date\": \"2022-03-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item4\",\n" +
            "            \"name\": \"name4\",\n" +
            "            \"date\": \"2022-04-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item5\",\n" +
            "            \"name\": \"name5\",\n" +
            "            \"date\": \"2022-05-01\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"contract\": [\n" +
            "        {\n" +
            "            \"item\": \"item1\",\n" +
            "            \"name\": \"name1\",\n" +
            "            \"date\": \"2022-01-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item2\",\n" +
            "            \"name\": \"name2\",\n" +
            "            \"date\": \"2022-02-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item3\",\n" +
            "            \"name\": \"name3\",\n" +
            "            \"date\": \"2022-03-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item4\",\n" +
            "            \"name\": \"name4\",\n" +
            "            \"date\": \"2022-04-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"item\": \"item5\",\n" +
            "            \"name\": \"name5\",\n" +
            "            \"date\": \"2022-05-01\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Test
    public void test() {

        // DataDriveTableExpand.dataDriveTableGenerate(table, data);
        try {
            // DataDriveTableExpand.dataDriveTableGenerate(table, data);
            FileInputStream fis = new FileInputStream("src/test/resources/Template-data.docx");
            XWPFDocument doc = new XWPFDocument(fis);
            XWPFTable table = doc.getTables().get(0);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(data);

            DataDriveTableExpand.dataDriveTableGenerate(table, json);

            doc.write(new FileOutputStream("src/test/resources/Template-data-result.docx"));
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
