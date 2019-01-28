package uk.ac.solent.mapping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(38.55,  -27.7755));
        mv.getController().setZoom(14);

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);

        Button button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(this);

    }

    //38.5500/-27.7755



    public void onClick(View view){
        EditText etLat = (EditText)findViewById(R.id.lat);
        EditText etLon = (EditText)findViewById(R.id.lon);

        String stringEtLat = etLat.getText().toString();
        String stringEtLon = etLon.getText().toString();


        Float latitude = Float.parseFloat(stringEtLat);
        Float longitude = Float.parseFloat(stringEtLon);


        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(latitude,longitude));

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);
    }

}
