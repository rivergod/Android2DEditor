package com.krcode.android.editor.vector2d.element;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Polygon implements Figure {

	private int n;

	private ArrayList<FloatVertex> vertexList;

	public Polygon() {
		n = 5;
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
		
		float a[] = new float[n*3];
		
		for(int i=0; i < n; i++) {
			FloatVertex fv = vertexList.get(i);
			
			a[(3*i)] = fv.getX();
			a[(3*i)+1] = fv.getY();
			a[(3*i)+2] = fv.getZ();
		}
		
		ByteBuffer vbb = ByteBuffer.allocateDirect( a.length * 4);

		vbb.order(ByteOrder.nativeOrder());
		
		FloatBuffer vertexBuffer = vbb.asFloatBuffer();

		vertexBuffer.put(a);

		vertexBuffer.position(0);
		
		short[] indices = { 0, 1, 2, 3, 4, 5, 6 };
		
		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);

		ibb.order(ByteOrder.nativeOrder());

		ShortBuffer indexBuffer = ibb.asShortBuffer();

		indexBuffer.put(indices);

		indexBuffer.position(0);
		

		gl.glLineWidth(2.0f);
		
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		
//		gl.glDrawArrays(GL10.GL_LINES, 0, n);
//		gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, n);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, n);
//		gl.glDrawElements(GL10.GL_TRIANGLE_STRIP, 7,
//				GL10.GL_UNSIGNED_SHORT, indexBuffer);

		// Disable the vertices buffer.

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// Disable face culling.

		gl.glDisable(GL10.GL_CULL_FACE);

	}

}
