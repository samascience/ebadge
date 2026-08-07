package defpackage;

import androidx.recyclerview.widget.ItemTouchHelper;
import cn.bertsir.zbar.Qr.Config;
import com.jieli.jl_rcsp.BuildConfig;
import com.jieli.jl_rcsp.constant.Command;
import com.jieli.jl_rcsp.model.SportHealthConfigure;
import com.jieli.lib.gif.GifError;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import com.tenmeter.smlibrary.banner.config.BannerConfig;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
final class xh {
    private static final int[][] b;
    private final wh a;

    static {
        int[] iArr = new int[30];
        // fill-array-data instruction
        iArr[0] = 419;
        iArr[1] = 418;
        iArr[2] = 425;
        iArr[3] = 424;
        iArr[4] = 431;
        iArr[5] = 430;
        iArr[6] = 107;
        iArr[7] = 106;
        iArr[8] = 59;
        iArr[9] = 58;
        iArr[10] = -3;
        iArr[11] = -3;
        iArr[12] = -3;
        iArr[13] = -3;
        iArr[14] = -3;
        iArr[15] = -3;
        iArr[16] = -3;
        iArr[17] = -3;
        iArr[18] = -3;
        iArr[19] = 23;
        iArr[20] = 89;
        iArr[21] = 88;
        iArr[22] = 437;
        iArr[23] = 436;
        iArr[24] = 443;
        iArr[25] = 442;
        iArr[26] = 449;
        iArr[27] = 448;
        iArr[28] = 836;
        iArr[29] = 835;
        b = new int[][]{new int[]{121, 120, 127, 126, 133, Opcodes.IINC, Opcodes.F2I, Opcodes.L2D, Opcodes.I2B, Opcodes.D2F, Opcodes.DCMPL, Opcodes.FCMPG, 157, 156, 163, 162, Opcodes.RET, Opcodes.JSR, Opcodes.DRETURN, Opcodes.FRETURN, Opcodes.PUTFIELD, Opcodes.GETFIELD, Opcodes.NEW, Opcodes.INVOKEDYNAMIC, 193, 192, Opcodes.IFNONNULL, Opcodes.IFNULL, -2, -2}, new int[]{123, 122, Opcodes.LOR, 128, Opcodes.I2D, Opcodes.I2F, Opcodes.F2D, Opcodes.F2L, Opcodes.I2S, Opcodes.I2C, 153, Opcodes.DCMPG, Opcodes.IF_ICMPEQ, 158, 165, 164, Opcodes.LOOKUPSWITCH, Opcodes.TABLESWITCH, Opcodes.RETURN, Opcodes.ARETURN, Opcodes.INVOKESPECIAL, Opcodes.INVOKEVIRTUAL, Opcodes.ANEWARRAY, Opcodes.NEWARRAY, 195, 194, 201, 200, 816, -3}, new int[]{125, 124, Opcodes.LXOR, 130, Opcodes.L2F, Opcodes.L2I, Opcodes.D2L, Opcodes.D2I, Opcodes.FCMPL, Opcodes.LCMP, 155, 154, 161, 160, Opcodes.GOTO, 166, Opcodes.LRETURN, Opcodes.IRETURN, Opcodes.PUTSTATIC, Opcodes.GETSTATIC, Opcodes.INVOKEINTERFACE, Opcodes.INVOKESTATIC, Opcodes.ATHROW, Opcodes.ARRAYLENGTH, Opcodes.MULTIANEWARRAY, 196, 203, 202, 818, 817}, new int[]{DfuBaseService.NOTIFICATION_ID, 282, 277, 276, 271, 270, 265, 264, 259, 258, 253, 252, 247, 246, Command.CMD_PHONE_NUMBER_PLAY_MODE, 240, 235, 234, 229, 228, 223, 222, Command.CMD_GET_DEVICE_CONFIG_INFO, Command.CMD_SET_DEVICE_STORAGE, 211, Command.CMD_RECEIVE_SPEECH_CANCEL, 205, 204, 819, -3}, new int[]{285, 284, 279, 278, 273, 272, 267, 266, 261, 260, 255, SportHealthConfigure.CONFIGURE_TYPE_SPORT_MODE, 249, 248, 243, Command.CMD_NOTIFY_FILE_STRUCTURE_CHANGE, 237, 236, 231, 230, 225, 224, 219, 218, Command.CMD_GET_LOW_LATENCY_SETTINGS, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, 275, 274, 269, 268, 263, 262, Config.Y_DENSITY, 256, 251, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 245, 244, 239, 238, 233, 232, 227, 226, 221, 220, 215, Command.CMD_GET_EXTERNAL_FLASH_MSG, 209, Command.CMD_NOTIFY_DEVICE_APP_INFO, 822, -3}, new int[]{289, 288, 295, 294, GifError.ERR_INVALID_PARAM, ChartCoordinateportAnimator.FAST_ANIMATION_DURATION, 307, 306, 313, 312, 319, 318, 325, 324, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, GifError.ERR_SAVE_FILE, GifError.ERR_OP_IN_PROGRESS, 309, 308, 315, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, 305, 304, 311, 310, 317, 316, 323, 322, 329, 328, 335, 334, 341, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, 384, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, 407, 406, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, 421, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, 441, 440, 447, 446, 834, -3}, iArr, new int[]{481, 480, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, 458, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, 493, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, 507, 506, 513, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, 509, 508, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, 540, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, BuildConfig.VERSION_CODE, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, BannerConfig.SCROLL_TIME, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, 578, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, 640, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, 696, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, 800, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    }

    xh(wh whVar) {
        this.a = whVar;
    }

    byte[] a() {
        byte[] bArr = new byte[Opcodes.D2F];
        int iG = this.a.g();
        int iJ = this.a.j();
        for (int i = 0; i < iG; i++) {
            int[] iArr = b[i];
            for (int i2 = 0; i2 < iJ; i2++) {
                int i3 = iArr[i2];
                if (i3 >= 0 && this.a.d(i2, i)) {
                    int i4 = i3 / 6;
                    bArr[i4] = (byte) (((byte) (1 << (5 - (i3 % 6)))) | bArr[i4]);
                }
            }
        }
        return bArr;
    }
}
