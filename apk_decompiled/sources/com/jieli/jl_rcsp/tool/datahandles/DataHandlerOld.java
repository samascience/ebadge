package com.jieli.jl_rcsp.tool.datahandles;

import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.jieli.jl_rcsp.interfaces.bluetooth.IBluetoothProxy;
import com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener;
import com.jieli.jl_rcsp.model.DataInfo;
import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.tool.DeviceStatusManager;
import com.jieli.jl_rcsp.tool.datahandles.DataHandlerOld;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.jieli.jl_rcsp.util.RcspUtil;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class DataHandlerOld implements DataHandler {
    public static final String g = "jl_rcsp";
    public final IBluetoothProxy a;
    public final Handler b;
    public WorkThread c;
    public DataHandlerThread d;
    public volatile byte[] e;
    public volatile int f = 0;

    public class DataHandlerThread extends Thread {
        public volatile boolean a;
        public volatile boolean b;
        public final List<DataInfo> c;
        public final LinkedBlockingQueue<DataInfo> d;
        public final List<DataInfo> e;
        public final List<DataInfo> f;
        public TimerThread g;

        public DataHandlerThread() {
            super("DataHandlerThread");
            this.c = Collections.synchronizedList(new ArrayList());
            this.d = new LinkedBlockingQueue<>();
            this.e = Collections.synchronizedList(new ArrayList());
            this.f = Collections.synchronizedList(new ArrayList());
        }

        public final DataInfo c(DataInfo dataInfo) {
            BasePacket basePacket = dataInfo.getBasePacket();
            if (basePacket == null) {
                return null;
            }
            for (DataInfo dataInfo2 : new ArrayList(this.f)) {
                BasePacket basePacket2 = dataInfo2.getBasePacket();
                if (basePacket2 != null && basePacket.getOpCode() == basePacket2.getOpCode() && basePacket.getOpCodeSn() == basePacket2.getOpCodeSn() && RcspUtil.deviceEquals(dataInfo.getDevice(), dataInfo2.getDevice())) {
                    return dataInfo2;
                }
            }
            return null;
        }

        public final void d() {
            b();
            DataInfo dataInfoE = e();
            if (dataInfoE != null) {
                f(dataInfoE);
            } else if (this.f.isEmpty() && this.e.isEmpty()) {
                f();
            } else {
                a(500);
            }
        }

        public final void e(DataInfo dataInfo) {
            BasePacket basePacket = dataInfo.getBasePacket();
            if (basePacket == null) {
                return;
            }
            if (basePacket.getHasResponse() == 1) {
                this.f.remove(dataInfo);
            } else {
                this.e.remove(dataInfo);
            }
            DataHandlerOld.this.a(dataInfo, new BaseError(12288).setOpCode(basePacket.getOpCode()));
        }

        public final void f() {
            TimerThread timerThread = this.g;
            if (timerThread == null || !timerThread.b) {
                return;
            }
            JL_Log.i("jl_rcsp", "stopTimer", Constants.STR_EMPTY);
            this.g.a();
        }

        public final void g() {
            if (this.b) {
                synchronized (this.d) {
                    this.d.notify();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (this.d) {
                while (this.a) {
                    if (this.d.isEmpty()) {
                        this.b = true;
                        d();
                        try {
                            this.d.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        this.b = false;
                        d(this.d.poll());
                        d();
                    }
                }
            }
            this.e.clear();
            this.f.clear();
            this.d.clear();
            this.a = false;
            f();
            DataHandlerOld.this.d = null;
            JL_Log.e("jl_rcsp", "DataHandlerThread", "exit");
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.a = true;
            super.start();
            JL_Log.i("jl_rcsp", "DataHandlerThread", "start");
        }

        public void stopThread() {
            JL_Log.w("jl_rcsp", "DataHandlerThread", "stopThread");
            this.a = false;
            g();
        }

        public void tryToAddRecvData(DataInfo dataInfo) {
            JL_Log.d("jl_rcsp", "tryToAddRecvData", a(dataInfo) + ", isWaiting : " + this.b);
        }

        public void tryToAddSendData(DataInfo dataInfo) {
            JL_Log.d("jl_rcsp", "tryToAddSendData", a(dataInfo) + ", isWaiting : " + this.b);
        }

        public final void b() {
            if (!this.c.isEmpty()) {
                JL_Log.d("jl_rcsp", "checkResponseListModify", "start --> size = " + this.c.size());
                ArrayList<DataInfo> arrayList = new ArrayList(this.c);
                this.c.clear();
                for (DataInfo dataInfo : arrayList) {
                    BasePacket basePacket = dataInfo.getBasePacket();
                    JL_Log.d("jl_rcsp", "checkResponseListModify", "Receive command --> " + dataInfo);
                    if (basePacket != null) {
                        if (basePacket.getType() == 1) {
                            DataHandlerOld.this.a.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                        } else {
                            DataInfo dataInfoC = c(dataInfo);
                            JL_Log.i("jl_rcsp", "checkResponseListModify", "Cache Command --> size = " + this.f.size() + "\t" + dataInfoC);
                            if (dataInfoC == null) {
                                JL_Log.w("jl_rcsp", "checkResponseListModify", "No cached command found.");
                            } else {
                                this.f.remove(dataInfoC);
                                CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(dataInfoC.getDevice(), basePacket);
                                if (commandBaseConvert2Command == null) {
                                    BaseError baseError = new BaseError(12289);
                                    baseError.setOpCode(basePacket.getOpCode());
                                    DataHandlerOld.this.a(dataInfoC, baseError);
                                } else {
                                    DataHandlerOld.this.a.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                                    DataHandlerOld.this.a(dataInfoC, commandBaseConvert2Command);
                                }
                                CommandHelper.getInstance().removeCommandBase(dataInfoC.getDevice(), basePacket);
                            }
                        }
                    }
                }
            }
            if (!this.f.isEmpty()) {
                for (DataInfo dataInfo2 : new ArrayList(this.f)) {
                    if (dataInfo2.isSend()) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - dataInfo2.getSendTime();
                        if (dataInfo2.getTimeoutMs() < 500) {
                            dataInfo2.setTimeoutMs(500);
                        }
                        if (jCurrentTimeMillis >= dataInfo2.getTimeoutMs()) {
                            if (dataInfo2.getReSendCount() > 3) {
                                JL_Log.e("jl_rcsp", "checkResponseListModify", "Command timeout --> " + dataInfo2);
                                b(dataInfo2);
                                this.f.remove(dataInfo2);
                            } else {
                                dataInfo2.setReSendCount(dataInfo2.getReSendCount() + 1);
                                dataInfo2.setSend(false);
                            }
                        }
                    }
                }
            }
            JL_Log.d("jl_rcsp", "checkResponseListModify", "end --> size = " + this.c.size());
        }

        public final void a(int i) {
            TimerThread timerThread = this.g;
            if (timerThread != null) {
                if (timerThread.b) {
                    return;
                }
                this.g.b = true;
            } else {
                TimerThread timerThread2 = DataHandlerOld.this.new TimerThread(i, new ThreadStateListener() { // from class: com.jieli.jl_rcsp.tool.datahandles.DataHandlerOld.DataHandlerThread.1
                    @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                    public void onFinish(long j) {
                        if (DataHandlerThread.this.g == null || DataHandlerThread.this.g.getId() != j) {
                            return;
                        }
                        DataHandlerThread.this.g = null;
                    }

                    @Override // com.jieli.jl_rcsp.interfaces.listener.ThreadStateListener
                    public void onStart(long j) {
                    }
                });
                this.g = timerThread2;
                timerThread2.start();
            }
        }

        public final void f(DataInfo dataInfo) {
            if (dataInfo == null) {
                return;
            }
            byte[] bArrPackSendBasePacket = ParseHelper.packSendBasePacket(dataInfo.getBasePacket());
            if (bArrPackSendBasePacket == null) {
                JL_Log.i("jl_rcsp", "sendData", "pack data error.");
                e(dataInfo);
                return;
            }
            JL_Log.v("jl_rcsp", "sendData", "[" + CHexConver.byte2HexStr(bArrPackSendBasePacket) + "]");
            if (bArrPackSendBasePacket.length > DataHandlerOld.b(dataInfo.getDevice()) + 8) {
                JL_Log.e("jl_rcsp", "sendData", "Data over communication mtu [" + DataHandlerOld.b(dataInfo.getDevice()) + "] limit.");
                e(dataInfo);
                return;
            }
            boolean zSendDataToDevice = false;
            for (int i = 0; i < 3 && !(zSendDataToDevice = DataHandlerOld.this.a.sendDataToDevice(dataInfo.getDevice(), bArrPackSendBasePacket)); i++) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            JL_Log.i("jl_rcsp", "sendData", Constants.STR_EMPTY + zSendDataToDevice);
            if (!zSendDataToDevice) {
                e(dataInfo);
            } else if (dataInfo.getBasePacket().getHasResponse() != 1) {
                DataHandlerOld.this.a(dataInfo, ParseHelper.convert2Command(dataInfo.getDevice(), dataInfo.getBasePacket()));
                this.e.remove(dataInfo);
            } else {
                dataInfo.setSend(true);
                dataInfo.setSendTime(Calendar.getInstance().getTimeInMillis());
            }
        }

        public final DataInfo e() {
            int i = 0;
            if (!this.e.isEmpty()) {
                while (i < this.e.size()) {
                    DataInfo dataInfo = this.e.get(i);
                    if (!dataInfo.isSend()) {
                        return dataInfo;
                    }
                    i++;
                }
            } else if (!this.f.isEmpty()) {
                while (i < this.f.size()) {
                    DataInfo dataInfo2 = this.f.get(i);
                    if (!dataInfo2.isSend()) {
                        return dataInfo2;
                    }
                    i++;
                }
            }
            return null;
        }

        public final ArrayList<DataInfo> c() {
            if (this.f.isEmpty()) {
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

        public final void d(DataInfo dataInfo) {
            if (dataInfo != null) {
                if (dataInfo.getType() == 1) {
                    ArrayList<BasePacket> arrayListFindPacketData = DataHandlerOld.this.findPacketData(dataInfo.getDevice(), dataInfo.getRecvData());
                    if (arrayListFindPacketData != null) {
                        ArrayList arrayList = new ArrayList();
                        for (BasePacket basePacket : arrayListFindPacketData) {
                            JL_Log.d("jl_rcsp", "handlerQueue", "opCode : " + basePacket.getOpCode());
                            arrayList.add(new DataInfo().setType(1).setDevice(dataInfo.getDevice()).setBasePacket(basePacket));
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        this.c.addAll(arrayList);
                        g();
                        return;
                    }
                    JL_Log.e("jl_rcsp", "handlerQueue", "findPacketData not found. ");
                    return;
                }
                if (dataInfo.getBasePacket() != null) {
                    if (dataInfo.getBasePacket().getHasResponse() == 1) {
                        if (this.f.size() < 30) {
                            this.f.add(dataInfo);
                            return;
                        } else {
                            JL_Log.i("jl_rcsp", "handlerQueue", "haveResponseDataList is busy. ");
                            DataHandlerOld.this.a.callbackErrorEvent(new BaseError(12291));
                            return;
                        }
                    }
                    if (this.e.size() < 60) {
                        this.e.add(dataInfo);
                    } else {
                        JL_Log.i("jl_rcsp", "handlerQueue", "noResponseDataList is busy. ");
                        DataHandlerOld.this.a.callbackErrorEvent(new BaseError(12291));
                    }
                }
            }
        }

        public final boolean a(DataInfo dataInfo) {
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
                g();
            }
            return zOffer;
        }

        @Deprecated
        public final void a() {
            ArrayList<DataInfo> arrayList = new ArrayList<>();
            if (!this.c.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (DataInfo dataInfo : new ArrayList(this.c)) {
                    BasePacket basePacket = dataInfo.getBasePacket();
                    if (basePacket != null) {
                        DataHandlerOld.this.a.receiveDataFromDevice(dataInfo.getDevice(), basePacket);
                        if (basePacket.getType() == 1) {
                            arrayList2.add(dataInfo);
                        } else {
                            arrayList.add(dataInfo);
                        }
                    } else {
                        arrayList3.add(dataInfo);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    this.c.removeAll(arrayList2);
                }
                if (!arrayList3.isEmpty()) {
                    this.c.removeAll(arrayList3);
                }
                a(arrayList);
                return;
            }
            a((ArrayList<DataInfo>) null);
        }

        @Deprecated
        public final void a(ArrayList<DataInfo> arrayList) {
            ArrayList<DataInfo> arrayList2;
            ArrayList<DataInfo> arrayListC;
            if (!this.f.isEmpty()) {
                ArrayList<DataInfo> arrayListC2 = c();
                StringBuilder sb = new StringBuilder();
                sb.append("waitList size : ");
                sb.append(arrayListC2 == null ? 0 : arrayListC2.size());
                JL_Log.i("jl_rcsp", "checkHaveResponseList", sb.toString());
                if (arrayListC2 == null || arrayListC2.isEmpty()) {
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                long jA = DataHandlerOld.this.a();
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<DataInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        DataInfo next = it.next();
                        final BasePacket basePacket = next.getBasePacket();
                        if (basePacket != null) {
                            JL_Log.d("jl_rcsp", "checkHaveResponseList", "opCode : " + basePacket.getOpCode() + ", sn : " + basePacket.getOpCodeSn() + ", device : " + next.getDevice());
                            for (Iterator<DataInfo> it2 = arrayListC2.iterator(); it2.hasNext(); it2 = it2) {
                                final DataInfo next2 = it2.next();
                                final BasePacket basePacket2 = next2.getBasePacket();
                                ArrayList<DataInfo> arrayList5 = arrayListC2;
                                if (basePacket2 != null) {
                                    JL_Log.i("jl_rcsp", "checkHaveResponseList", "packet opCode : " + basePacket2.getOpCode() + ", packet sn : " + basePacket2.getOpCodeSn());
                                }
                                if (basePacket2 != null && basePacket2.getOpCode() == basePacket.getOpCode() && basePacket2.getOpCodeSn() == basePacket.getOpCodeSn() && RcspUtil.deviceEquals(next2.getDevice(), next.getDevice())) {
                                    JL_Log.w("jl_rcsp", "checkHaveResponseList", "callback");
                                    DataHandlerOld.this.b.post(new Runnable() { // from class: com.jieli.jl_rcsp.tool.datahandles.a
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.a.a(next2, basePacket, basePacket2);
                                        }
                                    });
                                    arrayList3.add(next);
                                    arrayList4.add(next2);
                                    arrayListC2 = arrayList5;
                                    break;
                                }
                                if (next2.getTimeoutMs() < 500) {
                                    next2.setTimeoutMs(500);
                                }
                                Iterator<DataInfo> it3 = it;
                                if (jA - next2.getSendTime() > next2.getTimeoutMs()) {
                                    int reSendCount = next2.getReSendCount();
                                    JL_Log.e("jl_rcsp", "checkHaveResponseList", "wait for response timeout !!! reSend count : " + reSendCount + ", data : " + next2);
                                    if (reSendCount >= 3) {
                                        JL_Log.e("jl_rcsp", "checkHaveResponseList", "retry count over time, callbackTimeOutError.");
                                        b(next2);
                                        arrayList3.add(next);
                                        arrayList4.add(next2);
                                    } else {
                                        next2.setReSendCount(reSendCount + 1);
                                        next2.setSend(false);
                                    }
                                }
                                it = it3;
                                arrayListC2 = arrayList5;
                            }
                        }
                    }
                    arrayList2 = arrayListC2;
                    if (!arrayList3.isEmpty()) {
                        arrayList.removeAll(arrayList3);
                        this.c.removeAll(arrayList3);
                    }
                    if (!arrayList.isEmpty()) {
                        JL_Log.e("jl_rcsp", "checkHaveResponseList", "remove unused response.");
                        this.c.removeAll(arrayList);
                    }
                    if (!arrayList4.isEmpty()) {
                        this.f.removeAll(arrayList4);
                        arrayList4.clear();
                        arrayListC = c();
                    }
                    if (arrayListC != null || arrayListC.isEmpty()) {
                        return;
                    }
                    for (DataInfo dataInfo : arrayListC) {
                        if (dataInfo.getTimeoutMs() < 500) {
                            dataInfo.setTimeoutMs(500);
                        }
                        if (jA - dataInfo.getSendTime() > dataInfo.getTimeoutMs()) {
                            int reSendCount2 = dataInfo.getReSendCount();
                            JL_Log.e("jl_rcsp", "checkHaveResponseList", "wait for response timeout 222222 !!! reSend count : " + reSendCount2 + ", data : " + dataInfo);
                            if (reSendCount2 >= 3) {
                                JL_Log.e("jl_rcsp", "checkHaveResponseList", "retry count over time 222222, callbackTimeOutError.");
                                b(dataInfo);
                                arrayList4.add(dataInfo);
                            } else {
                                dataInfo.setReSendCount(reSendCount2 + 1);
                                dataInfo.setSend(false);
                            }
                        }
                    }
                    if (arrayList4.isEmpty()) {
                        return;
                    }
                    this.f.removeAll(arrayList4);
                    return;
                }
                arrayList2 = arrayListC2;
                arrayListC = arrayList2;
                if (arrayListC != null) {
                    return;
                } else {
                    return;
                }
            }
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            JL_Log.e("jl_rcsp", "checkHaveResponseList", "22222 remove unused response.");
            this.c.removeAll(arrayList);
        }

        public final void b(DataInfo dataInfo) {
            CommandHelper.getInstance().removeCommandBase(dataInfo.getDevice(), dataInfo.getBasePacket());
            BaseError baseError = new BaseError(12290);
            if (dataInfo.getBasePacket() != null) {
                baseError.setOpCode(dataInfo.getBasePacket().getOpCode());
            }
            DataHandlerOld.this.a(dataInfo, baseError);
        }

        public final /* synthetic */ void a(DataInfo dataInfo, BasePacket basePacket, BasePacket basePacket2) {
            CommandBase commandBaseConvert2Command = ParseHelper.convert2Command(dataInfo.getDevice(), basePacket);
            if (commandBaseConvert2Command != null) {
                DataHandlerOld.this.a(dataInfo, commandBaseConvert2Command);
            } else {
                BaseError baseError = new BaseError(12289);
                baseError.setOpCode(basePacket.getOpCode());
                DataHandlerOld.this.a(dataInfo, baseError);
            }
            CommandHelper.getInstance().removeCommandBase(dataInfo.getDevice(), basePacket2);
        }
    }

    public class TimerThread extends Thread {
        public final long a;
        public volatile boolean b;
        public final ThreadStateListener c;

        public TimerThread(long j, ThreadStateListener threadStateListener) {
            super("TimerThread");
            this.a = j;
            this.c = threadStateListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.b) {
                try {
                    Thread.sleep(this.a);
                    if (DataHandlerOld.this.d == null) {
                        break;
                    } else {
                        DataHandlerOld.this.d.g();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.b = false;
            JL_Log.w("jl_rcsp", "TimerThread", "end. thread id : " + getId());
            ThreadStateListener threadStateListener = this.c;
            if (threadStateListener != null) {
                threadStateListener.onFinish(getId());
            }
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            this.b = true;
            super.start();
            JL_Log.w("jl_rcsp", "TimerThread", "start. thread id : " + getId());
            ThreadStateListener threadStateListener = this.c;
            if (threadStateListener != null) {
                threadStateListener.onStart(getId());
            }
        }

        public synchronized void a() {
            this.b = false;
        }
    }

    public class WorkThread extends HandlerThread implements Handler.Callback {
        public static final int c = 1;
        public static final int d = 2;
        public Handler a;

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
            if (message == null) {
                return false;
            }
            int i = message.what;
            if (i == 1) {
                DataInfo dataInfo = (DataInfo) message.obj;
                if (DataHandlerOld.this.d != null) {
                    DataHandlerOld.this.d.tryToAddSendData(dataInfo);
                }
            } else if (i == 2) {
                DataInfo dataInfo2 = (DataInfo) message.obj;
                if (DataHandlerOld.this.d != null && dataInfo2 != null) {
                    DataHandlerOld.this.d.tryToAddRecvData(dataInfo2);
                }
            }
            return false;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
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

    public DataHandlerOld(IBluetoothProxy iBluetoothProxy) {
        if (iBluetoothProxy == null) {
            throw new NullPointerException("IBluetoothProxy can not be null.");
        }
        this.a = iBluetoothProxy;
        this.b = new Handler(Looper.getMainLooper());
        b();
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addRecvData(DataInfo dataInfo) {
        if (this.c == null) {
            b();
        }
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.tryToAddRecvData(dataInfo);
        }
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void addSendData(DataInfo dataInfo) {
        if (this.c == null) {
            b();
        }
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.tryToAddSendData(dataInfo);
        }
    }

    public final void e() {
        WorkThread workThread = this.c;
        if (workThread != null) {
            workThread.quitSafely();
            this.c = null;
        }
    }

    public ArrayList<BasePacket> findPacketData(BluetoothDevice bluetoothDevice, byte[] bArr) {
        ArrayList<BasePacket> arrayList;
        byte[] bArr2;
        if (bArr != null && bArr.length > 0) {
            int length = bArr.length;
            if (this.f > 0) {
                bArr2 = new byte[this.f + length];
                System.arraycopy(this.e, 0, bArr2, 0, this.f);
                System.arraycopy(bArr, 0, bArr2, this.f, length);
                length += this.f;
                this.f = 0;
            } else {
                bArr2 = (byte[]) bArr.clone();
            }
            arrayList = new ArrayList<>();
            int i = 0;
            int i2 = -1;
            while (i < length) {
                for (int i3 = i; i3 < length; i3++) {
                    if (bArr2[i3] == -2) {
                        int i4 = i3 + 1;
                        if (i4 >= length) {
                            a(bArr2, i3, length - i3);
                            break;
                        }
                        if (bArr2[i4] == -36) {
                            int i5 = i3 + 2;
                            if (i5 >= length) {
                                a(bArr2, i3, length - i3);
                                break;
                            }
                            if (bArr2[i5] == -70) {
                                int i6 = i3 + 3;
                                if (i6 >= length) {
                                    a(bArr2, i3, length - i3);
                                    break;
                                }
                                i2 = i6;
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (i2 <= 0) {
                    JL_Log.w("jl_rcsp", "findPacketData", "No header data found.");
                    break;
                }
                int i7 = i2 + 4;
                if (i7 <= length) {
                    byte[] bArr3 = new byte[2];
                    System.arraycopy(bArr2, i2 + 2, bArr3, 0, 2);
                    int iBytesToInt = CHexConver.bytesToInt(bArr3[0], bArr3[1]);
                    if (iBytesToInt > c(bluetoothDevice)) {
                        JL_Log.e("jl_rcsp", "findPacketData", RcspUtil.formatString("data length[%d] over MAX_RECEIVE_MTU[%d], cast away", Integer.valueOf(iBytesToInt), Integer.valueOf(c(bluetoothDevice))));
                        i += i2;
                    } else {
                        int i8 = i7 + iBytesToInt;
                        int i9 = i8 + 1;
                        if (i9 > length) {
                            int i10 = i2 - 3;
                            a(bArr2, i10, length - i10);
                        } else if (bArr2[i8] == -17) {
                            int i11 = iBytesToInt + 4;
                            byte[] bArr4 = new byte[i11];
                            System.arraycopy(bArr2, i2, bArr4, 0, i11);
                            BasePacket basePacketA = a(bluetoothDevice, bArr4);
                            if (basePacketA != null) {
                                arrayList.add(basePacketA);
                            }
                            if (i9 == length) {
                                break;
                            }
                            i2 = -1;
                            i = i9;
                        } else {
                            i++;
                        }
                    }
                } else {
                    int i12 = i2 - 3;
                    a(bArr2, i12, length - i12);
                }
                i = length;
            }
        } else {
            arrayList = null;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // com.jieli.jl_rcsp.tool.datahandles.DataHandler
    public void release() {
        JL_Log.i("jl_rcsp", "release", "=====>>>");
        CommandHelper.getInstance().release();
        d();
    }

    public final void b() {
        if (this.d == null) {
            DataHandlerThread dataHandlerThread = new DataHandlerThread();
            this.d = dataHandlerThread;
            dataHandlerThread.start();
            c();
        }
    }

    public final void c() {
        if (this.c == null) {
            this.c = new WorkThread("Work_Thread");
        }
        this.c.start();
    }

    public final void d() {
        DataHandlerThread dataHandlerThread = this.d;
        if (dataHandlerThread != null) {
            dataHandlerThread.stopThread();
        }
        e();
    }

    public static int c(BluetoothDevice bluetoothDevice) {
        return DeviceStatusManager.getInstance().getMaxReceiveMtu(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(BluetoothDevice bluetoothDevice) {
        return DeviceStatusManager.getInstance().getMaxCommunicationMtu(bluetoothDevice);
    }

    public final void a(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length <= 0 || i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            return;
        }
        this.e = new byte[i2];
        System.arraycopy(bArr, i, this.e, 0, i2);
        this.f = i2;
    }

    public final /* synthetic */ void b(DataInfo dataInfo, BaseError baseError) {
        if (dataInfo.getRcspCmdCallback() != null) {
            dataInfo.getRcspCmdCallback().onErrCode(dataInfo.getDevice(), baseError);
        }
        this.a.callbackErrorEvent(baseError);
    }

    public static BasePacket a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return null;
        }
        byte[] booleanArrayBig = CHexConver.getBooleanArrayBig(bArr[0]);
        int iByteToInt = CHexConver.byteToInt(bArr[1]);
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArr, 2, bArr2, 0, 2);
        int iBytesToInt = CHexConver.bytesToInt(bArr2[0], bArr2[1]);
        BasePacket basePacket = new BasePacket();
        int i = 7;
        int iByteToInt2 = CHexConver.byteToInt(booleanArrayBig[7]);
        int iByteToInt3 = CHexConver.byteToInt(booleanArrayBig[6]);
        basePacket.setType(iByteToInt2);
        basePacket.setHasResponse(iByteToInt3);
        basePacket.setOpCode(iByteToInt);
        basePacket.setParamLen(iBytesToInt);
        if (iBytesToInt <= 0) {
            return basePacket;
        }
        if (iByteToInt2 == 0) {
            byte[] bArr3 = new byte[1];
            System.arraycopy(bArr, 4, bArr3, 0, 1);
            basePacket.setStatus(CHexConver.byteToInt(bArr3[0]));
            byte[] bArr4 = new byte[1];
            System.arraycopy(bArr, 5, bArr4, 0, 1);
            basePacket.setOpCodeSn(CHexConver.byteToInt(bArr4[0]));
            if (iByteToInt == 1) {
                byte[] bArr5 = new byte[1];
                System.arraycopy(bArr, 6, bArr5, 0, 1);
                basePacket.setXmOpCode(CHexConver.byteToInt(bArr5[0]));
            } else {
                i = 6;
            }
        } else {
            byte[] bArr6 = new byte[1];
            System.arraycopy(bArr, 4, bArr6, 0, 1);
            basePacket.setOpCodeSn(CHexConver.byteToInt(bArr6[0]));
            if (iByteToInt == 1) {
                byte[] bArr7 = new byte[1];
                System.arraycopy(bArr, 5, bArr7, 0, 1);
                basePacket.setXmOpCode(CHexConver.byteToInt(bArr7[0]));
                i = 6;
            } else {
                i = 5;
            }
        }
        int i2 = iBytesToInt - (i - 4);
        byte[] bArr8 = new byte[i2];
        System.arraycopy(bArr, i, bArr8, 0, i2);
        basePacket.setParamData(bArr8);
        JL_Log.d("jl_rcsp", "parsePacketData", RcspUtil.formatString("packet type : %d, opCode : %d, sn :%d, device : %s", Integer.valueOf(basePacket.getType()), Integer.valueOf(basePacket.getOpCode()), Integer.valueOf(basePacket.getOpCodeSn()), bluetoothDevice));
        return basePacket;
    }

    public static /* synthetic */ void b(DataInfo dataInfo, CommandBase commandBase) {
        if (dataInfo.getRcspCmdCallback() != null) {
            dataInfo.getRcspCmdCallback().onCommandResponse(dataInfo.getDevice(), commandBase);
        }
    }

    public final long a() {
        return Calendar.getInstance().getTimeInMillis();
    }

    public final void a(final DataInfo dataInfo, final BaseError baseError) {
        if (dataInfo == null || baseError == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: k60
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(dataInfo, baseError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final DataInfo dataInfo, final CommandBase commandBase) {
        if (dataInfo == null) {
            return;
        }
        this.b.post(new Runnable() { // from class: l60
            @Override // java.lang.Runnable
            public final void run() {
                DataHandlerOld.b(dataInfo, commandBase);
            }
        });
    }
}
