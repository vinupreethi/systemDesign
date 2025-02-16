package org.example.SnakeAndDesign;

public class Food {
    public static Food food;
    public static Position position;

   private Food()
   {

   }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static Food getInstance() {
        if (food == null) {
            synchronized (Food.class) {
                if (food == null)
                    return new Food();
            }
        }
        return food;
    }

}
