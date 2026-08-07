package com.jieli.jl_rcsp.model.command.file_op;

import android.text.TextUtils;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class LargeFileTransferGetNameCmd extends CommandWithParamAndResponse<Param, CommonResponse> {
    private static final String TAG = "LargeFileTransferGetNameCmd";

    public static class Param extends BaseParameter {
        private String encodeType = StandardCharsets.UTF_16LE.name();
        private boolean isOtherEncode;
        public final String name;
        public final int renameTime;

        public Param(String str, int i) {
            this.name = str;
            this.renameTime = i;
        }

        private byte[] getNameData(String str, int i) {
            return this.isOtherEncode ? getNameDataByOther(str, i) : getNameDataByDefault(str, i);
        }

        private byte[] getNameDataByDefault(String str, int i) {
            byte[] bytes;
            byte[] bytes2;
            String strSubstring = Constants.STR_EMPTY;
            String strReplaceAll = str.replaceAll("[\\x00-\\x1f\\x2f\\x3a\\x3c\\x3e\\x5c\\x22]", Constants.STR_EMPTY);
            int iLastIndexOf = strReplaceAll.lastIndexOf(46);
            String strSubstring2 = iLastIndexOf != -1 ? strReplaceAll.substring(0, iLastIndexOf) : strReplaceAll;
            String strSubstring3 = iLastIndexOf != -1 ? strReplaceAll.substring(iLastIndexOf) : Constants.STR_EMPTY;
            if (i > 0) {
                String str2 = "000" + i;
                strSubstring = str2.substring(str2.length() - 3);
            }
            String str3 = strSubstring2 + strSubstring;
            try {
                bytes = str3.getBytes("gbk");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bytes = str3.getBytes();
            }
            if (bytes.length < 9 && strSubstring3.length() < 5) {
                String str4 = str3 + strSubstring3;
                try {
                    bytes2 = str4.getBytes("gbk");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    bytes2 = str4.getBytes();
                }
                JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByDefault", "获取文件名称 \tretryName = " + i + "\tname = " + strReplaceAll + "\tshortName = " + str4);
                byte[] bArr = new byte[bytes2.length + 2];
                System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
                return bArr;
            }
            String str5 = strSubstring2 + strSubstring + strSubstring3;
            JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByDefault", "获取文件名称 \tretryName = " + i + "\tname = " + strReplaceAll + "\tlenName = " + str5);
            byte[] bytes3 = "\\U".getBytes();
            byte[] bytes4 = str5.getBytes(StandardCharsets.UTF_16LE);
            byte[] bArr2 = new byte[bytes3.length + bytes4.length + 2];
            System.arraycopy(bytes3, 0, bArr2, 0, bytes3.length);
            System.arraycopy(bytes4, 0, bArr2, bytes3.length, bytes4.length);
            JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByDefault", "data : " + CHexConver.byte2HexStr(bArr2));
            return bArr2;
        }

        private byte[] getNameDataByOther(String str, int i) {
            String strName = TextUtils.isEmpty(this.encodeType) ? StandardCharsets.UTF_16LE.name() : this.encodeType;
            String strSubstring = Constants.STR_EMPTY;
            String strReplaceAll = str.replaceAll("[\\x00-\\x1f\\x2f\\x3a\\x3c\\x3e\\x5c\\x22]", Constants.STR_EMPTY);
            int iLastIndexOf = strReplaceAll.lastIndexOf(46);
            String strSubstring2 = iLastIndexOf != -1 ? strReplaceAll.substring(0, iLastIndexOf) : strReplaceAll;
            String strSubstring3 = iLastIndexOf != -1 ? strReplaceAll.substring(iLastIndexOf) : Constants.STR_EMPTY;
            if (i > 0) {
                String str2 = "000" + i;
                strSubstring = str2.substring(str2.length() - 3);
            }
            try {
                String str3 = strSubstring2 + strSubstring + strSubstring3;
                JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByOther", "获取文件名称 \tretryName = " + i + "\tname = " + strReplaceAll + "\tlenName = " + str3);
                byte[] bytes = "\\U".getBytes();
                byte[] bytes2 = str3.getBytes(strName);
                byte[] bArr = new byte[bytes.length + bytes2.length + 2];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
                JL_Log.i(LargeFileTransferGetNameCmd.TAG, "getNameDataByOther", "data : " + CHexConver.byte2HexStr(bArr));
                return bArr;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return new byte[0];
            }
        }

        public String getEncodeType() {
            return this.encodeType;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            String str = this.name;
            return (str == null || str.isEmpty()) ? super.getParamData() : getNameData(this.name, this.renameTime);
        }

        public boolean isOtherEncode() {
            return this.isOtherEncode;
        }

        public Param setEncodeType(String str) {
            this.encodeType = str;
            return this;
        }

        public Param setOtherEncode(boolean z) {
            this.isOtherEncode = z;
            return this;
        }
    }

    public LargeFileTransferGetNameCmd(Param param) {
        super(32, LargeFileTransferGetNameCmd.class.getSimpleName(), param);
    }
}
