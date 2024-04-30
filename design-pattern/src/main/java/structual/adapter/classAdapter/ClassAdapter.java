package structual.adapter.classAdapter;

import structual.adapter.Target;
import structual.adapter.Translator;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 11:16
 * @Description:
 */
public class ClassAdapter extends Translator implements Target {
    @Override
    public void translate(String source, String target, String words) {
        if ("中文".equals(source) && "英文".equals(target)) {
            this.translateInEn(words);
        } else {
            this.translateInZh(words);
        }
    }
}
