package com.baji.network.test;

import com.baji.network.BadgeApiManager;
import com.baji.network.NetworkManager;
import com.baji.network.model.BadgeImage;
import com.baji.network.model.BadgeImageResponse;
import com.baji.network.model.NetworkError;
import com.baji.network.test.BadgeApiTest;
import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.k83;
import defpackage.p31;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeApiTest {
    private final BadgeApiManager badgeApiManager = BadgeApiManager.Companion.getInstance();

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testFindImageById$lambda$14(BadgeImage badgeImage) {
        if (badgeImage != null) {
            System.out.println((Object) ("✅ 找到图片: ID=" + badgeImage.getId() + ", 类型=" + badgeImage.getTypeDescription() + ", URL=" + badgeImage.getUrl()));
        } else {
            System.out.println((Object) "⚠️ 未找到ID为11的图片");
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testFindImageById$lambda$15(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("❌ 查找图片失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetAllImages$lambda$1(List list) {
        p31.f(list, "images");
        System.out.println((Object) ("✅ 成功获取 " + list.size() + " 张图片"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BadgeImage badgeImage = (BadgeImage) it.next();
            System.out.println((Object) ("  - ID: " + badgeImage.getId() + ", 类型: " + badgeImage.getTypeDescription() + ", URL: " + badgeImage.getUrl()));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetAllImages$lambda$2(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("❌ 获取失败: " + networkError.getErrorMessage() + " (错误码: " + networkError.getErrorCode() + ')'));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetAllImagesOfficial$lambda$12(List list) {
        int i;
        p31.f(list, "images");
        System.out.println((Object) ("✅ 成功获取 " + list.size() + " 张图片"));
        int i2 = 0;
        if (list.isEmpty()) {
            i = 0;
        } else {
            Iterator it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (((BadgeImage) it.next()).isBorder() && (i = i + 1) < 0) {
                    j.r();
                }
            }
        }
        if (!list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                if (((BadgeImage) it2.next()).isSticker() && (i2 = i2 + 1) < 0) {
                    j.r();
                }
            }
        }
        PrintStream printStream = System.out;
        printStream.println((Object) ("  - 边框图片: " + i + " 张"));
        printStream.println((Object) ("  - 贴纸图片: " + i2 + " 张"));
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            BadgeImage badgeImage = (BadgeImage) it3.next();
            System.out.println((Object) ("  - ID: " + badgeImage.getId() + ", 类型: " + badgeImage.getTypeDescription() + ", URL: " + badgeImage.getUrl()));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetAllImagesOfficial$lambda$13(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("❌ 获取失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetBorderImages$lambda$4(List list) {
        p31.f(list, "images");
        System.out.println((Object) ("✅ 成功获取 " + list.size() + " 张边框图片"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BadgeImage badgeImage = (BadgeImage) it.next();
            System.out.println((Object) ("  - ID: " + badgeImage.getId() + ", URL: " + badgeImage.getUrl()));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetBorderImages$lambda$5(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("❌ 获取边框图片失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetStickerImages$lambda$7(List list) {
        p31.f(list, "images");
        System.out.println((Object) ("✅ 成功获取 " + list.size() + " 张贴纸图片"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BadgeImage badgeImage = (BadgeImage) it.next();
            System.out.println((Object) ("  - ID: " + badgeImage.getId() + ", URL: " + badgeImage.getUrl()));
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testGetStickerImages$lambda$8(NetworkError networkError) {
        p31.f(networkError, "error");
        System.out.println((Object) ("❌ 获取贴纸图片失败: " + networkError.getErrorMessage()));
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testObservableWay$lambda$19(BadgeImageResponse badgeImageResponse) {
        if (badgeImageResponse.getSuccess()) {
            System.out.println((Object) ("✅ Observable方式成功获取 " + badgeImageResponse.getData().size() + " 张图片"));
            List<BadgeImage> data = badgeImageResponse.getData();
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                if (((BadgeImage) obj).isBorder()) {
                    arrayList.add(obj);
                }
            }
            List<BadgeImage> data2 = badgeImageResponse.getData();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : data2) {
                if (((BadgeImage) obj2).isSticker()) {
                    arrayList2.add(obj2);
                }
            }
            String str = "  - 边框图片: " + arrayList.size() + " 张";
            PrintStream printStream = System.out;
            printStream.println((Object) str);
            printStream.println((Object) ("  - 贴纸图片: " + arrayList2.size() + " 张"));
            for (BadgeImage badgeImage : badgeImageResponse.getData()) {
                System.out.println((Object) ("  - ID: " + badgeImage.getId() + ", 类型: " + badgeImage.getTypeDescription() + ", URL: " + badgeImage.getUrl()));
            }
        } else {
            System.out.println((Object) "❌ API返回失败");
        }
        return k83.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k83 testObservableWay$lambda$21(Throwable th) {
        System.out.println((Object) ("❌ Observable方式失败: " + th.getMessage()));
        return k83.a;
    }

    public final void runAllTests() {
        PrintStream printStream = System.out;
        printStream.println((Object) "开始运行电子吧唧API测试...");
        NetworkManager.initialize$default(NetworkManager.Companion.getInstance(), "https://hiapi.jusonsmart.com/", null, true, "DEBUG", null, 18, null);
        testGetAllImages();
        testGetAllImagesOfficial();
        testGetBorderImages();
        testGetStickerImages();
        testFindImageById();
        testObservableWay();
        printStream.println((Object) "\n测试完成！");
    }

    public final void testFindImageById() {
        System.out.println((Object) "\n=== 测试根据ID查找图片 ===");
        this.badgeApiManager.findImageById(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, new ar0() { // from class: ff
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testFindImageById$lambda$14((BadgeImage) obj);
            }
        }, new ar0() { // from class: gf
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testFindImageById$lambda$15((NetworkError) obj);
            }
        });
    }

    public final void testGetAllImages() {
        System.out.println((Object) "=== 测试获取所有图片列表 ===");
        this.badgeApiManager.getBadgeImageList(new ar0() { // from class: we
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetAllImages$lambda$1((List) obj);
            }
        }, new ar0() { // from class: xe
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetAllImages$lambda$2((NetworkError) obj);
            }
        });
    }

    public final void testGetAllImagesOfficial() {
        System.out.println((Object) "\n=== 测试获取所有图片（官方API） ===");
        this.badgeApiManager.getBadgeImageList(new ar0() { // from class: ye
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetAllImagesOfficial$lambda$12((List) obj);
            }
        }, new ar0() { // from class: ze
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetAllImagesOfficial$lambda$13((NetworkError) obj);
            }
        });
    }

    public final void testGetBorderImages() {
        System.out.println((Object) "\n=== 测试获取边框图片 ===");
        this.badgeApiManager.getBorderImages(new ar0() { // from class: hf
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetBorderImages$lambda$4((List) obj);
            }
        }, new ar0() { // from class: if
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetBorderImages$lambda$5((NetworkError) obj);
            }
        });
    }

    public final void testGetStickerImages() {
        System.out.println((Object) "\n=== 测试获取贴纸图片 ===");
        this.badgeApiManager.getStickerImages(new ar0() { // from class: ve
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetStickerImages$lambda$7((List) obj);
            }
        }, new ar0() { // from class: af
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testGetStickerImages$lambda$8((NetworkError) obj);
            }
        });
    }

    public final void testObservableWay() {
        System.out.println((Object) "\n=== 测试RxJava Observable方式 ===");
        Observable<BadgeImageResponse> badgeImageListObservable = this.badgeApiManager.getBadgeImageListObservable();
        final ar0 ar0Var = new ar0() { // from class: bf
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testObservableWay$lambda$19((BadgeImageResponse) obj);
            }
        };
        Consumer<? super BadgeImageResponse> consumer = new Consumer() { // from class: cf
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var.invoke(obj);
            }
        };
        final ar0 ar0Var2 = new ar0() { // from class: df
            @Override // defpackage.ar0
            public final Object invoke(Object obj) {
                return BadgeApiTest.testObservableWay$lambda$21((Throwable) obj);
            }
        };
        badgeImageListObservable.subscribe(consumer, new Consumer() { // from class: ef
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ar0Var2.invoke(obj);
            }
        });
    }
}
