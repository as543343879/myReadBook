/**
 * Main class
 *
 * @author 谢小平
 * @date 2020-10-09
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		try {
			synchronized (main) {
				main.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
