package com.jieli.jl_fatfs.tool;

import com.jieli.jl_fatfs.model.PackFileInfo;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class PackResFormat {
    public static final String b = "PackResFormat";
    public volatile long a;

    static {
        try {
            System.loadLibrary("jl_pack_format");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PackResFormat() {
        this.a = 0L;
        this.a = libInit();
        if (this.a == 0) {
            throw new RuntimeException("init lib failed.");
        }
    }

    public void destroy() {
        libDestroy(this.a);
        this.a = 0L;
    }

    public native byte[] getFileData(long j, String str);

    public byte[] getFileData(String str) {
        return getFileData(this.a, str);
    }

    public native void libDestroy(long j);

    public native long libInit();

    public native ArrayList<PackFileInfo> uncompressData(long j, byte[] bArr);

    public ArrayList<PackFileInfo> uncompressPackDataFile(byte[] bArr) {
        return uncompressData(this.a, bArr);
    }

    public byte[] getFileData(byte[] bArr, String str) {
        ArrayList<PackFileInfo> arrayListUncompressPackDataFile = uncompressPackDataFile(bArr);
        if (arrayListUncompressPackDataFile == null || arrayListUncompressPackDataFile.isEmpty()) {
            JL_Log.e(b, "getFileData", "Did not extract the file.");
            return null;
        }
        JL_Log.i(b, "getFileData", RcspUtil.formatString("========= Unzip file :[%d], target : %s =========", Integer.valueOf(arrayListUncompressPackDataFile.size()), str));
        Iterator<PackFileInfo> it = arrayListUncompressPackDataFile.iterator();
        while (it.hasNext()) {
            JL_Log.d(b, "getFileData", it.next().toString());
        }
        JL_Log.i(b, "getFileData", "================= Unzip file End ===============");
        return getFileData(str);
    }
}
