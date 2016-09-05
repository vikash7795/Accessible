package inspire.example.com.demo1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class IndianDiningHomeFragment extends Fragment {

    private FloatingActionButton btnGetLocation = null;
    private FloatingActionButton btnCall = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_indian_dining_home, container, false);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
        Toolbar mActionBarToolbar1 = (Toolbar)v. findViewById(R.id.toolbar);

        collapsingToolbar.setTitle("Kallakal Cafe");
      /*  mActionBarToolbar1.setNavigationIcon(R.drawable.back1);
        mActionBarToolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),ShoppingActivity.class);
                startActivity(i);
            }
        });*/
       /* setSupportActionBar(mActionBarToolbar1);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        /*CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);*/
        final Button button = (Button)v. findViewById(R.id.explain);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExplainIconActivity.class);
                startActivity(intent);
            }
        });
        FloatingActionButton share;
        share=(FloatingActionButton)v.findViewById(R.id.fab);

        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/html");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, Html.fromHtml("<p>This is the text that will be shared.</p>"));
                startActivity(Intent.createChooser(shareIntent,"Share using"));

            }
        });

        btnCall=(FloatingActionButton)v.findViewById(R.id.btnPhone);
        btnCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:8802124383"));
                startActivity(in);
            }
        });



        btnGetLocation = (FloatingActionButton)v. findViewById(R.id.btnLocation);

        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:37:7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });


        mActionBarToolbar1.setTitle("MaxHospital");
        return v;
    }
}