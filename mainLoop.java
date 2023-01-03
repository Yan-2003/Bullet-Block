import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.*;

public class mainLoop extends JPanel implements Runnable{
    
    int FPS = 60;

    public final int width = 500;
    public final int height = 500;
    public boolean isGame = false;
    public boolean Start = false;
    public boolean Exit = false;
    public int score = 0;

    Thread game;
    keyH controll = new keyH(this);
    player me = new player(this, controll);
    enemy block = new enemy(this);
    titleScreen title = new titleScreen(this, controll);
    
    mainLoop(){
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0,0,0));
        this.setDoubleBuffered(true);
        this.addKeyListener(controll);
        this.setFocusable(true);
    }

    public void start(){
        me.setPlayer();
        block.enemy_position();
        score = 0;
        isGame = false;
        game = new Thread(this);
        game.start();
        controll.gameTry = false;
    }

    public void run() {
        
        double darwInt = 1000000000/FPS;
        double nextdraw = System.nanoTime() + darwInt;

            while(game != null){


                update();// this will update the information in the screen
    
    
                repaint();// this will repaint the updated information in the screen
    
                
    
                try {
                    double remTime = nextdraw - System.nanoTime();
                    remTime = remTime /1000000;
    
                    if(remTime < 0){
                        remTime = 0;
                    }
    
                    Thread.sleep((long) remTime);
    
                    nextdraw += darwInt;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            }

        
    }


    public void update(){

        if(Start == false){
            title.update();
        }

        if(Start == true){
            me.update();
            block.update();

            if
            (
                block.x >= me.x && block.x <= me.x +50 && block.y + 48 >= me.y && block.y - 48 <= me.y
                ||
                block.x <= me.x && block.x >= me.x -50 &&  block.y + 48 >= me.y && block.y - 48 <= me.y
            ){
                System.out.println("hit");
                isGame = true;
                GameOver();
            }
        }

        
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(Start == false){
            title.draw(g2);
        }

        if(Start == true){
            block.draw(g2);
            me.draw(g2);
            g2.setColor(new Color(200,200,200));
            g2.setFont(new Font("poppins", Font.BOLD, 12));
            g2.drawString("Score : " + score, 10, 20);

            if(isGame == true){
                g2.setColor(new Color(200,0,0));
                g2.setFont(new Font("poppins", Font.BOLD, 40));
                g2.drawString("Game Over Score: " + score, 50, 250);
                g2.setFont(new Font("poppins", Font.PLAIN, 20));
                g2.setColor(new Color(200,100,100));
                g2.drawString("Press <Space> to try agian", 100, 280);
                g2.drawString("Press <Esc> to goto main menu", 100, 300);
            }
        }
        
        g2.dispose();
        
    }

    public void GameOver(){

        game = null;
    }

    public void Reset(){
        Start = false;
        Exit = false;
        start();
    }

}