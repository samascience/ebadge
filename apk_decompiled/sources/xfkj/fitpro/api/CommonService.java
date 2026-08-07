package xfkj.fitpro.api;

import com.tencent.open.SocialConstants;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import xfkj.fitpro.model.AcomplishModel;
import xfkj.fitpro.model.HabbitRankConfigModel;
import xfkj.fitpro.model.HabbitRankModel;
import xfkj.fitpro.model.MeasureDetailsModel;
import xfkj.fitpro.model.RealStepsModel;
import xfkj.fitpro.model.SleepDetailsModel;
import xfkj.fitpro.model.TempModel;
import xfkj.fitpro.model.UserHabbitConfigModel;
import xfkj.fitpro.model.UserHabbitCustomModel;
import xfkj.fitpro.model.UserHabbitDetailsModel;
import xfkj.fitpro.model.UserHabbitModel;
import xfkj.fitpro.model.UserHabbitSignModel;
import xfkj.fitpro.model.medal.MedalList;
import xfkj.fitpro.model.motion.PathRecord;
import xfkj.fitpro.model.report.ResponseReport;
import xfkj.fitpro.model.sever.Register2Response;
import xfkj.fitpro.model.sever.reponse.ActiveOfEmail;
import xfkj.fitpro.model.sever.reponse.AdvStatus;
import xfkj.fitpro.model.sever.reponse.AdviceResponse;
import xfkj.fitpro.model.sever.reponse.AuthorizedQrcodeResponse;
import xfkj.fitpro.model.sever.reponse.AvatarTokenResponse;
import xfkj.fitpro.model.sever.reponse.BaseResponse;
import xfkj.fitpro.model.sever.reponse.FeedbackResponse;
import xfkj.fitpro.model.sever.reponse.FindUserPasswdResponse;
import xfkj.fitpro.model.sever.reponse.HisSignResponse;
import xfkj.fitpro.model.sever.reponse.IMEIStatusModel;
import xfkj.fitpro.model.sever.reponse.LoginResponse;
import xfkj.fitpro.model.sever.reponse.Medal;
import xfkj.fitpro.model.sever.reponse.PaymentCodeResponse;
import xfkj.fitpro.model.sever.reponse.ProductResponse;
import xfkj.fitpro.model.sever.reponse.QueryDataReponse;
import xfkj.fitpro.model.sever.reponse.QueryStepsRankResponse;
import xfkj.fitpro.model.sever.reponse.RegisterOfEmail;
import xfkj.fitpro.model.sever.reponse.RegisterResponse;
import xfkj.fitpro.model.sever.reponse.SignInfoResponse;
import xfkj.fitpro.model.sever.reponse.SleepRankResponse;
import xfkj.fitpro.model.sever.reponse.SleepSummaryResponse;
import xfkj.fitpro.model.sever.reponse.StepsRankResponse;
import xfkj.fitpro.model.sever.reponse.UpdatePhoneNumResponse;
import xfkj.fitpro.model.sever.reponse.UpdateUserInfoResponse;
import xfkj.fitpro.model.sever.reponse.UpgradeResponse;
import xfkj.fitpro.model.sever.reponse.UserSignResponse;
import xfkj.fitpro.model.sever.reponse.WatchThemeDetailsResponse;
import xfkj.fitpro.model.sever.reponse.WatchThemeResponse;
import xfkj.fitpro.model.sever.reponse.Weather2Response;
import xfkj.fitpro.model.sever.reponse.WeatherForecastResponse;
import xfkj.fitpro.model.sever.reponse.WeatherResponse;
import xfkj.fitpro.model.sever.reponse.YanZhengResponse;
import xfkj.fitpro.model.sportDetails.SportDetailsModel;
import xfkj.fitpro.model.sports.WatchSportsDataModel;
import xfkj.fitpro.model.stand.SportStandModel;

/* JADX INFO: loaded from: classes4.dex */
public interface CommonService {
    @FormUrlEncoded
    @POST("api/v1/register/email/active/send")
    Observable<BaseResponse<ActiveOfEmail>> activeOfEmail(@Header("Authorization") String str, @Field("email") String str2);

    @FormUrlEncoded
    @POST("/api/v1/habbit/add")
    Observable<BaseResponse<UserHabbitCustomModel>> createUserHabbit(@Header("Authorization") String str, @Field("habbitId") long j);

    @FormUrlEncoded
    @POST("/api/v1/habbit/remove")
    Observable<BaseResponse<String>> deleteUserHabbit(@Header("Authorization") String str, @Field("habbitId") long j);

    @FormUrlEncoded
    @POST("/api/v1/user/password/callback")
    Observable<BaseResponse<FindUserPasswdResponse>> findUserPassword(@Header("Authorization") String str, @Field(SocialConstants.PARAM_TYPE) long j, @Field(SocialConstants.PARAM_TYPE) String str2, @Field(SocialConstants.PARAM_TYPE) String str3, @Field(SocialConstants.PARAM_TYPE) String str4);

    @POST("/api/v1/advice/list")
    Observable<BaseResponse<List<AdviceResponse>>> getAdviceList(@Header("Authorization") String str);

    @GET("/wechat/device/get_authorized_qrcode")
    Observable<BaseResponse<AuthorizedQrcodeResponse>> getAuthorizedQrcode(@Header("Authorization") String str, @Query("mac") String str2);

    @FormUrlEncoded
    @POST("/api/v1/step/beatCount")
    Observable<BaseResponse<Integer>> getBeatCount(@Header("Authorization") String str, @Field("date") String str2);

    @FormUrlEncoded
    @POST("/api/v1/habbit/rank")
    Observable<BaseResponse<List<HabbitRankModel>>> getHabbitRank(@Header("Authorization") String str, @Field("habbitId") long j);

    @GET("/api/v1/shopqrcode/get")
    Observable<BaseResponse<PaymentCodeResponse>> getPaymentCode(@Header("Authorization") String str, @Query("imei") String str2);

    @GET("/api/v1/qiniu/token")
    Observable<BaseResponse<AvatarTokenResponse>> getQiLiuYunToken(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("/api/v1/step/realtime/load")
    Observable<BaseResponse<RealStepsModel>> getRealSteps(@Header("Authorization") String str, @Field("date") String str2);

    @FormUrlEncoded
    @POST("/api/v1/habbit/signCount")
    Observable<BaseResponse<HabbitRankConfigModel>> getSignCount(@Header("Authorization") String str, @Field("habbitId") long j, @Field("date") String str2);

    @GET("/api/v1/user/sport/report/month")
    Observable<BaseResponse<ResponseReport>> getSportMonthReport(@Header("Authorization") String str, @Query("devid") String str2, @Query("start") String str3, @Query("targetSteps") int i);

    @GET("/api/v1/user/sport/report/week")
    Observable<BaseResponse<ResponseReport>> getSportWeekReport(@Header("Authorization") String str, @Query("devid") String str2, @Query("start") String str3, @Query("targetSteps") int i);

    @FormUrlEncoded
    @POST("/api/v1/step/myrank")
    Observable<BaseResponse<StepsRankResponse>> getStepRank(@Header("Authorization") String str, @Field("userid") long j, @Field("date") String str2);

    @GET("/api/v1/weather")
    Observable<BaseResponse<WeatherResponse>> getWeather(@Header("Authorization") String str, @Query("lat") double d, @Query("lon") double d2);

    @GET("/api/v1/weather/forecast/3day")
    Observable<BaseResponse<Weather2Response>> getWeather2(@Header("Authorization") String str, @Query("lat") double d, @Query("lon") double d2);

    @GET("/api/v1/weather/forecast")
    Observable<BaseResponse<WeatherForecastResponse>> getWeatherForecast(@Header("Authorization") String str, @Query("lat") double d, @Query("lon") double d2);

    @FormUrlEncoded
    @POST("/api/v1/app/launch/save")
    Observable<BaseResponse<String>> launchApp(@Header("Authorization") String str, @Field("appId") String str2, @Field("userId") String str3);

    @FormUrlEncoded
    @POST("/api/v1/step/like")
    Observable<BaseResponse<String>> like(@Header("Authorization") String str, @Field("userId") long j, @Field("date") String str2);

    @GET("/api/v1/app/setting/loadall")
    Observable<BaseResponse<AdvStatus>> loadAdvShowStatus(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("/api/v1/heartblood/load")
    Observable<BaseResponse<List<MeasureDetailsModel>>> loadHeartBlood(@Header("Authorization") String str, @Field("devid") String str2);

    @POST("/api/v1/track/load")
    Observable<BaseResponse<List<PathRecord>>> loadHistorySport(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("/api/v1/track/detail")
    Observable<BaseResponse<PathRecord>> loadHistorySportDetails(@Header("Authorization") String str, @Field("id") long j);

    @FormUrlEncoded
    @POST("/api/v1/sleep/load")
    Observable<BaseResponse<List<SleepDetailsModel>>> loadSleep(@Header("Authorization") String str, @Field("devid") String str2);

    @FormUrlEncoded
    @POST("/api/v1/sportrecord/load")
    Observable<BaseResponse<List<WatchSportsDataModel>>> loadSportsRecord(@Header("Authorization") String str, @Field("devid") String str2);

    @GET("/api/v1/standing/load")
    Observable<BaseResponse<List<SportStandModel>>> loadStandData(@Header("Authorization") String str, @Query("devid") String str2);

    @FormUrlEncoded
    @POST("/api/v1/step/load")
    Observable<BaseResponse<List<SportDetailsModel>>> loadSteps(@Header("Authorization") String str, @Field("devid") String str2);

    @GET("/api/v1/tmp/load")
    Observable<BaseResponse<List<TempModel>>> loadTmp(@Header("Authorization") String str, @Query("devid") String str2);

    @POST("/api/v1/habbit/loadConfig")
    Observable<BaseResponse<List<UserHabbitConfigModel>>> loadUserHabbitConfig(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("/api/v1/login")
    Observable<BaseResponse<LoginResponse>> loginForMobilePhone(@Header("Authorization") String str, @Field("mobile") String str2, @Field("password") String str3);

    @FormUrlEncoded
    @POST("/api/v1/login/email")
    Observable<BaseResponse<LoginResponse>> loginOfEmail(@Header("Authorization") String str, @Field("email") String str2, @Field("password") String str3);

    @GET("/api/v1/logout")
    Observable<BaseResponse<String>> loginOut(@Header("Authorization") String str);

    @GET("/api/v1/user/achievement/get")
    Observable<BaseResponse<AcomplishModel>> queryAcomplish();

    @GET("/api/v1/medal/list")
    Observable<BaseResponse<List<Medal>>> queryAllMedal(@Header("Authorization") String str);

    @GET("/api/v1/imei/status")
    Observable<BaseResponse<IMEIStatusModel>> queryIMEIStatus(@Header("Authorization") String str, @Query("version") String str2);

    @GET("/api/v1/medal/user/{userid}")
    Observable<BaseResponse<List<String>>> queryMedal(@Header("Authorization") String str, @Path("userid") long j);

    @GET("/api/v1/user/medal/list")
    Observable<BaseResponse<MedalList>> queryMedalListOfAll(@Header("Authorization") String str, @Query("devid") String str2);

    @GET("/api/v1/watchimage/find")
    Observable<BaseResponse<ProductResponse>> queryProductInfo(@Header("Authorization") String str, @Query("customerCode") String str2, @Query("customerModel") String str3);

    @GET("/api/v1/user/check/info")
    Observable<BaseResponse<SignInfoResponse>> querySignInfo(@Header("Authorization") String str, @Query("userid") long j);

    @GET("/api/v1/user/check/list")
    Observable<BaseResponse<List<HisSignResponse>>> querySignRecord(@Header("Authorization") String str, @Query("userid") long j, @Query("start") String str2, @Query("end") String str3);

    @GET("/api/v1/sleep/stat")
    Observable<BaseResponse<SleepSummaryResponse>> querySleepInfoSummary(@Header("Authorization") String str);

    @GET("/api/v1/sleep/rank")
    Observable<BaseResponse<SleepRankResponse>> querySleepRank(@Header("Authorization") String str, @Query("asleep") int i, @Query("wakeup") int i2, @Query("dur") int i3);

    @FormUrlEncoded
    @POST("/api/v1/step/rank")
    Observable<BaseResponse<List<QueryStepsRankResponse>>> queryStepsRank(@Header("Authorization") String str, @Field("userid") long j, @Field("date") String str2, @Field("limit") int i);

    @POST("/api/v1/habbit/list")
    Observable<BaseResponse<List<UserHabbitModel>>> queryUserHabbitList(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("/api/v1/habbit/detail")
    Observable<BaseResponse<UserHabbitDetailsModel>> queryUserHabbitListDetails(@Header("Authorization") String str, @Field("habbitId") long j);

    @GET("/api/v1/user/{userid}")
    Observable<BaseResponse<QueryDataReponse>> queryUserInfo(@Header("Authorization") String str, @Path("userid") long j);

    @GET("/api/v1/watch/theme/detail")
    Observable<BaseResponse<WatchThemeDetailsResponse>> queryWatchThemeDetails(@Header("Authorization") String str, @Query("id") long j);

    @GET("/api/v1/watch/theme/list")
    Observable<BaseResponse<List<WatchThemeResponse>>> queryWatchThemeList(@Header("Authorization") String str, @Query("mainModel") String str2, @Query("mchModel") String str3, @Query("screenType") int i, @Query("grade") int i2);

    @GET("/api/v2/watch/theme/list/ids")
    Observable<BaseResponse<List<WatchThemeResponse>>> queryWatchThemePresetList(@Header("Authorization") String str, @Query("ownIds") String str2);

    @FormUrlEncoded
    @POST("/api/v1/register")
    Observable<BaseResponse<RegisterResponse>> regiseter(@Header("Authorization") String str, @Field("mobile") String str2, @Field("password") String str3, @Field(SocialConstants.PARAM_SOURCE) String str4, @Field("code") int i, @Field(SocialConstants.PARAM_TYPE) String str5);

    @FormUrlEncoded
    @POST("/api/v1/register/email")
    Observable<BaseResponse<RegisterOfEmail>> registerOfEmail(@Header("Authorization") String str, @Field("email") String str2, @Field("password") String str3, @Field(SocialConstants.PARAM_SOURCE) int i, @Field(SocialConstants.PARAM_TYPE) int i2);

    @FormUrlEncoded
    @POST("/api/v2/register/email")
    Observable<BaseResponse<Register2Response>> registerOfEmail2(@Header("Authorization") String str, @Field("email") String str2, @Field("password") String str3, @Field(SocialConstants.PARAM_SOURCE) int i);

    @FormUrlEncoded
    @POST("/api/v1/user/password/reset")
    Observable<BaseResponse<String>> resetPasswordOfEmail(@Header("Authorization") String str, @Field("email") String str2);

    @FormUrlEncoded
    @POST("/api/v1/sleep/saveSleepTime")
    Observable<BaseResponse<String>> saveSleepTime(@Header("Authorization") String str, @Field("date") String str2, @Field("asleep") int i, @Field("wakeup") int i2, @Field("deepDur") int i3, @Field("lightDur") int i4, @Field("wakeDur") int i5);

    @FormUrlEncoded
    @POST("/api/v2/track/save")
    Observable<BaseResponse<String>> saveSportRecord(@Header("Authorization") String str, @Field("data") String str2);

    @FormUrlEncoded
    @POST("/api/v1/sportrecord/save")
    Observable<BaseResponse<String>> saveSportsRecord(@Header("Authorization") String str, @Field("data") String str2);

    @FormUrlEncoded
    @POST("/api/v1/habbit/create")
    Observable<BaseResponse<UserHabbitCustomModel>> saveUserHabbit(@Header("Authorization") String str, @Field("habbitName") String str2);

    @FormUrlEncoded
    @POST("/api/v1/sms/verifycode/send")
    Observable<BaseResponse<YanZhengResponse>> sendYanZhengCode(@Header("Authorization") String str, @Field("mobile") String str2);

    @FormUrlEncoded
    @POST("/api/v1/habbit/sign")
    Observable<BaseResponse<UserHabbitSignModel>> signUserHabbit(@Header("Authorization") String str, @Field("habbitId") long j, @Field("date") String str2);

    @FormUrlEncoded
    @POST("/api/v1/social/login")
    Observable<BaseResponse<LoginResponse>> socialLogin(@Header("Authorization") String str, @Field("uid") String str2, @Field("socialSource") String str3, @Field(SocialConstants.PARAM_SOURCE) int i, @Field("nickname") String str4, @Field("sex") int i2, @Field(SocialConstants.PARAM_TYPE) int i3, @Field("avatar") String str5);

    @FormUrlEncoded
    @POST("/api/v1/step/like")
    Observable<BaseResponse<String>> stepRankLike(@Header("Authorization") String str, @Field("userid") long j, @Field("date") String str2, @Field("like_userid") int i, @Field("is_like") int i2);

    @FormUrlEncoded
    @POST("/api/v1/step/unlike")
    Observable<BaseResponse<String>> unlike(@Header("Authorization") String str, @Field("userId") long j, @Field("date") String str2);

    @POST("/api/v1/user/account/remove")
    Observable<BaseResponse> unregisterUser(@Header("Authorization") String str);

    @FormUrlEncoded
    @POST("/api/v1/device/save")
    Observable<BaseResponse<String>> updateDeviceInfo(@Header("Authorization") String str, @Field("mac") String str2, @Field("deviceModel") String str3, @Field("deviceVersion") String str4, @Field("appVersion") String str5, @Field("osVersion") String str6, @Field("osType") String str7, @Field("osLang") String str8, @Field("phoneModel") String str9, @Field("userId") Long l);

    @FormUrlEncoded
    @POST("/api/v1/user/updateDevid")
    Observable<BaseResponse<String>> updateDevid(@Header("Authorization") String str, @Field("userid") long j, @Field("devid") String str2);

    @FormUrlEncoded
    @POST("/api/v1/user/updateInfo")
    Observable<BaseResponse<String>> updateInfo(@Header("Authorization") String str, @Field("sex") int i, @Field("age") int i2, @Field("bmi") float f, @Field("height") int i3, @Field("weight") int i4, @Field("fat") float f2, @Field("score") int i5, @Field("targetStep") int i6);

    @FormUrlEncoded
    @POST("/api/v1/user/mobile/update")
    Observable<BaseResponse<UpdatePhoneNumResponse>> updatePhoneNum(@Header("Authorization") String str, @Field("userid") int i, @Field("mobile") String str2, @Field("code") String str3);

    @FormUrlEncoded
    @POST("/api/v1/user/updateRanked")
    Observable<BaseResponse<String>> updateRanked(@Header("Authorization") String str, @Field("userid") long j, @Field("ranked") String str2);

    @FormUrlEncoded
    @POST("/api/v1/user/update")
    Observable<BaseResponse<UpdateUserInfoResponse>> updateUserInfo(@Header("Authorization") String str, @Field("userid") long j, @Field("sign") String str2, @Field("nickname") String str3, @Field("sex") int i, @Field("birthday") String str4, @Field("height") int i2, @Field("weight") int i3, @Field("target_steps") int i4, @Field("target_sleep") int i5, @Field("sit_remind") int i6, @Field("distance_unit") int i7, @Field("weightUnit") int i8, @Field("height_unit") int i9, @Field("mobile") String str5, @Field("avatar") String str6);

    @FormUrlEncoded
    @POST("/api/v1/user/password/update")
    Observable<BaseResponse<String>> updateUserPassword(@Header("Authorization") String str, @Field("id") long j, @Field("oldPassword") String str2, @Field("password") String str3);

    @GET("/api/v1/config/app/upgrade")
    Observable<BaseResponse<UpgradeResponse>> upgrade(@Header("authorization") String str, @Query("name") String str2);

    @FormUrlEncoded
    @POST("/api/v1/advice/save")
    Observable<BaseResponse<FeedbackResponse>> uploadFeedback(@Header("Authorization") String str, @Field("content") String str2, @Field("image1") String str3, @Field("image2") String str4, @Field("image3") String str5, @Field(SocialConstants.PARAM_SOURCE) String str6, @Field("version") String str7);

    @FormUrlEncoded
    @POST("/api/v1/heartblood/save")
    Observable<BaseResponse<String>> uploadHeartBlood(@Header("Authorization") String str, @Field("data") String str2);

    @FormUrlEncoded
    @POST("/api/v1/step/realtime/save")
    Observable<BaseResponse<String>> uploadRealSteps(@Header("Authorization") String str, @Field("date") String str2, @Field("step") int i, @Field("calory") int i2, @Field("distance") int i3);

    @FormUrlEncoded
    @POST("/api/v1/sleep/save")
    Observable<BaseResponse<String>> uploadSleep(@Header("Authorization") String str, @Field("data") String str2);

    @FormUrlEncoded
    @POST("/api/v1/standing/save")
    Observable<BaseResponse<String>> uploadStand(@Header("Authorization") String str, @Field("data") String str2);

    @FormUrlEncoded
    @POST("/api/v2/step/save")
    Observable<BaseResponse<String>> uploadSteps(@Header("Authorization") String str, @Field("data") String str2);

    @POST("/api/v1/tmp/save")
    Observable<BaseResponse<String>> uploadTmp(@Header("Authorization") String str, @Body List<TempModel> list);

    @FormUrlEncoded
    @POST("/api/v1/user/check")
    Observable<BaseResponse<UserSignResponse>> userSign(@Header("Authorization") String str, @Field("userid") long j, @Field("time") String str2);
}
