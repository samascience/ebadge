package com.jieli.jl_rcsp.model.device;

import android.os.Parcel;
import android.os.Parcelable;
import com.jieli.jl_rcsp.util.CHexConver;

/* JADX INFO: loaded from: classes3.dex */
public class VoiceMode implements Parcelable {
    public static final Parcelable.Creator<VoiceMode> CREATOR = new Parcelable.Creator<VoiceMode>() { // from class: com.jieli.jl_rcsp.model.device.VoiceMode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceMode createFromParcel(Parcel parcel) {
            return new VoiceMode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VoiceMode[] newArray(int i) {
            return new VoiceMode[i];
        }
    };
    public static final int VOICE_MODE_CLOSE = 0;
    public static final int VOICE_MODE_DENOISE = 1;
    public static final int VOICE_MODE_TRANSPARENT = 2;
    private int leftCurVal;
    private int leftMax;
    private int mode;
    private int rightCurVal;
    private int rightMax;

    public VoiceMode() {
        this.mode = -1;
    }

    public static boolean isValidMode(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static VoiceMode parse(byte[] bArr) {
        if (bArr == null || bArr.length != 9) {
            return null;
        }
        int iByteToInt = CHexConver.byteToInt(bArr[0]);
        int iBytesToInt = CHexConver.bytesToInt(bArr, 1, 2);
        int iBytesToInt2 = CHexConver.bytesToInt(bArr, 3, 2);
        int iBytesToInt3 = CHexConver.bytesToInt(bArr, 5, 2);
        return new VoiceMode().setMode(iByteToInt).setLeftMax(iBytesToInt).setLeftCurVal(iBytesToInt3).setRightMax(iBytesToInt2).setRightCurVal(CHexConver.bytesToInt(bArr, 7, 2));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[9];
        bArr[0] = CHexConver.intToByte(this.mode);
        byte[] bArrInt2byte2 = CHexConver.int2byte2(this.leftMax);
        System.arraycopy(bArrInt2byte2, 0, bArr, 1, bArrInt2byte2.length);
        int length = bArrInt2byte2.length + 1;
        byte[] bArrInt2byte3 = CHexConver.int2byte2(this.rightMax);
        System.arraycopy(bArrInt2byte3, 0, bArr, length, bArrInt2byte3.length);
        int length2 = length + bArrInt2byte3.length;
        byte[] bArrInt2byte4 = CHexConver.int2byte2(this.leftCurVal);
        System.arraycopy(bArrInt2byte4, 0, bArr, length2, bArrInt2byte4.length);
        int length3 = length2 + bArrInt2byte4.length;
        byte[] bArrInt2byte5 = CHexConver.int2byte2(this.rightCurVal);
        System.arraycopy(bArrInt2byte5, 0, bArr, length3, bArrInt2byte5.length);
        return bArr;
    }

    public int getLeftCurVal() {
        return this.leftCurVal;
    }

    public int getLeftMax() {
        return this.leftMax;
    }

    public int getMode() {
        return this.mode;
    }

    public int getRightCurVal() {
        return this.rightCurVal;
    }

    public int getRightMax() {
        return this.rightMax;
    }

    public VoiceMode setLeftCurVal(int i) {
        this.leftCurVal = i;
        return this;
    }

    public VoiceMode setLeftMax(int i) {
        this.leftMax = i;
        return this;
    }

    public VoiceMode setMode(int i) {
        this.mode = i;
        return this;
    }

    public VoiceMode setRightCurVal(int i) {
        this.rightCurVal = i;
        return this;
    }

    public VoiceMode setRightMax(int i) {
        this.rightMax = i;
        return this;
    }

    public String toString() {
        return "VoiceMode{mode=" + this.mode + ", leftMax=" + this.leftMax + ", rightMax=" + this.rightMax + ", leftCurVal=" + this.leftCurVal + ", rightCurVal=" + this.rightCurVal + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mode);
        parcel.writeInt(this.leftMax);
        parcel.writeInt(this.rightMax);
        parcel.writeInt(this.leftCurVal);
        parcel.writeInt(this.rightCurVal);
    }

    public VoiceMode(Parcel parcel) {
        this.mode = -1;
        this.mode = parcel.readInt();
        this.leftMax = parcel.readInt();
        this.rightMax = parcel.readInt();
        this.leftCurVal = parcel.readInt();
        this.rightCurVal = parcel.readInt();
    }
}
