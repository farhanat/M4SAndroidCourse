package farhanatou.ucer.firebasestudent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private DatabaseReference rootref;
    public View rootview;
    private EditText edtID,edtFirstname;
    private String id,firstname;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview= inflater.inflate(R.layout.fragment_main, container, false);
        rootref = FirebaseDatabase.getInstance().getReference();

        Button Btn = (Button)rootview.findViewById(R.id.button);
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText edtID = (EditText)rootview .findViewById(R.id.editText);
                final EditText edtFirstname = (EditText)rootview.findViewById(R.id.editText2);
                id= edtID.getText().toString().trim();
                firstname= edtFirstname.getText().toString().trim();
                student stdt = new student(id,firstname);
                rootref.push().setValue(stdt);
            }
        });

        return rootview;
    }

    public class student {
        private String id;
        private String firstname;

        public student(){
            this.id="0";
            this.firstname="Foo";
        }

        public student(String id,String firstname){
            this.id=id;
            this.firstname=firstname;
        }

        public String getId(){return id;}
        public String getFirstname(){return firstname;}
        public void setId(String id){this.id=id;}
        public void setFirstname (String firstname){this.firstname = firstname;}
    }
}
