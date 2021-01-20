package admission;
import java.util.*;
public class  Concession
{
	public void captureConcession(int[] marks,int[] balance_fee,int[] concess,int roll,int[] roll_id,int[] fee){
		Scanner sc=new Scanner(System.in);
		if(roll_id[roll]!=11&&roll_id[roll]!=12){
		System.out.println("The marks he scored in previous term as per records are : "+marks[roll]);
	    System.out.println("If the above marks are wrong please click 1 to change them or 0 to continue");
		//System.out.println();
		if(sc.nextInt()==1){
		    System.out.println("Enter the correct marks : ");
		    int marks1=sc.nextInt();
		    marks[roll]=marks1;
		    int con=concess[roll],con2=0;
		    int con1=delete(marks1);
		    if(con1==1){
		        System.out.println("Student cannot avail anytype of concession with this marks!!!");
		    }
		    else{
		        modify(marks1,fee[roll],roll_id[roll],concess,roll);
		    }
		    if(con1==0){
		        System.out.println("The concession that will be available with new marks is : "+concess[roll]); 
		        balance_fee[roll]-=concess[roll];
		    }
		}
		else{
		    System.out.println("The concession he can avail with these marks are : "+concess[roll]);
		    balance_fee[roll]-=concess[roll];
		}
		}
		else{
			System.out.println("He/She is not applicable for any type of concessions ");
		}
	}
	public int cAvail(int marks,int roll,int fee){
		int con=0;
		if(roll!=11||roll!=12){
		if(marks==100)
			con=(fee*75)/100;
		else if(marks>95)
			con=(fee*70)/100;
		else if(marks>90)
			con=(fee*65)/100;
		else if(marks>85)
			con=(fee*50)/100;
		else if(marks>75)
			con=(fee*35)/100;
		else if(marks>65)
			con=(fee*20)/100;
		else
			con=0;
		}
		return(con);
	}
	public static int delete(int marks){
		if(marks>65)
			return 0;
		else
			return(1);
	}
	public static void modify(int marks,int fee,int id,int[] con1,int i){
				int con=0;
		if(id!=11||id!=12){
		if(marks==100)
			con=(fee*75)/100;
		else if(marks>95)
			con=(fee*70)/100;
		else if(marks>90)
			con=(fee*65)/100;
		else if(marks>85)
			con=(fee*50)/100;
		else if(marks>75)
			con=(fee*35)/100;
		else if(marks>65)
			con=(fee*20)/100;
		else
			con=0;
		}
	con1[i]=con;
	}
}
