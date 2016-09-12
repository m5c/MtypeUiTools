package main.java.com.m5c.mtypeuitools;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 * One liner text panel, adjusting font size to available space (assuming one
 * line)
 *
 * @author M5C
 */
public class DynamicTextLabel extends JPanel
{

    private String text;
    private final boolean centered;
    private final String fgColorCode;
    private final String bgColorCode;

    public DynamicTextLabel(String text, boolean centered, String fgColorCode, String bgColorCode)
    {
        this.text = text;
        this.centered = centered;
        this.fgColorCode = fgColorCode;
        this.bgColorCode = bgColorCode;
    }

    public void setText(String text)
    {
        this.text = text;
        repaint();
    }

    public String getText()
    {
        return text;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        String content = text;

        //initialize font (will still be drawn after areas and rims)
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int fontSize = (int) (getHeight() * 0.5);
        Font font = new Font("Sans", Font.PLAIN, fontSize);
        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(content, g2);
        int labelPosX = (centered ? (this.getWidth() - (int) r.getWidth()) / 2 : 0);
        int labelPosY = (this.getHeight() / 2 - (int) r.getHeight()) / 2 + (int) (1.44 * fm.getAscent());

        //draw background
        g2.setColor(Color.decode(bgColorCode));
        g2.fillRect(0, 0, getWidth(), getHeight());

        // draw font (same color as rim)
        g2.setColor(Color.decode(fgColorCode));
        g2.drawString(content, labelPosX, labelPosY);
    }

}
