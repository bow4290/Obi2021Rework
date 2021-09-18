/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  private Command autonomousCommand;
  public static CameraServer server;
  private RobotContainer robotContainer;

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
    

    //UsbCamera cameraShooter = CameraServer.getInstance().startAutomaticCapture();
    UsbCamera cameraIntake = CameraServer.getInstance().startAutomaticCapture();
    //cameraShooter.setVideoMode(VideoMode.PixelFormat.kMJPEG, 160, 120, 30);
    cameraIntake.setVideoMode(VideoMode.PixelFormat.kMJPEG, 160, 120, 30);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("PDP Voltage: ", robotContainer.PDP.getVoltage());
    SmartDashboard.putNumber("PDP Total Current: ", robotContainer.PDP.getTotalCurrent());
    SmartDashboard.putNumber("PDP Ch 0 Current: ", robotContainer.PDP.getCurrent(0));
    SmartDashboard.putNumber("PDP Ch 1 Current: ", robotContainer.PDP.getCurrent(1));
    SmartDashboard.putNumber("PDP Ch 2 Current: ", robotContainer.PDP.getCurrent(2));
    SmartDashboard.putNumber("PDP Ch 3 Current: ", robotContainer.PDP.getCurrent(3));
    SmartDashboard.putNumber("PDP Ch 4 Current: ", robotContainer.PDP.getCurrent(4));
    SmartDashboard.putNumber("PDP Ch 5 Current: ", robotContainer.PDP.getCurrent(5));
    SmartDashboard.putNumber("PDP Ch 6 Current: ", robotContainer.PDP.getCurrent(6));
    SmartDashboard.putNumber("PDP Ch 7 Current: ", robotContainer.PDP.getCurrent(7));
    SmartDashboard.putNumber("PDP Ch 8 Current: ", robotContainer.PDP.getCurrent(8));
    SmartDashboard.putNumber("PDP Ch 9 Current: ", robotContainer.PDP.getCurrent(9));
    SmartDashboard.putNumber("PDP Ch 10 Current: ", robotContainer.PDP.getCurrent(10));
    SmartDashboard.putNumber("PDP Ch 11 Current: ", robotContainer.PDP.getCurrent(11));
    SmartDashboard.putNumber("PDP Ch 12 Current: ", robotContainer.PDP.getCurrent(12));
    SmartDashboard.putNumber("PDP Ch 13 Current: ", robotContainer.PDP.getCurrent(13));
    SmartDashboard.putNumber("PDP Ch 14 Current: ", robotContainer.PDP.getCurrent(14));
    SmartDashboard.putNumber("PDP Ch 15 Current: ", robotContainer.PDP.getCurrent(15));
    
    switch(robotContainer.getDPad()){
      case 0:
        robotContainer.setShooterPosition(0);
        break;
      case 90:
        robotContainer.setShooterPosition(1);
        break;
      case 180:
        robotContainer.setShooterPosition(2);
        break;
      case 270:
        robotContainer.setShooterPosition(3);
        break;
      default:
        break;
    }
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    robotContainer.limelight.setPipeline(3);
    autonomousCommand = robotContainer.getAutonomousCommand();

    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    robotContainer.limelight.setPipeline(0);
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Robot-Tower Distance", robotContainer.limelight.getBumperDistance());
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
