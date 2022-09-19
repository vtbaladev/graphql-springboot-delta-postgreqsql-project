package springboot.graphql.example.data;

import org.springframework.stereotype.Component;
import springboot.graphql.example.data.model.Accounts;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostgresqlRepository {

    public Accounts getAccountById(int id) {
        Connection c = null;
        Statement stmt = null;
        Accounts account = new Accounts();
        try {
            c = getPostgresqlConnection();

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM public.accounts where account_id = " + id + ";" );

            while ( rs.next() ) {
                account.setId(rs.getInt("account_id"));
                account.setUsername(rs.getString("username"));
                account.setEmail(rs.getString("email"));
                account.setSection(rs.getString("section"));
                account.setCoursexid(rs.getString("coursexid"));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return account;
    }

    public List<Accounts> getAllAccounts() {
        Connection c = null;
        Statement stmt = null;
        List<Accounts> accountsList = new ArrayList<>();
        try {
            c = getPostgresqlConnection();

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM public.accounts;" );

            while ( rs.next() ) {
                Accounts account = new Accounts();
                account.setId(rs.getInt("account_id"));
                account.setUsername(rs.getString("username"));
                account.setEmail(rs.getString("email"));
                account.setSection(rs.getString("section"));
                account.setCoursexid(rs.getString("coursexid"));
                accountsList.add(account);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return accountsList;
    }

    public Accounts insertAccounts(int id, String name, String coursexid, String email, String section) {
        Connection c = null;
        Statement stmt = null;
        Accounts accounts = new Accounts(id, name, coursexid, email, section);
        try {
            c = getPostgresqlConnection();
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "INSERT INTO  public.accounts (account_id, username, coursexid,email, section) "
                    + "VALUES (" + id+"," + "\'"+ name + "\'" +"," +"\'"+ coursexid +"\'"+"," +"\'"+ email +"\'"+ "," +"\'"+ section +"\'"+ ");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//            System.exit(0);
        }
        System.out.println("Records created successfully");
        return accounts;
    }

    public String deleteAccounts(int id) {
        Connection c = null;
        Statement stmt = null;

        try {
            c = getPostgresqlConnection();
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "Delete from public.accounts where account_id = " + id;
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//            System.exit(0);
        }
        System.out.println("Records deleted successfully");
        return id + " Delete completed";
    }

    public Connection getPostgresqlConnection() {
        Connection conn = null;
        String password = "";
        String username = "";
        String jdbcurl = "";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection(jdbcurl,
                            username, password);
            conn.setAutoCommit(false);
            System.out.println("Opened database successfully");

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;

    }
}