package com.daniluk.testrandomuser.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.daniluk.testrandomuser.api.ApiFactory;
import com.daniluk.testrandomuser.pojo.ListUsersData;
import com.daniluk.testrandomuser.pojo.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.daniluk.testrandomuser.api.ApiFactory.createLog;

public class UsersViewModel extends ViewModel {
    private static UsersViewModel usersViewModel = null;
    private final int numberUsers = 20;

    public UsersViewModel() {
        loadUsers(numberUsers);
    }

    public static UsersViewModel getUsersViewModel() {
        return usersViewModel;
    }

    public static void setUsersViewModel(UsersViewModel viewModel) {
            usersViewModel = viewModel;
    }
    private MutableLiveData<List<UserData>> listUsers;

    public LiveData<List<UserData>> getListUsers() {
        if (listUsers == null) {
            listUsers = new MutableLiveData<>();
        }
        return listUsers;
    }


    private void loadUsers(int numbers) {
        ApiFactory.createApiService().listUsersData(numbers).enqueue(new Callback<ListUsersData>() {
            @Override
            public void onResponse(Call<ListUsersData> call, Response<ListUsersData> response) {
                //createLog("Загрузка списка users успешна");
                if (response.body() != null) {
                    List<UserData> users = response.body().getResults();
                    listUsers.setValue(users);
                }

            }

            @Override
            public void onFailure(Call<ListUsersData> call, Throwable t) {
                createLog("Ошибка загрузки списка users");
            }
        });
    }

}
