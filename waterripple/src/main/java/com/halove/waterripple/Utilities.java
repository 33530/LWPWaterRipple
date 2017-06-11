package com.halove.waterripple;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by alexis on 10/01/17.
 */

public class Utilities {


    public static final int DEVICE_WIDTH = 1080;
    public static final int DEVICE_HEIGHT = 1920;

    public static Bitmap drawable2Bitmap(Drawable drawable){
        Bitmap bitmap = null;
        bitmap = ((BitmapDrawable)drawable).getBitmap();
        //Log.e("zhz","wallpaper width:"+bitmap.getWidth()+",height:"+bitmap.getHeight());
        bitmap = Bitmap.createBitmap(bitmap,0,0,DEVICE_WIDTH,DEVICE_HEIGHT);
        //Log.e("zhz","wallpaper width:"+bitmap.getWidth()+",height:"+bitmap.getHeight());
        //bitmap = scaleImage(((BitmapDrawable)drawable).getBitmap(),DEVICE_WIDTH,DEVICE_HEIGHT);
        /*if(bitmap == null){

            int w = DEVICE_WIDTH;
            int h = DEVICE_HEIGHT;

            Bitmap.Config config =  Bitmap.Config.ARGB_8888 ;
           // Bitmap.Config config =  Bitmap.Config.RGB_565 ;

            bitmap = Bitmap.createBitmap(w,h,config);
            //注意，下面三行代码要用到，否则在View或者surfaceview里的canvas.drawBitmap会看不到图
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0,0,w,h);
            drawable.draw(canvas);
        }*/
        return bitmap;

    }

    public static Bitmap scaleImage(Bitmap bm, int newWidth, int newHeight) {
        if (bm == null) {
            return null;
        }
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix,
                true);
        /*if (bm != null & !bm.isRecycled()) {
            bm.recycle();
            bm = null;
        }*/
        return newbm;
    }

    /** 保存方法 */
    /*public void saveBitmap() {
        File f = new File("/sdcard/namecard/", "wallpaper");
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }*/
}
