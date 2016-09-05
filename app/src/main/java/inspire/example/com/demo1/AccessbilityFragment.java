package inspire.example.com.demo1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;


public class AccessbilityFragment extends Fragment {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    Toolbar tool1;




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_accessbility, container, false);

        img1=(ImageView)v.findViewById(R.id.img1);
        img2=(ImageView)v.findViewById(R.id.img2);
        img3=(ImageView)v.findViewById(R.id.img3);
        img4=(ImageView)v.findViewById(R.id.img4);
        img5=(ImageView)v.findViewById(R.id.img5);
        img6=(ImageView)v.findViewById(R.id.img6);

        tool1=(Toolbar)v.findViewById(R.id.t1);


        img1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                tool1.setBackgroundColor(Color.RED);
            }
        });


        return  v;
    }
}
