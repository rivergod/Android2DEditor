package com.krcode.android.editor.vector2d.element;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * @author rivergod
 * @deprecated
 */
public class Triangle implements Figure {
	private float vertices[] = { 0.0f, 1.0f, 0.0f, // 0, Top Left
			-0.8660f, -0.5f, 0.0f, // 1, Bottom Left
			0.8660f, -0.5f, 0.0f, // 2, Bottom Right
	};

	// The order we like to connect them.

	private short[] indices = { 0, 1, 2 };

	// Our vertex buffer.

	private FloatBuffer vertexBuffer;

	// Our index buffer.

	private ShortBuffer indexBuffer;

	public Triangle() {
		// a float is 4 bytes, therefore we multiply the number if

		// vertices with 4.

		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);

		vbb.order(ByteOrder.nativeOrder());

		vertexBuffer = vbb.asFloatBuffer();

		vertexBuffer.put(vertices);

		vertexBuffer.position(0);

		// short is 2 bytes, therefore we multiply the number if

		// vertices with 2.

		ByteBuffer ibb = ByteBuffer.allocateDirect(indices.length * 2);

		ibb.order(ByteOrder.nativeOrder());

		indexBuffer = ibb.asShortBuffer();

		indexBuffer.put(indices);

		indexBuffer.position(0);
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

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length,
				GL10.GL_UNSIGNED_SHORT, indexBuffer);

		// Disable the vertices buffer.

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// Disable face culling.

		gl.glDisable(GL10.GL_CULL_FACE);
	}

}
