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
import com.uee.cdbinet.util.Config;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MailBoxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MailBoxFragment extends Fragment {

    View mailBoxInflater;
    TextView inboxTab, sentTab, draftTab, archiveTab;
    LinearLayout inboxListView, sentListView, draftListView, archiveListView;
    ImageView btnStop;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MailBoxFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MailBoxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MailBoxFragment newInstance(String param1, String param2) {
        MailBoxFragment fragment = new MailBoxFragment();
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
        mailBoxInflater = inflater.inflate(R.layout.fragment_mail_box, container, false);

        Config.setHeader("Mail Box");

        btnStop =  mailBoxInflater.findViewById(R.id.btn_comment);

        inboxListView = mailBoxInflater.findViewById(R.id.lo_listViewInbox);
        sentListView = mailBoxInflater.findViewById(R.id.lo_listViewSent);
        draftListView = mailBoxInflater.findViewById(R.id.lo_listViewDraft);
        archiveListView = mailBoxInflater.findViewById(R.id.lo_listViewArchive);

        inboxTab = mailBoxInflater.findViewById(R.id.inbox_tab);
        sentTab = mailBoxInflater.findViewById(R.id.sent_tab);
        draftTab = mailBoxInflater.findViewById(R.id.draft_tab);
        archiveTab = mailBoxInflater.findViewById(R.id.archive_tab);

        inboxTab.setOnClickListener(new MoveTab());
        sentTab.setOnClickListener(new MoveTab());
        draftTab.setOnClickListener(new MoveTab());
        archiveTab.setOnClickListener(new MoveTab());

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MailComposeActivity.class);
                startActivity(intent);
            }
        });

        return mailBoxInflater;
    }


    public class MoveTab implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String btn = ((TextView) v).getText() + "";


            if (btn.contains("Inbox")) {

                sentListView.setVisibility(View.GONE);
                inboxListView.setVisibility(View.VISIBLE);
                draftListView.setVisibility(View.GONE);
                archiveListView.setVisibility(View.GONE);

                inboxTab.setBackgroundResource(R.drawable.bottom_line_rounded);
                sentTab.setBackgroundResource(R.color.colorWhite);
                draftTab.setBackgroundResource(R.color.colorWhite);
                archiveTab.setBackgroundResource(R.color.colorWhite);

            } else if (btn.contains("Sent")) {
                sentListView.setVisibility(View.VISIBLE);
                inboxListView.setVisibility(View.GONE);
                draftListView.setVisibility(View.GONE);
                archiveListView.setVisibility(View.GONE);

                inboxTab.setBackgroundResource(R.color.colorWhite);
                sentTab.setBackgroundResource(R.drawable.bottom_line_rounded);
                draftTab.setBackgroundResource(R.color.colorWhite);
                archiveTab.setBackgroundResource(R.color.colorWhite);

            } else if (btn.contains("Draft")) {
                sentListView.setVisibility(View.GONE);
                inboxListView.setVisibility(View.GONE);
                draftListView.setVisibility(View.VISIBLE);
                archiveListView.setVisibility(View.GONE);

                inboxTab.setBackgroundResource(R.color.colorWhite);
                sentTab.setBackgroundResource(R.color.colorWhite);
                draftTab.setBackgroundResource(R.drawable.bottom_line_rounded);
                archiveTab.setBackgroundResource(R.color.colorWhite);

            } else if (btn.contains("Archive")) {
                sentListView.setVisibility(View.GONE);
                inboxListView.setVisibility(View.GONE);
                draftListView.setVisibility(View.GONE);
                archiveListView.setVisibility(View.VISIBLE);

                inboxTab.setBackgroundResource(R.color.colorWhite);
                sentTab.setBackgroundResource(R.color.colorWhite);
                draftTab.setBackgroundResource(R.color.colorWhite);
                archiveTab.setBackgroundResource(R.drawable.bottom_line_rounded);

            }

        }
    }
}