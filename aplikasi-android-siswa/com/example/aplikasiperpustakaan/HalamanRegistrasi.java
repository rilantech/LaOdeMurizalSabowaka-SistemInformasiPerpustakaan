package com.example.aplikasiperpustakaan;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class HalamanRegistrasi extends AppCompatActivity {
    int MY_REQUEST_CODE = 1;
    Bitmap bitmap;
    Button btnRegister;
    Button btnuploadfoto;
    String encodeImage;
    EditText etJurusan;
    EditText etKelas;
    EditText etNIS;
    EditText etNama;
    EditText etNomorhp;
    EditText etPassword;
    EditText etUsername;
    ImageView imageView;
    TextView tvLogin;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.halaman_registrasi);
        this.btnuploadfoto = (Button) findViewById(R.id.btnUploadfoto);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.tvLogin = (TextView) findViewById(R.id.tvLogin);
        this.btnRegister = (Button) findViewById(R.id.btnRegister);
        this.etNIS = (EditText) findViewById(R.id.etNIS);
        this.etNama = (EditText) findViewById(R.id.etNama);
        this.etKelas = (EditText) findViewById(R.id.etKelas);
        this.etJurusan = (EditText) findViewById(R.id.etJurusan);
        this.etNomorhp = (EditText) findViewById(R.id.etNomorhp);
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.btnuploadfoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                HalamanRegistrasi halamanRegistrasi = HalamanRegistrasi.this;
                halamanRegistrasi.startActivityForResult(i, halamanRegistrasi.MY_REQUEST_CODE);
            }
        });
        this.tvLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HalamanRegistrasi.this.startActivity(new Intent(HalamanRegistrasi.this.getApplicationContext(), HalamanLogin.class));
                HalamanRegistrasi.this.finish();
            }
        });
        this.btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (HalamanRegistrasi.this.etNIS.getText().toString().length() == 0) {
                    HalamanRegistrasi.this.etNIS.setError("Tidak Boleh Kosong");
                }
                if (HalamanRegistrasi.this.etNama.getText().toString().length() == 0) {
                    HalamanRegistrasi.this.etNama.setError("Tidak Boleh Kosong");
                }
                if (HalamanRegistrasi.this.etKelas.getText().toString().length() == 0) {
                    HalamanRegistrasi.this.etKelas.setError("Tidak Boleh Kosong");
                }
                if (HalamanRegistrasi.this.etJurusan.getText().toString().length() == 0) {
                    HalamanRegistrasi.this.etJurusan.setError("Tidak Boleh Kosong");
                }
                if (HalamanRegistrasi.this.etNomorhp.getText().toString().length() == 0) {
                    HalamanRegistrasi.this.etNomorhp.setError("Tidak Boleh Kosong");
                }
                if (HalamanRegistrasi.this.etUsername.getText().toString().length() == 0) {
                    HalamanRegistrasi.this.etUsername.setError("Tidak Boleh Kosong");
                }
                if (HalamanRegistrasi.this.etPassword.getText().toString().length() == 0) {
                    HalamanRegistrasi.this.etPassword.setError("Tidak Boleh Kosong");
                    return;
                }
                Volley.newRequestQueue(HalamanRegistrasi.this).add(new StringRequest(1, new Configurasi().baseUrl() + "api/registrasi.php", new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            if (new JSONObject(response).getString(NotificationCompat.CATEGORY_STATUS).equals("berhasil_registrasi")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(HalamanRegistrasi.this);
                                builder.setTitle((CharSequence) "Sukses");
                                builder.setMessage((CharSequence) "Berhasil Registrasi");
                                builder.setPositiveButton((CharSequence) "OK", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        HalamanRegistrasi.this.startActivity(new Intent(HalamanRegistrasi.this, HalamanLogin.class));
                                        HalamanRegistrasi.this.finish();
                                    }
                                });
                                builder.create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(HalamanRegistrasi.this, "Error :" + error.getMessage(), 0).show();
                    }
                }) {
                    /* access modifiers changed from: protected */
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> myParams = new HashMap<>();
                        myParams.put("nis", HalamanRegistrasi.this.etNIS.getText().toString());
                        myParams.put("nama", HalamanRegistrasi.this.etNama.getText().toString());
                        myParams.put("kelas", HalamanRegistrasi.this.etKelas.getText().toString());
                        myParams.put("jurusan", HalamanRegistrasi.this.etJurusan.getText().toString());
                        myParams.put("nomorhp", HalamanRegistrasi.this.etNomorhp.getText().toString());
                        myParams.put("foto", HalamanRegistrasi.this.encodeImage);
                        myParams.put("username", HalamanRegistrasi.this.etUsername.getText().toString());
                        myParams.put("password", HalamanRegistrasi.this.etPassword.getText().toString());
                        return myParams;
                    }
                });
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
        this.encodeImage = Base64.encodeToString(stream.toByteArray(), 0);
    }
}
