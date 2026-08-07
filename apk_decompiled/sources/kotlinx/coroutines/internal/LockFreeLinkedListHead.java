package kotlinx.coroutines.internal;

import defpackage.ar0;
import defpackage.p31;

/* JADX INFO: loaded from: classes4.dex */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final /* synthetic */ <T extends LockFreeLinkedListNode> void forEach(ar0 ar0Var) {
        Object next = getNext();
        p31.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !p31.a(nextNode, this); nextNode = nextNode.getNextNode()) {
            p31.k(3, "T");
            if (nextNode != null) {
                ar0Var.invoke(nextNode);
            }
        }
    }

    public final boolean isEmpty() {
        return getNext() == this;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean isRemoved() {
        return false;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    protected LockFreeLinkedListNode nextIfRemoved() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    /* JADX INFO: renamed from: remove, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ boolean mo148remove() {
        return ((Boolean) remove()).booleanValue();
    }

    public final void validate$kotlinx_coroutines_core() {
        Object next = getNext();
        p31.d(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = this;
        while (!p31.a(lockFreeLinkedListNode, this)) {
            LockFreeLinkedListNode nextNode = lockFreeLinkedListNode.getNextNode();
            lockFreeLinkedListNode.validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode2, nextNode);
            lockFreeLinkedListNode2 = lockFreeLinkedListNode;
            lockFreeLinkedListNode = nextNode;
        }
        Object next2 = getNext();
        p31.d(next2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        validateNode$kotlinx_coroutines_core(lockFreeLinkedListNode2, (LockFreeLinkedListNode) next2);
    }

    public final Void remove() {
        throw new IllegalStateException("head cannot be removed");
    }
}
