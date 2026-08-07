package com.jieli.jl_rcsp.task.smallfile;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.command.file_op.SmallFileTransferCmd;
import com.jieli.jl_rcsp.task.TaskBase;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.util.CryptoUtil;
import com.jieli.jl_rcsp.util.JL_Log;

/* JADX INFO: loaded from: classes3.dex */
public class AddFileTask extends TaskBase {
    public final Param b;
    public QueryFileTask.File c;

    public static class Param {
        public int a = 0;
        public int b;
        public byte[] c;
        protected int size;
        protected byte type;

        public Param(byte b, byte[] bArr) {
            this.type = b;
            this.size = bArr.length;
            this.c = bArr;
        }

        public byte[] getData() {
            return this.c;
        }

        public int getOffset() {
            return this.a;
        }

        public int getPacketSize() {
            return this.b;
        }

        public int getSize() {
            return this.size;
        }

        public byte getType() {
            return this.type;
        }

        public void setData(byte[] bArr) {
            this.c = bArr;
        }

        public void setOffset(int i) {
            this.a = i;
        }

        public void setPacketSize(int i) {
            this.b = i;
        }

        public void setSize(int i) {
            this.size = i;
        }

        public void setType(byte b) {
            this.type = b;
        }
    }

    public AddFileTask(RcspOpImpl rcspOpImpl, Param param) throws RuntimeException {
        super(rcspOpImpl);
        if (param == null) {
            throw new RuntimeException("AddFileTask.Param can not be null.");
        }
        this.b = param;
        if (param.b == 0) {
            param.b = DeviceStatusManager.getInstance().getMaxCommunicationMtu(getConnectedDevice()) - 20;
        }
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void cancel(byte b) {
        throw new RuntimeException("can not invoke cancel method");
    }

    public QueryFileTask.File getFile() {
        return this.c;
    }

    @Override // com.jieli.jl_rcsp.task.ITask
    public void start() {
        if (isRun()) {
            JL_Log.w(this.tag, "start", "Task is in progress.");
        } else {
            callbackBegin();
            a(this.b.a, Math.min(this.b.b, this.b.size), (short) 0);
        }
    }

    public final void a(int i, int i2, short s) {
        int iMin = Math.min(this.b.size - i, i2);
        byte[] bArr = new byte[iMin];
        System.arraycopy(this.b.c, i, bArr, 0, iMin);
        final int i3 = iMin + i;
        final short sCRC16 = CryptoUtil.CRC16(bArr, s);
        final SmallFileTransferCmd.Param paramA = a((short) i, (short) this.b.size, bArr, sCRC16);
        this.mRcspOp.sendRcspCommand(getConnectedDevice(), new SmallFileTransferCmd(paramA), new RcspCommandCallback<SmallFileTransferCmd>() { // from class: com.jieli.jl_rcsp.task.smallfile.AddFileTask.1
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onErrCode(BluetoothDevice bluetoothDevice, BaseError baseError) {
                AddFileTask.this.callbackError(baseError.getSubCode(), baseError.getMessage());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.jieli.jl_rcsp.interfaces.rcsp.RcspCommandCallback
            public void onCommandResponse(BluetoothDevice bluetoothDevice, SmallFileTransferCmd smallFileTransferCmd) {
                if (smallFileTransferCmd.getStatus() != 0) {
                    onErrCode(bluetoothDevice, AddFileTask.this.buildResponseBadState(smallFileTransferCmd.getId(), smallFileTransferCmd.getStatus()));
                    return;
                }
                SmallFileTransferCmd.ResultResponse resultResponse = (SmallFileTransferCmd.ResultResponse) smallFileTransferCmd.getResponse();
                byte b = resultResponse.ret;
                if (b != 0) {
                    onErrCode(bluetoothDevice, AddFileTask.this.buildResponseBadResult(smallFileTransferCmd.getId(), b));
                    return;
                }
                AddFileTask.this.callbackProgress((int) ((((double) i3) * 100.0d) / ((double) AddFileTask.this.b.size)));
                if (i3 < AddFileTask.this.b.size) {
                    AddFileTask addFileTask = AddFileTask.this;
                    addFileTask.a(i3, addFileTask.b.b, sCRC16);
                    return;
                }
                if (paramA instanceof SmallFileTransferCmd.AddFileParam) {
                    AddFileTask addFileTask2 = AddFileTask.this;
                    addFileTask2.c = new QueryFileTask.File(addFileTask2.b.type, ((SmallFileTransferCmd.AddFileResponse) resultResponse).id, AddFileTask.this.b.size);
                    JL_Log.d(((TaskBase) AddFileTask.this).tag, "write", "add small file finished id = " + ((int) AddFileTask.this.c.id));
                } else {
                    JL_Log.d(((TaskBase) AddFileTask.this).tag, "write", "update small file finished id = " + ((int) AddFileTask.this.c.id));
                }
                AddFileTask.this.callbackFinish();
            }
        });
    }

    public SmallFileTransferCmd.Param a(short s, short s2, byte[] bArr, short s3) {
        return new SmallFileTransferCmd.AddFileParam(this.b.type, s, s2, bArr, s3);
    }
}
