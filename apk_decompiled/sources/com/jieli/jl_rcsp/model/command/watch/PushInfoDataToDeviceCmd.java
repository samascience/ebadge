package com.jieli.jl_rcsp.model.command.watch;

import com.jieli.jl_rcsp.exception.ParseDataException;
import com.jieli.jl_rcsp.interfaces.cmd.IDataOp;
import com.jieli.jl_rcsp.model.base.BaseParameter;
import com.jieli.jl_rcsp.model.base.CommandWithParamAndResponse;
import com.jieli.jl_rcsp.model.base.CommonResponse;
import com.jieli.jl_rcsp.util.CHexConver;
import com.jieli.jl_rcsp.util.RcspUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class PushInfoDataToDeviceCmd extends CommandWithParamAndResponse<Param, Response> {

    public static class MessageData extends BaseInfo {
        private byte[] data;
        private int seq;

        public MessageData(int i, byte[] bArr) {
            super((byte) 2, (byte) 0);
            this.seq = i;
            this.data = bArr;
            setMessageData(beanToData());
        }

        private byte[] beanToData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(this.seq);
                byte[] bArr = this.data;
                if (bArr != null) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public byte[] getData() {
            return this.data;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd.BaseInfo
        public int getMessageType() {
            return 2;
        }

        public int getSeq() {
            return this.seq;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd.BaseInfo, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            byte[] messageData;
            this.seq = -1;
            this.data = new byte[0];
            int i = super.parse(bArr);
            if (i > 0 && (messageData = getMessageData()) != null && messageData.length != 0) {
                this.seq = CHexConver.byteToInt(messageData[0]);
                if (messageData.length > 1) {
                    int length = messageData.length - 1;
                    byte[] bArr2 = new byte[length];
                    this.data = bArr2;
                    System.arraycopy(messageData, 1, bArr2, 0, length);
                }
            }
            return i;
        }

        public String toString() {
            return "MessageData{seq=" + this.seq + ", data=" + CHexConver.byte2HexStr(this.data) + '}';
        }
    }

    public static class Param<T extends BaseInfo> extends BaseParameter {
        private final T baseInfo;

        public Param(T t) {
            this.baseInfo = t;
        }

        public T getBaseInfo() {
            return this.baseInfo;
        }

        @Override // com.jieli.jl_rcsp.model.base.BaseParameter, com.jieli.jl_rcsp.interfaces.cmd.IParamBase
        public byte[] getParamData() {
            T t = this.baseInfo;
            return t == null ? new byte[0] : t.toData();
        }
    }

    public static class RemoveMsg extends BaseInfo {
        private byte[] appPackageName;
        private byte[] timestamp;

        public RemoveMsg(String str, long j) {
            super((byte) 3, (byte) 0);
            this.appPackageName = RcspUtil.getData(str, 31);
            this.timestamp = CHexConver.intToBigBytes(RcspUtil.time2Int(j));
            setMessageData(beanToData());
        }

        private byte[] beanToData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(RcspUtil.packLTVPacket2(0, this.timestamp));
                byteArrayOutputStream.write(RcspUtil.packLTVPacket2(1, this.appPackageName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public byte[] getAppPackageName() {
            return this.appPackageName;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd.BaseInfo
        public int getMessageType() {
            return 3;
        }

        public byte[] getTimestamp() {
            return this.timestamp;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd.BaseInfo, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            byte[] messageData;
            this.appPackageName = new byte[0];
            this.timestamp = new byte[0];
            int i = super.parse(bArr);
            if (i > 0 && (messageData = getMessageData()) != null && messageData.length != 0) {
                if (messageData.length < 4) {
                    return -1;
                }
                byte[] bArr2 = new byte[4];
                this.timestamp = bArr2;
                System.arraycopy(messageData, 0, bArr2, 0, 4);
                if (messageData.length > 4) {
                    int length = messageData.length - 4;
                    byte[] bArr3 = new byte[length];
                    this.appPackageName = bArr3;
                    System.arraycopy(messageData, 4, bArr3, 0, length);
                }
            }
            return i;
        }
    }

    public static class Weather extends BaseInfo {
        private String city;
        private byte humidity;
        private String province;
        private byte temperature;
        private long time;
        private byte weather;
        private byte windDirection;
        private byte windPower;

        public Weather(byte[] bArr) throws ParseDataException {
            super(bArr);
        }

        private byte[] beanToData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                String str = this.province;
                int length = 0;
                int length2 = str == null ? 0 : str.getBytes().length;
                byteArrayOutputStream.write(length2);
                if (length2 > 0) {
                    byteArrayOutputStream.write(this.province.getBytes());
                }
                String str2 = this.city;
                if (str2 != null) {
                    length = str2.getBytes().length;
                }
                byteArrayOutputStream.write(length);
                if (length > 0) {
                    byteArrayOutputStream.write(this.city.getBytes());
                }
                byteArrayOutputStream.write(this.weather);
                byteArrayOutputStream.write(this.temperature);
                byteArrayOutputStream.write(this.humidity);
                byteArrayOutputStream.write(this.windDirection);
                byteArrayOutputStream.write(this.windPower);
                byteArrayOutputStream.write(CHexConver.intToBigBytes(RcspUtil.time2Int(this.time)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public String getCity() {
            return this.city;
        }

        public byte getHumidity() {
            return this.humidity;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd.BaseInfo
        public int getMessageType() {
            return 1;
        }

        public String getProvince() {
            return this.province;
        }

        public byte getTemperature() {
            return this.temperature;
        }

        public long getTime() {
            return this.time;
        }

        public byte getWeather() {
            return this.weather;
        }

        public byte getWindDirection() {
            return this.windDirection;
        }

        public byte getWindPower() {
            return this.windPower;
        }

        @Override // com.jieli.jl_rcsp.model.command.watch.PushInfoDataToDeviceCmd.BaseInfo, com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            byte[] messageData;
            int i = super.parse(bArr);
            if (i > 0 && (messageData = getMessageData()) != null && messageData.length != 0) {
                if (messageData.length < 11) {
                    return -1;
                }
                int iByteToInt = CHexConver.byteToInt(messageData[0]);
                int i2 = iByteToInt + 1;
                if (i2 > messageData.length) {
                    return i;
                }
                try {
                    this.province = new String(messageData, 1, iByteToInt);
                    int iByteToInt2 = CHexConver.byteToInt(messageData[i2]);
                    int i3 = i2 + iByteToInt2;
                    if (i3 > messageData.length) {
                        return i;
                    }
                    this.city = new String(messageData, i2, iByteToInt2);
                    int i4 = i3 + 1;
                    if (i4 > messageData.length) {
                        return i;
                    }
                    this.weather = messageData[i3];
                    int i5 = i3 + 2;
                    if (i5 > messageData.length) {
                        return i;
                    }
                    this.temperature = messageData[i4];
                    int i6 = i3 + 3;
                    if (i6 > messageData.length) {
                        return i;
                    }
                    this.humidity = messageData[i5];
                    int i7 = i3 + 4;
                    if (i7 > messageData.length) {
                        return i;
                    }
                    this.windDirection = messageData[i6];
                    int i8 = i3 + 5;
                    if (i8 > messageData.length) {
                        return i;
                    }
                    this.windPower = messageData[i7];
                    if (i3 + 9 > messageData.length) {
                        return i;
                    }
                    this.time = RcspUtil.intToTime(CHexConver.bytesToInt(messageData, i8, 4));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }

        public String toString() {
            return "Weather{province=" + this.province + ", city=" + this.city + ", weather=" + ((int) this.weather) + ", temperature=" + ((int) this.temperature) + ", humidity=" + ((int) this.humidity) + ", windDirection=" + ((int) this.windDirection) + ", windPower=" + ((int) this.windPower) + ", time=" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).format(new Date(this.time)) + '}';
        }

        public Weather(String str, String str2, byte b, byte b2, byte b3, byte b4, byte b5, long j) {
            super((byte) 1, (byte) 0);
            this.province = str;
            this.city = str2;
            this.weather = b;
            this.temperature = b2;
            this.humidity = b3;
            this.windDirection = b4;
            this.windPower = b5;
            this.time = j;
            setMessageData(beanToData());
        }
    }

    public PushInfoDataToDeviceCmd(Param param) {
        super(161, PushInfoDataToDeviceCmd.class.getSimpleName(), param);
    }

    public static class Response extends CommonResponse implements IDataOp {
        public int reason;
        public byte type;

        public Response(byte[] bArr) throws ParseDataException {
            int i = parse(bArr);
            if (i >= 0) {
                setRawData(bArr);
                return;
            }
            throw new ParseDataException(1, "Failed to parse data. size = " + i, bArr);
        }

        public int getReason() {
            return this.reason;
        }

        public byte getType() {
            return this.type;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            if (bArr.length < 2) {
                return -1;
            }
            this.type = bArr[0];
            this.reason = CHexConver.byteToInt(bArr[1]);
            return 2;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.type);
            byteArrayOutputStream.write(this.reason);
            return byteArrayOutputStream.toByteArray();
        }

        public Response(byte b, int i) {
            this.reason = i;
            this.type = b;
        }
    }

    public static abstract class BaseInfo implements IDataOp {
        private byte[] messageData;
        private byte type;
        private byte version;

        public BaseInfo(byte[] bArr) throws ParseDataException {
            int messageType;
            int i = parse(bArr);
            if (i < 0) {
                throw new ParseDataException(1, "Failed to parse data. size = " + i, bArr);
            }
            if (i > 0 && (messageType = getMessageType()) != -1 && this.type != messageType) {
                throw new ParseDataException(2, String.format(Locale.ENGLISH, "Data type[%d] does not match the target type[%d].", Byte.valueOf(this.type), Integer.valueOf(messageType)));
            }
        }

        private byte[] toParamData() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(this.type);
                byteArrayOutputStream.write(this.version);
                byte[] bArr = this.messageData;
                if (bArr != null) {
                    byteArrayOutputStream.write(bArr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        }

        public byte[] getMessageData() {
            return this.messageData;
        }

        public abstract int getMessageType();

        public byte getType() {
            return this.type;
        }

        public byte getVersion() {
            return this.version;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public int parse(byte[] bArr) {
            this.messageData = new byte[0];
            if (bArr == null || bArr.length == 0) {
                return 0;
            }
            if (bArr.length < 2) {
                return -1;
            }
            this.type = bArr[0];
            this.version = bArr[1];
            if (bArr.length > 2) {
                int length = bArr.length - 2;
                byte[] bArr2 = new byte[length];
                this.messageData = bArr2;
                System.arraycopy(bArr, 2, bArr2, 0, length);
            }
            return bArr.length;
        }

        public void setMessageData(byte[] bArr) {
            this.messageData = bArr;
        }

        @Override // com.jieli.jl_rcsp.interfaces.cmd.IDataOp
        public byte[] toData() {
            return toParamData();
        }

        public BaseInfo(byte b, byte b2) {
            this.type = b;
            this.version = b2;
        }
    }
}
