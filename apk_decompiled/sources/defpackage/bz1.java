package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class bz1 {
    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("qwen")) {
            return false;
        }
        String strSubstring = lowerCase.substring(4);
        try {
            StringBuilder sb = new StringBuilder();
            for (char c : strSubstring.toCharArray()) {
                if (!Character.isDigit(c)) {
                    break;
                }
                sb.append(c);
            }
            return sb.length() > 0 && Integer.parseInt(sb.toString()) >= 3;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.contains("tts") || lowerCase.contains("omni") || lowerCase.contains("qwen-deep-research")) ? false : true;
    }
}
