package no.nordicsemi.android.dfu.internal.manifest;

import defpackage.xm2;

/* JADX INFO: loaded from: classes4.dex */
public class SoftDeviceBootloaderFileInfo extends FileInfo {

    @xm2("bl_size")
    private int bootloaderSize;

    @xm2("sd_size")
    private int softdeviceSize;

    public int getBootloaderSize() {
        return this.bootloaderSize;
    }

    public int getSoftdeviceSize() {
        return this.softdeviceSize;
    }
}
