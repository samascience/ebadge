package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class DeviceFunctionConfigModel {
    private String deviceMac;
    private Boolean isCloseDrinkWarn;
    private Boolean isCloseEmergencyContact;
    private Boolean isCloseNotification;
    private Boolean isClosePinchToAnswer;
    private Boolean isCloseRestingHeartRate;
    private Boolean isCloseShakeMusicToggle;
    private Boolean isCloseShakeToReject;
    private Boolean isCloseShakeToSwitchVideo;
    private Boolean isCloseTempUnite;
    private Boolean isDefaultOpenCall;
    private Boolean isShowAdv;
    private Boolean isShowBattery;
    private Boolean isShowBatteryPercentage;
    private Boolean isShowBlood;
    private Boolean isShowClockDial;
    private Boolean isShowDistance;
    private Boolean isShowDisturbMode;
    private Boolean isShowFindDevice;
    private Boolean isShowHeart;
    private Boolean isShowHrEl;
    private Boolean isShowLongDurationTime;
    private Boolean isShowMoreNotifi;
    private Boolean isShowOta;
    private Boolean isShowRemoteCamera;
    private Boolean isShowShakeMode;
    private Boolean isShowSleep;
    private Boolean isShowSpo;
    private Boolean isShowSyncontract;
    private Boolean isShowTemp;
    private Boolean isShowVoice;
    private Boolean isShowWeather;
    private Boolean isShowWxsport;
    private Boolean isSupportOfArmRemoval;
    private Boolean isSupportOfBodyGame;
    private Boolean isSupportOfExercise;
    private Boolean isSupportOfGestureControl;
    private Boolean isSupportOfIMEI;
    private Boolean isSupportPaymentQRCode;
    private Boolean isSupportRealTimeAlbumPreview;
    private Boolean isSupportSleepEyeMovement;
    private Boolean isTurnOff;
    private Long updateTime;

    public DeviceFunctionConfigModel(String str, Long l, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Boolean bool14, Boolean bool15, Boolean bool16, Boolean bool17, Boolean bool18, Boolean bool19, Boolean bool20, Boolean bool21, Boolean bool22, Boolean bool23, Boolean bool24, Boolean bool25, Boolean bool26, Boolean bool27, Boolean bool28, Boolean bool29, Boolean bool30, Boolean bool31, Boolean bool32, Boolean bool33, Boolean bool34, Boolean bool35, Boolean bool36, Boolean bool37, Boolean bool38, Boolean bool39, Boolean bool40, Boolean bool41) {
        this.deviceMac = str;
        this.updateTime = l;
        this.isShowOta = bool;
        this.isShowBattery = bool2;
        this.isShowHeart = bool3;
        this.isShowBlood = bool4;
        this.isShowSpo = bool5;
        this.isShowSleep = bool6;
        this.isShowDistance = bool7;
        this.isShowWxsport = bool8;
        this.isShowVoice = bool9;
        this.isShowSyncontract = bool10;
        this.isShowTemp = bool11;
        this.isShowWeather = bool12;
        this.isShowClockDial = bool13;
        this.isShowMoreNotifi = bool14;
        this.isShowAdv = bool15;
        this.isShowRemoteCamera = bool16;
        this.isShowFindDevice = bool17;
        this.isShowHrEl = bool18;
        this.isShowLongDurationTime = bool19;
        this.isShowDisturbMode = bool20;
        this.isShowShakeMode = bool21;
        this.isShowBatteryPercentage = bool22;
        this.isSupportOfBodyGame = bool23;
        this.isSupportOfGestureControl = bool24;
        this.isSupportOfIMEI = bool25;
        this.isSupportOfExercise = bool26;
        this.isSupportOfArmRemoval = bool27;
        this.isSupportSleepEyeMovement = bool28;
        this.isSupportPaymentQRCode = bool29;
        this.isSupportRealTimeAlbumPreview = bool30;
        this.isCloseTempUnite = bool31;
        this.isCloseDrinkWarn = bool32;
        this.isTurnOff = bool33;
        this.isCloseNotification = bool34;
        this.isCloseEmergencyContact = bool35;
        this.isCloseRestingHeartRate = bool36;
        this.isClosePinchToAnswer = bool37;
        this.isCloseShakeToReject = bool38;
        this.isCloseShakeToSwitchVideo = bool39;
        this.isCloseShakeMusicToggle = bool40;
        this.isDefaultOpenCall = bool41;
    }

    public String getDeviceMac() {
        return this.deviceMac;
    }

    public Boolean getIsCloseDrinkWarn() {
        return this.isCloseDrinkWarn;
    }

    public Boolean getIsCloseEmergencyContact() {
        return this.isCloseEmergencyContact;
    }

    public Boolean getIsCloseNotification() {
        return this.isCloseNotification;
    }

    public Boolean getIsClosePinchToAnswer() {
        return this.isClosePinchToAnswer;
    }

    public Boolean getIsCloseRestingHeartRate() {
        return this.isCloseRestingHeartRate;
    }

    public Boolean getIsCloseShakeMusicToggle() {
        return this.isCloseShakeMusicToggle;
    }

    public Boolean getIsCloseShakeToReject() {
        return this.isCloseShakeToReject;
    }

    public Boolean getIsCloseShakeToSwitchVideo() {
        return this.isCloseShakeToSwitchVideo;
    }

    public Boolean getIsCloseTempUnite() {
        return this.isCloseTempUnite;
    }

    public Boolean getIsDefaultOpenCall() {
        return this.isDefaultOpenCall;
    }

    public Boolean getIsShowAdv() {
        return this.isShowAdv;
    }

    public Boolean getIsShowBattery() {
        return this.isShowBattery;
    }

    public Boolean getIsShowBatteryPercentage() {
        return this.isShowBatteryPercentage;
    }

    public Boolean getIsShowBlood() {
        return this.isShowBlood;
    }

    public Boolean getIsShowClockDial() {
        return this.isShowClockDial;
    }

    public Boolean getIsShowDistance() {
        return this.isShowDistance;
    }

    public Boolean getIsShowDisturbMode() {
        return this.isShowDisturbMode;
    }

    public Boolean getIsShowFindDevice() {
        return this.isShowFindDevice;
    }

    public Boolean getIsShowHeart() {
        return this.isShowHeart;
    }

    public Boolean getIsShowHrEl() {
        return this.isShowHrEl;
    }

    public Boolean getIsShowLongDurationTime() {
        return this.isShowLongDurationTime;
    }

    public Boolean getIsShowMoreNotifi() {
        return this.isShowMoreNotifi;
    }

    public Boolean getIsShowOta() {
        return this.isShowOta;
    }

    public Boolean getIsShowRemoteCamera() {
        return this.isShowRemoteCamera;
    }

    public Boolean getIsShowShakeMode() {
        return this.isShowShakeMode;
    }

    public Boolean getIsShowSleep() {
        return this.isShowSleep;
    }

    public Boolean getIsShowSpo() {
        return this.isShowSpo;
    }

    public Boolean getIsShowSyncontract() {
        return this.isShowSyncontract;
    }

    public Boolean getIsShowTemp() {
        return this.isShowTemp;
    }

    public Boolean getIsShowVoice() {
        return this.isShowVoice;
    }

    public Boolean getIsShowWeather() {
        return this.isShowWeather;
    }

    public Boolean getIsShowWxsport() {
        return this.isShowWxsport;
    }

    public Boolean getIsSupportOfArmRemoval() {
        return this.isSupportOfArmRemoval;
    }

    public Boolean getIsSupportOfBodyGame() {
        return this.isSupportOfBodyGame;
    }

    public Boolean getIsSupportOfExercise() {
        return this.isSupportOfExercise;
    }

    public Boolean getIsSupportOfGestureControl() {
        return this.isSupportOfGestureControl;
    }

    public Boolean getIsSupportOfIMEI() {
        return this.isSupportOfIMEI;
    }

    public Boolean getIsSupportPaymentQRCode() {
        return this.isSupportPaymentQRCode;
    }

    public Boolean getIsSupportRealTimeAlbumPreview() {
        return this.isSupportRealTimeAlbumPreview;
    }

    public Boolean getIsSupportSleepEyeMovement() {
        return this.isSupportSleepEyeMovement;
    }

    public Boolean getIsTurnOff() {
        return this.isTurnOff;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public void setIsCloseDrinkWarn(Boolean bool) {
        this.isCloseDrinkWarn = bool;
    }

    public void setIsCloseEmergencyContact(Boolean bool) {
        this.isCloseEmergencyContact = bool;
    }

    public void setIsCloseNotification(Boolean bool) {
        this.isCloseNotification = bool;
    }

    public void setIsClosePinchToAnswer(Boolean bool) {
        this.isClosePinchToAnswer = bool;
    }

    public void setIsCloseRestingHeartRate(Boolean bool) {
        this.isCloseRestingHeartRate = bool;
    }

    public void setIsCloseShakeMusicToggle(Boolean bool) {
        this.isCloseShakeMusicToggle = bool;
    }

    public void setIsCloseShakeToReject(Boolean bool) {
        this.isCloseShakeToReject = bool;
    }

    public void setIsCloseShakeToSwitchVideo(Boolean bool) {
        this.isCloseShakeToSwitchVideo = bool;
    }

    public void setIsCloseTempUnite(Boolean bool) {
        this.isCloseTempUnite = bool;
    }

    public void setIsDefaultOpenCall(Boolean bool) {
        this.isDefaultOpenCall = bool;
    }

    public void setIsShowAdv(Boolean bool) {
        this.isShowAdv = bool;
    }

    public void setIsShowBattery(Boolean bool) {
        this.isShowBattery = bool;
    }

    public void setIsShowBatteryPercentage(Boolean bool) {
        this.isShowBatteryPercentage = bool;
    }

    public void setIsShowBlood(Boolean bool) {
        this.isShowBlood = bool;
    }

    public void setIsShowClockDial(Boolean bool) {
        this.isShowClockDial = bool;
    }

    public void setIsShowDistance(Boolean bool) {
        this.isShowDistance = bool;
    }

    public void setIsShowDisturbMode(Boolean bool) {
        this.isShowDisturbMode = bool;
    }

    public void setIsShowFindDevice(Boolean bool) {
        this.isShowFindDevice = bool;
    }

    public void setIsShowHeart(Boolean bool) {
        this.isShowHeart = bool;
    }

    public void setIsShowHrEl(Boolean bool) {
        this.isShowHrEl = bool;
    }

    public void setIsShowLongDurationTime(Boolean bool) {
        this.isShowLongDurationTime = bool;
    }

    public void setIsShowMoreNotifi(Boolean bool) {
        this.isShowMoreNotifi = bool;
    }

    public void setIsShowOta(Boolean bool) {
        this.isShowOta = bool;
    }

    public void setIsShowRemoteCamera(Boolean bool) {
        this.isShowRemoteCamera = bool;
    }

    public void setIsShowShakeMode(Boolean bool) {
        this.isShowShakeMode = bool;
    }

    public void setIsShowSleep(Boolean bool) {
        this.isShowSleep = bool;
    }

    public void setIsShowSpo(Boolean bool) {
        this.isShowSpo = bool;
    }

    public void setIsShowSyncontract(Boolean bool) {
        this.isShowSyncontract = bool;
    }

    public void setIsShowTemp(Boolean bool) {
        this.isShowTemp = bool;
    }

    public void setIsShowVoice(Boolean bool) {
        this.isShowVoice = bool;
    }

    public void setIsShowWeather(Boolean bool) {
        this.isShowWeather = bool;
    }

    public void setIsShowWxsport(Boolean bool) {
        this.isShowWxsport = bool;
    }

    public void setIsSupportOfArmRemoval(Boolean bool) {
        this.isSupportOfArmRemoval = bool;
    }

    public void setIsSupportOfBodyGame(Boolean bool) {
        this.isSupportOfBodyGame = bool;
    }

    public void setIsSupportOfExercise(Boolean bool) {
        this.isSupportOfExercise = bool;
    }

    public void setIsSupportOfGestureControl(Boolean bool) {
        this.isSupportOfGestureControl = bool;
    }

    public void setIsSupportOfIMEI(Boolean bool) {
        this.isSupportOfIMEI = bool;
    }

    public void setIsSupportPaymentQRCode(Boolean bool) {
        this.isSupportPaymentQRCode = bool;
    }

    public void setIsSupportRealTimeAlbumPreview(Boolean bool) {
        this.isSupportRealTimeAlbumPreview = bool;
    }

    public void setIsSupportSleepEyeMovement(Boolean bool) {
        this.isSupportSleepEyeMovement = bool;
    }

    public void setIsTurnOff(Boolean bool) {
        this.isTurnOff = bool;
    }

    public void setUpdateTime(Long l) {
        this.updateTime = l;
    }

    public DeviceFunctionConfigModel() {
    }
}
