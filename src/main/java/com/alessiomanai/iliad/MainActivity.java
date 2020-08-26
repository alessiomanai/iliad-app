package com.alessiomanai.iliad;

/**
 * Copyright (C) 2018  Alessio Manai
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 		alessiomanai.ml      alessio@manai.tk
 * */

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    /**LMAO SO COMPLEX CODE*/

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView finestra = findViewById(R.id.sito);

        finestra.clearCache(true);
        finestra.clearHistory();

        finestra.getSettings().setJavaScriptEnabled(true);
        finestra.getSettings().setLoadsImagesAutomatically(true);
        finestra.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url)
            {
                view.loadUrl("javascript:(function() { " +
                        "document.getElementById('navbar').style.display='none'; " +
                        "document.getElementById('footer').style.display='none'; " +
                        "})()");

            }
        });

        finestra.setHorizontalScrollBarEnabled(true);
        finestra.setVerticalScrollBarEnabled(true);

        finestra.loadUrl("https://www.iliad.it/account/");

    }
}
