package gameEngine;

import java.awt.Image;

public class Sprite{
	private boolean visibility;
    private Image image;
    protected Location location;

    public Sprite() {
    	this.visibility = true;
    	this.location = new Location(0, 0);
    }
    
    public Sprite(Image image) {
    	this.setImage(image);
    	this.visibility = true;
    	this.location = new Location(0, 0);
    	//TODO load via the manager
    }

    public boolean isVisible() {
        return visibility;
    }


    protected void setVisible(boolean visibility) {
        this.visibility = visibility;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void remove() {
        this.dead = true;
    }

    public boolean isDead() {
        return this.dead;
    }

}
