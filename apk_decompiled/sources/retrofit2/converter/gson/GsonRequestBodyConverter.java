package retrofit2.converter.gson;

import com.tencent.connect.common.Constants;
import defpackage.a81;
import defpackage.e63;
import defpackage.ff2;
import defpackage.fi1;
import defpackage.fo;
import defpackage.qv0;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes4.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, ff2> {
    private static final fi1 MEDIA_TYPE = fi1.g("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName(Constants.ENC_UTF_8);
    private final e63 adapter;
    private final qv0 gson;

    GsonRequestBodyConverter(qv0 qv0Var, e63 e63Var) {
        this.gson = qv0Var;
        this.adapter = e63Var;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // retrofit2.Converter
    public ff2 convert(T t) throws IOException {
        fo foVar = new fo();
        a81 a81VarL = this.gson.l(new OutputStreamWriter(foVar.k0(), UTF_8));
        this.adapter.e(a81VarL, t);
        a81VarL.close();
        return ff2.create(MEDIA_TYPE, foVar.f0());
    }
}
