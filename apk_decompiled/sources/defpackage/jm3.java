package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class jm3 {
    public static byte[] a(int i, String str) {
        String lowerCase = l63.i(i, 2).toLowerCase();
        String strI = l63.i(str.length() / 2, 1);
        return l63.h("ba16" + (lowerCase.substring(2, 4) + lowerCase.substring(0, 2)) + strI + str);
    }

    private static String b(String str) {
        if (TextUtils.equals(str, "00")) {
            return "执行成功";
        }
        if (TextUtils.equals(str, "01")) {
            return "所需切换的工作模式不支持";
        }
        if (TextUtils.equals(str, "02")) {
            return "所需切换的工作模式异常";
        }
        if (TextUtils.equals(str, "03")) {
            return "不支持的固件类型";
        }
        if (TextUtils.equals(str, "04")) {
            return "PacketIndex不匹配";
        }
        if (TextUtils.equals(str, "05")) {
            return "PacketLength溢出";
        }
        if (TextUtils.equals(str, "06")) {
            return "BuckSize溢出";
        }
        if (TextUtils.equals(str, "07")) {
            return "Flash写入异常";
        }
        TextUtils.equals(str, "FF");
        return "未知错误";
    }

    public static tf2 c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 7) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "获取BUCK_SIZE 和 PACKET_MAX_LENGTH 回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        boolean zEquals = TextUtils.equals(strSubstring2, "00");
        String strB2 = b(strSubstring2);
        int iF = (int) l63.f(bArr, 3, 2);
        int iF2 = (int) l63.f(bArr, 5, 2);
        tf2 tf2Var = new tf2(zEquals, strSubstring, strSubstring2, strB2);
        tf2Var.j(iF);
        tf2Var.l(iF2);
        return tf2Var;
    }

    public static tf2 d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 7) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, Constants.VIA_REPORT_TYPE_MAKE_FRIEND)) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "检查Flash的CheckSum 回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        boolean zEquals = TextUtils.equals(strSubstring2, "00");
        String strB2 = b(strSubstring2);
        long jF = l63.f(bArr, 3, 4);
        tf2 tf2Var = new tf2(zEquals, strSubstring, strSubstring2, strB2);
        tf2Var.k(jF);
        return tf2Var;
    }

    public static tf2 e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 3) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, Constants.VIA_REPORT_TYPE_START_GROUP)) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "OTA数据发送请求2 回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        return new tf2(TextUtils.equals(strSubstring2, "00"), strSubstring, strSubstring2, b(strSubstring2));
    }

    public static tf2 f(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 12) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, "18")) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "OTA结束命令请求 回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        boolean zEquals = TextUtils.equals(strSubstring2, "00");
        String strB2 = b(strSubstring2);
        String strSubstring3 = strB.substring(6, 8);
        long jF = l63.f(bArr, 4, 4);
        long jF2 = l63.f(bArr, 8, 4);
        tf2 tf2Var = new tf2(zEquals, strSubstring, strSubstring2, strB2);
        tf2Var.n(strSubstring3);
        tf2Var.p(jF);
        tf2Var.o(jF2);
        return tf2Var;
    }

    public static tf2 g(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 4) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, Constants.VIA_REPORT_TYPE_WPA_STATE)) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "OTA开始命令请求 回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        boolean zEquals = TextUtils.equals(strSubstring2, "00");
        String strB2 = b(strSubstring2);
        String strSubstring3 = strB.substring(6, 8);
        tf2 tf2Var = new tf2(zEquals, strSubstring, strSubstring2, strB2);
        tf2Var.n(strSubstring3);
        return tf2Var;
    }

    public static tf2 h(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 5) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "获取版本号回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        boolean zEquals = TextUtils.equals(strSubstring2, "00");
        String strB2 = b(strSubstring2);
        int iF = (int) l63.f(bArr, 3, 2);
        tf2 tf2Var = new tf2(zEquals, strSubstring, strSubstring2, strB2);
        tf2Var.m(iF);
        return tf2Var;
    }

    public static tf2 i(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 3) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "命令设备切换工作模式 回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        return new tf2(TextUtils.equals(strSubstring2, "00"), strSubstring, strSubstring2, b(strSubstring2));
    }

    public static tf2 j(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String strB = l63.b(bArr);
        if (!strB.trim().toLowerCase().startsWith("ab") || bArr.length != 4) {
            return null;
        }
        String strSubstring = strB.substring(4, 6);
        if (!TextUtils.equals(strSubstring, Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
            return null;
        }
        Log.d("_3GenOtaDataInteraction", "获取设备工作模式 回复包：" + strB);
        String strSubstring2 = strB.substring(2, 4);
        boolean zEquals = TextUtils.equals(strSubstring2, "00");
        String strB2 = b(strSubstring2);
        String strSubstring3 = strB.substring(6, 8);
        tf2 tf2Var = new tf2(zEquals, strSubstring, strSubstring2, strB2);
        tf2Var.q(strSubstring3);
        return tf2Var;
    }

    public static byte[] k() {
        return l63.h("ba11");
    }

    public static byte[] l(String str, String str2, String str3) {
        if (str.length() != 8 || str2.length() != 8 || str3.length() != 8) {
            return null;
        }
        return l63.h("ba14" + (str.substring(6, 8) + str.substring(4, 6) + str.substring(2, 4) + str.substring(0, 2)) + (str2.substring(6, 8) + str2.substring(4, 6) + str2.substring(2, 4) + str2.substring(0, 2)) + (str3.substring(6, 8) + str3.substring(4, 6) + str3.substring(2, 4) + str3.substring(0, 2)));
    }

    public static byte[] m(int i, String str) {
        String lowerCase = l63.i(i, 2).toLowerCase();
        String strI = l63.i(str.length() / 2, 1);
        return l63.h("ba17" + (lowerCase.substring(2, 4) + lowerCase.substring(0, 2)) + strI + str);
    }

    public static byte[] n(String str, String str2, String str3) {
        if (str2.length() != 8 || str3.length() != 8) {
            return null;
        }
        return l63.h("ba18" + str + (str2.substring(6, 8) + str2.substring(4, 6) + str2.substring(2, 4) + str2.substring(0, 2)) + (str3.substring(6, 8) + str3.substring(4, 6) + str3.substring(2, 4) + str3.substring(0, 2)));
    }

    public static byte[] o(String str) {
        return l63.h("ba15" + str);
    }

    public static byte[] p() {
        return l63.h("ba10");
    }

    public static byte[] q(String str) {
        return l63.h("ba13" + str);
    }

    public static byte[] r() {
        return l63.h("ba12");
    }
}
