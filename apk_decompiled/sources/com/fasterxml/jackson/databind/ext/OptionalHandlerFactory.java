package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import defpackage.ay;
import defpackage.bn2;
import defpackage.f41;
import defpackage.f71;
import defpackage.kh;
import defpackage.q90;
import defpackage.s51;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes.dex */
public class OptionalHandlerFactory implements Serializable {
    private static final String CLS_NAME_JAVA_SQL_BLOB = "java.sql.Blob";
    private static final String CLS_NAME_JAVA_SQL_DATE = "java.sql.Date";
    private static final String CLS_NAME_JAVA_SQL_SERIALBLOB = "javax.sql.rowset.serial.SerialBlob";
    private static final String CLS_NAME_JAVA_SQL_TIME = "java.sql.Time";
    private static final String CLS_NAME_JAVA_SQL_TIMESTAMP = "java.sql.Timestamp";
    private static final String DESERIALIZERS_FOR_JAVAX_XML = "com.fasterxml.jackson.databind.ext.CoreXMLDeserializers";
    private static final String DESERIALIZER_FOR_DOM_DOCUMENT = "com.fasterxml.jackson.databind.ext.DOMDeserializer$DocumentDeserializer";
    private static final String DESERIALIZER_FOR_DOM_NODE = "com.fasterxml.jackson.databind.ext.DOMDeserializer$NodeDeserializer";
    private static final String PACKAGE_PREFIX_JAVAX_XML = "javax.xml.";
    private static final String SERIALIZERS_FOR_JAVAX_XML = "com.fasterxml.jackson.databind.ext.CoreXMLSerializers";
    private static final String SERIALIZER_FOR_DOM_NODE = "com.fasterxml.jackson.databind.ext.DOMSerializer";
    private static final f41 _jdk7Helper = null;
    public static final OptionalHandlerFactory instance;
    private static final long serialVersionUID = 1;
    private final Map<String, String> _sqlDeserializers;
    private final Map<String, Object> _sqlSerializers;
    private static final Class<?> CLASS_DOM_NODE = Node.class;
    private static final Class<?> CLASS_DOM_DOCUMENT = Document.class;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        try {
            f41.a();
        } catch (Throwable unused) {
        }
        instance = new OptionalHandlerFactory();
    }

    protected OptionalHandlerFactory() {
        HashMap map = new HashMap();
        this._sqlDeserializers = map;
        map.put(CLS_NAME_JAVA_SQL_DATE, "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put(CLS_NAME_JAVA_SQL_TIMESTAMP, "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this._sqlSerializers = map2;
        map2.put(CLS_NAME_JAVA_SQL_TIMESTAMP, DateSerializer.instance);
        map2.put(CLS_NAME_JAVA_SQL_DATE, "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put(CLS_NAME_JAVA_SQL_TIME, "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put(CLS_NAME_JAVA_SQL_BLOB, "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put(CLS_NAME_JAVA_SQL_SERIALBLOB, "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    private boolean _IsXOfY(Class<?> cls, Class<?> cls2) {
        return cls2 != null && cls2.isAssignableFrom(cls);
    }

    private boolean hasSuperClassStartingWith(Class<?> cls, String str) {
        do {
            cls = cls.getSuperclass();
            if (cls == null || cls == Object.class) {
                return false;
            }
        } while (!cls.getName().startsWith(str));
        return true;
    }

    private Object instantiate(String str, JavaType javaType) {
        try {
            return instantiate(Class.forName(str), javaType);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to find class `" + str + "` for handling values of type " + ay.G(javaType) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    public s51 findDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, kh khVar) throws JsonMappingException {
        Object objInstantiate;
        Class<?> rawClass = javaType.getRawClass();
        if (_IsXOfY(rawClass, CLASS_DOM_NODE)) {
            return (s51) instantiate(DESERIALIZER_FOR_DOM_NODE, javaType);
        }
        if (_IsXOfY(rawClass, CLASS_DOM_DOCUMENT)) {
            return (s51) instantiate(DESERIALIZER_FOR_DOM_DOCUMENT, javaType);
        }
        String name = rawClass.getName();
        String str = this._sqlDeserializers.get(name);
        if (str != null) {
            return (s51) instantiate(str, javaType);
        }
        if ((name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSuperClassStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) && (objInstantiate = instantiate(DESERIALIZERS_FOR_JAVAX_XML, javaType)) != null) {
            return ((q90) objInstantiate).findBeanDeserializer(javaType, deserializationConfig, khVar);
        }
        return null;
    }

    public f71 findSerializer(SerializationConfig serializationConfig, JavaType javaType, kh khVar) {
        Object objInstantiate;
        Class<?> rawClass = javaType.getRawClass();
        if (_IsXOfY(rawClass, CLASS_DOM_NODE)) {
            return (f71) instantiate(SERIALIZER_FOR_DOM_NODE, javaType);
        }
        String name = rawClass.getName();
        Object obj = this._sqlSerializers.get(name);
        if (obj != null) {
            return obj instanceof f71 ? (f71) obj : (f71) instantiate((String) obj, javaType);
        }
        if ((name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSuperClassStartingWith(rawClass, PACKAGE_PREFIX_JAVAX_XML)) && (objInstantiate = instantiate(SERIALIZERS_FOR_JAVAX_XML, javaType)) != null) {
            return ((bn2) objInstantiate).findSerializer(serializationConfig, javaType, khVar);
        }
        return null;
    }

    public boolean hasDeserializerFor(Class<?> cls) {
        if (_IsXOfY(cls, CLASS_DOM_NODE) || _IsXOfY(cls, CLASS_DOM_DOCUMENT)) {
            return true;
        }
        String name = cls.getName();
        if (name.startsWith(PACKAGE_PREFIX_JAVAX_XML) || hasSuperClassStartingWith(cls, PACKAGE_PREFIX_JAVAX_XML)) {
            return true;
        }
        return this._sqlDeserializers.containsKey(name);
    }

    private Object instantiate(Class<?> cls, JavaType javaType) {
        try {
            return ay.l(cls, false);
        } catch (Throwable th) {
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + ay.G(javaType) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }
}
