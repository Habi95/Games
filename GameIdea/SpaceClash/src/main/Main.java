package main;

import org.newdawn.slick.*;

public class Main extends BasicGame {

    public static Input in;
    public static int x;
    public static int y;
    public static Image player_img;
    public static Image lvl2;
    public static Image enemie;


    @Override
    public void init(GameContainer gc) throws SlickException {
        in = gc.getInput();
        x = 100;
        y = 330;
        //player_img = new Image("main/test-img.png");
        player_img = new Image("src/ship.png");
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        if (in.isKeyDown(in.KEY_W) ) {
            y-=5;
        }
        if (in.isKeyDown(in.KEY_S) ) {
            y+=5;
        }
        if (in.isKeyDown(in.KEY_A) ) {
            x-=5;
        }
        if (in.isKeyDown(in.KEY_D) ) {
            x+=5;
        }

        if (in.isMouseButtonDown(in.MOUSE_LEFT_BUTTON)) {

            x = in.getMouseX();
            y = in.getMouseY();
        }

        if (x >= 1200) {
            x = 0;
        } else if (x <= 0) {
            x = 1200;
        }
        if (y >= 800) {
            y = 0;
        } else if (y <= 0) {
            y = 800;
        }

    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        g.setColor(Color.yellow);
        g.drawImage(player_img,x,y);
        g.drawString("x cordinate " + x,100,100);
        g.drawString("y cordnitae " + y,100,120);
    }


    public Main(String title) {
        super(title);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Main("Clash"));
            app.setDisplayMode(1200, 800, false);
            app.setTargetFrameRate(60);
            app.setVSync(true);
            app.setShowFPS(false);
            app.start();

        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
