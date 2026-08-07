package xfkj.fitpro.model.sever.reponse;

import defpackage.e33;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class PaymentCodeResponse {
    private String createdAt;
    private String deviceId;
    private String id;
    private String imei;
    private Date localDate;
    private String qrcode;
    private String shopNo;

    public PaymentCodeResponse(String str, String str2, String str3, String str4, String str5, Date date, String str6) {
        e33.e();
        this.id = str;
        this.imei = str2;
        this.shopNo = str3;
        this.qrcode = str4;
        this.createdAt = str5;
        this.localDate = date;
        this.deviceId = str6;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getId() {
        return this.id;
    }

    public String getImei() {
        return this.imei;
    }

    public Date getLocalDate() {
        return this.localDate;
    }

    public String getQrcode() {
        return this.qrcode;
    }

    public String getShopNo() {
        return this.shopNo;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setLocalDate(Date date) {
        this.localDate = date;
    }

    public void setQrcode(String str) {
        this.qrcode = str;
    }

    public void setShopNo(String str) {
        this.shopNo = str;
    }

    public String toString() {
        return "PaymentCodeResponse{id='" + this.id + "', imei='" + this.imei + "', shopNo='" + this.shopNo + "', qrcode='" + this.qrcode + "', createdAt='" + this.createdAt + "', localDate=" + this.localDate + ", deviceId='" + this.deviceId + "'}";
    }

    public PaymentCodeResponse() {
        this.localDate = e33.e();
    }
}
