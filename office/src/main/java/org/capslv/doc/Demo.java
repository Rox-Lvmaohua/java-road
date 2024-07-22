package org.capslv.doc;

import com.deepoove.poi.XWPFTemplate;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) throws IOException {
        XWPFTemplate template = XWPFTemplate.compile("office/src/main/resources/template.docx").render(
                new HashMap<String, Object>() {
                    {
                        put("title", "Poi-tl 模板引擎");
                    }
                }
        );
        template.writeAndClose(Files.newOutputStream(Paths.get("office/src/test/resources/out_template.docx")));
    }
}
