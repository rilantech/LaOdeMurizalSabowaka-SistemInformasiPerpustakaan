package com.example.aplikasiperpustakaan;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.aplikasiperpustakaan.AdapterKomentar.AdaptorKomentar;
import com.example.aplikasiperpustakaan.AdapterKomentar.GetDataKomentar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.gotev.uploadservice.data.UploadTaskParameters;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Informasiwisata extends AppCompatActivity {
    public static SharedPreferences getData;
    public static String kodewisata;
    public static String lat = "";
    public static String longi = "";
    public static String namagambar;
    public static Boolean wisata1 = false;
    public static Boolean wisata2 = false;
    public static Boolean wisata3 = false;
    AdaptorKomentar adaptorKomentar;
    TextView biaya_masuk;
    Dialog customDialog;
    Dialog customeGambar;
    TextView deskripsi_wisata;
    ImageView fotobesar;
    ImageView gambar;
    ImageView ikon_uang;
    ImageView ikoninstagram;
    ImageView ikonyoutube;
    LayoutInflater inflater;
    TextView info_lanjut;
    TextView instagram;
    EditText isi_komentar;
    TextView keterangan_komentar;
    TextView keterangan_rating;
    ImageView kirim_komentar;
    Button kirim_rating;
    Button lihatjadwal;
    ListView list;
    ArrayList<GetDataKomentar> model;
    TextView nama_wisata;
    RatingBar rattingbar1;
    RatingBar rattingbar2;
    Button tombol_3D;
    Button tombol_lokasi;
    Toolbar toolbar;
    View view;
    TextView youtube;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_informasiwisata);
        getData = getSharedPreferences("data", 0);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.gambar = (ImageView) findViewById(R.id.gambar);
        this.info_lanjut = (TextView) findViewById(R.id.info_lanjut);
        this.keterangan_komentar = (TextView) findViewById(R.id.keterangan_komentar);
        this.kirim_komentar = (ImageView) findViewById(R.id.kirim_komentar);
        this.isi_komentar = (EditText) findViewById(R.id.isi_komentar);
        this.list = (ListView) findViewById(R.id.list);
        this.kirim_rating = (Button) findViewById(R.id.kirim_rating);
        this.rattingbar1 = (RatingBar) findViewById(R.id.rattingbar1);
        this.rattingbar2 = (RatingBar) findViewById(R.id.rattingbar2);
        this.nama_wisata = (TextView) findViewById(R.id.nama_wisata);
        this.deskripsi_wisata = (TextView) findViewById(R.id.deskripsi_wisata);
        this.biaya_masuk = (TextView) findViewById(R.id.biaya_masuk);
        this.lihatjadwal = (Button) findViewById(R.id.lihatjadwal);
        this.tombol_lokasi = (Button) findViewById(R.id.tombol_lokasi);
        this.tombol_3D = (Button) findViewById(R.id.tombol_3D);
        this.keterangan_rating = (TextView) findViewById(R.id.keterangan_rating);
        this.ikon_uang = (ImageView) findViewById(R.id.ikon_uang);
        this.ikonyoutube = (ImageView) findViewById(R.id.ikonyoutube);
        this.ikoninstagram = (ImageView) findViewById(R.id.ikoninstagram);
        this.youtube = (TextView) findViewById(R.id.youtube);
        this.instagram = (TextView) findViewById(R.id.instagram);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initCustomDialog();
        initCustomeGambar();
        this.ikonyoutube.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("https://www.youtube.com/@ButonizenID"));
                Informasiwisata.this.startActivity(intent);
            }
        });
        this.ikoninstagram.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse("https://shopee.co.id/"));
                Informasiwisata.this.startActivity(intent);
            }
        });
        this.info_lanjut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Informasiwisata.this.lihatjadwal.setVisibility(8);
                Informasiwisata.this.tombol_lokasi.setVisibility(8);
                Informasiwisata.this.biaya_masuk.setVisibility(8);
                Informasiwisata.this.tombol_3D.setVisibility(8);
                Informasiwisata.this.ikon_uang.setVisibility(8);
                Informasiwisata.this.kirim_rating.setVisibility(0);
                Informasiwisata.this.rattingbar2.setVisibility(0);
                Informasiwisata.this.keterangan_rating.setVisibility(0);
                Informasiwisata.this.info_lanjut.setVisibility(8);
                Informasiwisata.this.keterangan_komentar.setVisibility(0);
                Informasiwisata.this.kirim_komentar.setVisibility(0);
                Informasiwisata.this.isi_komentar.setVisibility(0);
                Informasiwisata.this.list.setVisibility(0);
                Informasiwisata.this.ikonyoutube.setVisibility(0);
                Informasiwisata.this.ikoninstagram.setVisibility(0);
                Informasiwisata.this.youtube.setVisibility(0);
                Informasiwisata.this.instagram.setVisibility(0);
            }
        });
        if (Daftarwisata.status_cardviewbaubau.booleanValue()) {
            if (Daftarwisatapulaubuton.tombol_wisata1.booleanValue()) {
                kodewisata = "101";
                lat = "-5.52360571612725";
                longi = "122.56798173559805";
                this.fotobesar.setImageResource(R.drawable.pantainirwana);
                this.nama_wisata.setText("Pantai Nirwana");
                namagambar = "pantainirwana";
                this.gambar.setImageResource(R.drawable.pantainirwana);
                this.deskripsi_wisata.setText("Pantai Nirwana Baubau adalah salah satu destinasi wisata di Sulawesi Tenggara. Wisata Pantai ini terletak di kota Baubau. Jaraknya hanya sekitar 15 menit dari kota Baubau.Air laut di Pantai Nirwana memiliki gradasi warna putih, hijau kebiruan, dan juga biru muda.memiliki ombak yang tenang sehingga bisa digunakan untuk berenang atau diving. Di wilayah pantai Nirwana ada hotel dan penginapan dengan harga yang baik bisa Anda temukan. Jadi, jika Anda ingin menginap tidak perlu khawatir untuk mendapatkan hotel atau penginapan.");
                this.biaya_masuk.setText("5000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata2.booleanValue()) {
                kodewisata = "102";
                lat = "-5.4744269151174825";
                longi = "122.60221982243847";
                this.nama_wisata.setText("Benteng Keraton");
                this.fotobesar.setImageResource(R.drawable.bentengkeraton);
                this.gambar.setImageResource(R.drawable.bentengkeraton);
                this.deskripsi_wisata.setText("Benteng Keraton adalah salah satu destinasi wisata budaya di Sulawesi Tenggara. Wisata ini terletak di kota Baubau. Benteng Keraton Buton dibangung pada abad ke-16 oleh Sultan Buton ke III bernama La Sangaji yang bergelar Sultan Kaimuddin(1591-1596), Benteng Keraton juga memiliki 3 komponen yaitu Badili(meriam), Lawa(pintu gerbang) yeng berjumlah 12 pada benteng keraton, Balarua(bastion) yang dibangun untuk melihat musuh dari benteng, selain itu benteng ini memiliki luas 23,375 hektare. Dan kini Benteng Keraton menjadi salah satu objek wisata bersejarah di Kota Baubau yang banyak didatangi wisatawan, karena memiliki bentuk arsitek unik.");
                this.biaya_masuk.setText("5000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata3.booleanValue()) {
                kodewisata = "103";
                lat = "-5.508105027007856";
                longi = "122.56697284254727";
                this.nama_wisata.setText("Goa Lakasa");
                this.fotobesar.setImageResource(R.drawable.goalakasa);
                this.gambar.setImageResource(R.drawable.goalakasa);
                this.deskripsi_wisata.setText("Goa Lakasa  adalah salah satu objek wisata yang berada di Kecamatan Betoambari, Kota Bau-Bau, Sulawesi Tenggara. Awal mulanya Pada tahun 1999 seorang kakek bernama La Kasa mendapatkan mimpi bahwa ada sebuah mata air yang dibawah tanah tepat di lokasi perkebunannya. Gua tersebut kemudian diberi nama Lakasa sesuai dengan nama sang kakek yang menemukannya. Gua yang memiliki banyak Stalaktit dan Stalakmit tersebut kemudian mulai mencuri perhatian wisatawan dari sekitaran Baubau, kini dengan semakin berkembangnya teknologi membuat banyak wisatawan dari luar Baubau juga datang berkunjung.");
                this.biaya_masuk.setText("10.000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata4.booleanValue()) {
                kodewisata = "104";
                lat = "-5.335852189265685";
                longi = "122.64848261230503";
                this.nama_wisata.setText("Batu Sori");
                this.fotobesar.setImageResource(R.drawable.batusori);
                this.gambar.setImageResource(R.drawable.batusori);
                this.deskripsi_wisata.setText("Batu Sori adalah salah satu destinasi wisata yang terletak di Palabusa, Kecamatan Lealea, Kota Baubau, Sulawesi Tenggara. Asal nama Batu Sori dari sebuah batu yang karam dengan sebutan Bahasa Buton (Batu Mo Tosore). ");
                this.biaya_masuk.setText("5.000");
            }
        }
        if (Daftarwisata.status_cardviewbuton.booleanValue()) {
            if (Daftarwisatapulaubuton.tombol_wisata1.booleanValue()) {
                kodewisata = "105";
                lat = "-5.5145119277105366";
                longi = "122.84168550857208";
                this.fotobesar.setImageResource(R.drawable.kalibiru);
                this.nama_wisata.setText("Kali Biru");
                namagambar = "kalibiru";
                this.gambar.setImageResource(R.drawable.kalibiru);
                this.deskripsi_wisata.setText("Kali Biru adalah salah satu destinasi wisata di Sulawesi Tenggara. Wisata ini terletak di Desa Banabungi, Kecamatan Pasarwajo, Kabupaten Buton, Sulawesi Tenggara.Disebut wisata kali biru, karenawarna air yang terlihat biru akibat warna cat dari dinding-dinding kolam yang biru memantul kedalam kolam sehingga menjadi keunikantersendiri.Di tengah kali juga terdapat perahu bebek yang bisa ditumpangi oleh para wisatawan, perahu bebek ini bisa digunakan untuk mengelilingi Kali Biru. Dengan harga Rp. 10.000 rupiah anda sudah bisa menikmati keindahan wisata ini. Disekitaran lokasi permandian, tersedia warung-warung yang menyuguhkan aneka jajanan-jajanan ringan dengan harga yang amat terjangkau. Tidak sedikit pengunjung yang kerap menghabiskan waktunya untuk berdiskusi dan menikmati sunshet (matahari terbenam).");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata2.booleanValue()) {
                kodewisata = "106";
                lat = "-5.1516080054003615";
                longi = "122.85122798649225";
                this.nama_wisata.setText("Air Terjun Kandawu Ndawuna");
                this.fotobesar.setImageResource(R.drawable.airterjunkandawundawuna);
                this.gambar.setImageResource(R.drawable.airterjunkandawundawuna);
                this.deskripsi_wisata.setText("Air Terjun Kandawu Ndawuna adalah salah satu destinasi wisata alam di Sulawesi Tenggara. Wisata ini terletak di Waondo Wolio, Kec. Kapontori, Kabupaten Buton, Sulawesi Tenggara. Letak wisata ini ada di tengah hutan dan daya tarik yang dimiliki wisata air terjun Kandawu Ndawuna ini yaitu memiliki ketinggian 30 meter yang eksotis dan alam hijau yang asri di sekitarnya ");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata3.booleanValue()) {
                kodewisata = "107";
                lat = "-5.303382583693693";
                longi = "123.21606327472104";
                this.nama_wisata.setText("Pantai Koguna");
                this.fotobesar.setImageResource(R.drawable.pantaikoguna);
                this.gambar.setImageResource(R.drawable.pantaikoguna);
                this.deskripsi_wisata.setText("Pantai Koguna adalah salah satu objek wisata pantai yang berada diKec. Betoambari, Kota Bau-Bau, Sulawesi Tenggara. terletak di Desa Mopaano, Kecamatan Lasalimu Selatan, Kabupaten Buton, Sulawesi Tenggara. Pantai ini memiliki pasir yang putih sedikit berwarna krem. Lautnya sendiri masih jernih, Ombak di sekitarnya pun sangat tenang sehingga di pantai ini sangat cocok untuk berenang menikmati air laut. Di daerah belakang pantai,  terdapat pula sebuah telaga kecil                        \"seperti rawa-rawa yang ditumbuhi pohon-pohon seperti pohon bakau, dan di dalam airnya hidup sejenis udang berwarna merah. Udang Merah yang cukup                        \"jinak itu, bukan untuk dimakan/disantap, melainkan hanya untuk sekedar dipandangi saja. Karena konon katanya, jika udang tersebut dimakan maka yang                        \"memakannya akan mengalami musibah. Tak hanya sampai disitu,Udang tersebut tidak boleh dibawah pulang, karena udang tersebut tidak bisa hidup ditempat lain.");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata4.booleanValue()) {
                kodewisata = "108";
                lat = "-5.624296994929138";
                longi = "122.84223604234057";
                this.nama_wisata.setText("Benteng Wasuemba");
                this.fotobesar.setImageResource(R.drawable.bentengwasuemba);
                this.gambar.setImageResource(R.drawable.bentengwasuemba);
                this.deskripsi_wisata.setText("Benteng Wasuemba adalah salah satu destinasi wisata budaya yang  terletak di Desa Wasuemba, Kec. Wabula, Kabupaten Buton, Sulawesi Tenggara. Benteng ini berdiri sejak zaman Kerajaan Buton. Bukti peninggalan sejarah pun masih dapat dilihat seperti meriam, kuburan penjaga benteng pada masa utu, dan situs lainnya. Benteng ini ada kaitannya dengan benteng keraton Kota Baubau dan perjalanan Oputa Yi Koo yang merupakan pahlawan nasional. bagi yang ingin menikmati sunrise dari ketinggian dengan pemandangan laut yang indah maka sebelum pukul 06.00 WITA sudah berada di lokasi");
                this.biaya_masuk.setText("Gratis");
            }
        }
        if (Daftarwisata.status_cardviewbutonselatan.booleanValue()) {
            if (Daftarwisatapulaubuton.tombol_wisata1.booleanValue()) {
                kodewisata = "109";
                lat = "-5.55526754889266";
                longi = "122.61103115034965";
                this.fotobesar.setImageResource(R.drawable.kaburaburana);
                this.nama_wisata.setText("Permandian Kabura-burana");
                this.gambar.setImageResource(R.drawable.kaburaburana);
                this.deskripsi_wisata.setText("Permandian Kabura-burana adalah salah satu destinasi wisata alam yang terletak di Desa Lawela, Kec.Batauga, Kabupaten Buton Selatan, Sulawesi Tenggara.  Wisata Permandian Kabura burana, menawarkan Pengalaman berupa pembelajaran tentang interaksi alam, lingkungan hidup, perkebunan, kuliner khas daerah,wirausaha, kehidupan sosial budaya dan kearifan lokal yang masih mengakar di masayarakat sehingga masih terasa suasana pedesaan.");
                this.biaya_masuk.setText("5.000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata2.booleanValue()) {
                kodewisata = "110";
                lat = "-5.660890469967392";
                longi = "122.67606127254399";
                this.nama_wisata.setText("Masjid Tua Wawoangi");
                this.fotobesar.setImageResource(R.drawable.masjidtuawawoangi);
                this.gambar.setImageResource(R.drawable.masjidtuawawoangi);
                this.deskripsi_wisata.setText("Masjid Tua Wawoangi adalah salah satu destinasi wisata budaya dan masjid ini hanya berjarak 1,5 KM dari pemukiman Desa Wawoangi, Kabupaten Buton Selatan. Masjid Tua Wawoangi diklaim sebagai masjid tertua di jazirah Buton dan Sulawesi Tenggara (Sultra). Betapa tidak, masjid ini didirikan pada tahun 1527 M oleh Syeh Abdul Wahid. Syeh Abdul Wahid adalah sosok yang mengislamkan Sultan Buton I Sultan Murhum (Laki Laponto). Kades Wawoangi, La Ode Abdul Halim, menjelaskan sejarah Masjid Tua Wawoangi. Ketika itu Syekh Abdul Wahid terdampar di Batu Atas dan melakukan perjalanan ke Burangasi, Kecamatan Lapandewa saat ini. Syiar Islam pertama itu menurut dia di Burangasi, tetapi Syeh Abdul Wahid membangun masjid jauh dari Burangasi. Wujud Masjid Tua Wawoangi itu masih ada sampai sekarang. “Syeh Abdul Wahid melihat cahaya di langit turun di Wawoangi. Makanya masjid dibangun di tempat itu.");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata3.booleanValue()) {
                kodewisata = "111";
                lat = "-5.525879246000692";
                longi = "122.75194189894903";
                this.nama_wisata.setText("Bukit Rongi");
                this.fotobesar.setImageResource(R.drawable.bukitrongi);
                this.gambar.setImageResource(R.drawable.bukitrongi);
                this.deskripsi_wisata.setText("Bukit Rongi adalah salah satu Ikon Wisata Masyarakat Buton-Baubau yang mulai dikenal luas oleh Wisatawan dan para Traveller. Bukit Rongi atau dengan nama lain \"Bukit Teletubies\" terletak di Kampung Rongi, Desa Sandang Pangan, Kecamatan Sampolawa, Kabupaten Buton Selatan, Pulau Buton. Destinasi wisata yang satu ini memiliki keunikan tersendiri yang mempesona mata. Posisinya yang berada di-perbukitan menjadikan Bukit Rongi bukanlah destinasi wisata biasa, Bukit Rongi adalah Destinasi wisata adventure yang luar biasa dan sangat menantang. Adrenalin Anda akan mendapat sentuhan yang berbeda dari biasanya tempat wisata lain yang pernah Anda kunjungi. Hamparan padang rumput yang hijau, gugusan awan dan biru-nya langit menyatu dalam keindahan ketika para Wisatawan/Traveller berada di puncak Bukit Rongi.");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata4.booleanValue()) {
                kodewisata = "112";
                lat = "-5.6902899484316825";
                longi = "122.63270040129167";
                this.nama_wisata.setText("Pantai Jodoh");
                this.fotobesar.setImageResource(R.drawable.pantaijodoh);
                this.gambar.setImageResource(R.drawable.pantaijodoh);
                this.deskripsi_wisata.setText("Pantai Jodoh adalah salah satu destinasi wisata pantai di daerah Batauga di Buton, pantai ini banyak dipilih wisatawan untuk spot bersantai dan bermain air. Keindahan laut yang perlahan menghampiri hamparan pasir memang tidak diragukan lagi. Wisata cantik ini masih mempunyai lahan yang begitu luas serta bersih. Pengunjung yang mencari tempat melepas penat tentu tidak akan kesulitan.");
                this.biaya_masuk.setText("5.000");
            }
        }
        if (Daftarwisata.status_cardviewbutontengah.booleanValue()) {
            if (Daftarwisatapulaubuton.tombol_wisata1.booleanValue()) {
                kodewisata = "113";
                lat = "-5.313866004483647";
                longi = "122.3963313869511";
                this.fotobesar.setImageResource(R.drawable.goamaobu);
                this.nama_wisata.setText("Goa Maobu");
                this.gambar.setImageResource(R.drawable.goamaobu);
                this.deskripsi_wisata.setText("Goa Maobu adalah salah satu destinasi wisata alam yang terletak di bibir jalan poros Mawasangka-Labungkari, tepatnya di Desa Lalibo, Kecamatan Mawasangka Tengah, Kabupaten Buton Tengah, Provinsi Sulawesi Tenggara. Goa Maobu memiliki konsep yang jauh berbeda dengan tempat wisata kebanyakan dan goa maobu ini juga dekat dengan daerah pantai sehingga sering kali wisatawan menyebutnya juga dengan nama Pantai Maobu dikarenakan posisinya yang dekat dengan pesisir pantai. Namun keunikan dari goa maobu ini adalah bongkahan batu krust yang mengelilingi sepanjang bibir pantai dengan air payaunya yang begitu jernih dan segar.");
                this.biaya_masuk.setText("5.000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata2.booleanValue()) {
                kodewisata = "114";
                lat = "-5.329835822571083";
                longi = "122.36476211221482";
                this.nama_wisata.setText("Goa Koo");
                this.fotobesar.setImageResource(R.drawable.goakoo);
                this.gambar.setImageResource(R.drawable.goakoo);
                this.deskripsi_wisata.setText(" Goa Koo adalah salah satu destinasi wisata alam yang berada di Desa Lantongau, Kecamatan Mawasangka Tengah, Kabupaten Buton Tengah, Sultra. Goa Koo memiliki keunikan tersendiri, dimana di dalamnya terdapat danau dengan air yang begitu jernih hingga dasar danau begitu terlihat sangat jelas. Sementara di dinding goa wisatawan akan dimanjakan dengan keindahan Stalaktit yang menjulang ke bawah.Luas Goa mencapai 200 meter dengan dan luasan danau mencapai 80 meter bentangan. Sementara kedalama danau diperikirakan mencapai 8 meter.");
                this.biaya_masuk.setText("10.000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata3.booleanValue()) {
                kodewisata = "115";
                lat = "-5.291064677151755";
                longi = "122.56586032763289";
                this.nama_wisata.setText("Benteng Bombonawulu");
                this.fotobesar.setImageResource(R.drawable.bentengbombonawulu);
                this.gambar.setImageResource(R.drawable.bentengbombonawulu);
                this.deskripsi_wisata.setText("Benteng Bombonawulu adalah salah satu destinasi wisata budaya yang terletak di Kecamatan Lakudo, Kabupaten Buton, Sulawesi Tenggara. Ini merupakan tempat pertahanan dari Rumpun Bombonawulu, yang merupakan salah satu peninggalan dari Kerajaan Bombonawulu. Diketahui Kerjaan Bombonawulu telah terbentuk sebelum Kerajaan Buton. menikmati pesona alam dari teluk Lasongko, teluk Lombe, dan Selat Buton.");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata4.booleanValue()) {
                kodewisata = "116";
                lat = "-5.406120099469575";
                longi = "122.5127184288344";
                this.nama_wisata.setText("Pantai Katembe");
                this.fotobesar.setImageResource(R.drawable.pantaikatembe);
                this.gambar.setImageResource(R.drawable.pantaikatembe);
                this.deskripsi_wisata.setText("Pantai Katembe adalah salah satu destinasi wisata pantai di daerah Madongka, Kec. Lakudo, Kab. Buton, Sulawesi Tenggara.  Pantai Katembe adalah salah satu pantai yang mempunyai sertifikat sebagai salah satu destinasi wisatadi Buton Tengah yang dapat menarik banyak perhatian wisatawan. Keunikan dari pantai katembe ini yaitu memiliki pasir dua warna dan airnya yang jernih, kecantikan biota bawah lautnya yang beragam dan terdapat sumur yang melegenda. ");
                this.biaya_masuk.setText("5.000");
            }
        }
        if (Daftarwisata.status_cardviewwakatobi.booleanValue()) {
            if (Daftarwisatapulaubuton.tombol_wisata1.booleanValue()) {
                kodewisata = "117";
                lat = "-5.22581659687836";
                longi = "123.58202454467812";
                this.fotobesar.setImageResource(R.drawable.tamannasionalwakatobi);
                this.nama_wisata.setText("Pantai Patuno Wakatobi");
                this.gambar.setImageResource(R.drawable.tamannasionalwakatobi);
                this.deskripsi_wisata.setText("Taman Nasional Wakatobi di Sulawesi Tenggara adalah salah satu kawasan yang memiiki jumlah terumbu karang dan spesies ikan terbanyak di dunia. Di dalam lautnya terdapat lebih dari 942 spesies ikan serta 750 jenis dari 850 koleksi terumbu karang di dunia. Taman nasional ini juga memiliki 50 diving spot yang dapat diakses dari pulau-pulau besar di sekitarnya yang menjadikan wisata ini unik dari wisata lainnya.");
                this.biaya_masuk.setText("10.000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata2.booleanValue()) {
                kodewisata = "118";
                lat = "-5.376799756235555";
                longi = "123.59199942773853";
                this.nama_wisata.setText("Masjid Mubarok Wakatobi");
                this.fotobesar.setImageResource(R.drawable.masjidmubarok);
                this.gambar.setImageResource(R.drawable.masjidmubarok);
                this.deskripsi_wisata.setText(" Masjid Mubarok adalah salah satu destinasi wisata budaya yang berada di Pulau Wangi-Wangi Selatan, Kabupaten Wakatobi, Provinsi Sulawesi Tenggara. Masjid Mubarok didirikan pada tahun 1546 dan dikenal sebagai Masjid Agung Keraton Liya Togo di Pulau Wangi Wangi, Liya Togo, Wangi-Wangi Selatan, Liya Mawi, Kabupaten Wakatobi, Sulawesi Tenggara. Masjid Mubarok merupakan masjid tertua kedua di Kabupaten Waktobi yang masih berdiri kukuh hingga kini, setelah Masjid Agung Keraton Wolio. Masjid berusia ratusan tahun ini sampai sekarang masih terus digunakan oleh kaum Muslimin di sana untuk beribadah.");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata3.booleanValue()) {
                kodewisata = "119";
                lat = "-5.3766715475971";
                longi = "123.5920969941832";
                this.nama_wisata.setText("Benteng Liya Togo");
                this.fotobesar.setImageResource(R.drawable.bentengliyatogo);
                this.gambar.setImageResource(R.drawable.bentengliyatogo);
                this.deskripsi_wisata.setText("Benteng Liya Togo adalah salah satu destinasi wisata budaya yang berada di Desa Liya Togo, Kecamatan Wangi-Wangi Selatan, Kabupaten Wakatobi, Provinsi Sulawesi Tenggara. Benteng Liya Togo dibangun untuk menghalau serangan musuh dari arah timur pada masanya. Benteng ini terbuat dari batu karang dan mempunyai 13 buah pintu (terletak 4 pintu didalam dan 9 pintu diluar pemukiman). Dan didalam benteng juga terdapat masjid yang dibangun pada abad XX yang ditandai dengan gaya arsitektur bangunannya.  ");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata4.booleanValue()) {
                kodewisata = "120";
                lat = "-5.261187988385983";
                longi = "123.51989135792546";
                this.nama_wisata.setText("Pantai Cemara");
                this.fotobesar.setImageResource(R.drawable.pantaicemara);
                this.gambar.setImageResource(R.drawable.pantaicemara);
                this.deskripsi_wisata.setText("Pantai Cemara adalah salah satu destinasi wisata pantai di Desa Sombu Kecamatan Wangi-Wangi. Pantai ini memiliki panjang sekitar 200 meter dengan adanya balutan pasir putih yang menakjubkan. Jarak untuk pantai ini sekitar 7 km dari pusat kota Wangi-Wangi dimana ada banyak fasilitas yang bisa didaatkan yaitu warung makan, pondokan, ayunan dan wahana permainan air seperti banana boat. Keunikan dari pantai ini yaitu pantainya teduh dan bersih yang mendukung suasana liburan jadi lebih menyenangkan.");
                this.biaya_masuk.setText("10.000");
            }
        }
        if (Daftarwisata.status_cardviewbutonutara.booleanValue()) {
            if (Daftarwisatapulaubuton.tombol_wisata1.booleanValue()) {
                kodewisata = "121";
                lat = "-4.774399108378632";
                longi = "123.20236347739736";
                this.fotobesar.setImageResource(R.drawable.pantaimumbuku);
                this.nama_wisata.setText("Pantai Mumbuku");
                this.gambar.setImageResource(R.drawable.pantaimumbuku);
                this.deskripsi_wisata.setText("Pantai Mumbuku adalah salah satu destinasi wisata alam yang terletak di daerah Desa Kadacua, Kecamatan Kulisusu Kabupaten Buton Utara, Provinsi Sulawesi Tenggara. Pantai Mumbuku merupakan wisata populer di Desa Kadacua Kecamatan Kulisusu dan selain berenang dan menikmati pemandangan, keunikan lain dari pantai mumbuku ini yaitu pengunjung juga dapat menikmati aktivitas memancing di pantai itu, karena laut di sekitar Pantai Membuku masih sangat alami dan menyimpan beragam jenis ikan. ");
                this.biaya_masuk.setText("15.000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata2.booleanValue()) {
                kodewisata = "122";
                lat = "-4.836655309012038";
                longi = "123.17362447073279";
                this.nama_wisata.setText("Pantai Bone");
                this.fotobesar.setImageResource(R.drawable.pantaibone);
                this.gambar.setImageResource(R.drawable.pantaibone);
                this.deskripsi_wisata.setText(" Pantai Bone adalah salah satu destinasi wisata alam yang berada di di Desa Malalanda, Kecamatan Kulisusu Kabupaten Buton Utara Provinsi Sulawesi Tenggara. Di pantai ini terdapat sejumlah vila dan taman serta jembatan sepanjang 300 meter dengan dua buah gazebo yang bisa menjadi salah satu spot untuk menikmati keindahan Pantai Bone. Uniknya pantai ini mempunyai hamparan pasir putih hanya pada bagian depan dengan bentuk lurus di sepanjang pantai dan menampakan kesan garis kuning dan menambah keunikan dari wisata ini dan termasuk dalam 10 spot wisatayang cocok untuk diving diwisata Buton Utara.");
                this.biaya_masuk.setText("15.000");
            }
            if (Daftarwisatapulaubuton.tombol_wisata3.booleanValue()) {
                kodewisata = "123";
                lat = "-4.824620860378476";
                longi = "122.97196607207714";
                this.nama_wisata.setText("Air Terjun La Ocu");
                this.fotobesar.setImageResource(R.drawable.airterjunlaocu);
                this.gambar.setImageResource(R.drawable.airterjunlaocu);
                this.deskripsi_wisata.setText("Air Terjun Laocu adalah salah satu destinasi wisata alam yang berada di Desa Eensumala, Kecamatan bonegunu, Kabupaten Buton Utara Provinsi Sulawesi Tenggara. Air Terjun La Ocu merupakan wisata tersembunyi dan berada di ketinggian 73 mdpl, wisata ini masih sangat alami sehingga menarik untuk dikunjungi di Buton Utara.");
                this.biaya_masuk.setText("Gratis");
            }
            if (Daftarwisatapulaubuton.tombol_wisata4.booleanValue()) {
                kodewisata = "124";
                lat = "-4.783414015918986";
                longi = "123.17953999958557";
                this.nama_wisata.setText("Benteng Kulisusu");
                this.fotobesar.setImageResource(R.drawable.bentengkulisusu);
                this.gambar.setImageResource(R.drawable.bentengkulisusu);
                this.deskripsi_wisata.setText("Benteng Kulisusu adalah salah satu destinasi wisata budaya yang berada di daerah Lipu Ereke,Kecamatan Kulisusu, Kabupaten Buton Utara Provinsi Sulawesi Tenggara. Benteng Kulisusu merupakan benteng peninggalan di masa pemerintahan Lakino Kulisusu (Raja Kulisusu) pada abad \" \nXVII. Ide pembangunan benteng, timbul dari seorang tokoh syiar Islam kala itu yang bernama Buraku (Gaumalanga). Benteng Kulisusu didirikan dengan tujuan untuk melindungi masyarakat yang bermukim di dalam kawasan benteng, dari serangan musuh.  Kulisusu sendiri dalam Bahasa Ereke berarti kulit kerang. \" \nBenteng Kulisusu berbahan baku batu kapur. Ia disusun dengan ketinggian mencapai sekitar 4 meter, luas area kurang lebih 13 hektar, dan berada pada 600 meter di atas permukaan laut. Keunikan dari benteng ini yaitu terdapat bermacam-macam peninggalan sejarah, yakni selain kulit kerang (kulisusu)\" \njuga terdapat masjid, aula, dan makam raja-raja yang bisa dijumpai pengunjung .");
                this.biaya_masuk.setText("Gratis");
            }
        }
        load_data_ratting();
        load_data2();
        this.tombol_lokasi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Informasiwisata.this.startActivity(new Intent(Informasiwisata.this.getApplicationContext(), lokasi.class));
            }
        });
        this.lihatjadwal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Informasiwisata.this.customDialog.show();
            }
        });
        this.kirim_komentar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (Informasiwisata.this.isi_komentar.toString().length() == 0) {
                    Informasiwisata.this.isi_komentar.setError("Tidak Boleh Kosong");
                    return;
                }
                Volley.newRequestQueue(Informasiwisata.this.getApplicationContext()).add(new StringRequest(1, new Configurasi().baseUrl() + "tambah_komentar.php", new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            if (new JSONObject(response).getString("status_kirim").equals("berhasil")) {
                                Informasiwisata.this.isi_komentar.setText("");
                                Informasiwisata.this.load_data2();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Informasiwisata.this.getApplicationContext(), "Error :" + error.getMessage(), 0).show();
                    }
                }) {
                    /* access modifiers changed from: protected */
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> myParams = new HashMap<>();
                        myParams.put("kode_wisata", Informasiwisata.kodewisata);
                        myParams.put("foto_profil", Informasiwisata.getData.getString("session_foto", (String) null));
                        myParams.put("nama", Informasiwisata.getData.getString("session_nama", (String) null));
                        myParams.put("isi_komentar", Informasiwisata.this.isi_komentar.getText().toString());
                        return myParams;
                    }
                });
            }
        });
        this.kirim_rating.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Volley.newRequestQueue(Informasiwisata.this.getApplicationContext()).add(new StringRequest(1, new Configurasi().baseUrl() + "tambah_ratting.php", new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            if (new JSONObject(response).getString("status_kirim").equals("berhasil")) {
                                Informasiwisata.this.rattingbar2.setRating(0.0f);
                                Informasiwisata.this.load_data_ratting();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Informasiwisata.this.getApplicationContext(), "Error :" + error.getMessage(), 0).show();
                    }
                }) {
                    /* access modifiers changed from: protected */
                    public Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> myParams = new HashMap<>();
                        myParams.put("kode_wisata", Informasiwisata.kodewisata);
                        myParams.put("ratting", String.valueOf(Informasiwisata.this.rattingbar2.getRating()));
                        return myParams;
                    }
                });
            }
        });
        this.gambar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Informasiwisata.this.customeGambar.show();
            }
        });
    }

    private void initCustomDialog() {
        Dialog dialog = new Dialog(this);
        this.customDialog = dialog;
        dialog.requestWindowFeature(1);
        this.customDialog.setContentView(R.layout.jadwal);
        this.customDialog.setCancelable(true);
    }

    private void initCustomeGambar() {
        this.customeGambar = new Dialog(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        this.inflater = layoutInflater;
        this.view = layoutInflater.inflate(R.layout.kumpulanfotowisata, (ViewGroup) null);
        this.customeGambar.requestWindowFeature(1);
        this.customeGambar.setContentView(this.view);
        this.fotobesar = (ImageView) this.view.findViewById(R.id.fotobesar);
        this.customeGambar.setCancelable(true);
    }

    /* access modifiers changed from: package-private */
    public void load_data_ratting() {
        Volley.newRequestQueue(getApplicationContext()).add(new StringRequest(1, new Configurasi().baseUrl() + "tampilkan_ratting.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    Float rate = Float.valueOf(new JSONObject(response).getString("ratarate"));
                    if (rate.floatValue() == 0.0f) {
                        Informasiwisata.this.rattingbar1.setRating(0.0f);
                    }
                    if (rate.floatValue() >= 1.0f) {
                        Informasiwisata.this.rattingbar1.setRating(1.0f);
                    }
                    if (rate.floatValue() >= 2.0f) {
                        Informasiwisata.this.rattingbar1.setRating(2.0f);
                    }
                    if (rate.floatValue() >= 3.0f) {
                        Informasiwisata.this.rattingbar1.setRating(3.0f);
                    }
                    if (rate.floatValue() >= 4.0f) {
                        Informasiwisata.this.rattingbar1.setRating(4.0f);
                    }
                    if (rate.floatValue() >= 5.0f) {
                        Informasiwisata.this.rattingbar1.setRating(5.0f);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Informasiwisata.this, "Anda Sedang Offline!", 0).show();
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put("kode_wisata", Informasiwisata.kodewisata);
                return form;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void load_data2() {
        Volley.newRequestQueue(this).add(new StringRequest(1, new Configurasi().baseUrl() + "tampilkan_komentar.php", new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONObject(response).getJSONArray("data");
                    Informasiwisata.this.model = new ArrayList<>();
                    for (int i = 0; i <= jsonArray.length(); i++) {
                        JSONObject getData = jsonArray.getJSONObject(i);
                        Informasiwisata.this.model.add(new GetDataKomentar(getData.getInt(UploadTaskParameters.Companion.CodingKeys.id), getData.getString("foto_profil"), getData.getString("nama"), getData.getString("isi_komentar")));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Informasiwisata.this.list.setAdapter(new AdaptorKomentar(Informasiwisata.this.getApplicationContext(), Informasiwisata.this.model));
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            /* access modifiers changed from: protected */
            public Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> form = new HashMap<>();
                form.put("kode_wisata", Informasiwisata.kodewisata);
                return form;
            }
        });
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void onBackPressed() {
        super.onBackPressed();
        Daftarwisatapulaubuton.tombol_wisata1 = false;
        Daftarwisatapulaubuton.tombol_wisata2 = false;
        Daftarwisatapulaubuton.tombol_wisata3 = false;
        Daftarwisatapulaubuton.tombol_wisata4 = false;
        kodewisata = "";
    }
}
