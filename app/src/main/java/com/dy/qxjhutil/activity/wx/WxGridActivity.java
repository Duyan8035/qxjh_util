package com.dy.qxjhutil.activity.wx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.constant.WxDefaultUtil;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import io.realm.Realm;

/**
 *
 **/
public class WxGridActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
//    private List<WXModel> mList = new ArrayList<>();

    Realm mRealm;

    private String mapName = "";

    private QMUIRoundButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_grid);

        mRealm = RealmHelper.getInstance(mContext);
        mapName = getIntent().getStringExtra("map");

        btn = findViewById(R.id.act_wx_list_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, WxListActivity.class);
                if (!TextUtils.isEmpty(mapName) && mapName.length() > 0) {
                    intent.putExtra("map", mapName);
                }
                startActivity(intent);
                finish();
            }
        });

        recyclerView = findViewById(R.id.recycler_view);
        if (ScreenUtils.isLandscape()) {
            recyclerView.setLayoutManager(new GridLayoutManager(mContext, 8));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(mContext, 4));
        }
//        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_sj_list) {
        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_sj_grid) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setText(R.id.item_wx_sj_list_name, item.getName_game());
                if (item.getIcon_mini() != -1) {
                    helper.setImageResource(R.id.item_wx_sj_list_img, item.getIcon_mini());
                }
            }
        };
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, WxDetailsActivity.class);
                intent.putExtra("name", mAdapter.getData().get(position).getName_game());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
        TextView view = (TextView) View.inflate(mContext, R.layout.include_text, null);
        view.setText("竹林和冰火岛事件攻略 感谢攻略组 东晓  ⃢ ——⃢　(眼镜大佬)非洲人呀 等提供资料");
        mAdapter.setFooterView(view);

        initData();
    }

    private void initData() {
        if (!TextUtils.isEmpty(mapName) && mapName.length() > 0) {
            String mapTitle = "";
            switch (mapName) {
                case WxDefaultUtil.MAP_NAME_1:
                    mapTitle = "isMap1";
                    break;
                case WxDefaultUtil.MAP_NAME_2:
                    mapTitle = "isMap2";
                    break;
                case WxDefaultUtil.MAP_NAME_3:
                    mapTitle = "isMap3";
                    break;
                case WxDefaultUtil.MAP_NAME_4:
                    mapTitle = "isMap4";
                    break;
                case WxDefaultUtil.MAP_NAME_5:
                    mapTitle = "isMap5";
                    break;
                case WxDefaultUtil.MAP_NAME_6:
                    mapTitle = "isMap6";
                    break;
                default:
                    break;
            }
            mAdapter.setNewData(mRealm.where(WXModel.class).equalTo(mapTitle, true).findAll().sort("index"));
        } else {
            mAdapter.setNewData(mRealm.where(WXModel.class).findAll().sort("index"));
        }
    }
}
