package org.eclipse.paho.android.service;

import android.os.Binder;

/* JADX INFO: loaded from: classes4.dex */
class c extends Binder {
    private MqttService c;
    private String d;

    c(MqttService mqttService) {
        this.c = mqttService;
    }

    void a(String str) {
        this.d = str;
    }
}
