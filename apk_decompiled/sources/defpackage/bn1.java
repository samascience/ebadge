package defpackage;

import androidx.room.RoomDatabase;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class bn1 {
    public static Date a(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (e33.k(date, 11) < 9) {
            date = j(date, -1);
        }
        calendar.setTime(date);
        calendar.set(11, 22);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date b() {
        return c(0);
    }

    public static Date c(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(e33.e());
        calendar.set(5, calendar.get(5) - (i * 7));
        calendar.set(5, (calendar.get(5) - e33.k(e33.e(), 7)) + 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static Date d(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) + (7 - e33.k(date, 7)));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTime();
    }

    public static int e(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(5);
    }

    public static Date f(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        return calendar.getTime();
    }

    public static Date g(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        return calendar.getTime();
    }

    public static Date h(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date i(int i) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) + i);
        return calendar.getTime();
    }

    public static Date j(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) + i);
        return calendar.getTime();
    }

    public static Date k(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, e(date));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        return calendar.getTime();
    }

    public static Date l(int i) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - i);
        return calendar.getTime();
    }

    public static SimpleDateFormat m() {
        return new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH);
    }

    public static SimpleDateFormat n() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
    }

    public static Date o(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date p(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date q(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, i);
        return calendar.getTime();
    }

    public static Date r(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (e33.k(date, 11) >= 9) {
            date = j(date, 1);
        }
        calendar.setTime(date);
        calendar.set(11, 8);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTime();
    }

    public static Date s(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, 0);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public static Date t(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(2, 11);
        calendar.set(5, e(calendar.getTime()));
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTime();
    }

    public static boolean u(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.setTime(date2);
        return i == calendar.get(1) && i2 == calendar.get(2) && i3 == calendar.get(5);
    }
}
