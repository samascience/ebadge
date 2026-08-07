package com.tenmeter.smlibrary.utils;

import com.tencent.connect.common.Constants;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class MD5 {
    public static String getMD5(byte[] bArr) {
        try {
            return HexDump.toHex(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0021: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:8:0x0021 */
    public static String getStreamMD5(String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        byte[] bArr = new byte[4096];
        String hex = null;
        hex = null;
        hex = null;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                    while (true) {
                        try {
                            int i = bufferedInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            messageDigest.update(bArr, 0, i);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return hex;
                        }
                    }
                    bufferedInputStream.close();
                    hex = HexDump.toHex(messageDigest.digest());
                    bufferedInputStream.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream3 = bufferedInputStream2;
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream3 != null) {
                    bufferedInputStream3.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return hex;
    }

    public static String getStringMD5(String str) {
        if (str == null || str.trim().length() < 1) {
            return null;
        }
        try {
            return getMD5(str.getBytes(Constants.ENC_UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
