package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes3.dex */
final class dt2 extends e63 {
    static final f63 b = new a();
    private final DateFormat a;

    class a implements f63 {
        a() {
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() == Date.class) {
                return new dt2(aVar);
            }
            return null;
        }
    }

    /* synthetic */ dt2(a aVar) {
        this();
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(a71 a71Var) throws IOException {
        java.util.Date date;
        if (a71Var.M0() == JsonToken.NULL) {
            a71Var.I0();
            return null;
        }
        String strK0 = a71Var.K0();
        try {
            synchronized (this) {
                date = this.a.parse(strK0);
            }
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as SQL Date; at path " + a71Var.g0(), e);
        }
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, Date date) throws IOException {
        String str;
        if (date == null) {
            a81Var.t0();
            return;
        }
        synchronized (this) {
            str = this.a.format((java.util.Date) date);
        }
        a81Var.P0(str);
    }

    private dt2() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }
}
