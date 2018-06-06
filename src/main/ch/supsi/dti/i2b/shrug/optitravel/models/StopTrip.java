package ch.supsi.dti.i2b.shrug.optitravel.models;

public abstract class StopTrip {
	public abstract Time getDeparture();

	public abstract Time getArrival();

	public abstract DropOff getDropOff();

	public abstract PickUp getPickUp();

	public abstract Stop getStop();

	// TODO: @Pura, implement for TL!
	public abstract int getStopSequence() /*throws ExecutionControl.NotImplementedException*/;

	@Override
	public String toString() {
		return String.format("ST %s, A %s D %s",
				getStop(),
				getArrival(),
				getDeparture()
		);
	}
}