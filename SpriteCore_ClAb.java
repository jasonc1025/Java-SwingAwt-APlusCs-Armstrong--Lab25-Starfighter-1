//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;

public abstract class SpriteCore_ClAb implements Moveable
{
	private int positionX_Fl;
	private int positionY_Fl;
	private int imageWidth_Fl;
	private int imageHeight_Fl;

	public SpriteCore_ClAb()
	{
		positionX_Fl = 10;
		positionY_Fl = 10;
		imageWidth_Fl = 10;
		imageHeight_Fl = 10;
	}

	public SpriteCore_ClAb(int x, int y)
	{
		positionX_Fl = x;
		positionY_Fl = y;
		imageWidth_Fl = 10;
		imageHeight_Fl = 10;
	}

	public SpriteCore_ClAb(int x, int y, int w, int h)
	{
		positionX_Fl = x;
		positionY_Fl = y;
		imageWidth_Fl = w;
		imageHeight_Fl = h;
	}

	public void setPos( int x, int y)
	{
		positionX_Fl = x;
		positionY_Fl = y;
	}

	public void setX(int x)
	{
		positionX_Fl =x;
	}

	public void setY(int y)
	{
		positionY_Fl =y;
	}

	public int getX()
	{
		return positionX_Fl;
	}

	public int getY()
	{
		return positionY_Fl;
	}

	public void setWidth(int w)
	{
		imageWidth_Fl = w;
	}

	public void setHeight(int h)
	{
		imageHeight_Fl = h;
	}

	public int getWidth()
	{
		return imageWidth_Fl;
	}

	public int getHeight()
	{
		return imageHeight_Fl;
	}

	public abstract void move(String direction);
	public abstract void draw(Graphics window);

	public String toString()
	{
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}