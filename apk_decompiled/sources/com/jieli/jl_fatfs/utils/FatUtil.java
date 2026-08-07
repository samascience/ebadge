package com.jieli.jl_fatfs.utils;

import com.jieli.jl_fatfs.model.CallInfo;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FatUtil {
    public static byte[] getCallInfoData(List<CallInfo> list) {
        if (list == null || list.isEmpty()) {
            return new byte[20];
        }
        byte[] bArr = new byte[list.size() * 40];
        Iterator<CallInfo> it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            byte[] bytes = it.next().getBytes();
            if (bytes != null) {
                System.arraycopy(bytes, 0, bArr, length, bytes.length);
                length += bytes.length;
            }
        }
        return bArr;
    }

    public static String getFatFilePath(String str) {
        return getFatFilePath(WatchConstant.FAT_FS_ROOT, str);
    }

    public static String getFatFsErrorCodeMsg(int i) {
        return WatchError.getErrorDesc(WatchError.fatfsToWatchErr(i));
    }

    public static String getFatFsName(String str) {
        return getFatFsName(12, str);
    }

    public static List<CallInfo> parseCallInfoList(byte[] bArr) {
        if (bArr == null || bArr.length < 40) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (bArr.length - i >= 40) {
            String strTrim = new String(bArr, i, 20).trim();
            String strTrim2 = new String(bArr, i + 20, 20).trim();
            i += 40;
            arrayList.add(new CallInfo(strTrim, strTrim2));
        }
        return arrayList;
    }

    public static String getFatFilePath(String str, String str2) {
        String fileName = WatchFileUtil.getFileName(str2);
        if (fileName == null || str == null) {
            return null;
        }
        String fatFsName = getFatFsName(fileName);
        if (str.equalsIgnoreCase(fatFsName)) {
            return str;
        }
        if (str.equalsIgnoreCase(WatchConstant.FAT_FS_ROOT)) {
            return str + fatFsName;
        }
        return str + WatchConstant.FAT_FS_ROOT + fatFsName;
    }

    public static String getFatFsName(int i, String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.length() > i) {
            int iLastIndexOf = str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
            if (iLastIndexOf != -1) {
                String strSubstring = str.substring(0, iLastIndexOf);
                String strSubstring2 = str.substring(iLastIndexOf + 1);
                int length = (i - 1) - strSubstring2.length();
                if (length > strSubstring.length()) {
                    length = strSubstring.length();
                }
                str = strSubstring.substring(0, length).replaceAll("\\.", "_") + FileUtils.FILE_EXTENSION_SEPARATOR + strSubstring2;
            } else {
                str = str.substring(0, i);
            }
        }
        return str.toUpperCase();
    }
}
