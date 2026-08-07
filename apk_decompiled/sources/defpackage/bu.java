package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.legend.mywatch.sdk.mywatchsdklib.android.enm.DeviceControlAppEnum;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.PermissionUtils;
import com.legend.sdk.cameralibray.Camera2Activity;

/* JADX INFO: loaded from: classes3.dex */
public abstract class bu {
    private static boolean a = false;
    private static Context b;

    class a implements PermissionUtils.b {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.PermissionUtils.b
        public void onDenied() {
            Toast.makeText(bu.b, "需要相机权限才能使用远程拍照", 0).show();
        }

        @Override // com.legend.mywatch.sdk.mywatchsdklib.android.utils.PermissionUtils.b
        public void onGranted() {
            Intent intent = new Intent(bu.b, (Class<?>) Camera2Activity.class);
            intent.addFlags(268435456);
            if (this.a) {
                intent.putExtra("extra_remote_shutter_on_open", true);
            }
            bu.b.startActivity(intent);
            if (e20.d == 1) {
                zi2.o(qm2.B(true), "开启拍照功能");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(ng ngVar) {
        if (ngVar == null) {
            return;
        }
        try {
            if (ngVar instanceof aa0) {
                aa0 aa0Var = (aa0) ngVar;
                String macAddress = ngVar.getMacAddress();
                boolean zM = aa0Var.M();
                cu.g(macAddress, zM);
                Log.d("CameraLibrary", "设备功能事件：MAC地址 = " + macAddress + ", 实时预览支持状态 = " + zM);
            } else {
                if (ngVar instanceof x90) {
                    DeviceControlAppEnum deviceControlAppEnumA = ((x90) ngVar).a();
                    Log.i("CameraLibrary", "handleSDKEvent: " + deviceControlAppEnumA);
                    DeviceControlAppEnum deviceControlAppEnum = DeviceControlAppEnum.ENTER_REMOTE_CAMERA;
                    if ((deviceControlAppEnumA == deviceControlAppEnum || deviceControlAppEnumA == DeviceControlAppEnum.TAKE_PHOTO) && !com.legend.mywatch.sdk.mywatchsdklib.android.utils.a.c(Camera2Activity.class)) {
                        e(deviceControlAppEnumA == deviceControlAppEnum);
                    }
                } else if ((ngVar instanceof pa0) && !com.legend.mywatch.sdk.mywatchsdklib.android.utils.a.c(Camera2Activity.class)) {
                    e(false);
                }
            }
        } catch (Exception e) {
            Log.e("CameraLibrary", "处理SDK事件失败", e);
        }
    }

    public static boolean d(Application application) {
        if (a) {
            Log.w("CameraLibrary", "相机库已经初始化，跳过重复初始化");
            return true;
        }
        if (application == null) {
            Log.e("CameraLibrary", "初始化失败：context不能为null");
            return false;
        }
        try {
            b = application;
            qj2.a(application);
            if (!tg3.m().q()) {
                tg3.m().o(application);
            }
            tg3.m().h(new tg3.b() { // from class: au
                @Override // tg3.b
                public final void a(ng ngVar) {
                    bu.c(ngVar);
                }
            });
            a = true;
            Log.d("CameraLibrary", "相机库初始化成功");
            return true;
        } catch (Exception e) {
            Log.e("CameraLibrary", "相机库初始化失败", e);
            return false;
        }
    }

    private static void e(boolean z) {
        if (b == null) {
            Log.e("CameraLibrary", "startCameraActivity: applicationContext 为空");
        } else if (com.legend.mywatch.sdk.mywatchsdklib.android.utils.a.c(Camera2Activity.class)) {
            Log.d("CameraLibrary", "已经处于Camera2Activity页面");
        } else {
            PermissionUtils.A("CAMERA").m(new a(z)).B();
        }
    }
}
