import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * My Program 3 solution
 * @author Brennan Sweney
 */
public class Program3 extends Application {
    
    WheelBrennanS theWheel = new WheelBrennanS();
    PieChart wheel = new PieChart();
    private TextArea210 ta210;

    /**
     * start method for Program 3
     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CSCE210 Program 3 - The Wheel Gui!!!!");

        //creating the menu bar
        MenuBar mb = createMenuBar();

        //creating the text area
        ta210 = createTextArea();

        //creating the box
        VBox vBox = createVBox();

        //creating the VBox
        VBox topBox = new VBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(mb, vBox, ta210.getTextArea());

        Scene scene = new Scene(topBox, 960, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * creating a menubar 
     * @return a menubar with all the menus added to it.
     */
    public MenuBar createMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menu1 = createMenu1();
        Menu menu2 = createMenu2();
        Menu menu3 = createMenu3();

        menuBar.getMenus().addAll(menu1, menu2, menu3);
        return menuBar;
    }

    /**
     * creates a menu for the menubar
     * @return menu "Program 3"
     */
    public Menu createMenu1() {
        Menu m = new Menu("Program 3");
        
        //gives a general description about the program
        MenuItem mi = new MenuItem("About");
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            System.out.println("Menu Item 1 Selected");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("This is our Wheel GUI");
            alert.setContentText("The actions menu includes random, reverse, and clear the text area.\nThe report menu includes first, last, size, and print.");
            alert.showAndWait();
        });

        // Program3/Exit - exits the program
        mi = new MenuItem("Exit"); // second menu item
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            System.exit(0);
        });
        return m;
    }

    /**
     * creating a menu for the menubar
     * @return menu2 "Action"
     */
    public Menu createMenu2() {
        Menu m = new Menu("Action");

        //Action/Random - picks a random item from the wheel
        MenuItem mi = new MenuItem("Random");
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            String s = theWheel.getRandomItem();
            ta210.println(s + " is the random item selected.");
        });

        //Action/Reverse - reverses the items in the wheel
        mi = new MenuItem("Reverse");
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            theWheel.reverse();
        });
    
        // Action/Clear - clear the text area
        mi = new MenuItem("Clear Text Area");
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            ta210.clear();
        });
        return m;
    }

    /**
     * creating a menu for the menubar
     * @return menu3 "Report"
     */
    public Menu createMenu3() {
        Menu m = new Menu("Report");

        //Report/First - gets first item in wheel
        MenuItem mi = new MenuItem("First");
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            ta210.println(theWheel.getFirstItem());
        });

        //Report/Last - gets last item in wheel
        mi = new MenuItem("Last");
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            ta210.println(theWheel.getLastItem());
        });

        //Report/size - gets size of the wheel
        mi = new MenuItem("Size");
        m.getItems().add(mi);
        mi.setOnAction(e -> {
            int i = theWheel.getSizeItem();
            String size = Integer.toString(i);
            ta210.println("The size of the wheel is: " + size);
        });

        //Report/Print - prints the items in the wheel
        mi = new MenuItem("Print");
        m.getItems().addAll(mi);
        mi.setOnAction(e -> {
            for(int i = theWheel.getSizeItem(); i > 0; i-- ) {
                ta210.print(theWheel.get(i) + ", ");
            }
        });
        return m;
    }

    /**
     * Creates a Vbox that is filled with buttons, text areas, pie chart, and hboxes.
     * @return a Vbox 
     */
    public VBox createVBox() {
        //creating a vbox
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        //creating a hbox
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));

        //creating the button hbox
        HBox hBox2 = new HBox(10);
        hBox2.setAlignment(Pos.CENTER);

        //creating piechart
        PieChart wheel = new PieChart();

        //creating a rotation transition
        RotateTransition rt = new RotateTransition(Duration.seconds(1), wheel);
        rt.setByAngle(360);
        rt.setCycleCount(2);

        //Spin button
        Button spin = new Button("Spin");
        spin.setOnAction(e -> {
            rt.play();
            String s = theWheel.spin();
            ta210.println("The item selected was " + s);
            wheel.getData().clear();
            for(int i = theWheel.getSizeItem(); i > 0; i-- ) {
                PieChart.Data slice = new PieChart.Data(theWheel.get(i), 1);
                wheel.getData().add(slice);
            }
        });

        //Reload Button
        Button reload = new Button("Reload");
        reload.setOnAction(e -> {
            theWheel.reload();
            ta210.println("Reloading the items");
            wheel.getData().clear();
            for(int i = theWheel.getSizeItem(); i > 0; i-- ) {
                PieChart.Data slice = new PieChart.Data(theWheel.get(i), 1);
                wheel.getData().add(slice);
            }
        });

        //Clear the wheel Button
        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            theWheel.clear();
            wheel.getData().clear();
            ta210.println("The wheel has been cleared.");
        });

        //creating a label for the piechart
        Label wheelName = new Label(theWheel.getName());
        wheelName.setAlignment(Pos.CENTER);
        wheelName.setPadding(new Insets(10));
        wheelName.setFont(new Font("Times New Roman", 24));

        //creating the add label and text area
        Label addLabel = new Label("Add: ");
        TextField add = new TextField();
        add.setPrefColumnCount(4);
        add.setOnAction(e -> {
            String s = add.getText().trim();
            ta210.println("The item " + s +" was added to the wheel.");
            theWheel.addItem(s);
            PieChart.Data slice = new PieChart.Data(s, 1);
            wheel.getData().add(slice);
        });

        //creating the name label and text area
        Label nameLabel = new Label("Name: ");
        TextField name = new TextField();
        name.setPrefColumnCount(4);
        name.setOnAction(e -> {
            String s = name.getText().trim();
            theWheel.setName(s);
            ta210.println('"' + theWheel.getName() + '"' + " is the name of your wheel.");
            wheelName.setText(theWheel.getName());
        });

        //adding items to the hbox
        hBox.getChildren().addAll(addLabel, add, nameLabel, name);
        hBox2.getChildren().addAll(spin, reload, clear);
        vBox.getChildren().addAll(hBox, hBox2, wheelName, wheel);
        return vBox;
    }

    /**
    * Create a fancy text area and return it.
    * @return Returns a fancy text area
    */
    private TextArea210 createTextArea() {
        TextArea210 tmp = new TextArea210();
        tmp.println("This is your text area for the wheel");

        // style up the JavaFX TextArea, 8 rows/lines
        TextArea ta = tmp.getTextArea();
        ta.setStyle("-fx-border-color: RED; -fx-border-width: 2px; -fx-font-size: 1.4em;");
        ta.setPrefRowCount(8);
        return tmp;
    }

    public static void main(String[] args) {
        launch(args);
    }
}