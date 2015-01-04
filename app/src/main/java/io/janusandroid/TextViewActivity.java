package io.janusandroid;

import android.widget.TextView;

/**
 * Created by VChabrette on 03/12/14.
 */
public interface TextViewActivity {
    TextView tv = null;

    public void setText(String line);

    public void setText(String line, int color);

    public String getApplicationName();
}
