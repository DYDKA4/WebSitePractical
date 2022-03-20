package services;


import DAO.ResidenceDAO;
import Enteties.Residence;

public class ResidenceService {
    private ResidenceDAO residenceDAO = new ResidenceDAO();

    public ResidenceService(){
    }

    public void addResidence(Residence residence){
        residenceDAO.addResidence(residence);
    }


}
