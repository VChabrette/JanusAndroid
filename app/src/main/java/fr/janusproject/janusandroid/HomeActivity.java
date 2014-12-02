package fr.janusproject.janusandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.arakhne.afc.vmutil.Android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import fr.janusproject.janusandroid.agents.HelloWorldAgent;
import io.janusproject.Boot;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button janus_btn = new Button(this);
        janus_btn = (Button) findViewById(R.id.btn_janus);
        janus_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchJanus();
            }
        });
    }

    public void launchJanus(){
        try {
            Android.initialize(this);
            Method m = Boot.class.getMethod("main", new Class[]{String[].class});

            HelloWorldAgent agent = new HelloWorldAgent(null);
            String[] args = new String[1];
            args[0] = agent.getClass().getName();

            m.invoke(Boot.class, new Object[]{args});

        } catch (Android.AndroidException e) {
            e.printStackTrace();
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
