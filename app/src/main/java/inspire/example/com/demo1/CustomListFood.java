package inspire.example.com.demo1;

/**
 * Created by vikash on 6/13/20}/**/
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListFood extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    private final String[] location;
    private final String[] distance;
    private final String[] accessibility;

    public CustomListFood(Activity context,
                              String[] web, Integer[] imageId, String[] location, String[] distance, String[] accessibility) {
        super(context, R.layout.list_food, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
        this.location=location;
        this.distance=distance;
        this.accessibility=accessibility;

    }
    @Override
    public View getView(int position, View view, ViewGroup parentView) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_food,null,true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        TextView location1=(TextView) rowView.findViewById(R.id.text2);
        TextView distance1=(TextView) rowView.findViewById(R.id.text3);
        TextView access1=(TextView) rowView.findViewById(R.id.txt4);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        location1.setText(location[position]);
        distance1.setText(distance[position]);
        access1.setText(accessibility[position]);
        return rowView;
    }
}