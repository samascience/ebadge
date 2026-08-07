package defpackage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class dq3 {
    private static dq3 h;
    private SQLiteDatabase a = null;
    private boolean b = false;
    a c = null;
    a d = null;
    private String e = null;
    private int f = -2;
    private static Object g = new Object();
    private static final String i = fq3.D() + "/hst.db";

    class a extends np3 {
        private String k = null;
        private String l = null;
        private boolean m = true;
        private boolean n = false;

        a() {
            this.d = new HashMap();
        }

        @Override // defpackage.np3
        public void a() {
            this.b = 1;
            String strG = Jni.g(this.l);
            this.l = null;
            this.d.put("bloc", strG);
        }

        @Override // defpackage.np3
        public void d(boolean z) {
            String str;
            if (z && (str = this.c) != null) {
                try {
                    if (this.m) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
                        if (jSONObject2 != null && jSONObject2.has("imo")) {
                            Long lValueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
                            int i = jSONObject2.getJSONObject("imo").getInt("mv");
                            if (Jni.f(this.k).longValue() == lValueOf.longValue()) {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                                contentValues.put("hst", Integer.valueOf(i));
                                try {
                                    if (dq3.this.a.update("hstdata", contentValues, "id = \"" + lValueOf + "\"", null) <= 0) {
                                        contentValues.put("id", lValueOf);
                                        dq3.this.a.insert("hstdata", null, contentValues);
                                    }
                                } catch (Exception unused) {
                                }
                                Bundle bundle = new Bundle();
                                bundle.putByteArray("mac", this.k.getBytes());
                                bundle.putInt("hotspot", i);
                                dq3.this.d(bundle);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            } else if (this.m) {
                dq3.this.n();
            }
            Map map = this.d;
            if (map != null) {
                map.clear();
            }
            dq3.this.b = false;
        }

        public void f(String str, String str2) {
            if (dq3.this.b) {
                return;
            }
            dq3.this.b = true;
            this.k = str;
            this.l = str2;
            ExecutorService executorServiceC = xq3.a().c();
            if (executorServiceC != null) {
                b(executorServiceC, fp3.a);
            } else {
                e(fp3.a);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004e  */
    private String b(boolean z) {
        String strT;
        bn3 bn3VarV = so3.h().v();
        eq3 eq3VarW = jq3.c().w();
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (bn3VarV != null && bn3VarV.c()) {
            stringBuffer.append(bn3VarV.i());
        }
        if (eq3VarW == null || eq3VarW.a() <= 1) {
            if (jq3.c().t() != null) {
                strT = jq3.c().t();
            }
            if (z) {
                stringBuffer.append("&imo=1");
            }
            stringBuffer.append(mp3.f().s0());
            stringBuffer.append(to3.a().b(false));
            stringBuffer.append(ro3.b().l());
            return stringBuffer.toString();
        }
        strT = eq3VarW.b(15);
        stringBuffer.append(strT);
        if (z) {
            stringBuffer.append("&imo=1");
        }
        stringBuffer.append(mp3.f().s0());
        stringBuffer.append(to3.a().b(false));
        stringBuffer.append(ro3.b().l());
        return stringBuffer.toString();
    }

    public static dq3 c() {
        dq3 dq3Var;
        synchronized (g) {
            try {
                if (h == null) {
                    h = new dq3();
                }
                dq3Var = h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dq3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Bundle bundle) {
        ro3.b().c(bundle, 406);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        d(bundle);
    }

    public void e(String str) {
        if (this.b) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has("content") ? jSONObject.getJSONObject("content") : null;
            if (jSONObject2 == null || !jSONObject2.has("imo")) {
                return;
            }
            Long lValueOf = Long.valueOf(jSONObject2.getJSONObject("imo").getString("mac"));
            int i2 = jSONObject2.getJSONObject("imo").getInt("mv");
            ContentValues contentValues = new ContentValues();
            contentValues.put("tt", Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
            contentValues.put("hst", Integer.valueOf(i2));
            if (this.a.update("hstdata", contentValues, "id = \"" + lValueOf + "\"", null) <= 0) {
                contentValues.put("id", lValueOf);
                this.a.insert("hstdata", null, contentValues);
            }
        } catch (Exception unused) {
        }
    }

    public void h() {
        try {
            File file = new File(i);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
                this.a = sQLiteDatabaseOpenOrCreateDatabase;
                sQLiteDatabaseOpenOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);");
                this.a.setVersion(1);
            }
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public void j() {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            } catch (Exception unused) {
            } finally {
                this.a = null;
            }
        }
    }

    public synchronized int l() {
        WifiInfo wifiInfoS;
        int i2;
        int i3 = -3;
        if (this.b) {
            return -3;
        }
        try {
            if (jq3.c().q() && this.a != null && (wifiInfoS = jq3.c().s()) != null && wifiInfoS.getBSSID() != null) {
                String strReplace = wifiInfoS.getBSSID().replace(":", Constants.STR_EMPTY);
                Long lF = Jni.f(strReplace);
                String str = this.e;
                if (str == null || !strReplace.equals(str) || (i2 = this.f) <= -2) {
                    Cursor cursorRawQuery = null;
                    try {
                        cursorRawQuery = this.a.rawQuery("select * from hstdata where id = \"" + lF + "\";", null);
                        if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                            i3 = -2;
                        } else {
                            i3 = cursorRawQuery.getInt(1);
                            this.e = strReplace;
                            this.f = i3;
                        }
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } catch (Exception unused) {
                        if (cursorRawQuery != null) {
                        }
                    } catch (Throwable th) {
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } else {
                    i3 = i2;
                }
            }
        } catch (Exception unused3) {
        }
        this.f = i3;
        return i3;
    }

    public void m() {
        WifiInfo wifiInfoS;
        if (this.b) {
            return;
        }
        try {
            if (!jq3.c().q() || this.a == null || (wifiInfoS = jq3.c().s()) == null || wifiInfoS.getBSSID() == null) {
                n();
                return;
            }
            String strReplace = wifiInfoS.getBSSID().replace(":", Constants.STR_EMPTY);
            Long lF = Jni.f(strReplace);
            Cursor cursorRawQuery = null;
            boolean z = false;
            try {
                cursorRawQuery = this.a.rawQuery("select * from hstdata where id = \"" + lF + "\";", null);
                if (cursorRawQuery == null || !cursorRawQuery.moveToFirst()) {
                    z = true;
                } else {
                    int i2 = cursorRawQuery.getInt(1);
                    if ((System.currentTimeMillis() / 1000) - ((long) cursorRawQuery.getInt(2)) > 259200) {
                        z = true;
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("mac", strReplace.getBytes());
                        bundle.putInt("hotspot", i2);
                        d(bundle);
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
            if (z) {
                if (this.c == null) {
                    this.c = new a();
                }
                a aVar = this.c;
                if (aVar != null) {
                    aVar.f(strReplace, b(true));
                }
            }
        } catch (Exception unused4) {
        }
    }
}
