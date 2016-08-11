package farhanatou.ucer.stateslistpoject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    final String[] States = {"Alabama", "Alaska", "Arizona ", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii",
            "Idaho", "Illinois", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
            "Montana", "Hawaii", "New York", "Washinton", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "Mexico", " Ohio ", "Texas ",
            " Carolina", "Dakota ", " Oklahoma", "Oregon ", " Pennsylvania", "Carolina ", "Dakota", "Tennessee ",
            "  Utah", " Vermont ", "  Virginia", " West Virginia", "Wisconsin", " Wyoming"};
    List<String> allstates = new ArrayList<String>(Arrays.asList(States));




    public MainActivityFragment() {
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container, false);
        ArrayAdapter<String> StatesAdapter = new ArrayAdapter<String>( getActivity() ,R.layout.listitem, R.id.text_list_view, allstates );
        ListView lv = (ListView) rootview.findViewById(R.id.listView);
        lv.setAdapter(StatesAdapter);


         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for (int i = 0; i < States.length; i++) {
                    if (position == 8) {
                       startActivity(new Intent(getActivity(), MapsActivity.class));
                        Log.i("je suis la","hello");
                    }
                }
            }

        });
        return rootview;
    }

}
