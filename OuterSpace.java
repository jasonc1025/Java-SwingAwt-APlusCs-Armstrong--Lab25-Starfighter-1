//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OuterSpace extends JPanel implements KeyListener, Runnable
{

//y- too fast and choppy- 		ship = new Sprite_MovableYes_CollidableYes_Cl(310,450,5);
//y- 	private Sprite_MovableYes_CollidableYes_Cl ship = new Sprite_MovableYes_CollidableYes_Cl(310,450,1);
	private Sprite_MovableYes_CollidableYes_Cl ship = new Sprite_MovableYes_CollidableYes_Cl( "/images/ship.jpg", 310, 450, 50, 50, 1);

    private AlienHorde horde;
	private Bullets shots;

//	private Long cycle_ProjectileLast_NanoTime = new Long( 0 );
//	private Long cycle_Last_NanoTime = new Long( 0 );
//	private Long cycle_Current_NanoTime = new Long( 0 );

    // * IMPORTANT: 1 sec = 1 x 10^9 nano-sec
    // * IMPORTANT: To avoid 'java: integer number too large' error, require 'l' for 64bit otherwise 32bit default
    // * Projectile at 1/10 sec frequency
	private long gameCycle_Projectile_Prev_NanoSec = 0l;
	private long gameCycle_Prev_NanoSec = 0l;
	private long gameCycle_Curr_NanoSec = 0l;
    private long gameCycle_Fps_NanoSec = 0l;
    private long gameCycle_Projectile_Per_Sec = 10;
    private double gameCycle_Period_Sec = 0.0;
    private long gameCycle_DelayFactor_MilliSec = 10; // 5msec too fast, 20msec kindof slow, 10msec seems right


	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace(JFrame par)
	{
		keys = new boolean[5];

		setBackground(Color.black);

		horde = new AlienHorde(20);

		shots = new Bullets();

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{

		//
		// * Timer Update
		//

		// * Calculate timer since last GameEngine Cycle
		gameCycle_Curr_NanoSec = System.nanoTime();
		gameCycle_Period_Sec = (gameCycle_Curr_NanoSec - gameCycle_Prev_NanoSec) / 1000000000.0;
		gameCycle_Fps_NanoSec = Math.round(1/ gameCycle_Period_Sec);
		gameCycle_Prev_NanoSec = gameCycle_Curr_NanoSec;
		//y- debug- System.out.println("> "+ gameCycle_Fps_NanoSec.value);
		//y- System.out.println("> FPS: "+ gameCycle_Fps_NanoSec);


		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null){
			StarFighter.HEIGHT = this.getHeight();
	      StarFighter.WIDTH = this.getWidth();
	      //System.out.println(StarFighter.WIDTH);
		   back = (BufferedImage)(createImage(this.getWidth(),this.getHeight()));
	   }

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,this.getWidth(),this.getHeight());

		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
        // * IMPORTANT: 1 sec = 1 x 10^9 nano-sec
        // * IMPORTANT: To avoid 'java: integer number too large' error, require 'l' for 64bit otherwise 32bit default
        // * Projectile at 1/10 sec frequency (or (1/10 * Math.pow(10,9)) nanosec)
        // ** '1.0' required for decimal division
		if( (keys[4] == true) && ( gameCycle_Curr_NanoSec - gameCycle_Projectile_Prev_NanoSec > (1.0/gameCycle_Projectile_Per_Sec * Math.pow(10,9)) ) )
		{
			//y- shots.add(new Sprite_MovableYes_CollidableYes_Cl(ship.getX()+ship.getWidth()/2-5, ship.getY(), 10, 10, 5));
			shots.add(new Sprite_MovableYes_CollidableYes_Cl( "/images/Circle-Green-20x20.png",ship.getX()+ship.getWidth()/2-5, ship.getY(), 10, 10, 5));
			//y turn off to allow continuous fire- keys[4] = false;
            gameCycle_Projectile_Prev_NanoSec = gameCycle_Curr_NanoSec;
		}

		shots.move();
		shots.draw(graphToBack);

		ship.draw(graphToBack);
		horde.move();
		horde.draw(graphToBack);



		//collision detection
		shots.cleanEmUp();
		horde.removeDeadOnes(shots.getList());


		twoDGraph.drawImage(back, null, 0, 0);
		back = null;
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
			//y- Thread.currentThread().sleep(5);
			//y- Thread.currentThread().sleep(20);
            //y- Thread.currentThread().sleep(10);  // 5msec too fast, 20msec kindof slow, 10msec seems right
            Thread.currentThread().sleep(gameCycle_DelayFactor_MilliSec);  // 5msec too fast, 20msec kindof slow, 10msec seems right
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

