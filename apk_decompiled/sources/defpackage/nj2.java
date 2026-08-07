package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public abstract class nj2 {
    public static int a(Parcel parcel) {
        return t(parcel, 20293);
    }

    public static void b(Parcel parcel, int i) {
        u(parcel, i);
    }

    public static void c(Parcel parcel, int i, boolean z) {
        v(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void d(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.writeBundle(bundle);
            u(parcel, iT);
        }
    }

    public static void e(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.writeByteArray(bArr);
            u(parcel, iT);
        }
    }

    public static void f(Parcel parcel, int i, float f) {
        v(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void g(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.writeStrongBinder(iBinder);
            u(parcel, iT);
        }
    }

    public static void h(Parcel parcel, int i, int i2) {
        v(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void i(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.writeIntArray(iArr);
            u(parcel, iT);
        }
    }

    public static void j(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            v(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            v(parcel, i, 0);
        }
    }

    public static void k(Parcel parcel, int i, long j) {
        v(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void l(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            v(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            v(parcel, i, 0);
        }
    }

    public static void m(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            u(parcel, iT);
        }
    }

    public static void n(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            u(parcel, iT);
        }
    }

    public static void o(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.writeString(str);
            u(parcel, iT);
        }
    }

    public static void p(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.writeStringArray(strArr);
            u(parcel, iT);
        }
    }

    public static void q(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                v(parcel, i, 0);
            }
        } else {
            int iT = t(parcel, i);
            parcel.writeStringList(list);
            u(parcel, iT);
        }
    }

    public static void r(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr == null) {
            if (z) {
                v(parcel, i, 0);
                return;
            }
            return;
        }
        int iT = t(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                w(parcel, parcelable, i2);
            }
        }
        u(parcel, iT);
    }

    public static void s(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                v(parcel, i, 0);
                return;
            }
            return;
        }
        int iT = t(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Parcelable parcelable = (Parcelable) list.get(i2);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                w(parcel, parcelable, 0);
            }
        }
        u(parcel, iT);
    }

    private static int t(Parcel parcel, int i) {
        parcel.writeInt(i | Opcodes.V_PREVIEW);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void u(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    private static void v(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    private static void w(Parcel parcel, Parcelable parcelable, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
