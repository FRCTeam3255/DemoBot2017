package org.usfirst.frc.team3255.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//Talons
	public static final int COLLECTOR_LEFT_TALON = 1;
	public static final int COLLECTOR_RIGHT_TALON = 2;
	
	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 3;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 4;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 5;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 6;
	
	public static final int SHOOTER_LEFT_TALON = 7;
	public static final int SHOOTER_RIGHT_TALON = 8;
	public static final int SHOOTER_TURRET_TALON = 9;

	//Solenoids
	public static final int COLLECTOR_SOLENOID_UP = 0;
	public static final int COLLECTOR_SOLENOID_DOWN = 1;
	
	public static final int DRIVETRAIN_FRONT_SHIFT_UP = 2;
	public static final int DRIVETRAIN_FRONT_SHIFT_DOWN = 3;
	public static final int DRIVETRAIN_BACK_SHIFT_UP = 4;
	public static final int DRIVETRAIN_BACK_SHIFT_DOWN = 5;
	
	//Encoders
	public static final int DRIVETRAIN_LEFT_ENCODER_A = 0;
	public static final int DRIVETRAIN_LEFT_ENCODER_B = 1;
	public static final int DRIVETRAIN_RIGHT_ENCODER_A = 2;
	public static final int DRIVETRAIN_RIGHT_ENCODER_B = 3;

	// Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_MANIPULATOR = 1;
	
	// Axes
	public static final int AXIS_DRIVER_SPEED = 1;
	public static final int AXIS_DRIVER_MOVE = 2;
	public static final int AXIS_DRIVER_ROTATE = 3;
	
}
