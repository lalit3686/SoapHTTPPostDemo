package com.soap;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;

public class SoapHTTPPostActivity extends Activity {

	private String URL = "http://www.w3schools.com/webservices/tempconvert.asmx";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		String xml = null;
		try {
			xml = convertStreamToString(getAssets().open("request.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String request = String.format(xml, "12");
		HTTPOST httpost = new HTTPOST();
		httpost.getResponseByXML(URL, request);
		httpost.getResponseByFile(URL);
	}

	public static String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line+"\n");
		}
		is.close();
		return sb.toString();
	}
}