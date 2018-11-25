//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Aliens_Cl
{
	private List<Sprite_MovableYes_CollidableYes_Cl> aliens_Lst;

	public Aliens_Cl(int size)
	{
		aliens_Lst = new ArrayList<Sprite_MovableYes_CollidableYes_Cl>();
		int x = 25;
		int y = 50;
		for( int i = 0; i < size; i++)
		{
            //y- 			aliens_Lst.add( new Sprite_MovableYes_CollidableYes_Cl("/images/alien.jpg", x, y,35,35,1) );
			aliens_Lst.add( new Sprite_MovableYes_CollidableYes_Cl("/images/alien.jpg", x, y, 100, 100, 1) );
			if( x > StarFighter.WIDTH - 50)
			{
				x = 25;
				//y- y += 75;
				y += (aliens_Lst.get(i).getHeight() * 1);
				aliens_Lst.get(i).setPos(x,y);
			}
			//y- x += 75;
			x += (aliens_Lst.get(i).getWidth() * 1);
		}
	}

	public void add(Sprite_MovableYes_CollidableYes_Cl al)
	{
	   aliens_Lst.add(al);
	}

	public void draw( Graphics window )
	{
		for( Sprite_MovableYes_CollidableYes_Cl al : aliens_Lst)
			al.draw( window );
	}

	public void move()
	{
		for(Sprite_MovableYes_CollidableYes_Cl al : aliens_Lst)
		{
			al.move("SIDEWAYS_AND_DOWN");
		}
	}

	public void removeDeadOnes(List<Sprite_MovableYes_CollidableYes_Cl> projectilesLstIn)
	{
		for(int i = 0; i < projectilesLstIn.size(); i++)
		{
			Sprite_MovableYes_CollidableYes_Cl spriteProjectileOb = projectilesLstIn.get(i);
			
		    for(int j = 0; j< aliens_Lst.size(); j++)
		    {
		   		Sprite_MovableYes_CollidableYes_Cl spriteAlienOb = aliens_Lst.get(j);
                //y-			   if ((spriteProjectileOb.getX() >= spriteAlienOb.getX() && spriteProjectileOb.getX() <= spriteAlienOb.getX()+60) ||
                //					   (spriteProjectileOb.getX()+10 >= spriteAlienOb.getX() && spriteProjectileOb.getX()+10 <= spriteAlienOb.getX()+60))
                //				   if ((spriteProjectileOb.getY() >= spriteAlienOb.getY() && spriteProjectileOb.getY() <= spriteAlienOb.getY()+60) ||
                //						   (spriteProjectileOb.getY()+10 >= spriteAlienOb.getY() && spriteProjectileOb.getY()+10 <= spriteAlienOb.getY()+60))

				//y-				if ((spriteProjectileOb.getX() >= spriteAlienOb.getX() && spriteProjectileOb.getX() <= spriteAlienOb.getX()+spriteAlienOb.getWidth()) ||
				//						(spriteProjectileOb.getX()+spriteProjectileOb.getWidth() >= spriteAlienOb.getX() && spriteProjectileOb.getX()+spriteProjectileOb.getWidth() <= spriteAlienOb.getX()+spriteAlienOb.getWidth()))
				//				{
				//					if ((spriteProjectileOb.getY() >= spriteAlienOb.getY() && spriteProjectileOb.getY() <= spriteAlienOb.getY() + spriteAlienOb.getHeight()) ||
				//							(spriteProjectileOb.getY() + spriteProjectileOb.getHeight() >= spriteAlienOb.getY() && spriteProjectileOb.getY() + spriteProjectileOb.getHeight() <= spriteAlienOb.getY() + spriteAlienOb.getHeight()))
				//					{
				//						aliens_Lst.remove(j);
				//						projectilesLstIn.remove(i);
				//						break;
				//					}
				//				}
				
				//y-				if (((spriteProjectileOb.getX() >= spriteAlienOb.getX() && spriteProjectileOb.getX() <= spriteAlienOb.getX() + spriteAlienOb.getWidth()  )  &&
				//				     (spriteProjectileOb.getY() >= spriteAlienOb.getY() && spriteProjectileOb.getY() <= spriteAlienOb.getY() + spriteAlienOb.getHeight()))
				//					||
				//				    ((spriteProjectileOb.getX() + spriteProjectileOb.getWidth()  >= spriteAlienOb.getX() && spriteProjectileOb.getX() + spriteProjectileOb.getWidth()  <= spriteAlienOb.getX() + spriteAlienOb.getWidth()  ) &&
				//					 (spriteProjectileOb.getY() + spriteProjectileOb.getHeight() >= spriteAlienOb.getY() && spriteProjectileOb.getY() + spriteProjectileOb.getHeight() <= spriteAlienOb.getY() + spriteAlienOb.getHeight() )))
				//					{
				//						aliens_Lst.remove(j);
				//						projectilesLstIn.remove(i);
				//						break;
				//					}

				//TODO tried to reverse the objects but failed, projectiles miss front row
				if( spriteProjectileOb.colliding( spriteAlienOb ))
				{
					aliens_Lst.remove(j);
					projectilesLstIn.remove(i);
					break;
				}
		   	}
		}
	}

	public String toString()
	{
		return "" + aliens_Lst;
	}
}
