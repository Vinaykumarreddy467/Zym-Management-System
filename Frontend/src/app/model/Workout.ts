import { WorkoutPlan } from "./WorkoutPlan";

export class Workout {
  workoutId: number;
  workoutName: string;
  description: string;
  workoutPlan: WorkoutPlan;

  constructor() {
    this.workoutId = null as any;
    this.workoutName = '';
    this.description = '';
    this.workoutPlan = undefined as any;
  }
}