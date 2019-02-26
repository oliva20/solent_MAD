package uk.ac.solent.mapping;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private String currentMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Double lat = Double.parseDouble(pref.getString("lat", "51.05"));
        Double lon = Double.parseDouble(pref.getString("lon", "-0.72"));
        Integer zoom = Integer.parseInt(pref.getString("zoom", "16"));

        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(lat, lon));
        mv.getController().setZoom(zoom);

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);

    }

    //38.5500/-27.7755


    public void onClick(View view) {
        /* EditText etLat = (EditText) findViewById(R.id.lat);
        EditText etLon = (EditText) findViewById(R.id.lon);

        String stringEtLat = etLat.getText().toString();
        String stringEtLon = etLon.getText().toString();


        Float latitude = Float.parseFloat(stringEtLat);
        Float longitude = Float.parseFloat(stringEtLon);


        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(latitude, longitude));

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);
        */
    }


    // Inflates the XML menu and makes the menu appear in the activity

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    // Reacts to an item being selected
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.choosemap) {
            //react to the menu item being selected...
            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent, 0);
            return true;
        } else if (item.getItemId() == R.id.setlocationoption) {
            Intent intent = new Intent(this, SetLocationActivity.class);
            startActivityForResult(intent, 1);
            return true;
        } else if(item.getItemId() == R.id.prefsMenuItem){
            Intent intent = new Intent(this, PrefsActivity.class);
            startActivity( intent);
            return true;
        } else if(item.getItemId() == R.id.listactivityoption){
            Intent intent = new Intent(this, ExampleListActivity.class);
            startActivityForResult(intent, 0);
        }
        return false;
    }

    //called when the activity is pauses
    public void onPause(){
        super.onPause();
    }

    //called when the acitivity is resumed
    public void onResume(){
        super.onResume();

        // read our preferences in onResume()...
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Double lat = Double.parseDouble(pref.getString("lat", "51.05"));
        Double lon = Double.parseDouble(pref.getString("lon", "-0.72"));
        Integer zoom = Integer.parseInt(pref.getString("zoom", "16"));

        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(lat, lon));
        mv.getController().setZoom(zoom);

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Bundle extras = intent.getExtras();
                boolean hikebikemap = extras.getBoolean("com.example.hikebikemap");

                if (hikebikemap == true) {

                    MapView mv1 = findViewById(R.id.map1);
                    mv1.getController().setCenter(new GeoPoint(20.05, -1.72));
                    mv1.getController().setZoom(16);

                    mv1.setBuiltInZoomControls(true);
                    mv1.setClickable(true);

                    mv1.setTileSource(TileSourceFactory.HIKEBIKEMAP);

                    currentMap = "hikebikemap";

                } else {

                    MapView mv1 = findViewById(R.id.map1);
                    mv1.getController().setCenter(new GeoPoint(51.05, -0.72));
                    mv1.getController().setZoom(16);

                    mv1.setBuiltInZoomControls(true);
                    mv1.setClickable(true);

                    mv1.setTileSource(TileSourceFactory.MAPNIK);

                    currentMap = "mapnik";
                }
            }
        }

        else if(requestCode == 1){
            if (resultCode == RESULT_OK){
                Bundle extras  = intent.getExtras();
                Float floatLat = extras.getFloat("com.example.latitude");
                Float floatLon = extras.getFloat("com.example.longitude");

                MapView mv1 = findViewById(R.id.map1);
                mv1.getController().setCenter(new GeoPoint(floatLat, floatLon));
                mv1.getController().setZoom(16);

                mv1.setBuiltInZoomControls(true);
                mv1.setClickable(true);

                if (currentMap == "hikebikemap"){
                    mv1.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }

            }
        }
    }
}

