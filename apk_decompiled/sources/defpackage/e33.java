package defpackage;

import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class e33 {
    private static final ThreadLocal a = new a();
    private static final String[] b = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    private static final int[] c = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};
    private static final String[] d = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};

    class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map initialValue() {
            return new HashMap();
        }
    }

    public static long a(Date date) {
        return date.getTime();
    }

    public static String b(Date date) {
        return c(date, d());
    }

    public static String c(Date date, DateFormat dateFormat) {
        return dateFormat.format(date);
    }

    private static SimpleDateFormat d() {
        return h(DateFormatUtils.YYYY_MM_DD_HH_MM_SS);
    }

    public static Date e() {
        return new Date();
    }

    public static long f() {
        return System.currentTimeMillis();
    }

    public static String g(DateFormat dateFormat) {
        return o(System.currentTimeMillis(), dateFormat);
    }

    public static SimpleDateFormat h(String str) {
        Map map = (Map) a.get();
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str);
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static long i(long j, long j2, int i) {
        return p(j - j2, i);
    }

    public static long j(Date date, Date date2, int i) {
        return p(a(date) - a(date2), i);
    }

    public static int k(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(i);
    }

    private static long l() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static boolean m(long j) {
        long jL = l();
        return j >= jL && j < jL + 86400000;
    }

    public static boolean n(Date date) {
        return m(date.getTime());
    }

    public static String o(long j, DateFormat dateFormat) {
        return dateFormat.format(new Date(j));
    }

    private static long p(long j, int i) {
        return j / ((long) i);
    }

    public static Date q(String str, DateFormat dateFormat) {
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
