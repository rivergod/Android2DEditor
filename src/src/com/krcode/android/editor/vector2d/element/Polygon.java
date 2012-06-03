package com.krcode.android.editor.vector2d.element;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

import min3d.Utils;
import min3d.core.Object3dContainer;
import min3d.vos.Color4;
import min3d.vos.RenderType;

public class Polygon extends Object3dContainer {

	private int edges;
	private float defaultSize;
	private int cols;
	private int rows;

	private ArrayList<FloatVertex> vertexList;

//	public Polygon(int $edges, int $columns, int $rows, Boolean $useUvs,
//			Boolean $useNormals, Boolean $useVertexColors, Color4 color) {
//		super(($columns + 1) * ($rows + 1), $columns * $rows * 2, $useUvs,
//				$useNormals, $useVertexColors);
//
//		edges = $edges;
//		cols = $columns;
//		rows = $rows;
//
//		if (color != null) {
//			defaultColor(color);
//		}
//
//		build();
//	}

	public Polygon(int $edges, Color4 color) {
		this($edges, 2.0f, color);
	}

	public Polygon(int $edges, float defaultSize, Color4 color) {
		super($edges, 0);

		edges = $edges;
		this.defaultSize = defaultSize;
		
		vertexColorsEnabled(true);
		ignoreFaces(true);
		renderType(RenderType.TRIANGLE_FAN);
		normalsEnabled(false);

		if (color != null) {
			defaultColor(color);
		}

		build();
	}

	
	private void build() {
		vertexList = new ArrayList<FloatVertex>();

		FloatVertex org = new FloatVertex(0, this.defaultSize, 0);

		vertexList.add(org);

		for (int i = 1; i < edges; i++) {
			FloatVertex iVtx = FloatVertex.rotateZ(org, 360f / edges * i);

			vertexList.add(iVtx);
		}
		
		Color4 color = defaultColor();

		for(FloatVertex fv : vertexList){
			this.vertices().addVertex(fv.getX(), fv.getY(), fv.getZ(), 0, 1, 0, 0, 1.0f, color.r, color.g,
					color.b, color.a);
		}
		
//		this.vertices().addVertex(0.0f, 1.0f, 0.0f, 0.5f, 0.0f, 0, 0, 1.0f, color.r, color.g, color.b, color.a);
//		this.vertices().addVertex(-1.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0, 0, 1.0f, color.r, color.g, color.b, color.a);
//		this.vertices().addVertex(0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 0, 0, 1.0f, color.r, color.g, color.b, color.a);
//		this.vertices().addVertex(1.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0, 0, 1.0f, color.r, color.g, color.b, color.a);
		
//		int row, col;
//
//		float w = $width / $segsW;
//		float h = $height / $segsH;
//
//		float width5 = $width/2f;
//		float height5 = $height/2f;
//		
//		// Add vertices
//		
//		for (row = 0; row <= $segsH; row++)
//		{
//			for (col = 0; col <= $segsW; col++)
//			{
//				this.vertices().addVertex(
//					(float)col*w - width5, (float)row*h - height5,0f,	
//					(float)col/(float)$segsW, 1 - (float)row/(float)$segsH,	
//					0,0,1f,	
//					color.r, color.g, color.b, color.a
//				);
//			}
//		}
//		
//		// Add faces
//		
//		int colspan = $segsW + 1;
//		
//		for (row = 1; row <= $segsH; row++)
//		{
//			for (col = 1; col <= $segsW; col++)
//			{
//				int lr = row * colspan + col;
//				int ll = lr - 1;
//				int ur = lr - colspan;
//				int ul = ur - 1;
//				Utils.addQuad(this, ul,ur,lr,ll);
//			}
//		}
	}

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

		float a[] = new float[edges * 3];

		for (int i = 0; i < edges; i++) {
			FloatVertex fv = vertexList.get(i);

			a[(3 * i)] = fv.getX();
			a[(3 * i) + 1] = fv.getY();
			a[(3 * i) + 2] = fv.getZ();
		}

		ByteBuffer vbb = ByteBuffer.allocateDirect(a.length * 4);

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

		// gl.glDrawArrays(GL10.GL_LINES, 0, n);
		// gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, n);
		gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, edges);
		// gl.glDrawElements(GL10.GL_TRIANGLE_STRIP, 7,
		// GL10.GL_UNSIGNED_SHORT, indexBuffer);

		// Disable the vertices buffer.

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

		// Disable face culling.

		gl.glDisable(GL10.GL_CULL_FACE);

	}

}
