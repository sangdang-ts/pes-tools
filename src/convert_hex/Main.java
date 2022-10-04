package convert_hex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static String convertToHex(int number) {
		String hex = Integer.toHexString(number);
		if (String.valueOf(hex).length() <= 1) {
			hex = "0" + hex;
		}
		return hex.toUpperCase();
	}

	public static String convertToNumber(int number) {
		String res = String.valueOf(number);
		if (String.valueOf(number).length() <= 1) {
			res = "0" + res;
		}
		return res;
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
			System.out.println(convertToHex(first) + "\t" + convertToHex(second));
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
		for (int i = 0; i < arr.length; i++) {
			nums.add(arr[i]);
		}

		int start = 0;
		String res = "";
		List<String> names = new ArrayList<String>();
		List<Integer> namesSize = new ArrayList<Integer>();
		List<Integer> totalBytes = new ArrayList<Integer>();
		List<String> firstBytes = new ArrayList<String>();
		List<String> secondBytes = new ArrayList<String>();

		while (start < nums.size() - 7) {
			int nameSize = (int) Long.parseLong(nums.get(start + 6), 16);
			int total = nameSize + 7;
			second += total;
			if (second > 255) {
				first += 1;
				second -= 256;
			}

			String name = "";
			for (int i = start + 7; i < start + total; i++) {
				int dec = (int) Long.parseLong(nums.get(i), 16);
				name += (char) dec;
			}
			names.add(name);
			namesSize.add(nameSize);
			totalBytes.add(total);
			firstBytes.add(convertToHex(first));
			secondBytes.add(convertToHex(second));
//			System.out.println(
//					name + "\t" + nameSize + "\t" + total + "\t" + convertToHex(first) + "\t" + convertToHex(second));

			res += convertToHex(first) + convertToHex(second);
			start += total;
		}

		names.remove(0);
		namesSize.remove(0);
		totalBytes.remove(0);
		firstBytes.remove(firstBytes.size() - 1);
		secondBytes.remove(secondBytes.size() - 1);

		List<EntryOldData> ents = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			EntryOldData ent = new EntryOldData(names.get(i), namesSize.get(i), totalBytes.get(i), firstBytes.get(i),
					secondBytes.get(i));
			ents.add(ent);
		}

		for (EntryOldData ent : ents) {
			System.out.println(ent);
		}

		System.out.println(res);
		sc.close();
	}

	public static void main(String[] args) {
		getHexNewData();
//		getHexOldData();
	}

}
