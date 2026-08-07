package defpackage;

import android.location.GnssNavigationMessage;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class yq3 {
    private b a;
    private long b = 0;
    private long c = 0;

    private static class a {
        private static yq3 a = new yq3();
    }

    class b extends np3 {
        private boolean k = false;
        private String l = null;
        public boolean m = false;
        public long n = 0;

        public b() {
            this.d = new HashMap();
        }

        @Override // defpackage.np3
        public void a() {
            String strF = to3.a().f();
            if (strF != null) {
                strF = strF + "&gnsst=" + this.n;
            }
            String strA = mq3.b().a(strF);
            String strReplaceAll = !TextUtils.isEmpty(strA) ? strA.trim().replaceAll("\r|\n", Constants.STR_EMPTY) : "null";
            String strA2 = mq3.b().a(this.l);
            String strReplaceAll2 = TextUtils.isEmpty(strA2) ? "null" : strA2.trim().replaceAll("\r|\n", Constants.STR_EMPTY);
            try {
                this.d.put("info", URLEncoder.encode(strReplaceAll, "utf-8"));
                this.d.put("enl", URLEncoder.encode(strReplaceAll2, "utf-8"));
            } catch (Exception unused) {
            }
        }

        @Override // defpackage.np3
        public void d(boolean z) {
            if (z && this.c != null) {
                try {
                    new JSONObject(this.c);
                    this.m = true;
                } catch (Throwable unused) {
                }
            }
            Map map = this.d;
            if (map != null) {
                map.clear();
            }
            this.k = false;
        }

        public void f(String str, long j) {
            if (this.k) {
                return;
            }
            this.k = true;
            this.l = str;
            this.n = j;
            ExecutorService executorServiceC = xq3.a().c();
            if (executorServiceC != null) {
                b(executorServiceC, "https://ofloc.map.baidu.com/locnu");
            } else {
                e("https://ofloc.map.baidu.com/locnu");
            }
        }

        public boolean g() {
            return this.k;
        }
    }

    public static yq3 a() {
        return a.a;
    }

    public void b(GnssNavigationMessage gnssNavigationMessage, long j) {
        sq3.a().b(gnssNavigationMessage, j);
        this.b = System.currentTimeMillis();
        this.c = j;
    }

    public void c() {
        ArrayList arrayListC;
        if (this.b == 0 || Math.abs(System.currentTimeMillis() - this.b) >= 20000) {
            return;
        }
        if (this.a == null) {
            this.a = new b();
        }
        b bVar = this.a;
        if (bVar == null || bVar.g() || (arrayListC = sq3.a().c()) == null || arrayListC.size() <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayListC.iterator();
        int i = 0;
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            i++;
            if (i != arrayListC.size()) {
                stringBuffer.append(";");
            }
        }
        this.a.f(stringBuffer.toString(), this.c);
    }
}
