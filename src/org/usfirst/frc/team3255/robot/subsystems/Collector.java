package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CANTalon leftTalon = null;
	private CANTalon rightTalon = null;
	
	private DoubleSolenoid collectorSolenoid = null;
	
	public Collector() {
		//CANTalons
		leftTalon = new CANTalon(RobotMap.COLLECTOR_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.COLLECTOR_RIGHT_TALON);
		
		leftTalon.enableBrakeMode(false);
		rightTalon.enableBrakeMode(false);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);
		
		//Solenoids
		collectorSolenoid = new DoubleSolenoid(RobotMap.COLLECTOR_SOLENOID_UP, RobotMap.COLLECTOR_SOLENOID_DOWN);
	}
	
	public void deploy() {
		collectorSolenoid.set(Value.kForward);
	}
	
	public void retract() {
		collectorSolenoid.set(Value.kReverse);
	}
	
	public void collect() {
		leftTalon.set(1.0);
		rightTalon.set(1.0);
	}
	
	public void reverse() {
		leftTalon.set(-1.0);
		rightTalon.set(-1.0);
	}
	
	public void stop() {
		leftTalon.set(0);
		rightTalon.set(0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

