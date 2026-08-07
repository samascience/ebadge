package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.luck.picture.lib.R$string;
import com.luck.picture.lib.compress.Checker;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a22 {
    public static String A(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        if (n(str)) {
            return applicationContext.getString(R$string.picture_video_error);
        }
        return k(str) ? applicationContext.getString(R$string.picture_audio_error) : applicationContext.getString(R$string.picture_error);
    }

    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return Checker.MIME_TYPE_JPEG;
            }
            String name = new File(str).getName();
            int iLastIndexOf = name.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
            return "image/" + (iLastIndexOf == -1 ? "jpeg" : name.substring(iLastIndexOf + 1));
        } catch (Exception e) {
            e.printStackTrace();
            return Checker.MIME_TYPE_JPEG;
        }
    }

    public static String b(String str, int i) {
        try {
            String name = new File(str).getName();
            int iLastIndexOf = name.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
            boolean z = iLastIndexOf != -1;
            if (i == 2) {
                if (!z) {
                    return "video/mp4";
                }
                return "video/" + name.substring(iLastIndexOf + 1);
            }
            if (i != 3) {
                if (!z) {
                    return Checker.MIME_TYPE_JPEG;
                }
                return "image/" + name.substring(iLastIndexOf + 1);
            }
            if (!z) {
                return "audio/amr";
            }
            return "audio/" + name.substring(iLastIndexOf + 1);
        } catch (Exception e) {
            e.printStackTrace();
            return Checker.MIME_TYPE_JPEG;
        }
    }

    public static String c(String str) {
        try {
            int iLastIndexOf = str.lastIndexOf(WatchConstant.FAT_FS_ROOT) + 1;
            if (iLastIndexOf <= 0) {
                return ".png";
            }
            return FileUtils.FILE_EXTENSION_SEPARATOR + str.substring(iLastIndexOf);
        } catch (Exception e) {
            e.printStackTrace();
            return ".png";
        }
    }

    public static String d(String str) {
        try {
            int iLastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
            return iLastIndexOf != -1 ? str.substring(iLastIndexOf) : ".png";
        } catch (Exception e) {
            e.printStackTrace();
            return ".png";
        }
    }

    public static int e(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (str.startsWith("video")) {
            return 2;
        }
        return str.startsWith("audio") ? 3 : 1;
    }

    public static String f(Context context, Uri uri) {
        String mimeTypeFromExtension;
        if (uri.getScheme().equals("content")) {
            mimeTypeFromExtension = context.getContentResolver().getType(uri);
        } else {
            mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()).toLowerCase());
        }
        return TextUtils.isEmpty(mimeTypeFromExtension) ? Checker.MIME_TYPE_JPEG : mimeTypeFromExtension;
    }

    public static String g(long j, String str) {
        Uri contentUri;
        if (m(str)) {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (n(str)) {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            contentUri = k(str) ? MediaStore.Audio.Media.EXTERNAL_CONTENT_URI : MediaStore.Files.getContentUri("external");
        }
        return ContentUris.withAppendedId(contentUri, j).toString();
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    public static boolean i(String str) {
        return str != null && (str.equals("image/gif") || str.equals("image/GIF"));
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ".gif".equalsIgnoreCase(str);
    }

    public static boolean k(String str) {
        return str != null && str.startsWith("audio");
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http") || str.startsWith("https") || str.startsWith("/http") || str.startsWith("/https");
    }

    public static boolean m(String str) {
        return str != null && str.startsWith("image");
    }

    public static boolean n(String str) {
        return str != null && str.startsWith("video");
    }

    public static boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(Checker.MIME_TYPE_JPG);
    }

    public static boolean p(String str, String str2) {
        return e(str) == e(str2);
    }

    public static boolean q(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ".png".equalsIgnoreCase(str) || ".jpeg".equalsIgnoreCase(str) || ".jpg".equalsIgnoreCase(str) || ".webp".equalsIgnoreCase(str) || ".gif".equalsIgnoreCase(str) || ".bmp".equalsIgnoreCase(str);
    }

    public static boolean r(String str) {
        return str != null && str.equalsIgnoreCase("image/webp");
    }

    public static int s() {
        return 0;
    }

    public static int t() {
        return 3;
    }

    public static String u() {
        return "image/bmp";
    }

    public static String v() {
        return "image/gif";
    }

    public static int w() {
        return 1;
    }

    public static String x() {
        return Checker.MIME_TYPE_JPEG;
    }

    public static int y() {
        return 2;
    }

    public static String z() {
        return "image/webp";
    }
}
