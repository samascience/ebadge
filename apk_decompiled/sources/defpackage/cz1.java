package defpackage;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.resource.bitmap.a;

/* JADX INFO: loaded from: classes.dex */
public final class cz1 implements ug2 {
    private final a a;

    public cz1(a aVar) {
        this.a = aVar;
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, rx1 rx1Var) {
        return this.a.d(parcelFileDescriptor, i, i2, rx1Var);
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, rx1 rx1Var) {
        return this.a.o(parcelFileDescriptor);
    }
}
