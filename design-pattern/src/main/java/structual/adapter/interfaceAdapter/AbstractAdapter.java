package structual.adapter.interfaceAdapter;

import structual.adapter.Translator;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/29 11:33
 * @Description:
 */
public abstract class AbstractAdapter implements Target2 {
    private Translator translator = new Translator();

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

    @Override
    public void a() {

    }
}
