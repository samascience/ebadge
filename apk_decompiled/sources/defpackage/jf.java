package defpackage;

import android.app.Application;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClientOption;
import com.baidu.location.c;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.Gps;

/* JADX INFO: loaded from: classes4.dex */
public class jf {
    private final String a = "BaiduLocationTools";
    private c b = null;
    private a c = new a();

    private class a extends ce {
        @Override // defpackage.ce
        public void c(BDLocation bDLocation) {
            double dF = bDLocation.f();
            double dI = bDLocation.i();
            Log.i("BaiduLocationTools", "onReceiveLocation lat:" + dF + ";lon:" + dI);
            if (dF < -90.0d || dF > 90.0d || dI < -180.0d || dI > 180.0d) {
                Log.e("BaiduLocationTools", "非法定位数据");
                return;
            }
            if (dF == Double.MIN_VALUE || dI == Double.MIN_VALUE) {
                Log.e("BaiduLocationTools", "百度异常数据");
                return;
            }
            Gps gps = new Gps(bDLocation.i(), bDLocation.f());
            DBHelper.savePhonePosition(gps);
            di0.a(gps);
            jf.this.b.d0();
            jf.this.b.f0(jf.this.c);
        }

        private a() {
        }
    }

    public jf(Application application) {
        c(application);
    }

    private void c(Application application) {
        try {
            c.a0(true);
            c cVar = new c(application);
            this.b = cVar;
            cVar.Y(this.c);
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.n(LocationClientOption.LocationMode.Hight_Accuracy);
            locationClientOption.j("WGS84");
            locationClientOption.l(LocationClientOption.FirstLocType.SPEED_IN_FIRST_LOC);
            locationClientOption.q(true);
            locationClientOption.o(true);
            locationClientOption.m(false);
            locationClientOption.a(false);
            locationClientOption.s(300000);
            locationClientOption.k(false);
            locationClientOption.p(true);
            this.b.b0(locationClientOption);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        try {
            Log.e("BaiduLocationTools", "startLocation");
            this.b.c0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
