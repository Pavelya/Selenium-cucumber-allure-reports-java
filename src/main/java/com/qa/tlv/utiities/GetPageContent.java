package com.qa.tlv.utiities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.*;

public class GetPageContent {

	private GetPageContent() {
	}

	@SuppressWarnings("unchecked")
	public static <T> void removeDuplicate(List<T> list) {
		Set<T> set = new HashSet<T>();
		List<T> newList = new ArrayList<T>();
		for (Iterator<T> iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add((T) element))
				newList.add((T) element);
		}
		list.clear();
		list.addAll(newList);
	}

	public static void Connect() throws Exception {

		List<String> urls = new ArrayList<String>();
		List<String> names = new ArrayList<String>();

		// Set URL
		URL url = new URL("https://tv4kids.tk/page/60/");
		URLConnection spoof = url.openConnection();

		// Spoof the connection so we look like a web browser
		spoof.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)");
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
		String strLine = "";
		String name = "";
		String mUrl = "";
		int i = 0;

		// Loop through every line in the source
		while ((strLine = in.readLine()) != null) {

			// Prints each line to the console
			if (strLine.contains("title") && strLine.contains("href")) {

				mUrl = StringUtils.substringBetween(strLine, "a href=\"", "\" title");

				name = StringUtils.substringBetween(strLine, "\" title=\"", "\">");

				urls.add(mUrl);
				names.add(name);

				i++;
				System.out.println(mUrl);

			}


		}

		System.out.println(i);
	}

	public static void main(String[] args) {

		try {
			// Calling the Connect method
			Connect();
		} catch (Exception e) {

		}
	}
}