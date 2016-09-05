package inspire.example.com.demo1;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FourthHospital extends AppCompatActivity {
    private static MenuItem mSearchAction;
    private static boolean isSearchOpened = false;

    private LocationManager locationMangaer = null;
    private LocationListener locationListener = null;

    private static TextView editLocation = null;
    private ProgressBar pb = null;

    private static final String TAG = "Debug";
    private Boolean flag = false;

    private Toast toast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_hospital);
        Toolbar mActionBarToolbar1 = (Toolbar) findViewById(R.id.toolbar);
       /* getActionBar().setDisplayHomeAsUpEnabled(true);*/
      /*  pb = (ProgressBar) findViewById(R.id.progressBar1);
        pb.setVisibility(View.INVISIBLE);

        editLocation = (TextView) findViewById(R.id.editTextLocation);
        btnGetLocation = (FloatingActionButton) findViewById(R.id.btnLocation);
        btnGetLocation.setOnClickListener(this);

        locationMangaer = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        //rating bar color*/
        FloatingActionButton btnGetLocation = (FloatingActionButton) findViewById(R.id.btnLocation);

        assert btnGetLocation != null;
        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:37:7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        assert ratingBar != null;
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);
        Drawable drawable = ratingBar.getProgressDrawable();
        drawable.setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_ATOP);

        assert mActionBarToolbar1 != null;
        mActionBarToolbar1.setTitle("MaxHospital");
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

// Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.video, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.virtual, R.color.color_tab_1);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.help, R.color.color_tab_1);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.book, R.color.color_tab_1);

// Add itemsr
        assert bottomNavigation != null;
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);


// Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

// Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);

// Force the titles to be displayed (against Material Design guidelines!)
        bottomNavigation.setForceTitlesDisplay(true);

// Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

// Set current item programmatically
        bottomNavigation.setCurrentItem(1);

// Customize notification (title, background, typeface)
        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));

// Add or remove notification for each item
        bottomNavigation.setNotification("4", 1);
        bottomNavigation.setNotification("", 1);

// Set listener
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {


                return true;
            }
        });
    }

} /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_item_share);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        return super.onPrepareOptionsMenu(menu);
    } // Creates options in menu

}*/
    /*@Override
    public void onClick(View v) {
        flag = displayGpsStatus();
        if (flag) {

            Log.v(TAG, "onClick");

            //  editLocation.setText("Please Wait...!");

            //ProgressDialog dialog = ProgressDialog.show(this, "Down Loading", "Please wait ...", true);
            pb.setVisibility(View.VISIBLE);
            locationListener = new MyLocationListener();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationMangaer.requestLocationUpdates(LocationManager
                    .NETWORK_PROVIDER, 5000, 10, locationListener);
            //dialog.dismiss();
        } else {
            alertbox("Gps Status!!", "Your GPS is: OFF");
        }

    }

    *//*----Method to Check GPS is enable or disable ----- *//*
    private Boolean displayGpsStatus() {
        ContentResolver contentResolver = getBaseContext()
                .getContentResolver();
        boolean gpsStatus = Settings.Secure
                .isLocationProviderEnabled(contentResolver,
                        LocationManager.NETWORK_PROVIDER);
        if (gpsStatus) {
            return true;

        } else {
            return false;
        }
    }

    *//*----------Method to create an AlertBox ------------- *//*
    protected void alertbox(String title, String mymessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your Device's GPS is Disable")
                .setCancelable(false)
                .setTitle("** Gps Status **")
                .setPositiveButton("Gps On",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // finish the current activity
                                // AlertBoxAdvance.this.finish();
                                Intent myIntent = new Intent(
                                        Settings.ACTION_SECURITY_SETTINGS);
                                startActivity(myIntent);
                                dialog.cancel();
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // cancel the dialog box
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    *//*----------Listener class to get coordinates ------------- *//*
 private    class MyLocationListener implements LocationListener {
        @Override
        public void onLocationChanged(Location loc) {

            editLocation.setText("");
            pb.setVisibility(View.INVISIBLE);
            toast = Toast.makeText(getBaseContext(), "Location changed : Lat: " +
                            loc.getLatitude() + " Lng: " + loc.getLongitude(),
                    Toast.LENGTH_SHORT);
            toast.show();
            toast.cancel();
            String longitude = "Longitude: " + loc.getLongitude();
            Log.v(TAG, longitude);
            Log.d(longitude, "longi1");
            // Log.d(longitude,"longi");
            String latitude = "Latitude: " + loc.getLatitude();
            Log.v(TAG, latitude);
            Log.d(latitude, "lati");
          *//*----------to get City-Name from coordinates ------------- *//*
            String cityName = null;

            Geocoder gcd = new Geocoder(getBaseContext(),
                    Locale.getDefault());
            List<Address> addresses;
            try {
                addresses = gcd.getFromLocation(loc.getLatitude(), loc
                        .getLongitude(), 1);
                Log.d(String.valueOf(addresses), "longi");
                if (addresses.size() > 0)
                    System.out.println(addresses.get(0).getLocality());
                //cityName=addresses.get(0).getLocality();
                cityName = addresses.get(0).getAddressLine(0) + ", " + addresses.get(0).getLocality();
                Log.d(String.valueOf(cityName), "city");
                // User request = new User(cityName);

                Uri gmmIntentUri = Uri.parse("geo:cityName");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

*//*Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:37.7749,-122.4194"));
                i.setPackage("com.google.android.apps.maps");
                startActivity(i);
                *//*
                toast = Toast.makeText(getBaseContext(), " address " + addresses.get(0).getAddressLine(0) + "," + addresses.get(0).getLocality(), Toast.LENGTH_SHORT);
                toast.show();
                //toast.cancel();

                //userLocalStore.saveUserData(request);
            } catch (IOException e) {
                e.printStackTrace();
            }


            String s = longitude + "\n" + latitude +
                    "\n\nMy Currrent City is: " + cityName;
            editLocation.setText(s);

            startActivity(new Intent(V3SShopping.this, V3SShopping.class));
            finish();
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider,
                                    int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }
}*/