package xfkj.fitpro.activity.ota.jieli;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.blankj.utilcode.util.ToastUtils;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.WatchFileContent;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import defpackage.fz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WatchDemo {
    private static final String TAG = "WatchDemo";
    private static boolean isSend = false;
    private static List<FatFile> watchList;

    public static void addWatch(final String str) {
        final WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
        watchManagerDemo.createWatchFile(str, false, new OnFatFileProgressListener() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.12
            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onProgress(float f) {
                Log.i(WatchDemo.TAG, "addWatch onProgress:" + f);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStart(String str2) {
                Log.i(WatchDemo.TAG, "addWatch onStart:" + str2);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStop(int i) {
                Log.i(WatchDemo.TAG, "addWatch result:" + i);
                if (i == 0) {
                    watchManagerDemo.setCurrentWatchInfo(FatUtil.getFatFilePath(str), new OnWatchOpCallback<FatFile>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.12.1
                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onFailed(BaseError baseError) {
                            Log.i(WatchDemo.TAG, "addWatch onFailed:" + baseError.toString());
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onSuccess(FatFile fatFile) {
                            Log.i(WatchDemo.TAG, "addWatch onSuccess:" + fatFile);
                        }
                    });
                }
            }
        });
    }

    public static void addWatchBg(final String str) {
        final WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
        watchManagerDemo.createWatchFile(str, true, new OnFatFileProgressListener() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.13
            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onProgress(float f) {
                Log.i(WatchDemo.TAG, "addWatchBg onProgress:" + f);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStart(String str2) {
                Log.i(WatchDemo.TAG, "addWatchBg onStart:" + str2);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStop(int i) {
                Log.i(WatchDemo.TAG, "addWatchBg onStop:" + i);
                if (i == 0) {
                    watchManagerDemo.enableCustomWatchBg(FatUtil.getFatFilePath(str), new OnWatchOpCallback<FatFile>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.13.1
                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onFailed(BaseError baseError) {
                            Log.i(WatchDemo.TAG, "addWatchBg onStop onFailed:" + baseError);
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onSuccess(FatFile fatFile) {
                            Log.i(WatchDemo.TAG, "addWatchBg onStop onSuccess:" + fatFile);
                        }
                    });
                }
            }
        });
    }

    public static void createWatch(String str) {
        WatchManagerDemo.getInstance().createWatchFile(str, false, new OnFatFileProgressListener() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.2
            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onProgress(float f) {
                Log.i(WatchDemo.TAG, "createWatch onProgress:" + f);
                ToastUtils.u("createWatch onProgress:" + f);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStart(String str2) {
                Log.i(WatchDemo.TAG, "createWatch onStart:" + str2);
                ToastUtils.u("createWatch onStart:" + str2);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStop(int i) {
                Log.i(WatchDemo.TAG, "createWatch onStop:" + i);
                ToastUtils.u("createWatch onStop:" + i);
            }
        });
    }

    public static void deleteWatch(String str) {
        WatchManagerDemo.getInstance().deleteWatchFile(str, new OnFatFileProgressListener() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.3
            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onProgress(float f) {
                Log.i(WatchDemo.TAG, "deleteWatch onProgress:" + f);
                ToastUtils.u("deleteWatch onProgress:" + f);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStart(String str2) {
                Log.i(WatchDemo.TAG, "deleteWatch deleteWatch:" + str2);
                ToastUtils.u("deleteWatch deleteWatch:" + str2);
            }

            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
            public void onStop(int i) {
                Log.i(WatchDemo.TAG, "deleteWatch onStop:" + i);
                ToastUtils.u("deleteWatch onStop:" + i);
            }
        });
    }

    public static void enableCustomWatchBg(String str) {
        WatchManagerDemo.getInstance().enableCustomWatchBg(str, new OnWatchOpCallback<FatFile>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.9
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "enableCustomWatchBg onFailed:" + baseError.toString());
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(FatFile fatFile) {
                Log.i(WatchDemo.TAG, "enableCustomWatchBg onSuccess:" + fatFile);
            }
        });
    }

    public static void getCurrentDialAllInfo() {
        final WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
        watchManagerDemo.getCurrentWatchInfo(new OnWatchOpCallback<FatFile>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.14
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "addWatchBg onStop onFailed:" + baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(FatFile fatFile) {
                Log.i(WatchDemo.TAG, "getCurrentDialAllInfo onStop onSuccess:" + fatFile);
                watchManagerDemo.getCustomWatchBgInfo(fatFile.getPath(), new OnWatchOpCallback<String>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.14.1
                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onFailed(BaseError baseError) {
                        Log.i(WatchDemo.TAG, "getCurrentDialAllInfo onStop onSuccess onFailed:" + baseError);
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onSuccess(String str) {
                        Log.i(WatchDemo.TAG, "getCurrentDialAllInfo onStop onSuccess onSuccess:" + str);
                    }
                });
            }
        });
    }

    public static void getCurrentWatchInfo() {
        WatchManagerDemo.getInstance().getCurrentWatchInfo(new OnWatchOpCallback<FatFile>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.5
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "getCurrentWatchInfo onFailed:" + baseError.toString());
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(FatFile fatFile) {
                Log.i(WatchDemo.TAG, "getCurrentWatchInfo onSuccess:" + fatFile);
            }
        });
    }

    public static void getCustomWatchBgInfo(String str) {
        WatchManagerDemo.getInstance().getCustomWatchBgInfo(str, new OnWatchOpCallback<String>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.8
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "getCustomWatchBgInfo onFailed:" + baseError.toString());
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(String str2) {
                Log.i(WatchDemo.TAG, "getCustomWatchBgInfo onSuccess:" + str2);
            }
        });
    }

    public static void getWatchExtraMessage(String str) {
        WatchManagerDemo.getInstance().getWatchMessage(str, new OnWatchOpCallback<String>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.6
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "getWatchExtraMessage onFailed:" + baseError.toString());
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(String str2) {
                Log.i(WatchDemo.TAG, "getWatchExtraMessage onSuccess:" + str2);
            }
        });
    }

    public static void getWatchFileSize(String str) {
        WatchManagerDemo.getInstance().getWatchFileSize(str, new OnWatchOpCallback<WatchFileContent>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.17
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "getWatchFileSize onFailed:" + baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(WatchFileContent watchFileContent) {
                watchFileContent.getFileSize();
                watchFileContent.getCrc();
                Log.i(WatchDemo.TAG, "getWatchFileSize onSuccess:" + watchFileContent);
            }
        });
    }

    public static List<FatFile> getWatchList() {
        return watchList;
    }

    public static void getWatchSysLeftSize() {
        WatchManagerDemo.getInstance().getWatchSysLeftSize(new OnWatchOpCallback<Long>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.16
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "getWatchSysLeftSize onFailed:" + baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(Long l) {
                Log.i(WatchDemo.TAG, "getWatchSysLeftSize onSuccess:" + l);
            }
        });
    }

    public static void getWatchSystemInfo() {
        ExternalFlashMsgResponse extFlashMsg = DeviceStatusManager.getInstance().getExtFlashMsg(WatchManagerDemo.getInstance().getConnectedDevice());
        if (extFlashMsg == null) {
            return;
        }
        extFlashMsg.getScreenWidth();
        extFlashMsg.getScreenHeight();
    }

    public static void listWatchs() {
        WatchManagerDemo.getInstance().listWatchList(new OnWatchOpCallback<ArrayList<FatFile>>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.1
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "listWatchs onFailed:" + baseError);
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(ArrayList<FatFile> arrayList) {
                WatchDemo.watchList = arrayList;
                int iC = fz.c(arrayList);
                if (iC > 0) {
                    String[] strArr = new String[iC];
                    for (int i = 0; i < arrayList.size(); i++) {
                        FatFile fatFile = arrayList.get(i);
                        Log.i(WatchDemo.TAG, "fatFile:" + fatFile);
                        strArr[i] = fatFile.getName();
                    }
                    ToastUtils.s(Arrays.toString(strArr));
                }
            }
        });
    }

    public static void readWatch(String str) {
        WatchManagerDemo.getInstance().openWatchFile(str, new OnWatchOpCallback<byte[]>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.4
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "readWatch onFailed:" + baseError.toString());
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(byte[] bArr) {
                Log.i(WatchDemo.TAG, "readWatch onSuccess:" + bArr);
            }
        });
    }

    public static void restoreSystem() {
        final WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
        watchManagerDemo.registerOnWatchCallback(new OnWatchCallback() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.11
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchCallback
            public void onWatchSystemException(BluetoothDevice bluetoothDevice, int i) {
                Log.i(WatchDemo.TAG, "restoreSystem onWatchSystemException sysStatus:" + i);
                if (i != 0) {
                    watchManagerDemo.restoreWatchSystem(new OnFatFileProgressListener() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.11.1
                        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                        public void onProgress(float f) {
                            Log.i(WatchDemo.TAG, "restoreSystem onWatchSystemException progress" + f);
                        }

                        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                        public void onStart(String str) {
                            Log.i(WatchDemo.TAG, "restoreSystem onWatchSystemException onStart" + str);
                        }

                        @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                        public void onStop(int i2) {
                            Log.i(WatchDemo.TAG, "restoreSystem onWatchSystemException onStop:" + i2);
                        }
                    });
                }
            }
        });
    }

    public static void setCurrentWatch(String str) {
        WatchManagerDemo.getInstance().setCurrentWatchInfo(str, new OnWatchOpCallback<FatFile>() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.7
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onFailed(BaseError baseError) {
                Log.i(WatchDemo.TAG, "setCurrentWatch onFailed:" + baseError.toString());
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
            public void onSuccess(FatFile fatFile) {
                Log.i(WatchDemo.TAG, "setCurrentWatch onSuccess:" + fatFile);
            }
        });
    }

    public static void testMandatoryOTA() {
        final WatchManagerDemo watchManagerDemo = WatchManagerDemo.getInstance();
        watchManagerDemo.registerOnWatchCallback(new OnWatchCallback() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.15
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onMandatoryUpgrade(BluetoothDevice bluetoothDevice) {
                if (watchManagerDemo.getDeviceInfo(bluetoothDevice).isSupportDoubleBackup()) {
                    return;
                }
                WatchFileUtil.obtainUpdateFilePath("存放资源升级文件的文件夹路径", ".ufw");
            }
        });
    }

    public static void updateResource(String str) {
        WatchManagerDemo.getInstance().updateWatchResource(str, new OnUpdateResourceCallback() { // from class: xfkj.fitpro.activity.ota.jieli.WatchDemo.10
            @Override // com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback
            public void onError(int i, String str2) {
                Log.i(WatchDemo.TAG, "updateResource onError code:" + i + ";message:" + str2);
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback
            public void onProgress(int i, String str2, float f) {
                Log.i(WatchDemo.TAG, "updateResource onProgress:" + f);
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback
            public void onStart(String str2, int i) {
                Log.i(WatchDemo.TAG, "updateResource onStart:" + i);
            }

            @Override // com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback
            public void onStop(String str2) {
                Log.i(WatchDemo.TAG, "updateResource onStop:" + str2);
            }
        });
    }
}
