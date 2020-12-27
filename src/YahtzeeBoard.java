import java.util.Scanner;
public class YahtzeeBoard {
	private Scanner scanner;
	private int numPlayers;
	private Player[] players;
	private Dice[] dice;  //그냥 주사위 배열
	private boolean[] chosenDice; //간직한 주사위 배열, 간직하면 true
	private static int player; //멀티 플레이어를 가정했을때 어떤 플레이어 차례인지 나타냄
	private static int roll; //0,1,2 주사위 3번 던지는 것을 관리
	private static int round; //0,1,2...13 라운드를 관리

	public YahtzeeBoard() {
		scanner = new Scanner(System.in);
		numPlayers = 1;
		players = new Player[numPlayers];
		players[0] = new Player("정다민");
		dice = new Dice[5];
		for (int i =0; i<5; i++)
			dice[i] = new Dice();
		chosenDice = new boolean[5];
	}
	
	public void run() {
		System.out.println("=================== 1인용 YAHTZEE GAME =================");
		for (int i =0; i<13; i++) {
			players[0].setScore(0,1); //13개 점수판 점수 scores 0으로 초기화
			players[0].setAtUsed(i, false); //13개 점수판 선택하지 않은 used false로 초기화
		}
		for (round=0; round<13; round++) {
			for (int i=0; i<5; i++)
				chosenDice[i] = false; //주사위 5개 선택하지 않은 false로 초기화
			for (roll=0; roll<3; roll++) { //5개 주사위 중 선택하지 않은 것들을 3번 던진다
				System.out.println("\t===== " +(roll+1) +"번째 주사위를 던진다!");
				for (int i=0; i<5; i++) {
					if (chosenDice[i] == false) //간직하지 않은 주사위만 던진다
						dice[i].rollDie();
					System.out.println("\t" +(i+1) +"번째 주사위: " +dice[i].getRoll()
							+", 간직 여부: "+(chosenDice[i]?"O":"X"));
				}
				if (roll!=2) {//roll=0 or 1, 즉 첫번째와 두번째 던질때만 주사위를 선택해서 간직한다
					for (int i=0; i<5; i++) {
						System.out.print("\t>>>>간직할 주사위 선택(1~5), 선택의끝(0): ");
						int n = scanner.nextInt();
						if (n ==0) break;
						chosenDice[n-1] = true;
					}
				}
		}
		printCategory();
		chooseCategory();
		printCategory();
		}
}
	
	public void printCategory() {
		System.out.println("======================= 점수판 =====================");
		System.out.println("\t\t[[카테고리]]\t\t[[점수]]");
		for (int i=0;i<6; i++) {
			System.out.println("["+(i+1)+"] "+NewConfiguration.getConfigs()[i]+"\t\t\t\t"+ players[0].getScores()[i]);
		}
		System.out.println("    "+NewConfiguration.getConfigs()[6]+"\t\t\t\t"+players[0].getUpperScore());
		System.out.print("    "+NewConfiguration.getConfigs()[7]+"\t\t\t");
		if (players[0].getUpperScore() > 63)
			System.out.println(35);
		else
			System.out.println(0);
		for (int i=0;i<7; i++) {
			System.out.println("["+(i+7)+"] "+NewConfiguration.getConfigs()[i+8]+"\t\t\t"+ players[0].getScores()[i+6]);
		}
		System.out.println("    "+NewConfiguration.getConfigs()[15]+"\t\t\t\t"+players[0].getLowerScore());
		System.out.println("    "+NewConfiguration.getConfigs()[16]+"\t\t\t\t"+players[0].getTotalScore());	
	}

	public void chooseCategory() {
		System.out.println("     ----------------------------");
		System.out.print("     카테고리 선택 (1-13)>>");
		int n = scanner.nextInt();
		players[0].setAtUsed(n, true);
		int score = NewConfiguration.score(n-1, dice);
		players[0].setScore(score, n-1);
	}

	public static void main(String[] args) {
		YahtzeeBoard yb = new YahtzeeBoard();
		yb.run();
	}
}