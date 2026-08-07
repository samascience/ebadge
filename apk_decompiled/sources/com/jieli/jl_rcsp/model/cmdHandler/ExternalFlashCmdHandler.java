package com.jieli.jl_rcsp.model.cmdHandler;

import android.bluetooth.BluetoothDevice;
import com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler;
import com.jieli.jl_rcsp.model.base.BasePacket;
import com.jieli.jl_rcsp.model.base.CommandBase;
import com.jieli.jl_rcsp.model.command.external_flash.ExtFlashIOCtrlNoResponseCmd;
import com.jieli.jl_rcsp.model.command.external_flash.ExternalFlashIOCtrlCmd;
import com.jieli.jl_rcsp.model.command.external_flash.GetExternalFlashMsgCmd;
import com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam;
import com.jieli.jl_rcsp.model.response.ExternalFlashIOCtrlResponse;
import com.jieli.jl_rcsp.model.response.ExternalFlashMsgResponse;
import com.jieli.jl_rcsp.tool.CommandHelper;
import com.jieli.jl_rcsp.util.CHexConver;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class ExternalFlashCmdHandler implements ICmdHandler {
    /* JADX WARN: Code duplicated, block: B:125:0x01ee A[PHI: r1
      0x01ee: PHI (r1v14 java.lang.String[]) = (r1v49 java.lang.String[]), (r1v50 java.lang.String[]), (r1v17 java.lang.String[]) binds: [B:107:0x01a2, B:109:0x01ab, B:115:0x01c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:59:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c4 A[PHI: r0 r5
      0x00c4: PHI (r0v64 byte[]) = (r0v52 byte[]), (r0v63 byte[]), (r0v52 byte[]) binds: [B:68:0x00d0, B:69:0x00d2, B:62:0x00b8] A[DONT_GENERATE, DONT_INLINE]
      0x00c4: PHI (r5v22 int) = (r5v21 int), (r5v21 int), (r5v24 int) binds: [B:68:0x00d0, B:69:0x00d2, B:62:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:78:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:83:0x012f  */
    /* JADX WARN: Code duplicated, block: B:85:0x013d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v55, types: [com.jieli.jl_rcsp.model.parameter.ExternalFlashIOCtrlParam] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.jieli.jl_rcsp.model.response.ExternalFlashIOCtrlResponse] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v2, types: [int] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2, types: [short] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [short] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // com.jieli.jl_rcsp.interfaces.cmd.ICmdHandler
    public CommandBase parseDataToCmd(BluetoothDevice bluetoothDevice, BasePacket basePacket) {
        ExternalFlashIOCtrlCmd externalFlashIOCtrlCmd;
        ExternalFlashIOCtrlParam externalFlashIOCtrlParam;
        int i;
        String strTrim;
        ?? ByteToInt;
        byte[] bArr;
        ?? r3;
        int iBytesToInt;
        int iBytesToInt2;
        int i2;
        int iBytesToInt3;
        int iByteToInt;
        int iByteToInt2;
        int iBytesToInt4;
        int iBytesToInt5;
        int iBytesToInt6;
        int iBytesToInt7;
        int iBytesToInt8;
        int iBytesToInt9;
        int iBytesToInt10;
        int iByteToInt3;
        ?? r4;
        int iBytesToInt11;
        int iBytesToInt12;
        int iBytesToInt13;
        String str = null;
        strArrSplit = null;
        strTrim = null;
        strTrim = null;
        strTrim = null;
        strTrim = null;
        strTrim = null;
        strTrim = null;
        strTrim = null;
        String strTrim2 = null;
        strArrSplit = null;
        strArrSplit = null;
        strArrSplit = null;
        String[] strArrSplit = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        if (basePacket == null) {
            return null;
        }
        int opCode = basePacket.getOpCode();
        if (opCode == 214 || opCode == 26) {
            byte[] paramData = basePacket.getParamData();
            int i3 = 0;
            if (basePacket.getType() != 1) {
                CommandBase command = CommandHelper.getInstance().getCommand(bluetoothDevice, opCode, basePacket.getOpCodeSn());
                if (opCode == 26) {
                    byte[] bArr2 = new byte[0];
                    if (command != null) {
                        externalFlashIOCtrlCmd = (ExternalFlashIOCtrlCmd) command;
                        externalFlashIOCtrlParam = (ExternalFlashIOCtrlParam) externalFlashIOCtrlCmd.getParam();
                    } else {
                        externalFlashIOCtrlCmd = new ExternalFlashIOCtrlCmd(new ExternalFlashIOCtrlParam());
                        externalFlashIOCtrlParam = null;
                    }
                    if (paramData == null || paramData.length <= 0) {
                        i = 0;
                        strTrim = null;
                        ByteToInt = 0;
                        ByteToInt = 0;
                    } else {
                        ByteToInt = CHexConver.byteToInt(paramData[0]);
                        if (externalFlashIOCtrlParam != null) {
                            int op = externalFlashIOCtrlParam.getOp();
                            if (op != 1) {
                                if (op == 3) {
                                    try {
                                        if (externalFlashIOCtrlParam.getWatchOp() == 0 || externalFlashIOCtrlParam.getWatchOp() == 5) {
                                            if (paramData.length > 1) {
                                                int length = paramData.length - 1;
                                                byte[] bArr3 = new byte[length];
                                                System.arraycopy(paramData, 1, bArr3, 0, length);
                                                String strTrim3 = new String(bArr3, StandardCharsets.UTF_8).trim();
                                                ByteToInt = 0;
                                                i = 0;
                                                strTrim = null;
                                                str = strTrim3;
                                            }
                                        } else if (externalFlashIOCtrlParam.getWatchOp() == 3 && paramData.length > 1) {
                                            int length2 = paramData.length - 1;
                                            byte[] bArr4 = new byte[length2];
                                            System.arraycopy(paramData, 1, bArr4, 0, length2);
                                            strTrim = new String(bArr4).trim();
                                            ByteToInt = 0;
                                            i = 0;
                                        }
                                    } catch (Exception unused) {
                                    }
                                } else if (op != 8) {
                                    if (op != 11) {
                                        if (op == 12 && paramData.length >= 5) {
                                            iBytesToInt = CHexConver.bytesToInt(paramData, 1, 4);
                                            i = iBytesToInt;
                                            ByteToInt = 0;
                                            strTrim = null;
                                        }
                                    } else if (paramData.length >= 5) {
                                        iBytesToInt = CHexConver.bytesToInt(paramData, 1, 4);
                                        if (paramData.length >= 7) {
                                            i = iBytesToInt;
                                            strTrim = null;
                                            ByteToInt = ByteToInt;
                                            ByteToInt = CHexConver.bytesToShort(paramData[5], paramData[6]);
                                        } else {
                                            i = iBytesToInt;
                                            ByteToInt = 0;
                                            strTrim = null;
                                        }
                                    }
                                } else if (paramData.length >= 3) {
                                    iBytesToInt = CHexConver.bytesToInt(paramData, 1, 2);
                                    i = iBytesToInt;
                                    ByteToInt = 0;
                                    strTrim = null;
                                }
                            } else if (paramData.length > 1) {
                                int length3 = paramData.length - 1;
                                bArr = new byte[length3];
                                i = 0;
                                System.arraycopy(paramData, 1, bArr, 0, length3);
                                bArr2 = bArr;
                                ByteToInt = i;
                                strTrim = null;
                            }
                            i = 0;
                            r3 = ByteToInt;
                            r3 = ByteToInt;
                            strTrim = str;
                            ByteToInt = r3;
                            ByteToInt = i;
                        } else {
                            i = 0;
                            if (paramData.length > 1) {
                                r3 = ByteToInt;
                                int length4 = paramData.length - 1;
                                bArr = new byte[length4];
                                System.arraycopy(paramData, 1, bArr, 0, length4);
                                try {
                                    String str2 = new String(paramData, 1, length4);
                                    bArr2 = bArr;
                                    ByteToInt = ByteToInt;
                                    ByteToInt = 0;
                                    strTrim = null;
                                    str = str2;
                                } catch (Exception unused2) {
                                    bArr2 = bArr;
                                    ByteToInt = i;
                                    strTrim = null;
                                }
                            } else {
                                r3 = ByteToInt;
                                strTrim = str;
                                ByteToInt = r3;
                                ByteToInt = i;
                            }
                        }
                    }
                    ExternalFlashIOCtrlResponse crc16 = new ExternalFlashIOCtrlResponse(ByteToInt).setData(bArr2).setSize(i).setFilePath(str).setVersion(strTrim).setCrc16(ByteToInt);
                    crc16.setRawData(paramData);
                    externalFlashIOCtrlCmd.setResponse(crc16);
                    externalFlashIOCtrlCmd.setStatus(basePacket.getStatus()).setOpCodeSn(basePacket.getOpCodeSn());
                    return externalFlashIOCtrlCmd;
                }
                if (opCode == 214) {
                    if (paramData == null || paramData.length < 4) {
                        iBytesToInt2 = 0;
                        i2 = 0;
                        iBytesToInt3 = 0;
                        iByteToInt = 0;
                        iByteToInt2 = 0;
                        iBytesToInt4 = 0;
                        iBytesToInt5 = 0;
                        iBytesToInt6 = 0;
                        iBytesToInt7 = 0;
                        iBytesToInt8 = 0;
                    } else {
                        iBytesToInt8 = CHexConver.bytesToInt(paramData, 0, 4);
                        if (paramData.length >= 8) {
                            iBytesToInt3 = CHexConver.bytesToInt(paramData, 4, 4);
                            if (paramData.length >= 9) {
                                iByteToInt2 = CHexConver.byteToInt(paramData[8]);
                                if (paramData.length >= 10) {
                                    iByteToInt = CHexConver.byteToInt(paramData[9]);
                                    if (paramData.length >= 12) {
                                        iBytesToInt5 = CHexConver.bytesToInt(paramData, 10, 2);
                                        if (paramData.length >= 14) {
                                            iBytesToInt4 = CHexConver.bytesToInt(paramData, 12, 2);
                                            if (paramData.length >= 16) {
                                                iBytesToInt6 = CHexConver.bytesToInt(paramData, 14, 2);
                                                if (paramData.length < 18 || paramData.length < (iBytesToInt10 = (iBytesToInt9 = CHexConver.bytesToInt(paramData, 16, 2)) + 18)) {
                                                    iBytesToInt2 = 0;
                                                    i2 = 0;
                                                    iBytesToInt7 = 0;
                                                } else {
                                                    try {
                                                        byte[] bArr5 = new byte[iBytesToInt9];
                                                        System.arraycopy(paramData, 18, bArr5, 0, iBytesToInt9);
                                                        strArrSplit = new String(bArr5).trim().split(",");
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                    int i4 = iBytesToInt9 + 20;
                                                    if (paramData.length >= i4) {
                                                        iBytesToInt2 = CHexConver.bytesToInt(paramData, iBytesToInt10, 2);
                                                        int i5 = iBytesToInt9 + 22;
                                                        if (paramData.length >= i5) {
                                                            iBytesToInt7 = CHexConver.bytesToInt(paramData, i4, 2);
                                                            if (paramData.length >= iBytesToInt9 + 24) {
                                                                int iBytesToInt14 = CHexConver.bytesToInt(paramData, i5, 2);
                                                                iBytesToInt8 = iBytesToInt8;
                                                                i2 = iBytesToInt14;
                                                            } else {
                                                                iBytesToInt8 = iBytesToInt8;
                                                                i2 = 0;
                                                            }
                                                        }
                                                    } else {
                                                        iBytesToInt2 = 0;
                                                    }
                                                    i2 = 0;
                                                    iBytesToInt7 = 0;
                                                }
                                            } else {
                                                iBytesToInt8 = iBytesToInt8;
                                                iBytesToInt2 = 0;
                                                i2 = 0;
                                            }
                                        } else {
                                            iBytesToInt8 = iBytesToInt8;
                                            iBytesToInt2 = 0;
                                            i2 = 0;
                                            iBytesToInt4 = 0;
                                        }
                                        iBytesToInt6 = 0;
                                        iBytesToInt7 = 0;
                                    } else {
                                        iBytesToInt8 = iBytesToInt8;
                                        iBytesToInt2 = 0;
                                        i2 = 0;
                                    }
                                } else {
                                    iBytesToInt8 = iBytesToInt8;
                                    iBytesToInt2 = 0;
                                    i2 = 0;
                                    iByteToInt = 0;
                                }
                                iBytesToInt4 = 0;
                                iBytesToInt5 = 0;
                                iBytesToInt6 = 0;
                                iBytesToInt7 = 0;
                            } else {
                                iBytesToInt2 = 0;
                                i2 = 0;
                            }
                        } else {
                            iBytesToInt2 = 0;
                            i2 = 0;
                            iBytesToInt3 = 0;
                        }
                        iByteToInt = 0;
                        iByteToInt2 = 0;
                        iBytesToInt4 = 0;
                        iBytesToInt5 = 0;
                        iBytesToInt6 = 0;
                        iBytesToInt7 = 0;
                    }
                    ExternalFlashMsgResponse screenHeight = new ExternalFlashMsgResponse().setFlashSize(iBytesToInt8).setSystem(iByteToInt2).setBlockSize(iBytesToInt4).setSysStatus(iByteToInt).setCluster(iBytesToInt6).setFatSize(iBytesToInt3).setMatchVersions(strArrSplit).setWatchVersionCode(iBytesToInt5).setReceiveMtu(iBytesToInt2).setScreenWidth(iBytesToInt7).setScreenHeight(i2);
                    screenHeight.setRawData(paramData);
                    GetExternalFlashMsgCmd getExternalFlashMsgCmd = command != null ? (GetExternalFlashMsgCmd) command : new GetExternalFlashMsgCmd();
                    getExternalFlashMsgCmd.setResponse(screenHeight);
                    getExternalFlashMsgCmd.setStatus(basePacket.getStatus()).setOpCodeSn(basePacket.getOpCodeSn());
                    return getExternalFlashMsgCmd;
                }
            } else {
                if (opCode == 26) {
                    byte[] bArr6 = new byte[0];
                    if (paramData != null && paramData.length > 0) {
                        iByteToInt3 = CHexConver.byteToInt(paramData[0]);
                        if (paramData.length > 1) {
                            int iByteToInt4 = CHexConver.byteToInt(paramData[1]);
                            boolean z = (iByteToInt4 & 1) == 0;
                            if (iByteToInt3 != 8) {
                                try {
                                    if (iByteToInt3 == 11) {
                                        if (paramData.length > 2) {
                                            strTrim2 = new String(paramData, 2, paramData.length - 2).trim();
                                            iBytesToInt13 = 0;
                                            iBytesToInt11 = iBytesToInt13;
                                            iBytesToInt12 = 0;
                                        } else {
                                            iBytesToInt11 = 0;
                                            iBytesToInt12 = 0;
                                        }
                                        i3 = iByteToInt4;
                                        r4 = iBytesToInt12;
                                    } else if (iByteToInt3 == 0) {
                                        if (paramData.length >= 6) {
                                            iBytesToInt12 = CHexConver.bytesToInt(paramData, 2, 4);
                                            if (paramData.length > 6) {
                                                int length5 = paramData.length - 6;
                                                byte[] bArr7 = new byte[length5];
                                                System.arraycopy(paramData, 6, bArr7, 0, length5);
                                                bArr6 = bArr7;
                                            }
                                            iBytesToInt11 = 0;
                                            i3 = iByteToInt4;
                                            r4 = 0;
                                        }
                                        iBytesToInt11 = 0;
                                        iBytesToInt12 = 0;
                                        i3 = iByteToInt4;
                                        r4 = iBytesToInt12;
                                    } else if (iByteToInt3 != 1) {
                                        if (iByteToInt3 != 2) {
                                            if (iByteToInt3 != 3) {
                                                if (iByteToInt3 != 4) {
                                                    if (iByteToInt3 == 5 && !z && paramData.length > 2) {
                                                        strTrim2 = new String(paramData, 2, paramData.length - 2).trim();
                                                        iBytesToInt13 = 0;
                                                        iBytesToInt11 = iBytesToInt13;
                                                        iBytesToInt12 = 0;
                                                    }
                                                } else if (paramData.length >= 6) {
                                                    iBytesToInt12 = CHexConver.bytesToInt(paramData, 2, 4);
                                                    if (paramData.length >= 8) {
                                                        iBytesToInt11 = CHexConver.bytesToInt(paramData, 6, 2);
                                                        i3 = iByteToInt4;
                                                        r4 = 0;
                                                    } else {
                                                        iBytesToInt11 = 0;
                                                        i3 = iByteToInt4;
                                                        r4 = 0;
                                                    }
                                                }
                                            } else if ((iByteToInt4 == 1 || iByteToInt4 == 2 || iByteToInt4 == 3 || iByteToInt4 == 4 || iByteToInt4 == 5) && paramData.length > 2) {
                                                strTrim2 = new String(paramData, 2, paramData.length - 2).trim();
                                                iBytesToInt13 = 0;
                                                iBytesToInt11 = iBytesToInt13;
                                                iBytesToInt12 = 0;
                                            }
                                            i3 = iByteToInt4;
                                            r4 = iBytesToInt12;
                                        } else {
                                            if (!z && paramData.length >= 6) {
                                                iBytesToInt13 = CHexConver.bytesToInt(paramData, 2, 4);
                                                if (paramData.length > 6) {
                                                    try {
                                                        strTrim2 = new String(paramData, 6, paramData.length - 6).trim();
                                                    } catch (Exception unused3) {
                                                    }
                                                }
                                                iBytesToInt11 = iBytesToInt13;
                                                iBytesToInt12 = 0;
                                            }
                                            i3 = iByteToInt4;
                                            r4 = iBytesToInt12;
                                        }
                                        iBytesToInt11 = 0;
                                        iBytesToInt12 = 0;
                                        i3 = iByteToInt4;
                                        r4 = iBytesToInt12;
                                    } else if (paramData.length >= 6) {
                                        iBytesToInt12 = CHexConver.bytesToInt(paramData, 2, 4);
                                        if (paramData.length >= 8) {
                                            iBytesToInt11 = CHexConver.bytesToInt(paramData, 6, 2);
                                            i3 = iByteToInt4;
                                            r4 = 0;
                                        } else {
                                            iBytesToInt11 = 0;
                                            i3 = iByteToInt4;
                                            r4 = 0;
                                        }
                                    } else {
                                        iBytesToInt11 = 0;
                                        iBytesToInt12 = 0;
                                        i3 = iByteToInt4;
                                        r4 = iBytesToInt12;
                                    }
                                } catch (Exception unused4) {
                                }
                            } else if (paramData.length > 4) {
                                byte[] bArr8 = new byte[2];
                                System.arraycopy(paramData, 2, bArr8, 0, 2);
                                short sBytesToShort = CHexConver.bytesToShort(bArr8[0], bArr8[1]);
                                iBytesToInt12 = 0;
                                i3 = iByteToInt4;
                                r4 = sBytesToShort;
                                iBytesToInt11 = 0;
                            } else {
                                iBytesToInt11 = 0;
                                iBytesToInt12 = 0;
                                i3 = iByteToInt4;
                                r4 = iBytesToInt12;
                            }
                        }
                        ExternalFlashIOCtrlParam crc17 = new ExternalFlashIOCtrlParam().setOp(iByteToInt3).setFlag(i3).setOffset(iBytesToInt12).setSize(iBytesToInt11).setData(bArr6).setFilePath(strTrim2).setCrc16(r4);
                        return basePacket.getHasResponse() == 1 ? new ExternalFlashIOCtrlCmd(crc17).setOpCodeSn(basePacket.getOpCodeSn()) : new ExtFlashIOCtrlNoResponseCmd(crc17).setOpCodeSn(basePacket.getOpCodeSn());
                    }
                    iByteToInt3 = -1;
                    r4 = 0;
                    iBytesToInt11 = 0;
                    iBytesToInt12 = 0;
                    ExternalFlashIOCtrlParam crc18 = new ExternalFlashIOCtrlParam().setOp(iByteToInt3).setFlag(i3).setOffset(iBytesToInt12).setSize(iBytesToInt11).setData(bArr6).setFilePath(strTrim2).setCrc16(r4);
                    if (basePacket.getHasResponse() == 1) {
                    }
                }
                if (opCode == 214) {
                    return new GetExternalFlashMsgCmd().setOpCodeSn(basePacket.getOpCodeSn());
                }
            }
        }
        return null;
    }
}
