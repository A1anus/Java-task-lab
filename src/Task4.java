import java.util.*;
import java.util.stream.Collectors;


public class Task4 {
	public static void main(String[] args) {
		System.out.println(nonRepeatable("abracadabra"));
		System.out.println(nonRepeatable("paparazzi"));
		System.out.println("----------------------------------|");
		System.out.println(generateBracket(1));
		System.out.println(generateBracket(2));
		System.out.println(generateBracket(3));
		System.out.println("----------------------------------|");
		System.out.println(binarySystem(3));
		System.out.println(binarySystem(4));
		System.out.println("----------------------------------|");
		System.out.println(alphabeticRow("abcdjuwx"));
		System.out.println(alphabeticRow("klmabzyxw"));
		System.out.println("----------------------------------|");
		System.out.println(func("aaabbcdd"));
		System.out.println(func("vvvvaajaaaaa"));
		System.out.println("----------------------------------|");
		System.out.println(convertToNum("eight"));
		System.out.println(convertToNum("five hundred sixty seven"));
		System.out.println(convertToNum("thirty one"));
		System.out.println("----------------------------------|");
		System.out.println(uniqueSubstring("123412324"));
		System.out.println(uniqueSubstring("111111"));
		System.out.println(uniqueSubstring("77897898"));
		System.out.println("----------------------------------|");
		int[][] matrix1 = {
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
		System.out.println(shortestWay(matrix1));  // Ожидаемый результат: 7

		int[][] matrix2 = {
				{2, 7, 3},
				{1, 4, 8},
				{4, 5, 9}
		};
		System.out.println(shortestWay(matrix2));
		System.out.println("----------------------------------|");
		System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
		System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
		System.out.println("----------------------------------|");
		System.out.println(switchNums(519, 723));
		System.out.println(switchNums(491, 3912));
		System.out.println(switchNums(6274, 71259));
	}

	public static String nonRepeatable(String str) {
		if (str.length() <= 1) {
			return str;
		}

		String withoutCurrentChar = str.substring(1).replaceAll(String.valueOf(str.charAt(0)), "");
		String resultWithoutDuplicates = nonRepeatable(withoutCurrentChar);
		return str.charAt(0) + resultWithoutDuplicates;
	}

	public static List<String> generateBracket(int n) {
		List<String> res = new ArrayList<>();
		generateBracketHelp(n, n, "", res);
		return res;
	}
	public static void generateBracketHelp(int left, int right, String cur, List<String> res) {
		if (left == 0 && right == 0) {
			res.add(cur);
			return;
		}
		if (left > 0) {
			generateBracketHelp(left - 1, right, cur + "(", res);
		}
		if (right > 0 && left < right) {
			generateBracketHelp(left, right - 1, cur + ")", res);
		}

	}

	public static List<String> binarySystem(int n) {
		List<String> res = new ArrayList<>();
		binarySystemHelp(n, "", res);
		return res;
	}

	public static void binarySystemHelp(int n, String cur, List<String> res) {
		if (cur.length() == n) {
			res.add(cur);
			return;
		}
		if (cur.isEmpty() || cur.charAt(cur.length() - 1) == '1') {
			binarySystemHelp(n, cur + '0', res);
		}
		binarySystemHelp(n, cur + '1', res);
	}

	public static String alphabeticRow(String input) {
		String curRow = String.valueOf(input.charAt(0));
		String longestRow = curRow;

		for(int i = 1; i < input.length(); i++) {
			 char current = input.charAt(i);
			 char nextCurrent = input.charAt(i - 1);

			 if(current - 1 == nextCurrent || current + 1 == nextCurrent) {
				 curRow += current;
			 } else {
				 curRow = String.valueOf((current));
			 }
			 if (curRow.length() > longestRow.length()) {
					longestRow = curRow;
			 }
		}
		return longestRow;

	}

	public static String func(String input) {
		StringBuilder res = new StringBuilder();
		List<String> patterns = new ArrayList<>();

		char cur = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			char temp = input.charAt(i);

			if (cur == temp) {
				count++;
			} else {
				patterns.add(cur + String.valueOf(count));

				count = 1;

				cur = temp;
			}
		}

		patterns.add(cur + String.valueOf(count));

		patterns.sort(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))));

		for (String pattern : patterns) {
			res.append(pattern);
		}

		return res.toString();
	}

	public static int convertToNum(String s) {
		Map<String, Integer> wordToNum = new HashMap<>();
		wordToNum.put("one", 1);
		wordToNum.put("two", 2);
		wordToNum.put("three", 3);
		wordToNum.put("four", 4);
		wordToNum.put("five", 5);
		wordToNum.put("six", 6);
		wordToNum.put("seven", 7);
		wordToNum.put("eight", 8);
		wordToNum.put("nine", 9);
		wordToNum.put("ten", 10);
		wordToNum.put("eleven", 11);
		wordToNum.put("twelve", 12);
		wordToNum.put("thirteen", 13);
		wordToNum.put("fourteen", 14);
		wordToNum.put("fifteen", 15);
		wordToNum.put("sixteen", 16);
		wordToNum.put("seventeen", 17);
		wordToNum.put("eighteen", 18);
		wordToNum.put("nineteen", 19);
		wordToNum.put("twenty", 20);
		wordToNum.put("thirty", 30);
		wordToNum.put("forty", 40);
		wordToNum.put("fifty", 50);
		wordToNum.put("sixty", 60);
		wordToNum.put("seventy", 70);
		wordToNum.put("eighty", 80);
		wordToNum.put("ninety", 90);
		wordToNum.put("hundred", 100);
		wordToNum.put("thousand", 1000);
		String[] words = s.split(" ");
		int result = 0;

		if (s.contains("hundred")) {
			int temp = wordToNum.get(words[0]);

			result = temp * 100;

			for (int i = 2; i < words.length; i++) {
				result += wordToNum.get(words[i]);
			}
		} else {

			for (String word : words) {
				result += wordToNum.get(word);
			}
		}

		return result;
	}

	public static String uniqueSubstring(String input) {
		if (input.length() <= 1) {
			return input;
		}

		String str = input.substring(1).replaceAll(String.valueOf(input.charAt(0)), "");
		String temp = uniqueSubstring(str);
		return input.charAt(0) + temp;
	}

	public static int shortestWay(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] dp = new int[rows][cols];

		dp[0][0] = matrix[0][0];
		for (int i = 1; i < rows; i++) {
			dp[i][0] = dp[i-1][0] + matrix[i][0];
		}
		for (int j = 1; j < cols; j++) {
			dp[0][j] = dp[0][j-1] + matrix[0][j];
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
			}
		}

		return dp[rows-1][cols-1];

	}

	public static String numericOrder(String input) {

		List<String> arr = new ArrayList<>();
		String[] words = input.split(" ");

		for (String word: words) {
			arr.add(word);
		}
		arr.sort(Comparator.comparingInt(Task4::extractNumb));
		String temp  = arr.stream().collect(Collectors.joining(" "));
		temp = temp.replaceAll("\\d", "");
		return temp;
	}

	public static int extractNumb(String s) {
		String num = s.replaceAll("\\D", "");
		return num.isEmpty() ? 0 : Integer.parseInt(num);
	}

	public static int switchNums(int in1, int in2) {
		String s = String.valueOf(in1);
		String s2 = String.valueOf(in2);

		String[] num = s.split("");
		String[] num2 = s2.split("");

		Integer[] intArr1 = new Integer[num.length];
		Integer[] intArr2 = new Integer[num2.length];

		for (int i = 0; i < num.length; i++) {
			intArr1[i] = Integer.parseInt(num[i]);
		}
		for (int i = 0; i < num2.length; i++) {
			intArr2[i] = Integer.parseInt(num2[i]);
		}

		Arrays.sort(intArr1, Collections.reverseOrder());

		int i = 0, j = 0;
		while(i < intArr1.length && j < intArr2.length) {
			if (intArr1[i] > intArr2[j]) {
				intArr2[j] = intArr1[i];
				j++;
				i++;
			} else {
				j++;
			}
		}
		
		StringBuilder temp = new StringBuilder();
		for (Integer nums:intArr2) {
			temp.append(nums);
		}

		int res = Integer.parseInt(temp.toString());
		
		return res;
	}


//	public static void reverseSort(int[] arr) {
//		int start = 0;
//		int end = arr.length -1;
//
//		while (start < end) {
//			int temp = arr[start];
//			arr[start] = arr[end];
//			arr[end] = temp;
//
//			start++;
//			end--;
//		}
//	}

	public static void fizzBuzzPrint(int i) {
		if (i % 3 == 0 && i % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (i % 3 == 0) {
			System.out.println("Fizz");
		} else if (i % 5 == 0) {
			System.out.println("Buzz");
		}
	}




}
