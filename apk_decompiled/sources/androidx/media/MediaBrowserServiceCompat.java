package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import defpackage.az1;
import defpackage.nh1;
import defpackage.th1;
import defpackage.u9;
import defpackage.vo;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    static final boolean f = Log.isLoggable("MBServiceCompat", 3);
    private g a;
    f c;
    MediaSessionCompat.Token e;
    final u9 b = new u9();
    final p d = new p();

    class a extends l {
        final /* synthetic */ f f;
        final /* synthetic */ String g;
        final /* synthetic */ Bundle h;
        final /* synthetic */ Bundle i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f = fVar;
            this.g = str;
            this.h = bundle;
            this.i = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if (MediaBrowserServiceCompat.this.b.get(this.f.f.asBinder()) != this.f) {
                if (MediaBrowserServiceCompat.f) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f.a + " id=" + this.g);
                    return;
                }
                return;
            }
            if ((a() & 1) != 0) {
                list = MediaBrowserServiceCompat.this.b(list, this.h);
            }
            try {
                this.f.f.a(this.g, list, this.h, this.i);
            } catch (RemoteException unused) {
                Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.g + " package=" + this.f.a);
            }
        }
    }

    class b extends l {
        final /* synthetic */ ResultReceiver f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(MediaBrowserCompat.MediaItem mediaItem) {
            if ((a() & 2) != 0) {
                this.f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", mediaItem);
            this.f.send(0, bundle);
        }
    }

    class c extends l {
        final /* synthetic */ ResultReceiver f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(List list) {
            if ((a() & 4) != 0 || list == null) {
                this.f.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f.send(0, bundle);
        }
    }

    class d extends l {
        final /* synthetic */ ResultReceiver f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.l
        void c(Bundle bundle) {
            this.f.send(-1, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(Bundle bundle) {
            this.f.send(0, bundle);
        }
    }

    public static final class e {
    }

    private class f implements IBinder.DeathRecipient {
        public final String a;
        public final int b;
        public final int c;
        public final th1 d;
        public final Bundle e;
        public final n f;
        public final HashMap g = new HashMap();

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                MediaBrowserServiceCompat.this.b.remove(fVar.f.asBinder());
            }
        }

        f(String str, int i, int i2, Bundle bundle, n nVar) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = new th1(str, i, i2);
            this.e = bundle;
            this.f = nVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.d.post(new a());
        }
    }

    interface g {
        void a();

        IBinder onBind(Intent intent);
    }

    class h implements g, androidx.media.a.d {
        final List a = new ArrayList();
        Object b;
        Messenger c;

        class a extends l {
            final /* synthetic */ androidx.media.a.c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, androidx.media.a.c cVar) {
                super(obj);
                this.f = cVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f.b(arrayList);
            }
        }

        h() {
        }

        @Override // androidx.media.a.d
        public void c(String str, androidx.media.a.c cVar) {
            MediaBrowserServiceCompat.this.f(str, new a(str, cVar));
        }

        @Override // androidx.media.a.d
        public androidx.media.a.C0027a e(String str, int i, Bundle bundle) {
            if (bundle != null && bundle.getInt("extra_client_version", 0) != 0) {
                bundle.remove("extra_client_version");
                this.c = new Messenger(MediaBrowserServiceCompat.this.d);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                vo.b(bundle2, "extra_messenger", this.c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.e;
                if (token != null) {
                    IMediaSession extraBinder = token.getExtraBinder();
                    vo.b(bundle2, "extra_session_binder", extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.a.add(bundle2);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.c = mediaBrowserServiceCompat.new f(str, -1, i, bundle, null);
            MediaBrowserServiceCompat.this.e(str, i, bundle);
            MediaBrowserServiceCompat.this.c = null;
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public IBinder onBind(Intent intent) {
            return androidx.media.a.a(this.b, intent);
        }
    }

    class i extends h implements androidx.media.c {

        class a extends l {
            final /* synthetic */ androidx.media.a.c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, androidx.media.a.c cVar) {
                super(obj);
                this.f = cVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f.b(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                this.f.b(parcelObtain);
            }
        }

        i() {
            super();
        }

        @Override // androidx.media.c
        public void b(String str, androidx.media.a.c cVar) {
            MediaBrowserServiceCompat.this.h(str, new a(str, cVar));
        }
    }

    class j extends i implements androidx.media.d.c {

        class a extends l {
            final /* synthetic */ androidx.media.d.b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, androidx.media.d.b bVar) {
                super(obj);
                this.f = bVar;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.l
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f.b(arrayList, a());
            }
        }

        j() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.g
        public void a() {
            Object objA = androidx.media.d.a(MediaBrowserServiceCompat.this, this);
            this.b = objA;
            androidx.media.a.b(objA);
        }

        @Override // androidx.media.d.c
        public void d(String str, androidx.media.d.b bVar, Bundle bundle) {
            MediaBrowserServiceCompat.this.g(str, new a(str, bVar), bundle);
        }
    }

    class k extends j {
        k() {
            super();
        }
    }

    public static class l {
        private final Object a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;

        l(Object obj) {
            this.a = obj;
        }

        int a() {
            return this.e;
        }

        boolean b() {
            return this.b || this.c || this.d;
        }

        void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.a);
        }

        abstract void d(Object obj);

        public void e(Bundle bundle) {
            if (!this.c && !this.d) {
                this.d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.a);
            }
        }

        public void f(Object obj) {
            if (!this.c && !this.d) {
                this.c = true;
                d(obj);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.a);
            }
        }

        void g(int i) {
            this.e = i;
        }
    }

    private class m {

        class a implements Runnable {
            final /* synthetic */ n a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;
            final /* synthetic */ int d;
            final /* synthetic */ Bundle e;

            a(n nVar, String str, int i, int i2, Bundle bundle) {
                this.a = nVar;
                this.b = str;
                this.c = i;
                this.d = i2;
                this.e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaBrowserServiceCompat.this.b.remove(this.a.asBinder());
                f fVar = MediaBrowserServiceCompat.this.new f(this.b, this.c, this.d, this.e, this.a);
                MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.c = fVar;
                mediaBrowserServiceCompat.e(this.b, this.d, this.e);
                MediaBrowserServiceCompat.this.c = null;
                Log.i("MBServiceCompat", "No root for client " + this.b + " from service " + getClass().getName());
                try {
                    this.a.b();
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + this.b);
                }
            }
        }

        class b implements Runnable {
            final /* synthetic */ n a;

            b(n nVar) {
                this.a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.b.remove(this.a.asBinder());
                if (fVar != null) {
                    fVar.f.asBinder().unlinkToDeath(fVar, 0);
                }
            }
        }

        class c implements Runnable {
            final /* synthetic */ n a;
            final /* synthetic */ String b;
            final /* synthetic */ IBinder c;
            final /* synthetic */ Bundle d;

            c(n nVar, String str, IBinder iBinder, Bundle bundle) {
                this.a = nVar;
                this.b = str;
                this.c = iBinder;
                this.d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.b.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.a(this.b, fVar, this.c, this.d);
                    return;
                }
                Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.b);
            }
        }

        class d implements Runnable {
            final /* synthetic */ n a;
            final /* synthetic */ String b;
            final /* synthetic */ IBinder c;

            d(n nVar, String str, IBinder iBinder) {
                this.a = nVar;
                this.b = str;
                this.c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.b.get(this.a.asBinder());
                if (fVar == null) {
                    Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.b);
                    return;
                }
                if (MediaBrowserServiceCompat.this.p(this.b, fVar, this.c)) {
                    return;
                }
                Log.w("MBServiceCompat", "removeSubscription called for " + this.b + " which is not subscribed");
            }
        }

        class e implements Runnable {
            final /* synthetic */ n a;
            final /* synthetic */ String b;
            final /* synthetic */ ResultReceiver c;

            e(n nVar, String str, ResultReceiver resultReceiver) {
                this.a = nVar;
                this.b = str;
                this.c = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.b.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.n(this.b, fVar, this.c);
                    return;
                }
                Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.b);
            }
        }

        class f implements Runnable {
            final /* synthetic */ n a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;
            final /* synthetic */ int d;
            final /* synthetic */ Bundle e;

            f(n nVar, String str, int i, int i2, Bundle bundle) {
                this.a = nVar;
                this.b = str;
                this.c = i;
                this.d = i2;
                this.e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.a.asBinder();
                MediaBrowserServiceCompat.this.b.remove(iBinderAsBinder);
                f fVar = MediaBrowserServiceCompat.this.new f(this.b, this.c, this.d, this.e, this.a);
                MediaBrowserServiceCompat.this.b.put(iBinderAsBinder, fVar);
                try {
                    iBinderAsBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        class g implements Runnable {
            final /* synthetic */ n a;

            g(n nVar) {
                this.a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.a.asBinder();
                f fVar = (f) MediaBrowserServiceCompat.this.b.remove(iBinderAsBinder);
                if (fVar != null) {
                    iBinderAsBinder.unlinkToDeath(fVar, 0);
                }
            }
        }

        class h implements Runnable {
            final /* synthetic */ n a;
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;
            final /* synthetic */ ResultReceiver d;

            h(n nVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.a = nVar;
                this.b = str;
                this.c = bundle;
                this.d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.b.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.o(this.b, this.c, fVar, this.d);
                    return;
                }
                Log.w("MBServiceCompat", "search for callback that isn't registered query=" + this.b);
            }
        }

        class i implements Runnable {
            final /* synthetic */ n a;
            final /* synthetic */ String b;
            final /* synthetic */ Bundle c;
            final /* synthetic */ ResultReceiver d;

            i(n nVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.a = nVar;
                this.b = str;
                this.c = bundle;
                this.d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) MediaBrowserServiceCompat.this.b.get(this.a.asBinder());
                if (fVar != null) {
                    MediaBrowserServiceCompat.this.l(this.b, this.c, fVar, this.d);
                    return;
                }
                Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.b + ", extras=" + this.c);
            }
        }

        m() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, n nVar) {
            MediaBrowserServiceCompat.this.d.a(new c(nVar, str, iBinder, bundle));
        }

        public void b(String str, int i2, int i3, Bundle bundle, n nVar) {
            if (MediaBrowserServiceCompat.this.c(str, i3)) {
                MediaBrowserServiceCompat.this.d.a(new a(nVar, str, i2, i3, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i3 + " package=" + str);
        }

        public void c(n nVar) {
            MediaBrowserServiceCompat.this.d.a(new b(nVar));
        }

        public void d(String str, ResultReceiver resultReceiver, n nVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.d.a(new e(nVar, str, resultReceiver));
        }

        public void e(n nVar, String str, int i2, int i3, Bundle bundle) {
            MediaBrowserServiceCompat.this.d.a(new f(nVar, str, i2, i3, bundle));
        }

        public void f(String str, IBinder iBinder, n nVar) {
            MediaBrowserServiceCompat.this.d.a(new d(nVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, n nVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.d.a(new h(nVar, str, bundle, resultReceiver));
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, n nVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.d.a(new i(nVar, str, bundle, resultReceiver));
        }

        public void i(n nVar) {
            MediaBrowserServiceCompat.this.d.a(new g(nVar));
        }
    }

    private interface n {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b();
    }

    private static class o implements n {
        final Messenger a;

        o(Messenger messenger) {
            this.a = messenger;
        }

        private void c(int i, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.a.send(messageObtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void a(String str, List list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            c(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public IBinder asBinder() {
            return this.a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.n
        public void b() throws RemoteException {
            c(2, null);
        }
    }

    private final class p extends Handler {
        private final m a;

        p() {
            this.a = MediaBrowserServiceCompat.this.new m();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new o(message.replyTo));
                    break;
                case 2:
                    this.a.c(new o(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.a.a(data.getString("data_media_item_id"), vo.a(data, "data_callback_token"), bundle2, new o(message.replyTo));
                    break;
                case 4:
                    this.a.f(data.getString("data_media_item_id"), vo.a(data, "data_callback_token"), new o(message.replyTo));
                    break;
                case 5:
                    this.a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.a.e(new o(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    break;
                case 7:
                    this.a.i(new o(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle("data_search_extras");
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                    break;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<az1> arrayList = (List) fVar.g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        for (az1 az1Var : arrayList) {
            if (iBinder == az1Var.a && nh1.a(bundle, (Bundle) az1Var.b)) {
                return;
            }
        }
        arrayList.add(new az1(iBinder, bundle));
        fVar.g.put(str, arrayList);
        m(str, fVar, bundle, null);
        this.c = fVar;
        j(str, bundle);
        this.c = null;
    }

    List b(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i3 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i2 == -1 && i3 == -1) {
            return list;
        }
        int i4 = i3 * i2;
        int size = i4 + i3;
        if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
            return Collections.emptyList();
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i4, size);
    }

    boolean c(String str, int i2) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i2)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, l lVar) {
        lVar.e(null);
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract e e(String str, int i2, Bundle bundle);

    public abstract void f(String str, l lVar);

    public void g(String str, l lVar, Bundle bundle) {
        lVar.g(1);
        f(str, lVar);
    }

    public void h(String str, l lVar) {
        lVar.g(2);
        lVar.f(null);
    }

    public void i(String str, Bundle bundle, l lVar) {
        lVar.g(4);
        lVar.f(null);
    }

    public void j(String str, Bundle bundle) {
    }

    public void k(String str) {
    }

    void l(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        d dVar = new d(str, resultReceiver);
        this.c = fVar;
        d(str, bundle, dVar);
        this.c = null;
        if (dVar.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void m(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.c = fVar;
        if (bundle == null) {
            f(str, aVar);
        } else {
            g(str, aVar, bundle);
        }
        this.c = null;
        if (aVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.a + " id=" + str);
    }

    void n(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.c = fVar;
        h(str, bVar);
        this.c = null;
        if (bVar.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void o(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.c = fVar;
        i(str, bundle, cVar);
        this.c = null;
        if (cVar.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.a.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.a = new k();
        } else {
            this.a = new j();
        }
        this.a.a();
    }

    boolean p(String str, f fVar, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder != null) {
                List list = (List) fVar.g.get(str);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == ((az1) it.next()).a) {
                            it.remove();
                            z = true;
                        }
                    }
                    if (list.size() == 0) {
                        fVar.g.remove(str);
                    }
                }
            } else if (fVar.g.remove(str) != null) {
                z = true;
            }
            this.c = fVar;
            k(str);
            this.c = null;
            return z;
        } catch (Throwable th) {
            this.c = fVar;
            k(str);
            this.c = null;
            throw th;
        }
    }
}
