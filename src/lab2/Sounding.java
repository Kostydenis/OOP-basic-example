package lab2;

/**
 * Интерфейс для животных. Общение животных.
 * 
 * @author Костылев Денис АСУб-12-1
 */
public interface Sounding {
    
    /**
     * Представиться - назвать свое имя и вид.
     * 
     * @return имя и вид
     */
    public String introduce();
    
    /**
     * Уникальный звук животного
     * 
     * @return уникальный звук животного
     */
    public String uniqueSound();
    
}
