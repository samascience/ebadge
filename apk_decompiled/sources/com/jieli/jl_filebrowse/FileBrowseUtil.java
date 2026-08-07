package com.jieli.jl_filebrowse;

import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.PathData;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class FileBrowseUtil {
    public static final String a = "FileBrowseUtil";
    public static byte b = 0;
    public static final byte[] c = {-2, -36, -70};
    public static final byte d = -17;

    public static byte[] coverPathDataToCmd(PathData pathData) {
        if (pathData == null) {
            return new byte[0];
        }
        byte[] data = pathData.toData();
        if (data == null || data.length == 0) {
            return new byte[0];
        }
        short length = (short) (data.length + 1);
        byte[] bArr = new byte[length + 8];
        System.arraycopy(c, 0, bArr, 0, 3);
        bArr[3] = -64;
        bArr[4] = AttrAndFunCode.SYS_INFO_ATTR_EQ_PRESET_VALUE;
        bArr[5] = (byte) (length >> 8);
        bArr[6] = (byte) (length & 255);
        byte b2 = b;
        b = (byte) (b2 + 1);
        bArr[7] = b2;
        System.arraycopy(data, 0, bArr, 8, data.length);
        bArr[length + 7] = -17;
        JL_Log.d(a, "coverPathDataToCmd", "data : " + CHexConver.byte2HexStr(bArr));
        return bArr;
    }

    public static String getDevName(int i) {
        switch (i) {
            case 0:
                return "USB";
            case 1:
                return "SD Card 0";
            case 2:
                return "SD Card 1";
            case 3:
                return "Flash";
            case 4:
                return "LineIn";
            case 5:
                return "Flash2";
            case 6:
                return "Flash3";
            default:
                return String.format(Locale.ENGLISH, "Unknown Type[%d]", Integer.valueOf(i));
        }
    }

    public static List<FileStruct> parseData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        FileStruct.parseFileStruct(bArr, 0, arrayList);
        return arrayList;
    }

    public static List<FileStruct> parseDataHasPacket(byte[] bArr) {
        if (bArr == null || bArr.length < 10) {
            return new ArrayList();
        }
        int length = bArr.length - 10;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 9, bArr2, 0, length);
        return parseData(bArr2);
    }
}
