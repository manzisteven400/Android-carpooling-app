package com.pt.taxi.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;
import com.pt.taxi.adapters.CommentAdapter;

public class RateFragment extends BaseFragment implements OnClickListener {
	private Button btn_find;
	private LinearLayout layout_leave_rating;
	private TextView tv_name;
	private ListView lv_comment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rate, container, false);

		initUI(view);
		initControl();
		initMenuButton(view);

		return view;
	}

	public void initUI(View view) {
		btn_find = (Button) view.findViewById(R.id.btn_find);
		layout_leave_rating = (LinearLayout) view
				.findViewById(R.id.layout_leave_rating);
		layout_leave_rating.setVisibility(View.GONE);
		tv_name = (TextView) view.findViewById(R.id.tv_name);
		lv_comment = (ListView) view.findViewById(R.id.lv_comment);
		CommentAdapter adapter = new CommentAdapter(self);
		lv_comment.setAdapter(adapter);
	}

	public void initControl() {
		btn_find.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_find:
			final Dialog dialog = new Dialog(self);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.dialog_find_rate);
			WindowManager wm = (WindowManager) getActivity().getSystemService(
					Context.WINDOW_SERVICE); // for activity use context instead
												// of getActivity()
			Display display = wm.getDefaultDisplay(); // getting the screen size
														// of device
			Point size = new Point();
			display.getSize(size);
			int width = size.x - 100; // Set your heights
			int height = size.y - 400; // set your widths

			WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
			lp.copyFrom(dialog.getWindow().getAttributes());

			lp.width = width;
			lp.height = height;

			dialog.getWindow().setAttributes(lp);
			Button leave_rating = (Button) dialog
					.findViewById(R.id.btn_leave_rating);
			// if button is clicked, close the custom dialog
			leave_rating.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					layout_leave_rating.setVisibility(View.VISIBLE);
					tv_name.setText("Alex 1");
					dialog.dismiss();
				}
			});

			dialog.show();
			break;
		}

	}
}
