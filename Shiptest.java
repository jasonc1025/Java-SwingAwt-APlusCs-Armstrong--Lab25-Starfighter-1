//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Shiptest
{
    public static void main( String args[] )
    {
        SpriteCore_ClAb test = new Sprite_MovableYes_CollidableYes_Cl();
        System.out.println("Sprite_MovableYes_CollidableYes_Cl 1 " + test);

        Sprite_MovableYes_CollidableYes_Cl test2 = new Sprite_MovableYes_CollidableYes_Cl(50,75);
        System.out.println("Sprite_MovableYes_CollidableYes_Cl 2 " + test2);

        Sprite_MovableYes_CollidableYes_Cl test3 = new Sprite_MovableYes_CollidableYes_Cl();
        test3.setX(3);
        test3.setY(5);
        System.out.println("Sprite_MovableYes_CollidableYes_Cl 3 " + test2);
    }
}
