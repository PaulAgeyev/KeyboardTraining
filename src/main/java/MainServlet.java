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
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*try {

            final String DB_URL="jdbc:hsqldb:mem:FD";

            final String USER = "SA";
            final String PASS = "";

            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            Connection c = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stm = c.createStatement();

            String sql;

            sql = "CREATE TABLE IF NOT EXISTS S (s1 int)";

            ResultSet rs = stm.executeQuery(sql);

            sql = "INSERT INTO S (s1) VALUES (444)";

            rs = stm.executeQuery(sql);

            sql = "SELECT s1 FROM S";

            rs = stm.executeQuery(sql);

            while (rs.next()) {

                request.setAttribute("textA", rs.getInt("S1"));

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        request.setAttribute("textA", "Hello World!");

        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);


    }

}
