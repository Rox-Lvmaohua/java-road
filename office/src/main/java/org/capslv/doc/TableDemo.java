package org.capslv.doc;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.MergeCellRule;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.Rows;
import com.deepoove.poi.data.Tables;
import com.deepoove.poi.data.style.BorderStyle;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TableDemo {

    @SneakyThrows
    public static void main(String[] args) {
        HashMap<Object, Object> table0 = new HashMap<>() {{
            // 一个2行2列的表格
            put("table0", Tables.of(new String[][]{
                    new String[]{"00", "01"},
                    new String[]{"10", "11"}
            }).border(BorderStyle.DEFAULT).create());
        }};
        XWPFTemplate template = XWPFTemplate.compile("office/src/main/resources/table-template.docx");
//        template.render(table0);

        RowRenderData row0 = Rows.of("姓名", "学历").textColor("FFFFFF").bgColor("4472C4").center().create();
        RowRenderData row1 = Rows.of("张三", "研究生").create();
        Map<String, Object> map = new HashMap<>() {
            {
                put("table1", Tables.create(row0, row1));
            }
        };
//        template.render(map);

        RowRenderData header = Rows.of("Word处理", "Excel处理", "PPT处理").bgColor("4472C4").center().create();
        RowRenderData row2 = Rows.create("没有数据", null, null);
        MergeCellRule rule = MergeCellRule.builder().map(MergeCellRule.Grid.of(1, 0), MergeCellRule.Grid.of(1, 2)).build();
        Map<String, Object> map2 = new HashMap<>() {{
            put("table2", Tables.of(header, row2).mergeRule(rule).border(BorderStyle.DEFAULT).create());
        }};

        template.render(map2);


        template.writeAndClose(new FileOutputStream("office/src/test/resources/out_table.docx"));
    }
}
