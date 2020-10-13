package com.uee.cdbinet.sidenav;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.uee.cdbinet.PaySaveBillsActivity;
import com.uee.cdbinet.PaySaveBillsReviewActivity;
import com.uee.cdbinet.R;
import com.uee.cdbinet.util.Config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountStatementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountStatementFragment extends Fragment {

    public TextView fromDate, toDate;
    public ImageView btnFromDate , btnToDate;
    public Button btnShow;
    final Calendar myCalendar = Calendar.getInstance();


    View accInflater;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountStatementFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountStatementFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountStatementFragment newInstance(String param1, String param2) {
        AccountStatementFragment fragment = new AccountStatementFragment();
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
        accInflater = inflater.inflate(R.layout.fragment_account_statement, container, false);

        Config.setHeader("Account Statement");

        initialize();
        eventHandler();

        return accInflater;
    }

    public void initialize(){

        fromDate = (TextView) accInflater.findViewById(R.id.from_date);
        toDate = (TextView) accInflater.findViewById(R.id.to_date);
        btnFromDate = (ImageView) accInflater.findViewById(R.id.btn_fromDate);
        btnToDate = (ImageView) accInflater.findViewById(R.id.btn_toDate);
        btnShow = (Button) accInflater.findViewById(R.id.btn_accShow);
    }

    public void eventHandler(){


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel();
            }

        };

        btnFromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), R.style.DialogTheme, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

        btnToDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), R.style.DialogTheme, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        fromDate.setText(sdf.format(myCalendar.getTime()));
        toDate.setText(sdf.format(myCalendar.getTime()));
    }

}
