package com.example.uas_180030459;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class TampilActivity extends AppCompatActivity {

    private TextView tvJudulLagu, tvNamaPenyanyi, tvAlbum, tvTahun, tvGenre;
    private CircleImageView imgProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        tvJudulLagu = findViewById(R.id.tv_judul_lagu);
        tvNamaPenyanyi = findViewById(R.id.tv_nama_penyanyi);
        tvAlbum = findViewById(R.id.tv_album);
        tvTahun = findViewById(R.id.tv_tahun);
        tvGenre = findViewById(R.id.tv_genre);
        imgProfilePicture = findViewById(R.id.profile_image_display);

        Intent receivedData = getIntent();
        Bundle data = receivedData.getExtras();
        tvJudulLagu.setText(data.getString("JUDUL_LAGU"));
        tvNamaPenyanyi.setText(data.getString("NAMA_PENYANYI"));
        tvAlbum.setText(data.getString("ALBUM"));
        tvTahun.setText(data.getString("TAHUN"));
        tvGenre.setText(data.getString("GENRE"));
        String imgLocation = data.getString("IMAGE");
        if (!imgLocation.equals(null)) {
            Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
            builder.downloader(new OkHttp3Downloader(getApplicationContext()));
            builder.build().load(imgLocation)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(imgProfilePicture);
        }
        imgProfilePicture.setContentDescription(imgLocation);
    }
}
