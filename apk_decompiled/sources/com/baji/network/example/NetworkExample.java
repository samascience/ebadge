package com.baji.network.example;

import android.content.Context;
import com.baji.network.BadgeApiManager;
import com.baji.network.NetworkManager;
import com.baji.network.api.ApiService;
import com.baji.network.api.FileApiService;
import com.baji.network.api.UserApiService;
import com.baji.network.example.NetworkExample;
import com.baji.network.model.BadgeImage;
import com.baji.network.model.BadgeImageResponse;
import com.baji.network.model.BadgeImageType;
import com.baji.network.model.DownloadProgress;
import com.baji.network.model.NetworkError;
import com.baji.network.model.UploadProgress;
import com.baji.network.utils.NetworkUtils;
import com.jieli.lib.video.tool.BuildConfig;
import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.d63;
import defpackage.fh2;
import defpackage.k83;
import defpackage.p31;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkExample {
    private final NetworkManager networkManager = NetworkManager.Companion.getInstance();
    private final BadgeApiManager badgeApiManager = BadgeApiManager.Companion.getInstance();

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$31(List list) {
        p31.f(list, "images");
        System.out.println((Object) ("获取到 " + list.size() + " 张图片"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BadgeImage badgeImage = (BadgeImage) it.next();
            System.out.println((Object) ("ID: " + badgeImage.getId() + ", 类型: " + badgeImage.getTypeDescription() + ", URL: " + badgeImage.getUrl()));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$32(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("获取图片列表失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$33(List list) {
        p31.f(list, "borderImages");
        System.out.println((Object) ("获取到 " + list.size() + " 张边框图片"));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$34(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("获取边框图片失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$35(List list) {
        p31.f(list, "stickerImages");
        System.out.println((Object) ("获取到 " + list.size() + " 张贴纸图片"));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$36(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("获取贴纸图片失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$37(List list) {
        p31.f(list, "images");
        System.out.println((Object) ("边框图片数量: " + list.size()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$38(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("根据类型获取图片失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$39(BadgeImage badgeImage) {
        if (badgeImage != null) {
            System.out.println((Object) ("找到图片: " + badgeImage.getId() + " - " + badgeImage.getTypeDescription()));
        } else {
            System.out.println((Object) "未找到指定ID的图片");
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiExample$lambda$40(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("查找图片失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiObservableExample$lambda$42(BadgeImageResponse badgeImageResponse) {
        if (badgeImageResponse.getSuccess()) {
            System.out.println((Object) ("API调用成功，获取到 " + badgeImageResponse.getData().size() + " 张图片"));
            for (BadgeImage badgeImage : badgeImageResponse.getData()) {
                System.out.println((Object) ("图片: " + badgeImage.getId() + " - " + badgeImage.getTypeDescription()));
            }
        } else {
            System.out.println((Object) "API返回失败");
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 badgeApiObservableExample$lambda$44(Throwable th) {
        System.out.println((Object) ("API调用失败: " + th.getMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 downloadFileExample$lambda$11(DownloadProgress downloadProgress) {
        p31.f(downloadProgress, "progress");
        String str = "下载进度: " + ((int) (downloadProgress.getProgress() * 100)) + '%';
        PrintStream printStream = System.out;
        printStream.println((Object) str);
        StringBuilder sb = new StringBuilder();
        sb.append("下载速度: ");
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        sb.append(networkUtils.formatSpeed(downloadProgress.getSpeed()));
        printStream.println((Object) sb.toString());
        printStream.println((Object) ("剩余时间: " + networkUtils.formatTimeRemaining(downloadProgress.getEstimatedTimeRemaining())));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 downloadFileExample$lambda$12(File file) {
        p31.f(file, "file");
        String str = "文件下载成功: " + file.getAbsolutePath();
        PrintStream printStream = System.out;
        printStream.println((Object) str);
        StringBuilder sb = new StringBuilder();
        sb.append("文件大小: ");
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        sb.append(networkUtils.formatFileSize(file.length()));
        printStream.println((Object) sb.toString());
        printStream.println((Object) ("文件MD5: " + networkUtils.calculateFileMD5(file)));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 downloadFileExample$lambda$13(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("文件下载失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 fileApiExample$lambda$22(fh2 fh2Var) throws IOException {
        System.out.println((Object) ("文件列表: " + fh2Var.string()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 fileApiExample$lambda$24(Throwable th) {
        System.out.println((Object) ("获取文件列表失败: " + th.getMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 fileApiExample$lambda$26(fh2 fh2Var) throws IOException {
        System.out.println((Object) ("删除文件成功: " + fh2Var.string()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 fileApiExample$lambda$28(Throwable th) {
        System.out.println((Object) ("删除文件失败: " + th.getMessage()));
        return k83.a;
    }

    private final String getAuthToken() {
        return "Bearer 6fcb7f58475b4e5aad8f0f1cadce235e";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getRequestExample$lambda$0(fh2 fh2Var) throws IOException {
        System.out.println((Object) ("GET请求成功: " + fh2Var.string()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 getRequestExample$lambda$2(Throwable th) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        System.out.println((Object) ("GET请求失败: " + networkUtils.createNetworkError(-1, message, th).getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 postRequestExample$lambda$4(fh2 fh2Var) throws IOException {
        System.out.println((Object) ("POST请求成功: " + fh2Var.string()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 postRequestExample$lambda$6(Throwable th) {
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        System.out.println((Object) ("POST请求失败: " + networkUtils.createNetworkError(-1, message, th).getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 uploadFileExample$lambda$10(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("文件上传失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 uploadFileExample$lambda$8(UploadProgress uploadProgress) {
        p31.f(uploadProgress, "progress");
        String str = "上传进度: " + ((int) (uploadProgress.getProgress() * 100)) + '%';
        PrintStream printStream = System.out;
        printStream.println((Object) str);
        StringBuilder sb = new StringBuilder();
        sb.append("上传速度: ");
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        sb.append(networkUtils.formatSpeed(uploadProgress.getSpeed()));
        printStream.println((Object) sb.toString());
        printStream.println((Object) ("剩余时间: " + networkUtils.formatTimeRemaining(uploadProgress.getEstimatedTimeRemaining())));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 uploadFileExample$lambda$9(String str) {
        p31.f(str, "response");
        System.out.println((Object) ("文件上传成功: " + str));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 userApiExample$lambda$14(fh2 fh2Var) throws IOException {
        System.out.println((Object) ("用户信息: " + fh2Var.string()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 userApiExample$lambda$16(Throwable th) {
        System.out.println((Object) ("获取用户信息失败: " + th.getMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 userApiExample$lambda$18(fh2 fh2Var) throws IOException {
        System.out.println((Object) ("登录成功: " + fh2Var.string()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 userApiExample$lambda$20(Throwable th) {
        System.out.println((Object) ("登录失败: " + th.getMessage()));
        return k83.a;
    }

    public final void badgeApiExample() {
        this.badgeApiManager.getBadgeImageList(new ar0() { // from class: eo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$31((List) obj);
            }
        }, new ar0() { // from class: po1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$32((NetworkError) obj);
            }
        });
        this.badgeApiManager.getBorderImages(new ar0() { // from class: ap1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$33((List) obj);
            }
        }, new ar0() { // from class: lp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$34((NetworkError) obj);
            }
        });
        this.badgeApiManager.getStickerImages(new ar0() { // from class: qp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$35((List) obj);
            }
        }, new ar0() { // from class: rp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$36((NetworkError) obj);
            }
        });
        this.badgeApiManager.getImagesByType(BadgeImageType.BORDER, new ar0() { // from class: sp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$37((List) obj);
            }
        }, new ar0() { // from class: tp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$38((NetworkError) obj);
            }
        });
        this.badgeApiManager.findImageById(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, new ar0() { // from class: up1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$39((BadgeImage) obj);
            }
        }, new ar0() { // from class: vp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiExample$lambda$40((NetworkError) obj);
            }
        });
    }

    public final void badgeApiObservableExample() {
        Observable<BadgeImageResponse> badgeImageListObservable = this.badgeApiManager.getBadgeImageListObservable();
        final ar0 ar0Var = new ar0() { // from class: no1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiObservableExample$lambda$42((BadgeImageResponse) obj);
            }
        };
        Consumer<? super BadgeImageResponse> consumer = new Consumer() { // from class: oo1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var.invoke(obj);
            }
        };
        final ar0 ar0Var2 = new ar0() { // from class: qo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.badgeApiObservableExample$lambda$44((Throwable) obj);
            }
        };
        badgeImageListObservable.subscribe(consumer, new Consumer() { // from class: ro1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var2.invoke(obj);
            }
        });
    }

    public final void checkNetworkStatus(Context context) {
        p31.f(context, "context");
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        if (!networkUtils.isNetworkAvailable(context)) {
            System.out.println((Object) "网络不可用");
            return;
        }
        System.out.println((Object) ("网络可用，类型: " + networkUtils.getNetworkType(context)));
    }

    public final void downloadFileExample() {
        this.networkManager.downloadFile("files/download/123", new File("/path/to/download/file.jpg"), new ar0() { // from class: ip1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.downloadFileExample$lambda$11((DownloadProgress) obj);
            }
        }, new ar0() { // from class: jp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.downloadFileExample$lambda$12((File) obj);
            }
        }, new ar0() { // from class: kp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.downloadFileExample$lambda$13((NetworkError) obj);
            }
        });
    }

    public final void fileApiExample() {
        FileApiService fileApiService = this.networkManager.getFileApiService();
        Observable<fh2> fileList = fileApiService.getFileList(1, 20);
        final ar0 ar0Var = new ar0() { // from class: wo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.fileApiExample$lambda$22((fh2) obj);
            }
        };
        Consumer<? super fh2> consumer = new Consumer() { // from class: xo1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var.invoke(obj);
            }
        };
        final ar0 ar0Var2 = new ar0() { // from class: yo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.fileApiExample$lambda$24((Throwable) obj);
            }
        };
        fileList.subscribe(consumer, new Consumer() { // from class: zo1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var2.invoke(obj);
            }
        });
        Observable<fh2> observableDeleteFile = fileApiService.deleteFile("123");
        final ar0 ar0Var3 = new ar0() { // from class: bp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.fileApiExample$lambda$26((fh2) obj);
            }
        };
        Consumer<? super fh2> consumer2 = new Consumer() { // from class: cp1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var3.invoke(obj);
            }
        };
        final ar0 ar0Var4 = new ar0() { // from class: dp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.fileApiExample$lambda$28((Throwable) obj);
            }
        };
        observableDeleteFile.subscribe(consumer2, new Consumer() { // from class: ep1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        });
    }

    public final void getRequestExample() {
        Observable observable = ApiService.DefaultImpls.get$default(this.networkManager.getApiService(), "users/123", u.g(d63.a("include", "profile"), d63.a("fields", "id,name,email")), null, 4, null);
        final ar0 ar0Var = new ar0() { // from class: so1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.getRequestExample$lambda$0((fh2) obj);
            }
        };
        Consumer consumer = new Consumer() { // from class: to1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var.invoke(obj);
            }
        };
        final ar0 ar0Var2 = new ar0() { // from class: uo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.getRequestExample$lambda$2((Throwable) obj);
            }
        };
        observable.subscribe(consumer, new Consumer() { // from class: vo1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var2.invoke(obj);
            }
        });
    }

    public final void initializeNetwork() {
        NetworkManager.initialize$default(this.networkManager, "https://hiapi.jusonsmart.com/", null, true, "DEBUG", u.g(d63.a("X-App-Version", BuildConfig.VERSION_NAME), d63.a("X-Platform", "Android")), 2, null);
    }

    public final void postRequestExample() {
        Observable observablePost$default = ApiService.DefaultImpls.post$default(this.networkManager.getApiService(), "users", u.g(d63.a("name", "张三"), d63.a("email", "zhangsan@example.com"), d63.a("age", 25)), null, 4, null);
        final ar0 ar0Var = new ar0() { // from class: mp1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.postRequestExample$lambda$4((fh2) obj);
            }
        };
        Consumer consumer = new Consumer() { // from class: np1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var.invoke(obj);
            }
        };
        final ar0 ar0Var2 = new ar0() { // from class: op1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.postRequestExample$lambda$6((Throwable) obj);
            }
        };
        observablePost$default.subscribe(consumer, new Consumer() { // from class: pp1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var2.invoke(obj);
            }
        });
    }

    public final void uploadFileExample() {
        File file = new File("/path/to/upload/file.jpg");
        if (NetworkUtils.INSTANCE.isValidFile(file)) {
            this.networkManager.uploadFile(file, "files/upload", new ar0() { // from class: fp1
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return NetworkExample.uploadFileExample$lambda$8((UploadProgress) obj);
                }
            }, new ar0() { // from class: gp1
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return NetworkExample.uploadFileExample$lambda$9((String) obj);
                }
            }, new ar0() { // from class: hp1
                @Override // defpackage.ar0
                public final Object invoke(Object obj) {
                    return NetworkExample.uploadFileExample$lambda$10((NetworkError) obj);
                }
            });
        } else {
            System.out.println((Object) "文件无效");
        }
    }

    public final void userApiExample() {
        UserApiService userApiService = this.networkManager.getUserApiService();
        Observable<fh2> userProfile = userApiService.getUserProfile();
        final ar0 ar0Var = new ar0() { // from class: fo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.userApiExample$lambda$14((fh2) obj);
            }
        };
        Consumer<? super fh2> consumer = new Consumer() { // from class: go1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var.invoke(obj);
            }
        };
        final ar0 ar0Var2 = new ar0() { // from class: ho1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.userApiExample$lambda$16((Throwable) obj);
            }
        };
        userProfile.subscribe(consumer, new Consumer() { // from class: io1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var2.invoke(obj);
            }
        });
        Observable<fh2> observableLogin = userApiService.login(u.g(d63.a("username", "zhangsan"), d63.a("password", "password123")));
        final ar0 ar0Var3 = new ar0() { // from class: jo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.userApiExample$lambda$18((fh2) obj);
            }
        };
        Consumer<? super fh2> consumer2 = new Consumer() { // from class: ko1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var3.invoke(obj);
            }
        };
        final ar0 ar0Var4 = new ar0() { // from class: lo1
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return NetworkExample.userApiExample$lambda$20((Throwable) obj);
            }
        };
        observableLogin.subscribe(consumer2, new Consumer() { // from class: mo1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var4.invoke(obj);
            }
        });
    }
}
