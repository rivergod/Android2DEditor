package com.krcode.android.editor.vector2d.element;

public class FloatVertex {

	private float x;
	private float y;
	private float z;

	public FloatVertex() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}

	public FloatVertex(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

}
