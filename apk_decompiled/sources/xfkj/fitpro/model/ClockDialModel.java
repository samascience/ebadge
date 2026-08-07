package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class ClockDialModel {
    int dialClickId;
    String fonBinPath;
    int fontPosition;
    int fontStyle;
    String picBinpath;
    String previewImgPath;
    int resId;

    public int getDialClickId() {
        return this.dialClickId;
    }

    public String getFonBinPath() {
        return this.fonBinPath;
    }

    public int getFontPosition() {
        return this.fontPosition;
    }

    public int getFontStyle() {
        return this.fontStyle;
    }

    public String getPicBinpath() {
        return this.picBinpath;
    }

    public String getPreviewImgPath() {
        return this.previewImgPath;
    }

    public int getResId() {
        return this.resId;
    }

    public void setDialClickId(int i) {
        this.dialClickId = i;
    }

    public void setFonBinPath(String str) {
        this.fonBinPath = str;
    }

    public void setFontPosition(int i) {
        this.fontPosition = i;
    }

    public void setFontStyle(int i) {
        this.fontStyle = i;
    }

    public void setPicBinpath(String str) {
        this.picBinpath = str;
    }

    public void setPreviewImgPath(String str) {
        this.previewImgPath = str;
    }

    public void setResId(int i) {
        this.resId = i;
    }

    public String toString() {
        return "ClockDialModel{resId=" + this.resId + ", dialClickId=" + this.dialClickId + ", fontPosition=" + this.fontPosition + ", fontStyle=" + this.fontStyle + ", picBinpath='" + this.picBinpath + "', previewImgPath='" + this.previewImgPath + "', fonBinPath='" + this.fonBinPath + "'}";
    }
}
