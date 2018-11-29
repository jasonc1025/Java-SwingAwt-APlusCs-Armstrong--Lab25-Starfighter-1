//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpritesList_Movable_Collidable_Cl
{
	//n invalid methods-	private List<Sprite_Core_ClAb> playerBots_ObsLst_Fl;
	private List<Sprite_Movable_Collidable_Cl> playerBots_ObsLst_Fl;

	public SpritesList_Movable_Collidable_Cl(int size)
	{
		playerBots_ObsLst_Fl = new ArrayList<Sprite_Movable_Collidable_Cl>();
		int x = 25;
		int y = 50;
		for( int i = 0; i < size; i++)
		{
            //y- 			playerBots_ObsLst_Fl.add( new Sprite_Movable_Collidable_Cl("/images/alien.jpg", x, y, 35, 35, 1) );
			//y- playerBots_ObsLst_Fl.add( new Sprite_Movable_Collidable_Cl("/images/alien.jpg", x, y, 100, 100, 1) );
			playerBots_ObsLst_Fl.add( new Sprite_Movable_Collidable_Cl("/images/ufo.png", x, y, 50, 50, 1) );
			if( x > Game_Main_JFrame_Cl.WIDTH - 50)
			{
				x = 25;
				//y- y += 75;
				y += (playerBots_ObsLst_Fl.get(i).getHeight() * 1);
				playerBots_ObsLst_Fl.get(i).setPos(x,y);
			}
			//y- x += 75;
			x += (playerBots_ObsLst_Fl.get(i).getWidth() * 1);
		}
	}

	public void add(Sprite_Movable_Collidable_Cl playerBotObIn)
	{
	   playerBots_ObsLst_Fl.add(playerBotObIn);
	}

	public void draw( Graphics window )
	{
		//n invalid methods-			for( Sprite_Core_ClAb al : playerBots_ObsLst_Fl)
		for( Sprite_Movable_Collidable_Cl playerBotOb : playerBots_ObsLst_Fl)
			playerBotOb.draw( window );
	}

	public void move()
	{
		//n invalid methods-			for(Sprite_Core_ClAb al : playerBots_ObsLst_Fl)
		for(Sprite_Movable_Collidable_Cl playerBotOb : playerBots_ObsLst_Fl)
		{
			playerBotOb.move("SIDEWAYS_AND_DOWN");
		}
	}

	public void removeDeadOnes(Sprite_Movable_Collidable_Cl playerMe_Ob_In, List<Sprite_Movable_Collidable_Cl> missiles_ObsLst_In)
	{
		//		for(int i = 0; i < missiles_ObsLst_In.size(); i++)
		//n invalid methods-		Iterator<Sprite_Core_ClAb> playerBots_Iterator = playerBots_ObsLst_Fl.iterator();
		Iterator<Sprite_Movable_Collidable_Cl> playerBots_Iterator = playerBots_ObsLst_Fl.iterator();
		while( playerBots_Iterator.hasNext() )
		{
			//n invalid methods-			Sprite_Core_ClAb playerBot_Ob = playerBots_Iterator.next();
			Sprite_Movable_Collidable_Cl playerBot_Ob = playerBots_Iterator.next();

			//			Sprite_Movable_Collidable_Cl spriteProjectileOb = missiles_ObsLst_In.get(i);
			if( playerBot_Ob.colliding( playerMe_Ob_In ))
			{
				playerBots_Iterator.remove();
				Game_Main_JFrame_Cl.SCORE--;
			}
			else {

//		    	for(int j = 0; j< playerBots_ObsLst_Fl.size(); j++)
				Iterator<Sprite_Movable_Collidable_Cl> missile_Iterator = missiles_ObsLst_In.iterator();
				while (missile_Iterator.hasNext()) {
					Sprite_Movable_Collidable_Cl missile_Ob = missile_Iterator.next();

//		   		Sprite_Movable_Collidable_Cl playerBot_Ob = playerBots_ObsLst_Fl.get(j);
					//y-			   if ((missile_Ob.getX() >= playerBot_Ob.getX() && missile_Ob.getX() <= playerBot_Ob.getX()+60) ||
					//					   (missile_Ob.getX()+10 >= playerBot_Ob.getX() && missile_Ob.getX()+10 <= playerBot_Ob.getX()+60))
					//				   if ((missile_Ob.getY() >= playerBot_Ob.getY() && missile_Ob.getY() <= playerBot_Ob.getY()+60) ||
					//						   (missile_Ob.getY()+10 >= playerBot_Ob.getY() && missile_Ob.getY()+10 <= playerBot_Ob.getY()+60))

					//y-				if ((missile_Ob.getX() >= playerBot_Ob.getX() && missile_Ob.getX() <= playerBot_Ob.getX()+playerBot_Ob.getWidth()) ||
					//						(missile_Ob.getX()+missile_Ob.getWidth() >= playerBot_Ob.getX() && missile_Ob.getX()+missile_Ob.getWidth() <= playerBot_Ob.getX()+playerBot_Ob.getWidth()))
					//				{
					//					if ((missile_Ob.getY() >= playerBot_Ob.getY() && missile_Ob.getY() <= playerBot_Ob.getY() + playerBot_Ob.getHeight()) ||
					//							(missile_Ob.getY() + missile_Ob.getHeight() >= playerBot_Ob.getY() && missile_Ob.getY() + missile_Ob.getHeight() <= playerBot_Ob.getY() + playerBot_Ob.getHeight()))
					//					{
					//						playerBots_ObsLst_Fl.remove(j);
					//						missiles_ObsLst_In.remove(i);
					//						break;
					//					}
					//				}

					//y-				if (((missile_Ob.getX() >= playerBot_Ob.getX() && missile_Ob.getX() <= playerBot_Ob.getX() + playerBot_Ob.getWidth()  )  &&
					//				     (missile_Ob.getY() >= playerBot_Ob.getY() && missile_Ob.getY() <= playerBot_Ob.getY() + playerBot_Ob.getHeight()))
					//					||
					//				    ((missile_Ob.getX() + missile_Ob.getWidth()  >= playerBot_Ob.getX() && missile_Ob.getX() + missile_Ob.getWidth()  <= playerBot_Ob.getX() + playerBot_Ob.getWidth()  ) &&
					//					 (missile_Ob.getY() + missile_Ob.getHeight() >= playerBot_Ob.getY() && missile_Ob.getY() + missile_Ob.getHeight() <= playerBot_Ob.getY() + playerBot_Ob.getHeight() )))
					//					{
					//						playerBots_ObsLst_Fl.remove(j);
					//						missiles_ObsLst_In.remove(i);
					//						break;
					//					}

//				if( missile_Ob.colliding( playerBot_Ob ))
					if (playerBot_Ob.colliding(missile_Ob)) {
//					playerBots_ObsLst_Fl.remove();
						playerBots_Iterator.remove();
//					missiles_ObsLst_In.remove(i);
						missile_Iterator.remove();
						Game_Main_JFrame_Cl.SCORE++;
						break;
					}
				}
			}
		}
	}

	public String toString()
	{
		return "" + playerBots_ObsLst_Fl;
	}
}
