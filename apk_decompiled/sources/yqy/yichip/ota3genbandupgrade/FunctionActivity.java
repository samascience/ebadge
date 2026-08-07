package yqy.yichip.ota3genbandupgrade;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import com.tencent.connect.common.Constants;
import defpackage.at0;
import defpackage.av1;
import defpackage.bm3;
import defpackage.hm3;
import defpackage.jw1;
import defpackage.k42;
import defpackage.l63;
import defpackage.lm3;
import defpackage.n0;
import defpackage.om3;
import defpackage.pm3;
import defpackage.rm3;
import defpackage.rv1;
import defpackage.rz2;
import defpackage.um0;
import defpackage.z8;
import java.util.ArrayList;
import java.util.Random;
import yqy.yichip.lib_pro_common.base.BaseActivity;
import yqy.yichip.ota3genbandupgrade.fragment.LoadingDialogFragment;
import yqy.yichip.ota3genbandupgrade.fragment.ScannerBleFragment;
import yqy.yichip.ota3genbandupgrade.fragment.SelectOtaFileSourceFragment;

/* JADX INFO: loaded from: classes4.dex */
public abstract class FunctionActivity extends BaseActivity {
    private static final int FILE_SELECTOR_CODE = 1;
    private static final String TAG = "_3GenEBandOtaUpgrade";
    private Button btnGenerateRandomAddress;
    private Button btnGenerateRandomName;
    private Button btnSelectDownloadFile;
    private Button btnStart;
    private DrawerLayout drawerLayout;
    private EditText etDeviceNewAddress;
    private EditText etDeviceNewName;
    private ImageView ivMenu;
    private LinearLayout llOriFlashInfo;
    private LoadingDialogFragment loadingDialog;
    private String localFilePath;
    private BluetoothDevice mSelectDevice;
    private hm3 otaManager;
    private ProgressBar pbUpgrade;
    private RelativeLayout rl_1121d_ota;
    private ScannerBleFragment scannerBleFragment;
    private SelectOtaFileSourceFragment selectOtaFileSourceFragment;
    private TextView tvConnectDeviceInfo;
    private TextView tvFlashFileName;
    private TextView tvOriFlashAddress;
    private TextView tvOriFlashName;
    private TextView tvOriFlashSvnVersion;
    private TextView tvTitle;
    private TextView tvUpdateState;
    private TextView tvUpgradeProcess;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new b();
    private pm3 genOtaManagerListener = new c();
    private BaseActivity.e onSingleClickListener = new d();
    private ScannerBleFragment.b onDeviceSelectedListener = new e();
    private av1 onFileSelectedListener = new g();
    private SelectOtaFileSourceFragment.e onFileSourceSelectedListener = new h();
    private rm3 serviceActivityListener = new i();

    class a implements rv1 {

        /* JADX INFO: renamed from: yqy.yichip.ota3genbandupgrade.FunctionActivity$a$a, reason: collision with other inner class name */
        class C0183a implements jw1 {
            C0183a() {
            }

            @Override // defpackage.jw1
            public void a(androidx.appcompat.app.b bVar) {
            }

            @Override // defpackage.jw1
            public void b(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }

            @Override // defpackage.jw1
            public void c(DialogInterface dialogInterface) {
            }
        }

        a() {
        }

        @Override // defpackage.rv1
        public void onGranted() {
            Log.d(FunctionActivity.TAG, "onGranted: 权限已授予");
            if (rz2.a()) {
                Log.d(FunctionActivity.TAG, "当前手机外部存储状态正常");
            } else {
                FunctionActivity.this.showTipsDialog("注意", "当前手机外部存储异常，应用部分功能受限！", Constants.STR_EMPTY, "确定", new C0183a());
            }
        }
    }

    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    class c implements pm3 {
        c() {
        }

        @Override // defpackage.pm3
        public void a(boolean z) {
            if (z) {
                FunctionActivity.this.otaManager.h(true);
                FunctionActivity.this.otaManager.k(FunctionActivity.this.serviceActivityListener);
            } else {
                FunctionActivity functionActivity = FunctionActivity.this;
                functionActivity.showPromptDialog(functionActivity.getString(R$string.f83OTA));
            }
        }
    }

    class d extends BaseActivity.e {
        d() {
            super();
        }

        @Override // yqy.yichip.lib_pro_common.base.BaseActivity.e
        public void a(View view) {
            int id = view.getId();
            if (id == R$id.iv_menu) {
                if (FunctionActivity.this.drawerLayout.C(3)) {
                    FunctionActivity.this.drawerLayout.d(3);
                    return;
                } else {
                    FunctionActivity.this.drawerLayout.J(3);
                    return;
                }
            }
            if (id == R$id.rl_change_ota_1121d) {
                return;
            }
            if (id == R$id.btn_select_download_file) {
                FunctionActivity.this.showSelectOtaFileSourceFragmentDialog();
                return;
            }
            if (id == R$id.bt_generate_random_name) {
                int iNextInt = new Random().nextInt(20) + 1;
                Log.d(FunctionActivity.TAG, "随机名称长度 = " + iNextInt);
                String strC = at0.c(iNextInt);
                Log.d(FunctionActivity.TAG, "随机生成名称：" + strC);
                FunctionActivity.this.etDeviceNewName.setText(strC);
                return;
            }
            if (id != R$id.btn_generate_random_address) {
                if (id == R$id.btn_start) {
                    if (TextUtils.isEmpty(FunctionActivity.this.localFilePath)) {
                        FunctionActivity.this.showToast("请先选择升级文件");
                        return;
                    } else {
                        FunctionActivity.this.otaManager.j();
                        FunctionActivity.this.showScannerBleFragmentDialog();
                        return;
                    }
                }
                return;
            }
            String[] strArrA = at0.a(6);
            StringBuilder sb = new StringBuilder();
            for (String str : strArrA) {
                sb.append(str);
            }
            String string = sb.toString();
            Log.d(FunctionActivity.TAG, "随机生成地址：" + string);
            FunctionActivity.this.etDeviceNewAddress.setText(string);
        }
    }

    class e implements ScannerBleFragment.b {

        class a implements Runnable {
            final /* synthetic */ BluetoothDevice a;

            a(BluetoothDevice bluetoothDevice) {
                this.a = bluetoothDevice;
            }

            @Override // java.lang.Runnable
            public void run() {
                FunctionActivity.this.tvConnectDeviceInfo.setText(this.a.getName() + "\n" + this.a.getAddress());
            }
        }

        e() {
        }

        @Override // yqy.yichip.ota3genbandupgrade.fragment.ScannerBleFragment.b
        public void a() {
            FunctionActivity.this.otaManager.m();
        }

        @Override // yqy.yichip.ota3genbandupgrade.fragment.ScannerBleFragment.b
        public void b(BluetoothDevice bluetoothDevice) {
            FunctionActivity.this.runOnUiThread(new a(bluetoothDevice));
            FunctionActivity.this.otaManager.m();
            FunctionActivity.this.G(bluetoothDevice);
        }
    }

    class f implements Runnable {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ BluetoothDevice b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FunctionActivity.this.hideLoading();
            }
        }

        f(ArrayList arrayList, BluetoothDevice bluetoothDevice) {
            this.a = arrayList;
            this.b = bluetoothDevice;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strD = this.a.size() > 0 ? yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a.d(new yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a(FunctionActivity.this.localFilePath, -1), this.a) : FunctionActivity.this.localFilePath;
            FunctionActivity.this.runOnUiThread(new a());
            FunctionActivity.this.otaManager.l(strD, 1, this.b);
        }
    }

    class g implements av1 {
        g() {
        }

        @Override // defpackage.av1
        public void a(String str) {
            FunctionActivity.this.tvFlashFileName.setText(FunctionActivity.this.getString(R$string.f102) + ": " + str);
            FunctionActivity.this.F(str);
            FunctionActivity.this.D();
        }
    }

    class h implements SelectOtaFileSourceFragment.e {
        h() {
        }

        @Override // yqy.yichip.ota3genbandupgrade.fragment.SelectOtaFileSourceFragment.e
        public void a(int i) {
            if (i == 1) {
                FunctionActivity.this.showPromptDialog("尚未开通，请选择“本地文件”");
                return;
            }
            if (i == 2) {
                FunctionActivity functionActivity = FunctionActivity.this;
                new k42(functionActivity, functionActivity.onFileSelectedListener).f();
            } else if (i == 3) {
                FunctionActivity.this.showPromptDialog("尚未开通，请选择“本地文件”");
            }
        }

        @Override // yqy.yichip.ota3genbandupgrade.fragment.SelectOtaFileSourceFragment.e
        public void b() {
        }
    }

    class i implements rm3 {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FunctionActivity.this.otaManager.j();
            }
        }

        class b implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ String b;

            b(int i, String str) {
                this.a = i;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.a;
                if (i == 0) {
                    FunctionActivity.this.tvUpdateState.setTextColor(FunctionActivity.this.getResources().getColor(R$color.log_level_black));
                } else if (i == 1) {
                    FunctionActivity.this.tvUpdateState.setTextColor(FunctionActivity.this.getResources().getColor(R$color.log_level_green));
                } else if (i == 2) {
                    FunctionActivity.this.tvUpdateState.setTextColor(FunctionActivity.this.getResources().getColor(R$color.log_level_red));
                }
                FunctionActivity.this.tvUpdateState.setText(this.b);
            }
        }

        class c implements Runnable {
            final /* synthetic */ int a;

            c(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                FunctionActivity.this.pbUpgrade.setProgress(this.a);
                FunctionActivity.this.tvUpgradeProcess.setText(this.a + "%");
            }
        }

        class d implements Runnable {
            final /* synthetic */ String a;

            d(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                FunctionActivity.this.btnStart.setEnabled(true);
                FunctionActivity.this.tvUpdateState.setTextColor(FunctionActivity.this.getResources().getColor(R$color.red));
                FunctionActivity.this.tvUpdateState.setText(this.a);
                FunctionActivity.this.otaUpdateFailed();
            }
        }

        class e implements Runnable {
            final /* synthetic */ String a;

            e(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                FunctionActivity.this.btnStart.setEnabled(true);
                FunctionActivity.this.tvUpdateState.setTextColor(FunctionActivity.this.getResources().getColor(R$color.colorPrimary));
                FunctionActivity.this.tvUpdateState.setText(this.a);
                FunctionActivity.this.otaUpdateSucess();
            }
        }

        i() {
        }

        @Override // defpackage.rm3
        public void a() {
            if (FunctionActivity.this.scannerBleFragment.isVisible()) {
                FunctionActivity.this.scannerBleFragment.U();
                FunctionActivity.this.mHandler.postDelayed(new a(), 500L);
            }
        }

        @Override // defpackage.rm3
        public void b(int i) {
            FunctionActivity.this.runOnUiThread(new c(i));
        }

        @Override // defpackage.rm3
        public void c() {
            FunctionActivity.this.scannerBleFragment.Q();
        }

        @Override // defpackage.rm3
        public void d(String str, int i) {
            FunctionActivity.this.runOnUiThread(new b(i, str));
        }

        @Override // defpackage.rm3
        public void e(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (!FunctionActivity.this.scannerBleFragment.isAdded() || bluetoothDevice.getName() == null || bluetoothDevice.getName().isEmpty()) {
                return;
            }
            FunctionActivity.this.scannerBleFragment.O(bluetoothDevice, i);
        }

        @Override // defpackage.rm3
        public void onError(String str) {
            Log.e(FunctionActivity.TAG, "onError :" + str);
            FunctionActivity.this.runOnUiThread(new d(str));
        }

        @Override // defpackage.rm3
        public void onSuccess(String str) {
            FunctionActivity.this.runOnUiThread(new e(str));
        }
    }

    class j implements Runnable {

        class a implements Runnable {
            final /* synthetic */ om3 a;

            a(om3 om3Var) {
                this.a = om3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                FunctionActivity.this.hideLoading();
                if (this.a == null) {
                    FunctionActivity.this.tvOriFlashSvnVersion.setText(FunctionActivity.this.getString(R$string.f112));
                    FunctionActivity.this.tvOriFlashName.setText(FunctionActivity.this.getString(R$string.f90));
                    FunctionActivity.this.tvOriFlashAddress.setText(FunctionActivity.this.getString(R$string.f91));
                    return;
                }
                FunctionActivity.this.tvOriFlashSvnVersion.setText("版本:" + this.a.c() + "\n时间:" + this.a.d());
                TextView textView = FunctionActivity.this.tvOriFlashName;
                StringBuilder sb = new StringBuilder();
                sb.append("原名称:\n");
                sb.append(this.a.b());
                textView.setText(sb.toString());
                FunctionActivity.this.tvOriFlashAddress.setText("原地址:\n" + this.a.a());
                FunctionActivity.this.tvConnectDeviceInfo.setText(FunctionActivity.this.mSelectDevice.getName() + "\n" + FunctionActivity.this.mSelectDevice.getAddress());
                FunctionActivity functionActivity = FunctionActivity.this;
                functionActivity.G(functionActivity.mSelectDevice);
            }
        }

        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a aVar = new yqy.yichip.yc_lib_ota_3_gen.wristband_1121E.a(FunctionActivity.this.localFilePath, -1);
            Log.d(FunctionActivity.TAG, aVar.toString());
            om3 om3VarG = aVar.g();
            if (om3VarG == null) {
                Log.d(FunctionActivity.TAG, "otaFileUtil == null");
            } else {
                Log.d(FunctionActivity.TAG, "所选固件信息：" + om3VarG.toString());
            }
            FunctionActivity.this.runOnUiThread(new a(om3VarG));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.llOriFlashInfo.setVisibility(8);
        showLoading("正在获取升级文件信息...", false);
        new Thread(new j()).start();
    }

    private void E() {
        onRequestPermission(z8.a, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str) {
        this.localFilePath = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(BluetoothDevice bluetoothDevice) {
        if (TextUtils.isEmpty(this.localFilePath)) {
            showPromptDialog("请先下载固件");
            return;
        }
        String strTrim = this.etDeviceNewName.getText().toString().trim();
        if (!TextUtils.isEmpty(strTrim)) {
            byte[] bytes = strTrim.getBytes();
            Log.d(TAG, "名称字节长度:" + bytes.length);
            if (bytes.length > 20) {
                showPromptDialog("名称长度需要低于20个字符");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(strTrim)) {
                lm3 lm3Var = new lm3();
                lm3Var.d(18057);
                byte[] bytes2 = strTrim.getBytes();
                int length = bytes2.length;
                byte[] bArr = new byte[length + 1];
                bArr[0] = (byte) length;
                System.arraycopy(bytes2, 0, bArr, 1, length);
                lm3Var.h(bArr);
                arrayList.add(lm3Var);
            }
            String strTrim2 = bluetoothDevice.getAddress().replace(":", Constants.STR_EMPTY).replace(" ", Constants.STR_EMPTY).trim();
            Log.d(TAG, "当前连接的设备地址：" + strTrim2);
            if (!TextUtils.isEmpty(strTrim2)) {
                lm3 lm3Var2 = new lm3();
                lm3Var2.d(17977);
                byte[] bArrH = l63.h(strTrim2);
                if (bArrH.length != 6) {
                    throw new Exception("地址不对");
                }
                byte[] bArr2 = new byte[bArrH.length];
                for (int i2 = 0; i2 < bArrH.length; i2++) {
                    bArr2[i2] = bArrH[(bArrH.length - 1) - i2];
                }
                lm3Var2.h(bArr2);
                arrayList.add(lm3Var2);
                lm3 lm3Var3 = new lm3();
                lm3Var3.d(16704);
                byte[] bArrH2 = l63.h(strTrim2);
                if (bArrH2.length != 6) {
                    throw new Exception("地址不对");
                }
                bArrH2[3] = (byte) (((int) l63.f(bArrH2, 3, 1)) + 1);
                byte[] bArr3 = new byte[bArrH2.length];
                for (int i3 = 0; i3 < bArrH2.length; i3++) {
                    bArr3[i3] = bArrH2[(bArrH2.length - 1) - i3];
                }
                lm3Var3.h(bArr3);
                arrayList.add(lm3Var3);
            }
            this.btnStart.setEnabled(false);
            this.pbUpgrade.setProgress(0);
            this.tvUpgradeProcess.setText(Constants.STR_EMPTY);
            this.tvUpdateState.setText(Constants.STR_EMPTY);
            showLoading("正在修改文件", false);
            new Thread(new f(arrayList, bluetoothDevice)).start();
        } catch (Exception e2) {
            e2.printStackTrace();
            showPromptDialog("名称/地址配置错误");
        }
    }

    @Override // yqy.yichip.lib_pro_common.base.BaseActivity
    @SuppressLint({"SetTextI18n"})
    public void afterInitView() {
        this.tvTitle.setText(getString(R$string.app_name) + " V" + n0.a(this.mContext));
        this.ivMenu.setOnClickListener(this.onSingleClickListener);
        this.rl_1121d_ota.setOnClickListener(this.onSingleClickListener);
        this.btnSelectDownloadFile.setOnClickListener(this.onSingleClickListener);
        this.btnGenerateRandomName.setOnClickListener(this.onSingleClickListener);
        this.btnGenerateRandomAddress.setOnClickListener(this.onSingleClickListener);
        this.btnStart.setOnClickListener(this.onSingleClickListener);
    }

    @Override // yqy.yichip.lib_pro_common.base.BaseActivity
    public void beforeInitView() {
        E();
        hm3 hm3VarG = hm3.g(bm3.b().c());
        this.otaManager = hm3VarG;
        hm3VarG.i(this.genOtaManagerListener);
    }

    protected abstract BluetoothDevice getBluetoothDevice();

    @Override // yqy.yichip.lib_pro_common.base.BaseActivity
    protected int getLayoutId() {
        return R$layout.activity_function;
    }

    protected abstract String getOtaPath();

    protected abstract String getTxtTips();

    public void hideLoading() {
        LoadingDialogFragment loadingDialogFragment = this.loadingDialog;
        if (loadingDialogFragment != null) {
            loadingDialogFragment.y();
        }
    }

    @Override // yqy.yichip.lib_pro_common.base.BaseActivity
    protected void initView() {
        this.ivMenu = (ImageView) findViewById(R$id.iv_menu);
        this.drawerLayout = (DrawerLayout) findViewById(R$id.drawer_layout);
        this.rl_1121d_ota = (RelativeLayout) findViewById(R$id.rl_change_ota_1121d);
        this.tvConnectDeviceInfo = (TextView) findViewById(R$id.tv_connect_device_name_addr);
        this.tvTitle = (TextView) findViewById(R$id.tv_title);
        this.tvFlashFileName = (TextView) findViewById(R$id.tv_flash_file_name);
        this.tvOriFlashSvnVersion = (TextView) findViewById(R$id.tv_ori_flash_svn_version);
        this.tvOriFlashName = (TextView) findViewById(R$id.tv_ori_flash_name);
        this.tvOriFlashAddress = (TextView) findViewById(R$id.tv_ori_flash_address);
        this.etDeviceNewName = (EditText) findViewById(R$id.et_device_new_name);
        this.etDeviceNewAddress = (EditText) findViewById(R$id.et_device_new_address);
        this.btnSelectDownloadFile = (Button) findViewById(R$id.btn_select_download_file);
        this.btnGenerateRandomName = (Button) findViewById(R$id.bt_generate_random_name);
        this.btnGenerateRandomAddress = (Button) findViewById(R$id.btn_generate_random_address);
        this.llOriFlashInfo = (LinearLayout) findViewById(R$id.ll_ori_flash_info);
        this.btnStart = (Button) findViewById(R$id.btn_start);
        this.tvUpdateState = (TextView) findViewById(R$id.tv_update_state);
        this.tvUpgradeProcess = (TextView) findViewById(R$id.tv_upgrade_process);
        this.pbUpgrade = (ProgressBar) findViewById(R$id.pb_upgrade);
        ((TextView) findViewById(R$id.tv_ota_upgrade_tips)).setText(getTxtTips());
        this.onFileSelectedListener.a(getOtaPath());
        this.mSelectDevice = getBluetoothDevice();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1) {
            if (intent == null) {
                Log.e(TAG, "onActivityResult()--> data == null");
                return;
            }
            Uri data = intent.getData();
            if (data == null) {
                Log.e(TAG, "onActivityResult()--> uri == null");
                return;
            }
            if (data.getPath() == null) {
                Log.e(TAG, "onActivityResult()--> uri.getPath() == null");
                return;
            }
            Log.d(TAG, "uri.getPath() = " + data.getPath());
            String strB = um0.b(this.mContext, data);
            Log.d(TAG, "localFilePath = " + strB);
            if (strB == null) {
                Toast.makeText(this, "当前文件所在路径无法访问，请重新选择！", 0).show();
                return;
            }
            if (!strB.endsWith(".dat")) {
                Log.e(TAG, "用户手动选择的固件不是.dat文件！");
                Toast.makeText(this, "所选文件不合法，请重新选择！", 0).show();
                return;
            }
            av1 av1Var = this.onFileSelectedListener;
            if (av1Var != null) {
                av1Var.a(strB);
            }
            Log.d(TAG, "选择了本地升级文件的路径：" + strB);
            Toast.makeText(this, "文件路径：" + strB, 0).show();
        }
    }

    @Override // yqy.yichip.lib_pro_common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected abstract void otaUpdateFailed();

    protected abstract void otaUpdateSucess();

    public void setLoadingMsg(String str) {
        LoadingDialogFragment loadingDialogFragment = this.loadingDialog;
        if (loadingDialogFragment == null) {
            return;
        }
        loadingDialogFragment.N(str);
    }

    public void showLoading(String str, boolean z) {
        LoadingDialogFragment loadingDialogFragment = this.loadingDialog;
        if (loadingDialogFragment == null) {
            this.loadingDialog = new LoadingDialogFragment();
        } else {
            loadingDialogFragment.y();
        }
        this.loadingDialog.N(str).O(z).M(getSupportFragmentManager(), "loading");
    }

    public void showScannerBleFragmentDialog() {
        ScannerBleFragment scannerBleFragment = this.scannerBleFragment;
        if (scannerBleFragment == null || !scannerBleFragment.isVisible()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            ScannerBleFragment scannerBleFragmentP = ScannerBleFragment.P(this.otaManager.f(), this.mSelectDevice.getAddress());
            this.scannerBleFragment = scannerBleFragmentP;
            scannerBleFragmentP.S(this.onDeviceSelectedListener);
            this.scannerBleFragment.M(supportFragmentManager, "ble_scan_fragment");
        }
    }

    public void showSelectOtaFileSourceFragmentDialog() {
        SelectOtaFileSourceFragment selectOtaFileSourceFragment = this.selectOtaFileSourceFragment;
        if (selectOtaFileSourceFragment == null || !selectOtaFileSourceFragment.isVisible()) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            SelectOtaFileSourceFragment selectOtaFileSourceFragmentO = SelectOtaFileSourceFragment.O();
            this.selectOtaFileSourceFragment = selectOtaFileSourceFragmentO;
            selectOtaFileSourceFragmentO.P(this.onFileSourceSelectedListener);
            this.selectOtaFileSourceFragment.M(supportFragmentManager, "select_ota_file_source_fragment");
        }
    }
}
