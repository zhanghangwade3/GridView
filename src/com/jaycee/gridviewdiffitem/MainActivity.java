package com.jaycee.gridviewdiffitem;

import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private GridView mGridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		mGridView = (GridView) findViewById(R.id.gridView);
		mGridView.setAdapter(new GridViewAdapter(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class GridViewAdapter extends BaseAdapter {

		private LayoutInflater mInflater;
		private ViewHolder mViewHolder;
		private Activity mActivity;

		public GridViewAdapter(Activity activity) {
			mActivity = activity;
			mInflater = LayoutInflater.from(mActivity);
		}

		@Override
		public int getCount() {
			return 6;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.gridview_item, null);
				mViewHolder = new ViewHolder();
				mViewHolder.addPicture = (LinearLayout) convertView
						.findViewById(R.id.layout_add_picture);
				mViewHolder.picture = (ImageView) convertView
						.findViewById(R.id.picture);

				convertView.setTag(mViewHolder);
			} else {
				mViewHolder = (ViewHolder) convertView.getTag();
			}

			if (position == 0) {
				mViewHolder.addPicture.setVisibility(View.VISIBLE);
				mViewHolder.picture.setVisibility(View.INVISIBLE);

				mViewHolder.addPicture.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								Toast.makeText(mActivity, "添加图片",
										Toast.LENGTH_SHORT).show();
							}
						});
			} else {
				mViewHolder.addPicture.setVisibility(View.INVISIBLE);
				mViewHolder.picture.setVisibility(View.VISIBLE);
				
				mViewHolder.picture.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(mActivity, "图片",
								Toast.LENGTH_SHORT).show();
					}
				});
			}

			return convertView;
		}

		private class ViewHolder {
			LinearLayout addPicture;
			ImageView picture;
		}
	}
}
