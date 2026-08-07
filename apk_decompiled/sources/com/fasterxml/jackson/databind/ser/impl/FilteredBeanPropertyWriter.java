package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import defpackage.an2;
import defpackage.f71;
import defpackage.p61;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class FilteredBeanPropertyWriter {

    private static final class MultiView extends BeanPropertyWriter implements Serializable {
        private static final long serialVersionUID = 1;
        protected final BeanPropertyWriter _delegate;
        protected final Class<?>[] _views;

        protected MultiView(BeanPropertyWriter beanPropertyWriter, Class<?>[] clsArr) {
            super(beanPropertyWriter);
            this._delegate = beanPropertyWriter;
            this._views = clsArr;
        }

        private final boolean _inView(Class<?> cls) {
            if (cls == null) {
                return true;
            }
            int length = this._views.length;
            for (int i = 0; i < length; i++) {
                if (this._views[i].isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public void assignNullSerializer(f71 f71Var) {
            this._delegate.assignNullSerializer(f71Var);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public void assignSerializer(f71 f71Var) {
            this._delegate.assignSerializer(f71Var);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
        public void depositSchemaProperty(p61 p61Var, an2 an2Var) throws JsonMappingException {
            if (_inView(an2Var.getActiveView())) {
                super.depositSchemaProperty(p61Var, an2Var);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
        public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
            if (_inView(an2Var.getActiveView())) {
                this._delegate.serializeAsElement(obj, jsonGenerator, an2Var);
            } else {
                this._delegate.serializeAsPlaceholder(obj, jsonGenerator, an2Var);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
        public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
            if (_inView(an2Var.getActiveView())) {
                this._delegate.serializeAsField(obj, jsonGenerator, an2Var);
            } else {
                this._delegate.serializeAsOmittedField(obj, jsonGenerator, an2Var);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public MultiView rename(NameTransformer nameTransformer) {
            return new MultiView(this._delegate.rename(nameTransformer), this._views);
        }
    }

    private static final class SingleView extends BeanPropertyWriter implements Serializable {
        private static final long serialVersionUID = 1;
        protected final BeanPropertyWriter _delegate;
        protected final Class<?> _view;

        protected SingleView(BeanPropertyWriter beanPropertyWriter, Class<?> cls) {
            super(beanPropertyWriter);
            this._delegate = beanPropertyWriter;
            this._view = cls;
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public void assignNullSerializer(f71 f71Var) {
            this._delegate.assignNullSerializer(f71Var);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public void assignSerializer(f71 f71Var) {
            this._delegate.assignSerializer(f71Var);
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter, com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
        public void depositSchemaProperty(p61 p61Var, an2 an2Var) throws JsonMappingException {
            Class<?> activeView = an2Var.getActiveView();
            if (activeView == null || this._view.isAssignableFrom(activeView)) {
                super.depositSchemaProperty(p61Var, an2Var);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
        public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
            Class<?> activeView = an2Var.getActiveView();
            if (activeView == null || this._view.isAssignableFrom(activeView)) {
                this._delegate.serializeAsElement(obj, jsonGenerator, an2Var);
            } else {
                this._delegate.serializeAsPlaceholder(obj, jsonGenerator, an2Var);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter, com.fasterxml.jackson.databind.ser.PropertyWriter
        public void serializeAsField(Object obj, JsonGenerator jsonGenerator, an2 an2Var) throws Exception {
            Class<?> activeView = an2Var.getActiveView();
            if (activeView == null || this._view.isAssignableFrom(activeView)) {
                this._delegate.serializeAsField(obj, jsonGenerator, an2Var);
            } else {
                this._delegate.serializeAsOmittedField(obj, jsonGenerator, an2Var);
            }
        }

        @Override // com.fasterxml.jackson.databind.ser.BeanPropertyWriter
        public SingleView rename(NameTransformer nameTransformer) {
            return new SingleView(this._delegate.rename(nameTransformer), this._view);
        }
    }

    public static BeanPropertyWriter a(BeanPropertyWriter beanPropertyWriter, Class[] clsArr) {
        return clsArr.length == 1 ? new SingleView(beanPropertyWriter, clsArr[0]) : new MultiView(beanPropertyWriter, clsArr);
    }
}
