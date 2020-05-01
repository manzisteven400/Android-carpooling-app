package com.pt.taxi.adapters;

import java.util.ArrayList;

import com.pt.taxi.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RequestPassengerAdapter  extends BaseAdapter{
	private Context context;
	private ArrayList<String> array;
	private LayoutInflater inflater;
	public RequestPassengerAdapter(Context context, ArrayList<String> array){
		this.context=context;
		this.array=array;
		inflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return array.size();
	}

	@Override
	public Object getItem(int position) {
		return array.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.custom_request_passenger, parent,false);
			holder = new ViewHolder();
			holder.lblrequestlink=(TextView) convertView.findViewById(R.id.lblRequestLink);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
			String requestlink=array.get(position);
			holder.lblrequestlink.setText(requestlink);
		}
		return convertView;
	}
	class ViewHolder {
		TextView lblrequestlink;
	}

}
