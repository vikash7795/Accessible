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



public class ShoppingListView extends Fragment {
    ListView list;
    String[] web = {
            "V3S Mall",
            "Select City Walk",
            "PVR",
            "Ambience",
            "Moments",
            "CrossRiver",
            "City Square",
            "Promenade"
    };
    Integer[] imageId = {
            R.drawable.v3,
            R.drawable.select_city_walk,
            R.drawable.pvr,
            R.drawable.ambience,
            R.drawable.moments,
            R.drawable.crossriver,
            R.drawable.citysq,
            R.drawable.promenade

    };

    String[] location = {
            "New Delhi",
            "Mumbai",
            "Chennai",
            "Gujarat",
            "Bihar",
            "Madhya Pradesh",
            "Kolkata",
            "Pune"
    };

    String[] distance={
            "18 Km",
            "25 Km",
            "43 Km",
            "53 Km",
            "62 Km",
            "84 km",
            "108 km",

            "128 Km",
    };
    String[] accessibilty = {

            "WheelChair Friendly",
            "Braille Availability",
            "Sign Language ",
            "Mobility Impaired",
            "Elderly Friendly",
            "Assistance available",
            "Braille Availability",
            "Wheelchair Friendly",
            "Sign Language available"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.shopping_list_view, container, false);


       /* Toolbar mActionBarToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        mActionBarToolbar.setTitle("Hospitals");
        mActionBarToolbar.setNavigationIcon(R.drawable.drawer);
*/
        CustomListShopping adapter;
        adapter = new CustomListShopping(getActivity(), web, imageId, location, distance, accessibilty);
        list = (ListView) rootView.findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(getContext(), V3SShopping.class);
                    startActivity(i);
                }
                Toast.makeText(getActivity(), "You Clicked at " + web[+position] + " " + position, Toast.LENGTH_SHORT).show();

            }
        });
                return  rootView;
    }
}

