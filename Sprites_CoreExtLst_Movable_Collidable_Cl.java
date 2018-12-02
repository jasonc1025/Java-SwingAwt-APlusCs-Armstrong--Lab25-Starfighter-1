//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sprites_CoreExtLst_Movable_Collidable_Cl
{
	//n invalid methods-	private List<Sprite_Core_ClAb> sprites_ObsLst_Fl;
	private List<Sprite_CoreExt_Movable_Collidable_Cl> sprites_ObsLst_Fl;

	public Sprites_CoreExtLst_Movable_Collidable_Cl()
	{
		sprites_ObsLst_Fl = new ArrayList<Sprite_CoreExt_Movable_Collidable_Cl>();
	}

	public Sprites_CoreExtLst_Movable_Collidable_Cl(int size)
	{
		sprites_ObsLst_Fl = new ArrayList<Sprite_CoreExt_Movable_Collidable_Cl>();
		int x = 25;
		int y = 50;
		for( int i = 0; i < size; i++)
		{
            //y- 			sprites_ObsLst_Fl.add( new Sprite_CoreExt_Movable_Collidable_Cl("/images/alien.jpg", x, y, 35, 35, 1) );
			//y- sprites_ObsLst_Fl.add( new Sprite_CoreExt_Movable_Collidable_Cl("/images/alien.jpg", x, y, 100, 100, 1) );
			sprites_ObsLst_Fl.add( new Sprite_CoreExt_Movable_Collidable_Cl("/images/ufo.png", x, y, 50, 50, 1) );
			if( x > Game_Main_JFrame_Cl.WIDTH - 50)
			{
				x = 25;
				//y- y += 75;
				y += (sprites_ObsLst_Fl.get(i).getHeight() * 1);
				sprites_ObsLst_Fl.get(i).setPos(x,y);
			}
			//y- x += 75;
			x += (sprites_ObsLst_Fl.get(i).getWidth() * 1);
		}
	}

	public void add(Sprite_CoreExt_Movable_Collidable_Cl sprite_Ob_In)
	{
	   sprites_ObsLst_Fl.add(sprite_Ob_In);
	}

	public void draw( Graphics window )
	{
		//n invalid methods-			for( Sprite_Core_ClAb al : sprites_ObsLst_Fl)
		for( Sprite_CoreExt_Movable_Collidable_Cl sprite_Ob_In : sprites_ObsLst_Fl)
			sprite_Ob_In.draw( window );
	}

	public void move( Game_Cycle_JPanel_Cl.Direction_Enum direction_Enum_In )
	{
		//n invalid methods-			for(Sprite_Core_ClAb al : sprites_ObsLst_Fl)
		for(Sprite_CoreExt_Movable_Collidable_Cl sprite_Ob_In : sprites_ObsLst_Fl)
		{
			//o- sprite_Ob_In.move("SIDEWAYS_AND_DOWN");
			sprite_Ob_In.move( direction_Enum_In );
		}
	}

	public void removeDeadOnes(Sprite_CoreExt_Movable_Collidable_Cl playerMe_Ob_In, List<Sprite_CoreExt_Movable_Collidable_Cl> missiles_ObsLst_In)
	{
		//		for(int i = 0; i < missiles_ObsLst_In.size(); i++)
		//n invalid methods-		Iterator<Sprite_Core_ClAb> playerBots_Iterator = sprites_ObsLst_Fl.iterator();
		Iterator<Sprite_CoreExt_Movable_Collidable_Cl> playerBots_Iterator = sprites_ObsLst_Fl.iterator();
		while( playerBots_Iterator.hasNext() )
		{
			//n invalid methods-			Sprite_Core_ClAb playerBot_Ob = playerBots_Iterator.next();
			Sprite_CoreExt_Movable_Collidable_Cl playerBot_Ob = playerBots_Iterator.next();

			//			Sprite_CoreExt_Movable_Collidable_Cl spriteProjectileOb = missiles_ObsLst_In.get(i);
			if( playerBot_Ob.colliding( playerMe_Ob_In ))
			{
				playerBots_Iterator.remove();
				Game_Main_JFrame_Cl.SCORE--;
			}
			else {

//		    	for(int j = 0; j< sprites_ObsLst_Fl.size(); j++)
				Iterator<Sprite_CoreExt_Movable_Collidable_Cl> missile_Iterator = missiles_ObsLst_In.iterator();
				while (missile_Iterator.hasNext()) {
					Sprite_CoreExt_Movable_Collidable_Cl missile_Ob = missile_Iterator.next();

//		   		Sprite_CoreExt_Movable_Collidable_Cl playerBot_Ob = sprites_ObsLst_Fl.get(j);
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
					//						sprites_ObsLst_Fl.remove(j);
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
					//						sprites_ObsLst_Fl.remove(j);
					//						missiles_ObsLst_In.remove(i);
					//						break;
					//					}

//				if( missile_Ob.colliding( playerBot_Ob ))
					if (playerBot_Ob.colliding(missile_Ob)) {
//					sprites_ObsLst_Fl.remove();
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

	public void cleanEmUp()
	{
		for(int i = 0; i< sprites_ObsLst_Fl.size(); i++)
		{
//			if(sprites_ObsLst_Fl.get(i).getX()<-20)
			if(sprites_ObsLst_Fl.get(i).getY() < 0)
				sprites_ObsLst_Fl.remove(i);
		}
	}

	public List<Sprite_CoreExt_Movable_Collidable_Cl> getList()
	{
		return sprites_ObsLst_Fl;
	}

	public String toString()
	{
		return "" + sprites_ObsLst_Fl;
	}
}
