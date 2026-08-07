package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.luck.picture.lib.R$string;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class sv2 {
    public static String a(long j, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return j + "_" + System.currentTimeMillis();
        }
        return j + "_" + i + i2;
    }

    public static String b(Context context, String str, int i) {
        if (a22.n(str)) {
            return context.getString(R$string.picture_message_video_max_num, Integer.valueOf(i));
        }
        return a22.k(str) ? context.getString(R$string.picture_message_audio_max_num, Integer.valueOf(i)) : context.getString(R$string.picture_message_max_num, Integer.valueOf(i));
    }

    public static String c(String str) {
        try {
            return str.substring(0, str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) + "_" + y60.c() + str.substring(str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR));
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    public static String d(String str, String str2) {
        try {
            return str.substring(0, str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)) + str2;
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    public static int e(String str) {
        if (Pattern.compile("^[-\\+]?[\\d]+$").matcher(str).matches()) {
            return db3.a(str);
        }
        return 0;
    }

    public static void f(TextView textView, int i) {
        String strTrim = textView.getText().toString().trim();
        String string = i == a22.t() ? textView.getContext().getString(R$string.picture_empty_audio_title) : textView.getContext().getString(R$string.picture_empty_title);
        String str = string + strTrim;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new RelativeSizeSpan(0.8f), string.length(), str.length(), 33);
        textView.setText(spannableString);
    }
}
