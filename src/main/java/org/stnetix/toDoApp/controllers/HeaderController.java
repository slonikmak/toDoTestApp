package org.stnetix.toDoApp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stnetix.toDoApp.models.TaskItem;

/**
 * Created by Anton on 12.02.2017.
 */
@Component
public class HeaderController {
    private MainController mainController;

    @FXML
    private TextField taskNameInput;

    @FXML
    void addTask(ActionEvent event) {
        mainController.addTask(new TaskItem(taskNameInput.getText()));
    }

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
