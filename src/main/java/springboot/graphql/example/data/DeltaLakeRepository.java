package springboot.graphql.example.data;
import java.sql.*;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import com.simba.spark.jdbc4.Driver;
import org.springframework.stereotype.Component;
import springboot.graphql.example.data.model.Section;

@Component
public class DeltaLakeRepository {

    //jdbc:spark://$dbcHost:443/default;transportMode=http;
    //
    // ssl=1;httpPath=sql/protocolv1/o/0/$dbcClusterId;AuthMech=3;UID=token;PWD=$dbcUserToken
    public Connection getDeltaConnection() {
        String jdbcurlwithtoken = "";
        Connection con = null;
        try {
            System.out.println("Delta getconnection");
            Class.forName("com.simba.spark.jdbc4.Driver");
            con = DriverManager.getConnection(
                    jdbcurlwithtoken);
//here sonoo is database name, root is username and password
            System.out.println("Delta Connection obtained");

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;

    }

    public List<Section> getAllSection(){
        List<Section> sectionList = new ArrayList<>();
        try{
            Connection con = getDeltaConnection();
            System.out.println("Create stmt");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from poc.section ");
            System.out.println("Execution done stmt");
            while (rs.next()) {
                Section s = new Section();
//                s.setSectionid(rs.getInt("sectionid"));
                Integer sid = rs.getInt(1);
                System.out.println("id " + sid);
                s.setSectionid(sid);
                s.setSectionname(rs.getString("sectionname"));
                s.setSectionxid(rs.getString("sectionxid"));
                s.setCoursexid(rs.getString("coursexid"));
                System.out.println("rs " + rs.getInt(1) + "  " + rs.getString(2));
                sectionList.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return sectionList;
    }


    public Section getSectionById(int id){
        Section s = new Section();
        try{
            Connection con = getDeltaConnection();
            System.out.println("Create stmt");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from poc.section where sectionid = " + id);
            System.out.println("Execution done stmt");
            while (rs.next()) {
                s.setSectionid(id);
//                s.setSectionid(rs.getInt("sectionid"));
                s.setSectionname(rs.getString("sectionname"));
                s.setSectionxid(rs.getString("sectionxid"));
                s.setCoursexid(rs.getString("coursexid"));
                System.out.println("rs " + rs.getInt(1) + "  ");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    public Section insertSection(int id, String sectionName, String sectionXID, String courseXID){
        Section s = new Section(id, sectionName,sectionXID, courseXID);
        try{
        Connection con = getDeltaConnection();
        System.out.println("Create stmt");
        Statement stmt = con.createStatement();
        String query = " insert into poc.section values( " + id +" ,\'" + sectionName +"\'," +" \'" +sectionXID +"\'," +" \'"+ courseXID +"\' )";
        System.out.println(query);
            stmt.execute(query);
            con.commit();
//            stmt.executeQuery(" insert into poc.section values( " + id +" \'," + sectionName +"\'," +" \'" +sectionXID +"\'," +" \'"+ courseXID +"\' )"  );
        System.out.println("Execution done stmt");
        con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }


    public String deleteSection(int id){
        try{
            Connection con = getDeltaConnection();
            System.out.println("Create stmt");
            Statement stmt = con.createStatement();
            String query = " delete from poc.section where sectionid =  " + id;
            System.out.println(query);
            stmt.executeUpdate(query );
            System.out.println("Execution done stmt");
            con.commit();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
            return "Error while deletion";
        }
        return "Delete Successful";
    }

}

