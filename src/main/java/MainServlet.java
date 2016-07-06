import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            final String DB_URL="jdbc:hsqldb:mem:FD";

            final String USER = "SA";
            final String PASS = "";

            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection c = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stm = c.createStatement();

            //TEST

            String sql;

            sql = "CREATE TABLE IF NOT EXISTS tbl_users " +
                    "(Login VARCHAR (255)," +
                    "id_role int," +
                    "Password varchar(88)," +
                    "FirstName varchar(255)," +
                    "LastName varchar(255));";


            stm.executeQuery(sql);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);


    }

}
