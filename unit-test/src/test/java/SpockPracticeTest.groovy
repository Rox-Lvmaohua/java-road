import spock.lang.Specification

/**
 * @Author : 吕茂华
 * @Date: 2024/5/16 上午10:11
 * @Description:
 */
class SpockPracticeTest extends Specification{
    def "Test hello"() {
        given:
        def hello = "Hello world"
        when:
            def a = ""
        then:
        hello == "Hello world"
    }
    /**
     * block: given、when、then、expect、cleanup、where
     * 块之间不能相互嵌套
     */
}
