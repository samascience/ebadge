package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class ProductInfoModel {
    private String deviceId;
    private String productInfo;
    private String productType;

    public ProductInfoModel(String str, String str2, String str3) {
        this.deviceId = str;
        this.productInfo = str2;
        this.productType = str3;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getProductInfo() {
        return this.productInfo;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setProductInfo(String str) {
        this.productInfo = str;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public String toString() {
        return "ProductInfoModel{deviceId='" + this.deviceId + "', productInfo='" + this.productInfo + "', productType='" + this.productType + "'}";
    }

    public ProductInfoModel() {
    }
}
