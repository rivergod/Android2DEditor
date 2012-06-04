package com.krcode.android.editor.vector2d.element;

import javax.microedition.khronos.opengles.GL10;

/**
 * @author rivergod
 * @deprecated
 *
 * 화면에 존재하는 객체를 위한 인터페이스<br/>
 * <br/>
 * min3d사용으로 더이상 사용하지 않음<br/>
 */
public interface Figure {
	public void draw(GL10 gl);
}
