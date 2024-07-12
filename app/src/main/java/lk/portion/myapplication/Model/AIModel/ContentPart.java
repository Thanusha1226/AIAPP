package lk.portion.myapplication.Model.AIModel;

import java.util.List;

import lk.portion.myapplication.Model.AIModel.Textpart;

public class ContentPart {
    private List<Textpart> parts;

    public ContentPart(List<Textpart> parts) {
        this.parts = parts;
    }

    public List<Textpart> getParts() {
        return parts;
    }

    public void setParts(List<Textpart> parts) {
        this.parts = parts;
    }
}
