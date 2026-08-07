package com.jieli.jl_rcsp.model.parameter;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ModifyNfcMsgParam extends NFCOperationCmd.ModifyMsgParam {
    private final String nickName;
    private final long updateTime;

    public ModifyNfcMsgParam(int i, short s, long j, String str) {
        super(i, s, getMask(j, str), getMaskData(j, str));
        this.updateTime = j;
        this.nickName = new String(RcspUtil.getData(str, 24));
    }

    private static int getMask(long j, String str) {
        int i = j > 0 ? 1 : 0;
        return !TextUtils.isEmpty(str) ? i | 2 : i;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001f A[Catch: Exception -> 0x0017, TRY_LEAVE, TryCatch #0 {Exception -> 0x0017, blocks: (B:4:0x000b, B:7:0x0019, B:9:0x001f), top: B:14:0x000b }] */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x001f, please report this as an issue */
    private static byte[] getMaskData(long j, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (j > 0) {
            try {
                byteArrayOutputStream.write(CHexConver.intToBigBytes(RcspUtil.time2Int(j)));
                if (!TextUtils.isEmpty(str)) {
                    byte[] bArr = new byte[24];
                    System.arraycopy(str.getBytes(), 0, bArr, 0, str.getBytes().length);
                    JL_Log.i("ModifyNfcMsgParam", "getMaskData", "modify name : " + str + ", data = " + CHexConver.byte2HexStr(bArr));
                    byteArrayOutputStream.write(bArr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!TextUtils.isEmpty(str)) {
            byte[] bArr2 = new byte[24];
            System.arraycopy(str.getBytes(), 0, bArr2, 0, str.getBytes().length);
            JL_Log.i("ModifyNfcMsgParam", "getMaskData", "modify name : " + str + ", data = " + CHexConver.byte2HexStr(bArr2));
            byteArrayOutputStream.write(bArr2);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getNickName() {
        return this.nickName;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }
}
