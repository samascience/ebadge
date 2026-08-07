package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
abstract class oo0 {
    private static final af1 a = new af1(2);
    private static final Comparator b = new Comparator() { // from class: no0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return oo0.g((byte[]) obj, (byte[]) obj2);
        }
    };

    private interface a {
        static a a(Context context, Uri uri) {
            return new b(context, uri);
        }

        Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    private static class b implements a {
        private final ContentProviderClient a;

        b(Context context, Uri uri) {
            this.a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // oo0.a
        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        @Override // oo0.a
        public void close() {
            ContentProviderClient contentProviderClient = this.a;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }

    private static class c {
        String a;
        String b;
        List c;

        c(String str, String str2, List list) {
            this.a = str;
            this.b = str2;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Objects.equals(this.a, cVar.a) && Objects.equals(this.b, cVar.b) && Objects.equals(this.c, cVar.c);
        }

        public int hashCode() {
            return Objects.hash(this.a, this.b, this.c);
        }
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List d(po0 po0Var, Resources resources) {
        return po0Var.b() != null ? po0Var.b() : uo0.c(resources, po0Var.c());
    }

    static wo0.a e(Context context, List list, CancellationSignal cancellationSignal) {
        l43.a("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                po0 po0Var = (po0) list.get(i);
                ProviderInfo providerInfoF = f(context.getPackageManager(), po0Var, context.getResources());
                if (providerInfoF == null) {
                    return wo0.a.b(1, null);
                }
                arrayList.add(h(context, po0Var, providerInfoF.authority, cancellationSignal));
            }
            return wo0.a.a(0, arrayList);
        } finally {
            l43.b();
        }
    }

    static ProviderInfo f(PackageManager packageManager, po0 po0Var, Resources resources) {
        l43.a("FontProvider.getProvider");
        try {
            List listD = d(po0Var, resources);
            c cVar = new c(po0Var.e(), po0Var.f(), listD);
            ProviderInfo providerInfo = (ProviderInfo) a.c(cVar);
            if (providerInfo != null) {
                l43.b();
                return providerInfo;
            }
            String strE = po0Var.e();
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(po0Var.f())) {
                throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + po0Var.f());
            }
            List listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
            Collections.sort(listB, b);
            for (int i = 0; i < listD.size(); i++) {
                ArrayList arrayList = new ArrayList((Collection) listD.get(i));
                Collections.sort(arrayList, b);
                if (c(listB, arrayList)) {
                    a.d(cVar, providerInfoResolveContentProvider);
                    l43.b();
                    return providerInfoResolveContentProvider;
                }
            }
            l43.b();
            return null;
        } catch (Throwable th) {
            l43.b();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            byte b3 = bArr2[i];
            if (b2 != b3) {
                return b2 - b3;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00de  */
    static wo0.b[] h(Context context, po0 po0Var, String str, CancellationSignal cancellationSignal) {
        boolean z;
        l43.a("FontProvider.query");
        try {
            ArrayList arrayList = new ArrayList();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
            Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            a aVarA = a.a(context, uriBuild);
            Cursor cursorB = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                l43.a("ContentQueryWrapper.query");
                try {
                    cursorB = aVarA.b(uriBuild, strArr, "query = ?", new String[]{po0Var.g()}, null, cancellationSignal);
                    l43.b();
                    if (cursorB != null && cursorB.getCount() > 0) {
                        int columnIndex = cursorB.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursorB.getColumnIndex("_id");
                        int columnIndex3 = cursorB.getColumnIndex("file_id");
                        int columnIndex4 = cursorB.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursorB.getColumnIndex("font_weight");
                        int columnIndex6 = cursorB.getColumnIndex("font_italic");
                        while (cursorB.moveToNext()) {
                            int i = columnIndex != -1 ? cursorB.getInt(columnIndex) : 0;
                            int i2 = columnIndex4 != -1 ? cursorB.getInt(columnIndex4) : 0;
                            Uri uriWithAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorB.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorB.getLong(columnIndex3));
                            int i3 = columnIndex5 != -1 ? cursorB.getInt(columnIndex5) : 400;
                            if (columnIndex6 != -1) {
                                z = true;
                                if (cursorB.getInt(columnIndex6) != 1) {
                                    z = false;
                                }
                            } else {
                                z = false;
                            }
                            wo0.b bVarA = wo0.b.a(uriWithAppendedId, i2, i3, z, i);
                            arrayList2 = arrayList2;
                            arrayList2.add(bVarA);
                        }
                        arrayList = arrayList2;
                    }
                    if (cursorB != null) {
                        cursorB.close();
                    }
                    aVarA.close();
                    return (wo0.b[]) arrayList.toArray(new wo0.b[0]);
                } finally {
                    l43.b();
                }
            } catch (Throwable th) {
                if (cursorB != null) {
                    cursorB.close();
                }
                aVarA.close();
                throw th;
            }
        } catch (Throwable th2) {
            l43.b();
            throw th2;
        }
    }
}
