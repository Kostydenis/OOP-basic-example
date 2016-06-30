package lab2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Денис
 */
public abstract class Animal implements Sounding {

    private String name;
    private byte hp = 100;
    private byte satiety = 100;
    private byte strength;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void addChangeListener(PropertyChangeListener listner) {
        support.addPropertyChangeListener(listner);
    }
    public void removeChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * Конструктор для доступа к родительскому классу из дочернего
     *
     */
    public Animal() {
    }

    /**
     * Создание животного с применением имени и силы.
     *
     * @param inputName
     * @param inputStrength
     */
    public Animal(String inputName, byte inputStrength) {
        name = inputName;
        strength = inputStrength;
        starving();
    }
    /**
     * Процедура голодания животного
     *
     * Сначала заканчивается сытость, после этого здоровье. При каждом изменении
     * возюуждается событие. При изменении сытости PropertyName - "SATIETY", при
     * изменении здоровья - "HP"
     */
    private TimerTask timerStarving = new TimerTask() {
        @Override
        public void run() {
            if (getSatiety() > 0) {
                int oldSatiety = satiety;
//                satiety = (byte) (satiety - 20);
                satiety--;
                support.firePropertyChange("SATIETY", oldSatiety, satiety);
            } else {
                if (hp < 1) {
                    die();
                } else {
                    int oldHp = hp;
                    hp--;
//                    hp = (byte) (hp - 20);
                    support.firePropertyChange("HP", oldHp, hp);
                }
            }
        }
    };

    /**
     * Метод, создающий объект класса {@link java.util.Timer#Timer()} и
     * запускающий процедуру голодания каждую секунду {@link #timerStarving}
     */
    private void starving() {
        Timer timer = new Timer();
        timer.schedule(timerStarving, 1000, 1000);
    }

    /**
     * Восстанавливает здоровье животного.
     *
     * Не восстанавливает, если не живое.
     *
     * Возбуждает событие с PropertyName: "HP"
     *
     */
    public void heal() {
        if (this.isAlive()) {
            if (hp < 91) {
                hp = (byte) (hp + 10);
                support.firePropertyChange("HP", name, name);
            }
        }
    }

    public boolean isAlive() {
        if (getHp() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Смерть животного.
     *
     * <p>Публичный, т.к. животное может умереть не только от голода, а также от
     * внешних факторов. Например, при кормлении одного животного другим.</p>
     *
     * <p>Обнуление здоровья и сытости, с возбужением события; отмена таймера
     * голодания</p>
     *
     * @return сообщение о результате
     */
    public String die() {
        byte oldSatiety = satiety;
        satiety = 0;
        support.firePropertyChange("SATIETY", oldSatiety, satiety);
        byte oldHp = hp;
        hp = 0;
        support.firePropertyChange("HP", oldHp, hp);


        this.timerStarving.cancel();

        System.out.println(name + ": Im diiiieing guuuys x_x");
        return (name + ": Im diiiieing guuuys x_x");
    }

    public String getName() {
        return name;
    }

    public byte getHp() {
        return hp;
    }

    public byte getSatiety() {
        return satiety;
    }

    /**
     * Задание сытости животного. Приватный метод. Для внешнего изменения
     * {@link Lab2.Animal#incSatiety}
     * 
     * Не меняет, если животное мертвое
     *
     * Возбуждается событие c PropertyName "SATIETY"
     *
     * @param inputSatiety - на сколько увеличить сытость
     */
    private void setSatiety(int inputSatiety) {

        if (this.isAlive()) {
            int oldSatiety = satiety;
            satiety = (byte) (satiety + inputSatiety);
            if (satiety > 100) {
                die();
            } else {
                support.firePropertyChange("SATIETY", oldSatiety, satiety);
            }
        }
    }

    /**
     * Инкрементирование сытости животного Публичный метод
     */
    public void incSatiety() {
        setSatiety(10);
    }

    public byte getStrength() {
        return strength;
    }

    /**
     * Изменение силы животного. Возможно расширение функциональности: изменение
     * силы животного в зависимости от сытости
     *
     * @param inputStrength - новое значение силы
     */
    public void setStrength(byte inputStrength) {
        strength = inputStrength;
    }

    /**
     * Кормление животного.
     *
     * @return сообщение о результате кормления.
     */
    public abstract String feed();

    /**
     * НЕОБХОДИМА ОТЛАДКА ВСЕХ МЕТОДОВ feed(args) Временно используется
     * {@link Lab2.Animal#feed()}
     *
     * @param food животное, которое должно быть съедено
     * @return сообщение о результате кормления
     */
    public abstract String feed(Animal food);

    /**
     * НЕОБХОДИМА ОТЛАДКА ВСЕХ МЕТОДОВ feed(args) Временно используется
     * {@link Lab2.Animal#feed()}
     *
     * @param food растение, которое должно быть съедено
     * @return сообщение о результате кормления
     */
    public abstract String feed(Plant food);
}
