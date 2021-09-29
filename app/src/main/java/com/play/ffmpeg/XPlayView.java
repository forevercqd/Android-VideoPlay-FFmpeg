package com.play.ffmpeg;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Author: yeliang(yeliang@tv365.net)
 * Date: 2019/2/12
 * Time: 6:50 PM
 * Description:
 */

//public class XPlayView extends GLSurfaceView implements SurfaceHolder.Callback, View.OnClickListener, GLSurfaceView.Renderer{
public class XPlayView extends TextureView implements TextureView.SurfaceTextureListener, View.OnClickListener {
    private Surface mSurface;

    public XPlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setSurfaceTextureListener(this);
        setOnClickListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        Log.e("XPlayView", "onSurfaceTextureAvailable");
        mSurface = new Surface(surfaceTexture);
        InitView(mSurface);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        mSurface = null;
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

    }

    public native void InitView(Object surface);

    public native void playOnPause();

    @Override
    public void onClick(View v) {
        playOnPause();
    }

}
