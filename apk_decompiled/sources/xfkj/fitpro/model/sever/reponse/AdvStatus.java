package xfkj.fitpro.model.sever.reponse;

import defpackage.xm2;

/* JADX INFO: loaded from: classes4.dex */
public class AdvStatus {

    @xm2("ad.show")
    private String _$AdShow33;

    @xm2("cs.services")
    private String _$CsServices259;

    @xm2("btnames")
    private String btnames;

    @xm2("ota")
    private String ota;

    @xm2("tz.blacklist")
    private String tzBlacklist;

    public String getBtnames() {
        return this.btnames;
    }

    public String getOta() {
        return this.ota;
    }

    public String getTzBlacklist() {
        return this.tzBlacklist;
    }

    public String get_$AdShow33() {
        return this._$AdShow33;
    }

    public String get_$CsServices259() {
        return this._$CsServices259;
    }

    public void setBtnames(String str) {
        this.btnames = str;
    }

    public void setOta(String str) {
        this.ota = str;
    }

    public void setTzBlacklist(String str) {
        this.tzBlacklist = str;
    }

    public void set_$AdShow33(String str) {
        this._$AdShow33 = str;
    }

    public void set_$CsServices259(String str) {
        this._$CsServices259 = str;
    }

    public String toString() {
        return "AdvStatus{_$CsServices259='" + this._$CsServices259 + "', btnames='" + this.btnames + "', _$AdShow33='" + this._$AdShow33 + "', ota='" + this.ota + "', tzBlacklist='" + this.tzBlacklist + "'}";
    }
}
