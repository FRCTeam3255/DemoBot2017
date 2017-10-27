package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon leftTalon = null;
	private CANTalon rightTalon = null;
	private CANTalon turretTalon = null;
	
	public Shooter() {
		leftTalon = new CANTalon(RobotMap.SHOOTER_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.SHOOTER_RIGHT_TALON);
		turretTalon = new CANTalon(RobotMap.SHOOTER_TURRET_TALON);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

