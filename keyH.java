import java.awt.event.*;


public class keyH implements KeyListener{

    mainLoop game;
    public boolean left, right, gameTry, Lbnt = true, Rbnt = false, GameGo;

    keyH(mainLoop game){
        this.game = game;

    }


    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }


    public void keyPressed(KeyEvent e) {
       
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A){
            left = true;
            Lbnt = true;
            Rbnt = false;
            System.out.println("key A press");
        }
        if(key == KeyEvent.VK_D){
            right = true;
            Rbnt = true;
            Lbnt = false;
            System.out.println("key D press");
        }

        if(game.isGame == true){

            if(key == KeyEvent.VK_SPACE){
                game.start();
            }
            if(key == KeyEvent.VK_ESCAPE){
                GameGo = false;
               game.Reset();
               
            }
           
        }
        if(key == KeyEvent.VK_ENTER){
            GameGo = true;
            System.out.println("Enter");
        }

        
    }


    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A){
            left = false;
            System.out.println("key A realesed");
        }
        if(key == KeyEvent.VK_D){
            right = false;
            System.out.println("key D realesed");
        }
       
    }
    
}
