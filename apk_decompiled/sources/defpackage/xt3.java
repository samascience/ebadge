package defpackage;

import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class xt3 implements Runnable {
    private static final gd1 c = new gd1("RevokeAccessOperation", new String[0]);
    private final String a;
    private final au2 b;

    private xt3(String str) {
        a52.e(str);
        this.a = str;
        this.b = new au2(null);
    }

    public static tz1 a(String str) {
        if (str == null) {
            return uz1.a(new Status(4), null);
        }
        xt3 xt3Var = new xt3(str);
        new Thread(xt3Var).start();
        return xt3Var.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.i;
        try {
            String strValueOf = String.valueOf(this.a);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strValueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(strValueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.g;
            } else {
                c.b("Unable to revoke access!", new Object[0]);
            }
            gd1 gd1Var = c;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            gd1Var.a(sb.toString(), new Object[0]);
        } catch (IOException e) {
            gd1 gd1Var2 = c;
            String strValueOf2 = String.valueOf(e.toString());
            gd1Var2.b(strValueOf2.length() != 0 ? "IOException when revoking access: ".concat(strValueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            gd1 gd1Var3 = c;
            String strValueOf3 = String.valueOf(e2.toString());
            gd1Var3.b(strValueOf3.length() != 0 ? "Exception when revoking access: ".concat(strValueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.b.j(status);
    }
}
