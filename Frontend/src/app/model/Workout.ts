import { WorkoutPlan } from "./WorkoutPlan";

export class Workout {
  workoutId: number;
  workoutName: string;
  description: string;
  workoutPlan: WorkoutPlan;

  constructor() {
    this.workoutId = 0;
    this.workoutName = '';
    this.description = '';
    this.workoutPlan = new WorkoutPlan(); // Initialize with a new WorkoutPlan object
  }
}