//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Sprite_MovableYes_CollidableYes_Cl> ammo;

	public Bullets()
	{
		ammo = new ArrayList<Sprite_MovableYes_CollidableYes_Cl>();
	}

	public void add(Sprite_MovableYes_CollidableYes_Cl al)
	{
	   ammo.add(al);
	}

	public void draw( Graphics window )
	{
		for( Sprite_MovableYes_CollidableYes_Cl a : ammo)
			a.draw( window );
	}

	public void move()
	{
		for(Sprite_MovableYes_CollidableYes_Cl al : ammo)
		{
			al.move("UP");
		}
	}

	public void cleanEmUp()
	{
		for(int i=0; i<ammo.size(); i++)
		{
			if(ammo.get(i).getX()<-20)
			   ammo.remove(i);
		}
	}

	public List<Sprite_MovableYes_CollidableYes_Cl> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return "" + ammo;
	}
}
