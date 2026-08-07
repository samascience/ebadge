package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.TDialog;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class QzonePublish extends BaseApi {
    public static final String HULIAN_CALL_BACK = "hulian_call_back";
    public static final String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(Context context, QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00cd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:45:0x016c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0177  */
    /* JADX WARN: Code duplicated, block: B:50:0x019e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0206  */
    /* JADX WARN: Code duplicated, block: B:57:0x0229  */
    /* JADX WARN: Code duplicated, block: B:60:0x0243  */
    /* JADX WARN: Code duplicated, block: B:63:0x0266  */
    /* JADX WARN: Code duplicated, block: B:66:0x0289  */
    /* JADX WARN: Code duplicated, block: B:69:0x0315  */
    /* JADX WARN: Code duplicated, block: B:70:0x035f  */
    /* JADX WARN: Instruction removed from duplicated block: B:48:0x0177, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:50:0x019e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:54:0x0206, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:57:0x0229, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x0243, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:63:0x0266, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x0289, please report this as an issue */
    public void b(Activity activity, Bundle bundle, IUiListener iUiListener) {
        String str;
        String str2;
        String string;
        String appId;
        String openId;
        String str3;
        String str4;
        String str5;
        Intent intent;
        String strA;
        SLog.i("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
        String string2 = bundle.getString("summary");
        int i = bundle.getInt("req_type", 3);
        String string3 = bundle.getString("appName");
        String string4 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        int i2 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
        long j = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
        try {
            Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                Set<String> setKeySet = bundle2.keySet();
                str2 = Constants.STR_EMPTY;
                try {
                    JSONObject jSONObject = new JSONObject();
                    Iterator<String> it = setKeySet.iterator();
                    while (it.hasNext()) {
                        Iterator<String> it2 = it;
                        String next = it.next();
                        if (TextUtils.isEmpty(bundle2.getString(next))) {
                            str = string3;
                        } else {
                            str = string3;
                            try {
                                jSONObject.put(next, bundle2.getString(next));
                            } catch (Exception e) {
                                e = e;
                                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                                string = str2;
                                appId = this.c.getAppId();
                                openId = this.c.getOpenId();
                                SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                                if (3 == i) {
                                    str3 = openId;
                                    str4 = str2;
                                } else {
                                    str3 = openId;
                                    str4 = str2;
                                }
                                if (4 == i) {
                                    stringBuffer.append("&videoPath=" + Base64.encodeToString(l.j(string4), 2));
                                    strA = l.a(appId, activity, string4, iUiListener);
                                    if (!TextUtils.isEmpty(strA)) {
                                        stringBuffer.append("&videoUri=" + Base64.encodeToString(l.j(strA), 2));
                                    }
                                    stringBuffer.append("&videoDuration=" + Base64.encodeToString(l.j(String.valueOf(i2)), 2));
                                    stringBuffer.append("&videoSize=" + Base64.encodeToString(l.j(String.valueOf(j)), 2));
                                    str4 = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                                }
                                str5 = str4;
                                if (!TextUtils.isEmpty(string2)) {
                                    stringBuffer.append("&description=" + Base64.encodeToString(l.j(string2), 2));
                                }
                                if (!TextUtils.isEmpty(appId)) {
                                    stringBuffer.append("&share_id=" + appId);
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    stringBuffer.append("&app_name=" + Base64.encodeToString(l.j(str), 2));
                                }
                                if (!l.e(str3)) {
                                    stringBuffer.append("&open_id=" + Base64.encodeToString(l.j(str3), 2));
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(l.j(string), 2));
                                }
                                stringBuffer.append("&req_type=" + Base64.encodeToString(l.j(String.valueOf(i)), 2));
                                SLog.v("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                                com.tencent.connect.a.a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                                intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(stringBuffer.toString()));
                                intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                                if (a(intent)) {
                                    a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
                                    e.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                                    e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str5, "0", "1", "0");
                                } else {
                                    SLog.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
                                    e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                                    e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str5, "0", "1", "0");
                                }
                                SLog.i(SLog.TAG, "doPublishToQzone() --end");
                            }
                        }
                        it = it2;
                        string3 = str;
                    }
                    str = string3;
                    if (jSONObject.length() > 0) {
                        string = jSONObject.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = string3;
                }
                appId = this.c.getAppId();
                openId = this.c.getOpenId();
                SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                if (3 == i || stringArrayList == null) {
                    str3 = openId;
                    str4 = str2;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    StringBuffer stringBuffer3 = new StringBuffer();
                    int size = stringArrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        String str6 = openId;
                        stringBuffer2.append(URLEncoder.encode(stringArrayList.get(i3)));
                        String strA2 = l.a(appId, activity, stringArrayList.get(i3), iUiListener);
                        if (!TextUtils.isEmpty(strA2)) {
                            stringBuffer3.append(URLEncoder.encode(strA2));
                        }
                        if (i3 != size - 1) {
                            stringBuffer2.append(";");
                            stringBuffer3.append(";");
                        }
                        i3++;
                        openId = str6;
                    }
                    str3 = openId;
                    stringBuffer.append("&image_url=" + Base64.encodeToString(l.j(stringBuffer2.toString()), 2));
                    if (!TextUtils.isEmpty(stringBuffer3.toString())) {
                        stringBuffer.append("&image_uri=" + Base64.encodeToString(l.j(stringBuffer3.toString()), 2));
                    }
                    str4 = "7";
                }
                if (4 == i) {
                    stringBuffer.append("&videoPath=" + Base64.encodeToString(l.j(string4), 2));
                    strA = l.a(appId, activity, string4, iUiListener);
                    if (!TextUtils.isEmpty(strA)) {
                        stringBuffer.append("&videoUri=" + Base64.encodeToString(l.j(strA), 2));
                    }
                    stringBuffer.append("&videoDuration=" + Base64.encodeToString(l.j(String.valueOf(i2)), 2));
                    stringBuffer.append("&videoSize=" + Base64.encodeToString(l.j(String.valueOf(j)), 2));
                    str4 = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                }
                str5 = str4;
                if (!TextUtils.isEmpty(string2)) {
                    stringBuffer.append("&description=" + Base64.encodeToString(l.j(string2), 2));
                }
                if (!TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!TextUtils.isEmpty(str)) {
                    stringBuffer.append("&app_name=" + Base64.encodeToString(l.j(str), 2));
                }
                if (!l.e(str3)) {
                    stringBuffer.append("&open_id=" + Base64.encodeToString(l.j(str3), 2));
                }
                if (!TextUtils.isEmpty(string)) {
                    stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(l.j(string), 2));
                }
                stringBuffer.append("&req_type=" + Base64.encodeToString(l.j(String.valueOf(i)), 2));
                SLog.v("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                com.tencent.connect.a.a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
                intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(stringBuffer.toString()));
                intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
                if (a(intent)) {
                    a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
                    e.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                    e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str5, "0", "1", "0");
                } else {
                    SLog.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
                    e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                    e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str5, "0", "1", "0");
                }
                SLog.i(SLog.TAG, "doPublishToQzone() --end");
            }
            str = string3;
            str2 = Constants.STR_EMPTY;
        } catch (Exception e3) {
            e = e3;
            str = string3;
            str2 = Constants.STR_EMPTY;
        }
        string = str2;
        appId = this.c.getAppId();
        openId = this.c.getOpenId();
        SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
        if (3 == i) {
            str3 = openId;
            str4 = str2;
        } else {
            str3 = openId;
            str4 = str2;
        }
        if (4 == i) {
            stringBuffer.append("&videoPath=" + Base64.encodeToString(l.j(string4), 2));
            strA = l.a(appId, activity, string4, iUiListener);
            if (!TextUtils.isEmpty(strA)) {
                stringBuffer.append("&videoUri=" + Base64.encodeToString(l.j(strA), 2));
            }
            stringBuffer.append("&videoDuration=" + Base64.encodeToString(l.j(String.valueOf(i2)), 2));
            stringBuffer.append("&videoSize=" + Base64.encodeToString(l.j(String.valueOf(j)), 2));
            str4 = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
        }
        str5 = str4;
        if (!TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + Base64.encodeToString(l.j(string2), 2));
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("&app_name=" + Base64.encodeToString(l.j(str), 2));
        }
        if (!l.e(str3)) {
            stringBuffer.append("&open_id=" + Base64.encodeToString(l.j(str3), 2));
        }
        if (!TextUtils.isEmpty(string)) {
            stringBuffer.append("&share_qzone_ext_str=" + Base64.encodeToString(l.j(string), 2));
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(l.j(String.valueOf(i)), 2));
        SLog.v("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(g.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        if (a(intent)) {
            a(activity, Constants.REQUEST_QZONE_SHARE, intent, false);
            e.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str5, "0", "1", "0");
        } else {
            SLog.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
            e.a().a(this.c.getOpenId(), this.c.getAppId(), Constants.VIA_SHARE_TO_QZONE, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str5, "0", "1", "0");
        }
        SLog.i(SLog.TAG, "doPublishToQzone() --end");
    }

    public void publishToQzone(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (com.tencent.connect.a.a("openSDK_LOG.QzonePublish", iUiListener)) {
            return;
        }
        if (bundle == null) {
            iUiListener.onError(new UiError(-6, Constants.MSG_PARAM_NULL_ERROR, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        if (!l.f(activity)) {
            iUiListener.onError(new UiError(-15, Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new TDialog(activity, Constants.STR_EMPTY, a(Constants.STR_EMPTY), null, this.c).show();
            return;
        }
        String strA = l.a(activity);
        int i = 0;
        if (strA == null) {
            strA = bundle.getString("appName");
        } else if (strA.length() > 20) {
            strA = strA.substring(0, 20) + "...";
        }
        if (!TextUtils.isEmpty(strA)) {
            bundle.putString("appName", strA);
        }
        int i2 = bundle.getInt("req_type");
        if (i2 == 3) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("imageUrl");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                while (i < stringArrayList.size()) {
                    if (!l.i(stringArrayList.get(i))) {
                        stringArrayList.remove(i);
                        i--;
                    }
                    i++;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            b(activity, bundle, iUiListener);
            SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i2 != 4) {
            iUiListener.onError(new UiError(-5, Constants.MSG_SHARE_TYPE_ERROR, null));
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.c.getAppId(), String.valueOf(4), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            return;
        }
        final String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        if (!l.i(string)) {
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.tencent.connect.share.QzonePublish.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer2) {
                long length = new File(string).length();
                int duration = mediaPlayer2.getDuration();
                bundle.putString(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string);
                bundle.putInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                bundle.putLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                QzonePublish.this.b(activity, bundle, iUiListener);
                SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.tencent.connect.share.QzonePublish.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer2, int i3, int i4) {
                SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                return false;
            }
        });
        try {
            mediaPlayer.setDataSource(string);
            mediaPlayer.prepareAsync();
        } catch (Exception unused) {
            SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
            iUiListener.onError(new UiError(-5, Constants.MSG_PUBLISH_VIDEO_ERROR, null));
        }
    }
}
