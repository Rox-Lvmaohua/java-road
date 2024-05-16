import spock.lang.Specification
import spock.lang.Unroll

/**
 * @Author : 吕茂华
 * @Date: 2024/5/14 下午3:55
 * @Description:
 */
class ComplexCalculatorTest extends Specification {

    @Unroll
    def "stub练习"() {
        given:
        ComplexCalculator calculator = new ComplexCalculator();
        and:
            SwitchService service = Stub(SwitchService)
            service.isOpen() >> isOpen
            calculator.setSwitchService(service)
        expect: "判断执行结果"
            calculator.add(a, b) == res
        where: "准备数据"
        name | a | b | isOpen || res
        "open" | 1 | 2 | true || 6
        "close" | 2 | 1 | false || 3
    }
}