package com.krcode.android.editor.vector2d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EditorSurfaceView view = new EditorSurfaceView(this);
		setContentView(view);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
//		if (menu.size() >= 4) {
//			if (MainActivity.accountVO != null
//					&& MainActivity.accountVO.isAvalidable()) {
//				if (menu.getItem(3).getItemId() == R.id.quick_menu_loginout) {
//					menu.getItem(3).setTitle("로그아웃");
//				}
//			} else {
//				if (menu.getItem(3).getItemId() == R.id.quick_menu_loginout) {
//					menu.getItem(3).setTitle("로그인");
//				}
//			}
//		}
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.quick_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = null;
		switch (item.getItemId()) {
//		case R.id.quick_menu_goto:
//			intent = new Intent(MainActivity.this, GotoLocationActivity.class);
//
//			startActivityForResult(intent, MainActivity.GOTOLOCATIONACTIVITY);
//			return true;
//		case R.id.quick_menu_recommend:
//			if (MainActivity.accountVO != null
//					&& MainActivity.accountVO.isAvalidable() && mapView != null) {
//				intent = new Intent(MainActivity.this,
//						RecommendLocationActivity.class);
//
//				startActivityForResult(intent,
//						MainActivity.RECOMMENDLOCATIONACTIVITY);
//			} else {
//				Toast.makeText(getApplicationContext(), "로그인 후 사용하실 수 있습니다.",
//						Toast.LENGTH_SHORT).show();
//			}
//			return true;
//		case R.id.quick_menu_attention:
//			if (MainActivity.accountVO != null
//					&& MainActivity.accountVO.isAvalidable()) {
//				intent = new Intent(MainActivity.this,
//						AttentionListActivity.class);
//
//				GeoPoint point = mapView.getMapCenter();
//
//				intent.putExtra("LATITUDE",
//						String.valueOf(point.getLatitudeE6()));
//				intent.putExtra("LONGITUDE",
//						String.valueOf(point.getLongitudeE6()));
//
//				startActivityForResult(intent,
//						MainActivity.ATTENTIONLISTACTIVITY);
//			} else {
//				Toast.makeText(getApplicationContext(), "로그인 후 사용하실 수 있습니다.",
//						Toast.LENGTH_SHORT).show();
//			}
//			return true;
//		case R.id.quick_menu_loginout:
//			if (MainActivity.accountVO != null
//					&& MainActivity.accountVO.isAvalidable()) {
//				MainActivity.accountVO = null;
//			} else {
//				startActivity(new Intent(MainActivity.this, LoginActivity.class));
//			}
//			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}