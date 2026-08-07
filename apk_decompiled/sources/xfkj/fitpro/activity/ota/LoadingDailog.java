package xfkj.fitpro.activity.ota;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LoadingDailog extends Dialog {

    public static class Builder {
        private Context context;
        private String message = Constants.STR_EMPTY;
        private boolean isCancelable = false;
        private boolean isCancelOutside = false;
        private List<WeakReference<ListenerModel>> listenerList = new ArrayList();

        public Builder(Context context) {
            this.context = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$create$0(LoadingDailog loadingDailog) {
            if (loadingDailog.isShowing()) {
                if (!((Activity) this.context).isDestroyed()) {
                    loadingDailog.dismiss();
                }
                Iterator<WeakReference<ListenerModel>> it = this.listenerList.iterator();
                while (it.hasNext()) {
                    ListenerModel listenerModel = it.next().get();
                    if (listenerModel != null) {
                        listenerModel.getListener().onTimeOut(listenerModel.view);
                    }
                }
            }
        }

        public Builder addTimeoutListener(LoaddingTimeOutListener loaddingTimeOutListener, View view) {
            this.listenerList.add(new WeakReference<>(new ListenerModel(loaddingTimeOutListener, view)));
            return this;
        }

        public LoadingDailog create(boolean z, int i) {
            View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.dialog_loading, (ViewGroup) null);
            final LoadingDailog loadingDailog = new LoadingDailog(this.context, R.style.MyDialogStyle);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tipTextView);
            String str = this.message;
            if (str == Constants.STR_EMPTY || str == null) {
                textView.setVisibility(8);
            } else {
                textView.setText(str);
            }
            loadingDailog.setContentView(viewInflate);
            loadingDailog.setCancelable(this.isCancelable);
            loadingDailog.setCanceledOnTouchOutside(this.isCancelOutside);
            if (z) {
                loadingDailog.show();
                new Handler().postDelayed(new Runnable() { // from class: hc1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.lambda$create$0(loadingDailog);
                    }
                }, i);
            }
            return loadingDailog;
        }

        public Builder setCancelOutside(boolean z) {
            this.isCancelOutside = z;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.isCancelable = z;
            return this;
        }

        public Builder setMessage(String str) {
            this.message = str;
            return this;
        }
    }

    private static class ListenerModel {
        private LoaddingTimeOutListener listener;
        private View view;

        public ListenerModel(LoaddingTimeOutListener loaddingTimeOutListener, View view) {
            this.listener = loaddingTimeOutListener;
            this.view = view;
        }

        public LoaddingTimeOutListener getListener() {
            return this.listener;
        }

        public View getView() {
            return this.view;
        }
    }

    public interface LoaddingTimeOutListener {
        void onTimeOut(View view);
    }

    public LoadingDailog(Context context) {
        super(context);
    }

    public LoadingDailog(Context context, int i) {
        super(context, i);
    }
}
