package com.uee.cdbinet.sidenav;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.uee.cdbinet.R;
import com.uee.cdbinet.util.Config;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DepositsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DepositsFragment extends Fragment {

    View depositeInflater;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DepositsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DepositsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DepositsFragment newInstance(String param1, String param2) {
        DepositsFragment fragment = new DepositsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        depositeInflater = inflater.inflate(R.layout.fragment_deposits, container, false);

        Config.setHeader("Deposits");







        return depositeInflater;
    }
}