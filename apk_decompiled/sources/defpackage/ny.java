package defpackage;

import com.tencent.connect.common.Constants;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
public final class ny {
    public static final ny a = new ny();

    private ny() {
    }

    public final ClockDialInfoBody a(my myVar) {
        p31.f(myVar, "sdkClockDialInfo");
        ClockDialInfoBody clockDialInfoBody = new ClockDialInfoBody();
        String strD = myVar.d();
        String str = Constants.STR_EMPTY;
        if (strD == null) {
            strD = Constants.STR_EMPTY;
        }
        clockDialInfoBody.setDevId(strD);
        String strG = myVar.g();
        if (strG == null) {
            strG = Constants.STR_EMPTY;
        }
        clockDialInfoBody.setMainModel(strG);
        String strH = myVar.h();
        if (strH == null) {
            strH = Constants.STR_EMPTY;
        }
        clockDialInfoBody.setMchModel(strH);
        clockDialInfoBody.setGrade(myVar.e());
        clockDialInfoBody.setScreenType(myVar.j());
        clockDialInfoBody.setWidth(myVar.p());
        clockDialInfoBody.setHeight(myVar.f());
        clockDialInfoBody.setConfig(myVar.b());
        clockDialInfoBody.setAlgorithm(myVar.a());
        clockDialInfoBody.setVersionCode(myVar.m());
        String strC = myVar.c();
        if (strC != null) {
            str = strC;
        }
        clockDialInfoBody.setCustomer(str);
        clockDialInfoBody.setPictureNums(myVar.i());
        clockDialInfoBody.setWatchThemeVersion(myVar.o());
        clockDialInfoBody.setWatchThemeShortPkgLenght(myVar.n());
        clockDialInfoBody.setThumbWidth(myVar.l());
        clockDialInfoBody.setThumbHeight(myVar.k());
        return clockDialInfoBody;
    }
}
