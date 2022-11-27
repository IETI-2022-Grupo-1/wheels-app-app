package com.example.wheelsapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wheelsapp.MainActivity2;
import com.example.wheelsapp.R;
import com.example.wheelsapp.databinding.FragmentHomeBinding;
import com.example.wheelsapp.utils.RoleEnum;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private static List<ListElement> elements;
    private static Socket mSocket;
    private Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        elements = new ArrayList<>();
        elements.add(0, new ListElement("Escuela Colombiana de ingenieria","Salida 1:00pm - Llegada 6:00pm","Cra 62 #171-41","","","Andrés Pico","Renault Duster Oroch"));
        elements.add(0, new ListElement("Universidad los Andes","Salida 3:00pm - Llegada 6:00pm","Cra 62 #171-41","Unicentro","Titan","Johan Pico","Renault Duster Oroch"));
        init();
        button = root.findViewById(R.id.button4);

        //envia infro al socket
        //attemptSend();
        mSocket.connect();
        //escucha el socket
        mSocket.on("newTrip", onNewMessage);

        if (MainActivity2.getUser().getRoles().contains(RoleEnum.DRIVER)) {
            System.out.println("home entro");
            button.setVisibility(View.VISIBLE);
            return root;
        } else {
            System.out.println("home no entro");
            button.setVisibility(View.INVISIBLE);
            return root;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void init(){
        ListAdapter listAdapter = new ListAdapter(elements,getContext());
        RecyclerView recyclerView = binding.listRecyclerView;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }

    {
        try {
            mSocket = IO.socket("https://wheelsapp-realtime.herokuapp.com");
        } catch (URISyntaxException e) {
        }
    }

    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            ArrayList<String> requestSocket = new ArrayList<>();
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    JSONObject data = (JSONObject) args[0];
                    if(!requestSocket.contains(data.toString())) {
                        requestSocket.add(data.toString());
                        elements.add(0, new ListElement("Universidad los Andes","Salida 3:00pm - Llegada 6:00pm","Cra 62 #171-41","Unicentro","Titan","Johan Pico","Renault Duster Oroch"));
                        init();
                    }

                }
            });
        }
    };

    private void attemptSend() {
        mSocket.emit("newTripAdded", "Holi "+ System.currentTimeMillis());
        mSocket.connect();
    }

    public void connect(){
        attemptSend();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mSocket.disconnect();
        mSocket.off("disconnect", onNewMessage);
    }
}