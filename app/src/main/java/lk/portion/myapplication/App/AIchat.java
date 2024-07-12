package lk.portion.myapplication.App;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lk.portion.myapplication.Model.AIModel.ContentPart;
import lk.portion.myapplication.Model.AIModel.RequestContent;
import lk.portion.myapplication.Model.AIModel.Responce;
import lk.portion.myapplication.Model.AIModel.Textpart;
import lk.portion.myapplication.Model.AIModel.candidates;
import lk.portion.myapplication.Model.AIModel.content;
import lk.portion.myapplication.Model.AIModel.parts;
import lk.portion.myapplication.R;
import lk.portion.myapplication.Utility.MarkdownUtils;
import lk.portion.myapplication.Utility.registerApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AIchat extends AppCompatActivity {
    private EditText editTextQuestion;
    private Button buttonAsk;
    private TextView textViewAnswer;
    ProgressBar progressBar;

    private static final String API_KEY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aichat);

        editTextQuestion = findViewById(R.id.editTextQuestion);
        buttonAsk = findViewById(R.id.buttonAsk);
        textViewAnswer = findViewById(R.id.textViewAnswer);
        progressBar = findViewById(R.id.progressBar);
        //textView.setText(Html.fromHtml(formattedText));

        textViewAnswer.setVisibility(View.GONE);

        buttonAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userTX = editTextQuestion.getText().toString();
                Request(userTX);
            }
        });
    }

    public void Request(String userText) {
        progressBar.setVisibility(View.VISIBLE);
        Textpart textPart = new Textpart(userText);
        List<Textpart> textParts = new ArrayList<>();
        textParts.add(textPart);

        ContentPart contentPart = new ContentPart(textParts);
        List<ContentPart> contentParts = new ArrayList<>();
        contentParts.add(contentPart);

        RequestContent requestContent = new RequestContent(contentParts);
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + API_KEY;

        Call<Responce> responceCall = registerApiClient.Ai().responceAI(url, requestContent);
        responceCall.enqueue(new Callback<Responce>() {
            @Override
            public void onResponse(Call<Responce> call, Response<Responce> response) {
                if (response.isSuccessful()) {
                    StringBuilder answerBuilder = new StringBuilder();
                    textViewAnswer.setVisibility(View.VISIBLE);
                    Responce res = response.body();
                    if (res != null) {
                        for (candidates candi : res.getCandidates()) {
                            content cont = candi.getContent();
                            for (parts part : cont.getPart()) {
                                answerBuilder.append(part.getText()).append("\n\n");
                            }
                        }
                        progressBar.setVisibility(View.GONE);
                        String htmlText = MarkdownUtils.markdownToHtml(answerBuilder.toString());
                        textViewAnswer.setText(Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY));
                        editTextQuestion.setText("");

                    }
                }
            }

            @Override
            public void onFailure(Call<Responce> call, Throwable t) {
                textViewAnswer.setVisibility(View.VISIBLE);
                textViewAnswer.setText("Request failed: " + t.getMessage());
            }
        });
    }
}
