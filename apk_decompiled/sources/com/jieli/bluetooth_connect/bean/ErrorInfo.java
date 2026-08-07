package com.jieli.bluetooth_connect.bean;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ErrorInfo {
    private int code;
    private BluetoothDevice device;
    private String message;

    public static class ErrorMsg {
        static final String KEY_CODE = "code";
        static final String KEY_DESC = "desc";
        static final String KEY_MESSAGE = "message";
        static final String KEY_SUB_CODE = "sub_code";
        private final int code;
        private final String desc;
        private final String message;
        private final int subCode;

        public ErrorMsg(int i) {
            this(i, ErrorInfo.getErrDesc(i), 0, null);
        }

        public static ErrorMsg parseJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(KEY_CODE) && jSONObject.has(KEY_SUB_CODE)) {
                    String string = Constants.STR_EMPTY;
                    if (jSONObject.has("desc")) {
                        string = jSONObject.getString("desc");
                    }
                    return new ErrorMsg(jSONObject.getInt(KEY_CODE), string, jSONObject.getInt(KEY_SUB_CODE), jSONObject.has(KEY_MESSAGE) ? jSONObject.getString(KEY_MESSAGE) : null);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        public int getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getMessage() {
            return this.message;
        }

        public int getSubCode() {
            return this.subCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("\"");
            sb.append(KEY_CODE);
            sb.append("\":");
            sb.append(this.code);
            if (!TextUtils.isEmpty(this.desc)) {
                sb.append(", \"");
                sb.append("desc");
                sb.append("\":\"");
                sb.append(this.desc);
                sb.append("\"");
            }
            sb.append(", \"");
            sb.append(KEY_SUB_CODE);
            sb.append("\":");
            sb.append(this.subCode);
            if (!TextUtils.isEmpty(this.message)) {
                sb.append(", \"");
                sb.append(KEY_MESSAGE);
                sb.append("\":\"");
                sb.append(this.message);
                sb.append("\"");
            }
            sb.append("}");
            return sb.toString();
        }

        public ErrorMsg(int i, int i2, String str) {
            this(i, ErrorInfo.getErrDesc(i), i2, str);
        }

        public ErrorMsg(int i, String str, int i2, String str2) {
            this.code = i;
            this.subCode = i2;
            this.desc = str;
            this.message = str2;
        }
    }

    public ErrorInfo() {
    }

    public static ErrorInfo buildError(int i) {
        return new ErrorInfo(i, new ErrorMsg(i).toString());
    }

    public static String getErrDesc(int i) {
        switch (i) {
            case 0:
                return "Success.";
            case 1:
                return "Parameter Error.";
            case 2:
                return "Bluetooth is not on.";
            case 3:
                return "Bluetooth pairing/unpairing operation failed.";
            case 4:
                return "Bluetooth pairing/unpairing timeout.";
            case 5:
                return "Bluetooth pairing/unpairing in progress.";
            case 6:
                return "Call reflection method exception.";
            case 7:
                return "Operation in progress.";
            case 8:
                return "A scan error occurred.";
            case 9:
                return "Timeout Exception.";
            case 10:
                return "The remote device is not connected.";
            default:
                return Constants.STR_EMPTY;
        }
    }

    public int getCode() {
        return this.code;
    }

    public BluetoothDevice getDevice() {
        return this.device;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setDevice(BluetoothDevice bluetoothDevice) {
        this.device = bluetoothDevice;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "ErrorInfo{code=" + this.code + ", message='" + this.message + "', device=" + this.device + '}';
    }

    public ErrorInfo(int i, String str) {
        setCode(i);
        setMessage(str);
    }

    public static ErrorInfo buildError(int i, int i2, String str) {
        return new ErrorInfo(i, new ErrorMsg(i, i2, str).toString());
    }
}
