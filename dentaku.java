/*1116210001 阿部勝寿*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.event.ActionEvent;

import java.math.BigDecimal;

public class Kadai_FX extends Application{

	String imagePath = getClass().getResource("fire.png").toString();
	Image image = new Image(imagePath);

	String imagePath2 = getClass().getResource("busy.png").toString();
	Image image2 = new Image(imagePath2);

	String imagePath3 = getClass().getResource("hug.png").toString();
	Image image3 = new Image(imagePath3);

	ImageView subimage;
	ImageView imageView1 = new ImageView(image);
	ImageView imageView2 = new ImageView(image);
	ImageView imageView3 = new ImageView(image);
	ImageView imageView4 = new ImageView(image);
	ImageView imageView6 = new ImageView(image);
	ImageView imageView7 = new ImageView(image);
	ImageView imageView8 = new ImageView(image);
	ImageView imageView9 = new ImageView(image);

	ImageView bee = new ImageView(image2);
	ImageView bee2 = new ImageView(image2);
	ImageView bee3 = new ImageView(image2);
	ImageView bee4 = new ImageView(image2);

	ImageView bear = new ImageView(image3);

	GraphicsContext gc;

	Canvas canvas;
	Group root;

	BigDecimal iresult=new BigDecimal("0");
	TextField calculation;
	TextField result;
	String string ="0";

	int consectiveopeflag=0;
	int firstopeflag=0;
	int opeflag=5;
	int dotflag=0;
	int errorflag=0;

	public static void main(String args[]) {
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) {

    	root = new Group();
    	canvas = new Canvas(1500,1000);
    	root.getChildren().add(canvas);

		imageView1.setX(225.0);
		imageView1.setY(1000.0-150-60-20);
		root.getChildren().add(imageView1);

		imageView2.setX(750.0-50);
		imageView2.setY(1000.0-75-60-20);
		root.getChildren().add(imageView2);

		imageView3.setX(225.0+425*2+100);
		imageView3.setY(1000.0-150-60-20);
		root.getChildren().add(imageView3);

		imageView4.setX(225.0-75);
		imageView4.setY(150.0+320);
		root.getChildren().add(imageView4);

		imageView6.setX(225.0-75+500*2+100);
		imageView6.setY(150.0+320);
		root.getChildren().add(imageView6);

		imageView7.setX(240);
		imageView7.setY(150);
		root.getChildren().add(imageView7);

		imageView8.setX(750.0-50);
		imageView8.setY(150.0-75);
		root.getChildren().add(imageView8);

		imageView9.setX(225.0+425*2+100);
		imageView9.setY(150);
		root.getChildren().add(imageView9);

		bee.setX(200);
		bee.setY(300);
		root.getChildren().add(bee);
		TranslateTransition tt = new TranslateTransition(Duration.millis(500), bee);
        tt.setToX(+100);
        tt.setCycleCount(tt.INDEFINITE);
    	tt.setAutoReverse(true);
        tt.play();

    	bee2.setX(1200);
    	bee2.setY(400);
    	root.getChildren().add(bee2);
    	TranslateTransition tt2 = new TranslateTransition(Duration.millis(500), bee2);
        tt2.setToX(-100);
        tt2.setCycleCount(tt2.INDEFINITE);
        tt2.setAutoReverse(true);
        tt2.play();

        bee3.setX(600);
        bee3.setY(800);
        root.getChildren().add(bee3);
        TranslateTransition tt3 = new TranslateTransition(Duration.millis(500), bee3);
        tt3.setToX(-100);
        tt3.setCycleCount(tt3.INDEFINITE);
        tt3.setAutoReverse(true);
        tt3.play();

        bee4.setX(1400);
        bee4.setY(900);
        root.getChildren().add(bee4);
        TranslateTransition tt4 = new TranslateTransition(Duration.millis(500), bee4);
        tt4.setToX(-100);
        tt4.setCycleCount(tt4.INDEFINITE);
        tt4.setAutoReverse(true);
        tt4.play();


        bear.setX(800);
        bear.setY(800);
        root.getChildren().add(bear);
        TranslateTransition tt5 = new TranslateTransition(Duration.millis(50), bear);
        tt5.setToX(+100);
        tt5.setCycleCount(tt5.INDEFINITE);
        tt5.setAutoReverse(true);
        tt5.play();

		calculation = new TextField("0");
		calculation.setAlignment(Pos.CENTER_RIGHT);
		calculation.setFont(new Font(25));
		calculation.setPrefSize(300, 75);
		calculation.setLayoutX(600);
		calculation.setLayoutY(325);

        result = new TextField("0");
        result.setAlignment(Pos.CENTER_RIGHT);
        result.setFont(new Font(25));
        result.setPrefSize(300, 75);
        result.setLayoutX(600);
        result.setLayoutY(250);

    	gc = canvas.getGraphicsContext2D();
		gc.setFill(new Color(1, 0, 1, 1));
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setFill(new Color(1, 0, 0, 1));
		gc.fillOval(0, 0, canvas.getWidth(), canvas.getHeight());
		gc.setFill(new Color(0, 0, 0, 1));
		gc.fillOval(750-375, 500-375, 750, 750);
		gc.setFill(new Color(0, 0, 1, 1));
		gc.fillOval(750-75, 500-375, 150, 750);

		Button btnnum[] = new Button[11];

		btnnum[0] = new Button("0");
		btnnum[1] = new Button("1");
		btnnum[2] = new Button("2");
		btnnum[3] = new Button("3");
		btnnum[4] = new Button("4");
		btnnum[5] = new Button("5");
		btnnum[6] = new Button("6");
		btnnum[7] = new Button("7");
		btnnum[8] = new Button("8");
		btnnum[9] = new Button("9");
		btnnum[10] = new Button(".");

		Button btnope[]= new Button[5];

		btnope[0] = new Button("=");
		btnope[1] = new Button("+");
		btnope[2] = new Button("-");
		btnope[3] = new Button("×");
		btnope[4] = new Button("÷");

		Button btnother[]= new Button[3];
		btnother[0] = new Button("±");
		btnother[1] = new Button("%");
		btnother[2] = new Button("AC");

		int i=0;

		for(i=0;i<11;i++)
			btnnum[i].setOnAction(new Btnnum());

		for(i=0;i<5;i++)
			btnope[i].setOnAction(new Btnope());

		for(i=0;i<3;i++)
			btnother[i].setOnAction(new Btnother());

			btnother[2].setOnAction(new BtnAC());

		    double width = 75;
	        double height = 75;
	        int font = 25;

	        for(i = 0; i < 11; i++) {

	            btnnum[i].setPrefHeight(height);
	            btnnum[i].setPrefWidth(width);
	            btnnum[i].setFont(new Font(font));

	            btnnum[i].setStyle("-fx-border-radius:100px;"
	            					+ "-fx-background-color: #696969;-fx-text-fill: white; "
	            					+ "-fx-background-radius: 100px;");

	        }

	        for(i = 0; i < 5; i++) {

	        	btnope[i].setPrefHeight(height);
	            btnope[i].setPrefWidth(width);
	            btnope[i].setFont(new Font(font));

	            btnope[i].setStyle("-fx-border-radius: 100px;"
	            					+ "-fx-background-color: orange;-fx-text-fill: white; "
	            					+ "-fx-background-radius: 100px;");

	        }

	        for(i = 0; i < 3; i++) {

	            btnother[i].setPrefHeight(height);
	            btnother[i].setPrefWidth(width);
	            btnother[i].setFont(new Font(font));

	            btnother[i].setStyle("-fx-border-radius: 100px;"
	            						+ "-fx-background-color: #c0c0c0;-fx-text-fill: black; "
	            						+ "-fx-background-radius: 100px;");

	        }

		GridPane grid = new GridPane();
		GridPane.setConstraints(btnnum[7], 0, 1);
		GridPane.setConstraints(btnnum[8], 1, 1);
		GridPane.setConstraints(btnnum[9], 2, 1);
		GridPane.setConstraints(btnnum[4], 0, 2);
		GridPane.setConstraints(btnnum[5], 1, 2);
		GridPane.setConstraints(btnnum[6], 2, 2);
		GridPane.setConstraints(btnnum[1], 0, 3);
		GridPane.setConstraints(btnnum[2], 1, 3);
		GridPane.setConstraints(btnnum[3], 2, 3);
		GridPane.setConstraints(btnnum[0], 0, 4);
		GridPane.setConstraints(btnnum[10],2, 4);

		GridPane.setConstraints(btnope[0], 3, 4);
		GridPane.setConstraints(btnope[1], 3, 3);
		GridPane.setConstraints(btnope[2], 3, 2);
		GridPane.setConstraints(btnope[3], 3, 1);
		GridPane.setConstraints(btnope[4], 3, 0);

		GridPane.setConstraints(btnother[0], 1, 0);
		GridPane.setConstraints(btnother[1], 2, 0);
		GridPane.setConstraints(btnother[2], 0, 0);


		for(i=1;i<10;i++)
			grid.getChildren().addAll(btnnum[i]);
		for(i=1;i<5;i++)
			grid.getChildren().addAll(btnope[i]);
		for(i=0;i<3;i++)
			grid.getChildren().addAll(btnother[i]);

		 btnnum[0].setPrefHeight(height);
         btnnum[0].setPrefWidth(width*2);
         btnnum[0].setFont(new Font(font));

         grid.setLayoutX(600);
         grid.setLayoutY(400);

         btnnum[0].setLayoutX(600);
         btnnum[0].setLayoutY(700);

         btnnum[10].setLayoutX(750);
         btnnum[10].setLayoutY(700);

         btnope[0].setLayoutX(825);

         btnope[0].setLayoutY(700);

			Polygon dokanup7 = new Polygon();
			dokanup7.setFill(Color.GREEN);
			dokanup7.setStroke(Color.BLACK);
			dokanup7.setStrokeWidth(2.0);
			dokanup7.getPoints().addAll(
					225.0,150.0,
					325.0,150.0,
					320.0,170.0,
					230.0,170.0);

			Polygon dokandown7 = new Polygon();
			dokandown7.setFill(Color.GREEN);
			dokandown7.setStroke(Color.BLACK);
			dokandown7.setStrokeWidth(2.0);

			dokandown7.getPoints().addAll(
					233.0,170.0,
					317.0,170.0,
					307.0,230.0,
					243.0,230.0);

			Polygon dokanup8 = new Polygon();
			dokanup8.setFill(Color.GREEN);
			dokanup8.setStroke(Color.BLACK);
			dokanup8.setStrokeWidth(2.0);
			dokanup8.getPoints().addAll(
					750.0-50,150.0-75,
					750.0+50,150.0-75,
					750.0+45,170.0-75,
					750.0-45,170.0-75);

			Polygon dokandown8 = new Polygon();
			dokandown8.setFill(Color.GREEN);
			dokandown8.setStroke(Color.BLACK);
			dokandown8.setStrokeWidth(2.0);

			dokandown8.getPoints().addAll(
					750.0-42,170.0-75,
					750.0+42,170.0-75,
					750.0+32,230.0-75,
					750.0-32,230.0-75);


			Polygon dokanup9 = new Polygon();
			dokanup9.setFill(Color.GREEN);
			dokanup9.setStroke(Color.BLACK);
			dokanup9.setStrokeWidth(2.0);
			dokanup9.getPoints().addAll(
					225.0+425*2+100,150.0,
					325.0+425*2+100,150.0,
					320.0+425*2+100,170.0,
					230.0+425*2+100,170.0);

			Polygon dokandown9 = new Polygon();
			dokandown9.setFill(Color.GREEN);
			dokandown9.setStroke(Color.BLACK);
			dokandown9.setStrokeWidth(2.0);

			dokandown9.getPoints().addAll(
					233.0+425*2+100,170.0,
					317.0+425*2+100,170.0,
					307.0+425*2+100,230.0,
					243.0+425*2+100,230.0);

			Polygon dokanup4 = new Polygon();
			dokanup4.setFill(Color.GREEN);
			dokanup4.setStroke(Color.BLACK);
			dokanup4.setStrokeWidth(2.0);
			dokanup4.getPoints().addAll(
					225.0-75,150.0+320,
					325.0-75,150.0+320,
					320.0-75,170.0+320,
					230.0-75,170.0+320);

			Polygon dokandown4 = new Polygon();
			dokandown4.setFill(Color.GREEN);
			dokandown4.setStroke(Color.BLACK);
			dokandown4.setStrokeWidth(2.0);
			dokandown4.getPoints().addAll(
					233.0-75,170.0+320,
					317.0-75,170.0+320,
					307.0-75,230.0+320,
					243.0-75,230.0+320);

			Polygon dokanup6 = new Polygon();
			dokanup6.setFill(Color.GREEN);
			dokanup6.setStroke(Color.BLACK);
			dokanup6.setStrokeWidth(2.0);
			dokanup6.getPoints().addAll(
					225.0-75+500*2+100,150.0+320,
					325.0-75+500*2+100,150.0+320,
					320.0-75+500*2+100,170.0+320,
					230.0-75+500*2+100,170.0+320);

			Polygon dokandown6 = new Polygon();
			dokandown6.setFill(Color.GREEN);
			dokandown6.setStroke(Color.BLACK);
			dokandown6.setStrokeWidth(2.0);
			dokandown6.getPoints().addAll(
					233.0-75+500*2+100,170.0+320,
					317.0-75+500*2+100,170.0+320,
					307.0-75+500*2+100,230.0+320,
					243.0-75+500*2+100,230.0+320);

			Polygon dokanup3 = new Polygon();
			dokanup3.setFill(Color.GREEN);
			dokanup3.setStroke(Color.BLACK);
			dokanup3.setStrokeWidth(2.0);
			dokanup3.getPoints().addAll(
					225.0+425*2+100,1000.0-150-60-20,
					325.0+425*2+100,1000.0-150-60-20,
					320.0+425*2+100,1000.0-150-60,
					230.0+425*2+100,1000.0-150-60);

			Polygon dokandown3 = new Polygon();
			dokandown3.setFill(Color.GREEN);
			dokandown3.setStroke(Color.BLACK);
			dokandown3.setStrokeWidth(2.0);
			dokandown3.getPoints().addAll(
					233.0+425*2+100,1000.0-150-60,
					317.0+425*2+100,1000.0-150-60,
					307.0+425*2+100,1000.0-150,
					243.0+425*2+100,1000.0-150);

			Polygon dokanup2 = new Polygon();
			dokanup2.setFill(Color.GREEN);
			dokanup2.setStroke(Color.BLACK);
			dokanup2.setStrokeWidth(2.0);
			dokanup2.getPoints().addAll(
					750.0-50,1000.0-75-60-20,
					750.0+50,1000.0-75-60-20,
					750.0+45,1000.0-75-60,
					750.0-45,1000.0-75-60);

			Polygon dokandown2 = new Polygon();
			dokandown2.setFill(Color.GREEN);
			dokandown2.setStroke(Color.BLACK);
			dokandown2.setStrokeWidth(2.0);
			dokandown2.getPoints().addAll(
					750.0-42,1000.0-75-60,
					750.0+42,1000.0-75-60,
					750.0+32,1000.0-75,
					750.0-32,1000.0-75);

			Polygon dokanup1 = new Polygon();
			dokanup1.setFill(Color.GREEN);
			dokanup1.setStroke(Color.BLACK);
			dokanup1.setStrokeWidth(2.0);
			dokanup1.getPoints().addAll(
					225.0,1000.0-150-60-20,
					325.0,1000.0-150-60-20,
					320.0,1000.0-150-60,
					230.0,1000.0-150-60);

			Polygon dokandown1 = new Polygon();
			dokandown1.setFill(Color.GREEN);
			dokandown1.setStroke(Color.BLACK);
			dokandown1.setStrokeWidth(2.0);
			dokandown1.getPoints().addAll(
					233.0,1000.0-150-60,
					317.0,1000.0-150-60,
					307.0,1000.0-150,
					243.0,1000.0-150);

			root.getChildren().add(dokanup7);
			root.getChildren().add(dokandown7);
			root.getChildren().add(dokanup8);
			root.getChildren().add(dokandown8);
			root.getChildren().add(dokanup9);
			root.getChildren().add(dokandown9);
			root.getChildren().add(dokanup4);
			root.getChildren().add(dokandown4);
			root.getChildren().add(dokanup6);
			root.getChildren().add(dokandown6);
			root.getChildren().add(dokanup1);
			root.getChildren().add(dokandown1);
			root.getChildren().add(dokanup2);
			root.getChildren().add(dokandown2);
			root.getChildren().add(dokanup3);
			root.getChildren().add(dokandown3);

        root.getChildren().addAll(calculation,result,grid, btnnum[0],btnnum[10],btnope[0]);

    	Scene scene = new Scene(root);
    	primaryStage.setScene(scene);

    	primaryStage.setTitle("課題 1116210001 阿部勝寿");
    	primaryStage.show();

    }

    private class Btnnum implements EventHandler<ActionEvent> {
  		@Override
  		public void handle(ActionEvent e) {

  			if(errorflag==1) return;

  			Button nowPressed = (Button) e.getSource();
  	        String btnnum = nowPressed.getText();

  	      consectiveopeflag=0;

			if(dotflag==0&&btnnum==".") dotflag++;

			else if(dotflag!=0&&btnnum==".") return;

				if(string.equals("0")||string.equals("-0")) {

					if(btnnum!=".") {

						if(string.equals("0")) {

							string=btnnum;
							calculation.setText(string);

						}

						else {

							string="-"+btnnum;
							calculation.setText(string);

						}
					}

					else {

						string = string+btnnum;
						calculation.setText(string);

					}
				}

				else {

				string = string+btnnum;
				calculation.setText(string);

			}

		if(btnnum!=".") {
				int num = Integer.parseInt(btnnum);

				if(0<num&&num<10&&num!=5) {

					switch(num) {

					case 1:subimage=imageView1;break;
					case 2:subimage=imageView2;break;
					case 3:subimage=imageView3;break;
					case 4:subimage=imageView4;break;
					case 6:subimage=imageView6;break;
					case 7:subimage=imageView7;break;
					case 8:subimage=imageView8;break;
					case 9:subimage=imageView9;break;

					}

					TranslateTransition tt = new TranslateTransition(Duration.millis(500), subimage);
					tt.setToY(-60);
					tt.setCycleCount(2);
					tt.setAutoReverse(true);
					tt.play();

					}

				if(num==5) {

					for(int i=1;i<10;i++) {

						if(i==5)continue;

						switch(i) {

						case 1:subimage=imageView1;break;
						case 2:subimage=imageView2;break;
						case 3:subimage=imageView3;break;
						case 4:subimage=imageView4;break;
						case 6:subimage=imageView6;break;
						case 7:subimage=imageView7;break;
						case 8:subimage=imageView8;break;
						case 9:subimage=imageView9;break;

							}

						TranslateTransition tt = new TranslateTransition(Duration.millis(500), subimage);
						tt.setToY(-100);
						tt.setCycleCount(2);
						tt.setAutoReverse(true);

						tt.play();}

				}
			}
  		}
    }

    private class Btnope implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {

			if(errorflag==1) return;

			try {

			Button nowPressed = (Button) e.getSource();
  	        String btnnum = nowPressed.getText();
  	        BigDecimal BDs3= new BigDecimal(string);
  	        int num=0;


  	        if(btnnum=="+"){

  	        	calculation.setText("+"); num=1;

  	        }
  	        	else if(btnnum=="-"){

  	        	calculation.setText("-"); num=2;

  	        }
  	        	else  if(btnnum=="×"){

  	        	calculation.setText("×"); num=3;

  	        }
  	        	else if(btnnum=="÷"){

  	        	calculation.setText("÷"); num=4;

  	        	}


	  	     if(consectiveopeflag==1) {

					opeflag=num;

					return;

				}

	  	     if(opeflag==0) firstopeflag=0;

	  	      if(firstopeflag==0) {

					iresult=BDs3;

					firstopeflag=1;

					result.setText(iresult.toString());
					string=("0");
					opeflag=num;
					consectiveopeflag=1;
					dotflag=0;

					return;

				}

			if(opeflag==1) {

				iresult=iresult.add(BDs3);

			}
				else if(opeflag==2) {

				iresult=iresult.subtract(BDs3);

			}
				else if(opeflag==3) {

				iresult=iresult.multiply(BDs3);

			}
				else if(opeflag==4) {

					try {

						iresult=iresult.divide(BDs3);

					}
					catch(java.lang.ArithmeticException error1){

						try {

								iresult=iresult.divide(BDs3, 10, BigDecimal.ROUND_HALF_UP);

						}catch(java.lang.ArithmeticException error2) {

								string="エラー：リセットしてください";
								calculation.setText(string);
								result.setText(string);
								errorflag++;

								return;

					}
				}
			}

			if(num==0) {

				calculation.setText("anser");

			};

			result.setText(iresult.toString());
			string=("0");
			opeflag=num;
			consectiveopeflag=1;
			dotflag=0;

			}catch(java.lang.NumberFormatException error3) {

					string="エラー：リセットしてください";
					calculation.setText(string);
					result.setText(string);
					errorflag++;

					return;

				}
			}
		}

    private class Btnother implements EventHandler<ActionEvent> {
  		@Override
  		public void handle(ActionEvent e) {

  			if(errorflag==1) return;

  			try {

  			Button nowPressed = (Button) e.getSource();
  	        String btnnum = nowPressed.getText();

  	        if(btnnum=="±"){

  	        	char ch=string.charAt(0);

  	        	if(ch=='-') {

  	        		string=string.substring(1);
  	        		calculation.setText(string);

  	        	}

  	        	else {

  	        		string="-"+string;
  	        		calculation.setText(string);

  	        	}
  	        }

  	        if(btnnum=="%"){

  	        		BigDecimal per= new BigDecimal(string);
  	        		BigDecimal on= new BigDecimal("100");
  	        		per=per.divide(on);
  	        		string=per.toString();
	        		calculation.setText(string);

  	        }


  		}catch(java.lang.NumberFormatException error) {

			string="エラー：リセットしてください";
			calculation.setText(string);
			result.setText(string);
			errorflag++;

			return;

  				}
  			}
    	}

    private class BtnAC implements EventHandler<ActionEvent> {
  		@Override
  		public void handle(ActionEvent e) {

	        	calculation.setText("0");
				result.setText("0");
				string=("0");
				iresult = new BigDecimal("0");
				firstopeflag=0;
				opeflag=5;
				dotflag=0;
				errorflag=0;

  			}
    	}
	}



