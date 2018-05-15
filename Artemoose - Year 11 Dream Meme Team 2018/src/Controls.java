package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Controls {

	Joystick joystickLeft; // stick
	Joystick joystickRight; // gamepad
	XboxController gamepadController; // gamepadController
	
	
	public void Controller()
	{
		joystickLeft = new Joystick(0);
		joystickRight = new Joystick(1);
		gamepadController = new XboxController(2);
	}
	
	public void updateControls(ArtemooseBot Moose)
	{
		 //System.out.println("X=" + accel.getX() + ", Y=" + accel.getY() + ", Z=" + accel.getZ() + ", gyro=" + gyro.getAngle());

		    //check left joystick slow speed control override
		    int pov = joystickLeft.getPOV();
		    //check right joystick slow speed control override
		    int povTurn = joystickRight.getPOV();

		    float slow = 0.5f;
		    float turn = 0, forward = 0;


		    // check the thumb controllers on the joysticks in case we need to override
		    // the joystick drive commands. (This is for slow mode.)
		    if (pov != -1 || povTurn != -1) {
		      // the forward/back thumb controller to check if it is at one of
		      // 0 degrees, 315 degrees, or 45 degrees for slow forward
		      // XOR
		      // 180 degrees, 135 degrees, or 225 degrees for slow backwards
		      switch (pov) {
		        case 0:
		        case 315:
		        case 45:
		          forward = -slow;
		        break;

		        case 180:
		        case 135:
		        case 225:
		          forward = slow;
		        break;
		      }

		      // the left / right thumb controller to check if it is pointing in one
		      // of the left or right regions.
		      switch (povTurn) {
		        case 90:
		        case 45:
		        case 135:
		          turn = -slow;
		        break;

		        case 270:
		        case 225:
		        case 315:
		          turn = slow;
		        break;
		      }
		      Moose.arcadeDrive(forward, turn, true);
		    } // end if -- for slow movement inputs ... otherwise feed in normal joystick drive...
		    else
		    {
		      //drive the robot as normal
		    	Moose.arcadeDrive((joystickLeft.getRawAxis(1)), -(joystickRight.getRawAxis(0)), true);
		    } // end if/else -- for slow or normal drive

		    //End code for driving
		    
		    
		  
	}
	
	
}
