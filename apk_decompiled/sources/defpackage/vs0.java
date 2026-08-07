package defpackage;

import com.jieli.jl_rcsp.model.SportHealthConfigure;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes4.dex */
public abstract class vs0 {
    public static String a(int i) {
        if (i == 26) {
            return "HCI ERROR UNSUPPORTED REMOTE FEATURE";
        }
        if (i == 30) {
            return "HCI ERROR INVALID LMP PARAM";
        }
        if (i == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i == 42) {
            return "HCI ERROR DIFF TRANSACTION COLLISION";
        }
        if (i == 257) {
            return "TOO MANY OPEN CONNECTIONS";
        }
        if (i == 58) {
            return "GATT CONTROLLER BUSY";
        }
        if (i == 59) {
            return "GATT UNACCEPT CONN INTERVAL";
        }
        switch (i) {
            case 1:
                return "GATT INVALID HANDLE";
            case 2:
                return "GATT READ NOT PERMIT";
            case 3:
                return "GATT WRITE NOT PERMIT";
            case 4:
                return "GATT INVALID PDU";
            case 5:
                return "GATT INSUF AUTHENTICATION";
            case 6:
                return "GATT REQ NOT SUPPORTED";
            case 7:
                return "GATT INVALID OFFSET";
            case 8:
                return "GATT INSUF AUTHORIZATION";
            case 9:
                return "GATT PREPARE Q FULL";
            case 10:
                return "GATT NOT FOUND";
            case 11:
                return "GATT NOT LONG";
            case 12:
                return "GATT INSUF KEY SIZE";
            case 13:
                return "GATT INVALID ATTR LEN";
            case 14:
                return "GATT ERR UNLIKELY";
            case 15:
                return "GATT INSUF ENCRYPTION";
            case 16:
                return "GATT UNSUPPORT GRP TYPE";
            case 17:
                return "GATT INSUF RESOURCE";
            default:
                switch (i) {
                    case 128:
                        return "GATT NO RESOURCES";
                    case Opcodes.LOR /* 129 */:
                        return "GATT INTERNAL ERROR";
                    case 130:
                        return "GATT WRONG STATE";
                    case Opcodes.LXOR /* 131 */:
                        return "GATT DB FULL";
                    case Opcodes.IINC /* 132 */:
                        return "GATT BUSY";
                    case 133:
                        return "GATT ERROR";
                    case Opcodes.I2F /* 134 */:
                        return "GATT CMD STARTED";
                    case Opcodes.I2D /* 135 */:
                        return "GATT ILLEGAL PARAMETER";
                    case Opcodes.L2I /* 136 */:
                        return "GATT PENDING";
                    case Opcodes.L2F /* 137 */:
                        return "GATT AUTH FAIL";
                    case Opcodes.L2D /* 138 */:
                        return "GATT MORE";
                    case Opcodes.F2I /* 139 */:
                        return "GATT INVALID CFG";
                    case Opcodes.F2L /* 140 */:
                        return "GATT SERVICE STARTED";
                    case Opcodes.F2D /* 141 */:
                        return "GATT ENCRYPTED NO MITM";
                    case Opcodes.D2I /* 142 */:
                        return "GATT NOT ENCRYPTED";
                    case Opcodes.D2L /* 143 */:
                        return "GATT CONGESTED";
                    default:
                        switch (i) {
                            case 253:
                                return "GATT CCCD CFG ERROR";
                            case SportHealthConfigure.CONFIGURE_TYPE_SPORT_MODE /* 254 */:
                                return "GATT PROCEDURE IN PROGRESS";
                            case 255:
                                return "GATT VALUE OUT OF RANGE";
                            default:
                                switch (i) {
                                    case 4096:
                                        return "DFU DEVICE DISCONNECTED";
                                    case 4097:
                                        return "DFU FILE NOT FOUND";
                                    case 4098:
                                        return "DFU FILE ERROR";
                                    case 4099:
                                        return "DFU NOT A VALID HEX FILE";
                                    case 4100:
                                        return "DFU IO EXCEPTION";
                                    case DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED /* 4101 */:
                                        return "DFU SERVICE DISCOVERY NOT STARTED";
                                    case DfuBaseService.ERROR_SERVICE_NOT_FOUND /* 4102 */:
                                        return "DFU CHARACTERISTICS NOT FOUND";
                                    default:
                                        switch (i) {
                                            case DfuBaseService.ERROR_INVALID_RESPONSE /* 4104 */:
                                                return "DFU INVALID RESPONSE";
                                            case DfuBaseService.ERROR_FILE_TYPE_UNSUPPORTED /* 4105 */:
                                                return "DFU FILE TYPE NOT SUPPORTED";
                                            case DfuBaseService.ERROR_BLUETOOTH_DISABLED /* 4106 */:
                                                return "BLUETOOTH ADAPTER DISABLED";
                                            case DfuBaseService.ERROR_INIT_PACKET_REQUIRED /* 4107 */:
                                            case DfuBaseService.ERROR_FILE_SIZE_INVALID /* 4108 */:
                                                return "DFU INIT PACKET REQUIRED";
                                            case DfuBaseService.ERROR_CRC_ERROR /* 4109 */:
                                                return "DFU CRC ERROR";
                                            case DfuBaseService.ERROR_DEVICE_NOT_BONDED /* 4110 */:
                                                return "DFU DEVICE NOT BONDED";
                                            default:
                                                return "UNKNOWN (" + i + ")";
                                        }
                                }
                        }
                }
        }
    }

    public static String b(int i) {
        if (i == 0) {
            return "SUCCESS";
        }
        if (i == 1) {
            return "GATT CONN L2C FAILURE";
        }
        if (i == 8) {
            return "GATT CONN TIMEOUT";
        }
        if (i == 19) {
            return "GATT CONN TERMINATE PEER USER";
        }
        if (i == 22) {
            return "GATT CONN TERMINATE LOCAL HOST";
        }
        if (i == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i == 62) {
            return "GATT CONN FAIL ESTABLISH";
        }
        if (i == 133) {
            return "GATT ERROR";
        }
        if (i == 256) {
            return "GATT CONN CANCEL ";
        }
        return "UNKNOWN (" + i + ")";
    }

    public static String c(int i) {
        int i2 = i & 3840;
        if (i2 == 256) {
            return pa1.a(i);
        }
        if (i2 == 512) {
            return hm2.a(i);
        }
        if (i2 == 1024) {
            return hm2.c(i);
        }
        if (i2 == 2048) {
            return hm2.b(i);
        }
        return "UNKNOWN (" + i + ")";
    }
}
