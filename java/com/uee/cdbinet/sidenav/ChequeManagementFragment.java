package com.uee.cdbinet.sidenav;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uee.cdbinet.MailComposeActivity;
import com.uee.cdbinet.R;
import com.uee.cdbinet.StopChequeActivity;
import com.uee.cdbinet.util.Config;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChequeManagementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChequeManagementFragment extends Fragment {

    View chequeInflater;
    TextView requestsTab, acceptsTab, rejectsTab;
    LinearLayout requestsListView, acceptsListView, rejectsListView;

    ImageView btnStopCheque;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChequeManagementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChequeManagementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChequeManagementFragment newInstance(String param1, String param2) {
        ChequeManagementFragment fragment = new ChequeManagementFragment();
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
        chequeInflater =  inflater.inflate(R.layout.fragment_cheque_management, container, false);

        Config.setHeader("My Cheques");

        btnStopCheque = chequeInflater.findViewById(R.id.btn_stop_cheque);

        requestsListView = chequeInflater.findViewById(R.id.lo_listViewRequests);
        acceptsListView = chequeInflater.findViewById(R.id.lo_listViewAccepts);
        rejectsListView = chequeInflater.findViewById(R.id.lo_listViewRejects);

        requestsTab = chequeInflater.findViewById(R.id.requests_tab);
        acceptsTab = chequeInflater.findViewById(R.id.accepts_tab);
        rejectsTab = chequeInflater.findViewById(R.id.rejects_tab);

        btnStopCheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), StopChequeActivity.class);
                startActivity(intent);

            }
        });

        requestsTab.setOnClickListener(new MoveTab());
        acceptsTab.setOnClickListener(new MoveTab());
        rejectsTab.setOnClickListener(new MoveTab());

        return chequeInflater;
    }

    public class MoveTab implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String btn = ((TextView) v).getText() + "";


            if (btn.contains("Requests")) {

                requestsListView.setVisibility(View.VISIBLE);
                acceptsListView.setVisibility(View.GONE);
                rejectsListView.setVisibility(View.GONE);

                requestsTab.setBackgroundResource(R.drawable.bottom_line_rounded);
                acceptsTab.setBackgroundResource(R.color.colorWhite);
                rejectsTab.setBackgroundResource(R.color.colorWhite);

            } else if (btn.contains("Accepts")) {

                acceptsListView.setVisibility(View.VISIBLE);
                requestsListView.setVisibility(View.GONE);
                rejectsListView.setVisibility(View.GONE);

                requestsTab.setBackgroundResource(R.color.colorWhite);
                acceptsTab.setBackgroundResource(R.drawable.bottom_line_rounded);
                rejectsTab.setBackgroundResource(R.color.colorWhite);

            } else if (btn.contains("Rejects")) {
                requestsListView.setVisibility(View.GONE);
                acceptsListView.setVisibility(View.GONE);
                rejectsListView.setVisibility(View.VISIBLE);

                requestsTab.setBackgroundResource(R.color.colorWhite);
                acceptsTab.setBackgroundResource(R.color.colorWhite);
                rejectsTab.setBackgroundResource(R.drawable.bottom_line_rounded);

            }

        }
    }

}