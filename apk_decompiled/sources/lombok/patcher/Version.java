package lombok.patcher;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/patcher/Version.SCL.lombok */
public class Version {
    private static final String VERSION = "0.46";

    private Version() {
    }

    public static void main(String[] args) {
        System.out.println(VERSION);
    }

    public static String getVersion() {
        return VERSION;
    }
}
