package com.krcode.android.editor.vector2d.element;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

public class Polygon implements Figure {
	
	private int n;
	
	private ArrayList<FloatVertex> vertexList;
	
	public Polygon() {
		n = 7;
		vertexList = new ArrayList<FloatVertex>();
	}

	@Override
	public void draw(GL10 gl) {
		// TODO Auto-generated method stub
		
	}

}
