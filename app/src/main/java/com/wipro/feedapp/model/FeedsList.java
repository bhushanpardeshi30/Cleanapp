
package com.wipro.feedapp.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FeedsList {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("rows")
    @Expose
    private ArrayList<Row> rows = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Row> getRows() {
        for (Iterator<Row> iterator = rows.iterator(); iterator.hasNext();) {
            Row string = iterator.next();
            if (string.getTitle()==null) {
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

}
