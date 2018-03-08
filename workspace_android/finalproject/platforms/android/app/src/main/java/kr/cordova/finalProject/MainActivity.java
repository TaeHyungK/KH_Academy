/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package kr.cordova.finalProject;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.cordova.*;
import org.apache.cordova.engine.SystemWebViewClient;
import org.apache.cordova.engine.SystemWebViewEngine;

public class MainActivity extends CordovaActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }
        /*추가한 부분1*/
        super.init();
        SystemWebViewEngine systemWebViewEngine = (SystemWebViewEngine)appView.getEngine();
        WebViewClient myWebViewClient = new MyWebViewClient(systemWebViewEngine);
        WebView webView = (WebView)systemWebViewEngine.getView();
        webView.setWebViewClient(myWebViewClient);
        /*추가한 부분1 끝*/

        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    }
    /*추가한 부분2 시작*/
    class MyWebViewClient extends SystemWebViewClient {

        public MyWebViewClient(SystemWebViewEngine parentEngine) {
            super(parentEngine);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
    /*추가한 부분2 끝*/
}