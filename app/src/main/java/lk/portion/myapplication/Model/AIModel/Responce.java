package lk.portion.myapplication.Model.AIModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Responce {
    @SerializedName("candidates")
    @Expose
    lk.portion.myapplication.Model.AIModel.candidates[] candidates;

    public Responce(candidates[] candidates){
        this.candidates =candidates;
    }

    public lk.portion.myapplication.Model.AIModel.candidates[] getCandidates() {
        return candidates;
    }
}
