import java.awt.*;


public class titleScreen{

    mainLoop game;
    keyH c;
    boolean Lselect = true;
    boolean Rselect = false;

    titleScreen(mainLoop game, keyH c){
        this.game = game;
        this.c = c;
    }

    public void update(){

        if(c.Lbnt == true){
            Lselect = true;
            Rselect = false;
            if(c.GameGo == true){
                game.Start = true;
            }
        }
        if(c.Rbnt == true){
            Rselect = true;
            Lselect = false;
            if(c.GameGo == true){
                System.exit(0);
            }
        }

    }

    public void draw(Graphics2D g2){
        g2.setColor(new Color(255,0,0));
        g2.setFont(new Font("poppins", Font.BOLD, 40));
        g2.drawString("Bullet Block", 150, 150);
        
        if(Lselect == true){
            g2.setColor(new Color(255,10,10));
            g2.setFont(new Font("poppins", Font.BOLD, 20));
            g2.drawString("Play", 170, 300);
            g2.setColor(new Color(255,255,255));
            g2.drawString("Exit", 300, 300);
        }
        if(Rselect == true){
            g2.setColor(new Color(255,255,255));
            g2.setFont(new Font("poppins", Font.BOLD, 20));
            g2.drawString("Play", 170, 300);
            g2.setColor(new Color(255,10,10));
            g2.drawString("Exit", 300, 300);
      
        }

        g2.setColor(new Color(255,255,255));
        g2.setFont(new Font("poppins", Font.BOLD, 12));
        g2.drawString("This game is made by : Julliane", 10, 470);

        g2.setColor(new Color(200,200,200));
        g2.setFont(new Font("poppins", Font.BOLD, 10));
        g2.drawString("A and D for controlling, Press Enter to select.", 10, 490);

       

    }




    
}
