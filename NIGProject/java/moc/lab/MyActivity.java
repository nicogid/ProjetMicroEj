package moc.lab;

import java.io.IOException;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.style.Style;
import ej.style.Stylesheet;
import ej.style.background.Background;
import ej.style.background.NoBackground;
import ej.style.background.SimpleImageBackground;
import ej.style.border.SimpleRectangularBorder;
import ej.style.outline.SimpleOutline;
import ej.style.selector.ClassSelector;
import ej.style.selector.TypeSelector;
import ej.style.selector.combinator.ChildCombinator;
import ej.style.util.EditableStyle;
import ej.style.util.StyleHelper;
import ej.wadapps.app.Activity;
import ej.widget.basic.Label;
import ej.widget.composed.Button;
import ej.widget.container.Scroll;
import ej.widget.navigation.navigator.SimpleNavigator;
import ej.widget.navigation.transition.HorizontalTransitionManager;
import moc.lab.pages.MainPage;

public class MyActivity implements Activity {
	
	static SimpleNavigator nav;
	public Image fond;
	

	public static void show(String url){
		nav.show(url, true);
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRestart() {
		// TODO Auto-generated method stub

	}

// FOR THE PROGRAMME
//	@Override
//	public void onStart() {
//		MicroUI.start();
//		Program myprog = new Program(null);
//		myprog.show();
//
//	}
	
	@Override
	public void onStart() {
		MicroUI.start();
		
		try{
			fond = Image.createImage("/images/fond.png");
		}catch(IOException e){
			throw new
			AssertionError(e);
		};
		
		SimpleImageBackground img = new SimpleImageBackground(fond,GraphicsContext.LEFT | GraphicsContext.TOP, true);

		
		Stylesheet sts = StyleHelper.getStylesheet();
		EditableStyle myStyle = new EditableStyle();
		
		//EditableStyle MStyle = new EditableStyle();
		//MStyle.setBackgroundColor(Colors.GREEN);
		
		//EditableStyle Style = new EditableStyle();
		
		
		//myStyle.setAlignment(GraphicsContext.HCENTER|GraphicsContext.VCENTER);
		//myStyle.setForegroundColor(Colors.BLUE);
		myStyle.setBackground(img);
		//myStyle.setBackgroundColor(Colors.BLUE);
		//myStyle.setBorder(new SimpleRectangularBorder(10));
		//myStyle.setBorderColor(Colors.RED);
		
		
//		sts.addRule(btnsel,Style);
//		TypeSelector lblsel = new TypeSelector(Label.class);
//		ChildCombinator parentBtnSel = new ChildCombinator(btnsel,lblsel);
//		sts.addRule(parentBtnSel,myStyle);
//		//sts.addRule(new TypeSelector(Label.class), myStyle);
		

		
		
		nav = new SimpleNavigator();
		nav.setTransitionManager(new HorizontalTransitionManager());
		nav.show(MainPage.class.getName(), true);// url de navigation
		
		Desktop desk = new Desktop();
		Panel pnl = new Panel();
		
		TypeSelector lblsel = new TypeSelector(Scroll.class);
		sts.addRule(lblsel, myStyle);
		
		pnl.setWidget(nav);

		pnl.show(desk,true);
		desk.show();

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub

	}

}
