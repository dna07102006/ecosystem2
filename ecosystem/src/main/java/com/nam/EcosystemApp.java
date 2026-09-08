package com.nam;

import com.nam.model.organism.OrganismFactory;
import com.nam.scenario.BalancedScenario;
import com.nam.simulation.SimulationEngine;
import com.nam.view.EcosystemView;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EcosystemApp extends Application {
    private static final double CELL_SIZE = 20;
    private static final long TICK_INTERVAL_NANOS = 400_000_000L; 

    @Override
    public void start(Stage stage) {
        SimulationEngine engine = new SimulationEngine(new BalancedScenario(), new OrganismFactory());

        int rows = engine.getEcosystem().getRows();
        int cols = engine.getEcosystem().getCols();
        Canvas canvas = new Canvas(cols * CELL_SIZE, rows * CELL_SIZE);
        EcosystemView view = new EcosystemView(canvas, CELL_SIZE);
        view.render(engine.getEcosystem(), engine.getTickCount());

        stage.setScene(new Scene(new StackPane(canvas)));
        stage.setTitle("Ecosystem Simulation - " + new BalancedScenario().getName());
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            private long lastTick = 0;

            @Override
            public void handle(long now) {
                if (now - lastTick >= TICK_INTERVAL_NANOS) {
                    engine.tick();
                    view.render(engine.getEcosystem(), engine.getTickCount());
                    lastTick = now;
                }
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}