import spock.lang.Specification
import spock.lang.Unroll

/**
 * @Author : 吕茂华
 * @Date: 2024/5/14 15:01
 * @Description:
 */
class CalculatorTest extends Specification{
    Calculator calculator = new Calculator();
    def "加法"() {
        given: "init data"
            def a = 1
            def b = 1
        when: "执行方法"
            def res = calculator.add(a, b);
        then: "判断结果"
            res == 2
    }

    def "减法"() {
        expect:
            calculator.sub(5, 1) == 4
    }

    def "乘法"() {
        expect:
            calculator.mul(4, 5) == 20
    }

    def "除法"() {
        expect:
            calculator.div(10d, 2) == 5
    }

    def "given expect练习"() {
        given:
            def a = 1
            def b = 3
            def c = 1
        expect:
            calculator.add(a,b) == 4
    }

    def "expect练习"() {
        expect:
            calculator.add(1, 3) == 4
    }

    def "where代码块练习，多组数据"() {
        expect:
            calculator.add(a, b) == res
        where:
            a | b || res
            1 | 2 || 3
            2 | 3 || 5
            4 | 5 || 9
    }

    @Unroll     // 为每组测试数据命名，方便查看出错的数据
    def "为数据命名"() {
        expect:
            calculator.div(a, b) == res
        where:
        name | a | b || res
        "正数" | 4d | 2d || 2d
        "负数" | -3d | 2d || -1.5
        "错误" | 3d | 1 || 3
    }

    def "整数除法"() {
        when:
            calculator.div(1, 0)
        then:
            def exception = thrown(ArithmeticException)
            exception.message == "/ by zero"
    }

    def "测试字符串"() {
        expect:
            "a" == "a"
    }
}
