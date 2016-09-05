package mainpage_fetching;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

import inspire.example.com.demo1.ExplainIconActivity;
import inspire.example.com.demo1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class  IndianDiningHomeFragment extends Fragment {
private RecyclerView recyclerView;
    private ArrayList<CardInfo> data;
    private DataAdapter adapter;

    private FloatingActionButton btnGetLocation = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_indian_dining_home, container, false);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) v.findViewById(R.id.collapsing_toolbar);
        Toolbar mActionBarToolbar1 = (Toolbar)v. findViewById(R.id.toolbar);
        initViews();
        collapsingToolbar.setTitle("Mcdonald");
        collapsingToolbar.setBackgroundColor(getResources().getColor(R.color.color_tab_1));

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

    private void initViews() {
        loadJSON();
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JsonResponse> call = request.getJSON();
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                JsonResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapter(data);
               /* recyclerView.setAdapter(adapter);*/
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}





