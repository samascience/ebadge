package defpackage;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

/* JADX INFO: loaded from: classes.dex */
public abstract class l10 {
    protected JsonFormat.Value _format;
    protected JsonIgnoreProperties.Value _ignorals;
    protected JsonInclude.Value _include;
    protected JsonInclude.Value _includeAsProperty;
    protected Boolean _isIgnoredType;
    protected Boolean _mergeable;
    protected JsonSetter.Value _setterInfo;
    protected JsonAutoDetect.Value _visibility;

    static final class a extends l10 {
        static final a a = new a();

        private a() {
        }
    }

    protected l10() {
    }

    public static l10 empty() {
        return a.a;
    }

    public JsonFormat.Value getFormat() {
        return this._format;
    }

    public JsonIgnoreProperties.Value getIgnorals() {
        return this._ignorals;
    }

    public JsonInclude.Value getInclude() {
        return this._include;
    }

    public JsonInclude.Value getIncludeAsProperty() {
        return this._includeAsProperty;
    }

    public Boolean getIsIgnoredType() {
        return this._isIgnoredType;
    }

    public Boolean getMergeable() {
        return this._mergeable;
    }

    public JsonSetter.Value getSetterInfo() {
        return this._setterInfo;
    }

    public JsonAutoDetect.Value getVisibility() {
        return this._visibility;
    }

    protected l10(l10 l10Var) {
        this._format = l10Var._format;
        this._include = l10Var._include;
        this._includeAsProperty = l10Var._includeAsProperty;
        this._ignorals = l10Var._ignorals;
        this._setterInfo = l10Var._setterInfo;
        this._visibility = l10Var._visibility;
        this._isIgnoredType = l10Var._isIgnoredType;
        this._mergeable = l10Var._mergeable;
    }
}
