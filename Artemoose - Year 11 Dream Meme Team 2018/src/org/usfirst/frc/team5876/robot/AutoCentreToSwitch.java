package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.DriverStation;

public class AutoCentreToSwitch extends AutoTemplate{
	
	 String gameData;
	
	public AutoCentreToSwitch() {
		
		 gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
    public void autonomousInitCode(ArtemooseBot Moose){
    	Moose.prepareForAuto();
    }
    public void autonomousPeriodicCode(ArtemooseBot Moose){
    	 System.out.println("Position 2 (centre)");
		 System.out.println("X=" + Moose.accel.getX() + ", Y=" + Moose.accel.getY() + ", Z=" + Moose.accel.getZ() + ", gyro=" + Moose.gyro.getAngle());

	//if alliance colour is on right of switch
		 if(gameData.charAt(0)=='R') {
			 
			 boolean completed = Moose.driveForward(48, 5); //4 ft within 5 seconds
			 if (completed = true){
			 completed = completed & Moose.turn(45,5); //turn right within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & Moose.driveForward(113,5); //113 in within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & Moose.turn(-45, 5); //turn left within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & Moose.driveForward(12, 5); //1 ft witin 5 seconds
			 }
			 
		 }
		 
	//if alliance colour is on left of swtich
		 else {
			 boolean completed = Moose.driveForward(42,5); //42 in within 5 seconds
			 if (completed = true){
			 completed = completed & Moose.turn(-45,5); //turn left within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & Moose.driveForward(130,5); //130 in within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & Moose.turn(45, 5); //turn right within 5 seconds
			 }
			 
			 if (completed = true) {
				completed = completed & Moose.driveForward(12, 5); //1 ft witin 5 seconds
			 }
			 
		 }
    }
	
}
