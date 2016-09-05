package inspire.example.com.demo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/*
 * Created by vikash on 7/3/2016.
 */
public class SearchPlaceListView extends Fragment{

    ListView list;
    String[] web = {

            "Pacific Mall",
            "GIP Mall",
            "Select City Walk",
            "CityCenter",
            "PVR",
            "Mandarin",
            "CrossRiver",
            "InOrbit"
    } ;
    Integer[] imageId = {
            R.drawable.pacific,
            R.drawable.gip,
            R.drawable.select_city_walk,
            R.drawable.citycentre,
            R.drawable.pvr,
            R.drawable.mandarin,
            R.drawable.crossriver,
            R.drawable.inorbit

    };

    String[] location = {
            "Cannuaght Palace",
            "Rajiv Chowk",
            "Barakhamba",
            "Akshardham",
            "Rajiv Chowk",
            "JanakPuri",
            "Cannaught Palace",
            "Rajiv Chowk"
    };
    String[] distance={
            "1.8 Km",
            "2.5 Km",
            "4.3 Km",
            "5.3 Km",
            "6.2 Km",
            "10.8 km",
            "8.4 km",
            "12.8 Km",
    };
    String[] accessibilty = {

            "WheelChair Friendly",
            "Braille Availability",
            "Sign Language ",
            "Mobility Imparied",
            "Elderly Friendly",
            "Assistance available",
            "Braille Availability",
            "Wheelchair Friendly",
            "Sign Language available"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_entertainment_list_view, container, false);


        CustomEntertain adapter;
        adapter = new CustomEntertain(getActivity(), web, imageId, location, distance, accessibilty);
        list = (ListView) rootView.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(getContext(), PacificActivity.class);
                    startActivity(i);
                }
                Toast.makeText(getActivity(), "You Clicked at " + web[+position] + " " + position, Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;

    }


}
