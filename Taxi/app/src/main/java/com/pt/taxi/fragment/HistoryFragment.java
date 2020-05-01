package com.pt.taxi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;
import com.pt.taxi.activities.DetailTripHistoryActivity;
import com.pt.taxi.activities.RoundTripActivity;
import com.pt.taxi.activities.TripHistoryActivity;
import com.pt.taxi.adapters.HistoryAdapter;

public class HistoryFragment extends BaseFragment {

	ListView lsvHistory;
	HistoryAdapter historyAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_list_history, container,
				false);
		initUI(view);
		initUIInThis(view);
		initMenuButton(view);
		setHeaderTitle(R.string.lbl_trip_history);
		return view;
	}

	public void initUIInThis(View view) {
		lsvHistory = (ListView) view.findViewById(R.id.lsvHistory);
		historyAdapter = new HistoryAdapter(mainActivity);
		lsvHistory.setAdapter(historyAdapter);
		
		lsvHistory.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				startActivity(new Intent(getActivity(),DetailTripHistoryActivity.class));
			}
			
		});
	}

}
