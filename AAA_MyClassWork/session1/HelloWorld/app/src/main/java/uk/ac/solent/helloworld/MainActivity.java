package uk.ac.solent.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //"acitvity_main" corresponds to xml file
        setContentView(R.layout.activity_main);

        /* Create a TextView, and set it as the main content view of the activity
        TextView tv = new TextView(this);

        tv.setText("Hello World!!!");
        setContentView(tv);
        */
    }
}
