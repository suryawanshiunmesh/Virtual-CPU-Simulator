package pkg;

import java.util.Hashtable;

public class AM_OP
{
	final public static String  AM1="direct_value";
	final public static String  AM2="indirect_value";
	final public static String  AM3="immediate_value";
	final public static String  AM4="register_value";
	final public  static Integer  add_opcode=00;
	final public  static Integer  sub_opcode=01;
	final public  static Integer  mul_opcode=10;
	final public  static Integer  div_opcode=11;
	Hashtable<String, Integer> RS = new Hashtable<String, Integer>();
	Hashtable<String, Integer> S = new Hashtable<String, Integer>();
	Integer calc = new Integer(100);
	}
