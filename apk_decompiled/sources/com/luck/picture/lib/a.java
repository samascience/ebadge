package com.luck.picture.lib;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class a implements MediaScannerConnection.MediaScannerConnectionClient {
    private final MediaScannerConnection a;
    private final String b;

    /* JADX INFO: renamed from: com.luck.picture.lib.a$a, reason: collision with other inner class name */
    public interface InterfaceC0099a {
    }

    public a(Context context, String str, InterfaceC0099a interfaceC0099a) {
        this.b = str;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context.getApplicationContext(), this);
        this.a = mediaScannerConnection;
        mediaScannerConnection.connect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        this.a.scanFile(this.b, null);
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.a.disconnect();
    }

    public a(Context context, String str) {
        this.b = str;
        MediaScannerConnection mediaScannerConnection = new MediaScannerConnection(context.getApplicationContext(), this);
        this.a = mediaScannerConnection;
        mediaScannerConnection.connect();
    }
}
