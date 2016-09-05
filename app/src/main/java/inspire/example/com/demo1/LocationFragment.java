package inspire.example.com.demo1;

/*
 * Created by vikash on 5/10/2016.
 */

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import android.support.v4.app.Fragment;

public class LocationFragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView pizzaRecycler = (RecyclerView)inflater.inflate(
                R.layout.mainpage_recycler_view, container, false);
        String[] pizzaNames = new String[Profile.pizzas.length];
        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Profile.pizzas[i].getName();
        }
        int[] pizzaImages = new int[Profile.pizzas.length];
        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Profile.pizzas[i].getImageResourceId();
        }
        ProfileImagesAdapter adapter = new ProfileImagesAdapter(pizzaNames, pizzaImages);
        pizzaRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        pizzaRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new ProfileImagesAdapter.Listener() {
            public void onClick(int position) {
                if(position==0)

                {
                    Intent i=new Intent(getActivity(),FoodActivity.class);
                    startActivity(i);
                }

                else if(position==1)

                {
                    Intent i=new Intent(getActivity(),ShoppingActivity.class);
                    startActivity(i);
                }
                else if(position==2)
                {
                    Intent i=new Intent(getActivity(),EntertainmentActivity.class);
                    startActivity(i);
                }

                else
                {
                    Intent intent = new Intent(getActivity(), CardviewDetail.class);
                    intent.putExtra(CardviewDetail.EXTRA_PIZZANO, position);
                    getActivity().startActivity(intent);
                }

            }
        });
        return pizzaRecycler;
    }

}
