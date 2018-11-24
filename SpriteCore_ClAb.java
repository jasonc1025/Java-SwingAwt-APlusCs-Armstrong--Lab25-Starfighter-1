//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

public abstract class SpriteCore_ClAb implements Moveable
{
	//y- protected Image image_Fl;
	private Image image_Fl;
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

	public SpriteCore_ClAb(String imageFileIn, int x, int y, int w, int h)
	{
		positionX_Fl = x;
		positionY_Fl = y;

		try
		{
			//y- URL url = getClass().getResource("/images/ship.jpg");
			URL url = getClass().getResource(imageFileIn);
			setImage(ImageIO.read(url));
			this.imageWidth_Fl = w;
			this.imageHeight_Fl = h;
		}
		catch(Exception e)
		{
			//feel free to do something here
		}

	}

	public SpriteCore_ClAb(String imageFileIn, int x, int y)
	{
		positionX_Fl = x;
		positionY_Fl = y;
		//y- imageWidth_Fl = w;
		//y- imageHeight_Fl = h;

		try
		{
			//y- URL url = getClass().getResource("/images/ship.jpg");
			URL url = getClass().getResource(imageFileIn);
			setImage(ImageIO.read(url));
			this.imageWidth_Fl = image_Fl.getWidth( null );
			this.imageHeight_Fl = image_Fl.getHeight( null );
		}
		catch(Exception e)
		{
			//feel free to do something here
		}

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

	public Image getImage() {
		return image_Fl;
	}

	public void setImage(Image imageFlIn) {
		this.image_Fl = imageFlIn;
		this.imageWidth_Fl = imageFlIn.getWidth( null );
		this.imageHeight_Fl = imageFlIn.getHeight( null );
	}
	public void setImageSize(int w, int h) {
		this.imageWidth_Fl = w;
		this.imageHeight_Fl = h;
	}
}