package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.Robot;
import org.usfirst.frc.team3255.robot.commands.DriveResetEncoders;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Telemetry() {
		SmartDashboard.putData("Reset Encoders", new DriveResetEncoders());
	}
	
	public void update() {
		SmartDashboard.putNumber("Hoop Distance", Robot.vision.getHoopDistance());
		SmartDashboard.putNumber("Hoop Angle", Robot.vision.getHoopAngle());
		SmartDashboard.putNumber("Hoop Offset", Robot.vision.getHoopOffset());
		
		SmartDashboard.putNumber("Ball Distance", Robot.vision.getBallDistance());
		SmartDashboard.putNumber("Ball Offset", Robot.vision.getBallOffset());
		
		SmartDashboard.putNumber("Right Encoder Count", Robot.drivetrain.getRightEncoderCount());
		SmartDashboard.putNumber("Left Encoder Count", Robot.drivetrain.getLeftEncoderCount());
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

