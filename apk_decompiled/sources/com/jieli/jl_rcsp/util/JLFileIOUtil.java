package com.jieli.jl_rcsp.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class JLFileIOUtil {
    public static void isToFile(String str, InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(str);
        byte[] bArr = new byte[4096];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                fileOutputStream.close();
                return;
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }
}
