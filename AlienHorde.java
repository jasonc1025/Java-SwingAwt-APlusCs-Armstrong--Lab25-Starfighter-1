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
//y- 			aliens.add( new Sprite_MovableYes_CollidableYes_Cl("/images/alien.jpg", x, y,35,35,1) );
			aliens.add( new Sprite_MovableYes_CollidableYes_Cl("/images/alien.jpg", x, y, 100, 100, 1) );
			if( x > StarFighter.WIDTH - 50)
			{
				x = 25;
				//y- y += 75;
				y += (aliens.get(i).getHeight() * 1);
				aliens.get(i).setPos(x,y);
			}
			//y- x += 75;
			x += (aliens.get(i).getWidth() * 1);
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
			Sprite_MovableYes_CollidableYes_Cl shot = shots.get(i);
		    for(int j=0; j<aliens.size();j++)
		    {
		   		Sprite_MovableYes_CollidableYes_Cl alien = aliens.get(j);
//y-			   if ((shot.getX() >= alien.getX() && shot.getX() <= alien.getX()+60) ||
//					   (shot.getX()+10 >= alien.getX() && shot.getX()+10 <= alien.getX()+60))
//				   if ((shot.getY() >= alien.getY() && shot.getY() <= alien.getY()+60) ||
//						   (shot.getY()+10 >= alien.getY() && shot.getY()+10 <= alien.getY()+60))
			   if ((shot.getX() >= alien.getX() && shot.getX() <= alien.getX()+alien.getWidth()) ||
					   (shot.getX()+shot.getWidth() >= alien.getX() && shot.getX()+shot.getWidth() <= alien.getX()+alien.getWidth()))
				   if ((shot.getY() >= alien.getY() && shot.getY() <= alien.getY()+alien.getHeight()) ||
						   (shot.getY()+shot.getHeight() >= alien.getY() && shot.getY()+shot.getHeight() <= alien.getY()+alien.getHeight()))
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
