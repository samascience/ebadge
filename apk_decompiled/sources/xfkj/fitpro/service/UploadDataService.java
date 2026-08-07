package xfkj.fitpro.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.blankj.utilcode.util.k;
import defpackage.fz;
import defpackage.rv0;
import defpackage.vr1;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.SleepDetailsModel;
import xfkj.fitpro.model.sever.reponse.BaseResponse;
import xfkj.fitpro.model.sportDetails.SportDetailsModel;
import xfkj.fitpro.model.sports.WatchSportsDataModel;
import xfkj.fitpro.model.stand.SportStandModel;

/* JADX INFO: loaded from: classes4.dex */
public class UploadDataService extends Service {
    private final String a = UploadDataService.class.getSimpleName();

    class a implements Observer {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                for (SportDetailsModel sportDetailsModel : this.a) {
                    Log.e(UploadDataService.this.a, "aaa:" + sportDetailsModel.toString());
                    sportDetailsModel.setUserId(DBHelper.getUserId());
                    sportDetailsModel.setIsUpload(true);
                    DBHelper.updateDetailsSport(sportDetailsModel);
                }
                Log.i(UploadDataService.this.a, "同步步数成功");
            }
            UploadDataService.this.k();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Log.i(UploadDataService.this.a, "同步步数失败:" + th.toString());
            UploadDataService.this.k();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.i(UploadDataService.this.a, "xxxxxxxxxxx上传历史步数");
        }
    }

    class b implements Observer {
        final /* synthetic */ List a;

        b(List list) {
            this.a = list;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                for (SleepDetailsModel sleepDetailsModel : this.a) {
                    sleepDetailsModel.setUserId(DBHelper.getUserId());
                    sleepDetailsModel.setIsUpload(true);
                    DBHelper.updateSleepDetailsDatas(sleepDetailsModel);
                }
                Log.i(UploadDataService.this.a, "同步历史睡眠成功");
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UploadDataService.this.l();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UploadDataService.this.l();
            Log.i(UploadDataService.this.a, "同步睡眠失败:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.i(UploadDataService.this.a, "正在上传历史睡眠");
        }
    }

    class c implements Observer {
        final /* synthetic */ List a;

        c(List list) {
            this.a = list;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            for (SportStandModel sportStandModel : this.a) {
                sportStandModel.setUserId(DBHelper.getUserId());
                DBHelper.saveSportStandModel(sportStandModel);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UploadDataService.this.n();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UploadDataService.this.n();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    class d implements Observer {
        final /* synthetic */ List a;

        d(List list) {
            this.a = list;
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (baseResponse.isSuccess()) {
                for (WatchSportsDataModel watchSportsDataModel : this.a) {
                    watchSportsDataModel.setUserId(DBHelper.getUserId());
                    watchSportsDataModel.setIsUpload(true);
                    DBHelper.updateWatchSportData(watchSportsDataModel);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UploadDataService.this.h();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UploadDataService.this.h();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    private String g(Object obj) {
        return new rv0().g("yyyyMMddHHmmss").c().toJson(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Log.i(this.a, "同步数据完成");
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        stopSelf();
    }

    private void j() {
        Notification notificationA = new vr1(this).a();
        if (Build.VERSION.SDK_INT >= 34) {
            startForeground(54880, notificationA, 2048);
        } else {
            startForeground(54880, notificationA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        List<SleepDetailsModel> noUploadSleepDetails = DBHelper.getNoUploadSleepDetails(100);
        if (!fz.a(noUploadSleepDetails)) {
            HttpHelper.g().L(g(noUploadSleepDetails), new b(noUploadSleepDetails));
        } else {
            Log.i(this.a, "没有需要上传的历史睡眠");
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!DBHelper.isLogin()) {
            Log.i(this.a, "not login, not upload stand data");
            return;
        }
        List<SportStandModel> noUploadSportStandModelModels = DBHelper.getNoUploadSportStandModelModels();
        if (fz.b(noUploadSportStandModelModels)) {
            HttpHelper.g().O(noUploadSportStandModelModels, new c(noUploadSportStandModelModels));
        } else {
            n();
        }
    }

    private void m() {
        List<SportDetailsModel> noUploadSportsDetails = DBHelper.getNoUploadSportsDetails(100);
        if (!fz.a(noUploadSportsDetails)) {
            HttpHelper.g().M(g(noUploadSportsDetails), new a(noUploadSportsDetails));
        } else {
            Log.i(this.a, "没有需要上传的历史步数");
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        List<WatchSportsDataModel> noUploadWatchSportsData = DBHelper.getNoUploadWatchSportsData(100);
        if (!fz.a(noUploadWatchSportsData)) {
            HttpHelper.g().N(noUploadWatchSportsData, new d(noUploadWatchSportsData));
        } else {
            Log.i(this.a, "not found watch sports data");
            h();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.i(this.a, "start upload data to server");
        j();
        if (DBHelper.getUserInfo() == null) {
            new Handler().postDelayed(new Runnable() { // from class: w93
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i();
                }
            }, 100L);
            return;
        }
        Log.i(this.a, "deviceId1:" + DBHelper.getUserInfo().getDevid());
        Log.i(this.a, "deviceId2:" + DBHelper.getMacAddress());
        m();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        k.a(54880);
    }
}
