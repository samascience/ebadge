package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
final class et2 extends e63 {
    static final f63 b = new a();
    private final DateFormat a;

    class a implements f63 {
        a() {
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.getRawType() == Time.class) {
                return new et2(aVar);
            }
            return null;
        }
    }

    /* synthetic */ et2(a aVar) {
        this();
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Time b(a71 a71Var) throws IOException {
        Time time;
        if (a71Var.M0() == JsonToken.NULL) {
            a71Var.I0();
            return null;
        }
        String strK0 = a71Var.K0();
        try {
            synchronized (this) {
                time = new Time(this.a.parse(strK0).getTime());
            }
            return time;
        } catch (ParseException e) {
            throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as SQL Time; at path " + a71Var.g0(), e);
        }
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, Time time) throws IOException {
        String str;
        if (time == null) {
            a81Var.t0();
            return;
        }
        synchronized (this) {
            str = this.a.format((Date) time);
        }
        a81Var.P0(str);
    }

    private et2() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }
}
