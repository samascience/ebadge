package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.eum.LoginType;
import xfkj.fitpro.model.TempModel;
import xfkj.fitpro.model.motion.PathRecord;
import xfkj.fitpro.model.sever.body.SocialLoginBody;
import xfkj.fitpro.model.sever.reponse.BaseResponse;
import xfkj.fitpro.model.sever.reponse.LoginResponse;
import xfkj.fitpro.model.sever.reponse.QueryDataReponse;
import xfkj.fitpro.model.sports.WatchSportsDataModel;
import xfkj.fitpro.model.stand.SportStandModel;

/* JADX INFO: loaded from: classes4.dex */
public class td1 {
    private static td1 d;
    private Context b;
    private final String a = "LoginHelper";
    Observer c = new a();

    class a implements Observer {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            td1.this.D();
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            com.blankj.utilcode.util.j.t("LoginHelper", "Request success");
            LoginResponse loginResponse = (LoginResponse) baseResponse.getData();
            if (!baseResponse.isSuccess()) {
                Log.e("LoginHelper", "login error:" + baseResponse.getError().getMessage());
                kx0.a(baseResponse.getError());
                return;
            }
            if (loginResponse == null || loginResponse.getSession() == null || loginResponse.getUser() == null) {
                td1.this.x("login response is null");
            } else {
                DBHelper.saveUserLoginInfo(loginResponse);
                new Handler().postDelayed(new Runnable() { // from class: sd1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                }, 200L);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ob0.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Log.e("LoginHelper", "登陆本地服务器错误:" + th.toString());
            ToastUtils.u(th.toString());
            DBHelper.clearUserData();
            ob0.b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class b implements Observer {
        b() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                td1.this.x("load ring steps data error:" + baseResponse.getError().toString());
                return;
            }
            QueryDataReponse queryDataReponse = (QueryDataReponse) baseResponse.getData();
            if (queryDataReponse == null) {
                td1.this.p();
                return;
            }
            DBHelper.saveUserInfo(queryDataReponse);
            HttpHelper.g().D();
            if (HttpHelper.g().K(zm1.f(), new j())) {
                Log.e("LoginHelper", "本地设备ID和服务器设备ID不匹配");
            } else {
                if (pv2.f(queryDataReponse.getDevid())) {
                    td1.this.q();
                    return;
                }
                if (pv2.f(zm1.f())) {
                    zm1.b0(queryDataReponse.getDevid());
                }
                td1.this.r();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            td1.this.x("load ring steps data error:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e("LoginHelper", "开始加载用户数据");
        }
    }

    class c implements Observer {
        c() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                td1.this.x("load ring steps data error:" + baseResponse.getError().getMessage());
                return;
            }
            List list = (List) baseResponse.getData();
            DBHelper.saveHttpMeasureValue(list);
            StringBuilder sb = new StringBuilder();
            sb.append("血压数据数量:");
            sb.append(list == null ? 0 : list.size());
            Log.e("LoginHelper", sb.toString());
            td1.this.u();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            td1.this.x("load ring steps data error:" + th.getMessage());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e("LoginHelper", "开始加载心率血压");
        }
    }

    class d implements Observer {
        d() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                td1.this.x("load ring steps data error:" + baseResponse.getError().getMessage());
                return;
            }
            List list = (List) baseResponse.getData();
            DBHelper.saveHttpDetailsSport(list);
            StringBuilder sb = new StringBuilder();
            sb.append("运动数据数量:");
            sb.append(list == null ? 0 : list.size());
            Log.e("LoginHelper", sb.toString());
            td1.this.t();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            td1.this.x("load ring steps data error:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e("LoginHelper", "开始加载运动数据");
        }
    }

    class e implements Observer {
        e() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                td1.this.x("sleep data load error:" + baseResponse.getError().getMessage());
                return;
            }
            List list = (List) baseResponse.getData();
            DBHelper.saveHttpSleepDetailsDatas(list);
            StringBuilder sb = new StringBuilder();
            sb.append("睡眠数据数量:");
            sb.append(list == null ? 0 : list.size());
            Log.e("LoginHelper", sb.toString());
            td1.this.s();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            td1.this.x("sleep data load error:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e("LoginHelper", "开始加载睡眠数据");
        }
    }

    class f implements Observer {
        f() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                td1.this.x("sport data load error:" + baseResponse.getError().toString());
                return;
            }
            List<PathRecord> list = (List) baseResponse.getData();
            if (list != null && list.size() > 0) {
                for (PathRecord pathRecord : list) {
                    pathRecord.setUserId(DBHelper.getUserId());
                    DBHelper.saveHttpSportRecordAndTracks(pathRecord);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("运动数据数量:");
            sb.append(list == null ? 0 : list.size());
            Log.e("LoginHelper", sb.toString());
            td1.this.v();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            td1.this.x("sport data load error:" + th.toString());
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
            if (!baseResponse.isSuccess()) {
                td1.this.x("sport data load error:" + baseResponse.getError().toString());
                return;
            }
            List<SportStandModel> list = (List) baseResponse.getData();
            if (fz.b(list)) {
                for (SportStandModel sportStandModel : list) {
                    sportStandModel.setUserId(DBHelper.getUserId());
                    sportStandModel.setIsUpload(true);
                    sportStandModel.setDate(sportStandModel.getDate());
                    DBHelper.saveSportStandModel(sportStandModel);
                }
            }
            td1.this.w();
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
        h() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                td1.this.x("watch sports error:" + baseResponse.getError().toString());
                return;
            }
            List<WatchSportsDataModel> list = (List) baseResponse.getData();
            if (!fz.a(list)) {
                for (WatchSportsDataModel watchSportsDataModel : list) {
                    watchSportsDataModel.setUserId(DBHelper.getUserId());
                    watchSportsDataModel.setIsUpload(true);
                    DBHelper.saveWatchSportData(watchSportsDataModel);
                }
            }
            Log.e("LoginHelper", "设备端多运动数据个数:" + fz.c(list));
            if (zm1.P()) {
                td1.this.o();
            } else {
                td1.this.q();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            td1.this.x("watch sports error:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class i implements Observer {
        i() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                Log.e("LoginHelper", "load temp data error;" + baseResponse.getError().toString());
                return;
            }
            List list = (List) baseResponse.getData();
            Log.e("LoginHelper", "load temp data ok; size:" + list.size());
            DBHelper.saveTemp((List<TempModel>) list);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            td1.this.q();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            td1.this.x("load temp data onError:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    private class j implements Observer {
        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                DBHelper.clearUserData();
                kx0.a(baseResponse.getError());
                ob0.b();
            } else {
                QueryDataReponse userInfo = DBHelper.getUserInfo();
                userInfo.setDevid(zm1.f());
                DBHelper.updateUserInfo(userInfo);
                td1.this.r();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Log.e("LoginHelper", "上传deviceId失败:" + th.toString());
            ToastUtils.t(R.string.login_failed);
            DBHelper.clearUserData();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }

        private j() {
        }
    }

    protected class k implements UMAuthListener {
        SocialLoginBody a = new SocialLoginBody();

        public k() {
        }

        private void a(Map map) {
            this.a.setUid((String) map.get("uid"));
            this.a.setNickname((String) map.get("name"));
            this.a.setSex(0);
            this.a.setAvatar((String) map.get("iconurl"));
            this.a.setType(1);
            this.a.setSocialSource(Constants.VIA_TO_TYPE_QZONE);
        }

        private void b(Map map) {
            this.a.setNickname((String) map.get("name"));
            this.a.setSex((map.get("gender") == null || !((String) map.get("gender")).equals("女")) ? 0 : 1);
            this.a.setAvatar((String) map.get("iconurl"));
            this.a.setUid((String) map.get("openid"));
            this.a.setType(0);
            this.a.setSocialSource("1");
        }

        private void c(Map map) {
            this.a.setUid((String) map.get("uid"));
            this.a.setSocialSource("2");
            this.a.setNickname((String) map.get("name"));
            this.a.setSex((map.get("gender") == null || !((String) map.get("gender")).equals("女")) ? 0 : 1);
            this.a.setType(0);
            this.a.setAvatar((String) map.get("iconurl"));
        }

        private void d(Map map) {
            this.a.setUid((String) map.get("uid"));
            this.a.setSocialSource("3");
            this.a.setNickname((String) map.get("name"));
            this.a.setSex((map.get("gender") == null || !((String) map.get("gender")).equals("女")) ? 0 : 1);
            this.a.setType(0);
            this.a.setAvatar((String) map.get("iconurl"));
        }

        public void onCancel(SHARE_MEDIA share_media, int i) {
            td1.this.x(pv2.d(R.string.login_cancel));
        }

        public void onComplete(SHARE_MEDIA share_media, int i, Map map) {
            Log.e("LoginHelper", "social login complete....");
            j83.b(share_media);
            SHARE_MEDIA share_media2 = share_media.toSnsPlatform().mPlatform;
            if (share_media2 == SHARE_MEDIA.SINA) {
                d(map);
            } else if (share_media2 == SHARE_MEDIA.QQ) {
                c(map);
            } else if (share_media2 == SHARE_MEDIA.WEIXIN) {
                b(map);
            } else if (share_media2 == SHARE_MEDIA.FACEBOOK) {
                a(map);
            } else if (share_media2 == SHARE_MEDIA.TWITTER) {
                this.a = null;
            } else {
                this.a = null;
            }
            SocialLoginBody socialLoginBody = this.a;
            if (socialLoginBody != null) {
                td1.this.n(socialLoginBody);
            } else {
                td1.this.x("Social Body is null");
            }
        }

        public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
            td1.this.x(th.toString());
        }

        public void onStart(SHARE_MEDIA share_media) {
            ob0.d(td1.this.b, R.string.loginning);
        }
    }

    private void C() {
        DBHelper.clearUserData();
        DBHelper.clearUploadedData();
        ob0.b();
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        ob0.d(this.b, R.string.loadding_data);
        HttpHelper.g().F(new b());
    }

    public static td1 m() {
        if (d == null) {
            d = new td1();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        HttpHelper.g().u(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        C();
        ToastUtils.t(R.string.loading_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        com.blankj.utilcode.util.a.a();
        k00.j();
        ob0.b();
        Log.e("LoginHelper", "数据加载完成，login success");
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        HttpHelper.g().q(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        HttpHelper.g().r(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        HttpHelper.g().s(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        HttpHelper.g().t(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        HttpHelper.g().y(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        HttpHelper.g().w(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str) {
        Log.i("LoginHelper", "exceptionInfo:" + str);
        ToastUtils.s(str);
        C();
    }

    public void A(Activity activity) {
        if (!com.blankj.utilcode.util.c.l("com.tencent.mobileqq")) {
            ToastUtils.t(R.string.app_no_install);
        } else {
            this.b = activity;
            j83.c(activity, LoginType.QQ, new k());
        }
    }

    public void B(Activity activity) {
        if (!com.blankj.utilcode.util.c.l("com.tencent.mm")) {
            ToastUtils.t(R.string.app_no_install);
        } else {
            this.b = activity;
            j83.c(activity, LoginType.WEIXIN, new k());
        }
    }

    public synchronized void n(SocialLoginBody socialLoginBody) {
        HttpHelper.g().I(socialLoginBody, this.c);
    }

    public void y(String str, String str2, Activity activity) {
        this.b = activity;
        ob0.d(activity, R.string.loginning);
        HttpHelper.g().z(str, str2, this.c);
    }

    public void z(Activity activity) {
        this.b = activity;
    }
}
