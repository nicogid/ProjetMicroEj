package moc.lab.pages;

import moc.lab.widget.GameContent;

import java.io.IOException;
import java.util.ArrayList;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.exit.ExitHandler;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.style.Stylesheet;
import ej.style.background.SimpleImageBackground;
import ej.style.border.SimpleRectangularBorder;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.selector.TypeSelector;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.Dock;
import ej.widget.container.List;
import ej.widget.container.Scroll;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;

public class Score extends Page {
	
	private static Scroll scroll;
	private static List list;
	
	private Label lb1 = new Label("Score : ??");
	private Label lb2 = new Label("Score : ??");
	private Label lb3 = new Label("Score : ??");
	private Label lb4 = new Label("Score : ??");
	private Label lb5 = new Label("Score : ??");
	private Button bt1 = new Button("Return");
	 public static ArrayList<Integer> scores = new ArrayList<Integer>();
	
	
	public Score() {
		
		Scroll scrollCenter = new Scroll(false, true);
    	
    	Dock dock = new Dock();
		
		list = new List(false);
		
		bt1.addOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Return MainPage");
				MyActivity.show(MainPage.class.getName());// url de navigation
			}
		});
		
		if (!scores.isEmpty()) {
	    	for (int a = scores.size(); a> 0; a--) {
	    		Label tempoLabelScore = new Label(((scores.size() == a)?"Dernier score : " : "")+Integer.toString(scores.get(a-1)));
		    	
	    		list.add(tempoLabelScore);
	    	}
    	} else {
    		Label tempoLabelScore = new Label("Vous n'avez pas encore de score");
    		
    		list.add(tempoLabelScore);
    	}
		
	
		 Label titre = new Label("Score");
	     
		 scrollCenter.setWidget(list);
		 
	     dock.addTop(titre);
	     dock.setCenter(scrollCenter);
	     dock.addBottom(bt1);

	        //on ajoute notre vue splitée à notre page (qui ne peut contenir qu'un seul enfant)
	     this.setWidget(dock);

	}
}