/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Денис
 */
public class Cat extends Felidae {
    
    public Cat(){
        super();
    }
    
    public Cat(String inputName){
        super(inputName);
    }
    
    @Override
    public String introduce(){
        return "Meow. I\'m a cat.";
    }
}
