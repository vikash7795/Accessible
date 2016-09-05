package inspire.example.com.demo1;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShoppingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText edtSeach;
    private LocationFragment mFragment;
    private static final int CONTENT_VIEW_ID = 10101010;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        if (savedInstanceState == null) {
            Toolbar t=(Toolbar)findViewById(R.id.toolbar);
            t.setTitle("Shopping");
            ShoppingListView fragment1 = new ShoppingListView();
            android.support.v4.app.FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction1.replace(R.id.frame,fragment1);
            fragmentTransaction1.commit();

        }


        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()){


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.location:
                        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);

                        mActionBarToolbar.setTitle("Home");
                        ShoppingListView fragment5 = new ShoppingListView();
                        android.support.v4.app.FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.replace(R.id.frame,fragment5);
                        fragmentTransaction5.commit();


                        return true;

                    // For rest of the options we just show a toast on click

                    case R.id.profile:
                        Toolbar mtoolbar = (Toolbar) findViewById(R.id.toolbar);

                        mtoolbar.setTitle("Complete Profile");
                        Toast.makeText(getApplicationContext(),"Location Selected",Toast.LENGTH_SHORT).show();

                        return true;


                    case R.id.location1:
                        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

                        toolbar.setTitle("Add Location");
                        Toast.makeText(getApplicationContext(),"new fragmentlist Selected",Toast.LENGTH_SHORT).show();

                        return true;

                    case R.id.search:
                        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);

                        mToolbar.setTitle("Advanced Search");

                        return true;
                    case R.id.access:
                        Toolbar moolbar = (Toolbar) findViewById(R.id.toolbar);

                        moolbar.setTitle("Accessibility");

                        return true;
                    case R.id.share:
                        Toolbar mlbar = (Toolbar) findViewById(R.id.toolbar);
                        mlbar.setTitle("Share");
                        Toast.makeText(getApplicationContext(),"share Selected",Toast.LENGTH_SHORT).show();
                        return true;

                    default:
                        Toolbar mActionBarToolbar1 = (Toolbar) findViewById(R.id.toolbar);

                        mActionBarToolbar1.setTitle("Home");


                        return true;


                }
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();






    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.action_filter);
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {

            case R.id.action_filter:
                AdvancedSearch fragment2 = new AdvancedSearch();
                android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frame,fragment2);
                fragmentTransaction2.commit();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    }

