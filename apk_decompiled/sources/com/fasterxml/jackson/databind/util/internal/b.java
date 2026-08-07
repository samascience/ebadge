package com.fasterxml.jackson.databind.util.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
final class b extends AbstractCollection implements Deque {
    com.fasterxml.jackson.databind.util.internal.a a;
    com.fasterxml.jackson.databind.util.internal.a b;

    class a extends c {
        a(com.fasterxml.jackson.databind.util.internal.a aVar) {
            super(aVar);
        }

        @Override // com.fasterxml.jackson.databind.util.internal.b.c
        com.fasterxml.jackson.databind.util.internal.a a() {
            return this.a.getNext();
        }
    }

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.b$b, reason: collision with other inner class name */
    class C0072b extends c {
        C0072b(com.fasterxml.jackson.databind.util.internal.a aVar) {
            super(aVar);
        }

        @Override // com.fasterxml.jackson.databind.util.internal.b.c
        com.fasterxml.jackson.databind.util.internal.a a() {
            return this.a.getPrevious();
        }
    }

    abstract class c implements Iterator {
        com.fasterxml.jackson.databind.util.internal.a a;

        c(com.fasterxml.jackson.databind.util.internal.a aVar) {
            this.a = aVar;
        }

        abstract com.fasterxml.jackson.databind.util.internal.a a();

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.fasterxml.jackson.databind.util.internal.a next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            com.fasterxml.jackson.databind.util.internal.a aVar = this.a;
            this.a = a();
            return aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    b() {
    }

    void A(com.fasterxml.jackson.databind.util.internal.a aVar) {
        com.fasterxml.jackson.databind.util.internal.a previous = aVar.getPrevious();
        com.fasterxml.jackson.databind.util.internal.a next = aVar.getNext();
        if (previous == null) {
            this.a = next;
        } else {
            previous.setNext(next);
            aVar.setPrevious(null);
        }
        if (next == null) {
            this.b = previous;
        } else {
            next.setPrevious(previous);
            aVar.setNext(null);
        }
    }

    com.fasterxml.jackson.databind.util.internal.a B() {
        com.fasterxml.jackson.databind.util.internal.a aVar = this.a;
        com.fasterxml.jackson.databind.util.internal.a next = aVar.getNext();
        aVar.setNext(null);
        this.a = next;
        if (next == null) {
            this.b = null;
        } else {
            next.setPrevious(null);
        }
        return aVar;
    }

    com.fasterxml.jackson.databind.util.internal.a C() {
        com.fasterxml.jackson.databind.util.internal.a aVar = this.b;
        com.fasterxml.jackson.databind.util.internal.a previous = aVar.getPrevious();
        aVar.setPrevious(null);
        this.b = previous;
        if (previous == null) {
            this.a = null;
        } else {
            previous.setNext(null);
        }
        return aVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(com.fasterxml.jackson.databind.util.internal.a aVar) {
        return offerLast(aVar);
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void addFirst(com.fasterxml.jackson.databind.util.internal.a aVar) {
        if (!offerFirst(aVar)) {
            throw new IllegalArgumentException();
        }
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void addLast(com.fasterxml.jackson.databind.util.internal.a aVar) {
        if (!offerLast(aVar)) {
            throw new IllegalArgumentException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        com.fasterxml.jackson.databind.util.internal.a aVar = this.a;
        while (aVar != null) {
            com.fasterxml.jackson.databind.util.internal.a next = aVar.getNext();
            aVar.setPrevious(null);
            aVar.setNext(null);
            aVar = next;
        }
        this.b = null;
        this.a = null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean contains(Object obj) {
        return (obj instanceof com.fasterxml.jackson.databind.util.internal.a) && e((com.fasterxml.jackson.databind.util.internal.a) obj);
    }

    void d() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.Deque
    public Iterator descendingIterator() {
        return new C0072b(this.b);
    }

    boolean e(com.fasterxml.jackson.databind.util.internal.a aVar) {
        return (aVar.getPrevious() == null && aVar.getNext() == null && aVar != this.a) ? false : true;
    }

    @Override // java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a element() {
        return getFirst();
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a getFirst() {
        d();
        return peekFirst();
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a getLast() {
        d();
        return peekLast();
    }

    void i(com.fasterxml.jackson.databind.util.internal.a aVar) {
        com.fasterxml.jackson.databind.util.internal.a aVar2 = this.a;
        this.a = aVar;
        if (aVar2 == null) {
            this.b = aVar;
        } else {
            aVar2.setPrevious(aVar);
            aVar.setNext(aVar2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a == null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Deque
    public Iterator iterator() {
        return new a(this.a);
    }

    void j(com.fasterxml.jackson.databind.util.internal.a aVar) {
        com.fasterxml.jackson.databind.util.internal.a aVar2 = this.b;
        this.b = aVar;
        if (aVar2 == null) {
            this.a = aVar;
        } else {
            aVar2.setNext(aVar);
            aVar.setPrevious(aVar2);
        }
    }

    public void k(com.fasterxml.jackson.databind.util.internal.a aVar) {
        if (aVar != this.b) {
            A(aVar);
            j(aVar);
        }
    }

    @Override // java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public boolean offer(com.fasterxml.jackson.databind.util.internal.a aVar) {
        return offerLast(aVar);
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public boolean offerFirst(com.fasterxml.jackson.databind.util.internal.a aVar) {
        if (e(aVar)) {
            return false;
        }
        i(aVar);
        return true;
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public boolean offerLast(com.fasterxml.jackson.databind.util.internal.a aVar) {
        if (e(aVar)) {
            return false;
        }
        j(aVar);
        return true;
    }

    @Override // java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a peek() {
        return peekFirst();
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a peekFirst() {
        return this.a;
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a peekLast() {
        return this.b;
    }

    @Override // java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a poll() {
        return pollFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        return remove(obj);
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a pollFirst() {
        if (isEmpty()) {
            return null;
        }
        return B();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public int size() {
        int i = 0;
        for (com.fasterxml.jackson.databind.util.internal.a next = this.a; next != null; next = next.getNext()) {
            i++;
        }
        return i;
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a pollLast() {
        if (isEmpty()) {
            return null;
        }
        return C();
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a pop() {
        return removeFirst();
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void push(com.fasterxml.jackson.databind.util.internal.a aVar) {
        addFirst(aVar);
    }

    @Override // java.util.Deque, java.util.Queue
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a remove() {
        return removeFirst();
    }

    boolean x(com.fasterxml.jackson.databind.util.internal.a aVar) {
        if (!e(aVar)) {
            return false;
        }
        A(aVar);
        return true;
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a removeFirst() {
        d();
        return pollFirst();
    }

    @Override // java.util.Deque
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.fasterxml.jackson.databind.util.internal.a removeLast() {
        d();
        return pollLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Deque
    public boolean remove(Object obj) {
        return (obj instanceof com.fasterxml.jackson.databind.util.internal.a) && x((com.fasterxml.jackson.databind.util.internal.a) obj);
    }
}
