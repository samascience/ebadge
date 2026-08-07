package com.jieli.jl_rcsp.model.device.double_connect;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceBtInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceBtInfo> CREATOR = new Parcelable.Creator<DeviceBtInfo>() { // from class: com.jieli.jl_rcsp.model.device.double_connect.DeviceBtInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceBtInfo createFromParcel(Parcel parcel) {
            return new DeviceBtInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceBtInfo[] newArray(int i) {
            return new DeviceBtInfo[i];
        }
    };
    private String address;
    private String btName;
    private boolean isBind;

    public DeviceBtInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBtName() {
        return this.btName;
    }

    public boolean isBind() {
        return this.isBind;
    }

    public int parseData(byte[] bArr) {
        int iByteToInt;
        if (bArr == null || bArr.length == 0) {
            return 0;
        }
        this.isBind = CHexConver.byteToInt(bArr[0]) == 1;
        int i = 7;
        if (7 <= bArr.length) {
            byte[] bArr2 = new byte[6];
            System.arraycopy(bArr, 1, bArr2, 0, 6);
            this.address = CHexConver.hexDataCovetToAddress(bArr2);
        } else {
            i = 1;
        }
        int i2 = i + 1;
        if (i2 <= bArr.length && (iByteToInt = CHexConver.byteToInt(bArr[i])) > 0 && iByteToInt <= bArr.length - 1) {
            byte[] bArr3 = new byte[iByteToInt];
            System.arraycopy(bArr, i2, bArr3, 0, iByteToInt);
            i = i2 + iByteToInt;
            try {
                this.btName = new String(bArr3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public DeviceBtInfo setAddress(String str) {
        this.address = str;
        return this;
    }

    public DeviceBtInfo setBind(boolean z) {
        this.isBind = z;
        return this;
    }

    public DeviceBtInfo setBtName(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes();
                if (bytes.length > 60) {
                    str = new String(bytes, 0, 60);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.btName = str;
        return this;
    }

    public byte[] toData() {
        byte[] bArrAddressCovertToByteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(this.isBind ? 1 : 0);
            byte[] bArr = new byte[6];
            String str = this.address;
            if (str != null && (bArrAddressCovertToByteArray = RcspUtil.addressCovertToByteArray(str)) != null && bArrAddressCovertToByteArray.length == 6) {
                bArr = bArrAddressCovertToByteArray;
            }
            byteArrayOutputStream.write(bArr);
            String str2 = this.btName;
            if (str2 != null) {
                byteArrayOutputStream.write(str2.getBytes().length);
                byteArrayOutputStream.write(this.btName.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString() {
        return "DeviceBtInfo{isBind=" + this.isBind + ", address='" + this.address + "', btName='" + this.btName + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isBind ? (byte) 1 : (byte) 0);
        parcel.writeString(this.address);
        parcel.writeString(this.btName);
    }

    public DeviceBtInfo(Parcel parcel) {
        this.isBind = parcel.readByte() != 0;
        this.address = parcel.readString();
        this.btName = parcel.readString();
    }
}
