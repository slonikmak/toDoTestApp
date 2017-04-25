package org.stnetix.toDoApp.dataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.stnetix.toDoApp.config.SpringConfig;
import org.stnetix.toDoApp.models.TaskItem;

import java.util.List;

/**
 * Created by Anton on 13.03.2017.
 */
@ContextConfiguration(classes = SpringConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class JpaProxyTaskRepositoryTest {
    @Autowired
    ITaskDAO repository;

    @Test
    public void sampleTest(){
        TaskItem item1 =new TaskItem("item1");
        TaskItem item2 = new TaskItem("item2");

        repository.save(item1);
        repository.save(item2);

        List<TaskItem> list = repository.findAll();

        list.forEach(System.out::println);
    }
}