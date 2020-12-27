
public class Player {

	private String name;
	private static final int UPPER = 6;
	private static final int LOWER = 7; //점수판 총 13개
	private boolean [] used; //13개 점수판을 기록했는지 관리하는 배열

	private int[] scores; //13개 점수판에 기록된 점수
	private int upperScore; //UPPER에 기록된 점수 합
	private int lowerScore; //LOEWR에 기록된 점수 합
	private int totalScore; //upperScore + Bonus(35) + lowerScore

	public Player(String name) {
		this.name = name;
		this.used = new boolean [UPPER + LOWER]; //13
		this.scores = new int [UPPER + LOWER];
	}

	public void setScore(int score, int index) {
		scores[index] = score;
	}

	public int [] getScores() {
		return scores;
	}
	
	public int getUpperScore() { //상단 6개 섹션의 합
		upperScore =0;
		for (int i=0; i<UPPER; i++)
		upperScore += scores[i];
		return upperScore;
	}

	public int getLowerScore() {
		lowerScore = 0;
		for (int i=UPPER; i<UPPER+LOWER; i++)
		lowerScore += scores[i];
		return lowerScore;
	}

	public int getTotalScore() {
		totalScore = getUpperScore() + getLowerScore();
		return totalScore;
	}

	public boolean[] getUesd() {
		return used;
	}

	public void setAtUsed (int index, boolean value) {
		used[index] = value;
	}
	
	public String toString() {
		return name;
	}
}