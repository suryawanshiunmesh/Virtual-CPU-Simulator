package pkg;

import java.util.ArrayList;
import pkg.AM_Data;

public class Reg_Data extends AM_OP
{
	AM_Data intr ;
	final public static String  direct="direct_value";
	final public static String  indirect="indirect_value";
	final public static String  immediate="immediate_value";
	final public static String  register="register_value";
	final public  static Integer add_opcode1=00;
	final public  static Integer sub_opcode1=01;
	final public  static Integer mul_opcode1=10;
	final public  static Integer div_oocode1=11;
	private String adr;
	private Integer opcode;
	
	private ArrayList<Integer> R1 = new ArrayList<Integer>();
	private ArrayList<Integer> R2 = new ArrayList<Integer>();
	private ArrayList<Integer> address1 = new ArrayList<Integer>();
	private Integer RAM1,RAM2,RAM3;
	private boolean t1=false;
	private boolean t2=false;
	private boolean t3=false;
	private  boolean t4=false;
	private boolean flag_1=false;
	private boolean flag_2=false;
	
	public Reg_Data()
	{
	}
	
	public Reg_Data(String address, Integer opcode,Integer R1, Integer R2, Integer R3)
	{
		this.adr=address;
		this.opcode=opcode;
		this.setRAM1(R1);
		this.setRAM2(R2);
		this.setRAM3(R3);	
	}
	public void setAddress(String address)
	{
		this.adr = address;
	}

	public String getAddress() 
	{
		return adr;
	}

	public void setOpcode(Integer opcode) 
	{
		this.opcode = opcode;
	}

	public Integer getOpcode() 
	{
		return opcode;
	}

	public void setR1(ArrayList<Integer> r1) 
	{
		R1 = r1;
	}

	public ArrayList<Integer> getR1() 
	{
		return R1;
	}

	public void setR2(ArrayList<Integer> r2)
	{
		R2 = r2;
	}

	public ArrayList<Integer> getR2() 
	{
		return R2;
	}

	public void setAddress1(ArrayList<Integer> address1) 
	{
		this.address1 = address1;
	}

	public ArrayList<Integer> getAddress1() 
	{
		return address1;
	}

	public void setRAM3(Integer r31) 
	{
		RAM3 = r31;
	}

	public Integer getRAM3() 
	{
		return RAM3;
	}

	public void setRAM1(Integer r11)
	{
		RAM1 = r11;
	}

	public Integer getRAM1()
	{
		return RAM1;
	}

	public void setRAM2(Integer r21) 
	{
		RAM2 = r21;
	}
	
	public Integer getRAM2()
	{
		return RAM2;
	}

	public void setT1(boolean t1)
	{
		this.t1 = t1;
	}

	public boolean isT1()
	{
		return t1;
	}

	public void setT2(boolean t2)
	{
		this.t2 = t2;
	}

	public boolean isT2()
	{
		return t2;
	}

	public void setT3(boolean t3)
	{
		this.t3 = t3;
	}

	public boolean isT3()
	{
		return t3;
	}

	public void setT4(boolean t4)
	{
		this.t4 = t4;
	}

	public boolean isT4()
	{
		return t4;
	}

	public void setflag_1(boolean f1)
	{
		flag_1 = f1;
	}
	public boolean isflag_1()
	{
		return flag_1;
	}

	public void setflag_2(boolean f2)
	{
		flag_2 = f2;
	}

	public boolean isflag_2()
	{
		return flag_2;
	}
}
