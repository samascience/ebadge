package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import defpackage.a52;
import defpackage.nj2;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new c();
    private static final a k = new b(new String[0], null);
    private final int a;
    private final String[] b;
    private Bundle c;
    private final CursorWindow[] d;
    private final int e;
    private final Bundle f;
    private int[] g;
    private int h;
    private boolean i = false;
    private boolean j = true;

    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i2, Bundle bundle) {
        this.a = i;
        this.b = strArr;
        this.d = cursorWindowArr;
        this.e = i2;
        this.f = bundle;
    }

    public final Bundle F0() {
        return this.f;
    }

    public final int G0() {
        return this.e;
    }

    public final void H0() {
        this.c = new Bundle();
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = this.b;
            if (i2 >= strArr.length) {
                break;
            }
            this.c.putInt(strArr[i2], i2);
            i2++;
        }
        this.g = new int[this.d.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.d;
            if (i >= cursorWindowArr.length) {
                this.h = numRows;
                return;
            }
            this.g[i] = numRows;
            numRows += this.d[i].getNumRows() - (numRows - cursorWindowArr[i].getStartPosition());
            i++;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            try {
                if (!this.i) {
                    this.i = true;
                    int i = 0;
                    while (true) {
                        CursorWindow[] cursorWindowArr = this.d;
                        if (i >= cursorWindowArr.length) {
                            break;
                        }
                        cursorWindowArr[i].close();
                        i++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.j && this.d.length > 0 && !isClosed()) {
                close();
                String string = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(string).length() + Opcodes.GETSTATIC);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(string);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.i;
        }
        return z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = nj2.a(parcel);
        nj2.p(parcel, 1, this.b, false);
        nj2.r(parcel, 2, this.d, i, false);
        nj2.h(parcel, 3, G0());
        nj2.d(parcel, 4, F0(), false);
        nj2.h(parcel, 1000, this.a);
        nj2.b(parcel, iA);
        if ((i & 1) != 0) {
            close();
        }
    }

    public static class a {
        private final String[] a;
        private final ArrayList b;
        private final String c;
        private final HashMap d;
        private boolean e;
        private String f;

        private a(String[] strArr, String str) {
            this.a = (String[]) a52.g(strArr);
            this.b = new ArrayList();
            this.c = str;
            this.d = new HashMap();
            this.e = false;
            this.f = null;
        }

        /* synthetic */ a(String[] strArr, String str, b bVar) {
            this(strArr, null);
        }
    }
}
