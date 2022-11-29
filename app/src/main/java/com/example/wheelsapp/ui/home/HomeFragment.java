package com.example.wheelsapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wheelsapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    List<ListElement> elements;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        init();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("Escuela Colombiana de ingenieria","Salida 1:00pm - Llegada 6:00pm","Cra 62 #171-41","","","Andrés Pico","Renault Duster Oroch"));
        elements.add(new ListElement("Universidad los Andes","Salida 3:00pm - Llegada 6:00pm","Cra 62 #171-41","Unicentro","Titan","Johan Pico","Renault Duster Oroch"));
        ListAdapter listAdapter = new ListAdapter(elements,getContext());
        RecyclerView recyclerView = binding.listRecyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }


}