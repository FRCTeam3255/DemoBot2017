package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon leftFrontTalon = null;
	private CANTalon rightFrontTalon = null;
	private CANTalon leftBackTalon = null;
	private CANTalon rightBackTalon = null;
	
	private DoubleSolenoid frontSol = null;
	private DoubleSolenoid backSol = null;
	
	private Encoder leftEncoder = null;
	private Encoder rightEncoder = null;
	
	private RobotDrive robotdrive = null;
	
	public Drivetrain() {
		super();
		leftFrontTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftBackTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightBackTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		leftFrontTalon.enableBrakeMode(true);
		leftBackTalon.enableBrakeMode(true);
		rightFrontTalon.enableBrakeMode(true);
		rightBackTalon.enableBrakeMode(true);
		
		leftFrontTalon.setSafetyEnabled(false);
		leftBackTalon.setSafetyEnabled(false);
		rightFrontTalon.setSafetyEnabled(false);
		rightBackTalon.setSafetyEnabled(false);
	}
	
	public void setSpeed(double speed) {
		leftFrontTalon.set(speed);
		leftBackTalon.set(speed);
		rightFrontTalon.set(-speed);
		rightBackTalon.set(-speed);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

