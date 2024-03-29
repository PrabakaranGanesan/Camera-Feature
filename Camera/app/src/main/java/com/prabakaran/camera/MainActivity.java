package com.prabakaran.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.net.URI;

public class MainActivity extends Activity {

    Button button;
    ImageView imageView;
    static final int cam = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.Button);
        imageView = (ImageView)findViewById(R.id.Imageview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent camera_intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                File f=getFile();

                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                startActivityForResult(camera_intent,cam);

            }
        });



        }
        private File getFile()
        {
            File folder = new File("sdcard/My_Cam");

            if (!folder.exists())
            {
                folder.mkdir();
            }

            File image_file = new File(folder,"cam_image.jpg");



            return image_file;
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/My_Cam/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));




    }




}



