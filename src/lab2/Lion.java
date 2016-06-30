/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Денис
 */
public class Lion extends Felidae{
    public Lion(){
        super();
    }
    
    public Lion(String inputName){
        super(inputName, (byte) 250);
    }
    
    public Lion(String inputName, byte inputStrength){
        super(inputName, inputStrength);
    }
    
    @Override
    public String introduce(){
        return (uniqueSound() + " , I\'m Lion. I\'m King of the animals.");
    }
    
    @Override
    public String uniqueSound(){
        return "RRrr";
    }
}
