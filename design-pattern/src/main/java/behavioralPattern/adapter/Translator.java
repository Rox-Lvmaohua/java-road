package behavioralPattern.adapter;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 11:11
 * @Description: 源对象：充当翻译
 */
public class Translator {
    public void translateInZh(String words) {
        if ("hello world!".equals(words)) {
            System.out.println("翻译：你好世界！");
        }
    }

    public void translateInEn(String words) {
        if ("你好世界！".equals(words)) {
            System.out.println("translate: hello world!");
        }
    }
}
