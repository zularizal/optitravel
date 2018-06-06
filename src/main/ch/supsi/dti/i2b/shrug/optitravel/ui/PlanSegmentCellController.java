package ch.supsi.dti.i2b.shrug.optitravel.ui;

import ch.supsi.dti.i2b.shrug.optitravel.models.*;
import ch.supsi.dti.i2b.shrug.optitravel.models.plan.PlanSegment;
import de.jensd.fx.glyphs.materialicons.MaterialIcon;
import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.io.IOException;

public class PlanSegmentCellController {

    @FXML
    private Label from;
    @FXML
    private Label eta;
    @FXML
    private Label to;
    @FXML
    private Label distance;
    @FXML
    private Label details;
    @FXML
    private MaterialIconView icon;

    private Node view;

    public PlanSegmentCellController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layouts/listCellItem.fxml"));
        loader.setController(this);
        try {
            view = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setTrip(PlanSegment planSegment) {
        distance.setVisible(false);
        details.setVisible(false);
        if(planSegment.getTrip() instanceof WaitingTrip) {
            from.setText("Wait for next connection");
            to.setText(planSegment.getStart().toString());
            eta.setText(planSegment.getStart().getTime().toString());
            icon.setIcon(MaterialIcon.TIMER);
        } else if (planSegment.getTrip() instanceof WalkingTrip || planSegment.getTrip() instanceof ConnectionTrip) {
            from.setText("Walk to next connection");
            to.setText(planSegment.getStart().toString());
            eta.setText(planSegment.getStart().getTime().toString());
            icon.setIcon(MaterialIcon.DIRECTIONS_WALK);
        } else {
            icon.setIcon(MaterialIcon.DIRECTIONS_BUS);
            from.setText(planSegment.getStart().toString());
            to.setText(planSegment.getEnd().toString());
            eta.setText(planSegment.getStart().getTime().toString());
            details.setText(planSegment.getTrip().getHeadSign());
            details.setVisible(true);
        }
//        if(planSegment instanceof PlanSegment) {
//            from.textProperty().setValue("Walk to next stop.");
//            to.setVisible(false);
//            icon.setIcon(MaterialIcon.DIRECTIONS_WALK);
//        } else {
//            icon.setIcon(MaterialIcon.DIRECTIONS_BUS);
//            from.textProperty().setValue(trip.getStopTrip().get(0).getStop().getName());
//            to.textProperty().setValue(trip.getRoute().getName());
//        }
//        eta.textProperty().setValue(trip.getStopTrip().get(0).getDeparture().toString());
    }

    public Node getView() {
        return view;
    }
}
