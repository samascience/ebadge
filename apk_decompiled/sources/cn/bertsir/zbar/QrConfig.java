package cn.bertsir.zbar;

import android.graphics.Color;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class QrConfig implements Serializable {
    public static final int BARCODE_CODABAR = 38;
    public static final int BARCODE_CODE128 = 128;
    public static final int BARCODE_CODE39 = 39;
    public static final int BARCODE_CODE93 = 93;
    public static final int BARCODE_DATABAR = 34;
    public static final int BARCODE_DATABAR_EXP = 35;
    public static final int BARCODE_EAN13 = 13;
    public static final int BARCODE_EAN8 = 8;
    public static final int BARCODE_I25 = 25;
    public static final int BARCODE_ISBN10 = 10;
    public static final int BARCODE_ISBN13 = 14;
    public static final int BARCODE_PDF417 = 57;
    public static final int BARCODE_UPCA = 12;
    public static final int BARCODE_UPCE = 9;
    public static final String EXTRA_THIS_CONFIG = "extra_this_config";
    public static final int LINE_FAST = 1000;
    public static final int LINE_MEDIUM = 2000;
    public static final int LINE_SLOW = 3000;
    public static final int REQUEST_CAMERA = 99;
    public static final int SCANVIEW_TYPE_BARCODE = 2;
    public static final int SCANVIEW_TYPE_QRCODE = 1;
    public static final int SCREEN_LANDSCAPE = 2;
    public static final int SCREEN_PORTRAIT = 1;
    public static final int SCREEN_SENSOR = 3;
    public static final int TYPE_ALL = 3;
    public static final int TYPE_BARCODE = 2;
    public static final int TYPE_CUSTOM = 4;
    public static final int TYPE_QRCODE = 1;
    public static int ding_path = R$raw.qrcode;
    public int CORNER_COLOR = Color.parseColor("#ff5f00");
    public int LINE_COLOR = Color.parseColor("#ff5f00");
    public int TITLE_BACKGROUND_COLOR = Color.parseColor("#ff5f00");
    public int TITLE_TEXT_COLOR = Color.parseColor("#ffffff");
    public boolean show_title = true;
    public boolean show_light = true;
    public boolean show_album = true;
    public boolean show_des = true;
    public boolean need_crop = true;
    public boolean show_zoom = false;
    public boolean auto_zoom = false;
    public boolean finger_zoom = false;
    public boolean only_center = false;
    public boolean play_sound = true;
    public boolean double_engine = false;
    public boolean loop_scan = false;
    public boolean show_vibrator = false;
    public String title_text = "扫描二维码";
    public String des_text = "(识别二维码)";
    public String open_album_text = "选择要识别的图片";
    public int line_speed = 1000;
    public int line_style = 2;
    public int corner_width = 10;
    public int loop_wait_time = 0;
    public int back_img_res = R$drawable.scanner_back_img;
    public int falsh_img_res = R$drawable.scanner_light;
    public int album_img_res = R$drawable.scanner_album;
    public boolean auto_light = false;
    public int custombarcodeformat = -1;
    public int scan_type = 1;
    public int scan_view_type = 1;
    public int SCREEN_ORIENTATION = 1;

    public static class a {
        private QrConfig a = new QrConfig();

        public QrConfig a() {
            return this.a;
        }

        public a b(boolean z) {
            this.a.auto_zoom = z;
            return this;
        }

        public a c(int i) {
            this.a.CORNER_COLOR = i;
            return this;
        }

        public a d(int i) {
            this.a.custombarcodeformat = i;
            return this;
        }

        public a e(String str) {
            this.a.des_text = str;
            return this;
        }

        public a f(boolean z) {
            this.a.finger_zoom = z;
            return this;
        }

        public a g(boolean z) {
            this.a.only_center = z;
            return this;
        }

        public a h(int i) {
            this.a.LINE_COLOR = i;
            return this;
        }

        public a i(int i) {
            this.a.line_speed = i;
            return this;
        }

        public a j(boolean z) {
            this.a.need_crop = z;
            return this;
        }

        public a k(boolean z) {
            this.a.play_sound = z;
            return this;
        }

        public a l(int i) {
            this.a.scan_type = i;
            return this;
        }

        public a m(int i) {
            this.a.scan_view_type = i;
            return this;
        }

        public a n(int i) {
            this.a.SCREEN_ORIENTATION = i;
            return this;
        }

        public a o(boolean z) {
            this.a.show_album = z;
            return this;
        }

        public a p(boolean z) {
            this.a.show_des = z;
            return this;
        }

        public a q(boolean z) {
            this.a.show_light = z;
            return this;
        }

        public a r(boolean z) {
            this.a.show_title = z;
            return this;
        }

        public a s(boolean z) {
            this.a.show_zoom = z;
            return this;
        }

        public a t(int i) {
            this.a.TITLE_BACKGROUND_COLOR = i;
            return this;
        }

        public a u(String str) {
            this.a.title_text = str;
            return this;
        }

        public a v(int i) {
            this.a.TITLE_TEXT_COLOR = i;
            return this;
        }
    }

    public static int getDing_path() {
        return ding_path;
    }

    public int getAblumImageRes() {
        return this.album_img_res;
    }

    public int getBackImgRes() {
        return this.back_img_res;
    }

    public int getCORNER_COLOR() {
        return this.CORNER_COLOR;
    }

    public int getCorner_width() {
        return this.corner_width;
    }

    public int getCustombarcodeformat() {
        return this.custombarcodeformat;
    }

    public String getDes_text() {
        return this.des_text;
    }

    public int getLINE_COLOR() {
        return this.LINE_COLOR;
    }

    public int getLightImageRes() {
        return this.falsh_img_res;
    }

    public int getLine_speed() {
        return this.line_speed;
    }

    public int getLine_style() {
        return this.line_style;
    }

    public int getLoop_wait_time() {
        return this.loop_wait_time;
    }

    public String getOpen_album_text() {
        return this.open_album_text;
    }

    public int getSCREEN_ORIENTATION() {
        return this.SCREEN_ORIENTATION;
    }

    public int getScan_type() {
        return this.scan_type;
    }

    public int getScan_view_type() {
        return this.scan_view_type;
    }

    public int getTITLE_BACKGROUND_COLOR() {
        return this.TITLE_BACKGROUND_COLOR;
    }

    public int getTITLE_TEXT_COLOR() {
        return this.TITLE_TEXT_COLOR;
    }

    public String getTitle_text() {
        return this.title_text;
    }

    public boolean isAuto_light() {
        return this.auto_light;
    }

    public boolean isAuto_zoom() {
        return this.auto_zoom;
    }

    public boolean isDouble_engine() {
        return this.double_engine;
    }

    public boolean isFinger_zoom() {
        return this.finger_zoom;
    }

    public boolean isLoop_scan() {
        return this.loop_scan;
    }

    public boolean isNeed_crop() {
        return this.need_crop;
    }

    public boolean isOnly_center() {
        return this.only_center;
    }

    public boolean isPlay_sound() {
        return this.play_sound;
    }

    public boolean isShow_album() {
        return this.show_album;
    }

    public boolean isShow_des() {
        return this.show_des;
    }

    public boolean isShow_light() {
        return this.show_light;
    }

    public boolean isShow_title() {
        return this.show_title;
    }

    public boolean isShow_vibrator() {
        return this.show_vibrator;
    }

    public boolean isShow_zoom() {
        return this.show_zoom;
    }
}
