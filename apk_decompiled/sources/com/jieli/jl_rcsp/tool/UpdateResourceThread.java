package com.jieli.jl_rcsp.tool;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.jieli.jl_fatfs.FatFileSystem;
import com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener;
import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_fatfs.utils.FatUtil;
import com.jieli.jl_fatfs.utils.ZipUtil;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.interfaces.watch.OnUpdateResourceCallback;
import com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.jieli.jl_rcsp.util.WatchFileUtil;
import com.jieli.jl_rcsp.watch.fatfs.FatFsWatch;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UpdateResourceThread extends Thread {
    public static final String n = "UpdateResourceThread";
    public boolean b;
    public int c;
    public final FatFsWatch d;
    public final FatFileSystem e;
    public final String f;
    public String g;
    public String h;
    public final OnUpdateResourceCallback i;
    public final ThreadStateListener j;
    public boolean l;
    public BaseError m;
    public final Object a = new Object();
    public final Handler k = new Handler(Looper.getMainLooper());

    public static class UpdateTask {
        public static final int OP_CREATE_FILE = 1;
        public static final int OP_REPLACE_FILE = 2;
        public String filePath;
        public long fileSize;
        public int op;

        public UpdateTask() {
        }
    }

    public UpdateResourceThread(FatFsWatch fatFsWatch, String str, OnUpdateResourceCallback onUpdateResourceCallback, ThreadStateListener threadStateListener) {
        if (fatFsWatch == null) {
            throw new NullPointerException("FatFsWatch can not be null.");
        }
        this.d = fatFsWatch;
        this.e = fatFsWatch.getWatchSystem();
        this.f = str;
        this.i = onUpdateResourceCallback;
        this.j = threadStateListener;
    }

    public final long d() {
        FatFileSystem fatFileSystem = this.e;
        if (fatFileSystem == null) {
            return 0L;
        }
        return ((long) fatFileSystem.getFreeSize()) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
    }

    public final void e() {
        synchronized (this.a) {
            try {
                if (!this.b) {
                    this.b = true;
                    this.a.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.b = false;
        }
    }

    public final void f() {
        String strObtainUpdateFilePath = WatchFileUtil.obtainUpdateFilePath(this.g, ".ufw");
        if (strObtainUpdateFilePath == null) {
            if (this.d.isOTAResource()) {
                this.d.writeResourceOTAFlag(true, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceThread.5
                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onFailed(BaseError baseError) {
                        UpdateResourceThread.this.a(baseError.getSubCode(), baseError.getMessage(), false);
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onSuccess(Boolean bool) {
                        UpdateResourceThread.this.f();
                    }
                });
                return;
            } else {
                if (this.l) {
                    this.d.jumpToUpdateResource(true, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceThread.6
                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onFailed(BaseError baseError) {
                            UpdateResourceThread.this.a(baseError.getSubCode(), baseError.getMessage(), false);
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onSuccess(Boolean bool) {
                            UpdateResourceThread.this.f();
                        }
                    });
                    return;
                }
                WatchFileUtil.deleteFile(this.f);
            }
        }
        WatchFileUtil.deleteFile(this.g + WatchConstant.FAT_FS_ROOT + WatchConstant.RES_DIR_NAME);
        b(strObtainUpdateFilePath);
    }

    public final void g() {
        synchronized (this.a) {
            try {
                if (this.b) {
                    this.a.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() throws Throwable {
        File file = new File(this.h);
        ArrayList<UpdateTask> arrayList = new ArrayList<>();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    UpdateTask updateTaskA = a(file2);
                    if (updateTaskA != null) {
                        arrayList.add(updateTaskA);
                    }
                } catch (RuntimeException e) {
                    a(a(e), true);
                    return;
                }
            }
        }
        ArrayList<UpdateTask> arrayListA = a(arrayList);
        if (!a((List<UpdateTask>) arrayListA)) {
            a(16897, true);
            return;
        }
        synchronized (this.a) {
            try {
                String str = n;
                JL_Log.i(str, "updateResource", "isOTAResource = " + this.d.isOTAResource());
                if (!this.d.isOTAResource()) {
                    this.d.writeResourceOTAFlag(false, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceThread.1
                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onFailed(BaseError baseError) {
                            UpdateResourceThread.this.m = baseError;
                            UpdateResourceThread.this.g();
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                        public void onSuccess(Boolean bool) {
                            UpdateResourceThread.this.g();
                        }
                    });
                    e();
                    if (!this.d.isOTAResource()) {
                        a(b(), c(), false);
                        return;
                    }
                }
                this.d.jumpToUpdateResource(false, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceThread.2
                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onFailed(BaseError baseError) {
                        UpdateResourceThread.this.l = false;
                        UpdateResourceThread.this.m = baseError;
                        UpdateResourceThread.this.g();
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                    public void onSuccess(Boolean bool) {
                        UpdateResourceThread.this.l = bool.booleanValue();
                        UpdateResourceThread.this.g();
                    }
                });
                e();
                if (!this.l) {
                    a(b(), c(), false);
                    return;
                }
                JL_Log.i(str, "updateResource", "task size : " + arrayListA.size());
                if (arrayListA.isEmpty()) {
                    f();
                    return;
                }
                b(this.h, arrayListA.size());
                for (final int i = 0; i < arrayListA.size(); i++) {
                    final UpdateTask updateTask = arrayListA.get(i);
                    if (this.c != 0) {
                        break;
                    }
                    int i2 = updateTask.op;
                    if (i2 != 1) {
                        if (i2 != 2) {
                            continue;
                        } else {
                            FatFileSystem fatFileSystem = this.e;
                            if (fatFileSystem == null) {
                                this.c = 22;
                                JL_Log.i(n, "updateResource", "replaceFatFile ---> updateResult : 2");
                                break;
                            }
                            fatFileSystem.replaceFatFile(updateTask.filePath, new OnFatFileProgressListener() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceThread.4
                                @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                                public void onProgress(float f) {
                                    JL_Log.i(UpdateResourceThread.n, "updateResource", "replaceFatFile ---> onProgress : " + f);
                                    UpdateResourceThread.this.b(i, updateTask.filePath, f);
                                }

                                @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                                public void onStart(String str2) {
                                    JL_Log.i(UpdateResourceThread.n, "updateResource", "replaceFatFile ---> onStart : " + str2);
                                    UpdateResourceThread.this.b(i, updateTask.filePath, 0.0f);
                                }

                                @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                                public void onStop(int i3) {
                                    JL_Log.e(UpdateResourceThread.n, "updateResource", "replaceFatFile ---> onStop : " + i3);
                                    UpdateResourceThread.this.c = i3;
                                    if (UpdateResourceThread.this.c == 0) {
                                        UpdateResourceThread.this.b(i, updateTask.filePath, 100.0f);
                                    }
                                    UpdateResourceThread.this.g();
                                }
                            });
                            if (this.c != 0) {
                                break;
                            }
                            String str2 = n;
                            JL_Log.e(str2, "updateResource", "replaceFatFile ---> lock >> ");
                            e();
                            JL_Log.e(str2, "updateResource", "replaceFatFile ---> unlock >> ");
                        }
                    } else {
                        if (this.e == null) {
                            this.c = 22;
                            JL_Log.i(n, "updateResource", "createFatFile ---> updateResult : 2");
                            break;
                        }
                        String str3 = n;
                        JL_Log.i(str3, "updateResource", "createFatFile ---> filePath : " + updateTask.filePath);
                        this.e.createFatFile(updateTask.filePath, true, new OnFatFileProgressListener() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceThread.3
                            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                            public void onProgress(float f) {
                                JL_Log.i(UpdateResourceThread.n, "updateResource", "createFatFile ---> onProgress : " + f);
                                UpdateResourceThread.this.b(i, updateTask.filePath, f);
                            }

                            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                            public void onStart(String str4) {
                                JL_Log.i(UpdateResourceThread.n, "updateResource", "createFatFile ---> onStart : " + str4);
                                UpdateResourceThread.this.b(i, str4, 0.0f);
                            }

                            @Override // com.jieli.jl_fatfs.interfaces.OnFatFileProgressListener
                            public void onStop(int i3) {
                                JL_Log.e(UpdateResourceThread.n, "updateResource", "createFatFile ---> onStop : " + i3);
                                UpdateResourceThread.this.c = i3;
                                if (i3 == 0) {
                                    UpdateResourceThread.this.b(i, updateTask.filePath, 100.0f);
                                }
                                UpdateResourceThread.this.g();
                            }
                        });
                        if (this.c != 0) {
                            break;
                        }
                        JL_Log.w(str3, "updateResource", "createFatFile ---> lock... >> ");
                        e();
                        JL_Log.w(str3, "updateResource", "createFatFile ---> unlock... >> ");
                    }
                }
                JL_Log.e(n, "updateResource", "end >> " + this.c);
                int i3 = this.c;
                if (i3 == 0) {
                    f();
                } else {
                    a(i3, true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws Throwable {
        ThreadStateListener threadStateListener = this.j;
        if (threadStateListener != null) {
            threadStateListener.onStart(getId());
        }
        if (this.f == null) {
            a(5);
            return;
        }
        File file = new File(this.f);
        if (!file.exists()) {
            a(5);
            return;
        }
        this.g = WatchFileUtil.getDirPath(this.f);
        String fileName = WatchFileUtil.getFileName(this.f);
        String str = n;
        JL_Log.i(str, str, "dirPath = " + this.g + ", fileName = " + fileName);
        if (fileName.endsWith(".zip")) {
            try {
                ZipUtil.unZipFolder(this.f, this.g);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.h = UpdateResourceTask.findFolder(this.g, WatchConstant.RES_DIR_NAME);
        } else if (file.isDirectory() && WatchConstant.RES_DIR_NAME.equalsIgnoreCase(fileName)) {
            this.h = this.f;
        }
        String str2 = n;
        JL_Log.i(str2, str2, "targetPath = " + this.h);
        if (this.h != null) {
            h();
            return;
        }
        String strObtainUpdateFilePath = WatchFileUtil.obtainUpdateFilePath(this.g, ".ufw");
        JL_Log.i(str2, str2, "otaFilePath = " + strObtainUpdateFilePath);
        if (strObtainUpdateFilePath == null) {
            a(4);
        } else {
            b(strObtainUpdateFilePath);
        }
    }

    public void stopThread() {
        this.c = 28;
        g();
    }

    public final void b(final String str, final int i) {
        if (this.i != null) {
            this.k.post(new Runnable() { // from class: c93
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(str, i);
                }
            });
        }
    }

    public final String c() {
        BaseError baseError = this.m;
        return baseError == null ? Constants.STR_EMPTY : baseError.getMessage();
    }

    public final void b(final String str) {
        if (this.i != null) {
            this.k.post(new Runnable() { // from class: e93
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(str);
                }
            });
        }
        ThreadStateListener threadStateListener = this.j;
        if (threadStateListener != null) {
            threadStateListener.onFinish(getId());
        }
    }

    public final void b(final int i, final String str) {
        JL_Log.w(n, "notifyError", RcspUtil.formatString("code : %d(0x%X), %s.", Integer.valueOf(i), Integer.valueOf(i), str));
        WatchFileUtil.deleteFile(WatchFileUtil.obtainUpdateFilePath(this.g, ".ufw"));
        WatchFileUtil.deleteFile(this.g + File.separator + WatchConstant.RES_DIR_NAME);
        if (this.i != null) {
            this.k.post(new Runnable() { // from class: d93
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(i, str);
                }
            });
        }
        ThreadStateListener threadStateListener = this.j;
        if (threadStateListener != null) {
            threadStateListener.onFinish(getId());
        }
    }

    public final /* synthetic */ void a(String str, int i) {
        this.i.onStart(str, i);
    }

    public final /* synthetic */ void a(String str) {
        this.i.onStop(str);
    }

    public final /* synthetic */ void a(int i, String str) {
        this.i.onError(i, str);
    }

    public final /* synthetic */ void a(int i, String str, float f) {
        this.i.onProgress(i, str, f);
    }

    public final void a(int i) {
        a(i, false);
    }

    public final void a(int i, boolean z) {
        a(i, FatUtil.getFatFsErrorCodeMsg(i), z);
    }

    public final void a(final int i, final String str, boolean z) {
        if (z && this.l) {
            this.d.jumpToUpdateResource(true, new OnWatchOpCallback<Boolean>() { // from class: com.jieli.jl_rcsp.tool.UpdateResourceThread.7
                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onFailed(BaseError baseError) {
                    UpdateResourceThread.this.b(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.watch.OnWatchOpCallback
                public void onSuccess(Boolean bool) {
                    onFailed(new BaseError(i, str));
                }
            });
        } else {
            b(i, str);
        }
    }

    public final void b(final int i, final String str, final float f) {
        if (this.i != null) {
            this.k.post(new Runnable() { // from class: f93
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(i, str, f);
                }
            });
        }
    }

    public final int b() {
        BaseError baseError = this.m;
        if (baseError == null) {
            return 12288;
        }
        return baseError.getSubCode();
    }

    public final UpdateTask a(File file) throws Throwable {
        UpdateTask updateTask;
        byte[] fileData = WatchFileUtil.readFileData(file.getPath());
        if (fileData == null || fileData.length < 512) {
            return null;
        }
        String fatFilePath = FatUtil.getFatFilePath(this.e.getCurBrowsePath(), file.getPath());
        FatFile fatFileMsg = this.e.getFatFileMsg(fatFilePath);
        if (fatFileMsg != null) {
            byte[] fileHead = this.e.getFileHead(fatFilePath);
            if (fileHead != null) {
                byte[] bArr = new byte[512];
                System.arraycopy(fileData, 0, bArr, 0, 512);
                if (Arrays.equals(bArr, fileHead) && file.length() == fatFileMsg.getSize()) {
                    JL_Log.w(n, "convertUpdateTask", "head same, file size : " + file.length() + ", fat File size = " + fatFileMsg.getSize());
                    return null;
                }
                updateTask = new UpdateTask();
                updateTask.filePath = file.getPath();
                updateTask.fileSize = fileData.length;
                updateTask.op = 2;
            } else {
                throw new RuntimeException(String.valueOf(24));
            }
        } else {
            updateTask = new UpdateTask();
            updateTask.filePath = file.getPath();
            updateTask.fileSize = fileData.length;
            updateTask.op = 1;
        }
        return updateTask;
    }

    public final ArrayList<UpdateTask> a(ArrayList<UpdateTask> arrayList) {
        if (arrayList == null || arrayList.size() <= 1) {
            return arrayList;
        }
        ArrayList<UpdateTask> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        for (UpdateTask updateTask : arrayList) {
            if (updateTask.op == 2) {
                arrayList2.add(updateTask);
            } else {
                arrayList3.add(updateTask);
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    public final boolean a(List<UpdateTask> list) {
        if (this.e == null) {
            return false;
        }
        if (list == null || list.isEmpty()) {
            return true;
        }
        long jD = d();
        JL_Log.d(n, "hasEnoughSpace", "leftSize = " + jD);
        for (UpdateTask updateTask : list) {
            JL_Log.d(n, "hasEnoughSpace", "task = " + updateTask.filePath + ", size = " + updateTask.fileSize + ", op = " + updateTask.op);
            int i = updateTask.op;
            if (i == 1) {
                jD -= updateTask.fileSize;
            } else if (i == 2) {
                FatFileSystem fatFileSystem = this.e;
                jD -= updateTask.fileSize - fatFileSystem.getFatFileMsg(FatUtil.getFatFilePath(fatFileSystem.getCurBrowsePath(), updateTask.filePath)).getSize();
            }
            if (jD < 0) {
                break;
            }
        }
        boolean z = jD >= 0;
        JL_Log.e(n, "hasEnoughSpace", z + ", leftSize = " + jD);
        return z;
    }

    public final int a(RuntimeException runtimeException) {
        if (runtimeException == null) {
            return 12288;
        }
        try {
            if (TextUtils.isEmpty(runtimeException.getMessage()) || !TextUtils.isDigitsOnly(runtimeException.getMessage())) {
                return 12288;
            }
            return Integer.parseInt(runtimeException.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return 12288;
        }
    }
}
