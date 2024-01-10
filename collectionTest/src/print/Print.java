package print;

public class Print {
	
	public static void printLn(int data) {
		for (int i = 0; i < data; i++) {
			System.out.println();
		}
	}
	
	public static void printVar() {
		System.out.println("────────────────────────────────────────────────────────────────────────");
	}
	
	public static void printBox(String text) {
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("                       "+text);
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}
	
}
