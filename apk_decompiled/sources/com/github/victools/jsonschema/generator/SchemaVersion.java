package com.github.victools.jsonschema.generator;

/* JADX INFO: loaded from: classes.dex */
public enum SchemaVersion {
    DRAFT_6("http://json-schema.org/draft-06/schema#"),
    DRAFT_7("http://json-schema.org/draft-07/schema#"),
    DRAFT_2019_09("https://json-schema.org/draft/2019-09/schema"),
    DRAFT_2020_12("https://json-schema.org/draft/2020-12/schema");

    private final String identifier;

    SchemaVersion(String str) {
        this.identifier = str;
    }

    public String getIdentifier() {
        return this.identifier;
    }
}
