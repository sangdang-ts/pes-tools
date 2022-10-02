import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static String convertHex(int number) {
		String hex = Integer.toHexString(number);
		if (String.valueOf(hex).length() <= 1) {
			hex = "0" + hex;
		}
		return hex.toUpperCase();
	}

	public static void getHexNewData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("First HEX: ");
		int first = (int) Long.parseLong(sc.nextLine(), 16);
		System.out.println("Second HEX: ");
		int second = (int) Long.parseLong(sc.nextLine(), 16);
		System.out.println("List numbers: ");
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 16; i++) {
			int input = sc.nextInt();
			nums.add(input);
		}
		for (int i = 0; i < nums.size(); i++) {
			second += nums.get(i);
			if (second > 255) {
				first += 1;
				second -= 256;
			}
			System.out.println(convertHex(first) + "\t" + convertHex(second));
		}
		sc.close();
	}

	public static void getHexOldData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("First HEX: ");
		int first = (int) Long.parseLong(sc.nextLine(), 16);
		System.out.println("Second HEX: ");
		int second = (int) Long.parseLong(sc.nextLine(), 16);
		System.out.println("List hex: ");
		List<String> nums = new ArrayList<String>();
		String[] arr = sc.nextLine().split(" ");
		for (int j = 0; j < arr.length; j++) {
			nums.add(arr[j]);
		}
		int start = 0;
		while (start < nums.size() - 7) {
			int lenName = (int) Long.parseLong(nums.get(start + 6), 16);
			int total = lenName + 7;
			second += total;
			if (second > 255) {
				first += 1;
				second -= 256;
			}
			String ch = "";
			for (int i = start + 7; i < start + total; i++) {
				int dec = (int) Long.parseLong(nums.get(i), 16);
				ch += (char) dec;
			}
			System.out.println(ch + "\t" + convertNumber(lenName) + "\t" + convertNumber(total) + "\t"
					+ convertHex(first) + "\t" + convertHex(second));
			start += total;
		}
		sc.close();
	}

	public static String convertNumber(int number) {
		String res = String.valueOf(number);
		if (String.valueOf(number).length() <= 1) {
			res = "0" + res;
		}
		return res;
	}

	public static void main(String[] args) {
//		getHexNewData();
		getHexOldData();
	}

}
