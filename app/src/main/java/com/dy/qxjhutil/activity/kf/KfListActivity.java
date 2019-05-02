package com.dy.qxjhutil.activity.kf;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.model.KungFuModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.dy.qxjhutil.util.Utils;
import com.gjiazhe.wavesidebar.WaveSideBar;

public class KfListActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<KungFuModel, BaseViewHolder> mAdapter;
    private WaveSideBar sideBar;
    private final static String[] indexs = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kf_list);

        mRecyclerView = findViewById(R.id.act_kf_list_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BaseQuickAdapter<KungFuModel, BaseViewHolder>(R.layout.item_kf_list) {
            @Override
            protected void convert(BaseViewHolder helper, KungFuModel item) {
                helper.setText(R.id.act_kf_details_name, item.getName());
                helper.setImageResource(R.id.act_kf_details_img, item.getImg());
                helper.setText(R.id.act_kf_details_value, Utils.getKfValue(item.getCost(), item.getDesc()));
            }
        };
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setNewData(RealmHelper.getInstance(mContext).where(KungFuModel.class).findAll());

        sideBar = findViewById(R.id.side_bar);
        sideBar.setIndexItems(indexs);
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                for (int i = 0; i < mAdapter.getData().size(); i++) {
                    if (mAdapter.getData().get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });
        findViewById(R.id.act_kf_list_btn_1).setOnClickListener(this);
        findViewById(R.id.act_kf_list_btn_2).setOnClickListener(this);
        findViewById(R.id.act_kf_list_btn_3).setOnClickListener(this);
        findViewById(R.id.act_kf_list_btn_4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.act_kf_list_btn_1:
                mAdapter.setNewData(RealmHelper.getInstance(mContext).where(KungFuModel.class)
                        .equalTo("type", 4).findAll().sort("index"));
                break;
            case R.id.act_kf_list_btn_2:
                mAdapter.setNewData(RealmHelper.getInstance(mContext).where(KungFuModel.class)
                        .equalTo("type", 2).findAll().sort("index"));
                break;
            case R.id.act_kf_list_btn_3:
                mAdapter.setNewData(RealmHelper.getInstance(mContext).where(KungFuModel.class)
                        .equalTo("type", 3).findAll().sort("index"));
                break;
            case R.id.act_kf_list_btn_4:
                mAdapter.setNewData(RealmHelper.getInstance(mContext).where(KungFuModel.class).findAll().sort("index"));
                break;
            default:
                break;
        }
    }
}
