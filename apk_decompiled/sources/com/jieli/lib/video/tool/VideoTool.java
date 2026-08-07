package com.jieli.lib.video.tool;

import android.content.Context;
import android.util.Log;
import com.arthenica.ffmpegkit.SessionState;
import com.arthenica.ffmpegkit.b;
import com.jieli.lib.video.tool.model.InputOption;
import com.jieli.lib.video.tool.util.OutputType;
import com.jieli.lib.video.tool.util.ResultCode;
import defpackage.sh2;
import defpackage.yj0;
import defpackage.zj0;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class VideoTool {
    private static volatile boolean mIsLibLoaded = false;
    private static final LibLoader sLocalLibLoader = new LibLoader() { // from class: com.jieli.lib.video.tool.a
        @Override // com.jieli.lib.video.tool.VideoTool.LibLoader
        public final void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    };
    private Context context;
    private long nAddress;
    private OnConversionListener onConversionListener;
    private final String TAG = "VideoTool";
    private InputOption mInputOption = null;

    public interface LibLoader {
        void loadLibrary(String str) throws SecurityException, UnsatisfiedLinkError;
    }

    public VideoTool(Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.context = context;
        loadLibrariesOnce();
        this.nAddress = _init();
    }

    private native boolean _encrypt(long j, String str);

    private native String _getAniCmd(long j, String str, String str2, int i, int i2, int i3);

    private native String _getAviCmd(long j, String str, String str2, int i, int i2, int i3, int i4);

    private native long _init();

    private native void _release(long j);

    private void dispatchResult(ResultCode resultCode, String str) {
        OnConversionListener onConversionListener = this.onConversionListener;
        if (onConversionListener != null) {
            onConversionListener.onResult(resultCode, str);
        }
    }

    public static int getVersionCode() {
        return 3;
    }

    public static String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCmd$0(yj0 yj0Var) {
        SessionState sessionStateO = yj0Var.o();
        sh2 sh2VarN = yj0Var.n();
        if (sessionStateO == SessionState.FAILED || !sh2VarN.c()) {
            Log.e("VideoTool", "Command failed. Please check output for the details.");
            dispatchResult(ResultCode.Failure, "Conversion failure");
            return;
        }
        if (sessionStateO == SessionState.COMPLETED && sh2VarN.c()) {
            InputOption inputOption = this.mInputOption;
            boolean z_encrypt = (inputOption == null || inputOption.getOutputType() != OutputType.ANI) ? true : _encrypt(this.nAddress, this.mInputOption.getOutPath());
            Log.i("VideoTool", "Command OK. And file encryption is " + z_encrypt);
            dispatchResult(z_encrypt ? ResultCode.Success : ResultCode.Failure, z_encrypt ? "Conversion success" : "Failed to encrypt video");
        }
    }

    private static void loadLibrariesOnce() {
        synchronized (VideoTool.class) {
            try {
                if (!mIsLibLoaded) {
                    sLocalLibLoader.loadLibrary("jl_vtool");
                    mIsLibLoaded = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void runCmd(String str) {
        b.c(str, new zj0() { // from class: ud3
            @Override // defpackage.zj0
            public final void a(yj0 yj0Var) {
                this.a.lambda$runCmd$0(yj0Var);
            }
        });
    }

    public void finalize() {
        long j = this.nAddress;
        if (j != 0) {
            _release(j);
        }
    }

    public void release() {
        long j = this.nAddress;
        if (j != 0) {
            _release(j);
        }
        this.nAddress = 0L;
        this.context = null;
    }

    public void setOnConversionListener(OnConversionListener onConversionListener) {
        this.onConversionListener = onConversionListener;
    }

    public boolean tryToCancel() {
        b.a();
        return true;
    }

    public boolean tryToConvert(InputOption inputOption) {
        String str_getAviCmd;
        if (inputOption == null) {
            Log.e("VideoTool", "'InputInfo' cannot be null");
            return false;
        }
        OutputType outputType = inputOption.getOutputType();
        if (OutputType.ANI == outputType) {
            File cacheDir = this.context.getCacheDir();
            if (cacheDir == null) {
                Log.e("VideoTool", "Cannot get tmp dir");
                return false;
            }
            str_getAviCmd = _getAniCmd(this.nAddress, inputOption.getInPath(), cacheDir.getAbsolutePath(), inputOption.getWidth(), inputOption.getHeight(), inputOption.getFrameRate());
        } else {
            if (OutputType.AVI != outputType) {
                Log.e("VideoTool", "Not support output type:" + outputType);
                return false;
            }
            str_getAviCmd = _getAviCmd(this.nAddress, inputOption.getInPath(), inputOption.getOutPath(), inputOption.getWidth(), inputOption.getHeight(), inputOption.getFrameRate(), inputOption.getQuality());
        }
        if (str_getAviCmd == null) {
            Log.e("VideoTool", "Fail to get cmd");
            return false;
        }
        this.mInputOption = inputOption;
        runCmd(str_getAviCmd);
        return true;
    }
}
