package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Coordinador {
    private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";
       
    private int person_id;
    private int project_id;
    private int privilege;
    private String job;
    private String phoneNumber;
    private String address;
        
    public static List<Coordinador> AgentList()
    { 
    	// Retorna una lista con todos los obejtos de la clase almacenados en la base de datos		
    	List<Coordinador> myList = new ArrayList<Coordinador>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    	
    	for(Object[] tupla: myDB.Select("SELECT * FROM Coordinador;"))
    	{
    		Coordinador c = new Coordinador( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Coordinador(int person_id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
       	DB myDB = new DB(DB_SERVER,DB_NAME);
       	Object[] tupla = myDB.Select("SELECT * FROM Coordinador WHERE persona_id = " + person_id + ";").get(0);
       	
       	this.person_id = (int)tupla[0];
        this.project_id = (int)tupla[1];
       	this.privilege = (int)tupla[2];
        this.job = (String)tupla[3];
        this.phoneNumber = (String)tupla[4];
       	this.address = (String)tupla[5];
    }
        
    public Coordinador(int person_id, int project_id, int privilege, String job, String phoneNumber, String address)
    {        	
        // Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Coordinador VALUES(" + person_id +
    	       		", " + project_id + ", " + privilege + ", '" + job +
       			    "', '" + phoneNumber + "', '" + address + "');");

        this.person_id = person_id;
        this.project_id = project_id;
        this.privilege = privilege;
        this.job = job;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void DeleteAgent()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
       	DB myDB = new DB(DB_SERVER,DB_NAME);
       	myDB.Delete("DELETE FROM Coordinador WHERE persona_id ="+ this.person_id + ";");    	
            
     	this.person_id = -1;
        this.project_id = -1;
        this.privilege = -1;
        this.job = null;
        this.phoneNumber = null;
        this.address = null;
    }
        
    public String formatDate(Date date){
      	if(date!=null) {
       		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
           	return "'" + format.format(date) + "'";
       	} else {
       		return null;
       	}
        	
    }
        
    public String toString()
    {        	
        return person_id + "->\t" + "\n\t//Proyecto: " + project_id + "\n\t//Nivel de privilegios: " + privilege
         		  + "\n\t//Posicion: " + job + "\n\t//Numero de telefono: " + phoneNumber + "\n\t//Direccion: "
                  + address;
    }
        
    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
        
    public int getPersonId() {
    	return person_id;
    }

    public int getProjectId() {
    	return project_id;
    }

    public int getPrivilege() {
    	return privilege;
    }

    public String getJob() {
    	return job;
    }

    public String getPhoneNumber() {
    	return phoneNumber;
    }

    public String getAddress() {
    	return address;
    }
    	    	
    /*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
    	
    public void setProjectId(int project_id) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
       	myDB.Update("UPDATE Coordinador SET proyecto_id= " + project_id + " WHERE persona_id=" + this.person_id + ";");
    	this.project_id = project_id;
    }

    public void setPrivilege(int privilege) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
       	myDB.Update("UPDATE Coordinador SET nivelPermisos= '" + privilege + "' WHERE persona_id=" + this.person_id + ";");
    	this.privilege = privilege;
    }

    public void setJob(String job) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
     	myDB.Update("UPDATE Coordinador SET Posicion= '" + job + "' WHERE persona_id=" + this.person_id + ";");
    	this.job = job;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Coordinador SET telefono= '" + phoneNumber + "' WHERE persona_id=" + this.person_id + ";");
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
      	myDB.Update("UPDATE Coordinador SET direccion='" + address + "' WHERE persona_id=" + this.person_id + ";");
    	this.address = address;
    }
}