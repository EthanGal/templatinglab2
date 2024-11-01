import java.util.*;

interface Ingredient {
    String getName();

    Double getQuantity();
}


class SolidIngredient implements Ingredient {
    private String _name;
    private Double _qtyInGrams;

    public SolidIngredient(String n, Double q) {
        _name = n;
        _qtyInGrams = q;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public Double getQuantity() {
        return _qtyInGrams;
    }

    public String toString() {
        String s = "" + _name + " ";
        return s;
    }
}

class LiquidIngredient implements Ingredient {
    private String _name;
    private Double _qtyInMl;

    public LiquidIngredient(String n, Double q) {
        _name = n;
        _qtyInMl = q;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public Double getQuantity() {
        return _qtyInMl;
    }

    public String toString() {
        String s = "" + _name + " ";
        return s;
    }
}

class Recipe<T extends Ingredient> {
    private String _name;
    private String _instructions;
    private ArrayList<T> _ingredients;

    public Recipe(String n, String i) {
        _name = n;
        _instructions = i;
        _ingredients = new ArrayList<>();
    }

    public void addIngredient(T t) {
        _ingredients.add(t);
    }

    public void print() {
        System.out.println("Recipe: " + _name);
        System.out.println("Instructions: " + _instructions);
        System.out.println("Ingredients: ");
        for (T t : _ingredients) {
            System.out.println("- " + t.getName() + ": " + t.getQuantity());
        }
    }
}


public class Main {
    public static void addIngredient(Recipe<Ingredient> recipe, Scanner i){
        System.out.println("Is this a Solid (s) or Liquid (l)");
        char type = i.nextLine().charAt(0);
        System.out.println("Enter ingredient name: ");
        String name = i.nextLine();
        System.out.println("Enter the quantity: ");
        double quantity = Double.parseDouble(i.nextLine());
        Ingredient ingredient;
        if (type == 's' || type == 'S' ){
            ingredient = new SolidIngredient(name, quantity);
            recipe.addIngredient(ingredient);
        } else if (type == 'l' || type == 'L') {
            ingredient = new LiquidIngredient(name, quantity);
            recipe.addIngredient(ingredient);
        }
    }

    public static void main(String[] args) {
        Scanner select = new Scanner(System.in);
        Scanner i = new Scanner(System.in);
        System.out.println("Enter recipe name: ");
        String name = i.nextLine();
        System.out.println("Enter instructions ");
        String instructions = i.nextLine();
        Recipe<Ingredient> r = new Recipe<Ingredient>(name, instructions);
        int userInput;
        System.out.println(" Select an option");
        System.out.println("1: Add Ingredient");
        System.out.println("2: Print ");
        System.out.println("3: Quit ");
        System.out.print("Enter 1-3: ");
        userInput = select.nextInt();
        while (userInput != 3) {
            if (userInput == 1){
               addIngredient(r, i);
            } else if (userInput == 2){
                r.print();
            } else {
                System.out.println("Please enter a number that's 1-3.");
            }
            System.out.println("1: Add Ingredient");
            System.out.println("2: Print ");
            System.out.println("3: Quit ");
            System.out.print("Enter 1-3: ");
            userInput = select.nextInt();
        }
        System.out.println("Goodbye!");

    }
}//

