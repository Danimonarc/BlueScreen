package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Beneficiario {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int person_id;
    private int project_id;
    private int coordinator_id;
    private Date projectEntryDate;
    private Date projectExitDate;
    private String scolarship;
    private int mark;
    private String birthCommunity;
    private String livingCommunity;

    public static List<Beneficiario> BeneficiaryList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Beneficiario> myList = new ArrayList<Beneficiario>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Beneficiario;"))
    	{
    		Beneficiario c = new Beneficiario( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Beneficiario(int person_id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Beneficiario WHERE persona_id = " + person_id + ";").get(0);
        
        this.person_id = (int)tupla[0];
        this.project_id = (int)tupla[1];
        this.coordinator_id = (int)tupla[2];
        this.projectEntryDate = (Date)tupla[3];
        this.projectExitDate = (Date)tupla[4];
        this.scolarship = (String)tupla[5];
        this.mark = (int)tupla[6];
        this.birthCommunity = (String)tupla[7];
        this.livingCommunity = (String)tupla[8];
    }

    public Beneficiario(int person_id, int project_id, int coordinator_id, Date projectEntryDate, Date projectExitDate, String scolarship, int mark, String birthCommunity, String livingCommunity)
    {
        // Da formato a las fechas para insertarlas en la base de datos
        String projectEntryDateToStr = formatDate(projectEntryDate); 
        String projectExitDateToStr = formatDate(projectExitDate); 
        	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Insert("INSERT INTO Beneficiario VALUES(" + person_id +
        		", " + project_id + ", " + coordinator_id + ", '" + projectEntryDateToStr +
                "', '" + projectExitDateToStr + "', '" + scolarship + "', " + mark + 
                ", '" + birthCommunity + "', '" + livingCommunity + "');");
                
        this.person_id = person_id;
        this.project_id = project_id;
        this.coordinator_id = coordinator_id;
        this.projectEntryDate = projectEntryDate;
        this.projectExitDate = projectExitDate;
        this.scolarship = scolarship;
        this.mark= mark;
        this.birthCommunity = birthCommunity;
        this.livingCommunity = livingCommunity;
    }

    public void DeleteBeneficiary()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Beneficiario WHERE persona_id ="+ this.person_id + ";");    	
            
        this.person_id = -1;
        this.project_id = -1;
        this.coordinator_id = -1;
        this.projectEntryDate = null;
        this.projectExitDate = null;
        this.scolarship = null;
        this.mark = -1;
        this.birthCommunity = null;
        this.livingCommunity = null;
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
        return person_id + "->\t" + "\n\t//Proyecto: " + project_id + "\n\t//Coordinador: " + coordinator_id
           		+ "\n\t//Alta proyecto: " + projectEntryDate + "\n\t//Baja proyecto: " + projectExitDate 
                + "\n\t//Beca: " + scolarship + "\n\t//Nota: " + mark + "\n\t//Comunidad nacimiento: " + birthCommunity
                + "\n\t//Comunidad residencia: " + livingCommunity;
    }

    /*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
    
    public void setProject_id(int project_id) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Beneficiario SET proyecto_id= " + project_id + " WHERE persona_id = " + this.person_id + ";");
        this.project_id = project_id;
    }

    public void setCoordinator_id(int coordinator_id) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Beneficiario SET coordinador_persona_id= " + coordinator_id + " WHERE persona_id = " + this.person_id + ";");
        this.coordinator_id = coordinator_id;
    }

    public void setProjectEntryDate(Date projectEntryDate) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        String dateToStr = formatDate(projectEntryDate); 

        myDB.Update("UPDATE Beneficiario SET fechaAltaProyecto= '" + dateToStr + "' WHERE persona_id = " + this.person_id + ";");
        this.projectEntryDate = projectEntryDate;
    }

    public void setProjectExitDate(Date projectExitDate) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        String dateToStr = formatDate(projectExitDate); 

        myDB.Update("UPDATE Beneficiario SET fechaBajaProyecto= '" + dateToStr + "' WHERE persona_id = " + this.person_id + ";");
        this.projectExitDate = projectExitDate;
    }

    public void setScolarship(String scolarship) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Beneficiario SET beca= " + scolarship + " WHERE persona_id = " + this.person_id + ";");
        this.scolarship = scolarship;
    }

    public void setMark(int mark) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Beneficiario SET notaCurso= " + mark + " WHERE persona_id = " + this.person_id + ";");
        this.mark = mark;
    }

    public void setBirthCommunity(String birthCommunity) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Beneficiario SET comunidadNacimiento= " + birthCommunity + " WHERE persona_id = " + this.person_id + ";");
        this.birthCommunity = birthCommunity;
    }

    public void setLivingCommunity(String livingCommunity) 
    {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("UPDATE Beneficiario SET comunidadResidencia= " + livingCommunity + " WHERE persona_id = " + this.person_id + ";");
        this.livingCommunity = livingCommunity;
    }

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
    
    public int getPersonId(){
        return person_id;
    }

    public int getProjectId(){
        return project_id;
    }

    public int getCoordinatorId(){
        return coordinator_id;
    }

    public Date getProjectEntryDate(){
        return projectEntryDate;
    }

    public Date getProjectExitDate(){
        return projectExitDate;
    }

    public String getScolarship(){
        return scolarship;
    }

    public int getMark(){
        return mark;
    }

    public String getBirthCommunity(){
        return birthCommunity;
    }

    public String getLivingCommunity(){
        return livingCommunity;
    }
}