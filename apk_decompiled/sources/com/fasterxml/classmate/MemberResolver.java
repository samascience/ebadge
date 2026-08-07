package com.fasterxml.classmate;

import com.fasterxml.classmate.util.ClassKey;
import defpackage.jn0;
import defpackage.og2;
import defpackage.vw0;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MemberResolver implements Serializable {
    protected boolean _cfgIncludeLangObject;
    protected jn0 _constructorFilter;
    protected jn0 _fieldFilter;
    protected jn0 _methodFilter;
    protected final TypeResolver _typeResolver;

    public MemberResolver(TypeResolver typeResolver) {
        this._typeResolver = typeResolver;
    }

    private void _addOverrides(List<vw0> list, Set<ClassKey> set, Class<?> cls) {
        ClassKey classKey = new ClassKey(cls);
        if (set.contains(classKey)) {
            return;
        }
        set.add(classKey);
        og2 og2VarResolve = this._typeResolver.resolve(cls, new Type[0]);
        list.add(new vw0(og2VarResolve, true, list.size()));
        Iterator it = og2VarResolve.i().iterator();
        while (it.hasNext()) {
            _addOverrides(list, set, (og2) it.next());
        }
        _addOverrides(list, set, og2VarResolve.j());
    }

    protected void _gatherTypes(og2 og2Var, Set<ClassKey> set, List<og2> list) {
        if (og2Var == null) {
            return;
        }
        Class clsG = og2Var.g();
        if (this._cfgIncludeLangObject || clsG != Object.class) {
            ClassKey classKey = new ClassKey(og2Var.g());
            if (set.contains(classKey)) {
                return;
            }
            set.add(classKey);
            list.add(og2Var);
            Iterator it = og2Var.i().iterator();
            while (it.hasNext()) {
                _gatherTypes((og2) it.next(), set, list);
            }
            _gatherTypes(og2Var.j(), set, list);
        }
    }

    public a resolve(og2 og2Var, AnnotationConfiguration annotationConfiguration, AnnotationOverrides annotationOverrides) {
        List<og2> arrayList;
        vw0[] vw0VarArr;
        vw0 vw0Var;
        new ArrayList();
        HashSet hashSet = new HashSet();
        if (this._cfgIncludeLangObject || og2Var.g() != Object.class) {
            arrayList = new ArrayList<>();
            _gatherTypes(og2Var, hashSet, arrayList);
        } else {
            arrayList = new ArrayList<>(1);
            arrayList.add(og2Var);
            hashSet.add(new ClassKey(Object.class));
        }
        if (annotationOverrides == null) {
            int size = arrayList.size();
            vw0[] vw0VarArr2 = new vw0[size];
            for (int i = 0; i < size; i++) {
                vw0VarArr2[i] = new vw0(arrayList.get(i), false, i);
            }
            vw0Var = vw0VarArr2[0];
            vw0VarArr = vw0VarArr2;
        } else {
            ArrayList arrayList2 = new ArrayList();
            vw0 vw0Var2 = null;
            for (og2 og2Var2 : arrayList) {
                List<Class<?>> listMixInsFor = annotationOverrides.mixInsFor((Class<?>) og2Var2.g());
                if (listMixInsFor != null) {
                    Iterator<Class<?>> it = listMixInsFor.iterator();
                    while (it.hasNext()) {
                        _addOverrides(arrayList2, hashSet, it.next());
                    }
                }
                vw0 vw0Var3 = new vw0(og2Var2, false, arrayList2.size());
                if (vw0Var2 == null) {
                    vw0Var2 = vw0Var3;
                }
                arrayList2.add(vw0Var3);
            }
            vw0VarArr = (vw0[]) arrayList2.toArray(new vw0[0]);
            vw0Var = vw0Var2;
        }
        return new a(this._typeResolver, annotationConfiguration, vw0Var, vw0VarArr, null, null, null);
    }

    public MemberResolver setConstructorFilter(jn0 jn0Var) {
        return this;
    }

    public MemberResolver setFieldFilter(jn0 jn0Var) {
        return this;
    }

    public MemberResolver setIncludeLangObject(boolean z) {
        this._cfgIncludeLangObject = z;
        return this;
    }

    public MemberResolver setMethodFilter(jn0 jn0Var) {
        return this;
    }

    private void _addOverrides(List<vw0> list, Set<ClassKey> set, og2 og2Var) {
        if (og2Var == null) {
            return;
        }
        Class clsG = og2Var.g();
        if (this._cfgIncludeLangObject || Object.class != clsG) {
            ClassKey classKey = new ClassKey(clsG);
            if (set.contains(classKey)) {
                return;
            }
            set.add(classKey);
            list.add(new vw0(og2Var, true, list.size()));
            Iterator it = og2Var.i().iterator();
            while (it.hasNext()) {
                _addOverrides(list, set, (og2) it.next());
            }
            og2 og2VarJ = og2Var.j();
            if (og2VarJ != null) {
                _addOverrides(list, set, og2VarJ);
            }
        }
    }
}
