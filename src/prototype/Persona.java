package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Persona {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int id;
	private String name;
	private String surname;
    private String sex;
    private int image;
    private Date birthDate;
    private Date entryDate;
    private Date exitDate;
    private String comments;

    public static List<Persona> PeopleList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Persona> myList = new ArrayList<Persona>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Persona;"))
    	{
    		Persona c = new Persona( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Persona(int id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Persona WHERE ID = " + id + ";").get(0);
        
        this.id = (int)tupla[0];
        this.name = (String)tupla[1];
        this.surname = (String)tupla[2];
        this.sex = (String)tupla[3];
        this.image = (int)tupla[4];
        this.birthDate = (Date)tupla[5];
        this.entryDate = (Date)tupla[6];
        this.exitDate = (Date)tupla[7];
        this.comments = (String)tupla[8];
    }

    public Persona(String name, String surname, String sex, int image, Date birthDate, Date entryDate, Date exitDate, String comments)
    {
        // Da formato a las fechas para insertarlas en la base de datos
        String birthdateToStr = formatDate(birthDate); 
        String entrydateToStr = formatDate(entryDate); 
        String exitdateToStr = formatDate(exitDate); 
        	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Persona VALUES('" + name +
        		"', '" + surname + "', '" + sex + "', " + image + " '" + birthdateToStr +
        		"', '" + entrydateToStr + "', '" + exitdateToStr + "', '" +
        		comments + "');");
        
        // Para obtener el ID asignado a la persona
        Object[] tupla = myDB.Select("SELECT @@IDENTITY").get(0);
        
        this.id = Integer.valueOf(((Number)tupla[0]).intValue());
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.image = image;
        this.birthDate = birthDate;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.comments = comments;
    }

    public void DeletePerson()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Persona WHERE id ="+ this.id + ";");    	
            
        this.id = -1;
        this.name = null;
        this.surname = null;
        this.sex = null;
        this.image = null;
        this.birthDate = null;
        this.entryDate = null;
        this.exitDate = null;
        this.comments = null;
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
        return id + "->\t" + name + " " + surname + "\n\t//Sexo: " + sex + "\n\t//Nacimiento: " + birthDate
          		+ "\n\t//Alta: " + entryDate + "\n\t//Baja: " + exitDate + "\n\t//Observaciones: " + comments;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
    
    public void setName(String name) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Persona SET Nombre= '" + name + "' WHERE ID=" + this.id + ";");
    	this.name = name;
    }

    public void setSurname(String surname) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Persona SET Apellidos= '" + surname + "' WHERE ID=" + this.id + ";");
    	this.surname = surname;
    }

    public void setSex(String sex) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
    	myDB.Update("UPDATE Persona SET Sexo= '" + sex + "' WHERE ID=" + this.id + ";");
    	this.sex = sex;
    }

    public void setImage(int image)
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
    	myDB.Update("UPDATE Persona SET image= " + image + " WHERE ID=" + this.id + ";");
    	this.image = image;
    }
    
    public void setBirthDate(Date birthDate) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
       	String dateToStr = formatDate(birthDate); 
            	
       	myDB.Update("UPDATE Persona SET FechaNacimiento=" + dateToStr + " WHERE ID=" + this.id + ";");
    	this.birthDate = birthDate;
    }
    
    public void setEntryDate(Date entryDate) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
       	String dateToStr = formatDate(entryDate); 
            	
       	myDB.Update("UPDATE Persona SET FechaAlta=" + dateToStr + " WHERE ID=" + this.id + ";");
    	this.entryDate = entryDate;
    }

    public void setExitDate(Date exitDate) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
       	String dateToStr = formatDate(exitDate); 
            	
       	myDB.Update("UPDATE Persona SET FechaBaja=" + dateToStr + " WHERE ID=" + this.id + ";");
    	this.exitDate = exitDate;
    }
    	
    public void setComments(String comments) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Persona SET comentarios='" + comments + "' WHERE ID=" + this.id + ";");
    	this.comments = comments;
    }

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getId(){
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

    public int image() {
    	return image;
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

    public String getComments() {
    	return comments;
    }
}