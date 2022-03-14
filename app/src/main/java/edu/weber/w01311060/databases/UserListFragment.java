package edu.weber.w01311060.databases;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.weber.w01311060.databases.models.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserListFragment extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View root;

    public UserListFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserListFragment newInstance(String param1, String param2)
    {
        UserListFragment fragment = new UserListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater)
    {
        inflater.inflate(R.menu.createuser, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.load:
                loadCourse();
                return true;
        }
        return false;
    }

    private void loadCourse()
    {
        GetCoursesTask task = new GetCoursesTask();
        task.execute("param", "param");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        RecyclerView rv = root.findViewById(R.id.recycler);

        if(rv instanceof RecyclerView)

        {
            UserRecyclerAdapter adapter = new UserRecyclerAdapter(new ArrayList<User>());

            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            rv.setAdapter(adapter);
            rv.setHasFixedSize(false);
        }
    }
}