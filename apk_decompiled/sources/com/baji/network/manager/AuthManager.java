package com.baji.network.manager;

import android.annotation.SuppressLint;
import com.baji.network.NetworkManager;
import com.baji.network.manager.AuthManager;
import com.baji.network.model.AiAccessConfigApiResponse;
import com.baji.network.model.BaseResponse;
import com.baji.network.model.ErrorType;
import com.baji.network.model.NetworkError;
import com.baji.network.model.SimultaneousTranslationResponse;
import defpackage.ar0;
import defpackage.k83;
import defpackage.p31;
import defpackage.y70;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public final class AuthManager {
    public static final Companion Companion = new Companion(null);
    private static volatile AuthManager INSTANCE;
    private final NetworkManager networkManager;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public final AuthManager getInstance() {
            AuthManager authManager = AuthManager.INSTANCE;
            if (authManager == null) {
                synchronized (this) {
                    authManager = AuthManager.INSTANCE;
                    if (authManager == null) {
                        authManager = new AuthManager(null);
                        AuthManager.INSTANCE = authManager;
                    }
                }
            }
            return authManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AuthManager(y70 y70Var) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getAiAccessConfig$lambda$0(ar0 ar0Var, AiAccessConfigApiResponse aiAccessConfigApiResponse) {
        p31.c(aiAccessConfigApiResponse);
        ar0Var.invoke(aiAccessConfigApiResponse);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getAiAccessConfig$lambda$2(ar0 ar0Var, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "网络请求失败";
        }
        ar0Var.invoke(new NetworkError(-1, message, ErrorType.NETWORK_ERROR, 0L, 8, null));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getSimultaneousTranslationTokens$lambda$4(ar0 ar0Var, BaseResponse baseResponse) {
        p31.c(baseResponse);
        ar0Var.invoke(baseResponse);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getSimultaneousTranslationTokens$lambda$6(ar0 ar0Var, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "网络请求失败";
        }
        ar0Var.invoke(new NetworkError(-1, message, ErrorType.NETWORK_ERROR, 0L, 8, null));
        return k83.a;
    }

    @SuppressLint({"CheckResult"})
    public final void getAiAccessConfig(String str, final ar0 ar0Var, final ar0 ar0Var2) {
        p31.f(str, "userLang");
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        Observable<AiAccessConfigApiResponse> observableObserveOn = this.networkManager.getAuthApiService().getAiAccessConfig("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e", str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ar0 ar0Var3 = new ar0() { // from class: gc
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return AuthManager.getAiAccessConfig$lambda$0(ar0Var, (AiAccessConfigApiResponse) obj);
            }
        };
        Consumer<? super AiAccessConfigApiResponse> consumer = new Consumer() { // from class: hc
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var3.invoke(obj);
            }
        };
        final ar0 ar0Var4 = new ar0() { // from class: ic
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return AuthManager.getAiAccessConfig$lambda$2(ar0Var2, (Throwable) obj);
            }
        };
        observableObserveOn.subscribe(consumer, new Consumer() { // from class: jc
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        });
    }

    @SuppressLint({"CheckResult"})
    public final void getSimultaneousTranslationTokens(final ar0 ar0Var, final ar0 ar0Var2) {
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        Observable<BaseResponse<SimultaneousTranslationResponse>> observableObserveOn = this.networkManager.getAuthApiService().getSimultaneousTranslationTokens("Bearer 6fcb7f58475b4e5aad8f0f1cadce235e").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ar0 ar0Var3 = new ar0() { // from class: cc
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return AuthManager.getSimultaneousTranslationTokens$lambda$4(ar0Var, (BaseResponse) obj);
            }
        };
        Consumer<? super BaseResponse<SimultaneousTranslationResponse>> consumer = new Consumer() { // from class: dc
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var3.invoke(obj);
            }
        };
        final ar0 ar0Var4 = new ar0() { // from class: ec
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return AuthManager.getSimultaneousTranslationTokens$lambda$6(ar0Var2, (Throwable) obj);
            }
        };
        observableObserveOn.subscribe(consumer, new Consumer() { // from class: fc
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        });
    }

    private AuthManager() {
        this.networkManager = NetworkManager.Companion.getInstance();
    }
}
