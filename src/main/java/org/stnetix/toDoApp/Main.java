package org.stnetix.toDoApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.stnetix.toDoApp.config.SpringConfig;
import org.stnetix.toDoApp.loaderProvaider.FXMLLoaderProvider;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        FXMLLoader loader = ctx.getBean(FXMLLoaderProvider.class).getLoader("/main.fxml");
        Parent root = loader.load();
        primaryStage.setTitle("ToDo application");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
        /*ITaskDAO repository = ctx.getBean(ITaskDAO.class);

        TaskItem item1 =new TaskItem("item1");
        TaskItem item2 = new TaskItem("item2");

        repository.save(item1);
        repository.save(item2);

        List<TaskItem> list = repository.findAll();

        list.forEach(System.out::println);*/
    }


    public static void main(String[] args) {
        launch(args);
    }
}
