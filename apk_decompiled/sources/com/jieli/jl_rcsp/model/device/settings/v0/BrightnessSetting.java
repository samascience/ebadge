package com.jieli.jl_rcsp.model.device.settings.v0;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class BrightnessSetting extends SettingFunction {
    public static final Parcelable.Creator<BrightnessSetting> CREATOR = new Parcelable.Creator<BrightnessSetting>() { // from class: com.jieli.jl_rcsp.model.device.settings.v0.BrightnessSetting.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrightnessSetting createFromParcel(Parcel parcel) {
            return new BrightnessSetting(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrightnessSetting[] newArray(int i) {
            return new BrightnessSetting[i];
        }
    };
    private int value;

    public BrightnessSetting(byte[] bArr) {
        super(bArr);
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getValue() {
        return this.value;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
    public int parse(byte[] bArr) {
        int i = super.parse(bArr);
        if (i == 0) {
            return i;
        }
        byte[] payload = getPayload();
        if (payload.length == 0) {
            return i;
        }
        this.value = CHexConver.byteToInt(payload[0]);
        return i;
    }

    @Override // com.jieli.jl_rcsp.model.device.settings.v0.SettingFunction, com.jieli.jl_rcsp.model.device.settings.SettingData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.value);
    }

    public BrightnessSetting(int i, Integer num) {
        super(1, 0, i, num == null ? new byte[0] : new byte[]{CHexConver.intToByte(num.intValue())});
        if (num != null) {
            this.value = num.intValue();
        }
    }

    public BrightnessSetting(Parcel parcel) {
        super(parcel);
        this.value = parcel.readInt();
    }
}
