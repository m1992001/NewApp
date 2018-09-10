package com.example.newapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment {

    private List<MyListItem> myListItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String username1 = (String) getArguments().get("input_username");
        String userclass1 = (String) getArguments().get("reg_class");
        Log.d("Fragment3"," ****** " + username1 + "  " + userclass1);
        TextView username = getActivity().findViewById(R.id.username);
        TextView userclass = getActivity().findViewById(R.id.user_class);
        username.setText(username1);
        userclass.setText(userclass1);


        setHasOptionsMenu(true);
        Toolbar toolbar_my = getActivity().findViewById(R.id.toolbar_my);
        toolbar_my.setTitle("  ");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar_my);

        initItem();
        ItemAdapter adapter = new ItemAdapter(getContext(), R.layout.my_item, myListItems);
        ListView listView = getActivity().findViewById(R.id.my_item_list);
        listView.setAdapter(adapter);

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.toolbar_my, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(getContext(), "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(getContext(), "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(getContext(), "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    private void initItem(){
        MyListItem item1 = new MyListItem("我的消息", R.drawable.my_info);
        myListItems.add(item1);
        MyListItem item2 = new MyListItem("报表数据分析",R.drawable.my_data);
        myListItems.add(item2);
        MyListItem item3 = new MyListItem("康复效率分析", R.drawable.my_productivity);
        myListItems.add(item3);
        MyListItem item4 = new MyListItem("康复投入信息", R.drawable.my_health);
        myListItems.add(item4);
        MyListItem item5 = new MyListItem("设置", R.drawable.my_setting);
        myListItems.add(item5);

    }
}