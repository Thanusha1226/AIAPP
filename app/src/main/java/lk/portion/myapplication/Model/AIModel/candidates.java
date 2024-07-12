package lk.portion.myapplication.Model.AIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class candidates {
    @SerializedName("content")
    @Expose
    content content;
    public candidates(content content){
        this.content= content;
    }

    public content getContent() {
        return content;
    }
}
