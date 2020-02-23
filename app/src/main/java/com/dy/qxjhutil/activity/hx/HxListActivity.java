package com.dy.qxjhutil.activity.hx;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.ToastUtils;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.constant.NameModel;
import com.dy.qxjhutil.model.HxModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.RealmHelper;
import com.evrencoskun.tableview.TableView;
import com.evrencoskun.tableview.listener.SimpleTableViewListener;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmQuery;
import io.realm.Sort;

public class HxListActivity extends BaseActivity {

    private List<RowHeader> mRowHeaderList;//行
    private List<ColumnHeader> mColumnHeaderList;//列
    private List<List<Cell>> mCellList;//单元格

    private TableView tableView;
    private MyTableViewAdapter mAdapter;
//    private Filter tableViewFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hx);
        ToastUtils.showLong("感谢 老骚 大佬taptap上的《化形图鉴（第二版）带技能简述》,数据很详细，我借鉴(抄)的很舒服");
        mRowHeaderList = new ArrayList<>();
        mColumnHeaderList = new ArrayList<>();
        mCellList = new ArrayList<>();
        findViewById(R.id.act_hx_list_chongzhi).setOnClickListener(view -> {
            wx_name = wx_parent = hx_type = hx_name = hx_value = "";
            selectIndex = 0;
            showNewData();
        });

        initView();
    }

    private void initView() {
        tableView = findViewById(R.id.content_container);
        mAdapter = new MyTableViewAdapter();
        mAdapter.setConfirmListener(new MyTableViewAdapter.ConfirmListener() {
            @Override
            public void onClickIndex() {
                showPicker(-1);
            }
        });
        tableView.setAdapter(mAdapter);
//        tableViewFilter = new Filter(tableView);
        initClick();


        initData();
        initSelectData();
    }


    private void initData() {
        List<HxModel> hxModels = RealmHelper.getInstance(mContext).where(HxModel.class).sort(strings, sorts).findAll();
//        mColumnHeaderList.add(new ColumnHeader("武侠名称"));
        mColumnHeaderList.add(new ColumnHeader("种类名称"));
        mColumnHeaderList.add(new ColumnHeader("品级"));
        mColumnHeaderList.add(new ColumnHeader("修炼初始"));
        mColumnHeaderList.add(new ColumnHeader("替换初始"));
        mColumnHeaderList.add(new ColumnHeader("技能增强"));
        mColumnHeaderList.add(new ColumnHeader("新技能"));
        mColumnHeaderList.add(new ColumnHeader("阵容"));

        for (int i = 0; i < hxModels.size(); i++) {
            HxModel hxModel = hxModels.get(i);
            mRowHeaderList.add(new RowHeader(hxModel.getWxModel().getName_game()));
            List<Cell> cells = new ArrayList<>();
//            cells.add(new Cell(hxModel.getWxModel().getName_game()));
            cells.add(new Cell(hxModel.getHx_type() + "-" + hxModel.getHx_name()));
            cells.add(new Cell(hxModel.getHxLvName(), hxModel.getHx_id()));
            cells.add(new Cell(hxModel.getHx_value_1()));
            cells.add(new Cell(hxModel.getHx_value_2()));
            cells.add(new Cell(hxModel.getHx_value_3()));
            cells.add(new Cell(hxModel.getHx_value_4()));
            cells.add(new Cell(hxModel.getParent()));
            mCellList.add(cells);
        }
        mAdapter.setAllItems(mColumnHeaderList, mRowHeaderList, mCellList);
    }

    private void initClick() {
        tableView.setTableViewListener(new SimpleTableViewListener() {
            @Override
            public void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {
                super.onCellClicked(cellView, column, row);
            }

            @Override
            public void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {
                super.onCellLongPressed(cellView, column, row);
            }

            @Override
            public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {
                showPicker(column);
//                super.onColumnHeaderClicked(columnHeaderView, column);
            }

            @Override
            public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int column) {
                super.onColumnHeaderLongPressed(columnHeaderView, column);
            }

            @Override
            public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {
                super.onRowHeaderClicked(rowHeaderView, row);
            }

            @Override
            public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder rowHeaderView, int row) {
                super.onRowHeaderLongPressed(rowHeaderView, row);
            }
        });
    }

    private OptionsPickerView mPickerView;

    /**
     * 打开选择器
     **/
    private void showPicker(int i) {
        OptionsPickerBuilder pickerBuilder = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                selectPicker(i, options1, options2, options3);
            }
        }).setOptionsSelectChangeListener(new OnOptionsSelectChangeListener() {
            @Override
            public void onOptionsSelectChanged(int options1, int options2, int options3) {
                List<WXModel> wxModels = new ArrayList<>();
                List<String> all = new ArrayList<>();
                all.add("全部");
                switch (i) {
                    case -1:
                        /**
                         * 选择武侠
                         **/
                        if (options1 == 0) {
                            mPickerView.setNPicker(name_1, all, null);
                        } else {
                            wxModels = RealmHelper.getInstance(mContext).where(WXModel.class)
                                    .equalTo("parent", name_1.get(options1)).findAll();
                            name_2 = new ArrayList<>();
                            name_2.add("全部");
                            for (int j = 0; j < wxModels.size(); j++) {
                                name_2.add(wxModels.get(j).getName_game());
                            }
                            mPickerView.setNPicker(name_1, name_2, null);
                        }
                        mPickerView.setSelectOptions(options1, options2);
                        break;
                    case 0:
                        if (options1 == 0) {
                            mPickerView.setNPicker(type_1, all, null);
                        } else {
                            setHxTypeDate(options1);
                            mPickerView.setNPicker(type_1, type_2, null);
                        }
                        mPickerView.setSelectOptions(options1, options2);
                        break;
                    default:
                        break;
                }
            }
        }).setCyclic(false, false, false)
                .setLabels("", "", "");
        switch (i) {
            case -1:
                mPickerView = pickerBuilder.setTitleText("选择武侠").setSelectOptions(1, 1).build();
                mPickerView.setNPicker(name_1, name_2, null);
                mPickerView.show();
                break;
            case 0:
                mPickerView = pickerBuilder.setTitleText("化形名称").setSelectOptions(1, 1).build();
                mPickerView.setNPicker(type_1, type_2, null);
                mPickerView.show();
                break;
            case 1:
                break;
            case 2:
                mPickerView = pickerBuilder.setTitleText("修炼初始武学").build();
                mPickerView.setNPicker(value, null, null);
                mPickerView.show();
                break;
            case 3:
                mPickerView = pickerBuilder.setTitleText("替换初始武学").build();
                mPickerView.setNPicker(value, null, null);
                mPickerView.show();
                break;
            case 4:
                mPickerView = pickerBuilder.setTitleText("强化技能").build();
                mPickerView.setNPicker(value, null, null);
                mPickerView.show();
                break;
            case 5:
                mPickerView = pickerBuilder.setTitleText("新技能").build();
                mPickerView.setNPicker(value, null, null);
                mPickerView.show();
                break;
            case 6:
                mPickerView = pickerBuilder.setTitleText("武侠阵容").build();
                mPickerView.setNPicker(parent, null, null);
                mPickerView.show();
                break;
//            case 0:
//                mPickerView = pickerBuilder.setTitleText("选择武侠").setSelectOptions(1).build();
//                mPickerView.setNPicker(name_1, name_2, null);
//                mPickerView.show();
//                break;
//            case 1:
//                mPickerView = pickerBuilder.setTitleText("化形名称").setSelectOptions(1).build();
//                mPickerView.setNPicker(type_1, type_2, null);
//                mPickerView.show();
//                break;
//            case 2:
//                break;
//            case 3:
//                mPickerView = pickerBuilder.setTitleText("修炼初始武学").build();
//                mPickerView.setNPicker(value, null, null);
//                mPickerView.show();
//                break;
//            case 4:
//                mPickerView = pickerBuilder.setTitleText("替换初始武学").build();
//                mPickerView.setNPicker(value, null, null);
//                mPickerView.show();
//                break;
//            case 5:
//                mPickerView = pickerBuilder.setTitleText("强化技能").build();
//                mPickerView.setNPicker(value, null, null);
//                mPickerView.show();
//                break;
//            case 6:
//                mPickerView = pickerBuilder.setTitleText("新技能").build();
//                mPickerView.setNPicker(value, null, null);
//                mPickerView.show();
//                break;
//            case 7:
//                mPickerView = pickerBuilder.setTitleText("武侠阵容").build();
//                mPickerView.setNPicker(parent, null, null);
//                mPickerView.show();
//                break;
            default:
                break;
        }
    }

    private String wx_name;
    private String wx_parent;
    private String hx_type;
    private String hx_name;
    private String hx_value;
    private int selectIndex;
    String[] strings = new String[]{"wx_name", "hx_type"};
    Sort[] sorts = new Sort[]{Sort.ASCENDING, Sort.ASCENDING};

    private void selectPicker(int i, int options1, int options2, int options3) {
//        wx_name = wx_parent = hx_type = hx_name = hx_value = "";
        selectIndex = i;
        switch (i) {
            case -1:
                wx_parent = "";
                if (options1 == 0) {
                    wx_name = "";
                } else {
                    if (options2 == 0) {
                        wx_name = "";
                        wx_parent = name_1.get(options1);
                    } else {
                        wx_name = name_2.get(options2);
                    }
                }
                break;
            case 0:
                hx_type = "";
                if (options1 == 0) {
                    hx_name = "";
                } else {
                    if (options2 == 0) {
                        hx_name = "";
                        hx_type = type_1.get(options1);
                    } else {
                        hx_name = type_2.get(options2);
                    }
                }
                break;
            case 1:
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                if (options1 == 2) {
                    //无
                    hx_value = "-";
                } else if (options1 == 1) {
                    //突破后
                    hx_value = "↑";
                } else {
                    //全部
                    hx_value = "";
                }
                break;
            case 6:
                if (options1 == 0) {
                    wx_parent = "";
                } else {
                    wx_parent = parent.get(options1);
                }
                break;
            default:
                break;
        }

        showNewData();
    }

    private void showNewData() {
        RealmQuery<HxModel> hxModels = RealmHelper.getInstance(mContext).where(HxModel.class).sort(strings, sorts);
        if (!TextUtils.isEmpty(wx_name) && wx_name.length() > 0) {
            hxModels.equalTo("wx_name", wx_name);
        }
        if (!TextUtils.isEmpty(wx_parent) && wx_parent.length() > 0) {
            hxModels.equalTo("parent", wx_parent);
        }
        if (!TextUtils.isEmpty(hx_type) && hx_type.length() > 0) {
            hxModels.equalTo("hx_type", hx_type);
        }
        if (!TextUtils.isEmpty(hx_name) && hx_name.length() > 0) {
            hxModels.equalTo("hx_name", hx_name);
        }
        switch (selectIndex) {
            case 2:
                if (!TextUtils.isEmpty(hx_value) && hx_value.length() > 0) {
                    hxModels.contains("hx_value_1", hx_value);
                }
                break;
            case 3:
                if (!TextUtils.isEmpty(hx_value) && hx_value.length() > 0) {
                    hxModels.contains("hx_value_2", hx_value);
                }
                break;
            case 4:
                if (!TextUtils.isEmpty(hx_value) && hx_value.length() > 0) {
                    hxModels.contains("hx_value_3", hx_value);
                }
                break;
            case 5:
                if (!TextUtils.isEmpty(hx_value) && hx_value.length() > 0) {
                    hxModels.contains("hx_value_4", hx_value);
                }
                break;
            default:
                break;
        }
        List<HxModel> modelList = hxModels.findAll();
        mRowHeaderList.clear();
        mCellList.clear();
        for (int i = 0; i < modelList.size(); i++) {
            HxModel hxModel = modelList.get(i);
            mRowHeaderList.add(new RowHeader(hxModel.getWx_name()));
            List<Cell> cells = new ArrayList<>();
//            cells.add(new Cell(hxModel.getWxModel().getName_game()));
            cells.add(new Cell(hxModel.getHx_type() + "-" + hxModel.getHx_name()));
            cells.add(new Cell(hxModel.getHxLvName(), hxModel.getHx_id()));
            cells.add(new Cell(hxModel.getHx_value_1()));
            cells.add(new Cell(hxModel.getHx_value_2()));
            cells.add(new Cell(hxModel.getHx_value_3()));
            cells.add(new Cell(hxModel.getHx_value_4()));
            cells.add(new Cell(hxModel.getParent()));
            mCellList.add(cells);
        }

        if (mCellList != null && mCellList.size() > 0) {
            mAdapter.setRowHeaderItems(mRowHeaderList);
            mAdapter.setCellItems(mCellList);
            mAdapter.notifyDataSetChanged();
        } else {
            ToastUtils.showLong("无数据，请点击右下角重置按钮");
        }
    }

/**
 * 选择了筛选条件
 **//*

    private void selectPicker(int i, int options1, int options2, int options3) {
        switch (i) {
            case 0:
                //选择武侠
                if (options1 == 0) {
                    tableViewFilter.set(7, null);
                    tableViewFilter.set(0, null);
                } else {
                    if (options2 == 0) {
                        tableViewFilter.set(7, null);
                        tableViewFilter.set(7, name_1.get(options1));
                    } else {
                        tableViewFilter.set(0, null);
                        tableViewFilter.set(0, name_2.get(options2));
                    }
                }
                break;
            case 1:
                //名称
                if (options1 == 0) {
                    tableViewFilter.set(1, null);
                } else {
                    if (options2 == 0) {
                        tableViewFilter.set(1, null);
                        tableViewFilter.set(1, type_1.get(options1));
                    } else {
                        tableViewFilter.set(null);
                        tableViewFilter.set(type_2.get(options2));
                    }
                }
                break;
            case 2:
                //品质，等级
                break;
            case 3:
                //修炼初始
                if (options1 == 3) {
                    //无
                    tableViewFilter.set(3,null);
                    tableViewFilter.set(3, "-");
                } else if (options1 == 2) {
                    //有
                    tableViewFilter.set(3,null);
                    tableViewFilter.set(3, "修炼");
                } else if (options1 == 1) {
                    //突破后
                    tableViewFilter.set(3,null);
                    tableViewFilter.set(3, "↑");
                } else {
                    tableViewFilter.set(3,null);
                    tableViewFilter.set(3, "");
                }
                break;
            case 4:
                //替换初始
                if (options1 == 3) {
                    //无
                    tableViewFilter.set(4, null);
                    tableViewFilter.set(4, "-");
                } else if (options1 == 2) {
                    //有
                    tableViewFilter.set(4, null);
                    tableViewFilter.set(4, "修炼");
                } else if (options1 == 1) {
                    //突破后
                    tableViewFilter.set(4, null);
                    tableViewFilter.set(4, "↑");
                } else {
                    tableViewFilter.set(4, null);
                    tableViewFilter.set(4, "");
                }
                break;
            case 5:
                //技能加强
                if (options1 == 3) {
                    //无
                    tableViewFilter.set(5, null);
                    tableViewFilter.set(5, "-");
                } else if (options1 == 2) {
                    //有
                    tableViewFilter.set(5, null);
                    tableViewFilter.set(5, "修炼");
                } else if (options1 == 1) {
                    //突破后
                    tableViewFilter.set(5, null);
                    tableViewFilter.set(5, "↑");
                } else {
                    tableViewFilter.set(5, null);
                    tableViewFilter.set(5, "");
                }
                break;
            case 6:
                //新技能
                if (options1 == 3) {
                    //无
                    tableViewFilter.set(6, null);
                    tableViewFilter.set(6, "-");
                } else if (options1 == 2) {
                    //有
                    tableViewFilter.set(6, null);
                    tableViewFilter.set(6, "修炼");
                } else if (options1 == 1) {
                    //突破后
                    tableViewFilter.set(6, null);
                    tableViewFilter.set(6, "↑");
                } else {
                    tableViewFilter.set(6, null);
                    tableViewFilter.set(6, "");
                }
                break;
            case 7:
                //阵容
                if (options1 == 0) {
                    tableViewFilter.set(7, null);
                } else {
                    tableViewFilter.set(7, null);
                    tableViewFilter.set(7, parent.get(options2));
                }
                break;
            default:
                break;
        }
    }
*/

    /**
     * 武侠名称
     **/
    private List<String> name_1, name_2;
    /**
     * 化形类型
     **/
    private List<String> type_1, type_2;
    /**
     * 属性，- 为空 ↑为突破后
     **/
    private List<String> value;
    /**
     * 阵容
     **/
    private List<String> parent;

    /**
     * 初始化筛选器
     **/
    private void initSelectData() {
        name_1 = new ArrayList<>();
        name_2 = new ArrayList<>();
        type_1 = new ArrayList<>();
        type_2 = new ArrayList<>();
        value = new ArrayList<>();
        parent = new ArrayList<>();

        name_1.add("全部");
        name_1.add(NameModel.Parent_2);
        name_1.add(NameModel.Parent_3);
        name_1.add(NameModel.Parent_4);
        name_1.add(NameModel.Parent_5);
        List<WXModel> wxModels = RealmHelper.getInstance(mContext)
                .where(WXModel.class).equalTo("parent", NameModel.Parent_2).findAll();
        name_2 = new ArrayList<>();
        name_2.add("全部");
        for (int j = 0; j < wxModels.size(); j++) {
            name_2.add(wxModels.get(j).getName_game());
        }

        type_1.add("全部");
        type_1.add(NameModel.HX_TYPE_武神);
        type_1.add(NameModel.HX_TYPE_飞天);
        type_1.add(NameModel.HX_TYPE_粽子);
        type_1.add(NameModel.HX_TYPE_傀儡);
        type_1.add(NameModel.HX_TYPE_木鸢);

        setHxTypeDate(1);

        value.add("全部");
        value.add("突破后");
        value.add("无");
//        value.add("有");

        parent.add("全部");
        parent.add(NameModel.Parent_2);
        parent.add(NameModel.Parent_3);
        parent.add(NameModel.Parent_4);
        parent.add(NameModel.Parent_5);
    }

    private void setHxTypeDate(int type) {
        type_2 = new ArrayList<>();
        type_2.add("全部");
        switch (type) {
            case 0:
                break;
            case 1:
                type_2.add(NameModel.HX_ws_tg_武神_天罡);
                type_2.add(NameModel.HX_ws_tj_武神_天机);
                type_2.add(NameModel.HX_ws_tk_武神_天魁);
                type_2.add(NameModel.HX_ws_ty_武神_天勇);
                type_2.add(NameModel.HX_ws_tx_武神_天闲);
                type_2.add(NameModel.HX_ws_tw_武神_天威);
                type_2.add(NameModel.HX_ws_tm_武神_天猛);
                type_2.add(NameModel.HX_ws_tx_武神_天雄);
                break;
            case 2:
                type_2.add(NameModel.HX_ft_bf_飞天_毕方);
                type_2.add(NameModel.HX_ft_bx_飞天_辟邪);
                type_2.add(NameModel.HX_ft_cm_飞天_重明);
                type_2.add(NameModel.HX_ft_jm_飞天_九命);
                type_2.add(NameModel.HX_ft_tl_飞天_天禄);
                type_2.add(NameModel.HX_ft_bj_飞天_白将);
                type_2.add(NameModel.HX_ft_fj_飞天_飞将);
                type_2.add(NameModel.HX_ft_bh_飞天_不化);
                break;
            case 3:
                type_2.add(NameModel.HX_zz_ds_粽子_地煞);
                type_2.add(NameModel.HX_zz_dy_粽子_地勇);
                type_2.add(NameModel.HX_zz_dk_粽子_地魁);
                type_2.add(NameModel.HX_zz_dx_粽子_地雄);
                type_2.add(NameModel.HX_zz_dj_粽子_地杰);
                type_2.add(NameModel.HX_zz_dq_粽子_地奇);
                type_2.add(NameModel.HX_zz_dy_粽子_地英);
                type_2.add(NameModel.HX_zz_dw_粽子_地威);
                break;
            case 4:
                type_2.add(NameModel.HX_kl_bt_傀儡_碧铜);
                type_2.add(NameModel.HX_kl_zs_傀儡_紫砂);
                type_2.add(NameModel.HX_kl_gt_傀儡_古铜);
                type_2.add(NameModel.HX_kl_ht_傀儡_黑陶);
                type_2.add(NameModel.HX_kl_qc_傀儡_青瓷);
                type_2.add(NameModel.HX_kl_lz_傀儡_绿竹);
                type_2.add(NameModel.HX_kl_hy_傀儡_红鸢);
                type_2.add(NameModel.HX_kl_ly_傀儡_蓝玉);
                break;
            case 5:
                type_2.add(NameModel.HX_my_hy_木鸢_皓月);
                type_2.add(NameModel.HX_my_yh_木鸢_业火);
                type_2.add(NameModel.HX_my_lr_木鸢_烈日);
                type_2.add(NameModel.HX_my_jl_木鸢_惊雷);
                type_2.add(NameModel.HX_my_ly_木鸢_流云);
                type_2.add(NameModel.HX_my_cd_木鸢_赤电);
                type_2.add(NameModel.HX_my_hy_木鸢_虹雨);
                type_2.add(NameModel.HX_my_jf_木鸢_疾风);
                break;
            default:
                break;
        }
    }
}
