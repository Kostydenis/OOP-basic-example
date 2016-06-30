package lab2;

import java.util.ArrayList;

/**
 *
 * @author Денис
 */
public class Zoo {
    private ArrayList<Animal> list = new ArrayList<>();

    public Zoo() {
        
    }
    
    /**
     * Добавление животного
     * 
     * @param inputAnimal добавляемое животное
     */
    public void addAnimal(Animal inputAnimal){
        list.add(inputAnimal);
    }
    
    /**
     * Удаление животного по номеру в списке
     * 
     * @param index номер животного в списке
     */
    public void removeAnimal(int index){
        list.remove(index);
    }
    
    /**
     * Удаление животного по соответствию
     * 
     * @param animal животное, которое нужно удалить
     */
    public void removeAnimal(Animal animal){
        list.remove(animal);
    }
    
    /**
     * Получение полного списка животных.
     * 
     * @return полный список животных {@link Lab2.Zoo#list}
     */
    public ArrayList<Animal> getList(){
        return list;
    }
    
    /**
     * Проверяет, все ли животные мертвы
     * 
     */
    public boolean isAllDead(){
        boolean tmp = false;
        for (int i = 0; i < this.size(); i++) {
            if (this.getAnimal(i).isAlive()) {
                tmp = true;
            }
        }
        return tmp;
    }

    /**
     * Возвращает количество животных в списке
     * 
     */
    public int size(){
        return list.size();
    }

    /**
     * Возвращает животного по номеру в списке
     * 
     * @param index номер животного в списке
     * @return {@link Lab2.Animal}
     */
    public Animal getAnimal(int index){
        return list.get(index);
    }
}
