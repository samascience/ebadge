package no.nordicsemi.android.dfu.internal.manifest;

import defpackage.xm2;

/* JADX INFO: loaded from: classes4.dex */
public class FileInfo {

    @xm2("bin_file")
    private String binFile;

    @xm2("dat_file")
    private String datFile;

    public String getBinFileName() {
        return this.binFile;
    }

    public String getDatFileName() {
        return this.datFile;
    }
}
