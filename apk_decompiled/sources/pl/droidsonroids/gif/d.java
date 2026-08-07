package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class d {
    static final List a = Arrays.asList("raw", "drawable", "mipmap");

    static void a(int i, Drawable drawable) {
        if (drawable instanceof pl.droidsonroids.gif.b) {
            ((pl.droidsonroids.gif.b) drawable).h(i);
        }
    }

    static float b(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.density;
        if (i2 == 0) {
            i2 = 160;
        } else if (i2 == 65535) {
            i2 = 0;
        }
        int i3 = resources.getDisplayMetrics().densityDpi;
        if (i2 <= 0 || i3 <= 0) {
            return 1.0f;
        }
        return i3 / i2;
    }

    static a c(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
        if (attributeSet == null || imageView.isInEditMode()) {
            return new a();
        }
        a aVar = new a(imageView, attributeSet, i, i2);
        int i3 = aVar.b;
        if (i3 >= 0) {
            a(i3, imageView.getDrawable());
            a(i3, imageView.getBackground());
        }
        return aVar;
    }

    static boolean d(ImageView imageView, Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            imageView.setImageDrawable(new pl.droidsonroids.gif.b(imageView.getContext().getContentResolver(), uri));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    static boolean e(ImageView imageView, boolean z, int i) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                if (!a.contains(resources.getResourceTypeName(i))) {
                    return false;
                }
                pl.droidsonroids.gif.b bVar = new pl.droidsonroids.gif.b(resources, i);
                if (z) {
                    imageView.setImageDrawable(bVar);
                    return true;
                }
                imageView.setBackground(bVar);
                return true;
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        return false;
    }

    static class a extends b {
        final int c;
        final int d;

        a(ImageView imageView, AttributeSet attributeSet, int i, int i2) {
            super(imageView, attributeSet, i, i2);
            this.c = a(imageView, attributeSet, true);
            this.d = a(imageView, attributeSet, false);
        }

        private static int a(ImageView imageView, AttributeSet attributeSet, boolean z) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
            if (attributeResourceValue > 0) {
                if (d.a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !d.e(imageView, z, attributeResourceValue)) {
                    return attributeResourceValue;
                }
            }
            return 0;
        }

        a() {
            this.c = 0;
            this.d = 0;
        }
    }

    static class b {
        boolean a;
        final int b;

        b(View view, AttributeSet attributeSet, int i, int i2) {
            TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.GifView, i, i2);
            this.a = typedArrayObtainStyledAttributes.getBoolean(R$styleable.GifView_freezesAnimation, false);
            this.b = typedArrayObtainStyledAttributes.getInt(R$styleable.GifView_loopCount, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        b() {
            this.a = false;
            this.b = -1;
        }
    }
}
