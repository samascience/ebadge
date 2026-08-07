package xfkj.fitpro.model;

/* JADX INFO: loaded from: classes4.dex */
public class GestureControlConfigModel {
    Long id;
    private boolean isEnableOfGestureAnswer;
    private boolean isEnableOfGestureMusic;
    private boolean isEnableOfGestureRejection;
    private boolean isEnableOfGestureVideo;
    boolean isOnly;

    public GestureControlConfigModel(Long l, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.id = l;
        this.isEnableOfGestureAnswer = z;
        this.isEnableOfGestureRejection = z2;
        this.isEnableOfGestureVideo = z3;
        this.isEnableOfGestureMusic = z4;
        this.isOnly = z5;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsEnableOfGestureAnswer() {
        return this.isEnableOfGestureAnswer;
    }

    public boolean getIsEnableOfGestureMusic() {
        return this.isEnableOfGestureMusic;
    }

    public boolean getIsEnableOfGestureRejection() {
        return this.isEnableOfGestureRejection;
    }

    public boolean getIsEnableOfGestureVideo() {
        return this.isEnableOfGestureVideo;
    }

    public boolean getIsOnly() {
        return this.isOnly;
    }

    public boolean isEnableOfGestureAnswer() {
        return this.isEnableOfGestureAnswer;
    }

    public boolean isEnableOfGestureMusic() {
        return this.isEnableOfGestureMusic;
    }

    public boolean isEnableOfGestureRejection() {
        return this.isEnableOfGestureRejection;
    }

    public boolean isEnableOfGestureVideo() {
        return this.isEnableOfGestureVideo;
    }

    public void setEnableOfGestureAnswer(boolean z) {
        this.isEnableOfGestureAnswer = z;
    }

    public void setEnableOfGestureMusic(boolean z) {
        this.isEnableOfGestureMusic = z;
    }

    public void setEnableOfGestureRejection(boolean z) {
        this.isEnableOfGestureRejection = z;
    }

    public void setEnableOfGestureVideo(boolean z) {
        this.isEnableOfGestureVideo = z;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsEnableOfGestureAnswer(boolean z) {
        this.isEnableOfGestureAnswer = z;
    }

    public void setIsEnableOfGestureMusic(boolean z) {
        this.isEnableOfGestureMusic = z;
    }

    public void setIsEnableOfGestureRejection(boolean z) {
        this.isEnableOfGestureRejection = z;
    }

    public void setIsEnableOfGestureVideo(boolean z) {
        this.isEnableOfGestureVideo = z;
    }

    public void setIsOnly(boolean z) {
        this.isOnly = z;
    }

    public String toString() {
        return "GestureControlConfigModel{isEnableOfGestureAnswer=" + this.isEnableOfGestureAnswer + ", isEnableOfGestureRejection=" + this.isEnableOfGestureRejection + ", isEnableOfGestureVideo=" + this.isEnableOfGestureVideo + ", isEnableOfGestureMusic=" + this.isEnableOfGestureMusic + '}';
    }

    public GestureControlConfigModel() {
        this.isOnly = true;
    }
}
