package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.MembersDao;
import entity.MembersEntity;

public class MembersDaoImpl implements MembersDao {

    @Override
    public boolean create(MembersEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO Members VALUES(?,?,?,?,?,?,?,?)",t.getMemberID(),t.getFirstName(),t.getLastName(),t.getGender(),t.getBirthDate(),t.getAddress(),t.getPhoneNumber(),t.getEmail());
    }

    @Override
    public boolean update(MembersEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Members SET FirstName=?, LastName=?, Gender=?, BirthDate=?, Address=?, PhoneNumber=?, Email=? WHERE MemberID=? ",t.getFirstName(),t.getLastName(),t.getGender(),t.getBirthDate(),t.getAddress(),t.getPhoneNumber(),t.getEmail(), t.getMemberID() );
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Members WHERE MemberID = ?", id);
    }

    @Override
    public MembersEntity get(Integer id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<MembersEntity> getAll() throws Exception {
        ArrayList<MembersEntity> membersEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Members");
        while (rst.next()) {            
            MembersEntity entity = new MembersEntity(rst.getInt("MemberID"), 
                    rst.getString("FirstName"), rst.getString("LastName"), 
                    rst.getString("Gender"), rst.getString("BirthDate"),rst.getString("Address"),rst.getString("PhoneNumber"),rst.getString("Email"));
            membersEntities.add(entity);
        }
        return membersEntities;
    }
    
}
