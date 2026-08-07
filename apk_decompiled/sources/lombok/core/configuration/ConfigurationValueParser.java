package lombok.core.configuration;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/core/configuration/ConfigurationValueParser.SCL.lombok */
interface ConfigurationValueParser {
    Object parse(String str);

    String description();

    String exampleValue();
}
