package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ux0 implements y50 {
    static final b g = new a();
    private final su0 a;
    private final int b;
    private final b c;
    private HttpURLConnection d;
    private InputStream e;
    private volatile boolean f;

    private static class a implements b {
        a() {
        }

        @Override // ux0.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url);
    }

    public ux0(su0 su0Var, int i) {
        this(su0Var, i, g);
    }

    private HttpURLConnection c(URL url, Map map) throws HttpException {
        try {
            HttpURLConnection httpURLConnectionA = this.c.a(url);
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.b);
            httpURLConnectionA.setReadTimeout(this.b);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e) {
            throw new HttpException("URL.openConnection threw", 0, e);
        }
    }

    private static int f(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e);
            return -1;
        }
    }

    private InputStream g(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.e = g30.u(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.e = httpURLConnection.getInputStream();
            }
            return this.e;
        } catch (IOException e) {
            throw new HttpException("Failed to obtain InputStream", f(httpURLConnection), e);
        }
    }

    private static boolean h(int i) {
        return i / 100 == 2;
    }

    private static boolean i(int i) {
        return i / 100 == 3;
    }

    private InputStream j(URL url, int i, URL url2, Map map) throws HttpException {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionC = c(url, map);
        this.d = httpURLConnectionC;
        try {
            httpURLConnectionC.connect();
            this.e = this.d.getInputStream();
            if (this.f) {
                return null;
            }
            int iF = f(this.d);
            if (h(iF)) {
                return g(this.d);
            }
            if (!i(iF)) {
                if (iF == -1) {
                    throw new HttpException(iF);
                }
                try {
                    throw new HttpException(this.d.getResponseMessage(), iF);
                } catch (IOException e) {
                    throw new HttpException("Failed to get a response message", iF, e);
                }
            }
            String headerField = this.d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url", iF);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return j(url3, i + 1, url, map);
            } catch (MalformedURLException e2) {
                throw new HttpException("Bad redirect url: " + headerField, iF, e2);
            }
        } catch (IOException e3) {
            throw new HttpException("Failed to connect or obtain data", f(this.d), e3);
        }
    }

    @Override // defpackage.y50
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.y50
    public void b() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.d = null;
    }

    @Override // defpackage.y50
    public void cancel() {
        this.f = true;
    }

    @Override // defpackage.y50
    public DataSource d() {
        return DataSource.REMOTE;
    }

    @Override // defpackage.y50
    public void e(Priority priority, y50.a aVar) {
        StringBuilder sb;
        long jB = cd1.b();
        try {
            aVar.f(j(this.a.f(), 0, null, this.a.c()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(cd1.a(jB));
                String string = sb.toString();
            }
        } catch (IOException e) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e);
            }
            aVar.c(e);
            if (!Log.isLoggable("HttpUrlFetcher", 2)) {
            } else {
                sb = new StringBuilder();
            }
        } finally {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + cd1.a(jB));
            }
        }
    }

    ux0(su0 su0Var, int i, b bVar) {
        this.a = su0Var;
        this.b = i;
        this.c = bVar;
    }
}
