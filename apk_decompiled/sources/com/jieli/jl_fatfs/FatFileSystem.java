package com.jieli.jl_fatfs;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import com.jieli.jl_fatfs.FatFileSystem;
import com.jieli.jl_fatfs.interfaces.IBluetoothCtrl;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.interfaces.OnFatFsInitListener;
import com.jieli.jl_fatfs.interfaces.OnFatFsOpResultListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.model.FatOpParam;
import com.jieli.jl_fatfs.model.FatWriteOp;
import com.jieli.jl_fatfs.model.FileExtMsg;
import com.jieli.jl_fatfs.tool.PackResFormat;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.tencent.connect.common.Constants;
import defpackage.qv0;
import defpackage.rv0;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class FatFileSystem {
    public static final String u = "FatFileSystem";
    public static final String[] v;
    public volatile boolean a;
    public volatile long b;
    public final ExecutorService c;
    public final IBluetoothCtrl d;
    public final Handler e;
    public final Map<String, ArrayList<FatFile>> f;
    public String g;
    public byte[] h;
    public int i;
    public short j;
    public int k;
    public byte[] l;
    public int m;
    public byte[] n;
    public int o;
    public final OnFatFsInitListener p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FatOpParam f282q;
    public PackResFormat r;
    public qv0 s;
    public final String[] t;

    static {
        try {
            System.loadLibrary("jl_fatfs");
        } catch (Exception e) {
            e.printStackTrace();
        }
        v = new String[]{"JL", "FONT", "SIDEBAR"};
    }

    public FatFileSystem(int i, int i2, final int i3, String[] strArr, IBluetoothCtrl iBluetoothCtrl, OnFatFsInitListener onFatFsInitListener, OnFatFileProgressListener onFatFileProgressListener) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.c = executorServiceNewSingleThreadExecutor;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new HashMap();
        this.g = WatchConstant.FAT_FS_ROOT;
        this.h = null;
        this.i = 0;
        this.j = (short) 0;
        this.n = null;
        this.o = 0;
        this.t = strArr;
        this.d = iBluetoothCtrl;
        this.p = onFatFsInitListener;
        if (iBluetoothCtrl == null) {
            throw new RuntimeException("IBluetoothCtrl cannot be null.");
        }
        this.b = libInit(i > i2 ? i2 : i, i2);
        if (this.b == 0) {
            throw new RuntimeException("init lib failed.");
        }
        a(false);
        updateSysStatus(this.b, i3);
        if (i3 != 0 && onFatFileProgressListener != null) {
            this.f282q = new FatOpParam().setOp(255).setFilePath(WatchConstant.FAT_FS_ROOT).setTotalSize(8192L).setProgressListener(onFatFileProgressListener);
        }
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: yk0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g(i3);
            }
        });
    }

    public static /* synthetic */ void a(OnFatFsOpResultListener onFatFsOpResultListener, int i) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(Integer.valueOf(i));
        }
    }

    public static boolean isIgnoreFile(String str) {
        String[] strArr;
        if (str == null || (strArr = v) == null || strArr.length == 0) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ void b(final OnFatFsOpResultListener onFatFsOpResultListener) {
        final int iMountDevice = mountDevice(this.b);
        if (iMountDevice == 0) {
            JL_Log.w(u, "mount", "FatFs mount ok.");
        }
        this.e.post(new Runnable() { // from class: cl0
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.a(onFatFsOpResultListener, iMountDevice);
            }
        });
    }

    public final /* synthetic */ void c(String str, final OnFatFsOpResultListener onFatFsOpResultListener) {
        final byte[] bArrOpenFile = openFile(str);
        JL_Log.w(u, "openFatFile", "file data : " + CHexConver.byte2HexStr(bArrOpenFile));
        this.e.post(new Runnable() { // from class: hl0
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.b(onFatFsOpResultListener, bArrOpenFile);
            }
        });
    }

    public void callbackProgress(int i) {
        if (this.f282q != null) {
            a(c(i));
        }
        this.i += i;
        this.k -= i;
        this.m += i;
    }

    public void createFatFile(final String str, final boolean z, final OnFatFileProgressListener onFatFileProgressListener) {
        if (!this.a || this.c.isShutdown()) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(22);
            }
        } else {
            if (this.f282q == null) {
                this.f282q = new FatOpParam().setOp(2).setFilePath(str).setProgressListener(onFatFileProgressListener);
                this.c.submit(new Runnable() { // from class: uk0
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.a.a(z, str, onFatFileProgressListener);
                    }
                });
                return;
            }
            JL_Log.w(u, "createFatFile", "An operation is in progress. " + this.f282q);
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(4352);
            }
        }
    }

    public native int createNewFile(String str, byte[] bArr);

    public void createReadBuffer(int i) {
        this.n = new byte[i];
        this.o = 0;
    }

    public final long d() {
        return ((long) getFreeSize()) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
    }

    public void deleteFatFile(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (!this.a || this.c.isShutdown()) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(22);
            }
        } else {
            if (this.f282q == null) {
                this.f282q = new FatOpParam().setOp(3).setFilePath(str).setProgressListener(onFatFileProgressListener).setTotalSize(PlaybackStateCompat.ACTION_PREPARE);
                this.c.submit(new Runnable() { // from class: wk0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g();
                    }
                });
                return;
            }
            JL_Log.w(u, "deleteFatFile", "An operation is in progress. " + this.f282q);
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(4352);
            }
        }
    }

    public native int deleteFile(String str);

    public void destroy() {
        JL_Log.w(u, "destroy", Constants.STR_EMPTY);
        j();
        i();
        if (!this.c.isShutdown()) {
            this.c.shutdownNow();
        }
        this.f.clear();
        PackResFormat packResFormat = this.r;
        if (packResFormat != null) {
            packResFormat.destroy();
            this.r = null;
        }
        this.d.release();
        libDestroy(this.b);
        this.b = 0L;
        this.s = null;
        a(false);
    }

    public final /* synthetic */ void e() {
        OnFatFsInitListener onFatFsInitListener = this.p;
        if (onFatFsInitListener != null) {
            onFatFsInitListener.onInitOk();
        }
    }

    public final /* synthetic */ void f() {
        FatOpParam fatOpParam = this.f282q;
        if (fatOpParam == null || fatOpParam.getProgressListener() == null) {
            return;
        }
        this.f282q.getProgressListener().onStart(this.f282q.getFilePath());
    }

    public final /* synthetic */ void g(int i) {
        b();
        int iInitDiskOp = initDiskOp();
        if (iInitDiskOp != 0) {
            JL_Log.e(u, "init", "FatFs init error. ret = " + iInitDiskOp);
            a(iInitDiskOp);
            return;
        }
        JL_Log.w(u, "init", "FatFs init ok.");
        if (i != 0) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateSysStatus(0);
        }
        int iMountDevice = mountDevice(this.b);
        a(iMountDevice == 0);
        if (this.a) {
            JL_Log.w(u, "init", "FatFs mount ok.");
            a();
            listFatDir(WatchConstant.FAT_FS_ROOT, null);
            this.r = new PackResFormat();
            this.s = new rv0().c();
            return;
        }
        JL_Log.e(u, "init", "FatFs mount failed. res = " + iMountDevice);
        a(iMountDevice);
    }

    public short getCrc16() {
        return this.j;
    }

    public String getCurBrowsePath() {
        return this.g;
    }

    public FatFile getFatFileMsg(String str) {
        FatFile fatFile = null;
        if (str != null && !this.f.isEmpty()) {
            String str2 = u;
            JL_Log.d(str2, "getFatFileMsg", "filePath = " + str);
            int iLastIndexOf = str.lastIndexOf(WatchConstant.FAT_FS_ROOT);
            if (iLastIndexOf == -1) {
                return null;
            }
            String strSubstring = iLastIndexOf > 0 ? str.substring(0, iLastIndexOf) : WatchConstant.FAT_FS_ROOT;
            JL_Log.d(str2, "getFatFileMsg", "key = " + strSubstring);
            ArrayList<FatFile> arrayList = this.f.get(strSubstring);
            if (arrayList == null) {
                arrayList = this.f.get(strSubstring + WatchConstant.FAT_FS_ROOT);
            }
            if (arrayList != null) {
                for (FatFile fatFile2 : arrayList) {
                    JL_Log.d(u, "getFatFileMsg", Constants.STR_EMPTY + fatFile2);
                    if (str.equalsIgnoreCase(fatFile2.getPath())) {
                        fatFile = fatFile2;
                        break;
                    }
                }
            }
            JL_Log.d(u, "getFatFileMsg", "fatFile = " + fatFile);
        }
        return fatFile;
    }

    public void getFatFsFreeSize(final OnFatFsOpResultListener<Long> onFatFsOpResultListener) {
        if (this.a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: al0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(0L);
        }
    }

    public native byte[] getFileHead(String str);

    public void getFileHeadData(final String str, final OnFatFsOpResultListener<byte[]> onFatFsOpResultListener) {
        if (this.a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: fl0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(str, onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(null);
        }
    }

    public int getFlagStatus() {
        return getFlagStatus(this.b);
    }

    public native int getFlagStatus(long j);

    public native int getFreeSize();

    public int getLeftDevSize() {
        return this.k;
    }

    public byte[] getNeedSendLeftData() {
        byte[] bArr = this.l;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        int i = this.m;
        int i2 = length - i;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public byte[] getNeedWriteData() {
        byte[] bArr = this.l;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public byte[] getReadBuffer() {
        byte[] bArr = this.n;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public int getReadLeftSize() {
        byte[] bArr = this.n;
        if (bArr == null) {
            return 0;
        }
        return bArr.length - this.o;
    }

    public int getReadStatus() {
        return getReadStatus(this.b);
    }

    public native int getReadStatus(long j);

    public byte[] getWriteLeftData() {
        byte[] bArr = this.h;
        int length = bArr.length;
        int i = this.i;
        int i2 = length - i;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public int getWriteStatus() {
        return getWriteStatus(this.b);
    }

    public native int getWriteStatus(long j);

    public final /* synthetic */ void h() throws Throwable {
        FatOpParam fatOpParam = this.f282q;
        if (fatOpParam == null) {
            b(4097);
            return;
        }
        byte[] fileData = WatchFileUtil.readFileData(fatOpParam.getFilePath());
        if (fileData == null || fileData.length == 0) {
            b(4);
            return;
        }
        if (this.d.getConnectedDevice() == null) {
            b(8192);
            return;
        }
        this.f282q.setTotalSize(fileData.length + 32768);
        String fatFilePath = FatUtil.getFatFilePath(this.g, this.f282q.getFilePath());
        if (d(fileData.length)) {
            b();
            int iReplaceFatFile = replaceFatFile(fatFilePath, fileData);
            JL_Log.w(u, "replaceFatFile", "replaceFatFile ---> " + iReplaceFatFile);
            b(iReplaceFatFile);
            return;
        }
        b();
        int iDeleteFile = deleteFile(fatFilePath);
        String str = u;
        JL_Log.d(str, "replaceFatFile", "deleteFile ---> " + iDeleteFile);
        if (iDeleteFile != 0) {
            b(iDeleteFile);
            return;
        }
        int iCreateNewFile = createNewFile(fatFilePath, fileData);
        JL_Log.w(str, "replaceFatFile", "createNewFile ---> " + iCreateNewFile);
        b(iCreateNewFile);
    }

    public final void i() {
        this.n = null;
        this.o = 0;
    }

    public native int initDiskOp();

    public boolean isMatchVersion(String str, byte[] bArr) {
        String jsonFileName = WatchFileUtil.getJsonFileName(str);
        if (this.r != null && jsonFileName != null && bArr != null && bArr.length != 0) {
            String str2 = u;
            JL_Log.d(str2, "isMatchVersion", "filePath = " + str + ", jsonFileName = " + jsonFileName + ", file size = " + bArr.length);
            byte[] fileData = this.r.getFileData(bArr, jsonFileName);
            StringBuilder sb = new StringBuilder();
            sb.append("data = ");
            sb.append(CHexConver.byte2HexStr(fileData));
            sb.append(", text = ");
            sb.append(fileData == null ? Constants.STR_EMPTY : new String(fileData));
            JL_Log.d(str2, "isMatchVersion", sb.toString());
            if (fileData == null) {
                return false;
            }
            try {
                FileExtMsg fileExtMsg = (FileExtMsg) c().fromJson(new String(fileData).trim(), FileExtMsg.class);
                JL_Log.d(str2, "isMatchVersion", "fileExtMsg = " + fileExtMsg);
                if (fileExtMsg == null) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("matchVersions = ");
                String[] strArr = this.t;
                sb2.append(strArr == null ? "null" : Arrays.toString(strArr));
                JL_Log.d(str2, "isMatchVersion", sb2.toString());
                String[] strArr2 = this.t;
                if (strArr2 == null || strArr2.length <= 0) {
                    return true;
                }
                for (String str3 : strArr2) {
                    JL_Log.d(u, "isMatchVersion", "version = " + str3);
                    if (str3.equalsIgnoreCase(fileExtMsg.getVersionID())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final void j() {
        this.h = null;
        this.j = (short) 0;
        this.i = 0;
        this.k = 0;
        this.m = 0;
        this.l = null;
    }

    public boolean judgeWriteFinish(int i) {
        byte[] bArr = this.h;
        return bArr != null && this.i + i >= bArr.length;
    }

    public native void libDestroy(long j);

    public native long libInit(int i, int i2);

    public native ArrayList<FatFile> listDir(String str);

    public void listFatDir(final String str, final OnFatFsOpResultListener<ArrayList<FatFile>> onFatFsOpResultListener) {
        if (this.a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: jl0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(str, onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(null);
        }
    }

    public void mount(final OnFatFsOpResultListener<Integer> onFatFsOpResultListener) {
        if (!this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: vk0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b(onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(8);
        }
    }

    public native int mountDevice(long j);

    public void onReadDataNotify(int i, int i2) {
        IBluetoothCtrl iBluetoothCtrl = this.d;
        iBluetoothCtrl.readFatDataFromDevice(iBluetoothCtrl.getConnectedDevice(), i, i2);
    }

    public void onWriteDataNotify(byte[] bArr, int i) {
        IBluetoothCtrl iBluetoothCtrl = this.d;
        iBluetoothCtrl.writeFatDataToDevice(iBluetoothCtrl.getConnectedDevice(), i, bArr);
    }

    public void onWriteFailed(ArrayList<FatWriteOp> arrayList) {
    }

    public void onWriteFlagNotify(boolean z) {
        IBluetoothCtrl iBluetoothCtrl = this.d;
        iBluetoothCtrl.sendWriteFlag(iBluetoothCtrl.getConnectedDevice(), z);
    }

    public void openFatFile(final String str, final OnFatFsOpResultListener<byte[]> onFatFsOpResultListener) {
        if (this.a && !this.c.isShutdown()) {
            this.c.submit(new Runnable() { // from class: zk0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(str, onFatFsOpResultListener);
                }
            });
        } else if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(null);
        }
    }

    public native byte[] openFile(String str);

    public void putDataInReadBuff(byte[] bArr) {
        byte[] bArr2;
        if (bArr != null && bArr.length != 0 && (bArr2 = this.n) != null) {
            int length = bArr.length;
            int i = this.o;
            if (length + i <= bArr2.length) {
                System.arraycopy(bArr, 0, bArr2, i, bArr.length);
                this.o += bArr.length;
                return;
            }
        }
        JL_Log.e(u, "putDataInReadBuff", "readBuffer no enough space.");
    }

    public boolean readBufferIsEmpty() {
        return this.n == null;
    }

    public native int replaceFatFile(String str, byte[] bArr);

    public void replaceFatFile(String str, OnFatFileProgressListener onFatFileProgressListener) {
        if (!this.a || this.c.isShutdown()) {
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(22);
            }
        } else {
            if (this.f282q == null) {
                this.f282q = new FatOpParam().setOp(4).setFilePath(str).setProgressListener(onFatFileProgressListener);
                this.c.submit(new Runnable() { // from class: gl0
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        this.a.h();
                    }
                });
                return;
            }
            JL_Log.w(u, "replaceFatFile", "An operation is in progress. " + this.f282q);
            if (onFatFileProgressListener != null) {
                onFatFileProgressListener.onStop(4352);
            }
        }
    }

    public void setNeedWriteData(int i) {
        byte[] bArr = this.h;
        if (bArr != null) {
            int length = bArr.length;
            int i2 = this.i;
            if (length >= i2 + i) {
                this.l = new byte[i];
            } else {
                this.l = new byte[length - i2];
            }
            byte[] bArr2 = this.l;
            System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
            this.m = 0;
        }
        this.k = i;
    }

    public void setWriteBuffer(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            this.h = null;
            this.i = 0;
            return;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        this.h = bArr2;
        short sCRC16 = CryptoUtil.CRC16(bArr2, (short) 0);
        this.j = sCRC16;
        this.i = 0;
        this.m = 0;
        this.l = null;
        JL_Log.d(u, "setWriteBuffer", RcspUtil.formatString("crc16 : %d(0x%X)", Short.valueOf(sCRC16), Short.valueOf(this.j)));
    }

    public native void updateFlagStatus(long j, int i);

    public void updateFlagStatus(boolean z) {
        updateFlagStatus(this.b, z ? 1 : 0);
    }

    public native void updateReadStatus(long j, int i, byte[] bArr);

    public void updateReadStatus(boolean z, byte[] bArr) {
        updateReadStatus(this.b, z ? 1 : 0, bArr);
    }

    public void updateSysStatus(int i) {
        updateSysStatus(this.b, i);
    }

    public native void updateSysStatus(long j, int i);

    public native void updateWriteStatus(long j, int i);

    public void updateWriteStatus(boolean z) {
        if (!z) {
            j();
        }
        updateWriteStatus(this.b, z ? 1 : 0);
    }

    public boolean writeBufferIsEmpty() {
        return this.h == null;
    }

    public final /* synthetic */ void a(boolean z, String str, OnFatFileProgressListener onFatFileProgressListener) throws Throwable {
        int iCreateNewFile;
        FatOpParam fatOpParam = this.f282q;
        if (fatOpParam == null) {
            b(4097);
            return;
        }
        byte[] fileData = WatchFileUtil.readFileData(fatOpParam.getFilePath());
        if (fileData == null || fileData.length == 0) {
            b(4);
            return;
        }
        if (this.d.getConnectedDevice() == null) {
            b(8192);
            return;
        }
        this.f282q.setTotalSize(fileData.length + 16384);
        if (!z && !isMatchVersion(this.f282q.getFilePath(), fileData)) {
            b(16896);
            return;
        }
        String fatFilePath = FatUtil.getFatFilePath(this.g, this.f282q.getFilePath());
        FatFile fatFileMsg = getFatFileMsg(fatFilePath);
        if (!d(fileData.length)) {
            if (fatFileMsg != null) {
                long jD = d() + fatFileMsg.getSize();
                JL_Log.w(u, "createFatFile", "freeSize = " + jD + ", file data size = " + fileData.length);
                if (jD >= fileData.length) {
                    this.f282q = null;
                    replaceFatFile(str, onFatFileProgressListener);
                    return;
                }
            }
            b(20);
            return;
        }
        b();
        if (fatFileMsg != null) {
            iCreateNewFile = deleteFile(fatFilePath);
            JL_Log.w(u, "createFatFile", "deleteFile ---> " + iCreateNewFile + ", fatFilePath = " + fatFilePath);
        } else {
            iCreateNewFile = 0;
        }
        if (iCreateNewFile == 0 || iCreateNewFile == 4 || iCreateNewFile == 5) {
            iCreateNewFile = createNewFile(fatFilePath, fileData);
        }
        JL_Log.w(u, "createFatFile", "createNewFile ---> " + iCreateNewFile);
        b(iCreateNewFile);
        if (iCreateNewFile == 0) {
            listFatDir(WatchConstant.FAT_FS_ROOT, null);
        }
    }

    public final boolean d(int i) {
        long jD = d();
        JL_Log.d(u, "hasEnoughSpace", "fatFsFreeSize = " + jD + ", dataLen = " + i);
        return jD - ((long) i) >= 0;
    }

    public final /* synthetic */ void e(int i) {
        OnFatFsInitListener onFatFsInitListener = this.p;
        if (onFatFsInitListener != null) {
            onFatFsInitListener.onInitFailed(i);
        }
    }

    public static /* synthetic */ void b(OnFatFsOpResultListener onFatFsOpResultListener, byte[] bArr) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(bArr);
        }
    }

    public final float c(int i) {
        FatOpParam fatOpParam = this.f282q;
        if (fatOpParam == null || fatOpParam.getTotalSize() == 0) {
            return 0.0f;
        }
        int sumFileDataLen = this.f282q.getSumFileDataLen() + i;
        this.f282q.setSumFileDataLen(sumFileDataLen);
        float totalSize = (sumFileDataLen * 100.0f) / this.f282q.getTotalSize();
        if (totalSize > 100.0f) {
            return 100.0f;
        }
        return totalSize;
    }

    public final /* synthetic */ void f(int i) {
        JL_Log.i(u, "callbackStop", "result : " + i + ", " + this.f282q);
        FatOpParam fatOpParam = this.f282q;
        if (fatOpParam != null) {
            OnFatFileProgressListener progressListener = fatOpParam.getProgressListener();
            j();
            this.f282q = null;
            if (progressListener != null) {
                progressListener.onStop(WatchError.fatfsToWatchErr(i));
            }
        }
    }

    public final /* synthetic */ void b(String str, final OnFatFsOpResultListener onFatFsOpResultListener) {
        ArrayList<FatFile> arrayListListDir = listDir(str);
        if (arrayListListDir != null) {
            if (!this.g.equalsIgnoreCase(str)) {
                if (this.g.equalsIgnoreCase(WatchConstant.FAT_FS_ROOT)) {
                    this.g += str;
                } else {
                    this.g += WatchConstant.FAT_FS_ROOT + str;
                }
            }
            JL_Log.i(u, "listFatDir", "put list in cache. curBrowsePath = " + this.g + ", fatFiles size = " + arrayListListDir.size());
            this.f.put(this.g, arrayListListDir);
        }
        final ArrayList<FatFile> arrayListA = a(arrayListListDir);
        this.e.post(new Runnable() { // from class: el0
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.a(onFatFsOpResultListener, arrayListA);
            }
        });
    }

    public final qv0 c() {
        if (this.s == null) {
            this.s = new rv0().c();
        }
        return this.s;
    }

    public final void b() {
        FatOpParam fatOpParam = this.f282q;
        if (fatOpParam != null) {
            fatOpParam.setSumFileDataLen(0);
        }
        this.e.post(new Runnable() { // from class: bl0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f();
            }
        });
    }

    public final /* synthetic */ void b(float f) {
        FatOpParam fatOpParam = this.f282q;
        if (fatOpParam == null || fatOpParam.getProgressListener() == null) {
            return;
        }
        this.f282q.getProgressListener().onProgress(f);
    }

    public final void b(final int i) {
        this.e.post(new Runnable() { // from class: tk0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.f(i);
            }
        });
    }

    public final /* synthetic */ void g() {
        if (this.f282q == null) {
            b(4097);
            return;
        }
        if (this.d.getConnectedDevice() == null) {
            b(8192);
            return;
        }
        b();
        int iDeleteFile = deleteFile(this.f282q.getFilePath());
        JL_Log.w(u, "deleteFatFile", "deleteFile ---> " + iDeleteFile + ", FilePath : " + this.f282q.getFilePath());
        b(iDeleteFile);
        if (iDeleteFile == 0) {
            listFatDir(WatchConstant.FAT_FS_ROOT, null);
        }
    }

    public static /* synthetic */ void a(OnFatFsOpResultListener onFatFsOpResultListener, ArrayList arrayList) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(arrayList);
        }
    }

    public final /* synthetic */ void a(final OnFatFsOpResultListener onFatFsOpResultListener) {
        final long jD = d();
        this.e.post(new Runnable() { // from class: sk0
            @Override // java.lang.Runnable
            public final void run() {
                FatFileSystem.a(onFatFsOpResultListener, jD);
            }
        });
    }

    public static /* synthetic */ void a(OnFatFsOpResultListener onFatFsOpResultListener, long j) {
        if (onFatFsOpResultListener != null) {
            onFatFsOpResultListener.onResult(Long.valueOf(j));
        }
    }

    public final /* synthetic */ void a(String str, final OnFatFsOpResultListener onFatFsOpResultListener) {
        final byte[] fileHead = getFileHead(str);
        if (onFatFsOpResultListener != null) {
            this.e.post(new Runnable() { // from class: dl0
                @Override // java.lang.Runnable
                public final void run() {
                    onFatFsOpResultListener.onResult(fileHead);
                }
            });
        }
    }

    public final void a(final float f) {
        this.e.post(new Runnable() { // from class: xk0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(f);
            }
        });
    }

    public final void a() {
        this.e.post(new Runnable() { // from class: kl0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e();
            }
        });
        JL_Log.d(u, "callbackInitOk", Constants.STR_EMPTY + this.f282q);
        if (this.f282q != null) {
            b(0);
        }
    }

    public final void a(final int i) {
        JL_Log.e(u, "callbackInitFailed", RcspUtil.formatString("code : %d(0x%X), %s", Integer.valueOf(i), Integer.valueOf(i), this.f282q));
        if (this.f282q != null) {
            b(i);
        }
        this.e.post(new Runnable() { // from class: il0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(i);
            }
        });
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final ArrayList<FatFile> a(ArrayList<FatFile> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList<FatFile> arrayList2 = new ArrayList<>();
        for (FatFile fatFile : arrayList) {
            if (!isIgnoreFile(fatFile.getName())) {
                arrayList2.add(fatFile);
            }
        }
        return arrayList2;
    }

    public final boolean a(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }
}
