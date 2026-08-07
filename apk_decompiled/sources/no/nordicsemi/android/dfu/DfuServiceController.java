package no.nordicsemi.android.dfu;

import android.content.Context;
import android.content.Intent;
import defpackage.oc1;

/* JADX INFO: loaded from: classes4.dex */
public class DfuServiceController implements DfuController {
    private boolean mAborted;
    private final oc1 mBroadcastManager;
    private boolean mPaused;

    DfuServiceController(Context context) {
        this.mBroadcastManager = oc1.b(context);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        if (this.mAborted) {
            return;
        }
        this.mAborted = true;
        this.mPaused = false;
        Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
        intent.putExtra(DfuBaseService.EXTRA_ACTION, 2);
        this.mBroadcastManager.d(intent);
    }

    public boolean isAborted() {
        return this.mAborted;
    }

    public boolean isPaused() {
        return this.mPaused;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        if (this.mAborted || this.mPaused) {
            return;
        }
        this.mPaused = true;
        Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
        intent.putExtra(DfuBaseService.EXTRA_ACTION, 0);
        this.mBroadcastManager.d(intent);
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        if (this.mAborted || !this.mPaused) {
            return;
        }
        this.mPaused = false;
        Intent intent = new Intent(DfuBaseService.BROADCAST_ACTION);
        intent.putExtra(DfuBaseService.EXTRA_ACTION, 1);
        this.mBroadcastManager.d(intent);
    }
}
