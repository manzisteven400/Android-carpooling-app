package com.pt.taxi.fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.w3c.dom.Document;
import org.w3c.dom.Text;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.pt.taxi.BaseFragment;
import com.pt.taxi.R;
import com.pt.taxi.activities.FindARideActivity;
import com.pt.taxi.activities.PassengerPage2Activity;
import com.pt.taxi.activities.RoundTripActivity;
import com.pt.taxi.activities.WaitDriverConfirmActivity;
import com.pt.taxi.googledirections.GMapV2Direction;
import com.pt.taxi.googledirections.Route;
import com.pt.taxi.googledirections.Routing;
import com.pt.taxi.googledirections.RoutingListener;
import com.pt.taxi.utility.GPSTracker;
import com.pt.taxi.widget.TextViewPixeden;

public class OnlineFragment extends BaseFragment implements
		OnMyLocationChangeListener, RoutingListener {

	private GoogleMap mMap;
	private GPSTracker gps;
	Handler handler;
	Button btnBook, btnBack;
	EditText txtFrom;
	EditText txtTo;
	RelativeLayout btnLink1, btnLink2, btnLink3;
	protected Double lat_start, lat_end, lng_start, lng_end;
	LatLng start, end;
	TextViewPixeden start_map, end_map;

	boolean processClick = true;
	Bitmap iconStart;
	ArrayList<LatLng> markerPoints;
	GMapV2Direction md;
	Routing routing;

	private Marker mUniqueMarker_start, mUniMarker_end;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_passenger_page1,
				container, false);
		initUI(view);
		initMenuButton(view);
		handler = new Handler();

		start_map = (TextViewPixeden) view.findViewById(R.id.btn_start);
		txtFrom = (EditText) view.findViewById(R.id.txtFrom);
		end_map = (TextViewPixeden) view.findViewById(R.id.btn_end);
		txtTo = (EditText) view.findViewById(R.id.txtTo);

		// if(txtFrom.getText().length() == 0){
		// try {
		// Geocoder geoCoder = new Geocoder(getActivity(),
		// Locale.getDefault());
		//
		// List<Address> address = geoCoder
		// .getFromLocation(, 1);
		//
		// txtFrom.setText(address.get(0)
		// .getAddressLine(0)
		// + "\t"
		// + address.get(0).getAdminArea()
		// + "\t"
		// + address.get(0).getCountryName());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }

		btnLink1 = (RelativeLayout) view.findViewById(R.id.btnlink1);
		btnLink2 = (RelativeLayout) view.findViewById(R.id.btnlink2);
		btnLink3 = (RelativeLayout) view.findViewById(R.id.btnlink3);
		btnBook = (Button) view.findViewById(R.id.btnBook);
		btnBack = (Button) view.findViewById(R.id.btnBack);

		btnBook.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

//				btnBook.setVisibility(v.GONE);
//				btnBack.setVisibility(v.VISIBLE);
				// btnLink1.setVisibility(v.VISIBLE);
				// btnLink2.setVisibility(v.VISIBLE);
				// btnLink3.setVisibility(v.VISIBLE);
				mainActivity.gotoActivity(RoundTripActivity.class);
			}
		});
		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btnBook.setVisibility(v.VISIBLE);
				btnBack.setVisibility(v.GONE);
				btnLink1.setVisibility(v.GONE);
				btnLink2.setVisibility(v.GONE);
				btnLink3.setVisibility(v.GONE);
			}
		});

		btnLink1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mainActivity.gotoActivity(WaitDriverConfirmActivity.class);
			}
		});
		btnLink2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mainActivity.gotoActivity(WaitDriverConfirmActivity.class);
			}
		});
		btnLink3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mainActivity.gotoActivity(WaitDriverConfirmActivity.class);
			}
		});

		((TextView) view.findViewById(R.id.btnIcGPS))
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						name();
					}
				});

		if (mMap == null) {
			// Try to obtain the map from the SupportMapFragment.

			mMap = ((MapFragment) mainActivity.getFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			mMap.getUiSettings().setMyLocationButtonEnabled(false);

			// Check if we were successful in obtaining the map.

			if (mMap != null) {
				setUpMap();
				name();

			}
		}

		return view;
	}

	public void name() {

		final GPSTracker tracker = new GPSTracker(mainActivity);
		if (tracker.canGetLocation() == false) {
			tracker.showSettingsAlert();
			showToast("Wait for location service");

		} else {
			mMap.clear();
			CameraUpdate myLoc = CameraUpdateFactory
					.newCameraPosition(new CameraPosition.Builder()
							.target(new LatLng(tracker.getLatitude(), tracker
									.getLongitude())).zoom(14).build());
			mMap.moveCamera(myLoc);

			clickPointStart();
			clickPointEnd();

			txtFrom.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					txtFrom.selectAll();
					txtFrom.clearFocus();
				}
			});

		}
	}

	public void clickPointStart() {

		start_map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				txtFrom.setText("Please to click map");

				if (mUniqueMarker_start != null) {
					// mUniqueMarker_start.remove();
					showToast("1");

					mMap.setOnMapClickListener(new OnMapClickListener() {
						@Override
						public void onMapClick(LatLng arg0) {

							iconStart = BitmapFactory.decodeResource(
									mainActivity.getResources(),
									R.drawable.ic_start);
							iconStart = Bitmap.createScaledBitmap(iconStart,
									iconStart.getWidth() / 5,
									iconStart.getHeight() / 5, false);

							mUniqueMarker_start.remove();

							showToast("2");

							mUniqueMarker_start = mMap
									.addMarker(new MarkerOptions()
											.position(arg0)
											.title("Start location")
											.icon(BitmapDescriptorFactory
													.fromBitmap(iconStart)));

							try {
								Geocoder geoCoder = new Geocoder(getActivity(),
										Locale.getDefault());
								lat_start = arg0.latitude;
								lng_start = arg0.longitude;

								List<Address> addresses = geoCoder
										.getFromLocation(lat_start, lng_start,
												1);

								txtFrom.setText(addresses.get(0)
										.getAddressLine(0)
										+ "\t"
										+ addresses.get(0).getAdminArea()
										+ "\t"
										+ addresses.get(0).getCountryName());
							} catch (IOException e) {
								e.printStackTrace();
							}
							if (mUniqueMarker_start != null) {
								processClick = false;
							}
							start = new LatLng(lat_start, lng_start);
							// showDirection();
						}
					});
				} else {
					mMap.setOnMapClickListener(new OnMapClickListener() {
						@Override
						public void onMapClick(LatLng arg0) {

							iconStart = BitmapFactory.decodeResource(
									mainActivity.getResources(),
									R.drawable.ic_start);
							iconStart = Bitmap.createScaledBitmap(iconStart,
									iconStart.getWidth() / 5,
									iconStart.getHeight() / 5, false);

							if (mUniqueMarker_start != null) {
								// mUniqueMarker_start.remove();
								processClick = true;
								showToast("4");
							}

							else {
								showToast("5");
								processClick = false;
								mMap.setMyLocationEnabled(true);
								mUniqueMarker_start = mMap.addMarker(new MarkerOptions()
										.position(arg0)
										.title("Start location")
										.icon(BitmapDescriptorFactory
												.fromBitmap(iconStart)));

								try {
									Geocoder geoCoder = new Geocoder(
											getActivity(), Locale.getDefault());
									lat_start = arg0.latitude;
									lng_start = arg0.longitude;

									List<Address> addresses = geoCoder
											.getFromLocation(lat_start,
													lng_start, 1);

									txtFrom.setText(addresses.get(0)
											.getAddressLine(0)
											+ "\t"
											+ addresses.get(0).getAdminArea()
											+ "\t"
											+ addresses.get(0).getCountryName());
								} catch (IOException e) {
									e.printStackTrace();
								}
								start = new LatLng(lat_start, lng_start);
							}
							// showDirection();
						}
					});
				}
			}
		});
	}

	public void clickPointEnd() {
		end_map.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				txtTo.setText("Please to click map");

				mMap.setOnMapClickListener(new OnMapClickListener() {

					@Override
					public void onMapClick(LatLng arg0) {
						Bitmap iconEnd = BitmapFactory.decodeResource(
								mainActivity.getResources(), R.drawable.ic_end);
						iconEnd = Bitmap.createScaledBitmap(iconEnd,
								iconEnd.getWidth() / 5,
								iconEnd.getHeight() / 5, false);

						if (mUniMarker_end != null) {
							mUniMarker_end.remove();
							// routing.remote(this);

						}
						mUniMarker_end = mMap.addMarker(new MarkerOptions()
								.position(arg0)
								.title("End location")
								.icon(BitmapDescriptorFactory
										.fromBitmap(iconEnd)));

						try {
							Geocoder geoCoder = new Geocoder(getActivity(),
									Locale.getDefault());
							lat_end = arg0.latitude;
							lng_end = arg0.longitude;

							List<Address> addresses = geoCoder.getFromLocation(
									lat_end, lng_end, 1);

							txtTo.setText(addresses.get(0).getAddressLine(0)
									+ "\t" + addresses.get(0).getAdminArea()
									+ "\t" + addresses.get(0).getCountryName());
						} catch (IOException e) {
							e.printStackTrace();
						}

						end = new LatLng(lat_end, lng_end);

						showDirection();

					}
				});

			}
		});

	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		if (hidden) {
			// do when hidden
		} else {
			// do when show
			// setUpMap();
		}
	}

	private void setUpMap() {
		mMap.setMyLocationEnabled(true);
		mMap.setOnMyLocationChangeListener(this);
		mMap.getUiSettings().setMyLocationButtonEnabled(false);

	}

	@Override
	public void onMyLocationChange(Location lastKnownLocation) {
		mMap.clear();
		CameraUpdate myLoc = CameraUpdateFactory
				.newCameraPosition(new CameraPosition.Builder()
						.target(new LatLng(lastKnownLocation.getLatitude(),
								lastKnownLocation.getLongitude())).zoom(12)
						.build());
		mMap.moveCamera(myLoc);
		mMap.setOnMyLocationChangeListener(null);

	}

	protected void showDirection() {
		mMap.clear();
		routing = new Routing(Routing.TravelMode.WALKING);

		routing.registerListener(this);
		routing.execute(start, end);
	}

	@Override
	public void onRoutingFailure() {

	}

	@Override
	public void onRoutingStart() {

	}

	// Draw google directions
	@Override
	public void onRoutingSuccess(PolylineOptions mPolyOptions, Route route) {

		PolylineOptions polyOptions = new PolylineOptions();
		polyOptions.color(Color.RED);
		polyOptions.width(6);
		polyOptions.addAll(mPolyOptions.getPoints());
		mMap.addPolyline(polyOptions);

	}

}

