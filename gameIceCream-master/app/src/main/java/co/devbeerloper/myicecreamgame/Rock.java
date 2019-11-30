package co.devbeerloper.myicecreamgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Rock {


    public static final float INIT_X =100;
    public static final float INIT_Y =100;
    public  int SPRITE_SIZE_WIDTH =120;
    public  int SPRITE_SIZE_HEIGTH=100;
    public static final float GRAVITY_FORCE=10;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 20;
    int puntos=0;
    private float maxY;
    private float maxX;

    private float speed = 0;
    private float positionX;
    private float positionY;
    private Bitmap spritemen;
    private boolean primeraVez;


    public Rock(Context context, float screenWidth, float screenHeigth){

        speed = 1;
        positionX = screenWidth-200;
        positionY = (screenWidth/2)-200;
        //Getting bitmap from resource
        Bitmap originalBitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.rock);
        spritemen  = Bitmap.createScaledBitmap(originalBitmap, SPRITE_SIZE_WIDTH, SPRITE_SIZE_HEIGTH, false);

        this.maxX = screenWidth - (spritemen.getWidth()/2);
        this.maxY = screenHeigth - spritemen.getHeight();
    }

    public Rock(Context context, float initialX, float initialY, float screenWidth, float screenHeigth){

        speed = 1;
        positionX = initialX;
        positionY = initialY;

        Bitmap originalBitmap= BitmapFactory.decodeResource(context.getResources(), R.drawable.rock);
        spritemen  = Bitmap.createScaledBitmap(originalBitmap, SPRITE_SIZE_WIDTH, SPRITE_SIZE_HEIGTH, false);

        this.maxX = screenWidth - (spritemen.getWidth()/2);
        this.maxY = screenHeigth - spritemen.getHeight();

    }

    public static float getInitX() {
        return INIT_X;
    }

    public static float getInitY() {
        return INIT_Y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getPositionX() {
        return positionX;
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public Bitmap getSpritemen() {
        return spritemen;
    }

    public void setSpritemen(Bitmap spritemen) {
        this.spritemen = spritemen;
    }


    /**
     * Control the position and behaviour of the icecream car
     */
    public int updateInfo (float a, float b,int level) {

         this.positionX-=3*level;
         this.SPRITE_SIZE_HEIGTH*=(level);
         this.SPRITE_SIZE_WIDTH*=(level);
         speed+=5;
        if(this.positionX<0){
            this.positionX= this.maxX;
        }
        if(a+100>this.positionX && a-100<this.positionX ){
            if(b+100>this.positionY && b-100<this.positionY ){
                this.positionX= this.maxX;
                return -10000;
            }
        }
        return 0;
    }
}

