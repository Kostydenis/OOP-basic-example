/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2.stuff;

import lab2.Zoo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import lab2.Animal;

/**
 *
 * @author Денис
 */
class InfoModel extends AbstractTableModel {

    Zoo zoo;

    public InfoModel() {
    }

    public InfoModel(Zoo inputZoo) {
        zoo = inputZoo;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            default: {
                return "";
            }
            case 0: {
                return "Name";
            }
            case 1: {
                return "Kind";
            }
            case 2: {
                return "HP";
            }
            case 3: {
                return "Satiety";
            }
            case 4: {
                return "Alive?";
            }
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            default:
                return Integer.class;
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return Integer.class;
            case 4:
                return Boolean.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getRowCount() {
        return zoo.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal tmp = zoo.getAnimal(rowIndex);
        switch (columnIndex) {
            default: {
                return "";
            }
            case 0: {
                return tmp.getName();
            }
            case 1: {
                return tmp.getClass().getName();
            }
            case 2: {
                return tmp.getHp();
            }
            case 3: {
                return tmp.getSatiety();
            }
            case 4: {
                return tmp.isAlive();
            }
        }
    }
}
