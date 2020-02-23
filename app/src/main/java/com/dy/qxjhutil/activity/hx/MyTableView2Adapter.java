package com.dy.qxjhutil.activity.hx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.dy.qxjhutil.R;
import com.dy.qxjhutil.constant.NameModel;
import com.evrencoskun.tableview.adapter.AbstractTableAdapter;
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder;

public class MyTableView2Adapter extends AbstractTableAdapter<ColumnHeader, RowHeader, Cell> {

    /**
     * This is sample CellViewHolder class
     * This viewHolder must be extended from AbstractViewHolder class instead of RecyclerView.ViewHolder.
     */
    class MyCellViewHolder extends AbstractViewHolder {

        public final TextView cell_textview;

        public MyCellViewHolder(View itemView) {
            super(itemView);
            cell_textview = (TextView) itemView.findViewById(R.id.item_call);
        }
    }


    /**
     * This is where you create your custom Cell ViewHolder. This method is called when Cell
     * RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given type to
     * represent an item.
     *
     * @param viewType : This value comes from #getCellItemViewType method to support different type
     *                 of viewHolder as a Cell item.
     * @see #getCellItemViewType(int);
     */
    @Override
    public AbstractViewHolder onCreateCellViewHolder(ViewGroup parent, int viewType) {
        // Get cell xml layout
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_call, parent, false);
        // Create a Custom ViewHolder for a Cell item.
        return new MyCellViewHolder(layout);
    }

    /**
     * That is where you set Cell View Model data to your custom Cell ViewHolder. This method is
     * Called by Cell RecyclerView of the TableView to display the data at the specified position.
     * This method gives you everything you need about a cell item.
     *
     * @param holder         : This is one of your cell ViewHolders that was created on
     *                       ```onCreateCellViewHolder``` method. In this example we have created
     *                       "MyCellViewHolder" holder.
     * @param cellItemModel  : This is the cell view model located on this X and Y position. In this
     *                       example, the model class is "Cell".
     * @param columnPosition : This is the X (Column) position of the cell item.
     * @param rowPosition    : This is the Y (Row) position of the cell item.
     * @see #onCreateCellViewHolder(ViewGroup, int);
     */
    @Override
    public void onBindCellViewHolder(AbstractViewHolder holder, Cell cellItemModel, int columnPosition, int rowPosition) {

        Cell cell = cellItemModel;

        // Get the holder to update cell item text
        MyCellViewHolder viewHolder = (MyCellViewHolder) holder;
        viewHolder.cell_textview.setText(cell.getStr());
        viewHolder.cell_textview.setTextColor(NameModel.hx_lvcolor_default);
        viewHolder.itemView.getLayoutParams().width = getWidth(columnPosition);

        switch (columnPosition) {
            case 2:
                //品级
                switch (cell.getStr().toString()) {
                    case "优秀":
                        viewHolder.cell_textview.setTextColor(NameModel.hx_lvcolor_1);
                        break;
                    case "稀有":
                        viewHolder.cell_textview.setTextColor(NameModel.hx_lvcolor_2);
                        break;
                    case "史诗":
                        viewHolder.cell_textview.setTextColor(NameModel.hx_lvcolor_3);
                        break;
                    case "传奇":
                        viewHolder.cell_textview.setTextColor(NameModel.hx_lvcolor_4);
                        break;
                    case "神话":
                        viewHolder.cell_textview.setTextColor(NameModel.hx_lvcolor_5);
                        break;
                    default:
                        viewHolder.cell_textview.setTextColor(NameModel.hx_lvcolor_default);
                        break;
                }

                break;
            default:
                break;
        }
        viewHolder.cell_textview.requestLayout();
    }


    /**
     * This is sample CellViewHolder class.
     * This viewHolder must be extended from AbstractViewHolder class instead of RecyclerView.ViewHolder.
     */
    class MyColumnHeaderViewHolder extends AbstractViewHolder {

        public final TextView column_textview;
        public final ImageView column_img;

        public MyColumnHeaderViewHolder(View itemView) {
            super(itemView);
            column_textview = (TextView) itemView.findViewById(R.id.item_column);
            column_img = itemView.findViewById(R.id.item_column_img);
        }
    }

    /**
     * This is where you create your custom Column Header ViewHolder. This method is called when
     * Column Header RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item.
     *
     * @param viewType : This value comes from "getColumnHeaderItemViewType" method to support
     *                 different type of viewHolder as a Column Header item.
     * @see #getColumnHeaderItemViewType(int);
     */
    @Override
    public AbstractViewHolder onCreateColumnHeaderViewHolder(ViewGroup parent, int viewType) {

        // Get Column Header xml Layout
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_column, parent, false);

        // Create a ColumnHeader ViewHolder
        return new MyColumnHeaderViewHolder(layout);
    }

    /**
     * That is where you set Column Header View Model data to your custom Column Header ViewHolder.
     * This method is Called by ColumnHeader RecyclerView of the TableView to display the data at
     * the specified position. This method gives you everything you need about a column header
     * item.
     *
     * @param holder                : This is one of your column header ViewHolders that was created on
     *                              ```onCreateColumnHeaderViewHolder``` method. In this example we have created
     *                              "MyColumnHeaderViewHolder" holder.
     * @param columnHeaderItemModel : This is the column header view model located on this X position. In this
     *                              example, the model class is "ColumnHeader".
     * @param columnPosition        : This is the X (Column) position of the column header item.
     * @see #onCreateColumnHeaderViewHolder(ViewGroup, int) ;
     */
    @Override
    public void onBindColumnHeaderViewHolder(AbstractViewHolder holder, ColumnHeader columnHeaderItemModel, int columnPosition) {

        ColumnHeader columnHeader = (ColumnHeader) columnHeaderItemModel;

        // Get the holder to update cell item text
        MyColumnHeaderViewHolder columnHeaderViewHolder = (MyColumnHeaderViewHolder) holder;
        columnHeaderViewHolder.column_textview.setText(columnHeader.getStr());
        columnHeaderViewHolder.itemView.getLayoutParams().width = getWidth(columnPosition);
        columnHeaderViewHolder.column_img.setVisibility(columnPosition == 2 ? View.GONE : View.VISIBLE);
        columnHeaderViewHolder.itemView.requestLayout();
    }

    private int getWidth(int position) {
        switch (position) {
            case 0:
                return ConvertUtils.dp2px(80);
            case 1:
                return ConvertUtils.dp2px(60);
            case 2:
                return ConvertUtils.dp2px(40);
            case 3:
                return ConvertUtils.dp2px(180);
            case 4:
                return ConvertUtils.dp2px(180);
            case 5:
                return ConvertUtils.dp2px(40);
//            case 0:
//                return ConvertUtils.dp2px(80);
//            case 1:
//                return ConvertUtils.dp2px(80);
//            case 2:
//                return ConvertUtils.dp2px(40);
//            case 3:
//                return ConvertUtils.dp2px(100);
//            case 4:
//                return ConvertUtils.dp2px(80);
//            case 5:
//                return ConvertUtils.dp2px(180);
//            case 6:
//                return ConvertUtils.dp2px(180);
//            case 7:
//                return ConvertUtils.dp2px(40);
            default:
                return ViewGroup.LayoutParams.WRAP_CONTENT;
        }
    }

    /**
     * This is sample CellViewHolder class.
     * This viewHolder must be extended from AbstractViewHolder class instead of RecyclerView.ViewHolder.
     */
    class MyRowHeaderViewHolder extends AbstractViewHolder {

        public final TextView row_header_textview;

        public MyRowHeaderViewHolder(View itemView) {
            super(itemView);
            row_header_textview = (TextView) itemView.findViewById(R.id.item_row);
        }
    }


    /**
     * This is where you create your custom Row Header ViewHolder. This method is called when
     * Row Header RecyclerView of the TableView needs a new RecyclerView.ViewHolder of the given
     * type to represent an item.
     *
     * @param viewType : This value comes from "getRowHeaderItemViewType" method to support
     *                 different type of viewHolder as a row Header item.
     * @see #getRowHeaderItemViewType(int);
     */
    @Override
    public AbstractViewHolder onCreateRowHeaderViewHolder(ViewGroup parent, int viewType) {

        // Get Row Header xml Layout
        View layout = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        // Create a Row Header ViewHolder
        return new MyRowHeaderViewHolder(layout);
    }

    /**
     * That is where you set Row Header View Model data to your custom Row Header ViewHolder. This
     * method is Called by RowHeader RecyclerView of the TableView to display the data at the
     * specified position. This method gives you everything you need about a row header item.
     *
     * @param holder             : This is one of your row header ViewHolders that was created on
     *                           ```onCreateRowHeaderViewHolder``` method. In this example we have created
     *                           "MyRowHeaderViewHolder" holder.
     * @param rowHeaderItemModel : This is the row header view model located on this Y position. In this
     *                           example, the model class is "RowHeader".
     * @param rowPosition        : This is the Y (row) position of the row header item.
     * @see #onCreateRowHeaderViewHolder(ViewGroup, int) ;
     */
    @Override
    public void onBindRowHeaderViewHolder(AbstractViewHolder holder, RowHeader rowHeaderItemModel, int rowPosition) {
        RowHeader rowHeader = (RowHeader) rowHeaderItemModel;
        MyRowHeaderViewHolder rowHeaderViewHolder = (MyRowHeaderViewHolder) holder;
        rowHeaderViewHolder.row_header_textview.setText(rowHeader.getStr());
    }


    @Override
    public View onCreateCornerView(ViewGroup parent) {
        // Get Corner xml layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_corner, parent, false);
        view.findViewById(R.id.item_corner).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onClickIndex();
                }
            }
        });
        return view;
    }

    @Override
    public int getColumnHeaderItemViewType(int columnPosition) {
        // The unique ID for this type of column header item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
        return 0;
    }

    @Override
    public int getRowHeaderItemViewType(int rowPosition) {
        // The unique ID for this type of row header item
        // If you have different items for Row Header View by Y (Row) position,
        // then you should fill this method to be able create different
        // type of RowHeaderViewHolder on "onCreateRowHeaderViewHolder"
        return 0;
    }

    @Override
    public int getCellItemViewType(int columnPosition) {
        // The unique ID for this type of cell item
        // If you have different items for Cell View by X (Column) position,
        // then you should fill this method to be able create different
        // type of CellViewHolder on "onCreateCellViewHolder"
        return 0;
    }


    public interface ConfirmListener {
        void onClickIndex();
    }

    private ConfirmListener mListener;

    public void setConfirmListener(ConfirmListener listener) {
        this.mListener = listener;
    }

}