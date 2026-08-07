package com.baji.network;

import com.baji.network.BadgeApiManager;
import com.baji.network.api.BadgeApiService;
import com.baji.network.model.BadgeImage;
import com.baji.network.model.BadgeImageResponse;
import com.baji.network.model.BadgeImageType;
import com.baji.network.model.ErrorType;
import com.baji.network.model.NetworkError;
import com.baji.network.utils.NetworkUtils;
import com.tencent.open.SocialConstants;
import defpackage.ar0;
import defpackage.ja1;
import defpackage.k83;
import defpackage.p31;
import defpackage.y70;
import defpackage.yq0;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.a;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeApiManager {
    public static final Companion Companion = new Companion(null);
    private static volatile BadgeApiManager INSTANCE;
    private final ja1 badgeApiService$delegate;
    private final NetworkManager networkManager;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public final BadgeApiManager getInstance() {
            BadgeApiManager badgeApiManager = BadgeApiManager.INSTANCE;
            if (badgeApiManager == null) {
                synchronized (this) {
                    badgeApiManager = BadgeApiManager.INSTANCE;
                    if (badgeApiManager == null) {
                        badgeApiManager = new BadgeApiManager(null);
                        BadgeApiManager.INSTANCE = badgeApiManager;
                    }
                }
            }
            return badgeApiManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ BadgeApiManager(y70 y70Var) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BadgeApiService badgeApiService_delegate$lambda$0(BadgeApiManager badgeApiManager) {
        return badgeApiManager.networkManager.getBadgeApiService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 findImageById$lambda$14(ar0 ar0Var, String str, List list) {
        p31.f(list, "allImages");
        for (Object obj : list) {
            if (p31.a(((BadgeImage) obj).getId(), str)) {
                ar0Var.invoke((BadgeImage) obj);
                return k83.a;
            }
        }
        obj = null;
        ar0Var.invoke((BadgeImage) obj);
        return k83.a;
    }

    private final BadgeApiService getBadgeApiService() {
        return (BadgeApiService) this.badgeApiService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getBadgeImageList$lambda$1(ar0 ar0Var, ar0 ar0Var2, BadgeImageResponse badgeImageResponse) {
        if (badgeImageResponse.getSuccess()) {
            ar0Var.invoke(badgeImageResponse.getData());
        } else {
            ar0Var2.invoke(new NetworkError(-1, "API返回失败", ErrorType.SERVER_ERROR, 0L, 8, null));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getBadgeImageList$lambda$3(ar0 ar0Var, Throwable th) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        String message = th.getMessage();
        if (message == null) {
            message = "网络请求失败";
        }
        ar0Var.invoke(networkUtils.createNetworkError(-1, message, th));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getBorderImages$lambda$6(ar0 ar0Var, List list) {
        p31.f(list, "allImages");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((BadgeImage) obj).isBorder()) {
                arrayList.add(obj);
            }
        }
        ar0Var.invoke(arrayList);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getImagesByType$lambda$12(ar0 ar0Var, BadgeImageType badgeImageType, List list) {
        p31.f(list, "allImages");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((BadgeImage) obj).getType() == badgeImageType.getValue()) {
                arrayList.add(obj);
            }
        }
        ar0Var.invoke(arrayList);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getStickerImages$lambda$8(ar0 ar0Var, List list) {
        p31.f(list, "allImages");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((BadgeImage) obj).isSticker()) {
                arrayList.add(obj);
            }
        }
        ar0Var.invoke(arrayList);
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getTimeStyleImages$lambda$10(ar0 ar0Var, List list) {
        p31.f(list, "allImages");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((BadgeImage) obj).isTimeStyle()) {
                arrayList.add(obj);
            }
        }
        ar0Var.invoke(arrayList);
        return k83.a;
    }

    public final void findImageById(final String str, final ar0 ar0Var, ar0 ar0Var2) {
        p31.f(str, "imageId");
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        getBadgeImageList(new ar0() { // from class: me
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiManager.findImageById$lambda$14(ar0Var, str, (List) obj);
            }
        }, ar0Var2);
    }

    public final void getBadgeImageList(final ar0 ar0Var, final ar0 ar0Var2) {
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        Observable<BadgeImageResponse> observableObserveOn = getBadgeApiService().getBadgeImageList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ar0 ar0Var3 = new ar0() { // from class: re
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiManager.getBadgeImageList$lambda$1(ar0Var, ar0Var2, (BadgeImageResponse) obj);
            }
        };
        Consumer<? super BadgeImageResponse> consumer = new Consumer() { // from class: se
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var3.invoke(obj);
            }
        };
        final ar0 ar0Var4 = new ar0() { // from class: te
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiManager.getBadgeImageList$lambda$3(ar0Var2, (Throwable) obj);
            }
        };
        observableObserveOn.subscribe(consumer, new Consumer() { // from class: ue
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        });
    }

    public final Observable<BadgeImageResponse> getBadgeImageListObservable() {
        Observable<BadgeImageResponse> observableObserveOn = getBadgeApiService().getBadgeImageList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        p31.e(observableObserveOn, "observeOn(...)");
        return observableObserveOn;
    }

    public final void getBorderImages(final ar0 ar0Var, ar0 ar0Var2) {
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        getBadgeImageList(new ar0() { // from class: qe
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiManager.getBorderImages$lambda$6(ar0Var, (List) obj);
            }
        }, ar0Var2);
    }

    public final void getImagesByType(final BadgeImageType badgeImageType, final ar0 ar0Var, ar0 ar0Var2) {
        p31.f(badgeImageType, SocialConstants.PARAM_TYPE);
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        getBadgeImageList(new ar0() { // from class: oe
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiManager.getImagesByType$lambda$12(ar0Var, badgeImageType, (List) obj);
            }
        }, ar0Var2);
    }

    public final void getStickerImages(final ar0 ar0Var, ar0 ar0Var2) {
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        getBadgeImageList(new ar0() { // from class: ne
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiManager.getStickerImages$lambda$8(ar0Var, (List) obj);
            }
        }, ar0Var2);
    }

    public final void getTimeStyleImages(final ar0 ar0Var, ar0 ar0Var2) {
        p31.f(ar0Var, "onSuccess");
        p31.f(ar0Var2, "onError");
        getBadgeImageList(new ar0() { // from class: le
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiManager.getTimeStyleImages$lambda$10(ar0Var, (List) obj);
            }
        }, ar0Var2);
    }

    private BadgeApiManager() {
        this.networkManager = NetworkManager.Companion.getInstance();
        this.badgeApiService$delegate = a.a(new yq0() { // from class: pe
            @Override // defpackage.yq0
            public final Object invoke() {
                return BadgeApiManager.badgeApiService_delegate$lambda$0(this.a);
            }
        });
    }
}
