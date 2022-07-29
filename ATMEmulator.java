import java.util.*;

class ATMEmulator
{
	public static void clearScreen()			//Method for clearing Screen
	{
		try
		{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			System.out.print("\n\n\n\t\t");
		}
		catch(Exception e){}
	}
	static ArrayList<Integer> atm_no=new ArrayList<Integer>();
	static ArrayList<Integer> atm_pin=new ArrayList<Integer>();
	static ArrayList<Long> acc_no=new ArrayList<Long>();
	static ArrayList<String> name=new ArrayList<String>();
	static ArrayList<String> acc_type=new ArrayList<String>();
	static ArrayList<Integer> total=new ArrayList<Integer>();

public static void main(String[] arg)
{
	atm_no.add(652487126);	atm_no.add(652556458);		// atm_no
	atm_no.add(985142367);	atm_no.add(524225103);
	atm_no.add(825067142);	atm_no.add(753159846);
	atm_no.add(569020136);	atm_no.add(915304268);
	atm_no.add(761442550);	atm_no.add(988540561);

	atm_pin.add(atm_no.indexOf(652487126),1204);	atm_pin.add(atm_no.indexOf(652556458),4862);	// atm_pin
	atm_pin.add(atm_no.indexOf(985142367),4025);	atm_pin.add(atm_no.indexOf(524225103),4596);
	atm_pin.add(atm_no.indexOf(825067142),6015);	atm_pin.add(atm_no.indexOf(753159846),1204);
	atm_pin.add(atm_no.indexOf(569020136),4862);	atm_pin.add(atm_no.indexOf(915304268),5463);
	atm_pin.add(atm_no.indexOf(761442550),5463);	atm_pin.add(atm_no.indexOf(988540561),9585);

	name.add(atm_no.indexOf(652487126),"Amit Rao");	name.add(atm_no.indexOf(652556458),"Nitish");	// name
	name.add(atm_no.indexOf(985142367),"Kunal");	name.add(atm_no.indexOf(524225103),"Alia Kumari");
	name.add(atm_no.indexOf(825067142),"Priyanka");	name.add(atm_no.indexOf(753159846),"Kunal");
	name.add(atm_no.indexOf(569020136),"Priya");	name.add(atm_no.indexOf(915304268),"Alia");
	name.add(atm_no.indexOf(761442550),"Rani");	name.add(atm_no.indexOf(988540561),"Santosh");

	acc_no.add(atm_no.indexOf(652487126),652236574581l);	acc_no.add(atm_no.indexOf(652556458),485213250475l);//acc_no
	acc_no.add(atm_no.indexOf(985142367),754215602058l);	acc_no.add(atm_no.indexOf(524225103),420152036587l);
	acc_no.add(atm_no.indexOf(825067142),425603258410l);	acc_no.add(atm_no.indexOf(753159846),625325632145l);
	acc_no.add(atm_no.indexOf(569020136),410258963074l);	acc_no.add(atm_no.indexOf(915304268),902458796325l);
	acc_no.add(atm_no.indexOf(761442550),140257862035l);	acc_no.add(atm_no.indexOf(988540561),758964123046l);

	acc_type.add(atm_no.indexOf(652487126),"Saving Account");	acc_type.add(atm_no.indexOf(652556458),"Current Account");//acc_type
	acc_type.add(atm_no.indexOf(985142367),"Current Account");	acc_type.add(atm_no.indexOf(524225103),"Current Account");
	acc_type.add(atm_no.indexOf(825067142),"Saving Account");	acc_type.add(atm_no.indexOf(753159846),"Saving Account");
	acc_type.add(atm_no.indexOf(569020136),"Current Account");	acc_type.add(atm_no.indexOf(915304268),"Saving Account");
	acc_type.add(atm_no.indexOf(761442550),"Saving Account");	acc_type.add(atm_no.indexOf(988540561),"Current Account");

	total.add(atm_no.indexOf(652487126),75000);	total.add(atm_no.indexOf(652556458),150000);// total
	total.add(atm_no.indexOf(985142367),55000);	total.add(atm_no.indexOf(524225103),45000);
	total.add(atm_no.indexOf(825067142),79999);	total.add(atm_no.indexOf(753159846),65000);
	total.add(atm_no.indexOf(569020136),74561);	total.add(atm_no.indexOf(915304268),8999);
	total.add(atm_no.indexOf(761442550),99999);	total.add(atm_no.indexOf(988540561),225000); 
	

	
while (true)
  {
  try
    {
	clearScreen();
	WelcomeScreen();				// Welcome Screen
	Thread.sleep(3000);
	boolean firstScr=true;
while (firstScr)
 {
	clearScreen();
	Scanner sc=new Scanner(System.in);
	Screen("Enter ATM Number\n\t\t-");		//ATM Number Screen
	int atmno=sc.nextInt();
	clearScreen();
	if(atm_no.contains(atmno))
	{
		Screen("Enter PIN\n\t\t-");			//ATM PIN Screen
		String p=new String(System.console().readPassword());
		int pin=Integer.parseInt(p);
		clearScreen();
	if (atm_pin.get(atm_no.indexOf(atmno))==pin)		//if atm_no and pin are correct
	{
		Screen("\rHello "+name.get(atm_no.indexOf(atmno))+"\n\n\t\t");
		Screen(new String[]{"Press 1 for WITHDRAW.","Press 2 for DEPOSIT.","Press 3 for MINI STATEMENT.","Press 4 for RESET PIN.","Press 5 to EXIT."});
		System.out.print("\n\t\tEnter Response: ");
		byte res=sc.nextByte();
		clearScreen();
		switch(res)
		{
		case 1:
			withdraw(atmno);				//withdraw function called
			firstScr=false;
			break;
		case 2:
			deposit(atmno);					//deposit function called
			firstScr=false;
			break;
		case 3:
			ministmt(atmno);				//ministmt function called
			break;
		case 4:
			rstpin(atmno);					//rstpin function called
			break;					
		case 5:
			firstScr=false;
			break;
		default:System.out.print("Enter Valid Option.");Thread.sleep(1500);
		}
	
	}
	else
	{
		clearScreen();
		System.out.print("You Have Entered Wrong PIN.");
		Thread.sleep(1500);
	}	
	}
	else
	{
		clearScreen();
		System.out.print("You Have Entered Wrong ATM Number.");
		Thread.sleep(1500);
	}
 }									//inner while end
    }									//Outer try block
catch(Exception e){}							


  }									//outer while end

}

static void WelcomeScreen() throws Exception		
{
	System.out.println("************************************************************");Thread.sleep(150);
	System.out.println("\t\t*  ******************************************************  *");Thread.sleep(125);
	System.out.println("\t\t* ::     :: ::::::: ::     ::::::  ::::  :::: :::: ::::::: *");Thread.sleep(100);
	System.out.println("\t\t* ::     :: ::      ::     ::     ::  :: :: ::: :: ::      *");Thread.sleep(75);
	System.out.println("\t\t* ::  .  :: :::::   ::     ::     ::  :: ::  :  :: :::::   *");Thread.sleep(65);
	System.out.println("\t\t* :: ::: :: ::      ::     ::     ::  :: ::     :: ::      *");Thread.sleep(55);
	System.out.println("\t\t* :::: :::: ::::::: :::::: ::::::  ::::  ::     :: ::::::: *");Thread.sleep(45);
	System.out.println("\t\t*  ******************************************************  *");Thread.sleep(40);
	System.out.println("\t\t************************************************************");Thread.sleep(30);
}

static void Screen(String Mess) throws Exception
{
	for(int i=0;i<Mess.length();i++)
	{
		System.out.print(Mess.charAt(i));Thread.sleep(76);
	}
}

static void Screen(String[] Mess) throws Exception
{	
	for(String i : Mess)
	{
		Thread.sleep(150);
		System.out.print(i+"\n\t\t");
	}
}

static void withdraw(int atmno) throws Exception
{
	Scanner in=new Scanner(System.in);
	boolean proceed=false;
	Screen("Select Account Type:\n\n\t\t");
	Screen(new String[]{"Press 1 for SAVING ACCOUNT","Press 2 for CURRENT ACCOUNT"});
	System.out.print("\n\t\tEnter Response: ");
	byte res=in.nextByte();
	switch(res)
	{
	case 1:
		if (acc_type.get(atm_no.indexOf(atmno)).equalsIgnoreCase("Saving Account"))
			proceed=true;
		break;
	case 2:
		if (acc_type.get(atm_no.indexOf(atmno)).equalsIgnoreCase("Current Account"))
			proceed=true;
		break;
	default:
		clearScreen();
		System.out.print("Choose Valid Option");Thread.sleep(1500);
	}
	if (proceed)
	{
		clearScreen();
		int inac=total.get(atm_no.indexOf(atmno));
		Screen("Enter Amount: ");
		int amt=in.nextInt();
		if (inac>=amt)
		{
			clearScreen();
			Screen("Please Collect Your Money.");
			inac-=amt;
			total.set(atm_no.indexOf(atmno),inac);
			Thread.sleep(1500);
			clearScreen();
			Screen("Thank-You for Visiting.");
			Thread.sleep(1500);
			
		}
		else
		{
			clearScreen();
			System.out.print("Insufficient Balance.");
			Thread.sleep(1500);
			clearScreen();
			Screen("Thank-You for Visiting.");
			Thread.sleep(1500);
			
		}	
	}
	else
	{
		clearScreen();
		System.out.print("Wrong Account Type Selected Selected.");
		Thread.sleep(1500);
	}
}

static void deposit(int atmno) throws Exception
{
	Scanner in=new Scanner(System.in);
	boolean proceed=false;
	Screen("Select Account Type:\n\n\t\t");
	Screen(new String[]{"Press 1 for SAVING ACCOUNT","Press 2 for CURRENT ACCOUNT"});
	System.out.print("\n\t\tEnter Response: ");
	byte res=in.nextByte();
	switch(res)
	{
	case 1:
		if (acc_type.get(atm_no.indexOf(atmno)).equalsIgnoreCase("Saving Account"))
			proceed=true;
		break;
	case 2:
		if (acc_type.get(atm_no.indexOf(atmno)).equalsIgnoreCase("Current Account"))
			proceed=true;
		break;
	default:
		clearScreen();
		System.out.print("Choose Valid Option");Thread.sleep(1500);
	}
	if (proceed)
	{
		clearScreen();
		int inac=total.get(atm_no.indexOf(atmno));
		Screen("Enter Amount: ");
		int amt=in.nextInt();
		clearScreen();
		Screen("Money Deposited.");
		inac+=amt;
		total.set(atm_no.indexOf(atmno),inac);
		Thread.sleep(1500);
		clearScreen();
		Screen("Thank-You for Visiting.");
		Thread.sleep(1500);	
	}
	else
	{
		clearScreen();
		System.out.print("Wrong Account Type Selected Selected.");
		Thread.sleep(1500);
	}
}

static void ministmt(int atmno) throws Exception
{
	System.out.println("\rName-"+name.get(atm_no.indexOf(atmno)));Thread.sleep(750);
	System.out.println("\t\tAccount Number-"+acc_no.get(atm_no.indexOf(atmno)));Thread.sleep(750);
	System.out.println("\t\tAccount Type-"+acc_type.get(atm_no.indexOf(atmno)));Thread.sleep(750);
	System.out.println("\t\tTotal Balance-"+total.get(atm_no.indexOf(atmno)));
	Screen("\nPress Enter When You are Done.");
	new Scanner(System.in).nextLine();
}
static void rstpin(int atmno) throws Exception
{
while (true)
{
	Scanner sc=new Scanner(System.in);
	int cpin=atm_pin.get(atm_no.indexOf(atmno));
	Screen("Enter OLD PIN: ");
	int opin=sc.nextInt();
	Screen("\t\tEnter NEW PIN: ");
	int npin=sc.nextInt();
	Screen("\t\tConfirm NEW PIN: ");
	int cnpin=sc.nextInt();
	if (cpin==opin)
	{
		if (npin==cnpin)
		{
			atm_pin.set(atm_no.indexOf(atmno),npin);
			clearScreen();
			Screen("PIN changed Successsfully.");
			Thread.sleep(1500);
			break;
		}
		else
		{
			clearScreen();
			System.out.print("You have Entered Wrong CONFIRMATION PIN.");
			Thread.sleep(1500);
			clearScreen();
		}
	}
	else
	{
		clearScreen();
		System.out.print("You have Entered Wrong OLD PIN.");
		Thread.sleep(1500);
		clearScreen();
	}	
}	
}

	
}




