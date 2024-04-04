package com.example.tugasbottomnav.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasbottomnav.Item;
import com.example.tugasbottomnav.Adapter;
import com.example.tugasbottomnav.R;
import com.example.tugasbottomnav.calculator1;
import com.example.tugasbottomnav.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment implements Adapter.OnItemClickListener{

    RecyclerView recyclerView;
    List<Item> listData;
    Adapter adapter;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment2, container, false);
        recyclerView = rootView.findViewById(R.id.rvDataRuang);
        listData = new ArrayList<>();

        Item item1 = new Item();
        item1.setShape("Cube");
        listData.add(item1);

        Item item3 = new Item();
        item3.setShape("Cone");
        listData.add(item3);

        Item item4 = new Item();
        item4.setShape("Sphere");
        listData.add(item4);

        adapter = new Adapter(getContext(), listData);
        adapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return rootView;

    }

    @Override
    public void onItemClick(int position) {
        if (position == 0) {
            String shape = listData.get(position).getShape();
            Intent intent = new Intent(requireContext(), calculator1.class);
            intent.putExtra("shape1", shape);
            startActivity(intent);
        } else if (position == 1) {
            String shape = listData.get(position).getShape();
            Intent intent = new Intent(requireContext(), calculator2.class);
            intent.putExtra("shape2", shape);
            startActivity(intent);
        } else if (position == 2) {
            String shape = listData.get(position).getShape();
            Intent intent = new Intent(requireContext(), calculator1.class);
            intent.putExtra("shape1", shape);
            startActivity(intent);
        } else {
            Toast.makeText(requireContext(), "Item clicked: " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
