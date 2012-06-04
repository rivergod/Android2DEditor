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

/**
 * @author rivergod
 * 
 * 다각형을 처리하기 위한 객체<br/>
 */
public class Polygon extends Object3dContainer {

	/**
	 * edge의 갯수
	 */
	private int edges;
		
	/**
	 * 기본크기 
	 */
	private float defaultSize;

	private int cols;
	private int rows;

	private ArrayList<FloatVertex> vertexList;

	/**
	 * @param $edges edge의 갯수
	 * @param color 색상
	 * 
	 * edge의 갯수와 기본 색상으로만 객체를 선언하는 생성자 <br/>
	 */
	public Polygon(int $edges, Color4 color) {
		this($edges, 2.0f, color);
	}

	/**
	 * @param $edges edge의 갯수
	 * @param defaultSize 기본 크기
	 * @param color 색상
	 * 
	 * edge의 갯수, 크기, 기본 색상으로만 객체를 선언하는 생성자 <br/>
	 */
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

	
	/**
	 * opengl에 객체를 생성하기 위한 연산 루틴
	 */
	private void build() {
		// 꼭지점의 목록
		vertexList = new ArrayList<FloatVertex>();

		// 기준 꼭지점
		FloatVertex org = new FloatVertex(0, this.defaultSize, 0);

		vertexList.add(org);

		// 정 n각형 생성을 위하여 계산된 각도를 회전하여 연산
		for (int i = 1; i < edges; i++) {
			FloatVertex iVtx = FloatVertex.rotateZ(org, 360f / edges * i);

			vertexList.add(iVtx);
		}
		
		Color4 color = defaultColor();

		// 화면에 출력하기 위한 vertex를 생성하여 min3d의 render에 넘김
		for(FloatVertex fv : vertexList){
			this.vertices().addVertex(fv.getX(), fv.getY(), fv.getZ(), 0, 1, 0, 0, 1.0f, color.r, color.g,
					color.b, color.a);
		}
		
	}

	/**
	 * @param gl
	 * @deprecated
	 * 
	 * min3d사용으로 더이상 사용하지 않음
	 */
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
