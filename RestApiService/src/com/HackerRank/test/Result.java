package com.HackerRank.test;
import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
//import org.json.simple.parser.JSONParser;


class Result {

	/*
	 * Complete the 'avgRotorSpeed' function below.
	 *
	 * URL for cut and paste
	 * https://jsonmock.hackerrank.com/api/iot_devices/search?status={statusQuery}&page={number}
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. STRING statusQuery
	 *  2. INTEGER parentId
	 *  
	 *  Returns:
	 *  int: the floor of the average rotor speed of matching devices or 0 if there are none.
	 *  
	 *  Explanation:
	 *  There are 4 such devices and their rotor speeds are 4721, 4446, 1592 and 4761 respectively
	 *  Their average rotor speed is (4721 + 4446 + 1592 + 4761) / 4 = 15520/4 = 3880. 
	 *  
	 *  https://www.devmedia.com.br/trabalhando-com-json-em-java-o-pacote-org-json/25480
	 */

	public static int avgRotorSpeed(String statusQuery, int parentId) {

		int average = 0;
		int rotorSpeedValue;

		try {

			URL url = new URL("https://jsonmock.hackerrank.com/api/iot_devices/search?status=statusQuery&page=parentId");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			//Getting the response code
			int responsecode = conn.getResponseCode();

			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			} else {

				String inline = "";
				Scanner scanner = new Scanner(url.openStream());

				//Write all the JSON data into a string using a scanner
				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}

				//Close the scanner
				scanner.close();

				//Using the JSON simple library parse the string into a json object
				JSONParser parse = new JSONParser();
				JSONObject data_obj = (JSONObject) parse.parse(inline);

				//Get the required object from the above created object
				JSONObject obj = (JSONObject) data_obj.get("data");

				//Get the required data using its key
				System.out.println(obj.get("rotorSpeed"));

				//JSONArray arr = (JSONArray) data_obj.get("Countries");
				for (int i = 0; i < obj.length(); i++) {

					//JSONObject new_obj = (JSONObject) arr.get(i);
					rotorSpeedValue = rotorSpeedValue + (int) obj.get("rotorSpeed");
					System.out.println("Rotor Speed: " + obj.get("rotorSpeed"));
					break;
				}

				average = average / rotorSpeedValue;

			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return average;

	}
}