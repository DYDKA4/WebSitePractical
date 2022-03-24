package services;

import Entities.RelationshipType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelationshipTypeServiceTest {

    @Test
    void addRelationshipType() {
        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType expected_type = new RelationshipType("Test");
        relationshipTypeService.addRelationshipType(expected_type);
        RelationshipType actual_type = relationshipTypeService.getRelationshipTypeById(expected_type.getId());
        assertEquals(actual_type.getId(),expected_type.getId());
        assertEquals(actual_type.getName(),expected_type.getName());
        relationshipTypeService.deleteRelationshipType(expected_type);
    }

    @Test
    void updateRelationshipType() {
        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType expected_type = new RelationshipType("Test");
        relationshipTypeService.addRelationshipType(expected_type);
        expected_type.setName("NEW TEST");
        relationshipTypeService.updateRelationshipType(expected_type);
        RelationshipType actual_type = relationshipTypeService.getRelationshipTypeById(expected_type.getId());
        assertEquals(actual_type.getId(),expected_type.getId());
        assertEquals(actual_type.getName(),expected_type.getName());
        relationshipTypeService.deleteRelationshipType(expected_type);
    }

    @Test
    void deleteRelationshipType() {
        RelationshipTypeService relationshipTypeService = new RelationshipTypeService();
        RelationshipType expected_type = new RelationshipType("Test");
        relationshipTypeService.addRelationshipType(expected_type);
        relationshipTypeService.deleteRelationshipType(expected_type);
        RelationshipType actual_type = relationshipTypeService.getRelationshipTypeById(expected_type.getId());
        assertNull(actual_type);
    }
}