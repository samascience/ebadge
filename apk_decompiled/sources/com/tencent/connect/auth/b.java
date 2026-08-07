package com.tencent.connect.auth;

import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static b a = null;
    static final /* synthetic */ boolean d = true;
    private static int e;
    public HashMap<String, a> b = new HashMap<>();
    public final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class a {
        public IUiListener a;
        public com.tencent.connect.auth.a b;
        public String c;
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public String c() {
        int iCeil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iCeil; i++) {
            stringBuffer.append(charArray[(int) (Math.random() * ((double) length))]);
        }
        return stringBuffer.toString();
    }

    public String a(a aVar) {
        int iB = b();
        try {
            this.b.put(Constants.STR_EMPTY + iB, aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return Constants.STR_EMPTY + iB;
    }
}
