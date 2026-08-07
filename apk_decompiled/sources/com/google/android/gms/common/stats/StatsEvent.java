package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int F0();

    public abstract long G0();

    public abstract long H0();

    public abstract String I0();

    public final String toString() {
        return H0() + "\t" + F0() + "\t" + G0() + I0();
    }
}
