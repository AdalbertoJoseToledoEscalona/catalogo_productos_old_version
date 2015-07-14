/**
 * 
 */
package q4;

/**
 * @author adalberto
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10; String name = null;
		try {
			a = name.length();
			a++;
		} catch (RuntimeException e) {
			++a;
		}
		System.out.println(a);
	}

}
