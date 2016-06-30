package lab2;

import java.util.Random;

/**
 *
 * @author Денис
 */
public abstract class Felidae extends Animal implements Carnivorous {
    
    public Felidae(){
        
    }
    public Felidae(String inputName, byte inputStrength) {
        super(inputName, inputStrength);
    }
    public Felidae(String inputName){
        super(inputName, (byte) (100));
    }

    @Override
    public String introduce() {
        return "Hello, I'm some kind of cat. Meow.";
    }

    @Override
    public String uniqueSound() {
        return "Meow";
    }    

    public String feed(){
        this.incSatiety();
        return (getName() + ": Omnomnom, so delicious");
    }
    @Override
    @Deprecated
    /**
     * НЕОБХОДИМА ОТЛАДКА ВСЕХ МЕТОДОВ feed(args)
     * Временно используется {@link Lab2.Animal.feed()}
     */
    public String feed(Animal food) {
        
        if (food instanceof Herbivorous){
            this.incSatiety();
            System.out.println(food.die());
            return (this.getName() + ": Omnomnom, so delicious");
        }
        else {
            if (this.getStrength() == food.getStrength()){
                if (new Random().nextBoolean()){
                    this.incSatiety();
                    food.die();
                    return (this.getName() + ": Omnomnom, so delicious");
                }
                else {
                    food.incSatiety();
                    System.out.println(this.die());
                    return (food.getName() + ": Omnomnom, so delicious");
                }
            }
            else {
                if (this.getStrength() > food.getStrength()){
                    this.incSatiety();
                    System.out.println(food.die()); 
                    return (this.getName() + ": Omnomnom, so delicious");
                }
                else {
                    food.incSatiety();
                    System.out.println(this.die());
                    return (food.getName() + ": Omnomnom, so delicious");
                }
            }
        }
    }    

    @Override
    @Deprecated
    /**
     * НЕОБХОДИМА ОТЛАДКА ВСЕХ МЕТОДОВ feed(args)
     * Временно используется {@link Lab2.Animal.feed()}
     */
    public String feed(Plant food) {
        return "Faugh! I ain\'t gonna eat it!";
    }
}
