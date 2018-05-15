package org.usfirst.frc.team5876.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.ArrayList;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;



public class RobotMain extends IterativeRobot {

  Controls driverStationControllers;
  ArtemooseBot robot;
  AutoManager autonomousPlans;
  AutoTemplate selectedAutonomous;


  //now we need the autonomous mode chooser....

  /*
   * Variables needed for Autonomous
   */
  String autoSelection;
  SendableChooser<String> chooser = new SendableChooser<String>();

  /**
   * set up the robot parameters, camperas, etc... once it is turned on.
   */
  @Override
  public void robotInit() {
    //the robot with all the motors and sensors available
    robot = new ArtemooseBot();

    //the joystick controlls and mappings for instructions
    driverStationControllers = new Controls();

    //the collection of autonomous plans (classes)
    autonomousPlans = new AutoManager();
    autonomousPlans.registerPlan("AutoCentreToSwitch");
    autonomousPlans.registerPlan("AutoDriveForward");
    autonomousPlans.registerPlan("AutoLeftToSwitch");
    autonomousPlans.registerPlan("AutoRightToSwitch");


    //get the list of registered auto classes and send them as options for the SmartDashboard selector
    ArrayList<String> autonomousPlansList = autonomousPlans.getRegisteredPlansList();

    for ( String planName : autonomousPlansList) {
      chooser.addObject(planName,planName);
    }

    SmartDashboard.putData("Auto choices", chooser);

  } // end robotInit()



  /**
   * make sure all timers, gyros, encoders, and accelerometers are initialised
   * and reset to what they need to be
   */
  @Override
  public void autonomousInit() {

        System.out.println("Getting Auto selection from dashboard");

    autoSelection = chooser.getSelected();

        System.out.println("Auto selected was: " + autoSelection);
        System.out.println("Loading Auto Plan...");

    selectedAutonomous = autonomousPlans.getAutoPlan(autoSelection);

        System.out.println("Running Auto Init Code...");

    selectedAutonomous.autonomousInitCode(robot);

        System.out.println("Auto Init Code Completed!");

  } // end autonomousInit()


  /**
   * this function is called multiple times during autonomous. In this function,
   * get all inputs, check timers, and then adjust robot movements as needed
   * based on checks / timers / stage in process
   */
  @Override
  public void autonomousPeriodic() {

    System.out.println("Running Auto Periodic Code");
    selectedAutonomous.autonomousPeriodicCode(robot);

  } // end autonomousPeriodic()


  /**
   * this function gets called multiple times during the tele-operated period.
   * In this function, get all inputs
   */
  @Override
  public void teleopPeriodic() {

    driverStationControllers.updateControls(robot);
  } // end teleopPeriodic()

  @Override
  public void testPeriodic() {

    LiveWindow.run();

  } // end testPeriodic()

} // end RobotMain class definitions