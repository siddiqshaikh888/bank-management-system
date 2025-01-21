import java.sql.*;

public class conn{
Connection c;
Statement s;
public Object conn;
public conn(){
try{
c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
s= c.createStatement();
}
catch(Exception e){
System.out.println(e);
}
}
}