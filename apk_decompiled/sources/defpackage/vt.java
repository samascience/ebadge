package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.luck.picture.lib.compress.Checker;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class vt {
    public static ContentValues a(String str, String str2) {
        String strE = db3.e(Long.valueOf(System.currentTimeMillis()));
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
        if (ol2.a()) {
            contentValues.put("datetaken", strE);
            contentValues.put("relative_path", "DCIM/Camera");
        }
        return contentValues;
    }

    public static ContentValues b(String str, String str2) {
        String strE = db3.e(Long.valueOf(System.currentTimeMillis()));
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
        if (ol2.a()) {
            contentValues.put("datetaken", strE);
            contentValues.put("relative_path", Environment.DIRECTORY_MOVIES);
        }
        return contentValues;
    }

    public static Uri c(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        String strE = db3.e(Long.valueOf(System.currentTimeMillis()));
        ContentValues contentValues = new ContentValues(3);
        contentValues.put("_display_name", y60.d("AUD_"));
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            contentValues.put("datetaken", strE);
        }
        if (TextUtils.isEmpty(str) || str.startsWith("image") || str.startsWith("video")) {
            str = "audio/amr";
        }
        contentValues.put("mime_type", str);
        if (externalStorageState.equals("mounted")) {
            if (i >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_MUSIC);
            }
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, contentValues);
        }
        return uriArr[0];
    }

    public static Uri d(Context context, PictureSelectionConfig pictureSelectionConfig) {
        pictureSelectionConfig.a1 = a22.t();
        if (!ol2.a()) {
            return null;
        }
        Uri uriC = c(context, pictureSelectionConfig.k);
        pictureSelectionConfig.Z0 = uriC != null ? uriC.toString() : null;
        return uriC;
    }

    public static Uri e(Context context, PictureSelectionConfig pictureSelectionConfig) {
        String strD;
        Log.i("CameraFileUtils", "=== 创建相机输出图片URI ===");
        Log.i("CameraFileUtils", "outPutCameraPath: " + pictureSelectionConfig.W0);
        Log.i("CameraFileUtils", "cameraFileName: " + pictureSelectionConfig.K0);
        Log.i("CameraFileUtils", "cameraImageFormat: " + pictureSelectionConfig.f);
        pictureSelectionConfig.a1 = a22.w();
        if (TextUtils.isEmpty(pictureSelectionConfig.K0)) {
            strD = Constants.STR_EMPTY;
        } else {
            strD = !a22.q(pictureSelectionConfig.K0) ? sv2.d(pictureSelectionConfig.K0, ".jpg") : pictureSelectionConfig.K0;
            pictureSelectionConfig.K0 = strD;
            if (!pictureSelectionConfig.b) {
                strD = sv2.c(strD);
            }
        }
        File fileC = s12.c(context, 1, strD, pictureSelectionConfig.f, pictureSelectionConfig.W0);
        pictureSelectionConfig.Z0 = fileC.getAbsolutePath();
        Log.i("CameraFileUtils", "相机文件路径: " + pictureSelectionConfig.Z0);
        Log.i("CameraFileUtils", "文件是否存在: " + fileC.exists());
        StringBuilder sb = new StringBuilder();
        sb.append("文件父目录: ");
        sb.append(fileC.getParentFile() != null ? fileC.getParentFile().getAbsolutePath() : "null");
        Log.i("CameraFileUtils", sb.toString());
        Uri uriT = s12.t(context, fileC);
        Log.i("CameraFileUtils", "生成的URI: " + uriT);
        Log.i("CameraFileUtils", "=== 创建完成 ===");
        return uriT;
    }

    public static Uri f(Context context, PictureSelectionConfig pictureSelectionConfig) {
        String strD;
        pictureSelectionConfig.a1 = a22.y();
        if (TextUtils.isEmpty(pictureSelectionConfig.K0)) {
            strD = Constants.STR_EMPTY;
        } else {
            strD = a22.q(pictureSelectionConfig.K0) ? sv2.d(pictureSelectionConfig.K0, ".mp4") : pictureSelectionConfig.K0;
            pictureSelectionConfig.K0 = strD;
            if (!pictureSelectionConfig.b) {
                strD = sv2.c(strD);
            }
        }
        File fileC = s12.c(context, 2, strD, pictureSelectionConfig.g, pictureSelectionConfig.W0);
        pictureSelectionConfig.Z0 = fileC.getAbsolutePath();
        return s12.t(context, fileC);
    }

    public static Uri g(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        Uri[] uriArr = {null};
        String externalStorageState = Environment.getExternalStorageState();
        ContentValues contentValuesA = a(str, str2);
        if (externalStorageState.equals("mounted")) {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValuesA);
        } else {
            uriArr[0] = applicationContext.getContentResolver().insert(MediaStore.Images.Media.INTERNAL_CONTENT_URI, contentValuesA);
        }
        return uriArr[0];
    }
}
