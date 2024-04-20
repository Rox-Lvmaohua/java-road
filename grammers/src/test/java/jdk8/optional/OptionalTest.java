package jdk8.optional;

import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * @Author :
 * @Date: 2024/4/20 21:15
 * @Description:
 */
public class OptionalTest {
    //Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
    //Optional.empty() : 创建一个空的 Optional 实例
    //Optional.ofNullable(T t)：t可以为null
    @Test
    public void testNull() {
        Female female = new Female();
        Optional<Female> girl1 = Optional.of(female);
        female = null;
        Optional<Female> girl2 = Optional.ofNullable(female);
        Optional<Female> girl3 = Optional.empty();
        System.out.println(girl1);
        System.out.println(girl2);
        System.out.println(girl3);
    }

    /**
     * @param male
     * @return
     */
    public String getGirlName(Male male){
        Optional<Male> boyOptional = Optional.ofNullable(male);
        Male male1 = boyOptional.orElse(new Male(new Female("Kerry")));

        Female female = male1.getFemale();

        Optional<Female> girlOptional = Optional.ofNullable(female);
        Female female1 = girlOptional.orElse(new Female("Perry"));

        return female1.getName();
    }

    @Test
    public void test5(){
        Male male =null;
        String girlName = getGirlName(male);
        System.out.println(girlName);

        Male male1 = new Male();
        girlName = getGirlName(male1);
        System.out.println(girlName);

        Male male2 =new Male(new Female("pony"));
        girlName = getGirlName(male2);
        System.out.println(girlName);
    }
}
