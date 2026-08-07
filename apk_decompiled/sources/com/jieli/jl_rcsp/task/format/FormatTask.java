package com.jieli.jl_rcsp.task.format;

import android.content.Context;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.task.CallTransferTask;
import com.jieli.jl_rcsp.task.GetFileByNameTask;
import com.jieli.jl_rcsp.task.ITask;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.task.TaskListener;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.util.JL_Log;
import java.io.File;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class FormatTask extends TaskBase {
    public final Context b;
    public final SDCardBean c;
    public final Queue<ITask> d;

    public class AddTaskListener extends NextListener {
        public final ITask c;

        public AddTaskListener(ITask iTask, String str) {
            super(str);
            this.c = iTask;
        }

        @Override // com.jieli.jl_rcsp.task.format.FormatTask.NextListener, com.jieli.jl_rcsp.task.TaskListener
        public void onFinish() {
            FormatTask.this.d.add(this.c);
            super.onFinish();
        }
    }

    public class ErrorStopListener extends NextListener {
        public ErrorStopListener(String str) {
            super(str);
        }

        @Override // com.jieli.jl_rcsp.task.format.FormatTask.NextListener, com.jieli.jl_rcsp.task.TaskListener
        public void onError(int i, String str) {
            JL_Log.w(((TaskBase) FormatTask.this).tag, "onError", "Formatting process stopped：task is --》" + this.a);
            FormatTask.this.callbackError(i, str);
        }
    }

    public class NextListener implements TaskListener {
        public String a;

        public NextListener(String str) {
            this.a = str;
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onBegin() {
            JL_Log.i(((TaskBase) FormatTask.this).tag, "onBegin", " Task begin :" + this.a);
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onCancel(int i) {
            onError(i, "cancel");
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onError(int i, String str) {
            JL_Log.w(((TaskBase) FormatTask.this).tag, "onError", "The formatting task is error, do next task: error task --》" + this.a);
            FormatTask.this.a();
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onFinish() {
            FormatTask.this.a();
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onProgress(int i) {
        }
    }

    public FormatTask(RcspOpImpl rcspOpImpl, Context context, SDCardBean sDCardBean) throws RuntimeException {
        super(rcspOpImpl);
        this.d = new ArrayBlockingQueue(6);
        if (context == null) {
            throw new RuntimeException("Context can not be null.");
        }
        if (sDCardBean == null) {
            throw new RuntimeException("Device storage can not be null.");
        }
        this.b = context;
        this.c = sDCardBean;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        throw new RuntimeException("can not cancel");
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        callbackBegin();
        int devHandler = this.c.getDevHandler();
        FormatBatchCmdTask formatBatchCmdTask = new FormatBatchCmdTask(this.mRcspOp, (byte) 0);
        FormatBatchCmdTask formatBatchCmdTask2 = new FormatBatchCmdTask(this.mRcspOp, (byte) -128);
        FormatCmdTask formatCmdTask = new FormatCmdTask(this.mRcspOp, (byte) -128, devHandler);
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.getCacheDir());
        String str = File.separator;
        sb.append(str);
        sb.append("WMEM.BIN");
        String string = sb.toString();
        GetFileByNameTask getFileByNameTask = new GetFileByNameTask(this.mRcspOp, new GetFileByNameTask.Param(devHandler, "WMEM.BIN", string, false));
        String str2 = this.b.getCacheDir() + str + "call.txt";
        GetFileByNameTask getFileByNameTask2 = new GetFileByNameTask(this.mRcspOp, new GetFileByNameTask.Param(devHandler, "call.txt", str2, false));
        TransferTask.Param param = new TransferTask.Param();
        param.devHandler = devHandler;
        param.useFlash = this.c.getType() == 2;
        TransferTask transferTask = new TransferTask(this.mRcspOp, string, param);
        transferTask.setListener(new NextListener("wmenSave task"));
        CallTransferTask callTransferTask = new CallTransferTask(this.mRcspOp, str2, param);
        callTransferTask.setListener(new NextListener("callSave task"));
        this.d.add(formatBatchCmdTask);
        this.d.add(getFileByNameTask);
        this.d.add(getFileByNameTask2);
        this.d.add(formatCmdTask);
        formatBatchCmdTask.setListener(new ErrorStopListener("start format batch cmd task"));
        getFileByNameTask.setListener(new AddTaskListener(transferTask, "wmen read task"));
        getFileByNameTask2.setListener(new AddTaskListener(callTransferTask, "call read  task"));
        formatCmdTask.setListener(new AddTaskListener(formatBatchCmdTask2, "  format cmd task"));
        formatBatchCmdTask2.setListener(new ErrorStopListener("stop format batch cmd task"));
        a();
    }

    public final void a() {
        ITask iTaskPeek = this.d.peek();
        if (iTaskPeek != null) {
            iTaskPeek.start();
            this.d.poll();
        } else {
            callbackFinish();
        }
    }
}
