package com.krcode.android.editor.vector2d;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL10;

import min3d.Shared;
import min3d.Utils;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.interfaces.ISceneController;
import min3d.objectPrimitives.Rectangle;
import min3d.objectPrimitives.Sphere;
import min3d.vos.Color4;
import min3d.vos.RenderType;
import min3d.vos.TexEnvxVo;
import min3d.vos.TextureVo;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.krcode.android.editor.vector2d.element.Polygon;

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
		// EditorSurfaceView view = new EditorSurfaceView(this);
		// setContentView(view);
	}

	@Override
	public void initScene() {
		super.initScene();

		scene.camera().position.setAll(0, 0, 10f);
		scene.camera().target.setAll(0.0f, 0.0f, 0.0f);
		scene.camera().upAxis.setAll(0.0f, 1.0f, 0.0f);
		scene.backgroundColor().setAll(new Color4(255, 255, 255, 255));

		// noLights

		// objects
		// Object3dContainer sphere;
		//
		// sphere = new Sphere(3, 10, 10, new Color4(0, 255, 0, 255));
		// sphere.normalsEnabled(false);
		// scene.addChild(sphere);

		Object3dContainer polygon;

		// polygon = new Polygon(4, 1, 1, false, false, true, new Color4(1.0f,
		// 0.0f, 0.0f, 1.0f));
		polygon = new Polygon(7, new Color4(255, 0, 0, 255));
		scene.addChild(polygon);

		// Object3dContainer rectangle;
		//
		// rectangle = new Rectangle(5, 5, 5, 5);
		// // rectangle.position().setAll(0.0f, 0.0f, 0.0f);
		// rectangle.normalsEnabled(false);
		// scene.addChild(rectangle);
		Object3dContainer sphere;
		TexEnvxVo alphaTextureEnv;

		sphere = new Sphere(0.8f, 15, 10);
		sphere.position().y = 2.0f;
		scene.addChildAt(sphere, 0);

		Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.jupiter);
		Shared.textureManager().addTextureId(b, "jupiter", false);
		b.recycle();

		TextureVo texture = sphere.textures().addById("jupiter");
		
		// We saved a reference to the sphere's "alpha" texture above so we can target 
		// its texture environment VO, which we will change around in the loop below.
		alphaTextureEnv = texture.textureEnvs.get(0);
		alphaTextureEnv.setAll(GL10.GL_TEXTURE_ENV_MODE, GL10.GL_REPLACE);
		
		

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
			TexEnvxVo alphaTextureEnv;

			sphere = new Sphere(0.8f, 15, 10);
			sphere.position().y = 2.0f;
			scene.addChildAt(sphere, 0);

			Bitmap b = Utils.makeBitmapFromResourceId(this, R.drawable.jupiter);
			Shared.textureManager().addTextureId(b, "jupiter", false);
			b.recycle();

			TextureVo texture = sphere.textures().addById("jupiter");
			
			// We saved a reference to the sphere's "alpha" texture above so we can target 
			// its texture environment VO, which we will change around in the loop below.
			alphaTextureEnv = texture.textureEnvs.get(0);
			alphaTextureEnv.setAll(GL10.GL_TEXTURE_ENV_MODE, GL10.GL_REPLACE);

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}