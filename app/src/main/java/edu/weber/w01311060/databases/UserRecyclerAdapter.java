package edu.weber.w01311060.databases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.weber.w01311060.databases.models.User;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>
{
    private final List<User> values;

    public UserRecyclerAdapter(List<User> values)
    {
        this.values = values;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.user_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        User user = values.get(position);
        if(user != null)
        {
            holder.userItem = user;
            holder.txtFirst.setText(user.getFirstname());
            holder.txtLast.setText(user.getLastname());
            holder.txtEmail.setText(user.getEmail());
        }
    }

    @Override
    public int getItemCount()
    {
        return values.size();
    }

    public void addItems(List<User> users)
    {
        values.clear();
        values.addAll(users);

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public View view;
        public TextView txtFirst, txtLast, txtEmail;
        public User userItem;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            this.view = itemView;
            txtEmail = view.findViewById(R.id.txtEmail);
            txtLast = view.findViewById(R.id.txtLast);
            txtFirst = view.findViewById(R.id.txtFirst);
        }
    }
}
