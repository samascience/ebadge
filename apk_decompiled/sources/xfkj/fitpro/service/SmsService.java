package xfkj.fitpro.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import com.blankj.utilcode.util.o;
import com.tencent.connect.common.Constants;
import defpackage.d20;
import defpackage.ur1;

/* JADX INFO: loaded from: classes4.dex */
public class SmsService extends BroadcastReceiver {
    public SmsService() {
        Log.i("AppManager/SmsService", "SmsReceiver(), SmsReceiver created!");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (!intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED") || (extras = intent.getExtras()) == null) {
            return;
        }
        Object[] objArr = (Object[]) extras.get("pdus");
        String str = Constants.STR_EMPTY;
        String displayOriginatingAddress = Constants.STR_EMPTY;
        for (Object obj : objArr) {
            SmsMessage smsMessageCreateFromPdu = SmsMessage.createFromPdu((byte[]) obj);
            str = str + smsMessageCreateFromPdu.getMessageBody();
            displayOriginatingAddress = smsMessageCreateFromPdu.getDisplayOriginatingAddress();
            String strA = ur1.a(o.a(), displayOriginatingAddress);
            if (strA != null) {
                displayOriginatingAddress = strA;
            }
        }
        if (str == null || displayOriginatingAddress == null) {
            return;
        }
        String str2 = displayOriginatingAddress + d20.l + str;
        NotifyService.m("app.mms", str2, 0);
        Log.i("AppManager/SmsService", "mosgbody:" + str2);
    }
}
