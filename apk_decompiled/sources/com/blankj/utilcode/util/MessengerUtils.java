package com.blankj.utilcode.util;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import defpackage.e43;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class MessengerUtils {
    private static ConcurrentHashMap a = new ConcurrentHashMap();
    private static Map b = new HashMap();

    public static class ServerService extends Service {
        private final ConcurrentHashMap a = new ConcurrentHashMap();
        private final Handler b;
        private final Messenger c;

        class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    ServerService.this.a.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i == 1) {
                    ServerService.this.a.remove(Integer.valueOf(message.arg1));
                } else if (i != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.b = aVar;
            this.c = new Messenger(aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Message message) {
            String string;
            Bundle data = message.getData();
            if (data == null || (string = data.getString("MESSENGER_UTILS")) == null) {
                return;
            }
            e43.a(MessengerUtils.a.get(string));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(Message message) {
            Message messageObtain = Message.obtain(message);
            for (Messenger messenger : this.a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(messageObtain));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            messageObtain.recycle();
        }

        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return this.c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            Bundle extras;
            startForeground(1, q.u(k.a.b, null));
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message messageObtain = Message.obtain(this.b, 2);
                messageObtain.replyTo = this.c;
                messageObtain.setData(extras);
                e(messageObtain);
                d(messageObtain);
            }
            return 2;
        }
    }
}
