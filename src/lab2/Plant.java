package lab2;

/**
 * Корм для травоядных животных {@link Lab2.Herbivorous}
 * Возможно расширение функциональности. Добавление типа/цвета. И соответственно кормление животных определенным типом растения
 *
 * @author Костылев Денис АСУб-12-1
 */
public class Plant {
    String type;
    String color;
    
    public Plant(){
        
    }
    
    @Deprecated
    public Plant(String inputType, String inputColor){
        type = inputType;
        color = inputColor;
    }
}
