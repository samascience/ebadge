package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.util.Log;
import defpackage.oc1;
import defpackage.vs0;
import defpackage.xr1;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.SizeValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"MissingPermission"})
public abstract class DfuBaseService extends IntentService implements DfuProgressInfo.ProgressListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ACTION_ABORT = 2;
    public static final int ACTION_PAUSE = 0;
    public static final int ACTION_RESUME = 1;
    public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
    public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
    public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
    public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
    static boolean DEBUG = false;
    public static final int ERROR_BLUETOOTH_DISABLED = 4106;
    public static final int ERROR_CONNECTION_MASK = 16384;
    public static final int ERROR_CONNECTION_STATE_MASK = 32768;
    public static final int ERROR_CRC_ERROR = 4109;
    public static final int ERROR_DEVICE_DISCONNECTED = 4096;
    public static final int ERROR_DEVICE_NOT_BONDED = 4110;
    public static final int ERROR_FILE_ERROR = 4098;
    public static final int ERROR_FILE_INVALID = 4099;
    public static final int ERROR_FILE_IO_EXCEPTION = 4100;
    public static final int ERROR_FILE_NOT_FOUND = 4097;
    public static final int ERROR_FILE_SIZE_INVALID = 4108;
    public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
    public static final int ERROR_INIT_PACKET_REQUIRED = 4107;
    public static final int ERROR_INVALID_RESPONSE = 4104;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_PROGRESS_LOST = 4111;
    public static final int ERROR_REMOTE_MASK = 8192;
    public static final int ERROR_REMOTE_TYPE_LEGACY = 256;
    public static final int ERROR_REMOTE_TYPE_SECURE = 512;
    public static final int ERROR_REMOTE_TYPE_SECURE_BUTTONLESS = 2048;
    public static final int ERROR_REMOTE_TYPE_SECURE_EXTENDED = 1024;
    public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
    public static final int ERROR_SERVICE_NOT_FOUND = 4102;
    public static final int ERROR_TYPE_COMMUNICATION = 2;
    public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
    public static final int ERROR_TYPE_DFU_REMOTE = 3;
    public static final int ERROR_TYPE_OTHER = 0;
    public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
    public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
    public static final String EXTRA_CURRENT_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU";
    public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
    public static final String EXTRA_DATA_OBJECT_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_DATA_OBJECT_DELAY";
    public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
    static final String EXTRA_DFU_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT";
    public static final String EXTRA_DISABLE_NOTIFICATION = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
    public static final String EXTRA_DISABLE_RESUME = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME";
    public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
    public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
    public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
    public static final String EXTRA_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
    public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
    public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
    public static final String EXTRA_FORCE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU";
    public static final String EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU";
    public static final String EXTRA_FOREGROUND_SERVICE = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE";
    public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
    public static final String EXTRA_INIT_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
    public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
    public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
    public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
    public static final String EXTRA_MAX_DFU_ATTEMPTS = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS";
    public static final String EXTRA_MBR_SIZE = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE";
    public static final String EXTRA_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_MTU";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE";
    public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
    public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
    public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
    private static final String EXTRA_RECONNECTION_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT";
    public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
    public static final String EXTRA_SCAN_DELAY = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_DELAY";
    public static final String EXTRA_SCAN_TIMEOUT = "no.nordicsemi.android.dfu.extra.EXTRA_SCAN_TIMEOUT";
    public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
    public static final String EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final int LOG_LEVEL_APPLICATION = 10;
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 20;
    public static final int LOG_LEVEL_INFO = 5;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 15;
    public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_ZIP = "application/zip";
    public static final String NOTIFICATION_CHANNEL_DFU = "dfu";
    public static final int NOTIFICATION_ID = 283;
    public static final int PROGRESS_ABORTED = -7;
    public static final int PROGRESS_COMPLETED = -6;
    public static final int PROGRESS_CONNECTING = -1;
    public static final int PROGRESS_DISCONNECTING = -5;
    public static final int PROGRESS_ENABLING_DFU_MODE = -3;
    public static final int PROGRESS_STARTING = -2;
    public static final int PROGRESS_VALIDATING = -4;
    protected static final int STATE_CLOSED = -5;
    protected static final int STATE_CONNECTED = -2;
    protected static final int STATE_CONNECTED_AND_READY = -3;
    protected static final int STATE_CONNECTING = -1;
    protected static final int STATE_DISCONNECTED = 0;
    protected static final int STATE_DISCONNECTING = -4;
    private static final String TAG = "DfuBaseService";
    public static final int TYPE_APPLICATION = 4;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_BOOTLOADER = 2;
    public static final int TYPE_SOFT_DEVICE = 1;
    private boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothStateBroadcastReceiver;
    private final BroadcastReceiver mBondStateBroadcastReceiver;
    protected int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver;
    private String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver;
    private DfuCallback mDfuServiceImpl;
    private boolean mDisableNotification;
    private int mError;
    private InputStream mFirmwareInputStream;
    private final BluetoothGattCallback mGattCallback;
    private InputStream mInitFileInputStream;
    private long mLastNotificationTime;
    private int mLastProgress;
    private final Object mLock;
    DfuProgressInfo mProgressInfo;

    public DfuBaseService() {
        super(TAG);
        this.mLock = new Object();
        this.mLastProgress = -1;
        this.mDfuActionReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_ACTION, 0);
                DfuBaseService.this.logi("User action received: " + intExtra);
                if (intExtra == 0) {
                    DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Pause action received");
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.pause();
                        return;
                    }
                    return;
                }
                if (intExtra == 1) {
                    DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Resume action received");
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.resume();
                        return;
                    }
                    return;
                }
                if (intExtra != 2) {
                    return;
                }
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Abort action received");
                DfuBaseService.this.mAborted = true;
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.abort();
                }
            }
        };
        this.mBluetoothStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
                DfuBaseService.this.logw("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: " + intExtra + ", previous state: " + intExtra2 + "]");
                if (intExtra2 == 12) {
                    if (intExtra == 13 || intExtra == 10) {
                        DfuBaseService.this.sendLogBroadcast(15, "Bluetooth adapter disabled");
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        dfuBaseService.mConnectionState = 0;
                        if (dfuBaseService.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                        synchronized (DfuBaseService.this.mLock) {
                            DfuBaseService.this.mLock.notifyAll();
                        }
                    }
                }
            }
        };
        this.mBondStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra;
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null || !bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress) || (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) == 11 || DfuBaseService.this.mDfuServiceImpl == null) {
                    return;
                }
                DfuBaseService.this.mDfuServiceImpl.onBondStateChanged(intExtra);
            }
        };
        this.mConnectionStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null || !bluetoothDevice.getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                    return;
                }
                String action = intent.getAction();
                DfuBaseService.this.logi("Action received: " + action);
                DfuBaseService.this.sendLogBroadcast(0, "[Broadcast] Action received: " + action);
            }
        };
        this.mGattCallback = new BluetoothGattCallback() { // from class: no.nordicsemi.android.dfu.DfuBaseService.5
            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                if (i != 0) {
                    if (i == 8 || i == 19) {
                        DfuBaseService.this.logw("Target device disconnected with status: " + i);
                    } else {
                        DfuBaseService.this.loge("Connection state change error: " + i + " newState: " + i2);
                    }
                    DfuBaseService.this.mError = i | 32768;
                    if (i2 == 0) {
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        dfuBaseService.mConnectionState = 0;
                        if (dfuBaseService.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                    }
                } else if (i2 == 2) {
                    DfuBaseService.this.logi("Connected to GATT server");
                    DfuBaseService.this.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                    DfuBaseService.this.mConnectionState = -2;
                    if (bluetoothGatt.getDevice().getBondState() == 12) {
                        DfuBaseService.this.logi("Waiting 1600 ms for a possible Service Changed indication...");
                        DfuBaseService.this.waitFor(1600L);
                    }
                    DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                    DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                    boolean zDiscoverServices = bluetoothGatt.discoverServices();
                    DfuBaseService dfuBaseService2 = DfuBaseService.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to start service discovery... ");
                    sb.append(zDiscoverServices ? "succeed" : "failed");
                    dfuBaseService2.logi(sb.toString());
                    if (zDiscoverServices) {
                        return;
                    } else {
                        DfuBaseService.this.mError = DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
                    }
                } else if (i2 == 0) {
                    DfuBaseService.this.logi("Disconnected from GATT server");
                    DfuBaseService dfuBaseService3 = DfuBaseService.this;
                    dfuBaseService3.mConnectionState = 0;
                    if (dfuBaseService3.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                    }
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onMtuChanged(bluetoothGatt, i, i2);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onPhyUpdate(bluetoothGatt, i, i2, i3);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                if (i == 0) {
                    DfuBaseService.this.logi("Services discovered");
                    DfuBaseService.this.mConnectionState = -3;
                } else {
                    DfuBaseService.this.loge("Service discovery error: " + i);
                    DfuBaseService.this.mError = i | 16384;
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }
        };
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        loge("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loge(String str) {
        Log.e(TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logi(String str) {
        if (DEBUG) {
            Log.i(TAG, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logw(String str) {
        if (DEBUG) {
            Log.w(TAG, str);
        }
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        return intentFilter;
    }

    private InputStream openInputStream(String str, String str2, int i, int i2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        if (MIME_TYPE_ZIP.equals(str2)) {
            return new ArchiveInputStream(fileInputStream, i, i2);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream(fileInputStream, i) : fileInputStream;
    }

    private void report(int i) {
        sendErrorBroadcast(i);
        if (this.mDisableNotification) {
            return;
        }
        String str = this.mDeviceAddress;
        String string = this.mDeviceName;
        if (string == null) {
            string = getString(R.string.dfu_unknown_name);
        }
        xr1.d dVarE = new xr1.d(this, NOTIFICATION_CHANNEL_DFU).q(android.R.drawable.stat_sys_upload).n(true).g(Opcodes.V_PREVIEW).m(false).j(getString(R.string.dfu_status_error)).q(android.R.drawable.stat_sys_upload_done).i(getString(R.string.dfu_status_error_msg)).e(true);
        Intent intent = new Intent(this, getNotificationTarget());
        intent.addFlags(268435456);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
        intent.putExtra(EXTRA_DEVICE_NAME, string);
        intent.putExtra(EXTRA_PROGRESS, i);
        dVarE.h(PendingIntent.getActivity(this, 0, intent, 201326592));
        updateErrorNotification(dVarE);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, dVarE.b());
        }
    }

    private void sendErrorBroadcast(int i) {
        Intent intent = new Intent(BROADCAST_ERROR);
        if ((i & 16384) > 0) {
            intent.putExtra(EXTRA_DATA, i & (-16385));
            intent.putExtra(EXTRA_ERROR_TYPE, 2);
        } else if ((32768 & i) > 0) {
            intent.putExtra(EXTRA_DATA, i & (-32769));
            intent.putExtra(EXTRA_ERROR_TYPE, 1);
        } else if ((i & 8192) > 0) {
            intent.putExtra(EXTRA_DATA, i & (-8193));
            intent.putExtra(EXTRA_ERROR_TYPE, 3);
        } else {
            intent.putExtra(EXTRA_DATA, i);
            intent.putExtra(EXTRA_ERROR_TYPE, 0);
        }
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        oc1.b(this).d(intent);
    }

    private void sendProgressBroadcast(DfuProgressInfo dfuProgressInfo) {
        Intent intent = new Intent(BROADCAST_PROGRESS);
        intent.putExtra(EXTRA_DATA, dfuProgressInfo.getProgress());
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        intent.putExtra(EXTRA_PART_CURRENT, dfuProgressInfo.getCurrentPart());
        intent.putExtra(EXTRA_PARTS_TOTAL, dfuProgressInfo.getTotalParts());
        intent.putExtra(EXTRA_SPEED_B_PER_MS, dfuProgressInfo.getSpeed());
        intent.putExtra(EXTRA_AVG_SPEED_B_PER_MS, dfuProgressInfo.getAverageSpeed());
        oc1.b(this).d(intent);
    }

    private void startForeground() {
        xr1.d dVarM = new xr1.d(this, NOTIFICATION_CHANNEL_DFU).q(android.R.drawable.stat_sys_upload).j(getString(R.string.dfu_status_foreground_title)).i(getString(R.string.dfu_status_foreground_content)).g(-7829368).o(-1).m(true);
        Class<? extends Activity> notificationTarget = getNotificationTarget();
        if (notificationTarget != null) {
            Intent intent = new Intent(this, notificationTarget);
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
            intent.putExtra(EXTRA_DEVICE_NAME, this.mDeviceName);
            dVarM.h(PendingIntent.getActivity(this, 0, intent, 201326592));
        } else {
            logw("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        updateForegroundNotification(dVarM);
        startForeground(NOTIFICATION_ID, dVarM.b());
    }

    protected void close(BluetoothGatt bluetoothGatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        sendLogBroadcast(0, "gatt.close()");
        bluetoothGatt.close();
        this.mConnectionState = -5;
    }

    protected BluetoothGatt connect(String str) {
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(str);
        sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, preferredPhy = LE_1M | LE_2M)");
        BluetoothGatt bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2, 3);
        try {
            synchronized (this.mLock) {
                while (true) {
                    try {
                        int i = this.mConnectionState;
                        if ((i != -1 && i != -2) || this.mError != 0 || this.mAborted) {
                            break;
                        }
                        this.mLock.wait();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return bluetoothGattConnectGatt;
    }

    protected void disconnect(BluetoothGatt bluetoothGatt) {
        if (this.mConnectionState == 0) {
            return;
        }
        sendLogBroadcast(1, "Disconnecting...");
        this.mProgressInfo.setProgress(-5);
        this.mConnectionState = -4;
        logi("Disconnecting from the device...");
        sendLogBroadcast(0, "gatt.disconnect()");
        bluetoothGatt.disconnect();
        waitUntilDisconnected();
        sendLogBroadcast(5, "Disconnected");
    }

    protected DfuDeviceSelector getDeviceSelector() {
        return new DfuDefaultDeviceSelector();
    }

    protected abstract Class<? extends Activity> getNotificationTarget();

    protected boolean isDebug() {
        return false;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DEBUG = isDebug();
        logi("DFU service created. Version: 2.2.2");
        initialize();
        oc1 oc1VarB = oc1.b(this);
        IntentFilter intentFilterMakeDfuActionIntentFilter = makeDfuActionIntentFilter();
        oc1VarB.c(this.mDfuActionReceiver, intentFilterMakeDfuActionIntentFilter);
        registerReceiver(this.mDfuActionReceiver, intentFilterMakeDfuActionIntentFilter);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        registerReceiver(this.mConnectionStateBroadcastReceiver, intentFilter);
        registerReceiver(this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DfuCallback dfuCallback = this.mDfuServiceImpl;
        if (dfuCallback != null) {
            dfuCallback.abort();
        }
        oc1.b(this).e(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        try {
            InputStream inputStream = this.mFirmwareInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            InputStream inputStream2 = this.mInitFileInputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (IOException unused) {
        } finally {
            this.mFirmwareInputStream = null;
            this.mInitFileInputStream = null;
        }
        logi("DFU service destroyed");
    }

    /* JADX WARN: Code duplicated, block: B:136:0x021f A[Catch: all -> 0x0137, Exception -> 0x013b, IOException -> 0x0141, SizeValidationException -> 0x0147, FileNotFoundException -> 0x014d, SecurityException -> 0x0153, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0228 A[Catch: all -> 0x0137, Exception -> 0x013b, IOException -> 0x0141, SizeValidationException -> 0x0147, FileNotFoundException -> 0x014d, SecurityException -> 0x0153, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0247 A[Catch: all -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0256  */
    /* JADX WARN: Code duplicated, block: B:147:0x025a A[Catch: all -> 0x0137, TRY_ENTER, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0276 A[Catch: all -> 0x0137, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0287  */
    /* JADX WARN: Code duplicated, block: B:153:0x028b A[Catch: all -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0297  */
    /* JADX WARN: Code duplicated, block: B:158:0x029d  */
    /* JADX WARN: Code duplicated, block: B:164:0x02e7 A[Catch: all -> 0x0137, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0314 A[Catch: all -> 0x0137, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x035f A[Catch: all -> 0x0137, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:171:0x036a A[Catch: all -> 0x0137, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x038b  */
    /* JADX WARN: Code duplicated, block: B:176:0x038f A[Catch: all -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0396  */
    /* JADX WARN: Code duplicated, block: B:180:0x039a  */
    /* JADX WARN: Code duplicated, block: B:183:0x03a0 A[Catch: all -> 0x0137, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:187:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:190:0x03b8 A[Catch: all -> 0x0137, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:194:0x03d0 A[Catch: all -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x03ff A[Catch: all -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x0404  */
    /* JADX WARN: Code duplicated, block: B:214:0x041c  */
    /* JADX WARN: Code duplicated, block: B:217:0x0428 A[Catch: all -> 0x0408, UploadAbortedException -> 0x0419, DfuException -> 0x042c, DeviceDisconnectedException -> 0x042f, TRY_LEAVE, TryCatch #24 {UploadAbortedException -> 0x0419, all -> 0x0408, blocks: (B:197:0x03e6, B:199:0x03ea, B:215:0x0422, B:217:0x0428), top: B:306:0x03e6 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0454 A[Catch: all -> 0x0440, TryCatch #0 {all -> 0x0440, blocks: (B:196:0x03db, B:235:0x044c, B:237:0x0454, B:239:0x0487, B:238:0x046e, B:243:0x049c, B:245:0x04ba, B:252:0x04fa, B:255:0x0500), top: B:302:0x03db }] */
    /* JADX WARN: Code duplicated, block: B:238:0x046e A[Catch: all -> 0x0440, TryCatch #0 {all -> 0x0440, blocks: (B:196:0x03db, B:235:0x044c, B:237:0x0454, B:239:0x0487, B:238:0x046e, B:243:0x049c, B:245:0x04ba, B:252:0x04fa, B:255:0x0500), top: B:302:0x03db }] */
    /* JADX WARN: Code duplicated, block: B:241:0x0497 A[Catch: all -> 0x0137, PHI: r2
      0x0497: PHI (r2v63 no.nordicsemi.android.dfu.DfuService) = 
      (r2v60 no.nordicsemi.android.dfu.DfuService)
      (r2v62 no.nordicsemi.android.dfu.DfuService)
      (r2v64 no.nordicsemi.android.dfu.DfuService)
     binds: [B:256:0x0512, B:240:0x0495, B:254:0x04ff] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x04ba A[Catch: all -> 0x0440, TRY_LEAVE, TryCatch #0 {all -> 0x0440, blocks: (B:196:0x03db, B:235:0x044c, B:237:0x0454, B:239:0x0487, B:238:0x046e, B:243:0x049c, B:245:0x04ba, B:252:0x04fa, B:255:0x0500), top: B:302:0x03db }] */
    /* JADX WARN: Code duplicated, block: B:247:0x04ef A[Catch: all -> 0x0137, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x0137, blocks: (B:65:0x0128, B:67:0x0132, B:86:0x016b, B:91:0x018a, B:97:0x01a0, B:99:0x01a6, B:101:0x01ab, B:103:0x01b4, B:105:0x01b8, B:108:0x01c1, B:109:0x01c8, B:110:0x01c9, B:112:0x01cd, B:115:0x01d6, B:116:0x01dd, B:117:0x01de, B:119:0x01e2, B:122:0x01ec, B:123:0x01f3, B:125:0x01f6, B:127:0x01fc, B:136:0x021f, B:138:0x0228, B:139:0x022f, B:140:0x0239, B:143:0x0247, B:147:0x025a, B:149:0x0276, B:153:0x028b, B:159:0x029f, B:161:0x02bf, B:163:0x02c6, B:167:0x0342, B:169:0x035f, B:171:0x036a, B:172:0x036d, B:176:0x038f, B:164:0x02e7, B:166:0x0314, B:181:0x039c, B:183:0x03a0, B:188:0x03b4, B:190:0x03b8, B:194:0x03d0, B:201:0x03ff, B:223:0x0434, B:241:0x0497, B:247:0x04ef, B:262:0x051d, B:263:0x0520, B:129:0x0208, B:131:0x020e, B:102:0x01b0, B:274:0x053b, B:278:0x0563, B:282:0x058b, B:286:0x05a0, B:290:0x05b5, B:94:0x0194, B:95:0x019b, B:88:0x0176, B:90:0x0180, B:81:0x015b, B:83:0x0162), top: B:305:0x0126 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:251:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:254:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:259:0x0517  */
    /* JADX WARN: Code duplicated, block: B:276:0x055f  */
    /* JADX WARN: Code duplicated, block: B:280:0x0587  */
    /* JADX WARN: Code duplicated, block: B:284:0x059c  */
    /* JADX WARN: Code duplicated, block: B:288:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:292:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:307:0x03ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:316:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:318:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:319:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:320:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:321:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:322:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:323:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:324:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:326:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:329:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:330:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0114 A[PHI: r20
      0x0114: PHI (r20v2 java.lang.String) = (r20v1 java.lang.String), (r20v4 java.lang.String) binds: [B:58:0x0112, B:54:0x0105] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to calculate best type for var: r23v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r23v0 'this'  ??, new type: no.nordicsemi.android.dfu.DfuBaseService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v29 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v29 ??, new type: android.content.Intent
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v29 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v29 ??, new type: android.content.Intent
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r23v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r23v0 'this'  ??, new type: no.nordicsemi.android.dfu.DfuBaseService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Instruction removed from duplicated block: B:164:0x02e7, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:166:0x0314, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r23v0 'this'  no.nordicsemi.android.dfu.DfuBaseService, new type: no.nordicsemi.android.dfu.DfuBaseService
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String str;
        int intExtra;
        Exception exc;
        int i;
        SecurityException securityException;
        int i2;
        IOException iOException;
        int i3;
        SizeValidationException sizeValidationException;
        int i4;
        FileNotFoundException fileNotFoundException;
        int i5;
        InputStream inputStreamOpenInputStream;
        InputStream inputStream;
        int i6;
        InputStream inputStream2;
        long jElapsedRealtime;
        BluetoothGatt bluetoothGattConnect;
        long jElapsedRealtime2;
        int i7;
        int i8;
        DfuException dfuException;
        Throwable th;
        DeviceDisconnectedException deviceDisconnectedException;
        int errorNumber;
        int intExtra2;
        int intExtra3;
        DfuService serviceImpl;
        int intExtra4;
        int i9;
        int i10;
        ByteArrayInputStream byteArrayInputStream;
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(EXTRA_DEVICE_ADDRESS);
        String stringExtra2 = intent.getStringExtra(EXTRA_DEVICE_NAME);
        boolean booleanExtra = intent.getBooleanExtra(EXTRA_DISABLE_NOTIFICATION, false);
        boolean booleanExtra2 = intent.getBooleanExtra(EXTRA_FOREGROUND_SERVICE, true);
        String stringExtra3 = intent.getStringExtra(EXTRA_FILE_PATH);
        Uri uri = (Uri) intent.getParcelableExtra(EXTRA_FILE_URI);
        int intExtra5 = intent.getIntExtra(EXTRA_FILE_RES_ID, 0);
        String stringExtra4 = intent.getStringExtra(EXTRA_INIT_FILE_PATH);
        Uri uri2 = (Uri) intent.getParcelableExtra(EXTRA_INIT_FILE_URI);
        int intExtra6 = intent.getIntExtra(EXTRA_INIT_FILE_RES_ID, 0);
        int intExtra7 = intent.getIntExtra(EXTRA_FILE_TYPE, 0);
        if (stringExtra3 != null && intExtra7 == 0) {
            intExtra7 = stringExtra3.toLowerCase(Locale.US).endsWith("zip") ? 0 : 4;
        }
        String stringExtra5 = intent.getStringExtra(EXTRA_FILE_MIME_TYPE);
        if (stringExtra5 == null) {
            stringExtra5 = intExtra7 == 0 ? MIME_TYPE_ZIP : MIME_TYPE_OCTET_STREAM;
        }
        if (stringExtra == null || (stringExtra3 == null && uri == null && intExtra5 == 0)) {
            loge("Device Address of firmware location are empty. Hint: use DfuServiceInitiator to start DFU");
            return;
        }
        if ((intExtra7 & (-8)) > 0 || !(MIME_TYPE_ZIP.equals(stringExtra5) || MIME_TYPE_OCTET_STREAM.equals(stringExtra5))) {
            logw("File type or file mime-type not supported");
            sendLogBroadcast(15, "File type or file mime-type not supported");
            report(ERROR_FILE_TYPE_UNSUPPORTED);
            return;
        }
        if (MIME_TYPE_OCTET_STREAM.equals(stringExtra5) && intExtra7 != 1 && intExtra7 != 2 && intExtra7 != 4) {
            logw("Unable to determine file type");
            sendLogBroadcast(15, "Unable to determine file type");
            report(ERROR_FILE_TYPE_UNSUPPORTED);
            return;
        }
        if (!booleanExtra && getNotificationTarget() == null) {
            throw new NullPointerException("getNotificationTarget() must not return null if notifications are enabled");
        }
        if (!booleanExtra2) {
            logw("Foreground service disabled. Android Oreo or newer may kill a background service few moments after user closes the application.\nConsider enabling foreground service using DfuServiceInitiator#setForeground(boolean)");
        }
        UuidHelper.assignCustomUuids(intent);
        if (booleanExtra2) {
            logi("Starting DFU service in foreground");
            startForeground();
        }
        this.mDeviceAddress = stringExtra;
        this.mDeviceName = stringExtra2;
        this.mDisableNotification = booleanExtra;
        this.mConnectionState = 0;
        this.mError = 0;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (defaultSharedPreferences.contains(DfuSettingsConstants.SETTINGS_MBR_SIZE)) {
            str = stringExtra;
            try {
                intExtra = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_MBR_SIZE, String.valueOf(4096)));
                if (intExtra < 0) {
                    intExtra = 0;
                }
            } catch (NumberFormatException unused) {
                intExtra = 4096;
            }
        } else {
            str = stringExtra;
            intExtra = intent.getIntExtra(EXTRA_MBR_SIZE, 4096);
            if (intExtra < 0) {
                intExtra = 0;
            }
        }
        sendLogBroadcast(1, "DFU service started");
        InputStream inputStream3 = this.mFirmwareInputStream;
        InputStream inputStreamOpenRawResource = this.mInitFileInputStream;
        boolean z = inputStream3 == null;
        try {
            if (z) {
                try {
                    sendLogBroadcast(1, "Opening file...");
                    if (uri != null) {
                        inputStreamOpenInputStream = openInputStream(uri, stringExtra5, intExtra, intExtra7);
                    } else if (stringExtra3 != null) {
                        inputStreamOpenInputStream = openInputStream(stringExtra3, stringExtra5, intExtra, intExtra7);
                    } else if (intExtra5 > 0) {
                        inputStreamOpenInputStream = openInputStream(intExtra5, stringExtra5, intExtra, intExtra7);
                    }
                    if (uri2 != null) {
                        inputStreamOpenInputStream = inputStream3;
                        inputStreamOpenRawResource = getContentResolver().openInputStream(uri2);
                    } else if (stringExtra4 != null) {
                        inputStreamOpenRawResource = new FileInputStream(stringExtra4);
                    } else if (intExtra6 > 0) {
                        inputStreamOpenRawResource = getResources().openRawResource(intExtra6);
                    }
                    if (inputStreamOpenInputStream.available() % 4 != 0) {
                        throw new SizeValidationException("The new firmware is not word-aligned.");
                    }
                    inputStream = inputStreamOpenInputStream;
                } catch (FileNotFoundException e) {
                    fileNotFoundException = e;
                    i5 = 20;
                    loge("An exception occurred while opening file", fileNotFoundException);
                    sendLogBroadcast(i5, "Opening file failed: File not found");
                    report(4097);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                    }
                } catch (SizeValidationException e2) {
                    sizeValidationException = e2;
                    i4 = 20;
                    loge("Firmware not word-aligned", sizeValidationException);
                    sendLogBroadcast(i4, "Opening file failed: Firmware size must be word-aligned");
                    report(ERROR_FILE_SIZE_INVALID);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                    }
                } catch (IOException e3) {
                    iOException = e3;
                    i3 = 20;
                    loge("An exception occurred while calculating file size", iOException);
                    sendLogBroadcast(i3, "Opening file failed: " + iOException.getLocalizedMessage());
                    report(4098);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                    }
                } catch (SecurityException e4) {
                    securityException = e4;
                    i2 = 20;
                    loge("A security exception occurred while opening file", securityException);
                    sendLogBroadcast(i2, "Opening file failed: Permission required");
                    report(4097);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                    }
                } catch (Exception e5) {
                    exc = e5;
                    i = 20;
                    loge("An exception occurred while opening files. Did you set the firmware file?", exc);
                    sendLogBroadcast(i, "Opening file failed: " + exc.getLocalizedMessage());
                    report(4098);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                    }
                }
            } else {
                inputStream = inputStream3;
            }
            try {
                if (MIME_TYPE_ZIP.equals(stringExtra5)) {
                    ArchiveInputStream archiveInputStream = (ArchiveInputStream) inputStream;
                    int contentType = intExtra7 == 0 ? archiveInputStream.getContentType() : archiveInputStream.setContentType(intExtra7);
                    if ((contentType & 4) > 0 && archiveInputStream.applicationImageSize() % 4 != 0) {
                        throw new SizeValidationException("Application firmware is not word-aligned.");
                    }
                    if ((contentType & 2) > 0 && archiveInputStream.bootloaderImageSize() % 4 != 0) {
                        throw new SizeValidationException("Bootloader firmware is not word-aligned.");
                    }
                    if ((contentType & 1) > 0 && archiveInputStream.softDeviceImageSize() % 4 != 0) {
                        throw new SizeValidationException("Soft Device firmware is not word-aligned.");
                    }
                    if (contentType == 4) {
                        if (archiveInputStream.getApplicationInit() != null) {
                            byteArrayInputStream = new ByteArrayInputStream(archiveInputStream.getApplicationInit());
                            i6 = contentType;
                            inputStream2 = byteArrayInputStream;
                        }
                        i6 = contentType;
                    } else {
                        if (archiveInputStream.getSystemInit() != null) {
                            byteArrayInputStream = new ByteArrayInputStream(archiveInputStream.getSystemInit());
                            i6 = contentType;
                            inputStream2 = byteArrayInputStream;
                        }
                        i6 = contentType;
                    }
                    if (z) {
                        inputStream.mark(inputStream.available());
                        if (inputStream2 != null) {
                            inputStream2.mark(inputStream2.available());
                        }
                    }
                    this.mFirmwareInputStream = inputStream;
                    this.mInitFileInputStream = inputStream2;
                    sendLogBroadcast(5, "Firmware file opened successfully");
                    this.mProgressInfo = new DfuProgressInfo(this);
                    if (this.mAborted) {
                        logw("Upload aborted");
                        sendLogBroadcast(15, "Upload aborted");
                        this.mProgressInfo.setProgress(-7);
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                            return;
                        }
                        return;
                    }
                    sendLogBroadcast(1, "Connecting to DFU target...");
                    this.mProgressInfo.setProgress(-1);
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                    String str2 = str;
                    bluetoothGattConnect = connect(str2);
                    jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    if (bluetoothGattConnect == null) {
                        loge("Bluetooth adapter disabled");
                        sendLogBroadcast(20, "Bluetooth adapter disabled");
                        report(ERROR_BLUETOOTH_DISABLED);
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                            return;
                        }
                        return;
                    }
                    i7 = this.mError;
                    if (i7 <= 0) {
                        if ((i7 & 32768) > 0) {
                            i10 = i7 & (-32769);
                            logi("Connection error after: " + (jElapsedRealtime2 - jElapsedRealtime) + " ms");
                            if (i10 == 133 || jElapsedRealtime2 <= jElapsedRealtime + 25000) {
                                loge("An error occurred while connecting to the device: " + i10);
                                sendLogBroadcast(20, String.format(Locale.US, "Connection failed (0x%02X): %s", Integer.valueOf(i10), vs0.b(i10)));
                            } else {
                                loge("Device not reachable. Check if the device with address " + str2 + " is in range, is advertising and is connectable");
                                sendLogBroadcast(20, "Error 133: Connection timeout");
                            }
                        } else {
                            int i11 = i7 & (-16385);
                            loge("An error occurred during discovering services:" + i11);
                            sendLogBroadcast(20, String.format(Locale.US, "Connection failed (0x%02X): %s", Integer.valueOf(i11), vs0.a(i11)));
                        }
                        intExtra4 = intent.getIntExtra(EXTRA_RECONNECTION_ATTEMPT, 0);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Attempt: ");
                        i9 = intExtra4 + 1;
                        sb.append(i9);
                        logi(sb.toString());
                        if (intExtra4 < 2) {
                            terminateConnection(bluetoothGattConnect, this.mError);
                            if (booleanExtra2) {
                                stopForeground(booleanExtra);
                                return;
                            }
                            return;
                        }
                        sendLogBroadcast(15, "Retrying...");
                        if (this.mConnectionState != 0) {
                            disconnect(bluetoothGattConnect);
                        }
                        refreshDeviceCache(bluetoothGattConnect, true);
                        close(bluetoothGattConnect);
                        logi("Restarting the service");
                        Intent intent2 = new Intent();
                        intent2.fillIn(intent, 24);
                        intent2.putExtra(EXTRA_RECONNECTION_ATTEMPT, i9);
                        startService(intent2);
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                        }
                    }
                    if (this.mConnectionState == 0) {
                        sendLogBroadcast(20, "Disconnected");
                        terminateConnection(bluetoothGattConnect, 4096);
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                            return;
                        }
                        return;
                    }
                    i8 = 20;
                    if (this.mAborted) {
                        logw("Upload aborted");
                        sendLogBroadcast(15, "Upload aborted");
                        terminateConnection(bluetoothGattConnect, 0);
                        this.mProgressInfo.setProgress(-7);
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                            return;
                        }
                        return;
                    }
                    sendLogBroadcast(5, "Services discovered");
                    intent.putExtra(EXTRA_RECONNECTION_ATTEMPT, 0);
                    DfuService dfuService = null;
                    try {
                        try {
                            DfuServiceProvider dfuServiceProvider = new DfuServiceProvider();
                            this.mDfuServiceImpl = dfuServiceProvider;
                            serviceImpl = dfuServiceProvider.getServiceImpl(intent, this, bluetoothGattConnect);
                            try {
                                try {
                                    this.mDfuServiceImpl = serviceImpl;
                                    if (serviceImpl == null) {
                                        i8 = 20;
                                        try {
                                            if (serviceImpl.initialize(intent, bluetoothGattConnect, i6, inputStream, inputStream2)) {
                                                serviceImpl.performDfu(intent);
                                            }
                                            serviceImpl.release();
                                        } catch (DeviceDisconnectedException e6) {
                                            e = e6;
                                            deviceDisconnectedException = e;
                                            dfuService = serviceImpl;
                                            sendLogBroadcast(i8, "Device has disconnected");
                                            loge(deviceDisconnectedException.getMessage());
                                            close(bluetoothGattConnect);
                                            intExtra2 = intent.getIntExtra(EXTRA_DFU_ATTEMPT, 0);
                                            intExtra3 = intent.getIntExtra(EXTRA_MAX_DFU_ATTEMPTS, 0);
                                            if (intExtra2 >= intExtra3) {
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append("Restarting the service (");
                                                int i12 = intExtra2 + 1;
                                                sb2.append(i12);
                                                sb2.append(" /");
                                                sb2.append(intExtra3);
                                                sb2.append(")");
                                                logi(sb2.toString());
                                                Intent intent3 = new Intent();
                                                intent3.fillIn(intent, r3);
                                                intent3.putExtra(EXTRA_DFU_ATTEMPT, i12);
                                                startService(intent3);
                                                if (dfuService != null) {
                                                    dfuService.release();
                                                }
                                                if (booleanExtra2) {
                                                    stopForeground(booleanExtra);
                                                    return;
                                                }
                                                return;
                                            }
                                            report(4096);
                                            if (dfuService != null) {
                                                dfuService.release();
                                            }
                                        } catch (DfuException e7) {
                                            e = e7;
                                            dfuException = e;
                                            dfuService = serviceImpl;
                                            errorNumber = dfuException.getErrorNumber();
                                            if ((errorNumber & 32768) > 0) {
                                                int i13 = errorNumber & (-32769);
                                                sendLogBroadcast(i8, String.format(Locale.US, "Error (0x%02X): %s", Integer.valueOf(i13), vs0.b(i13)));
                                            } else {
                                                int i14 = errorNumber & (-16385);
                                                sendLogBroadcast(i8, String.format(Locale.US, "Error (0x%02X): %s", Integer.valueOf(i14), vs0.a(i14)));
                                            }
                                            loge(dfuException.getMessage());
                                            terminateConnection(bluetoothGattConnect, dfuException.getErrorNumber());
                                            if (dfuService != null) {
                                                dfuService.release();
                                            }
                                        }
                                        if (booleanExtra2) {
                                            stopForeground(booleanExtra);
                                            return;
                                        }
                                        return;
                                    }
                                    try {
                                        Log.w(TAG, "DFU Service not found.");
                                        sendLogBroadcast(15, "DFU Service not found");
                                        terminateConnection(bluetoothGattConnect, ERROR_SERVICE_NOT_FOUND);
                                        if (serviceImpl != null) {
                                            serviceImpl.release();
                                        }
                                        if (booleanExtra2) {
                                            stopForeground(booleanExtra);
                                            return;
                                        }
                                        return;
                                    } catch (DeviceDisconnectedException e8) {
                                        e = e8;
                                        dfuService = serviceImpl;
                                        deviceDisconnectedException = e;
                                        sendLogBroadcast(i8, "Device has disconnected");
                                        loge(deviceDisconnectedException.getMessage());
                                        close(bluetoothGattConnect);
                                        intExtra2 = intent.getIntExtra(EXTRA_DFU_ATTEMPT, 0);
                                        intExtra3 = intent.getIntExtra(EXTRA_MAX_DFU_ATTEMPTS, 0);
                                        if (intExtra2 >= intExtra3) {
                                            report(4096);
                                            if (dfuService != null) {
                                                dfuService.release();
                                            }
                                            if (booleanExtra2) {
                                                stopForeground(booleanExtra);
                                                return;
                                            }
                                            return;
                                        }
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Restarting the service (");
                                        int i15 = intExtra2 + 1;
                                        sb3.append(i15);
                                        sb3.append(" /");
                                        sb3.append(intExtra3);
                                        sb3.append(")");
                                        logi(sb3.toString());
                                        Intent intent4 = new Intent();
                                        intent4.fillIn(intent, r3);
                                        intent4.putExtra(EXTRA_DFU_ATTEMPT, i15);
                                        startService(intent4);
                                        if (dfuService != null) {
                                            dfuService.release();
                                        }
                                        if (booleanExtra2) {
                                            stopForeground(booleanExtra);
                                            return;
                                        }
                                        return;
                                    } catch (DfuException e9) {
                                        dfuException = e9;
                                        i8 = 20;
                                        dfuService = serviceImpl;
                                        errorNumber = dfuException.getErrorNumber();
                                        if ((errorNumber & 32768) > 0) {
                                            int i16 = errorNumber & (-32769);
                                            sendLogBroadcast(i8, String.format(Locale.US, "Error (0x%02X): %s", Integer.valueOf(i16), vs0.b(i16)));
                                        } else {
                                            int i17 = errorNumber & (-16385);
                                            sendLogBroadcast(i8, String.format(Locale.US, "Error (0x%02X): %s", Integer.valueOf(i17), vs0.a(i17)));
                                        }
                                        loge(dfuException.getMessage());
                                        terminateConnection(bluetoothGattConnect, dfuException.getErrorNumber());
                                        if (dfuService != null) {
                                            dfuService.release();
                                        }
                                        if (booleanExtra2) {
                                            stopForeground(booleanExtra);
                                            return;
                                        }
                                        return;
                                    }
                                } catch (UploadAbortedException unused2) {
                                    dfuService = serviceImpl;
                                    logw("Upload aborted");
                                    sendLogBroadcast(15, "Upload aborted");
                                    terminateConnection(bluetoothGattConnect, 0);
                                    this.mProgressInfo.setProgress(-7);
                                    if (dfuService != null) {
                                        dfuService.release();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    dfuService = serviceImpl;
                                    if (dfuService == null) {
                                        throw th;
                                    }
                                    dfuService.release();
                                    throw th;
                                }
                            } catch (DeviceDisconnectedException e10) {
                                e = e10;
                                i8 = 20;
                            } catch (DfuException e11) {
                                e = e11;
                                i8 = 20;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (DeviceDisconnectedException e12) {
                        e = e12;
                    } catch (DfuException e13) {
                        i8 = 20;
                        dfuException = e13;
                    } catch (UploadAbortedException unused3) {
                    }
                } else {
                    i6 = intExtra7;
                }
                inputStream2 = inputStreamOpenRawResource;
                if (z) {
                    inputStream.mark(inputStream.available());
                    if (inputStream2 != null) {
                        inputStream2.mark(inputStream2.available());
                    }
                }
                this.mFirmwareInputStream = inputStream;
                this.mInitFileInputStream = inputStream2;
                sendLogBroadcast(5, "Firmware file opened successfully");
                this.mProgressInfo = new DfuProgressInfo(this);
                if (this.mAborted) {
                    logw("Upload aborted");
                    sendLogBroadcast(15, "Upload aborted");
                    this.mProgressInfo.setProgress(-7);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                }
                sendLogBroadcast(1, "Connecting to DFU target...");
                this.mProgressInfo.setProgress(-1);
                jElapsedRealtime = SystemClock.elapsedRealtime();
                String str3 = str;
                bluetoothGattConnect = connect(str3);
                jElapsedRealtime2 = SystemClock.elapsedRealtime();
                if (bluetoothGattConnect == null) {
                    loge("Bluetooth adapter disabled");
                    sendLogBroadcast(20, "Bluetooth adapter disabled");
                    report(ERROR_BLUETOOTH_DISABLED);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                }
                i7 = this.mError;
                if (i7 <= 0) {
                    if (this.mConnectionState == 0) {
                        sendLogBroadcast(20, "Disconnected");
                        terminateConnection(bluetoothGattConnect, 4096);
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                            return;
                        }
                        return;
                    }
                    i8 = 20;
                    if (this.mAborted) {
                        logw("Upload aborted");
                        sendLogBroadcast(15, "Upload aborted");
                        terminateConnection(bluetoothGattConnect, 0);
                        this.mProgressInfo.setProgress(-7);
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                            return;
                        }
                        return;
                    }
                    sendLogBroadcast(5, "Services discovered");
                    intent.putExtra(EXTRA_RECONNECTION_ATTEMPT, 0);
                    DfuService dfuService2 = null;
                    DfuServiceProvider dfuServiceProvider2 = new DfuServiceProvider();
                    this.mDfuServiceImpl = dfuServiceProvider2;
                    serviceImpl = dfuServiceProvider2.getServiceImpl(intent, this, bluetoothGattConnect);
                    this.mDfuServiceImpl = serviceImpl;
                    if (serviceImpl == null) {
                        i8 = 20;
                        if (serviceImpl.initialize(intent, bluetoothGattConnect, i6, inputStream, inputStream2)) {
                            serviceImpl.performDfu(intent);
                        }
                        serviceImpl.release();
                        if (booleanExtra2) {
                            stopForeground(booleanExtra);
                            return;
                        }
                        return;
                    }
                    Log.w(TAG, "DFU Service not found.");
                    sendLogBroadcast(15, "DFU Service not found");
                    terminateConnection(bluetoothGattConnect, ERROR_SERVICE_NOT_FOUND);
                    if (serviceImpl != null) {
                        serviceImpl.release();
                    }
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                }
                if ((i7 & 32768) > 0) {
                    i10 = i7 & (-32769);
                    logi("Connection error after: " + (jElapsedRealtime2 - jElapsedRealtime) + " ms");
                    if (i10 == 133) {
                        loge("An error occurred while connecting to the device: " + i10);
                        sendLogBroadcast(20, String.format(Locale.US, "Connection failed (0x%02X): %s", Integer.valueOf(i10), vs0.b(i10)));
                    } else {
                        loge("An error occurred while connecting to the device: " + i10);
                        sendLogBroadcast(20, String.format(Locale.US, "Connection failed (0x%02X): %s", Integer.valueOf(i10), vs0.b(i10)));
                    }
                } else {
                    int i18 = i7 & (-16385);
                    loge("An error occurred during discovering services:" + i18);
                    sendLogBroadcast(20, String.format(Locale.US, "Connection failed (0x%02X): %s", Integer.valueOf(i18), vs0.a(i18)));
                }
                intExtra4 = intent.getIntExtra(EXTRA_RECONNECTION_ATTEMPT, 0);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Attempt: ");
                i9 = intExtra4 + 1;
                sb4.append(i9);
                logi(sb4.toString());
                if (intExtra4 < 2) {
                    terminateConnection(bluetoothGattConnect, this.mError);
                    if (booleanExtra2) {
                        stopForeground(booleanExtra);
                        return;
                    }
                    return;
                }
                sendLogBroadcast(15, "Retrying...");
                if (this.mConnectionState != 0) {
                    disconnect(bluetoothGattConnect);
                }
                refreshDeviceCache(bluetoothGattConnect, true);
                close(bluetoothGattConnect);
                logi("Restarting the service");
                Intent intent5 = new Intent();
                intent5.fillIn(intent, 24);
                intent5.putExtra(EXTRA_RECONNECTION_ATTEMPT, i9);
                startService(intent5);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } catch (FileNotFoundException e14) {
                i5 = 20;
                fileNotFoundException = e14;
                loge("An exception occurred while opening file", fileNotFoundException);
                sendLogBroadcast(i5, "Opening file failed: File not found");
                report(4097);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } catch (SizeValidationException e15) {
                i4 = 20;
                sizeValidationException = e15;
                loge("Firmware not word-aligned", sizeValidationException);
                sendLogBroadcast(i4, "Opening file failed: Firmware size must be word-aligned");
                report(ERROR_FILE_SIZE_INVALID);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } catch (IOException e16) {
                i3 = 20;
                iOException = e16;
                loge("An exception occurred while calculating file size", iOException);
                sendLogBroadcast(i3, "Opening file failed: " + iOException.getLocalizedMessage());
                report(4098);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } catch (SecurityException e17) {
                i2 = 20;
                securityException = e17;
                loge("A security exception occurred while opening file", securityException);
                sendLogBroadcast(i2, "Opening file failed: Permission required");
                report(4097);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            } catch (Exception e18) {
                i = 20;
                exc = e18;
                loge("An exception occurred while opening files. Did you set the firmware file?", exc);
                sendLogBroadcast(i, "Opening file failed: " + exc.getLocalizedMessage());
                report(4098);
                if (booleanExtra2) {
                    stopForeground(booleanExtra);
                }
            }
        } catch (Throwable th4) {
            if (!booleanExtra2) {
                throw th4;
            }
            stopForeground(booleanExtra);
            throw th4;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(NOTIFICATION_ID);
        }
        stopSelf();
    }

    protected void refreshDeviceCache(BluetoothGatt bluetoothGatt, boolean z) {
        if (z || bluetoothGatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                logi("Refreshing result: " + ((Boolean) bluetoothGatt.getClass().getMethod("refresh", null).invoke(bluetoothGatt, null)).booleanValue());
            } catch (Exception e) {
                loge("An exception occurred while refreshing device", e);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    void sendLogBroadcast(int i, String str) {
        Intent intent = new Intent(BROADCAST_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, "[DFU] " + str);
        intent.putExtra(EXTRA_LOG_LEVEL, i);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        oc1.b(this).d(intent);
    }

    protected void terminateConnection(BluetoothGatt bluetoothGatt, int i) {
        if (this.mConnectionState != 0) {
            disconnect(bluetoothGatt);
        }
        refreshDeviceCache(bluetoothGatt, false);
        close(bluetoothGatt);
        waitFor(600L);
        if (i != 0) {
            report(i);
        }
    }

    protected void updateErrorNotification(xr1.d dVar) {
    }

    protected void updateForegroundNotification(xr1.d dVar) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressInfo.ProgressListener
    public void updateProgressNotification() {
        DfuProgressInfo dfuProgressInfo = this.mProgressInfo;
        int progress = dfuProgressInfo.getProgress();
        if (this.mLastProgress == progress) {
            return;
        }
        this.mLastProgress = progress;
        sendProgressBroadcast(dfuProgressInfo);
        if (this.mDisableNotification) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.mLastNotificationTime >= 250 || -6 == progress || -7 == progress) {
            this.mLastNotificationTime = jElapsedRealtime;
            String str = this.mDeviceAddress;
            String string = this.mDeviceName;
            if (string == null) {
                string = getString(R.string.dfu_unknown_name);
            }
            xr1.d dVarN = new xr1.d(this, NOTIFICATION_CHANNEL_DFU).q(android.R.drawable.stat_sys_upload).n(true);
            dVarN.g(-7829368);
            switch (progress) {
                case -7:
                    dVarN.m(false).j(getString(R.string.dfu_status_aborted)).q(android.R.drawable.stat_sys_upload_done).i(getString(R.string.dfu_status_aborted_msg)).e(true);
                    break;
                case -6:
                    dVarN.m(false).j(getString(R.string.dfu_status_completed)).q(android.R.drawable.stat_sys_upload_done).i(getString(R.string.dfu_status_completed_msg)).e(true).g(-16730086);
                    break;
                case -5:
                    dVarN.m(true).j(getString(R.string.dfu_status_disconnecting)).i(getString(R.string.dfu_status_disconnecting_msg, string)).p(100, 0, true);
                    break;
                case -4:
                    dVarN.m(true).j(getString(R.string.dfu_status_validating)).i(getString(R.string.dfu_status_validating_msg)).p(100, 0, true);
                    break;
                case -3:
                    dVarN.m(true).j(getString(R.string.dfu_status_switching_to_dfu)).i(getString(R.string.dfu_status_switching_to_dfu_msg)).p(100, 0, true);
                    break;
                case -2:
                    dVarN.m(true).j(getString(R.string.dfu_status_starting)).i(getString(R.string.dfu_status_starting_msg)).p(100, 0, true);
                    break;
                case -1:
                    dVarN.m(true).j(getString(R.string.dfu_status_connecting)).i(getString(R.string.dfu_status_connecting_msg, string)).p(100, 0, true);
                    break;
                default:
                    dVarN.m(true).j(dfuProgressInfo.getTotalParts() == 1 ? getString(R.string.dfu_status_uploading) : getString(R.string.dfu_status_uploading_part, Integer.valueOf(dfuProgressInfo.getCurrentPart()), Integer.valueOf(dfuProgressInfo.getTotalParts()))).i(getString(R.string.dfu_status_uploading_msg, string)).p(100, progress, false);
                    break;
            }
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
            intent.putExtra(EXTRA_DEVICE_NAME, string);
            intent.putExtra(EXTRA_PROGRESS, progress);
            dVarN.h(PendingIntent.getActivity(this, 0, intent, 201326592));
            updateProgressNotification(dVarN, progress);
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.notify(NOTIFICATION_ID, dVarN.b());
            }
        }
    }

    protected void waitFor(long j) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + j + ")");
                this.mLock.wait(j);
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        }
    }

    protected void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    try {
                        this.mLock.wait();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    private void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    private InputStream openInputStream(Uri uri, String str, int i, int i2) throws IOException {
        InputStream inputStreamOpenInputStream;
        if (uri.toString().startsWith("file:///android_asset/")) {
            inputStreamOpenInputStream = getAssets().open(uri.getPath().substring(15));
        } else {
            inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        }
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(inputStreamOpenInputStream, i, i2);
        }
        Cursor cursorQuery = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext() && cursorQuery.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(inputStreamOpenInputStream, i);
                    cursorQuery.close();
                    return hexInputStream;
                }
            } catch (Throwable th) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return inputStreamOpenInputStream;
    }

    private InputStream openInputStream(int i, String str, int i2, int i3) throws IOException {
        InputStream inputStreamOpenRawResource = getResources().openRawResource(i);
        if (MIME_TYPE_ZIP.equals(str)) {
            return new ArchiveInputStream(inputStreamOpenRawResource, i2, i3);
        }
        inputStreamOpenRawResource.mark(2);
        int i4 = inputStreamOpenRawResource.read();
        inputStreamOpenRawResource.reset();
        return i4 == 58 ? new HexInputStream(inputStreamOpenRawResource, i2) : inputStreamOpenRawResource;
    }

    protected void updateProgressNotification(xr1.d dVar, int i) {
        if (i == -7 || i == -6) {
            return;
        }
        Intent intent = new Intent(BROADCAST_ACTION);
        intent.putExtra(EXTRA_ACTION, 2);
        dVar.a(R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent, 201326592));
    }
}
