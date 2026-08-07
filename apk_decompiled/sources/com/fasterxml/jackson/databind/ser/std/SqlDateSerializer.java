package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import defpackage.an2;
import defpackage.e41;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;

/* JADX INFO: loaded from: classes.dex */
@e41
public class SqlDateSerializer extends DateTimeSerializerBase<Date> {
    public SqlDateSerializer() {
        this(null, null);
    }

    protected SqlDateSerializer(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    public long _timestamp(Date date) {
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, defpackage.f71
    public void serialize(Date date, JsonGenerator jsonGenerator, an2 an2Var) throws IOException {
        if (_asTimestamp(an2Var)) {
            jsonGenerator.a1(_timestamp(date));
        } else if (this._customFormat == null) {
            jsonGenerator.w1(date.toString());
        } else {
            _serializeAsString(date, jsonGenerator, an2Var);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase
    /* JADX INFO: renamed from: withFormat, reason: avoid collision after fix types in other method */
    public DateTimeSerializerBase<Date> withFormat2(Boolean bool, DateFormat dateFormat) {
        return new SqlDateSerializer(bool, dateFormat);
    }
}
