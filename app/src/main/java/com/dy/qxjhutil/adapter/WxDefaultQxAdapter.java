package com.dy.qxjhutil.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.constant.ColorModel;
import com.dy.qxjhutil.constant.NameModel;
import com.dy.qxjhutil.model.WXModel;

/**
 * Created by Dy on 2019/8/18 17
 *
 * @author Dy
 */
public class WxDefaultQxAdapter extends BaseQuickAdapter<WXModel, BaseViewHolder> {
    public WxDefaultQxAdapter() {
        super(R.layout.item_wx_good);
    }

    @Override
    protected void convert(BaseViewHolder helper, WXModel item) {
        helper.setText(R.id.item_wx_list_name, item.getName_game())
                .setText(R.id.item_wx_list_value, item.getTrend() == 99 ? "" : item.getTrend() + "")
                .setText(R.id.item_wx_list_value2, item.getGood() == 99 ? "" : item.getGood() + "")
                .setText(R.id.item_wx_list_value3, item.getParent())
        ;
        switch (item.getParent()) {
            case NameModel.Parent_1:
                helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_1);
                break;
            case NameModel.Parent_2:
                helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_2);
                break;
            case NameModel.Parent_3:
                helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_3);
                break;
            case NameModel.Parent_4:
                helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_4);
                break;
            case NameModel.Parent_5:
                helper.setBackgroundColor(R.id.item_wx_list_value3, ColorModel.TYPE_PARENT_5);
                break;
            default:
                break;
        }
        if (item.getTrend() == 0) {
            helper.setTextColor(R.id.item_wx_list_value, ColorModel.TYPE_COLOR_DEFAULT);
        } else {
            helper.setTextColor(R.id.item_wx_list_value, item.getTrend() > 0 ? ColorModel.TYPE_COLOR_GREEN : ColorModel.TYPE_COLOR_RED);
        }
        if (item.getGood() == 0) {
            helper.setTextColor(R.id.item_wx_list_value2, ColorModel.TYPE_COLOR_DEFAULT);
        } else {
            helper.setTextColor(R.id.item_wx_list_value2, item.getGood() > 0 ? ColorModel.TYPE_COLOR_GREEN : ColorModel.TYPE_COLOR_RED);
        }
        if (item.getTrend() < 0 && item.getGood() < 0) {
            helper.setTextColor(R.id.item_wx_list_name, ColorModel.TYPE_COLOR_RED);
        } else if (item.getGood() > 0 && item.getTrend() > 0) {
            helper.setTextColor(R.id.item_wx_list_name, ColorModel.TYPE_COLOR_GREEN);
        } else {
            helper.setTextColor(R.id.item_wx_list_name, ColorModel.TYPE_COLOR_DEFAULT);
        }
    }
}
