package pkg;

import pkg.Reg_Data;
import java.util.Hashtable;
import java.util.Stack;

public class AM_Data
{
	boolean flag1=false;
	boolean flag2=false;
	boolean CP1=false;
	boolean CP2=false;
	boolean CP3=false;
	boolean CP4=false;
	public static final Integer pc=0;
	
	public void direct(Hashtable<String, Integer> source_reg, Hashtable<String, Integer> s, Integer calc, Integer calc2)
	{
		if(source_reg.containsKey("r1"))
		{
		}
		else if(source_reg.containsKey("r2"))
		{
		}
		else if(source_reg.containsKey("r3"))
		{
		}
		else if(source_reg.containsKey("r4"))
		{
		}
	}
	
	public void indirect(Hashtable<String, Integer> source_reg, Hashtable<String, Integer> s, Integer calc, Integer calc2)
	{
		if(source_reg.containsKey("r1"))
		{
		}
		else if(source_reg.containsKey("r2"))
		{
		}
		else if(source_reg.containsKey("r3"))
		{
		}
		else if(source_reg.containsKey("r4"))
		{
		}
	}
	
	public  void immediate(Hashtable<String, Integer> source_reg, Hashtable<String, Integer> s, Integer calc, Integer calc2)
	{
		if(source_reg.containsKey("r1"))
		{
		}
		else if(source_reg.containsKey("r2"))
		{
		}
		else if(source_reg.containsKey("r3"))
		{	
		}
		else if(source_reg.containsKey("r4"))
		{
		}
	}
	
	public  void register(Hashtable<String, Integer> source_reg, Hashtable<String, Integer> s, Integer calc, Integer calc2)
	{
		if(source_reg.containsKey("r1"))
		{
		}
		else if(source_reg.containsKey("r2"))
		{
		}
		else if(source_reg.containsKey("r3"))
		{
		}
		else if(source_reg.containsKey("r4"))
		{
		}
	}
	
	public void fetchData()
	{
	}
	public void execute()
	{
	}
	public void interrupt()
	{
	}
	public void fetch(Stack<Reg_Data> instructionPool) 
	{
		if(flag1==true && flag2==true && CP1==true)
		{
		}
	}
	public Stack InstructionLoad(Stack<Reg_Data> instr_data)
	{
		return instr_data;
	}
}
