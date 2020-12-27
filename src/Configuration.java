/*
public class Configuration {
	private static String[] configs = {"Ones","Twos","Threes","Fours","Fives","Sixes",
			"Upper Score","Upper Bonus(35)","Three of a Kind","Four of a Kind","Full House(25)",
			"Small Straight(30)","Large Straight(40)","Yahtzee(50)", "Chance\t","Lower Score","Total"};

	public static String[] getConfigs() {
		return configs;
	}
	
	public static int score(int row, Dice[] d) {
		switch (row) {
			case 0: case 1: case 2: case 3: case 4: case 5: //1~6
				int sum = 0;
				for (int i=0; i<5; i++)
					if (d[i].getRoll() == (row+1))
						sum += row+1;
				return sum;
		
			case 6: //3개
				int count6 = 1;
				int tmp6 = 0;
				for (int i=1; i<6; i++)
					if (d[i].getRoll() == d[i+1].getRoll()) {
						count6++;
						tmp6 = d[i].getRoll();
					}
				if (count6 > 2) //3개있으면
					return tmp6 * 3;
				else return 0;
				
			case 7: //4개
				int count7 = 1;
				int tmp7 = 0;
				for (int i=1; i<6; i++)
					if (d[i].getRoll() == d[i+1].getRoll()) {
						count7++;
						tmp7 = d[i].getRoll();
					}
				if (count7 > 3) //4개있으면
					return tmp7 * 4;
				else return 0;
				
			case 8: //풀하우스
				int d01 = d[0].getRoll();
				int d02 = d[1].getRoll();
				int d03 = d[2].getRoll();
				int d04 = d[3].getRoll();
				int d05 = d[4].getRoll();
				
				if (d01 == d02 && (d02 == d03 || d03 == d04) && d04 == d05)
					return 25;
				else if (d01 == d03 && (d01 == d02 || d04 == d02) && d04 == d05)
					return 25;
				else if (d01 == d04 && (d01 == d02 || d02 == d03) && d03 == d05)
					return 25;
				else if (d01 == d05 && (d01 == d02 || d03 == d02) && d03 == d04)
					return 25;
				else return 0;				
				
			case 9: //스몰스트레이트
				int d1 = d[0].getRoll();
				int d2 = d[1].getRoll();
				int d3 = d[2].getRoll();
				int d4 = d[3].getRoll();
				int d5 = d[4].getRoll();
				
				if ( (d1 ==1 && d2 ==2 && d3 ==3 && d4 ==4) ||
					 (d1 ==2 && d2 ==3 && d3 ==4 && d4 ==5) ||
					 (d1 ==3 && d2 ==4 && d3 ==5 && d4 ==6) )
					return 30; //1234 나오는경우
				
				if ( (d1 ==2 && d2 ==3 && d3 ==4 && d4 ==5) ||
					 (d1 ==3 && d2 ==4 && d3 ==5 && d4 ==2) ||
					 (d1 ==4 && d2 ==5 && d3 ==2 && d4 ==3) )
					return 30; //2345 나오는경우
				
				if ( (d1 ==3 && d2 ==4 && d3 ==5 && d4 ==6) ||
					 (d1 ==4 && d2 ==5 && d3 ==6 && d4 ==3) ||
					 (d1 ==5 && d2 ==6 && d3 ==3 && d4 ==4) )
					return 30; //3456 나오는경우
				
				else return 0;
				
			case 10: //라지스트레이트
				int D1 = d[0].getRoll();
				int D2 = d[1].getRoll();
				int D3 = d[2].getRoll();
				int D4 = d[3].getRoll();
				int D5 = d[4].getRoll();
				
				if ( (D1 ==1 && D2 ==2 && D3 ==3 && D4 ==4 && D5 ==5) ||
					 (D1 ==2 && D2 ==3 && D3 ==4 && D4 ==5 && D5 ==1) ||
					 (D1 ==3 && D2 ==4 && D3 ==5 && D4 ==1 && D5 ==2) ||
					 (D1 ==4 && D2 ==5 && D3 ==1 && D4 ==2 && D5 ==3) ||
					 (D1 ==5 && D2 ==6 && D3 ==2 && D4 ==3 && D5 ==4) )
					return 40; //12345 나오는경우
				
				if ( (D1 ==2 && D2 ==3 && D3 ==4 && D4 ==5 && D5 ==6) ||
					 (D1 ==3 && D2 ==4 && D3 ==5 && D4 ==6 && D5 ==2) ||
					 (D1 ==4 && D2 ==5 && D3 ==6 && D4 ==2 && D5 ==3) ||
					 (D1 ==5 && D2 ==6 && D3 ==2 && D4 ==3 && D5 ==4) ||
					 (D1 ==6 && D2 ==2 && D3 ==3 && D4 ==4 && D5 ==5) )
					return 40; //23456 나오는경우
				
				else return 0;
				
			case 11: //얏찌
				for (int i=1; i<6; i++)
					if (d[i].getRoll() == d[i-1].getRoll())
						return 50;
					else return 0;
				
			case 12: //찬스
				int sum12 = 0;
				for (int i=0; i<5; i++)
					sum12 += d[i].getRoll();
				return sum12;
				
			default:
				return 0;
		}

	}

}
*/