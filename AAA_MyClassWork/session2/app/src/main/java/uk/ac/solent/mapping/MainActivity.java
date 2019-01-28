package uk.ac.solent.mapping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(38.55,  -27.7755));
        mv.getController().setZoom(14);

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);

    }

    //38.5500/-27.7755


}
