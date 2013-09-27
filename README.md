Circle-to-Circle Intersections in Java
======================================

Copyright 2012, Rodrigo Balerdi.
Licensed under the [GNU General Public License (GPL) Version 3](http://www.gnu.org/licenses/gpl-3.0-standalone.html) or later.

A year ago I needed free code to compute coplanar circle-to-circle intersections in Java and could not find any. So I wrote this and forgot to release it.

References
----------

http://paulbourke.net/geometry/2circle/

http://mathworld.wolfram.com/Circle-CircleIntersection.html

Usage
-----

Construct a `CircleCircleIntersection` from two `Circle` instances c1 and c2 to solve an intersection. Note that degenerate circles (zero radius) cannot be constructed.

The type of an intersection will be one of:

    COINCIDENT
    CONCENTRIC_CONTAINED
    ECCENTRIC_CONTAINED
    INTERNALLY_TANGENT
    OVERLAPPING
    EXTERNALLY_TANGENT
    SEPARATE

You can query the `Type` object for some generic properties of the type:

    int getIntersectionPointCount();                    // -1 if count is infinite (coincident circles)
    boolean isConcentric();
    boolean isContained();
    boolean isTangent();
    boolean isDisjoint();

The `CircleCircleIntersection` object itself will contain the immutable results of the intersection.

Results valid for all intersections:

    Type type;                                          // type of intersection
    double distanceC1cC2c;                              // distance between circle centers

Results valid for eccentric circles:

    Vector2 radicalPoint;                               // intersection between line connecting circle centers and radical line
    double distanceC1cRadicalLine;                      // signed distances from circle centers to radical line
    double distanceC2cRadicalLine;                      // (the direction to the other center is positive)
    Vector2 versorC1cC2c;                               // direction versor from c1 center to c2 center
    Vector2 versorRadicalLine;                          // direction versor of radical line
                                                        // (points to the left if looking from c1 center to c2 center)

Results valid for tangent circles:

    Vector2 intersectionPoint;                          // intersection point

Results valid for overlapping circles:

    Vector2 intersectionPoint1;                         // intersection points
    Vector2 intersectionPoint2;                         // (point 1 is on the left if looking from c1 center to c2 center)
    double distanceRadicalPointIntersectionPoints;      // distance between radical point and either intersection point

Method valid for noncoincident circles:

    Vector2[] getIntersectionPoints();                  // array of 0, 1 or 2 intersection points (throws if coincident circles)

