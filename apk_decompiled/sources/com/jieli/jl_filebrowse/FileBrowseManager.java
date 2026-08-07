package com.jieli.jl_filebrowse;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.jieli.jl_filebrowse.bean.File;
import com.jieli.jl_filebrowse.bean.FileChangeInfo;
import com.jieli.jl_filebrowse.bean.FileStruct;
import com.jieli.jl_filebrowse.bean.Folder;
import com.jieli.jl_filebrowse.bean.PathData;
import com.jieli.jl_filebrowse.bean.RegFile;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_filebrowse.interfaces.DeleteCallback;
import com.jieli.jl_filebrowse.interfaces.FileBrowseOperator;
import com.jieli.jl_filebrowse.interfaces.FileObserver;
import com.jieli.jl_filebrowse.interfaces.LrcDecoder;
import com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback;
import com.jieli.jl_filebrowse.interfaces.OperatCallback;
import com.jieli.jl_filebrowse.interfaces.lrc.LrcReadObserver;
import com.jieli.jl_filebrowse.interfaces.lrc.LrcReadOperator;
import com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback;
import com.jieli.jl_filebrowse.tool.FileObserverHelper;
import com.jieli.jl_filebrowse.tool.LrcReadObserverHelper;
import com.jieli.jl_rcsp.impl.OnFileBrowseCallbackImpl;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.tool.filebrowse.FileBrowseOperatorImpl;
import com.jieli.jl_rcsp.tool.filebrowse.LrcReadOperatorImpl;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FileBrowseManager implements OnFileBrowseCallback, OnLrcCallback {
    public static int MAX_FOLDER_LEVEL = 8;
    public static long WAITING_CMD_TIMEOUT = 20000;
    public static final String v = "FileBrowseManager";
    public static final int w = 4112;

    @SuppressLint({"StaticFieldLeak"})
    public static volatile FileBrowseManager x = null;
    public static final int y = 3072;
    public static String z;
    public FileBrowseOperator a;
    public LrcReadOperator b;
    public final FileObserverHelper c;
    public final LrcReadObserverHelper d;
    public volatile RcspOpImpl i;
    public volatile SDCardBean k;
    public volatile PathData l;
    public Context m;
    public OnRcspCallback o;
    public final Handler p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public byte[] f283q;
    public int r;
    public FileStruct s;
    public LrcDecoder t;
    public boolean u;
    public final Map<String, Folder> e = new HashMap();
    public final ByteArrayOutputStream f = new ByteArrayOutputStream();
    public final List<SDCardBean> g = new ArrayList();
    public int h = 10;
    public volatile boolean j = false;
    public volatile boolean n = false;

    public FileBrowseManager() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.jieli.jl_filebrowse.FileBrowseManager.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null) {
                    return false;
                }
                if (message.what == 4112) {
                    int i = message.arg1;
                    JL_Log.i(FileBrowseManager.v, "MSG_WAITING_FOR_DATA_TIMEOUT", "type = " + i + ", " + FileBrowseManager.this.k);
                    FileBrowseManager.this.c();
                    if (i == 1) {
                        FileBrowseManager.this.c.OnFlayCallback(false);
                    } else {
                        FileBrowseManager.this.onFileReadFailed(4099);
                    }
                }
                return true;
            }
        });
        this.p = handler;
        this.r = 0;
        this.u = true;
        this.c = new FileObserverHelper(handler);
        this.d = new LrcReadObserverHelper(handler);
    }

    public static FileBrowseManager getInstance() {
        if (x == null) {
            synchronized (FileBrowseManager.class) {
                x = new FileBrowseManager();
            }
        }
        return x;
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void OnFlayCallback(boolean z2) {
        JL_Log.d(v, "OnFlayCallback", "isSuccess : " + z2);
        c();
        this.c.OnFlayCallback(z2);
    }

    public void addFileObserver(FileObserver fileObserver) {
        this.c.registerCallback(fileObserver);
    }

    public void addLrcReadObserver(LrcReadObserver lrcReadObserver) {
        this.d.registerCallback(lrcReadObserver);
    }

    public int appenBrowse(FileStruct fileStruct, SDCardBean sDCardBean) {
        int iListFiles = 4097;
        if (fileStruct != null && sDCardBean != null) {
            if (b(sDCardBean)) {
                return 16384;
            }
            Folder currentReadFile = getCurrentReadFile(sDCardBean);
            if (currentReadFile == null) {
                JL_Log.w(v, "appenBrowse", "No file found. " + fileStruct);
                return 16387;
            }
            File childFile = currentReadFile.getChildFile(fileStruct.getCluster());
            if (childFile == null) {
                childFile = new Folder(currentReadFile, fileStruct);
            }
            if (childFile.isFile()) {
                JL_Log.w(v, "appenBrowse", "Target is not folder. " + fileStruct);
                return 4097;
            }
            Folder folder = (Folder) childFile;
            if (folder.getLevel() > MAX_FOLDER_LEVEL) {
                JL_Log.w(v, "appenBrowse", "Folders are too deep. limit level = " + MAX_FOLDER_LEVEL);
                return 16388;
            }
            if (isReading()) {
                JL_Log.w(v, "appenBrowse", "Reading file data.");
                return 16385;
            }
            String str = v;
            JL_Log.d(str, "appenBrowse", Constants.STR_EMPTY + folder);
            this.e.put(a(sDCardBean), folder);
            iListFiles = listFiles(folder, 1);
            if (iListFiles != 0) {
                this.e.put(a(sDCardBean), currentReadFile);
                JL_Log.i(str, "appenBrowse", "result = " + iListFiles + ", target = " + folder + ",\n cacheFolder = " + currentReadFile);
            }
        }
        return iListFiles;
    }

    public int backBrowse(SDCardBean sDCardBean) {
        return backBrowse(sDCardBean, true);
    }

    public void cleanCache() {
        JL_Log.i(v, "cleanCache", "clear all");
        Iterator<SDCardBean> it = this.g.iterator();
        while (it.hasNext()) {
            cleanCache(it.next());
        }
        this.g.clear();
    }

    public int deleteFile(SDCardBean sDCardBean, List<FileStruct> list, DeleteCallback deleteCallback) {
        return deleteFile(sDCardBean, list, true, deleteCallback);
    }

    public int formatDevice(final SDCardBean sDCardBean, final OperatCallback operatCallback) {
        if (sDCardBean == null) {
            return 4097;
        }
        if (b(sDCardBean)) {
            return 16384;
        }
        if (isReading()) {
            return 16385;
        }
        a(true);
        this.a.formatDevice(sDCardBean.getDevHandler(), new OperatCallback() { // from class: com.jieli.jl_filebrowse.FileBrowseManager.2
            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onError(int i) {
                FileBrowseManager.this.c();
                OperatCallback operatCallback2 = operatCallback;
                if (operatCallback2 != null) {
                    operatCallback2.onError(i);
                }
            }

            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onSuccess() {
                FileBrowseManager.this.cleanCache(sDCardBean);
                FileBrowseManager.this.c();
                OperatCallback operatCallback2 = operatCallback;
                if (operatCallback2 != null) {
                    operatCallback2.onSuccess();
                }
            }
        });
        return 0;
    }

    public List<FileStruct> getCurrentFileStructs(SDCardBean sDCardBean) {
        Folder currentReadFile = getCurrentReadFile(sDCardBean);
        return currentReadFile == null ? new ArrayList() : currentReadFile.getChildFileStructs();
    }

    public Folder getCurrentReadFile(SDCardBean sDCardBean) {
        if (b(sDCardBean)) {
            return null;
        }
        return this.e.get(a(sDCardBean));
    }

    public List<SDCardBean> getOnlineDev() {
        ArrayList arrayList = new ArrayList();
        for (SDCardBean sDCardBean : getSdCardBeans()) {
            if (sDCardBean.isOnline()) {
                arrayList.add(sDCardBean);
            }
        }
        return arrayList;
    }

    public SDCardBean getOnlineStorage(FileStruct fileStruct) {
        if (fileStruct == null) {
            return null;
        }
        return a(fileStruct.getDevIndex());
    }

    public int getPageSize() {
        return this.h;
    }

    public List<SDCardBean> getSdCardBeans() {
        return new ArrayList(this.g);
    }

    public void init(RcspOpImpl rcspOpImpl) {
        if (this.n) {
            throw new RuntimeException("It cannot be initialize morn than once!");
        }
        this.i = rcspOpImpl;
        setLrcReadOperator(new LrcReadOperatorImpl(rcspOpImpl));
        setFileBrowseOperator(new FileBrowseOperatorImpl(rcspOpImpl));
        OnFileBrowseCallbackImpl onFileBrowseCallbackImpl = new OnFileBrowseCallbackImpl(rcspOpImpl, this, this);
        this.o = onFileBrowseCallbackImpl;
        rcspOpImpl.registerOnRcspCallback(onFileBrowseCallbackImpl);
        this.n = true;
    }

    public boolean isInit() {
        return this.n;
    }

    public boolean isOnline(int i) {
        for (SDCardBean sDCardBean : getSdCardBeans()) {
            if (sDCardBean.getIndex() == i) {
                return sDCardBean.isOnline();
            }
        }
        return false;
    }

    public boolean isOpenLrcCache() {
        return this.u;
    }

    public boolean isReading() {
        return this.j;
    }

    public int listFiles(Folder folder, int i) {
        return listFiles(folder, i, true);
    }

    public int loadMore(SDCardBean sDCardBean) {
        if (b(sDCardBean)) {
            return 16384;
        }
        Folder currentReadFile = getCurrentReadFile(sDCardBean);
        if (currentReadFile == null) {
            return 16387;
        }
        if (currentReadFile.isLoadFinished(false)) {
            return 16386;
        }
        int childCount = currentReadFile.getChildCount() + 1;
        JL_Log.d(v, "loadMore", currentReadFile + ", offset = " + childCount);
        return listFiles(currentReadFile, childCount);
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onBluetoothConnectionChange(BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothDevice == null) {
            return;
        }
        JL_Log.i(v, "onBluetoothConnectionChange", "device : " + RcspUtil.printBtDeviceInfo(bluetoothDevice) + ", status : " + i);
        if (i == 0) {
            cleanCache(bluetoothDevice);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileDataReceive(byte[] bArr) {
        if (isReading()) {
            try {
                String str = v;
                StringBuilder sb = new StringBuilder();
                sb.append("data size = ");
                sb.append(bArr == null ? 0 : bArr.length);
                JL_Log.d(str, "onFileDataReceive", sb.toString());
                b(0);
                this.f.write(bArr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileReadFailed(int i) {
        if (isReading()) {
            final PathData pathData = this.l;
            final SDCardBean sDCardBean = this.k;
            JL_Log.i(v, "onFileReadFailed", "reason : " + i + "+ " + pathData);
            if (i == 3 && pathData != null && pathData.getRepeatTimes() > 0) {
                this.p.postDelayed(new Runnable() { // from class: am0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(pathData, sDCardBean);
                    }
                }, 500L);
            } else {
                c();
                this.c.onFileReadFailed(i);
            }
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileReadStart() {
        this.c.onFileReadStart();
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileReadStop(boolean z2) {
        if (isReading()) {
            SDCardBean sDCardBean = this.k;
            PathData pathData = this.l;
            byte[] byteArray = this.f.toByteArray();
            String str = v;
            JL_Log.d(str, "onFileReadStop", "isEnd = " + z2 + ", storage = " + sDCardBean + ", data size = " + byteArray.length);
            List<FileStruct> dataHasPacket = this.a.dataHasPacket() ? FileBrowseUtil.parseDataHasPacket(byteArray) : FileBrowseUtil.parseData(byteArray);
            this.f.reset();
            Folder currentReadFile = getCurrentReadFile(sDCardBean);
            if (currentReadFile == null) {
                JL_Log.e(str, "onFileReadStop", "not found read folder. " + sDCardBean);
                c();
                this.c.onFileReadFailed(16387);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (FileStruct fileStruct : dataHasPacket) {
                if (fileStruct != null) {
                    JL_Log.d(v, "onFileReadStop", Constants.STR_EMPTY + fileStruct);
                    arrayList.add(fileStruct.isFile() ? new RegFile(currentReadFile, fileStruct) : new Folder(currentReadFile, fileStruct));
                }
            }
            if (!arrayList.isEmpty() && arrayList.get(0).getDevIndex() != currentReadFile.getDevIndex()) {
                JL_Log.w(v, "onFileReadStop", "File data does not match.");
                b(pathData, sDCardBean);
                return;
            }
            if (!z2 && dataHasPacket.isEmpty()) {
                z2 = true;
            }
            currentReadFile.addChild(arrayList);
            currentReadFile.setLoadFinished(z2);
            c();
            this.c.onFileReceiver(dataHasPacket);
            this.c.onFileReadStop(z2);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onFileStructureChange(FileChangeInfo fileChangeInfo) {
        List<SDCardBean> onlineDev;
        SDCardBean next;
        Folder currentReadFile;
        Folder parent;
        if (fileChangeInfo == null || (onlineDev = getOnlineDev()) == null || onlineDev.isEmpty()) {
            return;
        }
        Iterator<SDCardBean> it = onlineDev.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.getDevHandler() != fileChangeInfo.getDevHandle());
        if (next == null || next.getDevHandler() != fileChangeInfo.getDevHandle() || (currentReadFile = getCurrentReadFile(next)) == null) {
            return;
        }
        do {
            parent = currentReadFile.getParent();
            if (parent != null) {
                currentReadFile = parent;
            }
        } while (parent != null);
        String str = v;
        JL_Log.d(str, "onFileStructureChange", currentReadFile + ",\n " + fileChangeInfo);
        Folder folderA = a(currentReadFile, fileChangeInfo.getFilePath());
        JL_Log.d(str, "onFileStructureChange", "op = " + fileChangeInfo.getOp() + ", targetFolder = " + folderA);
        if (folderA == null) {
            return;
        }
        int op = fileChangeInfo.getOp();
        if (op == 1) {
            folderA.removeChild(fileChangeInfo.getCluster());
        } else {
            if (op != 2) {
                return;
            }
            folderA.setLoadFinished(false);
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcDataReceive(byte[] bArr) throws Throwable {
        byte[] bArr2 = this.f283q;
        if (bArr2 != null) {
            int i = this.r;
            if (bArr.length + i > bArr2.length) {
                byte[] bArr3 = new byte[bArr2.length * 2];
                System.arraycopy(bArr2, 0, bArr3, 0, i);
                this.f283q = bArr3;
            }
            String str = v;
            StringBuilder sb = new StringBuilder();
            sb.append("lrcBuffer ---> ");
            byte[] bArr4 = this.f283q;
            sb.append(CHexConver.byte2HexStr(bArr4, bArr4.length));
            JL_Log.d(str, "onLrcDataReceive", sb.toString());
            System.arraycopy(bArr, 3, this.f283q, this.r, bArr.length - 3);
            this.r += bArr.length - 3;
            if ((bArr[0] & 255) == 255) {
                onLrcReadStop();
            }
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcReadFailed(int i) {
        JL_Log.d(v, "onLrcReadFailed", "reason : " + i);
        this.r = 0;
        this.f283q = null;
        this.d.onLrcReadFailed(i);
    }

    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcReadStart() {
        this.r = 0;
        this.f283q = new byte[y];
        this.d.onLrcReadStart();
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.jieli.jl_filebrowse.interfaces.lrc.OnLrcCallback
    public void onLrcReadStop() throws Throwable {
        int i;
        String str;
        Throwable th;
        FileOutputStream fileOutputStream;
        byte[] bArr = this.f283q;
        if (bArr == null || (i = this.r) < 5) {
            onLrcReadFailed(-1);
            return;
        }
        byte[] bytes = new byte[i];
        System.arraycopy(bArr, 0, bytes, 0, i);
        LrcDecoder lrcDecoder = this.t;
        if (lrcDecoder != null) {
            bytes = lrcDecoder.decode(bytes);
        }
        byte b = bytes[0];
        if (b == -1) {
            str = "utf_16le";
        } else if (b == -2 && bytes[1] == -1) {
            str = "utf_16be";
        } else {
            str = (b == -17 && bytes[1] == -69 && bytes[2] == -65) ? "utf-8" : "gbk";
        }
        try {
            bytes = new String(bytes, str).getBytes(StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream = new FileOutputStream(a(this.m, this.s));
            try {
                try {
                    fileOutputStream.write(bytes);
                    this.r = 0;
                    this.f283q = null;
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    a(a(this.m, this.s));
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    onLrcReadFailed(16389);
                    this.r = 0;
                    this.f283q = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                this.r = 0;
                this.f283q = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            this.r = 0;
            this.f283q = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    @Override // com.jieli.jl_filebrowse.interfaces.OnFileBrowseCallback
    public void onSdCardChange(List<SDCardBean> list) {
        SDCardBean sDCardBean = this.k;
        this.g.clear();
        this.g.addAll(list);
        for (SDCardBean sDCardBean2 : list) {
            if (!sDCardBean2.isOnline()) {
                cleanCache(sDCardBean2);
                if (sDCardBean2.equals(sDCardBean)) {
                    this.p.removeCallbacksAndMessages(null);
                    if (isReading()) {
                        onFileReadFailed(16384);
                    }
                }
            } else if (getCurrentReadFile(sDCardBean2) == null) {
                this.e.put(a(sDCardBean2), File.createRootFolder(sDCardBean2.getIndex()));
            }
        }
        this.c.onSdCardStatusChange(getOnlineDev());
    }

    public int playFile(FileStruct fileStruct, SDCardBean sDCardBean) {
        if (fileStruct != null && sDCardBean != null) {
            if (b(sDCardBean)) {
                return 16384;
            }
            Folder currentReadFile = getCurrentReadFile(sDCardBean);
            if (currentReadFile == null) {
                return 16387;
            }
            File childFile = currentReadFile.getChildFile(fileStruct.getCluster());
            if (childFile != null && !childFile.isFolder()) {
                return playFile((RegFile) childFile);
            }
        }
        return 4097;
    }

    public void release() {
        JL_Log.i(v, "release", Constants.STR_EMPTY);
        this.n = false;
        if (this.i != null) {
            this.i.unregisterOnRcspCallback(this.o);
        }
        c();
        cleanCache();
        this.c.release();
        this.d.release();
        this.e.clear();
        x = null;
    }

    public void removeFileObserver(FileObserver fileObserver) {
        this.c.unregisterCallback(fileObserver);
    }

    public void removeLrcReadObserver(LrcReadObserver lrcReadObserver) {
        this.d.unregisterCallback(lrcReadObserver);
    }

    public void setFileBrowseOperator(FileBrowseOperator fileBrowseOperator) {
        this.a = fileBrowseOperator;
    }

    public void setLrcDecoder(LrcDecoder lrcDecoder) {
        this.t = lrcDecoder;
    }

    public void setLrcReadOperator(LrcReadOperator lrcReadOperator) {
        this.b = lrcReadOperator;
    }

    public void setOpenLrcCache(boolean z2) {
        this.u = z2;
    }

    public void setPageSize(int i) {
        this.h = i;
    }

    public void startLrcRead(Context context, FileStruct fileStruct) {
        if (this.b != null) {
            java.io.File file = new java.io.File(a(context, fileStruct));
            JL_Log.d(v, "startLrcRead", "path : " + file.getPath());
            if (file.exists()) {
                if (isOpenLrcCache()) {
                    a(file.getPath());
                    return;
                }
                file.delete();
            }
            this.m = context;
            this.s = fileStruct;
            this.b.startLrcRead(new OperatCallback() { // from class: com.jieli.jl_filebrowse.FileBrowseManager.5
                @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
                public void onError(int i) {
                    FileBrowseManager.this.onLrcReadFailed(i);
                }

                @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
                public void onSuccess() {
                    FileBrowseManager.this.onLrcReadStart();
                }
            });
        }
    }

    public final boolean b(SDCardBean sDCardBean) {
        if (sDCardBean == null) {
            return true;
        }
        return !isOnline(sDCardBean.getIndex());
    }

    public int backBrowse(SDCardBean sDCardBean, boolean z2) {
        if (sDCardBean == null) {
            return 4097;
        }
        if (b(sDCardBean)) {
            return 16384;
        }
        Folder currentReadFile = getCurrentReadFile(sDCardBean);
        if (currentReadFile == null) {
            return 16387;
        }
        if (isReading()) {
            JL_Log.w(v, "backBrowse", "Reading file data.");
            return 16385;
        }
        Folder parent = currentReadFile.getParent();
        if (parent == null) {
            parent = currentReadFile;
        }
        String str = v;
        JL_Log.d(str, "backBrowse", Constants.STR_EMPTY + parent);
        this.e.put(a(sDCardBean), parent);
        int iListFiles = listFiles(parent, 1, z2);
        if (iListFiles != 0) {
            this.e.put(a(sDCardBean), currentReadFile);
            JL_Log.d(str, "backBrowse", "result = " + iListFiles + ", target = " + parent + ",\n currentFolder = " + currentReadFile);
        }
        return iListFiles;
    }

    public final void c() {
        a(false);
        this.f.reset();
        b();
        this.p.removeCallbacksAndMessages(null);
        this.k = null;
        this.l = null;
    }

    public int deleteFile(SDCardBean sDCardBean, List<FileStruct> list, boolean z2, DeleteCallback deleteCallback) {
        if (sDCardBean == null || list == null || list.isEmpty()) {
            return 4097;
        }
        if (b(sDCardBean)) {
            return 16384;
        }
        if (isReading()) {
            return 16385;
        }
        return a(sDCardBean, new ArrayList(list), z2, deleteCallback);
    }

    public int listFiles(Folder folder, int i, boolean z2) {
        if (folder == null) {
            return 4097;
        }
        SDCardBean onlineStorage = getOnlineStorage(folder);
        if (onlineStorage == null || b(onlineStorage)) {
            JL_Log.w(v, "listFiles", RcspUtil.formatString("Storage[%s] is offline.", onlineStorage));
            return 16384;
        }
        if (onlineStorage.getDevice() == null) {
            JL_Log.w(v, "listFiles", "Wrong parameters.");
            return 4097;
        }
        if (isReading()) {
            JL_Log.w(v, "listFiles", "Reading file data.");
            return 16385;
        }
        final List<FileStruct> listA = a(folder, i);
        int size = listA.size();
        String str = v;
        JL_Log.d(str, "listFiles", folder + ", offset = " + i + ", cacheFiles size = " + size);
        if (size > 0) {
            if (z2) {
                JL_Log.d(str, "listFiles", "callback cache file list.");
                final boolean zA = a(folder, listA.get(size - 1));
                this.p.postDelayed(new Runnable() { // from class: bm0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(listA, zA);
                    }
                }, 300L);
            }
            return 0;
        }
        PathData pathDataConvertPathData = folder.convertPathData(onlineStorage, (short) i, this.h);
        if (pathDataConvertPathData == null) {
            JL_Log.w(str, "listFiles", "File is not in storage.");
            return 16390;
        }
        a(true);
        b(pathDataConvertPathData, onlineStorage);
        return 0;
    }

    public final void b(int i) {
        b();
        Handler handler = this.p;
        handler.sendMessageDelayed(handler.obtainMessage(4112, i, 0), WAITING_CMD_TIMEOUT);
    }

    public final void b() {
        this.p.removeMessages(4112);
    }

    public void cleanCache(BluetoothDevice bluetoothDevice) {
        Folder value;
        if (bluetoothDevice == null) {
            return;
        }
        JL_Log.i(v, "cleanCache", "device : " + bluetoothDevice);
        for (Map.Entry<String, Folder> entry : this.e.entrySet()) {
            if (entry.getKey().endsWith(bluetoothDevice.getAddress()) && (value = entry.getValue()) != null) {
                entry.setValue(a(value));
            }
        }
    }

    public final /* synthetic */ void a(List list, boolean z2) {
        this.c.onFileReceiver(list);
        this.c.onFileReadStop(z2);
    }

    public final void b(final PathData pathData, final SDCardBean sDCardBean) {
        if (pathData == null || sDCardBean == null) {
            return;
        }
        this.k = sDCardBean;
        this.l = pathData;
        JL_Log.d(v, "sendPathDataToDevice", pathData + ",\n" + sDCardBean);
        this.a.sendPathDataCmd(pathData, FileBrowseUtil.coverPathDataToCmd(pathData), new OperatCallback() { // from class: com.jieli.jl_filebrowse.FileBrowseManager.4
            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onError(int i) {
                JL_Log.d(FileBrowseManager.v, "sendPathDataToDevice", "onError :: code = " + i + ", data = " + pathData + ", " + sDCardBean);
                if (pathData.getType() == 0) {
                    FileBrowseManager.this.onFileReadFailed(i);
                } else {
                    FileBrowseManager.this.OnFlayCallback(false);
                }
            }

            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onSuccess() {
                FileBrowseManager.this.b(pathData.getType());
                if (pathData.getType() != 0) {
                    JL_Log.d(FileBrowseManager.v, "sendPathDataToDevice", "Ready to play music.");
                } else {
                    JL_Log.d(FileBrowseManager.v, "sendPathDataToDevice", "Ready to receive file data.");
                    FileBrowseManager.this.onFileReadStart();
                }
            }
        });
    }

    public int deleteFile(List<FileStruct> list, boolean z2, DeleteCallback deleteCallback) {
        if (list == null || list.isEmpty()) {
            return 4097;
        }
        return deleteFile(getOnlineStorage(list.get(0)), new ArrayList(list), z2, deleteCallback);
    }

    public int playFile(RegFile regFile) {
        if (regFile == null) {
            return 4097;
        }
        SDCardBean onlineStorage = getOnlineStorage(regFile);
        if (onlineStorage == null || b(onlineStorage)) {
            return 16384;
        }
        if (isReading()) {
            return 16385;
        }
        JL_Log.d(v, "playFile", Constants.STR_EMPTY + regFile);
        a(true);
        b(regFile.convertPathData(onlineStorage, (short) 1, this.h), onlineStorage);
        return 0;
    }

    public final /* synthetic */ void a(PathData pathData, SDCardBean sDCardBean) {
        pathData.setRepeatTimes(pathData.getRepeatTimes() - 1);
        b(pathData, sDCardBean);
    }

    public final void a(boolean z2) {
        this.j = z2;
    }

    public final SDCardBean a(int i) {
        for (SDCardBean sDCardBean : getSdCardBeans()) {
            if (i == sDCardBean.getIndex() && sDCardBean.isOnline()) {
                return sDCardBean;
            }
        }
        return null;
    }

    public void cleanCache(SDCardBean sDCardBean) {
        String strA;
        Folder folder;
        if (sDCardBean == null || (folder = this.e.get((strA = a(sDCardBean)))) == null) {
            return;
        }
        JL_Log.i(v, "cleanCache", sDCardBean + ",\n " + folder);
        this.e.put(strA, a(folder));
    }

    public final int a(final SDCardBean sDCardBean, final List<FileStruct> list, final boolean z2, final DeleteCallback deleteCallback) {
        if (sDCardBean == null || list == null) {
            return 4097;
        }
        if (list.isEmpty()) {
            return 0;
        }
        boolean z3 = list.size() == 1;
        final FileStruct fileStructRemove = list.remove(list.size() - 1);
        a(true);
        final boolean z4 = z3;
        this.a.deleteFile(sDCardBean.getDevHandler(), fileStructRemove.isFile() ? (byte) 1 : (byte) 0, fileStructRemove.getCluster(), z3, z2, new OperatCallback() { // from class: com.jieli.jl_filebrowse.FileBrowseManager.3
            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onError(int i) {
                FileBrowseManager.this.c();
                DeleteCallback deleteCallback2 = deleteCallback;
                if (deleteCallback2 != null) {
                    deleteCallback2.onError(i, fileStructRemove);
                }
                if (!z4) {
                    FileBrowseManager.this.a(sDCardBean, list, z2, deleteCallback);
                    return;
                }
                DeleteCallback deleteCallback3 = deleteCallback;
                if (deleteCallback3 != null) {
                    deleteCallback3.onFinish();
                }
            }

            @Override // com.jieli.jl_filebrowse.interfaces.OperatCallback
            public void onSuccess() {
                FileBrowseManager.this.a(fileStructRemove);
                FileBrowseManager.this.c();
                DeleteCallback deleteCallback2 = deleteCallback;
                if (deleteCallback2 != null) {
                    deleteCallback2.onSuccess(fileStructRemove);
                }
                if (!z4) {
                    FileBrowseManager.this.a(sDCardBean, list, z2, deleteCallback);
                    return;
                }
                DeleteCallback deleteCallback3 = deleteCallback;
                if (deleteCallback3 != null) {
                    deleteCallback3.onFinish();
                }
            }
        });
        return 0;
    }

    public final String a(SDCardBean sDCardBean) {
        if (sDCardBean == null) {
            return Constants.STR_EMPTY;
        }
        BluetoothDevice device = sDCardBean.getDevice();
        if (device == null) {
            return String.valueOf(sDCardBean.getIndex());
        }
        return sDCardBean.getIndex() + "-" + device.getAddress();
    }

    public int appenBrowse(Folder folder) {
        if (folder == null) {
            return 4097;
        }
        SDCardBean sDCardBeanA = a(folder.getDevIndex());
        if (sDCardBeanA == null || b(sDCardBeanA)) {
            return 16384;
        }
        return appenBrowse(folder.getFileStruct(), sDCardBeanA);
    }

    public final List<FileStruct> a(Folder folder, int i) {
        SDCardBean onlineStorage = getOnlineStorage(folder);
        if (onlineStorage == null) {
            return new ArrayList();
        }
        Folder currentReadFile = getCurrentReadFile(onlineStorage);
        if (currentReadFile == null) {
            return new ArrayList();
        }
        int childCount = currentReadFile.getChildCount();
        boolean zIsLoadFinished = currentReadFile.isLoadFinished(false);
        JL_Log.d(v, "readCacheFiles", childCount + ", offset = " + i + ", isLoadFinished = " + zIsLoadFinished);
        if (zIsLoadFinished && childCount >= i) {
            int i2 = i - 1;
            return currentReadFile.getChildFileStructs().subList(i2, childCount + i2);
        }
        if (childCount < (this.h + i) - 1) {
            return new ArrayList();
        }
        int i3 = i - 1;
        return currentReadFile.getChildFileStructs().subList(i3, this.h + i3);
    }

    public final boolean a(Folder folder, FileStruct fileStruct) {
        SDCardBean onlineStorage;
        Folder currentReadFile;
        if (folder == null || fileStruct == null || (onlineStorage = getOnlineStorage(folder)) == null || (currentReadFile = getCurrentReadFile(onlineStorage)) == null) {
            return false;
        }
        return currentReadFile.isEndElement(fileStruct);
    }

    public final void a(FileStruct fileStruct) {
        SDCardBean sDCardBeanA;
        Folder currentReadFile;
        if (fileStruct == null || (sDCardBeanA = a(fileStruct.getDevIndex())) == null || (currentReadFile = getCurrentReadFile(sDCardBeanA)) == null) {
            return;
        }
        for (currentReadFile = getCurrentReadFile(sDCardBeanA); currentReadFile != null && !currentReadFile.removeChild(fileStruct.getCluster()); currentReadFile = currentReadFile.getParent()) {
        }
    }

    public final Folder a(Folder folder) {
        if (folder == null) {
            return null;
        }
        folder.clean();
        Folder parent = folder.getParent();
        while (true) {
            Folder folder2 = parent;
            Folder folder3 = folder;
            folder = folder2;
            if (folder != null) {
                folder.clean();
                parent = folder.getParent();
            } else {
                folder3.clean();
                return folder3;
            }
        }
    }

    public final Folder a(Folder folder, String str) {
        if (folder == null || str == null || str.isEmpty()) {
            return null;
        }
        String str2 = java.io.File.separator;
        int iLastIndexOf = str.lastIndexOf(str2);
        if (iLastIndexOf != -1 && !str2.equals(str)) {
            int i = 0;
            String strSubstring = str.substring(0, iLastIndexOf);
            String[] strArrSplit = strSubstring.split(str2);
            if (strArrSplit.length == 0) {
                strArrSplit = new String[]{strSubstring};
            }
            int length = strArrSplit.length;
            while (i < length) {
                Folder folderFindFolderByName = folder.findFolderByName(strArrSplit[i]);
                if (folderFindFolderByName == null) {
                    break;
                }
                i++;
                folder = folderFindFolderByName;
            }
        }
        return folder;
    }

    public final void a(String str) {
        this.d.onLrcReadStop(str);
    }

    public final String a(Context context, FileStruct fileStruct) {
        if (fileStruct == null) {
            return "lrc_Default";
        }
        return a(context) + java.io.File.separator + fileStruct.getName() + fileStruct.getCluster();
    }

    public final String a(Context context) {
        if (context == null) {
            return Constants.STR_EMPTY;
        }
        if (TextUtils.isEmpty(z)) {
            String path = context.getFilesDir().getPath();
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            String str = java.io.File.separator;
            sb.append(str);
            sb.append(context.getPackageName());
            sb.append(str);
            sb.append("lrcCache");
            z = sb.toString();
        }
        java.io.File file = new java.io.File(z);
        if (!file.exists() && !file.mkdirs()) {
            JL_Log.w(v, "getLrcCachePath", "can not create lrc cache path");
            return Constants.STR_EMPTY;
        }
        return file.getPath();
    }
}
