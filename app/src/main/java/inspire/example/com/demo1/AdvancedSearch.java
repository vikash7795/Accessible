package inspire.example.com.demo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.widget.Button;
import android.widget.Spinner;


import java.util.ArrayList;


/*
 * Created by vikash on 04-06-2016.
 */
public class AdvancedSearch extends Fragment {
    String[] country ={"India","USA"};
    String[] india={"Uttar Pradesh","Delhi"};
    String[] up ={"Agra","Lucknow","Varanasi","Mathura",""};
    String[] del={"East Delhi","West Delhi","South  Delhi","Central Delhi","North East Delhi"};
    String[] east ={"Mayur Vihar","Shahdara","Lakshmi Nagar",""};
    String[] usa={"Washington","Texas","New York","Mississipi"};
    String[] west={"Dwarka","Tughlakabad","Janakpuri"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_advanced_search, container, false);



        //Category Spinner
       /* String[] category=getResources().getStringArray(R.array.category_array);
        Spinner spin1  =(Spinner) v.findViewById(R.id.spinner);
*/
/*
        ArrayAdapter<String> spin1_adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,category);
        spin1_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(spin1_adapter);*/

        //Distance-Spinner
      /*  final Button button = (Button)v. findViewById(R.id.button1);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchPlace.class);
                startActivity(intent);
            }
        });*/
        String[] distance=getResources().getStringArray(R.array.distance_array);

        Spinner spin2 =(Spinner) v.findViewById(R.id.spinner2);
      /*  final CharSequence[] items = {"Wheelchair friendly "," Mobility impaired walker","Large Print"," Braille availability ","Sign Language available","Lifts available","Elevator available","Gluten free food","Elderly friendly","Assistance available","Step free","Disabled Parking"};
// arraylist to keep the selected items
        final ArrayList seletedItems=new ArrayList();
        final Button button = (Button) v. findViewById(R.id.accessible);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setTitle("Select Accessibility")
                        .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    seletedItems.add(indexSelected);
                                } else if (seletedItems.contains(indexSelected)) {
                                    // Else, if the item is already in the array, remove it
                                    seletedItems.remove(Integer.valueOf(indexSelected));
                                }
                            }
                        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on OK
                                //  You can write the code  to save the selected item here
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //  Your code when user clicked on Cancel
                            }
                        }).create();
                dialog.show();

            }
        });
*/


        ArrayAdapter<String> spin2_adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,distance);
        spin2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(spin2_adapter);

        //country Auto Complete
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (getActivity(),android.R.layout.select_dialog_item,country);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv1= (AutoCompleteTextView)v.findViewById(R.id.auto1);
        actv1.setThreshold(1);//will start working from first character
        actv1.setAdapter(adapter1);//setting the adapter data into the AutoCompleteTextVie

        actv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                         @Override
                                         public void onItemClick(AdapterView<?> parent, View view,
                                                                 final int position, long id) {
                                             if(position==0) {
                                                 //state auto-complete
                                                 ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                                                         (getActivity(), android.R.layout.select_dialog_item, india);
                                                 //Getting the instance of AutoCompleteTextView
                                                 AutoCompleteTextView actv2 = (AutoCompleteTextView) v.findViewById(R.id.auto2);
                                                 actv2.setThreshold(1);//will start working from first character
                                                 actv2.setAdapter(adapter2);//setting the adapter data into the AutoCompleteTextView

                                                 actv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                                                                                  @Override
                                                                                  public void onItemClick(AdapterView<?> parent, View view,
                                                                                                          int pos, long id) {
                                                                                      if (pos == 0) {
                                                                                          ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                                                                                                  (getActivity(), android.R.layout.select_dialog_item, del);
                                                                                          //Getting the instance of AutoCompleteTextView
                                                                                          AutoCompleteTextView actv3 = (AutoCompleteTextView) v.findViewById(R.id.auto3);
                                                                                          actv3.setThreshold(1);//will start working from first character
                                                                                          actv3.setAdapter(adapter3);//setting the adapter data into the AutoCompleteTextView

                                                                                          actv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                                                                                           @Override
                                                                                                                           public void onItemClick(AdapterView<?> parent, View view,
                                                                                                                                                   int po, long id) {
                                                                                                                               if (po == 0) {
                                                                                                                                   ArrayAdapter<String> adapter4 = new ArrayAdapter<String>
                                                                                                                                           (getActivity(), android.R.layout.select_dialog_item, east);
                                                                                                                                   //Getting the instance of AutoCompleteTextView
                                                                                                                                   AutoCompleteTextView actv4 = (AutoCompleteTextView) v.findViewById(R.id.auto4);
                                                                                                                                   actv4.setThreshold(1);//will start working from first character
                                                                                                                                   actv4.setAdapter(adapter4);//setting the adapter data into the AutoCompleteTextView
                                                                                                                               } else if (po == 1) {
                                                                                                                                   ArrayAdapter<String> adapter4 = new ArrayAdapter<String>
                                                                                                                                           (getActivity(), android.R.layout.select_dialog_item, west);
                                                                                                                                   //Getting the instance of AutoCompleteTextView
                                                                                                                                   AutoCompleteTextView actv4 = (AutoCompleteTextView) v.findViewById(R.id.auto4);
                                                                                                                                   actv4.setThreshold(1);//will start working from first character
                                                                                                                                   actv4.setAdapter(adapter4);//setting the adapter data into the AutoCompleteTextView
                                                                                                                               }

                                                                                                                           }
                                                                                                                       }
                                                                                          );


                                                                                      } else if (pos == 1) {


                                                                                          ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                                                                                                  (getActivity(), android.R.layout.select_dialog_item, up);
                                                                                          //Getting the instance of AutoCompleteTextView
                                                                                          AutoCompleteTextView actv3 = (AutoCompleteTextView) v.findViewById(R.id.auto3);
                                                                                          actv3.setThreshold(1);//will start working from first character
                                                                                          actv3.setAdapter(adapter3);//setting the adapter data into the AutoCompleteTextView
                                                                                      }


                                                                                  }
                                                                              }
                                                 );
                                             }

                                             else if(position==1)

                                             {
                                                 ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                                                         (getActivity(), android.R.layout.select_dialog_item, usa);
                                                 //Getting the instance of AutoCompleteTextView
                                                 AutoCompleteTextView actv2 = (AutoCompleteTextView) v.findViewById(R.id.auto2);
                                                 actv2.setThreshold(1);//will start working from first character
                                                 actv2.setAdapter(adapter2);//setting the adapter data into the AutoCompleteTextView
                                             }


                                         }
                                     }
        );

        return  v;

    }
}