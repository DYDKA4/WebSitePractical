package services;

import Entities.RelationshipType;
import Entities.RoleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTypeServiceTest {

    @Test
    void addRelationshipType() {
        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType expected_type = new RoleType("Test");
        roleTypeService.addRoleType(expected_type);
        RoleType actual_type = roleTypeService.getRoleTypeById(expected_type.getId());
        assertEquals(actual_type.getId(),expected_type.getId());
        assertEquals(actual_type.getName(),expected_type.getName());
        roleTypeService.deleteRoleType(expected_type);
    }

    @Test
    void updateRelationshipType() {
        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType expected_type = new RoleType("Test");
        roleTypeService.addRoleType(expected_type);
        expected_type.setName("NEW TEST");
        roleTypeService.updateRoleType(expected_type);
        RoleType actual_type = roleTypeService.getRoleTypeById(expected_type.getId());
        assertEquals(actual_type.getId(),expected_type.getId());
        assertEquals(actual_type.getName(),expected_type.getName());
        roleTypeService.deleteRoleType(expected_type);
    }

    @Test
    void deleteRelationshipType() {
        RoleTypeService roleTypeService = new RoleTypeService();
        RoleType expected_type = new  RoleType("Test");
        roleTypeService.addRoleType(expected_type);
        roleTypeService.deleteRoleType(expected_type);
        RoleType actual_type = roleTypeService.getRoleTypeById(expected_type.getId());
        assertNull(actual_type);
    }
}