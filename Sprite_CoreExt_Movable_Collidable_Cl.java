//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;

public class Sprite_CoreExt_Movable_Collidable_Cl extends Sprite_Core_ClAb implements Option_Movable_If, Option_Collidable_If {

	public Sprite_CoreExt_Movable_Collidable_Cl()
	{
		this("/images/Circle-Green-20x20.png",0,0,0);
	}

	public Sprite_CoreExt_Movable_Collidable_Cl(String imageFileIn)
	{
		this(imageFileIn, 0, 0, 0);
	}

	public Sprite_CoreExt_Movable_Collidable_Cl(int x, int y)
	{
		this("/images/Circle-Green-20x20.png", x, y, 0);
	}

	public Sprite_CoreExt_Movable_Collidable_Cl(String imageFileIn, int x, int y, int s)
	{
		super(imageFileIn, x, y, s);
		setSpeed(s);
	}
	public Sprite_CoreExt_Movable_Collidable_Cl(String imageFileIn, int x, int y, int w, int h, int s)
	{
		super(imageFileIn, x, y, w, h, s);
		setSpeed(s);
	}

	public void setSpeed(int s)
	{
        speed_Fl =s;
	}
	public int getSpeed()
	{
		return speed_Fl;
	}

    public void move(Game_Cycle_JPanel_Cl.Direction_Enum direction_Enum_In)
	{
		//o- if(direction_Enum_In.equals("LEFT"))
		if(direction_Enum_In == Game_Cycle_JPanel_Cl.Direction_Enum.LEFT)
		  	setX(getX()-getSpeed());
	  	//o- else if(direction_Enum_In.equals("RIGHT"))
		else if(direction_Enum_In == Game_Cycle_JPanel_Cl.Direction_Enum.RIGHT)
		  	setX(getX()+getSpeed());
	  	//o- else if(direction_Enum_In.equals("UP"))
		else if(direction_Enum_In == Game_Cycle_JPanel_Cl.Direction_Enum.UP)
			setY(getY()-getSpeed());
	  	//o- else if(direction_Enum_In.equals("DOWN"))
		else if(direction_Enum_In == Game_Cycle_JPanel_Cl.Direction_Enum.DOWN)
		  	setY(getY()+getSpeed());
		//o- else if(direction_Enum_In.equals("SIDEWAYS_AND_DOWN"))
		else if(direction_Enum_In == Game_Cycle_JPanel_Cl.Direction_Enum.SIDEWAYS_AND_DOWN)
		{
			if(getX() > (Game_Main_JFrame_Cl.WIDTH  - getWidth()) || getX() < (0 + getWidth()) )
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

    //y- public boolean colliding( Sprite_CoreExt_Movable_Collidable_Cl spriteOtherIn )
    //n- public boolean colliding( Sprite_Core_ClAb spriteOtherIn )
    public boolean colliding( Sprite_CoreExt_Movable_Collidable_Cl spriteOtherIn )
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


