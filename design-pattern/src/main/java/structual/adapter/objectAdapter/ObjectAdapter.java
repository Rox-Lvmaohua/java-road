package structual.adapter.objectAdapter;

import structual.adapter.Target;
import structual.adapter.Translator;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 11:29
 * @Description:
 */
public class ObjectAdapter implements Target {
    private final Translator translator = new Translator();
    @Override
    public void translate(String source, String target, String words) {
        if("中文".equals(source) && "英文".equals(target)) {
            //汉-->英
            translator.translateInEn(words);
        } else {
            //英-->汉
            translator.translateInZh(words);
        }
    }
}
