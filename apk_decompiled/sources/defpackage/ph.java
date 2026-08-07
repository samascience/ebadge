package defpackage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.tencent.connect.common.Constants;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes.dex */
public abstract class ph {
    public static String a(JavaType javaType) {
        String str;
        String str2;
        String name = javaType.getRawClass().getName();
        if (c(name)) {
            if (name.indexOf(46, 10) >= 0) {
                return null;
            }
            str = "Java 8 date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
        } else {
            if (!d(name)) {
                return null;
            }
            str = "Joda date/time";
            str2 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
        }
        return String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", str, ay.G(javaType), str2);
    }

    public static Object b(JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        Class clsB0 = ay.b0(rawClass);
        if (clsB0 != null) {
            return ay.m(clsB0);
        }
        if (javaType.isContainerType() || javaType.isReferenceType()) {
            return JsonInclude.Include.NON_EMPTY;
        }
        if (rawClass == String.class) {
            return Constants.STR_EMPTY;
        }
        if (javaType.isTypeOrSubTypeOf(Date.class)) {
            return new Date(0L);
        }
        if (!javaType.isTypeOrSubTypeOf(Calendar.class)) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(0L);
        return gregorianCalendar;
    }

    private static boolean c(String str) {
        return str.startsWith("java.time.");
    }

    private static boolean d(String str) {
        return str.startsWith("org.joda.time.");
    }
}
