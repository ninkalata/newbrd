/*
 * Classname:Validationfunction
*
 * Version info:0.01
 *
 * Copyright notice
 */
package com.demo.training;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.print.DocFlavor.STRING;
public class Validationfunction {
//Datetype Validation;
 public static boolean validateDataType(Object object){

		if(object.getClass().getSimpleName().equals("String")) {
			return true;
		}
		else if(object.getClass().getSimpleName().equals("Integer"))
		{
			return true;
		}
		else if(object.getClass().getSimpleName().equals("Float"))
		{
			return true;
		}
		else if(object.getClass().getSimpleName().equals("Char"))
		{
			return true;
			
		}
		else if(object.getClass().getSimpleName().equals("Boolean"))
		{
			return true;
		}
		return false;
	}
		public static boolean DataTypelength(Object object, short length){
			if(((String)object).length()<=length){
				return true;
			}
			return false;
		
	}	
		//Special Characters Validation
		public static boolean validatecharactere(String character){
			if((character.contains("@"))||(character.contains("#"))||(character.contains("$"))||(character.contains("%"))||(character.contains("^"))) {
			
			return false;
			
		}
		return true;
}

		//	Format Validation
			static	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

			public static boolean isValidDate(SimpleDateFormat date,String input) {
			    date.setLenient(false);
				try {
			          date.parse(input);
			          return true;
			     }
			     catch(ParseException e){
			          return false;
			     }
			}
			//Validate E-mail
		public static final Pattern validateEmail = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

			public static boolean validate(String emailStr) {
			        Matcher matcher = validateEmail .matcher(emailStr);
			        return matcher.find();
			}
			// domainValue
	public static boolean validatedomainValue()
			{
				ArrayList<String> domainvalue=new ArrayList<String> ();
				domainvalue.add("monday");
				domainvalue.add("tuesday");
				domainvalue.add("wednesday");
				domainvalue.add("thrusday");
				domainvalue.add("saturday");
				domainvalue.add("friday");
				domainvalue.add("sunday");
				if(domainvalue.contains("monday"))
						{
					return true;
						}
				else
				{
				return false;
			}
			}
	public static void main(String[] args) {
//		// TODO Auto-generated method 
	Scanner valiation=new Scanner(System.in);
		System.out.println("Data type Validation:");
	    Object object=valiation.nextLine();
		Validationfunction	 mi=new Validationfunction();
		System.out.println(mi.validateDataType(object));
		System.out.println(validateDataType(5));
		System.out.println("Data type Length Validation:");
		Short length=valiation.nextShort();
		valiation.nextLine();
		System.out.println(mi.DataTypelength(object,length));
		System.out.println("Validate E-mail:");
		String emailStr =valiation.nextLine();
		System.out.println(mi.validate(emailStr));
		System.out.println("Special Characters:");
	    String character =valiation.nextLine();
		System.out.println(mi.validatecharactere(character));
		System.out.println("Domain value:");
		System.out.println(validatedomainValue());
		System.out.println(isValidDate(date, "1996-08-24"));
	}

}


