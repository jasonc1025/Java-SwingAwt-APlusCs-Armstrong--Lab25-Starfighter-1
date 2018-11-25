//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;

public class Sprite_MovableYes_CollidableYes_Cl extends SpriteCore_ClAb implements Moveable {
	private int speed;

	public Sprite_MovableYes_CollidableYes_Cl()
	{
		this("/images/Circle-Green-20x20.png",0,0,0);
	}

	public Sprite_MovableYes_CollidableYes_Cl(String imageFileIn)
	{
		this(imageFileIn, 0, 0, 0);
	}

	public Sprite_MovableYes_CollidableYes_Cl(int x, int y)
	{
		this("/images/Circle-Green-20x20.png", x, y, 0);
	}

	public Sprite_MovableYes_CollidableYes_Cl(String imageFileIn, int x, int y, int s)
	{
		super(imageFileIn, x, y);
		speed=s;
	}
	public Sprite_MovableYes_CollidableYes_Cl(String imageFileIn, int x, int y, int w, int h, int s)
	{
		super(imageFileIn, x, y, w, h);
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
	  if(direction.equals("LEFT"))
	      setX(getX()-getSpeed());
      else if(direction.equals("RIGHT"))
	      setX(getX()+getSpeed());
      else if(direction.equals("UP"))
	      setY(getY()-getSpeed());
      else if(direction.equals("DOWN"))
	      setY(getY()+getSpeed());
      else if(direction.equals("SIDEWAYS_AND_DOWN"))
      {
        if(getX() > (StarFighter.WIDTH  - getWidth()) || getX() < (0 + getWidth()) )
        {
            speed = -speed;
			//y- setY(getY()+25);
			setY(getY()+(getHeight()*2));
        }
        setX(getX()+getSpeed());
      }
	}

	public void draw( Graphics window )
	{
   		window.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
	}

	public boolean colliding( Sprite_MovableYes_CollidableYes_Cl spriteOtherObIn )
    {
        boolean colliding_Boo = false;  // * default to false

        if ((this.getX() >= spriteOtherObIn.getX() && this.getX() <= spriteOtherObIn.getX()+spriteOtherObIn.getWidth()) ||
            (this.getX()+this.getWidth() >= spriteOtherObIn.getX() && this.getX()+this.getWidth() <= spriteOtherObIn.getX()+spriteOtherObIn.getWidth()))
        {
            if ((this.getY() >= spriteOtherObIn.getY() && this.getY() <= spriteOtherObIn.getY() + spriteOtherObIn.getHeight()) ||
                (this.getY() + this.getHeight() >= spriteOtherObIn.getY() && this.getY() + this.getHeight() <= spriteOtherObIn.getY() + spriteOtherObIn.getHeight()))
            {
                colliding_Boo = true;
            }
        }
        return colliding_Boo;

    }


	public String toString()
	{
		return super.toString() + getSpeed();
	}
}


