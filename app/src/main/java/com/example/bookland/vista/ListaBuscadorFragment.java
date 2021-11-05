package com.example.bookland.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bookland.AppExecutors;
import com.example.bookland.R;
import com.example.bookland.database.Book;
import com.example.bookland.modelBook.BookResponse;
import com.example.bookland.modelBook.Result;
import com.example.bookland.network.NetworkListener;
import com.example.bookland.network.NetworkRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaBuscadorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaBuscadorFragment extends Fragment implements AdapterBook.OnBookClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_NAME= "name";
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterBook mAdapter;


    // TODO: Rename and change types of parameters
    private String mParam1;


    public ListaBuscadorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaBuscadorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaBuscadorFragment newInstance(String param1, String param2) {
        ListaBuscadorFragment fragment = new ListaBuscadorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mParam1 = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_lista_buscador, container, false);
        TextView nameBook = v.findViewById(R.id.nameBookBusacador);
        nameBook.setText(mParam1);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerBuscador);

        mAdapter = new AdapterBook(new ArrayList<>(),this,this.getContext());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerView.setAdapter(mAdapter);


        List<Book> booksObtained = new ArrayList<>();
        AppExecutors.getInstance().networkIO().execute(new NetworkRunnable(new NetworkListener() {
            @Override
            public void onBookLoaded(BookResponse books) {
                for(Result r : books.getResults()){
                    Book aux = new Book();
                    aux.setTitle(r.getTitle());
                    aux.setAuthor(r.getAuthor().getName());
                    aux.setImage(r.getImageUrl());
                    if(r.getOriginalPublicationYear()!= null)
                    aux.setPublicationYear(r.getOriginalPublicationYear());
                    if (r.getOriginalPublicationMonth() != null)
                    aux.setPublicationMonth(r.getOriginalPublicationMonth());
                    if (r.getOriginalPublicationDay() != null)
                        aux.setPublicationDay(r.getOriginalPublicationDay());
                    booksObtained.add(aux);
                }
                AppExecutors.getInstance().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.swap(booksObtained);
                    }
                });
            }
        },mParam1));
        return v;
    }

    @Override
    public void onItemClick(Book b) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DetailsFragment.ARG_TITULO,b.getTitle());
        bundle.putString(DetailsFragment.ARG_AUTOR,b.getAuthor());
        bundle.putString(DetailsFragment.ARG_IMAGE,b.getImage());
        //bundle.putInt(DetailsFragment.ARG_NUMRATINGS,b.getRating());
        //bundle.putInt(DetailsFragment.ARG_PUBLICATIONYEAR,b.getPublicationYear());
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}