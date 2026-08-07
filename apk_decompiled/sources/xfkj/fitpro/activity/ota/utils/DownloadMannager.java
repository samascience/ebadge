package xfkj.fitpro.activity.ota.utils;

import android.util.Log;
import com.blankj.utilcode.util.g;
import com.blankj.utilcode.util.l;
import com.blankj.utilcode.util.r;
import com.tencent.connect.common.Constants;
import defpackage.df2;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import xfkj.fitpro.activity.ota.api.NetWorkManager;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadMannager {
    private static final String TAG = "DownloadMannager";
    DownLoadListener mDownLoadListener;

    public interface DownLoadListener {
        void onFailed(String str);

        void onStartDownload();

        void onSuccess(String str, String str2);
    }

    private void failed(final String str) {
        if (this.mDownLoadListener != null) {
            r.c(new Runnable() { // from class: ad0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$failed$2(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$failed$2(String str) {
        this.mDownLoadListener.onFailed(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1() {
        this.mDownLoadListener.onStartDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownLoad$0(String str, String str2, String str3) {
        try {
            start();
            InputStream inputStreamByteStream = NetWorkManager.getInstance().getOkHttpClient().a(new df2.a().m(str).b()).execute().n().byteStream();
            g.d(str2);
            FileOutputStream fileOutputStream = new FileOutputStream(g.l(str2));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamByteStream);
            byte[] bArr = new byte[102400];
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    inputStreamByteStream.close();
                    success(str2, str3);
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            g.f(str2);
            failed(e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$success$3(String str, String str2) {
        this.mDownLoadListener.onSuccess(str, str2);
    }

    private void start() {
        if (this.mDownLoadListener != null) {
            r.c(new Runnable() { // from class: yc0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$start$1();
                }
            });
        }
    }

    private void success(final String str, final String str2) {
        if (this.mDownLoadListener != null) {
            r.c(new Runnable() { // from class: zc0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.lambda$success$3(str, str2);
                }
            });
        }
    }

    public void setDownLoadListener(DownLoadListener downLoadListener) {
        this.mDownLoadListener = downLoadListener;
    }

    public synchronized void startDownLoad(String str, String str2) {
        startDownLoad(str, str2, Constants.STR_EMPTY);
    }

    public synchronized void startDownLoadByName(String str, String str2) {
        startDownLoad(str, l.c() + File.separator + str2, Constants.STR_EMPTY);
    }

    public synchronized void startDownLoad(final String str, final String str2, final String str3) {
        Log.e(TAG, "startDownLoad 下载地址：" + str);
        new Thread(new Runnable() { // from class: xc0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$startDownLoad$0(str, str2, str3);
            }
        }).start();
    }
}
