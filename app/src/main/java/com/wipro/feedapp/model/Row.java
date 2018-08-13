
package com.wipro.feedapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Row {

    @SerializedName("title")
    @Expose private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("imageHref")
    @Expose
    private Object imageHref;

    public String getTitle() {

            return title;
    }

    public void setTitle(String title) {
        if(title!=null)
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description!=null)
            this.description = description;
    }

    public Object getImageHref() {
        return imageHref;
    }

    public void setImageHref(Object imageHref) {
        this.imageHref = imageHref;
    }

}
