package xfkj.fitpro.model.sever.reponse;

/* JADX INFO: loaded from: classes4.dex */
public class ProductResponse {
    private String customerCode;
    private String customerModel;
    private String deviceId;
    private String downUrl;
    private String id;
    private String remark;
    private Integer status;

    public String getCustomerCode() {
        return this.customerCode;
    }

    public String getCustomerModel() {
        return this.customerModel;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDownUrl() {
        return this.downUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getRemark() {
        return this.remark;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setCustomerCode(String str) {
        this.customerCode = str;
    }

    public void setCustomerModel(String str) {
        this.customerModel = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDownUrl(String str) {
        this.downUrl = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public String toString() {
        return "ProductResponse{id='" + this.id + "', customerCode='" + this.customerCode + "', customerModel='" + this.customerModel + "', downUrl='" + this.downUrl + "', remark='" + this.remark + "', status=" + this.status + ", deviceId='" + this.deviceId + "'}";
    }
}
