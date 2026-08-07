package defpackage;

import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d33 {
    public static String a() {
        return new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
    }

    public static String b() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
    }

    public static String c() {
        return new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS).format(new Date(System.currentTimeMillis()));
    }

    public static String d(String str, String str2) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS);
        Date date2 = null;
        try {
            date = simpleDateFormat.parse(str);
            try {
                date2 = simpleDateFormat.parse(str2);
            } catch (ParseException e) {
                e = e;
                e.printStackTrace();
            }
        } catch (ParseException e2) {
            e = e2;
            date = null;
        }
        long time = date2.getTime() - date.getTime();
        long j = 86400000;
        long j2 = time / j;
        Long lValueOf = Long.valueOf(j2);
        long j3 = time - (j * j2);
        long j4 = 3600000;
        long j5 = j3 / j4;
        Long lValueOf2 = Long.valueOf(j5);
        long j6 = j3 - (j4 * j5);
        long j7 = 60000;
        long j8 = j6 / j7;
        Long lValueOf3 = Long.valueOf(j8);
        long j9 = j6 - (j7 * j8);
        long j10 = 1000;
        long j11 = j9 / j10;
        Long lValueOf4 = Long.valueOf(j11);
        long j12 = j9 - (j10 * j11);
        Long lValueOf5 = Long.valueOf(j12);
        StringBuffer stringBuffer = new StringBuffer();
        if (j2 > 0) {
            stringBuffer.append(lValueOf + "天");
        }
        if (j5 > 0) {
            stringBuffer.append(lValueOf2 + "小时");
        }
        if (j8 > 0) {
            stringBuffer.append(lValueOf3 + "分");
        }
        if (j11 > 0) {
            stringBuffer.append(lValueOf4 + "秒");
        }
        if (j12 > 0) {
            stringBuffer.append(lValueOf5 + "毫秒");
        }
        return stringBuffer.toString();
    }
}
