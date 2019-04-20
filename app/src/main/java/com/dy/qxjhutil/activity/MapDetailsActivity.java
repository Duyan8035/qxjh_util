package com.dy.qxjhutil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.MapModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.dy.qxjhutil.util.Utils;

public class MapDetailsActivity extends BaseActivity implements View.OnClickListener {


    private String mapName = "";
    private MapModel model;

    private TextView tv_title, tv_value, tv_wx_name1, tv_wx_name2, tv_kongfu_1, tv_kongfu_2, tv_wx_trend1, tv_wx_good1, tv_wx_trend2, tv_wx_good2;
    private ImageView img_map, img_wx_1, img_kongfu_1, img_wx_2, img_kongfu_2;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_details);
        mapName = getIntent().getStringExtra("map");

        model = RealmHelper.getInstance(mContext).where(MapModel.class).equalTo("mapName", mapName).findFirst();
        if (model != null) {
            initData();
        } else {
            ToastUtils.showLong("没有数据");
        }
    }

    private void initData() {
        tv_title = findViewById(R.id.act_map_details_map_tv_name);
        tv_value = findViewById(R.id.act_map_details_map_tv_value);
        img_map = findViewById(R.id.act_map_details_map_img);
        img_wx_1 = findViewById(R.id.act_map_details_map_img_wx1);
        img_wx_2 = findViewById(R.id.act_map_details_map_img_wx2);
        img_kongfu_1 = findViewById(R.id.act_map_details_map_img_kungfu1);
        img_kongfu_2 = findViewById(R.id.act_map_details_map_img_kungfu2);

        tv_kongfu_1 = findViewById(R.id.act_map_details_map_tv_kungfu1);
        tv_kongfu_2 = findViewById(R.id.act_map_details_map_tv_kungfu2);
        tv_wx_name1 = findViewById(R.id.act_map_details_map_tv_wx1);
        tv_wx_name2 = findViewById(R.id.act_map_details_map_tv_wx2);
        tv_wx_good1 = findViewById(R.id.act_map_details_map_wx_good1);
        tv_wx_good2 = findViewById(R.id.act_map_details_map_wx_good2);
        tv_wx_trend1 = findViewById(R.id.act_map_details_map_wx_trend1);
        tv_wx_trend2 = findViewById(R.id.act_map_details_map_wx_trend2);

        mRecyclerView = findViewById(R.id.act_map_details_map_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tv_title.setText(model.getMapName());
        tv_value.setText(model.getValue());

        if (model.getImg() != -1) {
            img_map.setImageResource(model.getImg());
        }

        if (model.getFuModel1() != null) {
            findViewById(R.id.act_map_details_group_1).setVisibility(View.VISIBLE);
            if (model.getFuModel1().getImg() != -1) {
                img_wx_1.setImageResource(model.getFuModel1().getImg());
            }
            tv_wx_trend1.setText(Utils.getTrend(model.getFuModel1().getTrendMin()));
            tv_wx_good1.setText(Utils.getGood(model.getFuModel1().getGoodMin()));
            if (model.getFuModel1().getWx_parent().getIcon() != -1) {
                img_kongfu_1.setImageResource(model.getFuModel1().getWx_parent().getIcon());
            }
            tv_kongfu_1.setText(model.getFuModel1().getWx_parent().getName_game());
        } else {
            findViewById(R.id.act_map_details_group_1).setVisibility(View.GONE);
        }

        if (model.getFuModel2() != null) {
            findViewById(R.id.act_map_details_group_2).setVisibility(View.VISIBLE);
            if (model.getFuModel2().getImg() != -1) {
                img_wx_2.setImageResource(model.getFuModel2().getImg());
            }
            tv_wx_trend2.setText(Utils.getTrend(model.getFuModel2().getTrendMin()));
            tv_wx_good2.setText(Utils.getGood(model.getFuModel2().getGoodMin()));
            if (model.getFuModel2().getWx_parent().getIcon() != -1) {
                img_kongfu_2.setImageResource(model.getFuModel2().getWx_parent().getIcon());
            }
            tv_kongfu_2.setText(model.getFuModel2().getWx_parent().getName_game());
        } else {
            findViewById(R.id.act_map_details_group_2).setVisibility(View.GONE);
        }


        findViewById(R.id.act_map_details_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_map_details_btn:
                Intent intent = new Intent(mContext, WxListActivity.class);
                intent.putExtra("map", model.getMapName());
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
