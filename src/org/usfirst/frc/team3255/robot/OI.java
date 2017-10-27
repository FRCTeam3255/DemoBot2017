package org.usfirst.frc.team3255.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick driverStick = new Joystick(RobotMap.JOYSTICK_DRIVER);
	public Joystick manipulatorStick = new Joystick(RobotMap.JOYSTICK_MANIPULATOR);
	
//	ManipulatorStick
	Button S1 = new JoystickButton(manipulatorStick, 1);
	Button S2 = new JoystickButton(manipulatorStick, 2);
	Button S3 = new JoystickButton(manipulatorStick, 3);
	Button S4 = new JoystickButton(manipulatorStick, 4);
	Button S5 = new JoystickButton(manipulatorStick, 5);
	Button S7 = new JoystickButton(manipulatorStick, 7);
	Button S8 = new JoystickButton(manipulatorStick, 8);
	Button S9 = new JoystickButton(manipulatorStick, 9);
	Button S10 = new JoystickButton(manipulatorStick, 10);
	Button S11 = new JoystickButton(manipulatorStick, 11);
	Button S12 = new JoystickButton(manipulatorStick, 12);
	
	
//	DriverStick
	Button D1 = new JoystickButton(driverStick, 1);
	Button D2 = new JoystickButton(driverStick, 2);
	Button D3 = new JoystickButton(driverStick, 3);
	Button D4 = new JoystickButton(driverStick, 4);
	Button D5 = new JoystickButton(driverStick, 5);
	Button D6 = new JoystickButton(driverStick, 6);
	Button D7 = new JoystickButton(driverStick, 7);
	Button D8 = new JoystickButton(driverStick, 8);
	Button D9 = new JoystickButton(driverStick, 9);
	Button D10 = new JoystickButton(driverStick, 10);
}
