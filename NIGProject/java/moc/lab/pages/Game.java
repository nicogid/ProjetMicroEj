package moc.lab.pages;


import ej.widget.container.Dock;
import ej.widget.navigation.page.Page;

import moc.lab.widget.GameContent;


public class Game extends Page {

	Dock dock;
	
	public Game(){
		
		dock = new Dock();
		dock.setCenter(new GameContent(272, 480));
		this.setWidget(dock);
		
	}
	
	
}
