package xfkj.fitpro.utils;

/* JADX INFO: loaded from: classes4.dex */
public enum SleepUtils$SleepType {
    LIGHT(1),
    DEEP(2),
    WAKE_UP(255),
    EYE_MOVEMENT(4);

    int sleepType;

    SleepUtils$SleepType(int i) {
        this.sleepType = i;
    }

    public int getSleepType() {
        return this.sleepType;
    }
}
