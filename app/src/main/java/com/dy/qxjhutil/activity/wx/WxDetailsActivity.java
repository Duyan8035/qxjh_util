package com.dy.qxjhutil.activity.wx;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.adapter.WxSjListAdapter;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.dy.qxjhutil.util.Utils;

/**
 * 详情页
 **/
public class WxDetailsActivity extends BaseActivity {
    private WXModel mModel;
    private String name;

    private TextView tv_name, tv_name_game;
    private ImageView img_icon;

    private TextView tv_wx_trend1, tv_wx_good1;
    private ImageView img_wx_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_details);
        name = getIntent().getStringExtra("name");

        mModel = RealmHelper.getInstance(mContext).where(WXModel.class).equalTo("name_game", name).findFirst();

        if (mModel != null) {
            img_icon = findViewById(R.id.item_wx_sj_list_img);
            tv_name_game = findViewById(R.id.item_wx_sj_list_name);
            tv_name = findViewById(R.id.item_wx_sj_list_value);
            tv_name_game.setText(mModel.getName_game());
            tv_name.setText(mModel.getName());

            if (mModel.getIcon() != -1) {
                img_icon.setImageResource(mModel.getIcon());
            }

            if (mModel.getSjModels() != null && mModel.getSjModels().size() > 0) {
                RecyclerView recyclerView = findViewById(R.id.item_wx_sj_list_rv);
                recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                recyclerView.setAdapter(new WxSjListAdapter(mModel.getSjModels()));
            }


            img_wx_1 = findViewById(R.id.act_map_details_map_img_wx1);

            tv_wx_good1 = findViewById(R.id.act_map_details_map_wx_good1);
            tv_wx_trend1 = findViewById(R.id.act_map_details_map_wx_trend1);

            if (mModel.getKfParent() != null) {
                if (mModel.getKfParent().getImg() != -1) {
                    img_wx_1.setImageResource(mModel.getKfParent().getImg());
                }
                tv_wx_trend1.setText(Utils.getTrend(mModel.getKfParent().getTrendMin()));
                tv_wx_good1.setText(Utils.getGood(mModel.getKfParent().getGoodMin()));
            } else {
                findViewById(R.id.act_map_details_map_tv_title_wx1).setVisibility(View.GONE);
            }
        } else {
            ToastUtils.showLong("无数据");
        }
    }
}
