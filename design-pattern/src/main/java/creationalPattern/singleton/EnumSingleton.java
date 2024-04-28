package creationalPattern.singleton;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/28 15:07
 * @Description:
 */
public enum EnumSingleton {
    INSTANCE;

    //  1. 因为枚举无构造方法，同时newInstance方法里也判断了属于枚举类则抛出异常：Cannot reflectively create enum objects
    //  2. 每个枚举类型定义的枚举变量都是唯一的，在序列化的时候仅仅是将枚举对象的 name 属性输出到结果中，
    //  反序列化的时候就会通过 Enum 的 valueOf 方法根据名字去查找对应的枚举对象
    public static EnumSingleton getInstance() {
        return EnumSingleton.INSTANCE;
    }
}
