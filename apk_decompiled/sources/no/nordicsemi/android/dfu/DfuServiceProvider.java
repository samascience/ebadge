package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.content.Intent;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

/* JADX INFO: loaded from: classes4.dex */
class DfuServiceProvider implements DfuCallback {
    private boolean mAborted;
    private BaseDfuImpl mImpl;
    private boolean mPaused;

    DfuServiceProvider() {
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void abort() {
        this.mAborted = true;
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.abort();
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public DfuCallback.DfuGattCallback getGattCallback() {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            return baseDfuImpl.getGattCallback();
        }
        return null;
    }

    DfuService getServiceImpl(Intent intent, DfuBaseService dfuBaseService, BluetoothGatt bluetoothGatt) throws UploadAbortedException, DfuException, DeviceDisconnectedException {
        try {
            ButtonlessDfuWithBondSharingImpl buttonlessDfuWithBondSharingImpl = new ButtonlessDfuWithBondSharingImpl(intent, dfuBaseService);
            this.mImpl = buttonlessDfuWithBondSharingImpl;
            if (buttonlessDfuWithBondSharingImpl.isClientCompatible(intent, bluetoothGatt)) {
                return this.mImpl;
            }
            ButtonlessDfuWithoutBondSharingImpl buttonlessDfuWithoutBondSharingImpl = new ButtonlessDfuWithoutBondSharingImpl(intent, dfuBaseService);
            this.mImpl = buttonlessDfuWithoutBondSharingImpl;
            if (buttonlessDfuWithoutBondSharingImpl.isClientCompatible(intent, bluetoothGatt)) {
                return this.mImpl;
            }
            SecureDfuImpl secureDfuImpl = new SecureDfuImpl(intent, dfuBaseService);
            this.mImpl = secureDfuImpl;
            if (secureDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                return this.mImpl;
            }
            LegacyButtonlessDfuImpl legacyButtonlessDfuImpl = new LegacyButtonlessDfuImpl(intent, dfuBaseService);
            this.mImpl = legacyButtonlessDfuImpl;
            if (legacyButtonlessDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                return this.mImpl;
            }
            LegacyDfuImpl legacyDfuImpl = new LegacyDfuImpl(intent, dfuBaseService);
            this.mImpl = legacyDfuImpl;
            if (legacyDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                return this.mImpl;
            }
            if (intent.getBooleanExtra(DfuBaseService.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU, false)) {
                ExperimentalButtonlessDfuImpl experimentalButtonlessDfuImpl = new ExperimentalButtonlessDfuImpl(intent, dfuBaseService);
                this.mImpl = experimentalButtonlessDfuImpl;
                if (experimentalButtonlessDfuImpl.isClientCompatible(intent, bluetoothGatt)) {
                    return this.mImpl;
                }
            }
            return null;
        } finally {
            BaseDfuImpl baseDfuImpl = this.mImpl;
            if (baseDfuImpl != null) {
                if (this.mPaused) {
                    baseDfuImpl.pause();
                }
                if (this.mAborted) {
                    this.mImpl.abort();
                }
            }
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuCallback
    public void onBondStateChanged(int i) {
        BaseDfuImpl baseDfuImpl = this.mImpl;
        if (baseDfuImpl != null) {
            baseDfuImpl.onBondStateChanged(i);
        }
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void pause() {
        this.mPaused = true;
    }

    @Override // no.nordicsemi.android.dfu.DfuController
    public void resume() {
        this.mPaused = false;
    }
}
