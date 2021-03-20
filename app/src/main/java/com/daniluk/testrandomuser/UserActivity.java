package com.daniluk.testrandomuser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.daniluk.testrandomuser.model.UsersViewModel;
import com.daniluk.testrandomuser.pojo.UserData;
import com.squareup.picasso.Picasso;

import static com.daniluk.testrandomuser.api.ApiFactory.createLog;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        TextView tvFirstName = findViewById(R.id.tvFirstName);
        TextView tvLastName = findViewById(R.id.tvLastName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvCity = findViewById(R.id.tvCity);
        TextView tvCountry = findViewById(R.id.tvCountry);
        ImageView ivLargeImage = findViewById(R.id.ivLargeImage);



                UsersViewModel.getUsersViewModel().getListUsers().observe(this, listUsers -> {
            try {
                int userPosition = getIntent().getIntExtra(USER_NUMBER, 0);
                UserData user = UsersViewModel.getUsersViewModel().getListUsers().getValue().get(userPosition);
                tvFirstName.setText(user.getName().getFirst());
                tvLastName.setText(user.getName().getLast());
                tvEmail.setText(user.getEmail());
                tvCity.setText(user.getLocation().getCity());
                tvCountry.setText(user.getLocation().getCountry());

                Picasso.get().load(user.getPicture().getLarge()).into(ivLargeImage);
            } catch (Exception e) {
                createLog("Ошибка данных");
                e.printStackTrace();
            }
        });
    }

    public static Intent getIntentForStartActivity(Context context, int userPosition) {
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(USER_NUMBER, userPosition);
        return intent;
    }

    public static String USER_NUMBER = "userNumber";
}