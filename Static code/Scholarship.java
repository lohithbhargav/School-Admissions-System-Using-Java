package admission;
import java.util.*;
public class Scholarship 
{
	public void captureScholarship(int[] sports,int[] balance_fee,int[] schol,int roll,int[] roll_id,int[] fee,int[] marks){
		Scanner sc=new Scanner(System.in);
		if(marks[roll]>=74&&roll_id[roll]!=11&&roll_id[roll]!=12){
		    System.out.println("The marks for sports he scored in previous term as per records are : "+sports[roll]);
	        System.out.println("If the above marks are wrong please click 1 to change them or 0 to continue");
		    if(sc.nextInt()==1){
		        System.out.println("Enter the correct marks : ");
		        int marks1=sc.nextInt();
		        sports[roll]=marks1;
		        int scl=schol[roll],scl2=0;
		        int scl1=sdelete(marks1);
		        if(scl1==1){
		            System.out.println("Student cannot avail anytype of Scholarship with this marks!!!");
		        }
		        else{
		            smodify(marks1,fee[roll],roll_id[roll],schol,roll);
		        }
		        if(scl1==0){
		            System.out.println("The scholarship that will be available with new marks is : "+schol[roll]); 
		            balance_fee[roll]-=schol[roll];
		        }
		    }
		    else{
		        System.out.println("The Scholarship he can avail with these marks are : "+schol[roll]);
		        balance_fee[roll]-=schol[roll];
		    }
		}	
		else if(marks[roll]<75){
			System.out.println("Since his marks are less than 75 he cannot avail any type of Scholarship!!!");
		}
		else if(roll_id[roll]==11||roll_id[roll]==12){
			System.out.println("He/She are not applicable to any type of Scholarship");
		}
	}
		public int sAvail(int sports,int roll,int fee){
		int scl=0;
		if(roll!=11||roll!=12){
		if(sports>95)
			scl=(fee*25)/100;
		else if(sports>85)
			scl=(fee*15)/100;
		else if(sports>75)
			scl=(fee*10)/100;
		else
			scl=0;
		}
		return(scl);
	}
	public static int sdelete(int sports){
		if(sports>75)
			return 0;
		else
			return(1);
	}
	public static void smodify(int sports,int fee,int id,int[] scl1,int i){
				int scl=0;
		if(id!=11||id!=12){
		if(sports>95)
			scl=(fee*25)/100;
		else if(sports>85)
			scl=(fee*15)/100;
		else if(sports>75)
			scl=(fee*10)/100;
		else
			scl=0;
		}
	scl1[i]=scl;
	}
}
