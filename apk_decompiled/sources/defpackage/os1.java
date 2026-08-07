package defpackage;

import com.alibaba.dashscope.common.ErrorType;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.protocol.Protocol;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.luck.picture.lib.compress.Checker;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
public abstract class os1 {
    private static final hd1 a = ld1.k(os1.class);

    private static String a(String str) {
        try {
            String strProbeContentType = Files.probeContentType(new File(str).toPath());
            if (strProbeContentType != null) {
                return strProbeContentType;
            }
            if (str.endsWith("mp3")) {
                return "audio/mp3";
            }
            if (str.endsWith("flac")) {
                return "audio/flac";
            }
            if (str.endsWith("wav")) {
                return "audio/wav";
            }
            if (str.endsWith("m4a")) {
                return "audio/mp4";
            }
            if (str.endsWith("png")) {
                return "image/png";
            }
            if (!str.endsWith("jpeg") && !str.endsWith("jpg")) {
                if (str.endsWith("bmp")) {
                    return "image/bmp";
                }
                if (str.endsWith("gif")) {
                    return "image/gif";
                }
                if (str.endsWith("tiff")) {
                    return "image/tiff";
                }
                a.error("Can not determine MIMEType, use default application/octet-stream");
                return DfuBaseService.MIME_TYPE_OCTET_STREAM;
            }
            return Checker.MIME_TYPE_JPEG;
        } catch (IOException unused) {
            return DfuBaseService.MIME_TYPE_OCTET_STREAM;
        }
    }

    public static u50 b(String str, String str2) throws NoApiKeyException {
        String str3;
        zt1 zt1VarB = au1.b();
        String str4 = i20.j;
        if (str4.endsWith(WatchConstant.FAT_FS_ROOT)) {
            str3 = str4 + "uploads";
        } else {
            str3 = str4 + "/uploads";
        }
        tx0.a aVarJ = tx0.l(str3).j();
        aVarJ.b("action", "getPolicy");
        aVarJ.b("model", str);
        df2.a aVarL = new df2.a().l(aVarJ.c());
        String strA = f8.a(str2);
        Boolean bool = Boolean.FALSE;
        Protocol protocol = Protocol.HTTP;
        try {
            eh2 eh2VarExecute = zt1VarB.a(aVarL.h(iw0.d(t50.a(strA, bool, protocol, bool, bool, Constants.STR_EMPTY, new HashMap()))).b()).execute();
            try {
                if (!eh2VarExecute.k0()) {
                    throw new ApiException(c(eh2VarExecute));
                }
                u50 u50Var = (u50) new u50().n(protocol, sq1.c().f(eh2VarExecute.n().string()).b(), false);
                eh2VarExecute.close();
                return u50Var;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (eh2VarExecute != null) {
                        try {
                            eh2VarExecute.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            throw new ApiException(th4);
        }
    }

    private static xt2 c(eh2 eh2Var) {
        String strA0 = eh2Var.a0("Content-Type");
        if (strA0 == null || !strA0.toLowerCase().contains("application/json")) {
            return xt2.c().f(eh2Var.C()).b(ErrorType.RESPONSE_ERROR.getValue()).d(eh2Var.m0()).c(false).a();
        }
        try {
            o61 o61VarC = t71.c(eh2Var.n().string());
            boolean zR = o61VarC.r("request_id");
            String strE = Constants.STR_EMPTY;
            String strE2 = zR ? o61VarC.p("request_id").e() : Constants.STR_EMPTY;
            String strE3 = o61VarC.r("code") ? o61VarC.p("code").e() : Constants.STR_EMPTY;
            if (o61VarC.r("message")) {
                strE = o61VarC.p("message").e();
            }
            return xt2.c().f(eh2Var.C()).b(strE3).d(strE).e(strE2).c(true).a();
        } catch (Throwable unused) {
            return xt2.c().f(eh2Var.C()).b(ErrorType.RESPONSE_ERROR.getValue()).d(eh2Var.m0()).c(true).a();
        }
    }

    public static z93 d(String str, String str2, String str3, ns1 ns1Var) {
        zt1 zt1VarB = au1.b();
        if (ns1Var == null) {
            o61 o61VarQ = ((o61) b(str, str3).q()).q("data");
            ns1Var = new ns1(o61VarQ.p("upload_host").e(), o61VarQ.p("oss_access_key_id").e(), o61VarQ.p(SocialOperation.GAME_SIGNATURE).e(), o61VarQ.p("policy").e(), o61VarQ.p("upload_dir").e(), o61VarQ.p("x_oss_object_acl").e(), o61VarQ.p("x_oss_forbid_overwrite").e());
        }
        HashMap map = new HashMap();
        map.put("user-agent", t50.d());
        map.put("Accept", "application/json");
        File file = new File(str2);
        String strF = ns1Var.f();
        String strB = ns1Var.b();
        String strD = ns1Var.d();
        String strC = ns1Var.c();
        String str4 = ns1Var.e() + WatchConstant.FAT_FS_ROOT + file.getName();
        try {
            eh2 eh2VarExecute = zt1VarB.a(new df2.a().m(strF).j(new gm1.a().f(gm1.k).a("OSSAccessKeyId", strB).a("Signature", strD).a("policy", strC).a("key", str4).a("x-oss-object-acl", ns1Var.h()).a("x-oss-forbid-overwrite", ns1Var.g()).a("success_action_status", "200").a("x-oss-content-type", a(str2)).b("file", file.getName(), ff2.create(fi1.g(a(str2)), file)).e()).b()).execute();
            try {
                if (!eh2VarExecute.k0()) {
                    throw new ApiException(c(eh2VarExecute));
                }
                z93 z93Var = new z93(uv2.a("oss://%s", str4), ns1Var);
                eh2VarExecute.close();
                return z93Var;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (eh2VarExecute != null) {
                        try {
                            eh2VarExecute.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            throw new ApiException(th4);
        }
    }
}
