package uk.ac.solent.mapping;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(51.05,  -0.72));
        mv.getController().setZoom(16);

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true);

        Button button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(this);

    }

    //38.5500/-27.7755



    public void onClick(View view){
        /* EditText etLat = (EditText)findViewById(R.id.lat);
        EditText etLon = (EditText)findViewById(R.id.lon);

        String stringEtLat = etLat.getText().toString();
        String stringEtLon = etLon.getText().toString();


        Float latitude = Float.parseFloat(stringEtLat);
        Float longitude = Float.parseFloat(stringEtLon);


        MapView mv = findViewById(R.id.map1);
        mv.getController().setCenter(new GeoPoint(latitude,longitude));

        mv.setBuiltInZoomControls(true);
        mv.setClickable(true); */
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.choosemap){
            //react to the menu item being selected...
            Intent intent = new Intent(this, MapChooseActivity.class);
            startActivityForResult(intent,0);
            return true;
        }

        else if(item.getItemId() == R.id.setLocation){
            Intent intent = new Intent(this, SetLocationActivity.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {

        if(requestCode==0)
        {
            MapView mv = findViewById(R.id.map1);
            if (resultCode==RESULT_OK)
            {
                Bundle extras=intent.getExtras();
                boolean hikebikemap = extras.getBoolean("com.example.hikebikemap");
                if(hikebikemap==true)
                {
                    String stringLatitude = extras.getString("stringLatitude");
                    mv.setTileSource(TileSourceFactory.HIKEBIKEMAP);
                }
                else
                {
                    mv.setTileSource(TileSourceFactory.MAPNIK);
                }
            }
        }
    }

}
