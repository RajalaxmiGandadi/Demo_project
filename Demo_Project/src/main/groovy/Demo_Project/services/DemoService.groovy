package Demo_Project.services



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository

import java.sql.ResultSet
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class DemoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<Object> getAllRecord(){
        List<Object> rs;

            String sql = "SELECT * FROM Test_User"
            rs= jdbcTemplate.queryForList(sql);

        return rs;

    }

    public int delete(int id)
    {
        int r;
        r =  jdbcTemplate.update("delete from Test_User where id="+id);
        return r;
    }


    public int update(int id)
    {
        int r = jdbcTemplate.update("update Test_User set ")
        return r;

    }


    public int create(String name,long phNo, String mailId)
    {
        String sql = "Insert into Test_User(Name,Mobile_number,email_id) values(?,?,?)";
        int r = jdbcTemplate.update(sql,name,phNo,mailId);
        return r;
    }


    public int update(int id, String name,String mail_id,long phNo)
    {
        String query="";
        if(!name.equals(null))
            query=" Name = '"+name+"'";
        if(phNo!=0)
            query = query+" , Mobile_number = "+phNo;
        if(!mail_id.equals(null))
            query = query+" , email_id='"+mail_id+"'"
        query = query.trim().replaceAll("^,","")
        query =  "update Test_User set" +query+ " where id="+id
        int r = jdbcTemplate.update(query)
        return r;
    }

}