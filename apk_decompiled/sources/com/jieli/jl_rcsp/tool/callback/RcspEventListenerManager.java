package com.jieli.jl_rcsp.tool.callback;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.rcsp.OnRcspEventListener;
import com.jieli.jl_rcsp.model.LtvBean;
import com.jieli.jl_rcsp.model.device.AlarmBean;
import com.jieli.jl_rcsp.model.device.AlarmListInfo;
import com.jieli.jl_rcsp.model.device.BatteryInfo;
import com.jieli.jl_rcsp.model.device.ChannelInfo;
import com.jieli.jl_rcsp.model.device.DefaultAlarmBell;
import com.jieli.jl_rcsp.model.device.DevStorageInfo;
import com.jieli.jl_rcsp.model.device.DynamicLimiterParam;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.jieli.jl_rcsp.model.device.EqPresetInfo;
import com.jieli.jl_rcsp.model.device.FmStatusInfo;
import com.jieli.jl_rcsp.model.device.ID3MusicInfo;
import com.jieli.jl_rcsp.model.device.LightControlInfo;
import com.jieli.jl_rcsp.model.device.MusicNameInfo;
import com.jieli.jl_rcsp.model.device.MusicStatusInfo;
import com.jieli.jl_rcsp.model.device.PlayModeInfo;
import com.jieli.jl_rcsp.model.device.ReverberationParam;
import com.jieli.jl_rcsp.model.device.VoiceMode;
import com.jieli.jl_rcsp.model.device.VolumeInfo;
import com.jieli.jl_rcsp.model.device.health.HealthData;
import com.jieli.jl_rcsp.model.device.health.HealthSettingInfo;
import com.jieli.jl_rcsp.model.device.health.SportsInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class RcspEventListenerManager extends BaseCallbackManager<OnRcspEventListener> {
    public void onAlarmDefaultBellListChange(final BluetoothDevice bluetoothDevice, final List<DefaultAlarmBell> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: jb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmDefaultBellListChange(bluetoothDevice, list);
            }
        });
    }

    public void onAlarmListChange(final BluetoothDevice bluetoothDevice, final AlarmListInfo alarmListInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ec2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmListChange(bluetoothDevice, alarmListInfo);
            }
        });
    }

    public void onAlarmNotify(final BluetoothDevice bluetoothDevice, final AlarmBean alarmBean) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ic2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmNotify(bluetoothDevice, alarmBean);
            }
        });
    }

    public void onAlarmStop(final BluetoothDevice bluetoothDevice, final AlarmBean alarmBean) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: zb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAlarmStop(bluetoothDevice, alarmBean);
            }
        });
    }

    public void onAuxStatusChange(final BluetoothDevice bluetoothDevice, final boolean z) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: hb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onAuxStatusChange(bluetoothDevice, z);
            }
        });
    }

    public void onBatteryChange(final BluetoothDevice bluetoothDevice, final BatteryInfo batteryInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ac2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onBatteryChange(bluetoothDevice, batteryInfo);
            }
        });
    }

    public void onCurrentVoiceMode(final BluetoothDevice bluetoothDevice, final VoiceMode voiceMode) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: lc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onCurrentVoiceMode(bluetoothDevice, voiceMode);
            }
        });
    }

    public void onDevStorageInfoChange(final BluetoothDevice bluetoothDevice, final DevStorageInfo devStorageInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: tb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onDevStorageInfoChange(bluetoothDevice, devStorageInfo);
            }
        });
    }

    public void onDeviceModeChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: mb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onDeviceModeChange(bluetoothDevice, i);
            }
        });
    }

    public void onDynamicLimiter(final BluetoothDevice bluetoothDevice, final DynamicLimiterParam dynamicLimiterParam) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: bc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onDynamicLimiter(bluetoothDevice, dynamicLimiterParam);
            }
        });
    }

    public void onEqChange(final BluetoothDevice bluetoothDevice, final EqInfo eqInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: gb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onEqChange(bluetoothDevice, eqInfo);
            }
        });
    }

    public void onEqPresetChange(final BluetoothDevice bluetoothDevice, final EqPresetInfo eqPresetInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: fb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onEqPresetChange(bluetoothDevice, eqPresetInfo);
            }
        });
    }

    public void onExpandFunction(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ib2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onExpandFunction(bluetoothDevice, i, bArr);
            }
        });
    }

    public void onFileFormatChange(final BluetoothDevice bluetoothDevice, final String str) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: cb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFileFormatChange(bluetoothDevice, str);
            }
        });
    }

    public void onFmChannelsChange(final BluetoothDevice bluetoothDevice, final List<ChannelInfo> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: wb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFmChannelsChange(bluetoothDevice, list);
            }
        });
    }

    public void onFmStatusChange(final BluetoothDevice bluetoothDevice, final FmStatusInfo fmStatusInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: xb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFmStatusChange(bluetoothDevice, fmStatusInfo);
            }
        });
    }

    public void onFrequencyTx(final BluetoothDevice bluetoothDevice, final float f) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: rb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onFrequencyTx(bluetoothDevice, f);
            }
        });
    }

    public void onHealthDataChange(final BluetoothDevice bluetoothDevice, final HealthData healthData) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ob2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onHealthDataChange(bluetoothDevice, healthData);
            }
        });
    }

    public void onHealthSettingChange(final BluetoothDevice bluetoothDevice, final HealthSettingInfo healthSettingInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: eb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onHealthSettingChange(bluetoothDevice, healthSettingInfo);
            }
        });
    }

    public void onHighAndBassChange(final BluetoothDevice bluetoothDevice, final int i, final int i2) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: bb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onHighAndBassChange(bluetoothDevice, i, i2);
            }
        });
    }

    public void onID3MusicInfo(final BluetoothDevice bluetoothDevice, final ID3MusicInfo iD3MusicInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: hc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onID3MusicInfo(bluetoothDevice, iD3MusicInfo);
            }
        });
    }

    public void onLightControlInfo(final BluetoothDevice bluetoothDevice, final LightControlInfo lightControlInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: pb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onLightControlInfo(bluetoothDevice, lightControlInfo);
            }
        });
    }

    public void onMusicNameChange(final BluetoothDevice bluetoothDevice, final MusicNameInfo musicNameInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: jc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onMusicNameChange(bluetoothDevice, musicNameInfo);
            }
        });
    }

    public void onMusicStatusChange(final BluetoothDevice bluetoothDevice, final MusicStatusInfo musicStatusInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: gc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onMusicStatusChange(bluetoothDevice, musicStatusInfo);
            }
        });
    }

    public void onPeripheralsConnectStatusChange(final BluetoothDevice bluetoothDevice, final boolean z, final String str) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: lb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPeripheralsConnectStatusChange(bluetoothDevice, z, str);
            }
        });
    }

    public void onPeripheralsModeChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: yb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPeripheralsModeChange(bluetoothDevice, i);
            }
        });
    }

    public void onPhoneCallStatusChange(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: nb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPhoneCallStatusChange(bluetoothDevice, i);
            }
        });
    }

    public void onPlatformInterfaceInfoChange(final BluetoothDevice bluetoothDevice, final Map<Integer, List<LtvBean>> map) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: ub2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPlatformInterfaceInfoChange(bluetoothDevice, map);
            }
        });
    }

    public void onPlayModeChange(final BluetoothDevice bluetoothDevice, final PlayModeInfo playModeInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: qb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onPlayModeChange(bluetoothDevice, playModeInfo);
            }
        });
    }

    public void onReverberation(final BluetoothDevice bluetoothDevice, final ReverberationParam reverberationParam) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: fc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onReverberation(bluetoothDevice, reverberationParam);
            }
        });
    }

    public void onSensorLogDataChange(final BluetoothDevice bluetoothDevice, final int i, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: vb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSensorLogDataChange(bluetoothDevice, i, bArr);
            }
        });
    }

    public void onSoundCardEqChange(final BluetoothDevice bluetoothDevice, final EqInfo eqInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: db2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSoundCardEqChange(bluetoothDevice, eqInfo);
            }
        });
    }

    public void onSoundCardStatusChange(final BluetoothDevice bluetoothDevice, final long j, final byte[] bArr) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: kb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSoundCardStatusChange(bluetoothDevice, j, bArr);
            }
        });
    }

    public void onSportInfoChange(final BluetoothDevice bluetoothDevice, final SportsInfo sportsInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: kc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSportInfoChange(bluetoothDevice, sportsInfo);
            }
        });
    }

    public void onSportsState(final BluetoothDevice bluetoothDevice, final int i) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: cc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onSportsState(bluetoothDevice, i);
            }
        });
    }

    public void onVoiceModeList(final BluetoothDevice bluetoothDevice, final List<VoiceMode> list) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: sb2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onVoiceModeList(bluetoothDevice, list);
            }
        });
    }

    public void onVolumeChange(final BluetoothDevice bluetoothDevice, final VolumeInfo volumeInfo) {
        callbackEvent(new BaseCallbackManager.CallbackImpl() { // from class: dc2
            @Override // com.jieli.jl_rcsp.tool.callback.BaseCallbackManager.CallbackImpl
            public final void onPost(Object obj) {
                ((OnRcspEventListener) obj).onVolumeChange(bluetoothDevice, volumeInfo);
            }
        });
    }
}
