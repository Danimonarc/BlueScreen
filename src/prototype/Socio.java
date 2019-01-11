package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int person_id;
	private String dni;
	private String email;
    private int postalCode;
    private String population;
    private String province;
    private String address;
    private String phoneNumber;
    private String secondPhoneNumber;
    private Boolean certified;

    public static List<Socio> PartnerList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Socio> myList = new ArrayList<Socio>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Socio;"))
    	{
    		Socio c = new Socio( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Socio(int person_id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Socio WHERE persona_id = " + person_id + ";").get(0);
        
        this.person_id = (int)tupla[0];
        this.dni = (String)tupla[1];
        this.email = (String)tupla[2];
        this.postalCode = (int)tupla[3];
        this.population = (String)tupla[4];
        this.province = (String)tupla[5];
        this.address = (String)tupla[6];
        this.phoneNumber = (String)tupla[7];
        this.secondPhoneNumber = (String)tupla[8];
        this.certified = (Boolean)tupla[9];
    }

    public Socio(int person_id, String dni, String email, int postalCode, String population, String province, String address, String phoneNumber, String secondPhoneNumber, Boolean certified)
    {      	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Socio VALUES(" + person_id + ", '" + dni +
        		"', '" + email + "', " + postalCode + ", '" + population + 
                "', '" + province + "', '" + address + "', '" + phoneNumber + "', '" +
        		secondPhoneNumber + "', " + (certified?1:0) + ");");

        this.person_id = person_id;
        this.dni = dni;
        this.email = email;
        this.postalCode = postalCode;
        this.population = population;
        this.province = province;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.secondPhoneNumber = secondPhoneNumber;
        this.certified = certified;
    }

    public void DeletePerson()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Socio WHERE persona_id ="+ this.person_id + ";");    	
            
        this.person_id = -1;
        this.dni = null;
        this.email = null;
        this.postalCode = -1;
        this.population = null;
        this.province = null;
        this.address = null;
        this.phoneNumber = null;
        this.secondPhoneNumber = null;
        this.certified = false;
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
        return person_id + "->\t" + "\n\t//DNI: " + dni + "\n\t//e-mail: " + email + "\n\t//Codigo postal: " + postalCode 
                + "\n\t//Poblacion: " + population + "\n\t//Provincia: " + province + "\n\t//Direccion: " + address 
                + "\n\t//Telefono: " + phoneNumber + "\n\t//Movil: " + secondPhoneNumber + "\n\t//Certificado: " + certified;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
    
    public void setDni(String dni) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Socio SET dni= '" + dni + "' WHERE persona_id=" + this.person_id + ";");
    	this.dni = dni;
    }

    public void setEmail(String email) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Socio SET email= '" + email + "' WHERE persona_id=" + this.person_id + ";");
    	this.email = email;
    }

    public void setPostalCode(int postalCode) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
    	myDB.Update("UPDATE Socio SET codigoPostal= " + postalCode + " WHERE persona_id=" + this.person_id + ";");
    	this.postalCode = postalCode;
    }

    public void setPopulation(String population)
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
    	myDB.Update("UPDATE Socio SET poblacion= " + population + " WHERE persona_id=" + this.person_id + ";");
    	this.population = population;
    }
    
    public void setProvince(String province) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
       	myDB.Update("UPDATE Socio SET provincia=" + province + " WHERE persona_id=" + this.person_id + ";");
    	this.province = province;
    }
    
    public void setAddress(String address) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
       	myDB.Update("UPDATE Socio SET direccion=" + address + " WHERE persona_id=" + this.person_id + ";");
    	this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);	
       	myDB.Update("UPDATE Socio SET telefono=" + phoneNumber + " WHERE persona_id=" + this.person_id + ";");
    	this.phoneNumber = phoneNumber;
    }
    	
    public void setSecondPhoneNumber(String secondPhoneNumber) 
    {
    	DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Socio SET movil='" + secondPhoneNumber + "' WHERE persona_id=" + this.person_id + ";");
    	this.secondPhoneNumber = secondPhoneNumber;
    }

    public void setCertified(Boolean certified) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Socio SET certificado=" + certified + " WHERE persona_id=" + this.person_id + ";");
        this.certified = certified;
    }

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getPerson_id(){
   		return person_id;
    }
    	
    public String getDni() {
    	return dni;
    }

    public String getEmail() {
    	return email;
    }

    public int getPostalCode() {
    	return postalCode;
    }

    public String getPopulation() {
    	return population;
    }

    public String getProvince() {
    	return province;
    }

    public String getAddress() {
    	return address;
    }

    public String getPhoneNumber() {
    	return phoneNumber;
    }

    public String getSecondPhoneNumber() {
    	return secondPhoneNumber;
    }

    public Boolean getCertified() {
        return certified;
    }
}