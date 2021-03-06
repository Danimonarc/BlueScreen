package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apadrinamiento {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int beneficiary_id;
    private int partner_id;
    private int headquarter_id;

    public static List<Apadrinamiento> PartnershipList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Apadrinamiento> myList = new ArrayList<Apadrinamiento>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Apadrinamiento;"))
    	{
    		Apadrinamiento c = new Apadrinamiento( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Apadrinamiento(int beneficiary_id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Apadrinamiento WHERE beneficiario_persona_id = " + beneficiary_id + ";").get(0);
        
        this.beneficiary_id = (int)tupla[0];
        this.partner_id = (int)tupla[1];
        this.headquarter_id = (int)tupla[2];
    }

    public Apadrinamiento(int beneficiary_id, int partner_id, int headquarter_id)
    {
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Apadrinamiento VALUES(" + beneficiary_id + ", " + partner_id + ", " + headquarter_id + ");");
        
        this.beneficiary_id = beneficiary_id;
        this.partner_id = partner_id;
        this.headquarter_id = headquarter_id;
    }

    public void DeletePartnership()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Apadrinamiento WHERE beneficiario_persona_id ="+ this.beneficiary_id + ";");    	
            
        this.beneficiary_id = -1;
        this.partner_id = -1;
        this.headquarter_id = -1;
    }

    public String formatDate(Date date)
    {
        if(date!=null) {
        	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
           	return "'" + format.format(date) + "'";

        } else {
        	return null;
        }
        	
    }
        
    public String toString()
    {      	
        return "\n\t//Beneficiario: " + beneficiary_id + "\n\t//Socio: " + partner_id + "\n\t//Proyecto: " + headquarter_id;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/

    //Partnership information cannot be edited

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getBeneficiaryId(){
   		return beneficiary_id;
    }
    	
    public int getPartnerId() {
    	return partner_id;
    }

    public int getHeadquarterId() {
    	return headquarter_id;
    }
}