package com.example.distributednfcchatapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.distributednfcchatapp.Model.User;
import com.example.distributednfcchatapp.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context cContext;
    private List<User> mUsers;

    public UserAdapter(Context cContext, List<User> cUsers) {
        this.cContext = cContext;
        this.mUsers = cUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(cContext).inflate(R.layout.user_item, viewGroup, false);

        return new UserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User user = mUsers.get(i);
        viewHolder.username.setText(user.getUserName());

        if (user.getProfilePictureURL().equals("default")) {
            viewHolder.profile_picture.setImageResource(R.mipmap.ic_launcher);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView profile_picture;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            profile_picture = itemView.findViewById(R.id.profile_picture);
        }
    }

}
