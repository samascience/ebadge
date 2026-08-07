package defpackage;

import android.content.Context;
import com.airbnb.lottie.network.FileExtension;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
public class wp1 {
    private final Context a;
    private final String b;
    private final co1 c;

    class a implements Callable {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public oe1 call() {
            return wp1.this.f();
        }
    }

    private wp1(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        this.c = new co1(applicationContext, str);
    }

    private pe1 a() {
        return new pe1(new a());
    }

    public static pe1 b(Context context, String str) {
        return new wp1(context, str).a();
    }

    private fe1 c() {
        az1 az1VarA = this.c.a();
        if (az1VarA == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) az1VarA.a;
        InputStream inputStream = (InputStream) az1VarA.b;
        oe1 oe1VarO = fileExtension == FileExtension.Zip ? he1.o(new ZipInputStream(inputStream), this.b) : he1.f(inputStream, this.b);
        if (oe1VarO.b() != null) {
            return (fe1) oe1VarO.b();
        }
        return null;
    }

    private oe1 d() {
        try {
            return e();
        } catch (IOException e) {
            return new oe1((Throwable) e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:22:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:23:0x00c1  */
    private oe1 e() throws IOException {
        FileExtension fileExtension;
        oe1 oe1VarO;
        boolean z;
        o91.b("Fetching " + this.b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.b).openConnection();
        httpURLConnection.setRequestMethod(Constants.HTTP_GET);
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
            String contentType = httpURLConnection.getContentType();
            int iHashCode = contentType.hashCode();
            if (iHashCode == -1248325150) {
                if (contentType.equals(DfuBaseService.MIME_TYPE_ZIP)) {
                    o91.b("Handling zip response.");
                    fileExtension = FileExtension.Zip;
                    oe1VarO = he1.o(new ZipInputStream(new FileInputStream(this.c.e(httpURLConnection.getInputStream(), fileExtension))), this.b);
                }
                if (oe1VarO.b() != null) {
                    this.c.d(fileExtension);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                if (oe1VarO.b() != null) {
                    z = true;
                } else {
                    z = false;
                }
                sb.append(z);
                o91.b(sb.toString());
                return oe1VarO;
            }
            if (iHashCode == -43840953) {
                contentType.equals("application/json");
            }
            o91.b("Received json response.");
            fileExtension = FileExtension.Json;
            oe1VarO = he1.f(new FileInputStream(new File(this.c.e(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.b);
            if (oe1VarO.b() != null) {
                this.c.d(fileExtension);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Completed fetch from network. Success: ");
            if (oe1VarO.b() != null) {
                z = true;
            } else {
                z = false;
            }
            sb2.append(z);
            o91.b(sb2.toString());
            return oe1VarO;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb3 = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new oe1((Throwable) new IllegalArgumentException("Unable to fetch " + this.b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb3)));
            }
            sb3.append(line);
            sb3.append('\n');
        }
    }

    public oe1 f() {
        fe1 fe1VarC = c();
        if (fe1VarC != null) {
            return new oe1(fe1VarC);
        }
        o91.b("Animation for " + this.b + " not found in cache. Fetching from network.");
        return d();
    }
}
