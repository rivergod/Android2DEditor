package com.krcode.android.editor.vector2d;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import com.krcode.android.editor.vector2d.element.Figure;
import com.krcode.android.editor.vector2d.element.Polygon;
import com.krcode.android.editor.vector2d.element.Quadrangle;
import com.krcode.android.editor.vector2d.element.Triangle;

public class EditorRender implements Renderer {

	private Figure figure;
	private Figure figure2;
	private float angle = 0;

	public EditorRender() {
		// TODO Auto-generated constructor stub
//		figure = new Polygon();
		figure2 = new Triangle();
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub

		// Clears the screen and depth buffer.

		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		// Replace the current matrix with the identity matrix

		gl.glLoadIdentity();

		// Translates 10 units into the screen.

		gl.glTranslatef(0, 0, -10); // 앞으로(z축)10만큼 이동변환

		// SQUARE A

		// Save the current matrix.

		gl.glPushMatrix(); // 앞으로(z축)10만큼 이동변환된 행렬을 스택에 저장

		// Rotate square A counter-clockwise.

		gl.glRotatef(angle, 0, 0, 1); // 이동(z축 -10), z축회전

		// Draw square A.

//		figure.draw(gl); // 이동(z축 -10), z축 회전변환된 큰 사각형
		figure2.draw(gl);

		// Restore the last matrix.

		gl.glPopMatrix(); // 이동(z축 -10)변환된 행렬 사용

//		// SQUARE B
//
//		// Save the current matrix
//
//		gl.glPushMatrix(); // 이동(z축 -10)변환된 행렬 저장
//
//		// Rotate square B before moving it, making it rotate around A.
//
//		gl.glRotatef(-angle, 0, 0, 1); // 이동(z축 -10), z축 CW회전
//
//		// Move square B.
//
//		gl.glTranslatef(2, 0, 0); // 이동(z축 -10), z축 CW회전, 이동(x축 2)
//
//		// Scale it to 50% of square A
//
//		gl.glScalef(.5f, .5f, .5f); // 이동(z축 -10), z축 CW회전, 이동(x축 2), 크기(.5)
//
//		// Draw square B.
//
//		figure.draw(gl); // 이동(z축 -10), z축 CW회전, 이동(x축 2), 크기(.5) 적용된 중간 사각형
//
//		// SQUARE C
//
//		// Save the current matrix
//
//		gl.glPushMatrix(); // 이동(z축 -10), z축 CW회전, 이동(x축 2), 크기(.5)변환적용된 행렬 저장
//
//		// Make the rotation around B
//
//		gl.glRotatef(-angle, 0, 0, 1); // B사각형을 중심으로 공전
//
//		gl.glTranslatef(2, 0, 0);
//
//		// Scale it to 50% of square B
//
//		gl.glScalef(.5f, .5f, .5f);
//
//		// Rotate around it's own center.
//
//		gl.glRotatef(angle * 10, 0, 0, 1); // 빠르게 자전
//
//		// Draw square C.
//
//		figure.draw(gl);
//
//		// Restore to the matrix as it was before C.
//
//		gl.glPopMatrix();
//
//		// Restore to the matrix as it was before B.
//
//		gl.glPopMatrix();
//
//		// Increse the angle.
//
//		angle++;
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub

		// Sets the current view port to the new size.

		gl.glViewport(0, 0, width, height);

		// Select the projection matrix

		gl.glMatrixMode(GL10.GL_PROJECTION);

		// Reset the projection matrix

		gl.glLoadIdentity();

		// Calculate the aspect ratio of the window

		GLU.gluPerspective(gl, 45.0f, (float) width / (float) height, 0.1f,
				100.0f);

		// Select the modelview matrix

		gl.glMatrixMode(GL10.GL_MODELVIEW);

		// Reset the modelview matrix

		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub

		// Set the background color to black ( rgba ).

		gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

		// Enable Smooth Shading, default not really needed.

		gl.glShadeModel(GL10.GL_SMOOTH);

		// Depth buffer setup.

		gl.glClearDepthf(1.0f);

		// Enables depth testing.

		gl.glEnable(GL10.GL_DEPTH_TEST);

		// The type of depth testing to do.

		gl.glDepthFunc(GL10.GL_LEQUAL);

		// Really nice perspective calculations.

		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
	}

}
