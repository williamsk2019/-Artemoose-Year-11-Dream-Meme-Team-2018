package org.usfirst.frc.team5876.robot;

import java.util.ArrayList;
import org.usfirst.frc.team5876.robot.*;


public class AutoManager {

    private AutoTemplate selectedAutoPlan;
    private ArrayList<String> registeredPlans;

    public AutoManager() {
        registeredPlans = new ArrayList<String>();
        selectedAutoPlan = null;
    }

    public void registerPlan(String planNameToCheck)
    {
        try{
            Object object = null;
            Class classDefinition = Class.forName(planNameToCheck);
            object = classDefinition.newInstance();
            AutoTemplate plan = (AutoTemplate) object; // temporary object to make sre the casting works

            //if we get to this point, then it should be ok to create the plan as no errors were thrown
            registeredPlans.add(planNameToCheck);

          }catch(Exception e){
              System.out.println("There was an error in registering Auto plan: " + planNameToCheck);
              return; // coulnd't add the plan successfully, so don't bother adding to the array.
          }
    }

    public AutoTemplate getAutoPlan(String planName)
    {
      try{
        Object object = null;
        Class classDefinition = Class.forName(planName);
        object = classDefinition.newInstance();
        selectedAutoPlan = (AutoTemplate) object;
        return selectedAutoPlan;
      }catch(Exception e){
          return null;
      }
      //should never reach here.
    }

    public ArrayList<String> getRegisteredPlansList()
    {
        return registeredPlans;
    }
}