package com.baji.network;

import defpackage.fh2;
import defpackage.p31;
import defpackage.y70;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* JADX INFO: loaded from: classes.dex */
public final class WeatherApiManager {
    public static final Companion Companion = new Companion(null);
    private static volatile WeatherApiManager INSTANCE;
    private final NetworkManager networkManager;

    public static final class Companion {
        public /* synthetic */ Companion(y70 y70Var) {
            this();
        }

        public final WeatherApiManager getInstance() {
            WeatherApiManager weatherApiManager = WeatherApiManager.INSTANCE;
            if (weatherApiManager == null) {
                synchronized (this) {
                    weatherApiManager = WeatherApiManager.INSTANCE;
                    if (weatherApiManager == null) {
                        weatherApiManager = new WeatherApiManager(null);
                        WeatherApiManager.INSTANCE = weatherApiManager;
                    }
                }
            }
            return weatherApiManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ WeatherApiManager(y70 y70Var) {
        this();
    }

    public static /* synthetic */ Observable getWeather2$default(WeatherApiManager weatherApiManager, String str, double d, double d2, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return weatherApiManager.getWeather2(str, d, d2, str2);
    }

    public final Observable<fh2> getWeather2(String str, double d, double d2, String str2) {
        p31.f(str, "authorization");
        Observable<fh2> observableObserveOn = (str2 != null ? this.networkManager.getWeatherApiService(str2) : this.networkManager.getWeatherApiService()).getWeather2(str, d, d2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        p31.e(observableObserveOn, "observeOn(...)");
        return observableObserveOn;
    }

    private WeatherApiManager() {
        this.networkManager = NetworkManager.Companion.getInstance();
    }
}
