import javax.swing.*;


public class cal{

    public static void main(String[] args){
        
        JFrame frame = new JFrame();
        mainLoop game = new mainLoop();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bullet Block");
        frame.setVisible(true);
        frame.add(game);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        game.start();
        
    }
}