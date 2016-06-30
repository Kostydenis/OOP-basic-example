package lab2.stuff;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import lab2.Cat;
import lab2.Lion;
import lab2.Tiger;
import lab2.Zebra;
import lab2.Zoo;

/**
 *
 * @author Костылев Денис АСУб-12-1
 */
public class GUI extends JFrame implements PropertyChangeListener {

    Zoo zoo;
    private JFrame wind;
    InfoModel im;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu file = new JMenu("File");
    private JMenu about = new JMenu("About");
    private JMenuItem exit;
    private JMenuItem help;
    /**
     * Таблица для отображения животных
     */
    private JTable table = new JTable();
    /**
     * Панель добавления животных
     */
    private JPanel control = new JPanel(new FlowLayout());
    private JButton addButton = new JButton("Add");
    private JButton remButton = new JButton("Remove");
    private String[] comboboxItems = {"Cat", "Lion", "Tiger", "Zebra"};
    private JComboBox<String> chooserAnimal = new JComboBox<>(comboboxItems);
    /**
     * Панель действий над животными
     */
    private JPanel actions = new JPanel();
    private JButton feed = new JButton("Feed");
    private JButton feedall = new JButton("Feed all");
    private JButton heal = new JButton("Heal");
    private JButton healall = new JButton("Heal all");
    private JButton kill = new JButton("Kill");
    private JButton killall = new JButton("Kill all");
    private JButton refresh = new JButton("Refresh");
    private JButton introduce = new JButton("Introduce");
    private JButton introduceall = new JButton("Introduce all");
    private JButton makenoise = new JButton("Make Noise");

    /**
     * Конструктор формы с новым зоопарком
     *
     */
    GUI() {
        this(new Zoo());
    }

    /**
     * Конструктор формы с существующим зоопарком
     *
     * @param inputZoo существующий зоопарк
     */
    GUI(Zoo inputZoo) {
        super("Lab2");
        wind = this;
        zoo = inputZoo;
        this.setBackground(Color.yellow);
        this.setLayout(new BorderLayout());
        actions.setLayout(new BoxLayout(actions, BoxLayout.Y_AXIS));
        im = new InfoModel(zoo);
        table.setModel(im);

        menuBar.add(file);
        menuBar.add(about);
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        file.add(exit);

        help = new JMenuItem("Help");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = null;
                if (Desktop.isDesktopSupported()) {
                    desktop = Desktop.getDesktop();
                }
                try {
                    desktop.open(new File("help.txt"));
                } catch (IOException ex) {
                    System.out.println("File error");
                }
            }
        });
        about.add(help);

        this.add(menuBar, BorderLayout.NORTH);

        feed.setAlignmentX(CENTER_ALIGNMENT);
        feedall.setAlignmentX(CENTER_ALIGNMENT);
        heal.setAlignmentX(CENTER_ALIGNMENT);
        healall.setAlignmentX(CENTER_ALIGNMENT);
        kill.setAlignmentX(CENTER_ALIGNMENT);
        killall.setAlignmentX(CENTER_ALIGNMENT);
        refresh.setAlignmentX(CENTER_ALIGNMENT);
        introduce.setAlignmentX(CENTER_ALIGNMENT);
        introduceall.setAlignmentX(CENTER_ALIGNMENT);
        makenoise.setAlignmentX(CENTER_ALIGNMENT);

        feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    zoo.getAnimal(table.getSelectedRow()).feed();
                } catch (IndexOutOfBoundsException ex) {
                }
                table.repaint();
            }
        });
        feedall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < zoo.size(); i++) {
                    zoo.getAnimal(i).feed();
                }
                table.repaint();
            }
        });
        heal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    zoo.getAnimal(table.getSelectedRow()).heal();
                } catch (IndexOutOfBoundsException ex) {
                }
                table.repaint();
            }
        });
        healall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < zoo.size(); i++) {
                    zoo.getAnimal(i).heal();
                }
                table.repaint();
            }
        });
        kill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    zoo.getAnimal(table.getSelectedRow()).die();
                } catch (IndexOutOfBoundsException ex) {
                }
                table.repaint();
            }
        });
        killall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < zoo.size(); i++) {
                    zoo.getAnimal(i).die();
                }
                table.repaint();
            }
        });
        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.repaint();
            }
        });
        introduce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, zoo.getAnimal(table.getSelectedRow()).introduce());
            }
        });
        introduceall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < zoo.size(); i++) {
                    JOptionPane.showMessageDialog(null, zoo.getAnimal(i).introduce());
                }
            }
        });
        makenoise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < zoo.size(); i++) {
                    JOptionPane.showMessageDialog(null, zoo.getAnimal(i).uniqueSound());
                }
            }
        });

        actions.add(feed);
        actions.add(heal);
        actions.add(kill);
        actions.add(feedall);
        actions.add(healall);
        actions.add(killall);
        actions.add(refresh);
        actions.add(introduce);
        actions.add(introduceall);
        actions.add(makenoise);

//        this.add(table, BorderLayout.CENTER);
        this.add(actions, BorderLayout.EAST);

        this.add(control, BorderLayout.SOUTH);
        control.add(chooserAnimal);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (chooserAnimal.getSelectedIndex()) {
                    case 0: {
                        String tmp = JOptionPane.showInputDialog("Enter name of cat");
                        if (!"".equals(tmp)) {
                            zoo.addAnimal(new Cat(tmp));
                        }
                        table.repaint();
                        break;
                    }
                    case 1: {
                        String tmp = JOptionPane.showInputDialog("Enter name of lion");
                        if (!"".equals(tmp)) {
                            zoo.addAnimal(new Lion(tmp));
                        }
                        table.repaint();
                        break;
                    }
                    case 2: {
                        String tmp = JOptionPane.showInputDialog("Enter name of tiger");
                        if (!"".equals(tmp)) {
                            zoo.addAnimal(new Tiger(tmp));
                        }
                        table.repaint();
                        break;
                    }
                    case 3: {
                        String tmp = JOptionPane.showInputDialog("Enter name of zebra");
                        if (!"".equals(tmp)) {
                            zoo.addAnimal(new Zebra(tmp));
                        }
                        table.repaint();
                        break;
                    }
                }
            }
        });
        control.add(addButton);
        remButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    zoo.removeAnimal(table.getSelectedRow());
                } catch (IndexOutOfBoundsException ex) {
                }
                table.repaint();
            }
        });
        control.add(remButton);

        this.add(new JScrollPane(table), BorderLayout.CENTER);


        /**
         * обновление таблицы каждую секунду
         */
        TimerTask tsk = new TimerTask() {
            @Override
            public void run() {
                //   WindowEvent we = new  WindowEvent(GUI.this, WindowEvent.COMPONENT_RESIZED);
                int tmp = table.getSelectedRow();
                GUI.this.im.fireTableDataChanged();
                try {
                    GUI.this.table.setRowSelectionInterval(tmp, tmp);
                } catch (IllegalArgumentException e) {
                }

            }
        };
        Timer tmr = new Timer();
        tmr.schedule(tsk, 1000, 1000);




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 400, 400);
        this.setVisible(true);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
