import java.util.ArrayList;

interface Ingredient {
    String getName();
    int getQuantity();
}


class SolidIngredient implements Ingredient{
    private String _name;
    private int _quantity;
    public SolidIngredient(String n, int q){
        _name = n;
        _quantity = q;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    public String toString() {
        String s = "" + _name + " ";
        return s;
    }
}

class LiquidIngredient implements Ingredient{
    private String _name;
    private int _quantity;
    public LiquidIngredient(String n, int q){
        _name = n;
        _quantity = q;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public int getQuantity() {
        return _quantity;
    }

    public String toString() {
        String s = "" + _name + " ";
        return s;
    }
}

class Recipe<T extends Ingredient>{
    private String _name;
    private String _instructions;
    private ArrayList<T> _setOfIngredients;
    public Recipe(String n, String i, ArrayList<T> s){
        _name = n;
        _instructions = i;
        _setOfIngredients = s;
    }

    public void addIngredient(T t){
        _setOfIngredients.add(t);
    }

    public void print() {
        if (_setOfIngredients != null)
            System.out.println("Name: " + _name + ", Instructions: " + _instructions + ", Set of Ingredients: " + _setOfIngredients.getClass().getName());
        else
            System.out.println("null member variable");
    }
}




public class Main {
    public static void main(String[] args) {
        ArrayList<String> aso = new ArrayList<>(2);
        aso.add("Apple");
        aso.add("Pear");
//        Recipe<Ingredient>a = new Recipe<Ingredient>("roro", "Burn", aso);
    }
}//

