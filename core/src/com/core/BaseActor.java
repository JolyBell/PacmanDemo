package com.core;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Polygon;

public class BaseActor extends Actor {
    public TextureRegion region;
    public Polygon boundingPolygon;

    public BaseActor() {
        super();
        region = new TextureRegion();
        boundingPolygon = null;
    }

    public void setTexture(Texture t) {
        int w = t.getWidth();
        int h = t.getHeight();
        setWidth( w );
        setHeight( h );
        region.setRegion( t );
    }

    public void setDefaultRectangleBoundary() {
        float w = getWidth();
        float h = getHeight();
        float[] vertices = {0,0, w,0, w,h, 0,h};
        boundingPolygon = new Polygon(vertices);
        boundingPolygon.setOrigin( getOriginX(), getOriginY() );
    }

    public void setCustomRectangleBoundary(int lowLeftX, int lowLeftY, int highLeftX, int highLeftY,
                                           int highRightX, int highRightY, int lowRightX, int lowRightY)
    {
        float[] vertices = {lowLeftX,lowLeftY,lowRightX,lowRightY,highRightX,highRightY,highLeftX,highLeftY};
        boundingPolygon = new Polygon(vertices);
        boundingPolygon.setOrigin( getOriginX(), getOriginY() );
    }

    public Polygon getBoundingPolygon() {
        boundingPolygon.setPosition( getX(), getY() );
        boundingPolygon.setRotation( getRotation() );
        return boundingPolygon;
    }

    public void act(float dt) {
        super.act( dt );
    }

    public void draw(Batch batch, float parentAlpha) {
        Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a);
        if ( isVisible() )
            batch.draw( region, getX(), getY(), getOriginX(), getOriginY(),
                    getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation() );
    }

    public void copy(BaseActor original) {
        this.region = new TextureRegion( original.region );
        if (original.boundingPolygon != null)
            this.boundingPolygon = new Polygon( original.boundingPolygon.getVertices() );
        this.setPosition( original.getX(), original.getY() );
        this.setOriginX( original.getOriginX() );
        this.setOriginY( original.getOriginY() );
        this.setWidth( original.getWidth() );
        this.setHeight( original.getHeight() );
        this.setColor( original.getColor() );
        this.setVisible( original.isVisible() );
    }

    public BaseActor clone() {
        BaseActor newbie = new BaseActor();
        newbie.copy( this );
        return newbie;
    }


}
