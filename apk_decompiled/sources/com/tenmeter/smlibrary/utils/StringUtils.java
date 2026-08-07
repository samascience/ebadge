package com.tenmeter.smlibrary.utils;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class StringUtils {
    private StringUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String capitalizeFirstLetter(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLetter(cCharAt) || Character.isUpperCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(Character.toUpperCase(cCharAt));
        sb.append(str.substring(1));
        return sb.toString();
    }

    public static String cnToUnicode(String str) {
        char[] charArray = str.toCharArray();
        String str2 = Constants.STR_EMPTY;
        for (char c : charArray) {
            str2 = str2 + "\\u" + Integer.toString(c, 16);
        }
        return str2;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static String formatPhoneNumber(String str) {
        String strReplace = str.replace(" ", Constants.STR_EMPTY);
        return strReplace.substring(0, 3) + " " + strReplace.substring(3, 7) + " " + strReplace.substring(7);
    }

    public static String getHrefInnerHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            return Constants.STR_EMPTY;
        }
        Matcher matcher = Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(str);
        return matcher.matches() ? matcher.group(1) : str;
    }

    public static String getMacAdd(String str, int i) {
        return Long.toHexString(Long.parseLong(str, 16) + ((long) i)).toUpperCase(Locale.getDefault());
    }

    public static String getMacMinus(String str, int i) {
        return Long.toHexString(Long.parseLong(str, 16) - ((long) i)).toUpperCase(Locale.getDefault());
    }

    public static String halfWidthToFullWidth(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c < '!' || c > '~') {
                charArray[i] = c;
            } else {
                charArray[i] = (char) (c + 65248);
            }
        }
        return new String(charArray);
    }

    public static String htmlEscapeCharsToString(String str) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static Boolean isEmail(String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.FALSE;
        }
        return str.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$") ? Boolean.TRUE : Boolean.FALSE;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isLetterDigit(String str) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                z = true;
            }
            if (Character.isLetter(str.charAt(i))) {
                z2 = true;
            }
        }
        return z && z2 && str.matches("^[a-zA-Z0-9]+$");
    }

    public static boolean isNumerEX(String str) {
        return Pattern.compile("-?[0-9]+.?[0-9]+").matcher(str).matches() || Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTrimEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerFirstLetter(String str) {
        if (isEmpty(str) || !Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        return String.valueOf((char) (str.charAt(0) + ' ')) + str.substring(1);
    }

    public static String null2Length0(String str) {
        return str == null ? Constants.STR_EMPTY : str;
    }

    public static String nullStrToEmpty(Object obj) {
        if (obj == null) {
            return Constants.STR_EMPTY;
        }
        return obj instanceof String ? (String) obj : obj.toString();
    }

    public static String replaceBlank(String str) {
        return str != null ? Pattern.compile("\t|\r|\n|\\s*").matcher(str).replaceAll(Constants.STR_EMPTY) : Constants.STR_EMPTY;
    }

    public static String reverse(String str) {
        int length = length(str);
        if (length <= 1) {
            return str;
        }
        int i = length >> 1;
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < i; i2++) {
            char c = charArray[i2];
            int i3 = (length - i2) - 1;
            charArray[i2] = charArray[i3];
            charArray[i3] = c;
        }
        return new String(charArray);
    }

    public static String splitIndex(String str, String str2) {
        return str.substring(str.lastIndexOf(str2), str.length());
    }

    public static String toDBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == 12288) {
                charArray[i] = ' ';
            } else if (65281 > c || c > 65374) {
                charArray[i] = c;
            } else {
                charArray[i] = (char) (c - 65248);
            }
        }
        return new String(charArray);
    }

    public static String toSBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if ('!' > c || c > '~') {
                charArray[i] = c;
            } else {
                charArray[i] = (char) (c + 65248);
            }
        }
        return new String(charArray);
    }

    public static String upperFirstLetter(String str) {
        if (isEmpty(str) || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return String.valueOf((char) (str.charAt(0) - ' ')) + str.substring(1);
    }

    public static String utf8Encode(String str) {
        if (TextUtils.isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, Constants.ENC_UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    public static String utf8Encode(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, Constants.ENC_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return str2;
        }
    }
}
