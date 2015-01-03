package fr.janusproject.janusandroid;

import android.app.Activity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by VChabrette on 03/12/14.
 */
public class TextViewLogger extends Thread {
    private TextViewActivity caller;
    private String tag;
    private int color;

    public TextViewLogger(TextViewActivity caller, String tag, int color){
        this.caller = caller;
        this.color = color;
        this.tag = tag;
    }

    public TextViewLogger(TextViewActivity caller, String tag){
        this(caller, tag, -1);
    }

    public TextViewLogger(TextViewActivity caller, int color){
        this(caller, caller.getApplicationName(), color);
    }

    public TextViewLogger(TextViewActivity caller){
        this(caller, caller.getApplicationName(), -1);
    }

    public void run(){
        try {
            //final Process process = Runtime.getRuntime().exec("logcat -i");
            final Process process = Runtime.getRuntime().exec("logcat "+this.tag+":I *:S");
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            StringBuilder log = new StringBuilder();
            String line;
            while (!this.isInterrupted()) {
                line = reader.readLine();
                line+="\n";

                if(line!=null){
                    log.append(line);
                    if(this.color!=-1){
                        caller.setText(log.toString(), color);
                    }else{
                        caller.setText(log.toString());
                    }
                }
                Thread.sleep(10);
            }
            System.out.println("Thread interrupted");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
