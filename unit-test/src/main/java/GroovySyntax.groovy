/**
 * @Author : 吕茂华
 * @Date: 2024/5/16 上午9:48
 * @Description:
 */
class GroovySyntax {
    static void main(String[] args) {
        println "Hello world" /*
            hello world
        */
        println 1   /**
            1
         */
        println greet("lee")
    }

    static String greet(String name) {
        "Hello ${name}"
    }
}
