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



public class FoodListView extends Fragment {
    ListView list;
    String[] web = {
            "Kallakal Cafe",
            "Vera Pizzeria",
            "Elephant and Co",
            "Trident",
            "Gastro Bar",
            "Ping Café Orient ",
            "Ottimo at West View",
            "Arriba",


    };
    Integer[] imageId = {
            R.drawable.kallakal,
            R.drawable.vera,
            R.drawable.elephant,
            R.drawable.trident,
            R.drawable.gastro,
            R.drawable.ping,
            R.drawable.ottimo,
            R.drawable.arriba

    };

    String[] location = {
            "Chennai",
            "Hyderabad",
            "Pune",
            "Mumbai",
            "Mumbai",
            "New Delhi",
            "New Delhi",
            "New Delhi"
    };

    String[] distance={
            "16 Km",
            "200 Km",
            "300 Km",
            "350 Km",
            "375 Km",
            "710 km",
            "725 km",
            "745 Km"
    };
    String[] accessibilty = {

            "WheelChair Friendly",
            "Braille Accessible",
            "Glutten Free FOod",
            "Disabled Parking",
            "Elderly Friendly",
            "Assistance available",
            "Large Print",
            "Lifts Available"



    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_food_list_view, container, false);


       /* Toolbar mActionBarToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        mActionBarToolbar.setTitle("Hospitals");
        mActionBarToolbar.setNavigationIcon(R.drawable.drawer);
*/
        CustomListFood adapter;
        adapter = new CustomListFood(getActivity(), web, imageId, location, distance, accessibilty);
        list = (ListView) rootView.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(getContext(),IndianDining.class);
                    startActivity(i);
                }

                Toast.makeText(getActivity(), "You Clicked at " + web[+position] + " " + position, Toast.LENGTH_SHORT).show();

            }
        });
        return  rootView;
    }
}

