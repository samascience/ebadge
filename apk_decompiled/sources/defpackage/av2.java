package defpackage;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class av2 implements ug2 {
    private final List a;
    private final ug2 b;
    private final v9 c;

    public av2(List list, ug2 ug2Var, v9 v9Var) {
        this.a = list;
        this.b = ug2Var;
        this.c = v9Var;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e);
            return null;
        }
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(InputStream inputStream, int i, int i2, rx1 rx1Var) {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(bArrE), i, i2, rx1Var);
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, rx1 rx1Var) {
        return !((Boolean) rx1Var.a(ku0.b)).booleanValue() && a.e(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
