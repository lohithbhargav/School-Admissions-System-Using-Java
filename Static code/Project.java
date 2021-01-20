import admission.Scholarship;
import admission.Concession;
import admission.Help;
import java.util.*;
class Project{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
		Help h=new Help();
		Concession co=new Concession();
		Scholarship s=new Scholarship();
        String[] name={null,"Mounisha","Lahari","Mihir","Vamsi","Bharadwaj","Vinay","Rohit","Ashish","Snehith","Amaresh","Ramya","Sahiti","Ramesh","Pavan",
			"Teja","Manikanta","Sairam","Vatsav","Rishi","Akshay","Sathwik","Tony","Sravan","Sampath"};
        int[] fee={0,6000,6000,6500,6500,7000,7000,7500,7500,8000,8000,8500,8500,9000,9000,11000,11000,13000,13000,14000,14000,15000,15000,18000,18000};
        int[] roll_id={0,11,12,21,22,101,102,201,202,301,302,401,402,501,502,601,602,701,702,801,802,901,902,1001,1002};
        String[] standard={null,"LKG","LKG","UKG","UKG","1st class","1st class","2nd class","2nd class","3rd class","3rd class","4th class","4th class",
			"5th class","5th class","6th class","6th class","7th class","7th class","8th class","8th class","9th class","9th class","10th class","10th class"};
        int roll=0,c=0,d=0;
        int[] balance_fee={0,6000,6000,6500,6500,7000,7000,7500,7500,8000,8000,8500,8500,9000,9000,11000,11000,13000,13000,14000,14000,15000,15000,18000,18000};
        int[] marks={0,0,0,80,89,75,79,95,99,92,82,96,85,62,68,59,73,78,100,88,99,95,86,100,45};
		int[] sports={0,0,0,90,95,80,85,82,75,78,89,65,73,99,96,54,86,76,60,78,45,58,76,73,96};
		int[] concess=new int[25];
		int[] schol=new int[25];
		int[] check=new int[25];
        int i;
		for(i=0;i<25;i++){
			concess[i]=co.cAvail(marks[i],roll_id[i],fee[i]);
			schol[i]=s.sAvail(marks[i],roll_id[i],fee[i]);
			check[i]=0;
		}
		System.out.println();
		System.out.println("Welcome to Koneru Lakshmaiah Central School ");
		System.out.println("-------------------------------------------");
		System.out.println("Press 1 to enter into fee section and 0 to exit : ");
		d=sc.nextInt();int e=0,choice=2;
        while(d==1){
            c=0;
			if(e!=0){
				System.out.print("Press 1 to view the students who paid fee and 2 to pay for another student : ");
				choice=sc.nextInt();
			}
			if(choice==1){
				h.display_paid(roll_id,name,fee,balance_fee,standard);
			}
			e=1;
			if(choice==2){
				System.out.println("Students yet to pay the fee and the balance fee: ");
				h.display_table(roll_id,name,fee,balance_fee,standard);
				System.out.println("Enter the student Roll Number : ");
				int num=sc.nextInt();
				System.out.println("Enter the student Name : ");
				String nam=sc.next();
				for(i=1;i<25;i++){
				    if(roll_id[i]==num){
				        c=1;
					    roll=i;
					    break;
					}
				}
				if(balance_fee[roll]<0)
					balance_fee[roll]=0;
				if(c==1&&name[roll].equalsIgnoreCase(nam)){
					if(balance_fee[roll]==0)
						System.out.println("The fee is fully paid!!!!!");
					else{
						System.out.println("Details of the Student  are : ");
						h.display(roll_id[roll],name[roll],fee[roll],balance_fee[roll]);
						if(check[roll]!=1){
							co.captureConcession(marks,balance_fee,concess,roll,roll_id,fee);
							check[roll]=1;
							s.captureScholarship(sports,balance_fee,schol,roll,roll_id,fee,marks);
						}
						else{
							System.out.println("The concessions and scholarships are already given!!!");
						}
						System.out.println("The Balance fee is  : "+balance_fee[roll]);
						System.out.print("Now Please enter the money that has been paid : ");
						int paid=sc.nextInt();
						balance_fee[roll]-=paid;
						if(balance_fee[roll]<=0)
							System.out.println("the Student "+name[roll]+" fee is completely paid ");
						else
							System.out.println("the fee yet to be paid for student "+name[roll]+" is "+balance_fee[roll]);
					}
				}
				else{
					System.out.println("Invalid details !!!!!  Do you want to try again ??");
				}
				System.out.print("Press 1 to continue and 2 to exit : "); 
				int a=sc.nextInt();
				if(a==2)
				break;
			}
		}
	}
 }