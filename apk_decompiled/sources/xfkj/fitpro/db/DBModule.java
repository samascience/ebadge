package xfkj.fitpro.db;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import defpackage.g82;
import xfkj.fitpro.db.build.BatteryCalculateParamsBeanDao;
import xfkj.fitpro.db.build.ClockDialInfoBodyDao;
import xfkj.fitpro.db.build.ContractModelDao;
import xfkj.fitpro.db.build.DaoMaster;
import xfkj.fitpro.db.build.DaoSession;
import xfkj.fitpro.db.build.DeviceFunctionConfigModelDao;
import xfkj.fitpro.db.build.DeviceHardInfoModelDao;
import xfkj.fitpro.db.build.DrinkModelDao;
import xfkj.fitpro.db.build.DrinkModelOfDayDao;
import xfkj.fitpro.db.build.ECGRecordModelDao;
import xfkj.fitpro.db.build.GestureControlConfigModelDao;
import xfkj.fitpro.db.build.IMEIStatusModelDao;
import xfkj.fitpro.db.build.MeasureBloodModelDao;
import xfkj.fitpro.db.build.MeasureHeartModelDao;
import xfkj.fitpro.db.build.MeasureSpoModelDao;
import xfkj.fitpro.db.build.PaymentCodeResponseDao;
import xfkj.fitpro.db.build.ProductInfoModelDao;
import xfkj.fitpro.db.build.SleepDetailsModelDao;
import xfkj.fitpro.db.build.SportDetailsModelDao;
import xfkj.fitpro.db.build.SportDetialsGroupDao;
import xfkj.fitpro.db.build.SportStandGroupModelDao;
import xfkj.fitpro.db.build.SportStandModelDao;
import xfkj.fitpro.db.build.TempModelDao;
import xfkj.fitpro.db.build.WatchSportsDataGroupModelOfDayDao;
import xfkj.fitpro.db.build.WatchSportsDataGroupModelOfMonthDao;
import xfkj.fitpro.db.build.WatchSportsDataModelDao;
import xfkj.fitpro.db.build.WeatherForecastResponseDao;

/* JADX INFO: loaded from: classes4.dex */
public class DBModule {
    public static final boolean ENCRYPTED = false;
    public static String KEY;
    private Application application;
    private String dbName;
    private String dbPath;
    private final String TAG = "DBModule";
    private DaoSession daoSession = null;

    public class DBOpenHelper extends DaoMaster.OpenHelper {
        public DBOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        @Override // org.greenrobot.greendao.database.a, android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
            Log.i("greenDAO", "Upgrading schema from version " + i + " to " + i2 + " by dropping all tables");
            MigrationHelper.getInstance().migrate(sQLiteDatabase, ContractModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, WeatherForecastResponseDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, TempModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, ClockDialInfoBodyDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, SleepDetailsModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, DeviceHardInfoModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, ECGRecordModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, WatchSportsDataGroupModelOfMonthDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, WatchSportsDataGroupModelOfDayDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, WatchSportsDataModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, ProductInfoModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, SportDetailsModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, SportDetialsGroupDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, SportStandModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, SportStandGroupModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, DrinkModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, DrinkModelOfDayDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, MeasureHeartModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, MeasureBloodModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, MeasureSpoModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, GestureControlConfigModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, IMEIStatusModelDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, PaymentCodeResponseDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, BatteryCalculateParamsBeanDao.class);
            MigrationHelper.getInstance().migrate(sQLiteDatabase, DeviceFunctionConfigModelDao.class);
        }
    }

    private static final class SingletonHolder {
        private static final DBModule INSTANCE = new DBModule();

        private SingletonHolder() {
        }
    }

    public static DBModule getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public DaoSession getDaoSession() {
        return this.daoSession;
    }

    public void init(Application application) {
        init(application, g82.d, g82.a);
    }

    public void init(Application application, String str, String str2) {
        DBOpenHelper dBOpenHelper;
        this.application = application;
        this.dbPath = str;
        this.dbName = str2;
        if (TextUtils.isEmpty(str)) {
            DBContextWrapper dBContextWrapper = new DBContextWrapper(application);
            if (TextUtils.isEmpty(str2)) {
                str2 = "db";
            }
            dBOpenHelper = new DBOpenHelper(dBContextWrapper, str2, null);
        } else {
            DBContextWrapper dBContextWrapper2 = new DBContextWrapper(application, str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "db";
            }
            dBOpenHelper = new DBOpenHelper(dBContextWrapper2, str2, null);
        }
        this.daoSession = new DaoMaster(dBOpenHelper.getWritableDb()).newSession();
    }
}
