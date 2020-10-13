package com.uee.cdbinet.sidenav;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uee.cdbinet.R;
import com.uee.cdbinet.util.Config;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoanLeaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoanLeaseFragment extends Fragment {

    View loanLeaseInflater;
    TextView loanTab, leaseTab;
    LinearLayout loanListView, leaseListView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public LoanLeaseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoanLeaseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoanLeaseFragment newInstance(String param1, String param2) {
        LoanLeaseFragment fragment = new LoanLeaseFragment();
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
        loanLeaseInflater = inflater.inflate(R.layout.fragment_loan_lease, container, false);

        Config.setHeader("Loan & Lease Summary");

        loanListView = loanLeaseInflater.findViewById(R.id.lo_listViewLoan);
        leaseListView = loanLeaseInflater.findViewById(R.id.lo_listViewLease);

        loanTab = loanLeaseInflater.findViewById(R.id.lo_loan_layout);
        leaseTab = loanLeaseInflater.findViewById(R.id.lo_lease_layout);

        loanTab.setOnClickListener(new MoveTab());
        leaseTab.setOnClickListener(new MoveTab());



        return loanLeaseInflater;
    }


    public class MoveTab implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            String btn = ((TextView) v).getText() + "";


            if(btn.contains("Loan"))
            {

                leaseListView.setVisibility(View.GONE);
                loanListView.setVisibility(View.VISIBLE);

                loanTab.setBackgroundResource(R.drawable.bottom_line_rounded);
                leaseTab.setBackgroundResource(R.color.colorWhite);



            }
            else if(btn.contains("Lease"))
            {
                leaseListView.setVisibility(View.VISIBLE);
                loanListView.setVisibility(View.GONE);

                leaseTab.setBackgroundResource(R.drawable.bottom_line_rounded);
                loanTab.setBackgroundResource(R.color.colorWhite);


            }

        }
    }

}