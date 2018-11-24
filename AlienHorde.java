//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Sprite_MovableYes_CollidableYes_Cl> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Sprite_MovableYes_CollidableYes_Cl>();
		int x = 25;
		int y = 50;
		for( int i = 0; i < size; i++)
		{
			if( x > StarFighter.WIDTH - 50)
			{
				x = 25;
				y += 75;
			}
//y- 			aliens.add( new Sprite_MovableYes_CollidableYes_Cl("/images/alien.jpg", x, y,35,35,1) );
			aliens.add( new Sprite_MovableYes_CollidableYes_Cl("/images/alien.jpg", x, y,35,35,1) );
			x += 75;
		}
	}

	public void add(Sprite_MovableYes_CollidableYes_Cl al)
	{
	   aliens.add(al);
	}

	public void draw( Graphics window )
	{
		for( Sprite_MovableYes_CollidableYes_Cl al : aliens)
			al.draw( window );
	}

	public void move()
	{
		for(Sprite_MovableYes_CollidableYes_Cl al : aliens)
		{
			al.move("SIDEWAYS_AND_DOWN");
		}
	}

	public void removeDeadOnes(List<Sprite_MovableYes_CollidableYes_Cl> shots)
	{
		for(int i = 0; i < shots.size(); i++)
		{
			Sprite_MovableYes_CollidableYes_Cl am = shots.get(i);
		   for(int j=0; j<aliens.size();j++)
		   {
		   	Sprite_MovableYes_CollidableYes_Cl al = aliens.get(j);
			   if ((am.getX() >= al.getX() && am.getX() <= al.getX()+60) ||
			        (am.getX()+10 >= al.getX() && am.getX()+10 <= al.getX()+60))
			   	     if ((am.getY() >= al.getY() && am.getY() <= al.getY()+60) ||
			   	     	   (am.getY()+10 >= al.getY() && am.getY()+10 <= al.getY()+60))
			   	     	   {
			   		         aliens.remove(j);
			   		         shots.remove(i);
			   		         break;
			   	     	   }
		   	}
		}
	}

	public String toString()
	{
		return "" + aliens;
	}
}
