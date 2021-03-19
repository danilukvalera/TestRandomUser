package com.daniluk.testrandomuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.daniluk.testrandomuser.adapters.ListUsersAdapter;
import com.daniluk.testrandomuser.api.ApiFactory;
import com.daniluk.testrandomuser.model.UsersViewModel;
import com.daniluk.testrandomuser.pojo.ListUsersData;
import com.daniluk.testrandomuser.pojo.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.daniluk.testrandomuser.api.ApiFactory.createLog;

public class ListUsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        RecyclerView recyclerView = findViewById(R.id.rwListUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListUsersAdapter adapter = new ListUsersAdapter();
        recyclerView.setAdapter(adapter);

        UsersViewModel viewModel = new ViewModelProvider(this).get(UsersViewModel.class);
        viewModel.getListUsers().observe(this, listUsers -> {
            adapter.setListUserData(listUsers);
        });


    }
}