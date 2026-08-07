package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.h;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Opcodes;
import xfkj.fitpro.model.SettingMenuItem;
import xfkj.fitpro.service.NotifyService;
import xfkj.fitpro.ui.activities.settings.MessageSettingActivity;

/* JADX INFO: loaded from: classes4.dex */
public class nj1 extends RecyclerView.Adapter implements View.OnClickListener {
    private Context a;
    public ArrayList b;
    private b c;
    private final String d = "MessageSettingAdapter";

    class a extends RecyclerView.ViewHolder {
        private TextView a;
        private SwitchCompat b;
        private ImageView c;
        private View d;
        private View e;

        /* JADX INFO: renamed from: nj1$a$a, reason: collision with other inner class name */
        class C0146a implements PermissionUtils.b {
            final /* synthetic */ boolean a;

            C0146a(boolean z) {
                this.a = z;
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onDenied() {
                a.this.b.setChecked(false);
                ToastUtils.r(R.string.permission_refuse_tips);
                com.blankj.utilcode.util.a.n(h.b(c.f()));
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onGranted() {
                int iIntValue = ((Integer) a.this.itemView.getTag()).intValue();
                ((SettingMenuItem) nj1.this.b.get(iIntValue)).setNameInfo(this.a ? "1" : "0");
                if (nj1.this.c != null) {
                    nj1.this.c.a(null, iIntValue, this.a);
                }
            }
        }

        class b implements PermissionUtils.b {
            final /* synthetic */ boolean a;

            b(boolean z) {
                this.a = z;
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onDenied() {
                a.this.b.setChecked(false);
                ToastUtils.r(R.string.permission_refuse_tips);
                com.blankj.utilcode.util.a.n(h.b(c.f()));
            }

            @Override // com.blankj.utilcode.util.PermissionUtils.b
            public void onGranted() {
                int iIntValue = ((Integer) a.this.itemView.getTag()).intValue();
                ((SettingMenuItem) nj1.this.b.get(iIntValue)).setNameInfo(this.a ? "1" : "0");
                if (nj1.this.c != null) {
                    nj1.this.c.a(null, iIntValue, this.a);
                }
            }
        }

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.labMenuName);
            this.b = (SwitchCompat) view.findViewById(R.id.iv_status);
            this.c = (ImageView) view.findViewById(R.id.iv_Left);
            this.d = view.findViewById(R.id.hline);
            this.e = view.findViewById(R.id.tv_tips_label);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
            this.b.toggle();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(boolean z, DialogInterface dialogInterface, int i) {
            PermissionUtils.y("SMS").m(new C0146a(z)).z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(boolean z, DialogInterface dialogInterface, int i) {
            PermissionUtils.y("CONTACTS", "PHONE").m(new b(z)).z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(SettingMenuItem settingMenuItem, CompoundButton compoundButton, final boolean z) {
            int i;
            if (compoundButton.isPressed()) {
                if (d20.a != 1) {
                    Toast.makeText(hg.l(), hg.l().getString(R.string.unconnected), 0).show();
                    this.b.toggle();
                    return;
                }
                if (R.string.push_setting_txt == ((MessageSettingActivity) nj1.this.a).f0() && (i = settingMenuItem.Id) != R.string.sms_remind && i != R.string.calls_remind && !NotifyService.j(nj1.this.a)) {
                    NotifyService.n(nj1.this.a);
                    this.b.toggle();
                    return;
                }
                int i2 = settingMenuItem.Id;
                if (i2 == R.string.sms_remind || i2 == R.string.calls_remind) {
                    List listO = PermissionUtils.o();
                    androidx.appcompat.app.b.a aVar = new androidx.appcompat.app.b.a(nj1.this.a);
                    aVar.t(u73.b(R.string.warn));
                    aVar.k(R.string.cancel, new DialogInterface.OnClickListener() { // from class: kj1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            this.a.g(dialogInterface, i3);
                        }
                    });
                    int i3 = settingMenuItem.Id;
                    if (i3 == R.string.sms_remind) {
                        String strB = u73.b(R.string.sms_remind_tips);
                        if (!listO.contains("android.permission.READ_SMS") || !listO.contains("android.permission.RECEIVE_SMS")) {
                            Log.e("MessageSettingAdapter", "sms permission not exist");
                        } else if (!PermissionUtils.t("android.permission.READ_SMS", "android.permission.RECEIVE_SMS")) {
                            aVar.i(strB);
                            aVar.p(u73.b(R.string.agree), new DialogInterface.OnClickListener() { // from class: lj1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i4) {
                                    this.a.h(z, dialogInterface, i4);
                                }
                            });
                            androidx.appcompat.app.b bVarA = aVar.a();
                            bVarA.show();
                            ob0.a(bVarA);
                            return;
                        }
                    } else if (i3 == R.string.calls_remind) {
                        String strB2 = u73.b(R.string.call_remind_tips);
                        if (!listO.contains("android.permission.READ_CONTACTS") || !listO.contains("android.permission.READ_CALL_LOG")) {
                            Log.e("MessageSettingAdapter", "phone contacts permission not exist");
                        } else if (!PermissionUtils.t("android.permission.READ_CONTACTS", "android.permission.READ_CALL_LOG")) {
                            aVar.i(strB2);
                            aVar.p(u73.b(R.string.agree), new DialogInterface.OnClickListener() { // from class: mj1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i4) {
                                    this.a.i(z, dialogInterface, i4);
                                }
                            });
                            androidx.appcompat.app.b bVarA2 = aVar.a();
                            bVarA2.show();
                            ob0.a(bVarA2);
                            return;
                        }
                    }
                }
                int iIntValue = ((Integer) this.itemView.getTag()).intValue();
                ((SettingMenuItem) nj1.this.b.get(iIntValue)).setNameInfo(z ? "1" : "0");
                if (nj1.this.c != null) {
                    nj1.this.c.a(null, iIntValue, z);
                }
            }
        }

        public void k(final SettingMenuItem settingMenuItem) {
            int i = settingMenuItem.MenuType;
            if (i == 1 || i == 2) {
                this.a.setText(settingMenuItem.Name);
                if (settingMenuItem.getNameInfo().equals("1")) {
                    this.b.setChecked(true);
                } else {
                    this.b.setChecked(false);
                }
                this.c.setImageResource(settingMenuItem.BgResource);
                this.d.setVisibility(!settingMenuItem.isHasDivision ? 8 : 0);
                if (settingMenuItem.MenuType == 2) {
                    this.a.setTextColor(Opcodes.V_PREVIEW);
                }
                this.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: jj1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        this.a.j(settingMenuItem, compoundButton, z);
                    }
                });
            }
        }

        public void l(int i) {
            this.itemView.setTag(Integer.valueOf(i));
        }
    }

    public interface b {
        void a(View view, int i, boolean z);
    }

    public nj1(Context context, ArrayList arrayList) {
        this.a = context;
        this.b = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        SettingMenuItem settingMenuItem = (SettingMenuItem) this.b.get(i);
        aVar.k(settingMenuItem);
        aVar.l(i);
        aVar.e.setVisibility(8);
        int i2 = settingMenuItem.Id;
        if (i2 != R.string.calls_remind) {
            if (i2 != R.string.sms_remind) {
                if (i2 == R.string.instagram_remind) {
                    aVar.e.setVisibility(0);
                    return;
                }
                return;
            } else {
                List listO = PermissionUtils.o();
                if (listO.contains("android.permission.READ_SMS") && listO.contains("android.permission.RECEIVE_SMS") && !PermissionUtils.t("android.permission.READ_SMS", "android.permission.RECEIVE_SMS")) {
                    aVar.b.setChecked(false);
                    return;
                }
                return;
            }
        }
        if (!zm1.I()) {
            if (!PermissionUtils.o().contains("android.permission.READ_CALL_LOG") || PermissionUtils.t("android.permission.READ_CALL_LOG")) {
                return;
            }
            aVar.b.setChecked(false);
            return;
        }
        List listO2 = PermissionUtils.o();
        if (!listO2.contains("android.permission.READ_CONTACTS") || !listO2.contains("android.permission.READ_CALL_LOG")) {
            aVar.b.setChecked(true);
            aVar.b.setEnabled(false);
        } else if (!PermissionUtils.t("android.permission.READ_CONTACTS", "android.permission.READ_CALL_LOG")) {
            aVar.b.setChecked(false);
        } else {
            aVar.b.setChecked(true);
            aVar.b.setEnabled(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1 && i != 2) {
            return new a(LayoutInflater.from(this.a).inflate(R.layout.layout_list_space, viewGroup, false));
        }
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.layout_list_msg_setting, viewGroup, false);
        viewInflate.setOnClickListener(this);
        return new a(viewInflate);
    }

    public void g(b bVar) {
        this.c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return ((SettingMenuItem) this.b.get(i)).MenuType;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.a(view, ((Integer) view.getTag()).intValue(), false);
    }
}
