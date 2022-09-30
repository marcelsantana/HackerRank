
package com.maximum.quality;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



class Result {

	/*
	 * Complete the 'maximumQuality' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY packets
	 *  2. INTEGER channels
	 */

	public static long maximumQuality(List<Integer> packets, int channels) {
		// Write your code here
		return 0;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int packetsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> packets = new ArrayList<>();

		for (int i = 0; i < packetsCount; i++) {
			int packetsItem = Integer.parseInt(bufferedReader.readLine().trim());
			packets.add(packetsItem);
		}

		int channels = Integer.parseInt(bufferedReader.readLine().trim());

		long result = Result.maximumQuality(packets, channels);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
