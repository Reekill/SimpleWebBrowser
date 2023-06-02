package stanleyd.anonimbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText urlText = (EditText)findViewById(R.id.urlText);
        ImageButton goToSite = (ImageButton) findViewById(R.id.goToSite);

        WebView web_view_simple;
        web_view_simple = (WebView) findViewById(R.id.webView);

        web_view_simple.clearCache(true);
        web_view_simple.clearHistory();
        web_view_simple.clearFormData();

        web_view_simple.setWebViewClient(new WebViewClient());
        web_view_simple.setWebChromeClient(new WebChromeClient());
        web_view_simple.getSettings().setJavaScriptEnabled(true);
        web_view_simple.getSettings().setLoadsImagesAutomatically(true);
        web_view_simple.getSettings().setDomStorageEnabled(true);




        goToSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web_view_simple.loadUrl(urlText.getText().toString().trim());
            }
        });
    }
}