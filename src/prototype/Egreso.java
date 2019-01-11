package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Egreso {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int movement_id;
    private int beneficiary_id;
    private String beneficiaryName;

    public static List<Egreso> EgressList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Egreso> myList = new ArrayList<Egreso>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Egreso;"))
    	{
    		Egreso c = new Egreso( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Egreso(int movement_id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Egreso WHERE movimiento_id = " + movement_id + ";").get(0);
        
        this.movement_id = (int)tupla[0];
        this.beneficiary_id = (int)tupla[1];
        this.beneficiaryName = (String)tupla[2];
    }

    public Egreso(int movement_id, int beneficiary_id, String beneficiaryName)
    {       	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Egreso VALUES(" + movement_id + ", " + beneficiary_id + ",'" + beneficiaryName + "');");
        
        this.movement_id = movement_id;
        this.beneficiary_id = beneficiary_id;
        this.beneficiaryName = beneficiaryName;
    }

    public void DeleteEgress()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Egreso WHERE movimiento_id ="+ this.movement_id + ";");    	
            
        this.movement_id = -1;
        this.beneficiary_id = -1;
        this.beneficiaryName = null;
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
        return "\n\t//Id: " + movement_id + "\n\t//Codigo beneficiario: " + beneficiary_id + "\n\t//beneficiario: " + beneficiaryName;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/

    public void setBeneficiaryName(String beneficiaryName) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Egreso SET nombreBeneficiario= " + beneficiaryName + " WHERE movimiento_id = " + this.movement_id + ";");
        this.beneficiaryName = beneficiaryName;
    }

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getMovementId(){
   		return movement_id;
    }
    	
    public int getbeneficiary_id() {
    	return beneficiary_id;
    }

    public String getBeneficiaryName(){
        return beneficiaryName;
    }
}