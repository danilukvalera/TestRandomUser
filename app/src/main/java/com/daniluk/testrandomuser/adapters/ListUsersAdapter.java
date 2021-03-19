package com.daniluk.testrandomuser.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import com.daniluk.testrandomuser.R;
import com.daniluk.testrandomuser.pojo.UserData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListUsersAdapter extends RecyclerView.Adapter<ListUsersAdapter.UserHolder>{
    List<UserData> listUserData = new ArrayList<UserData>();

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
        holder.firstName.setText(listUserData.get(position).getName().getFirst());
//        holder.lastName.setText(listUserData.get(position).getName().getLast());
//        Picasso.get().load(listUserData.get(position).getPicture().getThumbnail()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listUserData.size();
    }


    class UserHolder extends RecyclerView.ViewHolder{
        private TextView firstName;
        private TextView lastName;
        private ImageView image;

        public UserHolder(@NonNull View itemView) {
            super(itemView);

            this.firstName = firstName;
            this.lastName = lastName;
            this.image = image;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    //context.startActivity();
                }
            });
        }
    }
}
