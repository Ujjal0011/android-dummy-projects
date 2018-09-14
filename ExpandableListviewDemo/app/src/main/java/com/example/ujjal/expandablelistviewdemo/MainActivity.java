package com.example.ujjal.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<String> headerList;
    private HashMap<String, List<String>> childList;
    private CustomAdapter customAdapter;
    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        customAdapter = new CustomAdapter(this, headerList, childList);
        expandableListView.setAdapter(customAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String groupName = headerList.get(groupPosition);
                Toast.makeText(getApplicationContext(), "group name: " + groupName, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String groupName = headerList.get(groupPosition);
                Toast.makeText(getApplicationContext(), groupName + " is collapsed ", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childString = childList.get(headerList.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(), childString, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && lastExpandedPosition != groupPosition){
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });
    }

    private void prepareListData() {
        String[] headerString = getResources().getStringArray(R.array.header);
        String[] childString = getResources().getStringArray(R.array.child);

        headerList = new ArrayList<>();
        childList = new HashMap<>();

        for(int i = 0; i < headerString.length; i++){

            //adding header data
            headerList.add(headerString[i]);

            List<String> child = new ArrayList<>();
            child.add(childString[i]);

            childList.put(headerList.get(i), child);
        }
    }
}
