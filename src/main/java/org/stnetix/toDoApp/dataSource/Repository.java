package org.stnetix.toDoApp.dataSource;

import javafx.beans.Observable;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stnetix.toDoApp.models.TaskItem;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Anton on 12.02.2017.
 */
@org.springframework.stereotype.Repository
public class Repository {

    private ITaskDAO dataRepository;

    public Repository(){

    }

    @PostConstruct
    private void setup(){
        //dataRepository.save(new TaskItem("newTask"));
        List<TaskItem> list = dataRepository.findAll();
        allTasks.addAll(list);
        allTasks.addListener((ListChangeListener<TaskItem>) c -> {
            c.next();
            if (c.wasRemoved()){
                dataRepository.delete(c.getRemoved());
            } else if(c.wasAdded()) {
                dataRepository.save(c.getAddedSubList());
            } else {
                dataRepository.save(allTasks.get(c.getFrom()));
            }
        });

    }


    private ObservableList<TaskItem> allTasks = FXCollections.observableArrayList(item->new Observable[]{item.completedProperty()});

    private FilteredList<TaskItem> completedTasks = new FilteredList<TaskItem>(allTasks, TaskItem::getCompleted);

    private FilteredList<TaskItem> activeTasks = new FilteredList<TaskItem>(allTasks, taskItem -> !taskItem.getCompleted());

    private ListProperty<TaskItem> tasksProperty = new SimpleListProperty<>(allTasks);



    public ListProperty<TaskItem> getTasksProperty() {
        return tasksProperty;
    }

    public void showAllTasks(){
        tasksProperty.set(allTasks);
    }

    public void showCompletedTasks(){
        tasksProperty.set(completedTasks);
    }

    public void showActiveTasks(){
        tasksProperty.set(activeTasks);
    }

    public void addTasks(TaskItem item){
        allTasks.add(item);
        dataRepository.save(item);
    }

    public void deleteTask(TaskItem item){
        allTasks.remove(item);
        dataRepository.delete(item);
    }

    public ITaskDAO getDataRepository() {
        return dataRepository;
    }
    @Autowired
    public void setDataRepository(ITaskDAO dataRepository) {
        this.dataRepository = dataRepository;
    }
}
