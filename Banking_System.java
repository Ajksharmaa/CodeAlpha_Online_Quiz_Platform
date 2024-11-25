
import java.util.*;
import java.util.Map.Entry;

public class Banking_System extends Option{
	
	
	public static void main(String args[])throws Exception{
		Option ob=new Option();
		ob.login();
	}
	
}
class Option extends Methods{
	Scanner sc=new Scanner(System.in);
	HashMap<Integer,Integer> map=new HashMap<>();
	public Option() {
        map.put(001, 5678);
        map.put(002, 1234);
    }
	public void login()throws Exception {
		
		int x=1;
		boolean newuser=false;
		do {
			System.out.println("--------------------------------");
			System.out.print("Are you a new user? (true or false):  ");
            
			newuser=sc.nextBoolean();
			
			if(newuser==true) {
                System.out.println();
				System.out.print("Enter user number: ");
				int usernumber=sc.nextInt();
				
				System.out.print("Enter your user pin: ");
				int userpin=sc.nextInt();
				map.put(usernumber,userpin);
			}
			try {
				
				System.out.println();
                System.out.println("---------------------------");
				System.out.println("Welcome to my banking system ");
                System.out.println();
				System.out.print("Enter your number: ");
				setUserNumber(sc.nextInt());
				
				System.out.print("Enter your pin: ");
				setUserPin(sc.nextInt());
				
			}
			catch(Exception e) {
				System.out.println("Invalid ");
				x=2;
			}
			Iterator<Entry<Integer,Integer>> itr=map.entrySet().iterator();
			while(itr.hasNext()){
			Entry<Integer,Integer> entry=itr.next();
			if(entry.getKey()==getUserNumber() && entry.getValue()==getUserPin()) {
				getOperation();
			}
			
			
		}
	}while(x==1);
	}
	public void getOperation() {
		Scanner sc=new Scanner(System.in);
		System.out.print("\nChoices : ");
		System.out.print("\n1. View Balance ");
		System.out.print("\n2. Withdraw ");
		System.out.print("\n3. Deposite ");
		System.out.print("\n4. Exit :");
		System.out.print("\nEnter your choice :");
		
		int opr=sc.nextInt();
		switch(opr) {
		case 1:
            System.out.println("---------------------------");
			System.out.println("Balance: "+ getBalance());
			System.out.println("---------------------------");
			getOperation();
			break;
		case 2:
			Withdraw();
			getOperation();
			break;
		case 3:
			Deposite();
			getOperation();
			break;
		case 4:
			System.out.println();
			System.out.println("Thank you for using my banking system , Have a good day ");
			System.out.println("---------------------------------------------");
			break;
		default :
			System.out.println("Invalid choice : ");
			getOperation();
			
		}
	}
	
}
class Methods{
	private int UserNumber;
	private int pin;
	private double balance=0;
	Scanner sc=new Scanner(System.in);
	public int setUserNumber(int UserNumber) {
		this.UserNumber=UserNumber;
		return UserNumber;
	}
	public int setUserPin(int pin) {
		this.pin=pin;
		return pin;
	}
	public int getUserNumber() {
		return UserNumber;
	}
	public int getUserPin() {
		return pin;
	}
	public double getBalance() {
		return balance;
	}
	public double calWithdraw(double Amount) {
		balance=(balance - Amount);
		return balance;
	}
	public double calDeposite(double Amount) {
		balance=(balance + Amount);
		return balance;
	}
	public void Withdraw() {
		Scanner sc=new Scanner(System.in);
        System.out.print("---------------------------");
		System.out.print("\nYour current balance : "+ balance);
        System.out.println();
		System.out.print("\nEnter Amount : ");
		double Amount=sc.nextDouble();
		
		if((balance - Amount)>0) {
			calWithdraw(Amount);
			System.out.println("Money withdrawed successfully ");
			System.out.println("---------------------------");
		}
		else {
			System.out.println("\nNo enough funds \n");
			System.out.println("---------------------------");
		}
	}
	public void Deposite() {
		Scanner sc=new Scanner(System.in);
        System.out.println("---------------------------");
		System.out.print("Your current balance : "+ balance);
        System.out.println();
		System.out.print("\nEnter Amount : ");
		double Amount=sc.nextDouble();
		
		if((balance + Amount)>0) {
			calDeposite(Amount);
			System.out.println("Money deposited successfully ");
			System.out.println("---------------------------");
		}
		else {
			System.out.println("\nBalance can not be negative \n");
			System.out.println("---------------------------");
		}
		
	}
	
}
