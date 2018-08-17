/**
 * 
 */
package testing;

public class FrogJump {

    public int solution(int X, int Y, int D) {
	return (int) Math.ceil((double) Y - X / D);
    }

}
