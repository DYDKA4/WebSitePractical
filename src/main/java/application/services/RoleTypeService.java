package application.services;

import application.DAO.RoleTypeDAO;
import application.Entities.RoleType;

public class RoleTypeService {
    private RoleTypeDAO roleTypeDAO = new RoleTypeDAO();

    public RoleTypeService(){

    }
    public void addRoleType(RoleType roleType){
        roleTypeDAO.addRoleType(roleType);
    }
    public void updateRoleType(RoleType roleType){
        roleTypeDAO.updateRoleType(roleType);
    }
    public void deleteRoleType(RoleType roleType){
        roleTypeDAO.deleteRoleType(roleType);
    }
    public RoleType getRoleTypeById(Long id){
        return roleTypeDAO.getRoleTypeById(id);
    }
}
