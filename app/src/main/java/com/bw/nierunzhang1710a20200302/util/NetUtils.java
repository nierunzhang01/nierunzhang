package com.bw.nierunzhang1710a20200302.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.2<p>
 * <p>更改时间：2020.3.2<p>
 */
public class NetUtils {
    //使用单例模式封装一个NetUtils类。
    private NetUtils(){}
    public static NetUtils getInstance() {
        return NET_UTILS;
    }
    private static final NetUtils NET_UTILS=new NetUtils();
    Handler handler=new Handler();
    //②　在类中封装网络状态判断的方法，可以判断有网无网。
    public boolean hasNet(Context context){
       ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }
    private String ioToString(InputStream inputStream) throws IOException {
        byte[] bytes=new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        int len=-1;
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes, 0, len);
        }
        final byte[] bytes1 = byteArrayOutputStream.toByteArray();
        final String json = new String(bytes1);
        return json;
    }
    private Bitmap ioToBitmap(InputStream inputStream){
        return BitmapFactory.decodeStream(inputStream);
    }
    public interface MyCallBack{
        void ondoSerssecc(String json);
        void onEroor();
    }
    //③　在类中封装HttpUrlConnection的get获取数据的方法。
    //④　在类中封装HttpUrlConnection的get获取图片的方法。
    //⑤　给HttpUrlConnection设置读取与连接超时为5秒钟，处理网络异常、判断网络响应状态码，关闭流。
    //⑥　封装网络数据响应成功处理的接口回调，在接口中定义网络响应成功的方法和网络响应失败的方法。
    //⑦　使用Log打印网络响应数据成功，（打印不成功扣除5分）。
    public void doGet(final String httpUrl, final MyCallBack myCallBack){
        new Thread(new Runnable(){
            @Override
            public void run() {
                InputStream inputStream=null;
                try {
                    final URL url = new URL(httpUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream= httpURLConnection.getInputStream();
                        final String json = ioToString(inputStream);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求成功"+json);
                                myCallBack.ondoSerssecc(json);
                            }
                        });
                    }else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求失败");
                                myCallBack.onEroor();
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("TAG", "请求失败");
                            myCallBack.onEroor();
                        }
                    });
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
    public void doGetPhoto(final String photoUrl, final ImageView imageView){
        new Thread(new Runnable(){
            @Override
            public void run() {
                InputStream inputStream=null;
                try {
                    final URL url = new URL(photoUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        inputStream= httpURLConnection.getInputStream();
                        final Bitmap bitmap = ioToBitmap(inputStream);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求图片成功");
                               imageView.setImageBitmap(bitmap);
                            }
                        });
                    }else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("TAG", "请求图片失败");

                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("TAG", "请求图片失败");

                        }
                    });
                }finally {
                    if (inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }).start();
    }
}
