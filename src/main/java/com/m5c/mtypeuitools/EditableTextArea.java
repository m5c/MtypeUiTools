package main.java.com.m5c.mtypeuitools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;

/**
 *
 * @author Maximilian Schiedermeier
 */
public abstract class EditableTextArea extends JTextArea 
{

    private final String bgColorCode;

    private final String fgColorCode;

    private final int rows;

    public EditableTextArea(int rows, String description, String fgColorCode, String bgColorCode)
    {
        super(description, rows, 1);
        this.rows = rows;
        this.fgColorCode = fgColorCode;
        this.bgColorCode = bgColorCode;
        setLineWrap(true);
        setWrapStyleWord(true);
        setForeground(Color.decode(fgColorCode));
        setBackground(Color.decode(bgColorCode));

        repaint();

        addKeyListener(new KeyListener()
        {

            @Override
            public void keyTyped(KeyEvent arg0)
            {
            }

            @Override
            public void keyReleased(KeyEvent arg0)
            {

            }

            @Override
            public void keyPressed(KeyEvent arg0)
            {
                /*
                 // first line is title, second line is descr.
                 String[] content = getText().split("\n");
                 if(content.length > 0)
                 model.setTitle(model.getCurrentSubscription(), content[0]);
                 if(content.length == 1)
                 model.setDescription(model.getCurrentSubscription(), content[1]);
                 else if(content.length >=2)
                 model.setDescription(model.getCurrentSubscription(), content[1]+" "+content[2]);    
                
                 masterModelObserver.onModelUpdate();*/
                onTextChange(getText());
            }

        });
    }
    
    public abstract void onTextChange(String text);

    @Override
    protected void paintComponent(Graphics g)
    {
        setFont(new Font("Sans", Font.PLAIN, (int) (getHeight() / rows)));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode(bgColorCode));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.decode(fgColorCode));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g2d);
        g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }

}
