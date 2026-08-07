package com.jieli.jl_rcsp.tool;

import android.bluetooth.BluetoothDevice;
import android.graphics.Color;
import com.jieli.jl_rcsp.impl.RcspOpImpl;
import com.jieli.jl_rcsp.model.device.AlarmBean;
import com.jieli.jl_rcsp.model.device.AlarmListInfo;
import com.jieli.jl_rcsp.model.device.AttrBean;
import com.jieli.jl_rcsp.model.device.BatteryInfo;
import com.jieli.jl_rcsp.model.device.ChannelInfo;
import com.jieli.jl_rcsp.model.device.DefaultAlarmBell;
import com.jieli.jl_rcsp.model.device.DevStorageInfo;
import com.jieli.jl_rcsp.model.device.DeviceInfo;
import com.jieli.jl_rcsp.model.device.DynamicLimiterParam;
import com.jieli.jl_rcsp.model.device.EqInfo;
import com.jieli.jl_rcsp.model.device.EqPresetInfo;
import com.jieli.jl_rcsp.model.device.ExpandFunction;
import com.jieli.jl_rcsp.model.device.FmStatusInfo;
import com.jieli.jl_rcsp.model.device.ID3MusicInfo;
import com.jieli.jl_rcsp.model.device.LightControlInfo;
import com.jieli.jl_rcsp.model.device.MusicNameInfo;
import com.jieli.jl_rcsp.model.device.MusicStatusInfo;
import com.jieli.jl_rcsp.model.device.PlayModeInfo;
import com.jieli.jl_rcsp.model.device.ReverberationParam;
import com.jieli.jl_rcsp.model.device.VoiceMode;
import com.jieli.jl_rcsp.model.device.VolumeInfo;
import com.jieli.jl_rcsp.model.device.health.AutomaticPressureDetection;
import com.jieli.jl_rcsp.model.device.health.BloodOxygenMeasurementAlert;
import com.jieli.jl_rcsp.model.device.health.DisconnectReminder;
import com.jieli.jl_rcsp.model.device.health.EmergencyContact;
import com.jieli.jl_rcsp.model.device.health.ExerciseHeartRateReminder;
import com.jieli.jl_rcsp.model.device.health.FallDetection;
import com.jieli.jl_rcsp.model.device.health.HealthSettingInfo;
import com.jieli.jl_rcsp.model.device.health.HeartRateMeasure;
import com.jieli.jl_rcsp.model.device.health.LiftWristDetection;
import com.jieli.jl_rcsp.model.device.health.SedentaryReminder;
import com.jieli.jl_rcsp.model.device.health.SensorInfo;
import com.jieli.jl_rcsp.model.device.health.SleepDetection;
import com.jieli.jl_rcsp.model.device.health.UserInfo;
import com.jieli.jl_rcsp.tool.callback.RcspEventListenerManager;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.JL_Log;
import com.tencent.connect.common.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RcspDataHandler {
    public static final String c = "rcsp_handler";
    public static final int d = 64;
    public final RcspOpImpl a;
    public final RcspEventListenerManager b;

    public RcspDataHandler(RcspOpImpl rcspOpImpl, RcspEventListenerManager rcspEventListenerManager) {
        this.a = rcspOpImpl;
        this.b = rcspEventListenerManager;
    }

    public final void a(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        if (list == null || (deviceInfo = this.a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0 && attrBean.getType() == 0) {
                boolean z = CHexConver.byteToInt(attrData[0]) == 1;
                JL_Log.i(c, "parseAUXData", "onAuxStatusChange >> " + z);
                deviceInfo.setAuxPlay(z);
                this.b.onAuxStatusChange(bluetoothDevice, z);
            }
        }
    }

    public final void b(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        String str;
        String str2;
        String str3;
        String str4;
        if (list == null || (deviceInfo = this.a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        ID3MusicInfo iD3MusicInfo = deviceInfo.getiD3MusicInfo();
        if (iD3MusicInfo == null) {
            iD3MusicInfo = new ID3MusicInfo();
        }
        ID3MusicInfo iD3MusicInfo2 = iD3MusicInfo;
        boolean z = false;
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0) {
                byte type = attrBean.getType();
                String str5 = Constants.STR_EMPTY;
                switch (type) {
                    case 0:
                        String strByte2HexStr = CHexConver.byte2HexStr(attrData);
                        try {
                            str = new String(attrData, StandardCharsets.UTF_8);
                        } catch (Exception e) {
                            e.printStackTrace();
                            str = null;
                        }
                        if (str != null && attrData.length == 64) {
                            str = str.substring(0, str.length() - 1) + "...";
                        }
                        if (!"00".equals(strByte2HexStr)) {
                            str5 = str;
                        }
                        iD3MusicInfo2.setTitle(str5);
                        break;
                    case 1:
                        String strByte2HexStr2 = CHexConver.byte2HexStr(attrData);
                        try {
                            str2 = new String(attrData, 0, attrData.length, StandardCharsets.UTF_8);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            str2 = null;
                        }
                        if (str2 != null && attrData.length == 64) {
                            str2 = str2.substring(0, str2.length() - 1) + "...";
                        }
                        if (!"00".equals(strByte2HexStr2)) {
                            str5 = str2;
                        }
                        iD3MusicInfo2.setArtist(str5);
                        break;
                    case 2:
                        String strByte2HexStr3 = CHexConver.byte2HexStr(attrData);
                        try {
                            str3 = new String(attrData, StandardCharsets.UTF_8);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            str3 = null;
                        }
                        if (str3 != null && attrData.length == 64) {
                            str3 = str3.substring(0, str3.length() - 1) + "...";
                        }
                        if (!"00".equals(strByte2HexStr3)) {
                            str5 = str3;
                        }
                        iD3MusicInfo2.setAlbum(str5);
                        break;
                    case 3:
                        int iByteToInt = CHexConver.byteToInt(attrData[0]);
                        JL_Log.d(c, "parseBtData", "id3 number: " + iByteToInt);
                        iD3MusicInfo2.setNumber(iByteToInt);
                        break;
                    case 4:
                        int iBytesToInt = attrData.length >= 2 ? CHexConver.bytesToInt(attrData, 0, 2) : 0;
                        JL_Log.d(c, "parseBtData", "id3 allNum: " + iBytesToInt);
                        iD3MusicInfo2.setTotal(iBytesToInt);
                        break;
                    case 5:
                        try {
                            str4 = new String(attrData, 0, attrData.length, StandardCharsets.UTF_8);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                            str4 = null;
                        }
                        JL_Log.d(c, "parseBtData", "id3 genre: " + str4);
                        iD3MusicInfo2.setGenre(str4);
                        break;
                    case 6:
                        int iBytesToInt2 = attrData.length >= 2 ? CHexConver.bytesToInt(attrData, 0, 2) : 0;
                        JL_Log.i(c, "parseBtData", "id3 allTime: " + iBytesToInt2);
                        iD3MusicInfo2.setTotalTime(iBytesToInt2);
                        break;
                    case 7:
                        boolean z2 = (attrData[0] & 1) == 1;
                        JL_Log.d(c, "parseBtData", "id3 isPlay: " + z2);
                        iD3MusicInfo2.setPlayStatus(z2);
                        break;
                    case 8:
                        int iBytesToInt3 = attrData.length >= 4 ? CHexConver.bytesToInt(attrData, 0, 4) / 1000 : 0;
                        JL_Log.d(c, "parseBtData", "id3 currentTime: " + iBytesToInt3);
                        iD3MusicInfo2.setCurrentTime(iBytesToInt3);
                        break;
                    default:
                        continue;
                }
                z = true;
            }
        }
        if (z) {
            deviceInfo.setiD3MusicInfo(iD3MusicInfo2);
            this.b.onID3MusicInfo(bluetoothDevice, iD3MusicInfo2);
        }
    }

    public final void c(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        if (list == null || (deviceInfo = this.a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0) {
                byte type = attrBean.getType();
                int i = 1;
                if (type == 0) {
                    FmStatusInfo fmStatusInfo = new FmStatusInfo(CHexConver.byteToInt(attrData[0]) == 1, attrData.length > 1 ? CHexConver.byteToInt(attrData[1]) : 0, attrData.length > 3 ? CHexConver.bytesToInt(attrData[2], attrData[3]) / 10.0f : 0.0f, attrData.length > 4 ? CHexConver.byteToInt(attrData[4]) : 0);
                    deviceInfo.setFmStatusInfo(fmStatusInfo);
                    this.b.onFmStatusChange(bluetoothDevice, fmStatusInfo);
                } else if (type == 1) {
                    ArrayList arrayList = new ArrayList();
                    int length = attrData.length;
                    while (length - i >= 3) {
                        int iByteToInt = CHexConver.byteToInt(attrData[i]);
                        float fBytesToInt = CHexConver.bytesToInt(attrData[i + 1], attrData[i + 2]) / 10.0f;
                        i += 3;
                        arrayList.add(new ChannelInfo(iByteToInt, fBytesToInt));
                    }
                    deviceInfo.setChannelInfos(arrayList);
                    this.b.onFmChannelsChange(bluetoothDevice, arrayList);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0091  */
    public final void d(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        String str;
        int i;
        int iBytesToInt;
        if (list == null || (deviceInfo = this.a.getDeviceInfo(bluetoothDevice)) == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != null && attrData.length != 0) {
                byte type = attrBean.getType();
                int iByteToInt = 0;
                if (type == 0) {
                    boolean z = (attrData[0] & 1) == 1;
                    if (attrData.length > 4) {
                        byte[] bArr = new byte[4];
                        System.arraycopy(attrData, 1, bArr, 0, 4);
                        int iBytesToInt2 = CHexConver.bytesToInt(bArr) * 1000;
                        if (attrData.length > 8) {
                            System.arraycopy(attrData, 5, bArr, 0, 4);
                            iBytesToInt = CHexConver.bytesToInt(bArr) * 1000;
                            if (attrData.length > 9) {
                                iByteToInt = CHexConver.byteToInt(attrData[9]);
                            }
                        } else {
                            iBytesToInt = 0;
                        }
                        i = iByteToInt;
                        iByteToInt = iBytesToInt2;
                    } else {
                        i = 0;
                        iBytesToInt = 0;
                    }
                    MusicStatusInfo musicStatusInfo = new MusicStatusInfo(z, iByteToInt, iBytesToInt, i);
                    deviceInfo.setMusicStatusInfo(musicStatusInfo);
                    deviceInfo.setCurrentDevIndex(CHexConver.intToByte(musicStatusInfo.getCurrentDev()));
                    this.b.onMusicStatusChange(bluetoothDevice, musicStatusInfo);
                } else if (type != 1) {
                    if (type == 2) {
                        int iByteToInt2 = CHexConver.byteToInt(attrData[0]);
                        JL_Log.d(c, "parseMusicData", "music play mode : " + iByteToInt2);
                        PlayModeInfo playModeInfo = new PlayModeInfo(iByteToInt2);
                        deviceInfo.setPlayModeInfo(playModeInfo);
                        this.b.onPlayModeChange(bluetoothDevice, playModeInfo);
                    }
                } else if (attrData.length > 3) {
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(attrData, 0, bArr2, 0, 4);
                    int iBytesToInt3 = CHexConver.bytesToInt(bArr2);
                    if (attrData.length <= 4) {
                        str = null;
                    } else {
                        boolean z2 = (attrData[4] & 255) == 1;
                        if (attrData.length > 5) {
                            try {
                                str = new String(attrData, 5, attrData.length - 5, z2 ? "gbk" : "utf-16le");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                                str = null;
                            }
                        } else {
                            str = null;
                        }
                    }
                    MusicNameInfo musicNameInfo = new MusicNameInfo(iBytesToInt3, str);
                    deviceInfo.setMusicNameInfo(musicNameInfo);
                    deviceInfo.setCluster(musicNameInfo.getCluster());
                    this.b.onMusicNameChange(bluetoothDevice, musicNameInfo);
                }
            }
        }
    }

    public final void e(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        String str;
        DeviceInfo deviceInfo = this.a.getDeviceInfo(bluetoothDevice);
        if (deviceInfo == null) {
            return;
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            if (attrData != 0 && attrData.length != 0) {
                int i = 1;
                int iBytesToInt = 0;
                switch (attrBean.getType()) {
                    case 0:
                        this.b.onBatteryChange(bluetoothDevice, new BatteryInfo(CHexConver.byteToInt(attrData[0])));
                        break;
                    case 1:
                        int maxVol = deviceInfo.getMaxVol();
                        boolean zIsSupportVolumeSync = deviceInfo.isSupportVolumeSync();
                        int iByteToInt = CHexConver.byteToInt(attrData[0]);
                        deviceInfo.setVolume(iByteToInt);
                        this.b.onVolumeChange(bluetoothDevice, new VolumeInfo(maxVol, iByteToInt, zIsSupportVolumeSync));
                        break;
                    case 2:
                        DevStorageInfo devStorageInfo = new DevStorageInfo();
                        devStorageInfo.parseData(attrData);
                        deviceInfo.setDevStorageInfo(devStorageInfo);
                        this.b.onDevStorageInfoChange(bluetoothDevice, devStorageInfo);
                        break;
                    case 4:
                        byte b = attrData[0];
                        boolean z = (b & 128) == 128;
                        int iByteToInt2 = CHexConver.byteToInt(b) & 127;
                        EqInfo eqInfo = new EqInfo();
                        eqInfo.setMode(iByteToInt2);
                        eqInfo.setDynamic(z);
                        if (z) {
                            int i2 = attrData[1];
                            byte[] bArr = new byte[i2];
                            System.arraycopy(attrData, 2, bArr, 0, i2);
                            eqInfo.setValue(bArr);
                            EqPresetInfo eqPresetInfoA = a(list);
                            if (eqPresetInfoA == null) {
                                eqPresetInfoA = deviceInfo.getEqPresetInfo();
                            }
                            if (eqPresetInfoA != null) {
                                eqInfo.setFreqs(eqPresetInfoA.getFreqs());
                            }
                            JL_Log.d(c, "parsePublicData", "eq data freq-->" + eqPresetInfoA);
                        } else {
                            byte[] bArr2 = new byte[0];
                            if (attrData.length > 10) {
                                bArr2 = new byte[10];
                                System.arraycopy(attrData, 1, bArr2, 0, 10);
                            }
                            eqInfo.setValue(bArr2);
                        }
                        deviceInfo.setEqInfo(eqInfo);
                        this.b.onEqChange(bluetoothDevice, eqInfo);
                        break;
                    case 5:
                        try {
                            str = new String(attrData);
                        } catch (Exception e) {
                            e.printStackTrace();
                            str = null;
                        }
                        deviceInfo.setPlayFileFormat(str);
                        this.b.onFileFormatChange(bluetoothDevice, str);
                        break;
                    case 6:
                        int iByteToInt3 = CHexConver.byteToInt(attrData[0]);
                        deviceInfo.setCurFunction(attrData[0]);
                        JL_Log.i(c, "parsePublicData", "onDeviceModeChange >> " + iByteToInt3);
                        this.b.onDeviceModeChange(bluetoothDevice, iByteToInt3);
                        break;
                    case 7:
                        JL_Log.i(c, "parsePublicData", "SYS_INFO_ATTR_LIGHT");
                        int iByteToInt4 = CHexConver.byteToInt(attrData[0]);
                        int iByteToInt5 = CHexConver.byteToInt(attrData[1]);
                        int iByteToInt6 = CHexConver.byteToInt(attrData[2]);
                        int iByteToInt7 = CHexConver.byteToInt(attrData[3]);
                        int iByteToInt8 = CHexConver.byteToInt(attrData[4]);
                        int iByteToInt9 = CHexConver.byteToInt(attrData[5]);
                        int iByteToInt10 = CHexConver.byteToInt(attrData[6]);
                        LightControlInfo luminance = new LightControlInfo().setSwitchState(iByteToInt4 & 3).setLightMode((iByteToInt4 & 12) >>> 2).setColor(Color.rgb(iByteToInt5, iByteToInt6, iByteToInt7)).setTwinkleMode(iByteToInt8).setTwinkleFreq(iByteToInt9).setSceneMode(iByteToInt10).setHue(CHexConver.bytesToInt(attrData[7], attrData[8])).setSaturation(CHexConver.byteToInt(attrData[9])).setLuminance(CHexConver.byteToInt(attrData[10]));
                        deviceInfo.setLightControlInfo(luminance);
                        this.b.onLightControlInfo(bluetoothDevice, luminance);
                        break;
                    case 8:
                        if (attrData.length >= 2 && attrData.length < 4) {
                            byte[] bArr3 = new byte[2];
                            System.arraycopy(attrData, 0, bArr3, 0, 2);
                            iBytesToInt = CHexConver.bytesToInt(bArr3[0], bArr3[1]);
                        } else if (attrData.length >= 4) {
                            byte[] bArr4 = new byte[4];
                            System.arraycopy(attrData, 0, bArr4, 0, 4);
                            iBytesToInt = CHexConver.bytesToInt(bArr4);
                        }
                        float f = iBytesToInt / 10.0f;
                        deviceInfo.setFrequency(f);
                        this.b.onFrequencyTx(bluetoothDevice, f);
                        break;
                    case 9:
                        this.b.onPeripheralsModeChange(bluetoothDevice, CHexConver.byteToInt(attrData[0]));
                        break;
                    case 10:
                        byte[] bArr5 = new byte[0];
                        boolean z2 = attrData[0] == 1;
                        if (z2 && attrData.length > 6) {
                            bArr5 = new byte[6];
                            System.arraycopy(attrData, 1, bArr5, 0, 6);
                        }
                        this.b.onPeripheralsConnectStatusChange(bluetoothDevice, z2, CHexConver.hexDataCovetToAddress(bArr5));
                        break;
                    case 11:
                        if (attrData.length >= 8) {
                            this.b.onHighAndBassChange(bluetoothDevice, CHexConver.bytesToInt(attrData, 0, 4), CHexConver.bytesToInt(attrData, 4, 4));
                        }
                        break;
                    case 12:
                        JL_Log.d(c, "parsePublicData", "eq preset data-->" + CHexConver.byte2HexStr(attrData, attrData.length));
                        EqPresetInfo eqPresetInfoA2 = a(attrBean);
                        deviceInfo.setEqPresetInfo(eqPresetInfoA2);
                        this.b.onEqPresetChange(bluetoothDevice, eqPresetInfoA2);
                        break;
                    case 13:
                        if (attrData.length >= 9) {
                            byte[] bArr6 = new byte[9];
                            System.arraycopy(attrData, 0, bArr6, 0, 9);
                            VoiceMode voiceMode = VoiceMode.parse(bArr6);
                            deviceInfo.setCurrentVoiceMode(voiceMode);
                            this.b.onCurrentVoiceMode(bluetoothDevice, voiceMode);
                        }
                        break;
                    case 14:
                        int i3 = attrData[0];
                        if (i3 > 0 && attrData.length >= (i3 * 9) + 1) {
                            byte[] bArr7 = new byte[9];
                            ArrayList arrayList = new ArrayList();
                            for (int i4 = 0; i4 < i3; i4++) {
                                System.arraycopy(attrData, i, bArr7, 0, 9);
                                i += 9;
                                arrayList.add(VoiceMode.parse(bArr7));
                            }
                            deviceInfo.setVoiceModeList(arrayList);
                            this.b.onVoiceModeList(bluetoothDevice, arrayList);
                        }
                        break;
                    case 15:
                        JL_Log.e(c, "parsePublicData", "phone status change ：" + CHexConver.byte2HexStr(attrData));
                        int iByteToInt11 = CHexConver.byteToInt(attrData[0]);
                        deviceInfo.setPhoneStatus(iByteToInt11);
                        this.b.onPhoneCallStatusChange(bluetoothDevice, iByteToInt11);
                        break;
                    case 16:
                        int length = attrData.length;
                        byte[] bArr8 = new byte[length];
                        System.arraycopy(attrData, 0, bArr8, 0, length);
                        a(bluetoothDevice, bArr8);
                        break;
                    case 17:
                        EqInfo eqInfo2 = new EqInfo();
                        eqInfo2.setDynamic(true);
                        eqInfo2.setMode(0);
                        int i5 = attrData[0];
                        int[] iArr = new int[i5];
                        while (iBytesToInt < i5) {
                            iArr[iBytesToInt] = CHexConver.bytesToInt(attrData, i, 2);
                            iBytesToInt++;
                            i += 2;
                        }
                        eqInfo2.setFreqs(iArr);
                        deviceInfo.setSoundCardEqInfo(eqInfo2);
                        break;
                    case 18:
                        EqInfo soundCardEqInfo = deviceInfo.getSoundCardEqInfo();
                        if (soundCardEqInfo != null) {
                            int i6 = attrData[0];
                            byte[] bArr9 = new byte[i6];
                            System.arraycopy(attrData, 1, bArr9, 0, i6);
                            soundCardEqInfo.setValue(bArr9);
                            deviceInfo.setSoundCardEqInfo(soundCardEqInfo);
                            this.b.onSoundCardEqChange(bluetoothDevice, soundCardEqInfo);
                        }
                        break;
                    case 19:
                        JL_Log.d(c, "parsePublicData", "SYS_INFO_ATTR_SOUND_CARD : " + CHexConver.byte2HexStr(attrData));
                        if (attrData.length >= 8) {
                            long jBytesToLong = CHexConver.bytesToLong(attrData, 0, 8);
                            JL_Log.d(c, "parsePublicData", "mask  ->  " + CHexConver.byte2HexStr(attrData, 8));
                            byte[] bArr10 = new byte[0];
                            if (attrData.length > 8) {
                                int length2 = attrData.length - 8;
                                byte[] bArr11 = new byte[length2];
                                System.arraycopy(attrData, 8, bArr11, 0, length2);
                                JL_Log.d(c, "parsePublicData", "values  ->  " + CHexConver.byte2HexStr(bArr11));
                                bArr10 = bArr11;
                            }
                            this.b.onSoundCardStatusChange(bluetoothDevice, jBytesToLong, bArr10);
                        }
                        break;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo;
        Iterator<AttrBean> it;
        BluetoothDevice bluetoothDevice2;
        String str;
        byte b;
        byte b2;
        int iBytesToInt;
        int i;
        String str2;
        AlarmBean alarmBean;
        List<AlarmBean> alarmBeans;
        RcspDataHandler rcspDataHandler = this;
        BluetoothDevice bluetoothDevice3 = bluetoothDevice;
        if (list == null || (deviceInfo = rcspDataHandler.a.getDeviceInfo(bluetoothDevice3)) == null) {
            return;
        }
        int iB = rcspDataHandler.b(list);
        Iterator<AttrBean> it2 = list.iterator();
        while (it2.hasNext()) {
            AttrBean next = it2.next();
            byte[] attrData = next.getAttrData();
            if (attrData == 0 || attrData.length == 0) {
                it = it2;
                bluetoothDevice2 = bluetoothDevice3;
            } else {
                byte type = next.getType();
                int i2 = 5;
                int i3 = 1;
                boolean z = false;
                if (type != 1) {
                    if (type == 2 || type == 3) {
                        int iByteToInt = CHexConver.byteToInt(attrData[0]);
                        if (deviceInfo.getAlarmListInfo() != null && (alarmBeans = deviceInfo.getAlarmListInfo().getAlarmBeans()) != null && !alarmBeans.isEmpty()) {
                            Iterator<AlarmBean> it3 = alarmBeans.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    alarmBean = null;
                                    break;
                                }
                                AlarmBean next2 = it3.next();
                                if (iByteToInt == next2.getIndex()) {
                                    alarmBean = next2.copy();
                                    break;
                                }
                            }
                        } else {
                            alarmBean = null;
                            break;
                        }
                        if (alarmBean == null) {
                            alarmBean = new AlarmBean();
                            alarmBean.setIndex((byte) iByteToInt);
                            alarmBean.setName("Alarm");
                            Calendar calendar = Calendar.getInstance();
                            alarmBean.setHour((byte) calendar.get(11));
                            alarmBean.setMin((byte) calendar.get(12));
                        }
                        JL_Log.e(c, "parseRTCData", "index = " + iByteToInt + " " + alarmBean);
                        if (next.getType() == 3) {
                            rcspDataHandler.b.onAlarmStop(bluetoothDevice3, alarmBean);
                        } else {
                            rcspDataHandler.b.onAlarmNotify(bluetoothDevice3, alarmBean);
                        }
                    } else if (type == 4) {
                        JL_Log.d(c, "parseRTCData", "parse alarm ver " + CHexConver.byte2HexStr(attrData));
                        deviceInfo.setAlarmVersion(iB);
                        if (deviceInfo.getAlarmListInfo() == null) {
                            deviceInfo.setAlarmListInfo(new AlarmListInfo(iB, new ArrayList()));
                        } else {
                            deviceInfo.getAlarmListInfo().setVersion(iB);
                        }
                    } else if (type == 5) {
                        JL_Log.i(c, "parseRTCData", "parse alarm default bell " + CHexConver.byte2HexStr(attrData));
                        int i4 = attrData[0] & 15;
                        ArrayList arrayList = new ArrayList();
                        while (i3 < attrData.length && arrayList.size() < i4) {
                            int i5 = i3 + 1;
                            int i6 = attrData[i3];
                            int i7 = i3 + 2;
                            int i8 = attrData[i5];
                            byte[] bArr = new byte[i8];
                            System.arraycopy(attrData, i7, bArr, 0, i8);
                            i3 = i7 + i8;
                            arrayList.add(new DefaultAlarmBell(i6, new String(bArr), false));
                        }
                        deviceInfo.setAlarmDefaultBells(arrayList);
                        rcspDataHandler.b.onAlarmDefaultBellListChange(bluetoothDevice3, arrayList);
                    } else if (type == 7) {
                        deviceInfo.setAlarmExpandFlag(attrData[0]);
                    }
                    it = it2;
                    bluetoothDevice2 = bluetoothDevice3;
                } else {
                    int iByteToInt2 = CHexConver.byteToInt(attrData[0]);
                    ArrayList arrayList2 = new ArrayList();
                    if (iByteToInt2 <= 0) {
                        it = it2;
                        break;
                    }
                    int i9 = 1;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= iByteToInt2 || attrData.length - i9 <= i2) {
                            it = it2;
                            break;
                        }
                        byte b3 = attrData[i9];
                        int i11 = i9 + 2;
                        boolean z2 = CHexConver.byteToInt(attrData[i9 + 1]) == i3 ? i3 : z;
                        byte b4 = attrData[i11];
                        byte b5 = attrData[i9 + 3];
                        byte b6 = attrData[i9 + 4];
                        int i12 = i9 + 6;
                        int iByteToInt3 = CHexConver.byteToInt(attrData[i9 + 5]);
                        it = it2;
                        if (iByteToInt3 > attrData.length - i12) {
                            break;
                        }
                        if (iByteToInt3 > 0) {
                            try {
                                str = new String(attrData, i12, iByteToInt3);
                                i12 += iByteToInt3;
                            } catch (Exception e) {
                                e.printStackTrace();
                                str = null;
                            }
                        } else {
                            str = null;
                        }
                        if (iB == 0) {
                            iB = deviceInfo.getAlarmVersion();
                        }
                        int length = attrData.length - i12;
                        int i13 = iByteToInt2;
                        if (iB != 1 || length <= 6) {
                            b = 0;
                            b2 = 0;
                            iBytesToInt = 0;
                        } else {
                            byte b7 = attrData[i12];
                            byte b8 = attrData[i12 + 1];
                            byte[] bArr2 = new byte[4];
                            System.arraycopy(attrData, i12 + 2, bArr2, 0, 4);
                            iBytesToInt = CHexConver.bytesToInt(bArr2);
                            int i14 = i12 + 6;
                            i12 += 7;
                            int i15 = attrData[i14] & 255;
                            if (i15 <= attrData.length - i12) {
                                try {
                                    i = i12 + i15;
                                    b2 = b8;
                                    str2 = new String(attrData, i12, i15);
                                    b = b7;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    b = b7;
                                    b2 = b8;
                                    i = i12;
                                    str2 = Constants.STR_EMPTY;
                                }
                                arrayList2.add(new AlarmBean().setVersion(iB).setIndex(b3).setRepeatMode(b4).setName(str).setDevIndex(b2).setHour(b5).setMin(b6).setBellCluster(iBytesToInt).setBellName(str2).setBellType(b).setOpen(z2));
                                i10++;
                                it2 = it;
                                i9 = i;
                                iByteToInt2 = i13;
                                i2 = 5;
                                i3 = 1;
                                z = false;
                            }
                            b = b7;
                            b2 = b8;
                        }
                        i = i12;
                        str2 = Constants.STR_EMPTY;
                        arrayList2.add(new AlarmBean().setVersion(iB).setIndex(b3).setRepeatMode(b4).setName(str).setDevIndex(b2).setHour(b5).setMin(b6).setBellCluster(iBytesToInt).setBellName(str2).setBellType(b).setOpen(z2));
                        i10++;
                        it2 = it;
                        i9 = i;
                        iByteToInt2 = i13;
                        i2 = 5;
                        i3 = 1;
                        z = false;
                    }
                    AlarmListInfo alarmListInfo = new AlarmListInfo(arrayList2);
                    alarmListInfo.setVersion(iB);
                    deviceInfo.setAlarmListInfo(alarmListInfo);
                    rcspDataHandler = this;
                    bluetoothDevice2 = bluetoothDevice;
                    rcspDataHandler.b.onAlarmListChange(bluetoothDevice2, alarmListInfo);
                }
            }
            bluetoothDevice3 = bluetoothDevice2;
            it2 = it;
        }
    }

    public void parseAttrMessage(BluetoothDevice bluetoothDevice, byte b, List<AttrBean> list) {
        if (bluetoothDevice == null || list == null) {
            return;
        }
        if (b == -1) {
            e(bluetoothDevice, list);
            return;
        }
        if (b == 0) {
            b(bluetoothDevice, list);
            return;
        }
        if (b == 1) {
            d(bluetoothDevice, list);
            return;
        }
        if (b == 2) {
            f(bluetoothDevice, list);
        } else if (b == 3) {
            a(bluetoothDevice, list);
        } else {
            if (b != 4) {
                return;
            }
            c(bluetoothDevice, list);
        }
    }

    public void parseHealthSetting(BluetoothDevice bluetoothDevice, List<AttrBean> list) {
        DeviceInfo deviceInfo = this.a.getDeviceInfo();
        if (deviceInfo == null) {
            return;
        }
        HealthSettingInfo healthSettingInfo = deviceInfo.getHealthSettingInfo();
        if (healthSettingInfo == null) {
            healthSettingInfo = new HealthSettingInfo();
            deviceInfo.setHealthSettingInfo(healthSettingInfo);
        }
        for (AttrBean attrBean : list) {
            byte[] attrData = attrBean.getAttrData();
            healthSettingInfo.setFuncFlag(attrBean.getType());
            switch (attrBean.getType()) {
                case 1:
                    healthSettingInfo.setSensorInfo(new SensorInfo(CHexConver.bytesToInt(attrData, 0, 2)));
                    break;
                case 2:
                    healthSettingInfo.setSedentaryReminder(new SedentaryReminder(attrData));
                    break;
                case 3:
                    healthSettingInfo.setHeartRateMeasure(new HeartRateMeasure(attrData));
                    break;
                case 4:
                    healthSettingInfo.setExerciseHeartRateReminder(new ExerciseHeartRateReminder(attrData));
                    break;
                case 5:
                    healthSettingInfo.setAutomaticPressureDetection(new AutomaticPressureDetection(attrData));
                    break;
                case 6:
                    healthSettingInfo.setSleepDetection(new SleepDetection(attrData));
                    break;
                case 7:
                    healthSettingInfo.setFallDetection(new FallDetection(attrData));
                    break;
                case 8:
                    healthSettingInfo.setLiftWristDetection(new LiftWristDetection(attrData));
                    break;
                case 9:
                    healthSettingInfo.setUserInfo(new UserInfo(attrData));
                    break;
                case 10:
                    healthSettingInfo.setDisconnectReminder(new DisconnectReminder(attrData));
                    break;
                case 11:
                    healthSettingInfo.setBloodOxygenMeasurementAlert(new BloodOxygenMeasurementAlert(attrData));
                    break;
                case 12:
                    healthSettingInfo.setEmergencyContact(new EmergencyContact(attrData));
                    break;
            }
            this.b.onHealthSettingChange(bluetoothDevice, healthSettingInfo.cloneObject());
        }
    }

    public final void a(BluetoothDevice bluetoothDevice, byte[] bArr) {
        JL_Log.d(c, "parseFixedLenData", "data ---> " + CHexConver.byte2HexStr(bArr));
        DeviceInfo deviceInfo = this.a.getDeviceInfo(bluetoothDevice);
        if (deviceInfo == null) {
            return;
        }
        ExpandFunction expandFunction = deviceInfo.getExpandFunction();
        int i = 4;
        if (bArr.length >= 4) {
            int iBytesToInt = CHexConver.bytesToInt(bArr, 0, 4);
            if (expandFunction == null) {
                expandFunction = new ExpandFunction();
                expandFunction.setMask(iBytesToInt);
            } else {
                expandFunction.setMask(expandFunction.getMask() | iBytesToInt);
            }
            if ((iBytesToInt & 1) == 1 && bArr.length >= 9) {
                byte[] bArr2 = new byte[5];
                System.arraycopy(bArr, 4, bArr2, 0, 5);
                expandFunction.putData(0, bArr2);
                this.b.onExpandFunction(bluetoothDevice, 0, bArr2);
                ReverberationParam data = ReverberationParam.parseData(bArr2);
                if (data != null) {
                    this.b.onReverberation(bluetoothDevice, data);
                }
                i = 9;
            }
            if ((iBytesToInt & 2) == 2 && bArr.length >= i + 2) {
                byte[] bArr3 = new byte[2];
                System.arraycopy(bArr, i, bArr3, 0, 2);
                expandFunction.putData(1, bArr3);
                this.b.onExpandFunction(bluetoothDevice, 1, bArr3);
                DynamicLimiterParam data2 = DynamicLimiterParam.parseData(bArr3);
                if (data2 != null) {
                    this.b.onDynamicLimiter(bluetoothDevice, data2);
                }
            }
            deviceInfo.setExpandFunction(expandFunction);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    public final EqPresetInfo a(List<AttrBean> list) {
        for (AttrBean attrBean : list) {
            if (attrBean.getType() == 12) {
                if (attrBean == null) {
                    return null;
                }
                return a(attrBean);
            }
        }
        attrBean = null;
        if (attrBean == null) {
            return null;
        }
        return a(attrBean);
    }

    public final EqPresetInfo a(AttrBean attrBean) {
        EqPresetInfo eqPresetInfo = new EqPresetInfo();
        byte[] attrData = attrBean.getAttrData();
        ArrayList arrayList = new ArrayList();
        int i = attrData[0];
        int[] iArr = new int[i];
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = ((attrData[i2] & 255) << 8) | (attrData[i2 + 1] & 255);
            i2 += 2;
        }
        for (int i4 = 0; i4 < 7; i4++) {
            byte[] bArr = new byte[i];
            byte b = (byte) (attrData[i2] & 127);
            System.arraycopy(attrData, i2 + 1, bArr, 0, i);
            EqInfo eqInfo = new EqInfo(b, bArr, iArr);
            eqInfo.setDynamic((attrData[i2] & 128) == 128);
            arrayList.add(eqInfo);
            i2 += i + 1;
        }
        eqPresetInfo.setNumber(i);
        eqPresetInfo.setFreqs(iArr);
        eqPresetInfo.setEqInfos(arrayList);
        JL_Log.d(c, "parseEqPresetInfo", "eq--->" + eqPresetInfo);
        return eqPresetInfo;
    }

    public final int b(List<AttrBean> list) {
        for (AttrBean attrBean : list) {
            if (attrBean.getType() == 4) {
                return attrBean.getAttrData()[0] & 7;
            }
        }
        return 0;
    }
}
