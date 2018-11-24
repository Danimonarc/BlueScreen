package prototype;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Beneficiario {




    private static String BD_SERVER = "";
    private static String BD_NAME = "";

    private int id;
    private int idCoordinator;
    private String name;
    private String surname;
    // private imagen?
    private String sex;
    private Date birthDate;
    private Date entryDate;
    private Date exitDate;
    private Date projectJoinDate;
    private Date projectEndDate;
    private String beca;
    private String project;
    private float courseGrade;
    private String birthPlace;
    private String livingPlace;
    private String comments;

    public int getId() {
        return id;
    }

    //public void setId(int id) {
    //    this.id = id;
    //}

    public int getIdCoordinator() {
        return idCoordinator;
    }

    public void setIdCoordinator(int idCoordinator) {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET Agente="+idCoordinator+"WHERE ID="+this.id);
        this.idCoordinator = idCoordinator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET Nombre='"+name+"' WHERE ID="+this.id);
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET Apellido='"+surname+"' WHERE ID="+this.id);
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET Sexo='"+sex+"' WHERE ID="+this.id);
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        DB myDB = new DB(DB_SERVER,DB_NAME);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String birthDateToStr = format.format(birthDate);

        myDB.Update("Update Beneficiario SET FechaNacimiento='"+birthDateToStr+"' WHERE ID="+this.id);
        this.birthDate = birthDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        DB myDB = new DB(DB_SERVER,DB_NAME);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String entryDateToStr = format.format(entryDate);

        myDB.Update("Update Beneficiario SET FechaEntrada='"+entryDateToStr+"' WHERE ID="+this.id);
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        DB myDB = new DB(DB_SERVER,DB_NAME);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String exitDateToStr = format.format(exitDate);

        myDB.Update("Update Beneficiario SET FechaSalida='"+exitDateToStr+"' WHERE ID="+this.id);
        this.exitDate = exitDate;
    }

    public Date getProjectJoinDate() {
        return projectJoinDate;
    }

    public void setProjectJoinDate(Date projectJoinDate) {

        DB myDB = new DB(DB_SERVER,DB_NAME);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String projectJoinDateToStr = format.format(projectJoinDate);

        myDB.Update("Update Beneficiario SET FechaAltaProyecto='"+projectJoinDateToStr+"' WHERE ID="+this.id);
        this.projectJoinDate = projectJoinDate;
    }

    public Date getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(Date projectEndDate) {

        DB myDB = new DB(DB_SERVER,DB_NAME);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String projectendDateToStr = format.format(projectEndDate);

        myDB.Update("Update Beneficiario SET FechaBajaProyecto='"+projectendDateToStr+"' WHERE ID="+this.id);
        this.projectEndDate = projectEndDate;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {

        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET Beca='"+beca+"' WHERE ID="+this.id);

        this.beca = beca;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {

        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET Proyecto='"+project+"' WHERE ID="+this.id);

        this.project = project;
    }

    public float getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(float courseGrade) {

        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET NotaCurso="+courseGrade+"WHERE ID="+this.id);
        this.sex = sex;

        this.courseGrade = courseGrade;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {

        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET ComunidadNacimiento='"+birthPlace+"' WHERE ID="+this.id);

        this.birthPlace = birthPlace;
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(String livingPlace) {

        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET ComunidadViviendo='"+livingPlace+"' WHERE ID="+this.id);

        this.livingPlace = livingPlace;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {

        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Update("Update Beneficiario SET Observaciones='"+comments+"' WHERE ID="+this.id);

        this.comments = comments;
    }


    public static List<Beneficiario> BeneficiaryList(){
        //retorna una lista de beneficiarios
        List<Beneficiario> myList= new ArrayList<Beneficiario>();
        DB myDB = new DB(DB_Server,DB_NAME);

        for (Object[] tupla : myDB.Select("SELECT * FROM Beneficiario")){
            Beneficiario b = new Beneficiario((int)tupla[0]);
            myList.add(b);
        }
        return myList;
    }
    public Beneficiario(int id){
        //Crea el objeto cargando sus valores de la base de datos
        DB myDB = new DB(DB_Server,DB_NAME);
        Object[] tupla = myDB.Select("SELECT * FROM Beneficiario WHERE ID = "+id+";").get(0);

        this.id=(int)tupla[0];
        this.idCoordinator=(int)tupla[1];
        this.name=(String)tupla[2];
        this.surname=(String)tupla[3];
        //this.image= (jajasalu2)tupla[4]
        this.sex=(String)tupla[5];
        this.birthDate=(Date)tupla[6];
        this.entryDate=(Date)tupla[7];
        this.exitDate=(Date)tupla[8];
        this.projectJoinDate=(Date)tupla[9];
        this.projectEndDate=(Date)tupla[10];
        this.beca=(String)tupla[11];
        this.project=(String)tupla[12];
        this.courseGrade=(Float)tupla[13];
        this.birthPlace=(String)tupla[14];
        this.livingPlace=(String)tupla[15];
        this.comments=(String)tupla[16];
    }
    public Beneficiario(int idCoordinador, String name, String surename, String sex, Date birthDate,Date entryDate, Date exitDate, Date projectJoinDate, Date projectEndDate, String beca, String project, float courseGrade, String birthPlace, String livingPlace, String comments){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String birthDateToStr = format.format(this.birthDate);
        String entryDateToStr = format.format(this.entryDate);
        String exitDateToStr = format.format(this.exitDate);
        String projectJoinDateToStr = format.format(this.projectJoinDate);
        String projectEndDateToStr = format.format(this.projectEndDate);



        myDB = new BD (DB_Server,DB_NAME);
        myDB.Insert("INSERT INTO Beneficiario VALUES("+idCoordinador+", '"+name+"', '"+ surename+"', '"+sex+"', '"+birthDateToStr+"', '"+entryDateToStr+"', '"+exitDateToStr+"', '"+projectJoinDateToStr+"', '"+projectEndDateToStr+"', '"+beca+"', '"+project+"', "+courseGrade+", '"+birthPlace+"', '"+livingPlace+"', '"+comments+")1,");
        Object[] tupla = myDB.Select("SELECT @@IDENTITY").get(0);
        this.id= Integer.valueOf(((Number)tupla[0]).intValue());
        this.idCoordinator=idCoordinador;
        this.name = name;
        this.surname=surename;
        this.sex=sex;
        this.birthDate=birthDate;
        this.entryDate=entryDate;
        this.exitDate=exitDate;
        this.projectJoinDate=projectJoinDate;
        this.projectEndDate=projectEndDate;
        this.beca=beca;
        this.project=project;
        this.courseGrade=courseGrade;
        this.birthPlace=birthPlace;
        this.livingPlace=livingPlace;
        this.comments=comments;
    }
    public void DeleteBeneficiary(){
        DB myDB = new DB(DB_SERVER,DB_NAME);
        myDB.Delete("DELETE FROM Beneficiario WHERE id ="+this.id+";");
        this.id=0;
        this.idCoordinator=-1;
        this.name=null;
        this.surname=null;
        this.sex=null;
        this.birthDate=null;
        this.entryDate=null;
        this.exitDate=null;
        this.projectJoinDate=null;
        this.projectEndDate=null;
        this.beca=null;
        this.project=null;
        this.courseGrade=-1;
        this.birthPlace=null;
        this.livingPlace=null;
        this.comments=null;
    }
    public String toString(){
        return id+"->"+" "+name+" "+surname+" \n\t"+"id del coordinador: "+idCoordinator+"\n\t"+"genero: "+sex+"\n\t"+
        "Fecha de nacimiento: "+birthDate+"\n\tFecha de entrada: "+entryDate+"\n\tFecha de salida: "+exitDate+"\n\tFecha de union a proyecto"+
        "\n\tFecha de finalizacion de proyecto : "+projectEndDate+"\n\tTrabajando en el proyecto: "+project+"\n\tCon la beca: "+beca+
        "\n\tNota del curso: "+courseGrade+"\n\t Nacido en: "+birthPlace+"\n\tViviendo en"+livingPlace+"\n\n\tComentarios: "+"\n"+comments;
    }
}

