package com.seeker.luckychart.provider;

import com.seeker.luckychart.render.inters.LuckyAxesRenderer;
import com.seeker.luckychart.render.inters.LuckyDataRenderer;
import org.rajawali3d.renderer.Renderer;

/* JADX INFO: loaded from: classes.dex */
public interface RenderProvider extends GestureProvider {
    LuckyAxesRenderer getChartAxesRenderer();

    LuckyDataRenderer getChartDataRenderer();

    Renderer getChartGlRenderer();
}
