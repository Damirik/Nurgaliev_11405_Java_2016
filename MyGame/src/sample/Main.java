package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    private int windowWidth = 600;
    private int windowHeight = 600;
    private Random random = new Random();
    private Button currentButton;
    private Timeline timerline;
    private boolean startMove;
    private ArrayList<Button> visibleButtons;
    private Timeline timerline2;
    Timeline timerline3;
    Label time;
    Group root;


    int timeCount;

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("MYgame");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    Scene createScene() {
        root = new Group();


        time = new Label();
        time.setStyle("-fx-font: 30 arial;");
        time.setLayoutX(270);
        time.setLayoutY(24);
        timeCount = 0;

        Button redButton = new Button();
        redButton.setStyle("-fx-font: 12 arial; -fx-background-color: RED;");
        redButton.setLayoutX(42);
        redButton.setLayoutY(72);
        redButton.setMnemonicParsing(false);
        redButton.setPrefSize(80, 80);
        redButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (redButton.getText().equals("RED")) {
                    redButton.setVisible(false);
                    visibleButtons.remove(redButton);
                }
            }
        });

        Button yellowButton = new Button();
        yellowButton.setStyle("-fx-font: 12 arial; -fx-background-color: YELLOW;");
        yellowButton.setLayoutX(142);
        yellowButton.setLayoutY(72);
        yellowButton.setMnemonicParsing(false);
        yellowButton.setPrefSize(80, 80);
        yellowButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (yellowButton.getText().equals("YELLOW")) {
                    yellowButton.setVisible(false);
                    visibleButtons.remove(yellowButton);
                }
            }
        });


        Button orangeButton = new Button();
        orangeButton.setStyle("-fx-font: 12 arial; -fx-background-color: ORANGE;");
        orangeButton.setLayoutX(242);
        orangeButton.setLayoutY(72);
        orangeButton.setMnemonicParsing(false);
        orangeButton.setPrefSize(80, 80);
        orangeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (orangeButton.getText().equals("ORANGE")) {
                    orangeButton.setVisible(false);
                    visibleButtons.remove(orangeButton);
                }
            }
        });


        Button purpleButton = new Button();
        purpleButton.setStyle("-fx-font: 12 arial; -fx-background-color: PURPLE;");
        purpleButton.setLayoutX(342);
        purpleButton.setLayoutY(72);
        purpleButton.setMnemonicParsing(false);
        purpleButton.setPrefSize(80, 80);
        purpleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (purpleButton.getText().equals("PURPLE")) {
                    purpleButton.setVisible(false);
                    visibleButtons.remove(purpleButton);
                }
            }
        });


        Button blueButton = new Button();
        blueButton.setStyle("-fx-font: 12 arial; -fx-background-color: BLUE;");
        blueButton.setLayoutX(442);
        blueButton.setLayoutY(72);
        blueButton.setMnemonicParsing(false);
        blueButton.setPrefSize(80, 80);
        blueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (blueButton.getText().equals("BLUE")) {
                    blueButton.setVisible(false);
                    visibleButtons.remove(blueButton);
                }
            }
        });


        root.getChildren().add(time);
        root.getChildren().add(redButton);
        root.getChildren().add(yellowButton);
        root.getChildren().add(orangeButton);
        root.getChildren().add(purpleButton);
        root.getChildren().add(blueButton);

        visibleButtons = new ArrayList<>();
        visibleButtons.add(redButton);
        visibleButtons.add(yellowButton);
        visibleButtons.add(purpleButton);
        visibleButtons.add(blueButton);
        visibleButtons.add(orangeButton);

        timerline = new Timeline(new KeyFrame(Duration.seconds(0.5), ev -> {
            if (visibleButtons.size() == 0) gameOver();
            else if (visibleButtons.size() > 1) {
                currentButton = new Button();
                int number = random.nextInt(visibleButtons.size());
                currentButton = visibleButtons.get(number);
            } else
                currentButton = visibleButtons.get(0);
            int colorNumber = random.nextInt(5);
            currentButton.setText(String.valueOf(Colors.values()[colorNumber]));
            if (!startMove && visibleButtons.size() == 1) startMoveButton(currentButton);

        }));
        timerline.setCycleCount(Animation.INDEFINITE);
        timerline.play();


        timerline2 = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            time.setText(String.valueOf(timeCount));
            timeCount++;
        }));
        timerline2.setCycleCount(Animation.INDEFINITE);
        timerline2.play();

        return new Scene(root, 600, 500);

    }

    void gameOver() {
        timerline.stop();
        timerline2.stop();
        timerline3.stop();
        time.setText("Score = " + timeCount);
        time.setLayoutX(200);
        time.setLayoutY(200);
        Button restart = new Button("Restart?");
        restart.setStyle("-fx-font: 39 arial; -fx-background-color: RED;");
        restart.setLayoutX(160);
        restart.setLayoutY(250);
        restart.setMnemonicParsing(false);
        restart.setPrefSize(250, 40);
        root.getChildren().add(restart);
        restart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().remove(restart);
                startMove = false;
                start((Stage) root.getScene().getWindow());

            }
        });


    }

    void startMoveButton(Button button) {
        startMove = true;

        FadeTransition ft = new FadeTransition(Duration.millis(1000), button);
        ft.setFromValue(1.0);
        ft.setToValue(0.5);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        timerline3 = new Timeline(new KeyFrame(Duration.seconds(3), ev -> {
            setPlace(button);
        }));
        timerline3.setCycleCount(Animation.INDEFINITE);
        timerline3.play();


    }

    void setPlace(Button button) {
        final Timeline timeline4 = new Timeline();
        timeline4.setAutoReverse(true);
        int x = random.nextInt(500);
        int y = random.nextInt(400);
        final KeyValue kv2 = new KeyValue(button.layoutYProperty(), y);
        final KeyFrame kf2 = new KeyFrame(Duration.millis(1000), kv2);
        final KeyValue kv = new KeyValue(button.layoutXProperty(), x);
        final KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
        timeline4.getKeyFrames().add(kf);
        timeline4.getKeyFrames().add(kf2);
        timeline4.play();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
