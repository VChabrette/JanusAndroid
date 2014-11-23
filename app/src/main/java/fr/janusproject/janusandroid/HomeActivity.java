package fr.janusproject.janusandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.arakhne.afc.vmutil.Android;

import fr.janusproject.janusandroid.agents.HelloWorldAgent;
import io.janusproject.kernel.Kernel;

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
        Log.e("--","test");
        try {
            Android.initialize(this);
        } catch (Android.AndroidException e) {
            Log.e("JanusApplication", e.getLocalizedMessage(), e);
        }

        Kernel janusKernel = null;
        HelloWorldAgent agent = null;


        janusKernel = Kernel.create();
        agent = new HelloWorldAgent(null);
        janusKernel.spawn(agent.getClass());
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
