package com.jieli.lib.gif;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class GifError {
    public static final int ERR_CLOSE_FAILED = 9;
    public static final int ERR_DATA_TOO_BIG = 6;
    public static final int ERR_DISK_IS_FULL = 8;
    public static final int ERR_D_CLOSE_FAILED = 110;
    public static final int ERR_D_DATA_TOO_BIG = 108;
    public static final int ERR_D_NOT_ENOUGH_MEM = 109;
    public static final int ERR_D_NO_COLOR_MAP = 106;
    public static final int ERR_D_OPEN_FILE = 101;
    public static final int ERR_EOF_TOO_SOON = 113;
    public static final int ERR_HAS_IMAG_DSCR = 4;
    public static final int ERR_HAS_SCRN_DSCR = 3;
    public static final int ERR_IMAGE_DEFECT = 112;
    public static final int ERR_INVALID_PARAM = 301;
    public static final int ERR_NONE = 0;
    public static final int ERR_NOT_ENOUGH_MEM = 7;
    public static final int ERR_NOT_GIF_FILE = 103;
    public static final int ERR_NOT_READABLE = 111;
    public static final int ERR_NOT_WRITEABLE = 10;
    public static final int ERR_NO_COLOR_MAP = 5;
    public static final int ERR_NO_IMAG_DSCR = 105;
    public static final int ERR_NO_SCRN_DSCR = 104;
    public static final int ERR_OPEN_FILE = 1;
    public static final int ERR_OP_IN_PROGRESS = 302;
    public static final int ERR_READ_FAILED = 102;
    public static final int ERR_SAVE_FILE = 303;
    public static final int ERR_UNKNOWN_CHIP = -129;
    public static final int ERR_UNKNOWN_MODE = -128;
    public static final int ERR_WRITE_FAILED = 2;
    public static final int ERR_WRONG_RECORD = 107;

    public static String getErrDesc(int i) {
        if (i == -129) {
            return "Unknown Chip.";
        }
        if (i == -128) {
            return "Unknown Mode.";
        }
        switch (i) {
            case 0:
                return "Success.";
            case 1:
                return "Failed to open given file";
            case 2:
                return "Failed to write to given file";
            case 3:
                return "Screen descriptor has already been set";
            case 4:
                return "Image descriptor is still active";
            case 5:
                return "Neither global nor local color map";
            case 6:
                return "Number of pixels bigger than width * height";
            case 7:
                return "Failed to allocate required memory";
            case 8:
                return "Write failed (disk full?)";
            case 9:
                return "Failed to close given file";
            case 10:
                return "Given file was not opened for write";
            default:
                switch (i) {
                    case 101:
                        return "Failed to open given file";
                    case 102:
                        return "Failed to read from given file";
                    case 103:
                        return "Data is not in GIF format";
                    case 104:
                        return "No screen descriptor detected";
                    case 105:
                        return "No Image Descriptor detected";
                    case 106:
                        return "Neither global nor local color map";
                    case 107:
                        return "Wrong record type detected";
                    case 108:
                        return "Number of pixels bigger than width * height";
                    case 109:
                        return "Failed to allocate required memory";
                    case 110:
                        return "Failed to close given file";
                    case 111:
                        return "Given file was not opened for read";
                    case 112:
                        return "Image is defective, decoding aborted";
                    case 113:
                        return "Image EOF detected before image complete";
                    default:
                        switch (i) {
                            case ERR_INVALID_PARAM /* 301 */:
                                return "Invalid parameter.";
                            case ERR_OP_IN_PROGRESS /* 302 */:
                                return "Operation in progress.";
                            case ERR_SAVE_FILE /* 303 */:
                                return "Save file failed.";
                            default:
                                return String.format(Locale.ENGLISH, "Unknown Error[%d].", Integer.valueOf(i));
                        }
                }
        }
    }
}
