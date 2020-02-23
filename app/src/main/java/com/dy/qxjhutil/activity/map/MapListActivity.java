package com.dy.qxjhutil.activity.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.SpanUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.MapModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.dy.qxjhutil.util.Utils;

public class MapListActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<MapModel, BaseViewHolder> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_map_list);

        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.act_map_list_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mAdapter = new BaseQuickAdapter<MapModel, BaseViewHolder>(R.layout.item_map_main) {
            @Override
            protected void convert(BaseViewHolder helper, MapModel item) {
                helper.setText(R.id.item_map_main_tv, item.getMapName());
                if (item.getImg() != -1) {
                    helper.setImageResource(R.id.item_map_main_img, item.getImg());
                }

                if (item.getArtifactList() != null && item.getArtifactList().size() > 0) {
                    String artifact = "";
                    for (int i = 0; i < item.getArtifactList().size(); i++) {
                        artifact += item.getArtifactList().get(i).getName() + "   ";
                    }
                    helper.setText(R.id.item_map_main_tv_artifact, new SpanUtils().append(artifact).setBold()
                            .setForegroundColor(0xff212121).create());
                }
                if (item.getHerbsList() != null && item.getHerbsList().size() > 0) {
                    String herbs = "";
                    for (int i = 0; i < item.getHerbsList().size(); i++) {
                        herbs += item.getHerbsList().get(i).getName() + "   ";
                    }
                    helper.setText(R.id.item_map_main_tv_herbs, new SpanUtils().append("掉落药材：")
                            .append(herbs).setBold()
                            .setForegroundColor(0xff212121).create());
                }

                if (item.getMineralList() != null && item.getMineralList().size() > 0) {
                    String mineral = "";
                    for (int i = 0; i < item.getMineralList().size(); i++) {
                        mineral += item.getMineralList().get(i).getName() + "   ";
                    }
                    helper.setText(R.id.item_map_main_tv_mineral, new SpanUtils().append("掉落矿石：")
                            .append(mineral).setBold()
                            .setForegroundColor(0xff212121).create());
//                    helper.setText(R.id.item_map_main_tv_mineral, "掉落矿石：" + mineral);
                }

                if (item.getWxModel1() != null || item.getWxModel2() != null) {
                    String wx = "";
                    wx += item.getWxModel1().getName_game() + "   ";
                    wx += item.getWxModel2().getName_game();
                    helper.setText(R.id.item_map_main_tv_wx, new SpanUtils().append("掉落武魂：")
                            .append(wx).setBold()
                            .setForegroundColor(0xff212121).create());
                }


                if (item.getFuModel1() != null) {
//                    SpanUtils spanUtils = new SpanUtils();
//                    spanUtils.append(item.getFuModel1().getName() + " : ");
//                    spanUtils.append(Utils.getGood(item.getFuModel1().getGoodMin()) + "  ");
//                    spanUtils.append(Utils.getTrend(item.getFuModel1().getTrendMin()));
//                    spanUtils.append(item.getFuModel1().getWx_parent().getName_game());
                    helper.setText(R.id.item_map_main_tv_kf_11, item.getFuModel1().getName() + "\n" +
                            item.getFuModel1().getWx_parent().getName_game())
//                            .setText(R.id.item_map_main_tv_kf_12, spanUtils.create())
                            .setText(R.id.item_map_main_tv_kf_12, Utils.getTrend(item.getFuModel1().getTrendMin()) + "\n"
                                    + Utils.getGood(item.getFuModel1().getGoodMin()))
//                            .setText(R.id.item_map_main_tv_kf_13, )
                    ;
                }

                if (item.getFuModel2() != null) {
//                    SpanUtils spanUtils = new SpanUtils();
//                    spanUtils.append(Utils.getGood(item.getFuModel2().getGoodMin()) + " ");
//                    spanUtils.append(Utils.getTrend(item.getFuModel2().getTrendMin()));

//                    spanUtils.append(item.getFuModel2().getName() + " : ");
//                    spanUtils.append(item.getFuModel2().getWx_parent().getName_game());
                    helper.setText(R.id.item_map_main_tv_kf_21, item.getFuModel2().getName() + "\n" +
                            item.getFuModel2().getWx_parent().getName_game())
                            .setText(R.id.item_map_main_tv_kf_22, Utils.getTrend(item.getFuModel2().getTrendMin()) + "\n"
                                    + Utils.getGood(item.getFuModel2().getGoodMin()))
//                            .setText(R.id.item_map_main_tv_kf_22, spanUtils.create())
//                            .setText(R.id.item_map_main_tv_kf_23, item.getFuModel2().getWx_parent().getName_game())
                    ;
                }
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, MapDetailsActivity.class);
                intent.putExtra("map", mAdapter.getItem(position).getMapName());
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setNewData(RealmHelper.getInstance(mContext).where(MapModel.class).findAll());
    }
}
