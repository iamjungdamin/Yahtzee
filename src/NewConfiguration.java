import java.util.Arrays;
public class NewConfiguration {
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
		
			case 6: //ThreeOfKind 다른방법
			      int sum_third = 0;
			         int a_third = 0;
			         for(int k = 1; k <= 6; k++) {
			            int count = 0;
			            for(int i = 0; i < 5; i++) {
			               if(k == d[i].getRoll()) 
			                  count++; 
			               if(count >= 3)
			                  a_third = 1;
			            }
			         }
			         if(a_third == 1)
			            for(int i = 0; i < 5; i++)
			               sum_third += d[i].getRoll();
			         return sum_third;
			         
/*				ThreeOfKind 수정함
				int sumThree = 0;
				
				for (int i=1; i<=6; i++) {
					int countThree = 0;
					for (int j=0; j<5; j++) {
						if (d[j].getRoll() == i)
							countThree++;
					}
					if (countThree > 2) {
						for (int k=0; k<5; k++)
							sumThree += d[k].getRoll();
					}	
					return sumThree;
				}*/
				
			case 7: //FourOfKind 수정함
				int sumFour = 0;
				
				for (int i=1; i<=6; i++) {
					int countFour = 0;
					for (int j=0; j<5; j++) {
						if (d[j].getRoll() == i)
							countFour++;
					}
					if (countFour > 3) {
						for (int k=0; k<5; k++)
							sumFour += d[k].getRoll();
					}	
					return sumFour;
				}
				
			case 8: //풀하우스 경우추가함
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
				else if (d01 == d02 && (d01 == d05 || d03 == d05) && d03 == d04)
					return 25;
				
				else if (d02 == d03 && (d01 == d02 || d04 == d01) && d04 == d05)
					return 25;
				else if (d02 == d04 && (d01 == d02 || d01 == d03) && d03 == d05)
					return 25;
				else if (d02 == d05 && (d01 == d02 || d03 == d01) && d03 == d04)
					return 25;
				else return 0;
				
			case 9: //스몰스트레이트 수정함
				int countS=0;
		        int dS[] = new int[5];
		        for(int i=0;i<5;i++)
		        	dS[i]=d[i].getRoll();
		   
		        Arrays.parallelSort(dS); //오름차순 정렬
		        for(int j=0; j<4; j++)
		        	if(dS[j]+1==dS[j+1])
		        		countS++;
		        if(countS==3 || countS==4)
		        	return 30;
		        else return 0;
				
			case 10: //라지스트레이트 수정함
				int countL=0;
		        int dL[] = new int[5];
		        for(int i=0;i<5;i++)
		        	dL[i]=d[i].getRoll();
		        
		        Arrays.parallelSort(dL);
		        for(int j=0; j<4; j++)
		        	if(dL[j]+1==dL[j+1]) 
		        		countL++;
		        if(countL==4)
		        	return 40;
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
