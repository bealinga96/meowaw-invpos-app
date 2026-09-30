package com.meowaw.pos;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.webkit.WebView;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "PrintPlugin")
public class PrintPlugin extends Plugin {
    @PluginMethod
    public void print(PluginCall call) {
        getActivity().runOnUiThread(() -> {
            try {
                WebView web = getBridge().getWebView();
                PrintManager pm = (PrintManager) getActivity().getSystemService(Context.PRINT_SERVICE);
                PrintDocumentAdapter adapter = web.createPrintDocumentAdapter("MeowAw Report");
                pm.print("MeowAw Report", adapter, new PrintAttributes.Builder().build());
                call.resolve();
            } catch (Exception e) {
                call.reject(String.valueOf(e.getMessage()));
            }
        });
    }
}
