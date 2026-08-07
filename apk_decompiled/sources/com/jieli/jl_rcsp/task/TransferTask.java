package com.jieli.jl_rcsp.task;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_filebrowse.FileBrowseManager;
import com.jieli.jl_filebrowse.bean.Folder;
import com.jieli.jl_filebrowse.bean.SDCardBean;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.constant.WatchError;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.NotifyPrepareEnvCmd;
import com.jieli.jl_rcsp.model.command.data.DataCmd;
import com.jieli.jl_rcsp.model.command.file_op.CancelLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.DeviceExtendParamCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferGetNameCmd;
import com.jieli.jl_rcsp.model.command.file_op.LargeFileTransferOpCmd;
import com.jieli.jl_rcsp.model.command.file_op.StartLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.command.file_op.StopLargeFileTransferCmd;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.parameter.DataParam;
import com.jieli.jl_rcsp.model.parameter.LargeFileTransferOpParam;
import com.jieli.jl_rcsp.model.parameter.StartLargeFileTransferParam;
import com.jieli.jl_rcsp.model.response.StartLargeFileTransferResponse;
import com.jieli.jl_rcsp.tool.BooleanRcspActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class TransferTask extends TaskBase {
    public String b;
    public final CacheVar c;
    public final Param d;
    public final Handler e;
    protected ExecutorService executor;
    public final OnRcspCallback f;
    public int maxRenameCount;

    public static class CacheVar {
        public static final int l = 50;
        public RandomAccessFile a;
        public short b;
        public int c;
        public long d;
        public int e;
        public int f;
        public final LinkedBlockingQueue<SendData> g;
        public boolean h;
        public long i;
        public long j;
        public long k;

        public CacheVar() {
            this.f = 0;
            this.g = new LinkedBlockingQueue<>();
            this.j = -1L;
            this.k = 50L;
        }

        public void a() {
            RandomAccessFile randomAccessFile = this.a;
            if (randomAccessFile != null) {
                try {
                    try {
                        randomAccessFile.close();
                        this.a = null;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } catch (Throwable th) {
                    this.a = null;
                    throw th;
                }
            }
        }

        public void b() {
            this.c = 0;
            this.d = 0L;
            this.e = 0;
            this.f = 0;
            this.h = false;
            this.i = 0L;
            this.j = -1L;
            this.k = 50L;
            this.g.clear();
            a();
        }
    }

    public static class Param {
        public int devHandler;
        public String outputDirPath;
        public boolean appHasCrc16 = true;
        public boolean useFlash = false;
        public boolean isOtherEncode = false;
        public String encodeType = StandardCharsets.UTF_16LE.name();
        public boolean a = false;

        public String toString() {
            return "Param{devHandler=" + this.devHandler + ", appHasCrc16=" + this.appHasCrc16 + ", useFlash=" + this.useFlash + ", firmwareHasCrc16=" + this.a + ", isOtherEncode=" + this.isOtherEncode + ", encodeType=" + this.encodeType + ", outputDirPath=" + this.outputDirPath + '}';
        }
    }

    public static class SendData {
        public int a;
        public byte[] b;

        public SendData(int i, byte[] bArr) {
            this.a = i;
            this.b = bArr;
        }
    }

    public TransferTask(RcspOpImpl rcspOpImpl, String str, Param param) throws RuntimeException {
        super(rcspOpImpl);
        this.maxRenameCount = 9;
        this.executor = Executors.newSingleThreadExecutor();
        this.e = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: u43
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.a(message);
            }
        });
        this.f = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.task.TransferTask.8
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onConnectStateChange(BluetoothDevice bluetoothDevice, int i) {
                if (TransferTask.this.isRun() && i != 1) {
                    TransferTask.this.onError(8192, null);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                if (!TransferTask.this.isRun() || commandBase == null) {
                    return;
                }
                switch (commandBase.getId()) {
                    case 28:
                        StopLargeFileTransferCmd stopLargeFileTransferCmd = (StopLargeFileTransferCmd) commandBase;
                        StopLargeFileTransferCmd.Param param2 = (StopLargeFileTransferCmd.Param) stopLargeFileTransferCmd.getParam();
                        if (param2 != null) {
                            int reason = param2.getReason();
                            stopLargeFileTransferCmd.setParam(null);
                            stopLargeFileTransferCmd.setStatus(0);
                            TransferTask.this.mRcspOp.sendCommandResponse(bluetoothDevice, stopLargeFileTransferCmd, null);
                            TransferTask.this.a(reason);
                            break;
                        }
                        break;
                    case 29:
                        LargeFileTransferOpCmd largeFileTransferOpCmd = (LargeFileTransferOpCmd) commandBase;
                        if (TransferTask.this.c.c != 0) {
                            TransferTask.this.a(largeFileTransferOpCmd);
                        } else {
                            JL_Log.e(TransferTask.this.tag, "onRcspCommand", "mtu is 0");
                        }
                        break;
                    case 30:
                        CancelLargeFileTransferCmd cancelLargeFileTransferCmd = (CancelLargeFileTransferCmd) commandBase;
                        cancelLargeFileTransferCmd.setParam(null);
                        cancelLargeFileTransferCmd.setStatus(0);
                        TransferTask.this.mRcspOp.sendCommandResponse(bluetoothDevice, cancelLargeFileTransferCmd, null);
                        TransferTask.this.f();
                        break;
                    case 32:
                        TransferTask.this.a((LargeFileTransferGetNameCmd) commandBase);
                        break;
                }
            }
        };
        if (param == null) {
            throw new RuntimeException("TransferTask.Param can not be null.");
        }
        this.d = param;
        JL_Log.d(this.tag, "init", param + ", class = " + this);
        this.c = new CacheVar();
        setPath(str);
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        if (isRun()) {
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), new CancelLargeFileTransferCmd(), new BooleanRcspActionCallback("cancel", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.1
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    TransferTask.this.f();
                }
            }));
        }
    }

    public String getPath() {
        return this.b;
    }

    public final void i() {
        if (isRun()) {
            Param param = this.d;
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), new DeviceExtendParamCmd(new DeviceExtendParamCmd.FileTransferParam(param.devHandler, param.appHasCrc16)), new CustomRcspActionCallback("readExternParam", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.4
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    TransferTask.this.d.a = bool.booleanValue();
                    TransferTask.this.k();
                }
            }, new IHandleResult<Boolean, DeviceExtendParamCmd>() { // from class: com.jieli.jl_rcsp.task.TransferTask.5
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public int hasResult(BluetoothDevice bluetoothDevice, DeviceExtendParamCmd deviceExtendParamCmd) {
                    return 0;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
                public Boolean handleResult(BluetoothDevice bluetoothDevice, DeviceExtendParamCmd deviceExtendParamCmd) {
                    return (deviceExtendParamCmd == null || !(deviceExtendParamCmd.getResponse() instanceof DeviceExtendParamCmd.FileTransferResponse)) ? Boolean.FALSE : Boolean.valueOf(((DeviceExtendParamCmd.FileTransferResponse) deviceExtendParamCmd.getResponse()).hasCrc16);
                }
            }));
        }
    }

    public final void j() {
        if (isRun()) {
            JL_Log.d(this.tag, "startFileTransferFlow", Constants.STR_EMPTY + this.d);
            if (!this.d.useFlash) {
                h();
                return;
            }
            File file = new File(this.b);
            a(WatchConstant.FAT_FS_ROOT + file.getName(), (int) file.length());
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0093  */
    public final void k() {
        int iIndexOf;
        if (isRun()) {
            JL_Log.d(this.tag, "startTransferActual", "path = " + this.b);
            File file = new File(this.b);
            if (!file.exists() || file.isDirectory() || file.length() == 0) {
                onError(4097, RcspUtil.formatString("Path is invalid. path = " + this.b, new Object[0]));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(RcspUtil.formatString("%08x", Integer.valueOf((file.getName() + file.lastModified()).hashCode())));
            sb.append(".tmp\u0000");
            String string = sb.toString();
            String str = this.d.outputDirPath;
            if (str == null) {
                iIndexOf = -1;
            } else {
                String str2 = File.separator;
                if (str.startsWith(str2)) {
                    iIndexOf = this.d.outputDirPath.indexOf(str2);
                } else {
                    iIndexOf = -1;
                }
            }
            String strSubstring = iIndexOf == -1 ? this.d.outputDirPath : this.d.outputDirPath.substring(iIndexOf);
            if (strSubstring != null && !strSubstring.isEmpty()) {
                String str3 = File.separator;
                if (strSubstring.endsWith(str3)) {
                    string = strSubstring + string;
                } else {
                    string = strSubstring + str3 + string;
                }
            }
            JL_Log.d(this.tag, "startTransferActual", "tempPath --->" + string);
            byte[] bytes = string.getBytes();
            CacheVar cacheVar = this.c;
            a(bytes, cacheVar.f, cacheVar.b);
        }
    }

    public void onError(int i) {
        onError(i, null);
    }

    public void release() {
        this.mDeviceStatusManager.updateFileTransfer(getConnectedDevice(), false);
        this.c.b();
        this.mRcspOp.unregisterOnRcspCallback(this.f);
        this.e.removeCallbacksAndMessages(null);
        if (this.executor.isShutdown()) {
            return;
        }
        this.executor.shutdownNow();
    }

    public void setPath(String str) {
        this.b = str;
        int iLastIndexOf = str.lastIndexOf(File.separator);
        if (iLastIndexOf != -1) {
            if (str.length() - (iLastIndexOf + 1) > 9) {
                this.maxRenameCount = 32;
            } else {
                this.maxRenameCount = 9;
            }
        }
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
            return;
        }
        if (isFileTransfer()) {
            JL_Log.w(this.tag, "start", "SDK in file transfer.");
            onError(4352);
        } else if (isDeviceInCalling()) {
            JL_Log.w(this.tag, "start", "Device in calling.");
            onError(12545);
        } else {
            if (this.executor.isShutdown()) {
                this.executor = Executors.newSingleThreadExecutor();
            }
            g();
            a();
        }
    }

    private void g() {
        this.c.b();
        this.mRcspOp.registerOnRcspCallback(this.f);
        this.mDeviceStatusManager.updateFileTransfer(getConnectedDevice(), true);
        callbackBegin();
    }

    public final long b() {
        return System.currentTimeMillis();
    }

    public final SDCardBean c() {
        List<SDCardBean> onlineDev = FileBrowseManager.getInstance().getOnlineDev();
        if (onlineDev != null && !onlineDev.isEmpty()) {
            for (SDCardBean sDCardBean : onlineDev) {
                if (sDCardBean.getDevHandler() == this.d.devHandler) {
                    return sDCardBean;
                }
            }
        }
        return null;
    }

    public final /* synthetic */ void d() throws Throwable {
        FileInputStream fileInputStream;
        File file = new File(this.b);
        if (file.exists() && !file.isDirectory()) {
            long j = 0;
            if (file.length() != 0) {
                long jB = b();
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        try {
                            this.c.a = new RandomAccessFile(file, "r");
                            this.c.f = (int) file.length();
                            fileInputStream = new FileInputStream(file);
                            try {
                                long jAvailable = fileInputStream.available();
                                byte[] bArr = new byte[2048];
                                short sCRC16 = 0;
                                while (true) {
                                    int i = fileInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    byte[] bArr2 = new byte[i];
                                    System.arraycopy(bArr, 0, bArr2, 0, i);
                                    sCRC16 = CryptoUtil.CRC16(bArr2, sCRC16);
                                    j += (long) i;
                                }
                                long jA = a(jB);
                                this.c.b = sCRC16;
                                JL_Log.d(this.tag, "countFileCrc", RcspUtil.formatString("Take data time = %d, file len = %d, file size = %d, data size = %d, crc = %d(0x%X)", Long.valueOf(jA), Integer.valueOf(this.c.f), Long.valueOf(jAvailable), Long.valueOf(j), Short.valueOf(sCRC16), Short.valueOf(sCRC16)));
                                CacheVar cacheVar = this.c;
                                if (cacheVar.f != j) {
                                    cacheVar.f = (int) j;
                                }
                                j();
                                fileInputStream.close();
                            } catch (Exception e) {
                                e = e;
                                fileInputStream2 = fileInputStream;
                                e.printStackTrace();
                                this.e.post(new Runnable() { // from class: r43
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.a.a(e);
                                    }
                                });
                                if (fileInputStream2 == null) {
                                    return;
                                } else {
                                    fileInputStream2.close();
                                }
                            } catch (Throwable th) {
                                th = th;
                                Throwable th2 = th;
                                if (fileInputStream == null) {
                                    throw th2;
                                }
                                try {
                                    fileInputStream.close();
                                    throw th2;
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                    throw th2;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        fileInputStream = fileInputStream2;
                    }
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
        }
        onError(4097, RcspUtil.formatString("Path is invalid. path = " + this.b, new Object[0]));
    }

    public final void e() {
        if (!this.c.g.isEmpty()) {
            SendData sendDataPoll = this.c.g.poll();
            if (sendDataPoll == null) {
                return;
            }
            a(sendDataPoll.a, sendDataPoll.b, new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.7
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    TransferTask.this.e();
                }
            });
            return;
        }
        this.c.h = false;
        if (isRun()) {
            this.e.removeMessages(4386);
            this.e.sendEmptyMessageDelayed(4386, TaskBase.TIMEOUT);
        }
    }

    public final void f() {
        release();
        callbackCancel(0);
    }

    public final void h() {
        if (isRun()) {
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), new NotifyPrepareEnvCmd(new NotifyPrepareEnvCmd.NotifyPrepareTransferLargeFileParam()), new BooleanRcspActionCallback("prepareBigFileTransferEnv", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.3
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    DeviceInfo deviceInfo = TransferTask.this.mRcspOp.getDeviceInfo();
                    if (deviceInfo == null || deviceInfo.isSupportPackageCrc16()) {
                        TransferTask.this.i();
                    } else {
                        TransferTask.this.k();
                    }
                }
            }));
        }
    }

    public void onError(int i, String str) {
        release();
        if (str == null) {
            callbackError(i);
        } else {
            callbackError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(Message message) {
        if (message.what != 4386) {
            return true;
        }
        onError(12290);
        return true;
    }

    public final long a(long j) {
        return b() - j;
    }

    public final void a(LargeFileTransferGetNameCmd largeFileTransferGetNameCmd) {
        if (isRun()) {
            this.e.removeMessages(4386);
            this.e.sendEmptyMessageDelayed(4386, TaskBase.TIMEOUT);
            String name = new File(this.b).getName();
            JL_Log.d(this.tag, "onGetName", "File name = " + name + ", retryName = " + this.c.e);
            largeFileTransferGetNameCmd.setParam(new LargeFileTransferGetNameCmd.Param(name, this.c.e).setOtherEncode(this.d.isOtherEncode).setEncodeType(this.d.encodeType));
            largeFileTransferGetNameCmd.setStatus(this.c.e >= this.maxRenameCount ? 1 : 0);
            largeFileTransferGetNameCmd.setOpCodeSn(largeFileTransferGetNameCmd.getOpCodeSn());
            this.mRcspOp.sendCommandResponse(getConnectedDevice(), largeFileTransferGetNameCmd, null);
            if (this.d.useFlash) {
                return;
            }
            CacheVar cacheVar = this.c;
            int i = cacheVar.e;
            if (i >= this.maxRenameCount) {
                onError(16898);
            } else {
                cacheVar.e = i + 1;
            }
        }
    }

    public final void a(int i) {
        Folder currentReadFile;
        int i2;
        long jA = a(this.c.d);
        JL_Log.i(this.tag, "onStop", "Transfer file take time -->" + jA + ", reason = " + i);
        if (i != 0) {
            if (i == 1) {
                i2 = WatchError.ERR_FAT_WRITE;
            } else if (i == 2) {
                i2 = WatchError.ERR_DATA_OVER_LIMIT;
            } else if (i != 3) {
                i2 = i != 4 ? 12293 : 16897;
            } else {
                i2 = 12544;
            }
            onError(i2, WatchError.getErrorDesc(i2));
            return;
        }
        JL_Log.i(this.tag, "onStop", "Transfer of large file is complete.");
        SDCardBean sDCardBeanC = c();
        if (sDCardBeanC != null && (currentReadFile = FileBrowseManager.getInstance().getCurrentReadFile(sDCardBeanC)) != null) {
            currentReadFile.setLoadFinished(false);
        }
        release();
        callbackProgress(100);
        callbackFinish();
    }

    public final void a() {
        try {
            this.executor.execute(new Runnable() { // from class: v43
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.a.d();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            onError(16389, "Exception : " + e.getMessage());
        }
    }

    public final /* synthetic */ void a(Exception exc) {
        onError(16389, "IO Exception : " + exc.getMessage());
    }

    public final void a(String str, int i) {
        if (isRun()) {
            this.mRcspOp.sendRcspCommand(getConnectedDevice(), CommandBuilder.buildExternalFlashInsertNewFileStartCmd(str, i), new BooleanRcspActionCallback("startCreateFlashFile", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.task.TransferTask.2
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    TransferTask.this.h();
                }
            }));
        }
    }

    public final void a(byte[] bArr, int i, short s) {
        JL_Log.d(this.tag, "startBigFileTransfer", RcspUtil.formatString("size = %d, crc16 = %d(0x%X)", Integer.valueOf(i), Short.valueOf(s), Short.valueOf(s)));
        long jB = b();
        CacheVar cacheVar = this.c;
        cacheVar.d = jB;
        cacheVar.i = jB;
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new StartLargeFileTransferCmd(new StartLargeFileTransferParam(bArr, i, s)), new RcspCommandCallback<StartLargeFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.TransferTask.6
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
                JL_Log.e(TransferTask.this.tag, "startBigFileTransfer", "onErrCode ---> " + baseError);
                TransferTask.this.onError(baseError.getSubCode(), baseError.getMessage());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice, StartLargeFileTransferCmd startLargeFileTransferCmd) {
                if (startLargeFileTransferCmd.getStatus() != 0) {
                    short transferMtu = ((StartLargeFileTransferResponse) startLargeFileTransferCmd.getResponse()).getTransferMtu();
                    onErrCode(bluetoothDevice, transferMtu != 0 ? TransferTask.this.buildResponseBadResult(startLargeFileTransferCmd.getId(), transferMtu) : TransferTask.this.buildResponseBadState(startLargeFileTransferCmd.getId(), startLargeFileTransferCmd.getStatus()));
                    return;
                }
                TransferTask.this.c.c = ((StartLargeFileTransferResponse) startLargeFileTransferCmd.getResponse()).getTransferMtu();
                JL_Log.d(TransferTask.this.tag, "startBigFileTransfer", "transferMtu = " + TransferTask.this.c.c);
                if (TransferTask.this.c.c <= 0) {
                    onErrCode(bluetoothDevice, new BaseError(4097, RcspUtil.formatString("Device[%s] return an invalid mtu : %d.", bluetoothDevice, Integer.valueOf(TransferTask.this.c.c))));
                } else {
                    TransferTask.this.e.removeMessages(4386);
                    TransferTask.this.e.sendEmptyMessageDelayed(4386, TaskBase.TIMEOUT);
                }
            }
        });
    }

    public final void a(int i, byte[] bArr, OnOperationCallback<Boolean> onOperationCallback) {
        DataParam dataParam = new DataParam(bArr);
        dataParam.setXmOpCode(i);
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new DataCmd(dataParam), new BooleanRcspActionCallback("sendData", onOperationCallback));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(final LargeFileTransferOpCmd largeFileTransferOpCmd) {
        final int i = this.c.c;
        if (!isRun() || i <= 0 || this.c.a == null) {
            return;
        }
        LargeFileTransferOpParam largeFileTransferOpParam = (LargeFileTransferOpParam) largeFileTransferOpCmd.getParam();
        final int offset = largeFileTransferOpParam.getOffset();
        final short buffer = largeFileTransferOpParam.getBuffer();
        long jA = a(this.c.i);
        CacheVar cacheVar = this.c;
        if (cacheVar.j == offset && jA < cacheVar.k) {
            JL_Log.w(this.tag, "pullData", RcspUtil.formatString("Received same packet.Skip! offset = %d, take time = %d, limit = %d", Integer.valueOf(offset), Long.valueOf(jA), Long.valueOf(this.c.k)));
            return;
        }
        this.e.removeMessages(4386);
        if (offset > 512) {
            int i2 = this.c.f;
            float f = i2 == 0 ? 0.0f : (offset * 100.0f) / i2;
            callbackProgress((int) (f <= 100.0f ? f : 100.0f));
        }
        try {
            this.executor.execute(new Runnable() { // from class: w43
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(offset, buffer, i, largeFileTransferOpCmd);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            onError(16389, "Exception = " + e.getMessage());
        }
    }

    public final /* synthetic */ void a(final int i, final int i2, int i3, LargeFileTransferOpCmd largeFileTransferOpCmd) {
        int i4;
        byte[] bArr;
        try {
            CacheVar cacheVar = this.c;
            long j = i;
            cacheVar.j = j;
            cacheVar.i = b();
            this.c.a.seek(j);
            byte[] bArr2 = new byte[0];
            final int iMin = Math.min(i2, this.c.f - i);
            if (iMin >= 0) {
                bArr2 = new byte[iMin];
                i4 = this.c.a.read(bArr2);
            } else {
                i4 = -1;
            }
            if (i4 == -1) {
                this.e.post(new Runnable() { // from class: s43
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a(i, iMin, i2);
                    }
                });
                return;
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, 0, i4);
            this.c.k = (long) Math.max((((double) i4) * 10.0d) / ((double) i3), 10.0d);
            int i5 = 0;
            int i6 = 0;
            while (i5 < i4) {
                int iMin2 = Math.min(i3, i4 - i5);
                int i7 = i5 + iMin2;
                byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrCopyOfRange, i5, i7);
                Param param = this.d;
                if (param.appHasCrc16 && param.a) {
                    bArr = new byte[iMin2 + 3];
                    short sCRC16 = CryptoUtil.CRC16(bArrCopyOfRange2, (short) 0);
                    bArr[1] = (byte) ((sCRC16 >> 8) & 255);
                    bArr[2] = (byte) (sCRC16 & 255);
                    System.arraycopy(bArrCopyOfRange2, 0, bArr, 3, iMin2);
                } else {
                    bArr = new byte[iMin2 + 1];
                    System.arraycopy(bArrCopyOfRange2, 0, bArr, 1, iMin2);
                }
                bArr[0] = CHexConver.intToByte(i6);
                this.c.g.add(new SendData(largeFileTransferOpCmd.getId(), bArr));
                i6++;
                i5 = i7;
            }
            if (this.c.h) {
                return;
            }
            e();
        } catch (IOException e) {
            e.printStackTrace();
            this.e.post(new Runnable() { // from class: t43
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(e);
                }
            });
        }
    }

    public final /* synthetic */ void a(int i, int i2, int i3) {
        onError(16389, "Failed to read data. offset = " + i + ", packetSize = " + i2 + ", buffer : " + i3);
    }

    public final /* synthetic */ void a(IOException iOException) {
        onError(16389, "IO Exception = " + iOException.getMessage());
    }
}
