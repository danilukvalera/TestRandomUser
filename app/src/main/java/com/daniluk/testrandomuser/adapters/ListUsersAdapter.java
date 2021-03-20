package com.daniluk.testrandomuser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daniluk.testrandomuser.R;
import com.daniluk.testrandomuser.UserActivity;
import com.daniluk.testrandomuser.pojo.UserData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.daniluk.testrandomuser.api.ApiFactory.createLog;

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.UserHolder>{
    List<UserData> listUserData = new ArrayList<>();

    public void setListUserData(List<UserData> listUserData) {
        this.listUserData = listUserData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        try {
            holder.firstName.setText(listUserData.get(position).getName().getFirst());
            holder.lastName.setText(listUserData.get(position).getName().getLast());
            Picasso.get().load(listUserData.get(position).getPicture().getThumbnail()).into(holder.image);
        } catch (Exception e) {
            createLog("Ошибка данных");
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listUserData.size();
    }


    static class UserHolder extends RecyclerView.ViewHolder{
        private final TextView firstName;
        private final TextView lastName;
        private final ImageView image;

        public UserHolder(@NonNull View itemView) {
            super(itemView);

            this.firstName = itemView.findViewById(R.id.itemFirstName);
            this.lastName = itemView.findViewById(R.id.itemLastName);
            this.image = itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(v -> {
                Context context = v.getContext();
                context.startActivity(UserActivity.getIntentForStartActivity(context, getAdapterPosition()));
            });
        }
    }
}
