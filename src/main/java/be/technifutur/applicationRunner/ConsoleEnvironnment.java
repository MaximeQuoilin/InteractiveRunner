package be.technifutur.applicationRunner;

import java.util.Scanner;

public class ConsoleEnvironnment implements Environment {
	Scanner sc = new Scanner(System.in);

	@Override
	public void print(CharSequence out) {
		System.out.println(out);
	}

	@Override
	public String nextLine() {
		return this.sc.nextLine();
	}

}
