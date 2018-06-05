package ch.supsi.dti.i2b.shrug.optitravel.mock;

import ch.supsi.dti.i2b.shrug.optitravel.api.GTFS_rs.GTFSrsError;
import ch.supsi.dti.i2b.shrug.optitravel.api.GTFS_rs.GTFSrsWrapper;
import ch.supsi.dti.i2b.shrug.optitravel.api.GTFS_rs.models.PaginatedList;
import ch.supsi.dti.i2b.shrug.optitravel.api.GTFS_rs.models.Trip;
import ch.supsi.dti.i2b.shrug.optitravel.api.GTFS_rs.search.TripSearch;
import ch.supsi.dti.i2b.shrug.optitravel.geography.BoundingBox;
import ch.supsi.dti.i2b.shrug.optitravel.geography.Coordinate;
import ch.supsi.dti.i2b.shrug.optitravel.planner.DataGathering;
import org.mockito.Mockito;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MockedDataGathering extends DataGathering {
	private GTFSrsWrapper mockedGTFSWrapper;
	public MockedDataGathering() {
		super();
		mockedGTFSWrapper = Mockito.mock(GTFSrsWrapper.class);
		BoundingBox bbox = new BoundingBox(
				new Coordinate(46.012963, 8.964333),
				new Coordinate(46.028526,8.976853)
		);

		TripSearch ts = Mockito.mock(TripSearch.class);
		try {
			String fpath = "json/gtfs/bbox-pre-bo.json";
			File file = new File(getClass().getClassLoader().getResource(fpath).getFile());
			try {
				BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file), 1024 * 1024 * 2);
				byte[] json = fis.readAllBytes();
				PaginatedList<Trip> cached_res_1 = GTFSrsWrapper.parsePaginatedTrips(json);
				when(mockedGTFSWrapper.getTripsByBBox(any(), any())).thenReturn(cached_res_1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (GTFSrsError gtfSrsError) {
			gtfSrsError.printStackTrace();
		}
	}

	@Override
	public GTFSrsWrapper getwGTFS() {
		return mockedGTFSWrapper;
	}
}
