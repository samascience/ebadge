package defpackage;

import android.content.ClipData;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class q21 {

    class a extends InputConnectionWrapper {
        final /* synthetic */ b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InputConnection inputConnection, boolean z, b bVar) {
            super(inputConnection, z);
            this.a = bVar;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
            if (this.a.a(r21.f(inputContentInfo), i, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i, bundle);
        }
    }

    public interface b {
        boolean a(r21 r21Var, int i, Bundle bundle);
    }

    private static b b(final View view) {
        b52.g(view);
        return new b() { // from class: p21
            @Override // q21.b
            public final boolean a(r21 r21Var, int i, Bundle bundle) {
                return q21.e(view, r21Var, i, bundle);
            }
        };
    }

    public static InputConnection c(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return d(inputConnection, editorInfo, b(view));
    }

    public static InputConnection d(InputConnection inputConnection, EditorInfo editorInfo, b bVar) {
        tt1.d(inputConnection, "inputConnection must be non-null");
        tt1.d(editorInfo, "editorInfo must be non-null");
        tt1.d(bVar, "onCommitContentListener must be non-null");
        return new a(inputConnection, false, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean e(View view, r21 r21Var, int i, Bundle bundle) {
        if ((i & 1) != 0) {
            try {
                r21Var.d();
                Parcelable parcelable = (Parcelable) r21Var.e();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        return be3.f0(view, new x20.a(new ClipData(r21Var.b(), new ClipData.Item(r21Var.a())), 2).d(r21Var.c()).b(bundle).a()) == null;
    }
}
