package org.usfirst.frc.team3255.robot.subsystems;

import org.usfirst.frc.team3255.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Servo;
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
	
	private Servo servo = null;
	
	private AnalogInput absoluteEncoder = null;
	
	public Shooter() {
		leftTalon = new CANTalon(RobotMap.SHOOTER_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.SHOOTER_RIGHT_TALON);
		turretTalon = new CANTalon(RobotMap.SHOOTER_TURRET_TALON);
		
		servo = new Servo(RobotMap.SHOOTER_SERVO);
		
		absoluteEncoder = new AnalogInput(RobotMap.SHOOTER_ENCODER);
	}

	public void setShootSpeed(double speed) {
		leftTalon.set(speed);
		rightTalon.set(-speed);
	}
	
	public void setTurretSpeed(double speed) {
		turretTalon.set(speed);
	}
	
	public void setAngle(double angle) {
		servo.set(angle);
	}
	
	public double getEncoderPosition() {
		return absoluteEncoder.getValue();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

