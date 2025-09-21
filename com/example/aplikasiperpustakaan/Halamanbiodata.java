package com.example.aplikasiperpustakaan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import cn.pedant.SweetAlert.SweetAlertDialog;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

public class Halamanbiodata extends AppCompatActivity {
    public static SharedPreferences getData;
    int MY_REQUEST_CODE = 1;
    Bitmap bitmap;
    String encodeImage;
    ImageView imageView;
    EditText nama;
    SharedPreferences.Editor setData;
    Button simpan;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_halamanbiodata);
        this.setData = getSharedPreferences("data", 0).edit();
        getData = getSharedPreferences("data", 0);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.nama = (EditText) findViewById(R.id.nama);
        this.simpan = (Button) findViewById(R.id.simpan);
        if (getData.contains("session_nama")) {
            this.nama.setText(getData.getString("session_nama", (String) null));
            byte[] b = Base64.decode(getData.getString("session_foto", (String) null), 0);
            this.imageView.setImageBitmap(BitmapFactory.decodeByteArray(b, 0, b.length));
        }
        this.simpan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Halamanbiodata.this.nama.getText().toString().length() == 0 || Halamanbiodata.this.bitmap == null) {
                    new SweetAlertDialog(Halamanbiodata.this, 3).setContentText("Foto Profil / Nama Belum Lengkap!").show();
                    return;
                }
                Halamanbiodata.this.setData.putString("session_nama", Halamanbiodata.this.nama.getText().toString());
                Halamanbiodata.this.setData.apply();
                Halamanbiodata.this.startActivity(new Intent(Halamanbiodata.this.getApplicationContext(), Halamanutama.class));
            }
        });
        this.imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                Halamanbiodata halamanbiodata = Halamanbiodata.this;
                halamanbiodata.startActivityForResult(i, halamanbiodata.MY_REQUEST_CODE);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.MY_REQUEST_CODE && resultCode == -1 && data != null) {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(data.getData()));
                this.bitmap = decodeStream;
                this.imageView.setImageBitmap(decodeStream);
                imageStore(this.bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void imageStore(Bitmap bitmap2) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        String encodeToString = Base64.encodeToString(stream.toByteArray(), 0);
        this.encodeImage = encodeToString;
        this.setData.putString("session_foto", encodeToString);
        this.setData.apply();
    }
}
