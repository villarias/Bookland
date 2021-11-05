package com.example.bookland.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.bookland.AppExecutors;
import com.example.bookland.R;
import com.example.bookland.database.Book;
import com.example.bookland.database.BookDatabase;
import com.example.bookland.database.BookItemDao;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements AdapterBook.OnBookClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AdapterBook mAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ImageButton searchButton = (ImageButton) v.findViewById(R.id.buttonSearch);
        EditText buscador = (EditText) v.findViewById(R.id.editBuscador);

        BookDatabase database = BookDatabase.getInstance(this.getContext());
        BookItemDao dao = database.getDao();



        mAdapter = new AdapterBook(new ArrayList<>(),this,this.getContext());
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recyclerHome);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));



        Book b1 = new Book("La Marca de Atenea","Rick Riordan","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1397161148l/18209368._SX98_.jpg",2,2001,6,4);
        Book b2 = new Book("La Marca de Atenea","Rick Riordan","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1397161148l/18209368._SX98_.jpg",2,2001,6,4);
        Book b3 = new Book("La Marca de Atenea","Rick Riordan","https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1397161148l/18209368._SX98_.jpg",2,2001,6,4);
        List<Book> listBooks = new ArrayList<>();
        listBooks.add(b1);
        listBooks.add(b2);
        listBooks.add(b3);
        /*
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(b1);
            }
        });*/


        mAdapter.swap(listBooks);
        mRecyclerView.setAdapter(mAdapter);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListaBuscadorFragment fragment = new ListaBuscadorFragment();
                Bundle bundle = new Bundle();
                bundle.putString(ListaBuscadorFragment.ARG_NAME,buscador.getText().toString());
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onItemClick(Book b) {

        DetailsFragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DetailsFragment.ARG_TITULO,b.getTitle());
        bundle.putString(DetailsFragment.ARG_AUTOR,b.getAuthor());
        bundle.putString(DetailsFragment.ARG_IMAGE,b.getImage());
        bundle.putInt(DetailsFragment.ARG_NUMRATINGS,b.getRating());
        bundle.putInt(DetailsFragment.ARG_PUBLICATIONYEAR,b.getPublicationYear());
        fragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .addToBackStack(null)
                .commit();

    }
}