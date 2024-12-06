package tn.isetmd.dsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PostsAdapter extends ArrayAdapter<Poste> {

    private ArrayList<Poste> listPosts;
    private Context mContext;

    public PostsAdapter(@NonNull Context mContext,
                        int resource,
                        @NonNull ArrayList<Poste> values) {
        super(mContext, resource, values);
        listPosts = values;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public View getView(
            int position,
            @Nullable View convertView,
            @NonNull ViewGroup parent
    ) {

        Poste poste=listPosts.get(position);
        View itemView = LayoutInflater
                .from(getContext())
                .inflate(              //inflate trake7 les données f blayeshom mebin Poste.java w item_post.xml
                        R.layout.item_post,
                        parent,
                        false);
        TextView tvTitre= (TextView) itemView.findViewById(R.id.tvTitre);
        TextView tvDescription= (TextView) itemView.findViewById(R.id.tvDescription);
        ImageView imagePost= (ImageView) itemView.findViewById(R.id.imagePost);

        tvTitre.setText(poste.getTitre());
        tvDescription.setText(poste.getDescription());
        imagePost.setImageResource(poste.getImage());


        return itemView;
    }
}
