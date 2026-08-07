package com.baji.protocol.utils;

import defpackage.p31;
import defpackage.ty;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public final class Crc32Utils {
    public static final Crc32Utils INSTANCE = new Crc32Utils();

    private Crc32Utils() {
    }

    public final int calculate(byte[] bArr) {
        p31.f(bArr, "data");
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        return (int) crc32.getValue();
    }

    public final int calculateCrc32(File file) {
        p31.f(file, "file");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                CRC32 crc32 = new CRC32();
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        int value = (int) crc32.getValue();
                        ty.a(fileInputStream, null);
                        return value;
                    }
                    crc32.update(bArr, 0, i);
                    return 0;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    ty.a(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (Exception unused) {
            return 0;
        }
    }

    public final boolean verify(byte[] bArr, int i) {
        p31.f(bArr, "data");
        return calculate(bArr) == i;
    }

    public final boolean verify(byte[] bArr, int i, int i2, int i3) {
        p31.f(bArr, "data");
        return calculate(bArr, i, i2) == i3;
    }

    public final int calculate(byte[] bArr, int i, int i2) {
        p31.f(bArr, "data");
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        return (int) crc32.getValue();
    }
}
