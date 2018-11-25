//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;

public class Sprite_Movable_Collidable_Cl extends Sprite_Core_ClAb implements Movable_If, Collidable_If {

    public Sprite_Movable_Collidable_Cl()
	{
		this("/images/Circle-Green-20x20.png",0,0,0);
	}

	public Sprite_Movable_Collidable_Cl(String imageFileIn)
	{
		this(imageFileIn, 0, 0, 0);
	}

	public Sprite_Movable_Collidable_Cl(int x, int y)
	{
		this("/images/Circle-Green-20x20.png", x, y, 0);
	}

	public Sprite_Movable_Collidable_Cl(String imageFileIn, int x, int y, int s)
	{
		super(imageFileIn, x, y, s);
    }
	public Sprite_Movable_Collidable_Cl(String imageFileIn, int x, int y, int w, int h, int s)
	{
		super(imageFileIn, x, y, w, h, s);
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
        if(getX() > (StarFighter_JFrame_Main_Cl.WIDTH  - getWidth()) || getX() < (0 + getWidth()) )
        {
            setSpeed(-getSpeed());
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

    //y- public boolean colliding( Sprite_Movable_Collidable_Cl spriteOtherIn )
    //n- public boolean colliding( Sprite_Core_ClAb spriteOtherIn )
    public boolean colliding( Sprite_Movable_Collidable_Cl spriteOtherIn )
    {
        boolean colliding_Boo = false;  // * default to false

//y-        if ((this.getX() >= spriteOtherObIn.getX() && this.getX() <= spriteOtherObIn.getX()+spriteOtherObIn.getWidth()) ||
//            (this.getX()+this.getWidth() >= spriteOtherObIn.getX() && this.getX()+this.getWidth() <= spriteOtherObIn.getX()+spriteOtherObIn.getWidth()))
//        {
//            if ((this.getY() >= spriteOtherObIn.getY() && this.getY() <= spriteOtherObIn.getY() + spriteOtherObIn.getHeight()) ||
//                (this.getY() + this.getHeight() >= spriteOtherObIn.getY() && this.getY() + this.getHeight() <= spriteOtherObIn.getY() + spriteOtherObIn.getHeight()))
//        }

//y-        if (((this.getX() >= spriteOtherIn.getX() && this.getX() <= spriteOtherIn.getX() + spriteOtherIn.getWidth()  )  &&
//                (this.getY() >= spriteOtherIn.getY() && this.getY() <= spriteOtherIn.getY() + spriteOtherIn.getHeight()))
//                ||
//                ((this.getX() + this.getWidth()  >= spriteOtherIn.getX() && this.getX() + this.getWidth()  <= spriteOtherIn.getX() + spriteOtherIn.getWidth()  ) &&
//                        (this.getY() + this.getHeight() >= spriteOtherIn.getY() && this.getY() + this.getHeight() <= spriteOtherIn.getY() + spriteOtherIn.getHeight() )))
        // * (Sprite-01-XYMax >= Sprite-02-XYMin) && (Sprite-01-XYMin <= Sprite-02-XYMax)
        // * ...in other words...
        // * (this-XYMax >= spriteOtherIn-XYMin) && (this-XYMin <= spriteOtherIn-XYMax)
        if (
            ((this.getX() + this.getWidth() >= spriteOtherIn.getX()) && (this.getY() + this.getHeight() >= spriteOtherIn.getY())) &&
            ((this.getX() <= spriteOtherIn.getX() + spriteOtherIn.getWidth()) && (this.getY() <= spriteOtherIn.getY() + spriteOtherIn.getHeight()))
           )
            {
                colliding_Boo = true;
            }
        return colliding_Boo;
    }


	public String toString()
	{
		return super.toString() + getSpeed();
	}
}


