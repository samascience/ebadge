package com.tenmeter.smlibrary.utils;

import android.text.Editable;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes3.dex */
public class StringUtil {
    public static DecimalFormat format = new DecimalFormat("0.00");
    public static DecimalFormat formatZero = new DecimalFormat("###########.######");
    public static StringBuffer sb = new StringBuffer();

    public static void charsetLength(Editable editable, int i) {
        int length = editable.toString().getBytes(Charset.defaultCharset()).length;
        if (length > i) {
            editable.delete(i - 1, length);
        }
    }

    public static String convertTo(String str) {
        String str2 = Constants.STR_EMPTY;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            str2 = (cCharAt < '!' || cCharAt > '~') ? str2 + getPYChar(String.valueOf(cCharAt)) : str2 + String.valueOf(cCharAt);
        }
        return str2;
    }

    public static int counterChars(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            i = (cCharAt <= 0 || cCharAt >= 127) ? i + 2 : i + 1;
        }
        return i;
    }

    public static void decimal(Editable editable, int i, int i2) {
        Pattern patternCompile = Pattern.compile("^[0-9]{0," + i + "}+(\\.[0-9]{0," + i2 + "})?$");
        String string = editable.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (editable.length() > 1 && editable.charAt(0) == '0' && editable.charAt(1) != '.') {
            editable.delete(0, 1);
            return;
        }
        if (FileUtils.FILE_EXTENSION_SEPARATOR.equals(string)) {
            editable.insert(0, "0");
        } else {
            if (patternCompile == null || patternCompile.matcher(string).matches() || editable.length() <= 0) {
                return;
            }
            editable.delete(editable.length() - 1, editable.length());
        }
    }

    public static final String filterUCS4(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int iCharCount = 0;
        if (str.codePointCount(0, str.length()) == str.length()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            iCharCount += Character.charCount(iCodePointAt);
            if (!Character.isSupplementaryCodePoint(iCodePointAt)) {
                sb2.appendCodePoint(iCodePointAt);
            }
        }
        return sb2.toString();
    }

    public static String formatBalance(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    public static String formatDoubToString(Double d) {
        return format.format(d);
    }

    public static String formatDoubZeroToString(Double d) {
        return formatZero.format(d);
    }

    public static String formatFloatToString(Float f) {
        return formatZero.format(f);
    }

    public static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll("-", Constants.STR_EMPTY);
    }

    public static String get36UUID() {
        return UUID.randomUUID().toString();
    }

    public static String getPYChar(String str) {
        byte[] bytes = String.valueOf(str).getBytes();
        int i = (((short) (bytes[0] + 256)) * 256) + ((short) (bytes[1] + 256));
        if (i < 45217) {
            return Marker.ANY_MARKER;
        }
        if (i < 45253) {
            return "a";
        }
        if (i < 45761) {
            return "b";
        }
        if (i < 46318) {
            return "c";
        }
        if (i < 46826) {
            return "d";
        }
        if (i < 47010) {
            return "e";
        }
        if (i < 47297) {
            return "f";
        }
        if (i < 47614) {
            return "g";
        }
        if (i < 48119) {
            return "h";
        }
        if (i < 49062) {
            return "j";
        }
        if (i < 49324) {
            return "k";
        }
        if (i < 49896) {
            return "l";
        }
        if (i < 50371) {
            return "m";
        }
        if (i < 50614) {
            return "n";
        }
        if (i < 50622) {
            return "o";
        }
        if (i < 50906) {
            return "p";
        }
        if (i < 51387) {
            return "q";
        }
        if (i < 51446) {
            return "r";
        }
        if (i < 52218) {
            return "s";
        }
        if (i < 52698) {
            return "t";
        }
        if (i < 52980) {
            return "w";
        }
        if (i < 53689) {
            return "x";
        }
        if (i < 54481) {
            return "y";
        }
        return i < 55290 ? "z" : Marker.ANY_MARKER;
    }

    public static String getPercentString(float f) {
        return String.format(Locale.US, "%d%%", Integer.valueOf((int) (f * 100.0f)));
    }

    public static boolean isChinese(char c) {
        return c >= 19968 && c <= 40869;
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String makeMd5(String str) {
        return MD5.getStringMD5(str);
    }

    public static String removeBlanks(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        for (int length = sb2.length() - 1; length >= 0; length--) {
            if (' ' == sb2.charAt(length) || '\n' == sb2.charAt(length) || '\t' == sb2.charAt(length) || '\r' == sb2.charAt(length)) {
                sb2.deleteCharAt(length);
            }
        }
        return sb2.toString();
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        return Pattern.compile("[^a-zA-Z0-9一-龥]").matcher(str).replaceAll(Constants.STR_EMPTY).trim();
    }

    public static String stringFilterDigitAndLetter(String str) throws PatternSyntaxException {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll(Constants.STR_EMPTY).trim();
    }

    public static String stringToUtf8(String str) {
        try {
            return URLEncoder.encode(str, Constants.ENC_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean vd(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    public static Editable decimal(String str, int i, int i2) {
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable(str);
        decimal(editableNewEditable, i, i2);
        return editableNewEditable;
    }
}
