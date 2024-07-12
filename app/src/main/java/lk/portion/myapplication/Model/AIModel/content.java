package lk.portion.myapplication.Model.AIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class content {
    @SerializedName("parts")
    @Expose
    parts[] part;

    public content(parts[] parts){
        this.part =parts;
    }

    public parts[] getPart() {
        return part;
    }
}
