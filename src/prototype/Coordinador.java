package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Coordinador {
	private static String DB_SERVER = "DESKTOP-6289C7L\\SQLEXPRESS";
    private static String DB_NAME = "GI1819";
    
    private int id;
    private String name;
    private String surname;
    //private image;
    private String sex;
    private Date birthDate;
    private Date entryDate;
    private Date exitDate;
    private int privilege;
    private String address;
    private int phoneNumber;
    private String job;
    private String comments;
    
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
    public Coordinador(int id)
    {
		// Crea el objeto cargando sus valores de la base de datos
    	DB myDB = new DB(DB_SERVER,DB_NAME);
    	Object[] tupla = myDB.Select("SELECT * FROM Coordinador WHERE ID = '" + id + "';").get(0);
    	
    	this.id = (int)tupla[0];
    	this.name = (String)tupla[1];
        this.surname = (String)tupla[2];
        //this.image = (Image)tupla[3];
        this.sex = (String)tupla[4];
        this.birthDate = (Date)tupla[5];
        this.entryDate = (Date)tupla[6];
        this.exitDate = (Date)tupla[7];
        this.privilege = (int)tupla[8];
        this.address = (String)tupla[9];
        this.phoneNumber = (int)tupla[10];
        this.job = (String)tupla[11];
        this.comments = (String)tupla[12];
    }
    
    public Coordinador(String name, String surname, String sex, Date birthDate, Date entryDate, Date exitDate, int privilege, String address, int phoneNumber, String job, String comments) //TODO: image
    {
    	// Da formato a las fechas para insertarlas en la base de datos
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        String birthDateToStr = format.format(this.birthDate); 
        String entryDateToStr = format.format(this.entryDate); 
        String exitDateToStr = format.format(this.exitDate); 
    	
		// Crea el objeto y lo inserta en la base de datos
    	DB myDB = new DB(DB_SERVER,DB_NAME);
    	myDB.Insert("INSERT INTO Coordinador VALUES('" + name +
    			"', '" + surname + "', '" + sex + "', '" + birthDateToStr +
    			"', '" + entryDateToStr + "', '" + exitDateToStr + "', " + privilege + 
    			", '" + address + "', " + phoneNumber + ", '" + job +
    			"', '" + comments + "');");
    	
     	// Para obtener el ID asignado al coordinador
     	Object[] tupla = myDB.Select("SELECT @@IDENTITY").get(0);
     	
     	this.id = Integer.valueOf(((Number)tupla[0]).intValue());
     	this.name = name;
     	this.surname = surname;
     	//this.image = image;
     	this.sex = sex;
     	this.birthDate = birthDate;
     	this.entryDate = entryDate;
     	this.exitDate = exitDate;
     	this.privilege = privilege;
     	this.address = address;
     	this.phoneNumber = phoneNumber;
     	this.job = job;
     	this.comments = comments;
    }
    public void DeleteAgent()
    {
		// Borra la entrada de la base de datos y deja en null los valores
    	DB myDB = new DB(DB_SERVER,DB_NAME);
    	myDB.Delete("DELETE FROM Coordinador WHERE id ="+ this.id + ";");    	
        
    	this.id = -1;
     	this.name = null;
     	this.surname = null;
     	//this.image = image;
     	this.sex = null;
     	this.birthDate = null;
     	this.entryDate = null;
     	this.exitDate = null;
     	this.privilege = -1;
     	this.address = null;
     	this.phoneNumber = -1;
     	this.job = null;
     	this.comments = null;
    }
    
    public String toString()
    {
    	//TODO: los privilegios no deben imprimir el int sino su nombre o nivel correspondiente
    	
        return id + "->\t" + name + " " + surname + "\n\t//Sexo: " + sex + "\n\t//Nacimiento: " + birthDate
        		+ "\n\t//Alta: " + entryDate + "\n\t//Baja: " + exitDate + "\n\t//Privilegios: " + privilege
        		+ "\n\t//Direccion: " + address + "\n\t//Telefono: " + phoneNumber + "\n\t//Trabajo: " + job
        		+ "\n\t//Observaciones: " + comments;
    }
    
    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
    
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getSex() {
		return sex;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public Date getExitDate() {
		return exitDate;
	}
	public int getPrivilege() {
		return privilege;
	}
	public String getAddress() {
		return address;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public String getJob() {
		return job;
	}
	public String getComments() {
		return comments;
	}
	
	/*---------------------------------------------------------------*/
	/*-------------------------SETTERS-------------------------------*/
	/*---------------------------------------------------------------*/
	
	public void setName(String name) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
        	myDB.Update("UPDATE Coordinador SET Nombre= '" + name + "' WHERE ID=" + this.id + ";");
		this.name = name;
	}
	public void setSurname(String surname) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
        	myDB.Update("UPDATE Coordinador SET Apellidos= '" + surname + "' WHERE ID=" + this.id + ";");
		this.surname = surname;
	}
	public void setSex(String sex) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
       	 	myDB.Update("UPDATE Coordinador SET Sexo= '" + sex + "' WHERE ID=" + this.id + ";");
		this.sex = sex;
	}
	public void setBirthDate(Date birthDate) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
       		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        	String DateToStr = format.format(birthDate); 
        	
        	myDB.Update("UPDATE Coordinador SET FechaNacimiento='" + DateToStr + "' WHERE ID=" + this.id + ";");
		this.birthDate = birthDate;
	}
	public void setEntryDate(Date entryDate) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
       		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        	String DateToStr = format.format(entryDate); 
        	
        	myDB.Update("UPDATE Coordinador SET FechaNacimiento='" + DateToStr + "' WHERE ID=" + this.id + ";");
		this.entryDate = entryDate;
	}
	public void setExitDate(Date exitDate) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
       		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
        	String DateToStr = format.format(entryDate); 
        	
        	myDB.Update("UPDATE Coordinador SET FechaNacimiento='" + DateToStr + "' WHERE ID=" + this.id + ";");
		this.exitDate = exitDate;
	}
	public void setPrivilege(int privilege) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
        	myDB.Update("UPDATE Coordinador SET Privilegios=" + privilege + " WHERE ID=" + this.id + ";");
		this.privilege = privilege;
	}
	public void setAddress(String address) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
        	myDB.Update("UPDATE Coordinador SET Direcccion='" + address + "' WHERE ID=" + this.id + ";");
		this.address = address;
	}
	public void setPhoneNumber(int phoneNumber) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
        	myDB.Update("UPDATE Coordinador SET Telefono=" + privilege + " WHERE ID=" + this.id + ";");
		this.phoneNumber = phoneNumber;
	}
	public void setJob(String job) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
        	myDB.Update("UPDATE Coordinador SET Trabajo='" + job + "' WHERE ID=" + this.id + ";");
		this.job = job;
	}
	public void setComments(String comments) {
		DB myDB = new DB(DB_SERVER,DB_NAME);
        	myDB.Update("UPDATE Coordinador SET Observaciones='" + comments + "' WHERE ID=" + this.id + ";");
		this.comments = comments;
	}
    
}
