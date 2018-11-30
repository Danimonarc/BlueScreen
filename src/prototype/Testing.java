package prototype;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testing {
	public static void main(String[] args) {
		for(Beneficiario p: Beneficiario.BeneficiaryList()) 
		{
			System.out.println(p);	
		}
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date d =format.parse(format.format(format.parse("2018-01-01")));
			System.out.println(d);
			
			String birthDate=format.format(format.parse("01-01-2000"));
			System.out.println(birthDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
