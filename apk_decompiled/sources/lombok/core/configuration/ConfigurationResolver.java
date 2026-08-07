package lombok.core.configuration;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/core/configuration/ConfigurationResolver.SCL.lombok */
public interface ConfigurationResolver {
    <T> T resolve(ConfigurationKey<T> configurationKey);
}
