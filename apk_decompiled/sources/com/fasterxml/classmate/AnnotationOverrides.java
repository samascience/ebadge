package com.fasterxml.classmate;

import com.fasterxml.classmate.util.ClassKey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotationOverrides implements Serializable {

    public static class StdImpl extends AnnotationOverrides {
        protected final HashMap<ClassKey, List<Class<?>>> _targetsToOverrides;

        public StdImpl(HashMap<ClassKey, List<Class<?>>> map) {
            this._targetsToOverrides = new HashMap<>(map);
        }

        @Override // com.fasterxml.classmate.AnnotationOverrides
        public List<Class<?>> mixInsFor(ClassKey classKey) {
            return this._targetsToOverrides.get(classKey);
        }
    }

    public static class a {
        protected final HashMap a = new HashMap();
    }

    public static a builder() {
        return new a();
    }

    public abstract List<Class<?>> mixInsFor(ClassKey classKey);

    public List<Class<?>> mixInsFor(Class<?> cls) {
        return mixInsFor(new ClassKey(cls));
    }
}
