package com.krcode.android.editor.vector2d;

import java.util.ArrayList;
import java.util.List;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.interfaces.ISceneController;
import min3d.objectPrimitives.Sphere;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends RendererActivity implements ISceneController {
	
	private List<Object3dContainer> objects;
	
	public MainActivity() {
		super();

		this.objects = new ArrayList<Object3dContainer>();
	}
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		EditorSurfaceView view = new EditorSurfaceView(this);
//		setContentView(view);
	}
	
	@Override
	public void initScene() {
		super.initScene();
		
		scene.camera().position.setAll(0,0,-10f);
		
		// noLights

		// objects
//		Object3dContainer sphere;
//		
//		sphere = new Sphere(3, 10, 10, true, true, true);
//		sphere.normalsEnabled(false);
//		scene.addChild(sphere);
	
		
	}
	
	@Override
	public void updateScene() {
		super.updateScene();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
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
		case R.id.quick_menu_append:
			Object3dContainer sphere;
			
			sphere = new Sphere(3, 10, 10, true, true, true);
			sphere.normalsEnabled(false);
			scene.addChild(sphere);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}