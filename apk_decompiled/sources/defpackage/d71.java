package defpackage;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes.dex */
public class d71 {
    private final ObjectNode a;

    public d71(ObjectNode objectNode) {
        this.a = objectNode;
    }

    public static JsonNode a() {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put(SocialConstants.PARAM_TYPE, "any");
        return objectNode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof d71)) {
            return false;
        }
        d71 d71Var = (d71) obj;
        ObjectNode objectNode = this.a;
        if (objectNode == null) {
            return d71Var.a == null;
        }
        return objectNode.equals(d71Var.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a.toString();
    }
}
