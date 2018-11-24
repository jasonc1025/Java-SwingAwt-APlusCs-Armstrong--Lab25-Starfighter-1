//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Sprite_MovableYes_CollidableYes_Cl_02 extends SpriteCore_ClAb
{
	private int speed;
	private Image image;

	public Sprite_MovableYes_CollidableYes_Cl_02()
	{
		this("/images/Circle-Green-20x20.png", 0,0,50,50,0);
	}

	public Sprite_MovableYes_CollidableYes_Cl_02(int x, int y)
	{
		this("/images/Circle-Green-20x20.png", x, y,50,50,0);
	}

	public Sprite_MovableYes_CollidableYes_Cl_02(int x, int y, int s)
	{
		this("/images/Circle-Green-20x20.png", x, y, 50,50, s);
	}

	public Sprite_MovableYes_CollidableYes_Cl_02(String imageFileIn, int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
//y-			URL url = getClass().getResource("/images/alien.jpg");
			URL url = getClass().getResource(imageFileIn);
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
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
		if(direction.equals("SIDEWAYS_AND_DOWN"))
		{
			if(getX() > StarFighter.WIDTH || getX() < 20)
			{
			   speed = -speed;
			   setY(getY()+25);
			}
			setX(getX()+getSpeed());
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
