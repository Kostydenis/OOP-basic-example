package lab2;

/**
 * Корм для плотоядных животных {@link carnivorous}.
 * 
 * @author Костылев Денис АСУб-12-1
 */
public class FeedStuff extends Animal {
    public FeedStuff(){
        super("", (byte) 0);
    }

    @Override
    public String introduce() {
        return null;
    }
    @Override
    public String uniqueSound() {
        return null;
    }
    @Override
    public String feed(Animal food) {
        return null;
    }
    @Override
    public String feed(Plant food) {
        return null;
    }
    @Override
    /**
     * Оповещение о том, что корм был съеден
     * 
     * @return сообщение о съеденном корме 
     */
    public String die(){
        return "Feed-stuff had eaten";
    }

    @Override
    public String feed() {
        return null;
    }
}
