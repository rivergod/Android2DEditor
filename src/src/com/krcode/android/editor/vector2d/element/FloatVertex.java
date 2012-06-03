package com.krcode.android.editor.vector2d.element;

/**
 * @author rivergod
 *
 */
public class FloatVertex {

	/**
	 * 
	 */
	private float x;
	
	/**
	 * 
	 */
	private float y;
	
	/**
	 * 
	 */
	private float z;

	/**
	 * 
	 */
	public FloatVertex() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
	}

	/**
	 * @param x
	 * @param y
	 * @param z
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

		out.setX((float)((input.getX() * Math.cos(radian))
				- (input.getY() * Math.sin(radian))));
		
		out.setY((float)((input.getX() * Math.sin(radian))
				+ (input.getY() * Math.cos(radian))));
		
		return out;
	}
}
