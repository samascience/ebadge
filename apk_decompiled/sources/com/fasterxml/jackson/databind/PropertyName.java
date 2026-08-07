package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.tencent.connect.common.Constants;
import defpackage.ay;
import defpackage.vm2;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class PropertyName implements Serializable {
    private static final String _NO_NAME = "";
    private static final String _USE_DEFAULT = "";
    private static final long serialVersionUID = 1;
    protected vm2 _encodedSimple;
    protected final String _namespace;
    protected final String _simpleName;
    public static final PropertyName USE_DEFAULT = new PropertyName(Constants.STR_EMPTY, null);
    public static final PropertyName NO_NAME = new PropertyName(new String(Constants.STR_EMPTY), null);

    public PropertyName(String str) {
        this(str, null);
    }

    public static PropertyName construct(String str) {
        return (str == null || str.isEmpty()) ? USE_DEFAULT : new PropertyName(InternCache.instance.intern(str), null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        PropertyName propertyName = (PropertyName) obj;
        String str = this._simpleName;
        if (str == null) {
            if (propertyName._simpleName != null) {
                return false;
            }
        } else if (!str.equals(propertyName._simpleName)) {
            return false;
        }
        String str2 = this._namespace;
        if (str2 == null) {
            return propertyName._namespace == null;
        }
        return str2.equals(propertyName._namespace);
    }

    public String getNamespace() {
        return this._namespace;
    }

    public String getSimpleName() {
        return this._simpleName;
    }

    public boolean hasNamespace() {
        return this._namespace != null;
    }

    public boolean hasSimpleName() {
        return !this._simpleName.isEmpty();
    }

    public int hashCode() {
        String str = this._namespace;
        return str == null ? this._simpleName.hashCode() : str.hashCode() ^ this._simpleName.hashCode();
    }

    public PropertyName internSimpleName() {
        String strIntern;
        return (this._simpleName.isEmpty() || (strIntern = InternCache.instance.intern(this._simpleName)) == this._simpleName) ? this : new PropertyName(strIntern, this._namespace);
    }

    public boolean isEmpty() {
        return this._namespace == null && this._simpleName.isEmpty();
    }

    protected Object readResolve() {
        String str;
        return (this._namespace == null && ((str = this._simpleName) == null || Constants.STR_EMPTY.equals(str))) ? USE_DEFAULT : this;
    }

    public vm2 simpleAsEncoded(MapperConfig<?> mapperConfig) {
        vm2 serializedString = this._encodedSimple;
        if (serializedString == null) {
            serializedString = mapperConfig == null ? new SerializedString(this._simpleName) : mapperConfig.compileString(this._simpleName);
            this._encodedSimple = serializedString;
        }
        return serializedString;
    }

    public String toString() {
        if (this._namespace == null) {
            return this._simpleName;
        }
        return "{" + this._namespace + "}" + this._simpleName;
    }

    public PropertyName withNamespace(String str) {
        if (str == null) {
            if (this._namespace == null) {
                return this;
            }
        } else if (str.equals(this._namespace)) {
            return this;
        }
        return new PropertyName(this._simpleName, str);
    }

    public PropertyName withSimpleName(String str) {
        if (str == null) {
            str = Constants.STR_EMPTY;
        }
        return str.equals(this._simpleName) ? this : new PropertyName(str, this._namespace);
    }

    public PropertyName(String str, String str2) {
        this._simpleName = ay.Z(str);
        this._namespace = str2;
    }

    public boolean hasSimpleName(String str) {
        return this._simpleName.equals(str);
    }

    public static PropertyName construct(String str, String str2) {
        if (str == null) {
            str = Constants.STR_EMPTY;
        }
        if (str2 == null && str.isEmpty()) {
            return USE_DEFAULT;
        }
        return new PropertyName(InternCache.instance.intern(str), str2);
    }
}
