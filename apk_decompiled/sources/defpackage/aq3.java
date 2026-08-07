package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public abstract class aq3 {
    private static String a = "Temp_in.dat";
    private static File b = new File(bq3.a, a);
    private static StringBuffer c = null;
    private static boolean d = true;
    private static int e = 0;
    private static int f = 0;
    private static long g = 0;
    private static long h = 0;
    private static long i = 0;
    private static double j = 0.0d;
    private static double k = 0.0d;
    private static int l = 0;
    private static int m = 0;
    private static int n = 0;

    public static String a() {
        int i2;
        File file = b;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(b, "rw");
            randomAccessFile.seek(0L);
            int i3 = randomAccessFile.readInt();
            int i4 = randomAccessFile.readInt();
            int i5 = randomAccessFile.readInt();
            if (!b(i3, i4, i5)) {
                randomAccessFile.close();
                d();
                return null;
            }
            if (i4 != 0 && i4 != i5) {
                long j2 = ((i4 - 1) * 1024) + 12;
                randomAccessFile.seek(j2);
                int i6 = randomAccessFile.readInt();
                byte[] bArr = new byte[i6];
                randomAccessFile.seek(j2 + 4);
                for (int i7 = 0; i7 < i6; i7++) {
                    bArr[i7] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                int i8 = fq3.C;
                int i9 = 1;
                if (i3 < i8) {
                    i2 = i4 + 1;
                } else {
                    if (i4 != i8) {
                        i9 = 1 + i4;
                    }
                    i2 = i9;
                }
                randomAccessFile.seek(4L);
                randomAccessFile.writeInt(i2);
                randomAccessFile.close();
                return str;
            }
            randomAccessFile.close();
            return null;
        } catch (IOException unused) {
        }
    }

    private static boolean b(int i2, int i3, int i4) {
        int i5;
        int i6;
        return i2 >= 0 && i2 <= (i5 = fq3.C) && i3 >= 0 && i3 <= (i6 = i2 + 1) && i4 >= 1 && i4 <= i6 && i4 <= i5;
    }

    private static void c() {
        d = true;
        c = null;
        e = 0;
        f = 0;
        g = 0L;
        h = 0L;
        i = 0L;
        j = 0.0d;
        k = 0.0d;
        l = 0;
        m = 0;
        n = 0;
    }

    private static boolean d() {
        if (b.exists()) {
            b.delete();
        }
        if (!b.getParentFile().exists()) {
            b.getParentFile().mkdirs();
        }
        try {
            b.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(b, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            c();
            return b.exists();
        } catch (IOException unused) {
            return false;
        }
    }
}
