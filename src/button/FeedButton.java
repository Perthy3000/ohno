package button;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class FeedButton extends Button {

	private int expBoost;
	private int cost;
	
	public FeedButton(int expBoost,int x) {
		this.expBoost = expBoost;
		cost = expBoost*2;
		setAlignment(Pos.CENTER);
		setText("exp:"+Integer.toString(expBoost)+"\ncost:"+Integer.toString(cost));
		setBorder(new Border(new BorderStroke(Color.TRANSPARENT,BorderStrokeStyle.NONE, 
				CornerRadii.EMPTY, BorderWidths.EMPTY)));
		setStyle("-fx-background-color: transparent;");
		setGrapicBf(x);
		setPrefSize(2, 2);
	}
	
	public int getExp() {
		return expBoost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setGrapicBf(int x) {
		if(x==1) {
			setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exp1bf.png").toString(), 80, 50, false, false)));
		}
		else if(x==2) {
			setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exp2bf.png").toString(), 80, 50, false, false)));
		}
		else if(x==3) {
			setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exp3bf.png").toString(), 80, 50, false, false)));
		}
	}
	
	public void setGrapicAf(int x) {
		if(x==1) {
			setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exp1af.png").toString(), 80, 50, false, false)));
		}
		else if(x==2) {
			setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exp2af.png").toString(), 80, 50, false, false)));
		}
		else if(x==3) {
			setGraphic(new ImageView(new Image(ClassLoader.getSystemResource("exp3af.png").toString(), 80, 50, false, false)));
		}
	}
}
