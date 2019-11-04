package com.yangrui.shark.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostUtils {

  public static String dispachPackageDataByPostUrl(String url, String param) {
    PrintWriter out = null;
    BufferedReader in = null;
    String result = "";
    try {
      URL realUrl = new URL(url);
      URLConnection conn = realUrl.openConnection();
      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      conn.setRequestProperty("connection", "Keep-Alive");
      conn.setRequestProperty("Accept-Charset", "utf-8");
      conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
      conn.setDoOutput(true);
      conn.setDoInput(true);
      out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "utf-8"));

      out.print(param);
      out.flush();
      InputStream instr = conn.getInputStream();
      byte[] bis = input2byte(instr);
      result = new String(bis, "UTF-8");
    } catch (Exception e) {
      System.out.println("*************" + e);
      e.printStackTrace();
    }
    finally {
      try {
        if (out != null) {
          out.close();
        }
        if (in != null) {
          in.close();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return result;
  }

  public static final byte[] input2byte(InputStream inStream) throws IOException {
    ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
    byte[] buff = new byte[100];
    int rc = 0;
    while ((rc = inStream.read(buff, 0, 100)) > 0) {
      swapStream.write(buff, 0, rc);
    }
    byte[] in2b = swapStream.toByteArray();
    return in2b;
  }
}
