package fr.janusproject.janusandroid;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.arakhne.afc.vmutil.Android;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import fr.janusproject.janusandroid.agents.HelloWorldAgent;
import fr.janusproject.janusandroid.janus.Boot;

public class HomeActivity extends Activity implements TextViewActivity {

    /** Tag for logs.
     */
    protected static final String TAG = "HomeActivity"; //$NON-NLS-1$


    private TextView tv;
    private Scroller tvs;
    private String applicationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Initialize the Arakhne-VM-utility library to
        // support this Android activity
        try {
            Android.initialize(this);
        }
        catch (Android.AndroidException e) {
            Log.e(TAG, e.getLocalizedMessage(), e);
        }

        // Find application name
        final PackageManager pm = getApplicationContext().getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo(this.getPackageName(), 0);
        } catch (final PackageManager.NameNotFoundException e) {
            ai = null;
        }
        applicationName = (String) (ai != null ? pm.getApplicationLabel(ai) : "(unknown)");

        // Create OutputStream to bind sysout to log
        OutputStream infoOS = new OutputStream() {
            @Override
            public synchronized void write(byte[] buffer, int offset, int len) {
                setText(new String(buffer)); // Write in console textview
                Log.i(applicationName, new String(buffer)); // Log in LogCat
            }

            @Override
            public void write(int oneByte)
                    throws IOException {
                // Not really sure what to do here...
            }
        };
        OutputStream errorOS = new OutputStream() {
            @Override
            public synchronized void write(byte[] buffer, int offset, int len) {
                setText(new String(buffer), true); // Write in console textview (in red)
                Log.e(applicationName, new String(buffer)); // Log in LogCat
            }

            @Override
            public void write(int oneByte)
                    throws IOException {
                // Not really sure what to do here...
            }
        };

        System.setOut(new PrintStream(infoOS)); // Define Sout stream
        System.setErr(new PrintStream(errorOS)); // Define Serr stream

        // Start of onCreate
        ArrayList<Integer> test = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv = (TextView) findViewById(R.id.textViewLog);
        tvs = new Scroller(this);
        tv.setScroller(tvs);

        System.out.println("-- Application initialisation  --");
        System.out.println("ip address: " + OtherUtils.getIPAddress(true));

        //TextViewLogger tvlog = new TextViewLogger(this);
        //tvlog.start();
    }

    @Override
    public void setText(final String line, final boolean err) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This code will always run on the UI thread, therefore is safe to modify UI elements.
                tvs.computeScrollOffset();
                Boolean scroll = tvs.getCurrY() >= (tvs.getFinalY() - (2 * tv.getLineHeight()));
                tv.append(line);
                if (err) {
                    Spannable spannableText = (Spannable) tv.getText();
                    spannableText.setSpan(new ForegroundColorSpan(Color.RED), tv.getText().length() - line.length(), tv.getText().length(), 0);
                }
                if (scroll) {
                    tv.scrollTo(0, tvs.getFinalY());
                    //tvs.startScroll(tvs.getCurrX(), tvs.getCurrY(), 0, tvs.getFinalY()-tvs.getCurrY());
                    tv.computeScroll();
                }
            }
        });
    }

    @Override
    public void setText(final String line) {
        setText(line, false);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void onServerToggleClicked(View view) {
        // Is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
            launchJanus();
        } else {
        }
    }

    public void launchJanus() {
        System.out.println();
        System.out.println("-- Launch of the Janus Kernel --");
        System.out.println();
        try {
            Method m = Boot.class.getMethod("main", new Class[]{String[].class});



            HelloWorldAgent agent = new HelloWorldAgent(null);
            String[] args = new String[2];
            args[0] = "-o";
            args[1] = agent.getClass().getName();

            m.invoke(Boot.class, new Object[]{args});
       /* } catch (Android.AndroidException e) {
            e.printStackTrace();*/
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
