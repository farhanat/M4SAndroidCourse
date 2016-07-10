package farhanatou.ucer.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This is a Menu, click on what you want to open", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        onclickbuttonlistener();
    }


    public void onclickbuttonlistener() {

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                intent1.setData(Uri.parse("smsto:" + Uri.encode("772311939")));
                intent1.putExtra("sms_body", "Hello how are you, me I am fine and you?, #Farhanatou Mohamadoul-Bary ");
                startActivity(intent1);
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:772311939"));
                startActivity(intent2);
            }
        });

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=AJtDXIazrMo"));
                startActivity(intent3);
            }
        });

        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri = String.format("geo:13.516772, 2.125384");
                Uri geo = Uri.parse(geoUri);
                Intent intent4 = new Intent(Intent.ACTION_VIEW, geo);
                startActivity(intent4);
            }
        });

        Button btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent5 = new Intent(Intent.ACTION_SEND);
                intent5.setType("text/plain");
                intent5.putExtra(Intent.EXTRA_SUBJECT, "Mon ami");
                intent5.putExtra(Intent.EXTRA_TEXT, "LOVE YOU");
                startActivity(Intent.createChooser(intent5, "Share the love"));
            }
        });


        Button btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent(getApplication(), NewActivity.class);
                startActivity(intent6);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast t = Toast.makeText(this,"settings",Toast.LENGTH_SHORT);
            t.show();
            return true;
        }
        if (id == R.id.action_help) {
            final Intent intent = new Intent( getApplication(), HelpActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
