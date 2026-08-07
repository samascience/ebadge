package com.jieli.jl_rcsp.model.device;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class NfcFile {
    private NfcMsg message;
    private byte[] nfcData;

    public NfcFile(NfcMsg nfcMsg, byte[] bArr) {
        setMessage(nfcMsg);
        setNfcData(bArr);
    }

    public byte[] convertRawData() {
        int length;
        byte[] bArrConvertRawData = this.message.convertRawData();
        byte[] bArr = new byte[bArrConvertRawData.length + this.nfcData.length];
        if (bArrConvertRawData.length > 0) {
            System.arraycopy(bArrConvertRawData, 0, bArr, 0, bArrConvertRawData.length);
            length = bArrConvertRawData.length;
        } else {
            length = 0;
        }
        byte[] bArr2 = this.nfcData;
        if (bArr2.length > 0) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
        }
        return bArr;
    }

    public NfcMsg getMessage() {
        return this.message;
    }

    public byte[] getNfcData() {
        return this.nfcData;
    }

    public void setMessage(NfcMsg nfcMsg) {
        this.message = nfcMsg;
    }

    public void setNfcData(byte[] bArr) {
        this.nfcData = bArr;
    }

    public String toString() {
        return "NfcFile{message=" + this.message + ", nfcData=" + Arrays.toString(this.nfcData) + '}';
    }
}
