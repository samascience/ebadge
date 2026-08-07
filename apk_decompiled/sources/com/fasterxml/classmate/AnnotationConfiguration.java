package com.fasterxml.classmate;

import com.fasterxml.classmate.util.ClassKey;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnnotationConfiguration implements Serializable {

    public static class StdConfiguration extends AnnotationConfiguration implements Serializable {
        protected final AnnotationInclusion _defaultInclusion;
        protected final HashMap<ClassKey, AnnotationInclusion> _inclusions = new HashMap<>();

        public StdConfiguration(AnnotationInclusion annotationInclusion) {
            this._defaultInclusion = annotationInclusion;
        }

        protected AnnotationInclusion _inclusionFor(Class<? extends Annotation> cls) {
            AnnotationInclusion annotationInclusion = this._inclusions.get(new ClassKey(cls));
            return annotationInclusion == null ? this._defaultInclusion : annotationInclusion;
        }

        @Override // com.fasterxml.classmate.AnnotationConfiguration
        public AnnotationInclusion getInclusionForClass(Class<? extends Annotation> cls) {
            return _inclusionFor(cls);
        }

        @Override // com.fasterxml.classmate.AnnotationConfiguration
        public AnnotationInclusion getInclusionForConstructor(Class<? extends Annotation> cls) {
            return _inclusionFor(cls);
        }

        @Override // com.fasterxml.classmate.AnnotationConfiguration
        public AnnotationInclusion getInclusionForField(Class<? extends Annotation> cls) {
            return getInclusionForClass(cls);
        }

        @Override // com.fasterxml.classmate.AnnotationConfiguration
        public AnnotationInclusion getInclusionForMethod(Class<? extends Annotation> cls) {
            return getInclusionForClass(cls);
        }

        @Override // com.fasterxml.classmate.AnnotationConfiguration
        public AnnotationInclusion getInclusionForParameter(Class<? extends Annotation> cls) {
            return getInclusionForClass(cls);
        }

        public void setInclusion(Class<? extends Annotation> cls, AnnotationInclusion annotationInclusion) {
            this._inclusions.put(new ClassKey(cls), annotationInclusion);
        }
    }

    public abstract AnnotationInclusion getInclusionForClass(Class<? extends Annotation> cls);

    public abstract AnnotationInclusion getInclusionForConstructor(Class<? extends Annotation> cls);

    public abstract AnnotationInclusion getInclusionForField(Class<? extends Annotation> cls);

    public abstract AnnotationInclusion getInclusionForMethod(Class<? extends Annotation> cls);

    public abstract AnnotationInclusion getInclusionForParameter(Class<? extends Annotation> cls);
}
