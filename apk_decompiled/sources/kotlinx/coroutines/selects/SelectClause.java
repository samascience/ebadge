package kotlinx.coroutines.selects;

import defpackage.pr0;
import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes4.dex */
@InternalCoroutinesApi
public interface SelectClause {
    Object getClauseObject();

    pr0 getOnCancellationConstructor();

    pr0 getProcessResFunc();

    pr0 getRegFunc();
}
