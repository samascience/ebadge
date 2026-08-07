package xfkj.fitpro.model.motion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import xfkj.fitpro.db.build.DaoSession;
import xfkj.fitpro.db.build.PathRecordDao;

/* JADX INFO: loaded from: classes4.dex */
public class PathRecord {
    private int calory;
    private transient DaoSession daoSession;
    private Date date;
    private double distance;
    private long duration;
    private Long id;
    int mode;
    private transient PathRecordDao myDao;
    private int pace;
    private List<TrackModel> posList;
    long userId;

    public PathRecord() {
        this.posList = new ArrayList();
        this.userId = -1L;
    }

    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        this.myDao = daoSession != null ? daoSession.getPathRecordDao() : null;
    }

    public void addpoint(TrackModel trackModel) {
        this.posList.add(trackModel);
    }

    public void delete() {
        PathRecordDao pathRecordDao = this.myDao;
        if (pathRecordDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        pathRecordDao.delete(this);
    }

    public int getCalory() {
        return this.calory;
    }

    public Date getDate() {
        return this.date;
    }

    public double getDistance() {
        return this.distance;
    }

    public long getDuration() {
        return this.duration;
    }

    public Long getId() {
        return this.id;
    }

    public int getMode() {
        return this.mode;
    }

    public int getPace() {
        return this.pace;
    }

    public List<TrackModel> getPosList() {
        if (this.posList == null) {
            DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            List<TrackModel> list_queryPathRecord_PosList = daoSession.getTrackModelDao()._queryPathRecord_PosList(this.id);
            synchronized (this) {
                try {
                    if (this.posList == null) {
                        this.posList = list_queryPathRecord_PosList;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.posList;
    }

    public long getUserId() {
        return this.userId;
    }

    public void refresh() {
        PathRecordDao pathRecordDao = this.myDao;
        if (pathRecordDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        pathRecordDao.refresh(this);
    }

    public synchronized void resetPosList() {
        this.posList = null;
    }

    public void setCalory(int i) {
        this.calory = i;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setMode(int i) {
        this.mode = i;
    }

    public void setPace(int i) {
        this.pace = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        return "PathRecord{id=" + this.id + ", posList=" + this.posList + ", distance=" + this.distance + ", duration=" + this.duration + ", calory=" + this.calory + ", pace=" + this.pace + ", date=" + this.date + ", mode=" + this.mode + ", userId=" + this.userId + ", daoSession=" + this.daoSession + ", myDao=" + this.myDao + '}';
    }

    public void update() {
        PathRecordDao pathRecordDao = this.myDao;
        if (pathRecordDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        pathRecordDao.update(this);
    }

    public PathRecord(Long l, double d, long j, int i, int i2, Date date, int i3, long j2) {
        this.posList = new ArrayList();
        this.id = l;
        this.distance = d;
        this.duration = j;
        this.calory = i;
        this.pace = i2;
        this.date = date;
        this.mode = i3;
        this.userId = j2;
    }
}
