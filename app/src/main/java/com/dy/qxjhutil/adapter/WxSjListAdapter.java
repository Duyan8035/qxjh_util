package com.dy.qxjhutil.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.model.SjModel;
import com.dy.qxjhutil.util.Utils;

import java.util.List;

/**
 * Created by Dy on 2019/4/20 13
 *
 * @author Dy
 */
public class WxSjListAdapter extends BaseMultiItemQuickAdapter<SjModel, BaseViewHolder> {
    public static final int TYPE_1 = 1;
    public static final int TYPE_2 = 2;
    public static final int TYPE_3 = 3;

    public WxSjListAdapter(List<SjModel> data) {
        super(data);
        init();
    }

    public void init() {
        addItemType(TYPE_1, R.layout.item_sj_type_1);
        addItemType(TYPE_2, R.layout.item_sj_type_2);
        addItemType(TYPE_3, R.layout.item_sj_type_3);
    }

    @Override
    protected void convert(BaseViewHolder helper, SjModel item) {
        switch (item.getItemType()) {
            case TYPE_1:
                helper.setText(R.id.item_sj_value_tv_1, item.getValue_1())
                        .setText(R.id.item_sj_obtain_1, Utils.getObtain(item.getObtain_11(), item.getTrend_11(), item.getGood_11()));
                break;
            case TYPE_2:
                helper.setText(R.id.item_sj_parent_tv_1, item.getValue_1())
                        .setText(R.id.item_sj_value_tv_1, item.getBranch_11())
                        .setText(R.id.item_sj_value_tv_2, item.getBranch_21())
                        .setText(R.id.item_sj_obtain_1, Utils.getObtain(item.getObtain_11(), item.getTrend_11(), item.getGood_11()))
                        .setText(R.id.item_sj_obtain_2, Utils.getObtain(item.getObtain_21(), item.getTrend_21(), item.getGood_21()))
                ;
                break;
            case TYPE_3:
                helper.setText(R.id.item_sj_parent_tv_1, item.getValue_1())
                        .setText(R.id.item_sj_value_tv_1, item.getBranch_11())
                        .setText(R.id.item_sj_value_tv_2, item.getBranch_21())
                        .setText(R.id.item_sj_value_tv_3, item.getBranch_31())
                        .setText(R.id.item_sj_obtain_1, Utils.getObtain(item.getObtain_11(), item.getTrend_11(), item.getGood_11()))
                        .setText(R.id.item_sj_obtain_2, Utils.getObtain(item.getObtain_21(), item.getTrend_21(), item.getGood_21()))
                        .setText(R.id.item_sj_obtain_3, Utils.getObtain(item.getObtain_31(), item.getTrend_31(), item.getGood_31()))
                ;
                break;
            default:
                break;
        }
    }
}
