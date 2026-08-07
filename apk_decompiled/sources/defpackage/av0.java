package defpackage;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R$styleable;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
abstract class av0 {
    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        return z ? new a(i, i3, i2) : new a(i, i2);
    }

    static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayQ = c73.q(resources, theme, attributeSet, R$styleable.GradientColor);
        float fJ = c73.j(typedArrayQ, xmlPullParser, "startX", R$styleable.GradientColor_android_startX, 0.0f);
        float fJ2 = c73.j(typedArrayQ, xmlPullParser, "startY", R$styleable.GradientColor_android_startY, 0.0f);
        float fJ3 = c73.j(typedArrayQ, xmlPullParser, "endX", R$styleable.GradientColor_android_endX, 0.0f);
        float fJ4 = c73.j(typedArrayQ, xmlPullParser, "endY", R$styleable.GradientColor_android_endY, 0.0f);
        float fJ5 = c73.j(typedArrayQ, xmlPullParser, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
        float fJ6 = c73.j(typedArrayQ, xmlPullParser, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
        int iK = c73.k(typedArrayQ, xmlPullParser, SocialConstants.PARAM_TYPE, R$styleable.GradientColor_android_type, 0);
        int iF = c73.f(typedArrayQ, xmlPullParser, "startColor", R$styleable.GradientColor_android_startColor, 0);
        boolean zP = c73.p(xmlPullParser, "centerColor");
        int iF2 = c73.f(typedArrayQ, xmlPullParser, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
        int iF3 = c73.f(typedArrayQ, xmlPullParser, "endColor", R$styleable.GradientColor_android_endColor, 0);
        int iK2 = c73.k(typedArrayQ, xmlPullParser, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
        float fJ7 = c73.j(typedArrayQ, xmlPullParser, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
        typedArrayQ.recycle();
        a aVarA = a(c(resources, xmlPullParser, attributeSet, theme), iF, iF3, zP, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.a, aVarA.b, d(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.a, aVarA.b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.a, aVarA.b, d(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayQ = c73.q(resources, theme, attributeSet, R$styleable.GradientColorItem);
                int i = R$styleable.GradientColorItem_android_color;
                boolean zHasValue = typedArrayQ.hasValue(i);
                int i2 = R$styleable.GradientColorItem_android_offset;
                boolean zHasValue2 = typedArrayQ.hasValue(i2);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayQ.getColor(i, 0);
                float f = typedArrayQ.getFloat(i2, 0.0f);
                typedArrayQ.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i) {
        if (i != 1) {
            return i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    static final class a {
        final int[] a;
        final float[] b;

        a(List list, List list2) {
            int size = list.size();
            this.a = new int[size];
            this.b = new float[size];
            for (int i = 0; i < size; i++) {
                this.a[i] = ((Integer) list.get(i)).intValue();
                this.b[i] = ((Float) list2.get(i)).floatValue();
            }
        }

        a(int i, int i2) {
            this.a = new int[]{i, i2};
            this.b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.a = new int[]{i, i2, i3};
            this.b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
