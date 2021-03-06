package ch.supsi.dti.i2b.shrug.optitravel.params;

import ch.supsi.dti.i2b.shrug.optitravel.planner.PlanPreference;

public class DenvitPlanPreference implements PlanPreference {
	private double PREF_WEIGHT;
	private double distance;
	private double average_moving_speed_kmh = 35;
	private double average_moving_speed =  average_moving_speed_kmh * 3.6; // m/s

	public DenvitPlanPreference(double distance){
		this.distance = distance;
		PREF_WEIGHT = 0.5 * distance;
	}

	@Override
	public double walkable_radius_meters() {
		return 500;
	}

	@Override
	public double walk_speed_mps() {
		return 1.2;
	}

	@Override
	public double source_radius() {
		return PlannerParams.SOURCE_RADIUS;
	}

	@Override
	public double destination_radius() {
		return 300;
	}

	@Override
	public double max_waiting_time() {
		return 25.0;
	}

	@Override
	public double w_walk() {
		return 4 * PREF_WEIGHT;
	}

	@Override
	public double w_waiting() {
		return 2 * PREF_WEIGHT;
	}

	@Override
	public double w_fast_change() {
		return 6 * PREF_WEIGHT;
	}

	@Override
	public double w_change() {
		return 5 * PREF_WEIGHT;
	}

	@Override
	public double w_moving() {
		return 0.95 * PREF_WEIGHT;
	}

	@Override
	public double max_total_waiting_time() {
		return max_waiting_time() + 10 * max_total_changes();
	}

	@Override
	public int max_total_changes() {
		return 6;
	}

	@Override
	public double max_total_walkable_distance() {
		return 1600;
	}
}
