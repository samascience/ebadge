package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zz1 {
    private static final String[] a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] b = {"android.permission.CAMERA"};
    private static final String[] c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", "android.permission.GET_ACCOUNTS"};
    private static final String[] d = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"};
    private static final String[] e = {"android.permission.RECORD_AUDIO"};
    private static final String[] f = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};
    private static final String[] g = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};
    private static final String[] h = {"android.permission.BODY_SENSORS"};
    private static final String[] i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};
    private static final String[] j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final String[] k = {"android.permission.ACTIVITY_RECOGNITION"};

    public static String[] a(String str) {
        if (str == null) {
            return new String[0];
        }
        switch (str) {
            case "LOCATION":
                return d;
            case "SENSORS":
                return h;
            case "STORAGE":
                return j;
            case "SMS":
                return i;
            case "PHONE":
                return f;
            case "ACTIVITY_RECOGNITION":
                return k;
            case "CONTACTS":
                return c;
            case "CALENDAR":
                return a;
            case "MICROPHONE":
                return e;
            case "CAMERA":
                return b;
            default:
                return new String[]{str};
        }
    }
}
