package com.tenmeter.smlibrary.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.a;
import com.bumptech.glide.e;
import com.tenmeter.smlibrary.R;
import com.tenmeter.smlibrary.activity.SMVipGameListActivity;
import com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter;
import com.tenmeter.smlibrary.adapter.GameListBannerNAdapter;
import com.tenmeter.smlibrary.adapter.GameListTypeAdapter;
import com.tenmeter.smlibrary.adapter.HotListAdapter;
import com.tenmeter.smlibrary.adapter.IconListAdapter;
import com.tenmeter.smlibrary.banner.Banner;
import com.tenmeter.smlibrary.banner.adapter.BannerRoundImageAdapter;
import com.tenmeter.smlibrary.banner.holder.BannerImageHolder;
import com.tenmeter.smlibrary.banner.indicator.CircleIndicator;
import com.tenmeter.smlibrary.banner.listener.OnBannerListener;
import com.tenmeter.smlibrary.entity.SMADBean;
import com.tenmeter.smlibrary.entity.SMGameInfo;
import com.tenmeter.smlibrary.entity.SMGameListBannerParent;
import com.tenmeter.smlibrary.entity.SMGameListParent;
import com.tenmeter.smlibrary.entity.SMIconListParent;
import com.tenmeter.smlibrary.listener.Consumer;
import com.tenmeter.smlibrary.listener.IADCallback;
import com.tenmeter.smlibrary.listener.IGameListBannerCallback;
import com.tenmeter.smlibrary.listener.IGameListForTypeCallback;
import com.tenmeter.smlibrary.listener.IGameOpenListener;
import com.tenmeter.smlibrary.listener.IIconCallback;
import com.tenmeter.smlibrary.utils.DisplayUtil;
import com.tenmeter.smlibrary.utils.SGlideRequestListener;
import com.tenmeter.smlibrary.utils.SMGameClient;
import com.tenmeter.smlibrary.widget.LoadDia;
import com.tenmeter.smlibrary.widget.decoration.GridSpaceItemDecoration;
import defpackage.ac0;
import defpackage.q30;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GameListFragment extends Fragment {
    private SMGameListParent leisureGameDatas;
    private Banner mAdBanner;
    private TextView mAdTitle;
    private Banner mBannerN;
    private RecyclerView mGameRv;
    private HotListAdapter mHotAdapter;
    private LinearLayout mHotGameContainer;
    private TextView mHotName;
    private RecyclerView mHotRv;
    private IconListAdapter mIconAdapter;
    private RecyclerView mIconRv;
    private Banner mLeisureBanner;
    private LinearLayout mLeisureGameContainer;
    private TextView mLeisureMore;
    private TextView mLeisureName;
    private LoadDia mLoadDia;
    private GameListTypeAdapter mTypeAdapter;

    /* JADX INFO: renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$6, reason: invalid class name */
    class AnonymousClass6 implements IGameListBannerCallback {
        AnonymousClass6() {
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListBannerCallback
        public void onError(final String str) {
            GameListFragment.this.hideLoading();
            GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.6.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(GameListFragment.this.requireActivity(), str, 1).show();
                    GameListFragment.this.mBannerN.setVisibility(8);
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IGameListBannerCallback
        public void onSuccessFul(final List<SMGameListBannerParent> list) {
            GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.6.1
                @Override // java.lang.Runnable
                public void run() {
                    GameListFragment.this.hideLoading();
                    if (list.size() <= 0) {
                        GameListFragment.this.mBannerN.setVisibility(8);
                        return;
                    }
                    GameListFragment.this.mBannerN.setVisibility(0);
                    GameListFragment.this.mBannerN.setAdapter(new GameListBannerNAdapter(GameListFragment.this.requireActivity(), new GameListBannerNAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.6.1.1
                        @Override // com.tenmeter.smlibrary.adapter.GameListBannerNAdapter.IGameListItemClick
                        public void itemClick(SMGameInfo sMGameInfo) {
                            GameListFragment.this.gameClick(sMGameInfo);
                        }
                    }, list)).setBannerGalleryEffect(0, 22, 0, 1.0f);
                    if (list.size() > 1) {
                        GameListFragment.this.mBannerN.setIndicator(new CircleIndicator(GameListFragment.this.requireActivity()));
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.tenmeter.smlibrary.fragment.GameListFragment$9, reason: invalid class name */
    class AnonymousClass9 implements IADCallback {
        AnonymousClass9() {
        }

        @Override // com.tenmeter.smlibrary.listener.IADCallback
        public void onError(final String str) {
            GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.9.2
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(GameListFragment.this.requireActivity(), str, 1).show();
                }
            });
        }

        @Override // com.tenmeter.smlibrary.listener.IADCallback
        public void onSuccessFul(final List<SMADBean> list) {
            GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.9.1
                @Override // java.lang.Runnable
                public void run() {
                    List list2 = list;
                    if (list2 == null || list2.size() <= 0) {
                        GameListFragment.this.mAdTitle.setVisibility(8);
                        GameListFragment.this.mAdBanner.setVisibility(8);
                        return;
                    }
                    GameListFragment.this.mAdTitle.setVisibility(0);
                    GameListFragment.this.mAdBanner.setVisibility(0);
                    GameListFragment.this.mAdTitle.setText(((SMADBean) list.get(0)).getAdName());
                    GameListFragment.this.mAdBanner.setAdapter(new BannerRoundImageAdapter<SMADBean>(list) { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.9.1.2
                        @Override // com.tenmeter.smlibrary.banner.holder.IViewHolder
                        public void onBindView(BannerImageHolder bannerImageHolder, SMADBean sMADBean, int i, int i2) {
                            e eVarR = a.v(GameListFragment.this.requireActivity()).r(sMADBean.getAdUrl());
                            FragmentActivity fragmentActivityRequireActivity = GameListFragment.this.requireActivity();
                            int i3 = R.drawable.default_game;
                            e eVar = (e) ((e) eVarR.V(q30.e(fragmentActivityRequireActivity, i3))).i(q30.e(GameListFragment.this.requireActivity(), i3));
                            ImageView imageView = bannerImageHolder.imageView;
                            ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER_CROP;
                            ((e) eVar.w0(new SGlideRequestListener(imageView, scaleType, scaleType)).f(ac0.d)).u0(bannerImageHolder.imageView);
                        }
                    }).setOnBannerListener(new OnBannerListener<SMADBean>() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.9.1.1
                        @Override // com.tenmeter.smlibrary.banner.listener.OnBannerListener
                        public void OnBannerClick(SMADBean sMADBean, int i) {
                            if (sMADBean.getRedirectType() == 1) {
                                GameListFragment.this.gameClick(sMADBean.getGame());
                                return;
                            }
                            if (sMADBean.getRedirectType() == 2) {
                                SMGameClient.getInstance().startGameListSub(sMADBean.getTag(), GameListFragment.this.requireActivity());
                                return;
                            }
                            if (sMADBean.getRedirectType() != 3 || sMADBean.getIcon() == null) {
                                return;
                            }
                            if (sMADBean.getIcon().getIconPage() == 2) {
                                GameListFragment.this.jumpToVip(sMADBean.getIcon());
                                return;
                            }
                            SMGameListParent sMGameListParent = new SMGameListParent();
                            sMGameListParent.setGameList(sMADBean.getIcon().getGameList());
                            sMGameListParent.setTagId(sMADBean.getIcon().getIconId());
                            sMGameListParent.setTagName(sMADBean.getIcon().getIconName());
                            SMGameClient.getInstance().startGameListSub(sMGameListParent, GameListFragment.this.requireActivity());
                        }
                    });
                    if (list.size() > 1) {
                        GameListFragment.this.mAdBanner.setIndicator(new CircleIndicator(GameListFragment.this.requireActivity()));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gameClick(SMGameInfo sMGameInfo) {
        if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
            SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(requireActivity(), sMGameInfo);
        } else {
            showLoading();
            SMGameClient.getInstance().startGame(sMGameInfo, requireActivity(), new IGameOpenListener() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.10
                @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                public void openResult(boolean z) {
                    GameListFragment.this.hideLoading();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGameTypeData() {
        SMGameClient.getInstance().getGameBannerList(new AnonymousClass6());
        SMGameClient.getInstance().getIconLists(new IIconCallback() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.7
            @Override // com.tenmeter.smlibrary.listener.IIconCallback
            public void onError(final String str) {
                GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(GameListFragment.this.requireActivity(), str, 1).show();
                    }
                });
            }

            @Override // com.tenmeter.smlibrary.listener.IIconCallback
            public void onSuccessFul(final List<SMIconListParent> list) {
                GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GameListFragment.this.mIconAdapter.setData(list);
                    }
                });
            }
        });
        SMGameClient.getInstance().getTypeGameList(new IGameListForTypeCallback() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.8
            @Override // com.tenmeter.smlibrary.listener.IGameListForTypeCallback
            public void onError(final String str) {
                GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(GameListFragment.this.requireActivity(), str, 1).show();
                    }
                });
            }

            @Override // com.tenmeter.smlibrary.listener.IGameListForTypeCallback
            public void onSuccessFul(final List<SMGameListParent> list) {
                GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (list != null) {
                            ArrayList arrayList = new ArrayList();
                            for (SMGameListParent sMGameListParent : list) {
                                if (sMGameListParent.getTagId() == 4) {
                                    GameListFragment.this.mHotName.setText(sMGameListParent.getTagName());
                                    GameListFragment.this.mHotGameContainer.setVisibility(sMGameListParent.getGameList().size() > 0 ? 0 : 8);
                                    GameListFragment.this.mHotAdapter.setData(sMGameListParent.getGameList());
                                } else if (sMGameListParent.getTagId() == 2) {
                                    GameListFragment.this.leisureGameDatas = sMGameListParent;
                                    GameListFragment.this.mLeisureName.setText(sMGameListParent.getTagName());
                                    GameListFragment.this.mLeisureMore.setText(SMGameClient.getInstance().isChina() ? "更多" : "More");
                                    GameListFragment.this.mLeisureGameContainer.setVisibility(sMGameListParent.getGameList().size() > 0 ? 0 : 8);
                                    GameListFragment.this.processLeisureGame(sMGameListParent);
                                } else {
                                    arrayList.add(sMGameListParent);
                                }
                            }
                            GameListFragment.this.mTypeAdapter.setData(arrayList);
                        }
                    }
                });
            }
        });
        SMGameClient.getInstance().getAD(new AnonymousClass9());
    }

    private void initData() {
        showLoading();
        if (SMGameClient.baseUrl.isEmpty()) {
            SMGameClient.getInstance().gamePrivate(new Consumer<Boolean>() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.5
                @Override // com.tenmeter.smlibrary.listener.Consumer
                public void accept(Boolean bool) {
                    if (bool.booleanValue()) {
                        GameListFragment.this.getGameTypeData();
                    } else {
                        GameListFragment.this.requireActivity().runOnUiThread(new Runnable() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                GameListFragment.this.hideLoading();
                                Toast.makeText(GameListFragment.this.getActivity(), "data error", 1).show();
                            }
                        });
                    }
                }
            });
        } else {
            getGameTypeData();
        }
    }

    private void initView(View view) {
        this.mAdBanner = (Banner) view.findViewById(R.id.ad_banner);
        this.mLeisureMore = (TextView) view.findViewById(R.id.tv_leisure_more);
        this.mLeisureName = (TextView) view.findViewById(R.id.tv_leisure_name);
        this.mHotName = (TextView) view.findViewById(R.id.tv_hot_title);
        this.mHotGameContainer = (LinearLayout) view.findViewById(R.id.ll_hot_container);
        this.mLeisureGameContainer = (LinearLayout) view.findViewById(R.id.ll_leisure_container);
        this.mBannerN = (Banner) view.findViewById(R.id.banner);
        this.mLeisureBanner = (Banner) view.findViewById(R.id.leisure_game_banner);
        this.mGameRv = (RecyclerView) view.findViewById(R.id.rv_game_list);
        this.mIconRv = (RecyclerView) view.findViewById(R.id.rv_icon_list);
        this.mHotRv = (RecyclerView) view.findViewById(R.id.rv_hot_list);
        this.mAdTitle = (TextView) view.findViewById(R.id.tv_ad_title);
        ((TextView) view.findViewById(R.id.rv_hot_sub_title)).setText(SMGameClient.getInstance().isChina() ? "向左滑动查看更多" : "Swipe left for more");
        this.mGameRv.setHasFixedSize(true);
        this.mGameRv.setNestedScrollingEnabled(false);
        this.mIconRv.setLayoutManager(new GridLayoutManager(requireActivity(), 4));
        this.mIconRv.addItemDecoration(new GridSpaceItemDecoration(4));
        this.mHotRv.setLayoutManager(new LinearLayoutManager(requireActivity(), 0, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToVip(SMIconListParent sMIconListParent) {
        Intent intent = new Intent(requireActivity(), (Class<?>) SMVipGameListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("game", sMIconListParent);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLeisureGame(SMGameListParent sMGameListParent) {
        ArrayList arrayList = new ArrayList();
        if (sMGameListParent.getGameList().size() > 9) {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, 6));
            arrayList.add(sMGameListParent.getGameList().subList(6, 9));
        } else if (sMGameListParent.getGameList().size() <= 3) {
            arrayList.add(sMGameListParent.getGameList());
        } else if (sMGameListParent.getGameList().size() > 6) {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, 6));
            arrayList.add(sMGameListParent.getGameList().subList(6, sMGameListParent.getGameList().size() - 1));
        } else {
            arrayList.add(sMGameListParent.getGameList().subList(0, 3));
            arrayList.add(sMGameListParent.getGameList().subList(3, sMGameListParent.getGameList().size() - 1));
        }
        this.mLeisureBanner.setAdapter(new GameLeisureListBannerAdapter(requireActivity(), new GameLeisureListBannerAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.11
            @Override // com.tenmeter.smlibrary.adapter.GameLeisureListBannerAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                if (SMGameClient.getInstance().getGameListItemClickListener() != null) {
                    SMGameClient.getInstance().getGameListItemClickListener().gameItemClick(GameListFragment.this.requireActivity(), sMGameInfo);
                } else {
                    GameListFragment.this.showLoading();
                    SMGameClient.getInstance().startGame(sMGameInfo, GameListFragment.this.requireActivity(), new IGameOpenListener() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.11.1
                        @Override // com.tenmeter.smlibrary.listener.IGameOpenListener
                        public void openResult(boolean z) {
                            GameListFragment.this.hideLoading();
                        }
                    });
                }
            }
        }, arrayList)).setBannerGalleryEffect(0, 23, 0, 1.0f);
    }

    private void registerListener() {
        this.mGameRv.setLayoutManager(new LinearLayoutManager(requireActivity()));
        IconListAdapter iconListAdapter = new IconListAdapter(requireActivity(), new ArrayList(), new IconListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.1
            @Override // com.tenmeter.smlibrary.adapter.IconListAdapter.IGameListItemClick
            public void itemClick(SMIconListParent sMIconListParent) {
                if (sMIconListParent.getIconPage() == 2) {
                    GameListFragment.this.jumpToVip(sMIconListParent);
                    return;
                }
                SMGameListParent sMGameListParent = new SMGameListParent();
                sMGameListParent.setGameList(sMIconListParent.getGameList());
                sMGameListParent.setTagId(sMIconListParent.getIconId());
                sMGameListParent.setTagName(sMIconListParent.getIconName());
                SMGameClient.getInstance().startGameListSub(sMGameListParent, GameListFragment.this.requireActivity());
            }
        });
        this.mIconAdapter = iconListAdapter;
        this.mIconRv.setAdapter(iconListAdapter);
        HotListAdapter hotListAdapter = new HotListAdapter(requireActivity(), new ArrayList(), new HotListAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.2
            @Override // com.tenmeter.smlibrary.adapter.HotListAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                GameListFragment.this.gameClick(sMGameInfo);
            }
        }, (DisplayUtil.getScreenWidth() - DisplayUtil.dp2px(56.0f)) / 2);
        this.mHotAdapter = hotListAdapter;
        this.mHotRv.setAdapter(hotListAdapter);
        GameListTypeAdapter gameListTypeAdapter = new GameListTypeAdapter(requireActivity(), new ArrayList(), new GameListTypeAdapter.IGameListItemClick() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.3
            @Override // com.tenmeter.smlibrary.adapter.GameListTypeAdapter.IGameListItemClick
            public void itemClick(SMGameInfo sMGameInfo) {
                GameListFragment.this.gameClick(sMGameInfo);
            }

            @Override // com.tenmeter.smlibrary.adapter.GameListTypeAdapter.IGameListItemClick
            public void itemMoreClick(SMGameListParent sMGameListParent) {
                SMGameClient.getInstance().startGameListSub(sMGameListParent, GameListFragment.this.requireActivity());
            }
        });
        this.mTypeAdapter = gameListTypeAdapter;
        this.mGameRv.setAdapter(gameListTypeAdapter);
        this.mLeisureMore.setOnClickListener(new View.OnClickListener() { // from class: com.tenmeter.smlibrary.fragment.GameListFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GameListFragment.this.leisureGameDatas != null) {
                    SMGameClient.getInstance().startGameListSub(GameListFragment.this.leisureGameDatas, GameListFragment.this.requireActivity());
                }
            }
        });
    }

    public void hideLoading() {
        LoadDia loadDia = this.mLoadDia;
        if (loadDia == null || !loadDia.isShowing()) {
            return;
        }
        this.mLoadDia.dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_sm_sdk_game_list, (ViewGroup) null, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Banner banner = this.mBannerN;
        if (banner == null || banner.getVisibility() != 0) {
            return;
        }
        this.mBannerN.destroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Banner banner = this.mBannerN;
        if (banner == null || banner.getVisibility() != 0) {
            return;
        }
        this.mBannerN.start();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Banner banner = this.mBannerN;
        if (banner == null || banner.getVisibility() != 0) {
            return;
        }
        this.mBannerN.stop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initView(view);
        registerListener();
        initData();
    }

    public void showLoading() {
        if (this.mLoadDia == null) {
            this.mLoadDia = new LoadDia(getContext());
        }
        if (this.mLoadDia.isShowing()) {
            return;
        }
        this.mLoadDia.show();
    }
}
