package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cartas {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int id;
    private Date sentDate;
    private int beneficiary_id;

    public static List<Cartas> LettersList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Cartas> myList = new ArrayList<Cartas>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Cartas;"))
    	{
    		Cartas c = new Cartas( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Cartas(int id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Cartas WHERE ID = " + id + ";").get(0);
        
        this.id = (int)tupla[0];
        this.sentDate = (Date)tupla[1];
        this.beneficiary_id = (int)tupla[2];
    }

    public Cartas(int id, Date sentDate, int beneficiary_id)
    {
        // Da formato a las fechas para insertarlas en la base de datos
        String sentDateToStr = formatDate(sentDate); 
        	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Cartas VALUES(" + id + ", " + sentDateToStr + ", " + beneficiary_id + ");");
        
        this.id = id;
        this.sentDate = sentDate;
        this.beneficiary_id = beneficiary_id;
    }

    public void DeleteLetter()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Cartas WHERE id ="+ this.id + ";");    	
            
        this.id = -1;
        this.sentDate = null;
        this.beneficiary_id = -1;
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
        return id + "->\t" + "\n\t//Fecha: " + sentDate + "\n\t//Codigo beneficiario: " + beneficiary_id;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/

    //Letter information cannot be edited

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getId(){
   		return id;
    }
    	
    public Date getSentDate() {
    	return sentDate;
    }

    public int getBeneficiaryId() {
    	return beneficiary_id;
    }
}