package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoLeftToSwitch extends AutoTemplate{
	
	 String gameData;
	
	public AutoLeftToSwitch() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
    public void autonomousInitCode(ArtemooseBot Moose){
    	Moose.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemooseBot Moose){
    	 System.out.println("Position 1 (left)");
		 System.out.println("X=" + Moose.accel.getX() + ", Y=" + Moose.accel.getY() + ", Z=" + Moose.accel.getZ() + ", gyro=" + Moose.gyro.getAngle());
		 
		 //if alliance colour is on left of switch
		 if(gameData.charAt(0)=='L') {
			 boolean completed = Moose.driveForward(168,5); //14 ft within 5 seconds
			 if (completed = true){
			 completed = completed & Moose.turn(90,5); //turn right within 5 seconds
			 }
			 if (completed = true) {
				Moose.pulleyForward;
				completed = completed & Moose.driveForward(80,5); //80 in within 5 seconds
			 }
			 
			 
			
			 //continue with return to grab more cubes 
		 }
		 
		 //otherwise drive forward over baseline
		 else {
			Moose.driveForwardWithGyro(120, 15);
		 }
    }
	
}
