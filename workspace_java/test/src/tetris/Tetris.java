package tetris;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.image.*;
import sun.audio.*;
import java.io.*;
public class Tetris extends Frame implements KeyListener,Runnable{
	String type[]={"longtype","lefttype","righttype","nemotype","ttype","leftcas","rightcas"};
	Color colType[]={new Color(255,35,31),new Color(224,134,4),new Color(246,118,57)
			,new Color(65,228,82),new Color(58,98,235),new Color(68,17,111),new Color(128,0,64)};
	String nowType,nextType;
	Random ran = new Random();
	Image bground;
	long score;
	int isEnd,r;
	int okLineNum;
	int okLine[] = new int[4];
	int ok[] = new int[21];
	boolean droped,bottom,isBegin=true;
	boolean lBlocked,rBlocked,tBlocked;
	int bx[][] = new int[12][21];
	int by[][] = new int[12][21];
	Color gridColor = new Color(190,190,190);
	Color bcol[][] = new Color[12][21];
	int bis[][] = new int[12][21];
	int nowX[] = new int[4];
	int nowY[] = new int[4];
	Color nowCol,nextCol;
	int tempX[] ={0,0,0,0},tempY[]={0,0,0,0};
	int angle=0,degree=0;
	int delay_init=300,delay;
	Image img,icon;
	Graphics bg;
	Thread t;
	public void nextType(){
		r = ran.nextInt(7);
		nextType = type[r];
		r = ran.nextInt(7);
		nextCol = colType[r];
	}
	public String newType(){
		if(isBegin){
			nowType=type[ran.nextInt(7)];
			nowCol=colType[ran.nextInt(7)];
			isBegin=false;
		}else{
			nowType = nextType; 
			nowCol = nextCol;
		}
		degree = 0;
		delay=delay_init;
		nextType();
		return nowType;
	}
	public void typeIs(String s){
		if (s=="longtype"){
			nowX[0]=65;nowX[1]=80;nowX[2]=95;nowX[3]=110;
			nowY[0]=90;nowY[1]=90;nowY[2]=90;nowY[3]=90;
		}else if(s=="nemotype"){
			nowX[0]=80;nowX[1]=95;nowX[2]=80;nowX[3]=95;
			nowY[0]=75;nowY[1]=75;nowY[2]=90;nowY[3]=90;
		}else if(s=="ttype"){
			nowX[0]=95;nowX[1]=80;nowX[2]=95;nowX[3]=110;
			nowY[0]=75;nowY[1]=90;nowY[2]=90;nowY[3]=90;
		}else if(s=="lefttype"){
			nowX[0]=80;nowX[1]=80;nowX[2]=95;nowX[3]=110;
			nowY[0]=75;nowY[1]=90;nowY[2]=90;nowY[3]=90;
		}else if(s=="righttype"){
			nowX[0]=110;nowX[1]=95;nowX[2]=80;nowX[3]=110;
			nowY[0]=75;nowY[1]=90;nowY[2]=90;nowY[3]=90;
		}else if(s=="leftcas"){
			nowX[0]=80;nowX[1]=80;nowX[2]=95;nowX[3]=95;
			nowY[0]=75;nowY[1]=90;nowY[2]=90;nowY[3]=105;
		}else if(s=="rightcas"){
			nowX[0]=95;nowX[1]=95;nowX[2]=80;nowX[3]=80;
			nowY[0]=75;nowY[1]=90;nowY[2]=90;nowY[3]=105;
		}
	}

	public void initArray(){
		for(int i=0;i<12;i++){
			for(int j=0;j<21;j++){
				bx[i][j] = 5+i*15;
				by[i][j] = 75+j*15;
			}
		}
	}
	public Tetris(){
		icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
		bground = Toolkit.getDefaultToolkit().getImage("back.jpg");
		setIconImage(icon);
		setTitle("테트리스");
		setLocation(300,100);
		setSize(190,400);
		setVisible(true);
		addKeyListener(this);
		addWindowListener(new Exit());
		initArray();
		typeIs(newType());
		playSound("start.wav");
		t=new Thread(this);
		t.start();
	}

	public void turn_longtype(){
		if(angle==0 || angle==2){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0]+15;
			tempX[2]=nowX[0]+30;
			tempX[3]=nowX[0]+45;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0];
			tempY[2]=nowY[0];
			tempY[3]=nowY[0];
		}else if(angle==1 || angle==3){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0];
			tempX[2]=nowX[0];
			tempX[3]=nowX[0];
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]+15;
			tempY[2]=nowY[0]+30;
			tempY[3]=nowY[0]+45;
		}
		doTurn();
	}
	public void turn_nemotype(){
		tempX[0]=nowX[0];
		tempX[1]=nowX[1];
		tempX[2]=nowX[2];
		tempX[3]=nowX[3];
		tempY[0]=nowY[0];
		tempY[1]=nowY[1];
		tempY[2]=nowY[2];
		tempY[3]=nowY[3];
		doTurn();
	}
	public void turn_ttype(){
		if(angle==0){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0]-15;
			tempX[2]=nowX[0];
			tempX[3]=nowX[0]+15;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]+15;
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0]+15;
		}else if(angle==1){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0]-15;
			tempX[2]=nowX[0]-15;
			tempX[3]=nowX[0]-15;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]-15;
			tempY[2]=nowY[0];
			tempY[3]=nowY[0]+15;
		}else if(angle==2){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0]-15;
			tempX[2]=nowX[0];
			tempX[3]=nowX[0]+15;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]-15;
			tempY[2]=nowY[0]-15;
			tempY[3]=nowY[0]-15;
		}else if(angle==3){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0]+15;
			tempX[2]=nowX[0]+15;
			tempX[3]=nowX[0]+15;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]-15;
			tempY[2]=nowY[0];
			tempY[3]=nowY[0]+15;
		}
		doTurn();
	}
	public void turn_lefttype(){
		if(angle==0){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0];
			tempX[2]=nowX[0]+15;
			tempX[3]=nowX[0]+30;
			tempY[0]=nowY[0]-30;
			tempY[1]=nowY[0]-15;
			tempY[2]=nowY[0]-15;
			tempY[3]=nowY[0]-15;
		}else if(angle==1){
			tempX[0]=nowX[0]+30;
			tempX[1]=nowX[0]+15;
			tempX[2]=nowX[0]+15;
			tempX[3]=nowX[0]+15;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0];
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0]+30;
		}else if(angle==2){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0];
			tempX[2]=nowX[0]-15;
			tempX[3]=nowX[0]-30;
			tempY[0]=nowY[0]+15;
			tempY[1]=nowY[0];
			tempY[2]=nowY[0];
			tempY[3]=nowY[0];
		}else if(angle==3){
			tempX[0]=nowX[0]-30;
			tempX[1]=nowX[0]-15;
			tempX[2]=nowX[0]-15;
			tempX[3]=nowX[0]-15;
			tempY[0]=nowY[0]+15;
			tempY[1]=nowY[0]+15;
			tempY[2]=nowY[0];
			tempY[3]=nowY[0]-15;
		}
		doTurn();
	}
	public void turn_righttype(){
		if(angle==0){
			tempX[0]=nowX[0]+30;
			tempX[1]=nowX[0]+30;
			tempX[2]=nowX[0]+15;
			tempX[3]=nowX[0];
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]+15;
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0]+15;
		}else if(angle==1){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0]-15;
			tempX[2]=nowX[0]-15;
			tempX[3]=nowX[0]-15;
			tempY[0]=nowY[0]+30;
			tempY[1]=nowY[0]+30;
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0];
		}else if(angle==2){
			tempX[0]=nowX[0]-30;
			tempX[1]=nowX[0]-30;
			tempX[2]=nowX[0]-15;
			tempX[3]=nowX[0]-0;
			tempY[0]=nowY[0]-15;
			tempY[1]=nowY[0]-30;
			tempY[2]=nowY[0]-30;
			tempY[3]=nowY[0]-30;
		}else if(angle==3){
			tempX[0]=nowX[0];
			tempX[1]=nowX[0]+15;
			tempX[2]=nowX[0]+15;
			tempX[3]=nowX[0]+15;
			tempY[0]=nowY[0]-15;
			tempY[1]=nowY[0]-15;
			tempY[2]=nowY[0];
			tempY[3]=nowY[0]+15;
		}
		doTurn();
	}
	public void turn_leftcas(){
		if(angle==0 || angle==2){
			tempX[0]=nowX[0]-15;
			tempX[1]=nowX[0]-15;
			tempX[2]=nowX[0];
			tempX[3]=nowX[0];
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]+15;
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0]+30;
		}else if(angle==1 || angle==3){
			tempX[0]=nowX[0]+15;
			tempX[1]=nowX[0];
			tempX[2]=nowX[0];
			tempX[3]=nowX[0]-15;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0];
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0]+15;
		}
		doTurn();
	}
	public void turn_rightcas(){
		if(angle==0 || angle==2){
			tempX[0]=nowX[0]+15;
			tempX[1]=nowX[0]+15;
			tempX[2]=nowX[0];
			tempX[3]=nowX[0];
			tempY[0]=nowY[0];
			tempY[1]=nowY[0]+15;
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0]+30;
		}else if(angle==1 || angle==3){
			tempX[0]=nowX[0]-15;
			tempX[1]=nowX[0];
			tempX[2]=nowX[0];
			tempX[3]=nowX[0]+15;
			tempY[0]=nowY[0];
			tempY[1]=nowY[0];
			tempY[2]=nowY[0]+15;
			tempY[3]=nowY[0]+15;
		}
		doTurn();
	}
	public void doTurn(){
		if(checkTurn()){
			nowX[0]=tempX[0];
			nowX[1]=tempX[1];
			nowX[2]=tempX[2];
			nowX[3]=tempX[3];
			nowY[0]=tempY[0];
			nowY[1]=tempY[1];
			nowY[2]=tempY[2];
			nowY[3]=tempY[3];
		}
		else{
			degree--;
		}
	}
	public void turn(){ 
		if(nowType=="longtype"){
			turn_longtype();
		}else if(nowType=="nemotype"){
			turn_nemotype(); 
		}else if(nowType=="ttype"){
			turn_ttype(); 
		}else if(nowType=="lefttype"){
			turn_lefttype();
		}else if(nowType=="righttype"){
			turn_righttype();
		}else if(nowType=="leftcas"){
			turn_leftcas();
		}else if(nowType=="rightcas"){
			turn_rightcas();
		}
	}
	public boolean checkTurn(){
		tBlocked = false;
		if( tempX[0]<5 || tempX[0]>170 || 
				tempX[1]<5 || tempX[1]>170 || 
				tempX[2]<5 || tempX[2]>170 || 
				tempX[3]<5 || tempX[3]>170 ){ 
			return false;
		}else if(tempY[0]>385 || tempY[1]>385 || tempY[2]>385 || tempY[3]>385){
			return false;
		}
		else{
			for(int i=0;i<4;i++){
				if(bis[(tempX[i]-5)/15][(tempY[i]-75)/15]==1){
					tBlocked = true;
					break;
				}
			}
		}
		if(tBlocked){
			return false;
		}else{
			return true;
		}
	}
	public void drawBlock(Graphics g){
		for(int i=0;i<12;i++){
			for(int j=0;j<21;j++){
				if(bis[i][j]==1){
					g.setColor(bcol[i][j]);
					g.fillRect(bx[i][j],by[i][j],15,15);
				}
			}
		}
	}
	public void lineDel(){
		if(isOk()){
			delay_init -= 20;
			if(delay_init <100){
				delay_init = 100;
			}
			for(int k=0;k<4;k++){
				if(okLine[k]!=0){
					for(int j=okLine[k];j>0;j--){
						for(int i=0;i<12;i++){
							bis[i][j] = bis[i][j-1];
							bcol[i][j] = bcol[i][j-1];
						}
					}
				}
			}
		}
	}
	public void dropThen(){
		for(int i=0;i<4;i++){
			bcol[(nowX[i]-5)/15][(nowY[i]-75)/15]=nowCol;
			bis[(nowX[i]-5)/15][(nowY[i]-75)/15]=1;
		}
		if(okLineNum==1){
			score+=100;
		}else if(okLineNum==2){
			score+=300;
		}else if(okLineNum==3){
			score+=600;
		}else if(okLineNum==4){
			score+=1000;
		}
		lineDel();
		droped = false;
		bottom = false;
		playSound("drop.wav");
		for(int i=0;i<12;i++){
			isEnd+=bis[i][1];
		}
		if(isEnd>0){
			playSound("clap.wav");
			repaint();
		}else{
			typeIs(newType());
		}
	}
	public void drawEnd(Graphics g){
		g.setColor(Color.white);
		g.fillRect(51,121,90,60);
		Font f = new Font("Verdana",Font.BOLD,12); 
		g.setFont(f);

		g.setColor(Color.red);
		g.drawString(String.valueOf(score),80,145);
		g.setColor(Color.blue);
		g.drawString("Point",80,165);
	}
	public boolean isOk(){
		okLineNum = 0;
		for(int i=0;i<4;i++){
			okLine[i]=0;
		}
		int k=0;
		for(int j=0;j<21;j++){
			ok[j]=0;
			for(int i=0;i<12;i++){
				ok[j] += bis[i][j];
			}
			if(ok[j]==12){
				okLineNum ++;
				okLine[k] = j;
				k++;
			}  
		}
		if (okLineNum>0){
			playSound("ok.wav");
			return true;
		}else{ 
			return false;
		}
	}
	public boolean isDrop(){
		if(nowY[0]>370 || nowY[1]>370 || nowY[2]>370 || nowY[3]>370){
			bottom=true;
		}else{
			for(int i=0;i<4;i++){
				if(bis[(nowX[i]-5)/15][(nowY[i]-60)/15]==1){
					droped = true;
					break;
				}
			}
		}
		if(droped || bottom){
			dropThen();
			return true;
		}else{
			return false;
		}
	}
	public void drawNext(Graphics g){
		g.setColor(nextCol); 
		if(nextType=="longtype"){
			int x=110,y=45;
			g.fillRect(x,y,15,15);
			g.fillRect(x+15,y,15,15);
			g.fillRect(x+30,y,15,15);
			g.fillRect(x+45,y,15,15);
		}else if(nextType=="nemotype"){
			int x=140,y=30;
			g.fillRect(x,y,15,15);
			g.fillRect(x+15,y,15,15);
			g.fillRect(x,y+15,15,15);
			g.fillRect(x+15,y+15,15,15);
		}else if(nextType=="ttype"){
			int x=140,y=30;
			g.fillRect(x,y,15,15);
			g.fillRect(x-15,y+15,15,15);
			g.fillRect(x,y+15,15,15);
			g.fillRect(x+15,y+15,15,15);
		}else if(nextType=="lefttype"){
			int x=125,y=30;
			g.fillRect(x,y,15,15);
			g.fillRect(x,y+15,15,15);
			g.fillRect(x+15,y+15,15,15);
			g.fillRect(x+30,y+15,15,15);
		}else if(nextType=="righttype"){
			int x=155,y=30;
			g.fillRect(x,y,15,15);
			g.fillRect(x,y+15,15,15);
			g.fillRect(x-15,y+15,15,15);
			g.fillRect(x-30,y+15,15,15);
		}else if(nextType=="leftcas"){
			int x=140,y=30;
			g.fillRect(x,y,15,15);
			g.fillRect(x,y+15,15,15);
			g.fillRect(x+15,y+15,15,15);
			g.fillRect(x+15,y+30,15,15);
		}else if(nextType=="rightcas"){
			int x=155,y=30;
			g.fillRect(x,y,15,15);
			g.fillRect(x,y+15,15,15);
			g.fillRect(x-15,y+15,15,15);
			g.fillRect(x-15,y+30,15,15);
		}
	}
	public void drawMove(Graphics g){
		for(int i=0;i<4;i++){
			g.setColor(nowCol);
			g.fillRect(nowX[i],nowY[i],15,15);
		}
		g.setColor(gridColor);
		for(int i=5;i<185;i=i+15){
			for(int j=75;j<390;j=j+15){
				g.drawRect(i,j,15,15);
			}
		}
	}

	public void draw(Graphics g){
		img = createImage(getWidth(), getHeight());
		bg = img.getGraphics();
		Dimension d = getSize();
		bg.setColor(getBackground());
		bg.fillRect(0,0,d.width,d.height);
		bg.drawImage(bground,10,10,this);
		drawBlock(bg);  
		drawMove(bg);
		drawNext(bg);
		if(isEnd>0){
			drawEnd(bg);
		}
	}
	public void update(Graphics g){
		draw(bg);
		g.drawImage(img,0,0,this);
	}
	public void paint(Graphics g){
		update(g);
	}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==27){    //Escape
			System.exit(0);
		}
		if(e.getKeyCode()==37){ //Left
			if(checkLeft()){
				nowX[0]=nowX[0]-15;
				nowX[1]=nowX[1]-15;
				nowX[2]=nowX[2]-15;
				nowX[3]=nowX[3]-15;
			}
		}
		if(e.getKeyCode()==39){  //Right
			if(checkRight()){
				nowX[0]=nowX[0]+15;
				nowX[1]=nowX[1]+15;
				nowX[2]=nowX[2]+15;
				nowX[3]=nowX[3]+15;
			}
		}
		if(e.getKeyCode()==38){   //Up
			degree = degree+1;
			angle = degree%4;
			turn();
		}  
		if(e.getKeyCode()==40){   //Down
			t.yield();
			delay=0;
		}
		if(e.getKeyCode()==32){   //Space Bar
			t.yield();
			delay=0;
		}
		repaint();
	}
	public void keyReleased(KeyEvent e){}
	public void run(){
		while(isEnd==0){
			try{
				t.sleep(delay);
			}catch(Exception ex){}
			tBlocked = false;
			rBlocked = false;
			lBlocked = false;
			if(!isDrop()){
				nowY[0]=nowY[0]+15;
				nowY[1]=nowY[1]+15;
				nowY[2]=nowY[2]+15;
				nowY[3]=nowY[3]+15;
				repaint();
			}
		}
	}
	public boolean checkLeft(){
		rBlocked = false;
		if(nowX[0]==5 || nowX[1]==5 || nowX[2]==5 || nowX[3]==5){
			return false;
		}else{
			for(int i=0;i<4;i++){
				if(bis[(nowX[i]-20)/15][(nowY[i]-75)/15]==1){
					lBlocked = true;
					break;
				}
			}
		}
		if(lBlocked){
			return false;
		}else{
			return true;
		}
	}

	public boolean checkRight(){
		lBlocked = false;
		if( nowX[0]==170 || nowX[1]==170 || nowX[2]==170 || nowX[3]==170){ 
			return false;
		}else{
			for(int i=0;i<4;i++){
				if(bis[(nowX[i]+10)/15][(nowY[i]-75)/15]==1){
					rBlocked = true;
					break;
				}
			}
		}
		if(rBlocked){
			return false;
		}else{
			return true;
		}
	}
	public void playSound(String fileName){
		try {
			File theFile = new File(fileName);
			FileInputStream fis = new FileInputStream(theFile); 
//			AudioStream as = new AudioStream(fis);
//			AudioPlayer.player.start(as); 
		}catch(Exception ex){}
	} 
	public static void main(String args[]){
		Tetris ts = new Tetris();
	}
	class Exit extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}