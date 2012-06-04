/**
 * 
 */
package com.krcode.android.editor.vector2d;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * @author rivergod
 * @deprecated
 * 
 * min3d사용으로 더이상 사용하지 않음 <br/>
 */
public class EditorSurfaceView extends GLSurfaceView {
	private GestureDetector gestureDetector;

	/**
	 * @param context
	 */
	public EditorSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.setRenderer(new EditorRender());
		this.gestureDetector = new GestureDetector(context, new EditorOnGestureListener());
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public EditorSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.setRenderer(new EditorRender());
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return gestureDetector.onTouchEvent(event);
	}
	
	private class EditorOnGestureListener extends GestureDetector.SimpleOnGestureListener {
		@Override
		public boolean onDown(MotionEvent e) {
			// TODO Auto-generated method stub
			return super.onDown(e);
		}
		
		@Override
		public boolean onDoubleTap(MotionEvent e) {
			// TODO Auto-generated method stub
			return super.onDoubleTap(e);
		}
		
		@Override
		public boolean onSingleTapConfirmed(MotionEvent e) {
			// TODO Auto-generated method stub
			return super.onSingleTapConfirmed(e);
		}
	}
}
