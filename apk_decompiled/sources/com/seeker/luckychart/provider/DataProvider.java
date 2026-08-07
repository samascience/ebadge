package com.seeker.luckychart.provider;

/* JADX INFO: loaded from: classes.dex */
public interface DataProvider<Container> extends AxisProvider {
    void clear();

    boolean containDataContainer(Container container);

    Container[] getDataContainer();

    void setDataContainer(Container... containerArr);
}
