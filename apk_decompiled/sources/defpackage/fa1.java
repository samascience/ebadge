package defpackage;

import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.legend.smartwatch.electronicbadge.android.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class fa1 {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(String str) {
        int iC = rj2.c("language", 1);
        if (pv2.f(str)) {
            Log.e("LanguageUtils", "非法语言信息");
            return iC;
        }
        String lowerCase = str.toLowerCase();
        String strD = pv2.d(R.string.lang);
        if (pv2.b(strD, "zh-hk") || pv2.b(strD, "zh-tw")) {
            Log.i("LanguageUtils", "is fan ti lang");
            return 2;
        }
        lowerCase.hashCode();
        byte b = -1;
        switch (lowerCase.hashCode()) {
            case -1386270698:
                if (lowerCase.equals("bn-rIN")) {
                    b = 0;
                }
                break;
            case 3121:
                if (lowerCase.equals("ar")) {
                    b = 1;
                }
                break;
            case 3148:
                if (lowerCase.equals("bn")) {
                    b = 2;
                }
                break;
            case 3184:
                if (lowerCase.equals("cs")) {
                    b = 3;
                }
                break;
            case 3197:
                if (lowerCase.equals("da")) {
                    b = 4;
                }
                break;
            case 3201:
                if (lowerCase.equals("de")) {
                    b = 5;
                }
                break;
            case 3239:
                if (lowerCase.equals("el")) {
                    b = 6;
                }
                break;
            case 3246:
                if (lowerCase.equals("es")) {
                    b = 7;
                }
                break;
            case 3259:
                if (lowerCase.equals("fa")) {
                    b = 8;
                }
                break;
            case 3267:
                if (lowerCase.equals("fi")) {
                    b = 9;
                }
                break;
            case 3276:
                if (lowerCase.equals("fr")) {
                    b = 10;
                }
                break;
            case 3329:
                if (lowerCase.equals("hi")) {
                    b = 11;
                }
                break;
            case 3338:
                if (lowerCase.equals("hr")) {
                    b = 12;
                }
                break;
            case 3341:
                if (lowerCase.equals("hu")) {
                    b = 13;
                }
                break;
            case 3355:
                if (lowerCase.equals("id")) {
                    b = 14;
                }
                break;
            case 3365:
                if (lowerCase.equals("in")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_PHONE_STATUS;
                }
                break;
            case 3371:
                if (lowerCase.equals("it")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN;
                }
                break;
            case 3383:
                if (lowerCase.equals("ja")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_FREQ;
                }
                break;
            case 3428:
                if (lowerCase.equals("ko")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD_EQ_GAIN;
                }
                break;
            case 3494:
                if (lowerCase.equals("ms")) {
                    b = AttrAndFunCode.SYS_INFO_ATTR_SOUND_CARD;
                }
                break;
            case 3500:
                if (lowerCase.equals("my")) {
                    b = 20;
                }
                break;
            case 3508:
                if (lowerCase.equals("nb")) {
                    b = 21;
                }
                break;
            case 3518:
                if (lowerCase.equals("nl")) {
                    b = 22;
                }
                break;
            case 3580:
                if (lowerCase.equals("pl")) {
                    b = 23;
                }
                break;
            case 3588:
                if (lowerCase.equals("pt")) {
                    b = 24;
                }
                break;
            case 3645:
                if (lowerCase.equals("ro")) {
                    b = 25;
                }
                break;
            case 3651:
                if (lowerCase.equals("ru")) {
                    b = 26;
                }
                break;
            case 3672:
                if (lowerCase.equals("sk")) {
                    b = 27;
                }
                break;
            case 3683:
                if (lowerCase.equals("sv")) {
                    b = 28;
                }
                break;
            case 3700:
                if (lowerCase.equals("th")) {
                    b = 29;
                }
                break;
            case 3704:
                if (lowerCase.equals("tl")) {
                    b = 30;
                }
                break;
            case 3710:
                if (lowerCase.equals("tr")) {
                    b = 31;
                }
                break;
            case 3734:
                if (lowerCase.equals("uk")) {
                    b = 32;
                }
                break;
            case 3763:
                if (lowerCase.equals("vi")) {
                    b = 33;
                }
                break;
            case 3886:
                if (lowerCase.equals("zh")) {
                    b = 34;
                }
                break;
            case 101385:
                if (lowerCase.equals("fil")) {
                    b = 35;
                }
                break;
            case 115814250:
                if (lowerCase.equals("zh-cn")) {
                    b = 36;
                }
                break;
            case 115814402:
                if (lowerCase.equals("zh-hk")) {
                    b = ProtocolConstants.PRODUCT_ID;
                }
                break;
            case 115814786:
                if (lowerCase.equals("zh-tw")) {
                    b = 38;
                }
                break;
        }
        switch (b) {
            case 0:
            case 2:
                return 34;
            case 1:
                return 3;
            case 3:
                return 4;
            case 4:
                return 26;
            case 5:
                return 5;
            case 6:
                return 30;
            case 7:
                return 6;
            case 8:
                return 31;
            case 9:
                return 23;
            case 10:
                return 7;
            case 11:
                return 22;
            case 12:
                return 24;
            case 13:
                return 29;
            case 14:
            case 15:
                return 20;
            case 16:
                return 18;
            case 17:
                return 8;
            case 18:
                return 28;
            case 19:
                return 9;
            case 20:
                return 33;
            case 21:
                return 25;
            case 22:
                return 10;
            case 23:
                return 11;
            case 24:
                return 12;
            case 25:
                return 32;
            case 26:
                return 13;
            case 27:
                return 14;
            case 28:
                return 27;
            case 29:
                return 15;
            case 30:
            case 35:
                return 19;
            case 31:
                return 16;
            case 32:
                return 21;
            case 33:
                return 17;
            case 34:
            case 36:
                return 0;
            case 37:
            case 38:
                return 2;
            default:
                return 1;
        }
    }

    public static boolean b() {
        Locale locale = Locale.getDefault();
        return locale != null && a(locale.getLanguage()) == 3;
    }

    public static boolean c() {
        int iA = a(Locale.getDefault().getLanguage());
        return iA == 0 || iA == 2;
    }
}
