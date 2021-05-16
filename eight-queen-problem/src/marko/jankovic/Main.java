package marko.jankovic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    static Manager manager;
    int count;

    public static void main(String[] args) {
        manager = new Manager(8);
        launch(args);
    }

    public int[] convert(String s) {
        String[] items = s.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");

        int[] results = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            results[i] = Integer.parseInt(items[i]);
        }
        return results;
    }

    public void start(Stage stage) throws Exception {
        GUI chess = new GUI();

        count = 1;
        String s = manager.permutations.get(count);
        int[] show = convert(s);
        chess.drawQueens(show);
        chess.back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (count == 1) {
                    count = manager.permutations.size();
                } else {
                    count--;
                }
                chess.drawQueens(convert(manager.permutations.get(count-1)));
                chess.label.setText("" + count + "/" + manager.permutations.size());
            }
        });
        chess.next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (manager.permutations.size() == count) {
                    count = 1;
                } else {
                    count++;
                }
                chess.drawQueens(convert(manager.permutations.get(count-1)));
                chess.label.setText("" + count + "/" + manager.permutations.size());
            }
        });

        Scene scene = new Scene(chess, 800,600);

        stage.setScene(scene);
        stage.setHeight(675);
        stage.setWidth(753);
        stage.setResizable(true);
        stage.show();
    }
}
