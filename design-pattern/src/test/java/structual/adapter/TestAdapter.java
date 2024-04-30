package structual.adapter;

import structual.adapter.classAdapter.ClassAdapter;
import structual.adapter.interfaceAdapter.InterfaceAdapter;
import structual.adapter.objectAdapter.ObjectAdapter;
import org.junit.jupiter.api.Test;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 11:17
 * @Description:
 */
public class TestAdapter {
    @Test
    public void testClassAdapter() {
        ClassAdapter adapter = new ClassAdapter();
        adapter.translate("中文", "英文", "你好世界！");
        adapter.translate("英文", "中文", "hello world!");
    }

    @Test
    public void testObjectAdapter() {
        ObjectAdapter adapter = new ObjectAdapter();
        adapter.translate("中文", "英文", "你好世界！");
        adapter.translate("英文", "中文", "hello world!");
    }

    //接口适配器
    @Test
    void interfaceAdapter(){
        InterfaceAdapter adapter = new InterfaceAdapter();
        adapter.translate("中文", "英文", "你好世界！");
        adapter.translate("英语","中文","hello world！");
    }
}
