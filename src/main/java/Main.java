import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Location of database and granted access
        String url = "jdbc:postgresql://localhost:5432/MenuForBytesOfChina";
        String uname = "postgres";
        String pass = "123";

        //Information to go into the database
        int id = 1;
        String name = "Bytes Of China";
        String description = "An authentic Chinese restaurant!";
        double rating = 6.7;

        String query = "INSERT INTO restaurant VALUES (?,?,?,?)";

        //Registering the driver
        Class.forName("org.postgresql.Driver");

        //Establishing the connection
        Connection con = DriverManager.getConnection(url,uname,pass);

        //Creating the statement: Statement, PreparedStatement or Callable Statement.
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        st.setString(2, name);
        st.setString(3, description);
        st.setDouble(4, rating);

        //Executing the statement
        int rowsChanged = st.executeUpdate();
        //Processing the result
        System.out.println("Number of rows affected: " + rowsChanged);

        //Closing the connection and statement.
        st.close();
        con.close();

    }




}
