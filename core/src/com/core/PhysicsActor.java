package com.core;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class PhysicsActor extends AnimatedActor
{
    public Vector2 velocity;

    public PhysicsActor() {
        velocity = new Vector2();
    }

    public void setVelocityXY(float vx, float vy) {  velocity.set(vx,vy);  }

    public boolean overlaps(BaseActor other, boolean resolve) {
        Polygon poly1 = this.getBoundingPolygon();
        Polygon poly2 = other.getBoundingPolygon();

        if ( !poly1.getBoundingRectangle().overlaps(poly2.getBoundingRectangle()) )
            return false;

        Intersector.MinimumTranslationVector mtv = new Intersector.MinimumTranslationVector();
        boolean polyOverlap = Intersector.overlapConvexPolygons(poly1, poly2, mtv);
        if (polyOverlap && resolve)
        {
            this.moveBy( mtv.normal.x * mtv.depth, mtv.normal.y * mtv.depth );
        }
        float significant = 0.5f;
        return (polyOverlap && (mtv.depth > significant));
    }

    public void act(float dt) {
        super.act(dt);
        moveBy( velocity.x * dt, velocity.y * dt );
    }
}