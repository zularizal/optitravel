package ch.supsi.dti.i2b.shrug.optitravel.models;
import java.util.ArrayList;
import java.util.List;

public class WalkingTrip extends Trip {

	private StopTime from;
	private StopTime to;

	public WalkingTrip(StopTime f, StopTime t){
		from = f;
		to = t;
	}

	@Override
	public List<StopTrip> getStopTrip() {
		List<StopTrip> stl = new ArrayList<>();
		stl.add(new WalkingStopTrip(
				from.getStop(),
				from.getTime().toString(),
				from.getTime().toString(),
				0,
				DropOff.NotAvailable,
				PickUp.NotAvailable
		));

		stl.add(new WalkingStopTrip(
				to.getStop(),
				to.getTime().toString(),
				to.getTime().toString(),
				0,
				DropOff.NotAvailable,
				PickUp.NotAvailable
		));

		return stl;
	}

	@Override
	public Route getRoute() {
		return new WalkingRoute();
	}
}
