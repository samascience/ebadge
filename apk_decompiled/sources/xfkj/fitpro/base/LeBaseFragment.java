package xfkj.fitpro.base;

import android.os.Bundle;
import defpackage.wd3;
import xfkj.fitpro.receiver.LeReceiver;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LeBaseFragment<T extends wd3> extends NewBaseFragment<T> {
    private LeReceiver j;

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LeReceiver leReceiver = this.j;
        if (leReceiver != null) {
            leReceiver.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LeReceiver leReceiver = this.j;
        if (leReceiver != null) {
            leReceiver.b();
        }
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void z(Bundle bundle) {
        this.j = new LeReceiver(this.c, this.h);
    }
}
