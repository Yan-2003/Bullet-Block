import java.awt.*;

public class player {

    public int x, y, speed;
    mainLoop game;
    keyH keys;

    player(mainLoop game, keyH keys){
        this.game = game;
        this.keys = keys;
        setPlayer();

    }
    public void setPlayer(){
        x = 225;
        y = 400;
        speed = 4;
    }

    public void update(){

        if(x + 50 > 500){
            x -= speed;
        }else if(x < 0){
            x += speed;
        }

        if(keys.left == true){
            x -= speed;
        }

        else if(keys.right == true){
            x += speed;
        }

    }

    public void draw(Graphics2D g2){

        g2.setColor(new Color(255, 0, 0));
        g2.fillRect(x, y, 50, 50);

    }
}
