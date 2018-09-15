import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View extends Application {
    
    private Scene get_login_scene(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text login_title = new Text("Login");
        login_title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(login_title, 0, 0, 2, 1);
        
        Text username = new Text("Username");
        grid.add(username, 0, 1);
        
        TextField username_field = new TextField();
        grid.add(username_field, 1, 1);
        
        Text password = new Text("Password");
        grid.add(password, 0, 2);
        
        PasswordField password_field = new PasswordField();
        grid.add(password_field, 1, 2);
        
        Button login = new Button();
        login.setText("Login");
        
        HBox hb = new HBox(20);
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.getChildren().add(login);
        grid.add(hb, 1, 3);
        
        Scene scene = new Scene(grid, 400, 300);
        return scene;
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("testing");
        stage.setScene(get_login_scene(stage));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
