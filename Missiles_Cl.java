//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Missiles_Cl
{
//	private List<Sprite_Movable_Collidable_Cl> missles_Lst;
	private List<Sprite_Movable_Collidable_Cl> missles_Lst;

	public Missiles_Cl()
	{
		missles_Lst = new ArrayList<Sprite_Movable_Collidable_Cl>();
	}

	public void add(Sprite_Movable_Collidable_Cl al)
	{
	   missles_Lst.add(al);
	}

	public void draw( Graphics window )
	{
		for( Sprite_Movable_Collidable_Cl a : missles_Lst)
			a.draw( window );
	}

	public void move()
	{
		for(Sprite_Movable_Collidable_Cl al : missles_Lst)
		{
			al.move("UP");
		}
	}

	public void cleanEmUp()
	{
		for(int i = 0; i< missles_Lst.size(); i++)
		{
//			if(missles_Lst.get(i).getX()<-20)
			if(missles_Lst.get(i).getY() < 0)
			   missles_Lst.remove(i);
		}
	}

	public List<Sprite_Movable_Collidable_Cl> getList()
	{
		return missles_Lst;
	}

	public String toString()
	{
		return "" + missles_Lst;
	}
}
