package lk.portion.myapplication.Interface;

import lk.portion.myapplication.Model.AIModel.RequestContent;
import lk.portion.myapplication.Model.AIModel.Responce;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface GeminiAI {
    @Headers({
            "Content-Type: application/json"
    })
    @POST
    Call<Responce> responceAI(@Url String url, @Body RequestContent request);
}
