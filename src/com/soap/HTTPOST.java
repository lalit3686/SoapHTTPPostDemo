package com.soap;

import java.io.File;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.os.Environment;
import android.util.Log;

public class HTTPOST {

	public String getResponseByXML(String URL, String request) {
		HttpPost httpPost = new HttpPost(URL);
		StringEntity entity;
		String response_string = null;
		try {
			entity = new StringEntity(request, HTTP.UTF_8);
			httpPost.setHeader("Content-Type","text/xml;charset=UTF-8");
			//	httpPost.setHeader("Content-Type","application/soap+xml;charset=UTF-8");
			httpPost.setEntity(entity);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpPost);
			response_string = EntityUtils.toString(response.getEntity());
			Log.d("request", response_string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response_string;
	}
	
	public String getResponseByFile(String URL) {

		HttpPost httpPost = new HttpPost(URL);
		FileEntity entity;
		String response_string = null;
		try {
			entity = new FileEntity(new File(Environment.getExternalStorageDirectory()+File.separator+"request.xml"), "UTF-8");
			httpPost.setHeader("Content-Type","text/xml;charset=UTF-8");
			//	httpPost.setHeader("Content-Type","application/soap+xml;charset=UTF-8");
			httpPost.setEntity(entity);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response = client.execute(httpPost);
			response_string = EntityUtils.toString(response.getEntity());
			Log.d("request", response_string);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response_string;
	}
}
