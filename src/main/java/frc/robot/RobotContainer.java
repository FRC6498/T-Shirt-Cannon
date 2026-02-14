package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.TankDrive;

public class RobotContainer {
  private final TankDrive tankDrive = new TankDrive();
  private final CommandXboxController driverController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // Left stick Y = left side, Right stick Y = right side
    tankDrive.setDefaultCommand(
      new RunCommand(
        () -> tankDrive.tankDrive(
          -driverController.getLeftY(),   // Left stick controls left wheels
          -driverController.getRightY()   // Right stick controls right wheels
        ),
        tankDrive
      )
    );
  }

  public Command getAutonomousCommand() {
    return null;
  }
}