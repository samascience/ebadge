package defpackage;

import com.baji.protocol.model.ProtocolConstants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q52 {
    public static byte[] a(byte b) {
        return new byte[]{ProtocolConstants.PACKET_START_MARKER, 0, 6, 39, 1, 1, 0, 1, b};
    }

    public static byte[] b() {
        byte[] bArr = r52.c;
        return new byte[]{ProtocolConstants.PACKET_START_MARKER, 0, 5, 39, 1, bArr[0], bArr[1], 0, 0};
    }

    public static byte[] c() {
        return ks1.h(r52.a, new byte[]{0, 0, 0, 0}, r52.b);
    }
}
