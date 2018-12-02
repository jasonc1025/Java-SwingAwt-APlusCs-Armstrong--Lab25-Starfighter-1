//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Shiptest
{
    public static void main( String args[] )
    {
        Sprite_Core_ClAb test = new Sprite_Movable_Collidable_Cl();
        System.out.println("Sprite_Movable_Collidable_Cl 1 " + test);

        Sprite_Movable_Collidable_Cl test2 = new Sprite_Movable_Collidable_Cl(50,75);
        System.out.println("Sprite_Movable_Collidable_Cl 2 " + test2);

        Sprite_Movable_Collidable_Cl test3 = new Sprite_Movable_Collidable_Cl();
        test3.setX(3);
        test3.setY(5);
        System.out.println("Sprite_Movable_Collidable_Cl 3 " + test2);
    }
}
