package defpackage;

import com.github.victools.jsonschema.generator.SchemaKeyword;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class tp2 implements vk1 {
    private final Map a = new HashMap();
    private final Map b = new HashMap();

    public static tp2 g() {
        final tp2 tp2VarH = h();
        tp2VarH.w(LocalDate.class, "date");
        Stream.of((Object[]) new Class[]{LocalDateTime.class, ZonedDateTime.class, OffsetDateTime.class, Instant.class, Date.class, Calendar.class}).forEach(new Consumer() { // from class: qp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.w((Class) obj, "date-time");
            }
        });
        Stream.of((Object[]) new Class[]{LocalTime.class, OffsetTime.class}).forEach(new Consumer() { // from class: rp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.w((Class) obj, "time");
            }
        });
        tp2VarH.w(UUID.class, "uuid");
        tp2VarH.w(URI.class, "uri");
        tp2VarH.v(ZoneId.class);
        tp2VarH.v(Period.class);
        tp2VarH.r(BigInteger.class);
        Stream.of((Object[]) new Class[]{BigDecimal.class, Number.class}).forEach(new Consumer() { // from class: sp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.t((Class) obj);
            }
        });
        return tp2VarH;
    }

    public static tp2 h() {
        final tp2 tp2Var = new tp2();
        tp2Var.q(Object.class);
        Stream.of((Object[]) new Class[]{String.class, Character.class, Character.TYPE, CharSequence.class, Byte.class, Byte.TYPE}).forEach(new Consumer() { // from class: jp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.v((Class) obj);
            }
        });
        Stream.of((Object[]) new Class[]{Boolean.class, Boolean.TYPE}).forEach(new Consumer() { // from class: kp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.p((Class) obj);
            }
        });
        Stream.of((Object[]) new Class[]{Integer.class, Integer.TYPE}).forEach(new Consumer() { // from class: lp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.s((Class) obj, "int32");
            }
        });
        Stream.of((Object[]) new Class[]{Long.class, Long.TYPE}).forEach(new Consumer() { // from class: mp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.s((Class) obj, "int64");
            }
        });
        Stream.of((Object[]) new Class[]{Short.class, Short.TYPE}).forEach(new Consumer() { // from class: np2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.r((Class) obj);
            }
        });
        Stream.of((Object[]) new Class[]{Double.class, Double.TYPE}).forEach(new Consumer() { // from class: op2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.u((Class) obj, "double");
            }
        });
        Stream.of((Object[]) new Class[]{Float.class, Float.TYPE}).forEach(new Consumer() { // from class: pp2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.u((Class) obj, "float");
            }
        });
        return tp2Var;
    }

    private tp2 o(Class cls, SchemaKeyword schemaKeyword, String str) {
        this.a.put(cls, schemaKeyword);
        if (str != null) {
            this.b.put(cls, str);
        }
        return this;
    }

    public final tp2 p(Class cls) {
        return o(cls, SchemaKeyword.TAG_TYPE_BOOLEAN, null);
    }

    public final tp2 q(Class cls) {
        return o(cls, SchemaKeyword.TAG_TYPE_NULL, null);
    }

    public final tp2 r(Class cls) {
        return s(cls, null);
    }

    public final tp2 s(Class cls, String str) {
        return o(cls, SchemaKeyword.TAG_TYPE_INTEGER, str);
    }

    public final tp2 t(Class cls) {
        return u(cls, null);
    }

    public final tp2 u(Class cls, String str) {
        return o(cls, SchemaKeyword.TAG_TYPE_NUMBER, str);
    }

    public final tp2 v(Class cls) {
        return w(cls, null);
    }

    public final tp2 w(Class cls, String str) {
        return o(cls, SchemaKeyword.TAG_TYPE_STRING, str);
    }
}
