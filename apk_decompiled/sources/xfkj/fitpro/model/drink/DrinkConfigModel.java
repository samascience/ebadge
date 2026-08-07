package xfkj.fitpro.model.drink;

/* JADX INFO: loaded from: classes4.dex */
public class DrinkConfigModel {
    float durationOfDrinkWarn;
    int finishTimeOfWarn;
    Long id;
    boolean isOnly;
    boolean isWarnOfDrink;
    int startTimeOfWarn;
    boolean warnFinishOfToday;

    public DrinkConfigModel(Long l, boolean z, float f, int i, int i2, boolean z2, boolean z3) {
        this.id = l;
        this.isWarnOfDrink = z;
        this.durationOfDrinkWarn = f;
        this.startTimeOfWarn = i;
        this.finishTimeOfWarn = i2;
        this.warnFinishOfToday = z2;
        this.isOnly = z3;
    }

    public float getDurationOfDrinkWarn() {
        return this.durationOfDrinkWarn;
    }

    public int getFinishTimeOfWarn() {
        return this.finishTimeOfWarn;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsOnly() {
        return this.isOnly;
    }

    public boolean getIsWarnOfDrink() {
        return this.isWarnOfDrink;
    }

    public int getStartTimeOfWarn() {
        return this.startTimeOfWarn;
    }

    public boolean getWarnFinishOfToday() {
        return this.warnFinishOfToday;
    }

    public void setDurationOfDrinkWarn(float f) {
        this.durationOfDrinkWarn = f;
    }

    public void setFinishTimeOfWarn(int i) {
        this.finishTimeOfWarn = i;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsOnly(boolean z) {
        this.isOnly = z;
    }

    public void setIsWarnOfDrink(boolean z) {
        this.isWarnOfDrink = z;
    }

    public void setStartTimeOfWarn(int i) {
        this.startTimeOfWarn = i;
    }

    public void setWarnFinishOfToday(boolean z) {
        this.warnFinishOfToday = z;
    }

    public DrinkConfigModel() {
        this.durationOfDrinkWarn = 2.0f;
        this.startTimeOfWarn = 480;
        this.finishTimeOfWarn = 1200;
        this.isOnly = true;
    }
}
