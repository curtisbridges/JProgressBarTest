package com.curtisbridges.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class JProgressBarExample extends JFrame {
    private JProgressBar firstProgressBar;
    private JProgressBar secondProgressBar;

    private JButton paintedBorderButton;

    public JProgressBarExample() {
        super("JProgressBar Example");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        init();
    }

    private void init() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel contents = createContentPane();
        container.add(contents, BorderLayout.CENTER);

        JPanel buttonPanel = createButtonPanel();
        container.add(buttonPanel, BorderLayout.EAST);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        paintedBorderButton = createPaintedBorderButton();
        panel.add(paintedBorderButton);

        return panel;
    }

    private JPanel createContentPane() {
        firstProgressBar = createProgressBar();
        firstProgressBar.setValue(25);

        secondProgressBar = createProgressBar();
        secondProgressBar.setValue(75);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panel.add(firstProgressBar);
        panel.add(secondProgressBar);

        Border border = BorderFactory.createEtchedBorder();
        panel.setBorder(BorderFactory.createTitledBorder(border, "Complex Progress"));

        return panel;
    }

    private JProgressBar createProgressBar() {
        JProgressBar progressBar = new JProgressBar(SwingConstants.HORIZONTAL);

        progressBar.setBorder(BorderFactory.createEmptyBorder());
        //progressBar.setBorderPainted(false);

        return progressBar;
    }

    private JButton createPaintedBorderButton() {
        JButton button = new JButton("Toggle Painted Border");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                final boolean state = JProgressBarExample.this.firstProgressBar.isBorderPainted();
                firstProgressBar.setBorderPainted(!state);
                secondProgressBar.setBorderPainted(!state);
            }
        });

        return button;
    }

    public static void main(String[] args) {
        JProgressBarExample jProgressBarExample = new JProgressBarExample();
        jProgressBarExample.setSize(640, 480);
        jProgressBarExample.setVisible(true);
    } 
}

