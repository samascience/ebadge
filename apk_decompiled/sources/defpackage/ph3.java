package defpackage;

import android.util.Log;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import xfkj.fitpro.model.sever.reponse.Weather2Response;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ph3 {
    private static final String a = "ph3";
    private static Weather2Response b;

    public static byte[] a(Weather2Response weather2Response, boolean z) {
        int i = 7;
        String str = ":";
        try {
            if (weather2Response == null) {
                Log.e(a, "不存在缓存天气!");
                return null;
            }
            byte[] bArrA = new byte[0];
            String loc = weather2Response.getLoc();
            int iY = zm1.y();
            List<Weather2Response.ListDTO> list = weather2Response.getList();
            int iC = fz.c(list);
            if (iC > 0) {
                byte[] bytes = loc.getBytes(StandardCharsets.UTF_8);
                bArrA = ls1.a(bArrA, new byte[]{(byte) bytes.length}, bytes, new byte[]{(byte) iC});
                Iterator<Weather2Response.ListDTO> it = list.iterator();
                while (it.hasNext()) {
                    Weather2Response.ListDTO next = it.next();
                    Date dateQ = e33.q(next.getDay(), new SimpleDateFormat("yyyy-MM-dd"));
                    String strC = e33.c(dateQ, new SimpleDateFormat(DateFormatUtils.YYYYMMDD));
                    int iK = e33.k(dateQ, i);
                    int iIntValue = Integer.valueOf(next.getTmpMin()).intValue();
                    int iIntValue2 = Integer.valueOf(next.getTmpMax()).intValue();
                    if (iY != 0) {
                        iIntValue = m83.e(iIntValue);
                    }
                    if (iY != 0) {
                        iIntValue2 = m83.e(iIntValue2);
                    }
                    int iIntValue3 = z ? Integer.valueOf(next.getCondCodeDay()).intValue() : c(Integer.valueOf(next.getCondCodeDay()).intValue());
                    int iIntValue4 = z ? Integer.valueOf(next.getCondCodeDay()).intValue() : c(Integer.valueOf(next.getCondCodeNight()).intValue());
                    int iIntValue5 = Integer.valueOf(next.getUvIndex()).intValue();
                    int iIntValue6 = Integer.valueOf(next.getHumidity()).intValue();
                    int iIntValue7 = Integer.valueOf(next.getVis()).intValue();
                    int iIntValue8 = Integer.valueOf(next.getWindSpeedDay()).intValue();
                    int iIntValue9 = Integer.valueOf(next.getWindSpeedNight()).intValue();
                    Iterator<Weather2Response.ListDTO> it2 = it;
                    float fFloatValue = Float.valueOf(next.getPrecip()).floatValue();
                    byte[] bArr = bArrA;
                    String[] strArrSplit = next.getSunrise().split(str);
                    int iIntValue10 = (Integer.valueOf(strArrSplit[0]).intValue() * 60) + Integer.valueOf(strArrSplit[1]).intValue();
                    String[] strArrSplit2 = next.getSunset().split(str);
                    bArrA = ls1.a(bArr, pp.j(Integer.valueOf(strC).intValue()), new byte[]{(byte) iK, (byte) iIntValue, (byte) iIntValue2, (byte) iIntValue3, (byte) iIntValue4, (byte) iY, (byte) iIntValue5, (byte) iIntValue6, (byte) iIntValue7, (byte) iIntValue8, (byte) iIntValue9, (byte) fFloatValue}, pp.k((short) iIntValue10), pp.k((short) ((Integer.valueOf(strArrSplit2[0]).intValue() * 60) + Integer.valueOf(strArrSplit2[1]).intValue())));
                    it = it2;
                    i = 7;
                    str = str;
                    iY = iY;
                }
            }
            return qm2.L(bArrA);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(a, "天气错误:" + e);
            return null;
        }
    }

    public static Weather2Response b() {
        return b;
    }

    private static int c(int i) {
        if (100 == i) {
            return 1;
        }
        if (104 == i) {
            return 2;
        }
        if (101 == i || 102 == i || 103 == i) {
            return 3;
        }
        if (305 == i || 309 == i) {
            return 4;
        }
        if (306 == i || 314 == i || 399 == i) {
            return 5;
        }
        if (307 == i || 308 == i || 310 == i || 311 == i || 312 == i || 315 == i || 316 == i || 317 == i || 318 == i) {
            return 6;
        }
        if (300 == i || 301 == i || 302 == i || 303 == i) {
            return 7;
        }
        if (400 == i || 407 == i) {
            return 8;
        }
        if (401 == i || 408 == i || 499 == i) {
            return 9;
        }
        if (402 == i || 403 == i || 409 == i || 410 == i) {
            return 10;
        }
        if (404 == i || 405 == i || 406 == i) {
            return 11;
        }
        if (500 == i || 501 == i || 502 == i || 509 == i || 510 == i || 511 == i || 512 == i || 513 == i || 514 == i || 515 == i) {
            return 12;
        }
        if (304 == i || 313 == i) {
            return 13;
        }
        if (503 == i || 504 == i || 507 == i || 508 == i) {
            return 14;
        }
        if (200 == i || 201 == i || 202 == i || 203 == i || 204 == i) {
            return 15;
        }
        if (205 == i || 206 == i || 207 == i || 208 == i) {
            return 16;
        }
        if (209 == i || 210 == i || 211 == i) {
            return 17;
        }
        if (212 == i) {
            return 18;
        }
        return 231 == i ? 19 : 3;
    }

    public static void d(Weather2Response weather2Response) {
        b = weather2Response;
    }

    public static void e() {
        f(false);
    }

    public static void f(boolean z) {
        byte[] bArrA = a(b(), z);
        if (bArrA == null || !zi2.i()) {
            return;
        }
        zi2.o(bArrA, "同步天气2");
    }
}
