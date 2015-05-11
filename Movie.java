import java.io.*;
import sun.audio.*;

public class Movie{                                // character sprites 42 x 21 in

	public static void main(String[] args)  throws Exception {

//Play BG theme 

    // open the sound file as a Java input stream
    String gongFile = "/Users/Ramon/Desktop/Java Project Game/Zelda_Main_Theme_Song.wav";
    InputStream in = new FileInputStream(gongFile);
 
    // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);
 
    // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
  //BG Theme

    	//Play Game Over theme

    // open the sound file as a Java input stream
    String songFile = "/Users/Ramon/Desktop/Java Project Game/the_legend_of_zelda_NES_music_-_game_over_theme.wav";
    InputStream out = new FileInputStream(songFile);
 
    // create an audiostream from the inputstream
    AudioStream gameOver = new AudioStream(out);
 
    // play the audio clip with the audioplayer class

  //Game Over theme

    //Credit Song

    String credit = "/Users/Ramon/Desktop/Java Project Game/Legend_of_Zelda_Ocarina_of_Time-_Credits.wav";
    InputStream cr = new FileInputStream(credit);
    AudioStream credits = new AudioStream(cr);
    
  // credit song
	
		int count = 5;
		System.out.println("What is your name?");
		String playername = IO.readString();
		System.out.println();
		// Sprites
		Sprite player = new Sprite("PlayerStanding.png");
		player.setSize(100,100);
		player.setPosition(600,20);    //(x,y) (0,0) bottom left corner, (600,20) bottom right corner

		Sprite krispy = new Sprite("Krispy.png");
		krispy.setSize(75,75);
		krispy.setPosition(300,20);

		Sprite knight = new Sprite("KnightStanding.png");
		knight.setSize(100,110);
		knight.setPosition(0,20);

		Sprite guide = new Sprite("Guide.png");
		guide.setSize(100,100);
		guide.setPosition(315,115);

		Sprite bonkers = new Sprite("Bonkers.gif");
		bonkers.setSize(50,50);
		bonkers.setPosition(500,60);

		Sprite bowser = new Sprite("bowserRight.gif");
		bowser.setSize(100,100);
		bowser.setPosition(500,130);


		// Background Opening
		Animation movie = new Animation(720,480);
		movie.setFrameRate (8);
		movie.setBackgroundImage ("Opening.png");


		//Frame 1, initial status
		movie.addSprite(player);
		movie.addSprite(krispy);
		movie.frameFinished();


		//Player Inputs

		System.out.println("Type in 'left' to move left, 'right' to move right");

		//Test Frames, player walking to Rice Krispies -- WORKS!
		//Frames 2-9 Player walkings towards Rice Krispies

		int counters = 1;
		
		do{ 
			System.out.println();
			System.out.println("Where do you want to move? " + playername);
			 String movement = IO.readString().toLowerCase();

			if(movement.equals("left")){
				for(int i = player.getXposition(); i >=krispy.getXposition(); i-=10){

					player.setPosition(i,20);
					counters = move(counters, movie, player);
					player.getXposition();
					movie.frameFinished();

					if(player.getXposition() == 450){
						movie.addSprite(knight);
						knight.setImage("KnightWalking1.png");
						knight.setPosition(50,20);
						movie.frameFinished();
					}
					if(player.getXposition() == 400){
						knight.setImage("KnightWalking2.png");
						knight.setPosition(100,20);
						movie.frameFinished();

						knight.setImage("KnightWalking3.png");
						knight.setPosition(150,20);
						movie.frameFinished();

						knight.setImage("KnightWalking4.png");
						knight.setPosition(200,20);
						movie.frameFinished();

						knight.setImage("KnightWalking5.png");
						knight.setPosition(225,20);
						movie.frameFinished();

						knight.setImage("KnightWalking6.png");
						knight.setPosition(250,20);
						movie.frameFinished();

						knight.setImage("KnightWalking7.png");
						knight.setPosition(260,20);
						movie.frameFinished();

						knight.setImage("KnightWalkingFinal.png");
						knight.setPosition(270,20);
						movie.frameFinished();

					}
				}
			} else if(movement.equals("right")){
				for(int i = player.getXposition(); i < 670; i+=10){
					player.setPosition(i,20);
					player.getXposition();
					movie.frameFinished();

				}
			} else {
				System.out.println("Only 'left' and 'right' commands are accepted here :)");

			}
		} while(player.getXposition() != krispy.getXposition());

		//Frame 18 knight takes out weapon
		knight.setImage("KnightWeapon.png");
		movie.frameFinished();

		//Frame 19 -20 Knight takes out player
		player.setImage("PlayerDown.png");		
		movie.frameFinished();

		movie.removeSprite(player);
		movie.frameFinished();

		//Frame 21 BG goes black
		movie.removeSprite(knight);
		movie.removeSprite(krispy);
		movie.setBackgroundImage("BlackBG.png");
		movie.frameFinished();

		//Frame 22 - 23 Time Skip
		movie.setBackgroundImage("DaysLater.png");
		movie.frameFinished();
		movie.setBackgroundImage("DaysLater.png");
		movie.frameFinished();

		//Frame 24 - Aweakening 
		
		movie.setBackgroundImage("Ocarina Of TimeSword.png");
		movie.addSprite(guide);
		player.setImage("PlayerStanding.png");
		player.setPosition(400,120);
		movie.addSprite(player);
		movie.frameFinished();

		//Frame 25 - 29 player walks up to the sword
		player.setImage("PlayerStanding.png");
		movie.frameFinished();

		player.setImage("PlayerForward.png");
		guide.setImage("PlayerGuideForward.png");
		player.setPosition(390,130);
		movie.frameFinished();

		player.setImage("PlayerForward1.png");
		player.setPosition(380,140);
		movie.frameFinished();

		player.setImage("PlayerForward2.png");
		player.setPosition(370,150);
		movie.frameFinished();

		player.setImage("PlayerForward3.png");
		player.setPosition(360,160);
		movie.frameFinished();

		player.setImage("PlayerForward4.png");
		player.setPosition(350,170);
		movie.frameFinished();

		//Frame 30 player picks up sword
		movie.setBackgroundImage("Ocarina of Time.png");
		player.setImage("PlayerForwardWeapon.png");
		movie.frameFinished();

		//Frame 31 -43 Leaves the Guide's home
		player.setImage("PlayerWeapon.png");
		movie.frameFinished();

		player.setImage("PlayerWalkingForward1.png");
		player.setPosition(360,160);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward2.png");
		player.setPosition(370,150);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward3.png");
		player.setPosition(380,140);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward4.png");
		player.setPosition(390,130);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward5.png");
		player.setPosition(400,125);
		guide.setImage("Guide.png");
		movie.frameFinished();

		System.out.println("Guide: Welcome " + playername+"!");

		for(int wait = 0; wait < 10; wait++){
		movie.frameFinished();
	}
		System.out.println("Guide: As you may noticed this game is played with the console.");

		for(int wait = 0; wait < 10; wait++){
		movie.frameFinished();
	}
		System.out.println("Guide: Each section the game allows its own commands.");
		System.out.println();

		for(int wait = 0; wait < 10; wait++){
		movie.frameFinished();
	}
		for(int talkcount = 0; talkcount < 20; talkcount+=2){
			player.setImage("PlayerStanding.png");
			movie.frameFinished();
		}

		player.setImage("PlayerWalkingForward6.png");
		player.setPosition(410,115);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward7.png");
		player.setPosition(420,105);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward8.png");
		player.setPosition(450,95);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward9.png");
		player.setPosition(500,85);
		movie.frameFinished();

		player.setImage("PlayerWalkingForward10.png");
		player.setPosition(550,65);
		movie.frameFinished();
		movie.removeSprite(guide);
		movie.removeSprite(player);

		

		//Frame 45 - Player is outside and heading towards the knight
		movie.setBackgroundImage("SuperMarioWorldMapBG.png");
		movie.addSprite(bonkers);
		movie.addSprite(player);
		movie.frameFinished();

		movie.removeSprite(player);
		
		for(int i=500;i>399;i-=10){
			bonkers.setPosition(i,60);
			movie.frameFinished();
		}

		

		//Journey Scene
		movie.addSprite(player);
		player.setImage("PlayerSideWeaponRight.png");
		player.setPosition(10,50);
		movie.frameFinished();

		System.out.println("Only 'right' accepted");

		do{

			System.out.println("Where do you want to go?");
			String movement = IO.readString().toLowerCase();
			
			if(movement.equals("right")){
				for(int j = player.getXposition(); j <= 200; j+=5){
				player.setPosition(j,50);
				player.getXposition();
				movie.frameFinished();

				}
			} else {
				System.out.println("Only 'right' here. It's a linear game :)");
			}
		} while(player.getXposition() != 200);

		System.out.println();
		System.out.println("'left', 'right', 'up' and ('down' after certain conditions are met) accepted");
		System.out.println();

		do{
			System.out.println("Where do you want to go?");
			String movement = IO.readString().toLowerCase();
			
			if(movement.equals("right")){
				player.setImage("PlayerSideWeaponRight.png");
				for(int j = player.getXposition(); j <= 380; j+=10){
				player.setPosition(j,player.getYposition());
				player.getXposition();
				movie.frameFinished();
				}
			} else if(movement.equals("left") && player.getYposition() == 50) {
				player.setImage("PlayerSideWeapon.png");
				for(int movLeft = player.getXposition(); movLeft >= 10; movLeft -= 10){
					player.setPosition(movLeft, 50);
					player.getXposition();
					movie.frameFinished();
				}
			}else if(movement.equals("up")){
					player.setImage("PlayerSideWeaponRight.png");
					for(int p = 50; p <= 120; p+=35){
							player.setPosition(player.getXposition(),p);
							player.getYposition();
							movie.frameFinished();
					}

				} else if(movement.equals("down") && player.getYposition() ==  120){
					for(int movDown = 120; movDown >= 50; movDown -= 35){
						player.setPosition(player.getXposition(), movDown);
						player.getYposition();
						player.getXposition();
						movie.frameFinished();
					}
				}else {
					System.out.println("Invalid Input; refer back to the instructions :)");
				}

		} while(player.getXposition() != 380 && player.getYposition() != 120);

		do {
			System.out.println("Where do you want to go?");
			String movement = IO.readString().toLowerCase();

			if(movement.equals("right") && player.getYposition() == 120 && player.getXposition() == 380){
				player.setImage("PlayerSideWeaponRight.png");
				for(int j = player.getXposition(); j <= 410; j+=10){
				player.setPosition(j,120);
				player.getXposition();
				player.getYposition();
				movie.frameFinished();
				}
			} else if(movement.equals("right") && player.getXposition() == 380  && player.getXposition() <=400 && player.getYposition() == 50 ){
				for(int deadplayer = player.getXposition(); deadplayer <= 400; deadplayer+=2){
					player.setPosition(deadplayer,50);
					movie.frameFinished();
				}
			}else if(movement.equals("right") && player.getXposition() >= 410 &&player.getYposition() == 50){
				player.setImage("PlayerSideWeaponRight.png");
				for(int movRight = player.getXposition(); movRight <= 530; movRight+=20){
					player.setPosition(movRight,50);
					player.getXposition();
					movie.frameFinished();
				}
			}else if(movement.equals("right") && player.getYposition() == 120 && player.getXposition() == 530){
				for(int movHill = 530; movHill <= 610; movHill+=5){
					player.setPosition(movHill, 120);
					player.getXposition();
					movie.frameFinished();
				}
			}else if(movement.equals("right") && player.getXposition() > 600){
				for(int endScene = 610; endScene <= 725; endScene+=5){
					player.setPosition(endScene, 50);
					movie.frameFinished();
				}
			}else if(movement.equals("left") && player.getYposition() == 50 && player.getXposition() <=530) {
				player.setImage("PlayerSideWeapon.png");
				for(int movLeft = player.getXposition(); movLeft >= 400; movLeft -= 10){
					player.setPosition(movLeft, 50);
					player.getXposition();
					movie.frameFinished();
				}
			}else if(movement.equals("up") && player.getYposition() != 120){
					player.setImage("PlayerSideWeaponRight.png");
					for(int p = 50; p <= 120; p+=35){
							player.setPosition(player.getXposition(),p);
							player.getYposition();
							movie.frameFinished();
					}

				} else if(movement.equals("down") && player.getYposition() ==  120){
					for(int movDown = 120; movDown >= 50; movDown -= 35){
						player.setPosition(player.getXposition(), movDown);
						player.getYposition();
						player.getXposition();
						movie.frameFinished();
					}
				}else {
					System.out.println("Invalid Input; refer back to the instructions :)");
				}

		int bpos = bonkers.getXposition();
		int ppos = player.getXposition();

		if(bpos == ppos){
			System.out.println("Two sprites overlapping = one of them dying");
			System.out.println("You Lose :|"); //ಠ_ಠ
			System.out.println("Please close the game and run it again.");
			movie.removeSprite(player);
			movie.removeSprite(bonkers);
			AudioPlayer.player.stop(audioStream);
			AudioPlayer.player.start(gameOver);
			movie.setBackgroundImage("GameOver.png");
			movie.frameFinished();
			return; //Game Ends
		}

	}while(player.getXposition() != 725);

		movie.removeSprite(bonkers);
		movie.removeSprite(player);
		movie.frameFinished();
		

		//Journey Scene finished

		System.out.println("Boss Fight");

		movie.setBackgroundImage("BossFight.jpg");
		krispy.setPosition(620,110);
		movie.addSprite(krispy);
		knight.setImage("KnightLeft.png");
		knight.setPosition(610,110);
		movie.addSprite(knight);
		movie.addSprite(bowser);
		movie.frameFinished();

		player.setPosition(10,110);
		movie.addSprite(player);
		movie.frameFinished();

		for(int counter = 0; counter < 50; counter+=5){ //timer
			movie.frameFinished();
		}

		//bowser turns around
		bowser.setImage("bowser.gif");
		knight.setPosition(600,110);
		movie.frameFinished();

		//bowser moves up
		 int bowPos = bowser.getXposition();
		for(int m = bowPos; m > 300; m-=60){
			bowser.setPosition(m,130);
			movie.frameFinished();
		}
		//player moves up
		for(int n = 10; n < 101; n+=30){
			player.setPosition(n,110);
			movie.frameFinished();
		}


		for (int z = 100; z < 305; z+=80){
			player.setPosition(z,110); //player charges at bowser
			bowser.setPosition(300,400); //bowser jumps up
			movie.frameFinished();
		}

		for(int c = 150; c > 129; c-=50){
			bowser.setPosition(300,c);
			player.setPosition(200,110);
			movie.frameFinished();
		}
		//Make Interactive
		
		System.out.println("Move up? Yes or No");
		String movement = IO.readString().toLowerCase();

		while(movement.equals("yes") || movement.equals("no")){

		if(movement.equals("yes")){

			for(int v = 200; v <= 300; v+=10){
			player.setPosition(v,110);
			player.getXposition();
			movie.frameFinished();
			}break;
		}else if(movement.equals("no")){
			player.setPosition(150, 110);
			movie.frameFinished();
			break;
		}else {
			System.out.println("Not a valid response. Please try again -_-");
			movement = IO.readString().toLowerCase();
		}
	}
	

		if(player.getXposition() == bowser.getXposition()){
			movie.removeSprite(bowser);
			knight.setPosition(500,110);
			movie.frameFinished();
		} else {//you lose
			movie.removeSprite(player);
			movie.removeSprite(bowser);
			movie.removeSprite(knight);
			movie.removeSprite(krispy);
			movie.setBackgroundImage("GameOver.png");
			System.out.println("Really "+ playername +"!?!?");
			System.out.println("You lose. Bowser got you :[ ");
			System.out.println("Please close the game and open it up again.");
			AudioPlayer.player.stop(audioStream);
			AudioPlayer.player.start(gameOver);
			movie.frameFinished();
			return; //Game Ends
		}
		//End of Interactivity
		int playpos = player.getXposition();
		int knightpos = knight.getXposition();
		for(int b = playpos; b < knightpos; b+=30){ //must move up by ones
			player.setPosition(b,120);
			movie.frameFinished();
		}

		player.setImage("PlayerSwing.png");
		knight.setImage("Knightdown.png");
		movie.frameFinished();

		player.setImage("PlayerSideWeaponRight.png");
		movie.frameFinished();

		for(int s = 500; s < 620; s+=20) {
			player.setPosition(s,120);
			movie.frameFinished();
		}

		for(int timecount = 0; timecount < 20; timecount+=2){
			movie.frameFinished();
		}
		AudioPlayer.player.stop(audioStream);
		AudioPlayer.player.start(credits);
		//Guide comes out congratulates player
		player.setImage("PlayerStanding.png");
		guide.setPosition(-10,120);
		movie.addSprite(guide);
		movie.frameFinished();

		for(int q = -10; q < 540; q+=30){
			guide.setPosition(q,120);
			movie.frameFinished();
		}

		for(int timecount = 0; timecount < 50; timecount+=10){
			movie.frameFinished();
		}
		System.out.println("Guide: Good Job " + playername +"!");

		for(int wait = 0; wait < 15; wait++){
		movie.frameFinished();
	}
		System.out.println("Guide: You recovered your rice krispies from than evil knight.");

		for(int wait = 0; wait < 15; wait++){
		movie.frameFinished();
	}
		System.out.println("Guide: The world is a better place now thanks to you 0_0 "); //(ʘ‿ʘ)

		for(int wait = 0; wait < 15; wait++){
		movie.frameFinished();
	}
		System.out.println(playername + ", Thanks For Playing!");

		for(int wait = 0; wait < 15; wait++){
		movie.frameFinished();
	}

	System.out.println("You can exit out or just enjoy the music!");

		for(int remove = 0; remove < 25; remove++){
			movie.removeSprite(guide);
			movie.removeSprite(player);
			movie.removeSprite(krispy);
			movie.frameFinished();
		}

		//Game Finished
		for(int end = 0; end < 20; end++){
			movie.setBackgroundImage("Credits.png");
			movie.frameFinished();
		}

		movie.setBackgroundImage("fin.png");
		movie.frameFinished();
	}
	//allows simultaneous animation and movement for player character
	public static int move(int counters, Animation movie, Sprite player){ 
			if(counters == 1){
				player.setImage("Walking1.png");
				movie.frameFinished();
				counters++;
			}else if(counters == 2){
				player.setImage("Walking2.png");
				movie.frameFinished();
				counters++;
			} else if(counters == 3){
				player.setImage("Walking3.png");
				movie.frameFinished();
				counters++;
			} else if(counters == 4){
				player.setImage("Walking4.png");
				movie.frameFinished();
				counters++;
			} else if(counters == 5){
				player.setImage("Walking5.png");
				movie.frameFinished();
				counters++;
			} else if(counters == 6){
				player.setImage("Walking6.png");
				movie.frameFinished();
				counters++;
			}else if(counters == 7){
				player.setImage("Walking7.png");
				movie.frameFinished();
				counters++;
			}else if(counters == 8){
				player.setImage("WalkingFinal.png");
				movie.frameFinished();
				counters = 1;
			} return counters;
		}
}