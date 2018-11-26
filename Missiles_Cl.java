//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Missiles_Cl
{
	//n-	private List<Sprite_Core_ClAb> missiles_ObsLst_Fl;
	private List<Sprite_Movable_Collidable_Cl> missiles_ObsLst_Fl;

	public Missiles_Cl()
	{
		missiles_ObsLst_Fl = new ArrayList<Sprite_Movable_Collidable_Cl>();
	}

	public void add(Sprite_Movable_Collidable_Cl missileObIn)
	{
	   missiles_ObsLst_Fl.add(missileObIn);
	}

	public void draw( Graphics window )
	{
		for( Sprite_Movable_Collidable_Cl missileOb : missiles_ObsLst_Fl)
			missileOb.draw( window );
	}

	public void move()
	{
		for(Sprite_Movable_Collidable_Cl missileOb : missiles_ObsLst_Fl)
		{
			missileOb.move("UP");
		}
	}

	public void cleanEmUp()
	{
		for(int i = 0; i< missiles_ObsLst_Fl.size(); i++)
		{
//			if(missiles_ObsLst_Fl.get(i).getX()<-20)
			if(missiles_ObsLst_Fl.get(i).getY() < 0)
			   missiles_ObsLst_Fl.remove(i);
		}
	}

	public List<Sprite_Movable_Collidable_Cl> getList()
	{
		return missiles_ObsLst_Fl;
	}

	public String toString()
	{
		return "" + missiles_ObsLst_Fl;
	}
}
