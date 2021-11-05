package com.example.bookland.vista;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bookland.R;
import com.example.bookland.database.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterBook extends RecyclerView.Adapter<AdapterBook.ViewHolderBooks> {
    private List<Book> mItems;
    public OnBookClickListener listener;
    private Context context;
    public String autor;
    public String titulo;
    public int puntuacion;
    public String imagen;

    public interface OnBookClickListener {
        void onItemClick(Book b);
    }

    public AdapterBook (List<Book>mItems,OnBookClickListener ls,Context context){

        this.mItems=mItems;
        this.listener=ls;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderBooks onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        // Create new views (invoked by the layout manager)
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);

        return new ViewHolderBooks(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBooks holder, int position) {
        //holder.v=mItems.get(position);
        //Setters
        holder.b =mItems.get(position);
        holder.titulo.setText(mItems.get(position).getTitle());
        holder.autor.setText(mItems.get(position).getAuthor());
        Picasso.with(this.context)
                .load(mItems.get(position).getImage())
                .resize(240, 300)
                .centerCrop()
                .into(holder.portada);
        //holder.rating.setText(mItems.get(position).getRating());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(holder.b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }
    public void swap(List<Book> data){
        this.mItems = data;
        notifyDataSetChanged();
    }
    public static class ViewHolderBooks extends RecyclerView.ViewHolder {

        private TextView autor;
        private TextView titulo;
        private ImageView portada;
        private TextView rating;
        public View mView;

        public Book b;

        public ViewHolderBooks(View v) {
            super(v);
            mView=v;
            titulo =(TextView)v.findViewById(R.id.titulo);
            autor=(TextView)v.findViewById(R.id.autor);
            rating = (TextView)v.findViewById(R.id.rating);
            portada =  (ImageView)v.findViewById(R.id.portada);
        }
    }

}