package com.qiniu.android.utils;

import java.util.Arrays;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class ListVector<E> extends Vector<E> {

    public interface a {
        boolean a(Object obj);
    }

    public ListVector() {
    }

    public synchronized void enumerateObjects(a aVar) {
        if (aVar == null) {
            return;
        }
        Object[] objArr = ((Vector) this).elementData;
        int i = ((Vector) this).elementCount;
        for (int i2 = 0; i2 < i && !aVar.a(objArr[i2]); i2++) {
        }
    }

    public ListVector(int i, int i2) {
        super(i, i2);
    }

    @Override // java.util.Vector, java.util.AbstractList, java.util.List
    public synchronized ListVector<E> subList(int i, int i2) {
        ListVector<E> listVector;
        try {
            listVector = new ListVector<>();
            if (((Vector) this).elementData.getClass() != Object[].class) {
                Object[] objArrCopyOf = Arrays.copyOf(((Vector) this).elementData, ((Vector) this).elementCount, Object[].class);
                ((Vector) listVector).elementData = objArrCopyOf;
                ((Vector) listVector).elementCount = objArrCopyOf.length;
            } else {
                ((Vector) listVector).elementData = Arrays.copyOf(((Vector) this).elementData, ((Vector) this).elementCount);
                ((Vector) listVector).elementCount = ((Vector) this).elementCount;
            }
        } catch (Throwable th) {
            throw th;
        }
        return listVector;
    }
}
