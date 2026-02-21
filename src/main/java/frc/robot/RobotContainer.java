package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import frc.robot.subsystems.TankDrive;
import frc.robot.subsystems.Shooter;

public class RobotContainer {

  private final TankDrive tankDrive = new TankDrive();
  private final Shooter shooter = new Shooter();
  private final CommandXboxController driverController = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    tankDrive.setDefaultCommand(
      new RunCommand(
        () -> tankDrive.tankDrive(
          -driverController.getLeftY(),
          -driverController.getRightY()
        ),
        tankDrive
      )
    );

    driverController.a().onTrue(shooter.fire(12).withTimeout(1));
    driverController.rightBumper().whileTrue(shooter.up(0.2));
    driverController.leftBumper().whileTrue(shooter.up(-0.2));
  }

  

  public Command getAutonomousCommand() {
    return null;
  }
}