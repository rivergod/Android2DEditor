package com.krcode.android.editor.vector2d.element;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Polygon implements Figure {

	private int n;

	private ArrayList<FloatVertex> vertexList;

	public Polygon() {
		n = 7;
		vertexList = new ArrayList<FloatVertex>();

		FloatVertex org = new FloatVertex(0, 1, 0);

		vertexList.add(org);

		for (int i = 1; i < n; i++) {
			FloatVertex iVtx = FloatVertex.rotateZ(org, 360 / n * i);

			vertexList.add(iVtx);
		}
	}

	@Override
	public void draw(GL10 gl) {

		// Counter-clockwise winding.

		gl.glFrontFace(GL10.GL_CCW);

		// Enable face culling.

		gl.glEnable(GL10.GL_CULL_FACE);

		// What faces to remove with the face culling.

		gl.glCullFace(GL10.GL_BACK);

		// Enabled the vertices buffer for writing and to be used during

		// rendering.

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

		// Specifies the location and data format of an array of vertex

		// coordinates to use when rendering.

		gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f);

		gl.glVertexPointer(3, gl., stride, pointer)
		
		gl.glDrawArrays(mode, first, count)

		// Disable the vertices buffer.

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// Disable face culling.

		gl.glDisable(GL10.GL_CULL_FACE);

	}

}
