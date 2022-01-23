package com.example.uas_180030459.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.example.uas_180030459.InputActivity;
import com.example.uas_180030459.R;
import com.example.uas_180030459.TampilActivity;
import com.example.uas_180030459.model.Music;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    private List<Music> dataMusic;
    private Context context;

    public MusicAdapter(List<Music> dataMusic, Context context) {
        this.dataMusic = dataMusic;
        this.context = context;
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_music, parent, false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        Music tempMusic = dataMusic.get(position);
        holder.id = tempMusic.getId();
        holder.judulLagu = tempMusic.getJudulLagu();
        holder.namaPenyanyi = tempMusic.getNamaPenyanyi();
        holder.album = tempMusic.getAlbum();
        holder.tahun = tempMusic.getTahun();
        holder.genre = tempMusic.getGenre();
        holder.tvJudulLagu.setText(tempMusic.getJudulLagu());
        holder.tvNamaPenyanyi.setText(tempMusic.getNamaPenyanyi());
        String imgLocation = tempMusic.getPhoto();
        if(!imgLocation.equals(null)) {
            //Picasso.get().load(imgLocation).resize(64, 64).into(holder.imgAvatar);
            Picasso.Builder builder = new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(imgLocation)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imgAvatar);
        }
        holder.imgAvatar.setContentDescription(tempMusic.getPhoto());
    }

    @Override
    public int getItemCount() {
        return dataMusic.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private TextView tvJudulLagu, tvNamaPenyanyi;
        private CircleImageView imgAvatar;
        private int id;
        private String judulLagu, namaPenyanyi, album, tahun, genre;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudulLagu = itemView.findViewById(R.id.tv_judul_lagu);
            tvNamaPenyanyi = itemView.findViewById(R.id.tv_nama_penyanyi);
            imgAvatar = itemView.findViewById(R.id.profile_image);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent openDisplay = new Intent(context, TampilActivity.class);
            openDisplay.putExtra("JUDUL_LAGU", tvJudulLagu.getText());
            openDisplay.putExtra("NAMA_PENYANYI", tvNamaPenyanyi.getText());
            openDisplay.putExtra("ALBUM", album);
            openDisplay.putExtra("TAHUN", tahun);
            openDisplay.putExtra("IMAGE", imgAvatar.getContentDescription());
            openDisplay.putExtra("GENRE", genre);
            itemView.getContext().startActivity(openDisplay);
        }

        @Override
        public boolean onLongClick(View v) {
            Intent openInput = new Intent(context, InputActivity.class);
            openInput.putExtra("OPERATION", "update");
            openInput.putExtra("ID", id);
            openInput.putExtra("JUDUL_LAGU", tvJudulLagu.getText());
            openInput.putExtra("NAMA_PENYANYI", tvNamaPenyanyi.getText());
            openInput.putExtra("ALBUM", album);
            openInput.putExtra("TAHUN", tahun);
            openInput.putExtra("IMAGE", imgAvatar.getContentDescription());
            openInput.putExtra("GENRE", genre);
            itemView.getContext().startActivity(openInput);
            return true;
        }
    }
}