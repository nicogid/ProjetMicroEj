package moc.lab.pages;

import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.Dock;
import ej.widget.container.List;
import ej.widget.container.Scroll;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;
import moc.lab.widget.GameContent;

public class YourScore extends Page {

	public YourScore(){
		
		List listButtom = new List();
		List list = new List();
		
		Label label = new Label("Votre score " + GameContent.score);
		Button menu = new Button("Menu Principal");
		Button rejouer = new Button("Rejouer");
		
		listButtom.add(menu);
        listButtom.add(rejouer);
		
		menu.addOnClickListener(new OnClickListener() {
					
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Return MainPage");
				MyActivity.show(MainPage.class.getName());// url de navigation
			}
		});
		
		rejouer.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Rejouer");
				MyActivity.show(Game.class.getName());// url de navigation
			}
		});
		
		
		list.add(label);
		list.add(listButtom);
		Scroll scroll = new Scroll(false,true);
		scroll.setWidget(list);
		this.setWidget(scroll); // racine de l'arbre des widgets 
		}
}
