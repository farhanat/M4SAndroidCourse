package farhanatou.ucer.asynctaskproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = (Button) findViewById(R.id.btn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast t = Toast.makeText(getApplication(),"sms button click", Toast.LENGTH_LONG);
                    //t.show();
                    if (isConnectedToInternet()) {
                        new ReturnImage().execute();
                    }
                        else{
                            Toast t = Toast.makeText(getApplication()," Connected to Internet first", Toast.LENGTH_LONG);
                            t.show();
                        }
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

            return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isConnectedToInternet() {
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    public class ReturnImage extends AsyncTask<String, Void, Bitmap> {

        ProgressDialog pgd = null;
        @Override
        protected void onPreExecute() {
            Log.i("ReturnImage", "Je suis dans onPreExecure");
            //create a new progressdilog, an instance of progressdialog
            pgd = new ProgressDialog(MainActivity.this);
            // style of the progressdialog
            pgd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            // setting the title of progerssdialog
            pgd.setTitle("Exchanger of niamey");
            // setting the message of progerssdialog
            pgd.setMessage("Image dowloading");
            // is not cancellable without set to true
            pgd.setCancelable(false);
            // tart showing the progressdialog
            pgd.show();
            super.onPreExecute();
        }



        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bitmap = null;
            try {
                URL url = new URL("https://raw.githubusercontent.com/farhanat/M4SAndroidCourse/master/NewNiameyExchanger.png");
                HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
                Log.i("ReturnImage", "Je suis dans Try de doInBackground apres le url");
                if (con.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                    Toast t = Toast.makeText(getApplication(),"Failed to connect", Toast.LENGTH_LONG);
                    t.show();
                    throw new Exception("Failed to connect");
                }
                InputStream is = con.getInputStream();
                Log.i("ReturnImage", "Je suis dans Try de doInBackground apres le is");
                publishProgress(0);
                bitmap = BitmapFactory.decodeStream(is);
                is.close();
                Log.i("ReturnImage", "Je suis dans Try de doInBackground apres le bitmap");
            } catch (Exception e) {
                Log.e("Image", "Failed to load image", e);
                Log.e("error", e.getMessage());
            }
            return bitmap;
        }


        private void publishProgress(int i) {
        }


        @Override
        protected void onPostExecute(Bitmap result) {

            if (pgd != null) {
                if (pgd.isShowing()) {
                    pgd.dismiss();
                }
                pgd = null;}

            Log.i("ReturnImage", "je suis a  l'entree de onPostExecute");
            ImageView image = (ImageView) findViewById(R.id.imv);
            Log.i("ReturnImage", "Dans  onPostExecute recuperation de l'imageview");
           if (image != null && result != null) {
                Log.i("ReturnImage", "Dans  onPostExecute les condition pose dans le if");
                image.setImageBitmap(result);
           }
        }
    }
}
