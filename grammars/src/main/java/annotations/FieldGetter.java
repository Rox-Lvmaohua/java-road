package annotations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class FieldGetter {
    public static void main(String[] args) {
        Class clazz = Entity.class;
        Map<String, Field> fields = getAllFields(clazz);
        fields.forEach((k, v) -> System.out.println(k + " : " + v.getType().getSimpleName()));
    }

    private static Map<String, Field> getAllFields(Class clazz) {
        // write your code here
        Map<String, Field> fields = new HashMap<>();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                fields.put(field.getName(), field);
            }
            clazz = clazz.getSuperclass();
        }
        return fields;
    }


}
