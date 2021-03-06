package com.daniluk.testrandomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.daniluk.testrandomuser.adapters.ListUsersAdapter;
import com.daniluk.testrandomuser.model.UsersViewModel;

public class ListUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        RecyclerView recyclerView = findViewById(R.id.rwListUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListUsersAdapter adapter = new ListUsersAdapter();
        recyclerView.setAdapter(adapter);

        UsersViewModel viewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        UsersViewModel.setUsersViewModel(viewModel);

        viewModel.getListUsers().observe(this, listUsers -> {
            adapter.setListUserData(listUsers);
        });


    }
}