package aplikasi.mobile.listviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Menu_Daftar_Makanan extends AppCompatActivity {

    ListView lvItem;
    EditText Edtcari;
    ListViewAdapterCall adapter;
    ArrayList<ListViewAdapterMenu> arraylist = new ArrayList<ListViewAdapterMenu>();

    int[] Gambar;
    String[] NamaItem;
    String[] HargaItem;
    String[] Deskripsi;
    String[] NomorHP;
    String[] Lat;
    String[] Long;

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_daftar_makanan);

        lvItem		= (ListView)findViewById(R.id.listView1);
        Edtcari     = (EditText)findViewById(R.id.editText1);


        Gambar		= new int[]{
                R.mipmap.a_steamlogo,
                R.mipmap.pubg,
                R.mipmap.mobile,
                R.mipmap.coc,
                R.mipmap.ff};

        NamaItem 	= new String[]{
                "Steam Wallet ",
                "UC PUBG Mobile",
                "Mobile Legends Diamond",
                "Diamond COC",
                "DM Free Fire"};

        HargaItem 	= new String[]{
                "Dimulai Dari 10.000-10.000.000 Rupiah",
                "Dimulai Dari 15.000-10.000.000 Rupiah",
                "Dimulai Dari 5.000-10.000.000 Rupiah",
                "Dimulai Dari 20.000-10.000.000 Rupiah",
                "Dimulai Dari 10.000-10.000.000 Rupiah"};

        Deskripsi 	= new String[]{
                "Steam adalah layanan distribusi digital video game oleh Valve. Diluncurkan sebagai klien perangkat lunak mandiri pada September 2003 sebagai cara bagi Valve untuk menyediakan pembaruan otomatis untuk game mereka, dan diperluas untuk menyertakan game dari penerbit pihak ketiga.",

                "PlayerUnknown's Battlegrounds (sering disingkat PUBG) adalah sebuah permainan battle royale, di mana 100 orang sekaligus dapat bermain secara daring. Pemenang dari permainan ini adalah individu atau tim yang dapat bertahan hingga akhir. Pemain bisa bermain sendirian (solo), tim dengan dua orang (duo), dan tim dengan empat orang (squad). Pemain bisa mengundang teman di daftar teman (friend list) untuk bergabung ke dalam permainan sebagai sebuah tim.",

                "Mobile Legends: Bang Bang, biasa disebut ML atau MLBB, adalah game arena pertempuran online multipemain seluler yang dikembangkan dan diterbitkan oleh Moonton, anak perusahaan ByteDance.",

                "Clash of Clans adalah permainan video strategi seluler freemium yang dikembangkan dan diterbitkan oleh pengembang permainan Finlandia, Supercell. Permainan ini dirilis untuk platform iOS pada 2 Agustus 2012, dan di Google Play untuk Android pada 7 Oktober 2013.",

                "Garena Free Fire atau biasa disebut Free Fire (sering disingkat FF) adalah permainan battle royale yang dikembangkan oleh 111 Dots Studio dan diterbitkan oleh Garena untuk Android dan iOS. Itu menjadi permainan seluler yang paling banyak diunduh secara global pada tahun 2019."};
				

        NomorHP  = new String[]{
                "+6285499376607",
                "+6285499376607",
                "+6285499376607",
                "+6285499376607",
                "+6285499376607",
        };

        Lat  = new String[]{
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812",
                "-7.0268812"
        };

        Long  = new String[]{
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669",
                "110.424669"
        };


        for (int i = 0; i < NamaItem.length; i++)
        {
            ListViewAdapterMenu wp = new ListViewAdapterMenu(NamaItem[i], HargaItem[i], Deskripsi[i], Gambar[i], NomorHP[i], Lat[i], Long[i]);
            arraylist.add(wp);
        }

        adapter = new ListViewAdapterCall(this, arraylist);
        lvItem.setAdapter(adapter);

        Edtcari.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                String text = Edtcari.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
                showToastMessage("Pencarian dilakukan");
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub
            }
        });

    }

    void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
