package xfkj.fitpro.ui.activities.settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.d20;
import defpackage.hg;
import defpackage.lc1;
import defpackage.ng;
import defpackage.nj1;
import defpackage.ob0;
import defpackage.oj1;
import defpackage.pv2;
import defpackage.q3;
import defpackage.qm2;
import defpackage.rj2;
import defpackage.u73;
import defpackage.zi2;
import java.util.ArrayList;
import java.util.Map;
import xfkj.fitpro.model.SettingMenuItem;
import xfkj.fitpro.receiver.LeReceiver;

/* JADX INFO: loaded from: classes4.dex */
public class MessageSettingActivity extends BaseActivity<q3> {
    private String k;
    private ArrayList l;
    private RecyclerView m;
    private RelativeLayout n;
    private nj1 o;
    private View p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f407q;
    private int r;
    private LeReceiver s;
    private Switch t;
    private final int u;
    oj1 v;
    public Handler w;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Map map) {
            ob0.b();
            if (map.get("is_ok") == null || !map.get("is_ok").equals("0")) {
                MessageSettingActivity messageSettingActivity = MessageSettingActivity.this;
                Toast toastMakeText = Toast.makeText(messageSettingActivity, messageSettingActivity.getString(R.string.set), 0);
                toastMakeText.setGravity(17, 0, 0);
                toastMakeText.show();
                return;
            }
            MessageSettingActivity messageSettingActivity2 = MessageSettingActivity.this;
            Toast toastMakeText2 = Toast.makeText(messageSettingActivity2, messageSettingActivity2.getString(R.string.set_err), 0);
            toastMakeText2.setGravity(17, 0, 0);
            toastMakeText2.show();
            MessageSettingActivity.this.e0();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            final Map map = (Map) message.getData().getSerializable("Datas");
            int i = message.what;
            if (i == 37 || i == 40) {
                d20.d.postDelayed(new Runnable() { // from class: xfkj.fitpro.ui.activities.settings.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(map);
                    }
                }, 1000L);
                return;
            }
            if (i == 14) {
                MessageSettingActivity.this.e0();
                ob0.b();
            } else if (i == 4369) {
                MessageSettingActivity.this.p.setVisibility(8);
            }
        }
    }

    class b implements nj1.b {
        b() {
        }

        @Override // nj1.b
        public void a(View view, int i, boolean z) {
            String str;
            SettingMenuItem settingMenuItem = (SettingMenuItem) MessageSettingActivity.this.l.get(i);
            String nameInfo = settingMenuItem.getNameInfo();
            hg.b(MessageSettingActivity.this.k, "选中开关:" + settingMenuItem.Name + "--开关状态:" + nameInfo);
            if (d20.a != 1) {
                MessageSettingActivity messageSettingActivity = MessageSettingActivity.this;
                Toast.makeText(messageSettingActivity, messageSettingActivity.getString(R.string.unconnected), 0).show();
                return;
            }
            if (view == null) {
                int i2 = settingMenuItem.Id;
                if (i2 == R.string.calls_remind) {
                    str = "CALLState";
                } else if (i2 == R.string.sms_remind) {
                    str = "SMSState";
                } else if (i2 == R.string.wechat_remind) {
                    str = "WECHATState";
                } else if (i2 == R.string.qq_remind) {
                    str = "QQState";
                } else if (i2 == R.string.face_book_remind) {
                    str = "FaceBookState";
                } else if (i2 == R.string.twitter_remind) {
                    str = "TwitterState";
                } else if (i2 == R.string.skype_remind) {
                    str = "SkypeState";
                } else if (i2 == R.string.line_remind) {
                    str = "LineState";
                } else if (i2 == R.string.whatsapp_remind) {
                    str = "WhatsappState";
                } else if (i2 == R.string.instagram_remind) {
                    str = "INSTAGRAMState";
                } else if (i2 == R.string.kakao_talk_remind) {
                    str = "KakaoTalkState";
                } else if (i2 == R.string.linkdedIn) {
                    str = "linkdedInState";
                } else if (i2 == R.string.vibrate_setting) {
                    str = "SHOCKState";
                } else if (i2 == R.string.lift_screen) {
                    str = "BRIGHTState";
                } else if (i2 == R.string.sleep_monitoring) {
                    str = "SLEEPState";
                } else if (i2 == R.string.automatic_heart_rate) {
                    str = "HEARTState";
                } else {
                    str = i2 == R.string.lr_hand_wearing ? "HANDState" : Constants.STR_EMPTY;
                }
                rj2.g(str, nameInfo + Constants.STR_EMPTY);
                hg.b(MessageSettingActivity.this.k, "选中开关:" + settingMenuItem.Name + "--开关状态:" + rj2.d(str, Constants.STR_EMPTY));
                MessageSettingActivity.this.j0(str == "HANDState");
                if (pv2.a(str, "SHOCKState")) {
                    MessageSettingActivity.this.i0();
                }
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsChecked = MessageSettingActivity.this.t.isChecked();
            hg.b(MessageSettingActivity.this.k, "选中开关:HANDState--开关状态:" + (zIsChecked ? 1 : 0));
            if (d20.a == 1) {
                rj2.g("HANDState", (zIsChecked ? 1 : 0) + Constants.STR_EMPTY);
                MessageSettingActivity.this.j0(true);
                return;
            }
            MessageSettingActivity messageSettingActivity = MessageSettingActivity.this;
            Toast.makeText(messageSettingActivity, messageSettingActivity.getString(R.string.unconnected), 0).show();
            if (MessageSettingActivity.this.t.isChecked()) {
                MessageSettingActivity.this.t.setChecked(false);
            } else {
                MessageSettingActivity.this.t.setChecked(true);
            }
        }
    }

    public MessageSettingActivity() {
        super(R.layout.activity_message_setting);
        this.k = "MessageSettingActivity";
        this.f407q = Constants.STR_EMPTY;
        this.u = 4369;
        this.v = new oj1();
        this.w = new a(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        Log.i(this.k, "===============DataToUI");
        if (this.r == R.string.push_setting_txt) {
            this.n.setVisibility(8);
            ArrayList arrayList = this.l;
            if (arrayList != null && arrayList.size() != 0) {
                h0();
                return;
            }
            this.l.add(new SettingMenuItem(R.string.calls_remind, getString(R.string.calls_remind), rj2.d("CALLState", "0"), 1, R.drawable.device_switch_phone, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.sms_remind, getString(R.string.sms_remind), rj2.d("SMSState", "0"), 1, R.drawable.device_switch_sms, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.wechat_remind, getString(R.string.wechat_remind), rj2.d("WECHATState", "0"), 1, R.drawable.device_switch_wechat, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.qq_remind, getString(R.string.qq_remind), rj2.d("QQState", "0"), 1, R.drawable.device_switch_qq, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.face_book_remind, getString(R.string.face_book_remind), rj2.d("FaceBookState", "0"), 1, R.drawable.device_switch_face_book, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.twitter_remind, getString(R.string.twitter_remind), rj2.d("TwitterState", "0"), 1, R.drawable.device_switch_twitter, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.line_remind, getString(R.string.line_remind), rj2.d("LineState", "0"), 1, R.drawable.device_switch_line, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.whatsapp_remind, getString(R.string.whatsapp_remind), rj2.d("WhatsappState", "0"), 1, R.drawable.device_switch_whatsapp, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.instagram_remind, getString(R.string.instagram_remind), rj2.d("INSTAGRAMState", "0"), 1, R.drawable.device_switch_instagram, false, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.skype_remind, getString(R.string.skype_remind), rj2.d("SkypeState", "0"), 1, R.drawable.device_switch_skype, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.kakao_talk_remind, getString(R.string.kakao_talk_remind), rj2.d("KakaoTalkState", "0"), 1, R.drawable.device_switch_talk, true, 1, (Class<?>) null));
            this.l.add(new SettingMenuItem(R.string.linkdedIn, getString(R.string.linkdedIn), rj2.d("linkdedInState", "0"), 1, R.drawable.device_switch_linkedin, true, 1, (Class<?>) null));
        } else {
            String strD = rj2.d("HANDState", "0");
            hg.b(this.k, "选中开关:HANDState--开关状态:" + strD);
            this.t.setChecked(strD.equals("1"));
            ArrayList arrayList2 = this.l;
            if (arrayList2 != null && arrayList2.size() != 0) {
                String strD2 = rj2.d("SHOCKState", "0");
                SettingMenuItem settingMenuItem = (SettingMenuItem) this.l.get(0);
                if (strD2.equals(settingMenuItem.getNameInfo())) {
                    return;
                }
                settingMenuItem.setNameInfo(strD2);
                this.o.notifyDataSetChanged();
                return;
            }
            this.l.add(new SettingMenuItem(R.string.vibrate_setting, getString(R.string.vibrate_setting), rj2.d("SHOCKState", "0"), 1, R.drawable.device_switch_zhendong, false, 1, (Class<?>) null));
        }
        this.o.notifyDataSetChanged();
    }

    private void h0() {
        for (int i = 0; i < this.l.size(); i++) {
            SettingMenuItem settingMenuItem = (SettingMenuItem) this.l.get(i);
            switch (i) {
                case 0:
                    String strD = rj2.d("CALLState", "0");
                    if (!strD.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 1:
                    String strD2 = rj2.d("SMSState", "0");
                    if (!strD2.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD2);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 2:
                    String strD3 = rj2.d("WECHATState", "0");
                    if (!strD3.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD3);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 3:
                    String strD4 = rj2.d("QQState", "0");
                    if (!strD4.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD4);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 4:
                    String strD5 = rj2.d("FaceBookState", "0");
                    if (!strD5.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD5);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 5:
                    String strD6 = rj2.d("TwitterState", "0");
                    if (!strD6.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD6);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 6:
                    String strD7 = rj2.d("LineState", "0");
                    if (!strD7.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD7);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 7:
                    String strD8 = rj2.d("WhatsappState", "0");
                    if (!strD8.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD8);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 8:
                    String strD9 = rj2.d("INSTAGRAMState", "0");
                    if (!strD9.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD9);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 9:
                    String strD10 = rj2.d("SkypeState", "0");
                    if (!strD10.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD10);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 10:
                    String strD11 = rj2.d("KakaoTalkState", "0");
                    if (!strD11.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD11);
                        this.o.notifyItemChanged(i);
                    }
                    break;
                case 11:
                    String strD12 = rj2.d("linkdedInState", "0");
                    if (!strD12.equals(settingMenuItem.getNameInfo())) {
                        settingMenuItem.setNameInfo(strD12);
                        this.o.notifyItemChanged(i);
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        if (rj2.c("screen_status", 0) == 1) {
            zi2.o(qm2.b(true, 480, 1320), "设置抬腕亮屏");
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        byte b2;
        this.m = (RecyclerView) findViewById(R.id.rlv);
        this.t = (Switch) findViewById(R.id.hand_status);
        this.l = new ArrayList();
        this.n = (RelativeLayout) findViewById(R.id.hand_lr_box);
        this.p = findViewById(R.id.frm_loadding);
        nj1 nj1Var = new nj1(this, this.l);
        this.o = nj1Var;
        nj1Var.g(new b());
        this.m.setLayoutManager(new LinearLayoutManager(this));
        this.m.setAdapter(this.o);
        e0();
        if (this.r == R.string.push_setting_txt) {
            this.w.postDelayed(new Runnable() { // from class: ij1
                @Override // java.lang.Runnable
                public final void run() {
                    hg.B();
                }
            }, 1000L);
            b2 = 4;
        } else {
            b2 = 6;
        }
        if (d20.a == 1) {
            zi2.o(qm2.D(b2), "获取个人信息");
        }
        this.w.sendEmptyMessageDelayed(4369, 2000L);
    }

    public int f0() {
        return this.r;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        super.initListener();
        this.t.setOnClickListener(new c());
    }

    public void j0(boolean z) {
        if (d20.a != 1) {
            Toast.makeText(this, getString(R.string.unconnected), 0).show();
            return;
        }
        d20.c = new lc1.a(this).e(getString(R.string.setting)).d(false).b(true, 5000);
        if (pv2.a(this.f407q, u73.b(R.string.push_setting_txt))) {
            zi2.o(qm2.A(this.v), "设置消息推送开关");
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.w.removeMessages(4369);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void onMessageEvents(ng ngVar) {
        super.onMessageEvents(ngVar);
        if (ngVar instanceof oj1) {
            this.v = (oj1) ngVar;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LeReceiver leReceiver = this.s;
        if (leReceiver != null) {
            leReceiver.b();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LeReceiver leReceiver = this.s;
        if (leReceiver != null) {
            leReceiver.a();
        }
    }
}
