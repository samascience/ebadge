package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.aztec.decoder.Decoder;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class be implements cd2 {
    @Override // defpackage.cd2
    public kh2 a(th thVar, Map map) throws NotFoundException, FormatException {
        nh2[] nh2VarArrB;
        nh2[] nh2VarArrB2;
        FormatException formatException;
        s90 s90Var = new s90(thVar.a());
        q70 q70VarC = null;
        try {
            ae aeVarA = s90Var.a(false);
            nh2VarArrB = aeVarA.b();
            try {
                nh2VarArrB2 = nh2VarArrB;
                formatException = null;
                q70VarC = new Decoder().c(aeVarA);
                e = null;
            } catch (FormatException e) {
                e = e;
                nh2VarArrB2 = nh2VarArrB;
                formatException = e;
                e = null;
            } catch (NotFoundException e2) {
                e = e2;
                nh2VarArrB2 = nh2VarArrB;
                formatException = null;
            }
        } catch (FormatException e3) {
            e = e3;
            nh2VarArrB = null;
        } catch (NotFoundException e4) {
            e = e4;
            nh2VarArrB = null;
        }
        if (q70VarC == null) {
            try {
                ae aeVarA2 = s90Var.a(true);
                nh2VarArrB2 = aeVarA2.b();
                q70VarC = new Decoder().c(aeVarA2);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                }
                if (formatException != null) {
                    throw formatException;
                }
                throw e5;
            }
        }
        nh2[] nh2VarArr = nh2VarArrB2;
        if (map != null) {
            e43.a(map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK));
        }
        kh2 kh2Var = new kh2(q70VarC.h(), q70VarC.e(), q70VarC.c(), nh2VarArr, BarcodeFormat.AZTEC, System.currentTimeMillis());
        List listA = q70VarC.a();
        if (listA != null) {
            kh2Var.h(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = q70VarC.b();
        if (strB != null) {
            kh2Var.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        return kh2Var;
    }

    @Override // defpackage.cd2
    public void b() {
    }
}
