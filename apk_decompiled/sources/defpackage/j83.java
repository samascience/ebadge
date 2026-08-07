package defpackage;

import android.app.Activity;
import android.util.Log;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.shareboard.SnsPlatform;
import java.util.ArrayList;
import java.util.Map;
import xfkj.fitpro.eum.LoginType;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j83 {
    private static final String a = "j83";
    private static ArrayList b = new ArrayList();

    class a implements UMAuthListener {
        a() {
        }

        public void onCancel(SHARE_MEDIA share_media, int i) {
        }

        public void onComplete(SHARE_MEDIA share_media, int i, Map map) {
            Log.e(j83.a, "delete auth complete....");
        }

        public void onError(SHARE_MEDIA share_media, int i, Throwable th) {
        }

        public void onStart(SHARE_MEDIA share_media) {
        }
    }

    static {
        SHARE_MEDIA[] share_mediaArr = {SHARE_MEDIA.QQ, SHARE_MEDIA.SINA, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.FACEBOOK, SHARE_MEDIA.TWITTER};
        for (int i = 0; i < 5; i++) {
            SHARE_MEDIA share_media = share_mediaArr[i];
            if (!share_media.toString().equals(SHARE_MEDIA.GENERIC.toString())) {
                b.add(share_media.toSnsPlatform());
            }
        }
    }

    public static void b(SHARE_MEDIA share_media) {
        Activity activityG = com.blankj.utilcode.util.a.g();
        if (activityG == null || activityG.isDestroyed()) {
            return;
        }
        UMShareAPI.get(activityG).deleteOauth(activityG, share_media, new a());
    }

    public static void c(Activity activity, LoginType loginType, UMAuthListener uMAuthListener) {
        UMShareAPI.get(activity).getPlatformInfo(activity, ((SnsPlatform) b.get(loginType.ordinal())).mPlatform, uMAuthListener);
    }
}
