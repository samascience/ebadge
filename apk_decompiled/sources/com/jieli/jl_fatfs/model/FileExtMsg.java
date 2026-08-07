package com.jieli.jl_fatfs.model;

import defpackage.rv0;
import defpackage.xm2;

/* JADX INFO: loaded from: classes3.dex */
public class FileExtMsg {

    @xm2("prj_uuid")
    private String uuid;

    @xm2("version_id")
    private String versionID;

    public String getUuid() {
        return this.uuid;
    }

    public String getVersionID() {
        return this.versionID;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVersionID(String str) {
        this.versionID = str;
    }

    public String toString() {
        return new rv0().c().toJson(this);
    }
}
