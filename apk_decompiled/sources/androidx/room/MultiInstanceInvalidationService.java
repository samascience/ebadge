package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {
    int a = 0;
    final HashMap b = new HashMap();
    final RemoteCallbackList c = new a();
    private final c.a d = new b();

    class a extends RemoteCallbackList {
        a() {
        }

        @Override // android.os.RemoteCallbackList
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(androidx.room.b bVar, Object obj) {
            HashMap map = MultiInstanceInvalidationService.this.b;
            Integer num = (Integer) obj;
            num.intValue();
            map.remove(num);
        }
    }

    class b extends c.a {
        b() {
        }

        @Override // androidx.room.c
        public void D(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                try {
                    String str = (String) MultiInstanceInvalidationService.this.b.get(Integer.valueOf(i));
                    if (str == null) {
                        Log.w("ROOM", "Remote invalidation client ID not registered");
                        return;
                    }
                    int iBeginBroadcast = MultiInstanceInvalidationService.this.c.beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                        try {
                            Integer num = (Integer) MultiInstanceInvalidationService.this.c.getBroadcastCookie(i2);
                            int iIntValue = num.intValue();
                            String str2 = (String) MultiInstanceInvalidationService.this.b.get(num);
                            if (i != iIntValue && str.equals(str2)) {
                                try {
                                    ((androidx.room.b) MultiInstanceInvalidationService.this.c.getBroadcastItem(i2)).i(strArr);
                                } catch (RemoteException e) {
                                    Log.w("ROOM", "Error invoking a remote callback", e);
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.c.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.c.finishBroadcast();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // androidx.room.c
        public void F(androidx.room.b bVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.c) {
                MultiInstanceInvalidationService.this.c.unregister(bVar);
                MultiInstanceInvalidationService.this.b.remove(Integer.valueOf(i));
            }
        }

        @Override // androidx.room.c
        public int l(androidx.room.b bVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.c) {
                try {
                    MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                    int i = multiInstanceInvalidationService.a + 1;
                    multiInstanceInvalidationService.a = i;
                    if (multiInstanceInvalidationService.c.register(bVar, Integer.valueOf(i))) {
                        MultiInstanceInvalidationService.this.b.put(Integer.valueOf(i), str);
                        return i;
                    }
                    MultiInstanceInvalidationService.this.a--;
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.d;
    }
}
