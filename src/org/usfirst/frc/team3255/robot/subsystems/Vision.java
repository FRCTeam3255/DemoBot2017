package org.usfirst.frc.team3255.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class Vision extends Subsystem {

   NetworkTable table;
    public Vision() {
    	table = NetworkTable.getTable("NURDVision");
    }
    
    public double getHoopDistance() {
    	return table.getNumber("Hoop Distance", -99.9);
    }
    public double getHoopOffset() {
    	return table.getNumber("Hoop Offset", -99.9);
    }
    public double getHoopAngle() {
    	return table.getNumber("Hoop Angle", -99.9);
    }
    
    public double getBallDistance() {
    	return table.getNumber("Ball Distance", -99.9);
    }
    public double getBallOffset() {
    	return table.getNumber("Ball Offset", -99.9);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

