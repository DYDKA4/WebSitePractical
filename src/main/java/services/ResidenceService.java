package services;


import DAO.ResidenceDAO;
import Entities.Residence;

import java.util.List;

public class ResidenceService {
    private ResidenceDAO residenceDAO = new ResidenceDAO();

    public ResidenceService(){
    }
    public void deleteResidence(Residence person){ residenceDAO.deleteResidence(person); }
    public void updateResidence(Residence person){ residenceDAO.updateResidence(person); }
    public void addResidence(Residence person){
        residenceDAO.addResidence(person);
    }
    public Residence getResidenceById(Long id){
        return residenceDAO.getResidenceById(id);
    }
    public List<Residence> getResidenceByAddress(String address){
        return residenceDAO.getResidenceByAddress(address);
    }
}
