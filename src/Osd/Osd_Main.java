/*
 * -------------------------------------------------------------------
 * Project Title: CPU Architecture
   Course : CS 6560
   Name and Net id of the Group Members
   1) Binita Ghodasara, rt7778   	 
   2) Unmesh Suryawanshi, qd6395
   -------------------------------------------------------------------
 * Description:
 * OSD_Main.java : Performing all cycles for the given commands
 * AM_OP.java    : Declaration of Addressing mode and opcode
 * AM_Data.java  : Checking for instruction format
 * Reg_Data.java : Declaration of flags, clock pulses & RAM Data
 * ------------------------------------------------------------------
 */
package Osd;

// Declaration of predefined packages
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;
import pkg.*;

// Main class
public class Osd_Main
{
	//declaration of variables
	static int max=100;
	static Integer pc=0;
	static Integer RAM=0;
	static Integer temp2=0;
	static Reg_Data MBR = new Reg_Data();
	static ArrayList<Integer> R1 = new ArrayList<Integer>();
	static ArrayList<Integer> R2 = new ArrayList<Integer>();
	static ArrayList<Integer> R3 = new ArrayList<Integer>();
	static Scanner sc= new Scanner(System.in);
	
	// Putting random data in RAM
	public static void main(String[]args)
	{
		for(int i=0; i<max; i++)
		{
			R3.add(i+2);
		}
		
		// Display the RAM data
		System.out.println("---------------------------------------------------------------------------- ");
		System.out.println(" \t\t\t RAM Data: ");
		System.out.println("---------------------------------------------------------------------------- ");
		
		for(int i=0;i<R3.size()/10;i++)
		{
			for(int j=0;j<10;j++){
				System.out.print(j*10+i +" - "+R3.get(j*10+i)+"\t");
			}
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------------- ");
		
		Stack<Reg_Data> instr_data = new Stack<Reg_Data>();
		
		// Input: instructions 
		instr_data.add(new Reg_Data("0100", 11, 24, 2, 0));
		instr_data.add(new Reg_Data("1000", 22, 24, 2, 0));
		instr_data.add(new Reg_Data("0001", 33, 24, 2, 0));
		instr_data.add(new Reg_Data("0000", 44, 24, 2, 0));
		System.out.println(" Program started..! ");
		
		// Fetching instructions one by one
		int tmp = instr_data.size();
		for(int i=0; i<tmp; i++)
		{	
			sc.nextLine();
			System.out.println(" Instruction no. "+(i+1)+" Started");
			fetch(instr_data,i);
			System.out.println(" Press any Key to continue......! ");
			
		}
		
		System.out.println(" End of the Program! ");
	}
	
// method for fetch operation
	private static void fetch(Stack<Reg_Data> instr_data, int i) 
	{
		RAM=i;
		
		System.out.println(" Starting of Fetch Cycle...! ");
		System.out.println(" Flag 1 Value : "+MBR.isflag_1()+" and Flag Value 2: "+MBR.isflag_2());
		MBR.setT1(true);
		MBR.setT4(false);
		System.out.println(" Clock Values at first clock pulse: ");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
			
		if(MBR.isflag_1()==false &&MBR.isflag_2()==false && MBR.isT1()==true)
		{
			RAM=pc;
			temp2=RAM;
		}
		MBR.setT1(false);
		MBR.setT2(true);
		
		System.out.println(" Clock Values at second clock pulse:");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
			
		if(MBR.isflag_1()==false && MBR.isflag_2()==false &&MBR.isT2() ==true)
		{
			int temp=instr_data.get(RAM).getRAM3();
			MBR.setRAM3(R3.get(temp));
			
			pc=pc +1;
			System.out.println(" MBR Value : "+MBR.getRAM3());
			MBR.setflag_1(instr_data.get(RAM).isflag_1());
			MBR.setflag_2(instr_data.get(RAM).isflag_2());
			MBR.setT1(instr_data.get(RAM).isT1());
			MBR.setT2(instr_data.get(RAM).isT2());
			MBR.setT3(instr_data.get(RAM).isT3());
			MBR.setT4(instr_data.get(RAM).isT4());
			MBR.setT2(false);
			MBR.setT3(true);
		}
		System.out.println(" Clock Values at third clock pulse: ");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
			
		if(MBR.isflag_1()==false && MBR.isflag_2()==false &&MBR.isT3() ==true)
		{
			MBR.setAddress(instr_data.get(RAM).getAddress());
			MBR.setOpcode(instr_data.get(RAM).getOpcode());
			MBR.setRAM1(instr_data.get(RAM).getRAM1());
			MBR.setRAM2(instr_data.get(RAM).getRAM2());
			System.out.println(" Addressing Mode Value: "+ MBR.getAddress());
			System.out.println(" Source Regi. Value: "+MBR.getRAM1());
			System.out.println(" Desti. Regi. Value: "+MBR.getRAM2());
			System.out.println(" Opcode Value: "+MBR.getOpcode());
			
			MBR.setT3(false);
			MBR.setT4(true);
		}
	
		System.out.println(" Clock Values at fourth clock pulse: : ");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
		System.out.println(" Ending of Fetch Cycle....! ");
		
		if(MBR.isT4()==true)
		{
			// checking conditions for Addressing mode : 0100 i.e. Indirect
			if(MBR.getAddress().equalsIgnoreCase("0100"))
			{	
				MBR.setflag_2(true);
				MBR.setT4(false);
				System.out.println(" Given addressing mode is Indirect ("+MBR.getAddress() +") \n Next Cycle will be Fetch Operand ");
				fetchoperand(MBR ,instr_data, RAM,temp2);
				}
			
			// checking conditions for Addressing mode : 1000 i.e. Direct
			else if(MBR.getAddress().equalsIgnoreCase("1000"))
			{
				MBR.setflag_1(true);
				MBR.setT4(false);
				System.out.println(" Given addressing mode is Direct ("+MBR.getAddress() +") \n Next Cycle will be Execution ");
				executecycle(MBR ,instr_data, RAM, temp2);
				}
			
			// checking conditions for Addressing mode : 0001 i.e. Immediate
			else if(MBR.getAddress().equalsIgnoreCase("0001"))
			{
				MBR.setflag_1(true);
				MBR.setT4(false);
				System.out.println(" Given addressing mode is Immediate ("+MBR.getAddress() +") \n Next Cycle will be Execution ");
				;
				executecycle(MBR ,instr_data, RAM,temp2);
			}
			
			// checking conditions for Addressing mode : 0001 i.e. Register
			else if(MBR.getAddress().equalsIgnoreCase("0000"))
			{
				MBR.setflag_1(true);
				MBR.setT4(false);
				System.out.println(" Given addressing mode is Register ("+MBR.getAddress() +") \n Next Cycle will be Execution ");
			
				executecycle(MBR ,instr_data, RAM,temp2);
			}
		}	
	}

// method for fetch operand
	private static void fetchoperand(Reg_Data mBR2,
	Stack<Reg_Data> instr_data, Integer mAR2, Integer location2) 
	{
		System.out.println("---------------------------------------------------------------------------- ");
		System.out.println(" Starting of Fetch Operand cycle...! ");
		System.out.println(" Flag 1 Value :"+mBR2.isflag_1()+" and Flag Value 2: "+mBR2.isflag_2());
		
		MBR.setT1(true);
		//System.out.println("T1 Value:"+ MBR.isT1()+"T2 Value:"+ MBR.isT2()+"T3 Value:"+ MBR.isT2()+"T4 Value:"+ MBR.isT4());
		System.out.println(" Clock Values at first clock pulse: ");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
		
		int temp =0;
		if(MBR.isflag_1()==false &&MBR.isflag_2()==true && MBR.isT1()==true)
		{
			temp =mBR2.getRAM3();
			RAM=temp;
		}
	
		MBR.setT1(false);
		MBR.setT2(true);
		System.out.println(" Clock Values at second clock pulse: ");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
		
		if(MBR.isflag_1()==false && MBR.isflag_2()==true &&MBR.isT2() ==true)
		{
			MBR.setRAM3(R3.get(temp));
			System.out.println(" MBR Value : "+MBR.getRAM3());
			MBR.setT2(false);
			MBR.setT4(true);
		}
		System.out.println(" No execution at third clock pulse..! ");
		
		if(MBR.isT4()==true)
		{
			{	
				MBR.setflag_1(true);
				MBR.setflag_2(false);
				System.out.println(" Clock Values at fourth clock pulse: ");
				System.out.println(" T1: "+ MBR.isT1());
				System.out.println(" T2: "+ MBR.isT2());
				System.out.println(" T3: "+ MBR.isT3());
				System.out.println(" T4: "+ MBR.isT4());
				MBR.setT4(false);
				System.out.println(" Ending of Fetch operand cycle..! ");
				System.out.println(" Next Cycle will be Execution ");
				executecycle(MBR ,instr_data, RAM,location2);
			}
		}
		
	}

// method for execute cycle
	private static void executecycle(Reg_Data mBR2,
	Stack<Reg_Data> instr_data, Integer mAR2, Integer location2)
	{
		System.out.println("---------------------------------------------------------------------------- ");
		System.out.println(" Starting of Execution Cycle ");
		System.out.println(" Flag 1 Value :"+MBR.isflag_1()+" and Flag Value 2: "+MBR.isflag_2());
		MBR.setT1(true);
		int temp =0;
		
		System.out.println(" Clock Values at first clock pulse: ");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
		if(MBR.isflag_1()==true &&MBR.isflag_2()==false && MBR.isT1()==true && !MBR.getAddress().equalsIgnoreCase("0001"))
		{
			temp =MBR.getRAM3();
			RAM=temp;
		
		}
		MBR.setT1(false);
		MBR.setT2(true);
		
		
		if(MBR.isflag_1()==true && MBR.isflag_2()==false &&MBR.isT2() ==true&& !MBR.getAddress().equalsIgnoreCase("0001"))
		{
			mBR2.setRAM3(R3.get(temp));
		
			System.out.println(" MBR Value : "+mBR2.getRAM3());
			System.out.println(" Clock Values at second clock pulse: ");
			System.out.println(" T1: "+ MBR.isT1());
			System.out.println(" T2: "+ MBR.isT2());
			System.out.println(" T3: "+ MBR.isT3());
			System.out.println(" T4: "+ MBR.isT4());
			mBR2.setT2(false);
		}
		
		
		mBR2.setT3(true);
		System.out.println(" Clock Values at third clock pulse: ");
		System.out.println(" T1: "+ MBR.isT1());
		System.out.println(" T2: "+ MBR.isT2());
		System.out.println(" T3: "+ MBR.isT3());
		System.out.println(" T4: "+ MBR.isT4());
		if(MBR.isflag_1()==true && MBR.isflag_2()==false &&MBR.isT3() ==true)
		{
			// if Opcode is 11 then addition will be performed
			if(mBR2.getOpcode()==11)
			{
				mBR2.setRAM2(mBR2.getRAM1()+mBR2.getRAM3());
				instr_data.get(location2).setRAM1(mBR2.getRAM1());
				instr_data.get(location2).setRAM2(mBR2.getRAM2());
				instr_data.get(location2).setRAM3(mBR2.getRAM3());
				System.out.println(" Addition of Source and MBR value : "+instr_data.get(location2).getRAM2());
			}
			// if Opcode is 22 then subtraction will be performed
			else if(mBR2.getOpcode()==22)
			{
				mBR2.setRAM2(mBR2.getRAM1()-mBR2.getRAM3());
				instr_data.get(location2).setRAM1(mBR2.getRAM1());
				instr_data.get(location2).setRAM2(mBR2.getRAM2());
				instr_data.get(location2).setRAM3(mBR2.getRAM3());
				System.out.println(" Subtraction of Source and MBR value : "+instr_data.get(location2).getRAM2());
			}
			// if Opcode is 33 then multiplication will be performed
			else if(mBR2.getOpcode()==33)
			{
				mBR2.setRAM2(mBR2.getRAM1()*mBR2.getRAM3());
				instr_data.get(location2).setRAM1(mBR2.getRAM1());
				instr_data.get(location2).setRAM2(mBR2.getRAM2());
				instr_data.get(location2).setRAM3(mBR2.getRAM3());
				System.out.println(" Multiplication of Source and MBR value : "+instr_data.get(location2).getRAM2());
			}
			// if Opcode is 44 then division will be performed
			else if (mBR2.getOpcode()==44) 
			{
				mBR2.setRAM2(mBR2.getRAM1()/mBR2.getRAM3());
				instr_data.get(location2).setRAM1(mBR2.getRAM1());
				instr_data.get(location2).setRAM2(mBR2.getRAM2());
				instr_data.get(location2).setRAM3(mBR2.getRAM3());
				System.out.println(" Divison of Source and MBR value : "+instr_data.get(location2).getRAM2());
			}
			MBR.setT3(false);
			MBR.setT4(true);
		}		
		// after all operation are performed , It will go to fetch the next instruction
		if(	MBR.isT4()==true)
		{
			{	
				MBR.setflag_1(false);
				MBR.setflag_2(false);
			
				System.out.println(" Clock Values at fourth clock pulse: ");
				System.out.println(" T1: "+ MBR.isT1());
				System.out.println(" T2: "+ MBR.isT2());
				System.out.println(" T3: "+ MBR.isT3());
				System.out.println(" T4: "+ MBR.isT4());
				
				System.out.println(" Ending of Execution Cycle... Going to fetch the next instruction ");
				System.out.println("---------------------------------------------------------------------------- ");
				System.out.println("---------------------------------------------------------------------------- ");
				//System.out.println(" Press any key to continue..! ");

				MBR.setT4(false);	
			}
		}
	}
}
