package com.legend.mywatch.sdk.mywatchsdklib.android.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import defpackage.e43;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NetworkUtils {
    private static final Set a = new CopyOnWriteArraySet();

    public static final class NetworkChangedReceiver extends BroadcastReceiver {
        private NetworkType a;
        private Set b = new HashSet();

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkType networkTypeB = NetworkUtils.b();
                if (NetworkChangedReceiver.this.a == networkTypeB) {
                    return;
                }
                NetworkChangedReceiver.this.a = networkTypeB;
                if (networkTypeB == NetworkType.NETWORK_NO) {
                    Iterator it = NetworkChangedReceiver.this.b.iterator();
                    if (it.hasNext()) {
                        e43.a(it.next());
                        throw null;
                    }
                    return;
                }
                Iterator it2 = NetworkChangedReceiver.this.b.iterator();
                if (it2.hasNext()) {
                    e43.a(it2.next());
                    throw null;
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                k.t(new a(), 1000L);
            }
        }
    }

    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    private static NetworkInfo a() {
        ConnectivityManager connectivityManager = (ConnectivityManager) i.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static NetworkType b() {
        if (c()) {
            return NetworkType.NETWORK_ETHERNET;
        }
        NetworkInfo networkInfoA = a();
        if (networkInfoA == null || !networkInfoA.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (networkInfoA.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (networkInfoA.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (networkInfoA.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
                return NetworkType.NETWORK_4G;
            case 19:
            default:
                String subtypeName = networkInfoA.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_3G : NetworkType.NETWORK_UNKNOWN;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    private static boolean c() {
        NetworkInfo networkInfo;
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) i.a().getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(9)) == null || (state = networkInfo.getState()) == null) {
            return false;
        }
        return state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING;
    }
}
