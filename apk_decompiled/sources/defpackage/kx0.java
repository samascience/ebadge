package defpackage;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.a;
import com.legend.smartwatch.electronicbadge.android.R;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.sever.reponse.CommonErrorResponse;
import xfkj.fitpro.ui.activities.login.LoginAndRegisterActivity;

/* JADX INFO: loaded from: classes4.dex */
public abstract class kx0 {
    public static void a(CommonErrorResponse commonErrorResponse) {
        b(commonErrorResponse, true);
    }

    public static void b(CommonErrorResponse commonErrorResponse, boolean z) {
        int i;
        int code = commonErrorResponse != null ? commonErrorResponse.getCode() : -1;
        if (code == 12) {
            i = R.string.http_errror_12;
        } else if (code == 19) {
            i = R.string.http_errror_19;
        } else if (code == 31) {
            i = R.string.http_errror_31;
        } else if (code == 32) {
            i = R.string.http_errror_32;
        } else if (code == 101) {
            i = R.string.http_errror_101;
        } else if (code != 102) {
            i = R.string.http_errror__1;
            switch (code) {
                case -1:
                    break;
                case 0:
                    i = R.string.http_errror_0;
                    break;
                case 1:
                    i = R.string.http_errror_1;
                    break;
                case 2:
                    if (DBHelper.isLogin()) {
                        a.a();
                        DBHelper.clearUserData();
                        a.m(LoginAndRegisterActivity.class);
                    }
                    i = R.string.http_errror_2;
                    break;
                case 3:
                    i = R.string.http_errror_3;
                    break;
                case 4:
                    i = R.string.http_errror_4;
                    break;
                case 5:
                    i = R.string.http_errror_5;
                    break;
                case 6:
                    i = R.string.http_errror_6;
                    break;
                case 7:
                    i = R.string.http_errror_7;
                    break;
                case 8:
                    i = R.string.http_errror_8;
                    break;
                case 9:
                    i = R.string.http_errror_9;
                    break;
                default:
                    switch (code) {
                        case 15:
                            i = R.string.http_errror_15;
                            break;
                        case 16:
                            i = R.string.http_errror_16;
                            break;
                        case 17:
                            i = R.string.http_errror_17;
                            break;
                    }
                    break;
            }
        } else {
            i = R.string.http_errror_102;
        }
        if (z) {
            ToastUtils.t(i);
        }
    }
}
