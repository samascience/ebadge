package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class z70 extends e63 {
    private final b a;
    private final List b;

    public static abstract class b {
        public static final b b = new a(Date.class);
        private final Class a;

        class a extends b {
            a(Class cls) {
                super(cls);
            }

            @Override // z70.b
            protected Date d(Date date) {
                return date;
            }
        }

        protected b(Class cls) {
            this.a = cls;
        }

        private f63 c(z70 z70Var) {
            return h63.b(this.a, z70Var);
        }

        public final f63 a(int i, int i2) {
            return c(new z70(this, i, i2));
        }

        public final f63 b(String str) {
            return c(new z70(this, str));
        }

        protected abstract Date d(Date date);
    }

    private Date f(a71 a71Var) throws IOException {
        String strK0 = a71Var.K0();
        synchronized (this.b) {
            try {
                Iterator it = this.b.iterator();
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
        if (a71Var.M0() == JsonToken.NULL) {
            a71Var.I0();
            return null;
        }
        return this.a.d(f(a71Var));
    }

    @Override // defpackage.e63
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void e(a81 a81Var, Date date) throws IOException {
        String str;
        if (date == null) {
            a81Var.t0();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        synchronized (this.b) {
            str = dateFormat.format(date);
        }
        a81Var.P0(str);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private z70(b bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Objects.requireNonNull(bVar);
        this.a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private z70(b bVar, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Objects.requireNonNull(bVar);
        this.a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (o41.d()) {
            arrayList.add(o42.c(i, i2));
        }
    }
}
