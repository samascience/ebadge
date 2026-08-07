package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class dk {
    public static String a(String str) {
        String strSubstring = str.substring(0, str.length() - 2);
        String[] strArrSplit = str.split(":");
        int iIntValue = Integer.valueOf(strArrSplit[strArrSplit.length - 1], 16).intValue();
        if (iIntValue == 255) {
            return strSubstring + "00";
        }
        String hexString = Integer.toHexString(iIntValue + 1);
        StringBuilder sb = new StringBuilder();
        sb.append(strSubstring);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        sb.append(hexString);
        return sb.toString();
    }
}
