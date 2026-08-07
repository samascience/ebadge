package org.eclipse.paho.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import defpackage.e43;
import defpackage.fl1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;

/* JADX INFO: loaded from: classes4.dex */
public class MqttAndroidClient extends BroadcastReceiver implements IMqttAsyncClient {
    private static final ExecutorService h = Executors.newCachedThreadPool();
    private MqttService a;
    private String b;
    private final SparseArray c;
    private IMqttToken d;
    private MqttCallback e;
    private fl1 f;
    private final Ack g;

    public enum Ack {
        AUTO_ACK,
        MANUAL_ACK
    }

    private void a(Bundle bundle) {
        IMqttToken iMqttToken = this.d;
        h(bundle);
        j(iMqttToken, bundle);
    }

    private void b(Bundle bundle) {
        if (this.e instanceof MqttCallbackExtended) {
            this.e.connectComplete(bundle.getBoolean("MqttService.reconnect", false), bundle.getString("MqttService.serverURI"));
        }
    }

    private void c(Bundle bundle) {
        if (this.e != null) {
            this.e.connectionLost((Exception) bundle.getSerializable("MqttService.exception"));
        }
    }

    private void d(Bundle bundle) {
        this.b = null;
        IMqttToken iMqttTokenH = h(bundle);
        if (iMqttTokenH != null) {
            e43.a(iMqttTokenH);
            throw null;
        }
        MqttCallback mqttCallback = this.e;
        if (mqttCallback != null) {
            mqttCallback.connectionLost((Throwable) null);
        }
    }

    private synchronized IMqttToken e(Bundle bundle) {
        return (IMqttToken) this.c.get(Integer.parseInt(bundle.getString("MqttService.activityToken")));
    }

    private void f(Bundle bundle) {
        if (this.e != null) {
            String string = bundle.getString("MqttService.messageId");
            String string2 = bundle.getString("MqttService.destinationName");
            ParcelableMqttMessage parcelableMqttMessage = (ParcelableMqttMessage) bundle.getParcelable("MqttService.PARCEL");
            try {
                if (this.g == Ack.AUTO_ACK) {
                    this.e.messageArrived(string2, parcelableMqttMessage);
                    this.a.e(this.b, string);
                } else {
                    parcelableMqttMessage.a = string;
                    this.e.messageArrived(string2, parcelableMqttMessage);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void g(Bundle bundle) {
        IMqttDeliveryToken iMqttDeliveryTokenH = h(bundle);
        if (iMqttDeliveryTokenH == null || this.e == null || ((Status) bundle.getSerializable("MqttService.callbackStatus")) != Status.OK || !(iMqttDeliveryTokenH instanceof IMqttDeliveryToken)) {
            return;
        }
        this.e.deliveryComplete(iMqttDeliveryTokenH);
    }

    private synchronized IMqttToken h(Bundle bundle) {
        String string = bundle.getString("MqttService.activityToken");
        if (string == null) {
            return null;
        }
        int i = Integer.parseInt(string);
        IMqttToken iMqttToken = (IMqttToken) this.c.get(i);
        this.c.delete(i);
        return iMqttToken;
    }

    private void i(Bundle bundle) {
        j(e(bundle), bundle);
    }

    private void j(IMqttToken iMqttToken, Bundle bundle) {
        if (iMqttToken == null) {
            this.a.a("MqttService", "simpleAction : token is null");
        } else {
            if (((Status) bundle.getSerializable("MqttService.callbackStatus")) == Status.OK) {
                e43.a(iMqttToken);
                throw null;
            }
            e43.a(iMqttToken);
            throw null;
        }
    }

    private void k(Bundle bundle) {
        j(h(bundle), bundle);
    }

    private void l(Bundle bundle) {
        if (this.f != null) {
            String string = bundle.getString("MqttService.traceSeverity");
            String string2 = bundle.getString("MqttService.errorMessage");
            String string3 = bundle.getString("MqttService.traceTag");
            if ("debug".equals(string)) {
                this.f.b(string3, string2);
            } else if ("error".equals(string)) {
                this.f.a(string3, string2);
            } else {
                this.f.c(string3, string2, (Exception) bundle.getSerializable("MqttService.exception"));
            }
        }
    }

    private void m(Bundle bundle) {
        j(h(bundle), bundle);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("MqttService.clientHandle");
        if (string == null || !string.equals(this.b)) {
            return;
        }
        String string2 = extras.getString("MqttService.callbackAction");
        if ("connect".equals(string2)) {
            a(extras);
            return;
        }
        if ("connectExtended".equals(string2)) {
            b(extras);
            return;
        }
        if ("messageArrived".equals(string2)) {
            f(extras);
            return;
        }
        if ("subscribe".equals(string2)) {
            k(extras);
            return;
        }
        if ("unsubscribe".equals(string2)) {
            m(extras);
            return;
        }
        if ("send".equals(string2)) {
            i(extras);
            return;
        }
        if ("messageDelivered".equals(string2)) {
            g(extras);
            return;
        }
        if ("onConnectionLost".equals(string2)) {
            c(extras);
            return;
        }
        if ("disconnect".equals(string2)) {
            d(extras);
        } else if ("trace".equals(string2)) {
            l(extras);
        } else {
            this.a.a("MqttService", "Callback action doesn't exist.");
        }
    }
}
