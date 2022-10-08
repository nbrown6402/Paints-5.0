package com.example.paints;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static javafx.scene.control.ButtonBar.ButtonData.OK_DONE;

public class Save {

    //*********************    Save As   ************************************\\

    /**
     * Save as function
     * @param canv
     */
    void SavingNewImage(Canvas canv) {
        Stage stage = new Stage();
        FileChooser savefile = new FileChooser();
        savefile.setTitle("Save File");
        savefile.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG ", "*.png"), new FileChooser.ExtensionFilter("JPEG", "*.jpg"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"), new FileChooser.ExtensionFilter("PDF", "*.pdf"));

        File file = savefile.showSaveDialog(stage);
        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage((int) canv.getWidth(), (int) canv.getHeight());
                canv.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }
    }

    //**********************    Save   **************************************\\

    /**
     * Save function (if the canvas hasn't been saved before then Save as will be called
     * @param direct
     * @param canv
     */
    void save(String direct, Canvas canv) {
        if (direct == null){
            SavingNewImage(canv);
        }
        else{
        File file = new File(direct);
       // new Save().Reminder(5, smart);
        //System.out.println("Task scheduled.");

        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage((int) canv.getWidth(), (int) canv.getHeight());
                canv.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                System.out.println("Error!");
            }
        }
        }

    }


    //************************* Smart save  *********************************\\

    /**
     * When the canvas hasn't been saved adn the user is exiting this brings up a menu that asks if they wish to save
     * @param event
     * @param direct
     * @param canv
     * @throws IOException
     */
    void bye(WindowEvent event,  String direct, Canvas canv) throws IOException {
            //Create an Alert with predefined warning image
            Alert alert = new Alert(Alert.AlertType.WARNING);
//Set text in conveinently pre-defined layout
            alert.setTitle("Warning");
            alert.setHeaderText("Are you sure?");
            alert.setContentText("Do you want to close the application?");
//Set custom buttons
            ButtonType okButton = new ButtonType("Yes, exit", OK_DONE);
            ButtonType cancelButton = new ButtonType("No, go back to Paint", ButtonBar.ButtonData.CANCEL_CLOSE);
            ButtonType sButton = new ButtonType("Save", OK_DONE);
            ButtonType SAButton = new ButtonType("Save As", OK_DONE);

            alert.getButtonTypes().setAll(okButton, cancelButton, sButton, SAButton);
//Prevent all interaction with application until resolved.
            alert.initModality(Modality.APPLICATION_MODAL);
//Launch
            alert.showAndWait().ifPresent(response -> {
                if (response == okButton) {
                    Platform.exit();
                } else if (response == sButton) {
                    save(direct, canv);
                    Platform.exit();
                } else if (response == SAButton) {
                    SavingNewImage(canv);
                    Platform.exit();
                }

            });
    }

    /**
     * Adds an image to the clipboard for a mouse event
     * @param event
     * @param smart
     * @param graph
     * @param canv
     * @param read
     * @param clip
     * @param x
     * @param y
     * @throws FileNotFoundException
     */
    void oi(MouseEvent event, boolean smart, GraphicsContext graph, Canvas canv, PixelReader read, Image clip, double x, double y) throws FileNotFoundException {
        smart = false;
        graph = canv.getGraphicsContext2D();
        if (clip != null) {
            graph.drawImage(clip, x, y);
        }

    }
    /**
     * Adds an image to the clipboard for an Action event (will be removed later
     * @param event
     * @param smart
     * @param graph
     * @param canv
     * @param read
     * @param clip
     * @param x
     * @param y
     * @throws FileNotFoundException
     */
    void ui(ActionEvent event, boolean smart, GraphicsContext graph, Canvas canv, PixelReader read, Image clip, double x, double y) throws FileNotFoundException {
        smart = false;
        graph = canv.getGraphicsContext2D();
        if (clip != null) {
            graph.drawImage(clip, x, y);
        }

    }
//************************* Auto ***************************************//



}
