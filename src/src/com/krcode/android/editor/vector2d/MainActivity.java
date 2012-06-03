package com.krcode.android.editor.vector2d;

import javax.microedition.khronos.opengles.GL10;

import min3d.Shared;
import min3d.Utils;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.interfaces.ISceneController;
import min3d.objectPrimitives.Sphere;
import min3d.vos.Color4;
import min3d.vos.TexEnvxVo;
import min3d.vos.TextureVo;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.krcode.android.editor.vector2d.element.Polygon;

/**
 * @author rivergod
 *
 */
public class MainActivity extends RendererActivity implements ISceneController {
	private GestureDetector gestureDetector;
	
	public MainActivity() {
		super();
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.gestureDetector = new GestureDetector(getApplicationContext(), new EditorOnGestureListener());
	}

	/* (non-Javadoc)
	 * @see min3d.core.RendererActivity#initScene()
	 */
	@Override
	public void initScene() {
		super.initScene();

		// 카메라 설정		
		scene.camera().position.setAll(0, 0, 10f);
		scene.camera().target.setAll(0.0f, 0.0f, 0.0f);
		scene.camera().upAxis.setAll(0.0f, 1.0f, 0.0f);
		
		// 배경색 지정
		scene.backgroundColor().setAll(new Color4(255, 255, 255, 255));

		// noLights
		Object3dContainer polygon;

		// 중앙에 빨간색의 7각형 추가
		polygon = new Polygon(7, new Color4(255, 0, 0, 255));
		scene.addChild(polygon);

		// 상단에 구를 추가하고
		Object3dContainer sphere;
		TexEnvxVo alphaTextureEnv;

		sphere = new Sphere(0.8f, 15, 10);
		sphere.position().y = 2.0f;
		scene.addChildAt(sphere, 0);

		// 상단에 추가된 구에 목성 모양의 텍스쳐를 입힘
		Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.jupiter);
		Shared.textureManager().addTextureId(b, "jupiter", false);
		b.recycle();

		TextureVo texture = sphere.textures().addById("jupiter");
		
		alphaTextureEnv = texture.textureEnvs.get(0);
		alphaTextureEnv.setAll(GL10.GL_TEXTURE_ENV_MODE, GL10.GL_REPLACE);
		
		

	}

	/* (non-Javadoc)
	 * @see min3d.core.RendererActivity#updateScene()
	 */
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
			Object3dContainer polygon;

			// 하단에 녹색의 삼각형을 추가
			polygon = new Polygon(3, new Color4(0, 255, 0, 255));
			polygon.position().y = -2.0f;
			scene.addChildAt(polygon, 0);

			// 우측에 파란의 삼각형을 추가
			polygon = new Polygon(4, 0.5f, new Color4(0, 0, 255, 255));
			polygon.position().x = 2.0f;
			scene.addChildAt(polygon, 0);


			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}
	
	private class EditorOnGestureListener extends GestureDetector.SimpleOnGestureListener {
		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return super.onDown(e);
		}
		
		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			return super.onDoubleTap(e);
		}
		
		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			// TODO Auto-generated method stub
			return super.onSingleTapConfirmed(e);
		}
	}
}