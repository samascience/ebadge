package xfkj.fitpro.ui.activities.device.electronicBadgeDevice;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.d;
import defpackage.b40;
import defpackage.c40;
import defpackage.d20;
import defpackage.fa1;
import defpackage.fz;
import defpackage.g02;
import defpackage.gx;
import defpackage.j4;
import defpackage.k00;
import defpackage.k83;
import defpackage.kr2;
import defpackage.lc1;
import defpackage.ls2;
import defpackage.ly2;
import defpackage.my2;
import defpackage.ng;
import defpackage.ny2;
import defpackage.ob0;
import defpackage.oy2;
import defpackage.p31;
import defpackage.pv2;
import defpackage.q2;
import defpackage.qm2;
import defpackage.ty;
import defpackage.y70;
import defpackage.zi2;
import defpackage.zm1;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.ContractModel;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.SynContractsActivity;

/* JADX INFO: loaded from: classes4.dex */
public final class SynContractsActivity extends BaseActivity<j4> {
    public static final a F = new a(null);
    private int k;
    private c40 l;
    private SwipeMenuRecyclerView m;
    private ContractModel n;
    private ContractModel o;
    private Dialog p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private EditText f401q;
    private EditText r;
    private ImageButton s;
    private TextView t;
    private String u;
    private byte[] v;
    private byte[] w;
    private byte[] x;
    private final my2 y;
    private final oy2 z;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements PermissionUtils.b {
        b() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            AppCompatActivity appCompatActivityJ = SynContractsActivity.this.J();
            p31.d(appCompatActivityJ, "null cannot be cast to non-null type android.app.Activity");
            k00.i(appCompatActivityJ);
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            SynContractsActivity.this.t0();
        }
    }

    public SynContractsActivity() {
        super(R.layout.activity_syn_contracts);
        this.k = 8;
        this.u = Constants.STR_EMPTY;
        this.y = new my2() { // from class: uy2
            @Override // defpackage.my2
            public final void a(ly2 ly2Var, ly2 ly2Var2, int i) {
                SynContractsActivity.w0(this.a, ly2Var, ly2Var2, i);
            }
        };
        this.z = new oy2() { // from class: vy2
            @Override // defpackage.oy2
            public final void a(d dVar) {
                SynContractsActivity.s0(this.a, dVar);
            }
        };
    }

    private final boolean g0(String str, String str2) {
        if (pv2.f(str)) {
            str = Constants.STR_EMPTY;
        }
        String str3 = str;
        if (pv2.f(str2)) {
            ToastUtils.t(R.string.please_input_correct_num);
            return false;
        }
        String strC = kotlin.text.i.C(str3, "_", Constants.STR_EMPTY, false, 4, null);
        String strC2 = kotlin.text.i.C(kotlin.text.i.C(str2, "_", Constants.STR_EMPTY, false, 4, null), " ", Constants.STR_EMPTY, false, 4, null);
        Charset charset = gx.b;
        byte[] bytes = strC.getBytes(charset);
        p31.e(bytes, "getBytes(...)");
        if (p0(bytes)) {
            ToastUtils.t(R.string.input_content_name_out_limit);
            return false;
        }
        byte[] bytes2 = strC2.getBytes(charset);
        p31.e(bytes2, "getBytes(...)");
        if (q0(bytes2)) {
            ToastUtils.t(R.string.input_content_phone_out_limit);
            return false;
        }
        if (o0(strC2)) {
            ToastUtils.t(R.string.already_exist_contract);
            return false;
        }
        if (!zi2.i()) {
            ToastUtils.t(R.string.unconnected);
            return true;
        }
        ob0.e(J(), R.string.setting, 15000, false);
        ContractModel contractModel = new ContractModel(zm1.f(), strC, strC2);
        this.n = contractModel;
        String contractName = contractModel.getContractName();
        ContractModel contractModel2 = this.n;
        byte[] bytes3 = (contractName + "_" + (contractModel2 != null ? contractModel2.getPhoneNumber() : null)).getBytes(charset);
        p31.e(bytes3, "getBytes(...)");
        byte[] bArrJ = qm2.J(bytes3);
        this.x = bArrJ;
        zi2.o(bArrJ, "同步联系人");
        return true;
    }

    private final void h0(String str) {
        if (!zi2.i()) {
            ToastUtils.t(R.string.unconnected);
            return;
        }
        ob0.e(J(), R.string.deletting, 15000, false);
        byte[] bytes = str.getBytes(gx.b);
        p31.e(bytes, "getBytes(...)");
        byte[] bArrC = qm2.c(bytes);
        this.w = bArrC;
        zi2.o(bArrC, "删除联系人");
    }

    private final void i0() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        if (this.p == null) {
            this.p = new Dialog(this, R.style.DialogTheme);
            View viewInflate = View.inflate(this, R.layout.layout_dialog_add_contract, null);
            Dialog dialog = this.p;
            if (dialog != null) {
                dialog.setContentView(viewInflate);
            }
            Dialog dialog2 = this.p;
            EditText editText = dialog2 != null ? (EditText) dialog2.findViewById(R.id.edt_name) : null;
            p31.c(editText);
            this.f401q = editText;
            Dialog dialog3 = this.p;
            EditText editText2 = dialog3 != null ? (EditText) dialog3.findViewById(R.id.edt_phone) : null;
            p31.c(editText2);
            this.r = editText2;
            Dialog dialog4 = this.p;
            Window window = dialog4 != null ? dialog4.getWindow() : null;
            if (window != null) {
                window.setGravity(80);
            }
            if (window != null) {
                window.setWindowAnimations(R.style.dialog_anim_style);
            }
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Dialog dialog5 = this.p;
            if (dialog5 != null && (viewFindViewById3 = dialog5.findViewById(R.id.import_contract)) != null) {
                viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: ry2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SynContractsActivity.j0(this.a, view);
                    }
                });
            }
            Dialog dialog6 = this.p;
            if (dialog6 != null && (viewFindViewById2 = dialog6.findViewById(R.id.btn_cancel)) != null) {
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: sy2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SynContractsActivity.l0(this.a, view);
                    }
                });
            }
            Dialog dialog7 = this.p;
            if (dialog7 == null || (viewFindViewById = dialog7.findViewById(R.id.btn_ok)) == null) {
                return;
            }
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: ty2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SynContractsActivity.m0(this.a, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final SynContractsActivity synContractsActivity, View view) {
        if (PermissionUtils.t("android.permission.READ_CONTACTS")) {
            synContractsActivity.t0();
        } else {
            g02.n(null, new DialogInterface.OnClickListener() { // from class: wy2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SynContractsActivity.k0(this.a, dialogInterface, i);
                }
            }, synContractsActivity.getString(R.string.import_contract), synContractsActivity.getString(R.string.contract_permission));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(SynContractsActivity synContractsActivity, DialogInterface dialogInterface, int i) {
        PermissionUtils.y("CONTACTS").m(synContractsActivity.new b()).z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(SynContractsActivity synContractsActivity, View view) {
        Dialog dialog = synContractsActivity.p;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(SynContractsActivity synContractsActivity, View view) {
        Dialog dialog;
        EditText editText = synContractsActivity.f401q;
        EditText editText2 = null;
        if (editText == null) {
            p31.t("mEditName");
            editText = null;
        }
        String string = editText.getText().toString();
        EditText editText3 = synContractsActivity.r;
        if (editText3 == null) {
            p31.t("mEditPhone");
        } else {
            editText2 = editText3;
        }
        if (!synContractsActivity.g0(string, editText2.getText().toString()) || (dialog = synContractsActivity.p) == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(SynContractsActivity synContractsActivity, View view) {
        if (synContractsActivity.r0()) {
            ToastUtils.t(R.string.contract_outlimited);
        } else {
            synContractsActivity.v0();
        }
    }

    private final boolean o0(String str) {
        c40 c40Var = this.l;
        if (c40Var == null) {
            p31.t("mAdapter");
            c40Var = null;
        }
        Iterator it = c40Var.d().iterator();
        while (it.hasNext()) {
            if (pv2.b(((ContractModel) it.next()).getPhoneNumber(), str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean p0(byte[] bArr) {
        int length = bArr.length;
        Log.i(K(), "isOutForNameBytes: " + length);
        return length > 20;
    }

    private final boolean q0(byte[] bArr) {
        int length = bArr.length;
        Log.i(K(), "isOutForNumberBytes: " + length);
        return length > 20;
    }

    private final boolean r0() {
        c40 c40Var = this.l;
        if (c40Var == null) {
            p31.t("mAdapter");
            c40Var = null;
        }
        return c40Var.d().size() >= this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(SynContractsActivity synContractsActivity, com.yanzhenjie.recyclerview.swipe.d dVar) {
        String phoneNumber;
        dVar.a();
        int iB = dVar.b();
        c40 c40Var = synContractsActivity.l;
        if (c40Var == null) {
            p31.t("mAdapter");
            c40Var = null;
        }
        ContractModel contractModel = (ContractModel) c40Var.getItem(iB);
        synContractsActivity.o = contractModel;
        if (contractModel == null || (phoneNumber = contractModel.getPhoneNumber()) == null) {
            phoneNumber = Constants.STR_EMPTY;
        }
        synContractsActivity.h0(phoneNumber);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setType("vnd.android.cursor.dir/phone_v2");
        startActivityForResult(intent, 1);
    }

    private final void v0() {
        Dialog dialog = this.p;
        if (dialog != null) {
            p31.c(dialog);
            if (dialog.isShowing()) {
                return;
            }
            EditText editText = this.f401q;
            EditText editText2 = null;
            if (editText == null) {
                p31.t("mEditName");
                editText = null;
            }
            editText.setText(Constants.STR_EMPTY);
            EditText editText3 = this.r;
            if (editText3 == null) {
                p31.t("mEditPhone");
            } else {
                editText2 = editText3;
            }
            editText2.setText(Constants.STR_EMPTY);
            Dialog dialog2 = this.p;
            p31.c(dialog2);
            dialog2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(SynContractsActivity synContractsActivity, ly2 ly2Var, ly2 ly2Var2, int i) {
        int iA = kr2.a(70.0f);
        if (fa1.b()) {
            ly2Var.a(new ny2(synContractsActivity.J()).k(R.drawable.selector_red).n(R.mipmap.equipment_fc_delete_icon).p(iA).m(-1));
        } else {
            ly2Var2.a(new ny2(synContractsActivity.J()).k(R.drawable.selector_red).n(R.mipmap.equipment_fc_delete_icon).p(iA).m(-1));
        }
    }

    private final void x0() {
        if (zi2.i()) {
            zi2.o(qm2.D(AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE), "获取联系人状态");
        } else {
            ToastUtils.t(R.string.unconnected);
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        super.N(bundle);
        this.s = (ImageButton) ((j4) I()).F.getRoot().findViewById(R.id.img_btn_right);
        this.t = (TextView) ((j4) I()).F.getRoot().findViewById(R.id.tv_finish);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        super.initData(bundle);
        setTitle(R.string.common_contacts);
        this.l = new c40(DBHelper.getContracts());
        SwipeMenuRecyclerView swipeMenuRecyclerView = ((j4) I()).z;
        this.m = swipeMenuRecyclerView;
        c40 c40Var = null;
        if (swipeMenuRecyclerView == null) {
            p31.t("mContractList");
            swipeMenuRecyclerView = null;
        }
        swipeMenuRecyclerView.setSwipeMenuCreator(this.y);
        SwipeMenuRecyclerView swipeMenuRecyclerView2 = this.m;
        if (swipeMenuRecyclerView2 == null) {
            p31.t("mContractList");
            swipeMenuRecyclerView2 = null;
        }
        swipeMenuRecyclerView2.setLayoutManager(new LinearLayoutManager(J(), 1, false));
        SwipeMenuRecyclerView swipeMenuRecyclerView3 = this.m;
        if (swipeMenuRecyclerView3 == null) {
            p31.t("mContractList");
            swipeMenuRecyclerView3 = null;
        }
        swipeMenuRecyclerView3.setSwipeMenuItemClickListener(this.z);
        SwipeMenuRecyclerView swipeMenuRecyclerView4 = this.m;
        if (swipeMenuRecyclerView4 == null) {
            p31.t("mContractList");
            swipeMenuRecyclerView4 = null;
        }
        swipeMenuRecyclerView4.addItemDecoration(new ls2(5));
        SwipeMenuRecyclerView swipeMenuRecyclerView5 = this.m;
        if (swipeMenuRecyclerView5 == null) {
            p31.t("mContractList");
            swipeMenuRecyclerView5 = null;
        }
        c40 c40Var2 = this.l;
        if (c40Var2 == null) {
            p31.t("mAdapter");
        } else {
            c40Var = c40Var2;
        }
        swipeMenuRecyclerView5.setAdapter(c40Var);
        i0();
        x0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        super.initListener();
        ImageButton imageButton = this.s;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            p31.t("mImgBtnRight");
            imageButton = null;
        }
        imageButton.setVisibility(0);
        ImageButton imageButton3 = this.s;
        if (imageButton3 == null) {
            p31.t("mImgBtnRight");
            imageButton3 = null;
        }
        imageButton3.setImageResource(R.mipmap.drwr_addt);
        ImageButton imageButton4 = this.s;
        if (imageButton4 == null) {
            p31.t("mImgBtnRight");
        } else {
            imageButton2 = imageButton4;
        }
        imageButton2.setOnClickListener(new View.OnClickListener() { // from class: qy2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SynContractsActivity.n0(this.a, view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws IOException {
        if (i == 1) {
            if (intent != null) {
                Uri data = intent.getData();
                ContentResolver contentResolver = getContentResolver();
                p31.c(data);
                Cursor cursorQuery = contentResolver.query(data, new String[]{"data1", "display_name"}, null, null, null);
                if (cursorQuery != null) {
                    Cursor cursor = cursorQuery;
                    try {
                        Cursor cursor2 = cursor;
                        if (cursor2.moveToFirst()) {
                            int columnIndex = cursor2.getColumnIndex("display_name");
                            int columnIndex2 = cursor2.getColumnIndex("data1");
                            String string = cursor2.getString(columnIndex);
                            String string2 = cursor2.getString(columnIndex2);
                            EditText editText = this.f401q;
                            if (editText == null) {
                                p31.t("mEditName");
                                editText = null;
                            }
                            if (!pv2.f(string)) {
                                p31.c(string);
                                string = kotlin.text.i.C(string, "_", Constants.STR_EMPTY, false, 4, null);
                            }
                            editText.setText(string);
                            EditText editText2 = this.r;
                            if (editText2 == null) {
                                p31.t("mEditPhone");
                                editText2 = null;
                            }
                            if (!pv2.f(string2)) {
                                p31.c(string2);
                                string2 = kotlin.text.i.C(kotlin.text.i.C(string2, "_", Constants.STR_EMPTY, false, 4, null), " ", Constants.STR_EMPTY, false, 4, null);
                            }
                            editText2.setText(string2);
                        }
                        k83 k83Var = k83.a;
                        ty.a(cursor, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            ty.a(cursor, th);
                            throw th2;
                        }
                    }
                }
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void onMessageEvents(ng ngVar) {
        String phoneNumber;
        super.onMessageEvents(ngVar);
        boolean z = ngVar instanceof b40;
        String str = Constants.STR_EMPTY;
        c40 c40Var = null;
        if (z) {
            b40 b40Var = (b40) ngVar;
            int iB = b40Var.b();
            int iA = b40Var.a();
            if (iB <= 0 && !fz.a(DBHelper.getContracts())) {
                c40 c40Var2 = this.l;
                if (c40Var2 == null) {
                    p31.t("mAdapter");
                    c40Var2 = null;
                }
                c40Var2.d().clear();
                c40 c40Var3 = this.l;
                if (c40Var3 == null) {
                    p31.t("mAdapter");
                } else {
                    c40Var = c40Var3;
                }
                c40Var.notifyDataSetChanged();
                zm1.W(Constants.STR_EMPTY);
                DBHelper.deleteAllContract();
            }
            if (iA > 0) {
                this.k = iA;
            }
            Log.e(K(), "===============>>Contract num:" + iB);
            return;
        }
        if (ngVar instanceof q2) {
            q2 q2Var = (q2) ngVar;
            if (q2Var.b(this.x)) {
                if (q2Var.c()) {
                    ToastUtils.t(R.string.set);
                    if (this.n != null) {
                        if (pv2.h(zm1.p())) {
                            ContractModel contractModel = this.n;
                            if (contractModel != null && (phoneNumber = contractModel.getPhoneNumber()) != null) {
                                str = phoneNumber;
                            }
                            zm1.W(str);
                        }
                        c40 c40Var4 = this.l;
                        if (c40Var4 == null) {
                            p31.t("mAdapter");
                            c40Var4 = null;
                        }
                        c40Var4.d().add(this.n);
                        c40 c40Var5 = this.l;
                        if (c40Var5 == null) {
                            p31.t("mAdapter");
                            c40Var5 = null;
                        }
                        c40Var5.notifyDataSetChanged();
                        DBHelper.saveContract(this.n);
                        this.n = null;
                    }
                } else {
                    ToastUtils.t(R.string.set_err);
                }
                lc1 lc1Var = d20.c;
                if (lc1Var != null) {
                    lc1Var.dismiss();
                    return;
                }
                return;
            }
            if (!q2Var.b(this.w)) {
                if (q2Var.b(this.v)) {
                    if (q2Var.c()) {
                        ToastUtils.t(R.string.set);
                        if (!pv2.h(this.u)) {
                            zm1.W(this.u);
                            c40 c40Var6 = this.l;
                            if (c40Var6 == null) {
                                p31.t("mAdapter");
                            } else {
                                c40Var = c40Var6;
                            }
                            c40Var.notifyDataSetChanged();
                        }
                    } else {
                        ToastUtils.t(R.string.set_err);
                    }
                    lc1 lc1Var2 = d20.c;
                    if (lc1Var2 != null) {
                        lc1Var2.dismiss();
                        return;
                    }
                    return;
                }
                return;
            }
            if (q2Var.c()) {
                ToastUtils.t(R.string.set);
                if (this.o != null) {
                    c40 c40Var7 = this.l;
                    if (c40Var7 == null) {
                        p31.t("mAdapter");
                        c40Var7 = null;
                    }
                    c40Var7.d().remove(this.o);
                    DBHelper.deleteContract(this.o);
                    String strP = zm1.p();
                    ContractModel contractModel2 = this.o;
                    if (pv2.b(strP, contractModel2 != null ? contractModel2.getPhoneNumber() : null)) {
                        c40 c40Var8 = this.l;
                        if (c40Var8 == null) {
                            p31.t("mAdapter");
                            c40Var8 = null;
                        }
                        if (fz.a(c40Var8.d())) {
                            zm1.W(Constants.STR_EMPTY);
                        } else {
                            c40 c40Var9 = this.l;
                            if (c40Var9 == null) {
                                p31.t("mAdapter");
                                c40Var9 = null;
                            }
                            zm1.W(((ContractModel) c40Var9.d().get(0)).getPhoneNumber());
                        }
                    }
                    c40 c40Var10 = this.l;
                    if (c40Var10 == null) {
                        p31.t("mAdapter");
                        c40Var10 = null;
                    }
                    c40Var10.notifyDataSetChanged();
                    this.o = null;
                }
            } else {
                ToastUtils.t(R.string.set_err);
            }
            lc1 lc1Var3 = d20.c;
            if (lc1Var3 != null) {
                lc1Var3.dismiss();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    public final void u0(String str) {
        p31.f(str, "phoneNumber");
        if (!zi2.i()) {
            ToastUtils.t(R.string.unconnected);
            return;
        }
        this.u = str;
        ob0.e(J(), R.string.setting, 15000, false);
        byte[] bytes = this.u.getBytes(gx.b);
        p31.e(bytes, "getBytes(...)");
        byte[] bArrY = qm2.y(bytes);
        this.v = bArrY;
        zi2.o(bArrY, "设置SOS联系人");
    }
}
