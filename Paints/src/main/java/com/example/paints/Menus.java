package com.example.paints;

import javafx.event.ActionEvent;

import java.awt.*;
import java.io.File;

public class Menus{
    //*******************************    About menu   **************************************\\

    /**
     * brings up a text file that gives information about Paints
     * @param event
     */
    void About(ActionEvent event) {

        File file = new File("C:\\Users\\nicol\\Desktop\\Cs250\\Paints\\src\\main\\assets\\About.txt");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists())
            try {
                desktop.open(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    //*******************************    Help menu   **************************************\\

    /**
     * Brings up a help menu to help with Paints
     * @param event
     */
    void HELP(ActionEvent event) {
        File file = new File("C:\\Users\\nicol\\Desktop\\Cs250\\Paints\\src\\main\\assets\\HELP.txt");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists())
            try {
                desktop.open(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
