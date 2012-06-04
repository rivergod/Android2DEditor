package com.krcode.android.editor.vector2d.element;

/**
 * @author rivergod
 * 
 * x, y, z 좌표 <br/>
 * 좌표를 저장하면서 좌표에 대한 연산을 진행 할 수 있는 객체<br/>
 */
public class FloatVertex {

	/**
	 * x 좌표
	 */
	private float x;

	/**
	 * y 좌표
	 */
	private float y;

	/**
	 * z 좌표
	 */
	private float z;

	/**
	 * 기본생성자
	 */
	public FloatVertex() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}

	/**
	 * @param x x좌표
	 * @param y y좌표
	 * @param z z좌표
	 */
	public FloatVertex(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * @return
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return
	 */
	public float getZ() {
		return z;
	}

	/**
	 * @param z
	 */
	public void setZ(float z) {
		this.z = z;
	}

	/**
	 * @param input
	 * @param degree
	 * @return
	 */
	public static FloatVertex rotateZ(FloatVertex input, float degree) {
		FloatVertex out = new FloatVertex();

		float radian = degree / 180.0f * (float) Math.PI;

		out.setX((float) ((input.getX() * Math.cos(radian)) - (input.getY() * Math
				.sin(radian))));

		out.setY((float) ((input.getX() * Math.sin(radian)) + (input.getY() * Math
				.cos(radian))));

		return out;
	}
}
