package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public abstract class mz {
    private static final ThreadLocal a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        ThreadLocal threadLocal = a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0095  */
    private static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        float f;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayH = h(resources, theme, attributeSet, R$styleable.ColorStateListItem);
                int i3 = R$styleable.ColorStateListItem_android_color;
                int resourceId = typedArrayH.getResourceId(i3, -1);
                if (resourceId == -1 || f(resources, resourceId)) {
                    color = typedArrayH.getColor(i3, -65281);
                } else {
                    try {
                        color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayH.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                    }
                }
                int i4 = R$styleable.ColorStateListItem_android_alpha;
                float f2 = 1.0f;
                if (typedArrayH.hasValue(i4)) {
                    f2 = typedArrayH.getFloat(i4, 1.0f);
                } else {
                    int i5 = R$styleable.ColorStateListItem_alpha;
                    if (typedArrayH.hasValue(i5)) {
                        f2 = typedArrayH.getFloat(i5, 1.0f);
                    }
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    int i6 = R$styleable.ColorStateListItem_android_lStar;
                    if (typedArrayH.hasValue(i6)) {
                        f = typedArrayH.getFloat(i6, -1.0f);
                    } else {
                        f = typedArrayH.getFloat(R$styleable.ColorStateListItem_lStar, -1.0f);
                    }
                } else {
                    f = typedArrayH.getFloat(R$styleable.ColorStateListItem_lStar, -1.0f);
                }
                typedArrayH.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i7 = 0;
                for (int i8 = 0; i8 < attributeCount; i8++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i8);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R$attr.alpha && attributeNameResource != R$attr.lStar) {
                        int i9 = i7 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i8, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i7] = attributeNameResource;
                        i7 = i9;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i7);
                iArrA = pv0.a(iArrA, i2, g(color, f2, f));
                iArr = (int[][]) pv0.b(iArr, i2, iArrTrimStateSet);
                i2++;
            }
            i = 1;
        }
        int[] iArr3 = new int[i2];
        int[][] iArr4 = new int[i2][];
        System.arraycopy(iArrA, 0, iArr3, 0, i2);
        System.arraycopy(iArr, 0, iArr4, 0, i2);
        return new ColorStateList(iArr4, iArr3);
    }

    private static boolean f(Resources resources, int i) {
        TypedValue typedValueC = c();
        resources.getValue(i, typedValueC, true);
        int i2 = typedValueC.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static int g(int i, float f, float f2) {
        boolean z = f2 >= 0.0f && f2 <= 100.0f;
        if (f == 1.0f && !z) {
            return i;
        }
        int iB = eh1.b((int) ((Color.alpha(i) * f) + 0.5f), 0, 255);
        if (z) {
            jq jqVarC = jq.c(i);
            i = jq.m(jqVarC.j(), jqVarC.i(), f2);
        }
        return (i & 16777215) | (iB << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
