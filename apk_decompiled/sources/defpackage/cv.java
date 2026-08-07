package defpackage;

import android.content.ContentValues;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.luck.picture.lib.compress.Checker;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;

/* JADX INFO: loaded from: classes3.dex */
public abstract class cv {
    public static ContentValues a(String str, String str2) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR) == -1) {
            contentValues.put("_display_name", y60.d("IMG_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)), Constants.STR_EMPTY));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("video")) {
            str2 = Checker.MIME_TYPE_JPEG;
        }
        contentValues.put("mime_type", str2);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", strValueOf);
            contentValues.put("relative_path", "DCIM/Camera");
        }
        return contentValues;
    }

    public static ContentValues b(String str, String str2) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ContentValues contentValues = new ContentValues(3);
        if (TextUtils.isEmpty(str) || str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR) == -1) {
            contentValues.put("_display_name", y60.d("VID_"));
        } else {
            contentValues.put("_display_name", str.replaceAll(str.substring(str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR)), Constants.STR_EMPTY));
        }
        if (TextUtils.isEmpty(str2) || str2.startsWith("image")) {
            str2 = "video/mp4";
        }
        contentValues.put("mime_type", str2);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("datetaken", strValueOf);
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
        }
        return contentValues;
    }
}
