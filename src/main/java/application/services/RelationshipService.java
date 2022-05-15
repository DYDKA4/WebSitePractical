package application.services;

import application.DAO.RelationshipDAO;
import application.Entities.Person;
import application.Entities.Relationship;

import java.util.List;

public class RelationshipService {
    private RelationshipDAO relationshipDAO = new RelationshipDAO();

    public RelationshipService(){

    }
    public void addRelationship(Relationship relationship){
        relationshipDAO.addRelationship(relationship);
    }
    public void updateRelationship(Relationship relationship){
        relationshipDAO.updateRelationship(relationship);
    }
    public void deleteRelationship(Relationship relationship){
        relationshipDAO.deleteRelationship(relationship);
    }
    public Relationship getRelationshipById(Long id){
        return relationshipDAO.getRelationshipById(id);
    }
    public List<Relationship> getRelationshipByPerson2(Long id){
        return relationshipDAO.getRelationshipByPerson2(id);
    }
    public List<Relationship> getRelationshipBetweenPerson1Person2(Person person1, Person person2){
        return relationshipDAO.getRelationshipBetweenPerson1Person2(person1, person2);
    }
}
