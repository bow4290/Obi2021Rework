/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyorSubsystem;

public class StopConveyorCommand extends CommandBase {
  private final ConveyorSubsystem conveyorSubsystem;

  public StopConveyorCommand(ConveyorSubsystem conveyorSubsystem) {
    this.conveyorSubsystem = conveyorSubsystem;
    addRequirements(conveyorSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    conveyorSubsystem.conveyorStop();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
