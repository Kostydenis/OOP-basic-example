package lab2;

/**
 *
 * @author Денис
 */
public class Zebra extends Animal implements Herbivorous{

    public Zebra(){
        super();
    }
    
    public Zebra(String inputName){
        super(inputName, (byte) 20);
    }
    @Override
    public String introduce() {
        return "I\'m a zebra";
    }

    @Override
    public String uniqueSound() {
        return "Igogo";
    }

    public String feed(){
        this.incSatiety();
        return (this.getName() + ": Omnomnom, so delicious");
    }
    
    @Override
    @Deprecated
    /**
     * НЕОБХОДИМА ОТЛАДКА ВСЕХ МЕТОДОВ feed(args)
     * Временно используется {@link Lab2.Animal.feed()}
     */
    public String feed(Animal food) {
        food.incSatiety();
        this.die();
        return (food.getName() + ": Omnomnom, so delicious");
    }

    
    @Override
    @Deprecated
    /**
     * НЕОБХОДИМА ОТЛАДКА ВСЕХ МЕТОДОВ feed(args)
     * Временно используется {@link Lab2.Animal.feed()}
     */
    public String feed(Plant food) {
        this.incSatiety();
        return (this.getName() + ": Omnomnom, so delicious");
    }
    
}
