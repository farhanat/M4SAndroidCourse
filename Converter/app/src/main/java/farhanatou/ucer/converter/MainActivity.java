package farhanatou.ucer.converter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    protected String stredt;
    protected Double dbledt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
        //protected void OnButonConverterClick() {
          //  final EditText edt1 = (EditText) findViewById(R.id.editText);
            //final EditText edt2 = (EditText) findViewById(R.id.editText2);
     //       edt2.setEnabled(false);
//
  //          ImageButton ImgBtn = (ImageButton) findViewById(R.id.imageButton);
    //        ImgBtn.setOnClickListener(new View.OnClickListener() {
      //          @Override
        //        public void onClick(View view) {
          //          if(edt1.getText().length()>=1){
            //            stredt = edt1.getText().toString();
              //          dbledt = Double.parseDouble(stredt);
                //        edt1.setEnabled(false);
                  //      edt2.setText(dbledt * 1.609 + "");
               //     }else {
                 //       edt1.setText("");
                   //     Toast.makeText(MainActivity.this, "wrong nomber", Toast.LENGTH_SHORT).show();
                  //  }
          //      }
            //});
       // }
}
