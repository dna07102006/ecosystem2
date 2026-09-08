package com.nam.view;

import com.nam.model.ecosystem.EcosystemImpl;
import com.nam.model.organism.Organism;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class EcosystemView {
    private final Canvas canvas;
    private final GraphicsContext gc;
    private final double cellSize;

    public EcosystemView(Canvas canvas, double cellSize) {
        this.canvas = canvas;
        this.gc = canvas.getGraphicsContext2D();
        this.cellSize = cellSize;
    }

    public void render(EcosystemImpl ecosystem, int tickCount) {
        clearBackground();
        drawOrganisms(ecosystem);
        drawTickLabel(tickCount, ecosystem);
    }

    private void clearBackground() {
        gc.setFill(Color.web("#eef7ee"));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawOrganisms(EcosystemImpl ecosystem) {
        for (Organism o : ecosystem.getAllOrganisms()) {
            gc.setFill(colorFor(o.getName()));
            var pos = ecosystem.getPositionOf(o);
            gc.fillOval(pos.col() * cellSize, pos.row() * cellSize, cellSize, cellSize);
        }
    }

    private void drawTickLabel(int tickCount, EcosystemImpl ecosystem) {
        gc.setFill(Color.BLACK);
        gc.fillText("Tick: " + tickCount + "  |  Số cá thể: " + ecosystem.getAllOrganisms().size(), 8, 16);
    }

    private Color colorFor(String speciesId) {
        return switch (speciesId) {
            case "wolf" -> Color.web("#d9534f");
            case "rabbit" -> Color.web("#8b5a2b");
            case "grass" -> Color.web("#4caf50");
            default -> Color.GRAY;
        };
    }
}
