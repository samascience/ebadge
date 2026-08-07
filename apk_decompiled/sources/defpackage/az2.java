package defpackage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.luck.picture.lib.config.PictureSelectionConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class az2 {
    private static String a(Activity activity, Uri uri, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        String strSubstring;
        String strSubstring2;
        try {
            File externalFilesDir = activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            if (externalFilesDir == null) {
                externalFilesDir = new File(activity.getFilesDir(), "Pictures");
            }
            if (!externalFilesDir.exists()) {
                externalFilesDir.mkdirs();
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "image_" + System.currentTimeMillis() + a22.c(str);
            }
            File file = new File(externalFilesDir, str2);
            int i = 1;
            while (file.exists()) {
                int iLastIndexOf = str2.lastIndexOf(46);
                if (iLastIndexOf > 0) {
                    strSubstring = str2.substring(0, iLastIndexOf);
                    strSubstring2 = str2.substring(iLastIndexOf);
                } else {
                    strSubstring = str2;
                    strSubstring2 = Constants.STR_EMPTY;
                }
                i++;
                file = new File(externalFilesDir, strSubstring + "_" + i + strSubstring2);
            }
            InputStream inputStreamA = y02.a(activity, uri);
            if (inputStreamA == null) {
                return Constants.STR_EMPTY;
            }
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i2 = inputStreamA.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i2);
                        e.printStackTrace();
                        return Constants.STR_EMPTY;
                    }
                    fileOutputStream.flush();
                    String absolutePath = file.getAbsolutePath();
                    try {
                        inputStreamA.close();
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return absolutePath;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        inputStreamA.close();
                        if (fileOutputStream == null) {
                            throw th;
                        }
                        fileOutputStream.close();
                        throw th;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            return Constants.STR_EMPTY;
        }
    }

    private static List b(Intent intent) {
        ArrayList arrayList = new ArrayList();
        Uri data = intent.getData();
        if (data != null) {
            arrayList.add(data);
        }
        if (intent.getClipData() != null) {
            int itemCount = intent.getClipData().getItemCount();
            for (int i = 0; i < itemCount; i++) {
                Uri uri = intent.getClipData().getItemAt(i).getUri();
                if (uri != null) {
                    arrayList.add(uri);
                }
            }
        }
        return arrayList;
    }

    public static List c(Activity activity, Intent intent, PictureSelectionConfig pictureSelectionConfig) {
        ArrayList arrayList = new ArrayList();
        if (intent != null && pictureSelectionConfig != null) {
            List listB = b(intent);
            if (listB.isEmpty()) {
                return arrayList;
            }
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                LocalMedia localMediaD = d(activity, (Uri) it.next(), pictureSelectionConfig);
                if (localMediaD != null) {
                    arrayList.add(localMediaD);
                }
            }
            if (arrayList.isEmpty()) {
                return arrayList;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (a22.m(((LocalMedia) it2.next()).n())) {
                    if (!pictureSelectionConfig.o0 || pictureSelectionConfig.L0) {
                        break;
                        break;
                    }
                    if (pictureSelectionConfig.v != 1 || arrayList.size() <= 0) {
                        t73.c(activity, arrayList);
                        return new ArrayList();
                    }
                    LocalMedia localMedia = (LocalMedia) arrayList.get(0);
                    String strQ = localMedia.q();
                    pictureSelectionConfig.Y0 = strQ;
                    t73.b(activity, strQ, localMedia.n(), localMedia.u(), localMedia.l());
                    return new ArrayList();
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:103:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:106:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:108:0x0201  */
    /* JADX WARN: Code duplicated, block: B:109:0x0206  */
    /* JADX WARN: Code duplicated, block: B:112:0x0211  */
    /* JADX WARN: Code duplicated, block: B:114:0x021b  */
    /* JADX WARN: Code duplicated, block: B:117:0x0236  */
    /* JADX WARN: Code duplicated, block: B:133:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:64:0x0151 A[PHI: r12 r15 r16 r18
      0x0151: PHI (r12v8 android.database.Cursor) = (r12v7 android.database.Cursor), (r12v9 android.database.Cursor) binds: [B:69:0x0160, B:63:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r15v6 java.lang.String) = (r15v5 java.lang.String), (r15v7 java.lang.String) binds: [B:69:0x0160, B:63:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r16v7 long) = (r16v5 long), (r16v8 long) binds: [B:69:0x0160, B:63:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r18v6 java.lang.String) = (r18v5 java.lang.String), (r18v7 java.lang.String) binds: [B:69:0x0160, B:63:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:78:0x0175  */
    /* JADX WARN: Code duplicated, block: B:80:0x017f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0184  */
    /* JADX WARN: Code duplicated, block: B:84:0x018c  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d3  */
    /* JADX WARN: Instruction removed from duplicated block: B:93:0x01ae, please report this as an issue */
    private static LocalMedia d(Activity activity, Uri uri, PictureSelectionConfig pictureSelectionConfig) throws Throwable {
        Exception exc;
        String str;
        String string;
        long j;
        int i;
        long j2;
        long j3;
        String string2;
        String string3;
        long j4;
        int i2;
        String type;
        int iB;
        int i3;
        int iT;
        LocalMedia localMediaF;
        String strA;
        String path;
        int iLastIndexOf;
        int i4;
        long j5;
        Cursor cursorQuery = null;
        string = null;
        String string4 = null;
        cursorQuery = null;
        if (uri == null) {
            return null;
        }
        String string5 = uri.toString();
        ContentResolver contentResolver = activity.getContentResolver();
        int i5 = 0;
        long j6 = 0;
        try {
            try {
                Cursor cursorQuery2 = contentResolver.query(uri, new String[]{"_id", "_display_name", "mime_type", "_size", "date_added", "width", "height"}, null, null, null);
                if (cursorQuery2 != null) {
                    try {
                        try {
                            if (cursorQuery2.moveToFirst()) {
                                int columnIndexOrThrow = cursorQuery2.getColumnIndexOrThrow("_id");
                                int columnIndexOrThrow2 = cursorQuery2.getColumnIndexOrThrow("_display_name");
                                int columnIndexOrThrow3 = cursorQuery2.getColumnIndexOrThrow("mime_type");
                                int columnIndexOrThrow4 = cursorQuery2.getColumnIndexOrThrow("_size");
                                int columnIndexOrThrow5 = cursorQuery2.getColumnIndexOrThrow("date_added");
                                long j7 = cursorQuery2.getLong(columnIndexOrThrow);
                                try {
                                    string = cursorQuery2.getString(columnIndexOrThrow2);
                                    try {
                                        string4 = cursorQuery2.getString(columnIndexOrThrow3);
                                        j6 = cursorQuery2.getLong(columnIndexOrThrow4);
                                        try {
                                            j6 = cursorQuery2.getLong(columnIndexOrThrow5);
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                int columnIndexOrThrow6 = cursorQuery2.getColumnIndexOrThrow("width");
                                                int columnIndexOrThrow7 = cursorQuery2.getColumnIndexOrThrow("height");
                                                i5 = cursorQuery2.getInt(columnIndexOrThrow6);
                                                try {
                                                    i4 = cursorQuery2.getInt(columnIndexOrThrow7);
                                                    i5 = i5;
                                                } catch (Exception e) {
                                                    e = e;
                                                    exc = e;
                                                    str = string4;
                                                    cursorQuery = cursorQuery2;
                                                    long j8 = j6;
                                                    j6 = j7;
                                                    j = j8;
                                                    exc.printStackTrace();
                                                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                                                        cursorQuery.close();
                                                    }
                                                    i = 0;
                                                    j2 = j6;
                                                    j3 = j;
                                                    string2 = str;
                                                    string3 = string;
                                                    j4 = j6;
                                                    i2 = i5;
                                                }
                                            } else {
                                                i4 = 0;
                                            }
                                            j5 = j6;
                                            j6 = j7;
                                        } catch (Exception e2) {
                                            e = e2;
                                            i5 = 0;
                                        }
                                    } catch (Exception e3) {
                                        i5 = 0;
                                        j6 = 0;
                                        j6 = j7;
                                        j = 0;
                                        exc = e3;
                                        str = string4;
                                        cursorQuery = cursorQuery2;
                                    }
                                } catch (Exception e4) {
                                    string = null;
                                    cursorQuery = cursorQuery2;
                                    exc = e4;
                                    str = null;
                                    j6 = j7;
                                    j = j6;
                                    exc.printStackTrace();
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    i = 0;
                                    j2 = j6;
                                    j3 = j;
                                    string2 = str;
                                    string3 = string;
                                    j4 = j6;
                                    i2 = i5;
                                    if (TextUtils.isEmpty(string2)) {
                                        try {
                                            cursorQuery = contentResolver.query(uri, new String[]{"mime_type", "_display_name", "_size"}, null, null, null);
                                            if (cursorQuery != null) {
                                                int columnIndexOrThrow8 = cursorQuery.getColumnIndexOrThrow("mime_type");
                                                int columnIndexOrThrow9 = cursorQuery.getColumnIndexOrThrow("_display_name");
                                                int columnIndexOrThrow10 = cursorQuery.getColumnIndexOrThrow("_size");
                                                string2 = cursorQuery.getString(columnIndexOrThrow8);
                                                string3 = cursorQuery.getString(columnIndexOrThrow9);
                                                j4 = cursorQuery.getLong(columnIndexOrThrow10);
                                            }
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                            if (cursorQuery != null && !cursorQuery.isClosed()) {
                                                cursorQuery.close();
                                            }
                                        }
                                    }
                                    long j9 = j4;
                                    if (TextUtils.isEmpty(string2)) {
                                        type = contentResolver.getType(uri);
                                        if (TextUtils.isEmpty(type)) {
                                            type = a22.a(string5);
                                        }
                                    } else {
                                        type = string2;
                                    }
                                    if (TextUtils.isEmpty(string3)) {
                                        path = uri.getPath();
                                        if (path != null) {
                                            string3 = path.substring(iLastIndexOf + 1);
                                        }
                                        if (TextUtils.isEmpty(string3)) {
                                            string3 = "image_" + System.currentTimeMillis() + ".jpg";
                                        }
                                    }
                                    if (i2 > 0) {
                                        qh1 qh1VarG = gi1.g(activity, string5);
                                        int iC = qh1VarG.c();
                                        iB = qh1VarG.b();
                                        i3 = iC;
                                    } else {
                                        qh1 qh1VarG2 = gi1.g(activity, string5);
                                        int iC2 = qh1VarG2.c();
                                        iB = qh1VarG2.b();
                                        i3 = iC2;
                                    }
                                    if (a22.m(type)) {
                                        iT = a22.w();
                                    } else if (a22.n(type)) {
                                        iT = a22.y();
                                    } else if (a22.k(type)) {
                                        iT = a22.t();
                                    } else {
                                        iT = pictureSelectionConfig.a;
                                    }
                                    int i6 = iT;
                                    if (a22.h(string5)) {
                                        strA = a(activity, uri, type, string3);
                                        if (!TextUtils.isEmpty(strA)) {
                                            string5 = strA;
                                        }
                                    }
                                    localMediaF = LocalMedia.F(j2, string5, string5, string3, Constants.STR_EMPTY, 0L, i6, type, i3, iB, j9, -1L, j3);
                                    if (ol2.a()) {
                                        localMediaF.H(string5);
                                    }
                                    return localMediaF;
                                }
                            } else {
                                string = null;
                                i4 = 0;
                                j6 = 0;
                                j5 = 0;
                            }
                        } catch (Exception e6) {
                            string = null;
                            i5 = 0;
                            j6 = 0;
                            j = 0;
                            cursorQuery = cursorQuery2;
                            exc = e6;
                            str = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursorQuery = cursorQuery2;
                        if (cursorQuery != null && !cursorQuery.isClosed()) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                } else {
                    string = null;
                    i4 = 0;
                    j6 = 0;
                    j5 = 0;
                }
                if (cursorQuery2 != null && !cursorQuery2.isClosed()) {
                    cursorQuery2.close();
                }
                i = i4;
                j3 = j5;
                string2 = string4;
                i2 = i5;
                j2 = j6;
                cursorQuery = cursorQuery2;
                string3 = string;
                j4 = j6;
            } catch (Exception e7) {
                exc = e7;
                str = null;
                string = null;
            }
            try {
                if (TextUtils.isEmpty(string2)) {
                    cursorQuery = contentResolver.query(uri, new String[]{"mime_type", "_display_name", "_size"}, null, null, null);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int columnIndexOrThrow11 = cursorQuery.getColumnIndexOrThrow("mime_type");
                        int columnIndexOrThrow12 = cursorQuery.getColumnIndexOrThrow("_display_name");
                        int columnIndexOrThrow13 = cursorQuery.getColumnIndexOrThrow("_size");
                        string2 = cursorQuery.getString(columnIndexOrThrow11);
                        string3 = cursorQuery.getString(columnIndexOrThrow12);
                        j4 = cursorQuery.getLong(columnIndexOrThrow13);
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                }
                long j10 = j4;
                if (TextUtils.isEmpty(string2)) {
                    type = contentResolver.getType(uri);
                    if (TextUtils.isEmpty(type)) {
                        type = a22.a(string5);
                    }
                } else {
                    type = string2;
                }
                if (TextUtils.isEmpty(string3)) {
                    path = uri.getPath();
                    if (path != null && (iLastIndexOf = path.lastIndexOf(47)) >= 0 && iLastIndexOf < path.length() - 1) {
                        string3 = path.substring(iLastIndexOf + 1);
                    }
                    if (TextUtils.isEmpty(string3)) {
                        string3 = "image_" + System.currentTimeMillis() + ".jpg";
                    }
                }
                if (i2 > 0 || i <= 0) {
                    qh1 qh1VarG3 = gi1.g(activity, string5);
                    int iC3 = qh1VarG3.c();
                    iB = qh1VarG3.b();
                    i3 = iC3;
                } else {
                    i3 = i2;
                    iB = i;
                }
                if (a22.m(type)) {
                    iT = a22.w();
                } else if (a22.n(type)) {
                    iT = a22.y();
                } else if (a22.k(type)) {
                    iT = a22.t();
                } else {
                    iT = pictureSelectionConfig.a;
                }
                int i7 = iT;
                if (a22.h(string5)) {
                    strA = a(activity, uri, type, string3);
                    if (!TextUtils.isEmpty(strA)) {
                        string5 = strA;
                    }
                }
                localMediaF = LocalMedia.F(j2, string5, string5, string3, Constants.STR_EMPTY, 0L, i7, type, i3, iB, j10, -1L, j3);
                if (ol2.a()) {
                    localMediaF.H(string5);
                }
                return localMediaF;
            } catch (Throwable th2) {
                if (cursorQuery != null && !cursorQuery.isClosed()) {
                    cursorQuery.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
