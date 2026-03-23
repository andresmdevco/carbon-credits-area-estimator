/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import models.Shape;

/**
 *
 * @author andre
 */

public class ResultWindow extends JFrame {

    public ResultWindow(BufferedImage image, List<Shape> shapes, double result, int panelWidth, int panelHeight) {
        setTitle("Resultado de Estimación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                if (image != null) {
                    g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
                }

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setStroke(new BasicStroke(2));

                for (Shape shape : shapes) {
                    g2d.setColor(shape.getColor());
                    drawShape(g2d, shape);
                }
            }

            private void drawShape(Graphics2D g2d, Shape shape) {
                int x = Math.min(shape.getStartX(), shape.getEndX());
                int y = Math.min(shape.getStartY(), shape.getEndY());
                int width = Math.abs(shape.getStartX() - shape.getEndX());
                int height = Math.abs(shape.getStartY() - shape.getEndY());

                switch (shape.getShapeType()) {
                    case "Circulo":
                        g2d.drawOval(x, y, width, width);
                        break;
                    case "Elipse":
                        g2d.drawOval(x, y, width, height);
                        break;
                    case "Cuadrado":
                        g2d.drawRect(x, y, width, width);
                        break;
                    case "Rectangulo":
                        g2d.drawRect(x, y, width, height);
                        break;
                }
            }
        };

        imagePanel.setPreferredSize(new Dimension(panelWidth, panelHeight));

        JLabel resultLabel = new JLabel("Resultado Final: " + String.format("%.2f", result) + "%");
        resultLabel.setFont(new Font("Serif", Font.BOLD, 24));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                Font font = new Font("Serif", Font.BOLD, 22);
                g2d.setFont(font);

                // Drawing the blue line and label
                g2d.setColor(Color.BLUE);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(300, 20, 340, 20);
                g2d.drawString("Area Evaluada", 350, 25);

                // Drawing the red line and label
                g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(600, 20, 640, 20);
                g2d.drawString("Bosque Nativo", 650, 25);
            }
        };

        legendPanel.setPreferredSize(new Dimension(400, 40));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(legendPanel, BorderLayout.NORTH);
        bottomPanel.add(resultLabel, BorderLayout.SOUTH);

        add(imagePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}