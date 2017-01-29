package uk.co.mruoc.race.gui;

import uk.co.mruoc.time.ElapsedTime;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;
import static java.awt.Color.WHITE;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class AnalogClock extends JPanel {

    private static final double TWO_PI   = 2 * PI;

    private static final int WIDTH = 170;
    private static final int HEIGHT = 170;

    private static final int DIAMETER = 150;

    private double secondAngle;
    private double minuteAngle;
    private double hourAngle;

    private ElapsedTime time;

    public AnalogClock() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        drawClockFace(g2);
        drawClockHands(g2);
    }

    public void update(ElapsedTime time) {
        this.time = time;
        calculateHandAngles();
        repaint();
    }

    private void calculateHandAngles() {
        calculateSecondAngle();
        calculateMinuteAngle();
        calculateHourAngle();
    }

    private void calculateSecondAngle() {
        this.secondAngle = (time.getSeconds() + (double)time.getMillis() / 1000) / 60.0;
    }

    private void calculateMinuteAngle() {
        this.minuteAngle = (time.getMinutes() + secondAngle) / 60.0;
    }

    private void calculateHourAngle() {
        this.hourAngle = (time.getHours() + minuteAngle) / 12.0;
    }

    private void drawClockHands(Graphics2D g) {
        drawSecondHand(g);
        drawMinuteHand(g);
        drawHourHand(g);
    }

    private void drawClockFace(Graphics2D g2) {
        int x = (getWidth() - DIAMETER) / 2;
        int y = (getHeight() - DIAMETER) / 2;

        g2.setColor(BLUE);
        g2.fillOval(x, y, DIAMETER, DIAMETER);

        g2.setColor(WHITE);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(x, y, DIAMETER, DIAMETER);
    }

    private void drawSecondHand(Graphics2D g) {
        int length = (DIAMETER / 2) - 5;
        g.setStroke(new BasicStroke(1));
        drawHand(g, secondAngle, length);
    }

    private void drawMinuteHand(Graphics2D g) {
        int length = (DIAMETER / 2) - 10;
        g.setStroke(new BasicStroke(2));
        drawHand(g, minuteAngle, length);
    }

    private void drawHourHand(Graphics2D g) {
        int length = DIAMETER / 4;
        g.setStroke(new BasicStroke(3));
        drawHand(g, hourAngle, length);
    }

    private void drawHand(Graphics2D g2, double angle, int length) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        double radians = (0.5 - angle) * TWO_PI;
        double sine   = sin(radians);
        double cosine = cos(radians);

        int dxmin = centerX + (int)(0 * sine);
        int dymin = centerY + (int)(0 * cosine);

        int dxmax = centerX + (int)(length * sine);
        int dymax = centerY + (int)(length * cosine);

        g2.drawLine(dxmin, dymin, dxmax, dymax);
    }

}
