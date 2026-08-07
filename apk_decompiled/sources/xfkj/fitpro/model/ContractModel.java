package xfkj.fitpro.model;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class ContractModel {
    String contractName;
    String deviceId;
    Long id;
    String phoneNumber;

    public ContractModel(String str, String str2, String str3) {
        this.deviceId = str;
        this.contractName = str2;
        this.phoneNumber = str3;
    }

    public String getContractName() {
        return this.contractName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public Long getId() {
        return this.id;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setContractName(String str) {
        this.contractName = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String toString() {
        return "ContractModel{deviceId='" + this.deviceId + "', contractName='" + this.contractName + "', phoneNumber='" + this.phoneNumber + "'}";
    }

    public ContractModel(Long l, String str, String str2, String str3) {
        this.id = l;
        this.deviceId = str;
        this.contractName = str2;
        this.phoneNumber = str3;
    }

    public ContractModel() {
        this.contractName = Constants.STR_EMPTY;
    }
}
