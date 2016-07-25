package farhanatou.ucer.converter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    protected String stredt;
    protected Double dbledt;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final EditText edt1 = (EditText)rootView .findViewById(R.id.editText);
        final EditText edt2 = (EditText)rootView.findViewById(R.id.editText2);
        final ImageButton ImgBtn = (ImageButton)rootView.findViewById(R.id.imageButton);
        edt2.setEnabled(false);
        ImageButton reset = (ImageButton) rootView.findViewById(R.id.resetbtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText edt1 = (EditText) rootView.findViewById(R.id.editText);
                final EditText edt2 = (EditText) rootView.findViewById(R.id.editText2);
                edt1.setEnabled(true);
                edt2.setText("");
                edt1.setText("");
                ImgBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(edt1.getText().length()>=1){
                            stredt = edt1.getText().toString();
                            dbledt = Double.parseDouble(stredt);
                            edt1.setEnabled(false);
                            edt2.setText(dbledt * 1.609 + "");
                        }else {
                            edt1.setText("");
                            Toast.makeText(getActivity().getApplicationContext(), "wrong nomber", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        ImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt1.getText().length()>=1){
                    stredt = edt1.getText().toString();
                    dbledt = Double.parseDouble(stredt);
                    edt1.setEnabled(false);
                    edt2.setText(dbledt * 1.609 + "");
                }else {
                    edt1.setText("");
                    Toast.makeText(getActivity().getApplicationContext(), "wrong nomber", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rootView;

    }
    
}
