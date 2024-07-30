package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.MembersDao;
import dto.MembersDto;
import entity.MembersEntity;
import service.custom.MembersService;

public class MembersServiceImpl implements MembersService {

    private MembersDao membersDao = (MembersDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.Members);


    @Override
    public String save(MembersDto membersDto) throws Exception {
        MembersEntity entity = getMembersEntity(membersDto);
        return membersDao.create(entity) ? "Success" : "Fail";
    }

    @Override
    public String update(MembersDto membersDto) throws Exception {
        MembersEntity entity = getMembersEntity(membersDto);
        return membersDao.update(entity) ? "Success" : "Fail";
    }

    @Override
    public String delete(Integer memberID) throws Exception {
        return membersDao.delete(memberID) ?  "Success" : "Fail";
    }

    @Override
    public MembersDto get(Integer memberID) throws Exception {
       return null;
    }

    @Override
    public ArrayList<MembersDto> getAll() throws Exception {
         ArrayList<MembersEntity> membersEntitys = membersDao.getAll();
        if(membersEntitys != null && !membersEntitys.isEmpty()){
            ArrayList<MembersDto> membersDtos = new ArrayList<>();

            for (MembersEntity membersEntity : membersEntitys) {
                membersDtos.add(getMembersDto(membersEntity));
            }

            return membersDtos;
        }
        return null;
    }
    
    private MembersEntity getMembersEntity(MembersDto membersDto){
        return new MembersEntity(
            membersDto.getMemberID(),
            membersDto.getFirstName(),
            membersDto.getLastName(),
            membersDto.getGender(),
            membersDto.getBirthDate(),
            membersDto.getAddress(),
            membersDto.getPhoneNumber(),
            membersDto.getEmail()
        );
    }

    private MembersDto getMembersDto(MembersEntity membersEntity){
        return new MembersDto(
            membersEntity.getMemberID(),
            membersEntity.getFirstName(),
            membersEntity.getLastName(),
            membersEntity.getGender(),
            membersEntity.getBirthDate(),
            membersEntity.getAddress(),
            membersEntity.getPhoneNumber(),
            membersEntity.getEmail()
       );
    }
}
