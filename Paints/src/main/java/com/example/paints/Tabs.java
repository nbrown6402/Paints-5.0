package com.example.paints;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Tabs extends Tab {

    /**
     * adds a new tab
     * @param tabPane
     * @param i
     * @param tam
     */
    public void addTab(TabPane tabPane, int i, Tab tam) {
        Tab tab = new Tab("Tab: " + i);
        tab.setContent(createTabContent());
        tab.setContent(tam.getContent());
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }

    /**
     * Creates the content that will be on a new tab
     * @return
     */
    private Node createTabContent() {
        Canvas canvas = new Canvas(100, 100);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        return canvas;
    }

    /**
     * gets the current tab
     * @param pane
     * @return
     */
    public Tab getTabs(TabPane pane) {
        return (Tab) pane.getSelectionModel().getSelectedItem();
    }


}

