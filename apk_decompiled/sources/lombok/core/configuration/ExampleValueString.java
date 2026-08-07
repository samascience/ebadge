package lombok.core.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/core/configuration/ExampleValueString.SCL.lombok */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExampleValueString {
    String value();
}
