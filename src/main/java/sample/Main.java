package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import user.League;
import user.Match;
import user.Scraping;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        Scraping scraping = new Scraping();

        scraping.getLeaguesFromJson();
        ArrayList<League> leagues = scraping.getLeagues();

        for(League l : leagues)
        {
            for(Match m : l.getGames())
            {
                System.out.println(m.getTeam1() + " " + m.getOdd(2).getOdd() + " " + m.getOdd(0).getTeam2());
            }
        }
       /* JSONArray leagues = jsonObject.getJSONArray("data");
        System.out.println(leagues.length());*/
        //launch(args);
        System.exit(0);
    }
}

