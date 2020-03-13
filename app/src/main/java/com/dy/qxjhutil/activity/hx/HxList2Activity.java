package com.dy.qxjhutil.activity.hx;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.blankj.utilcode.util.SpanUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.base.BaseActivity;
import com.dy.qxjhutil.constant.NameModel;
import com.dy.qxjhutil.model.HxModel;
import com.dy.qxjhutil.model.WXModel;
import com.dy.qxjhutil.util.MmkvUtils;
import com.dy.qxjhutil.util.RealmHelper;
import com.evrencoskun.tableview.TableView;
import com.evrencoskun.tableview.listener.SimpleTableViewListener;
import com.xuexiang.xui.widget.dialog.materialdialog.MaterialDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import io.realm.RealmQuery;
import io.realm.Sort;

public class HxList2Activity extends BaseActivity {

    private List<RowHeader> mRowHeaderList;//行
    private List<ColumnHeader> mColumnHeaderList;//列
    private List<List<Cell>> mCellList;//单元格

    private TableView tableView;
    private MyTableView2Adapter mAdapter;
    private TextView tv;
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
            hx_star_lv = hx_level = 99;
            showNewData();
        });

        initView();
    }

    private void initView() {
        tableView = findViewById(R.id.content_container);
        tableView.setHasFixedWidth(false);
        mAdapter = new MyTableView2Adapter();
        mAdapter.setConfirmListener(() -> showPicker(-1));
        tableView.setAdapter(mAdapter);
        tv = findViewById(R.id.act_hx_list_tv);
//        tableViewFilter = new Filter(tableView);
        initClick();


        initData();
        initSelectData();
    }


    private void initData() {
        List<HxModel> hxModels = RealmHelper.getInstance(mContext).where(HxModel.class).findAll();
//        mColumnHeaderList.add(new ColumnHeader("武侠名称"));
        /**
         * 0 1 2 3 4 5
         **/
        mColumnHeaderList.add(new ColumnHeader("种类名称"));
        mColumnHeaderList.add(new ColumnHeader("评价"));
        mColumnHeaderList.add(new ColumnHeader("品质"));
        mColumnHeaderList.add(new ColumnHeader("初始属性"));
        mColumnHeaderList.add(new ColumnHeader("突破后属性"));
        mColumnHeaderList.add(new ColumnHeader("阵容"));

        for (int i = 0; i < hxModels.size(); i++) {
            HxModel hxModel = hxModels.get(i);
            mRowHeaderList.add(new RowHeader(hxModel.getWxModel().getName_game()));
            List<Cell> cells = new ArrayList<>();
            cells.add(new Cell(hxModel.getHx_type() + "-" + hxModel.getHx_name()));
            if (hxModel.getHx_star_lv() == 2) {
                cells.add(new Cell("★★★"));
            } else if (hxModel.getHx_star_lv() == 1) {
                cells.add(new Cell("☆☆"));
            } else {
                cells.add(new Cell("☆"));
            }
            cells.add(new Cell(hxModel.getHxLvName()));

            cells.add(new Cell(hxModel.getHx_value_default()));
            cells.add(new Cell(hxModel.getHx_value_up()));
            cells.add(new Cell(hxModel.getParent()));
            mCellList.add(cells);
        }
        tv.setText("共" + mCellList.size() + "条数据");
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
                if (mColumnHeaderList.size() > 0 || mCellList.size() > 0) {
                    showPicker(column);
                }else {
                    ToastUtils.showLong("初始化筛选条件");
                    wx_name = wx_parent = hx_type = hx_name = hx_value = "";
                    hx_star_lv = hx_level = 99;
                    showNewData();
                }
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
                mPickerView = pickerBuilder.setTitleText("化形名称").setSelectOptions(1, 0).build();
                mPickerView.setNPicker(type_1, type_2, null);
                mPickerView.show();
                break;
            case 1:
                mPickerView = pickerBuilder.setTitleText("感谢 william 大佬联合测评").setSelectOptions(1).build();

                hx_lv = new ArrayList<>();
                hx_lv.add("全部");
                hx_lv.add("强力推荐");
                hx_lv.add("凑合");
                hx_lv.add("辣鸡");
                if (MmkvUtils.isHideStar()) {
                    hx_lv.add("大佬威武,大佬碉堡了,大佬666");
                } else {
//                    hx_lv.add("瞎几把推荐,你是云玩家吧？");
                    hx_lv.add("瞎几把推荐,威廉就是个小菜鸡。");
                }

                mPickerView.setNPicker(hx_lv, null, null);
                mPickerView.show();
                break;
            case 2:
                mPickerView = pickerBuilder.setTitleText("化形品质").build();
                mPickerView.setNPicker(hx_prices, null, null);
                mPickerView.show();
                break;
            case 3:
                mPickerView = pickerBuilder.setTitleText("初始属性").build();
                mPickerView.setNPicker(value1, null, null);
                mPickerView.show();
                break;
            case 4:
                mPickerView = pickerBuilder.setTitleText("突破后属性").build();
                mPickerView.setNPicker(value2, null, null);
                mPickerView.show();
                break;
            case 5:
                mPickerView = pickerBuilder.setTitleText("武侠阵容").build();
                mPickerView.setNPicker(parent, null, null);
                mPickerView.show();
                break;
            default:
                break;
        }
    }

    private String wx_name;
    private String wx_parent;
    private String hx_type;
    private String hx_name;
    private String hx_value;
    private int hx_level = 99;
    private int hx_star_lv = 99;

    private int selectIndex;
    String[] strings = new String[]{"hx_id"};
    Sort[] sorts = new Sort[]{Sort.ASCENDING};

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
                switch (options1) {
                    case 1:
                        hx_star_lv = 2;
                        break;
                    case 2:
                        hx_star_lv = 1;
                        break;
                    case 3:
                        hx_star_lv = 0;
                        break;
                    case 4:
                        MmkvUtils.getMmkv().putBoolean("isHideStar", !MmkvUtils.isHideStar());
                        hx_star_lv = 99;
                        break;
                    case 0:
                    default:
                        hx_star_lv = 99;
                        break;
                }
                break;
            case 2:
                switch (options1) {
                    case 1:
                        hx_level = NameModel.HX_Lv_5_神话;
                        break;
                    case 2:
                        hx_level = NameModel.HX_Lv_4_传奇;
                        break;
                    case 3:
                        hx_level = NameModel.HX_Lv_3_史诗;
                        break;
                    case 4:
                        hx_level = NameModel.HX_Lv_2_稀有;
                        break;
                    case 5:
                        hx_level = NameModel.HX_Lv_1_优秀;
                        break;
                    case 0:
                        hx_level = 99;
                    default:
                        break;
                }
                break;
            case 3:
                /**
                 * 初始属性：强· 升· 替换
                 **/
                switch (options1) {
                    case 1:
                        hx_value = HxModel.type_qh_强化;
                        break;
                    case 2:
                        hx_value = HxModel.type_xl_修炼;
                        break;
                    case 3:
                        hx_value = HxModel.type_th_替换;
                        break;
                    case 0:
                    default:
                        hx_value = "";
                        break;
                }
                break;
            case 4:
                /**
                 * 突破后属性：新· 强·
                 **/
                switch (options1) {
                    case 1:
                        hx_value = HxModel.type_xz_新增;
                        break;
                    case 2:
                        hx_value = HxModel.type_qh_强化;
                        break;
                    case 0:
                    default:
                        hx_value = "";
                        break;
                }
                break;
            case 5:
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
        if (selectIndex == 1 && MmkvUtils.isHideStar()) {
            new MaterialDialog.Builder(this)
                    .customView(R.layout.dialog_img, true)
                    .title("我不要你觉得，我要我觉得")
                    .positiveText("好的")
                    .negativeText("没问题")
                    .show();
        }

        SpanUtils spanUtils = new SpanUtils();
        RealmQuery<HxModel> hxModels = RealmHelper.getInstance(mContext).where(HxModel.class);
        if (!TextUtils.isEmpty(wx_name) && wx_name.length() > 0) {
            hxModels.equalTo("wx_name", wx_name);
            spanUtils.append(" 武侠：" + wx_name);
        }
        if (!TextUtils.isEmpty(wx_parent) && wx_parent.length() > 0) {
            hxModels.equalTo("parent", wx_parent);
            spanUtils.append(" 阵容：" + wx_parent);
        }
        if (!TextUtils.isEmpty(hx_type) && hx_type.length() > 0) {
            hxModels.equalTo("hx_type", hx_type);
            spanUtils.append(" 化形：" + hx_type);
        }
        if (!TextUtils.isEmpty(hx_name) && hx_name.length() > 0) {
            hxModels.equalTo("hx_name", hx_name);
            spanUtils.append(" 化形：" + hx_name);
        }
        if (hx_star_lv != 99) {
            hxModels.equalTo("hx_star_lv", hx_star_lv);
            switch (hx_star_lv) {
                case 0:
                    spanUtils.append(" 评价：辣鸡");
                    break;
                case 1:
                    spanUtils.append(" 评价：凑合");
                    break;
                case 2:
                    spanUtils.append(" 评价：强力推荐");
                    break;
                default:
                    break;
            }
        }
        if (hx_level != 99) {
            hxModels.equalTo("hx_level", hx_level);
            switch (hx_level) {
                case 1:
                    spanUtils.append(" 品质：神话(红)");
                    break;
                case 2:
                    spanUtils.append(" 品质：传奇(橙)");
                    break;
                case 3:
                    spanUtils.append(" 品质：史诗(紫)");
                    break;
                case 4:
                    spanUtils.append(" 品质：稀有(蓝)");
                    break;
                case 5:
                    spanUtils.append(" 品质：优秀(绿)");
                    break;
                default:
                    break;
            }
        }
        switch (selectIndex) {
            case 3:
                if (!TextUtils.isEmpty(hx_value) && hx_value.length() > 0) {
                    hxModels.contains("hx_value_default", hx_value);
                    if (HxModel.type_qh_强化.equals(hx_value)) {
                        spanUtils.append(" 初始属性：强化初始技能");
                    } else if (HxModel.type_xl_修炼.equals(hx_value)) {
                        spanUtils.append(" 初始属性：修炼自带武学");
                    } else if (HxModel.type_th_替换.equals(hx_value)) {
                        spanUtils.append(" 初始属性：替换自带武学");
                    }
                }
                break;
            case 4:
                if (!TextUtils.isEmpty(hx_value) && hx_value.length() > 0) {
                    hxModels.contains("hx_value_up", hx_value);
                    if (HxModel.type_qh_强化.equals(hx_value)) {
                        spanUtils.append(" 初始属性：强化初始技能");
                    } else if (HxModel.type_xz_新增.equals(hx_value)) {
                        spanUtils.append(" 初始属性：新增技能");
                    }
                }
                break;
            default:
                break;
        }
        List<HxModel> modelList = hxModels.findAll();
        if (mRowHeaderList == null) {
            mRowHeaderList = new ArrayList<>();
        }
        mRowHeaderList.clear();
        if (mCellList == null) {
            mCellList = new ArrayList<>();
        }
        mCellList.clear();
        for (int i = 0; i < modelList.size(); i++) {
            HxModel hxModel = modelList.get(i);
            mRowHeaderList.add(new RowHeader(hxModel.getWx_name()));
            List<Cell> cells = new ArrayList<>();
            cells.add(new Cell(hxModel.getHx_type() + "-" + hxModel.getHx_name()));
            if (hxModel.getHx_star_lv() == 2) {
                cells.add(new Cell("★★★"));
            } else if (hxModel.getHx_star_lv() == 1) {
                cells.add(new Cell("☆☆"));
            } else {
                cells.add(new Cell("☆"));
            }
            cells.add(new Cell(hxModel.getHxLvName()));
            cells.add(new Cell(hxModel.getHx_value_default()));
            cells.add(new Cell(hxModel.getHx_value_up()));
            cells.add(new Cell(hxModel.getParent()));
            mCellList.add(cells);
        }
        tv.setText(new SpanUtils().appendLine("筛选结果：" + mCellList.size() + "条").append(spanUtils.create()).create());

        mAdapter.setRowHeaderItems(mRowHeaderList);
        mAdapter.setCellItems(mCellList);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 武侠名称
     **/
    private List<String> name_1, name_2;
    /**
     * 化形类型
     **/
    private List<String> type_1, type_2;
    /**
     * 普通属性和突破后属性
     **/
    private List<String> value1, value2;
    /**
     * 阵容
     **/
    private List<String> parent;
    /**
     * 武学推荐指数
     **/
    private List<String> hx_lv;
    private List<String> hx_prices;

    /**
     * 初始化筛选器
     **/
    private void initSelectData() {
        name_1 = new ArrayList<>();
        name_2 = new ArrayList<>();
        type_1 = new ArrayList<>();
        type_2 = new ArrayList<>();
        value1 = new ArrayList<>();
        value2 = new ArrayList<>();
        parent = new ArrayList<>();
        hx_lv = new ArrayList<>();
        hx_prices = new ArrayList<>();

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


        hx_prices.add("全部");
        hx_prices.add("神话(红)");
        hx_prices.add("传奇(橙)");
        hx_prices.add("史诗(紫)");
        hx_prices.add("稀有(蓝)");
        hx_prices.add("优秀(绿)");

        setHxTypeDate(1);

        value1.add("全部");
        value1.add("强化初始技能");
        value1.add("升级自带武学");
        value1.add("替换自带武学");

        value2.add("全部");
        value2.add("新技能");
        value2.add("强化初始技能");

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
