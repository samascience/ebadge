package com.baji.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.p31;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PagedResponse<T> implements Parcelable {
    public static final Parcelable.Creator<PagedResponse<?>> CREATOR = new Creator();
    private final int currentPage;
    private final boolean hasNextPage;
    private final boolean hasPreviousPage;
    private final List<T> items;
    private final int pageSize;
    private final int totalCount;
    private final int totalPages;

    public static final class Creator implements Parcelable.Creator<PagedResponse<?>> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PagedResponse<?> createFromParcel(Parcel parcel) {
            p31.f(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(parcel.readValue(PagedResponse.class.getClassLoader()));
            }
            return new PagedResponse<>(arrayList, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PagedResponse<?>[] newArray(int i) {
            return new PagedResponse[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PagedResponse(List<? extends T> list, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        p31.f(list, "items");
        this.items = list;
        this.totalCount = i;
        this.pageSize = i2;
        this.currentPage = i3;
        this.totalPages = i4;
        this.hasNextPage = z;
        this.hasPreviousPage = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PagedResponse copy$default(PagedResponse pagedResponse, List list, int i, int i2, int i3, int i4, boolean z, boolean z2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = pagedResponse.items;
        }
        if ((i5 & 2) != 0) {
            i = pagedResponse.totalCount;
        }
        int i6 = i;
        if ((i5 & 4) != 0) {
            i2 = pagedResponse.pageSize;
        }
        int i7 = i2;
        if ((i5 & 8) != 0) {
            i3 = pagedResponse.currentPage;
        }
        int i8 = i3;
        if ((i5 & 16) != 0) {
            i4 = pagedResponse.totalPages;
        }
        int i9 = i4;
        if ((i5 & 32) != 0) {
            z = pagedResponse.hasNextPage;
        }
        boolean z3 = z;
        if ((i5 & 64) != 0) {
            z2 = pagedResponse.hasPreviousPage;
        }
        return pagedResponse.copy(list, i6, i7, i8, i9, z3, z2);
    }

    public final List<T> component1() {
        return this.items;
    }

    public final int component2() {
        return this.totalCount;
    }

    public final int component3() {
        return this.pageSize;
    }

    public final int component4() {
        return this.currentPage;
    }

    public final int component5() {
        return this.totalPages;
    }

    public final boolean component6() {
        return this.hasNextPage;
    }

    public final boolean component7() {
        return this.hasPreviousPage;
    }

    public final PagedResponse<T> copy(List<? extends T> list, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        p31.f(list, "items");
        return new PagedResponse<>(list, i, i2, i3, i4, z, z2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PagedResponse)) {
            return false;
        }
        PagedResponse pagedResponse = (PagedResponse) obj;
        return p31.a(this.items, pagedResponse.items) && this.totalCount == pagedResponse.totalCount && this.pageSize == pagedResponse.pageSize && this.currentPage == pagedResponse.currentPage && this.totalPages == pagedResponse.totalPages && this.hasNextPage == pagedResponse.hasNextPage && this.hasPreviousPage == pagedResponse.hasPreviousPage;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final boolean getHasNextPage() {
        return this.hasNextPage;
    }

    public final boolean getHasPreviousPage() {
        return this.hasPreviousPage;
    }

    public final List<T> getItems() {
        return this.items;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final int getTotalPages() {
        return this.totalPages;
    }

    public int hashCode() {
        return (((((((((((this.items.hashCode() * 31) + Integer.hashCode(this.totalCount)) * 31) + Integer.hashCode(this.pageSize)) * 31) + Integer.hashCode(this.currentPage)) * 31) + Integer.hashCode(this.totalPages)) * 31) + Boolean.hashCode(this.hasNextPage)) * 31) + Boolean.hashCode(this.hasPreviousPage);
    }

    public String toString() {
        return "PagedResponse(items=" + this.items + ", totalCount=" + this.totalCount + ", pageSize=" + this.pageSize + ", currentPage=" + this.currentPage + ", totalPages=" + this.totalPages + ", hasNextPage=" + this.hasNextPage + ", hasPreviousPage=" + this.hasPreviousPage + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        p31.f(parcel, "dest");
        List<T> list = this.items;
        parcel.writeInt(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            parcel.writeValue(it.next());
        }
        parcel.writeInt(this.totalCount);
        parcel.writeInt(this.pageSize);
        parcel.writeInt(this.currentPage);
        parcel.writeInt(this.totalPages);
        parcel.writeInt(this.hasNextPage ? 1 : 0);
        parcel.writeInt(this.hasPreviousPage ? 1 : 0);
    }
}
