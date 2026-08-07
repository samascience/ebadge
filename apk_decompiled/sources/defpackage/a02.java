package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class a02 {
    private static final String[] a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] b = {"android.permission.CAMERA"};
    private static final String[] c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
    private static final String[] d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    private static final String[] e = {"android.permission.RECORD_AUDIO"};
    private static final String[] f = {"android.permission.READ_PHONE_STATE", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] g = {"android.permission.BODY_SENSORS"};
    private static final String[] h = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] i = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    public static String[] a(String str) {
        str.hashCode();
        switch (str) {
            case "android.permission-group.CONTACTS":
                return c;
            case "android.permission-group.PHONE":
                return f;
            case "android.permission-group.CALENDAR":
                return a;
            case "android.permission-group.CAMERA":
                return b;
            case "android.permission-group.SENSORS":
                return g;
            case "android.permission-group.LOCATION":
                return d;
            case "android.permission-group.STORAGE":
                return i;
            case "android.permission-group.MICROPHONE":
                return e;
            case "android.permission-group.SMS":
                return h;
            default:
                return new String[]{str};
        }
    }
}
