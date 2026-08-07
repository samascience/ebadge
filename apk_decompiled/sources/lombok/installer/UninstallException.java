package lombok.installer;

/* JADX INFO: loaded from: com.legend.smartwatch.electronicbadge.android.apk:lombok/installer/UninstallException.SCL.lombok */
public class UninstallException extends Exception {
    private boolean warning;

    public UninstallException(String message, Throwable cause) {
        super(message, cause);
    }

    public UninstallException(boolean warning, String message, Throwable cause) {
        super(message, cause);
        this.warning = warning;
    }

    public boolean isWarning() {
        return this.warning;
    }
}
