package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movimiento {
	private static String DB_SERVER = "localhost";
    private static String DB_NAME = "BlueCoes";

	private int id;
    private int project_id;
    private Date transactionDate;
    private double quantity;
    private String description;

    public static List<Movimiento> TransactionList()
    { 
    	// Retorna una lista con todos los objetos de la clase almacenados en la base de datos		
    	List<Movimiento> myList = new ArrayList<Movimiento>();
    	DB myDB  = new DB(DB_SERVER,DB_NAME);
    		
    	for(Object[] tupla: myDB.Select("SELECT * FROM Movimiento;"))
    	{
    		Movimiento c = new Movimiento( (int)tupla[0] );
    		myList.add(c);
    	}
    	return myList;
    }

    public Movimiento(int id)
    {
    	// Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);

        Object[] tupla = myDB.Select("SELECT * FROM Movimiento WHERE id = " + id + ";").get(0);
        
        this.id = (int)tupla[0];
        this.project_id = (int)tupla[1];
        this.transactionDate = (Date)tupla[2];
        this.quantity = (double)tupla[3];
        this.description = (String)tupla[4];
    }

    public Movimiento(int project_id, Date transactionDate, double quantity, String description)
    {       	
    	// Crea el objeto y lo inserta en la base de datos
        DB myDB = new DB(DB_SERVER,DB_NAME);
        String transactionDateToStr = formatDate(transactionDate); 

        myDB.Insert("INSERT INTO Movimiento VALUES(" + project_id + ", '" + transactionDateToStr + "', " + quantity +
            ", '" + description + "');");
        
        // Para obtener el ID asignado a la transaccion
        Object[] tupla = myDB.Select("SELECT @@IDENTITY").get(0);
        
        this.id = Integer.valueOf(((Number)tupla[0]).intValue());
        this.project_id = project_id;
        this.transactionDate = transactionDate;
        this.quantity = quantity;
        this.description = description;
    }

    public void DeleteTransaction()
    {
    	// Borra la entrada de la base de datos y deja en null los valores
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Movimiento WHERE id ="+ this.id + ";");    	
            
        this.id = -1;
        this.project_id = -1;
        this.transactionDate = null;
        this.quantity = -1;
        this.description = null;
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
        return id + "->\t" + "//Proyecto: " + project_id + "\n\t//Fecha: " + transactionDate + "\n\t//Cantidad: " 
               + quantity + "\n\t//Descripcion: " + description;
    }

 	/*---------------------------------------------------------------*/
    /*-------------------------SETTERS-------------------------------*/
    /*---------------------------------------------------------------*/

    //Transaction information cannot be edited

    /*---------------------------------------------------------------*/
    /*-------------------------GETTERS-------------------------------*/
    /*---------------------------------------------------------------*/
	
	public int getId() {
   		return id;
    }
    	
    public int getProject_id() {
    	return project_id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}