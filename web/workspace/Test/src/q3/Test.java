/**
 * 
 */
package q3;

/**
 * @author adalberto
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String[][] names = {{"Andre", "Mike"}, null, {"Pedro"}};
			System.out.println(names[2][1].substring(0, 2));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(1);
			
		}
	}

}
