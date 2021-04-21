package sed.home.simplefx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class App extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {       
        AtomicInteger currentImage = new AtomicInteger();
        
        //Load images
        List<Image> images = new ArrayList();
        List<String> cardSuits = Arrays.asList("spades", "diamonds", "clubs", "hearts");
        List<String> cardFace = Arrays.asList("ace", "2", "3", "jack");
        for(int i = 0; i < cardSuits.size(); i++)
        {
            for(int t = 0; t < cardFace.size(); t++)
            {
                 Image image = new Image(App.class.getResourceAsStream("images/deck/" + cardFace.get(t) + "_of_" + cardSuits.get(i) + ".png"));                
                 images.add(image);
            }
        }
                
        //Load the first image
        ImageView ivDisplay = new ImageView(images.get(currentImage.get()));
        ivDisplay.setFitHeight(100);
        ivDisplay.setFitWidth(100);
        
        //Handle previous button
        Button btnPrevious = new Button("<-");
        btnPrevious.setMaxHeight(Double.MAX_VALUE);
        btnPrevious.setOnAction((actionEvent) -> {
            if(currentImage.get() > 0)
            {
                ivDisplay.setImage(images.get(currentImage.decrementAndGet()));
            }
        });
        
        //Handle next button
        Button btnNext = new Button("->");
        btnNext.setMaxHeight(Double.MAX_VALUE);
         btnNext.setOnAction((actionEvent) -> {
            if(currentImage.get() < images.size() - 1)
            {
                ivDisplay.setImage(images.get(currentImage.incrementAndGet()));
            }
        });
         
        HBox root = new HBox(btnPrevious, ivDisplay, btnNext);        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
}