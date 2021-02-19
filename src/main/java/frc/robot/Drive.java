// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/** Add your docs here. */
public class Drive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Spark leftMotorSpark = new Spark(Map.leftMotorPort1);
  public Spark rightMotorSpark = new Spark(Map.rightMotorPort1);
  public Spark leftMotorSpark2 = new Spark(Map.leftMotorPort2);
  public Spark rightMotorSpark2 = new Spark(Map.rightMotorPort2);
  
SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftMotorSpark, leftMotorSpark2);
SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(rightMotorSpark, rightMotorSpark2);

  public DifferentialDrive drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  public Drive() {}

  public void teleopDrive(double move, double turn) {
    if (move > .5) move = .5;
    drive.arcadeDrive(move, turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
