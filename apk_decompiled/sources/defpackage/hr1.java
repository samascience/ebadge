package defpackage;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
abstract class hr1 extends h71 {
    protected final hr1 c;
    protected String d;
    protected Object e;

    protected static final class a extends hr1 {
        protected Iterator f;
        protected JsonNode g;

        public a(JsonNode jsonNode, hr1 hr1Var) {
            super(1, hr1Var);
            this.f = jsonNode.elements();
        }

        @Override // defpackage.h71
        public /* bridge */ /* synthetic */ h71 e() {
            return super.o();
        }

        @Override // defpackage.hr1
        public JsonNode n() {
            return this.g;
        }

        @Override // defpackage.hr1
        public JsonToken p() {
            if (!this.f.hasNext()) {
                this.g = null;
                return JsonToken.END_ARRAY;
            }
            this.b++;
            JsonNode jsonNode = (JsonNode) this.f.next();
            this.g = jsonNode;
            return jsonNode.asToken();
        }

        @Override // defpackage.hr1
        public hr1 q() {
            return new a(this.g, this);
        }

        @Override // defpackage.hr1
        public hr1 r() {
            return new b(this.g, this);
        }
    }

    protected static final class b extends hr1 {
        protected Iterator f;
        protected Map.Entry g;
        protected boolean h;

        public b(JsonNode jsonNode, hr1 hr1Var) {
            super(2, hr1Var);
            this.f = jsonNode.fields();
            this.h = true;
        }

        @Override // defpackage.h71
        public /* bridge */ /* synthetic */ h71 e() {
            return super.o();
        }

        @Override // defpackage.hr1
        public JsonNode n() {
            Map.Entry entry = this.g;
            if (entry == null) {
                return null;
            }
            return (JsonNode) entry.getValue();
        }

        @Override // defpackage.hr1
        public JsonToken p() {
            if (!this.h) {
                this.h = true;
                return ((JsonNode) this.g.getValue()).asToken();
            }
            if (!this.f.hasNext()) {
                this.d = null;
                this.g = null;
                return JsonToken.END_OBJECT;
            }
            this.b++;
            this.h = false;
            Map.Entry entry = (Map.Entry) this.f.next();
            this.g = entry;
            this.d = entry != null ? (String) entry.getKey() : null;
            return JsonToken.FIELD_NAME;
        }

        @Override // defpackage.hr1
        public hr1 q() {
            return new a(n(), this);
        }

        @Override // defpackage.hr1
        public hr1 r() {
            return new b(n(), this);
        }
    }

    protected static final class c extends hr1 {
        protected JsonNode f;
        protected boolean g;

        public c(JsonNode jsonNode, hr1 hr1Var) {
            super(0, hr1Var);
            this.g = false;
            this.f = jsonNode;
        }

        @Override // defpackage.h71
        public /* bridge */ /* synthetic */ h71 e() {
            return super.o();
        }

        @Override // defpackage.hr1
        public JsonNode n() {
            if (this.g) {
                return this.f;
            }
            return null;
        }

        @Override // defpackage.hr1
        public JsonToken p() {
            if (this.g) {
                this.f = null;
                return null;
            }
            this.b++;
            this.g = true;
            return this.f.asToken();
        }

        @Override // defpackage.hr1
        public hr1 q() {
            return new a(this.f, this);
        }

        @Override // defpackage.hr1
        public hr1 r() {
            return new b(this.f, this);
        }
    }

    public hr1(int i, hr1 hr1Var) {
        this.a = i;
        this.b = -1;
        this.c = hr1Var;
    }

    @Override // defpackage.h71
    public final String b() {
        return this.d;
    }

    @Override // defpackage.h71
    public Object c() {
        return this.e;
    }

    @Override // defpackage.h71
    public void l(Object obj) {
        this.e = obj;
    }

    public abstract JsonNode n();

    public final hr1 o() {
        return this.c;
    }

    public abstract JsonToken p();

    public abstract hr1 q();

    public abstract hr1 r();
}
