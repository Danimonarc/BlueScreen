package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sede {
    private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

    private int project_id;
    private String province;

    public static List<Sede> HeadquarterList()
    { 
        // Retorna una lista con todos los objetos de la clase almacenados en la base de datos      
        List<Sede> myList = new ArrayList<Sede>();
        DB myDB  = new DB(DB_SERVER,DB_NAME);
            
        for(Object[] tupla: myDB.Select("SELECT * FROM Sede;"))
        {
            Sede c = new Sede( (int)tupla[0] );
            myList.add(c);
        }
        return myList;
    }

    public Sede(int project_id)
    {
        // Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Sede WHERE proyecto_id = " + project_id + ";").get(0);
        
        this.project_id = (int)tupla[0];
        this.province = (String)tupla[1];
    }

    public Sede(int id, String province)
    {           
        // Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Sede VALUES(" + id + ", '" + province + "');");
        
        this.project_id = id;
        this.province = province;
    }

    public void DeleteHeadquarter()
    {
        // Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Sede WHERE proyecto_id ="+ this.project_id + ";");        
            
        this.project_id = -1;
        this.province = null;
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
        return "\n\t//Id: " + project_id + "\n\t//Provincia: " + province;
    }

    /*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/

    //Headquarters information cannot be edited

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
    
    public int getProjectId(){
        return project_id;
    }
        
    public String getProvince() {
        return province;
    }
}