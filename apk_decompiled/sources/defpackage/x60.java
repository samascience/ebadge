package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class x60 extends e63 {
    public static final f63 b = new a();
    private final List a;

    class a implements f63 {
        a() {
        }

        @Override // defpackage.f63
        public e63 a(qv0 qv0Var, TypeToken typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new x60();
            }
            return null;
        }
    }

    public x60() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (o41.d()) {
            arrayList.add(o42.c(2, 2));
        }
    }

    private Date f(a71 a71Var) throws IOException {
        String strK0 = a71Var.K0();
        synchronized (this.a) {
            try {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(strK0);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return qy0.c(strK0, new ParsePosition(0));
                } catch (ParseException e) {
                    throw new JsonSyntaxException("Failed parsing '" + strK0 + "' as Date; at path " + a71Var.g0(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Date b(a71 a71Var) throws IOException {
        if (a71Var.M0() != JsonToken.NULL) {
            return f(a71Var);
        }
        a71Var.I0();
        return null;
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, Date date) throws IOException {
        String str;
        if (date == null) {
            a81Var.t0();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.a.get(0);
        synchronized (this.a) {
            str = dateFormat.format(date);
        }
        a81Var.P0(str);
    }
}
