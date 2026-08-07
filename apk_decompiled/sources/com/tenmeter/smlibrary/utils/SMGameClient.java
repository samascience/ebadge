package com.tenmeter.smlibrary.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import com.iwellfitness.urllib.UrlBuilderUtils;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.activity.SMGameH5Activity;
import com.tenmeter.smlibrary.activity.SMGameListActivity;
import com.tenmeter.smlibrary.activity.SMGameListSubActivity;
import com.tenmeter.smlibrary.entity.BaseBean;
import com.tenmeter.smlibrary.entity.SMADBean;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.entity.SMGameSecretValid;
import com.tenmeter.smlibrary.entity.SMGameSensor;
import com.tenmeter.smlibrary.entity.SMGameUser;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.entity.SMReportBean;
import com.tenmeter.smlibrary.listener.Consumer;
import com.tenmeter.smlibrary.listener.IADCallback;
import com.tenmeter.smlibrary.listener.IGameGSensor;
import com.tenmeter.smlibrary.listener.IGameListBannerCallback;
import com.tenmeter.smlibrary.listener.IGameListCallback;
import com.tenmeter.smlibrary.listener.IGameListForTypeCallback;
import com.tenmeter.smlibrary.listener.IGameListItemClickListener;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.listener.IGameStatus;
import com.tenmeter.smlibrary.listener.IIconCallback;
import com.tenmeter.smlibrary.listener.IUserInfoCallback;
import com.tenmeter.smlibrary.listener.IVipPayClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SMGameClient {
    public static String baseUrl = "";

    @SuppressLint({"StaticFieldLeak"})
    private static Context context = null;
    public static boolean isClick = false;
    public static boolean isDev = false;
    public static boolean isRefresh = false;
    public static boolean isUserAddReport = false;
    public static String language = "zh";
    public static String thirdPartHeadImage = "";

    @SuppressLint({"StaticFieldLeak"})
    public static String thirdPartKey = "";
    public static String thirdPartName = "";
    public static String thirdPartNickname = "";
    public static String thirdPartUid = "";
    public int gameId;
    private IGameGSensor mGameGSensor;
    private IGameListItemClickListener mGameListItemClickListener;
    private IGameStatus mGameStatus;
    private IVipPayClickListener mIVipPayClickListener;
    private TextView tvData;
    private WebView webView;

    /* JADX INFO: renamed from: com.tenmeter.smlibrary.utils.SMGameClient$27, reason: invalid class name */
    class AnonymousClass27 implements Consumer<Boolean> {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ SMGameInfo val$bean;
        final /* synthetic */ IGameOpenListener val$listener;

        AnonymousClass27(Activity activity, IGameOpenListener iGameOpenListener, SMGameInfo sMGameInfo) {
            this.val$activity = activity;
            this.val$listener = iGameOpenListener;
            this.val$bean = sMGameInfo;
        }

        @Override // com.tenmeter.smlibrary.listener.Consumer
        public void accept(Boolean bool) {
            if (bool.booleanValue()) {
                SMGameClient.this.getInfo(new IUserInfoCallback() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.27.1
                    @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                    public void onError(final String str) {
                        AnonymousClass27.this.val$activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.27.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                IGameOpenListener iGameOpenListener = AnonymousClass27.this.val$listener;
                                if (iGameOpenListener != null) {
                                    iGameOpenListener.openResult(false);
                                }
                                SMGameClient.isClick = false;
                                Toast.makeText(SMGameClient.context, str, 1).show();
                            }
                        });
                    }

                    @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                    public void onSuccessFul(SMGameUser sMGameUser) {
                        AnonymousClass27.this.val$activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.27.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                IGameOpenListener iGameOpenListener = AnonymousClass27.this.val$listener;
                                if (iGameOpenListener != null) {
                                    iGameOpenListener.openResult(true);
                                }
                                SMGameClient.isClick = false;
                                SMGameClient.isRefresh = false;
                                AnonymousClass27 anonymousClass27 = AnonymousClass27.this;
                                SMGameClient.this.jumpGame(anonymousClass27.val$bean, anonymousClass27.val$activity);
                            }
                        });
                    }
                });
            } else {
                this.val$activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.27.2
                    @Override // java.lang.Runnable
                    public void run() {
                        IGameOpenListener iGameOpenListener = AnonymousClass27.this.val$listener;
                        if (iGameOpenListener != null) {
                            iGameOpenListener.openResult(false);
                        }
                        SMGameClient.isClick = false;
                    }
                });
            }
        }
    }

    private static class SingletonHolder {
        static SMGameClient sInstance = new SMGameClient();

        private SingletonHolder() {
        }
    }

    private void entryExposureDaily(final Consumer<Boolean> consumer) {
        if (DateFormatUtils.isSameDay(PreferencesUtils.getLong(getContext(), PreferencesUtils.ENTRY_EXPOSURE_DAILY_TIME, 0L), System.currentTimeMillis())) {
            return;
        }
        KLog.i("entryExposureDaily+++++++++++++++++++++++");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("thirdPartName", thirdPartName);
            HttpClientUtils.post(baseUrl + URLContent.ENTRY_EXPOSURE_DAILY, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.7
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    Consumer consumer2 = consumer;
                    if (consumer2 != null) {
                        consumer2.accept(Boolean.FALSE);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2obj = JsonConvert.json2obj(str, SMReportBean.class);
                    if (baseBeanJson2obj.getCode() != 0) {
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2obj.getData() != null && ((SMReportBean) baseBeanJson2obj.getData()).isResult()) {
                        PreferencesUtils.putLong(SMGameClient.getContext(), PreferencesUtils.DAILY_ACTIVE_REPORT_TIME, System.currentTimeMillis());
                    }
                    Consumer consumer3 = consumer;
                    if (consumer3 != null) {
                        consumer3.accept(Boolean.TRUE);
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void gameExposureDaily(final Consumer<Boolean> consumer) {
        if (DateFormatUtils.isSameDay(PreferencesUtils.getLong(getContext(), PreferencesUtils.GAME_EXPOSURE_DAILY_TIME, 0L), System.currentTimeMillis())) {
            return;
        }
        KLog.i("gameExposureDaily+++++++++++++++++++++++每天只触发一次");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("thirdPartName", thirdPartName);
            HttpClientUtils.post(baseUrl + URLContent.GAME_EXPOSURE_DAILY, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.9
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    Consumer consumer2 = consumer;
                    if (consumer2 != null) {
                        consumer2.accept(Boolean.FALSE);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2obj = JsonConvert.json2obj(str, SMReportBean.class);
                    if (baseBeanJson2obj.getCode() != 0) {
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2obj.getData() != null && ((SMReportBean) baseBeanJson2obj.getData()).isResult()) {
                        PreferencesUtils.putLong(SMGameClient.getContext(), PreferencesUtils.DAILY_ACTIVE_REPORT_TIME, System.currentTimeMillis());
                    }
                    Consumer consumer3 = consumer;
                    if (consumer3 != null) {
                        consumer3.accept(Boolean.TRUE);
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private synchronized void gameExposureNum(final Consumer<Boolean> consumer) {
        try {
            gameExposureDaily(null);
            Map<String, Integer> hashMapData = PreferencesUtils.getHashMapData(getContext(), "game_exposure_nNum");
            if (hashMapData.containsKey(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"))) {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), Integer.valueOf(hashMapData.get(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd")).intValue() + 1));
            } else {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), 1);
            }
            PreferencesUtils.putHashMapData(getContext(), "game_exposure_nNum", hashMapData);
            StringBuilder sb = new StringBuilder();
            for (String str : hashMapData.keySet()) {
                if (DateFormatUtils.getSecondsFromDate(str, "yyyy-MM-dd") < DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                    sb.append(str + "#" + hashMapData.get(str) + ",");
                }
            }
            if (!sb.toString().isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                KLog.i("gameExposureNum+++++++++++++++++++++++每次展示游戏列表都进行统计");
                try {
                    jSONObject.put("thirdPartName", thirdPartName);
                    jSONObject.put("data", sb.toString());
                    HttpClientUtils.post(baseUrl + URLContent.GAME_EXPOSURE_NUM, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.10
                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onError(String str2) {
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.FALSE);
                            }
                        }

                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onSuccess(String str2) {
                            if (JsonConvert.json2obj(str2, SMReportBean.class).getCode() != 0) {
                                Consumer consumer2 = consumer;
                                if (consumer2 != null) {
                                    consumer2.accept(Boolean.FALSE);
                                    return;
                                }
                                return;
                            }
                            Map<String, Integer> hashMapData2 = PreferencesUtils.getHashMapData(SMGameClient.getContext(), "game_exposure_nNum");
                            HashMap map = new HashMap();
                            for (String str3 : hashMapData2.keySet()) {
                                if (DateFormatUtils.getSecondsFromDate(str3, "yyyy-MM-dd") == DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                                    map.put(str3, hashMapData2.get(str3));
                                }
                            }
                            PreferencesUtils.putHashMapData(SMGameClient.getContext(), "game_exposure_nNum", map);
                            Consumer consumer3 = consumer;
                            if (consumer3 != null) {
                                consumer3.accept(Boolean.TRUE);
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getADs(final IADCallback iADCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("language", language);
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
            HttpClientUtils.post(baseUrl + URLContent.AD_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.24
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    IADCallback iADCallback2 = iADCallback;
                    if (iADCallback2 != null) {
                        iADCallback2.onError(str);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2arrayOther = JsonConvert.json2arrayOther(str, SMADBean.class);
                    if (baseBeanJson2arrayOther.getCode() != 0) {
                        IADCallback iADCallback2 = iADCallback;
                        if (iADCallback2 != null) {
                            iADCallback2.onError("Error");
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2arrayOther.getData() != null) {
                        IADCallback iADCallback3 = iADCallback;
                        if (iADCallback3 != null) {
                            iADCallback3.onSuccessFul((List) baseBeanJson2arrayOther.getData());
                            return;
                        }
                        return;
                    }
                    IADCallback iADCallback4 = iADCallback;
                    if (iADCallback4 != null) {
                        iADCallback4.onSuccessFul(new ArrayList());
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBanner(final IGameListBannerCallback iGameListBannerCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("language", language);
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
            HttpClientUtils.post(baseUrl + URLContent.BANNER_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.18
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    IGameListBannerCallback iGameListBannerCallback2 = iGameListBannerCallback;
                    if (iGameListBannerCallback2 != null) {
                        iGameListBannerCallback2.onError(str);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2arrayOther = JsonConvert.json2arrayOther(str, SMGameListBannerParent.class);
                    if (baseBeanJson2arrayOther.getCode() != 0) {
                        IGameListBannerCallback iGameListBannerCallback2 = iGameListBannerCallback;
                        if (iGameListBannerCallback2 != null) {
                            iGameListBannerCallback2.onError("Error");
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2arrayOther.getData() != null) {
                        IGameListBannerCallback iGameListBannerCallback3 = iGameListBannerCallback;
                        if (iGameListBannerCallback3 != null) {
                            iGameListBannerCallback3.onSuccessFul((List) baseBeanJson2arrayOther.getData());
                            return;
                        }
                        return;
                    }
                    IGameListBannerCallback iGameListBannerCallback4 = iGameListBannerCallback;
                    if (iGameListBannerCallback4 != null) {
                        iGameListBannerCallback4.onSuccessFul(new ArrayList());
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private synchronized void getBaseUrl(final Consumer<Boolean> consumer) {
        try {
            if (!thirdPartKey.equals(PreferencesUtils.getString(getContext(), PreferencesUtils.SAVE_THIRD_PART_KEY, Constants.STR_EMPTY)) || !DateFormatUtils.isSameDay(PreferencesUtils.getLong(getContext(), PreferencesUtils.SECRET_VALID_TIME, 0L), System.currentTimeMillis())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("thirdPartKey", thirdPartKey);
                    jSONObject.put("thirdPartName", thirdPartName);
                    HttpClientUtils.post("https://server.10m.com.cn/secret/valid", jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.5
                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onError(String str) {
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.FALSE);
                            }
                        }

                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onSuccess(String str) {
                            BaseBean baseBeanJson2obj = JsonConvert.json2obj(str, SMGameSecretValid.class);
                            if (baseBeanJson2obj.getCode() != 0) {
                                Consumer consumer2 = consumer;
                                if (consumer2 != null) {
                                    consumer2.accept(Boolean.FALSE);
                                    return;
                                }
                                return;
                            }
                            KLog.i(((SMGameSecretValid) baseBeanJson2obj.getData()).getBaseUrl());
                            KLog.i(baseBeanJson2obj.getCode() + Constants.STR_EMPTY);
                            KLog.i(baseBeanJson2obj.getMsg());
                            PreferencesUtils.putString(SMGameClient.getContext(), PreferencesUtils.SAVE_THIRD_PART_KEY, SMGameClient.thirdPartKey);
                            PreferencesUtils.putLong(SMGameClient.getContext(), PreferencesUtils.SECRET_VALID_TIME, System.currentTimeMillis());
                            SMGameClient.baseUrl = ((SMGameSecretValid) baseBeanJson2obj.getData()).getBaseUrl().trim();
                            SMGameClient.isDev = ((SMGameSecretValid) baseBeanJson2obj.getData()).getEnv().equals(UrlBuilderUtils.TYPE_DEV);
                            PreferencesUtils.putObject(SMGameClient.getContext(), PreferencesUtils.SECRET_VALID, (SMGameSecretValid) baseBeanJson2obj.getData());
                            SMGameClient.this.reportDailyActive(null);
                            SMGameClient.this.userAddReport(null);
                            Consumer consumer3 = consumer;
                            if (consumer3 != null) {
                                consumer3.accept(Boolean.TRUE);
                            }
                        }
                    });
                } catch (JSONException e) {
                    if (consumer != null) {
                        consumer.accept(Boolean.FALSE);
                    }
                    e.printStackTrace();
                }
            } else if (PreferencesUtils.getObject(getContext(), PreferencesUtils.SECRET_VALID) != null) {
                baseUrl = ((SMGameSecretValid) PreferencesUtils.getObject(getContext(), PreferencesUtils.SECRET_VALID)).getBaseUrl().trim();
                isDev = ((SMGameSecretValid) PreferencesUtils.getObject(getContext(), PreferencesUtils.SECRET_VALID)).getEnv().equals(UrlBuilderUtils.TYPE_DEV);
                if (consumer != null) {
                    consumer.accept(Boolean.TRUE);
                }
            } else {
                PreferencesUtils.putLong(getContext(), PreferencesUtils.SECRET_VALID_TIME, 0L);
                if (consumer != null) {
                    consumer.accept(Boolean.FALSE);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Context getContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        throw new NullPointerException("should be initialized in application");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameListRequest(String str, final IGameListCallback iGameListCallback) {
        gameExposureNum(null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("language", language);
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
            if (str != null && !str.equals(Constants.STR_EMPTY)) {
                jSONObject.put("includeGameId", str);
            }
            HttpClientUtils.post(baseUrl + URLContent.GAME_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.25
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str2) {
                    IGameListCallback iGameListCallback2 = iGameListCallback;
                    if (iGameListCallback2 != null) {
                        iGameListCallback2.onError(str2);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str2) {
                    BaseBean baseBeanJson2array = JsonConvert.json2array(str2, SMGameInfo.class);
                    if (baseBeanJson2array.getCode() != 0) {
                        IGameListCallback iGameListCallback2 = iGameListCallback;
                        if (iGameListCallback2 != null) {
                            iGameListCallback2.onError("Error");
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2array.getData() != null) {
                        IGameListCallback iGameListCallback3 = iGameListCallback;
                        if (iGameListCallback3 != null) {
                            iGameListCallback3.onSuccessFul((List) baseBeanJson2array.getData());
                            return;
                        }
                        return;
                    }
                    IGameListCallback iGameListCallback4 = iGameListCallback;
                    if (iGameListCallback4 != null) {
                        iGameListCallback4.onSuccessFul(new ArrayList());
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameTy(final IGameListForTypeCallback iGameListForTypeCallback) {
        gameExposureNum(null);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("language", language);
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
            HttpClientUtils.post(baseUrl + URLContent.TAG_GAME_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.22
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    IGameListForTypeCallback iGameListForTypeCallback2 = iGameListForTypeCallback;
                    if (iGameListForTypeCallback2 != null) {
                        iGameListForTypeCallback2.onError(str);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2arrayOther = JsonConvert.json2arrayOther(str, SMGameListParent.class);
                    if (baseBeanJson2arrayOther.getCode() != 0) {
                        IGameListForTypeCallback iGameListForTypeCallback2 = iGameListForTypeCallback;
                        if (iGameListForTypeCallback2 != null) {
                            iGameListForTypeCallback2.onError("Error");
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2arrayOther.getData() != null) {
                        IGameListForTypeCallback iGameListForTypeCallback3 = iGameListForTypeCallback;
                        if (iGameListForTypeCallback3 != null) {
                            iGameListForTypeCallback3.onSuccessFul((List) baseBeanJson2arrayOther.getData());
                            return;
                        }
                        return;
                    }
                    IGameListForTypeCallback iGameListForTypeCallback4 = iGameListForTypeCallback;
                    if (iGameListForTypeCallback4 != null) {
                        iGameListForTypeCallback4.onSuccessFul(new ArrayList());
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getIcons(final IIconCallback iIconCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("language", language);
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
            HttpClientUtils.post(baseUrl + URLContent.ICON_LIST, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.21
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    IIconCallback iIconCallback2 = iIconCallback;
                    if (iIconCallback2 != null) {
                        iIconCallback2.onError(str);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2arrayOther = JsonConvert.json2arrayOther(str, SMIconListParent.class);
                    if (baseBeanJson2arrayOther.getCode() != 0) {
                        IIconCallback iIconCallback2 = iIconCallback;
                        if (iIconCallback2 != null) {
                            iIconCallback2.onError("Error");
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2arrayOther.getData() == null) {
                        IIconCallback iIconCallback3 = iIconCallback;
                        if (iIconCallback3 != null) {
                            iIconCallback3.onSuccessFul(new ArrayList());
                            return;
                        }
                        return;
                    }
                    IIconCallback iIconCallback4 = iIconCallback;
                    if (iIconCallback4 != null) {
                        int size = ((List) baseBeanJson2arrayOther.getData()).size();
                        List<SMIconListParent> listSubList = (List) baseBeanJson2arrayOther.getData();
                        if (size > 4) {
                            listSubList = listSubList.subList(0, 4);
                        }
                        iIconCallback4.onSuccessFul(listSubList);
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInfo(final IUserInfoCallback iUserInfoCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
            jSONObject.put("thirdPartNickname", thirdPartNickname);
            jSONObject.put("thirdPartHeadImage", thirdPartHeadImage);
            jSONObject.put("thirdPartUid", thirdPartUid);
            HttpClientUtils.post(baseUrl + URLContent.SYNC_USER, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.14
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    IUserInfoCallback iUserInfoCallback2 = iUserInfoCallback;
                    if (iUserInfoCallback2 != null) {
                        iUserInfoCallback2.onError(str);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2obj = JsonConvert.json2obj(str, SMGameUser.class);
                    if (baseBeanJson2obj.getCode() != 0) {
                        IUserInfoCallback iUserInfoCallback2 = iUserInfoCallback;
                        if (iUserInfoCallback2 != null) {
                            iUserInfoCallback2.onError("Error");
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2obj.getData() == null) {
                        IUserInfoCallback iUserInfoCallback3 = iUserInfoCallback;
                        if (iUserInfoCallback3 != null) {
                            iUserInfoCallback3.onError("Error");
                            return;
                        }
                        return;
                    }
                    SMGameUser sMGameUser = (SMGameUser) baseBeanJson2obj.getData();
                    sMGameUser.setThirdPartHeadImage(SMGameClient.thirdPartHeadImage);
                    sMGameUser.setThirdPartNickname(SMGameClient.thirdPartNickname);
                    sMGameUser.setThirdPartUid(SMGameClient.thirdPartUid);
                    PreferencesUtils.putObject(SMGameClient.getContext(), SMGameClient.this.getSpUserKey(), sMGameUser);
                    IUserInfoCallback iUserInfoCallback4 = iUserInfoCallback;
                    if (iUserInfoCallback4 != null) {
                        iUserInfoCallback4.onSuccessFul(SMGameClient.this.getUserInfo());
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static SMGameClient getInstance() {
        return SingletonHolder.sInstance;
    }

    public static String getRequestBody(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("token", getInstance().getUserInfo().getUserToken());
            jSONObject.put("uid", getInstance().getUserInfo().getUid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void getUserByStartGame(final SMGameInfo sMGameInfo, final Activity activity, final IGameOpenListener iGameOpenListener) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new AnonymousClass27(activity, iGameOpenListener, sMGameInfo));
        } else {
            getInfo(new IUserInfoCallback() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.28
                @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                public void onError(final String str) {
                    activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.28.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IGameOpenListener iGameOpenListener2 = iGameOpenListener;
                            if (iGameOpenListener2 != null) {
                                iGameOpenListener2.openResult(false);
                            }
                            SMGameClient.isClick = false;
                            Toast.makeText(SMGameClient.context, str, 1).show();
                        }
                    });
                }

                @Override // com.tenmeter.smlibrary.listener.IUserInfoCallback
                public void onSuccessFul(SMGameUser sMGameUser) {
                    activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.28.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IGameOpenListener iGameOpenListener2 = iGameOpenListener;
                            if (iGameOpenListener2 != null) {
                                iGameOpenListener2.openResult(true);
                            }
                            SMGameClient.isClick = false;
                            SMGameClient.isRefresh = false;
                            AnonymousClass28 anonymousClass28 = AnonymousClass28.this;
                            SMGameClient.this.jumpGame(sMGameInfo, activity);
                        }
                    });
                }
            });
        }
    }

    private static void init(Context context2) {
        context = context2.getApplicationContext();
    }

    private static void initUrl() {
        if (baseUrl.isEmpty()) {
            getInstance().getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.4
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    bool.booleanValue();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpGame(SMGameInfo sMGameInfo, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) SMGameH5Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMGameInfo);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDailyActive(final Consumer<Boolean> consumer) {
        if (DateFormatUtils.isSameDay(PreferencesUtils.getLong(getContext(), PreferencesUtils.DAILY_ACTIVE_REPORT_TIME, 0L), System.currentTimeMillis())) {
            return;
        }
        KLog.i("reportDailyActive+++++++++++++++++++++++");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("thirdPartName", thirdPartName);
            HttpClientUtils.post(baseUrl + URLContent.DAILY_ACTIVE_REPORT, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.6
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    Consumer consumer2 = consumer;
                    if (consumer2 != null) {
                        consumer2.accept(Boolean.FALSE);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    BaseBean baseBeanJson2obj = JsonConvert.json2obj(str, SMReportBean.class);
                    if (baseBeanJson2obj.getCode() != 0) {
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.FALSE);
                            return;
                        }
                        return;
                    }
                    if (baseBeanJson2obj.getData() != null && ((SMReportBean) baseBeanJson2obj.getData()).isResult()) {
                        PreferencesUtils.putLong(SMGameClient.getContext(), PreferencesUtils.DAILY_ACTIVE_REPORT_TIME, System.currentTimeMillis());
                    }
                    Consumer consumer3 = consumer;
                    if (consumer3 != null) {
                        consumer3.accept(Boolean.TRUE);
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void userAddReport(final Consumer<Boolean> consumer) {
        try {
            if (!isUserAddReport) {
                Map<String, Integer> hashMapData = PreferencesUtils.getHashMapData(getContext(), "user_add_report");
                if (hashMapData.containsKey(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"))) {
                    hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), Integer.valueOf(hashMapData.get(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd")).intValue() + 1));
                } else {
                    hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), 1);
                }
                PreferencesUtils.putHashMapData(getContext(), "user_add_report", hashMapData);
                StringBuilder sb = new StringBuilder();
                for (String str : hashMapData.keySet()) {
                    if (DateFormatUtils.getSecondsFromDate(str, "yyyy-MM-dd") < DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                        sb.append(str + "#" + hashMapData.get(str) + ",");
                    }
                }
                if (!sb.toString().isEmpty()) {
                    KLog.i("userAddReport+++++++++++++++++++++++每个APP整个生命周期只调用一次");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("thirdPartName", thirdPartName);
                        jSONObject.put("data", sb.toString());
                        HttpClientUtils.post(baseUrl + URLContent.USER_ADD_REPORT, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.11
                            @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                            public void onError(String str2) {
                                Consumer consumer2 = consumer;
                                if (consumer2 != null) {
                                    consumer2.accept(Boolean.FALSE);
                                }
                            }

                            @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                            public void onSuccess(String str2) {
                                BaseBean baseBeanJson2obj = JsonConvert.json2obj(str2, SMReportBean.class);
                                if (baseBeanJson2obj.getCode() != 0) {
                                    Consumer consumer2 = consumer;
                                    if (consumer2 != null) {
                                        consumer2.accept(Boolean.FALSE);
                                        return;
                                    }
                                    return;
                                }
                                if (baseBeanJson2obj.getData() != null && ((SMReportBean) baseBeanJson2obj.getData()).isResult()) {
                                    SMGameClient.isUserAddReport = true;
                                }
                                Map<String, Integer> hashMapData2 = PreferencesUtils.getHashMapData(SMGameClient.getContext(), "user_add_report");
                                HashMap map = new HashMap();
                                for (String str3 : hashMapData2.keySet()) {
                                    if (DateFormatUtils.getSecondsFromDate(str3, "yyyy-MM-dd") == DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                                        map.put(str3, hashMapData2.get(str3));
                                    }
                                }
                                PreferencesUtils.putHashMapData(SMGameClient.getContext(), "user_add_report", map);
                                Consumer consumer3 = consumer;
                                if (consumer3 != null) {
                                    consumer3.accept(Boolean.TRUE);
                                }
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void comGameStart(int i, final Consumer<Boolean> consumer) {
        KLog.i("comGameStart+++++++++++++++++++++++游戏启动页调用");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("thirdPartName", thirdPartName);
            jSONObject.put("gameId", i);
            jSONObject.put("uid", getUserInfo().getUid());
            HttpClientUtils.post(baseUrl + URLContent.COMP_GAME_START, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.12
                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onError(String str) {
                    Consumer consumer2 = consumer;
                    if (consumer2 != null) {
                        consumer2.accept(Boolean.FALSE);
                    }
                }

                @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                public void onSuccess(String str) {
                    if (JsonConvert.json2obj(str, SMReportBean.class).getCode() == 0) {
                        Consumer consumer2 = consumer;
                        if (consumer2 != null) {
                            consumer2.accept(Boolean.TRUE);
                            return;
                        }
                        return;
                    }
                    Consumer consumer3 = consumer;
                    if (consumer3 != null) {
                        consumer3.accept(Boolean.FALSE);
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public synchronized void exposureReport(final Consumer<Boolean> consumer) {
        try {
            KLog.i("exposureReport+++++++++++++++++++++++");
            entryExposureDaily(null);
            Map<String, Integer> hashMapData = PreferencesUtils.getHashMapData(getContext(), "entry_exposure_num");
            if (hashMapData.containsKey(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"))) {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), Integer.valueOf(hashMapData.get(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd")).intValue() + 1));
            } else {
                hashMapData.put(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"), 1);
            }
            PreferencesUtils.putHashMapData(getContext(), "entry_exposure_num", hashMapData);
            StringBuilder sb = new StringBuilder();
            for (String str : hashMapData.keySet()) {
                if (DateFormatUtils.getSecondsFromDate(str, "yyyy-MM-dd") < DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                    sb.append(str + "#" + hashMapData.get(str) + ",");
                }
            }
            if (!sb.toString().isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("thirdPartName", thirdPartName);
                    jSONObject.put("data", sb.toString());
                    HttpClientUtils.post(baseUrl + URLContent.ENTRY_EXPOSURE_NUM, jSONObject.toString(), new HttpClientUtils.OnRequestCallBack() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.8
                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onError(String str2) {
                            Consumer consumer2 = consumer;
                            if (consumer2 != null) {
                                consumer2.accept(Boolean.FALSE);
                            }
                        }

                        @Override // com.tenmeter.smlibrary.utils.HttpClientUtils.OnRequestCallBack
                        public void onSuccess(String str2) {
                            if (JsonConvert.json2obj(str2, SMReportBean.class).getCode() != 0) {
                                Consumer consumer2 = consumer;
                                if (consumer2 != null) {
                                    consumer2.accept(Boolean.FALSE);
                                    return;
                                }
                                return;
                            }
                            Map<String, Integer> hashMapData2 = PreferencesUtils.getHashMapData(SMGameClient.getContext(), "entry_exposure_num");
                            HashMap map = new HashMap();
                            for (String str3 : hashMapData2.keySet()) {
                                if (DateFormatUtils.getSecondsFromDate(str3, "yyyy-MM-dd") == DateFormatUtils.getTimesmorning(System.currentTimeMillis())) {
                                    map.put(str3, hashMapData2.get(str3));
                                }
                            }
                            PreferencesUtils.putHashMapData(SMGameClient.getContext(), "entry_exposure_num", map);
                            Consumer consumer3 = consumer;
                            if (consumer3 != null) {
                                consumer3.accept(Boolean.TRUE);
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void gamePrivate(Consumer<Boolean> consumer) {
        getBaseUrl(consumer);
    }

    public void getAD(final IADCallback iADCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.23
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getADs(iADCallback);
                    } else {
                        iADCallback.onError("init error...");
                    }
                }
            });
        } else {
            getADs(iADCallback);
        }
    }

    public void getGameBannerList(final IGameListBannerCallback iGameListBannerCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.17
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getBanner(iGameListBannerCallback);
                    } else {
                        iGameListBannerCallback.onError("init error...");
                    }
                }
            });
        } else {
            getBanner(iGameListBannerCallback);
        }
    }

    public IGameGSensor getGameGSonsorListener() {
        return this.mGameGSensor;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGameInfo() {
        if (getUserInfo() == null) {
            return Constants.STR_EMPTY;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", getUserInfo().getUserToken());
            jSONObject.put("uid", getUserInfo().getUid() + Constants.STR_EMPTY);
            jSONObject.put("gid", this.gameId);
            jSONObject.put("serverUrl", getUserInfo().getServerUrl());
            jSONObject.put("joinRaceId", 0);
            jSONObject.put("otpToken", getUserInfo().getOtpToken());
            jSONObject.put("roomId", 0);
            jSONObject.put("thirdPartKey", thirdPartKey);
            jSONObject.put("thirdPartName", thirdPartName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public void getGameList(final IGameListCallback iGameListCallback, final String str) {
        if (thirdPartKey.isEmpty() || thirdPartName.isEmpty()) {
            Toast.makeText(context, "Please initialize first", 1).show();
        } else if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.15
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getGameListRequest(str, iGameListCallback);
                    } else {
                        iGameListCallback.onError("Error");
                    }
                }
            });
        } else {
            getGameListRequest(str, iGameListCallback);
        }
    }

    public IGameListItemClickListener getGameListItemClickListener() {
        return this.mGameListItemClickListener;
    }

    public IGameStatus getGameStatusListener() {
        return this.mGameStatus;
    }

    public IVipPayClickListener getIVipPayClickListener() {
        return this.mIVipPayClickListener;
    }

    public void getIconLists(final IIconCallback iIconCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.20
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getIcons(iIconCallback);
                    } else {
                        iIconCallback.onError("init error...");
                    }
                }
            });
        } else {
            getIcons(iIconCallback);
        }
    }

    public String getP1Data() {
        if (getUserInfo() == null) {
            return Constants.STR_EMPTY;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", getUserInfo().getUid());
            jSONObject.put("name", getUserInfo().getUserNickname());
            jSONObject.put("head", getUserInfo().getHeadImage());
            jSONObject.put("mac", Constants.STR_EMPTY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getSpUserKey() {
        return !thirdPartUid.equals(Constants.STR_EMPTY) ? thirdPartUid : thirdPartKey;
    }

    public void getTypeGameList(final IGameListForTypeCallback iGameListForTypeCallback) {
        if (baseUrl.isEmpty()) {
            getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.19
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        SMGameClient.this.getGameTy(iGameListForTypeCallback);
                    } else {
                        iGameListForTypeCallback.onError("init error...");
                    }
                }
            });
        } else {
            getGameTy(iGameListForTypeCallback);
        }
    }

    public SMGameUser getUserInfo() {
        if (thirdPartKey.isEmpty()) {
            Toast.makeText(context, "Please initialize first", 1).show();
        }
        return (SMGameUser) PreferencesUtils.getObject(getContext(), getSpUserKey(), null);
    }

    public WebView getWebView() {
        return this.webView;
    }

    public boolean isChina() {
        return language.equals("zh");
    }

    public void moveKeyDirection(int i) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript("javascript:WebviewBridge.getVKeyboardNum(" + i + ")", new ValueCallback<String>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.3
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
        }
    }

    @SuppressLint({"SetTextI18n"})
    public void movePlayer(int i, SMGameSensor sMGameSensor) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript("javascript:WebviewBridge.moveP" + i + "Game(" + sMGameSensor.getX() + "," + sMGameSensor.getY() + "," + sMGameSensor.getSpeed() + "," + sMGameSensor.getX_Throw() + "," + sMGameSensor.getY_Throw() + "," + sMGameSensor.getZ_Gravity() + "," + sMGameSensor.getCount_Throw() + "," + sMGameSensor.getX_Gravity() + "," + sMGameSensor.getY_Gravity() + ")", new ValueCallback<String>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
            TextView textView = this.tvData;
            if (textView == null || !isDev) {
                return;
            }
            textView.setText("x: " + sMGameSensor.getX() + "\ny: " + sMGameSensor.getY() + "\nSpeed: " + sMGameSensor.getSpeed() + "\nX_Throw: " + sMGameSensor.getX_Throw() + "\nY_Throw: " + sMGameSensor.getY_Throw() + "\nCount_Throw: " + sMGameSensor.getCount_Throw() + "\nX_Gravity: " + sMGameSensor.getX_Gravity() + "\nY_Gravity: " + sMGameSensor.getY_Gravity() + "\nZ_Gravity: " + sMGameSensor.getZ_Gravity());
        }
    }

    public void refreshUserInfo(String str, String str2, String str3) {
        isRefresh = true;
        if (str == null) {
            str = Constants.STR_EMPTY;
        }
        thirdPartUid = str;
        if (str2 == null) {
            str2 = Constants.STR_EMPTY;
        }
        thirdPartNickname = str2;
        if (str3 == null) {
            str3 = Constants.STR_EMPTY;
        }
        thirdPartHeadImage = str3;
    }

    public void setGameGSensorListener(IGameGSensor iGameGSensor) {
        this.mGameGSensor = iGameGSensor;
    }

    public void setGameId(int i) {
        this.gameId = i;
    }

    public void setGameListItemClickListener(IGameListItemClickListener iGameListItemClickListener) {
        this.mGameListItemClickListener = iGameListItemClickListener;
    }

    public void setGameStatusListener(IGameStatus iGameStatus) {
        this.mGameStatus = iGameStatus;
    }

    public void setIVipPayClickListener(IVipPayClickListener iVipPayClickListener) {
        this.mIVipPayClickListener = iVipPayClickListener;
    }

    public void setLanguage(String str) {
        language = str;
    }

    public void setTextData(TextView textView) {
        this.tvData = textView;
    }

    public void setUserInfo(String str, String str2, String str3) {
        thirdPartUid = str == null ? Constants.STR_EMPTY : str;
        if (getUserInfo() != null) {
            if (getUserInfo().getThirdPartUid().equals(str) && getUserInfo().getThirdPartNickname().equals(str2) && getUserInfo().getThirdPartHeadImage().equals(str3)) {
                return;
            }
            refreshUserInfo(str, str2, str3);
            return;
        }
        isRefresh = true;
        if (str2 == null) {
            str2 = Constants.STR_EMPTY;
        }
        thirdPartNickname = str2;
        if (str3 == null) {
            str3 = Constants.STR_EMPTY;
        }
        thirdPartHeadImage = str3;
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }

    public void startGame(String str, Activity activity) {
        try {
            startGame((SMGameInfo) JsonConvert.fromJson(str, SMGameInfo.class), activity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public void startGameList(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) SMGameListActivity.class));
    }

    public void startGameListSub(SMGameListParent sMGameListParent, Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) SMGameListSubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMGameListParent);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    private SMGameClient() {
    }

    public static void init(Context context2, String str, String str2) {
        init(context2);
        if (str == null) {
            str = Constants.STR_EMPTY;
        }
        thirdPartKey = str;
        if (str2 == null) {
            str2 = Constants.STR_EMPTY;
        }
        thirdPartName = str2;
        initUrl();
    }

    private void getUserInfo(final IUserInfoCallback iUserInfoCallback) {
        if (getUserInfo() != null) {
            if (iUserInfoCallback != null) {
                iUserInfoCallback.onSuccessFul(getUserInfo());
            }
        } else {
            if (!thirdPartKey.isEmpty() && !thirdPartName.isEmpty()) {
                if (baseUrl.isEmpty()) {
                    getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.13
                        @Override // com.tenmeter.smlibrary.listener.Consumer
                        public void accept(Boolean bool) {
                            if (bool.booleanValue()) {
                                SMGameClient.this.getInfo(iUserInfoCallback);
                                return;
                            }
                            IUserInfoCallback iUserInfoCallback2 = iUserInfoCallback;
                            if (iUserInfoCallback2 != null) {
                                iUserInfoCallback2.onError("Error");
                            }
                        }
                    });
                    return;
                } else {
                    if (iUserInfoCallback != null) {
                        getInfo(iUserInfoCallback);
                        return;
                    }
                    return;
                }
            }
            Toast.makeText(context, "Please initialize first", 1).show();
        }
    }

    public void startGame(SMGameInfo sMGameInfo, Activity activity) {
        if (isRefresh) {
            if (isClick) {
                return;
            }
            isClick = true;
            getUserByStartGame(sMGameInfo, activity, null);
            return;
        }
        if (isClick) {
            return;
        }
        isClick = true;
        if (getUserInfo() != null) {
            isClick = false;
            jumpGame(sMGameInfo, activity);
        } else {
            getUserByStartGame(sMGameInfo, activity, null);
        }
    }

    public void getGameList(final IGameListCallback iGameListCallback) {
        if (!thirdPartKey.isEmpty() && !thirdPartName.isEmpty()) {
            if (baseUrl.isEmpty()) {
                getBaseUrl(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.16
                    @Override // com.tenmeter.smlibrary.listener.Consumer
                    public void accept(Boolean bool) {
                        if (bool.booleanValue()) {
                            IGameListCallback iGameListCallback2 = iGameListCallback;
                            if (iGameListCallback2 != null) {
                                SMGameClient.this.getGameListRequest(Constants.STR_EMPTY, iGameListCallback2);
                                return;
                            }
                            return;
                        }
                        IGameListCallback iGameListCallback3 = iGameListCallback;
                        if (iGameListCallback3 != null) {
                            iGameListCallback3.onError("Error");
                        }
                    }
                });
                return;
            } else {
                getGameListRequest(Constants.STR_EMPTY, iGameListCallback);
                return;
            }
        }
        Toast.makeText(context, "Please initialize first", 1).show();
    }

    public void startGame(final SMGameInfo sMGameInfo, final Activity activity, final IGameOpenListener iGameOpenListener) {
        if (isRefresh) {
            if (isClick) {
                return;
            }
            isClick = true;
            getUserByStartGame(sMGameInfo, activity, iGameOpenListener);
            return;
        }
        if (isClick) {
            return;
        }
        isClick = true;
        if (getUserInfo() != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.26
                @Override // java.lang.Runnable
                public void run() {
                    IGameOpenListener iGameOpenListener2 = iGameOpenListener;
                    if (iGameOpenListener2 != null) {
                        iGameOpenListener2.openResult(true);
                    }
                    SMGameClient.isClick = false;
                    SMGameClient.this.jumpGame(sMGameInfo, activity);
                }
            });
        } else {
            getUserByStartGame(sMGameInfo, activity, iGameOpenListener);
        }
    }

    public void movePlayer(int i, int i2, int i3, int i4) {
        WebView webView = this.webView;
        if (webView != null) {
            webView.evaluateJavascript("javascript:WebviewBridge.moveP" + i + "Game(0,0,0,0,0," + i4 + ",0," + i2 + "," + i3 + ")", new ValueCallback<String>() { // from class: com.tenmeter.smlibrary.utils.SMGameClient.2
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str) {
                }
            });
            TextView textView = this.tvData;
            if (textView == null || !isDev) {
                return;
            }
            textView.setText("x: 0\ny: 0\nSpeed: 0\nX_Throw: 0\nY_Throw: 0\nCount_Throw: 0\nX_Gravity: " + i2 + "\nY_Gravity: " + i3 + "\nZ_Gravity: " + i4);
        }
    }
}
