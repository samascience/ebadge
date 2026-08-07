package xfkj.fitpro.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import de.hdodenhof.circleimageview.CircleImageView;
import defpackage.bn1;
import defpackage.d20;
import defpackage.e33;
import defpackage.fz;
import defpackage.kx0;
import defpackage.ls1;
import defpackage.ls2;
import defpackage.m83;
import defpackage.ob0;
import defpackage.pv2;
import defpackage.qu0;
import defpackage.ts2;
import defpackage.x4;
import defpackage.zm1;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.base.NewBaseFragment;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.medal.Medal;
import xfkj.fitpro.model.medal.MedalList;
import xfkj.fitpro.model.sever.reponse.BaseResponse;
import xfkj.fitpro.model.sportDetails.SportDetailsModel;
import xfkj.fitpro.receiver.LeReceiver;
import xfkj.fitpro.ui.activities.common.AboutActivity;
import xfkj.fitpro.ui.activities.login.LoginAndRegisterActivity;
import xfkj.fitpro.view.RxRunTextView;

/* JADX INFO: loaded from: classes4.dex */
public class MineFragment extends NewBaseFragment {
    FrameLayout F;
    private LeReceiver G;
    private Handler H = new Handler(new Handler.Callback() { // from class: hk1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return this.a.U(message);
        }
    });
    CircleImageView j;
    RxRunTextView k;
    TextView l;
    TextView m;
    Button n;
    TextView o;
    TextView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    TextView f394q;
    View r;
    TextView s;
    View t;
    TextView u;
    TextView v;
    RecyclerView w;
    SwipeRefreshLayout x;
    TextView y;
    CardView z;

    class a implements Observer {
        a() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                kx0.a(baseResponse.getError());
                return;
            }
            DBHelper.clearUserData();
            DBHelper.clearUploadedData();
            com.blankj.utilcode.util.a.m(LoginAndRegisterActivity.class);
            com.blankj.utilcode.util.a.a();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ob0.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ob0.b();
            ToastUtils.t(R.string.network_error);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            ob0.d(((NewBaseFragment) MineFragment.this).c, R.string.logout);
        }
    }

    class b implements Observer {
        b() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            MedalList medalList;
            if (!baseResponse.isSuccess() || (medalList = (MedalList) baseResponse.getData()) == null) {
                return;
            }
            d20.k = medalList;
            MineFragment.this.c0();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            MineFragment.this.x.setRefreshing(false);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            MineFragment.this.x.setRefreshing(false);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
        }
    }

    private List Q() {
        ArrayList arrayList = new ArrayList();
        MedalList medalList = d20.k;
        if (medalList == null) {
            return arrayList;
        }
        List<Medal> stepList1 = medalList.getStepList1();
        List<Medal> sportList1 = d20.k.getSportList1();
        if (!fz.a(stepList1)) {
            arrayList.addAll(stepList1);
        }
        if (!fz.a(sportList1)) {
            arrayList.addAll(sportList1);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R() {
        if (DBHelper.isLogin()) {
            a0();
        } else {
            this.x.setRefreshing(false);
            ToastUtils.t(R.string.please_login);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view) {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean U(Message message) {
        if (message.what != 14) {
            return false;
        }
        e0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(DialogInterface dialogInterface, int i) {
        HttpHelper.g().B(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(int i, float f, int i2) {
        if (C()) {
            this.o.setText(i + Constants.STR_EMPTY);
            this.p.setText(ls1.c(Double.valueOf(m83.a((double) (f / 1000.0f))), 1, 3) + Constants.STR_EMPTY);
            this.f394q.setText(i2 + Constants.STR_EMPTY);
            this.s.setText(zm1.h() == d20.f ? "km" : "mi");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        final float distance;
        final int i;
        Date dateB = bn1.b();
        Date dateD = bn1.d(e33.e());
        Log.i(this.b, "startDate:" + e33.b(dateB));
        Log.i(this.b, "endDate:" + e33.b(dateD));
        List<SportDetailsModel> sportsDetailsByDateDurationByOrderDesc = DBHelper.getSportsDetailsByDateDurationByOrderDesc(dateB, dateD);
        final int step = 0;
        if (sportsDetailsByDateDurationByOrderDesc == null || sportsDetailsByDateDurationByOrderDesc.size() <= 0) {
            distance = 0.0f;
            i = 0;
        } else {
            distance = 0.0f;
            Date date = null;
            i = 0;
            int step2 = 0;
            for (SportDetailsModel sportDetailsModel : sportsDetailsByDateDurationByOrderDesc) {
                step += sportDetailsModel.getStep();
                distance += sportDetailsModel.getDistance();
                if (date == null) {
                    date = sportDetailsModel.getDate();
                }
                if (bn1.u(date, sportDetailsModel.getDate())) {
                    step2 += sportDetailsModel.getStep();
                } else {
                    date = sportDetailsModel.getDate();
                    step2 = sportDetailsModel.getStep();
                }
                if (i < step2) {
                    i = step2;
                }
            }
        }
        Context context = this.c;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).runOnUiThread(new Runnable() { // from class: lk1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.W(step, distance, i);
            }
        });
    }

    private void a0() {
        if (DBHelper.isLogin()) {
            HttpHelper.g().C(new b());
        }
    }

    private void b0() {
        if (DBHelper.isLogin()) {
            qu0.c(this.c, DBHelper.getUserInfo().getAvatar(), this.j);
            this.l.setText(String.format("ID: %1$d", Long.valueOf(DBHelper.getUserInfo().getId())));
            this.k.setText(DBHelper.getUserInfo().getNickname());
            if (!pv2.f(DBHelper.getUserInfo().getEmail())) {
                this.m.setVisibility(0);
                this.r.setVisibility(0);
            }
        }
        this.v.setText(getString(R.string.your_health_index, d0(ts2.e())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (!DBHelper.isLogin()) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
            this.y.setText(getString(R.string._n_medals, Integer.valueOf(fz.c(Q()))));
        }
    }

    private String d0(int i) {
        if (i >= 96) {
            return "S";
        }
        if (i >= 86 && i < 96) {
            return "A";
        }
        if (i < 76 || i > 85) {
            return (i < 61 || i > 75) ? "F" : "C";
        }
        return "B";
    }

    private void e0() {
        new Thread(new Runnable() { // from class: gk1
            @Override // java.lang.Runnable
            public final void run() {
                this.a.X();
            }
        }).start();
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void A() {
        this.x.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: ik1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                this.a.R();
            }
        });
        x(R.id.tv_about).setOnClickListener(new View.OnClickListener() { // from class: jk1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.S(view);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: kk1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.T(view);
            }
        });
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    protected void B(View view) {
        super.B(view);
        this.j = (CircleImageView) view.findViewById(R.id.circle_imageView);
        this.k = (RxRunTextView) view.findViewById(R.id.tv_user_name);
        this.l = (TextView) view.findViewById(R.id.tv_user_id);
        this.m = (TextView) view.findViewById(R.id.tv_modify_pwd);
        this.n = (Button) view.findViewById(R.id.btn_logout);
        this.o = (TextView) view.findViewById(R.id.tv_week_steps);
        this.p = (TextView) view.findViewById(R.id.week_km);
        this.f394q = (TextView) view.findViewById(R.id.tv_best_steps);
        this.r = view.findViewById(R.id.space_modify_psd);
        this.s = (TextView) view.findViewById(R.id.tv_km);
        this.t = view.findViewById(R.id.divider_wechat);
        this.u = (TextView) view.findViewById(R.id.tv_wechat);
        this.v = (TextView) view.findViewById(R.id.tv_your_health_index);
        this.w = (RecyclerView) view.findViewById(R.id.list);
        this.x = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        this.y = (TextView) view.findViewById(R.id.tv_total_count);
        this.z = (CardView) view.findViewById(R.id.card_medal);
        this.F = (FrameLayout) view.findViewById(R.id.ad_container);
    }

    public void Y() {
        if (!DBHelper.isLogin()) {
            com.blankj.utilcode.util.a.m(LoginAndRegisterActivity.class);
            return;
        }
        androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(this.c);
        aVar.t(getString(R.string.tips_txt));
        aVar.i(getString(R.string.confirm_exit_login));
        aVar.m(getString(R.string.cancel_txt), null);
        aVar.p(getString(R.string.confirm_txt), new DialogInterface.OnClickListener() { // from class: mk1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.V(dialogInterface, i);
            }
        });
        aVar.v();
    }

    public void Z() {
        com.blankj.utilcode.util.a.m(AboutActivity.class);
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void onMessageEvent(Object obj) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LeReceiver leReceiver = this.G;
        if (leReceiver != null) {
            leReceiver.b();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LeReceiver leReceiver = this.G;
        if (leReceiver != null) {
            leReceiver.a();
        }
        b0();
        e0();
        c0();
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public int y() {
        return R.layout.fragment_mine;
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void z(Bundle bundle) {
        this.G = new LeReceiver(this.c, this.H);
        this.n.setText(getString(DBHelper.isLogin() ? R.string.logout : R.string.login));
        if (zm1.d() == 0 && zm1.R()) {
            this.t.setVisibility(0);
            this.u.setVisibility(0);
        } else {
            this.t.setVisibility(8);
            this.u.setVisibility(8);
        }
        e0();
        this.w.setLayoutManager(new GridLayoutManager(this.c, 4));
        this.w.addItemDecoration(new ls2(10, 10, 10));
        if (d20.k == null) {
            a0();
        }
        try {
            x4.a(requireActivity(), this.F);
        } catch (Throwable unused) {
        }
    }
}
