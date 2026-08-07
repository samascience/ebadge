package defpackage;

import android.app.Activity;
import android.util.Log;
import com.blankj.utilcode.util.o;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.listener.IGameGSensor;
import com.tenmeter.smlibrary.listener.IGameListItemClickListener;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.listener.IVipPayClickListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes4.dex */
public class ss0 {
    private static ss0 c;
    private final String a = "GameBodyHelper";
    private boolean b = false;

    class a implements IGameGSensor {
        a() {
        }

        @Override // com.tenmeter.smlibrary.listener.IGameGSensor
        public void closeGSensor(int i) {
            Log.i("GameBodyHelper", "closeGSensor:" + i);
        }

        @Override // com.tenmeter.smlibrary.listener.IGameGSensor
        public void closeGame() {
            Log.e("GameBodyHelper", "closeGame");
            ss0.this.b = false;
            ss0.this.k();
        }

        @Override // com.tenmeter.smlibrary.listener.IGameGSensor
        public void jsVirtualKeys(int i) {
            Log.i("GameBodyHelper", "jsVirtualKeys:" + i);
        }

        @Override // com.tenmeter.smlibrary.listener.IGameGSensor
        public void openGSensor(int i) {
            Log.i("GameBodyHelper", "openGSensor:" + i);
        }
    }

    public static ss0 f() {
        if (c == null) {
            synchronized (ss0.class) {
                try {
                    if (c == null) {
                        c = new ss0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(boolean z) {
        Log.e("GameBodyHelper", "penResult:" + z);
        if (z) {
            this.b = true;
            zi2.o(qm2.k(), "进入游戏");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(SMGameClient sMGameClient, Activity activity, SMGameInfo sMGameInfo) {
        if (zi2.i()) {
            sMGameClient.startGame(sMGameInfo, activity, new IGameOpenListener() { // from class: rs0
                @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                public final void openResult(boolean z) {
                    this.a.h(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        zi2.o(qm2.l(), "退出游戏");
    }

    public synchronized void g() {
        SMGameClient.init(o.a(), pv2.d(R.string.game_key_release), pv2.d(R.string.game_name));
        final SMGameClient sMGameClient = SMGameClient.getInstance();
        sMGameClient.setGameGSensorListener(new a());
        sMGameClient.setGameListItemClickListener(new IGameListItemClickListener() { // from class: ps0
            @Override // com.tenmeter.smlibrary.listener.IGameListItemClickListener
            public final void gameItemClick(Activity activity, SMGameInfo sMGameInfo) {
                this.a.i(sMGameClient, activity, sMGameInfo);
            }
        });
        sMGameClient.setIVipPayClickListener(new IVipPayClickListener() { // from class: qs0
            @Override // com.tenmeter.smlibrary.listener.IVipPayClickListener
            public final void startVipPay(Activity activity) {
                ss0.j(activity);
            }
        });
        di0.b(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Object obj) {
    }
}
