package com.dy.qxjhutil.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.adapter.WxSjListAdapter;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.gjiazhe.wavesidebar.WaveSideBar;

import io.realm.Realm;

/**
 *
 **/
public class WxListActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
//    private List<WXModel> mList = new ArrayList<>();

    Realm mRealm;

    private WaveSideBar sideBar;

    private String mapName = "";
    private String[] indexs = {"A", "B", "C", "D", "E", "F", "G", "J", "L", "M", "N", "Q", "R", "S", "T", "W", "X", "Y", "Z"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_list);

        mRealm = RealmHelper.getInstance(mContext);
        mapName = getIntent().getStringExtra("map");

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_sj_list) {
        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_sj_list) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setText(R.id.item_wx_sj_list_name, item.getName_game())
                        .setText(R.id.item_wx_sj_list_value, item.getName());
                if (item.getIcon() != -1) {
                    helper.setImageResource(R.id.item_wx_sj_list_img, item.getIcon());
                }
                if (item.getSjModels() != null && item.getSjModels().size() > 0) {
                    helper.setVisible(R.id.item_wx_sj_list_rv, true);
                    RecyclerView recyclerView = helper.getView(R.id.item_wx_sj_list_rv);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                    recyclerView.setAdapter(new WxSjListAdapter(item.getSjModels()));

                    /*recyclerView.setAdapter(new BaseQuickAdapter<SjModel, BaseViewHolder>(R.layout.item_sj_type_1, item.getSjModels()) {
                        @Override
                        protected void convert(BaseViewHolder helper, SjModel item) {
                            if (!TextUtils.isEmpty(item.getValue_1()) && item.getValue_1().length() > 0) {
                                helper.setGone(R.id.item_wx_sj_list_value_1, true);

                                if (!TextUtils.isEmpty(item.getBranch_11()) || !TextUtils.isEmpty(item.getBranch_12())
                                        || !TextUtils.isEmpty(item.getBranch_13())) {
                                    helper.setText(R.id.include_sj_value_parent_layout1_1, item.getValue_1())
                                            .setGone(R.id.include_sj_value_parent_layout1_1, true);
                                    if (!TextUtils.isEmpty(item.getBranch_11()) && item.getBranch_11().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout1_1, item.getBranch_11())
                                                .setGone(R.id.include_sj_value_value_layout1_1, true)
                                                .setText(R.id.include_sj_value_obtain_layout1_1, getObtain(item.getObtain_11(), item.getTrend_11(), item.getGood_11()))
                                                .setGone(R.id.include_sj_value_obtain_layout1_1, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout1_1, false)
                                                .setGone(R.id.include_sj_value_obtain_layout1_1, false)
                                                .setGone(R.id.include_sj_value_obtain_layout1_1, false)
                                        ;
                                    }
                                    if (!TextUtils.isEmpty(item.getBranch_12()) && item.getBranch_12().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout1_2, item.getBranch_12())
                                                .setGone(R.id.include_sj_value_value_layout1_2, true)
                                                .setText(R.id.include_sj_value_obtain_layout1_2, getObtain(item.getObtain_12(), item.getTrend_12(), item.getGood_12()))
                                                .setGone(R.id.include_sj_value_obtain_layout1_2, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout1_2, false)
                                                .setGone(R.id.include_sj_value_obtain_layout1_2, false)
                                                .setGone(R.id.include_sj_value_obtain_layout1_2, false);
                                    }
                                    if (!TextUtils.isEmpty(item.getBranch_13()) && item.getBranch_13().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout1_3, item.getBranch_13())
                                                .setGone(R.id.include_sj_value_value_layout1_3, true)
                                                .setText(R.id.include_sj_value_obtain_layout1_3, getObtain(item.getObtain_13(), item.getTrend_13(), item.getGood_13()))
                                                .setGone(R.id.include_sj_value_obtain_layout1_3, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout1_3, false)
                                                .setGone(R.id.include_sj_value_obtain_layout1_3, false)
                                                .setGone(R.id.include_sj_value_obtain_layout1_3, false);
                                    }
                                } else {
                                    helper.setText(R.id.include_sj_value_value_layout1_1, item.getValue_1())
                                            .setGone(R.id.include_sj_value_value_layout1_1, true)
                                            .setText(R.id.include_sj_value_obtain_layout1_1, getObtain(item.getObtain_11(),
                                                    item.getTrend_11(), item.getGood_11()))
                                            .setGone(R.id.include_sj_value_obtain_layout1_1, true)

                                            .setGone(R.id.include_sj_value_parent_layout1_1, false)
                                            .setGone(R.id.include_sj_value_value_layout1_2, false)
                                            .setGone(R.id.include_sj_value_value_layout1_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout1_3, false)
                                    ;
                                }
                            } else {
                                helper.setGone(R.id.item_wx_sj_list_value_1, false);
                            }

                            if (!TextUtils.isEmpty(item.getValue_2()) && item.getValue_2().length() > 0) {
                                helper.setGone(R.id.item_wx_sj_list_value_2, true)
                                ;
                                if (!TextUtils.isEmpty(item.getBranch_21()) || !TextUtils.isEmpty(item.getBranch_22())
                                        || !TextUtils.isEmpty(item.getBranch_23())) {
                                    helper.setGone(R.id.item_wx_sj_list_value_2, true);
                                    helper.setText(R.id.include_sj_value_parent_layout2_1, item.getValue_2())
                                            .setGone(R.id.include_sj_value_parent_layout2_1, true);
                                    if (!TextUtils.isEmpty(item.getBranch_21()) && item.getBranch_21().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout2_1, item.getBranch_21())
                                                .setGone(R.id.include_sj_value_value_layout2_1, true)
                                                .setText(R.id.include_sj_value_obtain_layout2_1, getObtain(item.getObtain_21(), item.getTrend_21(), item.getGood_21()))
                                                .setGone(R.id.include_sj_value_obtain_layout2_1, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout2_1, false)
                                                .setGone(R.id.include_sj_value_obtain_layout2_1, false)
                                                .setGone(R.id.include_sj_value_obtain_layout2_1, false)
                                        ;
                                    }
                                    if (!TextUtils.isEmpty(item.getBranch_22()) && item.getBranch_22().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout2_2, item.getBranch_22())
                                                .setGone(R.id.include_sj_value_value_layout2_2, true)
                                                .setText(R.id.include_sj_value_obtain_layout2_2, getObtain(item.getObtain_22(), item.getTrend_22(), item.getGood_22()))
                                                .setGone(R.id.include_sj_value_obtain_layout2_2, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout2_2, false)
                                                .setGone(R.id.include_sj_value_obtain_layout2_2, false)
                                                .setGone(R.id.include_sj_value_obtain_layout2_2, false);
                                    }
                                    if (!TextUtils.isEmpty(item.getBranch_23()) && item.getBranch_23().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout2_3, item.getBranch_23())
                                                .setGone(R.id.include_sj_value_value_layout2_3, true)
                                                .setText(R.id.include_sj_value_obtain_layout2_3, getObtain(item.getObtain_23(), item.getTrend_23(), item.getGood_23()))
                                                .setGone(R.id.include_sj_value_obtain_layout2_3, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout2_3, false)
                                                .setGone(R.id.include_sj_value_obtain_layout2_3, false)
                                                .setGone(R.id.include_sj_value_obtain_layout2_3, false);
                                    }
                                } else {
                                    helper.setGone(R.id.include_sj_value_parent_layout2_1, false)
                                            .setText(R.id.include_sj_value_value_layout2_1, item.getValue_2())
                                            .setGone(R.id.include_sj_value_value_layout2_1, true)
                                            .setText(R.id.include_sj_value_obtain_layout2_1, getObtain(item.getObtain_21(),
                                                    item.getTrend_21(), item.getGood_21()))
                                            .setGone(R.id.include_sj_value_obtain_layout2_1, true)
                                            .setGone(R.id.include_sj_value_parent_layout2_1, false)
                                            .setGone(R.id.include_sj_value_value_layout2_2, false)
                                            .setGone(R.id.include_sj_value_value_layout2_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout2_3, false)
                                    ;
                                }
                            } else {
                                helper.setGone(R.id.item_wx_sj_list_value_2, false);
                            }

                            if (!TextUtils.isEmpty(item.getValue_3()) && item.getValue_3().length() > 0) {
                                helper.setGone(R.id.item_wx_sj_list_value_3, true)
                                ;
                                if (!TextUtils.isEmpty(item.getBranch_31()) || !TextUtils.isEmpty(item.getBranch_32())
                                        || !TextUtils.isEmpty(item.getBranch_33())) {
                                    helper.setGone(R.id.item_wx_sj_list_value_3, true);
                                    helper.setText(R.id.include_sj_value_parent_layout3_1, item.getValue_3())
                                            .setGone(R.id.include_sj_value_parent_layout3_1, true);
                                    if (!TextUtils.isEmpty(item.getBranch_31()) && item.getBranch_31().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout3_1, item.getBranch_31())
                                                .setGone(R.id.include_sj_value_value_layout3_1, true)
                                                .setText(R.id.include_sj_value_obtain_layout3_1, getObtain(item.getObtain_31(), item.getTrend_31(), item.getGood_31()))
                                                .setGone(R.id.include_sj_value_obtain_layout3_1, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout3_1, false)
                                                .setGone(R.id.include_sj_value_obtain_layout3_1, false)
                                                .setGone(R.id.include_sj_value_obtain_layout3_1, false)
                                        ;
                                    }
                                    if (!TextUtils.isEmpty(item.getBranch_32()) && item.getBranch_32().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout3_2, item.getBranch_32())
                                                .setGone(R.id.include_sj_value_value_layout3_2, true)
                                                .setText(R.id.include_sj_value_obtain_layout3_2, getObtain(item.getObtain_32(), item.getTrend_32(), item.getGood_32()))
                                                .setGone(R.id.include_sj_value_obtain_layout3_2, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout3_2, false)
                                                .setGone(R.id.include_sj_value_obtain_layout3_2, false)
                                                .setGone(R.id.include_sj_value_obtain_layout3_2, false);
                                    }
                                    if (!TextUtils.isEmpty(item.getBranch_33()) && item.getBranch_33().length() > 0) {
                                        helper.setText(R.id.include_sj_value_value_layout3_3, item.getBranch_33())
                                                .setGone(R.id.include_sj_value_value_layout3_3, true)
                                                .setText(R.id.include_sj_value_obtain_layout3_3, getObtain(item.getObtain_33(), item.getTrend_33(), item.getGood_33()))
                                                .setGone(R.id.include_sj_value_obtain_layout3_3, true)
                                        ;
                                    } else {
                                        helper.setGone(R.id.include_sj_value_value_layout3_3, false)
                                                .setGone(R.id.include_sj_value_obtain_layout3_3, false)
                                                .setGone(R.id.include_sj_value_obtain_layout3_3, false);
                                    }
                                } else {
                                    helper.setGone(R.id.include_sj_value_parent_layout3_1, false)
                                            .setText(R.id.include_sj_value_value_layout3_1, item.getValue_3())
                                            .setGone(R.id.include_sj_value_value_layout3_1, true)
                                            .setText(R.id.include_sj_value_obtain_layout3_1, getObtain(item.getObtain_31(),
                                                    item.getTrend_31(), item.getGood_31()))
                                            .setGone(R.id.include_sj_value_obtain_layout3_1, true)
                                            .setGone(R.id.include_sj_value_value_layout3_2, false)
                                            .setGone(R.id.include_sj_value_value_layout3_3, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_2, false)
                                            .setGone(R.id.include_sj_value_obtain_layout3_3, false);
                                }
                            } else {
                                helper.setGone(R.id.item_wx_sj_list_value_3, false);
                            }
                        }
                    });*/
                } else {
                    helper.setVisible(R.id.item_wx_sj_list_rv, false);
                }
            }
        };
        recyclerView.setAdapter(mAdapter);
        TextView view = (TextView) View.inflate(mContext, R.layout.include_text, null);
        view.setText("竹林和冰火岛事件攻略 感谢攻略组 东晓  ⃢ ——⃢　(眼镜大佬)非洲人呀 等提供资料");
        mAdapter.setFooterView(view);

        sideBar = findViewById(R.id.side_bar);
        sideBar.setIndexItems(indexs);
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                for (int i = 0; i < mAdapter.getData().size(); i++) {
                    if (mAdapter.getData().get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });

        initData();
    }

    private void initData() {
        // TODO: 2019/4/20  暂时没做按照地图区分武侠
//        if (!TextUtils.isEmpty(mapName) && mapName.length() > 0) {
//            String mapTitle = "";
//            switch (mapName) {
//                case WxDefaultUtil.MAP_NAME_1:
//                    mapTitle = "isMap1";
//                    break;
//                case WxDefaultUtil.MAP_NAME_2:
//                    mapTitle = "isMap2";
//                    break;
//                case WxDefaultUtil.MAP_NAME_3:
//                    mapTitle = "isMap3";
//                    break;
//                case WxDefaultUtil.MAP_NAME_4:
//                    mapTitle = "isMap4";
//                    break;
//                case WxDefaultUtil.MAP_NAME_5:
//                    mapTitle = "isMap5";
//                    break;
//                case WxDefaultUtil.MAP_NAME_6:
//                    mapTitle = "isMap6";
//                    break;
//                default:
//                    break;
//            }
//            mAdapter.setNewData(mRealm.where(WXModel.class).equalTo(mapTitle, true).findAll().sort("index"));
//        } else {
        mAdapter.setNewData(mRealm.where(WXModel.class).findAll().sort("index"));
//        }
    }
}
