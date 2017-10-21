package org.usfirst.frc.team3255.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 0;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 1;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 3;
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	
	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	// Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_MANIPULATOR = 1;
	
	// Axes
	public static final int AXIS_DRIVER_SPEED = 1;
	public static final int AXIS_DRIVER_MOVE = 1;
	public static final int AXIS_DRIVER_ROTATE = 2;
	
}
