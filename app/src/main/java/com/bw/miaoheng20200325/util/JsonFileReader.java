package com.bw.miaoheng20200325.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 时间 :2020/4/2  13:48
 * 作者 :苗恒
 * 功能 :
 */
public class JsonFileReader {
    public static String getJson(Context context, String fileName) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {

            AssetManager assetManager = context.getAssets();

            InputStream inputStream = assetManager.open(fileName);

            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            byte[] buffer = new byte[1024];

            int len;

            while ((len = bufferedInputStream.read(buffer)) != -1) {

                baos.write(buffer, 0, len);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }finally {

            try {

                baos.close();



            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return baos.toString();

    }
}
