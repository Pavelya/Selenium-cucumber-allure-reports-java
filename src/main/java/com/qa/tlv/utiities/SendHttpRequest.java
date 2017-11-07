package com.qa.tlv.utiities;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.cert.X509Certificate;

/**
 * Util to send http request
 *
 */

public class SendHttpRequest {

	public static String SendSecuredRequset(String baseApiUrl, String requestType, String URL, String postParams)
			throws Exception {

		System.setProperty("jsse.enableSNIExtension", "false");

		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

		URL url = new URL(baseApiUrl + URL);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		// add request header
		con.setRequestMethod(requestType.toUpperCase());
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		// Send request
		con.setDoOutput(true);

		// store post request params
		if (requestType.equalsIgnoreCase("POST")) {
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());

			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
		}

		// get error code
		int errorCode = con.getResponseCode();

		BufferedReader in;

		// print error in console if error code is captured
		if (errorCode >= 400) {

			in = new BufferedReader(new InputStreamReader(con.getErrorStream()));

			// print non-error output in console if valid response code is
			// captured
		} else {
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		}

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		String apiResponse = response.toString();

		// Log.INFO("RESPONSE OUTPUT: " + apiResponse);
		// Log.INFO(URL);

		con.setHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});

		// Log.INFO("RESPONSE CODE: " + (con.getResponseCode()));

		con.disconnect();
		return apiResponse;
	}
}