package defpackage;

import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public interface o7 {
    public static final String a = pv2.e(R.string.privacy_cn, a());
    public static final String b = pv2.e(R.string.privacy_en, a());

    static String a() {
        return pv2.d(R.string.privacy_tag).replaceAll(" ", Constants.STR_EMPTY).toLowerCase(Locale.ROOT);
    }
}
