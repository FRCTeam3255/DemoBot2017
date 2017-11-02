package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;
import org.usfirst.frc.team3255.robot.commands.DriveArcade;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
	
	private DoubleSolenoid frontSolenoid = null;
	private DoubleSolenoid backSolenoid = null;
	
	private RobotDrive robotDrive = null;
	
	public Drivetrain() {
		super();
		//talons
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
		
		//solenoids
		frontSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_FRONT_SHIFT_UP, RobotMap.DRIVETRAIN_FRONT_SHIFT_DOWN);
		backSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_BACK_SHIFT_UP, RobotMap.DRIVETRAIN_BACK_SHIFT_DOWN);
		
		//robotDrive
		robotDrive = new RobotDrive(leftFrontTalon, leftBackTalon, rightFrontTalon, rightBackTalon);
		
		robotDrive.setSafetyEnabled(false);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed){
		robotDrive.arcadeDrive(moveSpeed, rotateSpeed);
	}
	
	public void setSpeed(double speed) {
		leftFrontTalon.set(speed);
		leftBackTalon.set(speed);
		rightFrontTalon.set(-speed);
		rightBackTalon.set(-speed);
	}
	
	public void shiftUp() {
		frontSolenoid.set(Value.kForward);
		backSolenoid.set(Value.kForward);
	}
	
	public void shiftDown() {
		frontSolenoid.set(Value.kReverse);
		backSolenoid.set(Value.kReverse);
	}
	
	public double getLeftEncoderCount() {
		return leftFrontTalon.getEncPosition();
	}
	
	public double getRightEncoderCount() {
		return rightFrontTalon.getEncPosition();
	}
	
	//getEncoderCount?
	
	public void resetEncoderCount() {
		leftFrontTalon.setEncPosition(0);
		rightFrontTalon.setEncPosition(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcade());
    }
}

