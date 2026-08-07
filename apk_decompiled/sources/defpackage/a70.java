package defpackage;

import com.tencent.connect.common.Constants;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a70 {
    public static Map a() {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        String str;
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        int i4 = calendar.get(11);
        int i5 = calendar.get(12);
        int i6 = calendar.get(13);
        if (i2 < 10) {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(i2);
            sb.append(Constants.STR_EMPTY);
        }
        String string = sb.toString();
        if (i3 < 10) {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(i3);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i3);
            sb2.append(Constants.STR_EMPTY);
        }
        String string2 = sb2.toString();
        if (i4 < 10) {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(i4);
        } else {
            sb3 = new StringBuilder();
            sb3.append(i4);
            sb3.append(Constants.STR_EMPTY);
        }
        String string3 = sb3.toString();
        if (i5 < 10) {
            sb4 = new StringBuilder();
            sb4.append("0");
            sb4.append(i5);
        } else {
            sb4 = new StringBuilder();
            sb4.append(i5);
            sb4.append(Constants.STR_EMPTY);
        }
        String string4 = sb4.toString();
        if (i6 < 10) {
            str = "0" + i6;
        } else {
            str = i6 + Constants.STR_EMPTY;
        }
        HashMap map = new HashMap();
        map.put("year", Integer.valueOf(i));
        map.put("month", string);
        map.put("day", string2);
        map.put("hour", string3);
        map.put("minute", string4);
        map.put("second", str);
        map.put("date", i + "-" + string + "-" + string2);
        return map;
    }
}
