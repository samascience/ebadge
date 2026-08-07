package defpackage;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ym0 {
    public static int a(String str, String str2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return 0;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception unused) {
            return -1;
        }
    }

    public static boolean b(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean c(String str) {
        return b(h(str));
    }

    public static boolean d(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean e(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            boolean zE = true;
            for (File file2 : file.listFiles()) {
                if (!file2.isFile()) {
                    if (file2.isDirectory() && !(zE = e(file2.getAbsolutePath()))) {
                        break;
                    }
                } else {
                    zE = g(file2.getAbsolutePath());
                    if (!zE) {
                        break;
                    }
                }
            }
            if (zE && file.delete()) {
                Log.e("--Method--", "Copy_Delete.deleteDirectory: 删除目录" + str + "成功！");
                return true;
            }
        }
        return false;
    }

    public static boolean f(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        boolean zE = true;
        for (File file2 : file.listFiles()) {
            if (!file2.isFile()) {
                if (file2.isDirectory() && !(zE = e(file2.getAbsolutePath()))) {
                    break;
                }
            } else {
                zE = g(file2.getAbsolutePath());
                if (!zE) {
                    break;
                }
            }
        }
        return zE;
    }

    public static boolean g(String str) {
        File file = new File(str);
        if (!file.exists() || !file.isFile() || !file.delete()) {
            return false;
        }
        Log.e("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + str + "成功！");
        return true;
    }

    public static File h(String str) {
        if (j(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean i(File file) {
        return file != null && file.exists();
    }

    private static boolean j(String str) {
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
}
