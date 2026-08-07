package xfkj.fitpro.db;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.j;
import com.blankj.utilcode.util.o;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import defpackage.bn1;
import defpackage.db0;
import defpackage.e33;
import defpackage.fz;
import defpackage.g82;
import defpackage.gi3;
import defpackage.h82;
import defpackage.hg;
import defpackage.pv2;
import defpackage.u92;
import defpackage.zm1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import xfkj.fitpro.db.bean.BatteryCalculateParamsBean;
import xfkj.fitpro.db.build.BatteryCalculateParamsBeanDao;
import xfkj.fitpro.db.build.ClockDialInfoBodyDao;
import xfkj.fitpro.db.build.ContractModelDao;
import xfkj.fitpro.db.build.DaoSession;
import xfkj.fitpro.db.build.DeviceHardInfoModelDao;
import xfkj.fitpro.db.build.DrinkGlobalDao;
import xfkj.fitpro.db.build.DrinkModelDao;
import xfkj.fitpro.db.build.DrinkModelOfDayDao;
import xfkj.fitpro.db.build.ECGRecordModelDao;
import xfkj.fitpro.db.build.GpsDao;
import xfkj.fitpro.db.build.MeasureBloodModelDao;
import xfkj.fitpro.db.build.MeasureDetailsModelDao;
import xfkj.fitpro.db.build.MeasureHeartModelDao;
import xfkj.fitpro.db.build.MeasureSpoModelDao;
import xfkj.fitpro.db.build.PathRecordDao;
import xfkj.fitpro.db.build.PaymentCodeResponseDao;
import xfkj.fitpro.db.build.ProductInfoModelDao;
import xfkj.fitpro.db.build.QueryDataReponseDao;
import xfkj.fitpro.db.build.SessionBeanDao;
import xfkj.fitpro.db.build.SleepDetailsModelDao;
import xfkj.fitpro.db.build.SleepWarnModelDao;
import xfkj.fitpro.db.build.SportDetailsModelDao;
import xfkj.fitpro.db.build.SportDetialsGroupDao;
import xfkj.fitpro.db.build.SportStandGroupModelDao;
import xfkj.fitpro.db.build.SportStandModelDao;
import xfkj.fitpro.db.build.TempModelDao;
import xfkj.fitpro.db.build.TrackModelDao;
import xfkj.fitpro.db.build.UserBeanDao;
import xfkj.fitpro.db.build.UserHabbitConfigModelDao;
import xfkj.fitpro.db.build.UserHabbitCustomModelDao;
import xfkj.fitpro.db.build.UserHabbitModelDao;
import xfkj.fitpro.db.build.WatchSportsDataGroupModelOfDayDao;
import xfkj.fitpro.db.build.WatchSportsDataGroupModelOfMonthDao;
import xfkj.fitpro.db.build.WatchSportsDataModelDao;
import xfkj.fitpro.db.build.WeatherForecastResponseDao;
import xfkj.fitpro.db.build.WeatherResponseDao;
import xfkj.fitpro.model.ContractModel;
import xfkj.fitpro.model.DeviceHardInfoModel;
import xfkj.fitpro.model.ECGRecordModel;
import xfkj.fitpro.model.GestureControlConfigModel;
import xfkj.fitpro.model.Gps;
import xfkj.fitpro.model.MeasureBloodModel;
import xfkj.fitpro.model.MeasureDetailsModel;
import xfkj.fitpro.model.MeasureHeartModel;
import xfkj.fitpro.model.MeasureSpoModel;
import xfkj.fitpro.model.ProductInfoModel;
import xfkj.fitpro.model.SleepDetailsModel;
import xfkj.fitpro.model.SleepWarnModel;
import xfkj.fitpro.model.TempModel;
import xfkj.fitpro.model.UserHabbitConfigModel;
import xfkj.fitpro.model.UserHabbitCustomModel;
import xfkj.fitpro.model.UserHabbitModel;
import xfkj.fitpro.model.drink.DrinkConfigModel;
import xfkj.fitpro.model.drink.DrinkGlobal;
import xfkj.fitpro.model.drink.DrinkModel;
import xfkj.fitpro.model.drink.DrinkModelOfDay;
import xfkj.fitpro.model.motion.PathRecord;
import xfkj.fitpro.model.motion.TrackModel;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;
import xfkj.fitpro.model.sever.body.Device;
import xfkj.fitpro.model.sever.reponse.IMEIStatusModel;
import xfkj.fitpro.model.sever.reponse.LoginResponse;
import xfkj.fitpro.model.sever.reponse.PaymentCodeResponse;
import xfkj.fitpro.model.sever.reponse.QueryDataReponse;
import xfkj.fitpro.model.sever.reponse.SessionBean;
import xfkj.fitpro.model.sever.reponse.UserBean;
import xfkj.fitpro.model.sever.reponse.WeatherForecastResponse;
import xfkj.fitpro.model.sever.reponse.WeatherResponse;
import xfkj.fitpro.model.sportDetails.SportDetailsModel;
import xfkj.fitpro.model.sportDetails.SportDetialsGroup;
import xfkj.fitpro.model.sports.WatchSportsDataGroupModelOfDay;
import xfkj.fitpro.model.sports.WatchSportsDataGroupModelOfMonth;
import xfkj.fitpro.model.sports.WatchSportsDataModel;
import xfkj.fitpro.model.stand.SportStandGroupModel;
import xfkj.fitpro.model.stand.SportStandModel;
import xfkj.fitpro.model.weight.WeightMannagerModel;
import xfkj.fitpro.model.weight.WeightModel;

/* JADX INFO: loaded from: classes4.dex */
public class DBHelper {
    private static final String TAG = "DBHelper";

    public static void clearCache() {
        getDaoSession().clear();
    }

    public static void clearUploadedData() {
        getMeasureDetailsQueryBuilder().r(MeasureDetailsModelDao.Properties.UserId.d(-1), new gi3[0]).d().e();
        getSleepDetailsQueryBuilder().r(SleepDetailsModelDao.Properties.UserId.d(-1), new gi3[0]).d().e();
        getSportsDetailsQueryBuilderOrderDesc().r(SportDetailsModelDao.Properties.UserId.d(-1), new gi3[0]).d().e();
        getTempQueryBuilder().r(TempModelDao.Properties.UserId.d("-1"), new gi3[0]).d().e();
        getSportsDetailsGroupQueryBuilder().r(SportDetialsGroupDao.Properties.UserId.d(-1), new gi3[0]).d().e();
        getWatchSportsDataModelQueryBuilder().r(WatchSportsDataModelDao.Properties.UserId.d(-1), new gi3[0]).d().e();
        getWatchSportsDataGroupModelOfDayQueryBuilder().r(WatchSportsDataGroupModelOfDayDao.Properties.UserId.d(-1), new gi3[0]).d().e();
        getWatchSportsDataGroupModelOfMonthQueryBuilder().r(WatchSportsDataGroupModelOfMonthDao.Properties.UserId.d(-1), new gi3[0]).d().e();
    }

    public static void clearUserData() {
        getUserInfoDao().deleteAll();
        getUserDao().deleteAll();
        getSessionDao().deleteAll();
        getPathRecordDao().deleteAll();
        getTrackModelDao().deleteAll();
        getUserHabbitModelDao().deleteAll();
        getUserHabbitCustomModelDao().deleteAll();
        getUserHabbitConfigModelDao().deleteAll();
        zm1.h0(false);
    }

    public static void deleteAllContract() {
        getDaoSession().getContractModelDao().queryBuilder().r(ContractModelDao.Properties.DeviceId.b(zm1.f()), new gi3[0]).d().e();
    }

    public static void deleteClockDialInfo() {
        getDaoSession().getClockDialInfoBodyDao().deleteAll();
    }

    public static void deleteContract(ContractModel contractModel) {
        getDaoSession().getContractModelDao().delete(contractModel);
    }

    public static void deleteDrink(DrinkModel drinkModel) {
        getDaoSession().getDrinkModelDao().delete(drinkModel);
        updateDrinkOneDay(getDrinkofDayByDateStr(drinkModel.getKey()));
    }

    public static void deleteHabbitByHabbitId(long j) {
        getUserHabbitModelDao().queryBuilder().r(UserHabbitModelDao.Properties.HabbitId.b(Long.valueOf(j)), new gi3[0]).d().e();
    }

    public static void deletePathRecord(PathRecord pathRecord) {
        getPathRecordDao().delete(pathRecord);
        deleteTrackByRecodeId(pathRecord.getId().longValue());
    }

    public static void deleteSleepData() {
        getDaoSession().getSleepDetailsModelDao().deleteAll();
    }

    public static void deleteTrackByRecodeId(long j) {
        Iterator<TrackModel> it = getTracksByRecodId(j).iterator();
        while (it.hasNext()) {
            getTrackModelDao().delete(it.next());
        }
    }

    public static List<DrinkModelOfDay> getAllDrinkofDay() {
        return getDrinkOfDayQueryBuilder().l();
    }

    public static List<SleepDetailsModel> getAllSleepDetailsDatasByDateAsc() {
        return getSleepDetailsQueryBuilder().m(SleepDetailsModelDao.Properties.Date).l();
    }

    public static List<PathRecord> getAllSportRecordForMode(int i) {
        u92 u92VarQueryBuilder = getPathRecordDao().queryBuilder();
        u92VarQueryBuilder.r(PathRecordDao.Properties.Mode.b(Integer.valueOf(i)), new gi3[0]);
        u92VarQueryBuilder.o(PathRecordDao.Properties.Date);
        return u92VarQueryBuilder.l();
    }

    public static List<SportDetailsModel> getAllSportsDetails() {
        return getSportsDetailsQueryBuilderOrderDesc().o(SportDetailsModelDao.Properties.Date).l();
    }

    public static BatteryCalculateParamsBean getBatteryCalculateParams() {
        return getBatteryCalculateParams(zm1.f());
    }

    public static ClockDialInfoBody getClockDialInfo() {
        return (ClockDialInfoBody) getDaoSession().getClockDialInfoBodyDao().queryBuilder().r(ClockDialInfoBodyDao.Properties.DevId.b(zm1.f()), new gi3[0]).q();
    }

    public static List<ContractModel> getContracts() {
        List<ContractModel> listL = getDaoSession().getContractModelDao().queryBuilder().r(ContractModelDao.Properties.DeviceId.b(zm1.f()), new gi3[0]).l();
        return listL == null ? new ArrayList() : listL;
    }

    public static DaoSession getDaoSession() {
        if (DBModule.getInstance().getDaoSession() == null && g82.a()) {
            DBModule.getInstance().init(o.a());
        }
        return DBModule.getInstance().getDaoSession();
    }

    private static WeightMannagerModel getDefaultWeightTask() {
        WeightMannagerModel weightMannagerModel = new WeightMannagerModel();
        weightMannagerModel.setId(1L);
        weightMannagerModel.setStartDate(e33.e());
        weightMannagerModel.setFinishDate(bn1.i(15));
        weightMannagerModel.setChuShiWeight(zm1.C());
        weightMannagerModel.setIsInCrease(false);
        weightMannagerModel.setTargetWeight(50.0f);
        WeightModel weightModel = new WeightModel();
        weightModel.setWeight(zm1.C());
        weightModel.setDate(e33.e());
        insertWeight(weightMannagerModel.getId(), weightModel);
        return weightMannagerModel;
    }

    @SuppressLint({"MissingPermission"})
    public static Device getDevice() {
        String strG = zm1.g();
        String strF = zm1.f();
        if (pv2.f(strG)) {
            j.j(TAG, "手环软件版本为空，不上传");
            return null;
        }
        if (!BluetoothAdapter.checkBluetoothAddress(strF)) {
            j.j(TAG, "mac地址不正确，不上传");
            return null;
        }
        BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(strF);
        String name = remoteDevice != null ? remoteDevice.getName() : Constants.STR_EMPTY;
        Device device = new Device();
        device.setPhoneModel(db0.b());
        device.setAppVersion(c.i());
        device.setOsLang(Locale.getDefault().getLanguage());
        device.setOsVersion(db0.c());
        device.setMac(zm1.f());
        device.setOsType("1");
        device.setDeviceModel(name);
        device.setDeviceVersion(strG);
        device.setUserId(Long.valueOf(isLogin() ? getUserId() : 0L));
        return device;
    }

    public static DeviceHardInfoModel getDeviceHardInfo() {
        return (DeviceHardInfoModel) getDaoSession().getDeviceHardInfoModelDao().queryBuilder().r(DeviceHardInfoModelDao.Properties.DeviceId.b(zm1.f()), new gi3[0]).q();
    }

    public static List<DrinkModel> getDrinkByKey(String str) {
        u92 u92VarR = getDrinkQueryBuilder().r(DrinkModelDao.Properties.Key.b(str), new gi3[0]);
        u92VarR.r(DrinkModelDao.Properties.IsPresets.b(Boolean.FALSE), new gi3[0]);
        u92VarR.o(DrinkModelDao.Properties.Date);
        return u92VarR.l();
    }

    public static DrinkConfigModel getDrinkConfig() {
        return (DrinkConfigModel) getDaoSession().getDrinkConfigModelDao().queryBuilder().q();
    }

    public static DrinkGlobal getDrinkGlobalByDate(String str) {
        return (DrinkGlobal) getDaoSession().getDrinkGlobalDao().queryBuilder().r(DrinkGlobalDao.Properties.YyyyMMdd.b(str), new gi3[0]).q();
    }

    public static List<DrinkModel> getDrinkListByDates(Date date, Date date2) {
        u92 u92VarQueryBuilder = getDaoSession().getDrinkModelDao().queryBuilder();
        u92VarQueryBuilder.r(DrinkModelDao.Properties.Date.a(date, date2), new gi3[0]);
        return u92VarQueryBuilder.l();
    }

    private static u92 getDrinkOfDayQueryBuilder() {
        return getDaoSession().getDrinkModelOfDayDao().queryBuilder();
    }

    public static List<DrinkModel> getDrinkOneDay(Date date) {
        return getDrinkByKey(e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH)));
    }

    private static u92 getDrinkQueryBuilder() {
        return getDaoSession().getDrinkModelDao().queryBuilder();
    }

    public static DrinkModelOfDay getDrinkofDayByDate(Date date) {
        return getDrinkofDayByDateStr(e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH)));
    }

    public static DrinkModelOfDay getDrinkofDayByDateStr(String str) {
        return (DrinkModelOfDay) getDrinkOfDayQueryBuilder().r(DrinkModelOfDayDao.Properties.DayStr.b(str), new gi3[0]).q();
    }

    public static PathRecord getExceptionExitPathRecord() {
        u92 u92VarQueryBuilder = getPathRecordDao().queryBuilder();
        u92VarQueryBuilder.r(PathRecordDao.Properties.UserId.b(-1), new gi3[0]);
        u92VarQueryBuilder.o(PathRecordDao.Properties.Date);
        List listL = u92VarQueryBuilder.l();
        Log.i(TAG, "exception exit pathrecord count:" + listL.size());
        if (listL.size() <= 0) {
            return null;
        }
        if (listL.size() > 1) {
            for (int i = 1; i < listL.size(); i++) {
                deletePathRecord((PathRecord) listL.get(i));
                listL.remove(i);
            }
        }
        return (PathRecord) listL.get(0);
    }

    public static GestureControlConfigModel getGestureControlConfig() {
        GestureControlConfigModel gestureControlConfigModel = (GestureControlConfigModel) getDaoSession().getGestureControlConfigModelDao().queryBuilder().q();
        return gestureControlConfigModel == null ? new GestureControlConfigModel() : gestureControlConfigModel;
    }

    private static GpsDao getGpsDao() {
        return getDaoSession().getGpsDao();
    }

    public static UserHabbitModel getHabbitByHabbitId(long j) {
        return (UserHabbitModel) getUserHabbitModelDao().queryBuilder().r(UserHabbitModelDao.Properties.HabbitId.b(Long.valueOf(j)), new gi3[0]).q();
    }

    public static UserHabbitConfigModel getHabbitConfigByType(int i) {
        return (UserHabbitConfigModel) getUserHabbitConfigModelDao().queryBuilder().r(UserHabbitConfigModelDao.Properties.Id.b(Integer.valueOf(i)), new gi3[0]).q();
    }

    public static List<UserHabbitConfigModel> getHabbitConfigs() {
        return getUserHabbitConfigModelDao().loadAll();
    }

    public static List<UserHabbitModel> getHabbitList() {
        return getUserHabbitModelDao().loadAll();
    }

    public static IMEIStatusModel getIMEIStatusModel() {
        IMEIStatusModel iMEIStatusModel = (IMEIStatusModel) getDaoSession().getIMEIStatusModelDao().queryBuilder().q();
        return iMEIStatusModel == null ? new IMEIStatusModel() : iMEIStatusModel;
    }

    public static DrinkModel getLastDrinkModel() {
        u92 u92VarQueryBuilder = getDaoSession().getDrinkModelDao().queryBuilder();
        u92VarQueryBuilder.r(DrinkModelDao.Properties.IsPresets.d(Boolean.TRUE), new gi3[0]);
        u92VarQueryBuilder.o(DrinkModelDao.Properties.LocalDate);
        List listL = u92VarQueryBuilder.l();
        if (fz.a(listL)) {
            return null;
        }
        return (DrinkModel) listL.get(0);
    }

    public static ECGRecordModel getLastECGRecordModelData() {
        u92 u92VarR = getDaoSession().getECGRecordModelDao().queryBuilder().r(ECGRecordModelDao.Properties.DeviceId.b(zm1.f()), new gi3[0]);
        u92VarR.o(ECGRecordModelDao.Properties.Date);
        List listL = u92VarR.l();
        if (fz.a(listL)) {
            return null;
        }
        return (ECGRecordModel) listL.get(0);
    }

    public static MeasureBloodModel getLastMeasureBlood() {
        List listL = getMeasureBloodModelQueryBuilder().o(MeasureBloodModelDao.Properties.Date).k(1).l();
        return fz.a(listL) ? new MeasureBloodModel() : (MeasureBloodModel) listL.get(0);
    }

    public static MeasureHeartModel getLastMeasureHeart() {
        List listL = getMeasureHeartModelQueryBuilder().o(MeasureHeartModelDao.Properties.Date).k(1).l();
        return fz.a(listL) ? new MeasureHeartModel() : (MeasureHeartModel) listL.get(0);
    }

    public static MeasureSpoModel getLastMeasureSpo() {
        List listL = getMeasureSpoModelQueryBuilder().o(MeasureSpoModelDao.Properties.Date).k(1).l();
        return fz.a(listL) ? new MeasureSpoModel() : (MeasureSpoModel) listL.get(0);
    }

    public static List<TempModel> getLastNTempModelOfAsc(int i) {
        u92 tempQueryBuilder = getTempQueryBuilder();
        tempQueryBuilder.r(TempModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        tempQueryBuilder.m(TempModelDao.Properties.MeasureTime);
        tempQueryBuilder.k(i);
        return tempQueryBuilder.c().h();
    }

    public static List<TempModel> getLastNTempModelOfDesc(int i) {
        u92 tempQueryBuilder = getTempQueryBuilder();
        tempQueryBuilder.r(TempModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        tempQueryBuilder.o(TempModelDao.Properties.MeasureTime);
        tempQueryBuilder.k(i);
        return tempQueryBuilder.c().h();
    }

    public static List<TempModel> getLastNTempModelOfNoUpload() {
        u92 tempQueryBuilder = getTempQueryBuilder();
        tempQueryBuilder.r(TempModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        tempQueryBuilder.r(TempModelDao.Properties.UserId.b("-1"), new gi3[0]);
        return tempQueryBuilder.c().h();
    }

    public static SportDetailsModel getLastSportDetailsHistory(Date date) {
        return getLastSportDetailsHistory(e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH)));
    }

    public static SportStandModel getLastSportStandModel() {
        List listL = getSportStandModelQueryBuilder().o(SportStandModelDao.Properties.Date).l();
        if (fz.a(listL)) {
            return null;
        }
        return (SportStandModel) listL.get(0);
    }

    public static MeasureDetailsModel getLaststMeasureDetails() {
        return (MeasureDetailsModel) getMeasureDetailsQueryBuilder().o(MeasureDetailsModelDao.Properties.Date).k(1).q();
    }

    public static WeightModel getLaststWeightModel() {
        WeightMannagerModel weightTask = getWeightTask();
        weightTask.resetWeightModelList();
        List<WeightModel> weightModelList = weightTask.getWeightModelList();
        if (fz.a(weightModelList)) {
            return null;
        }
        return weightModelList.get(weightModelList.size() - 1);
    }

    public static String getMacAddress() {
        if (pv2.f(zm1.f())) {
            return (getUserInfo() == null || pv2.f(getUserInfo().getDevid())) ? Constants.STR_EMPTY : getUserInfo().getDevid();
        }
        return zm1.f();
    }

    public static u92 getMeasureBloodModelQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getMeasureBloodModelDao().queryBuilder();
        u92VarQueryBuilder.r(MeasureBloodModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(MeasureBloodModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static List<MeasureBloodModel> getMeasureBloodOfOneDay(Date date) {
        u92 measureBloodModelQueryBuilder = getMeasureBloodModelQueryBuilder();
        Date dateP = bn1.p(date);
        Date dateG = bn1.g(date);
        h82 h82Var = MeasureBloodModelDao.Properties.Date;
        measureBloodModelQueryBuilder.r(h82Var.a(dateP, dateG), new gi3[0]);
        measureBloodModelQueryBuilder.m(h82Var);
        return measureBloodModelQueryBuilder.l();
    }

    public static List<MeasureBloodModel> getMeasureBloodOfOneDayLimit(Date date, int i) {
        u92 measureBloodModelQueryBuilder = getMeasureBloodModelQueryBuilder();
        Date dateP = bn1.p(date);
        Date dateG = bn1.g(date);
        h82 h82Var = MeasureBloodModelDao.Properties.Date;
        measureBloodModelQueryBuilder.r(h82Var.a(dateP, dateG), new gi3[0]);
        measureBloodModelQueryBuilder.m(h82Var);
        return measureBloodModelQueryBuilder.k(i).l();
    }

    public static List<MeasureDetailsModel> getMeasureDetailsByDateAsc(int i) {
        return getMeasureDetailsQueryBuilder().m(MeasureDetailsModelDao.Properties.Date).k(i).l();
    }

    public static List<MeasureDetailsModel> getMeasureDetailsByDateDes(int i) {
        return getMeasureDetailsQueryBuilder().o(MeasureDetailsModelDao.Properties.Date).k(i).l();
    }

    public static u92 getMeasureDetailsQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getMeasureDetailsModelDao().queryBuilder();
        u92VarQueryBuilder.r(MeasureDetailsModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(MeasureDetailsModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static MeasureHeartModel[] getMeasureHeartMaxAndMinByDate(Date date) {
        u92 measureHeartModelQueryBuilder = getMeasureHeartModelQueryBuilder();
        measureHeartModelQueryBuilder.r(MeasureHeartModelDao.Properties.Date.a(bn1.p(date), bn1.g(date)), new gi3[0]);
        measureHeartModelQueryBuilder.o(MeasureHeartModelDao.Properties.Heart);
        List listL = measureHeartModelQueryBuilder.l();
        MeasureHeartModel measureHeartModel = new MeasureHeartModel();
        MeasureHeartModel measureHeartModel2 = new MeasureHeartModel();
        int iC = fz.c(listL);
        if (iC > 0) {
            measureHeartModel = (MeasureHeartModel) listL.get(0);
            measureHeartModel2 = (MeasureHeartModel) listL.get(iC - 1);
        }
        return new MeasureHeartModel[]{measureHeartModel, measureHeartModel2};
    }

    public static u92 getMeasureHeartModelQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getMeasureHeartModelDao().queryBuilder();
        u92VarQueryBuilder.r(MeasureHeartModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(MeasureHeartModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static List<MeasureHeartModel> getMeasureHeartOfDurationOrderByAscDate(Date date, Date date2) {
        u92 measureHeartModelQueryBuilder = getMeasureHeartModelQueryBuilder();
        h82 h82Var = MeasureHeartModelDao.Properties.Date;
        measureHeartModelQueryBuilder.r(h82Var.a(date, date2), new gi3[0]);
        measureHeartModelQueryBuilder.m(h82Var);
        return measureHeartModelQueryBuilder.l();
    }

    public static List<MeasureHeartModel> getMeasureHeartOfDurationOrderByDescHeart(Date date, Date date2) {
        u92 measureHeartModelQueryBuilder = getMeasureHeartModelQueryBuilder();
        measureHeartModelQueryBuilder.r(MeasureHeartModelDao.Properties.Date.a(date, date2), new gi3[0]);
        measureHeartModelQueryBuilder.o(MeasureHeartModelDao.Properties.Heart);
        return measureHeartModelQueryBuilder.l();
    }

    public static List<MeasureHeartModel> getMeasureHeartOfOneDayByAscDate(Date date) {
        return getMeasureHeartOfDurationOrderByAscDate(bn1.p(date), bn1.g(date));
    }

    public static List<MeasureHeartModel> getMeasureHeartOfOneDayByDescHeart(Date date) {
        return getMeasureHeartOfDurationOrderByDescHeart(bn1.p(date), bn1.g(date));
    }

    public static List<MeasureBloodModel> getMeasureOfBlood(int i) {
        return getMeasureBloodModelQueryBuilder().k(i).l();
    }

    public static List<MeasureHeartModel> getMeasureOfHeart() {
        return getMeasureHeartModelQueryBuilder().l();
    }

    public static List<MeasureSpoModel> getMeasureOfSpo() {
        return getMeasureSpoModelQueryBuilder().l();
    }

    public static List<MeasureHeartModel> getMeasureQuietHeartOfDurationOrderByDescHeart(Date date, Date date2) {
        u92 measureHeartModelQueryBuilder = getMeasureHeartModelQueryBuilder();
        h82 h82Var = MeasureHeartModelDao.Properties.Date;
        measureHeartModelQueryBuilder.r(h82Var.a(date, date2), new gi3[0]);
        measureHeartModelQueryBuilder.r(MeasureHeartModelDao.Properties.Status.b(1), new gi3[0]);
        measureHeartModelQueryBuilder.o(h82Var);
        return measureHeartModelQueryBuilder.l();
    }

    public static List<MeasureSpoModel> getMeasureSpoBetweenDateByOrderAsc(Date date, Date date2) {
        u92 measureSpoModelQueryBuilder = getMeasureSpoModelQueryBuilder();
        h82 h82Var = MeasureSpoModelDao.Properties.Date;
        measureSpoModelQueryBuilder.r(h82Var.a(date, date2), new gi3[0]);
        return measureSpoModelQueryBuilder.m(h82Var).l();
    }

    public static MeasureSpoModel[] getMeasureSpoMaxAndMinByDate(Date date) {
        u92 measureSpoModelQueryBuilder = getMeasureSpoModelQueryBuilder();
        measureSpoModelQueryBuilder.r(MeasureSpoModelDao.Properties.Date.a(bn1.p(date), bn1.g(date)), new gi3[0]);
        measureSpoModelQueryBuilder.o(MeasureSpoModelDao.Properties.Spo);
        List listL = measureSpoModelQueryBuilder.l();
        int iC = fz.c(listL);
        MeasureSpoModel measureSpoModel = new MeasureSpoModel();
        MeasureSpoModel measureSpoModel2 = new MeasureSpoModel();
        if (iC > 0) {
            measureSpoModel = (MeasureSpoModel) listL.get(0);
            measureSpoModel2 = (MeasureSpoModel) listL.get(iC - 1);
        }
        return new MeasureSpoModel[]{measureSpoModel, measureSpoModel2};
    }

    public static u92 getMeasureSpoModelQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getMeasureSpoModelDao().queryBuilder();
        u92VarQueryBuilder.r(MeasureSpoModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(MeasureSpoModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static List<MeasureSpoModel> getMeasureSpoOfOneDay(Date date) {
        return getMeasureSpoBetweenDateByOrderAsc(bn1.p(date), bn1.g(date));
    }

    public static List<MeasureDetailsModel> getNoDeviceIdMeasureDetails() {
        return getDaoSession().getMeasureDetailsModelDao().queryBuilder().r(MeasureDetailsModelDao.Properties.Devid.b(Constants.STR_EMPTY), new gi3[0]).o(MeasureDetailsModelDao.Properties.Date).l();
    }

    public static List<SportDetailsModel> getNoDeviceIdSportDetails() {
        return getDaoSession().getSportDetailsModelDao().queryBuilder().r(SportDetailsModelDao.Properties.Devid.b(Constants.STR_EMPTY), new gi3[0]).o(SportDetailsModelDao.Properties.Date).l();
    }

    public static List<MeasureDetailsModel> getNoUploadMeasureDetails() {
        return getMeasureDetailsQueryBuilder().r(MeasureDetailsModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]).l();
    }

    public static List<SleepDetailsModel> getNoUploadSleepDetails() {
        return getSleepDetailsQueryBuilder().r(SleepDetailsModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]).l();
    }

    public static List<SportStandModel> getNoUploadSportStandModelModels() {
        u92 sportStandModelQueryBuilder = getSportStandModelQueryBuilder();
        sportStandModelQueryBuilder.r(SportStandModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]);
        return sportStandModelQueryBuilder.k(100).l();
    }

    public static List<SportDetailsModel> getNoUploadSportsDetails() {
        return getSportsDetailsQueryBuilderOrderDesc().r(SportDetailsModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]).l();
    }

    public static List<WatchSportsDataModel> getNoUploadWatchSportsData(int i) {
        return getDaoSession().getWatchSportsDataModelDao().queryBuilder().r(WatchSportsDataModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]).k(i).l();
    }

    public static PathRecord getPathRecordById(long j) {
        u92 u92VarQueryBuilder = getPathRecordDao().queryBuilder();
        u92VarQueryBuilder.r(PathRecordDao.Properties.Id.b(Long.valueOf(j)), new gi3[0]);
        return (PathRecord) u92VarQueryBuilder.q();
    }

    private static PathRecordDao getPathRecordDao() {
        return getDaoSession().getPathRecordDao();
    }

    public static PaymentCodeResponse getPaymentCodeResponse() {
        u92 u92VarQueryBuilder = getDaoSession().getPaymentCodeResponseDao().queryBuilder();
        u92VarQueryBuilder.r(PaymentCodeResponseDao.Properties.DeviceId.b(zm1.e()), new gi3[0]);
        return (PaymentCodeResponse) u92VarQueryBuilder.q();
    }

    public static Gps getPhonePosition() {
        return (Gps) getGpsDao().queryBuilder().q();
    }

    public static synchronized ProductInfoModel getProductInfo() {
        u92 u92VarQueryBuilder;
        u92VarQueryBuilder = getDaoSession().getProductInfoModelDao().queryBuilder();
        u92VarQueryBuilder.r(ProductInfoModelDao.Properties.DeviceId.b(zm1.f()), new gi3[0]);
        return (ProductInfoModel) u92VarQueryBuilder.q();
    }

    public static SessionBean getSession() {
        return (SessionBean) getSessionDao().queryBuilder().q();
    }

    public static SessionBeanDao getSessionDao() {
        return getDaoSession().getSessionBeanDao();
    }

    public static List<SleepDetailsModel> getSleepDetailsDatasByDateAsc(Date date, Date date2) {
        u92 sleepDetailsQueryBuilder = getSleepDetailsQueryBuilder();
        h82 h82Var = SleepDetailsModelDao.Properties.Date;
        return sleepDetailsQueryBuilder.r(h82Var.a(date, date2), new gi3[0]).m(h82Var).l();
    }

    public static List<SleepDetailsModel> getSleepDetailsDatasOfOneDay(Date date) {
        Date dateP = bn1.p(bn1.j(date, -1));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateP);
        calendar.set(11, 22);
        calendar.set(12, 0);
        Date dateP2 = bn1.p(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dateP2);
        calendar2.set(11, 8);
        calendar2.set(12, 0);
        return getSleepDetailsDatasByDateAsc(calendar.getTime(), calendar2.getTime());
    }

    public static List<SleepDetailsModel> getSleepDetailsDatasOfOneDay2(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 22);
        calendar.set(12, 0);
        Date dateJ = bn1.j(date, 1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dateJ);
        calendar2.set(11, 8);
        calendar2.set(12, 0);
        return getSleepDetailsDatasByDateAsc(calendar.getTime(), calendar2.getTime());
    }

    public static u92 getSleepDetailsQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getSleepDetailsModelDao().queryBuilder();
        u92VarQueryBuilder.r(SleepDetailsModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(SleepDetailsModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static SleepWarnModel getSleepWarnModel() {
        SleepWarnModel sleepWarnModel = new SleepWarnModel(zm1.f(), false, (byte) 127, (short) 1320);
        SleepWarnModel sleepWarnModel2 = (SleepWarnModel) getSleepWarnQueryBuilder().q();
        return sleepWarnModel2 == null ? sleepWarnModel : sleepWarnModel2;
    }

    public static u92 getSleepWarnQueryBuilder() {
        return getDaoSession().getSleepWarnModelDao().queryBuilder().r(SleepWarnModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
    }

    public static SportDetialsGroup getSportDetailsGroupByDateStr(Date date) {
        return getSportDetailsGroupByDateStr(e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH)));
    }

    public static SportDetialsGroup getSportDetailsGroupByDateStrNotUpload(Date date) {
        return getSportDetailsGroupByDateStrNotUpload(e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH)));
    }

    public static List<PathRecord> getSportRecordForMonth(int i, Date date) {
        Date dateH = bn1.h(date);
        Date dateK = bn1.k(date);
        u92 u92VarQueryBuilder = getPathRecordDao().queryBuilder();
        u92VarQueryBuilder.r(PathRecordDao.Properties.Mode.b(Integer.valueOf(i)), new gi3[0]);
        h82 h82Var = PathRecordDao.Properties.Date;
        u92VarQueryBuilder.r(h82Var.a(dateH, dateK), new gi3[0]);
        u92VarQueryBuilder.o(h82Var);
        return u92VarQueryBuilder.l();
    }

    public static List<PathRecord> getSportRecordForOneDay(int i, Date date) {
        Date dateP = bn1.p(date);
        Date dateG = bn1.g(date);
        u92 u92VarQueryBuilder = getPathRecordDao().queryBuilder();
        u92VarQueryBuilder.r(PathRecordDao.Properties.Mode.b(Integer.valueOf(i)), new gi3[0]);
        h82 h82Var = PathRecordDao.Properties.Date;
        u92VarQueryBuilder.r(h82Var.a(dateP, dateG), new gi3[0]);
        u92VarQueryBuilder.o(h82Var);
        return u92VarQueryBuilder.l();
    }

    public static List<PathRecord> getSportRecordForWeek(Date date, int i) {
        Date dateD = bn1.d(date);
        u92 u92VarQueryBuilder = getPathRecordDao().queryBuilder();
        u92VarQueryBuilder.r(PathRecordDao.Properties.Mode.b(Integer.valueOf(i)), new gi3[0]);
        h82 h82Var = PathRecordDao.Properties.Date;
        u92VarQueryBuilder.r(h82Var.a(date, dateD), new gi3[0]);
        u92VarQueryBuilder.o(h82Var);
        return u92VarQueryBuilder.l();
    }

    public static List<PathRecord> getSportRecordForYear(int i, Date date) {
        Date dateS = bn1.s(date);
        Date dateT = bn1.t(date);
        u92 u92VarQueryBuilder = getPathRecordDao().queryBuilder();
        u92VarQueryBuilder.r(PathRecordDao.Properties.Mode.b(Integer.valueOf(i)), new gi3[0]);
        h82 h82Var = PathRecordDao.Properties.Date;
        u92VarQueryBuilder.r(h82Var.a(dateS, dateT), new gi3[0]);
        u92VarQueryBuilder.o(h82Var);
        return u92VarQueryBuilder.l();
    }

    public static SportStandModel getSportStandByDate(Date date) {
        u92 sportStandModelQueryBuilder = getSportStandModelQueryBuilder();
        sportStandModelQueryBuilder.r(SportStandModelDao.Properties.Date.a(bn1.o(date), bn1.f(date)), new gi3[0]);
        List listL = sportStandModelQueryBuilder.l();
        if (fz.a(listL)) {
            return null;
        }
        return (SportStandModel) listL.get(0);
    }

    public static SportStandGroupModel getSportStandGroupByDateStr(String str) {
        u92 sportStandGroupModelQueryBuilder = getSportStandGroupModelQueryBuilder();
        sportStandGroupModelQueryBuilder.r(SportStandGroupModelDao.Properties.DateStrIndex.b(str), new gi3[0]);
        return (SportStandGroupModel) sportStandGroupModelQueryBuilder.q();
    }

    public static u92 getSportStandGroupModelQueryBuilder() {
        return getDaoSession().getSportStandGroupModelDao().queryBuilder().r(SportStandGroupModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
    }

    public static List<SportStandModel> getSportStandModelModels() {
        return getSportStandModelQueryBuilder().l();
    }

    public static u92 getSportStandModelQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getSportStandModelDao().queryBuilder();
        u92VarQueryBuilder.r(SportStandModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(SportStandModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static List<SportStandModel> getSportStandOfOneDay(Date date) {
        return getSportStandOfOneDay(date, true);
    }

    public static List<SportDetailsModel> getSportsDetailsByDateDurationByOrderAsc(Date date, Date date2) {
        u92 sportsDetailsQueryBuilderByOrderAsc = getSportsDetailsQueryBuilderByOrderAsc();
        sportsDetailsQueryBuilderByOrderAsc.r(SportDetailsModelDao.Properties.Date.a(date, date2), new gi3[0]);
        List<SportDetailsModel> listL = sportsDetailsQueryBuilderByOrderAsc.l();
        return listL == null ? new ArrayList() : listL;
    }

    public static List<SportDetailsModel> getSportsDetailsByDateDurationByOrderDesc(Date date, Date date2) {
        return getSportsDetailsQueryBuilderOrderDesc().r(SportDetailsModelDao.Properties.Date.a(date, date2), new gi3[0]).l();
    }

    public static List<SportDetailsModel> getSportsDetailsByOneDayByOrderAsc(Date date) {
        return getSportsDetailsByDateDurationByOrderAsc(bn1.p(date), bn1.g(date));
    }

    public static List<SportDetailsModel> getSportsDetailsByOneDayByOrderDesc(Date date) {
        return getSportsDetailsByDateDurationByOrderDesc(bn1.p(date), bn1.g(date));
    }

    public static u92 getSportsDetailsGroupQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getSportDetialsGroupDao().queryBuilder();
        u92VarQueryBuilder.r(SportDetialsGroupDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static u92 getSportsDetailsQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getSportDetailsModelDao().queryBuilder();
        u92VarQueryBuilder.r(SportDetailsModelDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(SportDetailsModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder;
    }

    public static u92 getSportsDetailsQueryBuilderByOrderAsc() {
        u92 sportsDetailsQueryBuilder = getSportsDetailsQueryBuilder();
        sportsDetailsQueryBuilder.m(SportDetailsModelDao.Properties.Date);
        return sportsDetailsQueryBuilder;
    }

    public static u92 getSportsDetailsQueryBuilderOrderDesc() {
        u92 sportsDetailsQueryBuilder = getSportsDetailsQueryBuilder();
        sportsDetailsQueryBuilder.o(SportDetailsModelDao.Properties.Date);
        return sportsDetailsQueryBuilder;
    }

    private static u92 getTempQueryBuilder() {
        return getDaoSession().getTempModelDao().queryBuilder();
    }

    public static ECGRecordModel getTodayRecentData() {
        u92 u92VarR = getDaoSession().getECGRecordModelDao().queryBuilder().r(ECGRecordModelDao.Properties.DeviceId.b(zm1.f()), new gi3[0]);
        Date dateP = bn1.p(e33.e());
        Date dateG = bn1.g(e33.e());
        h82 h82Var = ECGRecordModelDao.Properties.Date;
        u92VarR.r(h82Var.a(dateP, dateG), new gi3[0]);
        u92VarR.o(h82Var);
        List listL = u92VarR.l();
        if (fz.a(listL)) {
            return null;
        }
        return (ECGRecordModel) listL.get(0);
    }

    public static WeatherResponse getTodayWeather() {
        WeatherResponse weather = getWeather();
        if (weather == null || weather.getDate() == null || !e33.n(weather.getDate())) {
            return null;
        }
        return weather;
    }

    public static WeatherForecastResponse getTodayWeatherForecast() {
        WeatherForecastResponse weatherForecast = getWeatherForecast();
        if (weatherForecast == null || weatherForecast.getDate() == null || !e33.n(weatherForecast.getDate())) {
            return null;
        }
        return weatherForecast;
    }

    private static TrackModelDao getTrackModelDao() {
        return getDaoSession().getTrackModelDao();
    }

    public static List<TrackModel> getTracksByRecodId(long j) {
        u92 u92VarQueryBuilder = getTrackModelDao().queryBuilder();
        u92VarQueryBuilder.r(TrackModelDao.Properties.KeyId.b(Long.valueOf(j)), new gi3[0]);
        u92VarQueryBuilder.m(TrackModelDao.Properties.Date);
        return u92VarQueryBuilder.l();
    }

    public static UserBean getUser() {
        return (UserBean) getUserDao().queryBuilder().q();
    }

    public static List<UserHabbitCustomModel> getUserCustomHabbitsByType(int i) {
        return getUserHabbitCustomModelDao().queryBuilder().r(UserHabbitCustomModelDao.Properties.HabbitType.b(Integer.valueOf(i)), new gi3[0]).l();
    }

    public static UserBeanDao getUserDao() {
        return getDaoSession().getUserBeanDao();
    }

    public static UserHabbitConfigModelDao getUserHabbitConfigModelDao() {
        return getDaoSession().getUserHabbitConfigModelDao();
    }

    public static UserHabbitCustomModelDao getUserHabbitCustomModelDao() {
        return getDaoSession().getUserHabbitCustomModelDao();
    }

    public static UserHabbitModelDao getUserHabbitModelDao() {
        return getDaoSession().getUserHabbitModelDao();
    }

    public static long getUserId() {
        if (getUser() == null) {
            return -1L;
        }
        return getUser().getId();
    }

    public static QueryDataReponse getUserInfo() {
        return (QueryDataReponse) getUserInfoDao().queryBuilder().q();
    }

    public static QueryDataReponseDao getUserInfoDao() {
        return getDaoSession().getQueryDataReponseDao();
    }

    public static String getUserToken() {
        SessionBean session = getSession();
        if (session == null || pv2.f(session.getToken())) {
            return "Bearer 6fcb7f58475b4e5aad8f0f1cadce235e";
        }
        return "Bearer " + session.getToken();
    }

    public static WatchSportsDataGroupModelOfDay getWatchSPortsDataGroupOfDayByKey(Date date) {
        return getWatchSPortsDataGroupOfDayByKey(e33.c(date, new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH)));
    }

    public static WatchSportsDataGroupModelOfMonth getWatchSPortsDataGroupOfMonthByKey(String str) {
        u92 watchSportsDataGroupModelOfMonthQueryBuilder = getWatchSportsDataGroupModelOfMonthQueryBuilder();
        watchSportsDataGroupModelOfMonthQueryBuilder.r(WatchSportsDataGroupModelOfMonthDao.Properties.YyyyMM.b(str), new gi3[0]);
        List listL = watchSportsDataGroupModelOfMonthQueryBuilder.l();
        if (fz.a(listL)) {
            return null;
        }
        return (WatchSportsDataGroupModelOfMonth) listL.get(0);
    }

    public static List<WatchSportsDataGroupModelOfMonth> getWatchSPortsDataGroups() {
        return getWatchSportsDataGroupModelOfMonthQueryBuilder().l();
    }

    public static List<WatchSportsDataModel> getWatchSportsDataByKey(String str) {
        u92 watchSportsDataModelQueryBuilder = getWatchSportsDataModelQueryBuilder();
        watchSportsDataModelQueryBuilder.r(WatchSportsDataModelDao.Properties.YyyyMM.b(str), new gi3[0]);
        watchSportsDataModelQueryBuilder.o(WatchSportsDataModelDao.Properties.Date);
        return watchSportsDataModelQueryBuilder.l();
    }

    public static u92 getWatchSportsDataGroupModelOfDayQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getWatchSportsDataGroupModelOfDayDao().queryBuilder();
        u92VarQueryBuilder.r(WatchSportsDataGroupModelOfDayDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(WatchSportsDataGroupModelOfDayDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder.o(WatchSportsDataGroupModelOfDayDao.Properties.YyyyMMdd);
    }

    public static u92 getWatchSportsDataGroupModelOfMonthQueryBuilder() {
        u92 u92VarQueryBuilder = getDaoSession().getWatchSportsDataGroupModelOfMonthDao().queryBuilder();
        u92VarQueryBuilder.r(WatchSportsDataGroupModelOfMonthDao.Properties.Devid.b(zm1.f()), new gi3[0]);
        u92VarQueryBuilder.r(WatchSportsDataGroupModelOfMonthDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
        return u92VarQueryBuilder.o(WatchSportsDataGroupModelOfMonthDao.Properties.YyyyMM);
    }

    public static List<WatchSportsDataModel> getWatchSportsDataModelByDate(WatchSportsDataModel watchSportsDataModel) {
        u92 watchSportsDataModelQueryBuilder = getWatchSportsDataModelQueryBuilder();
        h82 h82Var = WatchSportsDataModelDao.Properties.Date;
        watchSportsDataModelQueryBuilder.r(h82Var.b(watchSportsDataModel.getDate()), new gi3[0]);
        watchSportsDataModelQueryBuilder.r(WatchSportsDataModelDao.Properties.SportMode.b(Integer.valueOf(watchSportsDataModel.getSportMode())), new gi3[0]);
        watchSportsDataModelQueryBuilder.o(h82Var);
        return watchSportsDataModelQueryBuilder.l();
    }

    public static List<WatchSportsDataModel> getWatchSportsDataModelOfBettween(Date date, Date date2) {
        u92 watchSportsDataModelQueryBuilder = getWatchSportsDataModelQueryBuilder();
        h82 h82Var = WatchSportsDataModelDao.Properties.Date;
        watchSportsDataModelQueryBuilder.r(h82Var.a(date, date2), new gi3[0]);
        watchSportsDataModelQueryBuilder.o(h82Var);
        return watchSportsDataModelQueryBuilder.l();
    }

    public static List<WatchSportsDataModel> getWatchSportsDataModelOfOneDay(int i, Date date) {
        u92 watchSportsDataModelQueryBuilder = getWatchSportsDataModelQueryBuilder();
        Date dateP = bn1.p(date);
        Date dateG = bn1.g(date);
        watchSportsDataModelQueryBuilder.r(WatchSportsDataModelDao.Properties.SportMode.b(Integer.valueOf(i)), new gi3[0]);
        h82 h82Var = WatchSportsDataModelDao.Properties.Date;
        watchSportsDataModelQueryBuilder.r(h82Var.a(dateP, dateG), new gi3[0]);
        watchSportsDataModelQueryBuilder.o(h82Var);
        return watchSportsDataModelQueryBuilder.l();
    }

    public static u92 getWatchSportsDataModelQueryBuilder() {
        return getDaoSession().getWatchSportsDataModelDao().queryBuilder().r(WatchSportsDataModelDao.Properties.Devid.b(zm1.f()), new gi3[0]).r(WatchSportsDataModelDao.Properties.UserId.c(Long.valueOf(getUserId()), -1), new gi3[0]);
    }

    public static List<WatchSportsDataModel> getWatchSportsDataModels() {
        return getWatchSportsDataModelQueryBuilder().l();
    }

    public static WeatherResponse getWeather() {
        return (WeatherResponse) getWeatherDao().queryBuilder().q();
    }

    private static WeatherResponseDao getWeatherDao() {
        return getDaoSession().getWeatherResponseDao();
    }

    public static WeatherForecastResponse getWeatherForecast() {
        return (WeatherForecastResponse) getWeatherForecastDao().queryBuilder().q();
    }

    private static WeatherForecastResponseDao getWeatherForecastDao() {
        return getDaoSession().getWeatherForecastResponseDao();
    }

    public static HashMap<String, Integer> getWeekMeasureDetailsMaxValue() {
        List listL = getMeasureDetailsQueryBuilder().k(7).m(MeasureDetailsModelDao.Properties.Heart).l();
        HashMap<String, Integer> map = new HashMap<>();
        if (listL == null || listL.size() <= 0) {
            map.put("min", 0);
            map.put("max", 0);
        } else {
            map.put("min", Integer.valueOf(((MeasureDetailsModel) listL.get(0)).getHeart()));
            map.put("max", Integer.valueOf(((MeasureDetailsModel) listL.get(listL.size() - 1)).getHeart()));
        }
        return map;
    }

    public static WeightMannagerModel getWeightTask() {
        if (fz.a(getDaoSession().getWeightMannagerModelDao().queryBuilder().l())) {
            insertWeightTask(getDefaultWeightTask());
        }
        return (WeightMannagerModel) getDaoSession().getWeightMannagerModelDao().queryBuilder().l().get(0);
    }

    public static void insertDeviceHardInfo(DeviceHardInfoModel deviceHardInfoModel) {
        getDaoSession().getDeviceHardInfoModelDao().insertOrReplace(deviceHardInfoModel);
    }

    public static void insertDrinkOfDay(DrinkModelOfDay drinkModelOfDay) {
        getDaoSession().insertOrReplace(drinkModelOfDay);
    }

    public static void insertLastWeight(WeightModel weightModel) {
        WeightModel laststWeightModel = getLaststWeightModel();
        if (laststWeightModel == null || !e33.n(laststWeightModel.getDate())) {
            insertWeight(getWeightTask().getId(), weightModel);
        } else {
            laststWeightModel.setWeight(weightModel.getWeight());
            updateLastWeight(laststWeightModel);
        }
    }

    public static void insertSportDetialsGroup(SportDetialsGroup sportDetialsGroup) {
        getDaoSession().getSportDetialsGroupDao().insert(sportDetialsGroup);
    }

    public static void insertSportStandGroupModel(SportStandGroupModel sportStandGroupModel) {
        getDaoSession().getSportStandGroupModelDao().insert(sportStandGroupModel);
    }

    private static void insertWeight(Long l, WeightModel weightModel) {
        weightModel.setKey(l.longValue());
        getDaoSession().getWeightModelDao().insert(weightModel);
    }

    private static void insertWeightTask(WeightMannagerModel weightMannagerModel) {
        getDaoSession().getWeightMannagerModelDao().insert(weightMannagerModel);
    }

    private static boolean isExistTheSameDateSportData(SportDetailsModel sportDetailsModel) {
        u92 sportsDetailsQueryBuilderOrderDesc = getSportsDetailsQueryBuilderOrderDesc();
        sportsDetailsQueryBuilderOrderDesc.r(SportDetailsModelDao.Properties.Date.b(sportDetailsModel.getDate()), new gi3[0]);
        sportsDetailsQueryBuilderOrderDesc.r(SportDetailsModelDao.Properties.IsLastHistory.b(Boolean.FALSE), new gi3[0]);
        sportsDetailsQueryBuilderOrderDesc.r(SportDetailsModelDao.Properties.TargetSteps.b(Integer.valueOf(sportDetailsModel.getTargetSteps())), new gi3[0]);
        return !fz.a(sportsDetailsQueryBuilderOrderDesc.l());
    }

    private static boolean isExistTheSameMeasureData(MeasureDetailsModel measureDetailsModel) {
        List listL = getMeasureDetailsQueryBuilder().r(MeasureDetailsModelDao.Properties.Date.b(measureDetailsModel.getDate()), new gi3[0]).l();
        return listL != null && listL.size() > 0;
    }

    private static boolean isExistTheSameSleepData(SleepDetailsModel sleepDetailsModel) {
        u92 sleepDetailsQueryBuilder = getSleepDetailsQueryBuilder();
        sleepDetailsQueryBuilder.r(SleepDetailsModelDao.Properties.Date.b(sleepDetailsModel.getDate()), new gi3[0]);
        sleepDetailsQueryBuilder.r(SleepDetailsModelDao.Properties.SleepType.b(Integer.valueOf(sleepDetailsModel.getSleepType())), new gi3[0]);
        List listL = sleepDetailsQueryBuilder.l();
        return listL != null && listL.size() > 0;
    }

    public static boolean isLogin() {
        return (getUser() == null || getSession() == null || getUserInfo() == null) ? false : true;
    }

    public static List<DrinkModel> queryDrinkPreset() {
        return getDaoSession().getDrinkModelDao().queryBuilder().r(DrinkModelDao.Properties.IsPresets.b(Boolean.TRUE), new gi3[0]).l();
    }

    public static List<ECGRecordModel> queryECGDatas() {
        u92 u92VarR = getDaoSession().getECGRecordModelDao().queryBuilder().r(ECGRecordModelDao.Properties.DeviceId.b(zm1.f()), new gi3[0]);
        u92VarR.o(ECGRecordModelDao.Properties.Date);
        return u92VarR.l();
    }

    public static void removeAllDrinkPreset() {
        getDaoSession().getDrinkModelDao().queryBuilder().r(DrinkModelDao.Properties.IsPresets.b(Boolean.TRUE), new gi3[0]).d().e();
    }

    public static void saveBatteryCalculateParams(BatteryCalculateParamsBean batteryCalculateParamsBean) {
        getDaoSession().getBatteryCalculateParamsBeanDao().insertOrReplace(batteryCalculateParamsBean);
    }

    public static void saveClockDialInfo(ClockDialInfoBody clockDialInfoBody) {
        getDaoSession().getClockDialInfoBodyDao().insertOrReplace(clockDialInfoBody);
    }

    public static void saveContract(ContractModel contractModel) {
        getDaoSession().getContractModelDao().insertOrReplace(contractModel);
    }

    public static synchronized void saveDetailsSport(SportDetailsModel sportDetailsModel) {
        try {
            SportDetailsModelDao sportDetailsModelDao = getDaoSession().getSportDetailsModelDao();
            sportDetailsModel.setTargetSteps(zm1.v(sportDetailsModel.getDate()));
            if (sportDetailsModel.getIsLastHistory()) {
                u92 sportsDetailsQueryBuilder = getSportsDetailsQueryBuilder();
                sportsDetailsQueryBuilder.r(SportDetailsModelDao.Properties.DateStr.b(sportDetailsModel.getDateStr()), new gi3[0]);
                sportsDetailsQueryBuilder.r(SportDetailsModelDao.Properties.IsLastHistory.b(Boolean.TRUE), new gi3[0]);
                List listL = sportsDetailsQueryBuilder.l();
                if (!fz.a(listL)) {
                    sportDetailsModel.setId(((SportDetailsModel) listL.get(0)).getId());
                }
                saveSportDetailsData(sportDetailsModel, sportDetailsModelDao);
            } else if (isExistTheSameDateSportData(sportDetailsModel)) {
                Log.i(TAG, "存在相同日期的运动数据，不保存");
            } else {
                saveSportDetailsData(sportDetailsModel, sportDetailsModelDao);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static long saveDrink(DrinkModel drinkModel) {
        if (drinkModel.getIsPresets()) {
            return getDaoSession().getDrinkModelDao().insertOrReplace(drinkModel);
        }
        DrinkModelOfDay drinkofDayByDateStr = getDrinkofDayByDateStr(drinkModel.getKey());
        if (drinkofDayByDateStr == null) {
            drinkofDayByDateStr = new DrinkModelOfDay(drinkModel.getKey(), drinkModel.getMl(), 1000);
        } else {
            drinkofDayByDateStr.setTotalML(drinkofDayByDateStr.getTotalML() + drinkModel.getMl());
        }
        long jInsertOrReplace = getDaoSession().getDrinkModelDao().insertOrReplace(drinkModel);
        insertDrinkOfDay(drinkofDayByDateStr);
        return jInsertOrReplace;
    }

    public static void saveDrinkConfig(DrinkConfigModel drinkConfigModel) {
        getDaoSession().getDrinkConfigModelDao().insertOrReplace(drinkConfigModel);
    }

    public static long saveDrinkGlobal(DrinkGlobal drinkGlobal) {
        return getDaoSession().getDrinkGlobalDao().insertOrReplace(drinkGlobal);
    }

    public static long saveDrinkPreset(DrinkModel drinkModel) {
        drinkModel.setIsPresets(true);
        return saveDrink(drinkModel);
    }

    public static void saveECGData(ECGRecordModel eCGRecordModel) {
        getDaoSession().getECGRecordModelDao().insertOrReplace(eCGRecordModel);
    }

    public static void saveGestureControlConfig(GestureControlConfigModel gestureControlConfigModel) {
        getDaoSession().getGestureControlConfigModelDao().insertOrReplace(gestureControlConfigModel);
    }

    public static void saveHabbitConfigs(List<UserHabbitConfigModel> list) {
        getUserHabbitConfigModelDao().deleteAll();
        getUserHabbitCustomModelDao().deleteAll();
        for (UserHabbitConfigModel userHabbitConfigModel : list) {
            getUserHabbitConfigModelDao().insertOrReplace(userHabbitConfigModel);
            saveUserHabbitConfigDetail(userHabbitConfigModel.getHabbits(), userHabbitConfigModel.getId());
        }
    }

    public static void saveHealthHabbit(UserHabbitModel userHabbitModel) {
        getUserHabbitModelDao().insertOrReplace(userHabbitModel);
    }

    public static void saveHealthHabbitList(List<UserHabbitModel> list) {
        getUserHabbitModelDao().deleteAll();
        Iterator<UserHabbitModel> it = list.iterator();
        while (it.hasNext()) {
            saveHealthHabbit(it.next());
        }
    }

    public static void saveHttpDetailsSport(List<SportDetailsModel> list) {
        if (list != null) {
            for (SportDetailsModel sportDetailsModel : list) {
                sportDetailsModel.setUserId(getUserId());
                sportDetailsModel.setIsUpload(true);
                if (pv2.h(sportDetailsModel.getDateStr())) {
                    sportDetailsModel.setDateStr(e33.c(sportDetailsModel.getDate(), new SimpleDateFormat(DateFormatUtils.YYYYMMDD, Locale.ENGLISH)));
                }
                saveDetailsSport(sportDetailsModel);
            }
        }
    }

    public static void saveHttpMeasureValue(List<MeasureDetailsModel> list) {
        if (list != null) {
            for (MeasureDetailsModel measureDetailsModel : list) {
                measureDetailsModel.setUserId(getUserId());
                measureDetailsModel.setIsUpload(true);
                saveMeasureValue(measureDetailsModel);
            }
        }
    }

    public static void saveHttpSleepDetailsDatas(List<SleepDetailsModel> list) {
        if (list != null) {
            for (SleepDetailsModel sleepDetailsModel : list) {
                sleepDetailsModel.setUserId(getUserId());
                sleepDetailsModel.setIsUpload(true);
                saveSleepDetailsDatas(sleepDetailsModel);
            }
        }
    }

    public static void saveHttpSportRecordAndTracks(PathRecord pathRecord) {
        getPathRecordDao().insertOrReplace(pathRecord);
        for (TrackModel trackModel : pathRecord.getPosList()) {
            pathRecord.setUserId(getUserId());
            trackModel.setKeyId(pathRecord.getId());
            saveTrackModel(trackModel);
        }
    }

    public static void saveIMEIStatusModel(IMEIStatusModel iMEIStatusModel) {
        getDaoSession().getIMEIStatusModelDao().insertOrReplace(iMEIStatusModel);
    }

    public static void saveMeasureBlood(MeasureBloodModel measureBloodModel) {
        getDaoSession().getMeasureBloodModelDao().insertOrReplace(measureBloodModel);
    }

    public static void saveMeasureHeart(MeasureHeartModel measureHeartModel) {
        getDaoSession().getMeasureHeartModelDao().insertOrReplace(measureHeartModel);
    }

    public static void saveMeasureSpo(MeasureSpoModel measureSpoModel) {
        getDaoSession().getMeasureSpoModelDao().insertOrReplace(measureSpoModel);
    }

    public static void saveMeasureValue(MeasureDetailsModel measureDetailsModel) {
        if (isExistTheSameMeasureData(measureDetailsModel)) {
            Log.i(TAG, "存在相同日期的测量数据，不保存");
        } else {
            getDaoSession().getMeasureDetailsModelDao().insertOrReplace(measureDetailsModel);
        }
    }

    public static void savePaymentCodeResponse(PaymentCodeResponse paymentCodeResponse) {
        getDaoSession().getPaymentCodeResponseDao().deleteAll();
        getDaoSession().getPaymentCodeResponseDao().insertOrReplace(paymentCodeResponse);
    }

    public static void savePhonePosition(Gps gps) {
        GpsDao gpsDao = getGpsDao();
        Gps phonePosition = getPhonePosition();
        if (phonePosition != null) {
            gps.setId(phonePosition.getId());
        }
        gpsDao.insertOrReplace(gps);
    }

    public static synchronized void saveProductInfo(ProductInfoModel productInfoModel) {
        getDaoSession().getProductInfoModelDao().deleteAll();
        getDaoSession().getProductInfoModelDao().insertOrReplace(productInfoModel);
    }

    private static void saveSession(SessionBean sessionBean) {
        getSessionDao().deleteAll();
        getSessionDao().insertOrReplace(sessionBean);
    }

    public static void saveSleepDetailsDatas(SleepDetailsModel sleepDetailsModel) {
        if (isExistTheSameSleepData(sleepDetailsModel)) {
            Log.i(TAG, "存在相同日期的睡眠数据，不保存");
        } else {
            getDaoSession().getSleepDetailsModelDao().insertOrReplace(sleepDetailsModel);
        }
    }

    public static void saveSleepWarn(SleepWarnModel sleepWarnModel) {
        getDaoSession().getSleepWarnModelDao().deleteAll();
        getDaoSession().getSleepWarnModelDao().insertOrReplace(sleepWarnModel);
    }

    private static void saveSportDetailsData(SportDetailsModel sportDetailsModel, SportDetailsModelDao sportDetailsModelDao) {
        sportDetailsModelDao.insertOrReplace(sportDetailsModel);
        saveSportDetailsGroup(sportDetailsModel);
    }

    private static void saveSportDetailsGroup(SportDetailsModel sportDetailsModel) {
        SportDetialsGroup sportDetailsGroupByDateStr = getSportDetailsGroupByDateStr(sportDetailsModel.getDateStr());
        if (sportDetailsGroupByDateStr == null) {
            insertSportDetialsGroup(new SportDetialsGroup(sportDetailsModel.getUserId(), sportDetailsModel.getIsUpload(), sportDetailsModel.getCalory(), sportDetailsModel.getStep(), sportDetailsModel.getDistance(), sportDetailsModel.getDevid(), sportDetailsModel.getDateStr()));
            return;
        }
        if (sportDetailsModel.getStep() >= sportDetailsGroupByDateStr.getTotalStep() || sportDetailsModel.getIsLastHistory()) {
            sportDetailsGroupByDateStr.setTotalCalory(sportDetailsModel.getCalory());
            sportDetailsGroupByDateStr.setTotalDistance(sportDetailsModel.getDistance());
            sportDetailsGroupByDateStr.setTotalStep(sportDetailsModel.getStep());
            updateSportDetailsGroup(sportDetailsGroupByDateStr);
        }
    }

    public static synchronized long saveSportRecord(PathRecord pathRecord) {
        return getPathRecordDao().insertOrReplace(pathRecord);
    }

    public static void saveSportStandModel(SportStandModel sportStandModel) {
        if (getSportStandByDate(sportStandModel.getDate()) == null) {
            getDaoSession().getSportStandModelDao().insertOrReplace(sportStandModel);
            SportStandGroupModel sportStandGroupByDateStr = getSportStandGroupByDateStr(sportStandModel.getDateStrIndex());
            if (sportStandGroupByDateStr == null) {
                insertSportStandGroupModel(new SportStandGroupModel(sportStandModel.getDevid(), sportStandModel.getDateStrIndex(), 1));
            } else {
                sportStandGroupByDateStr.setTotalCount(sportStandGroupByDateStr.getTotalCount() + 1);
                updateSportStandGroupModel(sportStandGroupByDateStr);
            }
        }
    }

    public static void saveTemp(TempModel tempModel) {
        getDaoSession().getTempModelDao().insertOrReplace(tempModel);
    }

    public static void saveTrackModel(TrackModel trackModel) {
        getTrackModelDao().insertOrReplace(trackModel);
    }

    private static void saveUser(UserBean userBean) {
        getUserDao().deleteAll();
        getUserDao().insertOrReplace(userBean);
    }

    private static void saveUserHabbitConfigDetail(List<UserHabbitCustomModel> list, long j) {
        for (UserHabbitCustomModel userHabbitCustomModel : list) {
            userHabbitCustomModel.setHabbitType(Long.valueOf(j));
            getUserHabbitCustomModelDao().insertOrReplace(userHabbitCustomModel);
        }
    }

    public static void saveUserInfo(QueryDataReponse queryDataReponse) {
        getUserInfoDao().deleteAll();
        getUserInfoDao().insertOrReplace(queryDataReponse);
    }

    public static void saveUserLoginInfo(LoginResponse loginResponse) {
        saveUser(loginResponse.getUser());
        saveSession(loginResponse.getSession());
    }

    public static boolean saveWatchSportData(WatchSportsDataModel watchSportsDataModel) {
        if (!fz.a(getWatchSportsDataModelByDate(watchSportsDataModel))) {
            hg.b(TAG, "此运动模式已经存在，不保存");
            return false;
        }
        getDaoSession().getWatchSportsDataModelDao().insertOrReplace(watchSportsDataModel);
        saveWatchSportsDataGroupModelOfMonth(watchSportsDataModel);
        saveWatchSportsDataGroupModelOfDay(watchSportsDataModel);
        return true;
    }

    public static void saveWatchSportsDataGroupModelOfDay(WatchSportsDataGroupModelOfDay watchSportsDataGroupModelOfDay) {
        WatchSportsDataGroupModelOfDay watchSPortsDataGroupOfDayByKey = getWatchSPortsDataGroupOfDayByKey(watchSportsDataGroupModelOfDay.getYyyyMMdd());
        if (watchSPortsDataGroupOfDayByKey == null) {
            getDaoSession().getWatchSportsDataGroupModelOfDayDao().insertOrReplace(watchSportsDataGroupModelOfDay);
            return;
        }
        watchSPortsDataGroupOfDayByKey.setTotalDuration(watchSportsDataGroupModelOfDay.getTotalDuration());
        watchSPortsDataGroupOfDayByKey.setTotalXiaohao(watchSportsDataGroupModelOfDay.getTotalXiaohao());
        getDaoSession().getWatchSportsDataGroupModelOfDayDao().update(watchSPortsDataGroupOfDayByKey);
    }

    private static void saveWatchSportsDataGroupModelOfMonth(WatchSportsDataGroupModelOfMonth watchSportsDataGroupModelOfMonth) {
        WatchSportsDataGroupModelOfMonth watchSPortsDataGroupOfMonthByKey = getWatchSPortsDataGroupOfMonthByKey(watchSportsDataGroupModelOfMonth.getYyyyMM());
        if (watchSPortsDataGroupOfMonthByKey == null) {
            getDaoSession().getWatchSportsDataGroupModelOfMonthDao().insertOrReplace(watchSportsDataGroupModelOfMonth);
            return;
        }
        watchSPortsDataGroupOfMonthByKey.setTotalDuration(watchSportsDataGroupModelOfMonth.getTotalDuration());
        watchSPortsDataGroupOfMonthByKey.setTotalXiaohao(watchSportsDataGroupModelOfMonth.getTotalXiaohao());
        getDaoSession().update(watchSPortsDataGroupOfMonthByKey);
    }

    public static void saveWeather(WeatherResponse weatherResponse) {
        WeatherResponse weather = getWeather();
        if (weather != null) {
            weatherResponse.setId(weather.getId());
        }
        getWeatherDao().insertOrReplace(weatherResponse);
    }

    public static void saveWeatherForecast(WeatherForecastResponse weatherForecastResponse) {
        WeatherForecastResponse weatherForecast = getWeatherForecast();
        if (weatherForecast != null) {
            weatherForecastResponse.setId(weatherForecast.getId());
        }
        getWeatherForecastDao().insertOrReplace(weatherForecastResponse);
    }

    public static void updateBodyTemp(List<TempModel> list) {
        getDaoSession().getTempModelDao().updateInTx(list);
    }

    public static void updateDetailsSport(SportDetailsModel sportDetailsModel) {
        getDaoSession().getSportDetailsModelDao().update(sportDetailsModel);
        SportDetialsGroup sportDetailsGroupByDateStrNotUpload = getSportDetailsGroupByDateStrNotUpload(sportDetailsModel.getDateStr());
        if (sportDetailsGroupByDateStrNotUpload != null) {
            sportDetailsGroupByDateStrNotUpload.setUserId(sportDetailsModel.getUserId());
            updateSportDetailsGroup(sportDetailsGroupByDateStrNotUpload);
        }
    }

    public static void updateDrink(DrinkModel drinkModel) {
        getDaoSession().getDrinkModelDao().update(drinkModel);
        updateDrinkOneDay(getDrinkofDayByDateStr(drinkModel.getKey()));
    }

    private static void updateDrinkOneDay(DrinkModelOfDay drinkModelOfDay) {
        List<DrinkModel> drinkByKey = getDrinkByKey(drinkModelOfDay.getDayStr());
        if (fz.a(drinkByKey)) {
            getDaoSession().getDrinkModelOfDayDao().delete(drinkModelOfDay);
            return;
        }
        Iterator<DrinkModel> it = drinkByKey.iterator();
        int ml = 0;
        while (it.hasNext()) {
            ml += it.next().getMl();
        }
        drinkModelOfDay.setTotalML(ml);
        getDaoSession().getDrinkModelOfDayDao().update(drinkModelOfDay);
    }

    public static void updateIMEIStatusModelByIsSync(boolean z) {
        IMEIStatusModel iMEIStatusModel = getIMEIStatusModel();
        if (iMEIStatusModel.getStatus() != -1) {
            iMEIStatusModel.setIsSync(z);
            getDaoSession().getIMEIStatusModelDao().update(iMEIStatusModel);
        }
    }

    public static void updateLastWeight(WeightModel weightModel) {
        getDaoSession().getWeightModelDao().update(weightModel);
    }

    public static void updateMeasureValue(MeasureDetailsModel measureDetailsModel) {
        getDaoSession().getMeasureDetailsModelDao().update(measureDetailsModel);
    }

    public static void updateSleepDetailsDatas(SleepDetailsModel sleepDetailsModel) {
        getDaoSession().getSleepDetailsModelDao().update(sleepDetailsModel);
    }

    public static void updateSportDetailsGroup(SportDetialsGroup sportDetialsGroup) {
        getDaoSession().getSportDetialsGroupDao().update(sportDetialsGroup);
    }

    public static void updateSportStandGroupModel(SportStandGroupModel sportStandGroupModel) {
        getDaoSession().getSportStandGroupModelDao().update(sportStandGroupModel);
    }

    public static void updateUserInfo(QueryDataReponse queryDataReponse) {
        getUserInfoDao().update(queryDataReponse);
    }

    public static void updateWatchSportData(WatchSportsDataModel watchSportsDataModel) {
        getDaoSession().getWatchSportsDataModelDao().update(watchSportsDataModel);
        WatchSportsDataGroupModelOfDay watchSPortsDataGroupOfDayByKey = getWatchSPortsDataGroupOfDayByKey(watchSportsDataModel.getDate());
        if (watchSPortsDataGroupOfDayByKey != null) {
            watchSPortsDataGroupOfDayByKey.setUserId(watchSportsDataModel.getUserId());
            saveWatchSportsDataGroupModelOfDay(watchSPortsDataGroupOfDayByKey);
        }
        WatchSportsDataGroupModelOfMonth watchSPortsDataGroupOfMonthByKey = getWatchSPortsDataGroupOfMonthByKey(watchSportsDataModel.getYyyyMM());
        if (watchSPortsDataGroupOfMonthByKey != null) {
            watchSPortsDataGroupOfMonthByKey.setUserId(watchSportsDataModel.getUserId());
            saveWatchSportsDataGroupModelOfMonth(watchSPortsDataGroupOfMonthByKey);
        }
    }

    public static void updateWeightTask(WeightMannagerModel weightMannagerModel) {
        getDaoSession().getWeightMannagerModelDao().update(weightMannagerModel);
    }

    public static BatteryCalculateParamsBean getBatteryCalculateParams(String str) {
        u92 u92VarQueryBuilder = getDaoSession().getBatteryCalculateParamsBeanDao().queryBuilder();
        u92VarQueryBuilder.r(BatteryCalculateParamsBeanDao.Properties.Mac.b(str), new gi3[0]);
        return (BatteryCalculateParamsBean) u92VarQueryBuilder.q();
    }

    public static List<UserHabbitModel> getHabbitList(int i) {
        return getUserHabbitModelDao().queryBuilder().k(i).l();
    }

    public static List<MeasureBloodModel> getMeasureOfBlood() {
        return getMeasureBloodModelQueryBuilder().l();
    }

    public static List<MeasureDetailsModel> getNoUploadMeasureDetails(int i) {
        return getMeasureDetailsQueryBuilder().r(MeasureDetailsModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]).k(i).l();
    }

    public static List<SleepDetailsModel> getNoUploadSleepDetails(int i) {
        return getSleepDetailsQueryBuilder().r(SleepDetailsModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]).k(i).l();
    }

    public static List<SportDetailsModel> getNoUploadSportsDetails(int i) {
        return getSportsDetailsQueryBuilderOrderDesc().r(SportDetailsModelDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]).k(i).l();
    }

    public static SportDetialsGroup getSportDetailsGroupByDateStr(String str) {
        u92 sportsDetailsGroupQueryBuilder = getSportsDetailsGroupQueryBuilder();
        sportsDetailsGroupQueryBuilder.r(SportDetialsGroupDao.Properties.DateStr.b(str), new gi3[0]);
        List listL = sportsDetailsGroupQueryBuilder.l();
        if (fz.a(listL)) {
            return null;
        }
        return (SportDetialsGroup) listL.get(0);
    }

    public static SportDetialsGroup getSportDetailsGroupByDateStrNotUpload(String str) {
        u92 sportsDetailsGroupQueryBuilder = getSportsDetailsGroupQueryBuilder();
        sportsDetailsGroupQueryBuilder.r(SportDetialsGroupDao.Properties.DateStr.b(str), new gi3[0]);
        sportsDetailsGroupQueryBuilder.r(SportDetialsGroupDao.Properties.IsUpload.b(Boolean.FALSE), new gi3[0]);
        return (SportDetialsGroup) sportsDetailsGroupQueryBuilder.q();
    }

    public static List<SportStandModel> getSportStandOfOneDay(Date date, boolean z) {
        Date dateP = bn1.p(date);
        Date dateG = bn1.g(date);
        u92 sportStandModelQueryBuilder = getSportStandModelQueryBuilder();
        h82 h82Var = SportStandModelDao.Properties.Date;
        sportStandModelQueryBuilder.r(h82Var.a(dateP, dateG), new gi3[0]);
        if (z) {
            sportStandModelQueryBuilder.o(h82Var);
        } else {
            sportStandModelQueryBuilder.m(h82Var);
        }
        return sportStandModelQueryBuilder.l();
    }

    public static WatchSportsDataGroupModelOfDay getWatchSPortsDataGroupOfDayByKey(String str) {
        u92 watchSportsDataGroupModelOfDayQueryBuilder = getWatchSportsDataGroupModelOfDayQueryBuilder();
        watchSportsDataGroupModelOfDayQueryBuilder.r(WatchSportsDataGroupModelOfDayDao.Properties.YyyyMMdd.b(str), new gi3[0]);
        List listL = watchSportsDataGroupModelOfDayQueryBuilder.l();
        if (fz.a(listL)) {
            return null;
        }
        return (WatchSportsDataGroupModelOfDay) listL.get(0);
    }

    public static void saveTemp(List<TempModel> list) {
        if (fz.a(list)) {
            return;
        }
        getDaoSession().getTempModelDao().insertOrReplaceInTx(list);
    }

    public static SportDetailsModel getLastSportDetailsHistory(String str) {
        u92 sportsDetailsQueryBuilder = getSportsDetailsQueryBuilder();
        sportsDetailsQueryBuilder.r(SportDetailsModelDao.Properties.DateStr.b(str), new gi3[0]);
        sportsDetailsQueryBuilder.o(SportDetailsModelDao.Properties.Step);
        List listL = sportsDetailsQueryBuilder.l();
        if (fz.a(listL)) {
            return null;
        }
        return (SportDetailsModel) listL.get(0);
    }

    public static List<DrinkModel> getDrinkListByDates(Date date, Date date2, int i) {
        u92 u92VarQueryBuilder = getDaoSession().getDrinkModelDao().queryBuilder();
        u92VarQueryBuilder.r(DrinkModelDao.Properties.Date.a(date, date2), new gi3[0]);
        u92VarQueryBuilder.r(DrinkModelDao.Properties.DrinkType.b(Integer.valueOf(i)), new gi3[0]);
        return u92VarQueryBuilder.l();
    }

    private static void saveWatchSportsDataGroupModelOfDay(WatchSportsDataModel watchSportsDataModel) {
        WatchSportsDataGroupModelOfDay watchSPortsDataGroupOfDayByKey = getWatchSPortsDataGroupOfDayByKey(watchSportsDataModel.getYyyyMMdd());
        if (watchSPortsDataGroupOfDayByKey == null) {
            watchSPortsDataGroupOfDayByKey = new WatchSportsDataGroupModelOfDay();
            watchSPortsDataGroupOfDayByKey.setDevid(zm1.f());
            watchSPortsDataGroupOfDayByKey.setYyyyMMdd(watchSportsDataModel.getYyyyMMdd());
        }
        watchSPortsDataGroupOfDayByKey.setUserId(watchSportsDataModel.getUserId());
        watchSPortsDataGroupOfDayByKey.setTotalSteps(watchSPortsDataGroupOfDayByKey.getTotalSteps() + watchSportsDataModel.getSteps());
        watchSPortsDataGroupOfDayByKey.setTotalXiaohao(watchSPortsDataGroupOfDayByKey.getTotalXiaohao() + watchSportsDataModel.getTotalKcal());
        watchSPortsDataGroupOfDayByKey.setTotalDuration(watchSPortsDataGroupOfDayByKey.getTotalDuration() + watchSportsDataModel.getDuration());
        watchSPortsDataGroupOfDayByKey.setTotalDistance(watchSPortsDataGroupOfDayByKey.getTotalDistance() + watchSportsDataModel.getTotalKm());
        saveWatchSportsDataGroupModelOfDay(watchSPortsDataGroupOfDayByKey);
    }

    private static void saveWatchSportsDataGroupModelOfMonth(WatchSportsDataModel watchSportsDataModel) {
        WatchSportsDataGroupModelOfMonth watchSPortsDataGroupOfMonthByKey = getWatchSPortsDataGroupOfMonthByKey(watchSportsDataModel.getYyyyMM());
        if (watchSPortsDataGroupOfMonthByKey == null) {
            watchSPortsDataGroupOfMonthByKey = new WatchSportsDataGroupModelOfMonth();
            watchSPortsDataGroupOfMonthByKey.setDevid(zm1.f());
            watchSPortsDataGroupOfMonthByKey.setYyyyMM(watchSportsDataModel.getYyyyMM());
        }
        watchSPortsDataGroupOfMonthByKey.setUserId(watchSportsDataModel.getUserId());
        watchSPortsDataGroupOfMonthByKey.setTotalXiaohao(watchSPortsDataGroupOfMonthByKey.getTotalXiaohao() + watchSportsDataModel.getTotalKcal());
        watchSPortsDataGroupOfMonthByKey.setTotalDuration(watchSPortsDataGroupOfMonthByKey.getTotalDuration() + watchSportsDataModel.getDuration());
        saveWatchSportsDataGroupModelOfMonth(watchSPortsDataGroupOfMonthByKey);
    }

    public static List<WatchSportsDataModel> getWatchSportsDataModelOfOneDay(Date date) {
        return getWatchSportsDataModelOfOneDay(date, true);
    }

    public static List<WatchSportsDataModel> getWatchSportsDataModelOfOneDay(Date date, boolean z) {
        u92 watchSportsDataModelQueryBuilder = getWatchSportsDataModelQueryBuilder();
        Date dateP = bn1.p(date);
        Date dateG = bn1.g(date);
        h82 h82Var = WatchSportsDataModelDao.Properties.Date;
        watchSportsDataModelQueryBuilder.r(h82Var.a(dateP, dateG), new gi3[0]);
        if (z) {
            watchSportsDataModelQueryBuilder.o(h82Var);
        } else {
            watchSportsDataModelQueryBuilder.m(h82Var);
        }
        return watchSportsDataModelQueryBuilder.l();
    }
}
