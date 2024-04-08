package com.meteo;

import com.meteo.models.Selection;
import com.meteo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest (classes = {
        MeteoApplication.class
})
@Sql(scripts = {
        "classpath:/sql/controller/meteo_ddl.sql",
        "classpath:/sql/controller/meteo_dml.sql"
})
public class MeteoApplicationIT {
    @Autowired
    public MeteoApplicationController meteoApplicationController;

    @Test
    void testFindAllUsers_OK() {
        // WHEN
        List<User> result = meteoApplicationController.getAllUsers();

        // THEN
        assertNotNull(result);
    }

    @Test
    void testFindSelectionsByUser_OK() {
        User user = meteoApplicationController.getAllUsers().get(0);

        // WHEN
        List<Selection> result = meteoApplicationController.getAllSelectionsByUser(user);

        // THEN
        assertNotNull(result);
    }

    @Test
    void testInsertUser_OK() {
        User user = new User(42L, "Totodu42", "Tanguy", "Ozano", "fr");

        User newUser = meteoApplicationController.insertUser(user);

        // WHEN
        User result = meteoApplicationController.getUserById(Math.toIntExact(newUser.getId()));

        // THEN
        assertNotNull(result);
    }

    @Test
    void testInsertSelection_OK() {
        User user = meteoApplicationController.getAllUsers().get(0);

        Selection selection = new Selection();
        selection.setLocationSurname("Test Insert");
        selection.setUser(user);

        Selection newSelection = meteoApplicationController.insertSelection(selection);

        // WHEN
        Selection result = meteoApplicationController.getSelectionById(Math.toIntExact(newSelection.getId()));

        // THEN
        assertNotNull(result);
        assertEquals(user.getId(), result.getUser().getId());
    }

    @Test
    void testFindAllSelectionsByUser_OK() {
        User user = meteoApplicationController.getAllUsers().get(0);

        List<Selection> selectionList = meteoApplicationController.getAllSelectionsByUser(user);

        Selection selection = new Selection();
        selection.setLocationSurname("Test FindAll");
        selection.setUser(user);

        Selection newSelection = meteoApplicationController.insertSelection(selection);
        selectionList.add(newSelection);

        // WHEN
        List<Selection> result = meteoApplicationController.getAllSelectionsByUser(user);

        // THEN
        assertNotNull(result);
        assertEquals(selectionList.size(), result.size());
        if (selectionList.size() == result.size()) {
            for (int i = 0; i < selectionList.size(); i++) {
                assertEquals(selectionList.get(i).getId(), result.get(i).getId());
                System.out.println(result.get(i).getId());
            }
        }
    }

    @Test
    void testUpdateUser_OK() {
        User user = meteoApplicationController.getAllUsers().get(0);

        user.setLang("Eng");

        User newUser = meteoApplicationController.insertUser(user);

        // WHEN
        User result = meteoApplicationController.getUserById(Math.toIntExact(newUser.getId()));

        // THEN
        assertNotNull(result);
        assertEquals("Eng", result.getLang());
    }

    @Test
    void testInsertSelectionInNewUser_OK() {
        User user = new User(42L, "Totodu42", "Tanguy", "Ozano", "fr");

        User newUser = meteoApplicationController.insertUser(user);

        Selection selection = new Selection();
        selection.setLocationSurname("Test Insert");
        selection.setUser(newUser);

        Selection newSelection = meteoApplicationController.insertSelection(selection);

        // WHEN
        Selection result = meteoApplicationController.getSelectionById(Math.toIntExact(newSelection.getId()));

        // THEN
        assertNotNull(result);
        assertEquals(newUser.getId(), result.getUser().getId());
    }

}
