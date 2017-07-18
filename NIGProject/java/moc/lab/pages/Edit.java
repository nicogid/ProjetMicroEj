package moc.lab.pages;

import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.Dock;
import ej.widget.container.List;
import ej.widget.container.Scroll;
import ej.widget.listener.OnClickListener;
import ej.widget.navigation.page.Page;
import moc.lab.MyActivity;

public class Edit extends Page {
	private Button plusCarapace = new Button("Plus de carapaces");
	private Button moinsCarapace = new Button("Moins de carapaces");
	private Button plusVitesse = new Button("Plus de vitesse");
	private Button moinsVitesse = new Button("Moins de vitesse");
	private Button mainPage  = new Button("Main page");
	private Label nbCarapace = new Label("nombre de carapaces : ");
	private Label vitesseCarapace = new Label("vitesse des carapaces : ");
	public static int nb;
	public static int vitesse;
	
	
	public Edit(){
		
		Dock dock = new Dock();
		nb = 1;
		vitesse = 1;
		nbCarapace.setText("nombre de carapaces : " + nb);
		vitesseCarapace.setText("vitesse des carapaces : " + vitesse);
		
		plusCarapace.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("plus");
				if(nb >= 10){
					nb = 10;
					nbCarapace.setText("nombre de carapaces : " + nb);
				}
					
				else{
					nb++;
					nbCarapace.setText("nombre de carapaces : " + nb);
				}
					
			}
		});
		
		moinsCarapace.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Moins");
				if(nb <= 1){
					nb = 1;
					nbCarapace.setText("nombre de carapaces : " + nb);
				}
					
				else{
					nb--;
					nbCarapace.setText("nombre de carapaces : " + nb);
				}
			}
		});
		
		plusVitesse.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("plus");
				if(vitesse >= 4){
					vitesse = 10;
					vitesseCarapace.setText("vitesse des carapaces : " + vitesse);
				}
					
				else{
					vitesse++;
					vitesseCarapace.setText("vitesse des carapaces : " + vitesse);
				}
					
			}
		});
		
		moinsVitesse.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Moins");
				if(vitesse <= 1){
					vitesse = 1;
					vitesseCarapace.setText("vitesse des carapaces : " + vitesse);
				}
					
				else{
					vitesse--;
					vitesseCarapace.setText("vitesse des carapaces : " + vitesse);
				}
			}
		});

		mainPage.addOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("Return MainPage");
				MyActivity.show(MainPage.class.getName());// url de navigation
			}
		});
		
		List list1 = new List();
		list1.add(moinsCarapace);
		list1.add(nbCarapace);
		list1.add(plusCarapace);
		List list2= new List();
		list2.add(moinsVitesse);
		list2.add(vitesseCarapace);
		list2.add(plusVitesse);
		Scroll scroll1 = new Scroll(false,true);
		Scroll scroll2 = new Scroll(false,true);
		scroll1.setWidget(list1);
		scroll2.setWidget(list2);
		dock.addTop(scroll1);
		dock.setCenter(scroll2);
		dock.addBottom(mainPage);
		this.setWidget(dock);
	}
}
