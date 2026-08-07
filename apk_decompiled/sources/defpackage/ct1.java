package defpackage;

import xfkj.fitpro.activity.ota.manager.OTASDKManager;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ct1 implements tg3.b {
    public final /* synthetic */ OTASDKManager a;

    public /* synthetic */ ct1(OTASDKManager oTASDKManager) {
        this.a = oTASDKManager;
    }

    @Override // tg3.b
    public final void a(ng ngVar) {
        this.a.handleWatchSDKEvent(ngVar);
    }
}
