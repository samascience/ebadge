package defpackage;

import android.util.Log;
import com.blankj.utilcode.util.j;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.sever.reponse.BaseResponse;

/* JADX INFO: loaded from: classes4.dex */
public abstract class dc1 {
    private static final String a = "dc1";

    class a implements Observer {
        a() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                dc1.f();
                Log.e(dc1.a, "心率血压加载失败:" + baseResponse.getError().getMessage());
                return;
            }
            List list = (List) baseResponse.getData();
            DBHelper.saveHttpMeasureValue(list);
            String str = dc1.a;
            StringBuilder sb = new StringBuilder();
            sb.append("血压数据数量:");
            sb.append(list == null ? 0 : list.size());
            Log.e(str, sb.toString());
            dc1.j();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dc1.f();
            Log.e(dc1.a, "心率血压加载失败");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e(dc1.a, "开始加载心率血压");
        }
    }

    class b implements Observer {
        b() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                dc1.f();
                Log.e(dc1.a, "运动数据加载失败:" + baseResponse.getError().getMessage());
                return;
            }
            List list = (List) baseResponse.getData();
            DBHelper.saveHttpDetailsSport(list);
            String str = dc1.a;
            StringBuilder sb = new StringBuilder();
            sb.append("运动数据数量:");
            sb.append(list == null ? 0 : list.size());
            Log.e(str, sb.toString());
            dc1.i();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dc1.f();
            Log.e(dc1.a, "运动数据加载失败:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e(dc1.a, "开始加载运动数据");
        }
    }

    class c implements Observer {
        c() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                dc1.f();
                Log.e(dc1.a, "睡眠数据加载失败:" + baseResponse.getError().getMessage());
                return;
            }
            List list = (List) baseResponse.getData();
            DBHelper.saveHttpSleepDetailsDatas(list);
            String str = dc1.a;
            StringBuilder sb = new StringBuilder();
            sb.append("睡眠数据数量:");
            sb.append(list == null ? 0 : list.size());
            Log.e(str, sb.toString());
            dc1.g();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dc1.f();
            Log.e(dc1.a, "睡眠数据加载失败:" + th.toString());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Log.e(dc1.a, "开始加载睡眠数据");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        ob0.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        HttpHelper.g().x();
        HttpHelper.g().v();
        ob0.b();
    }

    private static void h() {
        if (DBHelper.isLogin()) {
            HttpHelper.g().q(new a());
        } else {
            j.j(a, "没登录");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        if (DBHelper.isLogin()) {
            HttpHelper.g().s(new c());
        } else {
            j.j(a, "没登录");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        if (DBHelper.isLogin()) {
            HttpHelper.g().t(new b());
        } else {
            j.j(a, "没登录");
        }
    }

    public static void k() {
        h();
    }
}
