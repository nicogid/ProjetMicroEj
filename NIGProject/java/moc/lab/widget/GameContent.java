package moc.lab.widget;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.microui.display.Colors;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.mwt.Widget;
import ej.style.Element;
import ej.style.State;
import moc.lab.MyActivity;
import moc.lab.carapace.Carapace;
import moc.lab.pages.Edit;
import moc.lab.pages.MainPage;
import moc.lab.pages.Score;
import moc.lab.pages.YourScore;

public class GameContent extends Widget implements Element {

	private static final int NO_DELAY = 0;
	private static final int DEFAULT_PERIOD = 10;
	
	// Coords Background Image
	int DimH; //Px
	int DimV; //Py
	
	// Coords Block
	public int ElH; //Px
	public int ElV; //Py
	
	// Coords Perso
	public int BlV; // Py
	public int BlH; // Px
	
	// Image Declaration
	private Image saut; 
	private Image carre;
	private Image fond;
	
	public static int score;
	
	private final Font font = Font.getFont(Font.LATIN, 26 , Font.STYLE_PLAIN);
	
	public ArrayList<Carapace> objects= new ArrayList<Carapace>();
	
	public GameContent(int height,int width){
		super();
		
		System.out.println("nb de carapace " + Edit.nb);
		DimH = width;
		DimV = height;
		ElV = height-20;
		//objects.add(new Carapace(width,ElV));
		//objects.add(new Carapace(width-20,ElV));
		initCarapace(width,height);
		
		BlV = height-30;
		BlH = width/6;
		score = 0;
		try{
			saut = Image.createImage("/images/carapace.png");
		}catch(IOException e){
			throw new
			AssertionError(e);
		};
		
		try{
			carre = Image.createImage("/images/mario.png");
		}catch(IOException e){
			throw new
			AssertionError(e);
		};
		
		try{
			fond = Image.createImage("/images/fond.png");
		}catch(IOException e){
			throw new
			AssertionError(e);
		};

		
		
		// Create a timer (implicitly, create a new Thread)
		Timer timer = new Timer();
		
		

		// Use the same timer to schedule multiple tasks
		//timer.schedule(object, NO_DELAY, DEFAULT_PERIOD);
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<objects.size();i++){
					int value = objects.get(i).getPx()-(Edit.vitesse <= 0?1:Edit.vitesse);
					objects.get(i).setPx(value);
					
					if(objects.get(i).getPx()<0){
						Random rand = new Random();

						    // nextInt is normally exclusive of the top value,
						    // so add 1 to make it inclusive
						 int randomY = rand.nextInt((height-30 - 1) + 1) + 1;
						 int randomX = rand.nextInt((width - width/2+20) + 1) + width/2+20;
						objects.get(i).setPx(randomX);
						objects.get(i).setPy(randomY);
						score += 1; 
					}
					if(objects.get(i).getPx() > BlH-40 && objects.get(i).getPx() < BlH+40  && objects.get(i).getPy() > BlV-40 && objects.get(i).getPy() < BlV+40){
						this.cancel();
						Score.scores.add(new Integer(score));
						System.out.println(score);
						MyActivity.show(YourScore.class.getName());
					}

					
				}
				repaint();
			}
		},NO_DELAY, DEFAULT_PERIOD);
		
		
	}

	
	
	@Override
	public void render(GraphicsContext g) {
		
		g.setColor(Colors.WHITE);
		g.fillRect(0,0,DimH,DimV);
		
		g.drawImage(fond,0,0,GraphicsContext.TOP|GraphicsContext.LEFT);
		
		String myString = new String("Votre scrore : " + score);
		g.setFont(font);
		
		g.setColor(Colors.BLACK);
		g.drawString(myString, 0, 0, GraphicsContext.TOP|GraphicsContext.LEFT);
		
		
		                
		for(int i = 0; i < objects.size(); i++)
		{
			g.drawImage(saut,objects.get(i).getPx(),objects.get(i).getPy(),GraphicsContext.
					HCENTER|GraphicsContext.VCENTER);
		}               
		 
//		g.drawImage(saut,ElH,ElV,GraphicsContext.
//				HCENTER|GraphicsContext.VCENTER);
		
		
		g.drawImage(carre,BlH,BlV,GraphicsContext.
				HCENTER|GraphicsContext.VCENTER);
		
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		// TODO Auto-generated method stub

	}
	
	// Action in handler
		@Override
		public boolean handleEvent(int event) {
			if(Event.getType(event)== Event.POINTER){
				if(Pointer.isDragged(event)){
					Pointer ptr = (Pointer) Event.getGenerator(event);
					this.BlV = getRelativeY(ptr.getY());
				}
			}
			return false;
		}



		@Override
		public boolean hasClassSelector(String classSelector) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public boolean isInState(State state) {
			// TODO Auto-generated method stub
			return false;
		}



		@Override
		public String getAttribute(String attribute) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Element getParentElement() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Element[] getChildrenElements() {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public Element getChild(int index) {
			// TODO Auto-generated method stub
			return null;
		}



		@Override
		public int getChildrenCount() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public void initCarapace(int width,int height) {
			Random rand = new Random();
			
			for(int i = 0;i<(Edit.nb <= 0?1:Edit.nb);i++){
				int randomY = rand.nextInt((height-30 - 1) + 1) + 1;
				int randomX = rand.nextInt((width - width/2+20) + 1) + width/2+20;
				objects.add(new Carapace(randomY,randomX));
			}
			
		}

}
