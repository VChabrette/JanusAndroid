package fr.janusproject.janusandroid;

import android.app.Activity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by VChabrette on 03/12/14.
 */
public class TextViewLogger extends Thread {
    private TextViewActivity caller;

    public TextViewLogger(TextViewActivity a){
        this.caller = a;
    }

    public void run(){
        try {
            //final Process process = Runtime.getRuntime().exec("logcat -i");
            final Process process = Runtime.getRuntime().exec("logcat "+caller.getApplicationName()+":I *:S");
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            StringBuilder log = new StringBuilder();
            String line;
            while (!this.isInterrupted()) {
                line = reader.readLine();
                if(line!=null){
                    log.append(line);
                    caller.setText(log.toString());
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
