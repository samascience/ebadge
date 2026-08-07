package xfkj.fitpro.api;

import android.util.Log;
import com.baji.network.WeatherApiManager;
import com.blankj.utilcode.util.GsonUtils;
import com.google.gson.reflect.TypeToken;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.dc1;
import defpackage.e33;
import defpackage.fh2;
import defpackage.fz;
import defpackage.k00;
import defpackage.kx0;
import defpackage.ph3;
import defpackage.zm1;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.Gps;
import xfkj.fitpro.model.RealStepsModel;
import xfkj.fitpro.model.sever.body.SocialLoginBody;
import xfkj.fitpro.model.sever.reponse.AdvStatus;
import xfkj.fitpro.model.sever.reponse.BaseResponse;
import xfkj.fitpro.model.sever.reponse.QueryDataReponse;
import xfkj.fitpro.model.sever.reponse.Weather2Response;
import xfkj.fitpro.model.sports.WatchSportsDataModel;
import xfkj.fitpro.model.stand.SportStandModel;
import xfkj.fitpro.ui.activities.login.LoginAndRegisterActivity;

/* JADX INFO: loaded from: classes4.dex */
public class HttpHelper {
    private static HttpHelper b;
    private final String a = HttpHelper.class.getSimpleName();

    class a implements Observer {
        a() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                RealStepsModel realStepsModel = (RealStepsModel) baseResponse.getData();
                if (realStepsModel != null) {
                    zm1.U(realStepsModel.getDistance(), realStepsModel.getStep(), realStepsModel.getCalory());
                    return;
                }
                return;
            }
            Log.e(HttpHelper.this.a, "获取实时步数失败:" + baseResponse.getError().getMessage());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Log.e(HttpHelper.this.a, "获取实时步数失败:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class b extends BlockingBaseObserver {
        b() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            List list;
            if (!baseResponse.isSuccess() || (list = (List) baseResponse.getData()) == null) {
                return;
            }
            DBHelper.saveHealthHabbitList(list);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }
    }

    class c implements Observer {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                Log.e(HttpHelper.this.a, "=====>>上传app启动状态成功");
                return;
            }
            Log.e(HttpHelper.this.a, "=====>>上传app启动状态失败:" + baseResponse.getError().toString());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Log.e(HttpHelper.this.a, "=====>>上传app启动状态异常:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e(HttpHelper.this.a, "=====>>上传app启动状态 appId:" + this.a + ";userID:" + this.b);
        }
    }

    class d implements Observer {
        d() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            AdvStatus advStatus;
            String str = HttpHelper.this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("loadAdvShowStatus response:");
            sb.append(baseResponse == null ? "empty" : baseResponse.toString());
            Log.e(str, sb.toString());
            if (baseResponse == null || !baseResponse.isSuccess() || (advStatus = (AdvStatus) baseResponse.getData()) == null) {
                return;
            }
            zm1.X(advStatus.get_$AdShow33());
            zm1.T(advStatus.getTzBlacklist());
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Log.e(HttpHelper.this.a, "loadAdvShowStatus onError:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class e implements Observer {
        e() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                List<WatchSportsDataModel> list = (List) baseResponse.getData();
                if (fz.a(list)) {
                    return;
                }
                for (WatchSportsDataModel watchSportsDataModel : list) {
                    watchSportsDataModel.setUserId(DBHelper.getUserId());
                    watchSportsDataModel.setIsUpload(true);
                    DBHelper.saveWatchSportData(watchSportsDataModel);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class f implements Observer {
        f() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                DBHelper.clearUserData();
                com.blankj.utilcode.util.a.a();
                com.blankj.utilcode.util.a.m(LoginAndRegisterActivity.class);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class g implements Observer {
        g() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                List<SportStandModel> list = (List) baseResponse.getData();
                if (fz.b(list)) {
                    for (SportStandModel sportStandModel : list) {
                        sportStandModel.setUserId(DBHelper.getUserId());
                        sportStandModel.setIsUpload(true);
                        sportStandModel.setDate(sportStandModel.getDate());
                        DBHelper.saveSportStandModel(sportStandModel);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class h implements Observer {
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            Log.i(HttpHelper.this.a, "同步设备ID状态:" + baseResponse.toString());
            if (!baseResponse.isSuccess()) {
                kx0.b(baseResponse.getError(), false);
                return;
            }
            QueryDataReponse userInfo = DBHelper.getUserInfo();
            userInfo.setDevid(this.a);
            DBHelper.updateUserInfo(userInfo);
            dc1.k();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Log.i(HttpHelper.this.a, "同步设备ID失败:" + th.getMessage());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    private ObservableTransformer f() {
        return new ObservableTransformer() { // from class: nx0
            @Override // io.reactivex.ObservableTransformer
            public final ObservableSource apply(Observable observable) {
                return this.a.n(observable);
            }
        };
    }

    public static HttpHelper g() {
        if (b == null) {
            b = new HttpHelper();
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Disposable disposable) {
        Log.i(this.a, "start accept.....");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        Log.i(this.a, "run.....");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ObservableSource n(Observable observable) {
        return observable.subscribeOn(Schedulers.io()).doOnSubscribe(new Consumer() { // from class: ox0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.a.k((Disposable) obj);
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).doAfterNext(new Consumer() { // from class: px0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                this.a.l(obj);
            }
        }).doAfterTerminate(new Action() { // from class: qx0
            @Override // io.reactivex.functions.Action
            public final void run() {
                this.a.m();
            }
        });
    }

    public void A() {
        B(new f());
    }

    public void B(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loginOut(DBHelper.getUserToken()).compose(f()).subscribe(observer);
    }

    public void C(Observer observer) {
        NetWorkManager.getInstance().getCommonService().queryMedalListOfAll(DBHelper.getUserToken(), zm1.f()).compose(f()).subscribe(observer);
    }

    public void D() {
        E(new b());
    }

    public void E(Observer observer) {
        NetWorkManager.getInstance().getCommonService().queryUserHabbitList(DBHelper.getUserToken()).compose(f()).subscribe(observer);
    }

    public void F(Observer observer) {
        NetWorkManager.getInstance().getCommonService().queryUserInfo(DBHelper.getUserToken(), DBHelper.getUserId()).compose(f()).subscribe(observer);
    }

    public void G(String str, String str2, Observer observer) {
        NetWorkManager.getInstance().getCommonService().registerOfEmail2("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e", str, str2, 2).compose(f()).subscribe(observer);
    }

    public void H(String str, Observer observer) {
        NetWorkManager.getInstance().getCommonService().resetPasswordOfEmail("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e", str).compose(f()).subscribe(observer);
    }

    public void I(SocialLoginBody socialLoginBody, Observer observer) {
        NetWorkManager.getInstance().getCommonService().socialLogin("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e", socialLoginBody.getUid(), socialLoginBody.getSocialSource(), 2, socialLoginBody.getNickname(), socialLoginBody.getSex(), socialLoginBody.getType(), socialLoginBody.getAvatar()).compose(f()).subscribe(observer);
    }

    public void J(String str) {
        K(str, new h(str));
    }

    public boolean K(String str, Observer observer) {
        if (DBHelper.isLogin() && k00.d(str)) {
            NetWorkManager.getInstance().getCommonService().updateDevid(DBHelper.getUserToken(), DBHelper.getUserId(), str).compose(f()).subscribe(observer);
            return true;
        }
        Log.i(this.a, "同步设备id不成功，没登陆或设备没变化");
        return false;
    }

    public void L(String str, Observer observer) {
        NetWorkManager.getInstance().getCommonService().uploadSleep(DBHelper.getUserToken(), str).compose(f()).subscribe(observer);
    }

    public void M(String str, Observer observer) {
        NetWorkManager.getInstance().getCommonService().uploadSteps(DBHelper.getUserToken(), str).compose(f()).subscribe(observer);
    }

    public void N(List list, Observer observer) {
        NetWorkManager.getInstance().getCommonService().saveSportsRecord(DBHelper.getUserToken(), k00.c(list)).compose(f()).subscribe(observer);
    }

    public void O(List list, Observer observer) {
        NetWorkManager.getInstance().getCommonService().uploadStand(DBHelper.getUserToken(), k00.c(list)).compose(f()).subscribe(observer);
    }

    public void h() {
        i(new a());
    }

    public void i(Observer observer) {
        NetWorkManager.getInstance().getCommonService().getRealSteps(DBHelper.getUserToken(), e33.g(new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH))).compose(f()).subscribe(observer);
    }

    public boolean j(boolean z) {
        Gps phonePosition;
        if ((z && ph3.b() != null) || (phonePosition = DBHelper.getPhonePosition()) == null) {
            return false;
        }
        WeatherApiManager.Companion.getInstance().getWeather2("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e", phonePosition.getLatitude(), phonePosition.getLongitude(), !k00.e() ? "https://mywatchc.jusonsmart.com/" : "https://mywatchi.jusonsmart.com:16443").subscribe(new Observer() { // from class: xfkj.fitpro.api.HttpHelper.5
            @Override // io.reactivex.Observer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onNext(fh2 fh2Var) {
                try {
                    BaseResponse baseResponse = (BaseResponse) GsonUtils.fromJson(fh2Var.string(), new TypeToken<BaseResponse<Weather2Response>>() { // from class: xfkj.fitpro.api.HttpHelper.5.1
                    }.getType());
                    if (baseResponse == null || !baseResponse.isSuccess()) {
                        return;
                    }
                    ph3.d((Weather2Response) baseResponse.getData());
                    ph3.e();
                    zm1.j0();
                } catch (IOException e2) {
                    Log.e(HttpHelper.this.a, "解析天气响应失败: " + e2.getMessage(), e2);
                }
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                Log.e(HttpHelper.this.a, "获取天气失败: " + th.getMessage(), th);
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }
        });
        return true;
    }

    public void o() {
        String str = "android_" + zm1.z();
        String str2 = DBHelper.getUserId() + Constants.STR_EMPTY;
        NetWorkManager.getInstance().getCommonService().launchApp("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e", str, str2).compose(f()).subscribe(new c(str, str2));
    }

    public void p() {
        NetWorkManager.getInstance().getCommonService().loadAdvShowStatus("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e").compose(f()).subscribe(new d());
    }

    public void q(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loadHeartBlood(DBHelper.getUserToken(), DBHelper.getUserInfo().getDevid()).compose(f()).subscribe(observer);
    }

    public void r(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loadHistorySport(DBHelper.getUserToken()).compose(f()).subscribe(observer);
    }

    public void s(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loadSleep(DBHelper.getUserToken(), DBHelper.getUserInfo().getDevid()).compose(f()).subscribe(observer);
    }

    public void t(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loadSteps(DBHelper.getUserToken(), DBHelper.getUserInfo().getDevid()).compose(f()).subscribe(observer);
    }

    public void u(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loadTmp(DBHelper.getUserToken(), DBHelper.getMacAddress()).compose(f()).subscribe(observer);
    }

    public void v() {
        w(new e());
    }

    public void w(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loadSportsRecord(DBHelper.getUserToken(), DBHelper.getMacAddress()).compose(f()).subscribe(observer);
    }

    public void x() {
        y(new g());
    }

    public void y(Observer observer) {
        NetWorkManager.getInstance().getCommonService().loadStandData(DBHelper.getUserToken(), DBHelper.getMacAddress()).compose(f()).subscribe(observer);
    }

    public void z(String str, String str2, Observer observer) {
        NetWorkManager.getInstance().getCommonService().loginOfEmail("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e", str, str2).compose(f()).subscribe(observer);
    }
}
