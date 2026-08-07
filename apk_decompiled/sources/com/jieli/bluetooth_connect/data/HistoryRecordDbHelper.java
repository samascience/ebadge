package com.jieli.bluetooth_connect.data;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.jieli.bluetooth_connect.bean.BluetoothOption;
import com.jieli.bluetooth_connect.bean.history.HistoryRecord;
import com.jieli.bluetooth_connect.data.dao.HistoryRecordDao;
import com.jieli.bluetooth_connect.util.BluetoothUtil;
import com.jieli.bluetooth_connect.util.ConnectUtil;
import com.jieli.bluetooth_connect.util.JL_Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class HistoryRecordDbHelper {
    private final BtConnectDatabase mBtConnectDatabase;
    private final Context mContext;
    private final HistoryRecordObserver mObserver;
    private final ExecutorService mThreadPool = Executors.newSingleThreadExecutor();

    public HistoryRecordDbHelper(Context context, BluetoothOption bluetoothOption, HistoryRecordObserver historyRecordObserver) {
        if (context == null) {
            throw new NullPointerException("Please call initDb method at first!");
        }
        this.mContext = context;
        this.mBtConnectDatabase = BtConnectDatabase.buildDatabase(context);
        this.mObserver = historyRecordObserver;
        syncSystemDeviceList(bluetoothOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearAllHistoryRecord$4() {
        clearHistoryRecords(getHistoryRecordList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveHistoryRecord$0(BluetoothDevice bluetoothDevice, int i) {
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        boolean z = historyRecordByDevice == null;
        if (z) {
            historyRecordByDevice = new HistoryRecord();
        } else if (bluetoothDevice.getAddress().equals(historyRecordByDevice.getUpdateAddress())) {
            return;
        }
        historyRecordByDevice.setName(bluetoothDevice.getName());
        historyRecordByDevice.setAddress(bluetoothDevice.getAddress());
        historyRecordByDevice.setDevType(bluetoothDevice.getType());
        historyRecordByDevice.setConnectType(i);
        historyRecordByDevice.setOnlineTime(System.currentTimeMillis());
        JL_Log.d("HistoryRecordDbHelper", "saveHistoryRecord", ConnectUtil.formatString("device : %s, connectWay : %d, isAddRecord = %s", BluetoothUtil.printBtDeviceInfo(this.mContext, bluetoothDevice), Integer.valueOf(i), Boolean.valueOf(z)));
        if (z) {
            saveHistoryRecord(historyRecordByDevice);
        } else {
            updateHistoryRecord(historyRecordByDevice);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDeviceIDs$1(BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        if (historyRecordByDevice == null) {
            return;
        }
        historyRecordByDevice.setVid(i);
        historyRecordByDevice.setUid(i2);
        historyRecordByDevice.setPid(i3);
        updateHistoryRecord(historyRecordByDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateDeviceInfo$2(BluetoothDevice bluetoothDevice, int i, String str) {
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        if (historyRecordByDevice == null) {
            return;
        }
        historyRecordByDevice.setSdkFlag(i);
        historyRecordByDevice.setMappedAddress(str);
        updateHistoryRecord(historyRecordByDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateGpsInfo$3(BluetoothDevice bluetoothDevice, double d, double d2, int i, long j) {
        HistoryRecord historyRecordByDevice = getHistoryRecordByDevice(bluetoothDevice);
        if (historyRecordByDevice != null) {
            if (d == 0.0d && d2 == 0.0d) {
                return;
            }
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                if (d == historyRecordByDevice.getRightDevLatitude() && d2 == historyRecordByDevice.getRightDevLongitude() && j <= historyRecordByDevice.getRightDevUpdateTime()) {
                    return;
                } else {
                    historyRecordByDevice.updateRightDevGpsInfo(d, d2, j);
                }
            } else if (d == historyRecordByDevice.getLeftDevLatitude() && d2 == historyRecordByDevice.getLeftDevLongitude() && j <= historyRecordByDevice.getLeftDevUpdateTime()) {
                return;
            } else {
                historyRecordByDevice.updateLeftDevGpsInfo(d, d2, j);
            }
            updateHistoryRecord(historyRecordByDevice);
        }
    }

    public void clearAllHistoryRecord() {
        if (this.mThreadPool.isShutdown()) {
            return;
        }
        this.mThreadPool.submit(new Runnable() { // from class: xw0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$clearAllHistoryRecord$4();
            }
        });
    }

    public void clearHistoryRecords(List<HistoryRecord> list) {
        if (list == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().removeHistoryRecords(list);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onDelete(null);
        }
    }

    public void deleteHistoryRecord(HistoryRecord historyRecord) {
        if (historyRecord == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().removeHistoryRecord(historyRecord);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onDelete(historyRecord);
        }
    }

    public void destroy() {
        if (this.mThreadPool.isShutdown()) {
            return;
        }
        this.mThreadPool.shutdownNow();
    }

    public HistoryRecord getHistoryRecordByDevice(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return null;
        }
        return getHistoryRecordByMac(bluetoothDevice.getAddress());
    }

    public HistoryRecord getHistoryRecordByMac(String str) {
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            return getHistoryRecordDao().getHistoryRecord(str);
        }
        return null;
    }

    public HistoryRecordDao getHistoryRecordDao() {
        return this.mBtConnectDatabase.historyRecordDao();
    }

    public List<HistoryRecord> getHistoryRecordList() {
        return getHistoryRecordDao().getHistoryRecordList();
    }

    public String getMappedAddress(String str) {
        HistoryRecord historyRecordByMac = getHistoryRecordByMac(str);
        if (historyRecordByMac == null) {
            return null;
        }
        return str.equals(historyRecordByMac.getAddress()) ? historyRecordByMac.getMappedAddress() : historyRecordByMac.getAddress();
    }

    public boolean isMatchDevice(String str, String str2) {
        if (!BluetoothAdapter.checkBluetoothAddress(str) || !BluetoothAdapter.checkBluetoothAddress(str2)) {
            return false;
        }
        boolean zEquals = str.equals(str2);
        if (zEquals) {
            return zEquals;
        }
        String mappedAddress = getMappedAddress(str);
        if (BluetoothAdapter.checkBluetoothAddress(mappedAddress)) {
            zEquals = mappedAddress.equals(str2);
        }
        if (zEquals) {
            return zEquals;
        }
        String mappedAddress2 = getMappedAddress(str2);
        return BluetoothAdapter.checkBluetoothAddress(mappedAddress2) ? mappedAddress2.equals(str) : zEquals;
    }

    public void saveHistoryRecord(HistoryRecord historyRecord) {
        if (historyRecord == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().addHistoryRecord(historyRecord);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onInsert(historyRecord);
        }
    }

    public void syncSystemDeviceList(BluetoothOption bluetoothOption) {
        List<HistoryRecord> historyRecordList;
        if ((bluetoothOption == null || !bluetoothOption.isNotAssociatedEDR()) && BluetoothUtil.isBluetoothEnable() && (historyRecordList = getHistoryRecordList()) != null) {
            List<BluetoothDevice> pairedDevices = BluetoothUtil.getPairedDevices(this.mContext);
            ArrayList arrayList = new ArrayList();
            for (HistoryRecord historyRecord : historyRecordList) {
                if (historyRecord.getConnectType() != 0 && historyRecord.getMappedAddress() != null) {
                    if (pairedDevices != null) {
                        Iterator<BluetoothDevice> it = pairedDevices.iterator();
                        while (it.hasNext()) {
                            if (isMatchDevice(historyRecord.getAddress(), it.next().getAddress())) {
                                historyRecord = null;
                                break;
                            }
                        }
                    }
                    if (historyRecord != null) {
                        arrayList.add(historyRecord);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            clearHistoryRecords(arrayList);
        }
    }

    public void updateDeviceIDs(final BluetoothDevice bluetoothDevice, final int i, final int i2, final int i3) {
        if (bluetoothDevice == null || this.mThreadPool.isShutdown()) {
            return;
        }
        this.mThreadPool.submit(new Runnable() { // from class: yw0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$updateDeviceIDs$1(bluetoothDevice, i, i2, i3);
            }
        });
    }

    public void updateDeviceInfo(final BluetoothDevice bluetoothDevice, final int i, final String str) {
        if (bluetoothDevice == null || this.mThreadPool.isShutdown()) {
            return;
        }
        this.mThreadPool.submit(new Runnable() { // from class: ax0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$updateDeviceInfo$2(bluetoothDevice, i, str);
            }
        });
    }

    public void updateGpsInfo(final BluetoothDevice bluetoothDevice, final int i, final double d, final double d2, final long j) {
        if (bluetoothDevice == null || this.mThreadPool.isShutdown()) {
            return;
        }
        this.mThreadPool.submit(new Runnable() { // from class: bx0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$updateGpsInfo$3(bluetoothDevice, d, d2, i, j);
            }
        });
    }

    public void updateHistoryRecord(HistoryRecord historyRecord) {
        if (historyRecord == null) {
            return;
        }
        this.mBtConnectDatabase.historyRecordDao().updateHistoryRecord(historyRecord);
        HistoryRecordObserver historyRecordObserver = this.mObserver;
        if (historyRecordObserver != null) {
            historyRecordObserver.onModify(historyRecord);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void saveHistoryRecord(final BluetoothDevice bluetoothDevice, final int i) {
        if (bluetoothDevice == null || this.mThreadPool.isShutdown() || !ConnectUtil.isHasConnectPermission(this.mContext)) {
            return;
        }
        this.mThreadPool.submit(new Runnable() { // from class: zw0
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$saveHistoryRecord$0(bluetoothDevice, i);
            }
        });
    }
}
