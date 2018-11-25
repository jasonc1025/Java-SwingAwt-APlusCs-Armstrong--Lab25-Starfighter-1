//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerBots_Cl
{
//	private List<Sprite_Movable_Collidable_Cl> playerBots_Lst;
//n-	private List<Sprite_Core_ClAb> playerBots_Lst;
	private List<Sprite_Movable_Collidable_Cl> playerBots_Lst;

	public PlayerBots_Cl(int size)
	{
//		playerBots_Lst = new ArrayList<Sprite_Movable_Collidable_Cl>();
//n-		playerBots_Lst = new ArrayList<Sprite_Core_ClAb>();
		playerBots_Lst = new ArrayList<Sprite_Movable_Collidable_Cl>();
		int x = 25;
		int y = 50;
		for( int i = 0; i < size; i++)
		{
            //y- 			playerBots_Lst.add( new Sprite_Movable_Collidable_Cl("/images/alien.jpg", x, y,35,35,1) );
			playerBots_Lst.add( new Sprite_Movable_Collidable_Cl("/images/alien.jpg", x, y, 100, 100, 1) );
			if( x > StarFighter_JFrame_Main_Cl.WIDTH - 50)
			{
				x = 25;
				//y- y += 75;
				y += (playerBots_Lst.get(i).getHeight() * 1);
				playerBots_Lst.get(i).setPos(x,y);
			}
			//y- x += 75;
			x += (playerBots_Lst.get(i).getWidth() * 1);
		}
	}

	public void add(Sprite_Movable_Collidable_Cl al)
	{
	   playerBots_Lst.add(al);
	}

	public void draw( Graphics window )
	{
//		for( Sprite_Movable_Collidable_Cl al : playerBots_Lst)
//n-			for( Sprite_Core_ClAb al : playerBots_Lst)
		for( Sprite_Movable_Collidable_Cl al : playerBots_Lst)
			al.draw( window );
	}

	public void move()
	{
//		for(Sprite_Movable_Collidable_Cl al : playerBots_Lst)
//n-			for(Sprite_Core_ClAb al : playerBots_Lst)
		for(Sprite_Movable_Collidable_Cl al : playerBots_Lst)
		{
			al.move("SIDEWAYS_AND_DOWN");
		}
	}

	public void removeDeadOnes(Sprite_Movable_Collidable_Cl playerMeObIn, List<Sprite_Movable_Collidable_Cl> missilesLstIn)
	{
//		for(int i = 0; i < missilesLstIn.size(); i++)
//		Iterator<Sprite_Core_ClAb> playerBotIterator = playerBots_Lst.iterator();
//		Iterator<Sprite_Movable_Collidable_Cl> playerBotIterator = playerBots_Lst.iterator();
//n-		Iterator<Sprite_Core_ClAb> playerBotIterator = playerBots_Lst.iterator();
		Iterator<Sprite_Movable_Collidable_Cl> playerBotIterator = playerBots_Lst.iterator();
		while( playerBotIterator.hasNext() )
		{
//			Sprite_Movable_Collidable_Cl playerBotOb = playerBotIterator.next();
//n-			Sprite_Core_ClAb playerBotOb = playerBotIterator.next();
			Sprite_Movable_Collidable_Cl playerBotOb = playerBotIterator.next();

			//			Sprite_Movable_Collidable_Cl spriteProjectileOb = missilesLstIn.get(i);
			if( playerBotOb.colliding( playerMeObIn ))
			{
				playerBotIterator.remove();
				StarFighter_JFrame_Main_Cl.SCORE--;
			}
			else {

//		    	for(int j = 0; j< playerBots_Lst.size(); j++)
				Iterator<Sprite_Movable_Collidable_Cl> missileIterator = missilesLstIn.iterator();
				while (missileIterator.hasNext()) {
					Sprite_Movable_Collidable_Cl missileOb = missileIterator.next();

//		   		Sprite_Movable_Collidable_Cl playerBotOb = playerBots_Lst.get(j);
					//y-			   if ((missileOb.getX() >= playerBotOb.getX() && missileOb.getX() <= playerBotOb.getX()+60) ||
					//					   (missileOb.getX()+10 >= playerBotOb.getX() && missileOb.getX()+10 <= playerBotOb.getX()+60))
					//				   if ((missileOb.getY() >= playerBotOb.getY() && missileOb.getY() <= playerBotOb.getY()+60) ||
					//						   (missileOb.getY()+10 >= playerBotOb.getY() && missileOb.getY()+10 <= playerBotOb.getY()+60))

					//y-				if ((missileOb.getX() >= playerBotOb.getX() && missileOb.getX() <= playerBotOb.getX()+playerBotOb.getWidth()) ||
					//						(missileOb.getX()+missileOb.getWidth() >= playerBotOb.getX() && missileOb.getX()+missileOb.getWidth() <= playerBotOb.getX()+playerBotOb.getWidth()))
					//				{
					//					if ((missileOb.getY() >= playerBotOb.getY() && missileOb.getY() <= playerBotOb.getY() + playerBotOb.getHeight()) ||
					//							(missileOb.getY() + missileOb.getHeight() >= playerBotOb.getY() && missileOb.getY() + missileOb.getHeight() <= playerBotOb.getY() + playerBotOb.getHeight()))
					//					{
					//						playerBots_Lst.remove(j);
					//						missilesLstIn.remove(i);
					//						break;
					//					}
					//				}

					//y-				if (((missileOb.getX() >= playerBotOb.getX() && missileOb.getX() <= playerBotOb.getX() + playerBotOb.getWidth()  )  &&
					//				     (missileOb.getY() >= playerBotOb.getY() && missileOb.getY() <= playerBotOb.getY() + playerBotOb.getHeight()))
					//					||
					//				    ((missileOb.getX() + missileOb.getWidth()  >= playerBotOb.getX() && missileOb.getX() + missileOb.getWidth()  <= playerBotOb.getX() + playerBotOb.getWidth()  ) &&
					//					 (missileOb.getY() + missileOb.getHeight() >= playerBotOb.getY() && missileOb.getY() + missileOb.getHeight() <= playerBotOb.getY() + playerBotOb.getHeight() )))
					//					{
					//						playerBots_Lst.remove(j);
					//						missilesLstIn.remove(i);
					//						break;
					//					}

					//TODO tried to reverse the objects but failed, projectiles miss front row
//				if( missileOb.colliding( playerBotOb ))
					if (playerBotOb.colliding(missileOb)) {
//					playerBots_Lst.remove();
						playerBotIterator.remove();
//					missilesLstIn.remove(i);
						missileIterator.remove();
						StarFighter_JFrame_Main_Cl.SCORE++;
						break;
					}
				}
			}
		}
	}

	public String toString()
	{
		return "" + playerBots_Lst;
	}
}
