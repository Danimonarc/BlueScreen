package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proyecto {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int id;
    private String location;
    private String name;

    public static List<Proyecto> ProjectList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Proyecto> myList = new ArrayList<Proyecto>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Proyecto;"))
    	{
    		Proyecto c = new Proyecto( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Proyecto(int id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Proyecto WHERE id = " + id + ";").get(0);
        
        this.id = (int)tupla[0];
        this.location = (String)tupla[1];
        this.name = (String)tupla[2];
    }

    public Proyecto(String location, String name)
    {       	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Proyecto VALUES(" + id + ", '" + location + "');");
        
        // Para obtener el ID asignado al proyecto
        Object[] tupla = myDB.Select("SELECT @@IDENTITY").get(0);
        
        this.id = Integer.valueOf(((Number)tupla[0]).intValue());
        this.location = location;
        this.name = name;
    }

    public void DeleteProject()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Proyecto WHERE id ="+ this.id + ";");    	
            
        this.id = -1;
        this.location = null;
        this.name = null;
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
        return "\n\t//Id: " + id + "\n\t//Nocalizacion: " + location + "\n\t//Nombre: " + name;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/

    public void setName(String name) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Proyecto SET nombre= " + name + " WHERE id = " + this.id + ";");
        this.name = name;
    }

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getMovementId(){
   		return id;
    }
    	
    public String getLocation() {
    	return location;
    }

    public String getName() {
        return location;
    }
}