package com.jieli.jl_rcsp.model.device.health;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.util.CHexConver;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FallDetection implements IHealthSettingToAttr {
    public static final byte MODE_BRIGHT = 0;
    public static final byte MODE_CALL = 2;
    public static final byte MODE_SHAKE = 1;
    private String contact;
    private boolean enable;
    private byte mode;

    public FallDetection(byte[] bArr) {
        parseData(bArr);
    }

    private void parseData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        int iMin = 0;
        int i = 1;
        this.enable = CHexConver.byteToInt(bArr[0]) == 1;
        if (bArr.length >= 2) {
            this.mode = bArr[1];
            i = 2;
        }
        this.contact = Constants.STR_EMPTY;
        int i2 = i + 1;
        if (bArr.length >= i2) {
            iMin = Math.min(CHexConver.byteToInt(bArr[i]), bArr.length - i2);
            i = i2;
        }
        if (iMin <= 0 || bArr.length < i + iMin) {
            return;
        }
        this.contact = new String(bArr, i, iMin).trim();
    }

    private byte[] toData() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{this.enable ? (byte) 1 : (byte) 0, this.mode});
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.mode == 2 && !TextUtils.isEmpty(this.contact)) {
            try {
                byteArrayOutputStream.write(this.contact.getBytes().length);
                byteArrayOutputStream.write(this.contact.getBytes());
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getContact() {
        return this.contact;
    }

    public byte getMode() {
        return this.mode;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public int getType() {
        return 7;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public FallDetection setContact(String str) {
        this.contact = str;
        return this;
    }

    public FallDetection setEnable(boolean z) {
        this.enable = z;
        return this;
    }

    public FallDetection setMode(byte b) {
        this.mode = b;
        return this;
    }

    @Override // com.jieli.jl_rcsp.model.device.health.IHealthSettingToAttr
    public AttrBean toAttr() {
        return new AttrBean().setAttrData(toData()).setType((byte) getType());
    }

    public String toString() {
        return "FallDetection{contact='" + this.contact + "', enable=" + this.enable + ", mode=" + ((int) this.mode) + '}';
    }
}
