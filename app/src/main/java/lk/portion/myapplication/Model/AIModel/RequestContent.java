package lk.portion.myapplication.Model.AIModel;

import java.util.List;

public class RequestContent {
    private List<ContentPart> contents;

    public RequestContent(List<ContentPart> contents) {
        this.contents = contents;
    }

    public List<ContentPart> getContents() {
        return contents;
    }

    public void setContents(List<ContentPart> contents) {
        this.contents = contents;
    }
}
