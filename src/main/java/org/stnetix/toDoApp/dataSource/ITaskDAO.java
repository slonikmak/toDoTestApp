package org.stnetix.toDoApp.dataSource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stnetix.toDoApp.models.TaskItem;

import java.util.List;

/**
 * Created by Anton on 13.03.2017.
 */
public interface ITaskDAO extends JpaRepository<TaskItem, Long> {
    TaskItem findById(long id);
    TaskItem save(TaskItem taskItem);
    void delete(TaskItem taskItem);
    List<TaskItem> findAll();
}

