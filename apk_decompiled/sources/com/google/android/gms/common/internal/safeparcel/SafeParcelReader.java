package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public abstract class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static int A(Parcel parcel, int i) {
        I(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer B(Parcel parcel, int i) {
        int iE = E(parcel, i);
        if (iE == 0) {
            return null;
        }
        H(parcel, i, iE, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long C(Parcel parcel, int i) {
        I(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long D(Parcel parcel, int i) {
        int iE = E(parcel, i);
        if (iE == 0) {
            return null;
        }
        H(parcel, i, iE, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int E(Parcel parcel, int i) {
        return (i & Opcodes.V_PREVIEW) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static void F(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + E(parcel, i));
    }

    public static int G(Parcel parcel) {
        int iY = y(parcel);
        int iE = E(parcel, iY);
        int iDataPosition = parcel.dataPosition();
        if (u(iY) != 20293) {
            throw new ParseException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iY))), parcel);
        }
        int i = iE + iDataPosition;
        if (i >= iDataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new ParseException("Size read is invalid start=" + iDataPosition + " end=" + i, parcel);
    }

    private static void H(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        throw new ParseException("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
    }

    private static void I(Parcel parcel, int i, int i2) {
        int iE = E(parcel, i);
        if (iE == i2) {
            return;
        }
        throw new ParseException("Expected size " + i2 + " got " + iE + " (0x" + Integer.toHexString(iE) + ")", parcel);
    }

    public static BigDecimal a(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        int i2 = parcel.readInt();
        parcel.setDataPosition(iDataPosition + iE);
        return new BigDecimal(new BigInteger(bArrCreateByteArray), i2);
    }

    public static BigDecimal[] b(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArrCreateByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(bArrCreateByteArray), parcel.readInt());
        }
        parcel.setDataPosition(iDataPosition + iE);
        return bigDecimalArr;
    }

    public static BigInteger c(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iE);
        return new BigInteger(bArrCreateByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(iDataPosition + iE);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        boolean[] zArrCreateBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(iDataPosition + iE);
        return zArrCreateBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iE);
        return bundle;
    }

    public static byte[] g(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + iE);
        return bArrCreateByteArray;
    }

    public static double[] h(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        double[] dArrCreateDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(iDataPosition + iE);
        return dArrCreateDoubleArray;
    }

    public static float[] i(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        float[] fArrCreateFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(iDataPosition + iE);
        return fArrCreateFloatArray;
    }

    public static int[] j(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iE);
        return iArrCreateIntArray;
    }

    public static long[] k(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        long[] jArrCreateLongArray = parcel.createLongArray();
        parcel.setDataPosition(iDataPosition + iE);
        return jArrCreateLongArray;
    }

    public static Parcel l(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.appendFrom(parcel, iDataPosition, iE);
        parcel.setDataPosition(iDataPosition + iE);
        return parcelObtain;
    }

    public static Parcel[] m(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        int i2 = parcel.readInt();
        Parcel[] parcelArr = new Parcel[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = parcel.readInt();
            if (i4 != 0) {
                int iDataPosition2 = parcel.dataPosition();
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.appendFrom(parcel, iDataPosition2, i4);
                parcelArr[i3] = parcelObtain;
                parcel.setDataPosition(iDataPosition2 + i4);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(iDataPosition + iE);
        return parcelArr;
    }

    public static Parcelable n(Parcel parcel, int i, Parcelable.Creator creator) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iE);
        return parcelable;
    }

    public static String o(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iE);
        return string;
    }

    public static String[] p(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + iE);
        return strArrCreateStringArray;
    }

    public static ArrayList q(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iE);
        return arrayListCreateStringArrayList;
    }

    public static Object[] r(Parcel parcel, int i, Parcelable.Creator creator) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iE);
        return objArrCreateTypedArray;
    }

    public static ArrayList s(Parcel parcel, int i, Parcelable.Creator creator) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iE);
        return arrayListCreateTypedArrayList;
    }

    public static void t(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new ParseException("Overread allowed size end=" + i, parcel);
    }

    public static int u(int i) {
        return (char) i;
    }

    public static boolean v(Parcel parcel, int i) {
        I(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static double w(Parcel parcel, int i) {
        I(parcel, i, 8);
        return parcel.readDouble();
    }

    public static float x(Parcel parcel, int i) {
        I(parcel, i, 4);
        return parcel.readFloat();
    }

    public static int y(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder z(Parcel parcel, int i) {
        int iE = E(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iE == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iE);
        return strongBinder;
    }
}
