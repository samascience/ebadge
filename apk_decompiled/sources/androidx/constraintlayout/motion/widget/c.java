package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.g91;
import defpackage.h91;
import defpackage.y81;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class c {
    static HashMap b;
    private HashMap a = new HashMap();

    static {
        HashMap map = new HashMap();
        b = map;
        try {
            map.put("KeyAttribute", b.class.getConstructor(null));
            b.put("KeyPosition", d.class.getConstructor(null));
            b.put("KeyCycle", y81.class.getConstructor(null));
            b.put("KeyTimeCycle", g91.class.getConstructor(null));
            b.put("KeyTrigger", h91.class.getConstructor(null));
        } catch (NoSuchMethodException e) {
            Log.e("KeyFrames", "unable to load", e);
        }
    }

    public c() {
    }

    public void a(g gVar) {
        ArrayList arrayList = (ArrayList) this.a.get(-1);
        if (arrayList != null) {
            gVar.b(arrayList);
        }
    }

    public void b(g gVar) {
        ArrayList arrayList = (ArrayList) this.a.get(Integer.valueOf(gVar.c));
        if (arrayList != null) {
            gVar.b(arrayList);
        }
        ArrayList<a> arrayList2 = (ArrayList) this.a.get(-1);
        if (arrayList2 != null) {
            for (a aVar : arrayList2) {
                if (aVar.f(((ConstraintLayout.b) gVar.b.getLayoutParams()).c0)) {
                    gVar.a(aVar);
                }
            }
        }
    }

    public void c(a aVar) {
        if (!this.a.containsKey(Integer.valueOf(aVar.b))) {
            this.a.put(Integer.valueOf(aVar.b), new ArrayList());
        }
        ArrayList arrayList = (ArrayList) this.a.get(Integer.valueOf(aVar.b));
        if (arrayList != null) {
            arrayList.add(aVar);
        }
    }

    public ArrayList d(int i) {
        return (ArrayList) this.a.get(Integer.valueOf(i));
    }

    public c(Context context, XmlPullParser xmlPullParser) {
        Exception e;
        a aVar;
        HashMap map;
        HashMap map2;
        try {
            int eventType = xmlPullParser.getEventType();
            a aVar2 = null;
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlPullParser.getName();
                    if (b.containsKey(name)) {
                        try {
                            Constructor constructor = (Constructor) b.get(name);
                            if (constructor != null) {
                                aVar = (a) constructor.newInstance(null);
                                try {
                                    aVar.e(context, Xml.asAttributeSet(xmlPullParser));
                                    c(aVar);
                                } catch (Exception e2) {
                                    e = e2;
                                    Log.e("KeyFrames", "unable to create ", e);
                                }
                                aVar2 = aVar;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception e3) {
                            a aVar3 = aVar2;
                            e = e3;
                            aVar = aVar3;
                        }
                        Log.e("KeyFrames", "unable to create ", e);
                        aVar2 = aVar;
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (aVar2 != null && (map2 = aVar2.e) != null) {
                            ConstraintAttribute.h(context, xmlPullParser, map2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && aVar2 != null && (map = aVar2.e) != null) {
                        ConstraintAttribute.h(context, xmlPullParser, map);
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        }
    }
}
