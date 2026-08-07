package xfkj.fitpro.model.drink;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import xfkj.fitpro.db.build.DaoSession;
import xfkj.fitpro.db.build.DrinkModelOfDayDao;

/* JADX INFO: loaded from: classes4.dex */
public class DrinkModelOfDay {
    private transient DaoSession daoSession;
    String dayStr;
    List<DrinkModel> drinkModels;
    int globalDrink;
    private transient DrinkModelOfDayDao myDao;
    int totalML;

    public DrinkModelOfDay(String str, int i, int i2) {
        this.dayStr = str;
        this.totalML = i;
        this.globalDrink = i2;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getDrinkModelOfDayDao() : null;
    }

    public void delete() {
        DrinkModelOfDayDao drinkModelOfDayDao = this.myDao;
        if (drinkModelOfDayDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        drinkModelOfDayDao.delete(this);
    }

    public String getDayStr() {
        return this.dayStr;
    }

    public List<DrinkModel> getDrinkModels() {
        if (this.drinkModels == null) {
            DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            List<DrinkModel> list_queryDrinkModelOfDay_DrinkModels = daoSession.getDrinkModelDao()._queryDrinkModelOfDay_DrinkModels(this.dayStr);
            synchronized (this) {
                try {
                    if (this.drinkModels == null) {
                        this.drinkModels = list_queryDrinkModelOfDay_DrinkModels;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.drinkModels;
    }

    public int getGlobalDrink() {
        return this.globalDrink;
    }

    public int getTotalML() {
        return this.totalML;
    }

    public void refresh() {
        DrinkModelOfDayDao drinkModelOfDayDao = this.myDao;
        if (drinkModelOfDayDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        drinkModelOfDayDao.refresh(this);
    }

    public synchronized void resetDrinkModels() {
        this.drinkModels = null;
    }

    public void setDayStr(String str) {
        this.dayStr = str;
    }

    public void setGlobalDrink(int i) {
        this.globalDrink = i;
    }

    public void setTotalML(int i) {
        this.totalML = i;
    }

    public String toString() {
        return "DrinkModelOfDay{dayStr='" + this.dayStr + "', totalML=" + this.totalML + ", drinkModels=" + this.drinkModels + ", daoSession=" + this.daoSession + ", myDao=" + this.myDao + '}';
    }

    public void update() {
        DrinkModelOfDayDao drinkModelOfDayDao = this.myDao;
        if (drinkModelOfDayDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        drinkModelOfDayDao.update(this);
    }

    public DrinkModelOfDay() {
        this.globalDrink = 1000;
    }
}
