package com.jieli.jl_rcsp.impl;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.interfaces.IHandleResult;
import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.interfaces.nfc.INfcOp;
import com.jieli.jl_rcsp.interfaces.nfc.OnNfcEventCallback;
import com.jieli.jl_rcsp.interfaces.nfc.OnSyncNfcMsgListener;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationCmd;
import com.jieli.jl_rcsp.model.command.nfc.NFCOperationNoResponseCmd;
import com.jieli.jl_rcsp.model.device.NfcMsg;
import com.jieli.jl_rcsp.task.ITask;
import com.jieli.jl_rcsp.task.SimpleTaskListener;
import com.jieli.jl_rcsp.task.TaskListener;
import com.jieli.jl_rcsp.task.TransferTask;
import com.jieli.jl_rcsp.task.nfc.NfcSyncTask;
import com.jieli.jl_rcsp.tool.BooleanNfcActionCallback;
import com.jieli.jl_rcsp.tool.CustomRcspActionCallback;
import com.jieli.jl_rcsp.tool.NfcEventCbHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.CommandBuilder;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class NfcOpImpl implements INfcOp {
    public static final String g = "NfcOpImpl";
    public final RcspOpImpl a;
    public ITask c;
    public List<NfcMsg> d;
    public final OnRcspCallback f;
    public final NfcEventCbHelper b = new NfcEventCbHelper();
    public short e = 255;

    /* JADX INFO: renamed from: com.jieli.jl_rcsp.impl.NfcOpImpl$7, reason: invalid class name */
    public class AnonymousClass7 implements TaskListener {
        public final /* synthetic */ TaskListener a;
        public final /* synthetic */ BluetoothDevice b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;

        public AnonymousClass7(TaskListener taskListener, BluetoothDevice bluetoothDevice, int i, String str) {
            this.a = taskListener;
            this.b = bluetoothDevice;
            this.c = i;
            this.d = str;
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onBegin() {
            JL_Log.e(NfcOpImpl.g, "startTransferTask", "onBegin >> ");
            TaskListener taskListener = this.a;
            if (taskListener != null) {
                taskListener.onBegin();
            }
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onCancel(int i) {
            TaskListener taskListener = this.a;
            if (taskListener != null) {
                taskListener.onCancel(i);
            }
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onError(int i, String str) {
            JL_Log.e(NfcOpImpl.g, "startTransferTask", "onError = " + i + ", msg = " + str);
            NfcOpImpl.this.c = null;
            TaskListener taskListener = this.a;
            if (taskListener != null) {
                taskListener.onError(i, str);
            }
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onFinish() {
            JL_Log.e(NfcOpImpl.g, "startTransferTask", "onFinish >> ");
            NfcOpImpl.this.c = null;
            NfcOpImpl.this.a.sendRcspCommand(this.b, CommandBuilder.buildInsertNfcFileEndCmd(this.c, NfcOpImpl.this.a(this.d)), new BooleanNfcActionCallback("InsertNfcFileEnd", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.7.1
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    TaskListener taskListener = AnonymousClass7.this.a;
                    if (taskListener != null) {
                        taskListener.onError(baseError.getSubCode(), baseError.getMessage());
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                    NfcOpImpl.this.syncNfcMsg(anonymousClass7.b, anonymousClass7.c, new OnSyncNfcMsgListener() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.7.1.1
                        @Override // com.jieli.jl_rcsp.interfaces.nfc.OnSyncNfcMsgListener
                        public void onError(BaseError baseError) {
                            TaskListener taskListener = AnonymousClass7.this.a;
                            if (taskListener != null) {
                                taskListener.onError(baseError.getSubCode(), baseError.getMessage());
                            }
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.nfc.OnSyncNfcMsgListener
                        public void onFinish(List<NfcMsg> list) {
                            JL_Log.e(NfcOpImpl.g, "startTransferTask", "success >> list = " + list.size());
                            TaskListener taskListener = AnonymousClass7.this.a;
                            if (taskListener != null) {
                                taskListener.onFinish();
                            }
                        }

                        @Override // com.jieli.jl_rcsp.interfaces.nfc.OnSyncNfcMsgListener
                        public void onStart() {
                        }
                    });
                }
            }));
        }

        @Override // com.jieli.jl_rcsp.task.TaskListener
        public void onProgress(int i) {
            TaskListener taskListener = this.a;
            if (taskListener != null) {
                taskListener.onProgress(i);
            }
        }
    }

    public NfcOpImpl(RcspOpImpl rcspOpImpl) {
        OnRcspCallback onRcspCallback = new OnRcspCallback() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.OnRcspCallback
            public void onRcspCommand(BluetoothDevice bluetoothDevice, CommandBase commandBase) {
                if (commandBase.getId() == 164 && (commandBase instanceof NFCOperationNoResponseCmd)) {
                    NFCOperationNoResponseCmd.Param param = (NFCOperationNoResponseCmd.Param) ((NFCOperationNoResponseCmd) commandBase).getParam();
                    if (param instanceof NFCOperationNoResponseCmd.NotifyDefaultNfcParam) {
                        NfcOpImpl.this.e = ((NFCOperationNoResponseCmd.NotifyDefaultNfcParam) param).getId();
                        NfcOpImpl.this.b.onDefaultNfc(bluetoothDevice, NfcOpImpl.this.e);
                    }
                }
            }
        };
        this.f = onRcspCallback;
        if (rcspOpImpl == null) {
            throw new NullPointerException("RcspOpImpl can not be null.");
        }
        this.a = rcspOpImpl;
        rcspOpImpl.registerOnRcspCallback(onRcspCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void addNfcFile(final BluetoothDevice bluetoothDevice, final String str, final int i, final TaskListener taskListener) {
        JL_Log.i(g, "addNfcFile", "path : " + str);
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildInsertNfcFileCmd(i, (int) file.length(), file.getName()), new BooleanNfcActionCallback("addNfcFile", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.2
                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onFailed(BaseError baseError) {
                    JL_Log.i(NfcOpImpl.g, "addNfcFile", "onFailed :: " + baseError);
                    TaskListener taskListener2 = taskListener;
                    if (taskListener2 != null) {
                        taskListener2.onError(baseError.getSubCode(), baseError.getMessage());
                    }
                }

                @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
                public void onSuccess(Boolean bool) {
                    JL_Log.i(NfcOpImpl.g, "addNfcFile", "onSuccess :: " + bool);
                    NfcOpImpl.this.a(bluetoothDevice, str, i, taskListener);
                }
            }));
        } else if (taskListener != null) {
            taskListener.onError(4, "File not found.");
        }
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void addOnNfcEventCallback(OnNfcEventCallback onNfcEventCallback) {
        this.b.registerCallback(onNfcEventCallback);
    }

    public void destroy() {
        b();
        this.a.unregisterOnRcspCallback(this.f);
        this.b.release();
        this.d.clear();
        this.e = (short) 255;
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void getDefaultNfc(BluetoothDevice bluetoothDevice, int i, OnOperationCallback<Short> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildGetDefaultNfcOpCmd(i), new CustomRcspActionCallback("getDefaultNfc", onOperationCallback, new IHandleResult<Short, NFCOperationCmd>() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public Short handleResult(BluetoothDevice bluetoothDevice2, NFCOperationCmd nFCOperationCmd) {
                NfcOpImpl.this.e = ((NFCOperationCmd.GetDefaultNfcResponse) nFCOperationCmd.getResponse()).getId();
                NfcOpImpl.this.b.onDefaultNfc(bluetoothDevice2, NfcOpImpl.this.e);
                return Short.valueOf(NfcOpImpl.this.e);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.IHandleResult
            public int hasResult(BluetoothDevice bluetoothDevice2, NFCOperationCmd nFCOperationCmd) {
                if (nFCOperationCmd == null) {
                    return 1;
                }
                if (nFCOperationCmd.getStatus() != 1) {
                    return nFCOperationCmd.getStatus();
                }
                if (nFCOperationCmd.getResponse() == 0) {
                    return 1;
                }
                return ((NFCOperationCmd.Response) nFCOperationCmd.getResponse()).getResult();
            }
        }));
    }

    public short getDefaultNfcId() {
        return this.e;
    }

    public NfcMsg getNfcMsgByID(short s) {
        List<NfcMsg> list = this.d;
        if (list == null) {
            return null;
        }
        for (NfcMsg nfcMsg : list) {
            if (nfcMsg.getId() == s) {
                return nfcMsg;
            }
        }
        return null;
    }

    public List<NfcMsg> getNfcMsgList() {
        return this.d;
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void modifyNfcMsg(final BluetoothDevice bluetoothDevice, final NFCOperationCmd.ModifyMsgParam modifyMsgParam, final OnOperationCallback<Boolean> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildModifyNFCInfoCmd(modifyMsgParam), new BooleanNfcActionCallback("modifyNfcMsg", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.3
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onFailed(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                NfcOpImpl.this.a(bluetoothDevice, modifyMsgParam);
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onSuccess(bool);
                }
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void removeNfcMsg(final BluetoothDevice bluetoothDevice, int i, final short s, final OnOperationCallback<Boolean> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildDeleteNFCInfoSyncCmd(i, s), new BooleanNfcActionCallback("removeNfcMsg", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.4
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onFailed(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                NfcOpImpl.this.a(bluetoothDevice, s);
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onSuccess(bool);
                }
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void removeOnNfcEventCallback(OnNfcEventCallback onNfcEventCallback) {
        this.b.registerCallback(onNfcEventCallback);
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void setDefaultNfc(final BluetoothDevice bluetoothDevice, int i, final short s, final OnOperationCallback<Boolean> onOperationCallback) {
        this.a.sendRcspCommand(bluetoothDevice, CommandBuilder.buildSetDefaultNfcOpCmd(i, s), new BooleanNfcActionCallback("setDefaultNfc", new OnOperationCallback<Boolean>() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.6
            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onFailed(BaseError baseError) {
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onFailed(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.OnOperationCallback
            public void onSuccess(Boolean bool) {
                NfcOpImpl.this.e = s;
                NfcOpImpl.this.b.onDefaultNfc(bluetoothDevice, NfcOpImpl.this.e);
                OnOperationCallback onOperationCallback2 = onOperationCallback;
                if (onOperationCallback2 != null) {
                    onOperationCallback2.onSuccess(bool);
                }
            }
        }));
    }

    @Override // com.jieli.jl_rcsp.interfaces.nfc.INfcOp
    public void syncNfcMsg(final BluetoothDevice bluetoothDevice, int i, final OnSyncNfcMsgListener onSyncNfcMsgListener) {
        a(bluetoothDevice, i, new OnSyncNfcMsgListener() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.1
            @Override // com.jieli.jl_rcsp.interfaces.nfc.OnSyncNfcMsgListener
            public void onError(BaseError baseError) {
                OnSyncNfcMsgListener onSyncNfcMsgListener2 = onSyncNfcMsgListener;
                if (onSyncNfcMsgListener2 != null) {
                    onSyncNfcMsgListener2.onError(baseError);
                }
            }

            @Override // com.jieli.jl_rcsp.interfaces.nfc.OnSyncNfcMsgListener
            public void onFinish(List<NfcMsg> list) {
                NfcOpImpl.this.d = list;
                OnSyncNfcMsgListener onSyncNfcMsgListener2 = onSyncNfcMsgListener;
                if (onSyncNfcMsgListener2 != null) {
                    onSyncNfcMsgListener2.onFinish(list);
                }
                NfcOpImpl.this.b.onNfcMsgChange(bluetoothDevice, list);
                String str = NfcOpImpl.g;
                StringBuilder sb = new StringBuilder();
                sb.append("onFinish =  ");
                sb.append(list == null ? 0 : list.size());
                JL_Log.e(str, "syncNfcMsg", sb.toString());
            }

            @Override // com.jieli.jl_rcsp.interfaces.nfc.OnSyncNfcMsgListener
            public void onStart() {
                JL_Log.i(NfcOpImpl.g, "syncNfcMsg", "onStart >>>>>>");
                OnSyncNfcMsgListener onSyncNfcMsgListener2 = onSyncNfcMsgListener;
                if (onSyncNfcMsgListener2 != null) {
                    onSyncNfcMsgListener2.onStart();
                }
            }
        });
    }

    public final void b() {
        ITask iTask = this.c;
        if (iTask != null) {
            if (iTask.isRun()) {
                this.c.cancel((byte) 0);
            }
            this.c = null;
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, String str, int i, TaskListener taskListener) {
        ITask iTask = this.c;
        if (iTask != null && iTask.isRun()) {
            if (this.c.isRun()) {
                if (taskListener != null) {
                    taskListener.onError(4352, "Operation is in operation.");
                    return;
                }
                return;
            }
        } else {
            TransferTask.Param param = new TransferTask.Param();
            param.devHandler = i;
            this.c = new TransferTask(this.a, str, param);
        }
        this.c.setListener(new AnonymousClass7(taskListener, bluetoothDevice, i, str));
        ((TransferTask) this.c).setPath(str);
        JL_Log.e(g, "startTransferTask", "Task =  " + this.c + " start");
        this.c.start();
    }

    public final String a(String str) {
        if (str == null) {
            return Constants.STR_EMPTY;
        }
        int iLastIndexOf = str.lastIndexOf(WatchConstant.FAT_FS_ROOT);
        if (iLastIndexOf == -1) {
            return str;
        }
        return iLastIndexOf == str.length() + (-1) ? Constants.STR_EMPTY : str.substring(iLastIndexOf + 1);
    }

    public final void a(BluetoothDevice bluetoothDevice, int i, final OnSyncNfcMsgListener onSyncNfcMsgListener) {
        ITask iTask = this.c;
        if (iTask == null || !iTask.isRun()) {
            NfcSyncTask nfcSyncTask = new NfcSyncTask(this.a, bluetoothDevice, i);
            this.c = nfcSyncTask;
            nfcSyncTask.setListener(new SimpleTaskListener() { // from class: com.jieli.jl_rcsp.impl.NfcOpImpl.8
                @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
                public void onBegin() {
                    OnSyncNfcMsgListener onSyncNfcMsgListener2 = onSyncNfcMsgListener;
                    if (onSyncNfcMsgListener2 != null) {
                        onSyncNfcMsgListener2.onStart();
                    }
                }

                @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
                public void onError(int i2, String str) {
                    OnSyncNfcMsgListener onSyncNfcMsgListener2 = onSyncNfcMsgListener;
                    if (onSyncNfcMsgListener2 != null) {
                        onSyncNfcMsgListener2.onError(new BaseError(i2, str));
                    }
                }

                @Override // com.jieli.jl_rcsp.task.SimpleTaskListener, com.jieli.jl_rcsp.task.TaskListener
                public void onFinish() {
                    OnSyncNfcMsgListener onSyncNfcMsgListener2 = onSyncNfcMsgListener;
                    if (onSyncNfcMsgListener2 != null) {
                        onSyncNfcMsgListener2.onFinish(((NfcSyncTask) NfcOpImpl.this.c).getNfcMsgs());
                    }
                }
            });
        }
        this.c.start();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00e1  */
    public final void a(BluetoothDevice bluetoothDevice, NFCOperationCmd.ModifyMsgParam modifyMsgParam) {
        NfcMsg nfcMsgByID;
        boolean z;
        String strTrim;
        if (this.d == null || modifyMsgParam == null || modifyMsgParam.getValue() == null || (nfcMsgByID = getNfcMsgByID(modifyMsgParam.getId())) == null) {
            return;
        }
        int i = 0;
        boolean zCheckMaskHasBit = RcspUtil.checkMaskHasBit(modifyMsgParam.getMask(), (byte) 0);
        boolean z2 = true;
        boolean zCheckMaskHasBit2 = RcspUtil.checkMaskHasBit(modifyMsgParam.getMask(), (byte) 1);
        byte[] value = modifyMsgParam.getValue();
        String str = g;
        JL_Log.i(str, "modifyNfcMsg", "hasTime : " + zCheckMaskHasBit + ", hasNickname = " + zCheckMaskHasBit2 + ",  value : " + value.length);
        if (!zCheckMaskHasBit || 4 > value.length) {
            z = false;
        } else {
            long jIntToTime = RcspUtil.intToTime(CHexConver.bytesToInt(value, 0, 4));
            JL_Log.i(str, "modifyNfcMsg", "realTime : " + jIntToTime + ", UpdateTime = " + nfcMsgByID.getUpdateTime());
            if (nfcMsgByID.getUpdateTime() != jIntToTime) {
                nfcMsgByID.setUpdateTime(jIntToTime);
                z = true;
            } else {
                z = false;
            }
            i = 4;
        }
        if (!zCheckMaskHasBit2 || i + 24 > value.length) {
            z2 = z;
        } else {
            try {
                strTrim = new String(value, i, 24).trim();
            } catch (Exception e) {
                e.printStackTrace();
                strTrim = null;
            }
            JL_Log.i(g, "modifyNfcMsg", "name : " + strTrim + ", Nickname = " + nfcMsgByID.getNickname());
            if (strTrim == null || strTrim.equalsIgnoreCase(nfcMsgByID.getNickname())) {
                z2 = z;
            } else {
                nfcMsgByID.setNickname(strTrim);
            }
        }
        if (z2) {
            JL_Log.i(g, "modifyNfcMsg", "nfcMsg = " + nfcMsgByID);
            this.b.onModifyNfcMsg(bluetoothDevice, nfcMsgByID);
            this.b.onNfcMsgChange(bluetoothDevice, this.d);
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, short s) {
        NfcMsg nfcMsgByID;
        if (this.d == null || (nfcMsgByID = getNfcMsgByID(s)) == null || !this.d.remove(nfcMsgByID)) {
            return;
        }
        this.b.onNfcMsgChange(bluetoothDevice, this.d);
    }
}
