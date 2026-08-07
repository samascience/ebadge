package xfkj.fitpro.activity.ota;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.os.Bundle;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.g;
import defpackage.dm3;
import yqy.yichip.ota3genbandupgrade.FunctionActivity;

/* JADX INFO: loaded from: classes4.dex */
public class LyOTActivity extends FunctionActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackPressed$0(DialogInterface dialogInterface, int i) {
        super.onBackPressed();
    }

    @Override // yqy.yichip.ota3genbandupgrade.FunctionActivity
    protected BluetoothDevice getBluetoothDevice() {
        return (BluetoothDevice) getIntent().getParcelableExtra("device");
    }

    @Override // yqy.yichip.ota3genbandupgrade.FunctionActivity
    protected String getOtaPath() {
        return getIntent().getStringExtra("path");
    }

    @Override // yqy.yichip.ota3genbandupgrade.FunctionActivity
    protected String getTxtTips() {
        return getString(R.string.ota_upgrade_tips);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.warn));
        builder.setMessage(getString(R.string.upgradding_content));
        builder.setNeutralButton(getString(R.string.cancel_txt), (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(getString(R.string.exit), new DialogInterface.OnClickListener() { // from class: ff1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.lambda$onBackPressed$0(dialogInterface, i);
            }
        });
        builder.show();
    }

    @Override // yqy.yichip.ota3genbandupgrade.FunctionActivity, yqy.yichip.lib_pro_common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.b(dm3.b);
        try {
            PermissionUtils.y("android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE").z();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // yqy.yichip.ota3genbandupgrade.FunctionActivity
    protected void otaUpdateFailed() {
        setResult(1);
        ToastUtils.t(R.string.update_ota_failed_tips);
        finish();
    }

    @Override // yqy.yichip.ota3genbandupgrade.FunctionActivity
    protected void otaUpdateSucess() {
        setResult(-1);
        ToastUtils.t(R.string.upgrade_success);
        finish();
    }
}
