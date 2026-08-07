package com.onmicro.omtoolbox.dfu;

import android.app.LoaderManager;
import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;
import com.google.gson.reflect.TypeToken;
import com.onmicro.omtoolbox.BaseActivity;
import com.onmicro.omtoolbox.R$drawable;
import com.onmicro.omtoolbox.R$id;
import com.onmicro.omtoolbox.R$layout;
import com.onmicro.omtoolbox.R$string;
import com.onmicro.omtoolbox.scanner.ScannerFragment;
import defpackage.e43;
import defpackage.ed1;
import defpackage.h9;
import defpackage.hj2;
import defpackage.jm0;
import defpackage.m50;
import defpackage.o33;
import defpackage.on0;
import defpackage.pc0;
import defpackage.pj0;
import defpackage.qv0;
import java.io.File;
import java.util.List;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuBaseService;
import no.nordicsemi.android.dfu.DfuProgressListener;
import no.nordicsemi.android.dfu.DfuProgressListenerAdapter;
import no.nordicsemi.android.dfu.DfuServiceInitiator;
import no.nordicsemi.android.dfu.DfuServiceListenerHelper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DfuAppActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener, ScannerFragment.b, LoaderManager.LoaderCallbacks<Cursor> {
    private boolean F;
    private String G;
    private boolean H;
    private List L;
    protected List M;
    private File N;
    Toolbar c;
    TextView d;
    TextView e;
    RadioButton f;
    RelativeLayout g;
    EditText h;
    Button i;
    RelativeLayout j;
    ImageView k;
    TextView l;
    RadioButton m;
    TableLayout n;
    TextView o;
    TextView p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    TextView f303q;
    Button r;
    Button s;
    ProgressBar t;
    TextView u;
    private BluetoothDevice v;
    private String w;
    private Uri x;
    private boolean y;
    private boolean z;
    private final String a = "APP";
    private final String b = "UI";
    private int I = -60;
    private int J = 1;
    private String K = "6621D";
    private final DfuProgressListener O = new c();

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            DfuAppActivity.N(DfuAppActivity.this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ TextView a;

        b(TextView textView) {
            this.a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            this.a.setText(String.format(Locale.ROOT, "%ddBm", Integer.valueOf(i * (-1))));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class c extends DfuProgressListenerAdapter {
        c() {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceConnecting(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDeviceDisconnecting(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuAborted(String str) {
            DfuAppActivity.this.s.setText(R$string.dfu_status_fialed);
            DfuAppActivity.this.s.setClickable(true);
            DfuAppActivity.this.S();
            DfuAppActivity.this.otaUpdateFailed();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuCompleted(String str) {
            DfuAppActivity.this.s.setText(R$string.dfu_status_successed);
            DfuAppActivity.this.s.setClickable(true);
            DfuAppActivity.this.S();
            DfuAppActivity dfuAppActivity = DfuAppActivity.this;
            dfuAppActivity.M.remove(dfuAppActivity.N);
            if (DfuAppActivity.this.M.isEmpty()) {
                DfuAppActivity.this.otaUpdateSucess();
            } else {
                DfuAppActivity.this.h0();
                DfuAppActivity.this.m0();
            }
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onDfuProcessStarting(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onEnablingDfuMode(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onError(String str, int i, int i2, String str2) {
            ed1.b("DfuActivity", "onError:" + i);
            DfuAppActivity.this.s.setText(R$string.dfu_status_fialed);
            DfuAppActivity.this.s.setClickable(true);
            o33.b(DfuAppActivity.this, "升级失败：" + str2);
            DfuAppActivity.this.S();
            DfuAppActivity.this.otaUpdateFailed();
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onFirmwareValidating(String str) {
        }

        @Override // no.nordicsemi.android.dfu.DfuProgressListenerAdapter, no.nordicsemi.android.dfu.DfuProgressListener
        public void onProgressChanged(String str, int i, float f, float f2, int i2, int i3) {
            DfuAppActivity dfuAppActivity = DfuAppActivity.this;
            dfuAppActivity.s.setText(String.format(Locale.ROOT, dfuAppActivity.getString(R$string.updating_d), Integer.valueOf(i)));
            DfuAppActivity.this.u.setText(i + "%");
            DfuAppActivity.this.t.setProgress(i);
        }
    }

    static /* synthetic */ on0 N(DfuAppActivity dfuAppActivity) {
        dfuAppActivity.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        new Handler().postDelayed(new Runnable() { // from class: kb0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.Z();
            }
        }, 200L);
    }

    private boolean W() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    private boolean X() {
        return h9.f(this, DfuService.class.getName());
    }

    private boolean Y() {
        List list = this.M;
        return list == null || list.size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        ((NotificationManager) getSystemService("notification")).cancel(DfuBaseService.NOTIFICATION_ID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0() {
        this.k.setImageResource(R$drawable.ic_arrow_down_24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(m50 m50Var, int i) {
        if (getString(R$string.dfu_status_successed).equals(this.s.getText().toString())) {
            e43.a(this.L.get(i));
            throw null;
        }
        e43.a(this.L.get(i));
        Locale locale = Locale.ROOT;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(CheckBox checkBox, CheckBox checkBox2, EditText editText, SeekBar seekBar, DialogInterface dialogInterface, int i) {
        this.F = checkBox.isChecked();
        this.H = checkBox2.isChecked();
        this.G = editText.getText().toString().trim();
        this.I = seekBar.getProgress() * (-1);
        hj2.e(this, "is_filter_name", this.F);
        hj2.e(this, "is_filter_rssi", this.H);
        hj2.g(this, "filter_name", this.G);
        hj2.f(this, "filter_rssi", this.I);
    }

    private void f0() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(DfuBaseService.MIME_TYPE_ZIP);
        intent.addCategory("android.intent.category.OPENABLE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1);
        } else {
            o33.b(this, "请安装文件管理器");
        }
    }

    private void g0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        if (Y()) {
            T();
            finish();
            return;
        }
        for (File file : this.M) {
            if (!file.getName().toUpperCase().contains("APP")) {
                if (file.getName().toUpperCase().contains("UI")) {
                    this.N = file;
                    break;
                }
            } else {
                this.N = file;
                break;
            }
        }
        File file2 = this.N;
        if (file2 != null) {
            this.w = file2.getAbsolutePath();
            n0(this.N.getName(), this.N.length());
        } else {
            otaUpdateSucess();
            finish();
        }
    }

    private void i0() {
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 0);
    }

    private void j0() {
        ScannerFragment.X().M(getSupportFragmentManager(), "scan_fragment");
    }

    private void k0() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.pop_file_list, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_empty_desc);
        List list = this.L;
        if (list == null || list.isEmpty()) {
            textView.setVisibility(0);
            Locale locale = Locale.ROOT;
            String string = getString(R$string.no_file_tip);
            String str = this.K;
            textView.setText(String.format(locale, string, str, str));
        } else {
            textView.setVisibility(4);
        }
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new pc0(this, 1, R$drawable.divider));
        jm0 jm0Var = new jm0(this.L);
        recyclerView.setAdapter(jm0Var);
        final m50 m50VarA = new m50.c(this).e(viewInflate).b(true).d(true).f(-1, -2).c(new PopupWindow.OnDismissListener() { // from class: lb0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                this.a.a0();
            }
        }).a();
        viewInflate.findViewById(R$id.view_cancle).setOnClickListener(new View.OnClickListener() { // from class: mb0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                m50VarA.n();
            }
        });
        jm0Var.f(new jm0.c() { // from class: nb0
            @Override // jm0.c
            public final void a(int i) {
                this.a.c0(m50VarA, i);
            }
        });
        this.k.setImageResource(R$drawable.ic_arrow_up_24);
        m50VarA.o(this.j);
    }

    private void l0() {
        View viewInflate = LayoutInflater.from(this).inflate(R$layout.dialog_fliter_settings, (ViewGroup) null);
        final CheckBox checkBox = (CheckBox) viewInflate.findViewById(R$id.cb_name);
        final EditText editText = (EditText) viewInflate.findViewById(R$id.et_name);
        final CheckBox checkBox2 = (CheckBox) viewInflate.findViewById(R$id.cb_rssi);
        final SeekBar seekBar = (SeekBar) viewInflate.findViewById(R$id.seekBar);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_rssi);
        checkBox.setChecked(this.F);
        editText.setText(this.G);
        checkBox2.setChecked(this.H);
        textView.setText(String.format(Locale.ROOT, "%ddBm", Integer.valueOf(this.I)));
        seekBar.setProgress(Math.abs(this.I));
        seekBar.setOnSeekBarChangeListener(new b(textView));
        new androidx.appcompat.app.b.a(this).u(viewInflate).k(R$string.cancel, null).o(R$string.sure, new DialogInterface.OnClickListener() { // from class: jb0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.d0(checkBox, checkBox2, editText, seekBar, dialogInterface, i);
            }
        }).v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        if (X()) {
            return;
        }
        this.s.setText(getString(R$string.updating));
        DfuServiceInitiator unsafeExperimentalButtonlessServiceInSecureDfuEnabled = new DfuServiceInitiator(this.v.getAddress()).setDeviceName(this.v.getName()).setKeepBond(false).setForceDfu(false).setPacketsReceiptNotificationsEnabled(false).setPacketsReceiptNotificationsValue(12).setPrepareDataObjectDelay(400L).setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(true);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setZip(this.x, this.w);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setForeground(false);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.setDisableNotification(true);
        unsafeExperimentalButtonlessServiceInSecureDfuEnabled.start(this, DfuService.class);
        DfuServiceInitiator.createDfuNotificationChannel(this);
    }

    private void n0(String str, long j) {
        this.o.setText(str);
        this.p.setText(String.format(Locale.ROOT, getString(R$string.dfu_file_size_text), Long.valueOf(j)));
        boolean zMatches = MimeTypeMap.getFileExtensionFromUrl(str).matches("(?i)ZIP");
        this.y = zMatches;
        this.f303q.setText(zMatches ? "OK" : getString(R$string.dfu_file_status_invalid));
    }

    private void o0() {
        this.g.setAlpha(this.z ? 1.0f : 0.3f);
        this.i.setEnabled(this.z);
        this.j.setAlpha(this.z ? 1.0f : 0.3f);
        this.n.setAlpha(this.z ? 0.3f : 1.0f);
        this.r.setEnabled(!this.z);
        if (!this.z) {
            this.l.setVisibility(8);
        }
        hj2.f(this, "dfu_update_method", !this.z ? 1 : 0);
    }

    @Override // com.onmicro.omtoolbox.BaseActivity
    public void G() {
        super.G();
        setSupportActionBar(this.c);
        getSupportActionBar().s(true);
    }

    protected abstract void T();

    protected abstract String U();

    protected abstract List V();

    @Override // com.onmicro.omtoolbox.scanner.ScannerFragment.b
    public void b(pj0 pj0Var) {
        if (getString(R$string.dfu_status_successed).equals(this.s.getText().toString()) && !pj0Var.a.getAddress().equals(this.v.getAddress())) {
            this.s.setText("开始升级");
        }
        BluetoothDevice bluetoothDevice = pj0Var.a;
        this.v = bluetoothDevice;
        String name = bluetoothDevice.getName();
        TextView textView = this.d;
        if (TextUtils.isEmpty(name)) {
            name = "UNKNOW";
        }
        textView.setText(name);
        this.e.setText(this.v.getAddress());
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader loader, Cursor cursor) {
        if (cursor == null || !cursor.moveToNext()) {
            this.o.setText((CharSequence) null);
            this.p.setText((CharSequence) null);
            this.f303q.setText("文件读取失败");
            this.w = null;
            this.x = null;
            this.y = false;
            return;
        }
        String string = cursor.getString(cursor.getColumnIndex("_display_name"));
        int i = cursor.getInt(cursor.getColumnIndex("_size"));
        int columnIndex = cursor.getColumnIndex("_data");
        String string2 = columnIndex != -1 ? cursor.getString(columnIndex) : null;
        if (!TextUtils.isEmpty(string2)) {
            this.w = string2;
        }
        n0(string, i);
    }

    @Override // com.onmicro.omtoolbox.scanner.ScannerFragment.b
    public void h() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            this.w = null;
            this.x = null;
            if (intent == null) {
                return;
            }
            Uri data = intent.getData();
            ed1.b("DfuActivity", "uri:" + data.getScheme());
            if (data.getScheme().equals("file")) {
                String path = data.getPath();
                File file = new File(path);
                this.w = path;
                n0(file.getName(), file.length());
                return;
            }
            if (data.getScheme().equals("content")) {
                this.x = data;
                Bundle extras = intent.getExtras();
                if (extras != null && extras.containsKey("android.intent.extra.STREAM")) {
                    this.x = (Uri) extras.getParcelable("android.intent.extra.STREAM");
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("uri", data);
                getLoaderManager().restartLoader(1, bundle, this);
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == R$id.rb_net) {
            if (this.z != z) {
                this.z = z;
                this.m.setChecked(!z);
                o0();
                return;
            }
            return;
        }
        if (id == R$id.rb_local && this.z == z) {
            boolean z2 = !z;
            this.z = z2;
            this.f.setChecked(z2);
            o0();
        }
    }

    @OnClick({2621, 2740, 2620, 2622})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.btn_sure) {
            String strTrim = this.h.getText().toString().trim();
            this.K = strTrim;
            if (TextUtils.isEmpty(strTrim)) {
                o33.b(this, "请输入芯片型号");
                return;
            } else {
                hj2.g(this, "chip_model", this.K);
                g0(this.K);
                return;
            }
        }
        if (id == R$id.iv_file_expload) {
            if (TextUtils.isEmpty(this.K)) {
                o33.b(this, getString(R$string.input_chip_model_tip));
                return;
            } else {
                k0();
                return;
            }
        }
        if (id == R$id.btn_select_file) {
            f0();
            return;
        }
        if (id == R$id.btn_update) {
            if (this.v == null) {
                o33.b(this, "请选择设备");
                return;
            }
            if (getString(R$string.dfu_status_successed).equals(this.s.getText().toString().trim())) {
                finish();
                return;
            }
            if (this.z) {
                o33.b(this, "请选择DFU升级文件");
            } else if (!this.y) {
                o33.b(this, "升级文件无效，请重新选择升级文件！");
            } else {
                this.s.setClickable(false);
                m0();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_dfu);
        this.F = hj2.a(this, "is_filter_name", this.F);
        this.G = hj2.c(this, "filter_name");
        this.H = hj2.a(this, "is_filter_rssi", this.H);
        this.I = hj2.b(this, "filter_rssi", this.I);
        this.J = hj2.b(this, "dfu_update_method", this.J);
        this.f.setOnCheckedChangeListener(this);
        this.m.setOnCheckedChangeListener(this);
        int i = this.J;
        this.z = i == 1;
        if (i != 1) {
            this.f.setChecked(true);
        } else {
            this.m.setChecked(true);
        }
        DfuServiceListenerHelper.registerProgressListener(this, this.O);
        String strC = hj2.c(this, "firmware_info_json");
        if (!TextUtils.isEmpty(strC)) {
            try {
                e43.a(new qv0().fromJson(strC, new TypeToken<on0>() { // from class: com.onmicro.omtoolbox.dfu.DfuAppActivity.1
                }.getType()));
            } catch (Exception e) {
                ed1.a("DfuActivity", e.getMessage());
            }
        }
        String strD = hj2.d(this, "chip_model", this.K);
        this.K = strD;
        this.h.setText(strD);
        if (!TextUtils.isEmpty(this.K)) {
            this.h.setSelection(this.K.length());
            g0(this.K);
        }
        this.h.addTextChangedListener(new a());
        BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(U());
        this.v = remoteDevice;
        this.d.setText(remoteDevice != null ? remoteDevice.getName() : "UNKNOW");
        this.e.setText(U());
        this.M = V();
        h0();
        m0();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, (Uri) bundle.getParcelable("uri"), null, null, null, null);
    }

    @Override // com.onmicro.omtoolbox.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
        this.f303q.setText((CharSequence) null);
        this.p.setText((CharSequence) null);
        this.w = null;
        this.x = null;
        this.y = false;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId != R$id.action_scanner) {
            if (itemId != R$id.action_scanner_fliter) {
                return true;
            }
            l0();
            return true;
        }
        if (W()) {
            j0();
            return true;
        }
        i0();
        return true;
    }

    protected abstract void otaUpdateFailed();

    protected abstract void otaUpdateSucess();
}
