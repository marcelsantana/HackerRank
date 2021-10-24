/*
 *  A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
 *  Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
 *  A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
 *  By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 *  It contains no unmatched brackets.
 *  The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 *  Given 'n' strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.
 *
 *  Function Description
 *  Complete the function isBalanced in the editor below.
 *  
 *  isBalanced has the following parameter(s):
 *  string s: a string of brackets
 *  
 *  Returns
 *  string: either YES or NO
 *  
 *  Input Format
 *  The first line contains a single integer , the number of strings.
 *  Each of the next  lines contains a single string , a sequence of brackets.
 * 
 */

package balanced.brakets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

	/*
	 * Complete the 'isBalanced' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING s as parameter.
	 */

	public static String isBalanced(String s) {
		// Write your code here
		int length = s.length();
		int check  = -1;
		String brac[] = new String[length];

		for(int i= 0; i < length; i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){      
				check++;
				brac[check]=String.valueOf(s.charAt(i));    
			}
			else if(check == -1){
				check = 2;
				break;
			}
			else{

				if(s.charAt(i) == ')' && brac[check].equals("(")) {
					check=check-1;   
				}
				else if(s.charAt(i) == '}' && brac[check].equals("{")){
					check=check-1;   
				}
				else if(s.charAt(i) == ']' && brac[check].equals("[")){
					check-=1;
				}
				else{
					break;
				}
			}

		}

		System.out.println(length);

		if(check < 0){
			return "YES";
		}
		else{
			return "NO";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		for (int tItr = 0; tItr < t; tItr++) {
			String s = bufferedReader.readLine();

			String result = Solution.isBalanced(s);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedReader.close();
		bufferedWriter.close();
	}
}
