package com.example.kendoquizv11;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LinksActivity extends AppCompatActivity {
    LinksStorage storage = new LinksStorage();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        ImageView goBack = findViewById(R.id.imageArrow);
        goBack.setOnClickListener(v -> finish());

        Button btnYoutube1 = findViewById(R.id.btnYouTube1);
        Button btnYoutube2 = findViewById(R.id.btnYouTube2);
        Button btnSite1 = findViewById(R.id.btnSite1);
        Button btnSite2 = findViewById(R.id.btnSite2);

        btnYoutube1.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storage.kendoGuideYouTube));
            startActivity(browserIntent);
        });

        btnYoutube2.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storage.ajkfLinkYouTube));
            startActivity(browserIntent);
        });

        btnSite1.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storage.kendoGuideSite));
            startActivity(browserIntent);
        });

        btnSite2.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(storage.ajkfLinkSite));
            startActivity(browserIntent);
        });
    }
}

class LinksStorage {
    public final String kendoGuideSite = "https://www.kendo-guide.com/";
    public final String kendoGuideYouTube = "https://www.youtube.com/@KendoGuide";
    public final String ajkfLinkSite = "https://www.kendo.or.jp/en/";
    public final String ajkfLinkYouTube = "https://www.youtube.com/user/ZennipponKendoRenmei";

    public LinksStorage() {}
}