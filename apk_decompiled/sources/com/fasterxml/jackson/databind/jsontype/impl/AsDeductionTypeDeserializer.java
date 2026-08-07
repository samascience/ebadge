package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.introspect.g;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import defpackage.ay;
import defpackage.m63;
import defpackage.n63;
import defpackage.q33;
import java.io.IOException;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AsDeductionTypeDeserializer extends AsPropertyTypeDeserializer {
    private static final BitSet EMPTY_CLASS_FINGERPRINT = new BitSet(0);
    private static final long serialVersionUID = 1;
    private final Map<String, Integer> fieldBitIndex;
    private final Map<BitSet, String> subtypeFingerprints;

    public AsDeductionTypeDeserializer(JavaType javaType, n63 n63Var, JavaType javaType2, DeserializationConfig deserializationConfig, Collection<NamedType> collection) {
        super(javaType, n63Var, null, false, javaType2, null);
        this.fieldBitIndex = new HashMap();
        this.subtypeFingerprints = buildFingerprints(deserializationConfig, collection);
    }

    private static void prune(List<BitSet> list, int i) {
        Iterator<BitSet> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().get(i)) {
                it.remove();
            }
        }
    }

    protected Map<BitSet, String> buildFingerprints(DeserializationConfig deserializationConfig, Collection<NamedType> collection) {
        boolean zIsEnabled = deserializationConfig.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        HashMap map = new HashMap();
        int i = 0;
        for (NamedType namedType : collection) {
            List listO = deserializationConfig.introspect(deserializationConfig.getTypeFactory().constructType(namedType.getType())).o();
            BitSet bitSet = new BitSet(listO.size() + i);
            Iterator it = listO.iterator();
            while (it.hasNext()) {
                String name = ((g) it.next()).getName();
                if (zIsEnabled) {
                    name = name.toLowerCase();
                }
                Integer numValueOf = this.fieldBitIndex.get(name);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i);
                    this.fieldBitIndex.put(name, Integer.valueOf(i));
                    i++;
                }
                bitSet.set(numValueOf.intValue());
            }
            String str = (String) map.put(bitSet, namedType.getType().getName());
            if (str != null) {
                throw new IllegalStateException(String.format("Subtypes %s and %s have the same signature and cannot be uniquely deduced.", str, namedType.getType().getName()));
            }
        }
        return map;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer, com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, defpackage.m63
    public Object deserializeTypedFromObject(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String str;
        JsonToken jsonTokenD = jsonParser.D();
        if (jsonTokenD == JsonToken.START_OBJECT) {
            jsonTokenD = jsonParser.n1();
        } else if (jsonTokenD != JsonToken.FIELD_NAME) {
            return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, null, "Unexpected input");
        }
        if (jsonTokenD == JsonToken.END_OBJECT && (str = this.subtypeFingerprints.get(EMPTY_CLASS_FINGERPRINT)) != null) {
            return _deserializeTypedForId(jsonParser, deserializationContext, null, str);
        }
        LinkedList linkedList = new LinkedList(this.subtypeFingerprints.keySet());
        q33 q33VarBufferForInputBuffering = deserializationContext.bufferForInputBuffering(jsonParser);
        boolean zIsEnabled = deserializationContext.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (jsonTokenD == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            if (zIsEnabled) {
                strC = strC.toLowerCase();
            }
            q33VarBufferForInputBuffering.R1(jsonParser);
            Integer num = this.fieldBitIndex.get(strC);
            if (num != null) {
                prune(linkedList, num.intValue());
                if (linkedList.size() == 1) {
                    return _deserializeTypedForId(jsonParser, deserializationContext, q33VarBufferForInputBuffering, this.subtypeFingerprints.get(linkedList.get(0)));
                }
            }
            jsonTokenD = jsonParser.n1();
        }
        return _deserializeTypedUsingDefaultImpl(jsonParser, deserializationContext, q33VarBufferForInputBuffering, String.format("Cannot deduce unique subtype of %s (%d candidates match)", ay.G(this._baseType), Integer.valueOf(linkedList.size())));
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer, com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, com.fasterxml.jackson.databind.jsontype.impl.TypeDeserializerBase, defpackage.m63
    public m63 forProperty(BeanProperty beanProperty) {
        return beanProperty == this._property ? this : new AsDeductionTypeDeserializer(this, beanProperty);
    }

    public AsDeductionTypeDeserializer(AsDeductionTypeDeserializer asDeductionTypeDeserializer, BeanProperty beanProperty) {
        super(asDeductionTypeDeserializer, beanProperty);
        this.fieldBitIndex = asDeductionTypeDeserializer.fieldBitIndex;
        this.subtypeFingerprints = asDeductionTypeDeserializer.subtypeFingerprints;
    }
}
