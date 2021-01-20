package admission;
public class Help 
{ 
	public void display(int rollid,String name,int fee,int balance_fee){
        System.out.println("Roll Id : "+rollid);
        System.out.println("Student name : "+name);
       // System.out.println("The balanced fee to be paid is : "+balance_fee);
        
    }
    public void display_table(int roll_id[],String name[],int fee[],int balance_fee[],String standard[]){
        int i;
        System.out.printf("%10s %15s%20s %13s ", "STUDENT ID", "NAME", "FEE", "CLASS" );
        System.out.println();
        for(i=1;i<25;i++){
            if(balance_fee[i]>0)
            System.out.format("%-20d %-20s %-10d %-10s",roll_id[i],name[i],balance_fee[i],standard[i] );
            System.out.println();
        }
    }
	public void display_paid(int roll_id[],String[] name,int[] fee,int[] balance_fee,String[] standard){
		int i;
        System.out.printf("%10s %15s%20s %13s ", "STUDENT ID", "NAME", "BALANCE FEE", "CLASS" );
        System.out.println();
        for(i=1;i<25;i++){
            if(balance_fee[i]!=fee[i]){
            System.out.format("%-20d %-20s %-10d %-10s",roll_id[i],name[i],balance_fee[i],standard[i] );
            System.out.println();
			}
        }
	}
}
