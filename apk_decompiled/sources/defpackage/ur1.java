package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ur1 {
    public static String a(Context context, String str) {
        if (str == null || str.equals(Constants.STR_EMPTY)) {
            return null;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                str = cursorQuery.getString(0);
            }
            cursorQuery.close();
            Log.i("AppManager/Util", "getContactName(), contactName=" + str);
            return str;
        } catch (Exception unused) {
            Log.i("AppManager/Util", "getContactName Exception");
            return str;
        }
    }
}
