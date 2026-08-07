package xfkj.fitpro.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.jieli.bmp_convert.BmpConvert;
import com.jieli.bmp_convert.ConvertResult;
import com.jieli.bmp_convert.OnConvertListener;
import defpackage.ar0;
import defpackage.h70;
import defpackage.j70;
import defpackage.k83;
import defpackage.or0;
import defpackage.x30;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import xfkj.fitpro.model.sever.body.ClockDialInfoBody;

/* JADX INFO: loaded from: classes4.dex */
@h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$convertBitmapOfJIELI$2", f = "WatchThemeTransferManager.kt", l = {1030, 837}, m = "invokeSuspend")
final class WatchThemeTransferManager$convertBitmapOfJIELI$2 extends SuspendLambda implements or0 {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ ClockDialInfoBody $clockDialInfo;
    final /* synthetic */ Context $context;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: renamed from: xfkj.fitpro.manager.WatchThemeTransferManager$convertBitmapOfJIELI$2$1, reason: invalid class name */
    @h70(c = "xfkj.fitpro.manager.WatchThemeTransferManager$convertBitmapOfJIELI$2$1", f = "WatchThemeTransferManager.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements or0 {
        final /* synthetic */ String $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, x30 x30Var) {
            super(2, x30Var);
            this.$result = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final x30 create(Object obj, x30 x30Var) {
            return new AnonymousClass1(this.$result, x30Var);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d.b(obj);
            return this.$result;
        }

        @Override // defpackage.or0
        public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
            return ((AnonymousClass1) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
        }
    }

    static final class a implements ar0 {
        final /* synthetic */ File a;

        a(File file) {
            this.a = file;
        }

        public final void a(Throwable th) {
            Log.w("WatchThemeTransferManager", "转换被取消");
            if (this.a.exists()) {
                this.a.delete();
            }
        }

        @Override // defpackage.ar0
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return k83.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WatchThemeTransferManager$convertBitmapOfJIELI$2(Bitmap bitmap, ClockDialInfoBody clockDialInfoBody, Context context, x30 x30Var) {
        super(2, x30Var);
        this.$bitmap = bitmap;
        this.$clockDialInfo = clockDialInfoBody;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final x30 create(Object obj, x30 x30Var) {
        WatchThemeTransferManager$convertBitmapOfJIELI$2 watchThemeTransferManager$convertBitmapOfJIELI$2 = new WatchThemeTransferManager$convertBitmapOfJIELI$2(this.$bitmap, this.$clockDialInfo, this.$context, x30Var);
        watchThemeTransferManager$convertBitmapOfJIELI$2.L$0 = obj;
        return watchThemeTransferManager$convertBitmapOfJIELI$2;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x01df A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:7:0x001b, B:30:0x01db, B:32:0x01df, B:34:0x01ea, B:14:0x003b, B:27:0x01c1, B:17:0x0048, B:21:0x0152, B:23:0x01b8), top: B:39:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:34:0x01ea A[Catch: Exception -> 0x0020, TRY_LEAVE, TryCatch #0 {Exception -> 0x0020, blocks: (B:7:0x001b, B:30:0x01db, B:32:0x01df, B:34:0x01ea, B:14:0x003b, B:27:0x01c1, B:17:0x0048, B:21:0x0152, B:23:0x01b8), top: B:39:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:36:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        File file;
        String str;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i = this.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    file = (File) this.L$2;
                    coroutineScope = (CoroutineScope) this.L$0;
                    d.b(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    file = (File) this.L$1;
                    d.b(obj);
                }
                str = (String) obj;
                if (str == null) {
                    return str;
                }
                Log.e("WatchThemeTransferManager", "bin文件转换超时");
                if (file.exists()) {
                    return null;
                }
                file.delete();
                return null;
            }
            d.b(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            Log.d("WatchThemeTransferManager", "使用杰理SDK BmpConvert 转换图片");
            Log.d("WatchThemeTransferManager", "图片尺寸: " + this.$bitmap.getWidth() + "x" + this.$bitmap.getHeight());
            Log.d("WatchThemeTransferManager", "表盘信息: " + ((int) this.$clockDialInfo.getWidth()) + "x" + ((int) this.$clockDialInfo.getHeight()));
            File file2 = new File(this.$context.getExternalFilesDir(null), "watch_theme_jieli_" + System.currentTimeMillis() + ".bin");
            File file3 = new File(this.$context.getExternalFilesDir(null), "temp_bitmap_" + System.currentTimeMillis() + ".png");
            FileOutputStream fileOutputStream = new FileOutputStream(file3);
            this.$bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            Log.d("WatchThemeTransferManager", "临时文件保存成功: " + file3.getAbsolutePath());
            Log.d("WatchThemeTransferManager", "临时文件存在: " + file3.exists());
            Log.d("WatchThemeTransferManager", "临时文件大小: " + file3.length() + " bytes");
            BmpConvert bmpConvert = new BmpConvert();
            int i2 = this.$clockDialInfo.getAlgorithm() == 3 ? 6 : 1;
            Log.d("WatchThemeTransferManager", "使用算法类型: " + i2);
            Log.d("WatchThemeTransferManager", "目标文件路径: " + file2.getAbsolutePath());
            this.L$0 = coroutineScope;
            this.L$1 = file2;
            this.L$2 = file3;
            this.L$3 = bmpConvert;
            this.I$0 = i2;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(kotlin.coroutines.intrinsics.a.c(this), 1);
            cancellableContinuationImpl.initCancellability();
            bmpConvert.bitmapConvert(i2, file3.getAbsolutePath(), file2.getAbsolutePath(), new b(file2, file3, cancellableContinuationImpl));
            cancellableContinuationImpl.invokeOnCancellation(new a(file3));
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.d()) {
                j70.c(this);
            }
            if (result == objD) {
                return objD;
            }
            file = file3;
            obj = result;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((String) obj, null);
            this.L$0 = coroutineScope;
            this.L$1 = file;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            obj = TimeoutKt.withTimeoutOrNull(5000L, anonymousClass1, this);
            if (obj == objD) {
                return objD;
            }
            str = (String) obj;
            if (str == null) {
                return str;
            }
            Log.e("WatchThemeTransferManager", "bin文件转换超时");
            if (file.exists()) {
                return null;
            }
            file.delete();
            return null;
        } catch (Exception e) {
            Log.e("WatchThemeTransferManager", "convertBitmapOfJIELI 转换失败: " + e.getMessage(), e);
            return null;
        }
    }

    @Override // defpackage.or0
    public final Object invoke(CoroutineScope coroutineScope, x30 x30Var) {
        return ((WatchThemeTransferManager$convertBitmapOfJIELI$2) create(coroutineScope, x30Var)).invokeSuspend(k83.a);
    }

    public static final class b implements OnConvertListener {
        final /* synthetic */ File a;
        final /* synthetic */ File b;
        final /* synthetic */ CancellableContinuation c;

        b(File file, File file2, CancellableContinuation cancellableContinuation) {
            this.a = file;
            this.b = file2;
            this.c = cancellableContinuation;
        }

        @Override // com.jieli.bmp_convert.OnConvertListener
        public void onStart(String str) {
            Log.d("WatchThemeTransferManager", "BmpConvert 开始转换: " + str);
        }

        @Override // com.jieli.bmp_convert.OnConvertListener
        public void onStop(boolean z, String str) {
            Log.d("WatchThemeTransferManager", "BmpConvert 转换完成: 成功=" + z + ", 消息=" + str);
            if (!z || !this.a.exists() || this.a.length() <= 0) {
                Log.e("WatchThemeTransferManager", "转换失败: " + str);
                if (this.b.exists()) {
                    this.b.delete();
                }
                this.c.resumeWith(Result.m69constructorimpl(null));
                return;
            }
            Log.d("WatchThemeTransferManager", "bin文件转换成功: " + this.a.getAbsolutePath() + ", 大小: " + this.a.length() + " bytes");
            if (this.b.exists()) {
                this.b.delete();
                Log.d("WatchThemeTransferManager", "临时文件已删除");
            }
            CancellableContinuation cancellableContinuation = this.c;
            Result.a aVar = Result.Companion;
            cancellableContinuation.resumeWith(Result.m69constructorimpl(this.a.getAbsolutePath()));
        }

        @Override // com.jieli.bmp_convert.OnConvertListener
        public void onStop(ConvertResult convertResult, String str) {
            Log.d("WatchThemeTransferManager", "BmpConvert 转换结果: " + convertResult + ", 消息=" + str);
            if (convertResult != null) {
                Log.d("WatchThemeTransferManager", "转换结果详情: 成功=" + convertResult);
            }
        }
    }
}
