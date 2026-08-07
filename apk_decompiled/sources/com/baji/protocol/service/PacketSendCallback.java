package com.baji.protocol.service;

/* JADX INFO: loaded from: classes.dex */
public interface PacketSendCallback {
    void onPacketSendFailed(byte[] bArr, String str);

    void onPacketSent(byte[] bArr);
}
