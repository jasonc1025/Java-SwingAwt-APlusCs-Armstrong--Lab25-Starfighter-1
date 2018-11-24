//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Sprite_MovableYes_CollidableYes_Cl_03 extends SpriteCore_ClAb
{
	private int speed;

	public Sprite_MovableYes_CollidableYes_Cl_03()
	{
		this(0,0,0,0,0);
	}

	public Sprite_MovableYes_CollidableYes_Cl_03(int x, int y)
	{
		this(x,y,10,10,0);
	}

	public Sprite_MovableYes_CollidableYes_Cl_03(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
	}

	public void setSpeed(int s)
	{
	   speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void move(String direction)
	{
      if(direction.equals("UP"))
	      setY(getY()-getSpeed());
      else if(direction.equals("DOWN"))
	      setY(getY()+getSpeed());
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
   	window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
