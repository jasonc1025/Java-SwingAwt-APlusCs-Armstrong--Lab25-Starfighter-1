//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Projectiles_Cl
{
	private List<Sprite_MovableYes_CollidableYes_Cl> Projectiles_Lst;

	public Projectiles_Cl()
	{
		Projectiles_Lst = new ArrayList<Sprite_MovableYes_CollidableYes_Cl>();
	}

	public void add(Sprite_MovableYes_CollidableYes_Cl al)
	{
	   Projectiles_Lst.add(al);
	}

	public void draw( Graphics window )
	{
		for( Sprite_MovableYes_CollidableYes_Cl a : Projectiles_Lst)
			a.draw( window );
	}

	public void move()
	{
		for(Sprite_MovableYes_CollidableYes_Cl al : Projectiles_Lst)
		{
			al.move("UP");
		}
	}

	public void cleanEmUp()
	{
		for(int i = 0; i< Projectiles_Lst.size(); i++)
		{
			if(Projectiles_Lst.get(i).getX()<-20)
			   Projectiles_Lst.remove(i);
		}
	}

	public List<Sprite_MovableYes_CollidableYes_Cl> getList()
	{
		return Projectiles_Lst;
	}

	public String toString()
	{
		return "" + Projectiles_Lst;
	}
}
