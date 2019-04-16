package com.dy.qxjhutil.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blankj.utilcode.util.Utils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.model.WXModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 武侠善恶简单统计
 **/
public class WxListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BaseQuickAdapter<WXModel, BaseViewHolder> mAdapter;
    private List<WXModel> mList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_list);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BaseQuickAdapter<WXModel, BaseViewHolder>(R.layout.item_wx_list) {
            @Override
            protected void convert(BaseViewHolder helper, WXModel item) {
                helper.setText(R.id.item_wx_list_name, item.getName_game())
                        .setText(R.id.item_wx_list_value, item.getValue());
            }
        };
        recyclerView.setAdapter(mAdapter);

        initData();

    }

    private void initData() {
        mList.add(new WXModel(魔教圣女, Utils.getApp().getString(R.string.魔教圣女)));
        mList.add(new WXModel(狮王, Utils.getApp().getString(R.string.狮王)));
        mList.add(new WXModel(东方不败, Utils.getApp().getString(R.string.东方不败)));
        mList.add(new WXModel(九剑传人, Utils.getApp().getString(R.string.九剑传人)));
        mList.add(new WXModel(蝠王, Utils.getApp().getString(R.string.蝠王)));
        mList.add(new WXModel(君子剑, Utils.getApp().getString(R.string.君子剑)));
        mList.add(new WXModel(林家公子, Utils.getApp().getString(R.string.林家公子)));
        mList.add(new WXModel(波斯圣女, Utils.getApp().getString(R.string.波斯圣女)));
        mList.add(new WXModel(不可不戒, Utils.getApp().getString(R.string.不可不戒)));
        mList.add(new WXModel(玄冥二老, Utils.getApp().getString(R.string.玄冥二老)));
        mList.add(new WXModel(龙王, Utils.getApp().getString(R.string.龙王)));
        mList.add(new WXModel(余馆主, Utils.getApp().getString(R.string.余馆主)));
        mList.add(new WXModel(周芷若, Utils.getApp().getString(R.string.周芷若)));
        mList.add(new WXModel(赵敏, Utils.getApp().getString(R.string.赵敏)));
        mList.add(new WXModel(任盈盈, Utils.getApp().getString(R.string.任盈盈)));
        mList.add(new WXModel(魔教教主, Utils.getApp().getString(R.string.魔教教主)));

        mAdapter.setNewData(mList);
    }

    private static final String 魔教圣女 = "魔教圣女";
    private static final String 狮王 = "狮王";
    private static final String 东方不败 = "东方不败";
    private static final String 九剑传人 = "九剑传人";
    private static final String 蝠王 = "蝠王";
    private static final String 君子剑 = "君子剑";
    private static final String 林家公子 = "林家公子";
    private static final String 波斯圣女 = "波斯圣女";
    private static final String 不可不戒 = "不可不戒";
    private static final String 玄冥二老 = "玄冥二老";
    private static final String 龙王 = "龙王";
    private static final String 余馆主 = "余馆主";

    private static final String 周芷若 = "周芷若";
    private static final String 赵敏 = "赵敏";
    private static final String 任盈盈 = "任盈盈";
    private static final String 魔教教主 = "魔教教主";

}
