package xfkj.fitpro.model.weight;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import xfkj.fitpro.db.build.DaoSession;
import xfkj.fitpro.db.build.WeightMannagerModelDao;

/* JADX INFO: loaded from: classes4.dex */
public class WeightMannagerModel {
    float chuShiWeight;
    private transient DaoSession daoSession;
    Date finishDate;
    private Long id;
    boolean isInCrease;
    private transient WeightMannagerModelDao myDao;
    Date startDate;
    float targetWeight;
    float tiZhi;
    List<WeightModel> weightModelList;

    public WeightMannagerModel(Long l, Date date, Date date2, float f, float f2, boolean z, float f3) {
        this.id = l;
        this.startDate = date;
        this.finishDate = date2;
        this.chuShiWeight = f;
        this.targetWeight = f2;
        this.isInCrease = z;
        this.tiZhi = f3;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getWeightMannagerModelDao() : null;
    }

    public void delete() {
        WeightMannagerModelDao weightMannagerModelDao = this.myDao;
        if (weightMannagerModelDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        weightMannagerModelDao.delete(this);
    }

    public float getChuShiWeight() {
        return this.chuShiWeight;
    }

    public Date getFinishDate() {
        return this.finishDate;
    }

    public Long getId() {
        return this.id;
    }

    public boolean getIsInCrease() {
        return this.isInCrease;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public float getTargetWeight() {
        return this.targetWeight;
    }

    public float getTiZhi() {
        return this.tiZhi;
    }

    public List<WeightModel> getWeightModelList() {
        if (this.weightModelList == null) {
            DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            List<WeightModel> list_queryWeightMannagerModel_WeightModelList = daoSession.getWeightModelDao()._queryWeightMannagerModel_WeightModelList(this.id.longValue());
            synchronized (this) {
                try {
                    if (this.weightModelList == null) {
                        this.weightModelList = list_queryWeightMannagerModel_WeightModelList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.weightModelList;
    }

    public void refresh() {
        WeightMannagerModelDao weightMannagerModelDao = this.myDao;
        if (weightMannagerModelDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        weightMannagerModelDao.refresh(this);
    }

    public synchronized void resetWeightModelList() {
        this.weightModelList = null;
    }

    public void setChuShiWeight(float f) {
        this.chuShiWeight = f;
    }

    public void setFinishDate(Date date) {
        this.finishDate = date;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setIsInCrease(boolean z) {
        this.isInCrease = z;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public void setTargetWeight(float f) {
        this.targetWeight = f;
    }

    public void setTiZhi(float f) {
        this.tiZhi = f;
    }

    public void update() {
        WeightMannagerModelDao weightMannagerModelDao = this.myDao;
        if (weightMannagerModelDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        weightMannagerModelDao.update(this);
    }

    public WeightMannagerModel() {
    }
}
