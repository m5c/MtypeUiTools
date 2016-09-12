package main.java.com.m5c.mtypeuitools;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/*
 * @Author m5c
 */
public abstract class RectButton extends JPanel
{

    String bgColorCode;
    String fgColorCode;
    String iaColorCode;

    private final String text;
    private boolean active;

    public RectButton(String text, boolean active, boolean toggelable, String bgColor, String fgColor, String iaColor)
    {
        this.bgColorCode = bgColor;
        this.fgColorCode = fgColor;
        this.iaColorCode = iaColor;
        this.text = text;
        this.active = active;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        //initialize font (will still be drawn after areas and rims)
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int fontSize = (int) (getHeight() * 0.5);
        Font font = new Font("Sans", Font.PLAIN, fontSize);
        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(text, g2);
        int labelPosX = (this.getWidth() - (int) r.getWidth()) / 2;
        int labelPosY = (this.getHeight() / 2 - (int) r.getHeight()) / 2 + (int) (1.44 * fm.getAscent());

        //draw background
        g2.setColor(Color.decode(bgColorCode));
        g2.fillRect(0, 0, getWidth(), getHeight());
        // set color for rim and fomt
        if (!active)
            g2.setColor(Color.decode(iaColorCode));
        else
            g2.setColor(Color.decode(fgColorCode));
        // draw rim
        g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        // draw font (same color as rim)
        g2.drawString(text, labelPosX, labelPosY);
    }

    public boolean isActive()
    {
        return active;
    }

    public String getText()
    {
        return text;
    }

    public void setActivity(boolean active)
    {
        this.active = active;
        repaint();
    }
    
    public void onModelUpdate()
    {
        repaint();
    }
}
