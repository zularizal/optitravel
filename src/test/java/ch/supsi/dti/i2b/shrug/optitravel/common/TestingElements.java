package ch.supsi.dti.i2b.shrug.optitravel.common;

import ch.supsi.dti.i2b.shrug.optitravel.geography.BoundingBox;
import ch.supsi.dti.i2b.shrug.optitravel.geography.Coordinate;

public class TestingElements {
	public static BoundingBox LUGANO_BBOX = new BoundingBox(
			new Coordinate(45.951414, 8.865225),
			new Coordinate(46.059679, 9.036543)
	);

	public static Coordinate LUGANO_COORDINATE =
			new Coordinate(46, 8.95);

	public static Coordinate ZURICH_COORDINATE =
			new Coordinate(47.3673, 8.55);

	public static Coordinate LUGANO_CENTRO_COORDINATE =
			new Coordinate(46.0065117,8.9523121);

	public static Coordinate PREGASSONA_COORDINATE =
			new Coordinate(46.020805, 8.975589);

	public static Coordinate LAMONE_FFS_COORDINATE =
			new Coordinate(46.0396684,8.932392);

	public static Coordinate SUPSI_COORDINATE =
			new Coordinate(46.023346, 8.917129);
}
