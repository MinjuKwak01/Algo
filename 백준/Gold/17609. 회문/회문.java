

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String string = br.readLine();
			// 회문
			boolean isPali = isPalindrome(string);
			if (isPali) {
				System.out.println("0");
				continue;
			}
			// 부분회문
			boolean isPartPali = isPartPalindrome(string);
			if (isPartPali) {
				System.out.println("1");
				continue;
			} else {
				System.out.println("2");
			}
		}
	}

	private static boolean isPartPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;

		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(start + i) != s.charAt(end - i)) {
				// System.out.println(s.substring(start + i, end - i - 1));
				boolean left = isPalindrome(s.substring(start + i, end - i));
				if (left) {
					return true;
				}
				// System.out.println(s.substring(start + i + 1, end - i));
				boolean right = isPalindrome(s.substring(start + i + 1, end - i + 1));
				if (right) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}

//		char midChar = s.charAt(s.length() / 2);
//		// 길이는 짝수, 왼쪽이 문제일 경우
//		if (s.length() % 2 == 0 && (s.charAt(s.length() / 2 - 1) == midChar)) {
//			return false;
//		}
//		// 길이는 짝수, 가운데가 문제일 경우
//		if (s.length() % 2 == 0 && s.charAt(s.length() / 2 - 1) != midChar) {
//			int start = s.length() / 2 - 1;
//			int end = s.length() / 2 + 1;
//			int flag3 = 0;
//			for (int i = 0; i < s.length() / 2 - 1; i++) {
//				if (s.charAt(start - i) != s.charAt(end + i)) {
//					flag3++;
//				}
//			}
//			start = s.length() / 2 - 2;
//			end = s.length() / 2;
//			for (int i = 0; i < s.length() / 2 - 1; i++) {
//				if (s.charAt(start - i) != s.charAt(end + i)) {
//					flag3++;
//				}
//			}
//			if (flag3 >= 1) {
//				return false;
//			}
//
//		} else if (s.charAt(s.length() / 2 + 1) == midChar && s.length() % 2 != 0) {
//			System.out.println("왼");
//			int flag1 = 0;
//			int start = s.length() / 2;
//			int end = s.length() / 2 + 1;
//			for (int i = 0; i < s.length() / 2; i++) {
//				if (s.charAt(start - i) != s.charAt(end + i)) {
//					start--;
//					flag1++;
//				}
//				if (flag1 >= 2) {
//					return false;
//				}
//			}
//		} // 오른쪽이 문제일 경우
//		else if (s.charAt(s.length() / 2 - 1) == midChar && s.length() % 2 != 0) {
//			System.out.println("오");
//			int start = s.length() / 2 - 1;
//			int end = s.length() / 2;
//			int flag2 = 0;
//			for (int i = 0; i < s.length() / 2; i++) {
//				if (s.charAt(start - i) != s.charAt(end + i)) {
//					end++;
//					flag2++;
//				}
//				if (flag2 >= 2) {
//					return false;
//				}
//			}
//		} else if (s.length() % 2 != 0) {
//			int start = s.length() / 2 - 1;
//			int end = s.length() / 2 + 1;
//			int flag2 = 0;
//			for (int i = 0; i < s.length() / 2; i++) {
//				if (s.charAt(start - i) != s.charAt(end + i)) {
//					flag2++;
//				}
//				if (flag2 >= 1) {
//					return false;
//				}
//			}
//		}
//
//		return true;
//	}

	private static boolean isPalindrome(String s) {
	//	System.out.println(s);
		if (s.length() % 2 == 0) {
			int midInt = s.length() / 2;
			for (int i = 0; i < s.length() / 2; i++) {
				if (s.charAt(midInt - i - 1) != s.charAt(midInt + i))
					return false;
			}
			return true;
		} else {
			int midInt = s.length() / 2;
			for (int i = 1; i <= s.length() / 2; i++) {
				if (s.charAt(midInt - i) != s.charAt(midInt + i))
					return false;
			}
			return true;
		}
	}

}
