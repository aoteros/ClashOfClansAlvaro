package net.infobosccoma.clashofclansalvaro.views.impl.activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import net.infobosccoma.clashofclansalvaro.R;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by aoteros on 28/02/2016.
 */
public class ImatgeActivity extends AppCompatActivity {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imatge_main);
        image = (ImageView) findViewById(R.id.imageView);
    }

    private class TascaDescarrega extends AsyncTask<String, Void, Bitmap> {
        private Bitmap loadImageFromNetwork(String imageURL) {
            try {
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageURL).getContent());
                return bitmap;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            return loadImageFromNetwork(urls[0]);
        }

        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
        }
    }


    public void descarregarImatge(View v) {
        new Thread(new Runnable() {
            public void run() {
                final Bitmap b;

                b = loadImageFromNetwork("http://i.imgur.com/YvBjFbE.jpg");
                image.post(new Runnable() {
                    @Override
                    public void run() {
                        image.setImageBitmap(b);
                    }
                });

            }
        }).start();

    }

    private Bitmap loadImageFromNetwork(String imageURL) {
        try {
            Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageURL).getContent());
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
