package com.onmicro.omtoolbox.dfu;

import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes3.dex */
public class DfuService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    protected Class getNotificationTarget() {
        return NotificationActivity.class;
    }

    @Override // no.nordicsemi.android.dfu.DfuBaseService
    protected boolean isDebug() {
        return true;
    }
}
