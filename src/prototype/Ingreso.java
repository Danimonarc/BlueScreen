package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ingreso {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int movement_id;
    private String origin;

    public static List<Ingreso> DepositList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Ingreso> myList = new ArrayList<Ingreso>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Ingreso;"))
    	{
    		Ingreso c = new Ingreso( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Ingreso(int id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Ingreso WHERE movimiento_id = " + movement_id + ";").get(0);
        
        this.movement_id = (int)tupla[0];
        this.origin = (String)tupla[1];
    }

    public Ingreso(int movement_id, String origin)
    {       	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Ingreso VALUES(" + movement_id + ", '" + origin + "');");
        
        this.movement_id = movement_id;
        this.origin = origin;
    }

    public void DeleteDeposit()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Ingreso WHERE movimiento_id ="+ this.movement_id + ";");    	
            
        this.movement_id = -1;
        this.origin = null;
    }

    public String formatDate(Date date)
    {
        if(date!=null) {
        	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
           	return "'" + format.format(date) + "'";

        } else {
        	return null;
        }
        	
    }
        
    public String toString()
    {      	
        return "\n\t//Id: " + movement_id + "\n\t//Origen: " + origin;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/

    //Deposit information cannot be edited

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getMovementId(){
   		return movement_id;
    }
    	
    public String getOrigin() {
    	return origin;
    }
}