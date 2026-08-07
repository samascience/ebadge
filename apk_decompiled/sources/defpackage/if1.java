package defpackage;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class if1 extends pt1.a {
    private static pt1 e;
    public static final Parcelable.Creator f;
    public float c;
    public float d;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public if1 createFromParcel(Parcel parcel) {
            if1 if1Var = new if1(0.0f, 0.0f);
            if1Var.c(parcel);
            return if1Var;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public if1[] newArray(int i) {
            return new if1[i];
        }
    }

    static {
        pt1 pt1VarA = pt1.a(32, new if1(0.0f, 0.0f));
        e = pt1VarA;
        pt1VarA.g(0.5f);
        f = new a();
    }

    public if1() {
    }

    public static if1 b(float f2, float f3) {
        if1 if1Var = (if1) e.b();
        if1Var.c = f2;
        if1Var.d = f3;
        return if1Var;
    }

    public static void d(if1 if1Var) {
        e.c(if1Var);
    }

    @Override // pt1.a
    protected pt1.a a() {
        return new if1(0.0f, 0.0f);
    }

    public void c(Parcel parcel) {
        this.c = parcel.readFloat();
        this.d = parcel.readFloat();
    }

    public if1(float f2, float f3) {
        this.c = f2;
        this.d = f3;
    }
}
