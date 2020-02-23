package com.dy.qxjhutil.activity.hx;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.evrencoskun.tableview.listener.ITableViewListener;

public class MyTableViewListener implements ITableViewListener {

    @Override
    public void onCellClicked(@NonNull RecyclerView.ViewHolder cellView, int columnPosition, int
            rowPosition) {
        // Do what you want.
    }

    /**
     * Called when user long press any cell item.
     *
     * @param cellView : Long Pressed Cell ViewHolder.
     * @param column   : X (Column) position of Long Pressed Cell item.
     * @param row      : Y (Row) position of Long Pressed Cell item.
     */
    @Override
    public void onCellLongPressed(@NonNull RecyclerView.ViewHolder cellView, int column, int row) {
        // Do What you want
    }

    /**
     * Called when user click any column header item.
     *
     * @param columnHeaderView : Clicked Column Header ViewHolder.
     * @param columnPosition   : X (Column) position of Clicked Column Header item.
     */
    @Override
    public void onColumnHeaderClicked(@NonNull RecyclerView.ViewHolder columnHeaderView, int
            columnPosition) {
        // Do what you want.
    }

    /**
     * Called when user click any column header item.
     *
     * @param columnHeaderView : Long pressed Column Header ViewHolder.
     * @param columnPosition   : X (Column) position of Clicked Column Header item.
     * @version 0.8.5.1
     */
    @Override
    public void onColumnHeaderLongPressed(@NonNull RecyclerView.ViewHolder columnHeaderView, int
            columnPosition) {
        // Do what you want.
    }

    /**
     * Called when user click any Row Header item.
     *
     * @param rowHeaderView : Clicked Row Header ViewHolder.
     * @param rowPosition   : Y (Row) position of Clicked Row Header item.
     */
    @Override
    public void onRowHeaderClicked(@NonNull RecyclerView.ViewHolder rowHeaderView, int
            rowPosition) {
        // Do what you want.

    }

    /**
     * Called when user click any Row Header item.
     *
     * @param rowHeaderView : Long pressed Row Header ViewHolder.
     * @param rowPosition   : Y (Row) position of Clicked Row Header item.
     * @version 0.8.5.1
     */
    @Override
    public void onRowHeaderLongPressed(@NonNull RecyclerView.ViewHolder rowHeaderView, int
            rowPosition) {
        // Do what you want.

    }

}