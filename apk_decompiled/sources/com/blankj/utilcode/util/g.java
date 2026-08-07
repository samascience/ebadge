package com.blankj.utilcode.util;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    private static final String a = System.getProperty("line.separator");

    class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isFile();
        }
    }

    class b implements FileFilter {
        b() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return true;
        }
    }

    public static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean b(String str) {
        return a(l(str));
    }

    public static boolean c(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean d(String str) {
        return c(l(str));
    }

    public static boolean e(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? g(file) : h(file);
    }

    public static boolean f(String str) {
        return e(l(str));
    }

    private static boolean g(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !g(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean h(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean i(File file) {
        return k(file, new a());
    }

    public static boolean j(String str) {
        return i(l(str));
    }

    public static boolean k(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !g(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static File l(String str) {
        if (q.H(str)) {
            return null;
        }
        return new File(str);
    }

    public static String m(String str) {
        if (q.H(str)) {
            return Constants.STR_EMPTY;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || str.lastIndexOf(File.separator) >= iLastIndexOf) ? Constants.STR_EMPTY : str.substring(iLastIndexOf + 1);
    }

    public static boolean n(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean o(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return p(file.getAbsolutePath());
    }

    public static boolean p(String str) {
        File fileL = l(str);
        if (fileL == null) {
            return false;
        }
        if (fileL.exists()) {
            return true;
        }
        return q(str);
    }

    private static boolean q(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = o.a().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    assetFileDescriptorOpenAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static List r(File file, boolean z, Comparator comparator) {
        return u(file, new b(), z, comparator);
    }

    public static List s(String str) {
        return t(str, null);
    }

    public static List t(String str, Comparator comparator) {
        return r(l(str), false, comparator);
    }

    public static List u(File file, FileFilter fileFilter, boolean z, Comparator comparator) {
        List listV = v(file, fileFilter, z);
        if (comparator != null) {
            Collections.sort(listV, comparator);
        }
        return listV;
    }

    private static List v(File file, FileFilter fileFilter, boolean z) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (n(file) && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z && file2.isDirectory()) {
                    arrayList.addAll(v(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }
}
