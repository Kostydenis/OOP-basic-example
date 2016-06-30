/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Денис
 */
public class Tiger extends Felidae {
    
    public Tiger(){
        super();
    }
    
    public Tiger(String inputName){
        super(inputName, (byte) 200);
    }
    
    public Tiger(String inputName, byte inputHp, byte inputStrength){
        super(inputName, inputStrength);
    }
    
    @Override
    public String introduce(){
        return (uniqueSound() + " , I\'m Tiger.");
    }
    
    @Override
    public String uniqueSound(){
        return "RRrr. Meow.";
    }  
}
