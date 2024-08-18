package annotations;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Entity extends ParentEntity {
    private String name;
    @MyAnnotation
    private String password;
    private String email;
}
