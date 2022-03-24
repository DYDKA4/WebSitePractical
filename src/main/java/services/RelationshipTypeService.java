package services;

import DAO.RelationshipTypeDAO;
import Entities.RelationshipType;

public class RelationshipTypeService {
    private RelationshipTypeDAO relationshipTypeDAO = new RelationshipTypeDAO();

    public RelationshipTypeService(){

    }
    public void addRelationshipType(RelationshipType relationshipType){
        relationshipTypeDAO.addRelationshipType(relationshipType);
    }
    public void updateRelationshipType(RelationshipType relationshipType){
        relationshipTypeDAO.updateRelationshipType(relationshipType);
    }
    public void deleteRelationshipType(RelationshipType relationshipType){
        relationshipTypeDAO.deleteRelationshipType(relationshipType);
    }
    public RelationshipType getRelationshipTypeById(Long id){
        return relationshipTypeDAO.getRelationshipTypeById(id);
    }
}
