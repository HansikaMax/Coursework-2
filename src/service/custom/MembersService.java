package service.custom;

import java.util.ArrayList;

import dto.MembersDto;
import service.SuperService;

public interface MembersService extends SuperService {
     String save(MembersDto membersDto) throws Exception;
    String update(MembersDto membersDto) throws Exception;
    String delete(Integer memberID) throws Exception;
    MembersDto get(Integer memberID) throws Exception;
    ArrayList<MembersDto> getAll() throws Exception;
}
