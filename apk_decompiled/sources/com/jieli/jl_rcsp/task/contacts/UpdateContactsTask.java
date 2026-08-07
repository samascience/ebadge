package com.jieli.jl_rcsp.task.contacts;

import android.content.Context;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_filebrowse.util.DeviceChoseUtil;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.task.CallTransferTask;
import com.jieli.jl_rcsp.task.ITask;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.util.JL_Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UpdateContactsTask extends TaskBase {
    public final String b;
    public final List<DeviceContacts> c;
    public ITask d;

    public UpdateContactsTask(RcspOpImpl rcspOpImpl, String str, List<DeviceContacts> list) throws RuntimeException {
        super(rcspOpImpl);
        if (list == null) {
            throw new RuntimeException("contacts can not be null.");
        }
        this.b = str;
        this.c = list;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        if (isRun()) {
            ITask iTask = this.d;
            if (iTask == null) {
                callbackCancel(b);
            } else {
                iTask.cancel(b);
            }
        }
    }

    @Override // com.jieli.jl_rcsp.task.TaskBase, com.jieli.jl_rcsp.task.ITask
    public boolean isRun() {
        ITask iTask = this.d;
        return iTask == null ? super.isRun() : iTask.isRun();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() throws Throwable {
        ITask iTask;
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
            return;
        }
        DeviceInfo deviceInfo = this.mRcspOp.getDeviceInfo();
        if (deviceInfo == null) {
            callbackError(8192);
            return;
        }
        if (deviceInfo.isContactsTransferBySmallFile()) {
            this.d = new UpdateContactsBySmallFileTask(this.mRcspOp, this.c);
        } else {
            SDCardBean targetDevFlash2First = DeviceChoseUtil.getTargetDevFlash2First();
            if (targetDevFlash2First == null) {
                callbackError(16384);
                return;
            }
            TransferTask.Param param = new TransferTask.Param();
            param.devHandler = targetDevFlash2First.getDevHandler();
            param.useFlash = targetDevFlash2First.getType() == 2;
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(this.b);
                        try {
                            byte[] data = DeviceContacts.toData(this.c);
                            if (data.length == 0) {
                                data = new byte[20];
                            }
                            fileOutputStream2.write(data);
                            this.d = new CallTransferTask(this.mRcspOp, this.b, param);
                            fileOutputStream2.close();
                        } catch (IOException e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            e.printStackTrace();
                            callbackError(16389, "IO Exception = " + e.getMessage());
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            iTask = this.d;
                            if (iTask != null) {
                                iTask.setListener(this.listener);
                                this.d.start();
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        iTask = this.d;
        if (iTask != null) {
            iTask.setListener(this.listener);
            this.d.start();
        }
    }

    @Deprecated
    public UpdateContactsTask(RcspOpImpl rcspOpImpl, Context context, List<DeviceContacts> list) throws RuntimeException {
        super(rcspOpImpl);
        if (list != null) {
            if (context == null) {
                this.b = null;
            } else {
                this.b = context.getExternalCacheDir() + File.separator + "CALL.TXT";
            }
            this.c = list;
            return;
        }
        throw new RuntimeException("contacts can not be null.");
    }
}
