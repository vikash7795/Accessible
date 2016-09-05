package inspire.example.com.demo1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;





import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Accessible_Category extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_accessible_category, container, false);
        GridView gridView = (GridView) v.findViewById(R.id.gridview);
        gridView.setAdapter(new MyAdapter(getActivity()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
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

            }
        });
        return  v;
    }
    private class MyAdapter extends BaseAdapter {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            inflater = LayoutInflater.from(context);

            items.add(new Item("Food", R.drawable.foodd));
            items.add(new Item("Shopping", R.drawable.finalshopping));
            items.add(new Item("Entertainment",R.drawable.entertainment));
            items.add(new Item("Banking",R.drawable.b));

            items.add(new Item("Education", R.drawable.education));
            items.add(new Item("Health",R.drawable.health));

            items.add(new Item("Accessible Washrooms",R.drawable.wash));
            items.add(new Item("Accessible Buildings",R.drawable.access));
            items.add(new Item("Accessible Tours",R.drawable.tour));
            items.add(new Item("Accessible Cabs",R.drawable.cab1));
            items.add(new Item(" Disability Events",R.drawable.disevent));
            items.add(new Item("Public Transport",R.drawable.metro));


        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = view;
            ImageView picture;
            TextView name;

            if (v == null) {
                v = inflater.inflate(R.layout.gridview_accessible_category, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView) v.getTag(R.id.picture);
            name = (TextView) v.getTag(R.id.text);

            Item item = (Item) getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);

            return v;
        }

        private class Item {
            final String name;
            final int drawableId;

            Item(String name, int drawableId) {
                this.name = name;
                this.drawableId = drawableId;
            }
        }
    }
}
