package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.onmicro.omtoolbox.BaseActivity;
import com.onmicro.omtoolbox.R$id;
import com.onmicro.omtoolbox.R$layout;
import com.onmicro.omtoolbox.R$string;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class g9 {
    private Context a;
    private String b;
    private String c;
    private int d;
    private ProgressBar e;
    private TextView f;
    private wz g;
    private Dialog h;
    private boolean i;
    private File j;
    private d k;
    private int l;
    private boolean m;
    private e n;

    class a implements wt1 {
        a() {
        }

        public void a(xg xgVar) {
            if (g9.this.h != null) {
                g9.this.h.dismiss();
            }
        }

        @Override // defpackage.wt1
        public void onError(Throwable th) {
            ed1.b("AppUpdateManager", "onError:" + th.getMessage());
            if (g9.this.h != null) {
                g9.this.h.dismiss();
            }
            o33.b(g9.this.a, g9.this.a.getString(R$string.network_no_available));
        }

        @Override // defpackage.wt1
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            e43.a(obj);
            a(null);
        }
    }

    class b implements DialogInterface.OnDismissListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (g9.this.m || g9.this.d != 1) {
                return;
            }
            g9.this.y();
        }
    }

    class c extends Thread {
        c() {
        }

        /* JADX WARN: Code duplicated, block: B:56:0x010a A[Catch: IOException -> 0x00f0, TRY_ENTER, TryCatch #7 {IOException -> 0x00f0, blocks: (B:43:0x00ec, B:47:0x00f4, B:56:0x010a, B:58:0x010f), top: B:80:0x001f }] */
        /* JADX WARN: Code duplicated, block: B:58:0x010f A[Catch: IOException -> 0x00f0, TRY_LEAVE, TryCatch #7 {IOException -> 0x00f0, blocks: (B:43:0x00ec, B:47:0x00f4, B:56:0x010a, B:58:0x010f), top: B:80:0x001f }] */
        /* JADX WARN: Code duplicated, block: B:65:0x011c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:66:0x011e A[Catch: IOException -> 0x011a, TRY_LEAVE, TryCatch #0 {IOException -> 0x011a, blocks: (B:62:0x0116, B:66:0x011e), top: B:76:0x0116 }] */
        /* JADX WARN: Code duplicated, block: B:76:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2;
            if (!TextUtils.isEmpty(g9.this.b)) {
                String strA = xi2.a(g9.this.a, "download_apk");
                if (!TextUtils.isEmpty(strA)) {
                    InputStream inputStream = null;
                    try {
                        try {
                            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(g9.this.b).openConnection();
                            httpURLConnection.setRequestMethod(Constants.HTTP_GET);
                            httpURLConnection.connect();
                            if (httpURLConnection.getResponseCode() == 200) {
                                int contentLength = httpURLConnection.getContentLength();
                                InputStream inputStream2 = httpURLConnection.getInputStream();
                                try {
                                    File file = new File(strA);
                                    if (!file.exists()) {
                                        file.mkdir();
                                    }
                                    g9.this.j = new File(file, "OMToolbox.apk");
                                    if (!g9.this.j.exists()) {
                                        g9.this.j.delete();
                                    }
                                    fileOutputStream2 = new FileOutputStream(g9.this.j);
                                    try {
                                        byte[] bArr = new byte[1024];
                                        long j = 0;
                                        do {
                                            int i = inputStream2.read(bArr);
                                            if (i < 0) {
                                                break;
                                            }
                                            j += (long) i;
                                            Message message = new Message();
                                            message.what = 3;
                                            message.arg1 = (int) ((100 * j) / ((long) contentLength));
                                            g9.this.k.sendMessage(message);
                                            fileOutputStream2.write(bArr, 0, i);
                                        } while (!g9.this.i);
                                        inputStream = inputStream2;
                                    } catch (Exception e) {
                                        fileOutputStream = fileOutputStream2;
                                        e = e;
                                        inputStream = inputStream2;
                                        try {
                                            e.printStackTrace();
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            if (g9.this.g == null) {
                                            } else {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                    if (fileOutputStream != null) {
                                                        fileOutputStream.close();
                                                    }
                                                } catch (IOException e2) {
                                                    e2.printStackTrace();
                                                    throw th;
                                                }
                                            } else if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        fileOutputStream = fileOutputStream2;
                                        th = th2;
                                        inputStream = inputStream2;
                                        if (inputStream != null) {
                                            inputStream.close();
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        } else if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = null;
                                }
                            } else {
                                o33.a(g9.this.a, g9.this.a.getString(R$string.download_failed));
                                fileOutputStream2 = null;
                            }
                            try {
                                httpURLConnection.disconnect();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                            } catch (Exception e4) {
                                fileOutputStream = fileOutputStream2;
                                e = e4;
                                e.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } catch (Throwable th4) {
                                fileOutputStream = fileOutputStream2;
                                th = th4;
                                if (inputStream != null) {
                                    inputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                } else if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                    }
                }
            }
            if (g9.this.g == null && g9.this.g.isShowing()) {
                g9.this.g.dismiss();
            }
        }
    }

    private class d extends Handler {
        WeakReference a;

        public d(BaseActivity baseActivity) {
            this.a = new WeakReference(baseActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (((BaseActivity) this.a.get()) != null) {
                int i = message.what;
                if (i == 1) {
                    g9.this.y();
                    return;
                }
                if (i == 2) {
                    o33.b(g9.this.a, g9.this.a.getString(R$string.lastest_version));
                    return;
                }
                if (i != 3) {
                    return;
                }
                int i2 = message.arg1;
                g9.this.e.setProgress(i2);
                g9.this.f.setText(String.format(Locale.ROOT, "%d%%", Integer.valueOf(i2)));
                if (i2 == 100) {
                    g9.this.m = false;
                    g9.this.i = true;
                    if (g9.this.n != null) {
                        g9.this.n.a(g9.this.j);
                    }
                }
            }
        }
    }

    public interface e {
        void a(File file);
    }

    public g9(Context context) {
        this.a = context;
        if (context instanceof BaseActivity) {
            this.k = new d((BaseActivity) context);
        } else {
            new Throwable("context is must Activity");
        }
    }

    private void t() {
        new c().start();
    }

    private void u() {
        e8.a(new ym1(new a()), "OMToolbox", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(DialogInterface dialogInterface, int i) {
        this.m = true;
        dialogInterface.dismiss();
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        this.g.dismiss();
        this.i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Context context = this.a;
        xz.a(context, context.getString(R$string.version_update), this.c, this.a.getString(R$string.update_now), this.a.getString(R$string.later_on_update), new DialogInterface.OnClickListener() { // from class: e9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.a.v(dialogInterface, i);
            }
        }).setOnDismissListener(new b());
    }

    private void z() {
        wz.a aVar = new wz.a(this.a);
        View viewInflate = LayoutInflater.from(this.a).inflate(R$layout.dialog_download, (ViewGroup) null);
        this.e = (ProgressBar) viewInflate.findViewById(R$id.progressbar);
        this.f = (TextView) viewInflate.findViewById(R$id.tv_progress);
        TextView textView = (TextView) viewInflate.findViewById(R$id.tv_cancel);
        aVar.f(viewInflate);
        textView.setOnClickListener(new View.OnClickListener() { // from class: f9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w(view);
            }
        });
        wz wzVarC = aVar.c();
        this.g = wzVarC;
        wzVarC.show();
        this.g.setCancelable(false);
        t();
    }

    public void s(int i) {
        this.l = i;
        if (i == 1) {
            wz wzVarC = new wz.a(this.a).e(R$layout.dialog_check_version).d(true).c();
            this.h = wzVarC;
            wzVarC.show();
        }
        u();
    }

    public void x(e eVar) {
        this.n = eVar;
    }
}
