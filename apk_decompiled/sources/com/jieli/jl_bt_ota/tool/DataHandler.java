package com.jieli.jl_bt_ota.tool;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_bt_ota.constant.ErrorCode;
import com.jieli.jl_bt_ota.impl.BluetoothOTAManager;
import com.jieli.jl_bt_ota.interfaces.CommandCallback;
import com.jieli.jl_bt_ota.model.DataInfo;
import com.jieli.jl_bt_ota.model.OTAError;
import com.jieli.jl_bt_ota.model.base.BaseError;
import com.jieli.jl_bt_ota.model.base.BasePacket;
import com.jieli.jl_bt_ota.model.base.CommandBase;
import com.jieli.jl_bt_ota.util.CHexConver;
import com.jieli.jl_bt_ota.util.JL_Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class DataHandler implements IDataHandler {
    private static final String e = "DataHandler";
    private final BluetoothOTAManager a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private WorkThread c;
    private DataHandlerThread d;

    /* JADX INFO: Access modifiers changed from: private */
    class DataHandlerThread extends Thread {
        private volatile boolean a;
        private volatile boolean b;
        private ArrayList<BasePacket> c;
        private final LinkedBlockingQueue<DataInfo> d;
        private final List<DataInfo> e;
        private final List<DataInfo> f;
        private TimerThread g;

        public DataHandlerThread() {
            super("DataHandlerThread");
            this.d = new LinkedBlockingQueue<>();
            this.e = Collections.synchronizedList(new ArrayList());
            this.f = Collections.synchronizedList(new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            if (this.b) {
                synchronized (this.d) {
                    try {
                        if (this.b) {
                            JL_Log.i(DataHandler.e, "wakeUpThread:: notifyAll");
                            this.d.notifyAll();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (this.d) {
                while (this.a) {
                    if (this.d.isEmpty()) {
                        this.b = true;
                        c();
                        JL_Log.d(DataHandler.e, "DataHandlerThread is waiting...");
                        try {
                            this.d.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.b = false;
                        c(this.d.poll());
                        c();
                    }
                }
            }
            JL_Log.e(DataHandler.e, "-DataHandlerThread- exit...");
            this.e.clear();
            this.f.clear();
            this.d.clear();
            this.a = false;
            e();
            DataHandler.this.d = null;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.a = true;
            super.start();
            JL_Log.i(DataHandler.e, "DataHandlerThread start....");
        }

        public void stopThread() {
            JL_Log.w(DataHandler.e, "-stopThread-");
            this.a = false;
            f();
        }

        public void tryToAddRecvData(DataInfo dataInfo) {
            JL_Log.d(DataHandler.e, "-tryToAddRecvData-  ret : " + a(dataInfo) + ",isWaiting = " + this.b);
        }

        public void tryToAddSendData(DataInfo dataInfo) {
            JL_Log.d(DataHandler.e, "-tryToAddSendData-  ret : " + a(dataInfo) + ",isWaiting = " + this.b);
        }

        private int b(BluetoothDevice bluetoothDevice) {
            return DataHandler.this.a.getReceiveMtu(bluetoothDevice);
        }

        private void c() {
            a();
            DataInfo dataInfoD = d();
            if (dataInfoD != null) {
                e(dataInfoD);
                return;
            }
            if (this.f.size() > 0) {
                a(500);
            } else if (this.e.size() > 0) {
                a(500);
            } else {
                e();
            }
        }

        private void d(DataInfo dataInfo) {
            final BasePacket basePacket = dataInfo.getBasePacket();
            if (basePacket == null) {
                return;
            }
            if (basePacket.getHasResponse() == 1) {
                this.f.remove(dataInfo);
            } else {
                this.e.remove(dataInfo);
            }
            final CommandCallback callback = dataInfo.getCallback();
            DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(basePacket, callback);
                }
            });
        }

        private void e() {
            TimerThread timerThread = this.g;
            if (timerThread == null || !timerThread.b) {
                return;
            }
            JL_Log.i(DataHandler.e, "-stopTimer- >>> ");
            this.g.a();
        }

        private void a(int i) {
            TimerThread timerThread = this.g;
            if (timerThread != null) {
                if (timerThread.b) {
                    return;
                }
                this.g.b = true;
            } else {
                TimerThread timerThread2 = DataHandler.this.new TimerThread(i, new ThreadStateListener() { // from class: com.jieli.jl_bt_ota.tool.DataHandler.DataHandlerThread.1
                    @Override // com.jieli.jl_bt_ota.tool.DataHandler.ThreadStateListener
                    public void onFinish(long j) {
                        if (DataHandlerThread.this.g == null || DataHandlerThread.this.g.getId() != j) {
                            return;
                        }
                        DataHandlerThread.this.g = null;
                    }

                    @Override // com.jieli.jl_bt_ota.tool.DataHandler.ThreadStateListener
                    public void onStart(long j) {
                    }
                });
                this.g = timerThread2;
                timerThread2.start();
            }
        }

        private ArrayList<DataInfo> b() {
            if (this.f.size() <= 0) {
                return null;
            }
            ArrayList<DataInfo> arrayList = new ArrayList<>();
            for (DataInfo dataInfo : this.f) {
                if (dataInfo.isSend()) {
                    arrayList.add(dataInfo);
                }
            }
            return arrayList;
        }

        private void e(DataInfo dataInfo) {
            byte[] bArrPackSendBasePacket = ParseHelper.packSendBasePacket(dataInfo.getBasePacket());
            if (bArrPackSendBasePacket == null) {
                JL_Log.i(DataHandler.e, "send data :: pack data error.");
                d(dataInfo);
                return;
            }
            int iA = a(dataInfo.getDevice());
            JL_Log.i(DataHandler.e, "send data : [" + CHexConver.byte2HexStr(bArrPackSendBasePacket) + "], sendMtu = " + iA);
            if (bArrPackSendBasePacket.length > iA + 8) {
                JL_Log.e(DataHandler.e, "send data over communication mtu [" + iA + "] limit.");
                d(dataInfo);
                return;
            }
            boolean zSendDataToDevice = false;
            for (int i = 0; i < 3; i++) {
                if (DataHandler.this.a != null) {
                    zSendDataToDevice = DataHandler.this.a.sendDataToDevice(DataHandler.this.a.getConnectedDevice(), bArrPackSendBasePacket);
                }
                if (zSendDataToDevice) {
                    break;
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            JL_Log.i(DataHandler.e, "send ret : " + zSendDataToDevice);
            if (!zSendDataToDevice) {
                d(dataInfo);
                return;
            }
            if (dataInfo.getBasePacket().getHasResponse() == 1) {
                dataInfo.setSend(true);
                dataInfo.setSendTime(Calendar.getInstance().getTimeInMillis());
            } else {
                final CommandCallback callback = dataInfo.getCallback();
                if (callback != null) {
                    DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            callback.onCommandResponse(null);
                        }
                    });
                }
                this.e.remove(dataInfo);
            }
        }

        private DataInfo d() {
            int i = 0;
            if (this.e.size() > 0) {
                while (i < this.e.size()) {
                    DataInfo dataInfo = this.e.get(i);
                    if (!dataInfo.isSend()) {
                        return dataInfo;
                    }
                    i++;
                }
                return null;
            }
            if (this.f.size() <= 0) {
                return null;
            }
            while (i < this.f.size()) {
                DataInfo dataInfo2 = this.f.get(i);
                if (!dataInfo2.isSend()) {
                    return dataInfo2;
                }
                i++;
            }
            return null;
        }

        private int a(BluetoothDevice bluetoothDevice) {
            return DataHandler.this.a.getCommunicationMtu(bluetoothDevice);
        }

        private void b(DataInfo dataInfo) {
            final CommandCallback callback = dataInfo.getCallback();
            DataHandler.this.a.removeCacheCommand(dataInfo.getDevice(), dataInfo.getBasePacket());
            DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.n
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(callback);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(BasePacket basePacket, CommandCallback commandCallback) {
            BaseError baseErrorBuildError = OTAError.buildError(12290);
            baseErrorBuildError.setOpCode(basePacket.getOpCode());
            if (commandCallback != null) {
                commandCallback.onErrCode(baseErrorBuildError);
            }
            DataHandler.this.a.errorEventCallback(baseErrorBuildError);
        }

        private void c(DataInfo dataInfo) {
            if (dataInfo != null) {
                if (dataInfo.getType() == 1) {
                    ArrayList<BasePacket> arrayListFindPacketData = ParseHelper.findPacketData(dataInfo.getDevice(), b(dataInfo.getDevice()), dataInfo.getRecvData());
                    if (arrayListFindPacketData != null) {
                        ArrayList<BasePacket> arrayList = this.c;
                        if (arrayList != null && arrayList.size() != 0) {
                            this.c.addAll(arrayListFindPacketData);
                        } else {
                            this.c = arrayListFindPacketData;
                        }
                        int size = arrayListFindPacketData.size();
                        int i = 0;
                        while (i < size) {
                            BasePacket basePacket = arrayListFindPacketData.get(i);
                            i++;
                            JL_Log.d(DataHandler.e, "-handlerQueue- opCode : " + basePacket.getOpCode());
                        }
                        f();
                        return;
                    }
                    JL_Log.e(DataHandler.e, "-handlerQueue- findPacketData not found. ");
                    return;
                }
                if (dataInfo.getBasePacket() != null) {
                    if (dataInfo.getBasePacket().getHasResponse() == 1) {
                        if (this.f.size() < 30) {
                            this.f.add(dataInfo);
                            return;
                        } else {
                            JL_Log.i(DataHandler.e, "-handlerQueue- haveResponseDataList is busy. ");
                            DataHandler.this.a.errorEventCallback(OTAError.buildError(12291));
                            return;
                        }
                    }
                    if (this.e.size() < 60) {
                        this.e.add(dataInfo);
                    } else {
                        JL_Log.i(DataHandler.e, "-handlerQueue- noResponseDataList is busy. ");
                        DataHandler.this.a.errorEventCallback(OTAError.buildError(12291));
                    }
                }
            }
        }

        private boolean a(DataInfo dataInfo) {
            boolean zOffer;
            if (dataInfo != null) {
                try {
                    zOffer = this.d.offer(dataInfo, 3L, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    zOffer = false;
                }
            } else {
                zOffer = false;
            }
            if (zOffer) {
                f();
            }
            return zOffer;
        }

        private void a() {
            ArrayList<BasePacket> arrayList = new ArrayList<>();
            ArrayList<BasePacket> arrayList2 = this.c;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList(this.c);
                int size = arrayList5.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList5.get(i);
                    i++;
                    BasePacket basePacket = (BasePacket) obj;
                    byte[] bArrPackSendBasePacket = ParseHelper.packSendBasePacket(basePacket);
                    if (bArrPackSendBasePacket != null) {
                        if (DataHandler.this.a != null) {
                            DataHandler.this.a.receiveDataFromDevice(DataHandler.this.a.getConnectedDevice(), bArrPackSendBasePacket);
                        }
                        if (basePacket.getType() == 1) {
                            arrayList3.add(basePacket);
                        } else {
                            arrayList.add(basePacket);
                        }
                    } else {
                        arrayList4.add(basePacket);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    this.c.removeAll(arrayList3);
                }
                if (arrayList4.size() > 0) {
                    this.c.removeAll(arrayList4);
                }
                a(arrayList);
                return;
            }
            a((ArrayList<BasePacket>) null);
        }

        private void a(ArrayList<BasePacket> arrayList) {
            ArrayList<DataInfo> arrayList2;
            int i;
            String str;
            ArrayList<DataInfo> arrayListB;
            ArrayList arrayList3;
            ArrayList<BasePacket> arrayList4 = arrayList;
            int size = this.f.size();
            String str2 = DataHandler.e;
            if (size > 0) {
                ArrayList<DataInfo> arrayListB2 = b();
                StringBuilder sb = new StringBuilder();
                sb.append("-checkHaveResponseList- waitList size : ");
                sb.append(arrayListB2 == null ? 0 : arrayListB2.size());
                JL_Log.w(DataHandler.e, sb.toString());
                if (arrayListB2 == null || arrayListB2.size() <= 0) {
                    return;
                }
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                String str3 = ", data : ";
                if (arrayList4 != null && arrayList.size() > 0) {
                    int size2 = arrayList.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        int i3 = i2 + 1;
                        final BasePacket basePacket = arrayList4.get(i2);
                        JL_Log.w(str2, "-checkHaveResponseList- opCode : " + basePacket.getOpCode() + ", sn : " + basePacket.getOpCodeSn());
                        int size3 = arrayListB2.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            DataInfo dataInfo = arrayListB2.get(i4);
                            i4++;
                            final DataInfo dataInfo2 = dataInfo;
                            final BasePacket basePacket2 = dataInfo2.getBasePacket();
                            if (basePacket2 != null) {
                                JL_Log.w(str2, "-checkHaveResponseList- packet opCode : " + basePacket2.getOpCode() + ", packet sn : " + basePacket2.getOpCodeSn());
                            }
                            if (basePacket2 != null && basePacket2.getOpCode() == basePacket.getOpCode() && basePacket2.getOpCodeSn() == basePacket.getOpCodeSn()) {
                                JL_Log.w(str2, "-checkHaveResponseList- callback");
                                final CommandCallback callback = dataInfo2.getCallback();
                                DataHandler.this.b.post(new Runnable() { // from class: com.jieli.jl_bt_ota.tool.l
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.a.a(callback, basePacket, dataInfo2, basePacket2);
                                    }
                                });
                                arrayList5.add(basePacket);
                                arrayList6.add(dataInfo2);
                                str3 = str3;
                                break;
                            }
                            int i5 = size2;
                            String str4 = str3;
                            ArrayList<DataInfo> arrayList7 = arrayListB2;
                            if (dataInfo2.getTimeoutMs() < 500) {
                                dataInfo2.setTimeoutMs(500);
                            }
                            String str5 = str2;
                            if (timeInMillis - dataInfo2.getSendTime() > dataInfo2.getTimeoutMs()) {
                                int reSendCount = dataInfo2.getReSendCount();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("wait for response timeout !!! reSend count : ");
                                sb2.append(reSendCount);
                                str3 = str4;
                                sb2.append(str3);
                                sb2.append(dataInfo2);
                                JL_Log.e(str5, sb2.toString());
                                if (reSendCount >= 3) {
                                    JL_Log.e(str5, "retry count over time, callbackTimeOutError.");
                                    b(dataInfo2);
                                    arrayList5.add(basePacket);
                                    arrayList6.add(dataInfo2);
                                } else {
                                    dataInfo2.setReSendCount(reSendCount + 1);
                                    dataInfo2.setSend(false);
                                }
                            } else {
                                str3 = str4;
                            }
                            str2 = str5;
                            arrayListB2 = arrayList7;
                            size2 = i5;
                        }
                        arrayList4 = arrayList;
                        str2 = str2;
                        i2 = i3;
                        arrayListB2 = arrayListB2;
                        size2 = size2;
                    }
                    arrayList2 = arrayListB2;
                    str = str2;
                    if (arrayList5.size() <= 0 || this.c == null) {
                        arrayList3 = arrayList;
                        i = 500;
                    } else {
                        arrayList3 = arrayList;
                        i = 500;
                        arrayList3.removeAll(arrayList5);
                        this.c.removeAll(arrayList5);
                    }
                    if (arrayList.size() > 0 && this.c != null) {
                        JL_Log.e(str, "-checkHaveResponseList- remove unused response.");
                        this.c.removeAll(arrayList3);
                    }
                    if (arrayList6.size() > 0) {
                        this.f.removeAll(arrayList6);
                        arrayList6.clear();
                        arrayListB = b();
                    }
                    if (arrayListB != null || arrayListB.size() <= 0) {
                        return;
                    }
                    int size4 = arrayListB.size();
                    int i6 = 0;
                    while (i6 < size4) {
                        DataInfo dataInfo3 = arrayListB.get(i6);
                        i6++;
                        DataInfo dataInfo4 = dataInfo3;
                        if (dataInfo4.getTimeoutMs() < i) {
                            dataInfo4.setTimeoutMs(i);
                        }
                        if (timeInMillis - dataInfo4.getSendTime() > dataInfo4.getTimeoutMs()) {
                            int reSendCount2 = dataInfo4.getReSendCount();
                            JL_Log.e(str, "wait for response timeout 222222 !!! reSend count : " + reSendCount2 + str3 + dataInfo4);
                            if (reSendCount2 >= 3) {
                                JL_Log.e(str, "retry count over time 222222, callbackTimeOutError.");
                                b(dataInfo4);
                                arrayList6.add(dataInfo4);
                            } else {
                                dataInfo4.setReSendCount(reSendCount2 + 1);
                                dataInfo4.setSend(false);
                            }
                        }
                    }
                    if (arrayList6.size() > 0) {
                        this.f.removeAll(arrayList6);
                        return;
                    }
                    return;
                }
                arrayList2 = arrayListB2;
                i = 500;
                str = DataHandler.e;
                arrayListB = arrayList2;
                if (arrayListB != null) {
                    return;
                } else {
                    return;
                }
            }
            if (arrayList4 == null || arrayList.size() <= 0 || this.c == null) {
                return;
            }
            JL_Log.e(DataHandler.e, "-checkHaveResponseList- 22222 remove unused response.");
            this.c.removeAll(arrayList4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(CommandCallback commandCallback, BasePacket basePacket, DataInfo dataInfo, BasePacket basePacket2) {
            if (commandCallback != null) {
                CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(basePacket, DataHandler.this.a.getCacheCommand(dataInfo.getDevice(), basePacket));
                if (commandBaseConvert2Command == null) {
                    commandCallback.onErrCode(OTAError.buildError(12293));
                } else {
                    commandCallback.onCommandResponse(commandBaseConvert2Command);
                }
            }
            DataHandler.this.a.removeCacheCommand(dataInfo.getDevice(), basePacket2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(CommandCallback commandCallback) {
            BaseError baseErrorBuildError = OTAError.buildError(ErrorCode.SUB_ERR_SEND_TIMEOUT);
            if (commandCallback != null) {
                commandCallback.onErrCode(baseErrorBuildError);
            }
            DataHandler.this.a.errorEventCallback(baseErrorBuildError);
        }
    }

    public interface ThreadStateListener {
        void onFinish(long j);

        void onStart(long j);
    }

    private class TimerThread extends Thread {
        private final long a;
        private volatile boolean b;
        private final ThreadStateListener c;

        TimerThread(long j, ThreadStateListener threadStateListener) {
            super("TimerThread");
            this.a = j;
            this.c = threadStateListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.b) {
                try {
                    Thread.sleep(this.a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (DataHandler.this.d == null) {
                    break;
                } else {
                    DataHandler.this.d.f();
                }
            }
            this.b = false;
            JL_Log.w(DataHandler.e, "TimerThread is end....name : " + getName());
            ThreadStateListener threadStateListener = this.c;
            if (threadStateListener != null) {
                threadStateListener.onFinish(getId());
            }
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.b = true;
            super.start();
            JL_Log.w(DataHandler.e, "TimerThread is start....name : " + getName());
            ThreadStateListener threadStateListener = this.c;
            if (threadStateListener != null) {
                threadStateListener.onStart(getId());
            }
        }

        synchronized void a() {
            this.b = false;
        }
    }

    public class WorkThread extends HandlerThread implements Handler.Callback {
        private static final int c = 1;
        private static final int d = 2;
        private Handler a;

        public WorkThread(String str) {
            super(str, 10);
        }

        public Handler getWorkHandler() {
            if (this.a == null) {
                this.a = new Handler(getLooper(), this);
            }
            return this.a;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                DataInfo dataInfo = (DataInfo) message.obj;
                if (DataHandler.this.d == null) {
                    return false;
                }
                DataHandler.this.d.tryToAddSendData(dataInfo);
                return false;
            }
            if (i != 2) {
                return false;
            }
            DataInfo dataInfo2 = (DataInfo) message.obj;
            if (DataHandler.this.d == null || dataInfo2 == null) {
                return false;
            }
            DataHandler.this.d.tryToAddRecvData(dataInfo2);
            return false;
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            this.a = new Handler(getLooper(), this);
        }

        public void tryToAddRecvData(DataInfo dataInfo) {
            if (this.a == null) {
                this.a = new Handler(getLooper(), this);
            }
            Message messageObtainMessage = this.a.obtainMessage();
            messageObtainMessage.what = 2;
            messageObtainMessage.obj = dataInfo;
            this.a.sendMessage(messageObtainMessage);
        }

        public void tryToAddSendData(DataInfo dataInfo) {
            if (this.a == null) {
                this.a = new Handler(getLooper(), this);
            }
            Message messageObtainMessage = this.a.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = dataInfo;
            this.a.sendMessage(messageObtainMessage);
        }
    }

    public DataHandler(BluetoothOTAManager bluetoothOTAManager) {
        this.a = bluetoothOTAManager;
        a();
    }

    private void d() {
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.quitSafely();
            this.c = null;
        }
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void addRecvData(DataInfo dataInfo) {
        if (this.c == null) {
            a();
        }
        this.c.tryToAddRecvData(dataInfo);
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void addSendData(DataInfo dataInfo) {
        if (this.c == null) {
            a();
        }
        this.c.tryToAddSendData(dataInfo);
    }

    @Override // com.jieli.jl_bt_ota.tool.IDataHandler
    public void release() {
        JL_Log.e(e, "-release-");
        c();
    }

    private void b() {
        if (this.c == null) {
            this.c = new WorkThread("Work_Thread");
        }
        this.c.start();
    }

    private void c() {
        DataHandlerThread dataHandlerThread = this.d;
        if (dataHandlerThread != null) {
            dataHandlerThread.stopThread();
        }
        d();
    }

    private void a() {
        if (this.d == null) {
            DataHandlerThread dataHandlerThread = new DataHandlerThread();
            this.d = dataHandlerThread;
            dataHandlerThread.start();
            b();
        }
    }
}
