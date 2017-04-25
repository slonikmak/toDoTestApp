package org.stnetix.toDoApp.controllers;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.stnetix.toDoApp.models.TaskItem;

/**
 * Created by Anton on 12.02.2017.
 */
@Component
@Scope("prototype")
public class TaskController {
    private MainController mainController;

    private TaskItem taskItem;

    @FXML
    private AnchorPane taskContainer;

    @FXML
    private Label taskHeader;

    @FXML
    private Label taskStatus;

    @FXML
    private CheckBox complitedCheckBox;

    @FXML
    void deleteTask(ActionEvent event) {
        mainController.deleteTask(taskItem);
    }

    public void setTask(TaskItem task){
        this.taskItem = task;

        taskHeader.setText(task.getName());

        if (task.getCompleted()){
            taskStatus.setText("completed");
            taskContainer.pseudoClassStateChanged(PseudoClass.getPseudoClass("completed"), true);
        }
        complitedCheckBox.selectedProperty().bindBidirectional(taskItem.completedProperty());
        taskItem.completedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                taskStatus.setText("completed");
                taskContainer.pseudoClassStateChanged(PseudoClass.getPseudoClass("completed"), true);
            }
            else {
                taskStatus.setText("active");
                taskContainer.pseudoClassStateChanged(PseudoClass.getPseudoClass("completed"), false);
            }
        });
    }

    @Autowired
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
