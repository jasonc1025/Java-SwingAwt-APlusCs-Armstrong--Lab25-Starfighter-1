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
			Sprite_MovableYes_CollidableYes_Cl projectile_Ob = projectilesLstIn.get(i);
		    for(int j = 0; j< aliens_Lst.size(); j++)
		    {
		   		Sprite_MovableYes_CollidableYes_Cl alien_Ob = aliens_Lst.get(j);
                //y-			   if ((projectile_Ob.getX() >= alien_Ob.getX() && projectile_Ob.getX() <= alien_Ob.getX()+60) ||
                //					   (projectile_Ob.getX()+10 >= alien_Ob.getX() && projectile_Ob.getX()+10 <= alien_Ob.getX()+60))
                //				   if ((projectile_Ob.getY() >= alien_Ob.getY() && projectile_Ob.getY() <= alien_Ob.getY()+60) ||
                //						   (projectile_Ob.getY()+10 >= alien_Ob.getY() && projectile_Ob.getY()+10 <= alien_Ob.getY()+60))
//				if ((projectile_Ob.getX() >= alien_Ob.getX() && projectile_Ob.getX() <= alien_Ob.getX()+alien_Ob.getWidth()) ||
//						(projectile_Ob.getX()+projectile_Ob.getWidth() >= alien_Ob.getX() && projectile_Ob.getX()+projectile_Ob.getWidth() <= alien_Ob.getX()+alien_Ob.getWidth()))
//				{
//					if ((projectile_Ob.getY() >= alien_Ob.getY() && projectile_Ob.getY() <= alien_Ob.getY() + alien_Ob.getHeight()) ||
//							(projectile_Ob.getY() + projectile_Ob.getHeight() >= alien_Ob.getY() && projectile_Ob.getY() + projectile_Ob.getHeight() <= alien_Ob.getY() + alien_Ob.getHeight()))
//					{
//						aliens_Lst.remove(j);
//						projectilesLstIn.remove(i);
//						break;
//					}
//				}
				if (((projectile_Ob.getX() >= alien_Ob.getX() && projectile_Ob.getX() <= alien_Ob.getX() + alien_Ob.getWidth()  )  &&
				     (projectile_Ob.getY() >= alien_Ob.getY() && projectile_Ob.getY() <= alien_Ob.getY() + alien_Ob.getHeight()))
					||
				    ((projectile_Ob.getX() + projectile_Ob.getWidth()  >= alien_Ob.getX() && projectile_Ob.getX() + projectile_Ob.getWidth()  <= alien_Ob.getX() + alien_Ob.getWidth()  ) &&
					 (projectile_Ob.getY() + projectile_Ob.getHeight() >= alien_Ob.getY() && projectile_Ob.getY() + projectile_Ob.getHeight() <= alien_Ob.getY() + alien_Ob.getHeight() )))
					{
						aliens_Lst.remove(j);
						projectilesLstIn.remove(i);
						break;
					}

//				if( alien_Ob.colliding( projectile_Ob ))
//				{
//					aliens_Lst.remove(j);
//					projectilesLstIn.remove(i);
//					break;
//				}
		   	}
		}
	}

	public String toString()
	{
		return "" + aliens_Lst;
	}
}
