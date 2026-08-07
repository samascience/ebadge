package xfkj.fitpro.model.sever.body;

/* JADX INFO: loaded from: classes4.dex */
public class ClockDialInfoBody {
    private byte algorithm;
    private int config;
    private String customer;
    String devId;
    private int grade;
    private short height;
    private String mainModel;
    private String mchModel;
    private int pictureNums;
    private int screenType;
    private int thumbHeight;
    private int thumbWidth;
    private byte versionCode;
    private int watchThemeShortPkgLenght;
    private int watchThemeVersion;
    private short width;

    public ClockDialInfoBody(String str, String str2, String str3, int i, int i2, short s, short s2, int i3, byte b, byte b2, String str4, int i4, int i5, int i6, int i7, int i8) {
        this.devId = str;
        this.mainModel = str2;
        this.mchModel = str3;
        this.grade = i;
        this.screenType = i2;
        this.width = s;
        this.height = s2;
        this.config = i3;
        this.algorithm = b;
        this.versionCode = b2;
        this.customer = str4;
        this.pictureNums = i4;
        this.watchThemeVersion = i5;
        this.watchThemeShortPkgLenght = i6;
        this.thumbWidth = i7;
        this.thumbHeight = i8;
    }

    public byte getAlgorithm() {
        return this.algorithm;
    }

    public int getConfig() {
        return this.config;
    }

    public String getCustomer() {
        return this.customer;
    }

    public String getDevId() {
        return this.devId;
    }

    public int getGrade() {
        return this.grade;
    }

    public short getHeight() {
        return this.height;
    }

    public String getMainModel() {
        return this.mainModel;
    }

    public String getMchModel() {
        return this.mchModel;
    }

    public int getPictureNums() {
        return this.pictureNums;
    }

    public int getScreenType() {
        return this.screenType;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public byte getVersionCode() {
        return this.versionCode;
    }

    public int getWatchThemeShortPkgLenght() {
        return this.watchThemeShortPkgLenght;
    }

    public int getWatchThemeVersion() {
        return this.watchThemeVersion;
    }

    public short getWidth() {
        return this.width;
    }

    public void setAlgorithm(byte b) {
        this.algorithm = b;
    }

    public void setConfig(int i) {
        this.config = i;
    }

    public void setCustomer(String str) {
        this.customer = str;
    }

    public void setDevId(String str) {
        this.devId = str;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public void setHeight(short s) {
        this.height = s;
    }

    public void setMainModel(String str) {
        this.mainModel = str;
    }

    public void setMchModel(String str) {
        this.mchModel = str;
    }

    public void setPictureNums(int i) {
        this.pictureNums = i;
    }

    public void setScreenType(int i) {
        this.screenType = i;
    }

    public void setThumbHeight(int i) {
        this.thumbHeight = i;
    }

    public void setThumbWidth(int i) {
        this.thumbWidth = i;
    }

    public void setVersionCode(byte b) {
        this.versionCode = b;
    }

    public void setWatchThemeShortPkgLenght(int i) {
        this.watchThemeShortPkgLenght = i;
    }

    public void setWatchThemeVersion(int i) {
        this.watchThemeVersion = i;
    }

    public void setWidth(short s) {
        this.width = s;
    }

    public String toString() {
        return "ClockDialInfoBody{devId='" + this.devId + "', mainModel='" + this.mainModel + "', mchModel='" + this.mchModel + "', grade=" + this.grade + ", screenType=" + this.screenType + ", width=" + ((int) this.width) + ", height=" + ((int) this.height) + ", config=" + this.config + ", algorithm=" + ((int) this.algorithm) + ", versionCode=" + ((int) this.versionCode) + ", customer='" + this.customer + "', pictureNums=" + this.pictureNums + ", watchThemeVersion=" + this.watchThemeVersion + ", watchThemeShortPkgLenght=" + this.watchThemeShortPkgLenght + ", thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + '}';
    }

    public ClockDialInfoBody() {
    }
}
