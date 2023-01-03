import java.awt.*;
import java.util.Random;
public class enemy {

    mainLoop game;
    public int x, y , speed;
    Random enemy_p_x = new Random();
    Random Rspeed = new Random();
    int[] enemy_num;
    int r = enemy_p_x.nextInt(255)+1;
    int g = enemy_p_x.nextInt(255)+1;
    int b = enemy_p_x.nextInt(255)+1;
    int Espeed1 = Rspeed.nextInt(7)+3;
    int Espeed2 = Rspeed.nextInt(3)+1;
    public enemy(mainLoop game){
        this.game = game;
        enemy_num = new int[3];
        enemy_position();

    }

    public void enemy_position(){
        x = game.me.x;
        y = 0;
        speed = Espeed2;
    }
    public void update(){
        y += speed;
        if(y > game.height){
            x =  game.me.x;
            r = enemy_p_x.nextInt(255)+1;
            g = enemy_p_x.nextInt(255)+1;
            b = enemy_p_x.nextInt(255)+1;
            y = 0;
            game.score+=1;
            if(speed == 15){
                speed = 3;
            }
            speed++;
        }
    }

    public void draw(Graphics2D g2){

      

        g2.setColor(new Color(r,g,b));
        g2.fillRect(x, y,50 , 50);
    }
    
}
