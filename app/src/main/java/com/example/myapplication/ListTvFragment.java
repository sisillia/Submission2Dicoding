package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListTvFragment extends Fragment {

    private String[] dataName;
    private String[] dataYear;
    private String[] dataDesc;
    private String[] dataPhoto;
    private ArrayList<ListData> list = new ArrayList<>();

    private RecyclerView recyclerTv;
    private ListDataAdapter listDataAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_tv_show_fragment, container, false);

        listDataAdapter = new ListDataAdapter(getContext());

        recyclerTv = (RecyclerView) view.findViewById(R.id.recycler_tvshow);
        recyclerTv.setHasFixedSize(true);

        takeData();
        addData();
        showRecycler();

        return view;
    }


    private void takeData(){
        dataName = getResources().getStringArray(R.array.name_movie);
        dataYear = getResources().getStringArray(R.array.year_movie_eng);
        dataDesc = getResources().getStringArray(R.array.desc_movie_eng);
        dataPhoto = getResources().getStringArray(R.array.image_movie);
    }

    private void addData() {
        list = new ArrayList<>();

        for (int i = 0; i < dataYear.length; i++) {
            ListData listData = new ListData();
            listData.setPhoto(dataPhoto[i]);
            listData.setName(dataName[i]);
            listData.setYear(dataYear[i]);
            listData.setLongDesc(dataDesc[i]);
            list.add(listData);
        }

        listDataAdapter.setListAdapter(list);
    }

    private void showRecycler() {
        recyclerTv.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerTv.setAdapter(listDataAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }


}
