package uk.ac.solent.mapping;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class SetLocationActivity extends AppCompatActivity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_location);
        Button regular = (Button) findViewById(R.id.btn);
        regular.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        boolean setlocation = true;

        EditText etLat = (EditText)findViewById(R.id.lat);
        EditText etLon = (EditText)findViewById(R.id.lon);

        String stringEtLat = etLat.getText().toString();
        String stringEtLon = etLon.getText().toString();

        Float lat = Float.parseFloat(stringEtLat);
        Float lon = Float.parseFloat(stringEtLon);

        bundle.putBoolean("com.example.setlocation",setlocation);
        bundle.putFloat("com.example.latitude", lat);
        bundle.putFloat("com.example.longitude", lon);

        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();
    }
}
