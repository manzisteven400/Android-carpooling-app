package com.pt.taxi.adapters;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pt.taxi.R;
import com.pt.taxi.object.Comment;

public class TripApdater extends BaseAdapter {

	// public ArrayList<NewsObj> arrNews;
	private LayoutInflater mInflate;
	private ArrayList<Comment> arrViews;
	Activity mAct;

	// AQuery aq;

	public TripApdater(Activity activity) {
		// this.arrNews = listNews;
		this.mAct = activity;
		arrViews = new ArrayList<Comment>();
		this.mInflate = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	// public void setListNews(ArrayList<NewsObj> arrNews) {
	// this.arrNews = arrNews;
	// }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		// return arrNews.size();
		return 5;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, final ViewGroup parent) {
		// TODO Auto-generated method stub
		final HolderView holder;
		if (convertView == null) {
			holder = new HolderView();
			convertView = mInflate.inflate(R.layout.item_location, null);
			convertView.setTag(holder);
		} else {
			holder = (HolderView) convertView.getTag();
		}
		return convertView;
		// if (convertView == null) {
		// holder = new HolderView();
		// convertView = mInflate.inflate(R.layout.layout_item_new, null);
		// holder.imgNews = (ImageView) convertView.findViewById(R.id.imgNews);
		// holder.lblTitleNews = (TextView) convertView
		// .findViewById(R.id.lblTitleNew);
		// holder.lblDesc = (TextView) convertView
		// .findViewById(R.id.lblDescNews);
		// holder.lblDesc.setSelected(true);
		// holder.lblUrl = (TextView) convertView.findViewById(R.id.lblUrl);
		// holder.lblReadMore = (TextView) convertView
		// .findViewById(R.id.lblReadMore);
		//
		// convertView.setTag(holder);
		// } else {
		// holder = (HolderView) convertView.getTag();
		// }
		// final NewsObj item = arrNews.get(position);
		// if (item != null) {
		// aq = new AQuery(mAct);
		// boolean memCache = false;
		// boolean fileCache = true;
		// aq.id(holder.imgNews).image(item.getImage(), memCache, fileCache);
		// holder.lblTitleNews.setText(item.getTitle());
		// holder.lblDesc.setText(item.getDesc());
		// holder.lblUrl.setText(item.getUrl());
		// holder.lblReadMore.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View arg0) {
		// // TODO Auto-generated method stub
		// String url = holder.lblUrl.getText().toString();
		// String title = holder.lblTitleNews.getText().toString();
		// Intent i = new Intent(parent.getContext(),
		// ActivityBrowser.class);
		// i.putExtra("url", url);
		// i.putExtra("title", title);
		// parent.getContext().startActivity(i);
		// mAct.overridePendingTransition(R.anim.slide_in_left,
		// R.anim.slide_out_left);
		// }
		// });
		// }
		// return convertView;
	}

	public class HolderView {
		ImageView imgNews;
		TextView lblName, lblDate, lblStatus, lblContent;
	}
}
