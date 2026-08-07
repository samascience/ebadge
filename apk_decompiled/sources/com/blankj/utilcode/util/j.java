package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.ap2;
import defpackage.e43;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    private static SimpleDateFormat e;
    private static final char[] a = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static final String b = System.getProperty("file.separator");
    private static final String c = System.getProperty("line.separator");
    private static final d d = new d(null);
    private static final ExecutorService f = Executors.newSingleThreadExecutor();
    private static final ap2 g = new ap2();

    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ i b;
        final /* synthetic */ String c;

        a(int i, i iVar, String str) {
            this.a = i;
            this.b = iVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.A(this.a, this.b.a, this.b.c + this.c);
        }
    }

    class b implements FilenameFilter {
        b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return j.w(str);
        }
    }

    class c implements Runnable {
        final /* synthetic */ File a;

        c(File file) {
            this.a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.delete()) {
                return;
            }
            Log.e("LogUtils", "delete " + this.a + " failed!");
        }
    }

    public static final class d {
        private String a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private boolean f;
        private String g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private int m;
        private int n;
        private int o;
        private int p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f221q;
        private String r;
        private q.a s;

        /* synthetic */ d(a aVar) {
            this();
        }

        static /* synthetic */ g d(d dVar) {
            dVar.getClass();
            return null;
        }

        static /* synthetic */ e f(d dVar) {
            dVar.getClass();
            return null;
        }

        static /* synthetic */ h g(d dVar) {
            dVar.getClass();
            return null;
        }

        public final d A(int i) {
            this.n = i;
            return this;
        }

        public final d B(String str) {
            if (q.H(str)) {
                this.g = Constants.STR_EMPTY;
                this.h = true;
            } else {
                this.g = str;
                this.h = false;
            }
            return this;
        }

        public final d C(boolean z) {
            this.j = z;
            return this;
        }

        public final d D(boolean z) {
            this.i = z;
            return this;
        }

        public final d E(boolean z) {
            this.e = z;
            return this;
        }

        public final d F(int i) {
            this.f221q = i;
            return this;
        }

        public final char h() {
            return j.a[this.m - 2];
        }

        public final String i() {
            String str = this.b;
            return str == null ? this.a : str;
        }

        public final String j() {
            return this.d;
        }

        public final char k() {
            return j.a[this.n - 2];
        }

        public final String l() {
            return this.c;
        }

        public final String m() {
            return q.H(this.g) ? Constants.STR_EMPTY : this.g;
        }

        public final String n() {
            String str = this.r;
            return str == null ? Constants.STR_EMPTY : str.replace(":", "_");
        }

        public final int o() {
            return this.f221q;
        }

        public final int p() {
            return this.o;
        }

        public final int q() {
            return this.p;
        }

        public final boolean r() {
            return this.f;
        }

        public final boolean s() {
            return this.j;
        }

        public final boolean t() {
            return this.k;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("process: ");
            sb.append(n());
            sb.append(j.c);
            sb.append("logSwitch: ");
            sb.append(v());
            sb.append(j.c);
            sb.append("consoleSwitch: ");
            sb.append(r());
            sb.append(j.c);
            sb.append("tag: ");
            sb.append(m().equals(Constants.STR_EMPTY) ? "null" : m());
            sb.append(j.c);
            sb.append("headSwitch: ");
            sb.append(u());
            sb.append(j.c);
            sb.append("fileSwitch: ");
            sb.append(s());
            sb.append(j.c);
            sb.append("dir: ");
            sb.append(i());
            sb.append(j.c);
            sb.append("filePrefix: ");
            sb.append(l());
            sb.append(j.c);
            sb.append("borderSwitch: ");
            sb.append(t());
            sb.append(j.c);
            sb.append("singleTagSwitch: ");
            sb.append(w());
            sb.append(j.c);
            sb.append("consoleFilter: ");
            sb.append(h());
            sb.append(j.c);
            sb.append("fileFilter: ");
            sb.append(k());
            sb.append(j.c);
            sb.append("stackDeep: ");
            sb.append(p());
            sb.append(j.c);
            sb.append("stackOffset: ");
            sb.append(q());
            sb.append(j.c);
            sb.append("saveDays: ");
            sb.append(o());
            sb.append(j.c);
            sb.append("formatter: ");
            sb.append(j.g);
            sb.append(j.c);
            sb.append("fileWriter: ");
            sb.append((Object) null);
            sb.append(j.c);
            sb.append("onConsoleOutputListener: ");
            sb.append((Object) null);
            sb.append(j.c);
            sb.append("onFileOutputListener: ");
            sb.append((Object) null);
            sb.append(j.c);
            sb.append("fileExtraHeader: ");
            sb.append(this.s.c());
            return sb.toString();
        }

        public final boolean u() {
            return this.i;
        }

        public final boolean v() {
            return this.e;
        }

        public final boolean w() {
            return this.l;
        }

        public final d x(boolean z) {
            this.k = z;
            return this;
        }

        public final d y(boolean z) {
            this.f = z;
            return this;
        }

        public final d z(String str) {
            if (q.H(str)) {
                this.b = null;
            } else {
                if (!str.endsWith(j.b)) {
                    str = str + j.b;
                }
                this.b = str;
            }
            return this;
        }

        private d() {
            this.c = "util";
            this.d = ".txt";
            this.e = true;
            this.f = true;
            this.g = Constants.STR_EMPTY;
            this.h = true;
            this.i = true;
            this.j = false;
            this.k = true;
            this.l = true;
            this.m = 2;
            this.n = 2;
            this.o = 1;
            this.p = 0;
            this.f221q = -1;
            this.r = q.m();
            this.s = new q.a("Log");
            if (!q.G() || o.a().getExternalFilesDir(null) == null) {
                this.a = o.a().getFilesDir() + j.b + "log" + j.b;
                return;
            }
            this.a = o.a().getExternalFilesDir(null) + j.b + "log" + j.b;
        }
    }

    public interface e {
    }

    private static final class f {
        private static String a(Object obj) {
            if (obj instanceof Object[]) {
                return Arrays.deepToString((Object[]) obj);
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }

        private static String b(Bundle bundle) {
            Iterator<String> it = bundle.keySet().iterator();
            if (!it.hasNext()) {
                return "Bundle {}";
            }
            StringBuilder sb = new StringBuilder(128);
            sb.append("Bundle { ");
            while (true) {
                String next = it.next();
                Object obj = bundle.get(next);
                sb.append(next);
                sb.append('=');
                if (obj instanceof Bundle) {
                    sb.append(obj == bundle ? "(this Bundle)" : b((Bundle) obj));
                } else {
                    sb.append(j.n(obj));
                }
                if (!it.hasNext()) {
                    sb.append(" }");
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        }

        private static void c(ClipData clipData, StringBuilder sb) {
            ClipData.Item itemAt = clipData.getItemAt(0);
            if (itemAt == null) {
                sb.append("ClipData.Item {}");
                return;
            }
            sb.append("ClipData.Item { ");
            String htmlText = itemAt.getHtmlText();
            if (htmlText != null) {
                sb.append("H:");
                sb.append(htmlText);
                sb.append("}");
                return;
            }
            CharSequence text = itemAt.getText();
            if (text != null) {
                sb.append("T:");
                sb.append(text);
                sb.append("}");
                return;
            }
            Uri uri = itemAt.getUri();
            if (uri != null) {
                sb.append("U:");
                sb.append(uri);
                sb.append("}");
                return;
            }
            Intent intent = itemAt.getIntent();
            if (intent == null) {
                sb.append("NULL");
                sb.append("}");
            } else {
                sb.append("I:");
                sb.append(e(intent));
                sb.append("}");
            }
        }

        private static String d(String str) {
            try {
                StreamSource streamSource = new StreamSource(new StringReader(str));
                StreamResult streamResult = new StreamResult(new StringWriter());
                Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
                transformerNewTransformer.setOutputProperty("indent", "yes");
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                transformerNewTransformer.transform(streamSource, streamResult);
                return streamResult.getWriter().toString().replaceFirst(">", ">" + j.c);
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }

        private static String e(Intent intent) {
            boolean z;
            StringBuilder sb = new StringBuilder(128);
            sb.append("Intent { ");
            String action = intent.getAction();
            boolean z2 = false;
            boolean z3 = true;
            if (action != null) {
                sb.append("act=");
                sb.append(action);
                z = false;
            } else {
                z = true;
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cat=[");
                for (String str : categories) {
                    if (!z3) {
                        sb.append(',');
                    }
                    sb.append(str);
                    z3 = false;
                }
                sb.append("]");
                z = false;
            }
            Uri data = intent.getData();
            if (data != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("dat=");
                sb.append(data);
                z = false;
            }
            String type = intent.getType();
            if (type != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("typ=");
                sb.append(type);
                z = false;
            }
            int flags = intent.getFlags();
            if (flags != 0) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("flg=0x");
                sb.append(Integer.toHexString(flags));
                z = false;
            }
            String str2 = intent.getPackage();
            if (str2 != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("pkg=");
                sb.append(str2);
                z = false;
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("cmp=");
                sb.append(component.flattenToShortString());
                z = false;
            }
            Rect sourceBounds = intent.getSourceBounds();
            if (sourceBounds != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("bnds=");
                sb.append(sourceBounds.toShortString());
                z = false;
            }
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                if (!z) {
                    sb.append(' ');
                }
                c(clipData, sb);
                z = false;
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                if (!z) {
                    sb.append(' ');
                }
                sb.append("extras={");
                sb.append(b(extras));
                sb.append('}');
            } else {
                z2 = z;
            }
            Intent selector = intent.getSelector();
            if (selector != null) {
                if (!z2) {
                    sb.append(' ');
                }
                sb.append("sel={");
                sb.append(selector == intent ? "(this Intent)" : e(selector));
                sb.append("}");
            }
            sb.append(" }");
            return sb.toString();
        }

        private static String f(Object obj) {
            if (obj instanceof CharSequence) {
                return q.i(obj.toString());
            }
            try {
                return q.p().toJson(obj);
            } catch (Throwable unused) {
                return obj.toString();
            }
        }

        static String g(Object obj) {
            return h(obj, -1);
        }

        static String h(Object obj, int i) {
            if (obj.getClass().isArray()) {
                return a(obj);
            }
            if (obj instanceof Throwable) {
                return q.o((Throwable) obj);
            }
            if (obj instanceof Bundle) {
                return b((Bundle) obj);
            }
            if (obj instanceof Intent) {
                return e((Intent) obj);
            }
            if (i == 32) {
                return f(obj);
            }
            return i == 48 ? d(obj.toString()) : obj.toString();
        }
    }

    public interface g {
    }

    public interface h {
    }

    private static final class i {
        String a;
        String[] b;
        String c;

        i(String str, String[] strArr, String str2) {
            this.a = str;
            this.b = strArr;
            this.c = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(int i2, String str, String str2) {
        Date date = new Date();
        String str3 = s().format(date);
        String strSubstring = str3.substring(0, 10);
        String strQ = q(date);
        if (!h(strQ, strSubstring)) {
            Log.e("LogUtils", "create " + strQ + " failed!");
            return;
        }
        v(strQ, str3.substring(11) + a[i2 - 2] + WatchConstant.FAT_FS_ROOT + str + str2 + c);
    }

    private static void B(int i2, String str, boolean z) {
        if (d.t()) {
            y(i2, str, z ? "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────" : "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        }
    }

    private static void C(String str, String str2) {
        d dVar = d;
        dVar.s.a("Date of Log", str2);
        v(str, dVar.s.toString());
    }

    private static void D(int i2, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (d.t()) {
                    str2 = "│ " + str2;
                }
                y(i2, str, str2);
            }
            if (d.t()) {
                y(i2, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
            }
        }
    }

    private static void E(int i2, String str, String str2) {
        int length = str2.length();
        int i3 = length / 1100;
        if (i3 <= 0) {
            G(i2, str, str2);
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 1100;
            G(i2, str, str2.substring(i5, i6));
            i4++;
            i5 = i6;
        }
        if (i5 != length) {
            G(i2, str, str2.substring(i5, length));
        }
    }

    private static void F(int i2, String str, String str2) {
        int length = str2.length();
        d dVar = d;
        int i3 = 1100;
        int i4 = dVar.t() ? (length - 113) / 1100 : length / 1100;
        if (i4 <= 0) {
            y(i2, str, str2);
            return;
        }
        int i5 = 1;
        if (!dVar.t()) {
            y(i2, str, str2.substring(0, 1100));
            while (i5 < i4) {
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(c);
                int i6 = i3 + 1100;
                sb.append(str2.substring(i3, i6));
                y(i2, str, sb.toString());
                i5++;
                i3 = i6;
            }
            if (i3 != length) {
                y(i2, str, " " + c + str2.substring(i3, length));
                return;
            }
            return;
        }
        y(i2, str, str2.substring(0, 1100) + c + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        while (i5 < i4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            String str3 = c;
            sb2.append(str3);
            sb2.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb2.append(str3);
            sb2.append("│ ");
            int i7 = i3 + 1100;
            sb2.append(str2.substring(i3, i7));
            sb2.append(str3);
            sb2.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            y(i2, str, sb2.toString());
            i5++;
            i3 = i7;
        }
        if (i3 != length - 113) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" ");
            String str4 = c;
            sb3.append(str4);
            sb3.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb3.append(str4);
            sb3.append("│ ");
            sb3.append(str2.substring(i3, length));
            y(i2, str, sb3.toString());
        }
    }

    private static void G(int i2, String str, String str2) {
        if (!d.t()) {
            y(i2, str, str2);
            return;
        }
        for (String str3 : str2.split(c)) {
            y(i2, str, "│ " + str3);
        }
    }

    private static String H(int i2, Object... objArr) {
        String string;
        if (objArr != null) {
            if (objArr.length == 1) {
                string = m(i2, objArr[0]);
            } else {
                StringBuilder sb = new StringBuilder();
                int length = objArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj = objArr[i3];
                    sb.append("args");
                    sb.append("[");
                    sb.append(i3);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(n(obj));
                    sb.append(c);
                }
                string = sb.toString();
            }
        } else {
            string = "null";
        }
        return string.length() == 0 ? "log nothing" : string;
    }

    private static String I(int i2, String str, String[] strArr, String str2) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        if (d.t()) {
            sb.append(" ");
            String str3 = c;
            sb.append(str3);
            sb.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
            sb.append(str3);
            if (strArr != null) {
                for (String str4 : strArr) {
                    sb.append("│ ");
                    sb.append(str4);
                    sb.append(c);
                }
                sb.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
                sb.append(c);
            }
            String[] strArrSplit = str2.split(c);
            int length = strArrSplit.length;
            while (i3 < length) {
                String str5 = strArrSplit[i3];
                sb.append("│ ");
                sb.append(str5);
                sb.append(c);
                i3++;
            }
            sb.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        } else {
            if (strArr != null) {
                sb.append(" ");
                sb.append(c);
                int length2 = strArr.length;
                while (i3 < length2) {
                    sb.append(strArr[i3]);
                    sb.append(c);
                    i3++;
                }
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    private static i J(String str) {
        d dVar = d;
        if (dVar.h || dVar.u()) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int iQ = dVar.q() + 3;
            if (iQ >= stackTrace.length) {
                String strR = r(stackTrace[3]);
                if (dVar.h && q.H(str)) {
                    int iIndexOf = strR.indexOf(46);
                    str = iIndexOf == -1 ? strR : strR.substring(0, iIndexOf);
                }
                return new i(str, null, ": ");
            }
            StackTraceElement stackTraceElement = stackTrace[iQ];
            String strR2 = r(stackTraceElement);
            if (dVar.h && q.H(str)) {
                int iIndexOf2 = strR2.indexOf(46);
                str = iIndexOf2 == -1 ? strR2 : strR2.substring(0, iIndexOf2);
            }
            if (dVar.u()) {
                String name = Thread.currentThread().getName();
                String string = new Formatter().format("%s, %s.%s(%s:%d)", name, stackTraceElement.getClassName(), stackTraceElement.getMethodName(), strR2, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                String str2 = " [" + string + "]: ";
                if (dVar.p() <= 1) {
                    return new i(str, new String[]{string}, str2);
                }
                int iMin = Math.min(dVar.p(), stackTrace.length - iQ);
                String[] strArr = new String[iMin];
                strArr[0] = string;
                int length = name.length() + 2;
                String string2 = new Formatter().format("%" + length + "s", Constants.STR_EMPTY).toString();
                for (int i2 = 1; i2 < iMin; i2++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2 + iQ];
                    strArr[i2] = new Formatter().format("%s%s.%s(%s:%d)", string2, stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), r(stackTraceElement2), Integer.valueOf(stackTraceElement2.getLineNumber())).toString();
                }
                return new i(str, strArr, str2);
            }
        } else {
            str = dVar.m();
        }
        return new i(str, null, ": ");
    }

    private static boolean h(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!q.c(file.getParentFile())) {
            return false;
        }
        try {
            i(str, str2);
            boolean zCreateNewFile = file.createNewFile();
            if (zCreateNewFile) {
                C(str, str2);
            }
            return zCreateNewFile;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void i(String str, String str2) {
        File[] fileArrListFiles;
        d dVar = d;
        if (dVar.o() > 0 && (fileArrListFiles = new File(str).getParentFile().listFiles(new b())) != null && fileArrListFiles.length > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
            try {
                long time = simpleDateFormat.parse(str2).getTime() - (((long) dVar.o()) * 86400000);
                for (File file : fileArrListFiles) {
                    String name = file.getName();
                    name.length();
                    if (simpleDateFormat.parse(l(name)).getTime() <= time) {
                        f.execute(new c(file));
                    }
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void j(Object... objArr) {
        x(6, d.m(), objArr);
    }

    public static void k(String str, Object... objArr) {
        x(6, str, objArr);
    }

    private static String l(String str) {
        Matcher matcher = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(str);
        return matcher.find() ? matcher.group() : Constants.STR_EMPTY;
    }

    private static String m(int i2, Object obj) {
        if (obj == null) {
            return "null";
        }
        if (i2 == 32) {
            return f.h(obj, 32);
        }
        return i2 == 48 ? f.h(obj, 48) : n(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String n(Object obj) {
        if (obj == null) {
            return "null";
        }
        ap2 ap2Var = g;
        if (!ap2Var.isEmpty()) {
            e43.a(ap2Var.get(o(obj)));
        }
        return f.g(obj);
    }

    private static Class o(Object obj) {
        String string;
        Class<?> cls = obj.getClass();
        if (cls.isAnonymousClass() || cls.isSynthetic()) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces.length == 1) {
                Type rawType = genericInterfaces[0];
                while (rawType instanceof ParameterizedType) {
                    rawType = ((ParameterizedType) rawType).getRawType();
                }
                string = rawType.toString();
            } else {
                Type genericSuperclass = cls.getGenericSuperclass();
                while (genericSuperclass instanceof ParameterizedType) {
                    genericSuperclass = ((ParameterizedType) genericSuperclass).getRawType();
                }
                string = genericSuperclass.toString();
            }
            if (string.startsWith("class ")) {
                string = string.substring(6);
            } else if (string.startsWith("interface ")) {
                string = string.substring(10);
            }
            try {
                return Class.forName(string);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return cls;
    }

    public static d p() {
        return d;
    }

    private static String q(Date date) {
        String strSubstring = s().format(date).substring(0, 10);
        StringBuilder sb = new StringBuilder();
        d dVar = d;
        sb.append(dVar.i());
        sb.append(dVar.l());
        sb.append("_");
        sb.append(strSubstring);
        sb.append("_");
        sb.append(dVar.n());
        sb.append(dVar.j());
        return sb.toString();
    }

    private static String r(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] strArrSplit = className.split("\\.");
        if (strArrSplit.length > 0) {
            className = strArrSplit[strArrSplit.length - 1];
        }
        int iIndexOf = className.indexOf(36);
        if (iIndexOf != -1) {
            className = className.substring(0, iIndexOf);
        }
        return className + ".java";
    }

    private static SimpleDateFormat s() {
        if (e == null) {
            e = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
        }
        return e;
    }

    public static void t(Object... objArr) {
        x(4, d.m(), objArr);
    }

    public static void u(String str, Object... objArr) {
        x(4, str, objArr);
    }

    private static void v(String str, String str2) {
        d dVar = d;
        d.f(dVar);
        q.T(str, str2, true);
        d.g(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(String str) {
        return str.matches("^" + d.l() + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }

    public static void x(int i2, String str, Object... objArr) {
        d dVar = d;
        if (dVar.v()) {
            int i3 = i2 & 15;
            int i4 = i2 & 240;
            if (dVar.r() || dVar.s() || i4 == 16) {
                if (i3 >= dVar.m || i3 >= dVar.n) {
                    i iVarJ = J(str);
                    String strH = H(i4, objArr);
                    if (dVar.r() && i4 != 16 && i3 >= dVar.m) {
                        z(i3, iVarJ.a, iVarJ.b, strH);
                    }
                    if ((dVar.s() || i4 == 16) && i3 >= dVar.n) {
                        f.execute(new a(i3, iVarJ, strH));
                    }
                }
            }
        }
    }

    private static void y(int i2, String str, String str2) {
        Log.println(i2, str, str2);
        d.d(d);
    }

    private static void z(int i2, String str, String[] strArr, String str2) {
        if (d.w()) {
            F(i2, str, I(i2, str, strArr, str2));
            return;
        }
        B(i2, str, true);
        D(i2, str, strArr);
        E(i2, str, str2);
        B(i2, str, false);
    }
}
