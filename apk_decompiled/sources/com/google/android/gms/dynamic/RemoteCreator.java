package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.d;
import defpackage.a52;

/* JADX INFO: loaded from: classes.dex */
public abstract class RemoteCreator {
    private final String a;
    private Object b;

    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    protected RemoteCreator(String str) {
        this.a = str;
    }

    protected abstract Object a(IBinder iBinder);

    protected final Object b(Context context) throws RemoteCreatorException {
        if (this.b == null) {
            a52.g(context);
            Context contextC = d.c(context);
            if (contextC == null) {
                throw new RemoteCreatorException("Could not get remote context.");
            }
            try {
                this.b = a((IBinder) contextC.getClassLoader().loadClass(this.a).newInstance());
            } catch (ClassNotFoundException e) {
                throw new RemoteCreatorException("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new RemoteCreatorException("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new RemoteCreatorException("Could not instantiate creator.", e3);
            }
        }
        return this.b;
    }
}
