
public class Dice {
	
	private int roll; //´«ÀÇ°ª
	public void rollDie() {
		roll = (int)(Math.random() *6 +1);
	}

	public int getRoll() {
		return roll;
	}
}

