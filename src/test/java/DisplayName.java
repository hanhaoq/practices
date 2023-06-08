import org.apiguardian.api.API;

import java.lang.annotation.*;

import static org.apiguardian.api.API.Status.STABLE;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@API(status = STABLE, since = "5.0")
public @interface DisplayName {
    String value();

}
