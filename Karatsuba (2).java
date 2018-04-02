import java.util.*;

public class Karatsuba {
	int c1, c2, c3;
	int result;
	int left1, left2, right1, right2;
	int r1, r2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("input1 ");
		int number1 = in.nextInt();
		System.out.print("input2 ");
		int number2 = in.nextInt();
		int long1, long2;
		int N;

		long1 = Integer.toString(number1).length();
		long2 = Integer.toString(number2).length();
		N = Math.max(long1, long2);
		Karatsuba krs = new Karatsuba();
		krs.printKaratsuba(number1, number2, long1, long2, N);

		

	}

	public int result(int left1, int left2, int right1, int right2, int long1,
			int long2, int N) {
		c3 = left1 * left2;
		c1 = right1 * right2;
		c2 = (left1 + right1) * (left2 + right2) - c3 - c1;
		return c3 * (ten2(long1, long2, N) * ten2(long1, long2, N))
				+ ((c2 * ten2(long1, long2, N))) + c1; // /

	}

	public void printKaratsuba(int number1, int number2, int long1, int long2,
			int N) {
		if (long1 % 2 == 0 && long2 % 2 == 0) {
			r1 = (int) Math.pow(10, (N / 2));
			r2 = (int) Math.pow(10, (N) / 2);
			left1 = number1 / r1;
			left2 = number2 / r2;
			right1 = number1 % r1;
			right2 = number2 % r2;
		} else {
			r1 = (int) Math.pow(10, (long1 / 2) + 1);
			r2 = (int) Math.pow(10, (long2 / 2) + 1);
			left1 = number1 / r1;
			left2 = number2 / r2;
			right1 = number1 % r1;
			right2 = number2 % r2;
		}
		System.out.println("Karatsuba is "
				+ result(left1, left2, right1, right2, long1, long2, N));

	}

	public int ten2(int long1, int long2, int N) {
		if (N % 2 == 1) {
			return (int) Math.pow(10, (N / 2) + 1);
		} else {
			return (int) Math.pow(10, (N / 2));
		}

	}
}
