/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;
import java.sql.*;

public class ConnectionDB {
   private Connection connection = null;
   private String driver = "";
   private String jdbc = "";
   private String server = "";
   private String instanceName = "";
   private String port = "";
   private String database = "";
   private String user = "";
   private String password = "";
   private String url = "";

   public void setServer(String server){
        this.server = server;
   }

   public String getServer(){
        return this.server;
   }

   public void setInstanceName(String instanceName){
        this.instanceName = instanceName;
   }

   public String getInstanceName(){
        return this.instanceName;
   }

   public void setPort(String port){
        //this.port = ":" + port;
        this.port = port;
   }

   public String getPort(){
        return this.port;
   }

   public void setDatabase(String database){
        this.database = database;
   }

   public String getDatabase(){
        return this.database;
   }

   public void setUser(String user){
        this.user = user;
   }

   public String getUser(){
        return this.user;
   }

   public void setPassword(String password){
        this.password = password;
   }

   public String getPassword(){
        return this.password;
   }

   public void setDriver(String driver){
        this.driver = driver;
   }

   public String getDriver(){
        return this.driver;
   }

   public void setJDBC(String jdbc){
        this.jdbc = jdbc;
   }

   public String getJDBC(){
        return this.jdbc;
   }

   public void setConnectionUrl(String jdbc, String server, String instance, String port, String database, String user, String password) {
        this.url = "jdbc:"+jdbc+"://"+server+instance+port+";"+"databaseName="+database+";"+"user="+user+";password="+password;
   }

   public void setConnectionUrl(String jdbc, String server, String port, String database, String user, String password) {
        this.url = "jdbc:"+jdbc+"://"+server+port+";"+"databaseName="+database+";"+"user="+user+";password="+password;
   }

   public void setConnectionUrl(String jdbc, String server, String instance, String port, String database) {
        this.url = "jdbc:"+jdbc+"://"+server+instance+port+";"+"databaseName="+database+";";
   }

   public void setConnectionUrl(String jdbc, String server, String port, String database) {
        if ( jdbc.equalsIgnoreCase("sqlserver") || jdbc.equalsIgnoreCase("mysql")){
            if ( jdbc.equalsIgnoreCase("sqlserver")){
                this.url = "jdbc:"+jdbc+"://"+server+port+";"+"databaseName="+database+";";
            }

            if ( jdbc.equalsIgnoreCase("mysql")){
                this.url = "jdbc:"+jdbc+"://"+server+":"+port+"/"+database;
            }
        }
   }

   public String getConnectionUrl(){
        return this.url;
   }

   public ConnectionDB(String jdbc, String server, String instance, String port, String database, String user, String password) {
        if ( jdbc.equalsIgnoreCase("sqlserver2000") || jdbc.equalsIgnoreCase("sqlserver2005")){
            this.setServer(server);
            this.setInstanceName(instance);
            this.setPort(port);
            this.setDatabase(database);
            this.setUser(user);
            this.setPassword(password);

            if ( jdbc.equalsIgnoreCase("sqlserver2000")){
                this.setDriver("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                this.setJDBC("microsoft:sqlserver");
                this.setConnectionUrl(this.getJDBC(), server, instance, port, database);
            }

            if ( jdbc.equalsIgnoreCase("sqlserver2005")){
                this.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                this.setJDBC("sqlserver");
                this.setPort("");
                //this.setConnectionUrl(this.getJDBC(), server, instance, port, database, user, password);
                this.setConnectionUrl(this.getJDBC(), server, instance, "", database, user, password);
            }
        }
   }

   public ConnectionDB(String jdbc, String server, String port, String database, String user, String password) {
        if ( jdbc.equalsIgnoreCase("sqlserver2000") || jdbc.equalsIgnoreCase("sqlserver2005") || jdbc.equalsIgnoreCase("mysql")){
            this.setServer(server);
            this.setPort(port);
            this.setDatabase(database);
            this.setUser(user);
            this.setPassword(password);

            if ( jdbc.equalsIgnoreCase("sqlserver2000")){
                this.setDriver("com.microsoft.jdbc.sqlserver.SQLServerDriver");
                this.setJDBC("microsoft:sqlserver");
                this.setConnectionUrl(this.getJDBC(), server, port, database);
            }

            if ( jdbc.equalsIgnoreCase("sqlserver2005")){
                this.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                this.setJDBC("sqlserver");
                this.setPort("");
                this.setConnectionUrl(this.getJDBC(), server, "", database, user, password);
            }

            if ( jdbc.equalsIgnoreCase("mysql")){
                this.setServer(server);
                this.setPort(port);
                this.setDatabase(database);
                this.setUser(user);
                this.setPassword(password);
                this.setJDBC(jdbc);

                this.setDriver("com.mysql.jdbc.Driver");
                this.setConnectionUrl(jdbc, server, port, database);
            }
        }
   }

   public Connection getConnection()
   {
      try{
        //Class.forName(this.getDriver());
        Class.forName(this.getDriver()).newInstance();

        if ( this.getJDBC().equalsIgnoreCase("sqlserver") || this.getJDBC().equalsIgnoreCase("microsoft:sqlserver")){
            if ( this.getJDBC().equalsIgnoreCase("microsoft:sqlserver"))
                this.connection = DriverManager.getConnection(this.getConnectionUrl(), this.getUser(), this.getPassword());
            if ( this.getJDBC().equalsIgnoreCase("sqlserver"))
                this.connection = DriverManager.getConnection(this.getConnectionUrl());
        }

        if ( this.getJDBC().equalsIgnoreCase("mysql")){
            this.connection = DriverManager.getConnection(this.getConnectionUrl(), this.getUser(), this.getPassword());
        }

        /*
        if(this.connection!=null)
            System.out.println("Conexion correcta.");
        */
      }
      catch(SQLException ex)
      {
         System.out.println(ex);
      }
      catch(ClassNotFoundException ex)
      {
         System.out.println(ex);
      }
      catch(Exception e){
            e.printStackTrace();
            System.out.println("Error de seguimiento en getConnection() : " + e.getMessage());
      }
      return this.connection;
   }

    public void displayDbProperties(){
        DatabaseMetaData dm = null;
        ResultSet rs = null;
        try{
            this.connection = this.getConnection();
            if(this.connection!=null){
                dm = this.connection.getMetaData();
                System.out.println("Informacion del controlador");
                System.out.println("\tNombre del controlador: "+ dm.getDriverName());
                System.out.println("\tVersion del controlador: "+ dm.getDriverVersion ());
                System.out.println("\nInformacion de la base de datos ");
                System.out.println("\tNombre de la base de datos: "+ dm.getDatabaseProductName());
                System.out.println("\tVersion de la base de datos: "+ dm.getDatabaseProductVersion());
                System.out.println("Catalogos disponibles ");
                rs = dm.getCatalogs();
                while(rs.next()){
                    System.out.println("\tcatalogo: "+ rs.getString(1));
                }
                rs.close();
                rs = null;
                this.closeConnection();
            }else
                System.out.println("Error: No hay ninguna conexion activa");
        }catch(Exception e){
            e.printStackTrace();
        }
        dm = null;
    }

    public void closeConnection(){
        try{
            if(this.connection!=null)
                this.connection.close();
            this.connection=null;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


