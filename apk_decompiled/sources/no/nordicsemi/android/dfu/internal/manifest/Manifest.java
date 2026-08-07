package no.nordicsemi.android.dfu.internal.manifest;

import defpackage.xm2;

/* JADX INFO: loaded from: classes4.dex */
public class Manifest {
    private FileInfo application;
    private FileInfo bootloader;

    @xm2("bootloader_application")
    private FileInfo bootloaderApplication;
    private FileInfo softdevice;

    @xm2("softdevice_application")
    private FileInfo softdeviceApplication;

    @xm2("softdevice_bootloader")
    private SoftDeviceBootloaderFileInfo softdeviceBootloader;

    @xm2("softdevice_bootloader_application")
    private FileInfo softdeviceBootloaderApplication;

    public FileInfo getApplicationInfo() {
        FileInfo fileInfo = this.application;
        if (fileInfo != null) {
            return fileInfo;
        }
        FileInfo fileInfo2 = this.softdeviceApplication;
        if (fileInfo2 != null) {
            return fileInfo2;
        }
        FileInfo fileInfo3 = this.bootloaderApplication;
        return fileInfo3 != null ? fileInfo3 : this.softdeviceBootloaderApplication;
    }

    public FileInfo getBootloaderInfo() {
        return this.bootloader;
    }

    public SoftDeviceBootloaderFileInfo getSoftdeviceBootloaderInfo() {
        return this.softdeviceBootloader;
    }

    public FileInfo getSoftdeviceInfo() {
        return this.softdevice;
    }

    public boolean isSecureDfuRequired() {
        return (this.bootloaderApplication == null && this.softdeviceApplication == null && this.softdeviceBootloaderApplication == null) ? false : true;
    }
}
